package org.apache.commons.compress.archivers.dump;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class DumpArchiveConstants {

    public static final enum COMPRESSION_TYPE extends Enum<COMPRESSION_TYPE> {
        private static final /* synthetic */ COMPRESSION_TYPE[] $VALUES = null;
        public static final COMPRESSION_TYPE BZLIB = null;
        public static final COMPRESSION_TYPE LZO = null;
        public static final COMPRESSION_TYPE ZLIB = null;
        final int code;

        static {
            COMPRESSION_TYPE r0 = new COMPRESSION_TYPE("ZLIB", 0, 0);
            ZLIB = r0;
            COMPRESSION_TYPE r1 = new COMPRESSION_TYPE("BZLIB", 1, 1);
            BZLIB = r1;
            COMPRESSION_TYPE r3 = new COMPRESSION_TYPE("LZO", 2, 2);
            LZO = r3;
            $VALUES = new COMPRESSION_TYPE[]{r0, r1, r3};
        }

        private COMPRESSION_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }

        public static COMPRESSION_TYPE find(int r5) {
            COMPRESSION_TYPE[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            COMPRESSION_TYPE r3 = r0[r2];
            if (r3.code == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static COMPRESSION_TYPE valueOf(String r2) {
            return (COMPRESSION_TYPE) ZeusTransformUtils.preCheckCast(Enum.valueOf(COMPRESSION_TYPE.class, r2), COMPRESSION_TYPE.class, "com.obric.memorydata.plugin");
        }

        public static COMPRESSION_TYPE[] values() {
            return (COMPRESSION_TYPE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), COMPRESSION_TYPE[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum SEGMENT_TYPE extends Enum<SEGMENT_TYPE> {
        private static final /* synthetic */ SEGMENT_TYPE[] $VALUES = null;
        public static final SEGMENT_TYPE ADDR = null;
        public static final SEGMENT_TYPE BITS = null;
        public static final SEGMENT_TYPE CLRI = null;
        public static final SEGMENT_TYPE END = null;
        public static final SEGMENT_TYPE INODE = null;
        public static final SEGMENT_TYPE TAPE = null;
        final int code;

        static {
            SEGMENT_TYPE r0 = new SEGMENT_TYPE("TAPE", 0, 1);
            TAPE = r0;
            SEGMENT_TYPE r1 = new SEGMENT_TYPE("INODE", 1, 2);
            INODE = r1;
            SEGMENT_TYPE r4 = new SEGMENT_TYPE("BITS", 2, 3);
            BITS = r4;
            SEGMENT_TYPE r6 = new SEGMENT_TYPE("ADDR", 3, 4);
            ADDR = r6;
            SEGMENT_TYPE r8 = new SEGMENT_TYPE("END", 4, 5);
            END = r8;
            SEGMENT_TYPE r10 = new SEGMENT_TYPE("CLRI", 5, 6);
            CLRI = r10;
            $VALUES = new SEGMENT_TYPE[]{r0, r1, r4, r6, r8, r10};
        }

        private SEGMENT_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.code = r3;
        }

        public static SEGMENT_TYPE find(int r5) {
            SEGMENT_TYPE[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            SEGMENT_TYPE r3 = r0[r2];
            if (r3.code == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static SEGMENT_TYPE valueOf(String r2) {
            return (SEGMENT_TYPE) ZeusTransformUtils.preCheckCast(Enum.valueOf(SEGMENT_TYPE.class, r2), SEGMENT_TYPE.class, "com.obric.memorydata.plugin");
        }

        public static SEGMENT_TYPE[] values() {
            return (SEGMENT_TYPE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SEGMENT_TYPE[].class, "com.obric.memorydata.plugin");
        }
    }
}
