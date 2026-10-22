package com.lynx.tasm;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 extends EventEmitter {
    public long a;
    public boolean b;
    public WeakReference<EventEmitter.d> c;
    public WeakReference<EventEmitter.b> d;
    public final b e;
    public final ArrayList<EventEmitter.c> f;
    public final Handler g;

    public class a implements Runnable {
        public final /* synthetic */ com.lynx.tasm.event.a a;
        public final /* synthetic */ b0 b;

        public final void a() {
            this.a.getName();
            b0 r0 = this.b;
            if (r0.e != null) goto L5;
        L18:
            LLog.e("EventEmitter", "sendCustomEvent event: " + this.a.getName() + " failed since mEngineProxy is null or in preload.");
        L19:
            b0 r1 = this.b;
            EventEmitter.LynxEventType r2 = EventEmitter.LynxEventType.kLynxEventTypeCustomEvent;
            com.lynx.tasm.event.a r3 = this.a;
            r1.getClass();
            c0 r4 = new c0(r1, r2, r3);
            if (Looper.getMainLooper() != Looper.myLooper()) goto L22;
            r4.run();
            return;
        L22:
            r1.g.post(r4);
            return;
        L5:
            if (r0.b == true) goto L18;
            if (r0.onLynxEvent(this.a) == false) goto L9;
            return;
        L9:
            com.lynx.tasm.event.a r5 = this.a;
            r5.a("timestamp", Long.valueOf(r5.getTimestamp()));
            WeakReference<EventEmitter.b> r6 = this.b.d;
            if (r6 != null) goto L12;
        L16:
            LLog.e("EventEmitter", "checkFallbackForLynxEvent event: " + this.a.getName() + " failed since mEventFallback is null.");
            return;
        L12:
            if (r6.get() == null) goto L16;
            this.b.d.get().checkFallbackForLynxEvent(false);
            b r7 = this.b.e;
            com.lynx.tasm.event.a r8 = this.a;
            LynxEngineProxy r9 = r7.a;
            if (r9 == null) goto L19;
            UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.h(r9, r8));
            goto L19
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b0 r1, com.lynx.tasm.event.a r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class b {
        public final LynxEngineProxy a;

        public b(LynxEngineProxy r2) {
            this.a = null;
            this.a = r2;
        }
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void setTestTapTracker(EventEmitter.a r1) {
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void sendLayoutEvent() {
        c0 r1 = new c0(this, EventEmitter.LynxEventType.kLynxEventTypeLayoutEvent, null);
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r1.run();
        return;
    L5:
        this.g.post(r1);
    }

    public b0(LynxEngineProxy r3) {
        this.a = 0;
        this.b = false;
        this.f = new ArrayList();
        this.g = new Handler(Looper.getMainLooper());
        this.e = new b(r3);
        this.c = new WeakReference(null);
        this.d = new WeakReference(null);
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void addObserver(EventEmitter.c r2) {
        if (this.f.contains(r2) == false) goto L5;
        return;
    L5:
        this.f.add(r2);
    }

    @Override // com.lynx.tasm.EventEmitter
    public final boolean onLynxEvent(LynxEvent r3) {
        EventEmitter.d r0 = this.c.get();
        if (r0 != null) goto L5;
        LLog.e("EventEmitter", "onLynxEvent event: " + r3.getName() + " failed since mEventReporter is null.");
        return false;
    L5:
        return r0.a(r3);
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void registerEventFallback(EventEmitter.b r2) {
        this.d = new WeakReference(r2);
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void registerEventReporter(EventEmitter.d r2) {
        this.c = new WeakReference(r2);
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void removeObserver(EventEmitter.c r2) {
        if (this.f.contains(r2) == true) goto L5;
        return;
    L5:
        this.f.remove(r2);
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void sendCustomEvent(com.lynx.tasm.event.a r2) {
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r2));
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void sendMultiTouchEvent(LynxTouchEvent r8) {
        if (this.e != null) goto L5;
    L43:
        LLog.e("EventEmitter", "sendMultiTouchEvent event: " + r8.getName() + " failed since mEngineProxy is null or in preload.");
        return;
    L5:
        if (this.b == true) goto L43;
        boolean r4 = false;
        if (r8.getEventID() == Long.MIN_VALUE) goto L9;
        boolean r0 = false;
    L11:
        if (onLynxEvent(r8) == false) goto L13;
        return;
    L13:
        EventTarget r1 = (EventTarget) r8.getTarget();
        if (r1 == null) goto L40;
        HashMap<String, EventTarget> r2 = r1.getChildrenLynxPageUI();
        if (r0 == false) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r2 != null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r0 == false) goto L28;
        r4 = r6;
    L31:
        if (r4 == false) goto L37;
        if (r3 == true) goto L34;
        this.a = (this.a + 1) % 9223372036854775806L;
    L34:
        r8.setEventID(this.a);
        r1.setEventID(this.a);
        LLog.i("LynxEventEmitter", "TouchEventHandler " + r8.getName() + " " + r8.getEventID() + " " + this);
        startEventGenerate(r8);
        if (r6 == true) goto L45;
        r1.getRootLynxPageUI().startEventCapture(this.a);
        return;
    L45:
        return;
    L37:
        LynxEngineProxy r5 = this.e.a;
        if (r5 == null) goto L47;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.g(r5, r8));
        return;
    L47:
        return;
    L28:
        if (r3 == true) goto L30;
        if (r2 == null) goto L31;
    L30:
        r4 = true;
        goto L31
    L23:
        if (r2.get(String.valueOf(System.identityHashCode(r1))) == null) goto L25;
        r6 = true;
        goto L26
    L18:
        if (r1.getParentLynxPageUI() == null) goto L20;
        r3 = true;
        goto L21
    L40:
        LynxEngineProxy r7 = this.e.a;
        if (r7 == null) goto L49;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.g(r7, r8));
        return;
    L49:
        return;
    L9:
        r8.setEventID(0);
        r0 = true;
        goto L11
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void sendTouchEvent(LynxTouchEvent r8) {
        String r0 = r8.getName();
        if (this.e != null) goto L5;
    L43:
        LLog.e("EventEmitter", "sendTouchEvent event: " + r0 + " failed since mEngineProxy is null or in preload.");
        return;
    L5:
        if (this.b == true) goto L43;
        boolean r4 = false;
        if (r8.getEventID() == Long.MIN_VALUE) goto L9;
        boolean r1 = false;
    L11:
        if (onLynxEvent(r8) == false) goto L13;
        return;
    L13:
        EventTarget r2 = (EventTarget) r8.getTarget();
        if (r2 == null) goto L40;
        HashMap<String, EventTarget> r3 = r2.getChildrenLynxPageUI();
        if (r1 == false) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r3 != null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r1 == false) goto L28;
        r4 = r6;
    L31:
        if (r4 == false) goto L37;
        if (r5 == true) goto L34;
        this.a = (this.a + 1) % 9223372036854775806L;
    L34:
        r8.setEventID(this.a);
        r2.setEventID(this.a);
        LLog.i("LynxEventEmitter", "TouchEventHandler " + r8.getName() + " " + r8.getEventID() + " " + this);
        startEventGenerate(r8);
        if (r6 == true) goto L45;
        r2.getRootLynxPageUI().startEventCapture(this.a);
        return;
    L45:
        return;
    L37:
        LynxEngineProxy r7 = this.e.a;
        if (r7 == null) goto L47;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.f(r7, r8));
        return;
    L47:
        return;
    L28:
        if (r5 == true) goto L30;
        if (r3 == null) goto L31;
    L30:
        r4 = true;
        goto L31
    L23:
        if (r3.get(String.valueOf(System.identityHashCode(r2))) == null) goto L25;
        r6 = true;
        goto L26
    L18:
        if (r2.getParentLynxPageUI() == null) goto L20;
        r5 = true;
        goto L21
    L40:
        LynxEngineProxy r9 = this.e.a;
        if (r9 == null) goto L49;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.f(r9, r8));
        return;
    L49:
        return;
    L9:
        r8.setEventID(0);
        r1 = true;
        goto L11
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void setEventID(long r1) {
        this.a = r1;
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void setInPreLoad(boolean r1) {
        this.b = r1;
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void startEventBubble(long r3) {
        b r0 = this.e;
        if (r0 == null) goto L8;
        LynxEngineProxy r1 = r0.a;
        if (r1 == null) goto L9;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.b(r1, r3));
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void startEventCapture(long r3) {
        b r0 = this.e;
        if (r0 == null) goto L8;
        LynxEngineProxy r1 = r0.a;
        if (r1 == null) goto L9;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.a(r1, r3));
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void startEventGenerate(LynxEvent r3) {
        b r0 = this.e;
        if (r0 == null) goto L8;
        LynxEngineProxy r1 = r0.a;
        if (r1 == null) goto L9;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.l(r1, r3));
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void sendGestureEvent(int r8, com.lynx.tasm.event.a r9) {
        String r2 = r9.getName();
        if (this.e != null) goto L5;
    L13:
        LLog.e("EventEmitter", "sendGestureEvent event: " + r2 + " failed since mEngineProxy is null or in preload.");
        return;
    L5:
        if (this.b == true) goto L13;
        j7a.a r0 = j7a.a.a;
        Map<String, Object> r1 = r9.b();
        r0.getClass();
        ByteBuffer r5 = j7a.a.b(r1);
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        b r3 = this.e;
        int r4 = r9.getTag();
        LynxEngineProxy r7 = r3.a;
        if (r7 == null) goto L15;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.i(r7, r2, r4, r8, r5, r6));
        return;
    L15:
        return;
    L9:
        r6 = r5.position();
        goto L10
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void startEventFire(boolean r3, long r4) {
        b r0 = this.e;
        if (r0 == null) goto L8;
        LynxEngineProxy r1 = r0.a;
        if (r1 == null) goto L9;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.c(r1, r3, r4));
        return;
    L9:
        return;
    }

    @Override // com.lynx.tasm.EventEmitter
    public final void onPseudoStatusChanged(int r3, int r4, int r5) {
        if (r4 != r5) goto L4;
        return;
    L4:
        b r0 = this.e;
        if (r0 == null) goto L9;
        LynxEngineProxy r1 = r0.a;
        if (r1 == null) goto L11;
        UIThreadUtils.runOnUiThreadImmediately(new com.lynx.tasm.core.j(r1, r3, r4, r5));
        return;
    L11:
        return;
    L9:
        LLog.e("EventEmitter", "onPseudoStatusChanged id: " + r3 + " failed since mEngineProxy is null.");
    }
}
