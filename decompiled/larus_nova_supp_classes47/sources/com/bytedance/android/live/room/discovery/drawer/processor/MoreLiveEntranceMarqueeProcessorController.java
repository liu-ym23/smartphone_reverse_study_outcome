package com.bytedance.android.live.room.discovery.drawer.processor;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MoreLiveEntranceMarqueeProcessorController implements com.bytedance.android.live.room.discovery.drawer.processor.b {
    public final Lazy a;
    public Job b;
    public final List<com.bytedance.android.live.room.discovery.drawer.processor.a> c;
    public final List<com.bytedance.android.live.room.discovery.drawer.behavior.a> d;
    public final Handler e;
    public MoreLiveMarqueeProcessorContext f;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            String r4 = "checkEntranceMarqueeOnLoad error:" + r3.getMessage();
            Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
            ALogger.d("LiveDrawerLog", r4);
        }
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r2, Throwable r3) {
            String r4 = "checkEntranceMarqueeOnLoad useLocalShowMarquee error:" + r3.getMessage();
            Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
            ALogger.d("LiveDrawerLog", r4);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MoreLiveEntranceMarqueeProcessorController a;

        public c(MoreLiveEntranceMarqueeProcessorController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MoreLiveEntranceMarqueeProcessorController.c(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void i() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.room.discovery.drawer.behavior.a) r0.next()).b();
        goto L4
    L6:
        j(LiveEntranceStatus.NOT_DISPLAYED);
    }

    public final boolean k() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        com.bytedance.android.live.room.discovery.drawer.processor.a r1 = (com.bytedance.android.live.room.discovery.drawer.processor.a) r0.next();
        if (r1.a() == false) goto L4;
        d.a(r1.identifier() + " postIntercept called, intercepted");
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.b
    public final MoreLiveMarqueeProcessorContext b() {
        return this.f;
    }

    public MoreLiveEntranceMarqueeProcessorController(MoreLiveMarqueeProcessorContext r4) {
        Intrinsics.checkNotNullParameter(r4, "marqueeContext");
        this.f = r4;
        this.a = LazyKt.lazy(MoreLiveEntranceMarqueeProcessorController$liveMultiTabHandler$2.INSTANCE);
        ArrayList r5 = new ArrayList();
        this.c = r5;
        ArrayList r0 = new ArrayList();
        this.d = r0;
        this.e = new Handler(Looper.getMainLooper());
        r5.add(new f(this));
        r5.add(new h(this));
        r5.add(new g(this));
        if (this.f.a() == true) goto L5;
        r5.add(new com.bytedance.android.live.room.discovery.drawer.processor.c(this));
    L5:
        r5.add(new e(this));
        r0.add(new com.bytedance.android.live.room.discovery.drawer.behavior.b(this));
        g("init");
    }

    public static final void c(MoreLiveEntranceMarqueeProcessorController r1) {
        Function0<Unit> r0 = r1.f.p;
        if (r0 == null) goto L5;
        Unit r2 = (Unit) r0.invoke();
    L5:
        r1.j(LiveEntranceStatus.DISPLAY_COMPLETED);
    }

    public final void e(HashMap<String, String> r5) {
        com.bytedance.android.live.base.model.moreliveentrance.b r0 = this.f.m;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.d();
        if (r2 == null) goto L6;
    L7:
        r5.put("guide_content", r2);
        com.bytedance.android.live.base.model.moreliveentrance.b r3 = this.f.m;
        if (r3 == null) goto L11;
        String r4 = String.valueOf(r3.h());
        if (r4 == null) goto L11;
    L12:
        r5.put("interaction_theme_short_id", r4);
        com.bytedance.android.live.base.model.moreliveentrance.b r6 = this.f.m;
        if (r6 == null) goto L17;
        String r7 = r6.g();
        if (r7 == null) goto L17;
        r1 = r7;
    L17:
        r5.put("interaction_theme_short_text", r1);
        return;
    L11:
        r4 = "";
    L6:
        r2 = "";
        goto L7
    }

    public final void g(String r4) {
        d.a(r4 + " marqueeContext: " + this.f.hashCode() + ", isFromTab:" + this.f.c + ' ' + this.f.a + '-' + this.f.b + "， roomId: " + this.f.f + ", uniqueKey: " + this.f.h + ", isFirstEnterRoom:" + this.f.d + '-' + this.f.e);
    }

    public final void h(MarqueeType r6) {
        Intrinsics.checkNotNullParameter(r6, "marqueeType");
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((com.bytedance.android.live.room.discovery.drawer.processor.a) r0.next()).c(r6);
        goto L4
    L7:
        if (r6 != MarqueeType.CLICK) goto L12;
        if (this.f.n != LiveEntranceStatus.DISPLAYING) goto L16;
        HashMap<String, String> r7 = new HashMap();
        e(r7);
        u.l().sendLog("livesdk_drawer_entrance_guide_click", r7, new Object[]{new x(), Room.class});
        return;
    L16:
        return;
    L12:
        if (r6 != MarqueeType.SHOW) goto L18;
        HashMap<String, String> r8 = new HashMap();
        e(r8);
        u.l().sendLog("livesdk_drawer_entrance_guide_show", r8, new Object[]{new x(), Room.class});
        return;
    }

    public final void j(LiveEntranceStatus r3) {
        MoreLiveMarqueeProcessorContext r0 = this.f;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "status");
        r0.n = r3;
    }

    public static final void d(MoreLiveEntranceMarqueeProcessorController r2, com.bytedance.android.live.base.model.moreliveentrance.b r3) {
        r2.getClass();
        if (r3 == null) goto L22;
        String r0 = r3.e();
        if (r0 != null) goto L8;
    L16:
        r2.j(LiveEntranceStatus.DISPLAY_ERROR);
        Function0<Unit> r4 = r2.f.p;
        if (r4 == null) goto L21;
        Unit r5 = (Unit) r4.invoke();
        return;
    L21:
        return;
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 != true) goto L16;
        r2.h(MarqueeType.SHOW);
        Function1<? super com.bytedance.android.live.base.model.moreliveentrance.b, Unit> r6 = r2.f.o;
        if (r6 == null) goto L15;
        Unit r7 = (Unit) r6.invoke(r3);
    L15:
        r2.j(LiveEntranceStatus.DISPLAYING);
        return;
    L10:
        r1 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.room.discovery.drawer.processor.b
    public final void a(MARQUEE_TRIGGER_STYLE r22, Map<String, Object> r23) {
        Intrinsics.checkNotNullParameter(r22, "source");
        Intrinsics.checkNotNullParameter(r23, "extraQueryMap");
        Iterator r0 = ((ArrayList) this.c).iterator();
    L3:
        boolean r3 = false;
        if (r0.hasNext() == false) goto L8;
        com.bytedance.android.live.room.discovery.drawer.processor.a r2 = (com.bytedance.android.live.room.discovery.drawer.processor.a) r0.next();
        if (r2.b() == false) goto L3;
        d.a(r2.identifier() + " preIntercept called, intercepted");
        boolean r1 = true;
    L9:
        boolean r4 = !r1;
        d.a("checkEntranceMarqueeOnLoad canRequest: " + r4 + ", widget:" + hashCode() + ", source:" + r22.name());
        com.bytedance.android.live.room.utils.a r5 = (com.bytedance.android.live.room.utils.a) this.a.getValue();
        long r10 = 10000;
        if (r5 == null) goto L20;
        Long r6 = Long.valueOf(r5.marqueeDelayTime());
        if (r6.longValue() < 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L18;
        r6 = null;
    L18:
        if (r6 == null) goto L20;
        long r12 = r6.longValue();
    L21:
        Ref.LongRef r8 = new Ref.LongRef();
        r8.element = 2000;
        if (this.f.a() == false) goto L24;
        r8.element = 0;
    L24:
        if (r4 == false) goto L34;
        Job r9 = this.b;
        if (r9 == null) goto L29;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L29:
        if (this.f.a() == true) goto L31;
    L33:
        this.b = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new a(CoroutineExceptionHandler.Key))), null, null, new MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3(this, r12, r8, r23, null), 3, null);
        return;
    L31:
        if (this.f.n != LiveEntranceStatus.DISPLAYING) goto L33;
        this.e.post(new c(this));
        goto L33
    L34:
        MoreLiveMarqueeProcessorContext r13 = this.f;
        Intrinsics.checkNotNullParameter(r13, "$this$canShowMarqueeByInfoValid");
        long r14 = SystemClock.elapsedRealtime() - r13.i;
        IRoomService r15 = (IRoomService) k.f(IRoomService.class);
        if (r15 == null) goto L39;
        com.bytedance.android.live.room.utils.a r16 = r15.getLiveMultiTabHandler();
        if (r16 == null) goto L39;
        r10 = r16.marqueeDelayTime();
    L39:
        RoomContext r17 = r13.q;
        if (r17 == null) goto L57;
        m r18 = r17.getMoreLiveShowMarqueeShown();
        if (r18 == null) goto L57;
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L57;
        com.bytedance.android.live.base.model.moreliveentrance.b r19 = r13.m;
        if (r19 == null) goto L57;
        String r20 = r19.e();
        if (r20 == null) goto L57;
        if (r20.length() <= 0) goto L52;
        boolean r24 = true;
    L53:
        if (r24 != true) goto L57;
        if (r14 >= r10) goto L57;
        r3 = true;
        goto L57
    L52:
        r24 = false;
    L57:
        if (r3 == false) goto L64;
        Job r25 = this.b;
        if (r25 == null) goto L62;
        Job.DefaultImpls.cancel$default(r25, null, 1, null);
    L62:
        if (k() == true) goto L70;
        this.b = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new b(CoroutineExceptionHandler.Key))), null, null, new MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5(this, r8, null), 3, null);
        return;
    L70:
        return;
    L64:
        d.a("checkEntranceMarqueeOnLoad has shown once time or " + this.f.a + ", status: " + this.f.n.name() + " intercept");
        return;
    L14:
        r7 = false;
    L20:
        r12 = 10000;
        goto L21
    L8:
        r1 = false;
        goto L9
    }

    public final void f(Function1<? super com.bytedance.android.live.base.model.moreliveentrance.b, Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "showMarqueeAction");
        Intrinsics.checkNotNullParameter(r3, "resetMarqueeAction");
        MoreLiveMarqueeProcessorContext r0 = this.f;
        r0.o = r2;
        r0.p = r3;
    }

    public final void l(RoomContext r8, DataCenter r9) {
        MoreLiveMarqueeProcessorContext r0 = this.f;
        Intrinsics.checkNotNullParameter(r0, "$this$tryTransformRecently");
        if (r8 == null) goto L9;
        m r1 = r8.getRoom();
        if (r1 == null) goto L9;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L9;
        long r3 = r2.getRoomId();
    L10:
        String r4 = null;
        if (r8 == null) goto L13;
        Integer r5 = Integer.valueOf(r8.hashCode());
    L14:
        String r6 = r0.a;
        if (r8 == null) goto L19;
        n r7 = r8.getSourceEnterFromMerge();
        if (r7 == null) goto L19;
        String r10 = (String) r7.getValue();
    L21:
        if (Intrinsics.areEqual(r6, r10) == false) goto L34;
        String r12 = r0.b;
        if (r8 == null) goto L28;
        n r13 = r8.getSourceEnterMethod();
        if (r13 == null) goto L28;
        r4 = (String) r13.getValue();
    L28:
        if (Intrinsics.areEqual(r12, r4) == false) goto L34;
        if (r0.f != r3) goto L34;
        if (Intrinsics.areEqual(r0.h, r5) == false) goto L34;
    L35:
        this.f = r0;
        g("replace");
        return;
    L34:
        r0 = new MoreLiveMarqueeProcessorContext(r8, r9);
    L19:
        r10 = null;
        goto L21
    L13:
        r5 = null;
    L9:
        r3 = 0;
        goto L10
    }
}
