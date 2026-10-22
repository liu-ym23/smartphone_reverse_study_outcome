package com.ss.android.lark.image.transform;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CropTransformation {

    public static final enum CropType extends Enum<CropType> {
        public static final CropType BOTTOM = null;
        public static final CropType CENTER = null;
        public static final CropType TOP = null;
        public static final /* synthetic */ CropType[] a = null;
        private int value;

        static {
            CropType r0 = new CropType("TOP", 0, 1);
            TOP = r0;
            CropType r1 = new CropType("CENTER", 1, 2);
            CENTER = r1;
            CropType r4 = new CropType("BOTTOM", 2, 3);
            BOTTOM = r4;
            a = new CropType[]{r0, r1, r4};
        }

        public static CropType[] values() {
            return (CropType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static CropType forNumber(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return null;
        L11:
            return BOTTOM;
        L13:
            return CENTER;
        L15:
            return TOP;
        }

        public static CropType valueOf(String r1) {
            return (CropType) a.a(CropType.class, r1);
        }

        public static CropType valueOf(int r0) {
            return forNumber(r0);
        }

        public CropType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }
}
