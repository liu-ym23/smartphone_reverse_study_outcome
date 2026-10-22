package com.bytedance.common.wschannel.event;

import ai.j0;

/* JADX INFO: loaded from: classes2.dex */
public final enum ChannelType extends Enum<ChannelType> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ChannelType f3979b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ChannelType f3980c = null;
    public static final /* synthetic */ ChannelType[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3981a;

    static {
        ChannelType r5 = new ChannelType("CHANNEL_SELF", 0, 1);
        f3979b = r5;
        ChannelType r10 = new ChannelType("CHANNEL_OK", 1, 2);
        f3980c = r10;
        d = new ChannelType[]{r5, r10};
    }

    public ChannelType(String r5, int r10, int r11) {
        super(r5, r10);
        this.f3981a = r11;
    }

    public static ChannelType valueOf(String r5) {
        return (ChannelType) Enum.valueOf(ChannelType.class, r5);
    }

    public static ChannelType[] values() {
        return (ChannelType[]) d.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return j0.n(new StringBuilder("ChannelType{Type="), this.f3981a, '}');
    }
}
