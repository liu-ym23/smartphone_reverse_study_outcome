package com.bytedance.android.live.recharge.platform.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/NoPasswordPayChannel;", "", "", "value", "I", "getValue", "()I", "DOUYIN_CHANNEL", "ZFB_CHANNEL", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum NoPasswordPayChannel extends Enum<NoPasswordPayChannel> {
    public static final NoPasswordPayChannel DOUYIN_CHANNEL = null;
    public static final NoPasswordPayChannel ZFB_CHANNEL = null;
    public static final /* synthetic */ NoPasswordPayChannel[] a = null;
    private final int value;

    static {
        NoPasswordPayChannel r1 = new NoPasswordPayChannel("DOUYIN_CHANNEL", 0, 206);
        DOUYIN_CHANNEL = r1;
        NoPasswordPayChannel r2 = new NoPasswordPayChannel("ZFB_CHANNEL", 1, 201);
        ZFB_CHANNEL = r2;
        a = new NoPasswordPayChannel[]{r1, r2};
    }

    public static NoPasswordPayChannel valueOf(String r1) {
        return (NoPasswordPayChannel) r27.a.a(NoPasswordPayChannel.class, r1);
    }

    public static NoPasswordPayChannel[] values() {
        return (NoPasswordPayChannel[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public NoPasswordPayChannel(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
