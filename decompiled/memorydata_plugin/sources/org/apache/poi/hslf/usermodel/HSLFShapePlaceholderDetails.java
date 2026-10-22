package org.apache.poi.hslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class HSLFShapePlaceholderDetails extends HSLFPlaceholderDetails {

    private static final enum PlaceholderContainer extends Enum<PlaceholderContainer> {
        private static final /* synthetic */ PlaceholderContainer[] $VALUES = null;
        public static final PlaceholderContainer master = null;
        public static final PlaceholderContainer notes = null;
        public static final PlaceholderContainer notesMaster = null;
        public static final PlaceholderContainer slide = null;

        static {
            PlaceholderContainer r0 = new PlaceholderContainer("slide", 0);
            slide = r0;
            PlaceholderContainer r1 = new PlaceholderContainer("master", 1);
            master = r1;
            PlaceholderContainer r3 = new PlaceholderContainer("notes", 2);
            notes = r3;
            PlaceholderContainer r5 = new PlaceholderContainer("notesMaster", 3);
            notesMaster = r5;
            $VALUES = new PlaceholderContainer[]{r0, r1, r3, r5};
        }

        private PlaceholderContainer(String r1, int r2) {
            super(r1, r2);
        }

        public static PlaceholderContainer valueOf(String r2) {
            return (PlaceholderContainer) ZeusTransformUtils.preCheckCast(Enum.valueOf(PlaceholderContainer.class, r2), PlaceholderContainer.class, "com.obric.memorydata.plugin");
        }

        public static PlaceholderContainer[] values() {
            return (PlaceholderContainer[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PlaceholderContainer[].class, "com.obric.memorydata.plugin");
        }
    }
}
