package com.bytedance.android.livesdk.interactivity.api.monitorV2;

import android.os.Handler;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s;
import com.bytedance.android.livesdk.interactivity.service.monitor.EventName;
import com.bytedance.android.livesdk.interactivity.service.monitor.MonitorEvent;
import com.bytedance.android.livesdk.interactivity.service.monitor.UploadMode;
import com.bytedance.android.livesdk.interactivity.service.monitor.b;
import com.bytedance.android.livesdk.interactivity.service.monitor.c;
import com.bytedance.android.livesdk.interactivity.service.monitor.d;
import com.bytedance.android.livesdk.interactivity.service.monitor.f;
import com.bytedance.android.livesdk.interactivity.service.monitor.g;
import com.bytedance.android.livesdk.interactivity.service.monitor.h;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import r52.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InteractivityMonitor implements d {
    public final HashMap<EventName, MonitorEvent> a;
    public final ConcurrentHashMap<EventName, Runnable> b;
    public final List<f> c;
    public final long d;
    public final long e;
    public final boolean f;
    public final long g;
    public final boolean h;
    public boolean i;
    public long j;
    public long k;
    public final Lazy l;
    public final Lazy m;
    public final long n;

    public static final class a implements Runnable {
        public final /* synthetic */ InteractivityMonitor a;
        public final /* synthetic */ MonitorEvent b;

        @Override // java.lang.Runnable
        public final void run() {
            InteractivityMonitor r0 = this.a;     // Catch: Throwable -> L14
            EventName r1 = this.b.g;     // Catch: Throwable -> L14
            if (r0.f == false) goto L12;
            MonitorEvent r2 = r0.a.get(r1);     // Catch: Throwable -> L14
            if (r2 == null) goto L12;
            Iterator r3 = ((ArrayList) r2.f).iterator();     // Catch: Throwable -> L14
        L9:
            if (r3.hasNext() == false) goto L11;
            ((g) r3.next()).a(r2);     // Catch: Throwable -> L14
            goto L9
        L11:
            r2.d();     // Catch: Throwable -> L14
        L12:
            ((Handler) this.a.l.getValue()).postDelayed(this, this.b.i * 1000);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L18;
            return;
        L18:
            throw th;
        }

        public a(InteractivityMonitor r1, MonitorEvent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final void b() {
        if (this.f == true) goto L5;
        return;
    L5:
        Iterator<Map.Entry<EventName, MonitorEvent>> r0 = this.a.entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        MonitorEvent r1 = r0.next().getValue();
        ((ArrayList) r1.a).clear();
        ((LinkedHashMap) r1.b).clear();
        ((LinkedHashMap) r1.c).clear();
        ((LinkedHashMap) r1.d).clear();
        r1.b().clear();
        ((ArrayList) r1.f).clear();
        goto L7
    L9:
        ((ArrayList) this.c).clear();
        this.a.clear();
        MainThreadPostUtils.d((InteractivityMonitor$trackRunnable$2.a) this.m.getValue());
        Iterator<Map.Entry<EventName, Runnable>> r2 = this.b.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<EventName, Runnable> r3 = r2.next();
        ((Handler) this.l.getValue()).removeCallbacks(r3.getValue());
        goto L11
    L13:
        this.i = false;
        j<d> r4 = com.bytedance.android.livesdk.interactivity.api.monitorV2.a.a;
        if (PublicScreenABHelper.D.interactivityMonitorHelperOpt == false) goto L19;
        com.bytedance.android.livesdk.interactivity.api.monitorV2.a.a = null;
        return;
    }

    public InteractivityMonitor(long r3) {
        this.n = r3;
        this.a = new HashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ArrayList();
        this.d = 1000;
        s r4 = (s) w0.a.getValue();
        this.e = r4.c();
        this.f = r4.a();
        this.g = r4.d();
        this.h = r4.b();
        this.j = -1;
        this.l = LazyKt.lazy(InteractivityMonitor$handler$2.INSTANCE);
        this.m = LazyKt.lazy(new InteractivityMonitor$trackRunnable$2(this));
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final void d(long r4) {
        k(UploadMode.ROOM_QUIT, r4 - this.n);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final void f(MonitorEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "newEvent");
        if (this.f == true) goto L6;
        return;
    L6:
        if (this.a.containsKey(r7.g) == false) goto L8;
        return;
    L8:
        this.a.put(r7.g, r7);
        if (this.i == true) goto L15;
        if (r7.h != UploadMode.LOOP) goto L15;
        this.k = com.bytedance.android.livesdk.utils.ntp.a.a;
        this.j = i(System.currentTimeMillis() + this.k);
        MainThreadPostUtils.c((InteractivityMonitor$trackRunnable$2.a) this.m.getValue(), this.j);
        this.i = true;
        return;
    L15:
        if (r7.h != UploadMode.TIMER) goto L18;
        a r0 = new a(this, r7);
        this.b.put(r7.g, r0);
        ((Handler) this.l.getValue()).postDelayed(r0, r7.i * 1000);
        return;
    }

    public final long i(long r4) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r4);
        int r5 = r0.get(12);
        int r6 = r0.get(13);
        int r1 = r0.get(14);
        long r7 = (((long) ((r5 * 60) + r6)) * this.d) + ((long) r1);
        long r2 = this.e;
        return r2 - (r7 % r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final void g(EventName r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "customParams");
        if (this.f == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap(r4);
        j(r0, UploadMode.IMMEDIATE, null);
        j0.l().sendLog(r3.getStr(), r0, new Object[0]);
    }

    public final void k(UploadMode r11, long r13) {
        if (this.f == true) goto L6;
        return;
    L6:
        if (r13 >= this.g) goto L9;
        return;
    L9:
        if (r11 != UploadMode.LOOP) goto L25;
        HashMap<EventName, MonitorEvent> r0 = this.a;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<Map.Entry<EventName, MonitorEvent>> r1 = r0.entrySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        Map.Entry<EventName, MonitorEvent> r4 = r1.next();
        if (r4.getValue().h != UploadMode.LOOP) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L12;
        r3.put(r4.getKey(), r4.getValue());
        goto L12
    L16:
        r5 = false;
        goto L17
    L19:
        Iterator r2 = r3.entrySet().iterator();
    L21:
        if (r2.hasNext() == false) goto L51;
        Map.Entry r6 = (Map.Entry) r2.next();
        HashMap r7 = new HashMap();
        Map<String, String> r8 = ((MonitorEvent) r6.getValue()).a(this.h);
        if ((!r8.isEmpty()) == false) goto L21;
        r7.putAll(r8);
        j(r7, r11, Long.valueOf(r13));
        j0.l().sendLog(((EventName) r6.getKey()).getStr(), r7, new Object[0]);
        ((MonitorEvent) r6.getValue()).d();
        r7.clear();
        goto L21
    L51:
        return;
    L25:
        HashMap<EventName, MonitorEvent> r9 = this.a;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<Map.Entry<EventName, MonitorEvent>> r14 = r9.entrySet().iterator();
    L27:
        if (r14.hasNext() == false) goto L34;
        Map.Entry<EventName, MonitorEvent> r15 = r14.next();
        if (r15.getValue().h == UploadMode.TIMER) goto L31;
        boolean r16 = true;
    L32:
        if (r16 == false) goto L27;
        r10.put(r15.getKey(), r15.getValue());
        goto L27
    L31:
        r16 = false;
        goto L32
    L34:
        Iterator r17 = r10.entrySet().iterator();
    L36:
        if (r17.hasNext() == false) goto L47;
        Map.Entry r18 = (Map.Entry) r17.next();
        HashMap r19 = new HashMap();
        r19.putAll(((MonitorEvent) r18.getValue()).a(this.h));
        if (UploadMode.LOOP != ((MonitorEvent) r18.getValue()).h) goto L43;
        long r20 = r13 % ((long) 60000);
        if (r20 >= this.g) goto L44;
        boolean r21 = false;
    L45:
        if (r21 == false) goto L36;
        j(r19, r11, Long.valueOf(r20));
        j0.l().sendLog(((EventName) r18.getKey()).getStr(), r19, new Object[0]);
        ((MonitorEvent) r18.getValue()).d();
        r19.clear();
    L44:
        r21 = true;
        goto L45
    L43:
        r20 = r13;
        goto L44
    L47:
        Iterator r110 = ((ArrayList) this.c).iterator();
    L49:
        if (r110.hasNext() == false) goto L73;
        ((f) r110.next()).a();
        goto L49
    }

    public static void j(HashMap r7, UploadMode r8, Long r9) {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L48;
        Float r4 = null;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L50;
        m r2 = r1.getRoom();
        if (r2 == null) goto L49;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L51;
        r7.put("room_id", String.valueOf(r3.getId()));
        r7.put("anchor_id", String.valueOf(r3.getAnchorId()));
        String r5 = "1";
        if (Intrinsics.areEqual(r1.isAnchor(), Boolean.TRUE) == false) goto L15;
        Object r6 = "1";
    L16:
        r7.put("is_anchor", r6);
        IMiddlewareUserService r10 = k.f(IMiddlewareUserService.class);
        if (r10 == null) goto L24;
        e r11 = r10.user();
        if (r11 == null) goto L24;
        IBaseUser r13 = r11.b();
        if (r13 == null) goto L24;
        String r14 = r13.getIdString();
        if (r14 == null) goto L24;
    L25:
        r7.put("user_id", r14);
        r7.put("upload_mode", r8.getMode());
        if (r9 == null) goto L28;
        r7.put("stat_duration", String.valueOf(r9.longValue()));
    L28:
        r1.N1();
        r7.put("current_acu", CardLockInfo.sUNKNOWN);
        LiveMode r15 = r3.getStreamType();
        int r16 = h1.a;
        r7.put("room_type", i1.a(r15));
        if (r3.isMergeVSRoom() == false) goto L32;
        String r17 = "vs";
    L35:
        r7.put("room_scene", r17);
        if ((!Intrinsics.areEqual(r1.isPortraitInteraction(), Boolean.FALSE)) == true) goto L39;
        r5 = "0";
    L39:
        r7.put("is_portrait", r5);
        IInteractivityInjectService r18 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r18 == null) goto L46;
        Boolean r19 = r1.isAnchor();
        if (r19 == null) goto L44;
        boolean r20 = r19.booleanValue();
    L45:
        r4 = Float.valueOf(r18.getScore(r20));
        goto L46
    L44:
        r20 = false;
    L46:
        r7.put("device_score", String.valueOf(r4));
        return;
    L32:
        if (r3.isMediaRoom() == false) goto L34;
        r17 = "media";
        goto L35
    L34:
        r17 = "normal";
    L24:
        r14 = BuildConfig.FLAVOR;
        goto L25
    L15:
        r6 = "0";
        goto L16
    L51:
        return;
    L49:
        return;
    L50:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final boolean a(EventName r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "nodeName");
        Intrinsics.checkNotNullParameter(r6, "nodeValue");
        if (this.f == true) goto L5;
        return false;
    L5:
        MonitorEvent r7 = this.a.get(r4);
        if (r7 == null) goto L12;
        Intrinsics.checkNotNullParameter(r5, "nodeName");
        Intrinsics.checkNotNullParameter(r6, "value");
        if (r7.b().containsKey(r5) == true) goto L13;
        r7.b().put(r5, new b(r5, r6));
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final void c(EventName r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "nodeName");
        if (this.f == true) goto L6;
        return;
    L6:
        if (this.a.containsKey(r3) == true) goto L8;
        return;
    L8:
        MonitorEvent r6 = this.a.get(r3);
        if (r6 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "nodeName");
        h r0 = (h) ((LinkedHashMap) r6.b).get(r4);
        if (r0 == null) goto L13;
        r0.b += r5;
        return;
    L13:
        r6.b.put(r4, new h(r4, r5));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final void e(EventName r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "fieldName");
        Intrinsics.checkNotNullParameter(r6, "fieldValue");
        if (this.f == true) goto L6;
        return;
    L6:
        if (this.a.containsKey(r4) == true) goto L8;
        return;
    L8:
        MonitorEvent r7 = this.a.get(r4);
        if (r7 == null) goto L15;
        Intrinsics.checkNotNullParameter(r5, "fieldName");
        Intrinsics.checkNotNullParameter(r6, "fieldValue");
        c r0 = (c) ((LinkedHashMap) r7.c).get(r5);
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r0.b = r6;
        return;
    L13:
        r7.c.put(r5, new c(r5, r6));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.monitor.d
    public final void h(EventName r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "indiName");
        if (this.f == true) goto L6;
        return;
    L6:
        if (this.a.containsKey(r2) == true) goto L8;
        return;
    L8:
        MonitorEvent r5 = this.a.get(r2);
        if (r5 == null) goto L15;
        Intrinsics.checkNotNullParameter(r3, "indicatorName");
        com.bytedance.android.livesdk.interactivity.service.monitor.a r0 = (com.bytedance.android.livesdk.interactivity.service.monitor.a) ((LinkedHashMap) r5.d).get(r3);
        if (r0 == null) goto L13;
        r0.b += r4;
        r0.c++;
        return;
    L13:
        r5.d.put(r3, new com.bytedance.android.livesdk.interactivity.service.monitor.a(r3, r4));
        return;
    }
}
