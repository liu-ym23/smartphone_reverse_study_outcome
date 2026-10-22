package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.address.api.AddressItemVO;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class w {
    public final Map<String, AddressItemVO> a;
    public final b b;
    public final b c;
    public final b d;
    public int e;
    public long f;
    public v g;
    public volatile boolean h;
    public long i;
    public wi.a j;
    public final WeakHashMap<Object, Unit> k;
    public Map<String, Integer> l;

    public final void a() {
        int r0 = this.g.e().e();
        long r1 = System.currentTimeMillis();
        if (((r1 - this.f) / ((long) 60000)) <= r0) goto L6;
        this.f = r1;
        com.bytedance.android.ec.sdk.helper.d.b.getIECSPService().e("ec_address_dialog_stat_timestamp", this.f);
        this.e = 0;
        return;
    }

    public w() {
        this.a = new LinkedHashMap();
        this.b = new b();
        this.c = new b();
        this.d = new b();
        this.g = new v(true);
        this.k = new WeakHashMap();
    }
}
