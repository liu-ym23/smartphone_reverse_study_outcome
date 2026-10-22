package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface PlaceholderDetails {

    public static final enum PlaceholderSize extends Enum<PlaceholderSize> {
        private static final /* synthetic */ PlaceholderSize[] $VALUES = null;
        public static final PlaceholderSize full = null;
        public static final PlaceholderSize half = null;
        public static final PlaceholderSize quarter = null;

        static {
            PlaceholderSize r0 = new PlaceholderSize("quarter", 0);
            quarter = r0;
            PlaceholderSize r1 = new PlaceholderSize("half", 1);
            half = r1;
            PlaceholderSize r3 = new PlaceholderSize("full", 2);
            full = r3;
            $VALUES = new PlaceholderSize[]{r0, r1, r3};
        }

        private PlaceholderSize(String r1, int r2) {
            super(r1, r2);
        }

        public static PlaceholderSize valueOf(String r2) {
            return (PlaceholderSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(PlaceholderSize.class, r2), PlaceholderSize.class, "com.obric.memorydata.plugin");
        }

        public static PlaceholderSize[] values() {
            return (PlaceholderSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PlaceholderSize[].class, "com.obric.memorydata.plugin");
        }
    }
}
