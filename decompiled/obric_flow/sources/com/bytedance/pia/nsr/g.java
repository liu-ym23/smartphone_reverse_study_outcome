package com.bytedance.pia.nsr;

import android.net.Uri;
import com.bytedance.pia.core.metrics.MetricsType;
import com.bytedance.pia.core.utils.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ko.r;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f7191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yg.b f7192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ nh.d f7193c;
    public final /* synthetic */ a d;
    public final /* synthetic */ Function2 e;

    public g(AtomicBoolean r5, yg.b r10, nh.d r11, a r12, Function2 r13) {
        this.f7191a = r5;
        this.f7192b = r10;
        this.f7193c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "html");
        if (this.f7191a.compareAndSet(false, true) == false) goto L6;
        StringBuilder r5 = new StringBuilder("[NSR] Run nsr success. (URL: ");
        Uri r12 = this.f7192b.f23260a;
        r5.append(r12);
        r5.append(')');
        com.bytedance.pia.core.utils.j.y(r5.toString(), null);
        r r13 = h.f7194a;
        String r14 = r12.toString();
        nh.d r15 = this.f7193c;
        Intrinsics.checkNotNullParameter(r15, "runtime");
        Intrinsics.checkNotNullParameter(r14, "url");
        a r16 = this.d;
        Intrinsics.checkNotNullParameter(r16, "consumer");
        kh.c r17 = r15.f20239j;
        MetricsType r18 = MetricsType.f7037c;
        Map r19 = MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("worker_url", r14), TuplesKt.to("pia_sdk_version", "2.5.2.8-allinone"), TuplesKt.to("render_success", Boolean.TRUE)}), (LinkedHashMap) r16.e);
        r17.getClass();
        m.b(new kh.b(r17, r18, r19));
        Boolean r20 = Boolean.valueOf(r11);
        this.e.mo2invoke(r10, r20);
        return;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Object r10) {
        a((String) r5, ((Boolean) r10).booleanValue());
        return Unit.INSTANCE;
    }
}
