package com.bytedance.android.livesdk.gift.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/PageExtraWrapperJsonAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/android/livesdk/gift/model/PageExtraWapper;", "Lcom/google/gson/JsonSerializer;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class PageExtraWrapperJsonAdapter implements JsonDeserializer<PageExtraWapper>, JsonSerializer<PageExtraWapper> {
    public PageExtraWrapperJsonAdapter() {
    }

    public final Object deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, "typeOfT");
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r6 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(new PageExtraWapper((w2) r5.deserialize(r3, w2.class), null, r3.getAsJsonObject()));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r7) == true) goto L12;
        r6 = r7;
    L12:
        return (PageExtraWapper) r6;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final JsonElement serialize(Object r2, Type r3, JsonSerializationContext r4) {
        PageExtraWapper r5 = (PageExtraWapper) r2;
        Intrinsics.checkNotNullParameter(r5, "src");
        Intrinsics.checkNotNullParameter(r3, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r4, "context");
        JsonObject r6 = r5.getRawJson();
        if (r6 == null) goto L6;
        return r6;
    L6:
        return r4.serialize(r5.getDecoded());
    }
}
