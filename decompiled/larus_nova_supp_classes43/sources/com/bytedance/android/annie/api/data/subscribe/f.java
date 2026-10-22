package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class f<T> {
    public static c e(g r10) {
        Object r0 = r10.g();
        if ((r0 instanceof JsonElement) == false) goto L5;
        JsonElement r11 = (JsonElement) r0;
    L7:
        return new c(r10, r0, r11);
    L5:
        r11 = d.b(r0);
        goto L7
    }

    public static JsonElement a(g r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Object r0 = r10.g();
        if (r0 == null) goto L16;
        if ((r0 instanceof JsonElement) == false) goto L7;
        JsonElement r1 = (JsonElement) r0;
    L8:
        if (r1 == null) goto L16;
        if (r1.isJsonObject() == true) goto L14;
        return r1;
    L14:
        return r10.f(r11, r1);
    L7:
        r1 = d.b(r0);
    L16:
        return new JsonObject();
    }

    public static JsonObject d(List r10, JsonElement r11) {
        Intrinsics.checkNotNullParameter(r10, "paths");
        Intrinsics.checkNotNullParameter(r11, "element");
        JsonObject r0 = new JsonObject();
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = r0;
        Iterator<T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L17;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r16 = (String) r14;
        if ((r11 instanceof JsonObject) == false) goto L11;
        r11 = r11.getAsJsonObject().get(r16);
    L13:
        if (r13 != (r10.size() - 1)) goto L15;
        ((JsonObject) r1.element).getAsJsonObject().add(r16, r11);
    L16:
        r13 = r15;
        goto L4
    L15:
        JsonObject r17 = new JsonObject();
        ((JsonObject) r1.element).getAsJsonObject().add(r16, r17);
        r1.element = r17;
        goto L16
    L11:
        r11 = JsonNull.INSTANCE;
        goto L13
    L17:
        return r0;
    }

    public static JsonElement b(g r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        return r1.a(r10);
    }

    public static JsonElement c(g r10, String r11, JsonElement r12) {
        Intrinsics.checkNotNullParameter(r11, "keyParam");
        Intrinsics.checkNotNullParameter(r12, "element");
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return r12;
    L9:
        return r10.h(StringsKt.split$default(r11, new char[]{r10.d()}, false, 0, 6, null), r12);
    L5:
        r0 = false;
        goto L6
    }
}
