package com.lynx.tasm.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum LynxViewBuilderProperty extends Enum<LynxViewBuilderProperty> {
    public static final LynxViewBuilderProperty PLATFORM_CONFIG = null;
    public static final /* synthetic */ LynxViewBuilderProperty[] a = null;
    private final String key;

    static {
        LynxViewBuilderProperty r0 = new LynxViewBuilderProperty();
        PLATFORM_CONFIG = r0;
        a = new LynxViewBuilderProperty[]{r0};
    }

    public LynxViewBuilderProperty() {
        super("PLATFORM_CONFIG", 0);
        this.key = "platform_config";
    }

    public static LynxViewBuilderProperty[] values() {
        return (LynxViewBuilderProperty[]) a.clone();
    }

    public String getKey() {
        return this.key;
    }

    public static LynxViewBuilderProperty valueOf(String r1) {
        return (LynxViewBuilderProperty) r27.a.a(LynxViewBuilderProperty.class, r1);
    }
}
