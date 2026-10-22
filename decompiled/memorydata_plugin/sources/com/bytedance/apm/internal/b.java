package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm.core.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f1387a;

    /* JADX INFO: renamed from: com.bytedance.apm.internal.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f1388a = null;

        static {
            f1388a = new b(null);
        }

        static /* synthetic */ b a() {
            return f1388a;
        }
    }

    private b() {
        this.f1387a = e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "monitor_config");
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    public static b a() {
        return a.a();
    }

    public String a(String r2) {
        return this.f1387a.getString(r2, null);
    }

    public void a(String r1, int r2) {
        this.f1387a.edit().putInt(r1, r2).apply();
    }

    public void a(String r1, String r2) {
        this.f1387a.edit().putString(r1, r2).apply();
    }

    public int b(String r2) {
        return this.f1387a.getInt(r2, -1);
    }
}
