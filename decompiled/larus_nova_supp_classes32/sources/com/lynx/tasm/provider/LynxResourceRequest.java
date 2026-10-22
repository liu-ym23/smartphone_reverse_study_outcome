package com.lynx.tasm.provider;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxResourceRequest<T> {
    public final String a;
    public final T b;

    public static final enum LynxResourceType extends Enum<LynxResourceType> {
        public static final LynxResourceType LynxResourceTypeDynamicComponent = null;
        public static final LynxResourceType LynxResourceTypeExternalJSSource = null;
        public static final LynxResourceType LynxResourceTypeFont = null;
        public static final LynxResourceType LynxResourceTypeI18NText = null;
        public static final LynxResourceType LynxResourceTypeImage = null;
        public static final LynxResourceType LynxResourceTypeLottie = null;
        public static final LynxResourceType LynxResourceTypeLynxCoreJS = null;
        public static final LynxResourceType LynxResourceTypeSVG = null;
        public static final LynxResourceType LynxResourceTypeTemplate = null;
        public static final LynxResourceType LynxResourceTypeTheme = null;
        public static final LynxResourceType LynxResourceTypeVideo = null;
        public static final /* synthetic */ LynxResourceType[] a = null;

        static {
            LynxResourceType r0 = new LynxResourceType("LynxResourceTypeImage", 0);
            LynxResourceTypeImage = r0;
            LynxResourceType r1 = new LynxResourceType("LynxResourceTypeFont", 1);
            LynxResourceTypeFont = r1;
            LynxResourceType r3 = new LynxResourceType("LynxResourceTypeLottie", 2);
            LynxResourceTypeLottie = r3;
            LynxResourceType r5 = new LynxResourceType("LynxResourceTypeVideo", 3);
            LynxResourceTypeVideo = r5;
            LynxResourceType r7 = new LynxResourceType("LynxResourceTypeSVG", 4);
            LynxResourceTypeSVG = r7;
            LynxResourceType r9 = new LynxResourceType("LynxResourceTypeTemplate", 5);
            LynxResourceTypeTemplate = r9;
            LynxResourceType r11 = new LynxResourceType("LynxResourceTypeLynxCoreJS", 6);
            LynxResourceTypeLynxCoreJS = r11;
            LynxResourceType r13 = new LynxResourceType("LynxResourceTypeDynamicComponent", 7);
            LynxResourceTypeDynamicComponent = r13;
            LynxResourceType r15 = new LynxResourceType("LynxResourceTypeI18NText", 8);
            LynxResourceTypeI18NText = r15;
            LynxResourceType r14 = new LynxResourceType("LynxResourceTypeTheme", 9);
            LynxResourceTypeTheme = r14;
            LynxResourceType r12 = new LynxResourceType("LynxResourceTypeExternalJSSource", 10);
            LynxResourceTypeExternalJSSource = r12;
            a = new LynxResourceType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
        }

        public static LynxResourceType[] values() {
            return (LynxResourceType[]) a.clone();
        }

        public static LynxResourceType valueOf(String r1) {
            return (LynxResourceType) a.a(LynxResourceType.class, r1);
        }

        public LynxResourceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public LynxResourceRequest(String r1) {
        this.a = r1;
    }

    public LynxResourceRequest(String r1, T r2) {
        this.a = r1;
        this.b = r2;
    }
}
