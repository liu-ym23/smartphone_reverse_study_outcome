package com.larus.bmhome.chat.model.repo;

import android.util.LruCache;
import com.bytedance.keva.Keva;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ServiceBotNoticeRepo {
    public static final ServiceBotNoticeRepo a = null;
    public static final Lazy b = null;
    public static volatile String c;
    public static volatile FullPermissionSettings d;
    public static final LruCache<String, DetailedPermissionSetting> e = null;

    public static final class a {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L8;
            return false;
        L8:
            ((a) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "LegacyDetailedCacheEntry(version=0, bootTime=0, data=null)";
        }
    }

    public static final class b {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "LegacyFullCacheEntry(version=0, bootTime=0, data=null)";
        }
    }

    public ServiceBotNoticeRepo() {
    }

    static {
        a = new ServiceBotNoticeRepo();
        b = LazyKt.lazy(new f2());
        e = new LruCache(80);
    }

    public static Keva g() {
        return (Keva) b.getValue();
    }

    public static String e(String r2) {
        return AccountService.a.getUserId() + '_' + r2;
    }

    public static FullPermissionSettings f(String r1) {
        Intrinsics.checkNotNullParameter(r1, "botId");
        String r2 = e(r1);
        if (Intrinsics.areEqual(c, r2) == false) goto L7;
        FullPermissionSettings r0 = d;
        if (r0 == null) goto L7;
        return r0;
    L7:
        FullPermissionSettings r3 = h(r2);
        if (r3 == null) goto L10;
        c = r2;
        d = r3;
        return r3;
    L10:
        return null;
    }

    public static FullPermissionSettings h(String r7) {
        FLogger.a.i("ServiceBotNoticeRepo", "readFullCacheFromKeva key: " + r7);
        String r0 = g().getString(r7, null);
        if (r0 != null) goto L32;
        return null;
    L32:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        return (FullPermissionSettings) HttpExtKt.f.fromJson(r0, FullPermissionSettings.class);
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        ((b) HttpExtKt.f.fromJson(r0, b.class)).getClass();     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(null);     // Catch: Throwable -> L11
    L13:
        Throwable r5 = Result.exceptionOrNull-impl(r1);
        if (r5 == null) goto L17;
        a.getClass();
        g().erase(r7);
        FLogger.a.e("ServiceBotNoticeRepo", "readFullCacheFromKeva fail: " + r5);
    L17:
        if (Result.isFailure-impl(r1) == false) goto L19;
        r1 = null;
    L19:
        FullPermissionSettings r2 = (FullPermissionSettings) r1;
        if (r2 != null) goto L30;
        return null;
    L30:
        a.getClass();     // Catch: Throwable -> L24
        g().storeString(r7, HttpExtKt.f.toJson(r2));     // Catch: Throwable -> L24
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L27:
        return r2;
    L24:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static String b(String r2, String r3) {
        return AccountService.a.getUserId() + '_' + r2 + '_' + r3;
    }

    public static Object d(String r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ServiceBotNoticeRepo$fetchFullPermissionSetting$2(r3, null), r4);
    }

    public static void i(String r3, FullPermissionSettings r4) {
        String r5 = e(r3);
        c = r5;
        d = r4;
        FLogger.a.i("ServiceBotNoticeRepo", "saveFullCache " + r5);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        g().storeString(r5, HttpExtKt.f.toJson(r4));     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L13;
        FLogger.a.e("ServiceBotNoticeRepo", "saveFullCache fail: " + r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static Object c(String r3, String r4, Continuation r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ServiceBotNoticeRepo$fetchDetailedPermissionSetting$2(r3, r4, null), r5);
    }

    public static final void a(ServiceBotNoticeRepo r1, String r2, String r3, DetailedPermissionSetting r4) {
        r1.getClass();
        String r5 = b(r2, r3);
        FLogger.a.i("ServiceBotNoticeRepo", "saveDetailedCache " + r5);
        e.put(r5, r4);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        g().storeString(r5, HttpExtKt.f.toJson(r4));     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L13;
        FLogger.a.e("ServiceBotNoticeRepo", "saveDetailedCache fail: " + r8);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static Object j(String r3, String r4, List r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ServiceBotNoticeRepo$updateDetailedPermissionSetting$2(r3, r4, r5, null), r6);
    }
}
