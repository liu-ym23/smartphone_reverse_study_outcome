package com.ss.android.lark.preload;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum PreloadType extends Enum<PreloadType> {
    public static final PreloadType IDLE = null;
    public static final /* synthetic */ PreloadType[] a = null;

    static {
        PreloadType r0 = new PreloadType();
        IDLE = r0;
        a = new PreloadType[]{r0};
    }

    public PreloadType() {
        super("IDLE", 0);
    }

    public static PreloadType[] values() {
        return (PreloadType[]) a.clone();
    }

    public static PreloadType valueOf(String r1) {
        return (PreloadType) r27.a.a(PreloadType.class, r1);
    }
}
