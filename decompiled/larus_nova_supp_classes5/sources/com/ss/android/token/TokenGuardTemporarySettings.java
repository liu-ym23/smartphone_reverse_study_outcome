package com.ss.android.token;

import android.content.Context;
import com.ss.android.account.k;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tb7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TokenGuardTemporarySettings {
    public static final /* synthetic */ KProperty[] a = null;
    public static final Lazy b = null;
    public static final TokenGuardTemporarySettings c = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TokenGuardTemporarySettings.class), "storage", "getStorage()Lcom/ss/android/token/TokenGuardTemporarySettings$Storage;"))};
        c = new TokenGuardTemporarySettings();
        b = LazyKt.lazy(TokenGuardTemporarySettings$storage$2.INSTANCE);
    }

    public TokenGuardTemporarySettings() {
    }

    public static a d() throws IllegalStateException {
        Lazy r0 = b;
        KProperty r1 = a[0];
        return (a) r0.getValue();
    }

    public static boolean c() throws IllegalStateException {
        String r0 = com.bytedance.sdk.account.ticketguard.f.g;
        if (d().a != null) goto L5;
    L9:
        a r1 = d();
        r1.getClass();
        a.d("TokenGuardTemporarySettings", "resetAllTemporarySettings, oldVersion: " + r1.a + ", newVersion: " + r0);
        Object r3 = r1.c;
        monitor-enter(r3);
        r1.a = r0;     // Catch: Throwable -> L14
        r1.b.clear();     // Catch: Throwable -> L14
        r1.a();     // Catch: Throwable -> L14
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r3);
        return true;
    L14:
        th = move-exception;
        throw th;
    L5:
        if ((!Intrinsics.areEqual(r0, d().a)) == true) goto L9;
        return false;
    }

    private final Context getContext() {
        wqa.f r0 = k.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getApplicationContext();
    }

    public static final /* synthetic */ Context a(TokenGuardTemporarySettings r0) {
        return r0.getContext();
    }

    public static void b(Collection r4) {
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.m == true) goto L16;
        return;
    L16:
        a r1 = d();     // Catch: IllegalStateException -> L13
        Object r2 = r1.c;     // Catch: IllegalStateException -> L13
        monitor-enter(r2);     // Catch: IllegalStateException -> L13
        r1.b.addAll(r4);     // Catch: Throwable -> L10
        r1.a();     // Catch: Throwable -> L10
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: IllegalStateException -> L13
        a.d("TokenGuardTemporarySettings", "Paths added to temporary settings: " + r4 + ", config_version: " + d().a);     // Catch: IllegalStateException -> L13
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: IllegalStateException -> L13
    L13:
        e = move-exception;
        a.c("TokenGuardTemporarySettings", "Context is null when adding paths", e);
    }

    public static boolean e(String r5) {
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.m == true) goto L15;
        return false;
    L15:
    L12:
        e = move-exception;
        a.c("TokenGuardTemporarySettings", "Context is null", e);
        return false;
    L6:
        if (c() == false) goto L8;
        return false;
    L8:
        boolean r2 = d().b.contains(r5);     // Catch: IllegalStateException -> L12
        if (r2 == false) goto L11;
        a.d("TokenGuardTemporarySettings", "path is in temporary settings: " + r5 + ", config_version: " + d().a);     // Catch: IllegalStateException -> L12
    L11:
        return r2;
    }

    public static void f(String r2, String r3, String r4, boolean r5) {
        TTTokenMonitor.r("token_guard_update_fallback_config", d0.b(new Pair[]{TuplesKt.to(DownloadConstants.PATH_KEY, r2), TuplesKt.to("remote_error", r3), TuplesKt.to("logid", r4), TuplesKt.to("has_consumer_content", Integer.valueOf(r5 ? 1 : 0)), TuplesKt.to("token_config_version", com.bytedance.sdk.account.ticketguard.f.g)}));
    }

    public static void g(String r2, String r3, String r4, boolean r5) {
        TTTokenMonitor.r("token_guard_use_fallback_config_fail", d0.b(new Pair[]{TuplesKt.to(DownloadConstants.PATH_KEY, r2), TuplesKt.to("remote_error", r3), TuplesKt.to("logid", r4), TuplesKt.to("has_consumer_content", Integer.valueOf(r5 ? 1 : 0)), TuplesKt.to("token_config_version", com.bytedance.sdk.account.ticketguard.f.g)}));
    }
}
