package com.bytedance.android.ec.core.hybrid.prefetch;

import android.net.Uri;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        com.bytedance.android.ec.sdk.helper.g r0 = com.bytedance.android.ec.sdk.helper.g.a;
        JSONObject r1 = new JSONObject();
        r1.putOpt(com.bytedance.android.ec.core.event.a.KEY_URL, r10.toString());
        String r11 = r10.getPath();
        String r12 = "";
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r1.putOpt("path", r11);
        String r13 = r10.getHost();
        if (r13 == null) goto L9;
        r12 = r13;
    L9:
        r1.putOpt("host", r12);
        Unit r14 = Unit.INSTANCE;
        r0.logV3("native_prefetch_security", r1);
    }

    public static void b(String r10, boolean r11) {
        com.bytedance.android.ec.sdk.helper.g r0 = com.bytedance.android.ec.sdk.helper.g.a;
        JSONObject r1 = new JSONObject();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L16
        String r13 = "";
        if (r10 == null) goto L10;
        String r14 = StringsKt.substringBefore(r10, "?", "");     // Catch: Throwable -> L16
        if (r14 == null) goto L10;
        r13 = r14;
    L10:
        r1.putOpt(com.bytedance.android.ec.core.event.a.KEY_URL, r13);     // Catch: Throwable -> L16
        if (r11 == false) goto L13;
        int r15 = 1;
    L14:
        Result.constructor-impl(r1.putOpt("success", Integer.valueOf(r15)));     // Catch: Throwable -> L16
    L18:
        Unit r16 = Unit.INSTANCE;
        r0.logV3("ies_ecommerce_na_prefetch_jsb_monitor", r1);
        return;
    L13:
        r15 = 0;
    L16:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public static void a(String r10, Integer r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L10
        r14.putOpt(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r10);     // Catch: Throwable -> L10
        r14.putOpt(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, r11);     // Catch: Throwable -> L10
        r14.putOpt(com.bytedance.android.ec.core.event.a.KEY_RESULT, 0);     // Catch: Throwable -> L10
        r14.putOpt("api_key", r13);     // Catch: Throwable -> L10
        r14.putOpt("error_message", r12);     // Catch: Throwable -> L10
        int r15 = ECSdk.a;     // Catch: Throwable -> L10
        IECHostService r16 = (IECHostService) ECSdk.a(IECHostService.class);     // Catch: Throwable -> L10
        if (r16 == null) goto L8;
        xi.a r17 = r16.getIECHostLogService();     // Catch: Throwable -> L10
        if (r17 == null) goto L8;
        r17.logV3("ec_na_prefetch", r14);     // Catch: Throwable -> L10
    L8:
        Result.constructor-impl(r14);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
