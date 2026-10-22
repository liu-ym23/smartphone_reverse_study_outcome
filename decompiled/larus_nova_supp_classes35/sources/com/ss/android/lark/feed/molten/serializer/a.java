package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final <E extends Enum<E>> E d(Class<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "enumClass");
        return (E) ArraysKt.first(r1.getEnumConstants());
    }

    public static final Boolean c(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L9;
        return null;
    L9:
        return Boolean.valueOf(r3.getAsBoolean());
    }

    public static final Integer e(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L9;
        return null;
    L9:
        return Integer.valueOf(r3.getAsInt());
    }

    public static final Long f(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L9;
        return null;
    L9:
        return Long.valueOf(r3.getAsLong());
    }

    public static final String l(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonNull() == false) goto L9;
        return null;
    L9:
        return r3.getAsString();
    }

    public static final <T> List<T> b(JsonObject r1, String r2, TypeAdapter<List<T>> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r3, "adapter");
        JsonElement r4 = r1.get(r2);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isJsonNull() == false) goto L9;
        return null;
    L9:
        return (List) r3.fromJsonTree(r4);
    }

    public static final void g(JsonObject r1, String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        if (r3 == null) goto L5;
        JsonPrimitive r0 = new JsonPrimitive(r3);
    L6:
        r1.add(r2, r0);
        return;
    L5:
        r0 = JsonNull.INSTANCE;
        goto L6
    }

    public static final void h(JsonObject r1, String r2, Number r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        if (r3 == null) goto L5;
        JsonPrimitive r0 = new JsonPrimitive(r3);
    L6:
        r1.add(r2, r0);
        return;
    L5:
        r0 = JsonNull.INSTANCE;
        goto L6
    }

    public static final void j(JsonObject r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        if (r3 == null) goto L5;
        JsonPrimitive r0 = new JsonPrimitive(r3);
    L6:
        r1.add(r2, r0);
        return;
    L5:
        r0 = JsonNull.INSTANCE;
        goto L6
    }

    public static final <T> T k(JsonObject r1, String r2, TypeAdapter<T> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r3, "adapter");
        JsonElement r4 = r1.get(r2);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isJsonNull() == false) goto L9;
        return null;
    L9:
        return (T) r3.fromJsonTree(r4);
    }

    public static final <T> void a(JsonObject r1, String r2, List<? extends T> r3, TypeAdapter<List<T>> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r4, "adapter");
        if (r3 != null) goto L5;
        JsonNull r5 = JsonNull.INSTANCE;
    L6:
        r1.add(r2, r5);
        return;
    L5:
        r5 = r4.toJsonTree(r3);
        goto L6
    }

    public static final <T> void i(JsonObject r1, String r2, T r3, TypeAdapter<T> r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r4, "adapter");
        if (r3 != null) goto L5;
        JsonNull r5 = JsonNull.INSTANCE;
    L6:
        r1.add(r2, r5);
        return;
    L5:
        r5 = r4.toJsonTree(r3);
        goto L6
    }
}
