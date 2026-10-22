package com.bytedance.android.ec.core.monitor;

import android.util.Log;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECExceptionMonitor {
    public static final /* synthetic */ int a = 0;

    public static final class a<V> implements Callable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            return this.a.invoke();
        L4:
            th = move-exception;
            return Integer.valueOf(Log.e("ECExceptionMonitor", "post exception monitor failed:", th));
        }
    }

    public ECExceptionMonitor() {
    }

    public static final boolean a() {
        if (com.bytedance.android.ec.core.opt.ab.t.a() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    static {
    }

    public static void b(Function0 r1) {
        Single.fromCallable(new a(r1)).subscribeOn(Schedulers.io()).subscribe();
    }

    @JvmStatic
    public static final void c(final String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        boolean r1 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r1 = false;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.isDebug() == false) goto L11;
    L13:
        cl.d r11 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r11 == null) goto L18;
        cl.d.b.a(r11, "EC_CATCH_EXCEPTION", "[电商]发生异常： " + r10 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, null, ErrorType.WARING, 12);
        return;
    L18:
        return;
    L11:
        if (r0.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHere$1(r10));
    }

    @JvmStatic
    public static final void e(final Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, "throwable");
        boolean r11 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L7;
        r11 = false;
    L7:
        if (r11 == true) goto L9;
        return;
    L9:
        ECAppInfoService r1 = ECAppInfoService.e;     // Catch: Throwable -> L22
        if (r1.isDebug() == false) goto L12;
    L14:
        cl.d r12 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L22
        if (r12 == null) goto L17;
        cl.d.b.a(r12, "EC_CATCH_EXCEPTION", "[电商]catch住错误 " + r10 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, r10, ErrorType.WARING, 4);     // Catch: Throwable -> L22
    L17:
        cl.d r0 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L22
        if (r0 == null) goto L20;
        r0.l();     // Catch: Throwable -> L22
    L20:
        r10.printStackTrace();     // Catch: Throwable -> L22
        return;
    L12:
        if (r1.isLocalTest() == true) goto L14;
        b(new ECExceptionMonitor$ensureNotReachHere$2(r10));     // Catch: Throwable -> L22
        return;
    }

    @JvmStatic
    public static final void g(final String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        boolean r1 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r1 = false;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.isDebug() == false) goto L11;
    L13:
        cl.d r11 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r11 == null) goto L18;
        cl.d.b.a(r11, "EC_CATCH_EXCEPTION", "[电商]发生异常： " + r10 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, null, ErrorType.WARING, 12);
        return;
    L18:
        return;
    L11:
        if (r0.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHereDetail$1(r10));
    }

    public static void h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "content");
        cl.d r1 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r1 == null) goto L6;
        cl.d.b.a(r1, "EC_TIP", r10, null, null, null, 28);
        return;
    }

    @JvmStatic
    public static final void f(final Throwable r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "throwable");
        Intrinsics.checkNotNullParameter(r11, MessageIndication.MESSAGE_TYPE_MSG);
        boolean r1 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r1 = false;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.isDebug() == false) goto L11;
    L13:
        cl.d r12 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r12 == null) goto L16;
        cl.d.b.a(r12, "EC_CATCH_EXCEPTION", "[电商]catch住错误 " + r11 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, r10, ErrorType.WARING, 4);
    L16:
        cl.d r13 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r13 == null) goto L19;
        r13.l();
    L19:
        r10.printStackTrace();
        return;
    L11:
        if (r0.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHere$3(r10, r11));
    }

    @JvmStatic
    public static final void d(final String r10, final Throwable r11, final String r12) {
        Intrinsics.checkNotNullParameter(r10, "logType");
        Intrinsics.checkNotNullParameter(r11, "throwable");
        Intrinsics.checkNotNullParameter(r12, MessageIndication.MESSAGE_TYPE_MSG);
        boolean r1 = true;
        if (com.bytedance.android.ec.core.opt.ab.t.a() >= 1) goto L6;
        r1 = false;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.isDebug() == false) goto L11;
    L13:
        cl.d r13 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r13 == null) goto L16;
        cl.d.b.a(r13, "EC_CATCH_EXCEPTION", "[电商]catch住错误 " + r12 + "，请排查一下问题，若误报或有任何问题可联系相应的电商研发同学", null, r11, ErrorType.WARING, 4);
    L16:
        cl.d r14 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r14 == null) goto L21;
        r14.l();
        return;
    L21:
        return;
    L11:
        if (r0.isLocalTest() == true) goto L13;
        b(new ECExceptionMonitor$ensureNotReachHere$4(r10, r11, r12));
    }
}
