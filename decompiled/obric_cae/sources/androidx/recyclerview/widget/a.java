package androidx.recyclerview.widget;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a implements p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0.d f2419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f2420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f2421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0020a f2422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f2423e;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0020a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f2426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2427d;

        public b(int r8, int r10, int r11, Object r12) {
            this.f2424a = r8;
            this.f2425b = r10;
            this.f2427d = r11;
            this.f2426c = r12;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L37:
            return false;
        L8:
            if (b.class != r8.getClass()) goto L37;
            b r10 = (b) r8;
            int r11 = this.f2424a;
            if (r11 == r10.f2424a) goto L14;
            return false;
        L14:
            if (r11 != 8) goto L23;
            if (Math.abs(this.f2427d - this.f2425b) != 1) goto L23;
            if (this.f2427d != r10.f2425b) goto L23;
            if (this.f2425b != r10.f2427d) goto L23;
            return true;
        L23:
            if (this.f2427d == r10.f2427d) goto L26;
            return false;
        L26:
            if (this.f2425b == r10.f2425b) goto L28;
            return false;
        L28:
            Object r12 = this.f2426c;
            if (r12 == null) goto L34;
            if (r12.equals(r10.f2426c) == true) goto L36;
            return false;
        L36:
            return true;
        L34:
            if (r10.f2426c == null) goto L36;
            return false;
        }

        public final int hashCode() {
            return (((this.f2424a * 31) + this.f2425b) * 31) + this.f2427d;
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder();
            r8.append(Integer.toHexString(System.identityHashCode(this)));
            r8.append("[");
            int r10 = this.f2424a;
            if (r10 != 1) goto L5;
            String r11 = "add";
        L15:
            r8.append(r11);
            r8.append(",s:");
            r8.append(this.f2425b);
            r8.append("c:");
            r8.append(this.f2427d);
            r8.append(",p:");
            r8.append(this.f2426c);
            r8.append("]");
            return r8.toString();
        L5:
            if (r10 != 2) goto L7;
            r11 = "rm";
            goto L15
        L7:
            if (r10 != 4) goto L9;
            r11 = "up";
            goto L15
        L9:
            if (r10 == 8) goto L11;
            r11 = "??";
            goto L15
        L11:
            r11 = "mv";
            goto L15
        }
    }

    public a(RecyclerView.f r8) {
        this.f2419a = new i0.d(30);
        this.f2420b = new ArrayList();
        this.f2421c = new ArrayList();
        this.f2422d = r8;
        this.f2423e = new p(this);
    }

    public final boolean a(int r10) {
        ArrayList<b> r8 = this.f2421c;
        int r11 = r8.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L17;
        b r13 = r8.get(r12);
        int r14 = r13.f2424a;
        if (r14 == 8) goto L7;
        if (r14 != 1) goto L16;
        int r15 = r13.f2425b;
        int r16 = r13.f2427d + r15;
    L11:
        if (r15 >= r16) goto L16;
        if (f(r15, r12 + 1) == r10) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        return true;
    L16:
        r12 = r12 + 1;
        goto L3
    L7:
        if (f(r13.f2427d, r12 + 1) != r10) goto L16;
        return true;
    L17:
        return false;
    }

    public final void b() {
        ArrayList<b> r8 = this.f2421c;
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        b r12 = r8.get(r11);
        ((RecyclerView.f) this.f2422d).a(r12);
        r11 = r11 + 1;
        goto L3
    L5:
        l(r8);
    }

    public final void c() {
        b();
        ArrayList<b> r8 = this.f2420b;
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L18;
        b r12 = r8.get(r11);
        int r13 = r12.f2424a;
        InterfaceC0020a r14 = this.f2422d;
        if (r13 != 1) goto L7;
        RecyclerView.f r15 = (RecyclerView.f) r14;
        r15.a(r12);
        int r16 = r12.f2425b;
        int r17 = r12.f2427d;
        RecyclerView r18 = r15.f2301a;
        r18.offsetPositionRecordsForInsert(r16, r17);
        r18.mItemsAddedOrRemoved = true;
    L17:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r13 != 2) goto L9;
        RecyclerView.f r19 = (RecyclerView.f) r14;
        r19.a(r12);
        int r20 = r12.f2425b;
        int r21 = r12.f2427d;
        RecyclerView r22 = r19.f2301a;
        r22.offsetPositionRecordsForRemove(r20, r21, true);
        r22.mItemsAddedOrRemoved = true;
        r22.mState.f2366c += r21;
        goto L17
    L9:
        if (r13 != 4) goto L11;
        RecyclerView.f r23 = (RecyclerView.f) r14;
        r23.a(r12);
        int r24 = r12.f2425b;
        int r25 = r12.f2427d;
        Object r26 = r12.f2426c;
        RecyclerView r27 = r23.f2301a;
        r27.viewRangeUpdate(r24, r25, r26);
        r27.mItemsChanged = true;
        goto L17
    L11:
        if (r13 != 8) goto L17;
        RecyclerView.f r28 = (RecyclerView.f) r14;
        r28.a(r12);
        int r29 = r12.f2425b;
        int r30 = r12.f2427d;
        RecyclerView r31 = r28.f2301a;
        r31.offsetPositionRecordsForMove(r29, r30);
        r31.mItemsAddedOrRemoved = true;
        goto L17
    L18:
        l(r8);
    }

    public final void d(b r15) {
        int r8 = r15.f2424a;
        if (r8 == 1) goto L38;
        if (r8 == 8) goto L38;
        int r10 = m(r15.f2425b, r8);
        int r11 = r15.f2425b;
        int r12 = r15.f2424a;
        if (r12 == 2) goto L12;
        if (r12 != 4) goto L11;
        int r13 = 1;
    L13:
        int r14 = 1;
        int r16 = 1;
    L14:
        int r17 = r15.f2427d;
        i0.d r18 = this.f2419a;
        if (r14 >= r17) goto L33;
        int r19 = m((r13 * r14) + r15.f2425b, r15.f2424a);
        int r110 = r15.f2424a;
        if (r110 == 2) goto L23;
        if (r110 == 4) goto L21;
    L25:
        boolean r111 = false;
    L26:
        if (r111 == false) goto L28;
        r16 = r16 + 1;
    L32:
        r14 = r14 + 1;
        goto L14
    L28:
        b r20 = h(r110, r10, r16, r15.f2426c);
        e(r20, r11);
        r20.f2426c = null;
        r18.b(r20);
        if (r15.f2424a != 4) goto L31;
        r11 = r11 + r16;
    L31:
        r16 = 1;
        r10 = r19;
        goto L32
    L21:
        if (r19 != (r10 + 1)) goto L25;
    L24:
        r111 = true;
        goto L26
    L23:
        if (r19 != r10) goto L25;
    L33:
        Object r21 = r15.f2426c;
        r15.f2426c = null;
        r18.b(r15);
        if (r16 <= 0) goto L42;
        b r112 = h(r15.f2424a, r10, r16, r21);
        e(r112, r11);
        r112.f2426c = null;
        r18.b(r112);
        return;
    L42:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r15);
    L12:
        r13 = 0;
    L38:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public final void e(b r8, int r10) {
        RecyclerView.f r11 = (RecyclerView.f) this.f2422d;
        r11.a(r8);
        int r12 = r8.f2424a;
        if (r12 != 2) goto L5;
        int r13 = r8.f2427d;
        RecyclerView r14 = r11.f2301a;
        r14.offsetPositionRecordsForRemove(r10, r13, true);
        r14.mItemsAddedOrRemoved = true;
        r14.mState.f2366c += r13;
        return;
    L5:
        if (r12 != 4) goto L8;
        int r15 = r8.f2427d;
        Object r16 = r8.f2426c;
        RecyclerView r17 = r11.f2301a;
        r17.viewRangeUpdate(r10, r15, r16);
        r17.mItemsChanged = true;
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    public final int f(int r8, int r10) {
        ArrayList<b> r11 = this.f2421c;
        int r12 = r11.size();
    L3:
        if (r10 >= r12) goto L27;
        b r13 = r11.get(r10);
        int r14 = r13.f2424a;
        if (r14 != 8) goto L14;
        int r15 = r13.f2425b;
        if (r15 != r8) goto L9;
        r8 = r13.f2427d;
    L26:
        r10 = r10 + 1;
        goto L3
    L9:
        if (r15 >= r8) goto L12;
        r8 = r8 - 1;
    L12:
        if (r13.f2427d > r8) goto L26;
        r8 = r8 + 1;
        goto L26
    L14:
        int r16 = r13.f2425b;
        if (r16 > r8) goto L26;
        if (r14 != 2) goto L24;
        int r17 = r13.f2427d;
        if (r8 < (r16 + r17)) goto L20;
        r8 = r8 - r17;
        goto L26
    L20:
        return -1;
    L24:
        if (r14 != 1) goto L26;
        r8 = r8 + r13.f2427d;
        goto L26
    L27:
        return r8;
    }

    public final boolean g() {
        if (this.f2420b.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final b h(int r8, int r10, int r11, Object r12) {
        b r13 = (b) this.f2419a.a();
        if (r13 == null) goto L7;
        r13.f2424a = r8;
        r13.f2425b = r10;
        r13.f2427d = r11;
        r13.f2426c = r12;
        return r13;
    L7:
        return new b(r8, r10, r11, r12);
    }

    public final void i(b r8) {
        this.f2421c.add(r8);
        int r10 = r8.f2424a;
        InterfaceC0020a r11 = this.f2422d;
        if (r10 != 1) goto L5;
        int r12 = r8.f2425b;
        int r13 = r8.f2427d;
        RecyclerView r14 = ((RecyclerView.f) r11).f2301a;
        r14.offsetPositionRecordsForInsert(r12, r13);
        r14.mItemsAddedOrRemoved = true;
        return;
    L5:
        if (r10 != 2) goto L7;
        int r15 = r8.f2425b;
        int r16 = r8.f2427d;
        RecyclerView r17 = ((RecyclerView.f) r11).f2301a;
        r17.offsetPositionRecordsForRemove(r15, r16, false);
        r17.mItemsAddedOrRemoved = true;
        return;
    L7:
        if (r10 != 4) goto L9;
        int r18 = r8.f2425b;
        int r19 = r8.f2427d;
        Object r20 = r8.f2426c;
        RecyclerView r21 = ((RecyclerView.f) r11).f2301a;
        r21.viewRangeUpdate(r18, r19, r20);
        r21.mItemsChanged = true;
        return;
    L9:
        if (r10 != 8) goto L12;
        int r22 = r8.f2425b;
        int r23 = r8.f2427d;
        RecyclerView r24 = ((RecyclerView.f) r11).f2301a;
        r24.offsetPositionRecordsForMove(r22, r23);
        r24.mItemsAddedOrRemoved = true;
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r8);
    }

    public final void j() {
        ArrayList<b> r8 = this.f2420b;
        p r10 = this.f2423e;
        r10.getClass();
    L3:
        int r11 = r8.size() - 1;
        boolean r12 = false;
    L4:
        int r13 = 8;
        byte r14 = -1;
        if (r11 < 0) goto L12;
        if (r8.get(r11).f2424a != 8) goto L10;
        if (r12 == false) goto L11;
    L13:
        int r15 = 4;
        int r16 = 2;
        if (r11 == (-1)) goto L119;
        int r17 = r11 + 1;
        b r18 = r8.get(r11);
        b r19 = r8.get(r17);
        int r110 = r19.f2424a;
        if (r110 != 1) goto L17;
        int r20 = r18.f2427d;
        int r21 = r19.f2425b;
        if (r20 >= r21) goto L109;
        int r22 = -1;
    L110:
        int r23 = r18.f2425b;
        if (r23 >= r21) goto L113;
        r22 = r22 + 1;
    L113:
        if (r21 > r23) goto L115;
        r18.f2425b = r23 + r19.f2427d;
    L115:
        int r24 = r19.f2425b;
        if (r24 > r20) goto L118;
        r18.f2427d = r20 + r19.f2427d;
    L118:
        r19.f2425b = r24 + r22;
        r8.set(r11, r19);
        r8.set(r17, r18);
        goto L3
    L109:
        r22 = 0;
        goto L110
    L17:
        p.a r25 = r10.f2553a;
        if (r110 != 2) goto L19;
        int r26 = r18.f2425b;
        int r111 = r18.f2427d;
        int r112 = r19.f2425b;
        if (r26 >= r111) goto L51;
        if (r112 == r26) goto L47;
    L49:
        boolean r27 = false;
    L55:
        boolean r28 = r27;
    L57:
        if (r111 < r112) goto L58;
        int r113 = r19.f2427d;
        if (r111 >= (r112 + r113)) goto L64;
        r19.f2427d = r113 - 1;
        r18.f2424a = 2;
        r18.f2427d = 1;
        if (r19.f2427d != 0) goto L3;
        r8.remove(r17);
        a r29 = (a) r25;
        r29.getClass();
        r19.f2426c = null;
        r29.f2419a.b(r19);
    L64:
        int r30 = r18.f2425b;
        int r114 = r19.f2425b;
        if (r30 > r114) goto L67;
        r19.f2425b = r114 + 1;
    L70:
        b r31 = null;
    L71:
        if (r27 == true) goto L72;
        if (r28 == false) goto L87;
        if (r31 == null) goto L81;
        int r32 = r18.f2425b;
        if (r32 <= r31.f2425b) goto L78;
        r18.f2425b = r32 - r31.f2427d;
    L78:
        int r33 = r18.f2427d;
        if (r33 <= r31.f2425b) goto L81;
        r18.f2427d = r33 - r31.f2427d;
    L81:
        int r34 = r18.f2425b;
        if (r34 <= r19.f2425b) goto L84;
        r18.f2425b = r34 - r19.f2427d;
    L84:
        int r35 = r18.f2427d;
        if (r35 > r19.f2425b) goto L99;
    L100:
        r8.set(r11, r19);
        if (r18.f2425b == r18.f2427d) goto L103;
        r8.set(r17, r18);
    L104:
        if (r31 == null) goto L3;
        r8.add(r11, r31);
        goto L3
    L103:
        r8.remove(r17);
    L99:
        r18.f2427d = r35 - r19.f2427d;
        goto L100
    L87:
        if (r31 == null) goto L94;
        int r36 = r18.f2425b;
        if (r36 < r31.f2425b) goto L91;
        r18.f2425b = r36 - r31.f2427d;
    L91:
        int r37 = r18.f2427d;
        if (r37 < r31.f2425b) goto L94;
        r18.f2427d = r37 - r31.f2427d;
    L94:
        int r38 = r18.f2425b;
        if (r38 < r19.f2425b) goto L97;
        r18.f2425b = r38 - r19.f2427d;
    L97:
        r35 = r18.f2427d;
        if (r35 < r19.f2425b) goto L100;
    L72:
        r8.set(r11, r19);
        r8.remove(r17);
        a r39 = (a) r25;
        r39.getClass();
        r18.f2426c = null;
        r39.f2419a.b(r18);
        goto L3
    L67:
        int r115 = r114 + r19.f2427d;
        if (r30 >= r115) goto L70;
        a r116 = (a) r25;
        r31 = r116.h(2, r30 + 1, r115 - r30, null);
        r19.f2427d = r18.f2425b - r19.f2425b;
        goto L71
    L58:
        r19.f2425b = r112 - 1;
        goto L64
    L47:
        if (r19.f2427d != (r111 - r26)) goto L49;
        r27 = true;
        r28 = false;
        goto L57
    L51:
        if (r112 == (r111 + 1)) goto L53;
    L56:
        r28 = true;
        r27 = false;
        goto L57
    L53:
        if (r19.f2427d != (r26 - r111)) goto L56;
        r27 = true;
        goto L55
    L19:
        if (r110 != 4) goto L3;
        int r40 = r18.f2427d;
        int r117 = r19.f2425b;
        if (r40 >= r117) goto L24;
        r19.f2425b = r117 - 1;
    L27:
        b r41 = null;
    L28:
        int r42 = r18.f2425b;
        int r118 = r19.f2425b;
        if (r42 > r118) goto L31;
        r19.f2425b = r118 + 1;
    L34:
        b r43 = null;
    L35:
        r8.set(r17, r18);
        if (r19.f2427d <= 0) goto L38;
        r8.set(r11, r19);
    L39:
        if (r41 == null) goto L41;
        r8.add(r11, r41);
    L41:
        if (r43 == null) goto L3;
        r8.add(r11, r43);
        goto L3
    L38:
        r8.remove(r11);
        a r44 = (a) r25;
        r44.getClass();
        r19.f2426c = null;
        r44.f2419a.b(r19);
        goto L39
    L31:
        int r119 = r118 + r19.f2427d;
        if (r42 >= r119) goto L34;
        int r120 = r119 - r42;
        r43 = ((a) r25).h(4, r42 + 1, r120, r19.f2426c);
        r19.f2427d -= r120;
        goto L35
    L24:
        int r121 = r19.f2427d;
        if (r40 >= (r117 + r121)) goto L27;
        r19.f2427d = r121 - 1;
        r41 = ((a) r25).h(4, r18.f2425b, 1, r19.f2426c);
        goto L28
    L119:
        int r45 = r8.size();
        int r46 = 0;
    L120:
        if (r46 >= r45) goto L194;
        b r122 = r8.get(r46);
        int r123 = r122.f2424a;
        if (r123 == 1) goto L192;
        i0.d r124 = this.f2419a;
        InterfaceC0020a r125 = this.f2422d;
        if (r123 == r16) goto L159;
        if (r123 == r15) goto L130;
        if (r123 != r13) goto L129;
        i(r122);
    L129:
        int r47 = r16;
    L193:
        r46 = r46 + 1;
        r16 = r47;
        r13 = 8;
        r14 = -1;
        r15 = 4;
        goto L120
    L130:
        int r126 = r122.f2425b;
        int r127 = r122.f2427d + r126;
        int r48 = r126;
        int r49 = 0;
    L131:
        if (r126 >= r127) goto L152;
        RecyclerView r128 = ((RecyclerView.f) r125).f2301a;
        RecyclerView.c0 r50 = r128.findViewHolderForPosition(r126, true);
        if (r50 != null) goto L136;
    L134:
        r50 = null;
    L138:
        if (r50 != null) goto L147;
        if (a(r126) == true) goto L147;
        if (r14 != 1) goto L145;
        i(h(4, r48, r49, r122.f2426c));
        r48 = r126;
        r49 = 0;
    L145:
        r14 = 0;
    L150:
        r49 = r49 + 1;
        r126 = r126 + 1;
    L147:
        if (r14 != 0) goto L149;
        d(h(4, r48, r49, r122.f2426c));
        r48 = r126;
        r49 = 0;
    L149:
        r14 = 1;
        goto L150
    L136:
        if (r128.mChildHelper.j(r50.f2281a) == false) goto L138;
    L152:
        if (r49 == r122.f2427d) goto L155;
        Object r51 = r122.f2426c;
        r122.f2426c = null;
        r124.b(r122);
        r122 = h(4, r48, r49, r51);
    L155:
        if (r14 != 0) goto L157;
        d(r122);
    L158:
        r47 = 2;
        goto L193
    L157:
        i(r122);
        goto L158
    L159:
        int r52 = r122.f2425b;
        int r53 = r122.f2427d + r52;
        int r54 = r52;
        int r55 = 0;
        byte r129 = -1;
    L160:
        if (r54 >= r53) goto L186;
        RecyclerView r130 = ((RecyclerView.f) r125).f2301a;
        RecyclerView.c0 r131 = r130.findViewHolderForPosition(r54, true);
        if (r131 != null) goto L165;
    L163:
        r131 = null;
    L167:
        if (r131 != null) goto L177;
        if (a(r54) == true) goto L177;
        if (r129 != 1) goto L174;
        i(h(2, r52, r55, null));
        boolean r132 = true;
    L175:
        byte r56 = 0;
    L181:
        if (r132 == false) goto L183;
        r54 = r54 - r55;
        r53 = r53 - r55;
        r55 = 1;
    L184:
        r54 = r54 + 1;
        r129 = r56;
        goto L160
    L183:
        r55 = r55 + 1;
        goto L184
    L174:
        r132 = false;
    L177:
        if (r129 != 0) goto L179;
        d(h(2, r52, r55, null));
        r132 = true;
    L180:
        r56 = 1;
        goto L181
    L179:
        r132 = false;
        goto L180
    L165:
        if (r130.mChildHelper.j(r131.f2281a) == false) goto L167;
    L186:
        if (r55 == r122.f2427d) goto L188;
        r122.f2426c = null;
        r124.b(r122);
        r47 = 2;
        r122 = h(2, r52, r55, null);
    L189:
        if (r129 != 0) goto L191;
        d(r122);
        goto L193
    L191:
        i(r122);
        goto L193
    L188:
        r47 = 2;
        goto L189
    L192:
        r47 = r16;
        i(r122);
        goto L193
    L194:
        r8.clear();
        return;
    L11:
        r11 = r11 - 1;
        goto L4
    L10:
        r12 = true;
        goto L11
    L12:
        r11 = -1;
        goto L13
    }

    public final void k(b r8) {
        r8.f2426c = null;
        this.f2419a.b(r8);
    }

    public final void l(ArrayList r8) {
        int r10 = r8.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        k((b) r8.get(r11));
        r11 = r11 + 1;
        goto L3
    L5:
        r8.clear();
    }

    public final int m(int r10, int r11) {
        ArrayList<b> r8 = this.f2421c;
        int r12 = r8.size() - 1;
    L4:
        if (r12 < 0) goto L44;
        b r13 = r8.get(r12);
        int r14 = r13.f2424a;
        if (r14 != 8) goto L32;
        int r15 = r13.f2425b;
        int r16 = r13.f2427d;
        if (r15 >= r16) goto L10;
        int r17 = r15;
        int r18 = r16;
    L11:
        if (r10 < r17) goto L26;
        if (r10 > r18) goto L26;
        if (r17 != r15) goto L20;
        if (r11 != 1) goto L17;
        int r19 = r16 + 1;
    L16:
        r13.f2427d = r19;
    L19:
        r10 = r10 + 1;
    L43:
        r12 = r12 - 1;
        goto L4
    L17:
        if (r11 != 2) goto L19;
        r19 = r16 - 1;
        goto L16
    L20:
        if (r11 != 1) goto L23;
        int r20 = r15 + 1;
    L22:
        r13.f2425b = r20;
    L25:
        r10 = r10 - 1;
        goto L43
    L23:
        if (r11 != 2) goto L25;
        r20 = r15 - 1;
    L26:
        if (r10 >= r15) goto L43;
        if (r11 != 1) goto L30;
        r13.f2425b = r15 + 1;
        int r21 = r16 + 1;
    L29:
        r13.f2427d = r21;
        goto L43
    L30:
        if (r11 != 2) goto L43;
        r13.f2425b = r15 - 1;
        r21 = r16 - 1;
        goto L29
    L10:
        r18 = r15;
        r17 = r16;
        goto L11
    L32:
        int r22 = r13.f2425b;
        if (r22 > r10) goto L38;
        if (r14 != 1) goto L36;
        r10 = r10 - r13.f2427d;
        goto L43
    L36:
        if (r14 != 2) goto L43;
        r10 = r10 + r13.f2427d;
        goto L43
    L38:
        if (r11 != 1) goto L41;
        int r23 = r22 + 1;
    L40:
        r13.f2425b = r23;
        goto L43
    L41:
        if (r11 != 2) goto L43;
        r23 = r22 - 1;
        goto L40
    L44:
        int r110 = r8.size() - 1;
    L45:
        if (r110 < 0) goto L56;
        b r24 = r8.get(r110);
        if (r24.f2424a != 8) goto L53;
        int r25 = r24.f2427d;
        if (r25 == r24.f2425b) goto L54;
        if (r25 < 0) goto L54;
    L55:
        r110 = r110 - 1;
    L54:
        r8.remove(r110);
        k(r24);
        goto L55
    L53:
        if (r24.f2427d > 0) goto L55;
    L56:
        return r10;
    }
}
