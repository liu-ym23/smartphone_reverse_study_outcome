package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import s09.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p {
    public static volatile Pair<String, MultimodalDowngradeData> a;
    public static volatile Pair<String, VLMUploadDowngradeData> b;

    public static final class a implements b {
        public a() {
        }

        public final String getUniqueId() {
            return "MultimodalDowngradeDataHolder";
        }

        public final void onFailure() {
        }

        public final void a(s09.a r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            Pair<String, MultimodalDowngradeData> r0 = p.a;
            Map r1 = r4.a;
            if (r1 == null) goto L5;
            String r2 = (String) r1.get("atm_dg");
        L6:
            p.a = TuplesKt.to(r2, null);
            Map r5 = r4.a;
            if (r5 == null) goto L9;
            String r6 = (String) r5.get("atm_up_dg");
        L10:
            p.b = TuplesKt.to(r6, null);
            return;
        L9:
            r6 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        PollingConfigService r0 = PollingConfigService.a;
        a = TuplesKt.to(r0.f("atm_dg"), null);
        b = TuplesKt.to(r0.f("atm_up_dg"), null);
        r0.j(new a());
    }

    public static MultimodalDowngradeData a() {
        if (a.getFirst() == null) goto L16;
        String r0 = (String) a.getFirst();
        if (r0 != null) goto L19;
        MultimodalDowngradeData r1 = null;
    L15:
        a = TuplesKt.to(null, r1);
    L17:
        FLogger.a.i("MultimodalDowngradeDataHolder", "getMultimodalDowngradeData result = " + r1);
        return r1;
    L19:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl((MultimodalDowngradeData) HttpExtKt.f.fromJson(r0, MultimodalDowngradeData.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        r1 = (MultimodalDowngradeData) r3;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L16:
        r1 = (MultimodalDowngradeData) a.getSecond();
        goto L17
    }

    public static VLMUploadDowngradeData b() {
        if (b.getFirst() == null) goto L16;
        String r0 = (String) b.getFirst();
        if (r0 != null) goto L19;
        VLMUploadDowngradeData r1 = null;
    L15:
        b = TuplesKt.to(null, r1);
    L17:
        FLogger.a.i("MultimodalDowngradeDataHolder", "getVLMUploadDowngradeData result = " + r1);
        return r1;
    L19:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl((VLMUploadDowngradeData) HttpExtKt.f.fromJson(r0, VLMUploadDowngradeData.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = null;
    L13:
        r1 = (VLMUploadDowngradeData) r3;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L16:
        r1 = (VLMUploadDowngradeData) b.getSecond();
        goto L17
    }
}
