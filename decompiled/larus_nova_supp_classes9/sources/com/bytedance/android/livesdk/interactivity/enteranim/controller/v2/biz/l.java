package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ k32.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ e e;

    public l(long r1, k32.a r3, String r4, String r5, g r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public final void accept(Object r18) {
        Throwable r1 = (Throwable) r18;
        ALogger.e("RevenueUtils", "getAssetPath error: id=" + this.a + ",error=" + r1.getMessage());
        RevenueUtils.b r2 = RevenueUtils.i;
        k32.a r3 = this.b;
        String r4 = this.c;
        String r5 = "download failed " + r1.getMessage();
        JSONObject r7 = UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("dress_id", this.d), TuplesKt.to("resource_id", Long.valueOf(this.a)), TuplesKt.to("duration_time", -1)});
        r2.getClass();
        RevenueUtils.b.d(r3, r4, true, r5, r7);
        e r6 = this.e;
        String r14 = "download failed " + r1.getMessage();
        u72.a r8 = ((g) r6).a;
        if (r8 == null) goto L6;
        v72.c r9 = (v72.c) r8;
        RevenueUtils.b(0, 0, 0, false, -1, r14, r9.g, r9.d);
        return;
    }
}
