package com.bytedance.ies.bullet.web.scc;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.JsonObject;
import com.lynx.tasm.behavior.ui.utils.p;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r9.c;
import ug.d;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function2 f6254c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.a f6255a;

    public b(JsonObject r10, c r11) {
        Intrinsics.checkNotNullParameter(r10, "sccConfig");
        Intrinsics.checkNotNullParameter(r11, "networkDepend");
        i4.a r5 = new i4.a(22);
        this.f6255a = r5;
        if (f6253b == false) goto L5;
    L35:
        d r12 = (d) r5.f17502b;
        monitor-enter(r12);
        vf.b.b(r10, (vf.b) r12.f22357b);     // Catch: Throwable -> L40
        monitor-exit(r12);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L5:
        monitor-enter(b.class);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (f6253b == true) goto L30;
        f6254c = new SccDelegate$1$1(AppLogNewUtils.class.getMethod("onEventV3", new Class[]{String.class, JSONObject.class}));     // Catch: Throwable -> L18
        if (vf.a.a() != null) goto L20;
        com.bytedance.ies.bullet.base.utils.logger.a.g("SccDelegate", "set SccSDK NetAdapter", null, 12);     // Catch: Throwable -> L18
        we.a r13 = new we.a(new o(r11, 4));     // Catch: Throwable -> L18
        monitor-enter(vf.a.class);     // Catch: Throwable -> L18
        vf.a.f22571a = r13;     // Catch: Throwable -> L15
        monitor-exit(vf.a.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L20:
        a r14 = a.f6252a;     // Catch: Throwable -> L18
        monitor-enter(vf.a.class);     // Catch: Throwable -> L18
        vf.a.f22572b = r14;     // Catch: Throwable -> L27
        monitor-exit(vf.a.class);     // Catch: Throwable -> L27
    L25:
        f6253b = true;     // Catch: Throwable -> L18
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L30:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(b.class);
        goto L35
    }

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        String r11 = StringsKt.W(r10, '#');
        d r5 = (d) this.f6255a.f17502b;
        r5.getClass();
        if (TextUtils.isEmpty(r11) == true) goto L34;
        String r12 = p.h(r11);
        Future r13 = (Future) ((ConcurrentHashMap) r5.d).remove(r12);
        if (r13 == null) goto L35;
        yf.b r14 = (yf.b) ((ConcurrentHashMap) r5.g).get(r12);
        if (r14 == null) goto L11;
        r14.d = SystemClock.uptimeMillis();
    L11:
        androidx.constraintlayout.motion.widget.a.A("will wait response, url: ", r12, "scc_sdk");
        monitor-enter(r5);
        int r15 = ((vf.b) r5.f22357b).f22576c;     // Catch: Throwable -> L28
        monitor-exit(r5);     // Catch: Throwable -> L28
    L22:
        e = move-exception;
        Log.w("scc_sdk", "getCloudServiceResponse error:" + Log.getStackTraceString(e));
        if (r14 == null) goto L26;
        r14.b(e.toString(), false);
    L26:
        ((ConcurrentHashMap) r5.g).remove(r12);
        Log.d("scc_sdk", "res json: null");
        return;
    L17:
        if (r13.get(r15, TimeUnit.MILLISECONDS) != null) goto L21;
        if (r14 == null) goto L26;
        r14.b(null, true);     // Catch: Throwable -> L22
        goto L26
    L21:
        throw new ClassCastException();     // Catch: Throwable -> L22
    L28:
        th = move-exception;
        throw th;
    L35:
        return;
    }
}
