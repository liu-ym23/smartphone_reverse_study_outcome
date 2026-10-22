package com.bytedance.android.live.revlink.impl.pk.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/service/RingDrawable;", "", "ttlive_ic_pk_random_normal_circle", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RingDrawable extends Enum<RingDrawable> {
    public static final /* synthetic */ RingDrawable[] a = null;
    public static final RingDrawable ttlive_ic_pk_random_normal_circle = null;

    static {
        RingDrawable r1 = new RingDrawable();
        ttlive_ic_pk_random_normal_circle = r1;
        a = new RingDrawable[]{r1};
    }

    public static RingDrawable valueOf(String r1) {
        return (RingDrawable) r27.a.a(RingDrawable.class, r1);
    }

    public static RingDrawable[] values() {
        return (RingDrawable[]) a.clone();
    }

    public RingDrawable() {
        super("ttlive_ic_pk_random_normal_circle", 0);
    }
}
