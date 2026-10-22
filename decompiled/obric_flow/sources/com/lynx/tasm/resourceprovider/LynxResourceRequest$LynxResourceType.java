package com.lynx.tasm.resourceprovider;

/* JADX INFO: loaded from: classes2.dex */
public final enum LynxResourceRequest$LynxResourceType extends Enum<LynxResourceRequest$LynxResourceType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxResourceRequest$LynxResourceType f10942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LynxResourceRequest$LynxResourceType f10943b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LynxResourceRequest$LynxResourceType f10944c = null;
    public static final LynxResourceRequest$LynxResourceType d = null;
    public static final LynxResourceRequest$LynxResourceType e = null;
    public static final LynxResourceRequest$LynxResourceType f = null;
    public static final LynxResourceRequest$LynxResourceType g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LynxResourceRequest$LynxResourceType f10945h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ LynxResourceRequest$LynxResourceType[] f10946i = null;

    static {
        LynxResourceRequest$LynxResourceType r5 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeGeneric", 0);
        LynxResourceRequest$LynxResourceType r10 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeImage", 1);
        f10942a = r10;
        LynxResourceRequest$LynxResourceType r11 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeFont", 2);
        f10943b = r11;
        LynxResourceRequest$LynxResourceType r12 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeLottie", 3);
        f10944c = r12;
        LynxResourceRequest$LynxResourceType r13 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeVideo", 4);
        d = r13;
        LynxResourceRequest$LynxResourceType r14 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeSVG", 5);
        e = r14;
        LynxResourceRequest$LynxResourceType r15 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeTemplate", 6);
        f = r15;
        LynxResourceRequest$LynxResourceType r16 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeLynxCoreJS", 7);
        LynxResourceRequest$LynxResourceType r17 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeDynamicComponent", 8);
        g = r17;
        LynxResourceRequest$LynxResourceType r18 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeI18NText", 9);
        LynxResourceRequest$LynxResourceType r19 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeTheme", 10);
        LynxResourceRequest$LynxResourceType r110 = new LynxResourceRequest$LynxResourceType("LynxResourceTypeExternalJSSource", 11);
        f10945h = r110;
        f10946i = new LynxResourceRequest$LynxResourceType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, new LynxResourceRequest$LynxResourceType("LynxResourceTypeExternalByteCode", 12)};
    }

    public LynxResourceRequest$LynxResourceType(String r5, int r10) {
        super(r5, r10);
    }

    public static LynxResourceRequest$LynxResourceType valueOf(String r5) {
        return (LynxResourceRequest$LynxResourceType) Enum.valueOf(LynxResourceRequest$LynxResourceType.class, r5);
    }

    public static LynxResourceRequest$LynxResourceType[] values() {
        return (LynxResourceRequest$LynxResourceType[]) f10946i.clone();
    }
}
