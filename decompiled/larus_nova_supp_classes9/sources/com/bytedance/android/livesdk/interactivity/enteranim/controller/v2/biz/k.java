package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.utils.t;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ k32.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;

    public k(long r1, k32.a r3, String r4, String r5, g r6, int r7) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public final void accept(Object r18) {
        RevenueUtils.a r1 = (RevenueUtils.a) r18;
        ALogger.i("RevenueUtils", "resource downloaded: id=" + this.a + ",info=" + r1);
        RevenueUtils.b r2 = RevenueUtils.i;
        k32.a r3 = this.b;
        if (r1.f == false) goto L5;
        String r4 = this.c;
    L6:
        RevenueUtils.b.e(r2, r3, r4, UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("dress_id", this.d), TuplesKt.to("resource_id", Long.valueOf(this.a)), TuplesKt.to("duration_time", Long.valueOf(r1.d))}));
        e r5 = this.e;
        final k32.a r10 = this.b;
        String r6 = r1.a;
        final long r11 = this.a;
        final int r13 = this.f;
        final long r14 = r1.c;
        final boolean r16 = !r1.e;
        final g r9 = (g) r5;
        r9.getClass();
        r10.l = t.a(r6);
        Runnable r7 = new f(r9, r10, r11, r13, r14, r16);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        r7.run();
        return;
    L9:
        i0.h(r7);
        return;
    L5:
        r4 = this.c + "_local";
        goto L6
    }
}
