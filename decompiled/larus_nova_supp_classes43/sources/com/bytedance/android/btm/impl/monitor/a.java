package com.bytedance.android.btm.impl.monitor;

import android.os.Handler;
import android.os.Message;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends PthreadHandlerThreadV2 implements Handler.Callback {
    public static volatile Handler c;
    public static final ArrayList<Message> d = null;
    public static final a e = null;

    static {
        e = new a();
        d = new ArrayList();
    }

    public a() {
        super("BtmSDK-ALog");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLooperPrepared() {
        super/*android.os.HandlerThread*/.onLooperPrepared();
        Thread.sleep(BtmSetting.d.c().d().a());     // Catch: Exception -> L18
    L4:
        c = new Handler(getLooper(), this);
        ArrayList<Message> r0 = d;
        monitor-enter(r0);
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L15
    L8:
        if (r1.hasNext() == false) goto L12;
        Message r10 = (Message) r1.next();     // Catch: Throwable -> L15
        Handler r11 = c;     // Catch: Throwable -> L15
        if (r11 == null) goto L8;
        r11.sendMessage(r10);     // Catch: Throwable -> L15
        goto L8
    L12:
        d.clear();     // Catch: Throwable -> L15
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r10) {
        Object r11 = r10.obj;
        Object r12 = null;
        if ((r11 instanceof e) == true) goto L5;
        r11 = null;
    L5:
        e r13 = (e) r11;
        if (r13 != null) goto L32;
        return false;
    L32:
        if (r13.c == null) goto L13;
        StringBuilder r14 = new StringBuilder("delayTime: ");     // Catch: Exception -> L31
        long r15 = System.currentTimeMillis();     // Catch: Exception -> L31
        Long r0 = r13.c;     // Catch: Exception -> L31
        if (r0 != null) goto L12;
        Intrinsics.throwNpe();     // Catch: Exception -> L31
    L12:
        r14.append(r15 - r0.longValue());     // Catch: Exception -> L31
        r14.append('\n');     // Catch: Exception -> L31
        String r1 = r14.toString();     // Catch: Exception -> L31
    L14:
        StringBuilder r16 = new StringBuilder();     // Catch: Exception -> L31
        r16.append(r1);     // Catch: Exception -> L31
        Object r17 = r13.b;     // Catch: Exception -> L31
        if (TypeIntrinsics.isFunctionOfArity(r17, 0) == true) goto L17;
        r17 = null;
    L17:
        Function0 r18 = (Function0) r17;     // Catch: Exception -> L31
        if (r18 == null) goto L20;
        r12 = r18.invoke();     // Catch: Exception -> L31
    L20:
        r16.append(String.valueOf(r12));     // Catch: Exception -> L31
        String r19 = r16.toString();     // Catch: Exception -> L31
        BtmHostDependManager r20 = BtmHostDependManager.F;     // Catch: Exception -> L31
        zc.a r21 = r20.a();     // Catch: Exception -> L31
        if (r21 == null) goto L24;
        r21.i(r13.a, r19);     // Catch: Exception -> L31
    L24:
        if (r20.c() == false) goto L34;
        zc.f r22 = (zc.f) BtmHostDependManager.j.getValue(r20, BtmHostDependManager.a[8]);     // Catch: Exception -> L31
        if (r22 == null) goto L35;
        r22.i(r13.a, r19);     // Catch: Exception -> L31
        return true;
    L35:
        return true;
    L34:
        return true;
    L13:
        r1 = "";
    L36:
        return true;
    }

    public static void b(String r10, Function0 r11) {
        if (com.bytedance.android.btm.impl.util.a.a() == true) goto L6;
        return;
    L6:
        if (c == null) goto L8;
        Message.obtain(c, 0, new e(r10, r11, null, 12)).sendToTarget();
        return;
    L8:
        ArrayList<Message> r0 = d;
        monitor-enter(r0);
    L17:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L18:
        monitor-exit(r0);
        return;
    L15:
        th = move-exception;
        throw th;
    L11:
        if (c != null) goto L13;
        r0.add(Message.obtain(null, 0, new e(r10, r11, Long.valueOf(System.currentTimeMillis()), 8)));     // Catch: Throwable -> L15 Exception -> L17
    L22:
    L13:
        Message.obtain(c, 0, new e(r10, r11, null, 12)).sendToTarget();     // Catch: Throwable -> L15 Exception -> L17
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L15 Exception -> L17
        goto L22
    }
}
