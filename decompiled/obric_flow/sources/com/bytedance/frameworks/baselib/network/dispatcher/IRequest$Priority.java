package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final enum IRequest$Priority extends Enum<IRequest$Priority> {
    public static final IRequest$Priority HIGH = null;
    public static final IRequest$Priority IMMEDIATE = null;
    public static final IRequest$Priority LOW = null;
    public static final IRequest$Priority NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IRequest$Priority[] f4668a = null;

    static {
        IRequest$Priority r5 = new IRequest$Priority("LOW", 0);
        LOW = r5;
        IRequest$Priority r10 = new IRequest$Priority("NORMAL", 1);
        NORMAL = r10;
        IRequest$Priority r11 = new IRequest$Priority("HIGH", 2);
        HIGH = r11;
        IRequest$Priority r12 = new IRequest$Priority("IMMEDIATE", 3);
        IMMEDIATE = r12;
        f4668a = new IRequest$Priority[]{r5, r10, r11, r12};
    }

    public static IRequest$Priority valueOf(String r5) {
        return (IRequest$Priority) Enum.valueOf(IRequest$Priority.class, r5);
    }

    public static IRequest$Priority[] values() {
        return (IRequest$Priority[]) f4668a.clone();
    }
}
