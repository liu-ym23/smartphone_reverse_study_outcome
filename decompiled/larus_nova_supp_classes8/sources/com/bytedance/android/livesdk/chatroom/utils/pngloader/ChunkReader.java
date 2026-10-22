package com.bytedance.android.livesdk.chatroom.utils.pngloader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class ChunkReader {
    public final ChunkReaderMode a;
    public final po1.b b;
    public int c;
    public int d;

    public static final enum ChunkReaderMode extends Enum<ChunkReaderMode> {
        public static final ChunkReaderMode BUFFER = null;
        public static final ChunkReaderMode PROCESS = null;
        public static final ChunkReaderMode SKIP = null;
        public static final /* synthetic */ ChunkReaderMode[] a = null;

        static {
            ChunkReaderMode r0 = new ChunkReaderMode("BUFFER", 0);
            BUFFER = r0;
            ChunkReaderMode r1 = new ChunkReaderMode("PROCESS", 1);
            PROCESS = r1;
            ChunkReaderMode r3 = new ChunkReaderMode("SKIP", 2);
            SKIP = r3;
            a = new ChunkReaderMode[]{r0, r1, r3};
        }

        public static ChunkReaderMode[] values() {
            return (ChunkReaderMode[]) a.clone();
        }

        public static ChunkReaderMode valueOf(String r1) {
            return (ChunkReaderMode) r27.a.a(ChunkReaderMode.class, r1);
        }

        public ChunkReaderMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public ChunkReader(int r4, String r5, ChunkReaderMode r6) {
        boolean r0 = false;
        this.c = 0;
        this.d = 0;
        if (r6 == null) goto L13;
        if (r5.length() != 4) goto L13;
        if (r4 < 0) goto L13;
        this.a = r6;
        if (r6 != ChunkReaderMode.BUFFER) goto L10;
        r0 = true;
    L10:
        this.b = new po1.b(r4, r5, r0);
        return;
    L13:
        throw new RuntimeException();
    }
}
