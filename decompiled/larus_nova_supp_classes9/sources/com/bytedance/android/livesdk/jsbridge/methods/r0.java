package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "fetchClipBoard")
public final class r0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final TokenCert a;

    public final void onTerminate() {
    }

    public r0() {
        this.a = TokenCert.Companion.with("bpea-bpea-live_fetchClipBoard_jsb_fetch_clip_board");
    }

    public final void invoke(Object r5, CallContext r6) {
        JSONObject r7 = (JSONObject) r5;
        String r0 = BuildConfig.FLAVOR;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r8 = r7.optString("token", BuildConfig.FLAVOR);     // Catch: Exception -> L28
        if (r8 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        TokenCert r9 = this.a;     // Catch: Exception -> L28
    L13:
        Context r10 = r6.getContext();     // Catch: Exception -> L28
        Object r3 = r10.getSystemService("clipboard");     // Catch: Exception -> L28
        if (r3 == null) goto L27;
        ClipboardManager r4 = (ClipboardManager) r3;     // Catch: Exception -> L28
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L28
        ClipData r13 = g80.d.b(r9);     // Catch: Exception -> L28
        if (r13 == null) goto L25;
        ClipData.Item r14 = r13.getItemAt(0);     // Catch: Exception -> L28
        if (r14 == null) goto L25;
        CharSequence r15 = r14.coerceToText(r10);     // Catch: Exception -> L28
        if (r15 == null) goto L25;
        String r16 = r15.toString();     // Catch: Exception -> L28
        if (r16 == null) goto L25;
        r0 = r16;
    L25:
        r11.put("content", r0);     // Catch: Exception -> L28
        Unit r17 = Unit.INSTANCE;     // Catch: Exception -> L28
        finishWithResult(r11);     // Catch: Exception -> L28
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Exception -> L28
    L12:
        r9 = TokenCert.Companion.with(r8);     // Catch: Exception -> L28
        goto L13
    L6:
        if (StringsKt.isBlank(r8) == true) goto L9;
        r2 = false;
    L28:
        e = move-exception;
        e.printStackTrace();
        finishWithFailure(e);
    }
}
