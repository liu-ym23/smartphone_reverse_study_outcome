package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements k82.d, i82.i, i82.d {
    public final VSInputSectionType a;
    public k82.a b;
    public NestedScrollView c;
    public Space d;
    public final m82.c e;
    public final m82.b f;
    public final b g;
    public final Context h;

    public static final class a {
    }

    public static final class b implements j82.e {
        public final /* synthetic */ v a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                NestedScrollView r0 = this.a.a.c;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.smoothScrollTo(0, r0.getBottom());     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.v$b$b, reason: collision with other inner class name */
        public static final class RunnableC0166b implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ boolean b;

            public RunnableC0166b(b r1, boolean r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Space r0 = this.a.a.d;     // Catch: Throwable -> L10
                if (r0 != null) goto L5;
                return;
            L5:
                if (this.b == false) goto L7;
                int r1 = 0;
            L8:
                r0.setVisibility(r1);     // Catch: Throwable -> L10
                return;
            L7:
                r1 = 8;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L17;
                throw th;
            }
        }

        @Override // j82.e
        public final void i() {
            m82.b r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.b();
        L5:
            m82.c r1 = this.a.e;
            if (r1 == null) goto L9;
            r1.b();
            return;
        }

        public b(v r1) {
            this.a = r1;
        }

        @Override // j82.e
        public final void j(boolean r2) {
            Space r0 = this.a.d;
            if (r0 == null) goto L8;
            if (r2 == false) goto L6;
            int r3 = 0;
        L7:
            r0.setVisibility(r3);
            goto L8
        L6:
            r3 = 8;
        L8:
            Space r4 = this.a.d;
            if (r4 == null) goto L12;
            r4.post(new a(this));
            return;
        }

        @Override // j82.e
        public final void scrollToTop(boolean r5) {
            NestedScrollView r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.smoothScrollTo(0, 0);
        L5:
            NestedScrollView r1 = this.a.c;
            if (r1 == null) goto L9;
            r1.postDelayed(new RunnableC0166b(this, r5), 300);
            return;
        }
    }

    static {
    }

    @Override // k82.d
    public final k82.c c() {
        return null;
    }

    @Override // k82.d
    public final void a() {
        int r0 = n82.c.a;
        i82.g r1 = this.e.d;
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L6;
        String r3 = r1.c;
        if (r3 == null) goto L6;
    L7:
        k82.a r4 = this.b;
        DataCenter r5 = null;
        if (r4 == null) goto L12;
        t9 r6 = r4.s();
        if (r6 == null) goto L12;
        DataCenter r7 = r6.l;
    L13:
        VSMsgBoardDress r8 = n82.c.j(r3, r7);
        i82.a r9 = this.f.e;
        if (r9 == null) goto L19;
        String r10 = r9.c;
        if (r10 == null) goto L19;
        r2 = r10;
    L19:
        k82.a r11 = this.b;
        if (r11 == null) goto L24;
        t9 r13 = r11.s();
        if (r13 == null) goto L24;
        DataCenter r14 = r13.l;
    L25:
        VSMsgBoardDress r15 = n82.c.e(r2, r14);
        k82.a r16 = this.b;
        if (r16 == null) goto L30;
        t9 r17 = r16.s();
        if (r17 == null) goto L30;
        DataCenter r18 = r17.l;
    L32:
        if (n82.c.b(r8, r18) != true) goto L40;
        k82.a r19 = this.b;
        if (r19 == null) goto L39;
        t9 r20 = r19.s();
        if (r20 == null) goto L39;
        r5 = r20.l;
    L39:
        if (n82.c.b(r15, r5) != true) goto L40;
        return;
    L40:
        i82.g r21 = this.e.d;
        if (r21 == null) goto L45;
        r21.c = String.valueOf(0);
        ((me.drakeet.multitype.b) r21).a.notifyDataSetChanged();
        i82.i r23 = r21.h;
        if (r23 == null) goto L45;
        r23.f();
    L45:
        i82.a r24 = this.f.e;
        if (r24 == null) goto L52;
        r24.c = String.valueOf(0);
        ((me.drakeet.multitype.b) r24).a.notifyDataSetChanged();
        i82.d r25 = r24.e;
        if (r25 == null) goto L53;
        r25.k();
        return;
    L53:
        return;
    L52:
        return;
    L30:
        r18 = null;
    L24:
        r14 = null;
    L12:
        r7 = null;
    L6:
        r3 = BuildConfig.FLAVOR;
        goto L7
    }

    @Override // k82.d
    public final void d() {
        int r0 = n82.c.a;
        k82.a r1 = this.b;
        List r2 = null;
        if (r1 == null) goto L7;
        t9 r3 = r1.s();
        if (r3 == null) goto L7;
        DataCenter r4 = r3.l;
    L8:
        com.bytedance.android.livesdk.chatroom.msgboard.b r5 = n82.c.i(r4);
        if (r5 == null) goto L11;
        List r6 = r5.a();
    L13:
        if ((!CollectionUtils.isEmpty(r6)) == false) goto L15;
        this.f.getClass();
    L15:
        k82.a r7 = this.b;
        if (r7 == null) goto L20;
        t9 r8 = r7.s();
        if (r8 == null) goto L20;
        DataCenter r9 = r8.l;
    L21:
        com.bytedance.android.livesdk.chatroom.msgboard.b r10 = n82.c.i(r9);
        if (r10 == null) goto L25;
        r2 = r10.c();
    L25:
        if ((!CollectionUtils.isEmpty(r2)) == false) goto L28;
        this.e.getClass();
        return;
    L28:
        return;
    L20:
        r9 = null;
        goto L21
    L11:
        r6 = null;
    L7:
        r4 = null;
        goto L8
    }

    @Override // k82.d
    public final void e() {
        int r0 = VSInputPanelSectionContainer.k;
        k82.a r1 = this.b;
        if (r1 != null) goto L5;
    L6:
        k82.a r2 = this.b;
        if (r2 == null) goto L9;
        r0 = r2.t();
    L10:
        NestedScrollView r3 = this.c;
        if (r3 == null) goto L13;
        a1.k(r3, r0);
    L13:
        NestedScrollView r4 = this.c;
        if (r4 == null) goto L16;
        r4.requestLayout();
    L16:
        nm1.e r5 = pm1.f.c();
        String r6 = null;
        if (r5 == null) goto L21;
        ReplayDataContext r7 = r5.h(null);
        if (r7 == null) goto L21;
        com.bytedance.live.datacontext.j r8 = r7.getVsMsgBoardDataContext();
    L23:
        if ((r8 instanceof com.bytedance.live.datacontext.j) == true) goto L25;
        r8 = null;
    L25:
        if (r8 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.msgboard.a r9 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r8.getValue();
        if (r9 == null) goto L28;
    L41:
        com.bytedance.android.livesdk.sharedpref.e r10 = nq1.d.x;
        HashSet r11 = (HashSet) r10.getValue();
        if (r9 == null) goto L46;
        IRoom r13 = r9.getRoom();
        if (r13 == null) goto L46;
        String r14 = r13.getIdStr();
    L48:
        if (TextUtils.isEmpty(r14) == true) goto L56;
        if (r11 == null) goto L56;
        if (r9 == null) goto L54;
        IRoom r15 = r9.getRoom();
        if (r15 == null) goto L54;
        String r16 = r15.getIdStr();
    L55:
        r11.add(r16);
    L54:
        r16 = null;
    L56:
        if (r9 == null) goto L60;
        Episode r17 = r9.getEpisode();
        if (r17 == null) goto L60;
        String r18 = r17.idStr;
    L62:
        if (TextUtils.isEmpty(r18) == true) goto L70;
        if (r11 == null) goto L70;
        if (r9 == null) goto L68;
        Episode r19 = r9.getEpisode();
        if (r19 == null) goto L68;
        String r20 = r19.idStr;
    L69:
        r11.add(r20);
    L68:
        r20 = null;
    L70:
        if (r11 == null) goto L83;
        if (r9 == null) goto L78;
        IRoom r21 = r9.getRoom();
        if (r21 == null) goto L78;
        String r23 = r21.getIdStr();
        if (r23 == null) goto L78;
        r6 = r23;
    L82:
        r11.add(r6);
    L78:
        if (r9 == null) goto L82;
        Episode r24 = r9.getEpisode();
        if (r24 == null) goto L82;
        r6 = r24.idStr;
    L83:
        com.bytedance.android.livesdk.sharedpref.f.d(r10, r11);
        NestedScrollView r25 = this.c;
        if (r25 == null) goto L86;
        r25.scrollTo(0, 0);
    L86:
        m82.c r26 = this.e;
        if (r26 == null) goto L91;
        MultiTypeAdapter r27 = r26.e;
        if (r27 == null) goto L91;
        r27.notifyDataSetChanged();
    L91:
        m82.b r28 = this.f;
        if (r28 == null) goto L97;
        MultiTypeAdapter r29 = r28.c;
        if (r29 == null) goto L98;
        r29.notifyDataSetChanged();
        return;
    L98:
        return;
    L97:
        return;
    L60:
        r18 = null;
    L46:
        r14 = null;
    L28:
        k82.a r30 = this.b;
        if (r30 == null) goto L33;
        t9 r31 = r30.s();
        if (r31 == null) goto L33;
        DataCenter r33 = r31.l;
    L34:
        vr1.u r34 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r33, null, 2);
        if (r34 == null) goto L37;
        r9 = r34.L0();
    L39:
        if ((r9 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L41;
        r9 = null;
        goto L41
    L37:
        r9 = null;
    L33:
        r33 = null;
    L21:
        r8 = null;
        goto L23
    L9:
        r0 = 800;
        goto L10
    L5:
        if (r1.t() == 0) goto L10;
        goto L6
    }

    @Override // i82.i
    public final void f() {
        k82.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.D(BuildConfig.FLAVOR);
        return;
    }

    @Override // i82.d
    public final void k() {
        k82.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.C(BuildConfig.FLAVOR);
        return;
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.a;
    }

    public final Context getContext() {
        return this.h;
    }

    public v(Context r2) {
        this.h = r2;
        this.a = VSInputSectionType.PAID_LIVE_PACKAGE;
        this.e = new m82.c(r2, this);
        this.f = new m82.b(r2, this);
        this.g = new b(this);
    }

    @Override // k82.d
    public final View g(h82.b r10) {
        Intrinsics.checkNotNullParameter(r10, "panelBridge");
        this.b = r10;
        LayoutInflater r0 = LayoutInflater.from(this.h);
        t9 r1 = r10.h.d;
        if (r1 != null) goto L5;
    L7:
        if (r1 != null) goto L9;
    L11:
        int r2 = 2131567435;
    L12:
        Boolean r3 = null;
        View r4 = r0.inflate(r2, null);
        if ((r4 instanceof NestedScrollView) == true) goto L15;
        r4 = null;
    L15:
        this.c = (NestedScrollView) r4;
        int r5 = n82.c.a;
        t9 r6 = r10.h.d;
        if (r6 == null) goto L18;
        DataCenter r7 = r6.l;
    L19:
        n82.c.i(r7);
        NestedScrollView r8 = this.c;
        if (r8 == null) goto L22;
        LinearLayout r9 = (LinearLayout) r8.findViewById(2131389768);
    L23:
        if (r9 == null) goto L25;
        Space r11 = (Space) r9.findViewById(2131371596);
    L26:
        this.d = r11;
        nm1.e r13 = pm1.f.c();
        if (r13 == null) goto L31;
        ReplayDataContext r14 = r13.h(null);
        if (r14 == null) goto L31;
        com.bytedance.live.datacontext.j r15 = r14.getVsMsgBoardDataContext();
    L33:
        if ((r15 instanceof com.bytedance.live.datacontext.j) == true) goto L35;
        r15 = null;
    L35:
        if (r15 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.msgboard.a r16 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r15.getValue();
        if (r16 == null) goto L38;
    L49:
        t9 r17 = r10.h.d;
        if (r17 == null) goto L52;
        DataCenter r18 = r17.l;
    L53:
        com.bytedance.android.livesdk.chatroom.msgboard.b r19 = n82.c.i(r18);
        if (r19 == null) goto L56;
        List r20 = r19.a();
    L58:
        if ((!CollectionUtils.isEmpty(r20)) == false) goto L104;
        if (r9 == null) goto L104;
        m82.b r21 = this.f;
        r21.f = r16;
        r21.g = r10;
        t9 r23 = r10.h.d;
        if (r23 == null) goto L63;
        DataCenter r24 = r23.l;
    L64:
        com.bytedance.android.livesdk.chatroom.msgboard.b r25 = n82.c.i(r24);
        if (r25 == null) goto L67;
        List r26 = r25.a();
    L69:
        if (CollectionUtils.isEmpty(r26) == true) goto L103;
        LayoutInflater r27 = LayoutInflater.from(r21.h);
        t9 r28 = r10.h.d;
        if (r28 != null) goto L73;
    L74:
        if (r28 != null) goto L76;
    L78:
        int r29 = 2131567479;
    L79:
        View r30 = r27.inflate(r29, null);
        r21.a = r30;
        if (r30 == null) goto L82;
        TextView r31 = (TextView) r30.findViewById(2131388884);
    L83:
        r21.b = r31;
        View r33 = r21.a;
        if (r33 == null) goto L86;
        OverScrollRecyclerView r34 = (OverScrollRecyclerView) r33.findViewById(2131379755);
    L87:
        r21.d = r34;
        r21.e = new i82.a(r21.i, r10, r21.d);
        OverScrollRecyclerView r35 = r21.d;
        if (r35 == null) goto L90;
        r35.addItemDecoration(m82.a.a(r10));
    L90:
        OverScrollRecyclerView r36 = r21.d;
        if (r36 == null) goto L93;
        r36.setLayoutManager(new LinearLayoutManager(r21.h, 0, false));
    L93:
        MultiTypeAdapter r37 = r21.c;
        i82.a r38 = r21.e;
        if (r38 == null) goto L103;
        r37.z2(VSMsgBoardDress.class, r38);
        OverScrollRecyclerView r39 = r21.d;
        if (r39 == null) goto L99;
        r39.setAdapter(r21.c);
    L99:
        OverScrollRecyclerView r40 = r21.d;
        if (r40 == null) goto L102;
        r40.r();
    L102:
        r21.b();
        goto L103
    L86:
        r34 = null;
        goto L87
    L82:
        r31 = null;
        goto L83
    L76:
        if (r28.h != true) goto L78;
    L77:
        r29 = 2131567478;
        goto L79
    L73:
        if (r28.g == true) goto L77;
    L103:
        r9.addView(r21.a, 0);
        goto L104
    L67:
        r26 = null;
        goto L69
    L63:
        r24 = null;
    L104:
        t9 r41 = r10.h.d;
        if (r41 == null) goto L107;
        DataCenter r43 = r41.l;
    L108:
        com.bytedance.android.livesdk.chatroom.msgboard.b r44 = n82.c.i(r43);
        if (r44 == null) goto L111;
        List r45 = r44.c();
    L113:
        if ((!CollectionUtils.isEmpty(r45)) == false) goto L159;
        if (r9 == null) goto L159;
        m82.c r46 = this.e;
        r46.f = r16;
        r46.g = r10;
        t9 r47 = r10.h.d;
        if (r47 == null) goto L118;
        DataCenter r48 = r47.l;
    L119:
        com.bytedance.android.livesdk.chatroom.msgboard.b r49 = n82.c.i(r48);
        if (r49 == null) goto L122;
        List r50 = r49.c();
    L124:
        if (CollectionUtils.isEmpty(r50) == true) goto L158;
        LayoutInflater r51 = LayoutInflater.from(r46.h);
        t9 r53 = r10.h.d;
        if (r53 != null) goto L128;
    L129:
        if (r53 != null) goto L131;
    L133:
        int r54 = 2131567481;
    L134:
        View r55 = r51.inflate(r54, null);
        r46.a = r55;
        if (r55 == null) goto L137;
        TextView r56 = (TextView) r55.findViewById(2131388905);
    L138:
        r46.b = r56;
        View r57 = r46.a;
        if (r57 == null) goto L141;
        OverScrollRecyclerView r58 = (OverScrollRecyclerView) r57.findViewById(2131386824);
    L142:
        r46.c = r58;
        r46.d = new i82.g(r46.c, r46.f, r10, r46.i);
        OverScrollRecyclerView r59 = r46.c;
        if (r59 == null) goto L145;
        r59.addItemDecoration(m82.a.a(r10));
    L145:
        OverScrollRecyclerView r60 = r46.c;
        if (r60 == null) goto L148;
        r60.setLayoutManager(new LinearLayoutManager(r46.h, 0, false));
    L148:
        MultiTypeAdapter r61 = r46.e;
        i82.g r63 = r46.d;
        if (r63 == null) goto L158;
        r61.z2(VSMsgBoardDress.class, r63);
        OverScrollRecyclerView r64 = r46.c;
        if (r64 == null) goto L154;
        r64.setAdapter(r46.e);
    L154:
        OverScrollRecyclerView r65 = r46.c;
        if (r65 == null) goto L157;
        r65.r();
    L157:
        r46.b();
        goto L158
    L141:
        r58 = null;
        goto L142
    L137:
        r56 = null;
        goto L138
    L131:
        if (r53.h != true) goto L133;
    L132:
        r54 = 2131567480;
        goto L134
    L128:
        if (r53.g == true) goto L132;
    L158:
        r9.addView(r46.a, 0);
        goto L159
    L122:
        r50 = null;
        goto L124
    L118:
        r48 = null;
    L159:
        t9 r66 = r10.h.d;
        if (r66 == null) goto L162;
        DataCenter r67 = r66.l;
    L163:
        if (r66 == null) goto L165;
        Boolean r68 = Boolean.valueOf(r66.p);
    L166:
        String r69 = n82.c.g(r67, r68);
        k82.a r70 = this.b;
        if (r70 == null) goto L169;
        r70.C(r69);
    L169:
        t9 r110 = r10.h.d;
        if (r110 == null) goto L172;
        DataCenter r71 = r110.l;
    L173:
        if (r110 == null) goto L175;
        r3 = Boolean.valueOf(r110.p);
    L175:
        String r111 = n82.c.h(r71, r3);
        k82.a r73 = this.b;
        if (r73 == null) goto L179;
        r73.D(r111);
    L179:
        return this.c;
    L172:
        r71 = null;
        goto L173
    L165:
        r68 = null;
        goto L166
    L162:
        r67 = null;
        goto L163
    L111:
        r45 = null;
        goto L113
    L107:
        r43 = null;
        goto L108
    L56:
        r20 = null;
        goto L58
    L52:
        r18 = null;
    L38:
        t9 r74 = r10.h.d;
        if (r74 == null) goto L41;
        DataCenter r75 = r74.l;
    L42:
        vr1.u r76 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r75, null, 2);
        if (r76 == null) goto L45;
        r16 = r76.L0();
    L47:
        if ((r16 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L49;
        r16 = null;
        goto L49
    L45:
        r16 = null;
        goto L47
    L41:
        r75 = null;
    L31:
        r15 = null;
        goto L33
    L25:
        r11 = null;
        goto L26
    L22:
        r9 = null;
        goto L23
    L18:
        r7 = null;
        goto L19
    L9:
        if (r1.g != true) goto L11;
        r2 = 2131567433;
        goto L12
    L5:
        if (r1.h != true) goto L7;
        r2 = 2131567436;
        goto L12
    }

    @Override // i82.d
    public final void i(VSMsgBoardDress r7) {
        int r0 = l82.a.a;
        Long r1 = null;
        if (r7 == null) goto L5;
        String r2 = String.valueOf(r7.getDressId());
    L6:
        int r3 = n82.c.a;
        if (r7 == null) goto L9;
        String r4 = String.valueOf(r7.getDressId());
    L10:
        k82.a r5 = this.b;
        if (r5 == null) goto L15;
        t9 r6 = r5.s();
        if (r6 == null) goto L15;
        DataCenter r8 = r6.l;
    L16:
        boolean r9 = n82.c.a(r4, r8);
        boolean r10 = true;
        if (r7 != null) goto L19;
    L22:
        k82.a r11 = this.b;
        if (r11 == null) goto L25;
        Map<String, String> r13 = r11.o();
    L26:
        l82.a.c(r2, r9, false, r10, r13);
        k82.a r14 = this.b;
        if (r14 == null) goto L32;
        if (r7 == null) goto L30;
        r1 = Long.valueOf(r7.getDressId());
    L30:
        r14.C(String.valueOf(r1));
        return;
    L32:
        return;
    L25:
        r13 = null;
        goto L26
    L19:
        if (r7.getPaidType() != 1) goto L22;
        r10 = false;
    L15:
        r8 = null;
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // i82.i
    public final void j(VSMsgBoardDress r7) {
        int r0 = l82.a.a;
        Long r1 = null;
        if (r7 == null) goto L5;
        String r2 = String.valueOf(r7.getDressId());
    L6:
        int r3 = n82.c.a;
        if (r7 == null) goto L9;
        String r4 = String.valueOf(r7.getDressId());
    L10:
        k82.a r5 = this.b;
        if (r5 == null) goto L15;
        t9 r6 = r5.s();
        if (r6 == null) goto L15;
        DataCenter r8 = r6.l;
    L16:
        boolean r9 = n82.c.a(r4, r8);
        if (r7 != null) goto L19;
    L22:
        boolean r10 = true;
    L23:
        k82.a r11 = this.b;
        if (r11 == null) goto L26;
        Map<String, String> r13 = r11.o();
    L27:
        l82.a.c(r2, r9, true, r10, r13);
        k82.a r14 = this.b;
        if (r14 == null) goto L33;
        if (r7 == null) goto L31;
        r1 = Long.valueOf(r7.getDressId());
    L31:
        r14.D(String.valueOf(r1));
        return;
    L33:
        return;
    L26:
        r13 = null;
        goto L27
    L19:
        if (r7.getPaidType() != 1) goto L22;
        r10 = false;
    L15:
        r8 = null;
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // k82.d
    public final void h(VSInputSectionType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionType");
        Intrinsics.checkNotNullParameter(r3, "view");
        k82.d.a.a(r2, r3);
    }
}
