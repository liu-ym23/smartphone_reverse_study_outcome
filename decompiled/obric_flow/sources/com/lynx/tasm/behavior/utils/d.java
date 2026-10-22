package com.lynx.tasm.behavior.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.keva.Keva;
import com.lynx.tasm.ui.image.v;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f10792a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static uj.a f10793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10794c;
    public static File d;
    public static File e;

    public static final String a() {
        String r5 = UUID.randomUUID().toString();
        if (com.bytedance.ies.bullet.core.h.g.f5315a == false) goto L6;
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.f(r5, "create sessionId. just print for local_test, take it easy = ", "XRouter", new Throwable(), LogLevel.f5955c);
        return r5;
    L6:
        com.bytedance.ies.bullet.service.base.b.b(8, r5, "create sessionId.", "XRouter");
        return r5;
    }

    public static final String b(Uri r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "url");
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r10 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r10 == null) goto L9;
        xc.d r11 = (xc.d) r10.a(xc.d.class);
        if (r11 == null) goto L9;
        Boolean r14 = r11.S();
        if (r14 == null) goto L9;
        boolean r15 = r14.booleanValue();
    L10:
        if (r15 == false) goto L39;
        String r16 = m.f(r12, "__x_session_id");
        if (r16 != null) goto L16;
        if (r13 == null) goto L15;
        r16 = r13.getString("__x_session_id");
        goto L16
    L15:
        r16 = null;
    L16:
        if (r16 != null) goto L18;
    L21:
        boolean r17 = true;
    L22:
        if (r17 == false) goto L37;
        String r18 = r12.getQueryParameter("__bullet_trident_starter_session_id");
        String r19 = r12.getQueryParameter("__bullet_trident_call_id");
        m.n(r12, "__bullet_trident_starter_session_id");
        String r110 = a();
        if (com.lynx.tasm.utils.k.o(r18) == false) goto L33;
        int r20 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r21 = new com.bytedance.ies.bullet.base.utils.logger.b();
        if (r19 != null) goto L28;
        r19 = "";
    L28:
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r19, "sessionId");
        ArrayList r111 = r21.f5260a;
        r111.add(new com.bytedance.ies.bullet.base.utils.logger.c("callId", r19));
        Intrinsics.checkNotNullParameter("sessionId", "name");
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        r111.add(new com.bytedance.ies.bullet.base.utils.logger.c("sessionId", r110));
        if (r18 != null) goto L31;
        r18 = "";
    L31:
        Intrinsics.checkNotNullParameter("originSessionId", "name");
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("originSessionId", r18, r111);
        Unit r22 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("associated session", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "associated session", null, r21);
    L33:
        if (xq.b.c() == true) goto L36;
        if (r13 == null) goto L36;
        r13.putString("__x_session_id", r110);
    L36:
        return r110;
    L37:
        return r16;
    L18:
        if (r16.length() == 0) goto L21;
        r17 = false;
        goto L22
    L39:
        return h(r12, r13);
    L9:
        r15 = true;
        goto L10
    }

    public static String c(String r5, String r10, String r11) {
        String r12 = r5 + r10;
        Intrinsics.checkNotNullParameter(r11, "tag");
        return r12;
    }

    public static void d() {
        Keva r5 = com.bytedance.iesgurd.meta.e.f6649a;
        GeckoLogger.a("ChannelMetaManager removeAll");
        Iterator r10 = CollectionsKt.toList(com.bytedance.iesgurd.meta.e.f6651c.keySet()).iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        String r11 = (String) r10.next();
        GeckoLogger.a("ChannelMetaManager removeAccessKey " + r11);
        ConcurrentHashMap r12 = com.bytedance.iesgurd.meta.e.f6651c;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12.get(r11);
        if (r13 == null) goto L4;
        Iterator r14 = r13.keySet().iterator();
    L9:
        if (r14.hasNext() == false) goto L14;
        String r15 = (String) r14.next();
        Keva r16 = com.bytedance.iesgurd.meta.e.f6649a;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L13:
        r16.erase(r11 + '@' + r15);
        goto L9
    L14:
        r12.remove(r11);
        goto L4
    L15:
        Iterator r17 = df.c.d.values().iterator();
    L17:
        if (r17.hasNext() == false) goto L19;
        f(new File((String) r17.next()));
        goto L17
    L19:
        i();
    }

    public static void e(int r5, Context r10) {
        if (r10 == null) goto L30;
        if (r5 > 0) goto L5;
        return;
    L5:
        if (r5 <= 3) goto L8;
        return;
    L8:
        if (Logger.debug() == false) goto L11;
        Logger.d("WsChannelSdk", com.lynx.jsbridge.a.d(r5, "sendAppState appState = "));
    L11:
        if (((c5.a) g8.g.d(r10).f17073b).b(WsConstants.KEY_FRONTIER_ENABLED, true) == false) goto L33;
        Message r11 = new Message();
        r11.what = 2;
        r11.arg1 = r5;
        if (f4.b.f16878a == null) goto L16;
    L26:
        s8.a r12 = f4.b.f16878a;
        r12.getClass();
        int r13 = 27;
        v r14 = new v(r13, r12, Message.obtain(r11));
        r12.f21835a.post(r14);
        return;
    L16:
        monitor-enter(s8.a.class);
    L20:
        th = move-exception;
        throw th;
    L18:
        if (f4.b.f16878a != null) goto L22;
        f4.b.f16878a = f4.b.c(r10);     // Catch: Throwable -> L20
    L22:
        monitor-exit(s8.a.class);     // Catch: Throwable -> L20
        goto L26
    L33:
        return;
    }

    public static boolean f(File r5) {
        if (f10794c == true) goto L5;
        return false;
    L5:
        File r10 = e;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L9:
        if (r10.exists() == true) goto L16;
        File r11 = e;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L14:
        if (r11.mkdirs() == true) goto L16;
        return false;
    L16:
        String r12 = r5.getName() + '_' + System.currentTimeMillis();
        File r13 = e;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L20:
        return r5.renameTo(new File(r13, r12));
    }

    public static boolean g(String r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.length() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static final String h(Uri r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "url");
        if (r12 == null) goto L5;
        String r5 = r12.getString("__x_session_id");
    L6:
        if (r5 != null) goto L8;
    L11:
        String r10 = r11.getQueryParameter("__bullet_trident_starter_session_id");
        String r13 = r11.getQueryParameter("__bullet_trident_call_id");
        m.n(r11, "__bullet_trident_starter_session_id");
        String r14 = a();
        if (com.lynx.tasm.utils.k.o(r10) == false) goto L21;
        int r15 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.b r16 = new com.bytedance.ies.bullet.base.utils.logger.b();
        if (r13 != null) goto L16;
        r13 = "";
    L16:
        Intrinsics.checkNotNullParameter("callId", "name");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        ArrayList r17 = r16.f5260a;
        r17.add(new com.bytedance.ies.bullet.base.utils.logger.c("callId", r13));
        Intrinsics.checkNotNullParameter("sessionId", "name");
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        r17.add(new com.bytedance.ies.bullet.base.utils.logger.c("sessionId", r14));
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        Intrinsics.checkNotNullParameter("originSessionId", "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        androidx.room.jarjarred.org.antlr.runtime.a.B("originSessionId", r10, r17);
        Unit r18 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("XRouter", "moduleTag");
        Intrinsics.checkNotNullParameter("associated session", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XRouter", "associated session", null, r16);
    L21:
        if (xq.b.c() == true) goto L24;
        if (r12 == null) goto L24;
        r12.putString("__x_session_id", r14);
    L24:
        return r14;
    L8:
        if (r5.length() == 0) goto L11;
        return r5;
    L5:
        r5 = null;
        goto L6
    }

    public static void i() {
        if (f10794c == false) goto L13;
        File r5 = e;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("filePendingDelete");
    L9:
        if (r5.exists() == true) goto L11;
        return;
    L11:
        ((Executor) com.bytedance.geckox.utils.c.f.getValue()).execute(df.a.f16643a);
        return;
    }

    public static boolean j(boolean r5, boolean r10, io.reactivex.observers.d r11, rt.g r12, Disposable r13, io.reactivex.internal.observers.h r14) {
        if (r14.d == false) goto L6;
        r12.clear();
        r13.dispose();
        return true;
    L6:
        if (r5 == false) goto L19;
        Throwable r15 = r14.f;
        if (r15 == null) goto L14;
        r12.clear();
        if (r13 == null) goto L12;
        r13.dispose();
    L12:
        r11.onError(r15);
        return true;
    L14:
        if (r10 == false) goto L21;
        if (r13 == null) goto L17;
        r13.dispose();
    L17:
        r11.onComplete();
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    public static void k(io.reactivex.internal.queue.a r10, io.reactivex.observers.d r11, Disposable r12, io.reactivex.internal.observers.h r13) {
        int r5 = 1;
    L4:
        if (j(r13.e, r10.isEmpty(), r11, r10, r12, r13) == true) goto L5;
    L6:
        boolean r14 = r13.e;
        Object r15 = r10.poll();
        if (r15 != null) goto L9;
        boolean r16 = true;
    L11:
        if (j(r14, r16, r11, r10, r12, r13) == true) goto L12;
        if (r16 == true) goto L14;
        r13.d(r11, r15);
        goto L6
    L14:
        r5 = r13.f17638a.addAndGet(-r5);
        if (r5 != 0) goto L4;
        return;
    L12:
        return;
    L9:
        r16 = false;
        goto L11
    }

    public static String l(Throwable r5) {
        if (r5 != null) goto L5;
        return "";
    L5:
        Throwable r10 = r5;
    L6:
        if (r10 == null) goto L12;
        if ((r10 instanceof UnknownHostException) == true) goto L9;
        r10 = r10.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        bp.b r11 = new bp.b();
        r11.f967a = 0;
        r11.f968b = false;
        PrintWriter r12 = new PrintWriter(r11);
        r5.printStackTrace(r12);     // Catch: Throwable -> L16
    L14:
        r12.flush();
        return r11.toString();
    }

    public static boolean m(String r5, CopyOnWriteArraySet r10) {
        if (com.bytedance.common.utility.b.b(r5) == false) goto L5;
        return false;
    L5:
        if (r10 == null) goto L18;
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L18;
        String r12 = (String) r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L8;
        if (r5.startsWith(r12) == false) goto L8;
        if (Logger.debug() == false) goto L25;
        Logger.d("RequestDelayHelper", "app delay, matched, rule is " + r12 + " request path is " + r5);
        return true;
    L25:
        return true;
    L18:
        return false;
    }

    public static boolean n(long r10, zu.c r11, Queue r12, AtomicLong r13, pt.e r14) {
        long r5 = r10 & Long.MIN_VALUE;
    L4:
        if (r5 != r10) goto L35;
        boolean r15 = r14.getAsBoolean();     // Catch: Throwable -> L18
    L20:
        if (r15 == true) goto L21;
        if (r12.isEmpty() == true) goto L24;
        r10 = r13.get();
        if (r10 != r5) goto L4;
        long r16 = r13.addAndGet(-(r5 & Long.MAX_VALUE));
        if ((Long.MAX_VALUE & r16) == 0) goto L30;
        r10 = r16;
        r5 = r16 & Long.MIN_VALUE;
        goto L4
    L30:
        return false;
    L24:
        r11.onComplete();
        return true;
    L21:
        return true;
    L18:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r15 = true;
        goto L20
    L35:
        boolean r17 = r14.getAsBoolean();     // Catch: Throwable -> L7
    L9:
        if (r17 == true) goto L10;
        Object r18 = r12.poll();
        if (r18 == null) goto L13;
        r11.onNext(r18);
        r5 = r5 + 1;
        goto L4
    L13:
        r11.onComplete();
        return true;
    L10:
        return true;
    L7:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        r17 = true;
        goto L9
    }
}
