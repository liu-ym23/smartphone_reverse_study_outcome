package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.app.Activity;
import android.content.Context;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.input.AbsLiveInputSecondaryFragment;
import com.bytedance.android.livesdk.interactivity.api.input.InputDialogFragmentSwitchType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.AudioComposeSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.DanmakuSectionProvider;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.b1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.d1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.j0;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.t1;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.x;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.z1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ec2.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class g implements z62.b, z62.f, z62.d, z62.c, z62.a, z62.j, z62.e, z62.h, z62.g {
    public EditText a;
    public long b;
    public com.bytedance.android.livesdk.interactivity.comment.audio.c c;
    public int d;
    public int e;
    public final /* synthetic */ z62.b f;
    public final /* synthetic */ z62.f g;
    public final /* synthetic */ z62.d h;
    public final /* synthetic */ z62.c i;
    public final /* synthetic */ z62.a j;
    public final /* synthetic */ z62.j k;
    public final /* synthetic */ z62.e l;
    public final /* synthetic */ z62.h m;
    public final /* synthetic */ z62.g n;

    public void A(com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItem");
        this.i.A(r2);
    }

    public void A0() {
    }

    @Override // z62.g
    public final int B() {
        return this.n.B();
    }

    public abstract void B0();

    @Override // z62.b
    public final void C(com.bytedance.android.live.base.model.data.activityemoji.b r2) {
        Intrinsics.checkNotNullParameter(r2, "activityEmoji");
        this.f.C(r2);
    }

    public void C0() {
    }

    @Override // z62.b
    public final int[] D() {
        return this.f.D();
    }

    public abstract void D0();

    @Override // z62.b
    public final void E() {
        this.f.E();
    }

    public void E0() {
    }

    @Override // z62.h
    public final void F(int r2) {
        this.m.F(r2);
    }

    public void F0() {
    }

    public void G(InputDialogFragmentSwitchType r2, AbsLiveInputSecondaryFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "switchType");
        Intrinsics.checkNotNullParameter(r3, "fragment");
    }

    public abstract void G0();

    public boolean H() {
        return false;
    }

    public abstract void I();

    public abstract void J();

    public abstract void K();

    public abstract void L();

    public void M(boolean r1) {
    }

    public void N(boolean r1) {
    }

    public abstract void O(boolean r1);

    public void P(boolean r1) {
    }

    public abstract InputSectionType Q();

    public abstract DataCenter R();

    public abstract CommentFlowContext S();

    public abstract Fragment T();

    public x22.e U() {
        return null;
    }

    public abstract com.bytedance.android.livesdk.interactivity.comment.newinput.c V();

    public abstract int W();

    public abstract int X();

    @Override // z62.d
    public final void a(EditText r2) {
        this.h.a(r2);
    }

    public abstract MeasureLinearLayout a0();

    @Override // z62.d
    public void b(BaseEmoji r2, String r3, EditText r4) {
        this.h.b(r2, r3, r4);
    }

    public abstract IBaseUser b0();

    @Override // z62.b
    public final void c() {
        this.f.c();
    }

    @Override // z62.e
    public final void d(boolean r2) {
        this.l.d(r2);
    }

    @Override // z62.b
    public final int e() {
        return this.f.e();
    }

    @Override // z62.a
    public final int f() {
        return this.j.f();
    }

    @Override // z62.b
    public final void g(com.bytedance.android.livesdk.interactivity.api.emoji.a r2) {
        Intrinsics.checkNotNullParameter(r2, "emoji");
        this.f.g(r2);
    }

    public abstract Activity getActivity();

    public abstract Context getContext();

    @Override // z62.c
    public final void h() {
        this.i.h();
    }

    @Override // z62.h
    public final boolean i() {
        return this.m.i();
    }

    @Override // z62.b
    public final void j(com.bytedance.android.livesdk.interactivity.api.emoji.a r2) {
        Intrinsics.checkNotNullParameter(r2, "emoji");
        this.f.j(r2);
    }

    @Override // z62.c
    public final void k(z62.i r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.i.k(r2);
    }

    public abstract boolean k0();

    @Override // z62.b
    public final void l(Context r2, com.bytedance.android.live.base.model.message.h r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "activityEmoji");
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "clickArea");
        this.f.l(r2, r3, r4, r5);
    }

    public abstract boolean l0();

    @Override // z62.a
    public final boolean m() {
        return this.j.m();
    }

    public abstract boolean m0();

    @Override // z62.j
    public final int n() {
        return this.k.n();
    }

    public abstract boolean n0();

    @Override // z62.b
    public final void o(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "word");
        this.f.o(r2, r3);
    }

    public void o0(InputDialogFragmentSwitchType r2, AbsLiveInputSecondaryFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "switchType");
        Intrinsics.checkNotNullParameter(r3, "fragment");
    }

    @Override // z62.g
    public final void p(z1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.n.p(r2);
    }

    public abstract void p0();

    @Override // z62.b
    public final void q(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "word");
        this.f.q(r2, r3);
    }

    public abstract void q0(InputPanelSectionContainer.c r1);

    @Override // z62.f
    public final void r(boolean r2) {
        this.g.r(r2);
    }

    public abstract void r0(TokenCert r1);

    @Override // z62.h
    public final void s(InputFunctionEnum r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        this.m.s(r2);
    }

    public void s0(String r1, long r2) {
    }

    @Override // z62.b
    public final void t(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.f.t(r2);
    }

    public abstract void t0();

    @Override // z62.b
    public final long u() {
        return this.f.u();
    }

    public abstract void u0(int r1);

    @Override // z62.j
    public final long v() {
        return this.k.v();
    }

    public abstract void v0();

    @Override // z62.b
    public final void w(TextWatcher r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        this.f.w(r2);
    }

    public void w0() {
    }

    @Override // z62.b
    public final void x(com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
        Intrinsics.checkNotNullParameter(r2, "tabItem");
        this.f.x(r2);
    }

    public void x0() {
    }

    @Override // z62.c
    public final int y() {
        return this.i.y();
    }

    public abstract void y0();

    @Override // z62.h
    public final b z() {
        return this.m.z();
    }

    public abstract void z0();

    public final boolean d0() {
        if (Intrinsics.areEqual(h0.a.getValue(), Boolean.FALSE) == false) goto L5;
        return false;
    L5:
        CommentFlowContext r0 = S();
        if (r0 == null) goto L10;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L10;
        CommentInputConfig.State r2 = r1.u;
    L12:
        if (r2 != CommentInputConfig.State.ForceOpen) goto L15;
        return true;
    L15:
        if (r2 != CommentInputConfig.State.ForeClose) goto L17;
        return false;
    L17:
        return true;
    L10:
        r2 = null;
        goto L12
    }

    public final com.bytedance.android.livesdk.interactivity.api.quickcomment.f Y() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(R(), 1);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.quickcomment.f> r1 = r0.getQuickCommentManager();
        if (r1 == null) goto L7;
        return (com.bytedance.android.livesdk.interactivity.api.quickcomment.f) r1.getValue();
    L7:
        return null;
    }

    public final long Z() {
        DataCenter r0 = R();
        if (r0 == null) goto L7;
        IRoom r1 = a0.n(r0);
        if (r1 == null) goto L7;
        return r1.getRoomId();
    L7:
        return 0;
    }

    public final boolean c0() {
        if (rf2.a.a() == false) goto L5;
        return false;
    L5:
        CommentFlowContext r0 = S();
        if (r0 == null) goto L10;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L10;
        CommentInputConfig.State r2 = r1.d;
    L12:
        if (r2 != CommentInputConfig.State.ForceOpen) goto L15;
        return true;
    L15:
        if (r2 != CommentInputConfig.State.ForeClose) goto L17;
        return false;
    L17:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = V();
        if (r3 != null) goto L20;
        return false;
    L20:
        if (r3.b != true) goto L29;
        Integer r4 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r4 != null) goto L25;
    L26:
        return true;
    L25:
        if (r4.intValue() != 2) goto L26;
        return false;
    L29:
        return false;
    L10:
        r2 = null;
        goto L12
    }

    public final boolean e0() {
        if (rf2.a.a() == false) goto L5;
        return false;
    L5:
        CommentFlowContext r0 = S();
        if (r0 == null) goto L10;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L10;
        CommentInputConfig.State r2 = r1.c;
    L12:
        if (r2 != CommentInputConfig.State.ForceOpen) goto L15;
        return true;
    L15:
        if (r2 != CommentInputConfig.State.ForeClose) goto L17;
        return false;
    L17:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = V();
        if (r3 == null) goto L20;
        boolean r4 = r3.a;
    L21:
        if (r4 == false) goto L29;
        Integer r5 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r5 != null) goto L26;
    L27:
        return true;
    L26:
        if (r5.intValue() != 2) goto L27;
        return false;
    L29:
        return false;
    L20:
        r4 = false;
    L10:
        r2 = null;
        goto L12
    }

    public final boolean f0() {
        CommentFlowContext r0 = S();
        if (r0 == null) goto L7;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L7;
        CommentInputConfig.State r2 = r1.a;
    L9:
        if (r2 != CommentInputConfig.State.ForceOpen) goto L13;
        return true;
    L13:
        if (r2 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = V();
        if (r3 != null) goto L18;
        return false;
    L18:
        return r3.c;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean g0() {
        CommentFlowContext r0 = S();
        if (r0 == null) goto L7;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L7;
        CommentInputConfig.State r2 = r1.v;
    L9:
        if (r2 != CommentInputConfig.State.ForceOpen) goto L12;
        return true;
    L12:
        if (r2 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        return true;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean h0() {
        CommentFlowContext r0 = S();
        Boolean r1 = null;
        if (r0 == null) goto L7;
        CommentInputConfig r2 = r0.d;
        if (r2 == null) goto L7;
        Boolean r3 = Boolean.valueOf(r2.w);
    L8:
        Boolean r4 = Boolean.FALSE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L11;
        return false;
    L11:
        if (rf2.a.a() == true) goto L53;
        IRoomContextService r5 = jc1.k.f(IRoomContextService.class);
        if (r5 == null) goto L46;
        o r6 = IRoomContextService.a.a(r5, R(), 0, 2);
        if (r6 == null) goto L47;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L48;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L54;
        DataCenter r9 = R();
        if (r9 == null) goto L25;
        Boolean r10 = (Boolean) r9.get("data_is_anchor", r4);
    L26:
        Boolean r11 = Boolean.TRUE;
        boolean r13 = Intrinsics.areEqual(r10, r11);
        Boolean r14 = v22.a.a;
        Intrinsics.checkNotNullParameter(r8, "room");
        IRoomAuthStatus r15 = r8.getRoomAuthStatus();
        if (r15 != null) goto L29;
    L31:
        boolean r16 = false;
    L32:
        com.bytedance.android.livesdk.interactivity.api.h r17 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r17 == null) goto L37;
        com.bytedance.live.datacontext.j<Boolean> r18 = r17.getHighlightEnable();
        if (r18 == null) goto L37;
        r1 = (Boolean) r18.getValue();
    L37:
        boolean r19 = Intrinsics.areEqual(r1, r11);
        if (r16 == false) goto L49;
        if (r19 == true) goto L41;
        return false;
    L41:
        if (v22.a.a.booleanValue() == false) goto L51;
        if (r13 == true) goto L52;
        return true;
    L52:
        return false;
    L51:
        return false;
    L49:
        return false;
    L29:
        if (r15.isEnablePinHighlight() != true) goto L31;
        r16 = true;
        goto L32
    L25:
        r10 = null;
        goto L26
    L54:
        return false;
    L48:
        return false;
    L47:
        return false;
    L46:
        return false;
    L53:
        return false;
    L7:
        r3 = null;
        goto L8
    }

    public final boolean i0() {
        CommentFlowContext r0 = S();
        if (r0 == null) goto L7;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L7;
        CommentInputConfig.State r2 = r1.k;
    L9:
        if (r2 != CommentInputConfig.State.ForceOpen) goto L13;
        return true;
    L13:
        if (r2 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        IRoomContextService r3 = jc1.k.f(IRoomContextService.class);
        if (r3 == null) goto L27;
        o r4 = IRoomContextService.a.a(r3, R(), 0, 2);
        if (r4 == null) goto L28;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L29;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L30;
        IRoomAuthStatus r7 = r6.getRoomAuthStatus();
        if (r7 != null) goto L26;
        return false;
    L26:
        return r7.isEnableInteractivtyShare();
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    L27:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean j0() {
        CommentFlowContext r0 = S();
        if (r0 == null) goto L7;
        CommentInputConfig r1 = r0.d;
        if (r1 == null) goto L7;
        CommentInputConfig.State r2 = r1.e;
    L9:
        if (r2 != CommentInputConfig.State.ForceOpen) goto L13;
        return true;
    L13:
        if (r2 != CommentInputConfig.State.ForeClose) goto L15;
        return false;
    L15:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = V();
        if (r3 != null) goto L18;
        return false;
    L18:
        return r3.e;
    L7:
        r2 = null;
        goto L9
    }

    public g(com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.d r2, j0.d r3, x.a r4, DanmakuSectionProvider.c r5, AudioComposeSectionProvider.g r6, e0.d r7, d1.d r8, com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.c r9, t1.d r10, b1.c r11, int r13) {
        z62.b r14 = r2;
        if ((r13 & 1) == 0) goto L5;
        r14 = com.bytedance.android.livesdk.interactivity.comment.newinput.provider.e.g;
    L5:
        z62.f r15 = r3;
        if ((r13 & 2) == 0) goto L8;
        r15 = j0.e;
    L8:
        z62.a r16 = r6;
        if ((r13 & 16) == 0) goto L11;
        r16 = AudioComposeSectionProvider.v;
    L11:
        z62.e r17 = r7;
        if ((r13 & 32) == 0) goto L14;
        r17 = e0.d;
    L14:
        z62.h r18 = r8;
        if ((r13 & 64) == 0) goto L17;
        r18 = d1.e;
    L17:
        Object r19 = r9;
        if ((r13 & 128) == 0) goto L20;
        r19 = com.bytedance.android.livesdk.interactivity.comment.newinput.provider.a.f;
    L20:
        z62.j r110 = r10;
        if ((r13 & 256) == 0) goto L23;
        r110 = t1.d;
    L23:
        z62.g r111 = r11;
        if ((r13 & 512) == 0) goto L26;
        r111 = b1.d;
    L26:
        Intrinsics.checkNotNullParameter(r14, "contentSectionBridge");
        Intrinsics.checkNotNullParameter(r15, "landscapeControlSectionBridge");
        Intrinsics.checkNotNullParameter(r4, "emojiSectionBridge");
        Intrinsics.checkNotNullParameter(r5, "danmakuSectionBridge");
        Intrinsics.checkNotNullParameter(r16, "audioComposeBridge");
        Intrinsics.checkNotNullParameter(r17, "inputSendSectionBridge");
        Intrinsics.checkNotNullParameter(r18, "newPortraitControlSectionBridge");
        Intrinsics.checkNotNullParameter(r19, "audioSectionBridge");
        Intrinsics.checkNotNullParameter(r110, "wordAssociateBridge");
        Intrinsics.checkNotNullParameter(r111, "mentionBridge");
        this.f = r14;
        this.g = r15;
        this.h = r4;
        this.i = r5;
        this.j = r16;
        this.k = r110;
        this.l = r17;
        this.m = r18;
        this.n = r111;
    }
}
