package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class f {
    private String a;
    private String b;

    /* JADX INFO: renamed from: com.tencent.open.utils.f$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {
        private static f a;

        static {
            a = new f(null);
        }

        public static /* synthetic */ f a() {
            return a;
        }
    }

    private f() {
        this.a = BuildConfig.FLAVOR;
        this.b = BuildConfig.FLAVOR;
    }

    public static f a() {
        return a.a();
    }

    public String b() {
        return this.b;
    }

    public /* synthetic */ f(AnonymousClass1 r1) {
        this();
    }

    public void a(Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        SharedPreferences r4 = r3.getSharedPreferences("device_info_file", 0);
        String r0 = this.b;
        if (r0 != null) goto L7;
    L8:
        this.b = r4.getString("build_model", BuildConfig.FLAVOR);
    L9:
        String r1 = this.a;
        if (r1 != null) goto L12;
    L13:
        this.a = r4.getString("build_device", BuildConfig.FLAVOR);
        return;
    L12:
        if (r1.trim().isEmpty() == true) goto L13;
        return;
    L7:
        if (r0.trim().isEmpty() == false) goto L9;
        goto L8
    }

    public String b(Context r1) {
        return this.a;
    }

    public String c(Context r1) {
        return this.b;
    }

    public void a(Context r5, String r6) {
        if (r6 != null) goto L5;
    L15:
        this.b = BuildConfig.FLAVOR;
        if (r5 == null) goto L21;
        r5.getSharedPreferences("device_info_file", 0).edit().remove("build_model").apply();
        return;
    L21:
        return;
    L5:
        if (r6.trim().isEmpty() == true) goto L15;
        String r3 = this.b;
        if (r3 != null) goto L10;
    L12:
        this.b = r6;
        if (r5 == null) goto L19;
        r5.getSharedPreferences("device_info_file", 0).edit().putString("build_model", this.b).apply();
        return;
    L19:
        return;
    L10:
        if (r3.equals(r6) == false) goto L12;
    }
}
