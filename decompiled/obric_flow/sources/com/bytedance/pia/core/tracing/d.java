package com.bytedance.pia.core.tracing;

import com.bytedance.pia.core.utils.m;
import com.google.common.reflect.w;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("id")
    public long f7122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("name")
    public final EventName f7123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("ts")
    public final Long f7124c;

    @SerializedName("args")
    public final Map<String, Object> d;
    public boolean e;
    public final /* synthetic */ w f;

    public d(w r5, EventName r10, long r11) {
        this.f = r5;
        this.f7122a = ((AtomicLong) r5.d).getAndIncrement();
        this.e = false;
        this.f7123b = r10;
        this.f7124c = Long.valueOf(r11);
        this.d = new HashMap();
    }

    public final void a() {
        w r5 = this.f;
        r5.getClass();
        m.b(new c(r5, this, true));
    }
}
