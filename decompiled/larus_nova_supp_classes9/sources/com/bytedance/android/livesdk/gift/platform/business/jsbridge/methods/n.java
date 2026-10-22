package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n<V> implements Callable {
    public final /* synthetic */ JSONObject a;

    public n(JSONObject r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final Pair<g0, JsonObject> call() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(JSONObjectProtectorUtils.getString(this.a, "gift_extra"));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        Object r3 = Result.constructor-impl((JsonObject) GsonHelper.get().fromJson(r2, JsonObject.class));     // Catch: Throwable -> L12
    L14:
        ResultKt.throwOnFailure(r3);
        JsonObject r4 = (JsonObject) r3;
        Object r5 = Result.constructor-impl((g0) GsonHelper.get().fromJson(r2, g0.class));     // Catch: Throwable -> L17
    L19:
        ResultKt.throwOnFailure(r5);
        return new Pair((g0) r5, r4);
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
