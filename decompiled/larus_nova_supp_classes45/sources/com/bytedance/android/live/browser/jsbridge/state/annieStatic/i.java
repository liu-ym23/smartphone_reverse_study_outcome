package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.prefetch.p;
import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public i() {
    }

    public final /* synthetic */ com.bytedance.android.annie.api.data.subscribe.g c() {
        return com.bytedance.android.annie.api.data.subscribe.f.e(this);
    }

    public final /* synthetic */ char d() {
        return '.';
    }

    public final /* synthetic */ JsonElement e(String r1, String r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.b(this, r1, r2);
    }

    public final /* synthetic */ JsonElement f(String r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r1, r2);
    }

    public final /* bridge */ /* synthetic */ Object g() {
        return null;
    }

    public final /* synthetic */ JsonElement h(List r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r1, r2);
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.h r0 = com.bytedance.android.live.browser.jsbridge.i.g.h.b;
        return "prefetch";
    }

    public final JsonElement a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        return GsonHelper.parser().parse(String.valueOf(Annie.getService(p.class, "webcast").getCacheJsonByScheme(r4)));
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return JsonNull.INSTANCE;
    }
}
