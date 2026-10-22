package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentBusinessType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentContentType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.comment.CommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.mention.MentionSectionController;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.AudioComposeSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.b1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.t1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.android.livesdk.interactivity.common.InterceptLinearLayout;
import com.bytedance.android.livesdk.user.LiveInteractFunction;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LivePortraitInputDialogV3$initFramework$2 extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g {
    public int o;
    public final /* synthetic */ LivePortraitInputDialogV3 p;
    public final /* synthetic */ z62.b q;
    public final /* synthetic */ DanmakuSectionProvider r;
    public final /* synthetic */ b1 s;
    public final /* synthetic */ t1 t;

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean n0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void A0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.MARK_HIGHLIGHT, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void B0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.INTERACTIVITY_SHARE, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void C0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.INTEREST, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void D0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.KEYBOARD, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void E0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.MORE, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void F0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.TRUTH, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void G0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.VIDEO, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean H() {
        MentionSectionController r0 = this.s.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.k.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void I() {
        InputPanelSectionContainer r0 = this.p.B;
        if (r0 == null) goto L5;
        r0.setCanBlockTouchEvent(true);
    L5:
        InputPanelSectionContainer r1 = this.p.A;
        if (r1 == null) goto L9;
        r1.setCanBlockTouchEvent(true);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void J() {
        this.p.dismissInputDialog();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void K() {
        LivePortraitInputDialogV3 r0 = this.p;
        r0.q = 1;
        r0.dismissInputDialog();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void L() {
        InputPanelSectionContainer r0 = this.p.B;
        if (r0 == null) goto L5;
        r0.setCanBlockTouchEvent(false);
    L5:
        InputPanelSectionContainer r1 = this.p.A;
        if (r1 == null) goto L9;
        r1.setCanBlockTouchEvent(false);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final InputSectionType Q() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentSectionType();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final DataCenter R() {
        LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        return r0.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final CommentFlowContext S() {
        LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        return r0.h;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final x22.e U() {
        LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        return r0.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final c V() {
        LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        return r0.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final int W() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 != null) goto L5;
    L7:
        InputPanelSectionContainer r1 = this.p.C;
        if (r1 != null) goto L13;
        return 0;
    L13:
        return r1.getKeyboardHeight();
    L5:
        if (r0.getKeyboardHeight() != 0) goto L7;
        return ((Number) l42.a.m.getValue()).intValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final MeasureLinearLayout a0() {
        LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        return r0.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public Activity getActivity() {
        return this.p.getActivity();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public Context getContext() {
        return this.p.getContext();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean l0() {
        LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        c r2 = r0.d;
        if (r2 == null) goto L9;
        a r3 = r2.g;
        if (r3 == null) goto L9;
        if (r3.c != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void t0() {
        this.p.aa0();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void v0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.AUDIO2TEXT, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void w0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.AUDIO_COMPOSE, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void y0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L5;
        InputPanelSectionContainer.e(r0, InputSectionType.EMOJI, null, false, 6);
    L5:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.g("comment_keyboard_emoji", d0(), g0());
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void z0() {
        InputPanelSectionContainer r0 = this.p.C;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.FREQUENT_CHAT, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final IBaseUser b0() {
        DataCenter r0 = R();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (IBaseUser) r0.get("data_user_in_room");
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean k0() {
        DataCenter r0 = R();
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_is_anchor", Boolean.FALSE);
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean m0() {
        com.bytedance.android.live.profit.privilege.a r0 = yt0.c.i();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.isInDanmakuMode();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void p0() {
        c r0 = V();
        if (r0 == null) goto L9;
        a r1 = r0.g;
        if (r1 == null) goto L9;
        if (r1.s != true) goto L9;
        z32.c.b(InputValueNode.ClickSend);
        z32.c.b(InputValueNode.PortraitClickSendCount);
    L9:
        this.p.Y90();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final Fragment T() {
        return this.p;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final int X() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g, z62.c
    public final void A(com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItem");
        this.q.x(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void M(boolean r4) {
        InputPanelSectionContainer r0 = this.p.A;
        if (r0 == null) goto L5;
        r0.c(InputSectionType.EMPTY, this.a, r4);
    L5:
        InputPanelSectionContainer r1 = this.p.D;
        if (r1 == null) goto L9;
        r1.c(InputSectionType.EMPTY, this.a, r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void N(boolean r4) {
        InputPanelSectionContainer r0 = this.p.B;
        if (r0 == null) goto L6;
        r0.c(InputSectionType.EMPTY, this.a, r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void O(boolean r6) {
        LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        c r2 = r0.d;
        if (r2 == null) goto L11;
        a r3 = r2.g;
        if (r3 == null) goto L11;
        if (r3.b != true) goto L11;
        InputPanelSectionContainer r4 = r0.B;
        if (r4 == null) goto L16;
        r4.c(InputSectionType.DANMAKU, this.a, r6);
    L16:
        c r5 = V();
        if (r5 == null) goto L22;
        a r7 = r5.g;
        if (r7 == null) goto L23;
        r7.c = r6;
        return;
    L23:
        return;
    L22:
        return;
    L11:
        if (r6 == false) goto L15;
        InputPanelSectionContainer r8 = r0.z;
        if (r8 == null) goto L16;
        InputPanelSectionContainer.e(r8, InputSectionType.DANMAKU, null, true, 2);
        goto L16
    L15:
        this.r.j(new LivePortraitInputDialogV3$initFramework$2$flashDanmakuSection$1(this));
        goto L16
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void P(boolean r5) {
        InputSectionType r0 = null;
        if (r5 == true) goto L5;
        InputPanelSectionContainer r6 = this.p.z;
        if (r6 == null) goto L29;
        r0 = r6.getCurrentSectionType();
    L29:
        if (r0 != InputSectionType.MENTION) goto L39;
        b1 r7 = this.s;
        Function0<Unit> r1 = new LivePortraitInputDialogV3$initFramework$2$flushMentionSection$1(this);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "doOnEnd");
        MentionSectionController r8 = r7.b;
        if (r8 == null) goto L40;
        r8.g(r1);
        return;
    L40:
        return;
    L39:
        return;
    L5:
        if (l0() == true) goto L24;
        MentionSectionController r9 = this.s.b;
        if (r9 == null) goto L9;
        boolean r10 = r9.k.a;
    L10:
        if (r10 == false) goto L34;
        InputPanelSectionContainer r11 = this.p.z;
        if (r11 == null) goto L15;
        InputSectionType r13 = r11.getCurrentSectionType();
    L16:
        InputSectionType r2 = InputSectionType.MENTION;
        if (r13 != r2) goto L21;
        MentionSectionController r14 = this.s.b;
        if (r14 == null) goto L35;
        r14.h();
        return;
    L35:
        return;
    L21:
        InputPanelSectionContainer r15 = this.p.z;
        if (r15 == null) goto L37;
        InputPanelSectionContainer.e(r15, r2, null, true, 2);
        return;
    L37:
        return;
    L15:
        r13 = null;
        goto L16
    L34:
        return;
    L9:
        r10 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void q0(InputPanelSectionContainer.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        InputPanelSectionContainer r1 = this.p.C;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.k.add(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void r0(TokenCert r5) {
        Intrinsics.checkNotNullParameter(r5, "cert");
        FragmentActivity r0 = this.p.requireActivity();
        SettingKey r1 = m60.i.a;
        new m60.i.b(r0).b(new com.bytedance.android.livesdk.interactivity.comment.audio.e(), null, r5, new String[]{"android.permission.RECORD_AUDIO"});
        this.p.hideSoftKeyBoard();
    L11:
        e = move-exception;
        f72.a.b("dismiss input dialog exception: " + e.getMessage());
        return;
    L14:
        this.p.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L19:
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Exception -> L11
        Throwable r6 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L11
        if (r6 == null) goto L18;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L11
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void u0(int r1) {
        this.o = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void G(InputDialogFragmentSwitchType r8, final AbsLiveInputSecondaryFragment r9) {
        Intrinsics.checkNotNullParameter(r8, "switchType");
        Intrinsics.checkNotNullParameter(r9, "fragment");
        final LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        InterceptLinearLayout r2 = r0.G;
        if (r2 == null) goto L5;
        r2.setIsIntercept(false);
    L5:
        MeasureLinearLayout r3 = r0.f;
        if (r3 == null) goto L12;
        InputPanelSectionContainer r4 = r0.C;
        if (r4 == null) goto L12;
        i40.b r5 = r3.getKeyBoardObservable();
        if (r5 == null) goto L12;
        r5.b(r4);
    L12:
        r0.I = false;
        MeasureLinearLayout r6 = r0.f;
        final ViewGroup.LayoutParams r7 = null;
        if (r6 == null) goto L19;
        ViewGroup.LayoutParams r10 = r6.getLayoutParams();
        if (r10 == null) goto L17;
        r10.height = -1;
    L18:
        r6.setLayoutParams(r10);
        goto L19
    L17:
        r10 = null;
    L19:
        FragmentTransaction r11 = r0.getChildFragmentManager().beginTransaction();
        int r13 = f.b[r8.ordinal()];
        if (r13 == 1) goto L26;
        if (r13 == 2) goto L26;
        if (r13 != 3) goto L27;
        r11.setCustomAnimations(2130772702, 2130772703);
    L27:
        r11.remove(r9);
        r11.commitAllowingStateLoss();
        FrameLayout r14 = r0.F;
        if (r14 == null) goto L31;
        r7 = r14.getLayoutParams();
    L31:
        if (r9.S90() == true) goto L35;
        if (r7 == null) goto L34;
        int r15 = r7.height;
    L37:
        if (r0.J != InputSectionType.KEYBOARD) goto L51;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r16 = r0.g;
        if (r16 == null) goto L41;
        int r17 = r16.X();
    L42:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r18 = r0.g;
        if (r18 == null) goto L45;
        int r19 = r18.W();
    L46:
        final int r20 = r17 - r19;
        if (r20 > 0) goto L55;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r21 = r0.g;
        if (r21 == null) goto L54;
        r20 = r21.X();
    L54:
        r20 = 0;
    L55:
        ValueAnimator r23 = ValueAnimator.ofInt(new int[]{r15, r20});
        r0.H = r23;
        if (r23 == null) goto L58;
        r23.addUpdateListener(new i(r0, r7));
    L58:
        ValueAnimator r24 = r0.H;
        if (r24 == null) goto L61;
        com.bytedance.android.live.core.utils.h.a(r24, new LivePortraitInputDialogV3$innerBackToMainPage$4(r0, r7, r9, r20));
    L61:
        ValueAnimator r25 = r0.H;
        if (r25 == null) goto L67;
        ValueAnimator r26 = r25.setDuration(250);
        if (r26 == null) goto L68;
        r26.start();
        return;
    L68:
        return;
    L67:
        return;
    L45:
        r19 = 0;
        goto L46
    L41:
        r17 = 0;
        goto L42
    L51:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r27 = r0.g;
        if (r27 == null) goto L54;
        r20 = r27.X();
        goto L55
    L34:
        r15 = 0;
        goto L37
    L35:
        r15 = r9.T90();
    L26:
        r11.setCustomAnimations(2130772704, 2130772705);
        goto L27
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void o0(InputDialogFragmentSwitchType r9, AbsLiveInputSecondaryFragment r10) {
        Intrinsics.checkNotNullParameter(r9, "switchType");
        Intrinsics.checkNotNullParameter(r10, "fragment");
        final LivePortraitInputDialogV3 r0 = this.p;
        int r1 = LivePortraitInputDialogV3.L;
        InputPanelSectionContainer r2 = r0.C;
        if (r2 == null) goto L6;
        InputSectionType r3 = r2.getCurrentSectionType();
        if (r3 == null) goto L6;
    L7:
        r0.J = r3;
        InputPanelSectionContainer r4 = r0.C;
        final ViewGroup.LayoutParams r5 = null;
        if (r4 == null) goto L10;
        InputSectionType r6 = r4.getCurrentSectionType();
    L11:
        InputSectionType r7 = InputSectionType.KEYBOARD;
        if (r6 != r7) goto L15;
        r0.hideSoftKeyBoard();
        r0.l = false;
    L15:
        if (r10.S90() == true) goto L31;
        MeasureLinearLayout r8 = r0.f;
        if (r8 == null) goto L31;
        if (r0.J != r7) goto L25;
        int r11 = r8.getHeight();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r13 = r0.g;
        if (r13 == null) goto L23;
        int r14 = r13.W();
    L24:
        int r15 = r11 + r14;
    L26:
        ViewGroup.LayoutParams r16 = r8.getLayoutParams();
        if (r16 == null) goto L29;
        r16.height = r15;
    L30:
        r8.setLayoutParams(r16);
        goto L31
    L29:
        r16 = null;
        goto L30
    L23:
        r14 = 0;
        goto L24
    L25:
        r15 = r8.getHeight();
    L31:
        MeasureLinearLayout r17 = r0.f;
        if (r17 == null) goto L40;
        InputPanelSectionContainer r18 = r0.C;
        if (r18 == null) goto L40;
        i40.b r19 = r17.getKeyBoardObservable();
        if (r19 == null) goto L40;
        List r20 = r19.b;
        if (r20 == null) goto L40;
        ((ArrayList) r20).remove(r18);
    L40:
        r0.I = true;
        InterceptLinearLayout r21 = r0.G;
        if (r21 == null) goto L43;
        r21.setIsIntercept(true);
    L43:
        FragmentTransaction r23 = r0.getChildFragmentManager().beginTransaction();
        int r24 = f.a[r9.ordinal()];
        if (r24 == 1) goto L50;
        if (r24 == 2) goto L50;
        if (r24 != 3) goto L52;
        r23.setCustomAnimations(2130772702, 2130772703);
    L52:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r23, r10, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L55;
        r23.add(2131373275, r10);
    L55:
        r23.commitAllowingStateLoss();
        int r25 = r10.T90();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r26 = r0.g;
        if (r26 == null) goto L58;
        int r27 = r26.X();
    L59:
        int r28 = RangesKt.coerceAtLeast(r25, r27);
        if (r0.J != r7) goto L70;
        FrameLayout r29 = r0.w;
        if (r29 == null) goto L64;
        int r30 = r29.getHeight();
    L65:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r31 = r0.g;
        if (r31 == null) goto L68;
        int r33 = r31.W();
    L69:
        int r34 = r30 + r33;
    L74:
        FrameLayout r35 = r0.F;
        if (r35 == null) goto L77;
        r5 = r35.getLayoutParams();
    L77:
        ValueAnimator r36 = ValueAnimator.ofInt(new int[]{r34, r28});
        r0.H = r36;
        if (r36 == null) goto L81;
        r36.addUpdateListener(new j(r0, r5));
    L81:
        if (r10.S90() == false) goto L85;
        ValueAnimator r37 = r0.H;
        if (r37 == null) goto L85;
        com.bytedance.android.live.core.utils.h.a(r37, new LivePortraitInputDialogV3$innerLoadSecondaryPage$4(r0, r5));
    L85:
        ValueAnimator r38 = r0.H;
        if (r38 == null) goto L91;
        ValueAnimator r39 = r38.setDuration(250);
        if (r39 == null) goto L91;
        r39.start();
    L91:
        if (r10.S90() == false) goto L96;
        InterceptLinearLayout r40 = r0.G;
        if (r40 == null) goto L97;
        UtilityKotlinExtentionsKt.t(r40);
        return;
    L97:
        return;
    L96:
        return;
    L68:
        r33 = 0;
        goto L69
    L64:
        r30 = 0;
        goto L65
    L70:
        FrameLayout r41 = r0.w;
        if (r41 == null) goto L73;
        r34 = r41.getHeight();
        goto L74
    L73:
        r34 = 0;
        goto L74
    L58:
        r27 = 0;
    L50:
        r23.setCustomAnimations(2130772704, 2130772705);
        goto L52
    L10:
        r6 = null;
    L6:
        r3 = InputSectionType.NONE;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void s0(String r8, long r9) {
        CommentFlowContext r0 = S();
        if (r0 == null) goto L8;
        CommentContentType r1 = CommentContentType.Audio;
        CommentBusinessType r2 = CommentBusinessType.Normal;
        y22.a r3 = new y22.a();
        Intrinsics.checkNotNullParameter(r1, "contentType");
        Intrinsics.checkNotNullParameter(r2, "businessType");
        Intrinsics.checkNotNullParameter(r3, "content");
        r0.a = CommentFlowContext.State.Send;
        r0.e = r1;
        r0.f = r2;
        if (r0.a() != true) goto L8;
        this.p.dismissInputDialog();
        return;
    L8:
        LivePortraitInputDialogV3 r4 = this.p;
        int r5 = LivePortraitInputDialogV3.L;
        x22.e r6 = r4.e;
        if (r6 == null) goto L29;
        c r7 = V();
        if (r7 == null) goto L15;
        a r10 = r7.g;
        if (r10 == null) goto L15;
        boolean r11 = r10.s;
    L16:
        CommentWidget r13 = ((CommentWidget.e) r6).a;
        int r14 = CommentWidget.V1;
        r13.getClass();
        IMiddlewareUserService r15 = jc1.k.f(IMiddlewareUserService.class);
        if (r15 == null) goto L29;
        com.bytedance.android.livesdk.user.e r16 = r15.user();
        if (r16 == null) goto L29;
        if (r16.isLogin() == true) goto L26;
        Context r17 = ((Widget) r13).context;
        com.bytedance.android.livesdk.user.l.a r18 = new com.bytedance.android.livesdk.user.l.a();
        r18.a = s1.B(2131915990);
        r18.d = "comment_live";
        r18.c = -1;
        r16.login(r17, new com.bytedance.android.livesdk.user.l(r18)).compose(r13.getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L29
    L26:
        if (r16.g(LiveInteractFunction.COMMENT) == true) goto L29;
        r13.y.j0(r8, r9, false, r11);
    L15:
        r11 = false;
    L29:
        this.p.dismissInputDialog();
    }

    public LivePortraitInputDialogV3$initFramework$2(LivePortraitInputDialogV3 r4, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r5, DanmakuSectionProvider r6, b1 r7, t1 r8, x.a r9, DanmakuSectionProvider.c r10, AudioComposeSectionProvider.g r11, d1.d r13, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r14, t1.d r15, e0.d r16, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r17, x.a r18, DanmakuSectionProvider.c r19, AudioComposeSectionProvider.g r110, d1.d r20, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r21, t1.d r23, e0.d r24, b1.c r25) {
        this.p = r4;
        this.q = r5;
        this.r = r6;
        this.s = r7;
        this.t = r8;
        super(r17, null, r18, r19, r110, r24, r20, r21, r23, r25, 2);
    }
}
