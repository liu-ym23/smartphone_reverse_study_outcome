package com.bytedance.ai.applet.base.gson;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new d());
    }

    public static String c(Object r1) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        return GsonProtectorUtils.toJson(c.a(), r1);
    }

    public static JsonObject d(Object r1) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        return GsonProtectorUtils.toJsonTree(c.a(), r1).getAsJsonObject();
    }

    public static Object a(String r1, Class r10) throws JsonSyntaxException {
        return GsonProtectorUtils.fromJson(c.a(), r1, r10);
    }

    public static Object b(String r1, Type r10) throws JsonSyntaxException {
        Intrinsics.checkNotNullParameter(r10, "typeOfT");
        return GsonProtectorUtils.fromJson(c.a(), r1, r10);
    }
}
