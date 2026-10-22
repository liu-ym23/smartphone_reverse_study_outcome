package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.InputPositionNameDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends com.bytedance.android.livesdk.common.b implements View.OnClickListener, VoiceChatMuteManager.a {
    public View A;
    public View B;
    public String C;
    public final int D;
    public TextView E;
    public TextView F;
    public String G;
    public TextView H;
    public Boolean I;
    public int J;
    public int K;
    public final CompositeDisposable L;
    public final y M;
    public final DataCenter b;
    public final IRoom c;
    public final Context d;
    public final ILinkPlayerInfoBridge e;
    public final boolean f;
    public final com.bytedance.android.live.liveinteract.voicechat.b g;
    public x0 h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public View w;
    public View x;
    public View y;
    public View z;

    public final void c() {
        x0 r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L27;
        x0 r1 = this.h;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r1);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L9:
        if (Looper.myLooper() == r2.getLooper()) goto L11;
        r2.post(DialogLancet.createDismissRunnable(r1));
        return;
    }

    public final boolean d() {
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L7;
        if (IVoiceChatAdminService.a.a().isKtvOn() == false) goto L7;
    L8:
        return true;
    L7:
        if (je0.d.y() == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.app.Dialog*/.onAttachedToWindow();
        com.bytedance.android.live.liveinteract.voicechat.b r0 = this.g;
        if (r0 == null) goto L6;
        r0.a(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.L.dispose();
        com.bytedance.android.live.liveinteract.voicechat.b r0 = this.g;
        if (r0 == null) goto L6;
        r0.g(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(p r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void g(IBaseUser r1) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        r0.kickOut(r1);
        return;
    L7:
        if (je0.d.y() == false) goto L14;
        if (r1 != null) goto L10;
        return;
    L10:
        if (jc1.k.f(IKtvService.class) == null) goto L16;
        jc1.k.f(IKtvService.class).kickOut(r1);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void C(String r3) {
        if (TextUtils.equals(r3, jc1.k.f(IMiddlewareUserService.class).user().n()) == false) goto L5;
        f2.c(s1.B(2131923173), 0);
    L8:
        c();
        a(this);
        return;
    L5:
        String r4 = b(r3);
        if (TextUtils.isEmpty(r4) == true) goto L8;
        f2.c(s1.C(2131923172, new Object[]{r4}), 0);
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void V(String r3) {
        if (TextUtils.equals(r3, jc1.k.f(IMiddlewareUserService.class).user().n()) == false) goto L5;
        f2.c(s1.B(2131923166), 0);
    L8:
        c();
        a(this);
        return;
    L5:
        String r4 = b(r3);
        if (TextUtils.isEmpty(r4) == true) goto L8;
        f2.c(s1.C(2131923165, new Object[]{r4}), 0);
        goto L8
    }

    public final String b(String r4) {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 != null) goto L5;
        return "";
    L5:
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 != null) goto L8;
        return "";
    L8:
        IBaseUser r5 = r1.c5(r4);
        if (r5 != null) goto L12;
        return "";
    L12:
        if (r5.getNickName().length() <= 10) goto L15;
        return r5.getNickName().substring(0, 10) + "...";
    L15:
        return r5.getNickName();
    }

    public final void e(TalkRoomOperate r3) {
        if (jc1.k.f(IMiddlewareUserService.class).user().isAdmin() == false) goto L5;
        f2.b(2131914522, 0);
    L6:
        x.C0(r3);
        return;
    L5:
        f2.b(2131917298, 0);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(int r4) {
        if (this.h != null) goto L6;
        Context r0 = getContext();
        x0.d r1 = new x0.d();
        r1.b = r0;
        r1.a = 2;
        r1.d = r0.getText(r4);
        r1.k = false;
        this.h = new x0(r1.b, r1);
    L6:
        if (this.h.isShowing() == true) goto L16;
        x0 r5 = this.h;
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r17) {
        int r1 = r17.getId();
        String r6 = null;
        boolean r7 = false;
        if (r1 == 2131386504) goto L5;
        boolean r8 = true;
        if (r1 != 2131365133) goto L48;
        String r2 = jc1.k.f(IMiddlewareUserService.class).user().n();
        if (this.g != null) goto L30;
        a(this);
        return;
    L30:
        if (this.f == false) goto L33;
        f(2131919829);
        String r3 = this.G;
        d();
        TalkRoomLogUtils.z(r3, je0.d.k0(this.e.getUser().getIdString()), "");
        this.g.f(this.e.getUser().getIdString(), null);
        return;
    L33:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L38;
        if (TextUtils.equals(this.e.getUser().getIdString(), r2) == true) goto L38;
        f(2131919829);
        String r4 = this.G;
        d();
        TalkRoomLogUtils.z(r4, je0.d.k0(this.e.getUser().getIdString()), "");
        this.g.f(this.e.getUser().getIdString(), null);
        return;
    L38:
        if (TextUtils.equals(this.e.getUser().getIdString(), r2) == false) goto L46;
        String r5 = this.G;
        d();
        TalkRoomLogUtils.z(r5, je0.d.k0(this.e.getUser().getIdString()), "");
        if (this.g.i() == true) goto L43;
        f2.b(2131919299, 0);
        return;
    L43:
        if (this.g.e(true) == false) goto L45;
        f(2131919829);
        this.g.d("self_panel", false, null, true);
        return;
    L45:
        f2.b(2131917527, 0);
        return;
    L46:
        e(TalkRoomOperate.UNSILENCE);
        return;
    L48:
        if (r1 != 2131369129) goto L98;
        if (TextUtils.equals(jc1.k.f(IMiddlewareUserService.class).user().n(), this.e.getUser().getIdString()) == true) goto L52;
    L64:
        String r9 = s1.B(2131919267);
        String r10 = s1.B(2131915442);
        if (this.f == false) goto L71;
        String r11 = s1.C(2131919814, new Object[]{com.bytedance.android.live.liveinteract.plantform.model.n.e(this.e.getUser().getNickName())});
        if (d() == false) goto L69;
        r6 = s1.B(2131919479);
    L69:
        DialogInterface.OnClickListener r12 = new j(this);
    L85:
        if (d() == true) goto L87;
    L95:
        j0.a r13 = new j0.a(getContext());
        r13.a = r11;
        r13.a(r9, r12);
        r13.b(r10, new n());
        r13.c();
        return;
    L87:
        if (TextUtils.isEmpty(r6) == true) goto L95;
        Context r14 = getContext();
        x0.d r15 = new x0.d();
        r15.b = r14;
        r15.a = 0;
        r15.a = 5;
        r15.k = false;
        r15.c = r11;
        r15.d = r6;
        x0.c[] r16 = r15.g;
        x0.c r18 = r16[0];
        if (r18 != null) goto L91;
        r18 = new x0.c();
        r16[0] = r18;
    L91:
        r18.a = r9;
        r18.b = r12;
        DialogInterface.OnClickListener r19 = new m();
        x0.c[] r20 = r15.g;
        x0.c r21 = r20[1];
        if (r21 != null) goto L94;
        r21 = new x0.c();
        r20[1] = r21;
    L94:
        r21.a = r10;
        r21.b = r19;
        x0.b.g(new x0(r15.b, r15));
        return;
    L71:
        if (TextUtils.equals(jc1.k.f(IMiddlewareUserService.class).user().n(), this.e.getUser().getIdString()) == true) goto L79;
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L79;
        r11 = s1.C(2131919814, new Object[]{com.bytedance.android.live.liveinteract.plantform.model.n.e(this.e.getUser().getNickName())});
        if (d() == false) goto L77;
        r6 = s1.B(2131919479);
    L77:
        r12 = new k(this);
    L79:
        if (TextUtils.equals(jc1.k.f(IMiddlewareUserService.class).user().n(), this.e.getUser().getIdString()) == true) goto L81;
        e(TalkRoomOperate.DISCONNECT);
        return;
    L81:
        if (d() == false) goto L83;
        r6 = s1.B(2131919492);
    L83:
        r11 = s1.B(2131919817);
        r12 = new l(this);
        goto L85
    L52:
        if (s0.c(this.f) == false) goto L64;
        a(this);
        u r22 = com.bytedance.android.live.liveinteract.api.utils.m.f(this.b, 0L);
        if (r22 != null) goto L56;
    L58:
        int r23 = 5;
    L59:
        boolean r24 = this.f;
        String r25 = this.G;
        int r26 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r27 = TalkRoomFeedbackDialog.a.a(r23, r24, r25, null, false, null, null, null, 1016);
        FragmentManager r28 = ContextUtil.contextToFragmentActivity(getContext()).getSupportFragmentManager();
        LandscapeRestrictionOperation r29 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r27, "TalkRoomFeedbackDialog", r29);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r28, r27, r29) == true) goto L325;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L274
    L63:
        r27.show(r28, "TalkRoomFeedbackDialog");
        return;
    L325:
        return;
    L56:
        if (r22.s().getValue() == null) goto L58;
        r23 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) r22.s().getValue()).t().a;
        goto L59
    L98:
        if (r1 != 2131385913) goto L103;
        a(this);
        if (this.b == null) goto L304;
        jc1.k.f(g50.c.class).openGiftDialog(this.e.getUser());
        return;
    L304:
        return;
    L103:
        if (r1 != 2131384367) goto L111;
        a(this);
        ILinkPlayerInfoBridge r30 = this.e;
        if (r30 != null) goto L107;
        return;
    L107:
        if (r30.getUser() == null) goto L326;
        jc1.k.f(IMiddlewareReportService.class).reportWithUserProfileEvent(ReportConstant.BusinessSource.NewProfile, this.e.getUser(), this.c, new UserProfileEvent(this.e.getUser()).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
        return;
    L326:
        return;
    L111:
        if (r1 != 2131386397) goto L114;
        a(this);
        xs2.b.a().post(new UserProfileEvent(this.e.getUser()).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience").setShowSendGift(true));
        return;
    L114:
        if (r1 != 2131365114) goto L117;
        a(this);
        return;
    L117:
        if (r1 != 2131365105) goto L120;
        a(this);
        return;
    L120:
        if (r1 != 2131385955) goto L131;
        ILinkPlayerInfoBridge r31 = this.e;
        if (r31 != null) goto L124;
    L129:
        a(this);
        return;
    L124:
        if (r31.getUser() == null) goto L129;
        boolean r32 = !((Boolean) r17.getTag()).booleanValue();
        String r33 = this.e.getUser().getIdString();
        IRoom r34 = this.c;
        if (r34 == null) goto L129;
        oe0.d.c(r32, r33, r34.getRoomId(), getContext(), this.b);
        goto L129
    L131:
        if (r1 != 2131371668) goto L147;
        if (this.d != null) goto L136;
        return;
    L136:
        if (je0.d.h().intValue() != 27) goto L138;
        r7 = true;
    L138:
        Boolean r35 = Boolean.valueOf(r7);
        ILinkPlayerInfoBridge r36 = this.e;
        if (r36 != null) goto L141;
    L145:
        com.bytedance.android.live.liveinteract.videotalk.utils.e.b(this.d, r35.booleanValue(), this.c, r6, this.L, new o(this));
        return;
    L141:
        if (r36.getUser() == null) goto L145;
        if (this.e.getUser().getIdString() == null) goto L145;
        r6 = this.e.getUser().getIdString();
        goto L145
    L147:
        if (r1 != 2131385960) goto L169;
        a(this);
        int r37 = this.D;
        if (r37 != (-1)) goto L152;
        r37 = this.e.getUserPosition();
    L152:
        int r110 = r37;
        if (TeamFightContext.isTeamFightShowing() == false) goto L156;
        f2.b(2131922781, 0);
        return;
    L156:
        if (this.e.isEnlarged() == true) goto L162;
        ArrayList<c0> r38 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(this.e.getUser().getIdString()) == false) goto L162;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L162;
        f2.b(2131919001, 0);
        return;
    L162:
        InputPositionNameDialog r39 = new InputPositionNameDialog(this.d, r110, this.c, "", true, true);
        if (DialogLancet.shouldBlockDialogShow(r39) == false) goto L282;
        DialogLancet.handleBlockedDialogShow(r39);
    L167:
        a(this);
        boolean r40 = hd0.c.f().h();
        jf0.a r41 = jf0.a.a;
        jf0.a.a(this.D, r40, false, "name", this.I.booleanValue());
        return;
    L282:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L275
    L166:
        DialogLancet.beforeDialogShow(r39);
        r39.show();
        DialogLancet.afterDialogShow(r39);
        goto L167
    L169:
        if (r1 != 2131371431) goto L198;
        if (this.e.isEnlarged() == true) goto L177;
        ArrayList<c0> r42 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(this.e.getUser().getIdString()) == false) goto L177;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L177;
        f2.b(2131919001, 0);
        return;
    L177:
        int r43 = this.D;
        if (r43 != (-1)) goto L182;
        r43 = this.e.getUserPosition();
    L182:
        if (je0.d.N() == false) goto L186;
        if (je0.d.w() == true) goto L186;
    L191:
        Boolean.valueOf(r8).booleanValue();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m r44 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m(this.d, this.f, this.e.getUserPosition(), this.c, true, Boolean.valueOf(this.e.isEnlarged()), Boolean.FALSE);
        if (DialogLancet.shouldBlockDialogShow(r44) == false) goto L284;
        DialogLancet.handleBlockedDialogShow(r44);
    L196:
        jf0.a r45 = jf0.a.a;
        jf0.a.c(r43, false, false, this.I.booleanValue());
        a(this);
        return;
    L284:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L276
    L195:
        DialogLancet.beforeDialogShow(r44);
        r44.show();
        DialogLancet.afterDialogShow(r44);
    L186:
        if (je0.d.u() == true) goto L188;
    L190:
        r8 = false;
        goto L191
    L188:
        if (d0.h(this.c) == true) goto L190;
    L198:
        if (r1 != 2131368795) goto L240;
        if (this.e.isEnlarged() == true) goto L207;
        ArrayList<c0> r46 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(this.e.getUser().getIdString()) == false) goto L207;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L207;
        f2.b(2131919001, 0);
        return;
    L207:
        if (this.c == null) goto L328;
        final long r47 = System.currentTimeMillis();
        String r48 = this.C;
        if (r48 != null) goto L213;
        r48 = "";
    L213:
        ThemedCompetitionContext.a r49 = ThemedCompetitionContext.Companion;
        if (r49.g() == true) goto L216;
    L218:
        ILinkPlayerInfoBridge r50 = this.e;
        if (r50 != null) goto L221;
    L227:
        r8 = false;
    L229:
        if (r49.g() == true) goto L231;
    L234:
        Boolean r51 = Boolean.FALSE;
    L236:
        if (r51.booleanValue() == true) goto L238;
        this.M.M(this.D);
    L238:
        jf0.a.a.delete(r48, this.D, false, this.I.booleanValue());
        this.L.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).setPositionAttribute(this.c.getId(), this.D, "").compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r47), new i(this, r47)));
        return;
    L231:
        if (this.e == null) goto L234;
        if (r8 == true) goto L234;
        r51 = Boolean.TRUE;
        goto L236
    L221:
        if (r50.getUser() == null) goto L227;
        if (this.c == null) goto L227;
        if (TextUtils.equals(this.e.getUser().getIdString(), this.c.getOwnerUserIdString()) == false) goto L227;
    L216:
        if (this.D != this.M.q()) goto L218;
        r51 = Boolean.TRUE;
        goto L236
    L328:
        return;
    L240:
        if (r1 != 2131362284) goto L250;
        boolean r52 = hd0.c.f().h();
        jf0.a r53 = jf0.a.a;
        jf0.a.a(this.D, r52, false, "order", this.I.booleanValue());
        if (je0.d.h() == null) goto L248;
        AdjustGuestPositionDialog r54 = new AdjustGuestPositionDialog(this.d, je0.d.f(), je0.d.h().intValue(), this.c, this.D);
        if (DialogLancet.shouldBlockDialogShow(r54) == false) goto L280;
        DialogLancet.handleBlockedDialogShow(r54);
        goto L248
    L280:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L277
    L247:
        DialogLancet.beforeDialogShow(r54);
        r54.show();
        DialogLancet.afterDialogShow(r54);
    L248:
        a(this);
        return;
    L250:
        if (r1 != 2131385959) goto L267;
        ILinkPlayerInfoBridge r55 = this.e;
        if (r55 != null) goto L254;
        return;
    L254:
        if (r55.getUser() != null) goto L256;
        return;
    L256:
        if (this.c != null) goto L259;
        return;
    L259:
        if (this.e.getThemedCompetitionRole() == ThemedCompetitionRole.PERFORMER.getValue()) goto L262;
        r7 = true;
    L262:
        ThemedCompetitionContext.a r56 = ThemedCompetitionContext.Companion;
        if (r56.c() == null) goto L265;
        r56.c().Z6(this.c.getRoomId(), this.e.getUser().getIdString(), r7);
    L265:
        a(this);
        return;
    L267:
        if (r1 == 2131362287) goto L269;
        return;
    L269:
        if (TeamFightContext.Companion.d() == false) goto L271;
        com.bytedance.android.live.liveinteract.revenue.fight.c r57 = TeamFightContext.getTeamFightWidget();
        Objects.requireNonNull(r57);
        r57.e5(this.K, this.J, this.D, this.e.getUser().getIdString());
    L272:
        a(this);
        return;
    L271:
        f2.c(s1.B(2131915773), 0);
        goto L272
    L5:
        if (this.g != null) goto L8;
        a(this);
        return;
    L8:
        if (this.f == false) goto L11;
        f(2131919826);
        TalkRoomLogUtils.A(this.G, null, je0.d.k0(this.e.getUser().getIdString()), "");
        this.g.h(this.e.getUser().getIdString());
        return;
    L11:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == false) goto L16;
        if (TextUtils.equals(this.e.getUser().getIdString(), jc1.k.f(IMiddlewareUserService.class).user().n()) == true) goto L16;
        f(2131919826);
        TalkRoomLogUtils.A(this.G, null, je0.d.k0(this.e.getUser().getIdString()), "");
        this.g.h(this.e.getUser().getIdString());
        return;
    L16:
        if (TextUtils.equals(this.e.getUser().getIdString(), jc1.k.f(IMiddlewareUserService.class).user().n()) == false) goto L23;
        TalkRoomLogUtils.A(this.G, null, je0.d.k0(this.e.getUser().getIdString()), "");
        if (this.g.i() == true) goto L21;
        f2.b(2131919299, 0);
        return;
    L21:
        if (this.g.e(false) == false) goto L290;
        f(2131919826);
        this.g.b("self_panel", null);
        return;
    L290:
        return;
    L23:
        e(TalkRoomOperate.SILENCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r13) {
        super/*android.app.Dialog*/.onCreate(r13);
        setContentView(LayoutInflater.from(getContext()).inflate(2131565523, null));
        Window r14 = getWindow();
        if (r14 == null) goto L5;
        r14.setGravity(80);
        r14.setLayout(-1, -2);
    L5:
        this.I = Boolean.valueOf(jc1.k.f(IMiddlewareUserService.class).user().c());
        if (this.e == null) goto L179;
        this.i = (TextView) findViewById(2131386504);
        this.j = (TextView) findViewById(2131365133);
        this.k = (TextView) findViewById(2131369129);
        this.l = (TextView) findViewById(2131385913);
        this.H = (TextView) findViewById(2131384367);
        this.m = (TextView) findViewById(2131386397);
        this.n = (TextView) findViewById(2131365114);
        this.p = (TextView) findViewById(2131365105);
        this.o = (TextView) findViewById(2131374360);
        this.E = (TextView) findViewById(2131385955);
        this.F = (TextView) findViewById(2131371668);
        TextView r15 = (TextView) findViewById(2131385960);
        this.r = r15;
        r15.setOnClickListener(this);
        TextView r16 = (TextView) findViewById(2131371431);
        this.s = r16;
        r16.setOnClickListener(this);
        TextView r17 = (TextView) findViewById(2131368795);
        this.t = r17;
        r17.setOnClickListener(this);
        this.w = findViewById(2131377927);
        this.x = findViewById(2131377916);
        this.y = findViewById(2131377913);
        this.q = (TextView) findViewById(2131362284);
        this.z = findViewById(2131377909);
        this.u = (TextView) findViewById(2131385959);
        this.v = (TextView) findViewById(2131362287);
        this.B = findViewById(2131377910);
        this.A = findViewById(2131377926);
        this.q.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        boolean r4 = false;
        if (this.e.getSilenceStatus() != 0) goto L12;
        this.i.setVisibility(0);
        this.j.setVisibility(8);
    L20:
        boolean r18 = jc1.k.f(IMiddlewareUserService.class).user().E(Long.valueOf(this.c.getRoomId()));
        if (this.e == null) goto L37;
        boolean r6 = this.f;
        if (r6 == true) goto L26;
        if (r18 == false) goto L37;
    L26:
        if (je0.d.K(r6, r18) == false) goto L37;
        if (je0.d.f() != 5) goto L37;
        if (d0.h(this.c) == false) goto L32;
    L36:
        boolean r19 = true;
    L38:
        if (r19 == true) goto L40;
    L48:
        this.E.setVisibility(8);
    L49:
        ILinkPlayerInfoBridge r110 = this.e;
        if (r110 != null) goto L52;
    L66:
        this.F.setVisibility(8);
    L68:
        if (this.e == null) goto L82;
        UIUtils.setViewVisibility(this.l, 8);
        if (this.f == false) goto L73;
    L77:
        UIUtils.setViewVisibility(this.o, 0);
        if (TextUtils.equals(this.e.getUser().getIdString(), jc1.k.f(IMiddlewareUserService.class).user().b().getIdString()) == false) goto L80;
        UIUtils.setText(this.o, s1.B(2131919309));
        goto L82
    L80:
        UIUtils.setText(this.o, s1.C(2131919308, new Object[]{com.bytedance.android.live.liveinteract.plantform.model.n.e(this.e.getUser().getNickName())}));
        goto L82
    L73:
        if (jc1.k.f(IMiddlewareUserService.class).user().c() == true) goto L77;
        if (TextUtils.equals(this.e.getUser().getIdString(), jc1.k.f(IMiddlewareUserService.class).user().b().getIdString()) == false) goto L77;
        UIUtils.setViewVisibility(this.m, 8);
        UIUtils.setViewVisibility(this.o, 8);
    L82:
        if (this.e.isAnonymous() == false) goto L84;
        this.m.setVisibility(8);
        this.p.setVisibility(8);
        this.H.setVisibility(0);
    L84:
        y r111 = this.M;
        if (r111 == null) goto L96;
        CopyOnWriteArrayList<LinkmicPositionItem> r112 = r111.e;
        if (r112 == null) goto L96;
        int r7 = 0;
    L90:
        if (r7 >= r112.size()) goto L96;
        if (((LinkmicPositionItem) ListProtector.get(r112, r7)).getPosition() == this.D) goto L93;
        r7 = r7 + 1;
        goto L90
    L93:
        this.C = ((LinkmicPositionItem) ListProtector.get(r112, r7)).getActiveName();
    L96:
        if (TextUtils.isEmpty(this.C) == true) goto L99;
        this.r.setVisibility(8);
        this.w.setVisibility(8);
        this.s.setVisibility(0);
        this.x.setVisibility(0);
        this.t.setVisibility(0);
        this.y.setVisibility(0);
    L99:
        if (TeamFightContext.isTeamFightShowing() == false) goto L103;
        if (li0.d.g(null) == true) goto L103;
    L110:
        this.r.setVisibility(8);
        this.w.setVisibility(8);
        this.s.setVisibility(8);
        this.x.setVisibility(8);
        this.t.setVisibility(8);
        this.y.setVisibility(8);
    L112:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.e() == false) goto L114;
    L123:
        this.q.setVisibility(8);
        this.z.setVisibility(8);
    L125:
        if (this.f == true) goto L130;
        if (jc1.k.f(IMiddlewareUserService.class).user().t(Long.valueOf(this.c.getRoomId())) == true) goto L130;
        this.r.setVisibility(8);
        this.w.setVisibility(8);
        this.s.setVisibility(8);
        this.x.setVisibility(8);
        this.t.setVisibility(8);
        this.y.setVisibility(8);
    L130:
        if (ThemedCompetitionContext.Companion.g() == true) goto L132;
    L152:
        TextView r113 = this.u;
        if (r113 == null) goto L155;
        r113.setVisibility(8);
    L155:
        View r114 = this.A;
        if (r114 == null) goto L159;
        r114.setVisibility(8);
    L159:
        if (li0.d.g(null) == true) goto L161;
    L170:
        Integer r115 = je0.d.h();
        if (r115 == null) goto L179;
        if (r115.intValue() != 28) goto L175;
        r4 = true;
    L175:
        if (r4 == false) goto L177;
    L178:
        this.r.setVisibility(8);
        this.w.setVisibility(8);
        this.s.setVisibility(8);
        this.x.setVisibility(8);
        this.t.setVisibility(8);
        this.y.setVisibility(8);
        goto L179
    L177:
        if (r115.intValue() != 30) goto L179;
    L161:
        if (TeamFightContext.isTeamFightShowing() == false) goto L170;
        if (li0.d.c(this.e.getUser().getIdString()) == (-1)) goto L170;
        TextView r116 = this.v;
        if (r116 == null) goto L167;
        r116.setVisibility(0);
    L167:
        View r117 = this.B;
        if (r117 == null) goto L170;
        r117.setVisibility(0);
        goto L170
    L132:
        if (ThemedCompetitionContext.a.e() == false) goto L152;
        if (je0.d.u() == false) goto L152;
        ILinkPlayerInfoBridge r118 = this.e;
        if (r118 == null) goto L152;
        if (r118.getThemedCompetitionRole() != ThemedCompetitionRole.CONTESTANT.getValue()) goto L140;
    L141:
        TextView r119 = this.u;
        if (r119 == null) goto L144;
        r119.setVisibility(0);
    L144:
        View r120 = this.A;
        if (r120 == null) goto L148;
        r120.setVisibility(0);
    L148:
        if (this.e.getThemedCompetitionRole() != ThemedCompetitionRole.PERFORMER.getValue()) goto L150;
        this.u.setText(s1.B(2131919403));
    L151:
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r121 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.b(false, this.e.getThemedCompetitionRole());
        goto L159
    L150:
        this.u.setText(s1.B(2131919407));
        goto L151
    L140:
        if (this.e.getThemedCompetitionRole() != ThemedCompetitionRole.PERFORMER.getValue()) goto L152;
    L114:
        if (this.e.isEnlarged() == true) goto L123;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.b(this.D) == true) goto L123;
        if (je0.d.y() == true) goto L123;
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == true) goto L123;
        if (je0.d.P() == false) goto L125;
    L103:
        if (je0.d.M() == true) goto L110;
        if (je0.d.s() == true) goto L110;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f() == true) goto L110;
        if (je0.d.y() == false) goto L112;
    L52:
        if (r110.getUser() == null) goto L66;
        if (this.e.getUser().getIdString() == null) goto L66;
        if (com.bytedance.android.live.liveinteract.videotalk.utils.e.a(this.c, this.f, this.e.getUser().getIdString()) == false) goto L66;
        this.F.setVisibility(0);
        if (je0.d.h().intValue() != 27) goto L60;
        boolean r122 = true;
    L61:
        Boolean r123 = Boolean.valueOf(r122);
        TextView r8 = this.F;
        if (r123.booleanValue() == false) goto L64;
        int r124 = 2131923223;
    L65:
        r8.setText(r124);
        goto L68
    L64:
        r124 = 2131923220;
        goto L65
    L60:
        r122 = false;
        goto L61
    L40:
        if (je0.d.P() == true) goto L48;
        if (je0.d.h().intValue() == 24) goto L48;
        this.E.setVisibility(0);
        this.E.setTag(Boolean.valueOf(this.e.isEnlarged()));
        TextView r125 = this.E;
        if (this.e.isEnlarged() == false) goto L46;
        int r9 = 2131922760;
    L47:
        r125.setText(r9);
        goto L49
    L46:
        r9 = 2131922758;
        goto L47
    L32:
        if (TextUtils.equals(this.e.getUser().getIdString(), this.c.getOwnerUserIdString()) == false) goto L36;
        if (je0.d.c() != null) goto L36;
    L37:
        r19 = false;
        goto L38
    L12:
        if (this.e.getSilenceStatus() != 1) goto L14;
    L19:
        this.i.setVisibility(8);
        UIUtils.setViewVisibility(this.j, 0);
        goto L20
    L14:
        if (this.e.getSilenceStatus() == 3) goto L19;
        if (this.e.getSilenceStatus() != 2) goto L20;
        this.i.setVisibility(8);
        this.j.setVisibility(0);
    L179:
        int r126 = li0.d.b(this.D);
        if (r126 != 1) goto L182;
        this.J = 2;
    L184:
        if (this.e != null) goto L186;
        this.K = 2;
    L187:
        if (r126 != 1) goto L189;
        this.v.setText(s1.B(2131915771));
        return;
    L189:
        this.v.setText(s1.B(2131915772));
        return;
    L186:
        this.K = 1;
        goto L187
    L182:
        this.J = 1;
        goto L184
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void Q(String r3, Throwable r4) {
        c();
        boolean r0 = false;
        if ((r4 instanceof ApiServerException) == false) goto L8;
        String r5 = ((ApiServerException) r4).getPrompt();
        if (TextUtils.isEmpty(r5) == true) goto L8;
        f2.c(r5, 0);
        return;
    L8:
        if (r4 != null) goto L11;
    L15:
        if (r0 == true) goto L18;
        ExceptionUtils.handleException(getContext(), r4, 2131919337);
        return;
    L18:
        return;
    L11:
        if ((r4 instanceof ApiServerException) == false) goto L15;
        if (((ApiServerException) r4).getErrorCode() != 4004468) goto L15;
        r0 = true;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void i0(String r2, Throwable r3) {
        c();
        if ((r3 instanceof ApiServerException) == false) goto L8;
        String r4 = ((ApiServerException) r3).getPrompt();
        if (TextUtils.isEmpty(r4) == true) goto L8;
        f2.c(r4, 0);
        return;
    L8:
        ExceptionUtils.handleException(getContext(), r3, 2131919335);
    }

    public p(Context r3, DataCenter r4, ILinkPlayerInfoBridge r5, boolean r6) {
        super(r3, true);
        this.C = "";
        this.D = -1;
        this.G = "";
        this.I = Boolean.FALSE;
        this.J = -1;
        this.K = 0;
        this.L = new CompositeDisposable();
        this.M = (y) ((IInteractService) jc1.k.f(IInteractService.class)).getLinkUserInfoCenter();
        this.b = r4;
        this.f = r6;
        this.d = r3;
        this.c = (IRoom) r4.get("data_room");
        this.e = r5;
        this.D = r5.getUserPosition();
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L6;
        this.g = IVoiceChatAdminService.a.a().muteManager();
        return;
    L6:
        if (je0.d.y() == true) goto L8;
        return;
    L8:
        if (jc1.k.f(IKtvService.class) != null) goto L10;
        return;
    L10:
        if ((jc1.k.f(IKtvService.class).muteManager() instanceof com.bytedance.android.live.liveinteract.voicechat.b) == false) goto L16;
        this.g = (com.bytedance.android.live.liveinteract.voicechat.b) jc1.k.f(IKtvService.class).muteManager();
        return;
    }
}
