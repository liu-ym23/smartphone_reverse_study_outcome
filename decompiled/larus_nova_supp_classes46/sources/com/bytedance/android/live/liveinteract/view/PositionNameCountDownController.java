package com.bytedance.android.live.liveinteract.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ugc.live.sdk.msg.utils.f;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PositionNameCountDownController {
    public final Handler a;
    public boolean b;
    public ILinkPlayerInfoBridge c;
    public final c d;
    public final b e;
    public final d f;
    public final e g;
    public final PositionNameTv h;
    public final PaidLinkCountDownView i;
    public final SeatPosTagLabelTextView j;
    public final Context k;
    public final DataCenter l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PositionNameCountDownController a;

        public b(PositionNameCountDownController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.g();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Observer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
            IVoiceLiveTheme r2 = (IVoiceLiveTheme) r1;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ PositionNameCountDownController a;

        public d(PositionNameCountDownController r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.c() == false) goto L7;
            final PositionNameCountDownController r0 = this.a;
            AppCompatTextView r8 = r0.j;
            if (r8 == null) goto L9;
            r0.b = false;
            final ObjectAnimator r9 = ObjectAnimator.ofFloat(r8, "translationY", new float[]{r8.getMeasuredHeight(), 0.0f}).setDuration(300);
            h.b(r9, new PositionNameCountDownController$hideCountDownTimerAndShowHostLabel$$inlined$let$lambda$1(r0));
            AppCompatTextView r10 = r0.i;
            ObjectAnimator r1 = ObjectAnimator.ofFloat(r10, "translationY", new float[]{0.0f, 0.0f - r10.getMeasuredHeight()}).setDuration(300);
            h.a(r1, new PositionNameCountDownController$hideCountDownTimerAndShowHostLabel$$inlined$let$lambda$2(r0));
            h.b(r1, new PositionNameCountDownController$hideCountDownTimerAndShowHostLabel$$inlined$let$lambda$3(r9, r0));
            r1.start();
            return;
        L9:
            return;
        L7:
            final PositionNameCountDownController r2 = this.a;
            r2.b = false;
            AppCompatTextView r11 = r2.h;
            final ObjectAnimator r12 = ObjectAnimator.ofFloat(r11, "translationY", new float[]{r11.getMeasuredHeight(), 0.0f}).setDuration(300);
            h.b(r12, new PositionNameCountDownController$hideCountDownTimerAndShowPositionName$positionNameTvFadeInAnimator$1(r2));
            AppCompatTextView r13 = r2.i;
            ObjectAnimator r3 = ObjectAnimator.ofFloat(r13, "translationY", new float[]{0.0f, 0.0f - r13.getMeasuredHeight()}).setDuration(300);
            h.a(r3, new PositionNameCountDownController$hideCountDownTimerAndShowPositionName$countDownViewFadeOutAnimator$1(r2));
            h.b(r3, new PositionNameCountDownController$hideCountDownTimerAndShowPositionName$1(r2, r12));
            r3.start();
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
    }

    public static final class e implements Runnable {
        public final /* synthetic */ PositionNameCountDownController a;

        public e(PositionNameCountDownController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.a.c() == false) goto L5;
            this.a.d();     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.a.e();     // Catch: Throwable -> L7
            goto L12
        }
    }

    static {
    }

    public final void e() {
        this.b = true;
        AppCompatTextView r1 = this.i;
        final ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "translationY", new float[]{r1.getMeasuredHeight(), 0.0f}).setDuration(300);
        h.a(r2, new PositionNameCountDownController$hidePositionNameAndShowCountDownTimer$countDownViewFadeInAnimator$1(this));
        AppCompatTextView r3 = this.h;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(r3, "translationY", new float[]{0.0f, 0.0f - r3.getMeasuredHeight()}).setDuration(300);
        h.b(r0, new PositionNameCountDownController$hidePositionNameAndShowCountDownTimer$1(this, r2));
        h.a(r0, new PositionNameCountDownController$hidePositionNameAndShowCountDownTimer$2(this));
        r0.start();
    }

    public final int b() {
        ILinkPlayerInfoBridge r0 = this.c;
        long r1 = 0;
        if (r0 == null) goto L9;
        long r3 = r0.getExpectLeaveTime() - (f.a() / 1000);
        if (r3 <= 0) goto L9;
        r1 = r3;
    L9:
        return (int) r1;
    }

    public final boolean c() {
        ILinkPlayerInfoBridge r0 = this.c;
        if (r0 == null) goto L7;
        g0 r1 = r0.getMicPosTagInfo();
        if (r1 == null) goto L7;
        long r3 = r1.getTagType();
    L9:
        if (r3 > 0) goto L11;
    L13:
        return false;
    L11:
        if (this.j == null) goto L13;
        return true;
    L7:
        r3 = 0;
        goto L9
    }

    public final void d() {
        AppCompatTextView r0 = this.j;
        if (r0 == null) goto L6;
        this.b = true;
        AppCompatTextView r2 = this.i;
        final ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "translationY", new float[]{r2.getMeasuredHeight(), 0.0f}).setDuration(300);
        h.a(r3, new PositionNameCountDownController$hideHostLabelAndShowCountDownTimer$$inlined$let$lambda$1(this));
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.j, "translationY", new float[]{0.0f, 0.0f - r0.getMeasuredHeight()}).setDuration(300);
        h.b(r1, new PositionNameCountDownController$hideHostLabelAndShowCountDownTimer$$inlined$let$lambda$2(r3, this));
        h.a(r1, new PositionNameCountDownController$hideHostLabelAndShowCountDownTimer$$inlined$let$lambda$3(this));
        r1.start();
        return;
    }

    public final void f() {
        if ((this.k instanceof AppCompatActivity) == false) goto L18;
        Boolean r0 = m.i().isAnchor();
        if (r0 == null) goto L7;
        boolean r1 = r0.booleanValue();
    L8:
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L11;
        x00.a r3 = r2.getThemeManager(r1, this.l);
    L12:
        if (r3 == null) goto L18;
        AppCompatActivity r4 = this.k;
        if (r4 == null) goto L17;
        r3.j(r4, this.d, 2);
        goto L18
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    L11:
        r3 = null;
        goto L12
    L7:
        r1 = false;
    L18:
        this.b = false;
    }

    public final void g() {
        if (this.b == false) goto L5;
    L16:
        this.a.removeCallbacks(this.e);
        this.a.removeCallbacks(this.f);
        this.a.removeCallbacks(this.g);
        long r0 = b();
        if (r0 < 360) goto L20;
        this.a.postDelayed(this.f, 5000);
        this.a.postDelayed(this.e, 300000);
        return;
    L20:
        if (r0 <= 60) goto L26;
        long r1 = r0 - 60;
        this.a.postDelayed(this.e, 1000 * r1);
        if (r1 <= 5) goto L27;
        this.a.postDelayed(this.f, 5000);
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (c() == false) goto L13;
        AppCompatTextView r2 = this.j;
        if (r2 != null) goto L9;
    L11:
        this.i.setVisibility(0);
        PaidLinkCountDownView r3 = this.i;
        r3.c = b();
        com.bytedance.android.live.liveinteract.voicechat.util.c.d.b(r3);
        goto L16
    L9:
        if (r2.getVisibility() != 0) goto L11;
        d();
        goto L16
    L13:
        if (this.h.getVisibility() != 0) goto L15;
        e();
        goto L16
    L15:
        this.i.setVisibility(0);
        PaidLinkCountDownView r4 = this.i;
        r4.c = b();
        com.bytedance.android.live.liveinteract.voicechat.util.c.d.b(r4);
        goto L16
    }

    public final void a(ILinkPlayerInfoBridge r17, boolean r18, int r19, int r20) {
        if (r17 != null) goto L8;
        UtilityKotlinExtentionsKt.t(this.h);
        UtilityKotlinExtentionsKt.t(this.i);
        AppCompatTextView r1 = this.j;
        if (r1 == null) goto L126;
        UtilityKotlinExtentionsKt.t(r1);
        return;
    L126:
        return;
    L8:
        ILinkPlayerInfoBridge r2 = this.c;
        Intrinsics.checkNotNullParameter(r17, "newGuestInfo");
        if (r2 != null) goto L12;
    L43:
        boolean r3 = false;
    L44:
        if (r3 == false) goto L46;
        return;
    L46:
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        SeatPosTagLabelTextView r10 = this.j;
        if (r10 == null) goto L49;
        SeatPosTagLabelTextView.z(r10, 8, this.c, null, null, 12);
    L49:
        this.h.setY(0.0f);
        AppCompatTextView r4 = this.j;
        if (r4 == null) goto L52;
        r4.setY(0.0f);
    L52:
        this.i.setY(0.0f);
        this.a.removeCallbacks(this.e);
        this.a.removeCallbacks(this.f);
        this.a.removeCallbacks(this.g);
        this.c = r17;
        ih0.b r5 = ((IInteractService) k.n(IInteractService.class)).dynamicService(null);
        if (r5 != null) goto L55;
    L57:
        boolean r6 = false;
    L58:
        boolean r7 = com.bytedance.android.live.liveinteract.utils.h.f(r19);
        ILinkPlayerInfoBridge r8 = this.c;
        Intrinsics.checkNotNull(r8);
        if (r8.getExpectLeaveTime() == 0) goto L62;
        if (r6 == true) goto L62;
        boolean r9 = true;
    L63:
        if (r18 == false) goto L65;
    L66:
        ILinkPlayerInfoBridge r11 = this.c;
        Intrinsics.checkNotNull(r11);
        if (r11.getVerifyStatus() != 1) goto L75;
        PositionNameTv r12 = this.h;
        ILinkPlayerInfoBridge r13 = this.c;
        Intrinsics.checkNotNull(r13);
        List<Integer> r14 = CollectionsKt.emptyList();
        if (r19 <= 0) goto L71;
        boolean r15 = true;
    L73:
        if (r12.z(r13, r20, r14, r15) == false) goto L75;
        boolean r16 = true;
    L76:
        ILinkPlayerInfoBridge r21 = this.c;
        Intrinsics.checkNotNull(r21);
        if (r21.getActiveName() == null) goto L93;
        ILinkPlayerInfoBridge r22 = this.c;
        Intrinsics.checkNotNull(r22);
        String r23 = r22.getActiveName();
        if (r23 == null) goto L93;
        if (r23.length() <= 0) goto L83;
        boolean r24 = true;
    L84:
        if (r24 != true) goto L93;
        PositionNameTv r25 = this.h;
        ILinkPlayerInfoBridge r110 = this.c;
        Intrinsics.checkNotNull(r110);
        List<Integer> r111 = CollectionsKt.emptyList();
        if (r19 <= 0) goto L88;
        boolean r112 = true;
    L90:
        if (r25.z(r110, r20, r111, r112) == false) goto L93;
        r16 = true;
        goto L93
    L88:
        r112 = false;
        goto L90
    L83:
        r24 = false;
    L93:
        if (c() == false) goto L100;
        if (r7 == false) goto L100;
        if (r9 == true) goto L99;
        SeatPosTagLabelTextView r26 = this.j;
        if (r26 == null) goto L99;
        r26.y(0, this.c, MicSeatScene.AUDIO_LINK, Boolean.FALSE);
    L99:
        boolean r27 = true;
        r16 = false;
    L102:
        if (r16 == true) goto L106;
        if (r27 == true) goto L106;
        boolean r28 = false;
    L107:
        Pair r29 = new Pair(Boolean.valueOf(r28), Boolean.valueOf(r9));
        Boolean r30 = Boolean.TRUE;
        if (Intrinsics.areEqual(r29, new Pair(r30, r30)) == false) goto L110;
        this.i.setOriginTime(b());
        g();
        PositionNameTv.x(this.h, r17, r18, 0, null, false, 60);
        return;
    L110:
        Boolean r31 = Boolean.FALSE;
        if (Intrinsics.areEqual(r29, new Pair(r31, r30)) == false) goto L114;
        PositionNameTv.x(this.h, r17, r18, 0, null, false, 60);
        this.i.setVisibility(0);
        PaidLinkCountDownView r32 = this.i;
        r32.c = b();
        com.bytedance.android.live.liveinteract.voicechat.util.c.d.b(r32);
        return;
    L114:
        if (Intrinsics.areEqual(r29, new Pair(r30, r31)) == false) goto L121;
        PositionNameTv r33 = this.h;
        if (r19 <= 0) goto L118;
        boolean r34 = true;
    L119:
        PositionNameTv.x(r33, r17, r18, r20, null, r34, 20);
        PaidLinkCountDownView r35 = this.i;
        r35.c = 0;
        com.bytedance.android.live.liveinteract.voicechat.util.c.c(r35);
        this.i.setVisibility(8);
        return;
    L118:
        r34 = false;
        goto L119
    L121:
        if (Intrinsics.areEqual(r29, new Pair(r31, r31)) == false) goto L130;
        UtilityKotlinExtentionsKt.t(this.h);
        UtilityKotlinExtentionsKt.t(this.i);
        AppCompatTextView r36 = this.j;
        if (r36 == null) goto L131;
        UtilityKotlinExtentionsKt.t(r36);
        return;
    L131:
        return;
    L130:
        return;
    L106:
        r28 = true;
    L100:
        r27 = false;
        goto L102
    L71:
        r15 = false;
    L75:
        r16 = false;
        goto L76
    L65:
        if (je0.d.Y() == false) goto L75;
    L62:
        r9 = false;
        goto L63
    L55:
        if (r5.jl("adventure") != true) goto L57;
        r6 = true;
        goto L58
    L12:
        if (r2.getUser() == null) goto L43;
        if (r17.getUser() == null) goto L43;
        if (r17.getExpectLeaveTime() != r2.getExpectLeaveTime()) goto L43;
        IBaseUser r37 = r17.getUser();
        if (r37 == null) goto L21;
        String r38 = r37.getIdString();
    L22:
        IBaseUser r39 = r2.getUser();
        if (r39 == null) goto L25;
        String r40 = r39.getIdString();
    L27:
        if (Intrinsics.areEqual(r38, r40) == false) goto L43;
        if (Intrinsics.areEqual(r17.getActiveName(), r2.getActiveName()) == false) goto L43;
        if (r17.getUserPosition() != r2.getUserPosition()) goto L43;
        g0 r41 = r17.getMicPosTagInfo();
        if (r41 == null) goto L35;
        Long r42 = Long.valueOf(r41.getTagTypeId());
    L36:
        g0 r43 = r2.getMicPosTagInfo();
        if (r43 == null) goto L39;
        Long r44 = Long.valueOf(r43.getTagTypeId());
    L41:
        if (Intrinsics.areEqual(r42, r44) == false) goto L43;
        r3 = true;
        goto L44
    L39:
        r44 = null;
        goto L41
    L35:
        r42 = null;
        goto L36
    L25:
        r40 = null;
        goto L27
    L21:
        r38 = null;
        goto L22
    }

    public PositionNameCountDownController(PositionNameTv r2, PaidLinkCountDownView r3, SeatPosTagLabelTextView r4, Context r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r2, "positionNameTv");
        Intrinsics.checkNotNullParameter(r3, "paidLinkCountDownView");
        Intrinsics.checkNotNullParameter(r5, "context");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.a = new Handler(Looper.getMainLooper());
        this.d = c.a;
        this.e = new b(this);
        this.f = new d(this);
        this.g = new e(this);
    }
}
