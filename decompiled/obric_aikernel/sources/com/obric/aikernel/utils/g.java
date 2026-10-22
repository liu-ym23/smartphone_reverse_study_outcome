package com.obric.aikernel.utils;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.gson.d f5593a = null;

    static {
        f5593a = new com.google.gson.d();
    }

    public static final com.google.gson.d a() {
        return f5593a;
    }

    public static final JSONObject b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new JSONObject(r10);
    L5:
        return null;
    }
}
