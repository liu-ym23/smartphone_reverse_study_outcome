package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RequiresApi(19)
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";

    @NonNull
    private final char[] mEmojiCharArray;

    @NonNull
    private final MetadataList mMetadataList;

    @NonNull
    private final Node mRootNode;

    @NonNull
    private final Typeface mTypeface;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class Node {
        private final SparseArray<Node> mChildren;
        private EmojiMetadata mData;

        private Node() {
            this(1);
        }

        Node(int r10) {
            this.mChildren = new SparseArray(r10);
        }

        Node get(int r10) {
            SparseArray<Node> r11 = this.mChildren;
            if (r11 != null) goto L6;
            return null;
        L6:
            return r11.get(r10);
        }

        final EmojiMetadata getData() {
            return this.mData;
        }

        void put(@NonNull EmojiMetadata r10, int r11, int r12) {
            Node r13 = get(r10.getCodepointAt(r11));
            if (r13 != null) goto L5;
            r13 = new Node();
            this.mChildren.put(r10.getCodepointAt(r11), r13);
        L5:
            if (r12 <= r11) goto L7;
            r13.put(r10, r11 + 1, r12);
            return;
        L7:
            r13.mData = r10;
        }
    }

    private MetadataRepo(@NonNull Typeface r10, @NonNull MetadataList r11) {
        this.mTypeface = r10;
        this.mMetadataList = r11;
        this.mRootNode = new Node(1024);
        this.mEmojiCharArray = new char[r11.listLength() * 2];
        constructIndex(r11);
    }

    private void constructIndex(MetadataList r10) {
        int r11 = r10.listLength();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        EmojiMetadata r13 = new EmojiMetadata(this, r12);
        Character.toChars(r13.getId(), this.mEmojiCharArray, r12 * 2);
        put(r13);
        r12 = r12 + 1;
        goto L3
    }

    @NonNull
    public static MetadataRepo create(@NonNull AssetManager r10, @NonNull String r11) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r12 = new MetadataRepo(Typeface.createFromAsset(r10, r11), MetadataListReader.read(r10, r11));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r12;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static MetadataRepo create(@NonNull Typeface r10) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r11 = new MetadataRepo(r10, new MetadataList());     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r11;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface r10, @NonNull InputStream r11) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r12 = new MetadataRepo(r10, MetadataListReader.read(r11));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r12;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface r10, @NonNull ByteBuffer r11) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r12 = new MetadataRepo(r10, MetadataListReader.read(r11));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r12;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Node getRootNode() {
        return this.mRootNode;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    Typeface getTypeface() {
        return this.mTypeface;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    void put(@NonNull EmojiMetadata r10) {
        Preconditions.checkNotNull(r10, "emoji metadata cannot be null");
        if (r10.getCodepointsLength() <= 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "invalid metadata codepoint length");
        this.mRootNode.put(r10, 0, r10.getCodepointsLength() - 1);
        return;
    L5:
        r11 = false;
        goto L6
    }
}
