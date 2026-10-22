package com.bytedance.android.ec.common.impl.sku;

import android.content.Context;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuInfoResponseDTO;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Observer<SkuInfoResponseDTO> {
    public final /* synthetic */ String A;
    public final /* synthetic */ String B;
    public final /* synthetic */ String C;
    public final /* synthetic */ com.bytedance.android.ec.model.e D;
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ eg.a c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ String i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ Integer m;
    public final /* synthetic */ String n;
    public final /* synthetic */ boolean o;
    public final /* synthetic */ String p;
    public final /* synthetic */ boolean q;
    public final /* synthetic */ String r;
    public final /* synthetic */ com.bytedance.android.btm.api.model.l s;
    public final /* synthetic */ boolean t;
    public final /* synthetic */ String u;
    public final /* synthetic */ cf.a v;
    public final /* synthetic */ Function1 w;
    public final /* synthetic */ String x;
    public final /* synthetic */ Integer y;
    public final /* synthetic */ Map z;

    public final void onComplete() {
    }

    public final void onSubscribe(Disposable r10) {
        Intrinsics.checkNotNullParameter(r10, "d");
    }

    public final void onError(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "e");
        cf.a r11 = this.v;
        if (r11 != null) goto L5;
    L6:
        Context r12 = this.d;
        UIUtils.displayToast(r12, th.a.g(r12, 2131913776));
    L7:
        cf.a r13 = this.v;
        if (r13 == null) goto L10;
        r13.onFailed();
    L10:
        int r14 = AddCartDirectlyHelper.a;
        AddCartDirectlyHelper.a(this.r);
        if (AddCartDirectlyHelper.c(this.b) == false) goto L14;
        Set<String> r15 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -1, null, null, null, 14);
    L14:
        if (AddCartDirectlyHelper.b(this.b) == false) goto L17;
        Set<String> r16 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), -1, null, null, null, 14);
        return;
    L17:
        return;
    L5:
        if (r11.c() == false) goto L7;
        goto L6
    }

    public final void onNext(Object r44) {
        SkuInfoResponseDTO r1 = (SkuInfoResponseDTO) r44;
        Intrinsics.checkNotNullParameter(r1, "response");
        Set<String> r10 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a r11 = ECProcessMonitor.d("ec_product_detail");
        Pair<String, String>[] r12 = new Pair[1];
        LogPbData r13 = r1.getLogPb();
        String r14 = null;
        if (r13 == null) goto L5;
        String r15 = r13.getImprId();
    L7:
        if (r15 != null) goto L9;
        r15 = "";
    L9:
        r12[0] = TuplesKt.to("sku_log_id", r15);
        r11.b(r12);
        Map<String, SkuItemInfo> r16 = r1.getSkus();
        if (r16 != null) goto L12;
    L39:
        int r17 = AddCartDirectlyHelper.a;
        if (AddCartDirectlyHelper.c(this.b) == false) goto L43;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -1, null, Integer.valueOf(r1.getStatusCode()), r1.getStatusMsg(), 2);
    L43:
        if (AddCartDirectlyHelper.b(this.b) == false) goto L45;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_flow_page"), -1, null, Integer.valueOf(r1.getStatusCode()), r1.getStatusMsg(), 2);
    L45:
        cf.a r18 = this.v;
        if (r18 != null) goto L48;
    L49:
        Context r19 = this.d;
        UIUtils.displayToast(r19, th.a.g(r19, 2131913776));
    L50:
        cf.a r20 = this.v;
        if (r20 == null) goto L53;
        r20.onFailed();
    L53:
        AddCartDirectlyHelper.a(this.r);
        return;
    L48:
        if (r18.c() == false) goto L50;
    L12:
        if ((!r16.isEmpty()) == true) goto L15;
        r16 = null;
    L15:
        if (r16 == null) goto L39;
        if (r16.size() != 1) goto L56;
        String r21 = (String) CollectionsKt.first(r16.keySet());
        SkuItemInfo r22 = r16.get(r21);
        if (r22 == null) goto L22;
        r14 = r22.getId();
    L22:
        if (r14 != null) goto L24;
        String r23 = "";
    L25:
        Object[] r24 = new Regex("_").split(r21, 0).toArray(new String[0]);
        if (r24 == null) goto L38;
        String[] r25 = (String[]) r24;
        int r26 = AddCartDirectlyHelper.a;
        int r110 = this.a;
        int r111 = this.b;
        eg.a r112 = this.c;
        List<SpecInfo> r113 = r1.getSpecList();
        Context r114 = this.d;
        String r115 = this.e;
        String r27 = this.f;
        String r28 = this.g;
        String r29 = this.h;
        String r30 = this.i;
        String r31 = this.j;
        if (r31 != null) goto L30;
        String r210 = "";
    L31:
        String r32 = this.k;
        String r33 = this.l;
        Integer r34 = this.m;
        if (r34 == null) goto L35;
        String r35 = String.valueOf(r34.intValue());
        if (r35 == null) goto L35;
    L36:
        AddCartDirectlyHelper.d(r110, r111, r112, r113, r114, r115, r27, r28, r29, r30, r210, r32, r33, r23, r35, r25, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D);
        return;
    L35:
        r35 = "1";
        goto L36
    L30:
        r210 = r31;
        goto L31
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L24:
        r23 = r14;
        goto L25
    L56:
        return;
    L5:
        r15 = null;
        goto L7
    }

    public a(int r10, int r11, eg.a r12, Context r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111, Integer r112, String r113, boolean r114, String r115, boolean r116, String r20, com.bytedance.android.btm.api.model.l r21, boolean r22, String r23, cf.a r24, Function1 r25, String r26, Integer r27, Map r28, String r29, String r30, String r31, com.bytedance.android.ec.model.e r32) {
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r19;
        this.k = r110;
        this.l = r111;
        this.m = r112;
        this.n = r113;
        this.o = r114;
        this.p = r115;
        this.q = r116;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
    }
}
