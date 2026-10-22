package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m1 {
    public static final /* synthetic */ int a = 0;

    static {
        TokenCert.Companion.with("bpea-live_callPhoneMethod_jsb_read_phone_state");
    }

    public static void a(JSONObject r4, CallContext r5, Function1 r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "finishWithFailure");
        Intrinsics.checkNotNullParameter(r7, "finishWithResult");
        Activity r8 = ContextUtil.contextToActivity(r5.getContext());
        Object r1 = null;
        if (r8 != null) goto L6;
        r6.invoke(null);
        return;
    L6:
        Object r2 = r8.getSystemService("phone");
        if ((r2 instanceof TelephonyManager) == false) goto L10;
        r1 = r2;
    L10:
        TelephonyManager r3 = (TelephonyManager) r1;
        if (r3 != null) goto L13;
    L16:
        Intrinsics.checkNotNullParameter(r8, "context");
        boolean r9 = false;
        if (Settings.System.getInt(r8.getContentResolver(), "airplane_mode_on", 0) != 1) goto L19;
        r9 = true;
    L19:
        if (r9 == false) goto L22;
        r6.invoke(new Throwable("please turn off air mode"));
        return;
    L22:
        String r0 = r4.optString("phone_number");
        if (r0 != null) goto L25;
    L27:
        String r11 = r4.optString("phoneNumber");
    L28:
        JSONObject r12 = new JSONObject();
        r12.put("code", 1);
        r12.put("msg", "SUCCESS");
        if (TextUtils.isEmpty(r11) == false) goto L37;
    L35:
        r7.invoke(r12);
        return;
    L37:
        r8.startActivity(new Intent("android.intent.action.DIAL", UriProtector.parse("tel:" + Uri.encode(r11))));     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L25:
        if ((!StringsKt.isBlank(r0)) != true) goto L27;
        r11 = r4.optString("phone_number");
        goto L28
    L13:
        if (1 != r3.getSimState()) goto L16;
        r6.invoke(new Throwable("no sim card"));
    }
}
