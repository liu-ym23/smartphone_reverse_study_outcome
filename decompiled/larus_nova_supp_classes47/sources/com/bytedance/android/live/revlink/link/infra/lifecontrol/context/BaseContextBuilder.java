package com.bytedance.android.live.revlink.link.infra.lifecontrol.context;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class BaseContextBuilder {
    public String a;
    public boolean b;
    public long c;
    public String d;
    public int e;
    public long f;
    public Function0<Integer> g;
    public Function0<Integer> h;
    public int i;
    public o11.a j;
    public com.bytedance.android.live.revlink.impl.global.c k;
    public x51.a l;
    public wq2.f m;
    public yz0.f n;
    public com.bytedance.android.livesdk.revenue.service.message.d o;
    public ld.a p;
    public x11.a q;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.l r;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.j s;
    public com.bytedance.android.live.revlink.link.domain.anchorimpl.m t;
    public Function0<? extends IRoom> u;

    public BaseContextBuilder() {
        this.a = "";
        this.d = "";
        this.e = 1;
        this.g = BaseContextBuilder$containerWidthFn$1.INSTANCE;
        this.h = BaseContextBuilder$containerHeightFn$1.INSTANCE;
    }
}
