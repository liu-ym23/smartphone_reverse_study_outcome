package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MetadataRepo {
    private static final int DEFAULT_ROOT_SIZE = 1024;
    private static final String S_TRACE_CREATE_REPO = "EmojiCompat.MetadataRepo.create";
    private final char[] mEmojiCharArray;
    private final MetadataList mMetadataList;
    private final Node mRootNode;
    private final Typeface mTypeface;

    public int getMetadataVersion() {
        return this.mMetadataList.version();
    }

    public char[] getEmojiCharArray() {
        return this.mEmojiCharArray;
    }

    public MetadataList getMetadataList() {
        return this.mMetadataList;
    }

    public Node getRootNode() {
        return this.mRootNode;
    }

    public Typeface getTypeface() {
        return this.mTypeface;
    }

    private void constructIndex(MetadataList r6) {
        int r7 = r6.listLength();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        TypefaceEmojiRasterizer r1 = new TypefaceEmojiRasterizer(this, r0);
        Character.toChars(r1.getId(), this.mEmojiCharArray, r0 * 2);
        put(r1);
        r0 = r0 + 1;
        goto L3
    }

    public static MetadataRepo create(Typeface r2) {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r0 = new MetadataRepo(r2, new MetadataList());     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r0;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public void put(TypefaceEmojiRasterizer r5) {
        Preconditions.checkNotNull(r5, "emoji metadata cannot be null");
        if (r5.getCodepointsLength() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "invalid metadata codepoint length");
        this.mRootNode.put(r5, 0, r5.getCodepointsLength() - 1);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private MetadataRepo(Typeface r2, MetadataList r3) {
        this.mTypeface = r2;
        this.mMetadataList = r3;
        this.mRootNode = new Node(1024);
        this.mEmojiCharArray = new char[r3.listLength() * 2];
        constructIndex(r3);
    }

    public static MetadataRepo create(AssetManager r2, String r3) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r1 = new MetadataRepo(Typeface.createFromAsset(r2, r3), MetadataListReader.read(r2, r3));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r1;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static MetadataRepo create(Typeface r1, InputStream r2) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r0 = new MetadataRepo(r1, MetadataListReader.read(r2));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r0;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }

    public static MetadataRepo create(Typeface r1, ByteBuffer r2) throws IOException {
        TraceCompat.beginSection(S_TRACE_CREATE_REPO);     // Catch: Throwable -> L5
        MetadataRepo r0 = new MetadataRepo(r1, MetadataListReader.read(r2));     // Catch: Throwable -> L5
        TraceCompat.endSection();
        return r0;
    L5:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    }
}
