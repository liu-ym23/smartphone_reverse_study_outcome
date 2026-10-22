package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface ClientAnchor {

    public static final enum AnchorType extends Enum<AnchorType> {
        private static final /* synthetic */ AnchorType[] $VALUES = null;
        public static final AnchorType DONT_MOVE_AND_RESIZE = null;
        public static final AnchorType DONT_MOVE_DO_RESIZE = null;
        public static final AnchorType MOVE_AND_RESIZE = null;
        public static final AnchorType MOVE_DONT_RESIZE = null;
        public final short value;

        static {
            AnchorType r0 = new AnchorType("MOVE_AND_RESIZE", 0, 0);
            MOVE_AND_RESIZE = r0;
            AnchorType r1 = new AnchorType("DONT_MOVE_DO_RESIZE", 1, 1);
            DONT_MOVE_DO_RESIZE = r1;
            AnchorType r3 = new AnchorType("MOVE_DONT_RESIZE", 2, 2);
            MOVE_DONT_RESIZE = r3;
            AnchorType r5 = new AnchorType("DONT_MOVE_AND_RESIZE", 3, 3);
            DONT_MOVE_AND_RESIZE = r5;
            $VALUES = new AnchorType[]{r0, r1, r3, r5};
        }

        private AnchorType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = (short) r3;
        }

        public static AnchorType byId(int r1) {
            return values()[r1];
        }

        public static AnchorType valueOf(String r2) {
            return (AnchorType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AnchorType.class, r2), AnchorType.class, "com.obric.memorydata.plugin");
        }

        public static AnchorType[] values() {
            return (AnchorType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AnchorType[].class, "com.obric.memorydata.plugin");
        }
    }
}
