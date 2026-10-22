package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements k82.d {
    public k82.a a;
    public k82.c b;
    public final c c;
    public final VSInputSectionType d;

    public static final class a {
    }

    public final class b extends k82.c {
        public ImageView c;
        public View d;
        public View e;
        public ImageView f;
        public ImageView g;
        public TextView h;
        public ImageView i;
        public ImageView j;
        public boolean k;
        public boolean l;
        public final Map<VSInputSectionType, ImageView> m;
        public final /* synthetic */ j n;

        public final void b(boolean r4) {
            if (((Boolean) nq1.b.a.getValue()).booleanValue() == false) goto L22;
            if (r4 == true) goto L6;
        L13:
            TextView r0 = this.h;
            if (r0 == null) goto L16;
            r0.setEnabled(false);
        L16:
            TextView r1 = this.h;
            if (r1 == null) goto L19;
            r1.setAlpha(0.34f);
        L19:
            k82.a r2 = this.n.a;
            if (r2 == null) goto L37;
            r2.g(r4);
        L37:
            this.l = r4;
            return;
        L6:
            if (this.k == true) goto L13;
            TextView r3 = this.h;
            if (r3 == null) goto L10;
            r3.setEnabled(true);
        L10:
            TextView r5 = this.h;
            if (r5 == null) goto L19;
            r5.setAlpha(1.0f);
            goto L19
        L22:
            if (r4 == true) goto L24;
        L31:
            ImageView r6 = this.i;
            if (r6 == null) goto L34;
            r6.setImageResource(2131251935);
        L34:
            ImageView r7 = this.i;
            if (r7 == null) goto L37;
            r7.setClickable(false);
            goto L37
        L24:
            if (this.k == true) goto L31;
            ImageView r8 = this.i;
            if (r8 == null) goto L28;
            r8.setImageResource(2131251936);
        L28:
            ImageView r9 = this.i;
            if (r9 == null) goto L37;
            r9.setClickable(true);
            goto L37
        }

        public final void c(VSInputSectionType r4) {
            Iterator r0 = ((LinkedHashMap) this.m).entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            Map.Entry r1 = (Map.Entry) r0.next();
            ImageView r2 = (ImageView) r1.getValue();
            if (r2 == null) goto L4;
            if (((VSInputSectionType) r1.getKey()) != r4) goto L10;
            boolean r3 = true;
        L11:
            r2.setSelected(r3);
            goto L4
        L10:
            r3 = false;
            goto L11
        }

        public b(j r2, View r3, h82.b r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.n = r2;
            super(r3, r4);
            this.m = new LinkedHashMap();
        }
    }

    public static final class c implements j82.c {
        public final /* synthetic */ j a;

        @Override // j82.c
        public final void k() {
            k82.c r0 = this.a.b;
            if ((r0 instanceof b) == true) goto L5;
            r0 = null;
        L5:
            b r1 = (b) r0;
            if (r1 == null) goto L9;
            r1.c(null);
            return;
        }

        public c(j r1) {
            this.a = r1;
        }

        @Override // j82.c
        public final void d(boolean r3) {
            k82.c r0 = this.a.b;
            if ((r0 instanceof b) == true) goto L5;
            r0 = null;
        L5:
            b r1 = (b) r0;
            if (r1 == null) goto L9;
            r1.b(r3);
            return;
        }

        @Override // j82.c
        public final void n(SkinSelection r5) {
            j r0 = this.a;
            k82.c r1 = r0.b;
            DataCenter r3 = null;
            if ((r1 instanceof b) == true) goto L5;
            r1 = null;
        L5:
            b r2 = (b) r1;
            if (r2 == null) goto L19;
            if (r5 == null) goto L16;
            k82.a r4 = r0.a;
            if (r4 == null) goto L13;
            t9 r6 = r4.s();
            if (r6 == null) goto L13;
            r3 = r6.l;
        L13:
            boolean r7 = true;
            if (r5.a(r3) != true) goto L16;
        L17:
            r2.k = r7;
            r2.b(r2.l);
            return;
        L16:
            r7 = false;
            goto L17
        }
    }

    static {
    }

    @Override // k82.d
    public final void a() {
    }

    @Override // k82.d
    public final void d() {
    }

    @Override // k82.d
    public final void e() {
    }

    public j() {
        this.c = new c(this);
        this.d = VSInputSectionType.CONTROL_PORTRAIT;
    }

    @Override // k82.d
    public final VSInputSectionType b() {
        return this.d;
    }

    @Override // k82.d
    public final k82.c c() {
        return this.b;
    }

    @Override // k82.d
    public final View g(h82.b r10) {
        Intrinsics.checkNotNullParameter(r10, "panelBridge");
        Activity r0 = r10.getActivity();
        Map<String, String> r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.a = r10;
        LayoutInflater r2 = LayoutInflater.from(r0);
        t9 r3 = r10.h.d;
        if (r3 != null) goto L8;
    L9:
        if (r3 != null) goto L11;
    L13:
        int r4 = 2131567707;
    L14:
        View r5 = r2.inflate(r4, null);
        final b r6 = new b(this, r5, r10);
        r6.d = r6.a.findViewById(2131367935);
        r6.e = r6.a.findViewById(2131367927);
        r6.c = (ImageView) r6.a.findViewById(2131367926);
        r6.i = (ImageView) r6.a.findViewById(2131375362);
        r6.h = (TextView) r6.a.findViewById(2131375363);
        r6.j = (ImageView) r6.a.findViewById(2131375360);
        r6.g = (ImageView) r6.a.findViewById(2131384100);
        r6.f = (ImageView) r6.a.findViewById(2131367934);
        Map<VSInputSectionType, ImageView> r11 = r6.m;
        r11.put(VSInputSectionType.EMOJI, r6.c);
        r11.put(VSInputSectionType.PAID_LIVE_PACKAGE, r6.f);
        Rect r13 = new Rect();
        r13.top -= UtilityKotlinExtentionsKt.i(5);
        r13.left -= UtilityKotlinExtentionsKt.i(5);
        r13.right += UtilityKotlinExtentionsKt.i(5);
        r13.bottom += UtilityKotlinExtentionsKt.i(5);
        View r7 = r6.e;
        if (r7 == null) goto L21;
        View r8 = r6.e;
        if (r8 == null) goto L19;
        ViewGroup r9 = UtilityKotlinExtentionsKt.p(r8);
    L20:
        r7.setTouchDelegate(new TouchDelegate(r13, r9));
        goto L21
    L19:
        r9 = null;
    L21:
        View r14 = r6.d;
        if (r14 == null) goto L29;
        View r15 = r6.d;
        if (r15 == null) goto L26;
        ViewGroup r16 = UtilityKotlinExtentionsKt.p(r15);
    L27:
        r14.setTouchDelegate(new TouchDelegate(r13, r16));
        goto L29
    L26:
        r16 = null;
    L29:
        if (((Boolean) nq1.b.a.getValue()).booleanValue() == false) goto L46;
        TextView r17 = r6.h;
        if (r17 == null) goto L37;
        TextView r18 = r6.h;
        if (r18 == null) goto L35;
        ViewGroup r19 = UtilityKotlinExtentionsKt.p(r18);
    L36:
        r17.setTouchDelegate(new TouchDelegate(r13, r19));
        goto L37
    L35:
        r19 = null;
    L37:
        TextView r110 = r6.h;
        if (r110 == null) goto L40;
        r110.setOnClickListener(x0.a(new VSMsgBoardPortraitControlSectionProvider$ControlSectionController$init$2(r6)));
    L40:
        TextView r111 = r6.h;
        if (r111 == null) goto L43;
        r111.setVisibility(0);
    L43:
        ImageView r112 = r6.i;
        if (r112 == null) goto L62;
        r112.setVisibility(8);
    L62:
        View r113 = r6.e;
        if (r113 == null) goto L65;
        r113.setOnClickListener(new k(r6));
    L65:
        int r114 = n82.c.a;
        k82.a r115 = r6.n.a;
        if (r115 == null) goto L70;
        t9 r116 = r115.s();
        if (r116 == null) goto L70;
        DataCenter r117 = r116.l;
    L72:
        if (n82.c.d(r117) == false) goto L166;
        View r118 = r6.d;
        if (r118 == null) goto L76;
        UtilityKotlinExtentionsKt.z(r118, true);
    L76:
        k82.a r119 = r6.n.a;
        if (r119 == null) goto L81;
        t9 r120 = r119.s();
        if (r120 == null) goto L81;
        DataCenter r121 = r120.l;
    L82:
        nm1.e r20 = pm1.f.c();
        if (r20 == null) goto L87;
        ReplayDataContext r21 = r20.h(null);
        if (r21 == null) goto L87;
        com.bytedance.live.datacontext.j r23 = r21.getVsMsgBoardDataContext();
    L89:
        if ((r23 instanceof com.bytedance.live.datacontext.j) == true) goto L91;
        r23 = null;
    L91:
        if (r23 == null) goto L94;
        com.bytedance.android.livesdk.chatroom.msgboard.a r24 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r23.getValue();
        if (r24 == null) goto L94;
    L102:
        if (r24 == null) goto L106;
        IRoom r122 = r24.getRoom();
        if (r122 == null) goto L106;
        String r123 = r122.getIdStr();
    L108:
        if (TextUtils.isEmpty(r123) == true) goto L125;
        if (r24 == null) goto L113;
        IRoom r124 = r24.getRoom();
        if (r124 == null) goto L113;
        String r125 = r124.getIdStr();
    L115:
        if (TextUtils.isEmpty(r125) == true) goto L149;
        HashSet r126 = (HashSet) nq1.d.x.getValue();
        if (r126 == null) goto L125;
        if (r24 == null) goto L122;
        IRoom r25 = r24.getRoom();
        if (r25 == null) goto L122;
        String r26 = r25.getIdStr();
    L124:
        if (r126.contains(r26) == true) goto L149;
    L122:
        r26 = null;
    L149:
        boolean r127 = false;
    L151:
        if (r127 == false) goto L159;
        ImageView r128 = r6.g;
        if (r128 == null) goto L155;
        UtilityKotlinExtentionsKt.z(r128, true);
    L155:
        int r129 = l82.a.a;
        k82.a r130 = r6.n.a;
        if (r130 == null) goto L158;
        r1 = r130.o();
    L158:
        l82.a.b(true, r1);
    L172:
        k82.a r131 = r6.n.a;
        if (r131 == null) goto L187;
        t9 r132 = r131.s();
        if (r132 == null) goto L187;
        if (r132.p != true) goto L187;
        ImageView r133 = r6.g;
        if (r133 == null) goto L181;
        UtilityKotlinExtentionsKt.z(r133, false);
    L181:
        ImageView r134 = r6.f;
        if (r134 == null) goto L184;
        r134.setAlpha(0.5f);
    L184:
        View r135 = r6.d;
        if (r135 == null) goto L196;
        r135.setOnClickListener(l.a);
    L196:
        ImageView r136 = r6.j;
        if (r136 == null) goto L199;
        r136.setOnClickListener(new n(r6));
    L199:
        k82.a r137 = r6.n.a;
        if (r137 == null) goto L202;
        r137.y(new o(r6));
    L202:
        r3.a(r6.c, s1.B(2131914438));
        r3.a(r6.i, s1.B(2131914445));
        r3.a(r6.h, s1.B(2131914445));
        r3.a(r6.j, s1.B(2131914425));
        Unit r138 = Unit.INSTANCE;
        this.b = r6;
        return r5;
    L187:
        ImageView r139 = r6.g;
        if (r139 == null) goto L190;
        r139.setBackgroundResource(2131251426);
    L190:
        View r140 = r6.d;
        if (r140 == null) goto L193;
        r140.setOnClickListener(new m(r6));
    L193:
        ImageView r141 = r6.f;
        if (r141 == null) goto L196;
        r141.setAlpha(1.0f);
        goto L196
    L159:
        ImageView r142 = r6.g;
        if (r142 == null) goto L162;
        UtilityKotlinExtentionsKt.z(r142, false);
    L162:
        int r143 = l82.a.a;
        k82.a r144 = r6.n.a;
        if (r144 == null) goto L165;
        r1 = r144.o();
    L165:
        l82.a.b(false, r1);
    L113:
        r125 = null;
    L125:
        if (r24 == null) goto L129;
        Episode r145 = r24.getEpisode();
        if (r145 == null) goto L129;
        String r146 = r145.idStr;
    L131:
        if (TextUtils.isEmpty(r146) == true) goto L150;
        if (r24 == null) goto L136;
        Episode r147 = r24.getEpisode();
        if (r147 == null) goto L136;
        String r148 = r147.idStr;
    L138:
        if (TextUtils.isEmpty(r148) == true) goto L149;
        HashSet r149 = (HashSet) nq1.d.x.getValue();
        if (r149 == null) goto L150;
        if (r24 == null) goto L145;
        Episode r27 = r24.getEpisode();
        if (r27 == null) goto L145;
        String r28 = r27.idStr;
    L147:
        if (r149.contains(r28) == true) goto L149;
    L145:
        r28 = null;
    L136:
        r148 = null;
    L150:
        r127 = true;
    L129:
        r146 = null;
    L106:
        r123 = null;
    L94:
        vr1.u r150 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r121, null, 2);
        if (r150 == null) goto L97;
        com.bytedance.android.livesdk.chatroom.msgboard.a r151 = r150.L0();
    L99:
        if ((r151 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L101;
        r24 = null;
        goto L102
    L101:
        r24 = r151;
        goto L102
    L97:
        r151 = null;
    L87:
        r23 = null;
    L81:
        r121 = null;
        goto L82
    L166:
        View r152 = r6.d;
        if (r152 == null) goto L169;
        UtilityKotlinExtentionsKt.z(r152, false);
    L169:
        ImageView r153 = r6.g;
        if (r153 == null) goto L172;
        UtilityKotlinExtentionsKt.z(r153, false);
    L70:
        r117 = null;
        goto L72
    L46:
        ImageView r29 = r6.i;
        if (r29 == null) goto L53;
        ImageView r30 = r6.i;
        if (r30 == null) goto L51;
        ViewGroup r31 = UtilityKotlinExtentionsKt.p(r30);
    L52:
        r29.setTouchDelegate(new TouchDelegate(r13, r31));
        goto L53
    L51:
        r31 = null;
    L53:
        ImageView r154 = r6.i;
        if (r154 == null) goto L56;
        r154.setOnClickListener(x0.a(new VSMsgBoardPortraitControlSectionProvider$ControlSectionController$init$3(r6)));
    L56:
        TextView r155 = r6.h;
        if (r155 == null) goto L59;
        r155.setVisibility(8);
    L59:
        ImageView r156 = r6.i;
        if (r156 == null) goto L62;
        r156.setVisibility(0);
        goto L62
    L11:
        if (r3.h != true) goto L13;
    L12:
        r4 = 2131567706;
        goto L14
    L8:
        if (r3.g == true) goto L12;
        goto L9
    }

    @Override // k82.d
    public final void h(VSInputSectionType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "sectionType");
        Intrinsics.checkNotNullParameter(r3, "view");
        k82.d.a.a(r2, r3);
        int r4 = p.a[r2.ordinal()];
        if (r4 != 1) goto L5;
        FrameLayout r5 = (FrameLayout) r3.findViewById(2131367927);
        if (r5 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    L16:
        return;
    L5:
        if (r4 != 2) goto L17;
        FrameLayout r6 = (FrameLayout) r3.findViewById(2131367935);
        if (r6 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r6);
        return;
    L14:
        return;
    }
}
