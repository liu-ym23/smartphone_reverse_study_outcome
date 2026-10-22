package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {
    public List<tf0.d> b;
    public List<tf0.d> c;
    public List<tf0.d> d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
    }

    public d() {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    public final void d(nh0.l r14) {
        Intrinsics.checkNotNullParameter(r14, "seatExtraObject");
        int r0 = e.a[r14.getType().ordinal()];
        if (r0 != 1) goto L5;
        List<tf0.d> r1 = this.b;
        ArrayList r6 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L112:
        if (r2.hasNext() == false) goto L130;
        Object r7 = r2.next();
        tf0.d r8 = (tf0.d) r7;
        List<tf0.d> r9 = r14.c;
        if ((r9 instanceof Collection) == true) goto L116;
    L118:
        Iterator<T> r10 = r9.iterator();
    L120:
        if (r10.hasNext() == false) goto L127;
        if (r8.a() != ((tf0.d) r10.next()).a()) goto L124;
        boolean r11 = true;
    L125:
        if (r11 == false) goto L120;
        boolean r12 = false;
    L128:
        if (r12 == false) goto L112;
        r6.add(r7);
        goto L112
    L124:
        r11 = false;
    L127:
        r12 = true;
        goto L128
    L116:
        if (r9.isEmpty() == false) goto L118;
    L130:
        List<tf0.d> r3 = CollectionsKt.toMutableList(r6);
        this.b = r3;
        r3.addAll(r14.c);
    L131:
        gh0.a.b("DynamicHandler", "onSeatExtraObjectUpdate: \n updateByUidList = " + this.b + ", \n updateByPosList = " + this.c + ", \n updateAllList = " + this.d, 4);
        a().y0(new ch0.i(r14.a, this.b, this.c, this.d));
        return;
    L5:
        if (r0 != 2) goto L7;
        Iterator<T> r4 = r14.c.iterator();
    L93:
        if (r4.hasNext() == false) goto L131;
        tf0.d r13 = (tf0.d) r4.next();
        Iterator<T> r15 = this.c.iterator();
    L96:
        if (r15.hasNext() == false) goto L105;
        Object r16 = r15.next();
        tf0.d r17 = (tf0.d) r16;
        if (r17.b() == r13.b()) goto L100;
    L102:
        boolean r18 = false;
    L103:
        if (r18 == false) goto L96;
    L106:
        tf0.d r19 = (tf0.d) r16;
        if (r19 == null) goto L109;
        this.c.remove(r19);
    L109:
        this.c.add(r13);
        goto L93
    L100:
        if (r17.a() != r13.a()) goto L102;
        r18 = true;
        goto L103
    L105:
        r16 = null;
        goto L106
    L7:
        if (r0 == 3) goto L74;
        if (r0 != 4) goto L131;
        if (r14.c.isEmpty() == false) goto L13;
        this.b.clear();
        this.c.clear();
        this.d.clear();
        goto L131
    L13:
        gh0.a.b("DynamicHandler", "onSeatExtraObjectUpdate: \n updateByUidList = " + this.b + ", \n removeList = " + r14.c, 4);
        List<tf0.d> r5 = this.b;
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r5.iterator();
    L15:
        if (r21.hasNext() == false) goto L33;
        Object r22 = r21.next();
        tf0.d r23 = (tf0.d) r22;
        List<tf0.d> r24 = r14.c;
        if ((r24 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r25 = r24.iterator();
    L23:
        if (r25.hasNext() == false) goto L30;
        if (r23.a() != ((tf0.d) r25.next()).a()) goto L27;
        boolean r110 = true;
    L28:
        if (r110 == false) goto L23;
        boolean r26 = false;
    L31:
        if (r26 == false) goto L15;
        r20.add(r22);
        goto L15
    L27:
        r110 = false;
    L30:
        r26 = true;
        goto L31
    L19:
        if (r24.isEmpty() == false) goto L21;
    L33:
        this.b = CollectionsKt.toMutableList(r20);
        List<tf0.d> r27 = this.c;
        ArrayList r28 = new ArrayList();
        Iterator<T> r29 = r27.iterator();
    L35:
        if (r29.hasNext() == false) goto L53;
        Object r30 = r29.next();
        tf0.d r31 = (tf0.d) r30;
        List<tf0.d> r32 = r14.c;
        if ((r32 instanceof Collection) == true) goto L39;
    L41:
        Iterator<T> r33 = r32.iterator();
    L43:
        if (r33.hasNext() == false) goto L50;
        if (r31.a() != ((tf0.d) r33.next()).a()) goto L47;
        boolean r111 = true;
    L48:
        if (r111 == false) goto L43;
        boolean r34 = false;
    L51:
        if (r34 == false) goto L35;
        r28.add(r30);
        goto L35
    L47:
        r111 = false;
    L50:
        r34 = true;
        goto L51
    L39:
        if (r32.isEmpty() == false) goto L41;
    L53:
        this.c = CollectionsKt.toMutableList(r28);
        List<tf0.d> r35 = this.d;
        ArrayList r36 = new ArrayList();
        Iterator<T> r37 = r35.iterator();
    L55:
        if (r37.hasNext() == false) goto L73;
        Object r38 = r37.next();
        tf0.d r39 = (tf0.d) r38;
        List<tf0.d> r40 = r14.c;
        if ((r40 instanceof Collection) == true) goto L59;
    L61:
        Iterator<T> r41 = r40.iterator();
    L63:
        if (r41.hasNext() == false) goto L70;
        if (r39.a() != ((tf0.d) r41.next()).a()) goto L67;
        boolean r112 = true;
    L68:
        if (r112 == false) goto L63;
        boolean r42 = false;
    L71:
        if (r42 == false) goto L55;
        r36.add(r38);
        goto L55
    L67:
        r112 = false;
    L70:
        r42 = true;
        goto L71
    L59:
        if (r40.isEmpty() == false) goto L61;
    L73:
        this.d = CollectionsKt.toMutableList(r36);
        goto L131
    L74:
        Iterator<T> r43 = r14.c.iterator();
    L76:
        if (r43.hasNext() == false) goto L131;
        tf0.d r44 = (tf0.d) r43.next();
        Iterator<T> r45 = this.d.iterator();
    L79:
        if (r45.hasNext() == false) goto L86;
        Object r46 = r45.next();
        if (((tf0.d) r46).a() != r44.a()) goto L83;
        boolean r113 = true;
    L84:
        if (r113 == false) goto L79;
    L87:
        tf0.d r47 = (tf0.d) r46;
        if (r47 == null) goto L90;
        this.d.remove(r47);
    L90:
        this.d.add(r44);
        goto L76
    L83:
        r113 = false;
        goto L84
    L86:
        r46 = null;
        goto L87
    }
}
