package com.larus.bmhome.chat.map;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.INetworkApi;
import com.google.gson.Gson;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.network.FlowHttpConnection;
import com.larus.platform.service.t1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o {
    public final Context a;
    public String b;
    public PoiItem c;
    public wq9.f d;
    public wq9.f e;
    public wq9.g f;
    public wq9.g g;
    public final Resources h;
    public final wq9.e i;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public final void a(final wq9.a r5) {
        PoiItem r0 = this.c;
        if (r0 == null) goto L8;
        String r1 = r0.getIcon();
        if (r1 == null) goto L9;
        final String r2 = this.b;
        ImageLoaderKt.l(r1, "poi_map_wrapper", new m(r2, this, r5), new n(this), 20);
        return;
    L9:
        return;
    }

    public final void b(List<wq9.a> r8) {
        Intrinsics.checkNotNullParameter(r8, "latLngs");
        wq9.g r0 = this.f;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        wq9.g r1 = this.g;
        if (r1 == null) goto L8;
        r1.remove();
    L8:
        wq9.e r2 = this.i;
        kk9.c r3 = null;
        if (r2 == null) goto L11;
        kk9.c r4 = r2.g(new wq9.c(r8, -1, (int) this.a.getResources().getDimension(v19.c.b(2130970911, this.a, 2131166614))));
    L12:
        this.f = r4;
        wq9.e r5 = this.i;
        if (r5 == null) goto L15;
        r3 = r5.g(new wq9.c(r8, this.a.getResources().getColor(v19.c.b(2130972123, this.a, 2131103203)), (int) this.a.getResources().getDimension(v19.c.b(2130972346, this.a, 2131167679))));
    L15:
        this.g = r3;
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final void d(List<wq9.a> r9) {
        Intrinsics.checkNotNullParameter(r9, "latLngs");
        wq9.e r1 = this.i;
        if (r1 == null) goto L6;
        r1.c(r9, (int) this.h.getDimension(v19.c.b(2130972039, null, 2131167553)), (int) this.h.getDimension(v19.c.b(2130972039, null, 2131167553)), (int) this.h.getDimension(v19.c.b(2130972039, null, 2131167553)), (int) this.h.getDimension(v19.c.b(2130972040, null, 2131167555)));
        return;
    }

    public o(Context r2, ConstraintLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        this.a = r2;
        this.h = r2.getResources();
        wq9.e r4 = t1.a.a(r2);
        this.i = r4;
        if (r4 == null) goto L5;
        r4.a();
    L5:
        if (r4 == null) goto L7;
        r4.e();
    L7:
        if (r4 == null) goto L9;
        r4.f();
    L9:
        if (r4 == null) goto L11;
        r4.i();
    L11:
        if (r4 == null) goto L14;
        r4.b(r3);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.chat.map.l, java.lang.Object] */
    public final void c(wq9.a r12, wq9.a r13) {
        Intrinsics.checkNotNullParameter(r12, "origin");
        Intrinsics.checkNotNullParameter(r13, "destination");
        final String r2 = this.b;
        Gson r3 = e.a;
        ?? r4 = new l(r2, this);
        Intrinsics.checkNotNullParameter(r12, "origin");
        Intrinsics.checkNotNullParameter(r13, "destination");
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.d("MapNetworkClient", "queryPolyline");
        INetworkApi r5 = (INetworkApi) FlowHttpConnection.b("https://mapproxy.bytedance.com", null, null).create(INetworkApi.class);
        StringBuilder r6 = new StringBuilder();
        r6.append(r12.b);
        r6.append(',');
        r6.append(r12.a);
        StringBuilder r14 = new StringBuilder();
        r14.append(r13.b);
        r14.append(',');
        r14.append(r13.a);
        r5.doGet(true, -1, "/amap/v3/direction/driving", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("key", t1.a.c()), TuplesKt.to("origin", r6.toString()), TuplesKt.to("destination", r14.toString())}), CollectionsKt.mutableListOf(new Header[]{new Header("Content-Type", "application/json")}), null).enqueue(new d(r4));
    }
}
