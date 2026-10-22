package com.bytedance.android.livesdk.clearscreen;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.c31;
import com.bytedance.android.livesdk.config.pg0;
import com.bytedance.android.livesdk.config.qg0;
import com.bytedance.android.livesdk.config.tp0;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdk.widget.y;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends k {
    public static final /* synthetic */ int j0 = 0;
    public final int L;
    public final int M;
    public final int N;
    public int O;
    public final float P;
    public float Q;
    public float R;
    public final int S;
    public final int T;
    public long U;
    public float V;
    public float W;
    public float X;
    public float Y;
    public final float Z;
    public final float a0;
    public float b0;
    public float c0;
    public boolean d0;
    public boolean e0;
    public q f0;
    public boolean g0;
    public final com.bytedance.android.livesdk.widget.b.h h0;
    public MotionEvent i0;

    public static final class a {
        @JvmStatic
        public static o a(GestureDetectLayout r4) {
            y r0 = null;
            if (r4 == null) goto L37;
            f0 r1 = com.bytedance.android.livesdk.widget.b.h.c;
            if (r1 == null) goto L21;
            List r2 = r4.j;
            if (r2 == null) goto L21;
            if (((ArrayList) r2).isEmpty() == true) goto L21;
            Iterator r5 = ((ArrayList) r4.j).iterator();
        L13:
            if (r5.hasNext() == false) goto L21;
            WeakReference r3 = (WeakReference) r5.next();
            if (r3 == null) goto L13;
            if (r3.get() == null) goto L13;
            if (((y) r3.get()).getConfig() != r1) goto L13;
            y r6 = (y) r3.get();
        L22:
            if (r6 != null) goto L24;
            return null;
        L24:
            if ((r6 instanceof o) == false) goto L28;
            r0 = r6;
        L28:
            return (o) r0;
        L21:
            r6 = null;
            goto L22
        L37:
            return null;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void s() {
        this.O = 0;
        A();
        i0.c().post(new p(this));
        super.s();
    }

    public final void A() {
        WeakReference<View> r0 = this.j;
        ViewGroup r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.get();
    L6:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.getChildCount() <= 1) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        r1 = r3;
    L14:
        if (r1 == null) goto L35;
        Sequence r5 = UtilityKotlinExtentionsKt.g(r1);
        if (r5 == null) goto L36;
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L37;
        View r7 = (View) r6.next();
        if ((r7 instanceof IRenderView) == false) goto L19;
        this.V = r7.getLeft();
        this.W = r7.getTop();
        this.X = r7.getRight();
        float r8 = r7.getBottom();
        this.Y = r8;
        float r9 = 2;
        this.b0 = this.Z / r9;
        float r10 = this.W;
        float r11 = r8 - r10;
        float r12 = this.a0;
        if (r11 < r12) goto L24;
        this.c0 = r12 / r9;
        goto L19
    L24:
        this.d0 = true;
        this.c0 = (r8 + r10) / r9;
        goto L19
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L11:
        r4 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void o() {
        HashMap r0 = new HashMap();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        String r2 = "0";
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m r3 = r1.getCleanMode();
        if (r3 == null) goto L10;
        if (((Number) r3.getValue()).intValue() != ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L10;
        String r4 = "0";
    L11:
        r0.put("is_under_screen_clear", r4);
        IUserService r5 = jc1.k.f(IUserService.class);
        if (r5 == null) goto L19;
        com.bytedance.android.livesdk.user.f r6 = r5.user();
        if (r6 == null) goto L19;
        String r7 = r6.n();
        if (r7 == null) goto L19;
        r2 = r7;
    L19:
        r0.put("user_id", r2);
        ClearScreenLogUtils.a.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_pitch_enlarge", r0);
        return;
    L10:
        r4 = "1";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void t() {
        super.t();
        this.c = this.P;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void u() {
        super.u();
        this.Q = 1.0f;
        this.R = 1.0f;
    }

    public final f0 getConfig() {
        return this.h0;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void q() {
        s();
    }

    public final boolean C(MotionEvent r7) {
        if (Intrinsics.areEqual(r7, this.i0) == true) goto L23;
        Integer r0 = null;
        if (r7 == null) goto L7;
        Integer r2 = Integer.valueOf(r7.getAction());
    L8:
        MotionEvent r3 = this.i0;
        if (r3 == null) goto L12;
        r0 = Integer.valueOf(r3.getAction());
    L12:
        if (Intrinsics.areEqual(r2, r0) == false) goto L21;
        if (r7 == null) goto L21;
        if (r7.getAction() != 1) goto L21;
        long r4 = r7.getEventTime();
        MotionEvent r8 = this.i0;
        if (r8 == null) goto L21;
        if (r4 != r8.getEventTime()) goto L21;
        return true;
    L21:
        return false;
    L7:
        r2 = null;
        goto L8
    L23:
        return true;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final boolean a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        if (this.O == 0) goto L6;
        s();
        return true;
    L6:
        super.a(r2);
        return false;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void h(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        int r0 = r10.getPointerCount();
        if (r0 == 2) goto L5;
    L25:
        if (r0 == 1) goto L27;
        return;
    L27:
        if (this.p == true) goto L29;
        return;
    L29:
        if (this.G == true) goto L49;
        int r1 = this.O;
        if (r1 != this.M) goto L34;
        float r2 = r10.getX();
        float r11 = r10.getY();
        super.y((r2 - this.B) + this.D, (r11 - this.C) + this.E);
        this.r = true;
        return;
    L34:
        if (r1 != this.N) goto L51;
        float r3 = r10.getX();
        float r12 = r10.getY();
        float r4 = r3 - this.B;
        float r13 = r12 - this.C;
        if (this.r == false) goto L38;
    L41:
        super.y(r4 + this.D, r13 + this.E);
        this.r = true;
        return;
    L38:
        if (Math.abs(r4) > this.S) goto L41;
        if (Math.abs(r13) > this.S) goto L41;
        return;
    L51:
        return;
    L49:
        return;
    L5:
        if (this.p == false) goto L25;
        if (this.o == false) goto L25;
        if (this.G == true) goto L25;
        this.r = true;
        double r5 = k.z(r10);
        double r6 = r5 - this.d;
        if (r6 != 0.0d) goto L13;
        return;
    L13:
        if (this.q == true) goto L18;
        float r14 = this.Q;
        if (r14 != 1.0f) goto L17;
        this.c = this.P * r14;
        goto L18
    L17:
        this.c = r14;
    L18:
        this.q = true;
        float r15 = (float) ((((double) 1) + (r6 / ((double) s1.y()))) * ((double) this.c));
        float r7 = this.a;
        if (r15 <= r7) goto L21;
        this.d = r5;
        this.c = r7;
        x(r7);
        return;
    L21:
        float r8 = this.b;
        if (r15 >= r8) goto L24;
        this.d = r5;
        this.c = r8;
        x(r8);
        return;
    L24:
        x(Math.max(r8, Math.min(r7, r15)));
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void i(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.getPointerCount() == 2) goto L5;
        return;
    L5:
        if (this.G == true) goto L44;
        int r0 = 0;
        this.o = false;
        this.O = this.M;
        k.b r1 = this.y;
        if (r1 != null) goto L9;
    L11:
        this.A = this.y;
    L12:
        k.b r2 = this.A;
        if (r2 == null) goto L15;
        int r3 = r2.a;
    L16:
        this.B = r4.getX(r4.findPointerIndex(r3));
        k.b r5 = this.A;
        if (r5 == null) goto L19;
        r0 = r5.a;
    L19:
        this.C = r4.getY(r4.findPointerIndex(r0));
        WeakReference<View> r6 = this.j;
        float r7 = 0.0f;
        if (r6 == null) goto L24;
        View r8 = r6.get();
        if (r8 == null) goto L24;
        float r9 = r8.getTranslationX();
    L25:
        this.D = r9;
        WeakReference<View> r10 = this.j;
        if (r10 == null) goto L30;
        View r11 = r10.get();
        if (r11 == null) goto L30;
        r7 = r11.getTranslationY();
    L30:
        this.E = r7;
        if (tp0.a.getValue().booleanValue() == false) goto L45;
        WeakReference<View> r12 = this.k;
        if (r12 == null) goto L37;
        View r13 = r12.get();
        if (r13 == null) goto L37;
        r13.getTranslationX();
    L37:
        WeakReference<View> r14 = this.k;
        if (r14 == null) goto L46;
        View r15 = r14.get();
        if (r15 == null) goto L47;
        r15.getTranslationY();
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L24:
        r9 = 0.0f;
        goto L25
    L15:
        r3 = 0;
        goto L16
    L9:
        if (r1.a != r4.getPointerId(r4.getActionIndex())) goto L11;
        this.A = this.z;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void j(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        this.G = false;
        int r1 = this.O;
        if (r1 != this.N) goto L13;
        if (this.r == false) goto L7;
    L11:
        this.p = false;
    L25:
        if (this.q == false) goto L27;
    L28:
        float r11 = qg0.a.getValue().floatValue();
        if (r11 <= 0) goto L38;
        float r2 = this.Q;
        float r3 = this.R;
        if (r2 >= (r3 / r11)) goto L33;
    L36:
        s();
    L137:
        this.H = false;
        return;
    L33:
        if (r3 <= (((double) r2) + 0.5d)) goto L38;
        if (r2 < 1.1f) goto L36;
    L38:
        if (this.Q > 1.0d) goto L41;
        s();
        goto L137
    L41:
        if (this.d0 == false) goto L87;
        WeakReference<View> r12 = this.j;
        if (r12 == null) goto L126;
        View r13 = r12.get();
        if (r13 == null) goto L126;
        float r4 = this.X - this.V;
        float r5 = this.Y - this.W;
        float r6 = this.Q;
        float r7 = r4 * r6;
        float r8 = r6 * r5;
        float r9 = 2;
        float r14 = (r7 - this.Z) / r9;
        float r15 = r13.getTranslationX();
        float r16 = r13.getTranslationY();
        if (r7 > this.Z) goto L49;
    L54:
        r14 = r15;
    L55:
        float r17 = r8 / r9;
        float r18 = this.c0;
        float r19 = r17 - r18;
        float r20 = this.a0;
        float r21 = (r20 - r18) - r17;
        if (r8 <= r20) goto L64;
        if (r16 >= r21) goto L61;
    L68:
        r19 = r21;
    L71:
        if (r14 == r15) goto L73;
    L74:
        super.y(r14, r19);
        WeakReference<View> r110 = this.j;
        if (r110 == null) goto L79;
        View r111 = r110.get();
        if (r111 == null) goto L79;
        float r112 = r111.getTranslationX();
    L80:
        this.D = r112;
        WeakReference<View> r113 = this.j;
        if (r113 == null) goto L85;
        View r114 = r113.get();
        if (r114 == null) goto L85;
        float r115 = r114.getTranslationY();
    L86:
        this.E = r115;
    L85:
        r115 = 0.0f;
    L79:
        r112 = 0.0f;
        goto L80
    L73:
        if (r19 == r16) goto L126;
    L61:
        if (r16 > r19) goto L71;
    L69:
        r19 = r16;
        goto L71
    L64:
        if (r16 < r19) goto L71;
        if (r16 <= r21) goto L69;
    L49:
        if (r15 > r14) goto L55;
        r14 = -r14;
        if (r15 >= r14) goto L54;
    L126:
        this.O = this.N;
        this.B = 0.0f;
        this.C = 0.0f;
        t();
        if (tp0.a.getValue().booleanValue() == false) goto L129;
        v(this.w, this.x);
    L129:
        HashMap r116 = new HashMap();
        IUserService r22 = jc1.k.f(IUserService.class);
        if (r22 == null) goto L135;
        com.bytedance.android.livesdk.user.f r23 = r22.user();
        if (r23 == null) goto L135;
        String r24 = r23.n();
        if (r24 == null) goto L135;
    L136:
        r116.put("user_id", r24);
        ClearScreenLogUtils.a.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_pitch_enlarge_success", r116);
    L135:
        r24 = "0";
        goto L136
    L87:
        WeakReference<View> r117 = this.j;
        if (r117 == null) goto L126;
        View r118 = r117.get();
        if (r118 == null) goto L126;
        float r25 = this.Q;
        float r26 = this.Z;
        float r27 = r25 * r26;
        float r28 = this.a0;
        float r29 = r25 * r28;
        float r30 = 2;
        float r31 = (r27 - r26) / r30;
        float r32 = (r29 - r28) / r30;
        float r33 = r118.getTranslationX();
        float r119 = r118.getTranslationY();
        if (r27 > this.Z) goto L94;
    L99:
        r31 = r33;
    L101:
        if (r29 > this.a0) goto L103;
    L108:
        r32 = r119;
    L110:
        if (r31 == r33) goto L112;
    L113:
        super.y(r31, r32);
        WeakReference<View> r120 = this.j;
        if (r120 == null) goto L118;
        View r121 = r120.get();
        if (r121 == null) goto L118;
        float r122 = r121.getTranslationX();
    L119:
        this.D = r122;
        WeakReference<View> r123 = this.j;
        if (r123 == null) goto L124;
        View r124 = r123.get();
        if (r124 == null) goto L124;
        float r125 = r124.getTranslationY();
    L125:
        this.E = r125;
    L124:
        r125 = 0.0f;
    L118:
        r122 = 0.0f;
        goto L119
    L112:
        if (r32 == r119) goto L126;
    L103:
        if (r119 > r32) goto L110;
        r32 = -r32;
        if (r119 >= r32) goto L108;
    L94:
        if (r33 > r31) goto L101;
        r31 = -r31;
        if (r33 >= r31) goto L99;
    L27:
        if (this.r == false) goto L137;
    L7:
        if (this.p == false) goto L11;
        if ((System.currentTimeMillis() - this.U) >= this.T) goto L11;
        this.i0 = MotionEvent.obtain(r10);
        s();
        goto L11
    L13:
        if (r1 != this.M) goto L25;
        if (c31.a.getValue().booleanValue() == false) goto L25;
        if (this.r == false) goto L19;
    L23:
        this.p = false;
        goto L25
    L19:
        if (this.p == false) goto L23;
        if ((System.currentTimeMillis() - this.U) >= this.T) goto L23;
        s();
        goto L23
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void p(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        WeakReference<View> r0 = this.j;
        float r1 = 0.0f;
        if (r0 == null) goto L7;
        View r2 = r0.get();
        if (r2 == null) goto L7;
        float r4 = r2.getTranslationX();
    L8:
        this.D = r4;
        WeakReference<View> r5 = this.j;
        if (r5 == null) goto L13;
        View r6 = r5.get();
        if (r6 == null) goto L13;
        r1 = r6.getTranslationY();
    L13:
        this.E = r1;
        super.p(r3);
        return;
    L7:
        r4 = 0.0f;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void x(float r2) {
        this.Q = r2;
        this.R = Math.max(this.R, r2);
        super.x(r2);
    }

    public final void B(MotionEvent r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "gestureDetectLayout");
        MotionEvent r0 = this.i0;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        this.i0 = null;
        this.y = new k.b(r3);
        if (this.O != this.N) goto L19;
        d(r4);
        r(true);
        this.B = r3.getX();
        this.C = r3.getY();
        WeakReference<View> r1 = this.j;
        float r2 = 0.0f;
        if (r1 == null) goto L12;
        View r5 = r1.get();
        if (r5 == null) goto L12;
        float r6 = r5.getTranslationX();
    L13:
        this.D = r6;
        WeakReference<View> r7 = this.j;
        if (r7 == null) goto L18;
        View r8 = r7.get();
        if (r8 == null) goto L18;
        r2 = r8.getTranslationY();
    L18:
        this.E = r2;
        this.p = true;
    L12:
        r6 = 0.0f;
    L19:
        r3.getX();
        r3.getY();
        this.U = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final boolean g(MotionEvent r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r9, "gestureDetectLayout");
        int r0 = r8.getPointerCount();
        if (r0 == 2) goto L5;
    L96:
        if (r0 < 3) goto L102;
        this.G = true;
        if (this.q == false) goto L100;
    L101:
        s();
        goto L102
    L100:
        if (this.r == true) goto L101;
    L102:
        return false;
    L5:
        if (this.G == true) goto L96;
        if (this.q == false) goto L9;
    L94:
        s();
        return true;
    L9:
        if (this.r == true) goto L94;
        this.z = new k.b(r8);
        p(r9);
        if (this.O != 0) goto L49;
        WeakReference<View> r10 = this.j;
        float r1 = 0.0f;
        if (r10 == null) goto L18;
        View r11 = r10.get();
        if (r11 == null) goto L18;
        float r12 = r11.getPivotX();
    L19:
        this.s = r12;
        WeakReference<View> r13 = this.j;
        if (r13 == null) goto L24;
        View r14 = r13.get();
        if (r14 == null) goto L24;
        float r15 = r14.getPivotY();
    L25:
        this.t = r15;
        if (tp0.a.getValue().booleanValue() == false) goto L39;
        WeakReference<View> r16 = this.k;
        if (r16 == null) goto L32;
        View r17 = r16.get();
        if (r17 == null) goto L32;
        float r18 = r17.getPivotX();
    L33:
        this.w = r18;
        WeakReference<View> r19 = this.k;
        if (r19 == null) goto L38;
        View r20 = r19.get();
        if (r20 == null) goto L38;
        r1 = r20.getPivotY();
    L38:
        this.x = r1;
    L32:
        r18 = 0.0f;
    L39:
        RoomContext r21 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r21 == null) goto L47;
        com.bytedance.live.datacontext.m r22 = r21.getCleanMode();
        if (r22 == null) goto L47;
        if (((Number) r22.getValue()).intValue() != ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L47;
        boolean r23 = false;
    L48:
        this.e0 = r23;
    L47:
        r23 = true;
    L24:
        r15 = 0.0f;
    L18:
        r12 = 0.0f;
    L49:
        k.b r24 = this.y;
        if (r24 == null) goto L52;
        int r25 = r24.b;
    L53:
        this.e = r8.getX(r25);
        k.b r26 = this.y;
        if (r26 == null) goto L56;
        int r27 = r26.b;
    L57:
        this.g = r8.getY(r27);
        k.b r28 = this.z;
        if (r28 == null) goto L60;
        int r29 = r28.b;
    L61:
        this.f = r8.getX(r29);
        k.b r30 = this.z;
        if (r30 == null) goto L64;
        int r31 = r30.b;
    L65:
        this.h = r8.getY(r31);
        this.d = k.z(r8);
        this.o = true;
        this.p = true;
        this.O = this.L;
        o();
        this.J.put("live_zoom_and_lock_notify", Boolean.TRUE);
        if (pg0.a.getValue().booleanValue() == true) goto L68;
    L74:
        ClearScreenLogUtils.Companion r32 = ClearScreenLogUtils.a;
        HashMap r33 = new HashMap();
        r32.getClass();
        ClearScreenLogUtils.Companion.c("livesdk_enlarge_under_screen_clear", r33);
        WeakReference<View> r34 = this.j;
        if (r34 == null) goto L79;
        View r35 = r34.get();
        if (r35 == null) goto L79;
        r35.setPivotX(this.b0);
    L79:
        WeakReference<View> r36 = this.j;
        if (r36 == null) goto L84;
        View r37 = r36.get();
        if (r37 == null) goto L84;
        r37.setPivotY(this.c0);
    L84:
        WeakReference<View> r38 = this.k;
        if (r38 == null) goto L89;
        View r39 = r38.get();
        if (r39 == null) goto L89;
        r39.setPivotX(this.b0);
    L89:
        WeakReference<View> r40 = this.k;
        if (r40 == null) goto L102;
        View r41 = r40.get();
        if (r41 == null) goto L102;
        r41.setPivotY(this.c0);
        goto L102
    L68:
        if (this.e0 == true) goto L74;
        this.g0 = true;
        StringBuilder r42 = new StringBuilder("hashcode = ");
        r42.append(hashCode());
        r42.append(' ');
        q r43 = this.f0;
        if (r43 == null) goto L72;
        int r44 = r43.hashCode();
    L73:
        r42.append(r44);
        ALogger.i("GestureBaseBehavior", r42.toString());
        ClearScreenHelper.m(true);
        goto L74
    L72:
        r44 = 0;
        goto L73
    L64:
        r31 = 1;
        goto L65
    L60:
        r29 = 1;
        goto L61
    L56:
        r27 = 0;
        goto L57
    L52:
        r25 = 0;
        goto L53
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final boolean onTouchEvent(ViewGroup r7, MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r7, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r8, "event");
        Lazy r0 = ClearScreenHelper.a;
        if (ClearScreenHelper.h(this.J) == true) goto L8;
        if (k() == true) goto L8;
        return false;
    L8:
        if (f() == false) goto L11;
        return false;
    L11:
        if (r8.getPointerCount() <= 2) goto L14;
        s();
        return false;
    L14:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.J, 0, 2);
        if (r1 == null) goto L21;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L21;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L21;
        boolean r4 = r3.isVrRoom();
    L23:
        if (r4 == false) goto L25;
    L28:
        boolean r5 = true;
    L29:
        if (r5 == false) goto L73;
        return false;
    L73:
        int r6 = r8.getAction() & 255;     // Catch: IllegalArgumentException -> L50
        if (r6 == 0) goto L48;
        if (r6 == 1) goto L47;
        if (r6 != 2) goto L36;
        h(r8);     // Catch: IllegalArgumentException -> L50
    L72:
    L52:
        if (r5 == false) goto L54;
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r9 = LiveVrContext.c.a();
        if (r9 == null) goto L66;
        com.bytedance.live.datacontext.m r10 = r9.isVrSensorOpen();
        if (r10 == null) goto L66;
        Boolean r11 = (Boolean) r10.getValue();
        if (r11 == null) goto L66;
        boolean r12 = r11.booleanValue();
    L67:
        if (r5 == false) goto L70;
        if (r12 == true) goto L70;
        return false;
    L70:
        return true;
    L66:
        r12 = true;
        goto L67
    L54:
        if (this.r == false) goto L56;
    L57:
        return true;
    L56:
        if (this.q == true) goto L57;
        return false;
    L36:
        if (r6 == 3) goto L47;
        if (r6 == 5) goto L44;
        if (r6 != 6) goto L72;
        i(r8);     // Catch: IllegalArgumentException -> L50
        goto L72
    L44:
        if (g(r8, r7) == false) goto L72;
        return true;
    L47:
        j(r8);     // Catch: IllegalArgumentException -> L50
        goto L72
    L48:
        B(r8, r7);     // Catch: IllegalArgumentException -> L50
    L50:
        e = move-exception;
        ALogger.e("GestureBaseBehavior", "IllegalArgumentException error: " + e.toString());
        goto L52
    L25:
        if (VrUtils.v(this.J) == true) goto L28;
        r5 = false;
    L21:
        r4 = false;
        goto L23
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void w(float r2, float r3) {
        WeakReference<View> r0 = this.k;
        if (r0 == null) goto L7;
        View r1 = r0.get();
        if (r1 == null) goto L7;
        r1.setTranslationX(r2);
    L7:
        WeakReference<View> r4 = this.k;
        if (r4 == null) goto L13;
        View r5 = r4.get();
        if (r5 == null) goto L14;
        r5.setTranslationY(r3);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.clearscreen.k
    public final void y(float r1, float r2) {
        super.y(r1, r2);
    }

    public o(LivePlayerView r7, DataCenter r8, Context r9, ZoomType r10) {
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "zoomType");
        super(r7, r8, r9, null, r10);
        boolean r11 = true;
        this.L = 1;
        this.M = 2;
        this.N = 3;
        this.O = 0;
        this.P = 1.0f;
        this.Q = 1.0f;
        this.R = 1.0f;
        this.S = 24;
        this.T = 400;
        this.S = ViewConfiguration.get(r9).getScaledTouchSlop();
        this.T = ViewConfiguration.getLongPressTimeout();
        WeakReference<View> r12 = this.j;
        float r0 = 0.0f;
        if (r12 == null) goto L7;
        View r13 = r12.get();
        if (r13 == null) goto L7;
        float r14 = r13.getWidth();
    L8:
        this.Z = r14;
        WeakReference<View> r15 = this.j;
        if (r15 == null) goto L13;
        View r16 = r15.get();
        if (r16 == null) goto L13;
        r0 = r16.getHeight();
    L13:
        this.a0 = r0;
        A();
        boolean r17 = gs1.b.a;
        HashMap<ClearScreenConst.InteractType, jg1.a> r18 = gs1.b.a(a0.p(this.J)).g();
        if (r18 == null) goto L20;
        ClearScreenConst.InteractType r1 = ClearScreenConst.InteractType.ZOOM_MODE_CLEAR;
        if (r18.get(r1) == null) goto L20;
        int r19 = gs1.a.a;
        h r20 = gs1.a.a(a0.p(this.J));
        if (r20 == null) goto L20;
        r20.a(r1);
    L20:
        q r21 = new q(this);
        this.f0 = r21;
        int r2 = gs1.a.a;
        h r3 = gs1.a.a(a0.p(this.J));
        if (r3 == null) goto L23;
        r3.b(r21);
    L23:
        RoomContext.a r22 = RoomContext.Companion;
        RoomContext r4 = RoomContext.a.c(r22, null, 0, 3);
        if (r4 == null) goto L31;
        com.bytedance.live.datacontext.m r5 = r4.getCleanMode();
        if (r5 == null) goto L31;
        if (((Number) r5.getValue()).intValue() != ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L31;
        r11 = false;
    L31:
        this.e0 = r11;
        RoomContext r23 = RoomContext.a.c(r22, null, 0, 3);
        if (r23 == null) goto L38;
        com.bytedance.live.datacontext.m r24 = r23.getCleanMode();
        if (r24 == null) goto L38;
        Observable r25 = r24.a();
        if (r25 == null) goto L38;
        r25.subscribe(new n(this));
    L38:
        this.h0 = com.bytedance.android.livesdk.widget.b.h.c;
        return;
    L7:
        r14 = 0.0f;
        goto L8
    }
}
