package com.ss.ugc.live.sdk.msg.dispatch;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends Handler {
    public final /* synthetic */ Dispatcher a;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.os.Handler
    public final void handleMessage(Message r18) {
        Intrinsics.checkNotNullParameter(r18, "msg");
        Dispatcher r2 = this.a;
        r2.getClass();
        int r5 = 1;
        switch(r18.what) {
            case 201: goto L173;
            case 202: goto L28;
            case 203: goto L18;
            case 204: goto L12;
            case 205: goto L6;
            default: goto L342;
        };
    L342:
        return;
    L6:
        if (r2.k() == true) goto L9;
        return;
    L9:
        if (r2.v == false) goto L259;
        r2.v = false;
        return;
    L259:
        return;
    L12:
        if (r2.k() == true) goto L15;
        return;
    L15:
        if (r2.v == true) goto L334;
        r2.v = true;
        ArrayList r0 = new ArrayList(r2.y);
        r0.addAll(r2.x);
        ((ArrayList) r2.y).clear();
        r2.x.clear();
        r2.h(r0);
        return;
    L334:
        return;
    L18:
        if (r2.k() == false) goto L345;
        Object r1 = r18.obj;
        if (r1 == null) goto L26;
        tlc.d r3 = (tlc.d) r1;
        r3.setEnqueueDispatchTime(System.currentTimeMillis());
        ((ArrayList) r2.a).add(r3);
        if (((ArrayList) r2.a).size() <= 0) goto L336;
        r2.m(true, 0);
        return;
    L336:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L345:
        return;
    L28:
        if (r2.k() == false) goto L346;
        dmc.f r4 = r2.s;
        LinkedHashSet<dmc.e> r7 = r4.c;
        dmc.b r8 = r4.b;
        if (r8 == null) goto L103;
        Intrinsics.checkNotNullParameter(r7, "replayMessageListeners");
        r8.a();
        if (r7.isEmpty() == true) goto L45;
        Iterator<T> r9 = r7.iterator();
    L37:
        if (r9.hasNext() == false) goto L45;
        dmc.e r10 = (dmc.e) r9.next();
        if ((r10.a.size() + r10.b.size()) != 1) goto L41;
        boolean r11 = true;
    L43:
        if ((!r11) == false) goto L37;
        boolean r12 = true;
    L46:
        if (r12 == false) goto L83;
        HashMap r13 = new HashMap();
        Iterator<T> r14 = r7.iterator();
    L49:
        if (r14.hasNext() == false) goto L51;
        r13.put((dmc.e) r14.next(), new LinkedList());
        goto L49
    L51:
        Iterator<T> r15 = r8.a.iterator();
    L53:
        if (r15.hasNext() == false) goto L74;
        tlc.d r16 = (tlc.d) r15.next();
        ArrayList r17 = new ArrayList();
        Iterator<T> r19 = r7.iterator();
    L56:
        if (r19.hasNext() == false) goto L67;
        Object r110 = r19.next();
        dmc.e r111 = (dmc.e) r110;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r16, INotificationHitPoint.NoticeType.MESSAGE);
        if (r111.a.contains(Integer.valueOf(r16.getIntType())) == false) goto L60;
    L63:
        boolean r6 = true;
    L64:
        if (r6 == false) goto L56;
        r17.add(r110);
        goto L56
    L60:
        if (r111.b.contains(r16.getMessageMethod()) == true) goto L63;
        r6 = false;
        goto L64
    L67:
        Iterator r20 = r17.iterator();
    L69:
        if (r20.hasNext() == false) goto L53;
        LinkedList r112 = (LinkedList) r13.get((dmc.e) r20.next());
        if (r112 == null) goto L69;
        r112.addLast(r16);
        goto L69
    L74:
        Iterator<T> r21 = r7.iterator();
    L76:
        if (r21.hasNext() == false) goto L103;
        dmc.e r22 = (dmc.e) r21.next();
        List<tlc.d> r113 = r22.c.a((List) r13.get(r22));
        if (r113 == null) goto L76;
        Iterator<T> r114 = r113.iterator();
    L81:
        if (r114.hasNext() == false) goto L76;
        r22.onMessage((tlc.d) r114.next());
        goto L81
    L83:
        Iterator<T> r23 = r7.iterator();
    L85:
        if (r23.hasNext() == false) goto L103;
        dmc.e r24 = (dmc.e) r23.next();
        Integer r115 = (Integer) CollectionsKt.firstOrNull(r24.a);
        if (r115 == null) goto L94;
        List<tlc.d> r116 = r24.c.a(r8.b.get(Integer.valueOf(r115.intValue())));
        if (r116 == null) goto L94;
        Iterator<T> r117 = r116.iterator();
    L92:
        if (r117.hasNext() == false) goto L94;
        r24.onMessage((tlc.d) r117.next());
    L94:
        String r118 = (String) CollectionsKt.firstOrNull(r24.b);
        if (r118 == null) goto L85;
        List<tlc.d> r119 = r24.c.a(r8.c.get(r118));
        if (r119 == null) goto L85;
        Iterator<T> r120 = r119.iterator();
    L100:
        if (r120.hasNext() == false) goto L85;
        r24.onMessage((tlc.d) r120.next());
        goto L100
    L41:
        r11 = false;
    L45:
        r12 = false;
    L103:
        if ((!r7.isEmpty()) == false) goto L105;
        com.ss.ugc.live.sdk.msg.utils.a.c(r4.d, "replay " + r7.size() + " listeners");
    L105:
        r4.c.clear();
        if (r4.a == false) goto L108;
    L113:
        int r25 = ((ArrayList) r2.a).size();
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "before dispatch, message queue size is " + ((ArrayList) r2.a).size());
        Object r26 = r18.obj;
        if (r26 == null) goto L171;
        int r27 = ((Integer) r26).intValue();
        if (r27 > 0) goto L119;
        r27 = r2.k;
    L119:
        if (r25 <= r27) goto L122;
        r25 = r27;
    L122:
        ArrayList r28 = new ArrayList(((ArrayList) r2.a).subList(0, r25));
        int r29 = Math.min(r2.p.a(r28, r2), r28.size());
        ((ArrayList) r2.a).subList(0, r29).clear();
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "expect dispatch size: " + r28.size() + ", actual dispatch size: " + r29);
        int r30 = r28.size() - r29;
        if (r30 <= 0) goto L125;
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "schedule next dispatch immediately due to dispatch not enough");
        r2.m(false, r30);
        return;
    L125:
        boolean r31 = !r2.l.isEmpty();
        if (r31 == false) goto L167;
        if (r31 == false) goto L143;
        LinkedHashMap r32 = new LinkedHashMap();
        Iterator r33 = r28.iterator();
    L130:
        if (r33.hasNext() == false) goto L139;
        Object r34 = r33.next();
        String r35 = ((tlc.d) r34).getMessageMethod();
        if (r35 != null) goto L135;
        r35 = "unknow";
    L135:
        Object r36 = r32.get(r35);
        if (r36 != null) goto L138;
        r36 = new ArrayList();
        r32.put(r35, r36);
    L138:
        ((List) r36).add(r34);
        goto L130
    L139:
        Map r37 = new LinkedHashMap(MapsKt.mapCapacity(r32.size()));
        Iterator r38 = r32.entrySet().iterator();
    L141:
        if (r38.hasNext() == false) goto L144;
        Map.Entry r39 = (Map.Entry) r38.next();
        r37.put(r39.getKey(), Integer.valueOf(((List) r39.getValue()).size()));
    L144:
        Iterator<T> r40 = r2.l.iterator();
    L146:
        if (r40.hasNext() == false) goto L167;
        a r41 = (a) r40.next();
        Integer r42 = (Integer) r37.get(r41.a);
        if (r42 == null) goto L150;
        int r43 = r42.intValue();
    L151:
        int r44 = r41.b;
        if (r43 < r44) goto L153;
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "no need to dispatch ensure, method: " + r41.a + ", expect count per dispatch: " + r41.b + ", current dispatch count: " + r43);
        goto L146
    L153:
        int r45 = r44 - r43;
        ArrayList r46 = new ArrayList();
        Iterator r47 = ((ArrayList) r2.a).iterator();
    L155:
        if (r47.hasNext() == false) goto L160;
        tlc.d r121 = (tlc.d) r47.next();
        if (TextUtils.equals(r41.a, r121.getMessageMethod()) == false) goto L155;
        r46.add(r121);
        r47.remove();
        if (r46.size() < r45) goto L155;
    L160:
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "trigger dispatch ensure, method: " + r41.a + ", expect count per dispatch: " + r41.b + ", find in queue: " + r46.size());
        if ((!r46.isEmpty()) == false) goto L146;
        Iterator r48 = r46.iterator();
    L164:
        if (r48.hasNext() == false) goto L146;
        r2.onMessage((tlc.d) r48.next());
        goto L164
    L150:
        r43 = 0;
        goto L151
    L143:
        r37 = MapsKt.emptyMap();
    L167:
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "after dispatch, message queue size is " + ((ArrayList) r2.a).size());
        if (((ArrayList) r2.a).size() <= 0) goto L339;
        r2.m(true, 0);
        return;
    L339:
        return;
    L171:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L108:
        if (r4.c.isEmpty() == false) goto L113;
        dmc.b r49 = r4.b;
        if (r49 == null) goto L112;
        r49.a.clear();
    L112:
        r4.b = null;
        goto L113
    L346:
        return;
    L173:
        if (r2.k() == false) goto L347;
        Object r50 = r18.obj;
        if (r50 == null) goto L258;
        List r51 = (List) r50;
        r2.q.a += (long) r51.size();
        tlc.d r52 = (tlc.d) CollectionsKt.firstOrNull(r51);
        if (r52 != null) goto L180;
    L218:
        List r53 = r51;
    L219:
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "main thread receive message list, size is " + r51.size());
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "add message list to message queue, size is " + r51.size());
        Iterator r54 = r53.iterator();
    L221:
        if (r54.hasNext() == false) goto L235;
        tlc.d r55 = (tlc.d) r54.next();
        long r56 = r55.getDelayDispatchMs();
        if (r56 > 0) goto L224;
        bmc.a r57 = r2.u.get(r55.getMessageMethod());
        if (r57 == null) goto L229;
        r57.x40();
    L230:
        boolean r58 = true;
    L232:
        if (r58 == true) goto L233;
        r55.setEnqueueDispatchTime(System.currentTimeMillis());
        ((ArrayList) r2.a).add(r55);
        goto L221
    L233:
        r2.onMessage(r55);
        goto L221
    L229:
        if (com.ss.ugc.live.sdk.msg.utils.a.b(r55) == true) goto L230;
        r58 = false;
        goto L232
    L224:
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "delay dispatch message: " + r55.getMessageMethod() + ", delay time: " + r56);
        r2.t.sendMessageDelayed(r2.t.obtainMessage(203, r55), r56);
        goto L221
    L235:
        long r59 = System.currentTimeMillis() - r2.a();
        if (r59 <= 0) goto L240;
        long[] r60 = r2.i;
        int r61 = r2.j;
        r60[r61] = r59;
        int r62 = r61 + 1;
        r2.j = r62;
        if (r62 <= 4) goto L240;
        r2.j = 0;
    L240:
        int r63 = ((ArrayList) r2.a).size();
        long r64 = r2.d();
        long[] r65 = r2.i;
        int r66 = r65.length;
        long r122 = 0;
        int r123 = 0;
    L241:
        if (r123 >= r66) goto L246;
        long r124 = r65[r123];
        if (r124 <= r122) goto L245;
        r122 = r124;
    L245:
        r123 = r123 + 1;
        goto L241
    L246:
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "maxTime: " + r122);
        if (r122 > 0) goto L250;
        r122 = 200;
    L250:
        long r67 = Math.min(r64 + Math.min(r122, 500), r2.o);
        long r68 = r2.n;
        if (r67 >= r68) goto L253;
        r67 = r68;
    L253:
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "message queue size: " + ((ArrayList) r2.a).size() + ", total dispatch time: " + r67);
        int r69 = (int) ((r67 + ((long) 100)) / r2.n);
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "expect dispatch count: " + r69);
        if ((r63 / r69) < 1) goto L256;
        r5 = (r63 + (r69 / 2)) / r69;
    L256:
        r2.k = r5;
        com.ss.ugc.live.sdk.msg.utils.a.a(r2.z, "next time dispatch size: " + r2.k);
        r2.m(false, 0);
        return;
    L180:
        if (r52.isFromFirstRequest() != true) goto L218;
        ArrayList r70 = new ArrayList();
        Iterator r71 = r51.iterator();
    L183:
        if (r71.hasNext() == false) goto L208;
        Object r72 = r71.next();
        tlc.d r73 = (tlc.d) r72;
        if (r73.isFromFirstRequest() == false) goto L204;
        Iterator r74 = ((CopyOnWriteArrayList) r2.b).iterator();
    L189:
        if (r74.hasNext() == false) goto L204;
        vlc.b r125 = (vlc.b) r74.next();
        if (r125.onMessage(r73) == false) goto L189;
        Iterator r75 = ((CopyOnWriteArrayList) r2.d).iterator();
    L194:
        if (r75.hasNext() == false) goto L203;
        vlc.j r126 = (vlc.j) r75.next();
        if ((r125 instanceof ulc.b) == true) goto L198;
        vlc.b r127 = null;
    L199:
        ulc.b r128 = (ulc.b) r127;
        if (r128 == null) goto L202;
        r128.getName();
    L202:
        r126.I(r73);
        goto L194
    L198:
        r127 = r125;
        goto L199
    L203:
        boolean r76 = true;
    L206:
        if ((!r76) == false) goto L183;
        r70.add(r72);
    L204:
        r76 = false;
        goto L206
    L208:
        r53 = new ArrayList(r70);
        com.ss.ugc.live.sdk.msg.utils.a.c(r2.z, "trigger first request listener, listener size: " + ((CopyOnWriteArrayList) r2.c).size());
        Iterator r77 = ((CopyOnWriteArrayList) r2.c).iterator();
    L210:
        if (r77.hasNext() == false) goto L219;
        vlc.h r78 = (vlc.h) r77.next();
        ArrayList r79 = new ArrayList();
        Iterator r80 = r70.iterator();
    L213:
        if (r80.hasNext() == false) goto L217;
        Object r129 = r80.next();
        if (((tlc.d) r129).isFromFirstRequest() == false) goto L213;
        r79.add(r129);
        goto L213
    L217:
        r78.onFirstMessage(r79, r2.z.d);
        goto L210
    L258:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.ss.ugc.live.sdk.message.data.IMessage>");
    }

    public c(Dispatcher r1, Looper r2) {
        this.a = r1;
        super(r2);
    }
}
