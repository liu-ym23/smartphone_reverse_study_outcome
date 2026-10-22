package com.bytedance.apm.launch;

import android.content.Intent;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1422a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1423b = false;
    private static boolean c = false;
    private static String d = "";
    private static String e = "";
    private static Intent f;
    private static long g;
    private static long h;

    static {
    }

    static /* synthetic */ long a(long r0) {
        g = r0;
        return r0;
    }

    static /* synthetic */ String a(String r0) {
        d = r0;
        return r0;
    }

    public static void a() {
        f = f.a();
        ActivityLifeObserver.getInstance().register(new AnonymousClass1());
    }

    static /* synthetic */ boolean a(boolean r0) {
        f1422a = r0;
        return r0;
    }

    static /* synthetic */ long b(long r0) {
        h = r0;
        return r0;
    }

    static /* synthetic */ String b(String r0) {
        e = r0;
        return r0;
    }

    static /* synthetic */ boolean b(boolean r0) {
        c = r0;
        return r0;
    }

    static /* synthetic */ boolean c(boolean r0) {
        f1423b = r0;
        return r0;
    }
}
