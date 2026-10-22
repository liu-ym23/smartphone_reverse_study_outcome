package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.InitialProps;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.lynx.tasm.TemplateData;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public q() {
    }

    static {
    }

    public static com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c a(Context r31, Uri r32, b7.a r33, long r34, DataCenter r36, boolean r37) {
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r32, "uri");
        Intrinsics.checkNotNullParameter(r33, "commonLifecycle");
        jc1.k.n(IBrowserService.class).initAnnie();
        u6 r3 = new u6(r32);
        Map r4 = Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null).s1();
        u6 r7 = r3.d("url");
        Iterator r5 = r4.entrySet().iterator();
    L3:
        boolean r9 = false;
        if (r5.hasNext() == false) goto L12;
        Map.Entry r8 = (Map.Entry) r5.next();
        String r11 = r7.a((String) r8.getKey());
        if (r11 != null) goto L8;
    L9:
        r9 = true;
    L10:
        if (r9 == false) goto L3;
        r7.b((String) r8.getKey(), (String) r8.getValue());
        goto L3
    L8:
        if (r11.length() != 0) goto L10;
    L12:
        String r6 = r7.a("business_type");
        if (r2.a(r6) == false) goto L23;
        String r12 = r3.a("group");
        if (r12 != null) goto L17;
    L20:
        boolean r13 = true;
    L21:
        if (r13 == false) goto L23;
        r3.b("group", r6);
        goto L23
    L17:
        if (r12.length() == 0) goto L20;
        r13 = false;
    L23:
        Uri r10 = r3.c();
        InitialProps r14 = InitialProps.d;
        Uri r15 = r7.c();
        r14.getClass();
        GsonMap r16 = InitialProps.a(r10, r15, r36, r37);
        if (r16 == null) goto L26;
        TemplateData r17 = TemplateData.fromMap(MapsKt.mapOf(TuplesKt.to("initialProps", r16)));
    L27:
        ra.a r18 = com.bytedance.android.anniex.api.d.g(new com.bytedance.android.anniex.api.d("webcast", MapsKt.mapOf(TuplesKt.to("location", r7.toString())), ra.b.b(ra.b.B.c(r10), false, null, null, null, 0, 0, 0.0f, false, false, null, false, CollectionsKt.listOf(new com.lynx.tasm.behavior.a[]{new n(), new o(), new p()}), null, false, false, false, null, false, 0.0f, 16769023), 8), r10, r17, null, 24);
        com.bytedance.android.anniex.assemble.a r19 = com.bytedance.android.anniex.assemble.a.a;
        AnnieXLynxView r0 = com.bytedance.android.anniex.api.c.a(r31, r18);
        if (((LiveMemLeakConfig) j1.a.getValue()).getOpenFixV2() == false) goto L30;
        r0.setTag(2131362966, r33);
        r0.addLynxViewClient(new k(r0));
    L31:
        r0.E(r18, Long.valueOf(r34));
        return new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c(r0, r18, new m(r33, r32));
    L30:
        r0.addLynxViewClient(new l(r33, r0));
        goto L31
    L26:
        r17 = null;
        goto L27
    }

    public static /* synthetic */ com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c b(Context r7, Uri r8, b7.a r9, long r10, DataCenter r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r10 = System.currentTimeMillis();
    L5:
        long r3 = r10;
        if ((r13 & 16) == 0) goto L8;
        r12 = null;
    L8:
        DataCenter r5 = r12;
        if ((r13 & 32) == 0) goto L11;
        boolean r6 = true;
    L13:
        return a(r7, r8, r9, r3, r5, r6);
    L11:
        r6 = false;
        goto L13
    }
}
