package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatDescNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.NormalMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.i;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.ugc.live.sdk.message.data.LimitedSizeHashMap;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r42.p;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements vlc.h, l {
    public final LimitedSizeHashMap a;
    public final List<tlc.d> b;
    public p c;
    public final List<tlc.d> d;
    public boolean e;
    public boolean f;
    public final int g;
    public final a h;
    public Disposable i;
    public final Lazy j;
    public final DataCenter k;
    public final IRoom l;
    public final List<String> m;
    public final vlc.d n;
    public final vlc.h o;
    public final l p;
    public final Function0<Unit> q;

    public final void b() {
        int r0 = r42.a.a;
        r42.a.c("try process first fetch, historyFirstFetchDone: " + this.e + ", realtimeFirstFetchDone: " + this.f);
        boolean r1 = this.e;
        if (r1 == true) goto L5;
    L91:
        if (r1 == false) goto L94;
        z32.f.a(PSRoomStatDescNode.PublicScreenReceiveFirstMessageType, "history");
        return;
    L94:
        if (this.f == false) goto L128;
        z32.f.a(PSRoomStatDescNode.PublicScreenReceiveFirstMessageType, "realtime");
        return;
    L128:
        return;
    L5:
        if (this.f == false) goto L91;
        ArrayList r2 = new ArrayList();
        p r3 = this.c;
        boolean r4 = false;
        if (r3 == null) goto L9;
        boolean r5 = r3.b;
    L11:
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L52;
        p r6 = this.c;
        if (r6 == null) goto L42;
        List<tlc.d> r7 = r6.a;
        if (r7 == null) goto L42;
        List<tlc.d> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        r9.add(Long.valueOf(((tlc.d) r10.next()).getMessageId()));
        goto L18
    L20:
        List<tlc.d> r11 = this.b;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r14 = ((ArrayList) r11).iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        r13.add(Long.valueOf(((tlc.d) r14.next()).getMessageId()));
        goto L22
    L24:
        Set r15 = CollectionsKt.intersect(r9, CollectionsKt.toSet(r13));
        if (r15 == null) goto L42;
        if ((!r15.isEmpty()) == true) goto L30;
        r15 = null;
    L30:
        if (r15 == null) goto L42;
        p r16 = this.c;
        if (r16 == null) goto L42;
        List<tlc.d> r17 = r16.a;
        if (r17 == null) goto L42;
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L37:
        if (r19.hasNext() == false) goto L41;
        Object r20 = r19.next();
        if ((!r15.contains(Long.valueOf(((tlc.d) r20).getMessageId()))) == false) goto L37;
        r18.add(r20);
        goto L37
    L41:
        this.c = new p(r18, r5);
    L42:
        List<tlc.d> r21 = this.b;
        ArrayList r23 = new ArrayList();
        Iterator r24 = ((ArrayList) r21).iterator();
    L44:
        if (r24.hasNext() == false) goto L48;
        Object r25 = r24.next();
        if ((r25 instanceof k0) == false) goto L44;
        r23.add(r25);
        goto L44
    L48:
        Iterator r26 = r23.iterator();
    L50:
        if (r26.hasNext() == false) goto L52;
        ((k0) r26.next()).getOrInitPublicAreaCommon().setFirstAggregateHistoryMessage(true);
    L52:
        p r27 = this.c;
        if (r27 != null) goto L55;
    L74:
        Iterator r28 = ((ArrayList) this.b).iterator();
    L76:
        if (r28.hasNext() == false) goto L80;
        tlc.d r29 = (tlc.d) r28.next();
        if (this.a.containsKey(Long.valueOf(r29.getMessageId())) == true) goto L76;
        r2.add(r29);
        this.a.put(Long.valueOf(r29.getMessageId()), null);
        goto L76
    L80:
        this.o.onFirstMessage(r2, r5);
        Iterator r30 = ((ArrayList) this.d).iterator();
    L82:
        if (r30.hasNext() == false) goto L84;
        this.p.onMessage((tlc.d) r30.next());
        goto L82
    L84:
        this.q.invoke();
        Iterator<T> r31 = this.m.iterator();
    L86:
        if (r31.hasNext() == false) goto L90;
        String r33 = (String) r31.next();
        vlc.d r34 = this.n;
        if (r34 == null) goto L86;
        r34.removeMessageListener(r33, this);
        goto L86
    L90:
        r42.a.c("trigger actual first message listener, dispatch temp realtime messages, then all ready with remove temp realtime listener");
        this.h.a();
        return;
    L55:
        if (r42.g.c() == false) goto L61;
        if (r5 == true) goto L61;
        if (r27.a.size() <= this.g) goto L60;
        r4 = true;
    L60:
        r5 = r4;
    L61:
        Iterator<T> r35 = r27.a.iterator();
    L63:
        if (r35.hasNext() == false) goto L74;
        t r36 = (tlc.d) r35.next();
        r36.setIsFromFirstRequest(true);
        if ((r36 instanceof t) == true) goto L67;
        t r37 = null;
    L68:
        t r38 = r37;
        if (r38 == null) goto L72;
        r38.setIsFirstHistoryMessage(true);
    L72:
        if (this.a.containsKey(Long.valueOf(r36.getMessageId())) == true) goto L63;
        r2.add(r36);
        this.a.put(Long.valueOf(r36.getMessageId()), null);
        goto L63
    L67:
        r37 = r36;
        goto L68
    L9:
        r5 = false;
        goto L11
    }

    public final void a(tlc.d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.e == true) goto L7;
    L9:
        r42.a.c("check and process realtime message, temp store");
        ((ArrayList) this.d).add(r2);
        return;
    L7:
        if (this.f == false) goto L9;
        this.p.onMessage(r2);
    }

    public final void onMessage(tlc.d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isFromFirstRequest() == true) goto L8;
        a(r2);
        return;
    }

    public final void onFirstMessage(List<tlc.d> r5, boolean r6) {
        r42.a.c("on realtime first message");
        ((ArrayList) this.b).clear();
        if (r5 == null) goto L5;
        ((ArrayList) this.b).addAll(r5);
    L5:
        this.f = true;
        i.b.getClass();
        i.b r7 = i.a;
        if (r7 == null) goto L8;
        z32.f.d(PSRoomStatValueNode.ReceiveRealtimeMsgCostTime, System.currentTimeMillis() - r7.c);
        PublicScreenTraceMonitor.l("ReceiveRealtimeMessage", System.currentTimeMillis());
    L8:
        b();
    }

    public c(DataCenter r2, IRoom r3, List r4, vlc.d r5, vlc.h r6, NormalMessageRepoManager.a r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r4, "msgTypes");
        Intrinsics.checkNotNullParameter(r6, "actualOnFirstMessageList");
        Intrinsics.checkNotNullParameter(r7, "actualOnOtherRealtimeMessageList");
        Intrinsics.checkNotNullParameter(r8, "onReady");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.o = r6;
        this.p = r7;
        this.q = r8;
        this.a = new LimitedSizeHashMap(128);
        this.b = new ArrayList();
        this.d = new ArrayList();
        this.g = r42.g.d();
        if (r3 == null) goto L5;
        long r9 = r3.getId();
    L6:
        this.h = new a(r9);
        this.j = LazyKt.lazy(new PublicScreenFirstMessageProcessor$enableHistoryUnderAggregate$2(this));
        r42.a.c("public screen first message processor init");
        if (r5 == null) goto L9;
        r5.n(this);
    L9:
        Iterator r10 = r4.iterator();
    L11:
        if (r10.hasNext() == false) goto L15;
        String r11 = (String) r10.next();
        vlc.d r13 = this.n;
        if (r13 == null) goto L11;
        r13.addMessageListener(r11, this);
        goto L11
    L15:
        return;
    L5:
        r9 = 0;
        goto L6
    }
}
