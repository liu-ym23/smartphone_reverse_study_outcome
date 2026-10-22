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
import java.io.IOException;
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
    public static class Node {
        private final SparseArray<Node> mChildren;
        private EmojiMetadata mData;

        private Node() {
            this(1);
        }

        public Node get(int r5) {
            SparseArray<Node> r10 = this.mChildren;
            if (r10 != null) goto L6;
            return null;
        L6:
            return r10.get(r5);
        }

        public final EmojiMetadata getData() {
            return this.mData;
        }

        public void put(@NonNull EmojiMetadata r5, int r10, int r11) {
            Node r12 = get(r5.getCodepointAt(r10));
            if (r12 != null) goto L5;
            r12 = new Node();
            this.mChildren.put(r5.getCodepointAt(r10), r12);
        L5:
            if (r11 <= r10) goto L7;
            r12.put(r5, r10 + 1, r11);
            return;
        L7:
            r12.mData = r5;
        }

        public Node(int r5) {
            this.mChildren = new SparseArray(r5);
        }
    }

    private MetadataRepo(@NonNull Typeface r5, @NonNull MetadataList r10) {
        this.mTypeface = r5;
        this.mMetadataList = r10;
        this.mRootNode = new Node(1024);
        this.mEmojiCharArray = new char[r10.listLength() * 2];
        constructIndex(r10);
    }

    private void constructIndex(MetadataList r10) {
        int r11 = r10.listLength();
        int r5 = 0;
    L3:
        if (r5 >= r11) goto L5;
        EmojiMetadata r12 = new EmojiMetadata(this, r5);
        Character.toChars(r12.getId(), this.mEmojiCharArray, r5 * 2);
        put(r12);
        r5 = r5 + 1;
        goto L3
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static MetadataRepo create(@NonNull Typeface r5) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r10 = new MetadataRepo(r5, new MetadataList());     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r10;
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
    public int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Node getRootNode() {
        return this.mRootNode;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface getTypeface() {
        return this.mTypeface;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public void put(@NonNull EmojiMetadata r5) {
        Preconditions.checkNotNull(r5, "emoji metadata cannot be null");
        if (r5.getCodepointsLength() <= 0) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkArgument(r10, "invalid metadata codepoint length");
        this.mRootNode.put(r5, 0, r5.getCodepointsLength() - 1);
        return;
    L5:
        r10 = false;
        goto L6
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface r5, @NonNull InputStream r10) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r11 = new MetadataRepo(r5, MetadataListReader.read(r10));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r11;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @NonNull
    public static MetadataRepo create(@NonNull Typeface r5, @NonNull ByteBuffer r10) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r11 = new MetadataRepo(r5, MetadataListReader.read(r10));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r11;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    @NonNull
    public static MetadataRepo create(@NonNull AssetManager r5, @NonNull String r10) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r11 = new MetadataRepo(Typeface.createFromAsset(r5, r10), MetadataListReader.read(r5, r10));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r11;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }
}
