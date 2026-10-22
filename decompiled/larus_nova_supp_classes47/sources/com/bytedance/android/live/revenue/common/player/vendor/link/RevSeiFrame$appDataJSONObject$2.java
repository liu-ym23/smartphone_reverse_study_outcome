package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$appDataJSONObject$2 extends FunctionReferenceImpl implements Function0<JSONObject> {
    public RevSeiFrame$appDataJSONObject$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseAppDataJson", "parseAppDataJson()Lorg/json/JSONObject;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final JSONObject m368invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        JSONObject r4 = (JSONObject) r0.b.getValue();     // Catch: Throwable -> L11
        if (r4 != null) goto L6;
    L8:
        JSONObject r5 = null;
    L9:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r6) == true) goto L18;
        r2 = r6;
    L18:
        return (JSONObject) r2;
    L6:
        if (r4.has("app_data") != true) goto L8;
        r5 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r4, "app_data"), ""));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m368invoke();
    }
}
