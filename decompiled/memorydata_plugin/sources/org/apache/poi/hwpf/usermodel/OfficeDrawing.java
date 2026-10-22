package org.apache.poi.hwpf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface OfficeDrawing {

    public static final enum HorizontalPositioning extends Enum<HorizontalPositioning> {
        private static final /* synthetic */ HorizontalPositioning[] $VALUES = null;
        public static final HorizontalPositioning ABSOLUTE = null;
        public static final HorizontalPositioning CENTER = null;
        public static final HorizontalPositioning INSIDE = null;
        public static final HorizontalPositioning LEFT = null;
        public static final HorizontalPositioning OUTSIDE = null;
        public static final HorizontalPositioning RIGHT = null;

        static {
            HorizontalPositioning r0 = new HorizontalPositioning("ABSOLUTE", 0);
            ABSOLUTE = r0;
            HorizontalPositioning r1 = new HorizontalPositioning("CENTER", 1);
            CENTER = r1;
            HorizontalPositioning r3 = new HorizontalPositioning("INSIDE", 2);
            INSIDE = r3;
            HorizontalPositioning r5 = new HorizontalPositioning("LEFT", 3);
            LEFT = r5;
            HorizontalPositioning r7 = new HorizontalPositioning("OUTSIDE", 4);
            OUTSIDE = r7;
            HorizontalPositioning r9 = new HorizontalPositioning("RIGHT", 5);
            RIGHT = r9;
            $VALUES = new HorizontalPositioning[]{r0, r1, r3, r5, r7, r9};
        }

        private HorizontalPositioning(String r1, int r2) {
            super(r1, r2);
        }

        public static HorizontalPositioning valueOf(String r2) {
            return (HorizontalPositioning) ZeusTransformUtils.preCheckCast(Enum.valueOf(HorizontalPositioning.class, r2), HorizontalPositioning.class, "com.obric.memorydata.plugin");
        }

        public static HorizontalPositioning[] values() {
            return (HorizontalPositioning[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HorizontalPositioning[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum HorizontalRelativeElement extends Enum<HorizontalRelativeElement> {
        private static final /* synthetic */ HorizontalRelativeElement[] $VALUES = null;
        public static final HorizontalRelativeElement CHAR = null;
        public static final HorizontalRelativeElement MARGIN = null;
        public static final HorizontalRelativeElement PAGE = null;
        public static final HorizontalRelativeElement TEXT = null;

        static {
            HorizontalRelativeElement r0 = new HorizontalRelativeElement("CHAR", 0);
            CHAR = r0;
            HorizontalRelativeElement r1 = new HorizontalRelativeElement("MARGIN", 1);
            MARGIN = r1;
            HorizontalRelativeElement r3 = new HorizontalRelativeElement("PAGE", 2);
            PAGE = r3;
            HorizontalRelativeElement r5 = new HorizontalRelativeElement("TEXT", 3);
            TEXT = r5;
            $VALUES = new HorizontalRelativeElement[]{r0, r1, r3, r5};
        }

        private HorizontalRelativeElement(String r1, int r2) {
            super(r1, r2);
        }

        public static HorizontalRelativeElement valueOf(String r2) {
            return (HorizontalRelativeElement) ZeusTransformUtils.preCheckCast(Enum.valueOf(HorizontalRelativeElement.class, r2), HorizontalRelativeElement.class, "com.obric.memorydata.plugin");
        }

        public static HorizontalRelativeElement[] values() {
            return (HorizontalRelativeElement[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HorizontalRelativeElement[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum VerticalPositioning extends Enum<VerticalPositioning> {
        private static final /* synthetic */ VerticalPositioning[] $VALUES = null;
        public static final VerticalPositioning ABSOLUTE = null;
        public static final VerticalPositioning BOTTOM = null;
        public static final VerticalPositioning CENTER = null;
        public static final VerticalPositioning INSIDE = null;
        public static final VerticalPositioning OUTSIDE = null;
        public static final VerticalPositioning TOP = null;

        static {
            VerticalPositioning r0 = new VerticalPositioning("ABSOLUTE", 0);
            ABSOLUTE = r0;
            VerticalPositioning r1 = new VerticalPositioning("BOTTOM", 1);
            BOTTOM = r1;
            VerticalPositioning r3 = new VerticalPositioning("CENTER", 2);
            CENTER = r3;
            VerticalPositioning r5 = new VerticalPositioning("INSIDE", 3);
            INSIDE = r5;
            VerticalPositioning r7 = new VerticalPositioning("OUTSIDE", 4);
            OUTSIDE = r7;
            VerticalPositioning r9 = new VerticalPositioning("TOP", 5);
            TOP = r9;
            $VALUES = new VerticalPositioning[]{r0, r1, r3, r5, r7, r9};
        }

        private VerticalPositioning(String r1, int r2) {
            super(r1, r2);
        }

        public static VerticalPositioning valueOf(String r2) {
            return (VerticalPositioning) ZeusTransformUtils.preCheckCast(Enum.valueOf(VerticalPositioning.class, r2), VerticalPositioning.class, "com.obric.memorydata.plugin");
        }

        public static VerticalPositioning[] values() {
            return (VerticalPositioning[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VerticalPositioning[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum VerticalRelativeElement extends Enum<VerticalRelativeElement> {
        private static final /* synthetic */ VerticalRelativeElement[] $VALUES = null;
        public static final VerticalRelativeElement LINE = null;
        public static final VerticalRelativeElement MARGIN = null;
        public static final VerticalRelativeElement PAGE = null;
        public static final VerticalRelativeElement TEXT = null;

        static {
            VerticalRelativeElement r0 = new VerticalRelativeElement("LINE", 0);
            LINE = r0;
            VerticalRelativeElement r1 = new VerticalRelativeElement("MARGIN", 1);
            MARGIN = r1;
            VerticalRelativeElement r3 = new VerticalRelativeElement("PAGE", 2);
            PAGE = r3;
            VerticalRelativeElement r5 = new VerticalRelativeElement("TEXT", 3);
            TEXT = r5;
            $VALUES = new VerticalRelativeElement[]{r0, r1, r3, r5};
        }

        private VerticalRelativeElement(String r1, int r2) {
            super(r1, r2);
        }

        public static VerticalRelativeElement valueOf(String r2) {
            return (VerticalRelativeElement) ZeusTransformUtils.preCheckCast(Enum.valueOf(VerticalRelativeElement.class, r2), VerticalRelativeElement.class, "com.obric.memorydata.plugin");
        }

        public static VerticalRelativeElement[] values() {
            return (VerticalRelativeElement[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), VerticalRelativeElement[].class, "com.obric.memorydata.plugin");
        }
    }
}
