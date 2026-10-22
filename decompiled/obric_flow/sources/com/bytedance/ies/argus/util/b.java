package com.bytedance.ies.argus.util;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f5173a = null;

    static {
        f5173a = LazyKt.lazy(ArgusGsonUtils$gsonObjExcludeProperty$2.f5167a);
    }

    public static JSONObject a(Object r5) {
        Gson r10 = (Gson) f5173a.getValue();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new JSONObject(r10.toJson(r5));
    L6:
        return new JSONObject();
    }
}
