package com.bytedance.pia.nsr;

import android.net.Uri;
import androidx.core.view.PointerIconCompat;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f7188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nh.d f7189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ yg.b f7190c;
    public final /* synthetic */ a d;
    public final /* synthetic */ Function1 e;

    public f(AtomicBoolean r5, nh.d r10, yg.b r11, a r12, Function1 r13) {
        this.f7188a = r5;
        this.f7189b = r10;
        this.f7190c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        if (this.f7188a.compareAndSet(false, true) == false) goto L6;
        nh.d r5 = this.f7189b;
        r5.f20239j.b(PointerIconCompat.TYPE_VERTICAL_TEXT, "nsr_worker", r10);
        StringBuilder r11 = new StringBuilder("[NSR] Run nsr failed (URL: ");
        Uri r12 = this.f7190c.f23260a;
        r11.append(r12);
        r11.append(", Reason: ");
        r11.append(r10);
        r11.append(')');
        com.bytedance.pia.core.utils.j.y(r11.toString(), null);
        r r13 = h.f7194a;
        String r14 = r12.toString();
        Intrinsics.checkNotNullParameter(r5, "runtime");
        Intrinsics.checkNotNullParameter(r14, "url");
        a r15 = this.d;
        Intrinsics.checkNotNullParameter(r15, "consumer");
        MetricsType r16 = MetricsType.f7037c;
        Map r17 = MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("worker_url", r14), TuplesKt.to("pia_sdk_version", "2.5.2.8-allinone"), TuplesKt.to("render_success", Boolean.FALSE)}), (LinkedHashMap) r15.e);
        kh.c r18 = r5.f20239j;
        r18.getClass();
        m.b(new kh.b(r18, r16, r17));
        this.e.invoke(r10);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object r5) {
        a((String) r5);
        return Unit.INSTANCE;
    }
}
