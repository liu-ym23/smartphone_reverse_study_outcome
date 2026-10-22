package com.lynx.tasm.resourceprovider;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxResourceRequest {
    public final String a;
    public final LynxResourceType b;

    public static final enum AsyncMode extends Enum<AsyncMode> {
        public static final AsyncMode EXACTLY_ASYNC = null;
        public static final AsyncMode EXACTLY_SYNC = null;
        public static final AsyncMode MOST_SYNC = null;
        public static final /* synthetic */ AsyncMode[] a = null;

        static {
            AsyncMode r0 = new AsyncMode("EXACTLY_ASYNC", 0);
            EXACTLY_ASYNC = r0;
            AsyncMode r1 = new AsyncMode("EXACTLY_SYNC", 1);
            EXACTLY_SYNC = r1;
            AsyncMode r3 = new AsyncMode("MOST_SYNC", 2);
            MOST_SYNC = r3;
            a = new AsyncMode[]{r0, r1, r3};
        }

        public static AsyncMode[] values() {
            return (AsyncMode[]) a.clone();
        }

        public static AsyncMode valueOf(String r1) {
            return (AsyncMode) a.a(AsyncMode.class, r1);
        }

        public AsyncMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum LynxResourceType extends Enum<LynxResourceType> {
        public static final LynxResourceType LynxResourceTypeDynamicComponent = null;
        public static final LynxResourceType LynxResourceTypeExternalByteCode = null;
        public static final LynxResourceType LynxResourceTypeExternalJSSource = null;
        public static final LynxResourceType LynxResourceTypeFont = null;
        public static final LynxResourceType LynxResourceTypeGeneric = null;
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
            LynxResourceType r0 = new LynxResourceType("LynxResourceTypeGeneric", 0);
            LynxResourceTypeGeneric = r0;
            LynxResourceType r1 = new LynxResourceType("LynxResourceTypeImage", 1);
            LynxResourceTypeImage = r1;
            LynxResourceType r3 = new LynxResourceType("LynxResourceTypeFont", 2);
            LynxResourceTypeFont = r3;
            LynxResourceType r5 = new LynxResourceType("LynxResourceTypeLottie", 3);
            LynxResourceTypeLottie = r5;
            LynxResourceType r7 = new LynxResourceType("LynxResourceTypeVideo", 4);
            LynxResourceTypeVideo = r7;
            LynxResourceType r9 = new LynxResourceType("LynxResourceTypeSVG", 5);
            LynxResourceTypeSVG = r9;
            LynxResourceType r11 = new LynxResourceType("LynxResourceTypeTemplate", 6);
            LynxResourceTypeTemplate = r11;
            LynxResourceType r13 = new LynxResourceType("LynxResourceTypeLynxCoreJS", 7);
            LynxResourceTypeLynxCoreJS = r13;
            LynxResourceType r15 = new LynxResourceType("LynxResourceTypeDynamicComponent", 8);
            LynxResourceTypeDynamicComponent = r15;
            LynxResourceType r14 = new LynxResourceType("LynxResourceTypeI18NText", 9);
            LynxResourceTypeI18NText = r14;
            LynxResourceType r12 = new LynxResourceType("LynxResourceTypeTheme", 10);
            LynxResourceTypeTheme = r12;
            LynxResourceType r10 = new LynxResourceType("LynxResourceTypeExternalJSSource", 11);
            LynxResourceTypeExternalJSSource = r10;
            LynxResourceType r8 = new LynxResourceType("LynxResourceTypeExternalByteCode", 12);
            LynxResourceTypeExternalByteCode = r8;
            a = new LynxResourceType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
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

    public LynxResourceRequest(String r1, LynxResourceType r2) {
        this.a = r1;
        this.b = r2;
    }
}
