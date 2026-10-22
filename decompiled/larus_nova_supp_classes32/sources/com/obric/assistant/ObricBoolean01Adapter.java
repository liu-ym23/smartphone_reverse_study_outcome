package com.obric.assistant;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/ObricBoolean01Adapter;", "Lcom/google/gson/JsonDeserializer;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Boolean;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricBoolean01Adapter implements JsonDeserializer<Boolean> {
    public ObricBoolean01Adapter() {
    }

    public Boolean deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        if (r2 == null) goto L38;
        if (r2.isJsonNull() == true) goto L38;
        if (r2.isJsonPrimitive() == false) goto L9;
        JsonPrimitive r5 = r2.getAsJsonPrimitive();
        if (r5.isBoolean() == false) goto L13;
        boolean r6 = r5.getAsBoolean();
    L36:
        return Boolean.valueOf(r6);
    L13:
        boolean r7 = true;
        if (r5.isNumber() == false) goto L28;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L21
        if (r5.getAsInt() != 0) goto L19;
        r7 = false;
    L19:
        Object r9 = Result.constructor-impl(Boolean.valueOf(r7));     // Catch: Throwable -> L21
    L23:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r9) == false) goto L26;
        r9 = r10;
    L26:
        r6 = ((Boolean) r9).booleanValue();
    L21:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L28:
        if (r5.isString() == false) goto L34;
        String r12 = StringsKt.trim(r5.getAsString()).toString().toLowerCase(Locale.ROOT);
        if (Intrinsics.areEqual(r12, "1") == false) goto L32;
    L33:
        r6 = true;
        goto L36
    L32:
        if (Intrinsics.areEqual(r12, "true") == true) goto L33;
    L34:
        r6 = false;
        goto L36
    L9:
        return Boolean.FALSE;
    L38:
        return Boolean.FALSE;
    }

    /* JADX INFO: renamed from: deserialize, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m407deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) {
        return deserialize(r1, r2, r3);
    }
}
