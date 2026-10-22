package com.lynx.tasm;

import android.os.Handler;
import android.os.Looper;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.event.LynxEvent$LynxEventType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f10941c;
    public WeakReference d;
    public final i e;
    public final ArrayList f;
    public final Handler g;

    public r(LynxEngineProxy r5) {
        this.f10939a = 0;
        this.f10940b = false;
        this.f = new ArrayList();
        this.g = new Handler(Looper.getMainLooper());
        this.e = new i(r5);
        this.f10941c = new WeakReference(null);
        this.d = new WeakReference(null);
    }

    public final void a(int r5, int r10, int r11) {
        if (r10 == r11) goto L13;
        i r12 = this.e;
        if (r12 == null) goto L10;
        LynxEngineProxy r13 = (LynxEngineProxy) r12.f10879a;
        if (r13 == null) goto L12;
        com.lynx.tasm.utils.j.f(new mn.e(r13, r5, r10, r11));
        return;
    L12:
        return;
    L10:
        LynxLog.b(4, "EventEmitter", "onPseudoStatusChanged id: " + r5 + " failed since mEngineProxy is null.");
        return;
    }

    public final void b(on.b r5) {
        com.lynx.tasm.utils.j.f(new ab.b(22, this, false, r5));
    }

    public final boolean c(on.c r14) {
        NativeFacade r13 = (NativeFacade) this.f10941c.get();
        if (r13 != null) goto L5;
        LynxLog.b(4, "EventEmitter", "onLynxEvent event: " + r14.f20780b + " failed since mEventReporter is null.");
        return false;
    L5:
        if (r13.f10048b != null) goto L7;
        return false;
    L7:
        LynxContext r5 = (LynxContext) r13.d.get();
        if (r5 != null) goto L10;
    L48:
        return false;
    L10:
        if (((com.lynx.tasm.behavior.n0) r5.f10147o.get()) == null) goto L48;
        LynxEvent$LynxEventType r10 = r14.f20781c;
        LynxEvent$LynxEventType r11 = LynxEvent$LynxEventType.f10839a;
        if (r10 == r11) goto L15;
    L36:
        wm.a r12 = r14.d;
        if (r12 != null) goto L39;
        return false;
    L39:
        r5.k();
        on.d r15 = new on.d();
        if (r14.f20781c != r11) goto L45;
        if ((r14 instanceof on.h) == false) goto L45;
        on.h r16 = (on.h) r14;
    L45:
        if (r12.dispatchEvent(r15) == false) goto L47;
        return true;
    L47:
        r13.f10048b.onLynxEvent(r15);
        goto L48
    L15:
        if ((r14 instanceof on.h) == false) goto L36;
        on.h r17 = (on.h) r14;
        if (r17.f20788j == false) goto L36;
        JavaOnlyMap r18 = r17.f20789k;
        Iterator<Map.Entry<String, Object>> r19 = r18.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L33;
        Map.Entry<String, Object> r20 = r19.next();
        wm.a r21 = (wm.a) r17.f20790l.get(Integer.valueOf(Integer.parseInt(r20.getKey())));
        if (r21 == null) goto L20;
        HashMap r22 = new HashMap();
        Iterator<Object> r23 = ((JavaOnlyArray) r20.getValue()).iterator();
    L26:
        if (r23.hasNext() == false) goto L28;
        JavaOnlyArray r24 = (JavaOnlyArray) r23.next();
        r22.put((Integer) r24.get(0), new on.g(((Float) r24.get(5)).floatValue(), ((Float) r24.get(6)).floatValue()));
        goto L26
    L28:
        r21.getSign();
        LynxEvent$LynxEventType r25 = LynxEvent$LynxEventType.f10839a;
        System.currentTimeMillis();
        r5.k();
        on.d r26 = new on.d();
        if (r21.dispatchEvent(r26) == true) goto L30;
        r13.f10048b.onLynxEvent(r26);
        goto L20
    L30:
        r19.remove();
        goto L20
    L33:
        if (r18.size() != 0) goto L35;
        return true;
    L35:
        return false;
    }

    public final void d(on.h r10) {
        String r5 = r10.f20780b;
        i r11 = this.e;
        if (r11 != null) goto L5;
    L30:
        LynxLog.b(4, "EventEmitter", "sendTouchEvent event: " + r5 + " failed since mEngineProxy is null or in preload.");
        return;
    L5:
        if (this.f10940b == true) goto L30;
        if (c(r10) == true) goto L34;
        wm.a r12 = r10.d;
        LynxEngineProxy r13 = (LynxEngineProxy) r11.f10879a;
        if (r12 != null) goto L12;
    L27:
        if (r13 == null) goto L33;
        com.lynx.tasm.utils.j.f(new mn.c(r13, r10, 0));
        return;
    L33:
        return;
    L12:
        if (r12.getParentLynxPageUI() != null) goto L16;
        if (r12.getChildrenLynxPageUI() == null) goto L27;
    L16:
        if (r12.getParentLynxPageUI() != null) goto L18;
        this.f10939a = (this.f10939a + 1) % 9223372036854775806L;
    L18:
        long r14 = this.f10939a;
        r10.f = r14;
        r12.setEventID(r14);
        LynxLog.b(2, "LynxEventEmitter", "TouchEventHandler " + r10.f20780b + " " + r10.f + " " + this);
        if (r13 == null) goto L22;
        com.lynx.tasm.utils.j.f(new mn.c(r13, r10, 2));
    L22:
        if (r12.getChildrenLynxPageUI() != null) goto L24;
    L25:
        r12.getRootLynxPageUI().startEventCapture(this.f10939a);
        return;
    L24:
        if (r12.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(r12))) == null) goto L25;
        return;
    }
}
