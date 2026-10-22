package com.bytedance.android.live.liveinteract.service;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.widget.p0;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import zg1.g1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    public final void accept(Object r14) {
        g1 r15 = (g1) r14;
        this.a.getClass();
        ALogger.i("AnchorModeOutServiceImp", "onSwitchRoomJsBridge LiveEndEvent mAnchorGuestLiveEndInfo " + this.a.a);
        ny.a r16 = this.a.a;
        if (r16 == null) goto L5;
        Boolean r17 = Boolean.valueOf(r16.b);
    L6:
        ny.a r2 = this.a.a;
        if (r2 == null) goto L9;
        String r9 = r2.d;
    L10:
        if (r2 == null) goto L12;
        final Boolean r5 = Boolean.valueOf(r2.c);
    L13:
        ny.a r3 = this.a.a;
        if (r3 == null) goto L16;
        final String r6 = r3.e;
    L18:
        if (r9 != null) goto L20;
    L25:
        WeakReference r0 = com.bytedance.android.live.core.utils.a.a;
        if (r0 == null) goto L28;
        Activity r1 = (Activity) r0.get();
    L30:
        if ((r1 instanceof Context) == true) goto L32;
        r1 = null;
    L32:
        if (r1 != null) goto L35;
        return;
    L35:
        if (Intrinsics.areEqual(r17, Boolean.TRUE) == false) goto L38;
        p0.a r11 = new p0.a(r1);
        r11.a = "聊天室已关闭";
        r11.b = "10秒后你将和观众回到个播";
        final Boolean r4 = r17;
        final Activity r7 = r1;
        final String r8 = r9;
        DialogInterface.OnClickListener r12 = new AnchorModeOutServiceImp$onSwitchRoomJsBridge$1$1(this, r4, r5, r6, r7, r8);
        Intrinsics.checkNotNullParameter("回到个播", "confirmText");
        r11.c = "回到个播";
        r11.d = r12;
        r11.e = 10;
        r11.f = true;
        r11.a();
    L38:
        if (Intrinsics.areEqual(r17, Boolean.FALSE) == false) goto L45;
        ReadOnlyProperty r18 = vm2.d.c;
        KProperty[] r10 = vm2.d.a;
        if (((Number) r18.getValue(null, r10[1])).longValue() <= 0) goto L42;
        AndroidSchedulers.mainThread().scheduleDirect(new a(r1, r9), ((Number) r18.getValue(null, r10[1])).longValue(), TimeUnit.MILLISECONDS);
        goto L45
    L42:
        ILiveActionHandler r19 = jc1.k.f(ILiveActionHandler.class);
        if (r19 == null) goto L45;
        r19.handle(r1, r9);
    L45:
        this.a.a = null;
        return;
    L28:
        r1 = null;
        goto L30
    L20:
        if (r9.length() <= 0) goto L22;
        boolean r13 = true;
    L23:
        if (r13 == true) goto L25;
        this.a.getClass();
        ALogger.i("AnchorModeOutServiceImp", "onSwitchRoomJsBridge jumpScheme is empty");
        return;
    L22:
        r13 = false;
        goto L23
    L16:
        r6 = null;
        goto L18
    L12:
        r5 = null;
        goto L13
    L9:
        r9 = null;
        goto L10
    L5:
        r17 = null;
        goto L6
    }
}
