package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.j0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g {
    public int o;
    public final /* synthetic */ LiveLandscapeInputDialogV3 p;
    public final /* synthetic */ z62.b q;

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void B0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void G0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void I() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void L() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final boolean n0() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void z0() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void D0() {
        InputPanelSectionContainer r0 = this.p.x;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.KEYBOARD, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void J() {
        this.p.dismissInputDialog();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void K() {
        LiveLandscapeInputDialogV3 r0 = this.p;
        r0.q = 1;
        r0.dismissInputDialog();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final InputSectionType Q() {
        InputPanelSectionContainer r0 = this.p.x;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentSectionType();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final DataCenter R() {
        LiveLandscapeInputDialogV3 r0 = this.p;
        int r1 = LiveLandscapeInputDialogV3.A;
        return r0.j;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final CommentFlowContext S() {
        LiveLandscapeInputDialogV3 r0 = this.p;
        int r1 = LiveLandscapeInputDialogV3.A;
        return r0.h;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final x22.e U() {
        LiveLandscapeInputDialogV3 r0 = this.p;
        int r1 = LiveLandscapeInputDialogV3.A;
        return r0.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final c V() {
        LiveLandscapeInputDialogV3 r0 = this.p;
        int r1 = LiveLandscapeInputDialogV3.A;
        return r0.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final int W() {
        InputPanelSectionContainer r0 = this.p.x;
        if (r0 != null) goto L5;
    L7:
        InputPanelSectionContainer r1 = this.p.x;
        if (r1 != null) goto L13;
        return 0;
    L13:
        return r1.getKeyboardHeight();
    L5:
        if (r0.getKeyboardHeight() != 0) goto L7;
        return ((Number) l42.a.n.getValue()).intValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final MeasureLinearLayout a0() {
        LiveLandscapeInputDialogV3 r0 = this.p;
        int r1 = LiveLandscapeInputDialogV3.A;
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
        LiveLandscapeInputDialogV3 r0 = this.p;
        int r1 = LiveLandscapeInputDialogV3.A;
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
        InputPanelSectionContainer r0 = this.p.x;
        if (r0 == null) goto L6;
        InputPanelSectionContainer.e(r0, InputSectionType.AUDIO2TEXT, null, false, 6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void x0() {
        InputPanelSectionContainer r0 = this.p.x;
        if (r0 == null) goto L5;
        InputPanelSectionContainer.e(r0, InputSectionType.DANMAKU, null, false, 6);
    L5:
        c r1 = V();
        if (r1 == null) goto L11;
        a r2 = r1.g;
        if (r2 == null) goto L12;
        r2.c = true;
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void y0() {
        InputPanelSectionContainer r0 = this.p.x;
        if (r0 == null) goto L5;
        InputPanelSectionContainer.e(r0, InputSectionType.EMOJI, null, false, 6);
    L5:
        com.bytedance.android.livesdk.interactivity.comment.utils.a.g("comment_keyboard_emoji", d0(), g0());
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
    L9:
        z32.c.b(InputValueNode.LandscapeClickSendCount);
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
    public final void A(com.bytedance.android.live.profit.privilege.model.danmu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "tabItem");
        this.q.x(r5);
        if (Q() != InputSectionType.DANMAKU) goto L12;
        InputPanelSectionContainer r6 = this.p.x;
        if (r6 == null) goto L7;
        InputPanelSectionContainer.e(r6, InputSectionType.KEYBOARD, null, false, 6);
    L7:
        c r7 = V();
        if (r7 == null) goto L14;
        a r8 = r7.g;
        if (r8 == null) goto L15;
        r8.c = false;
        return;
    L15:
        return;
    L14:
        return;
    L12:
        O(false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void O(boolean r5) {
        InputSectionType r0 = Q();
        InputSectionType r1 = InputSectionType.DANMAKU;
        if (r0 != r1) goto L12;
        InputPanelSectionContainer r6 = this.p.x;
        if (r6 == null) goto L7;
        InputPanelSectionContainer.e(r6, InputSectionType.KEYBOARD, null, false, 6);
    L7:
        c r7 = V();
        if (r7 == null) goto L21;
        a r8 = r7.g;
        if (r8 == null) goto L22;
        r8.c = false;
        return;
    L22:
        return;
    L21:
        return;
    L12:
        InputPanelSectionContainer r2 = this.p.x;
        if (r2 == null) goto L15;
        r2.c(r1, this.a, r5);
    L15:
        c r3 = V();
        if (r3 == null) goto L24;
        a r4 = r3.g;
        if (r4 == null) goto L25;
        r4.c = r5;
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g
    public final void q0(InputPanelSectionContainer.c r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        InputPanelSectionContainer r1 = this.p.x;
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
        this.p.getClass();
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

    public d(LiveLandscapeInputDialogV3 r14, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r15, j0.d r16, x.a r17, DanmakuSectionProvider.c r18, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r19, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r20, j0.d r21, x.a r23, DanmakuSectionProvider.c r24, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r25) {
        this.p = r14;
        this.q = r15;
        super(r20, r21, r23, r24, null, null, null, r25, null, null, 880);
    }
}
