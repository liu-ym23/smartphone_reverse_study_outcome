package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface TabStop {

    public static final enum TabStopType extends Enum<TabStopType> {
        private static final /* synthetic */ TabStopType[] $VALUES = null;
        public static final TabStopType CENTER = null;
        public static final TabStopType DECIMAL = null;
        public static final TabStopType LEFT = null;
        public static final TabStopType RIGHT = null;
        public final int nativeId;
        public final int ooxmlId;

        static {
            TabStopType r0 = new TabStopType("LEFT", 0, 0, 1);
            LEFT = r0;
            TabStopType r1 = new TabStopType("CENTER", 1, 1, 2);
            CENTER = r1;
            TabStopType r4 = new TabStopType("RIGHT", 2, 2, 3);
            RIGHT = r4;
            TabStopType r6 = new TabStopType("DECIMAL", 3, 3, 4);
            DECIMAL = r6;
            $VALUES = new TabStopType[]{r0, r1, r4, r6};
        }

        private TabStopType(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.nativeId = r3;
            this.ooxmlId = r4;
        }

        public static TabStopType fromNativeId(int r5) {
            TabStopType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            TabStopType r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static TabStopType fromOoxmlId(int r5) {
            TabStopType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            TabStopType r3 = r0[r2];
            if (r3.ooxmlId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static TabStopType valueOf(String r2) {
            return (TabStopType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TabStopType.class, r2), TabStopType.class, "com.obric.memorydata.plugin");
        }

        public static TabStopType[] values() {
            return (TabStopType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TabStopType[].class, "com.obric.memorydata.plugin");
        }
    }

    TabStopType getType();
}
