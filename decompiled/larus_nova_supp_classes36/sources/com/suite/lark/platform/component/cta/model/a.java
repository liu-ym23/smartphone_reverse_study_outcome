package com.suite.lark.platform.component.cta.model;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final StuckSpotRequestExecutor a;

    /* JADX INFO: renamed from: com.suite.lark.platform.component.cta.model.a$a, reason: collision with other inner class name */
    public static final class C0237a {
    }

    static {
    }

    public a() {
        this.a = new StuckSpotRequestExecutor();
    }

    public final Object a(String r18, String r19, String r20, String r21, Continuation<? super com.larksuite.rucket.job.base.b<goc.b>> r22) {
        StringBuilder r3 = new StringBuilder();
        r3.append("https://" + jcb.b.c().a("api"));
        r3.append("/boss/api/v1/feature/stuck_spot");
        String r7 = r3.toString();
        HashMap r8 = new HashMap();
        User r4 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        e.a().getClass();
        int r5 = com.ss.android.lark.language.service.impl.a.f;
        apb.b r6 = com.ss.android.lark.language.service.impl.a.b.a;
        r8.put("locale", r6.d(r6.getLanguageSetting()));
        r8.put("X-Device-Type", "Android");
        if (Intrinsics.areEqual(r20, "0") == false) goto L9;
        if (r4 == null) goto L6;
        String r9 = r4.getTenantId();
    L7:
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        int r10 = hoc.a.a;
        boolean r11 = false;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("lark.purchase_cta.version_info") == false) goto L13;
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("feature_key", r18), TuplesKt.to("scene", r19), TuplesKt.to("checkpoint_tenant_id", r9), TuplesKt.to("checkpoint_user_id", r21), TuplesKt.to("template_version", "1.1")});
    L14:
        String r1 = GsonProtectorUtils.toJson(new Gson(), r0);
        StuckSpotRequestExecutor r12 = this.a;
        if (r4 == null) goto L17;
        final String r2 = r4.userId;
    L18:
        if (r2 != null) goto L20;
        r2 = "";
    L20:
        if (r4 == null) goto L22;
        String r13 = r4.getSession();
    L23:
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        Intrinsics.checkNotNull(r1);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.chat.session_governance") == false) goto L46;
        r12.getClass();
        j r14 = new j(IntrinsicsKt.intercepted(r22), 1);
        r14.C();
        if (r2.length() != 0) goto L30;
        r11 = true;
    L30:
        if (r11 == false) goto L47;
        Result.Companion r15 = Result.Companion;
        r14.resumeWith(Result.constructor-impl(new com.larksuite.rucket.job.base.b.b(new ErrorResult("foreground user id is empty"))));
    L42:
        Object r16 = r14.B();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
        DebugProbesKt.probeCoroutineSuspended(r22);
        return r16;
    L49:
        return r16;
    L47:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L34
        Request r23 = new Request.Builder().url(r7).headers(Headers.of(r8)).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r1)).build();     // Catch: Throwable -> L34
        com.larksuite.framework.http.v2.internal.main.b r24 = ((com.larksuite.framework.http.v2.b) r12.a.getValue()).a(new StuckSpotRequestExecutor$executeWithLarkHttp$2$1$1(r2));     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r23);     // Catch: Throwable -> L34
        Object r25 = Result.constructor-impl(com.larksuite.framework.http.v2.c.c.a(r24, r23));     // Catch: Throwable -> L34
    L37:
        if (Result.isSuccess-impl(r25) == false) goto L39;
        final Call r26 = (Call) r25;
        r14.i(new StuckSpotRequestExecutor$executeWithLarkHttp$2$2$1(r26));
        r26.enqueue(new c(r12, r14));
    L39:
        Throwable r27 = Result.exceptionOrNull-impl(r25);
        if (r27 == null) goto L42;
        StuckSpotRequestExecutor.a(r12, r14, new com.larksuite.rucket.job.base.b.b(StuckSpotRequestExecutor.b(r12, r27)));
    L34:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L46:
        return r12.c(r13, r7, r8, r1, r22);
    L22:
        r13 = null;
        goto L23
    L17:
        r2 = null;
        goto L18
    L13:
        r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("feature_key", r18), TuplesKt.to("scene", r19), TuplesKt.to("checkpoint_tenant_id", r9), TuplesKt.to("checkpoint_user_id", r21)});
        goto L14
    L6:
        r9 = null;
        goto L7
    L9:
        r9 = r20;
        goto L10
    }
}
