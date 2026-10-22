package com.bytedance.android.live.liveinteract.videotalk.dialog;

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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.AdjustGuestPositionDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.InputPositionNameDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
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
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkmicAIGuestType;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public int A;
    public int B;
    public final ILinkPlayerInfoBridge C;
    public final boolean D;
    public final String E;
    public final DataCenter F;
    public TextView b;
    public TextView c;
    public ILinkPlayerInfoBridge d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public String n;
    public boolean o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public String u;
    public boolean v;
    public final CompositeDisposable w;
    public final y x;
    public final IRoom y;
    public int z;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        CompositeDisposable r0 = this.w;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super.onStart();
        int r0 = c1.a;
        c1.b(getWindow(), -2, 6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(n r3) {
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

    public final boolean b(ILinkPlayerInfoBridge r2) {
        if (r2 == null) goto L6;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L6;
        String r4 = r3.getIdString();
    L8:
        if (Intrinsics.areEqual(r4, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r4 = null;
        goto L8
    }

    public final void c(TalkRoomOperate r3) {
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L5;
        f2.b(2131914522, 0);
    L6:
        x.C0(r3);
        return;
    L5:
        f2.b(2131917298, 0);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r18) {
        Intrinsics.checkNotNullParameter(r18, "v");
        int r1 = r18.getId();
        String r5 = "";
        String r6 = null;
        String r7 = null;
        r7 = null;
        String r8 = null;
        r8 = null;
        IBaseUser r9 = null;
        IBaseUser r10 = null;
        Integer r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        Object r15 = null;
        Integer r16 = null;
        r6 = null;
        if (r1 != 2131386504) goto L69;
        a(this);
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r2 = IVoiceChatAdminService.a.a();
        if (r2 == null) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.b r3 = r2.muteManager();
    L9:
        if (this.D == false) goto L33;
        ILinkPlayerInfoBridge r4 = this.d;
        if (r4 == null) goto L23;
        IBaseUser r17 = r4.getUser();
        if (r17 == null) goto L23;
        String r19 = r17.getIdString();
        if (r19 == null) goto L23;
        if (this.y.isLiveTypeAudio() == false) goto L20;
        if (r3 == null) goto L23;
        r3.h(r19);
        goto L23
    L20:
        rj0.k.m2.getClass();
        rj0.k r20 = rj0.k.a.a();
        if (r20 == null) goto L23;
        rj0.k.b.d(r20, r19);
    L23:
        String r21 = this.n;
        ILinkPlayerInfoBridge r22 = this.d;
        if (r22 == null) goto L31;
        IBaseUser r23 = r22.getUser();
        if (r23 == null) goto L31;
        String r24 = r23.getIdString();
        if (r24 == null) goto L31;
        r5 = r24;
    L31:
        TalkRoomLogUtils.A(r21, null, null, r5);
        return;
    L33:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L59;
        if (b(this.d) == true) goto L59;
        ILinkPlayerInfoBridge r25 = this.d;
        if (r25 == null) goto L49;
        IBaseUser r26 = r25.getUser();
        if (r26 == null) goto L49;
        String r27 = r26.getIdString();
        if (r27 == null) goto L49;
        if (this.y.isLiveTypeAudio() == false) goto L46;
        if (r3 == null) goto L49;
        ILinkPlayerInfoBridge r28 = this.d;
        Intrinsics.checkNotNull(r28);
        IBaseUser r29 = r28.getUser();
        Intrinsics.checkNotNull(r29);
        r3.h(r29.getIdString());
        goto L49
    L46:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r30 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r30 == null) goto L49;
        r30.li(r27, null);
    L49:
        String r31 = this.n;
        ILinkPlayerInfoBridge r32 = this.d;
        if (r32 == null) goto L57;
        IBaseUser r33 = r32.getUser();
        if (r33 == null) goto L57;
        String r34 = r33.getIdString();
        if (r34 == null) goto L57;
        r5 = r34;
    L57:
        TalkRoomLogUtils.A(r31, null, null, r5);
        return;
    L59:
        if (b(this.d) == true) goto L61;
        c(TalkRoomOperate.SILENCE);
        return;
    L61:
        if (this.y.isLiveTypeAudio() == false) goto L64;
        if (r3 == null) goto L67;
        r3.b("self_panel", null);
    L67:
        TalkRoomLogUtils.A(this.n, null, null, jc1.k.n(IMiddlewareUserService.class).user().n());
        return;
    L64:
        rj0.l.n2.getClass();
        rj0.l r35 = rj0.l.a.a();
        if (r35 == null) goto L67;
        r35.li(jc1.k.n(IMiddlewareUserService.class).user().n(), null);
        goto L67
    L7:
        r3 = null;
        goto L9
    L69:
        boolean r36 = false;
        int r37 = 0;
        boolean r38 = false;
        boolean r39 = true;
        if (r1 != 2131365133) goto L137;
        a(this);
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r40 = IVoiceChatAdminService.a.a();
        if (r40 == null) goto L74;
        com.bytedance.android.live.liveinteract.voicechat.b r41 = r40.muteManager();
    L76:
        if (this.D == false) goto L100;
        ILinkPlayerInfoBridge r42 = this.d;
        if (r42 == null) goto L90;
        IBaseUser r43 = r42.getUser();
        if (r43 == null) goto L90;
        String r44 = r43.getIdString();
        if (r44 == null) goto L90;
        if (this.y.isLiveTypeAudio() == false) goto L87;
        if (r41 == null) goto L90;
        r41.f(r44, null);
        goto L90
    L87:
        rj0.k.m2.getClass();
        rj0.k r45 = rj0.k.a.a();
        if (r45 == null) goto L90;
        r45.Q5(r44, false, null);
    L90:
        String r46 = this.n;
        ILinkPlayerInfoBridge r47 = this.d;
        if (r47 == null) goto L98;
        IBaseUser r48 = r47.getUser();
        if (r48 == null) goto L98;
        String r49 = r48.getIdString();
        if (r49 == null) goto L98;
        r5 = r49;
    L98:
        TalkRoomLogUtils.z(r46, null, r5);
        return;
    L100:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L126;
        if (b(this.d) == true) goto L126;
        ILinkPlayerInfoBridge r50 = this.d;
        if (r50 == null) goto L116;
        IBaseUser r51 = r50.getUser();
        if (r51 == null) goto L116;
        String r52 = r51.getIdString();
        if (r52 == null) goto L116;
        if (this.y.isLiveTypeAudio() == false) goto L113;
        if (r41 == null) goto L116;
        r41.f(r52, null);
        goto L116
    L113:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r53 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r53 == null) goto L116;
        r53.Td(r52, null);
    L116:
        String r54 = this.n;
        ILinkPlayerInfoBridge r55 = this.d;
        if (r55 == null) goto L124;
        IBaseUser r56 = r55.getUser();
        if (r56 == null) goto L124;
        String r57 = r56.getIdString();
        if (r57 == null) goto L124;
        r5 = r57;
    L124:
        TalkRoomLogUtils.z(r54, null, r5);
        return;
    L126:
        if (b(this.d) == true) goto L128;
        c(TalkRoomOperate.UNSILENCE);
        return;
    L128:
        if (this.y.isLiveTypeAudio() == false) goto L131;
        if (r41 == null) goto L134;
        r41.d("self_panel", false, null, true);
    L134:
        TalkRoomLogUtils.z(this.n, null, je0.d.b0());
        return;
    L131:
        rj0.l.n2.getClass();
        rj0.l r58 = rj0.l.a.a();
        if (r58 == null) goto L134;
        r58.Td(jc1.k.n(IMiddlewareUserService.class).user().n(), null);
        goto L134
    L74:
        r41 = null;
        goto L76
    L137:
        if (r1 != 2131369129) goto L171;
        if (s0.c(this.D) == true) goto L141;
    L147:
        a(this);
        String r59 = s1.B(2131919267);
        String r60 = s1.B(2131915442);
        if (this.D == false) goto L156;
        Object[] r61 = new Object[1];
        com.bytedance.android.live.liveinteract.plantform.model.m.a r62 = com.bytedance.android.live.liveinteract.plantform.model.m.q0;
        ILinkPlayerInfoBridge r63 = this.d;
        if (r63 == null) goto L154;
        IBaseUser r65 = r63.getUser();
        if (r65 == null) goto L154;
        r7 = r65.getNickName();
    L154:
        r62.getClass();
        r61[0] = com.bytedance.android.live.liveinteract.plantform.model.m.a.a(r7);
        String r66 = s1.C(2131919814, r61);
        DialogInterface.OnClickListener r67 = new j(this);
    L168:
        j0.a r68 = new j0.a(getContext());
        r68.a = r66;
        r68.b(r59, r67);
        r68.a(r60, m.a);
        r68.c();
        return;
    L156:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L166;
        if (b(this.d) == true) goto L166;
        Object[] r69 = new Object[1];
        com.bytedance.android.live.liveinteract.plantform.model.m.a r70 = com.bytedance.android.live.liveinteract.plantform.model.m.q0;
        ILinkPlayerInfoBridge r71 = this.d;
        if (r71 == null) goto L164;
        IBaseUser r72 = r71.getUser();
        if (r72 == null) goto L164;
        r8 = r72.getNickName();
    L164:
        r70.getClass();
        r69[0] = com.bytedance.android.live.liveinteract.plantform.model.m.a.a(r8);
        r66 = s1.C(2131919814, r69);
        r67 = new k(this);
    L166:
        if (b(this.d) == false) goto L169;
        r66 = s1.B(2131919817);
        r67 = new l(this);
        goto L168
    L169:
        c(TalkRoomOperate.DISCONNECT);
        return;
    L141:
        if (b(this.d) == false) goto L147;
        a(this);
        int r73 = TalkRoomFeedbackDialog.r;
        TalkRoomFeedbackDialog r74 = TalkRoomFeedbackDialog.a.a(8, this.D, this.n, null, false, null, null, null, 1016);
        FragmentActivity r75 = ContextUtil.contextToFragmentActivity(getContext());
        Intrinsics.checkNotNull(r75);
        FragmentManager r76 = r75.getSupportFragmentManager();
        LandscapeRestrictionOperation r77 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r74, "TalkRoomFeedbackDialog", r77);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r76, r74, r77) == true) goto L478;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L435
    L146:
        r74.show(r76, "TalkRoomFeedbackDialog");
        return;
    L478:
        return;
    L171:
        if (r1 != 2131386397) goto L177;
        a(this);
        xs2.b r78 = xs2.b.a();
        ILinkPlayerInfoBridge r79 = this.d;
        if (r79 == null) goto L175;
        r9 = r79.getUser();
    L175:
        r78.post(new UserProfileEvent(r9).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience").setShowSendGift(true));
        return;
    L177:
        if (r1 != 2131384367) goto L191;
        a(this);
        com.bytedance.live.datacontext.m r80 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r80 == null) goto L181;
        IRoom r81 = (IRoom) r80.getValue();
    L182:
        IMiddlewareReportService r82 = jc1.k.n(IMiddlewareReportService.class);
        ReportConstant.BusinessSource r83 = ReportConstant.BusinessSource.NewProfile;
        ILinkPlayerInfoBridge r84 = this.d;
        if (r84 == null) goto L185;
        IBaseUser r85 = r84.getUser();
    L186:
        ILinkPlayerInfoBridge r86 = this.d;
        if (r86 == null) goto L189;
        r10 = r86.getUser();
    L189:
        r82.reportWithUserProfileEvent(r83, r85, r81, new UserProfileEvent(r10).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
        return;
    L185:
        r85 = null;
        goto L186
    L181:
        r81 = null;
        goto L182
    L191:
        if (r1 != 2131365114) goto L194;
        a(this);
        return;
    L194:
        if (r1 != 2131362284) goto L215;
        int r87 = this.B;
        if (r87 != (-1)) goto L201;
        ILinkPlayerInfoBridge r88 = this.C;
        if (r88 == null) goto L202;
        r87 = r88.getUserPosition();
    L202:
        Integer r89 = je0.d.h();
        if (r89 == null) goto L212;
        int r110 = r89.intValue();
        if (r11 == null) goto L211;
        AdjustGuestPositionDialog r90 = new AdjustGuestPositionDialog(getContext(), je0.d.f(), r110, this.y, r11.intValue());
        if (DialogLancet.shouldBlockDialogShow(r90) == false) goto L445;
        DialogLancet.handleBlockedDialogShow(r90);
        goto L211
    L445:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L436
    L210:
        DialogLancet.beforeDialogShow(r90);
        r90.show();
        DialogLancet.afterDialogShow(r90);
    L211:
        a(this);
    L212:
        if (r11 == null) goto L461;
        jf0.a r91 = jf0.a.a;
        jf0.a.b(r11.intValue(), true, "order", this.v);
        return;
    L461:
        return;
    L201:
        r11 = Integer.valueOf(r87);
        goto L202
    L215:
        if (r1 != 2131385960) goto L258;
        a(this);
        int r92 = this.B;
        if (r92 != (-1)) goto L222;
        ILinkPlayerInfoBridge r93 = this.C;
        if (r93 == null) goto L223;
        r92 = r93.getUserPosition();
        goto L222
    L223:
        Integer r94 = null;
    L225:
        if (je0.d.s() == true) goto L230;
        if (je0.d.M() == true) goto L230;
        UtilityKotlinExtentionsKt.w(findViewById(2131385960));
    L230:
        if (TeamFightContext.Companion.h() == true) goto L232;
    L234:
        ILinkPlayerInfoBridge r95 = this.C;
        if (r95 == null) goto L479;
        Intrinsics.checkNotNull(r95);
        if (r95.isEnlarged() == true) goto L247;
        ArrayList<c0> r96 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        ILinkPlayerInfoBridge r97 = this.C;
        Intrinsics.checkNotNull(r97);
        IBaseUser r98 = r97.getUser();
        if (r98 == null) goto L243;
        r12 = r98.getIdString();
    L243:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(r12) == false) goto L247;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L247;
        f2.b(2131919001, 0);
        return;
    L247:
        if (r94 == null) goto L480;
        ILinkPlayerInfoBridge r99 = this.C;
        if (r99 == null) goto L256;
        InputPositionNameDialog r100 = new InputPositionNameDialog(getContext(), r99.getUserPosition(), this.y, null, true, true, 8);
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L441;
        DialogLancet.handleBlockedDialogShow(r100);
        goto L256
    L441:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L437
    L255:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    L256:
        a(this);
        return;
    L480:
        return;
    L479:
        return;
    L232:
        if (li0.d.g(null) == true) goto L234;
        f2.b(2131922781, 0);
        return;
    L222:
        r94 = Integer.valueOf(r92);
        goto L225
    L258:
        if (r1 != 2131371431) goto L283;
        ILinkPlayerInfoBridge r101 = this.C;
        if (r101 == null) goto L481;
        Intrinsics.checkNotNull(r101);
        if (r101.isEnlarged() == true) goto L272;
        ArrayList<c0> r102 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        ILinkPlayerInfoBridge r103 = this.C;
        Intrinsics.checkNotNull(r103);
        IBaseUser r104 = r103.getUser();
        if (r104 == null) goto L268;
        r13 = r104.getIdString();
    L268:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(r13) == false) goto L272;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L272;
        f2.b(2131919001, 0);
        return;
    L272:
        ILinkPlayerInfoBridge r105 = this.C;
        if (r105 == null) goto L279;
        InputPositionNameDialog r106 = new InputPositionNameDialog(getContext(), r105.getUserPosition(), this.y, this.u, true, false, 32);
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L443;
        DialogLancet.handleBlockedDialogShow(r106);
        goto L279
    L443:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L438
    L278:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
    L279:
        a(this);
        ILinkPlayerInfoBridge r107 = this.C;
        if (r107 == null) goto L467;
        int r108 = r107.getUserPosition();
        jf0.a r109 = jf0.a.a;
        jf0.a.b(r108, true, "name", this.v);
        return;
    L467:
        return;
    L481:
        return;
    L283:
        if (r1 != 2131368795) goto L339;
        if (this.y == null) goto L482;
        ILinkPlayerInfoBridge r111 = this.C;
        if (r111 == null) goto L483;
        Intrinsics.checkNotNull(r111);
        if (r111.isEnlarged() == true) goto L301;
        ArrayList<c0> r112 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        ILinkPlayerInfoBridge r113 = this.C;
        Intrinsics.checkNotNull(r113);
        IBaseUser r114 = r113.getUser();
        if (r114 == null) goto L295;
        String r115 = r114.getIdString();
    L297:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(r115) == false) goto L301;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L301;
        f2.b(2131919001, 0);
        return;
    L295:
        r115 = null;
    L301:
        ThemedCompetitionContext.a r116 = ThemedCompetitionContext.Companion;
        if (r116.g() == false) goto L314;
        ILinkPlayerInfoBridge r117 = this.C;
        if (r117 == null) goto L306;
        Integer r118 = Integer.valueOf(r117.getUserPosition());
    L307:
        y r119 = this.x;
        if (r119 == null) goto L310;
        Integer r120 = Integer.valueOf(r119.q());
    L312:
        if (Intrinsics.areEqual(r118, r120) == false) goto L314;
    L328:
        if (r39 == true) goto L335;
        y r121 = this.x;
        if (r121 == null) goto L335;
        ILinkPlayerInfoBridge r122 = this.C;
        if (r122 == null) goto L334;
        r37 = r122.getUserPosition();
    L334:
        r121.M(r37);
    L335:
        long r123 = System.currentTimeMillis();
        ILinkPlayerInfoBridge r124 = this.C;
        if (r124 == null) goto L470;
        this.w.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).setPositionAttribute(this.y.getId(), r124.getUserPosition(), "").compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r123), new h(this, r123)));
        return;
    L470:
        return;
    L310:
        r120 = null;
        goto L312
    L306:
        r118 = null;
    L314:
        ILinkPlayerInfoBridge r125 = this.C;
        if (r125 == null) goto L319;
        IBaseUser r126 = r125.getUser();
        if (r126 == null) goto L319;
        String r127 = r126.getIdString();
    L320:
        IRoom r128 = this.y;
        if (r128 == null) goto L323;
        r14 = r128.getOwnerUserIdString();
    L323:
        boolean r129 = Intrinsics.areEqual(r127, r14);
        if (r116.g() == false) goto L327;
        if (r129 == false) goto L328;
    L327:
        r39 = false;
    L319:
        r127 = null;
        goto L320
    L483:
        return;
    L482:
        return;
    L339:
        if (r1 != 2131362246) goto L361;
        String r130 = vm2.d.l().addTimeSchema;
        ILinkPlayerInfoBridge r131 = this.C;
        if (r131 == null) goto L359;
        IBaseUser r132 = r131.getUser();
        if (r132 == null) goto L359;
        String r133 = r132.getIdString();
        if (r133 == null) goto L359;
        if (TextUtils.isEmpty(r130) == true) goto L350;
        jc1.k.n(IBaseLiveActionHandler.class).handle(getContext(), y0.b(r130, MapsKt.mapOf(TuplesKt.to("to_user_id", r133))));
    L350:
        fj0.a r134 = fj0.b.a;
        ILinkPlayerInfoBridge r135 = this.C;
        if (r135 == null) goto L358;
        IBaseUser r136 = r135.getUser();
        if (r136 == null) goto L358;
        String r137 = r136.getIdString();
        if (r137 == null) goto L358;
        r5 = r137;
    L358:
        fj0.b.a(r5);
    L359:
        a(this);
        return;
    L361:
        if (r1 != 2131385955) goto L393;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r138 = MultiRevenueDataContext.a.d();
        if (r138 == null) goto L368;
        if (r138.n(3) == true) goto L368;
        return;
    L368:
        if (je0.d.M() == false) goto L371;
        f2.b(2131918756, 0);
        return;
    L371:
        if (fj0.e.l() == true) goto L373;
    L375:
        ILinkPlayerInfoBridge r139 = this.d;
        if (r139 == null) goto L391;
        IBaseUser r140 = r139.getUser();
        if (r140 == null) goto L391;
        Object r141 = r18.getTag();
        if ((r141 instanceof Boolean) == false) goto L383;
        r15 = r141;
    L383:
        Boolean r142 = (Boolean) r15;
        if (r142 == null) goto L386;
        r38 = r142.booleanValue();
    L386:
        boolean r143 = !r38;
        String r144 = r140.getIdString();
        com.bytedance.live.datacontext.m r145 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r145 == null) goto L391;
        IRoom r146 = (IRoom) r145.getValue();
        if (r146 == null) goto L391;
        oe0.d.c(r143, r144, r146.getRoomId(), getContext(), this.F);
    L391:
        a(this);
        return;
    L373:
        if (fj0.c.a() == true) goto L375;
        f2.b(2131919053, 0);
        return;
    L393:
        if (r1 != 2131385959) goto L421;
        ILinkPlayerInfoBridge r147 = this.C;
        if (r147 == null) goto L397;
        r16 = Integer.valueOf(r147.getThemedCompetitionRole());
    L397:
        int r148 = ThemedCompetitionRole.PERFORMER.getValue();
        if (r16 != null) goto L401;
    L403:
        ThemedCompetitionRole.CONTESTANT.getValue();
        if (r16 == null) goto L407;
        r16.intValue();
    L407:
        r36 = true;
    L408:
        pj0.b r149 = ThemedCompetitionContext.Companion.c();
        if (r149 == null) goto L419;
        long r150 = this.y.getId();
        ILinkPlayerInfoBridge r151 = this.C;
        if (r151 == null) goto L418;
        IBaseUser r152 = r151.getUser();
        if (r152 == null) goto L418;
        String r153 = r152.getIdString();
        if (r153 == null) goto L418;
        r5 = r153;
    L418:
        r149.Z6(r150, r5, r36);
    L419:
        a(this);
        return;
    L401:
        if (r16.intValue() != r148) goto L403;
    L421:
        if (r1 != 2131362287) goto L477;
        TeamFightContext.a r154 = TeamFightContext.Companion;
        if (r154.d() == false) goto L432;
        com.bytedance.android.live.liveinteract.revenue.fight.c r155 = r154.c();
        if (r155 == null) goto L433;
        int r156 = this.A;
        int r157 = this.z;
        long r158 = this.B;
        ILinkPlayerInfoBridge r159 = this.C;
        if (r159 == null) goto L431;
        IBaseUser r160 = r159.getUser();
        if (r160 == null) goto L431;
        r6 = r160.getIdString();
    L431:
        r155.e5(r156, r157, r158, r6);
    L433:
        a(this);
        return;
    L432:
        f2.c(s1.B(2131915773), 0);
        goto L433
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r21) {
        super/*android.app.Dialog*/.onCreate(r21);
        String r3 = null;
        setContentView(LayoutInflater.from(getContext()).inflate(2131565798, null));
        Window r1 = getWindow();
        if (r1 == null) goto L6;
        r1.setGravity(80);
        r1.setLayout(-1, -2);
    L6:
        if (this.d == null) goto L8;
    L17:
        this.e = (TextView) findViewById(2131386504);
        this.f = (TextView) findViewById(2131365133);
        this.g = (TextView) findViewById(2131369129);
        this.h = (TextView) findViewById(2131385913);
        this.l = (TextView) findViewById(2131387888);
        this.i = (TextView) findViewById(2131386397);
        this.m = (TextView) findViewById(2131362246);
        this.j = (TextView) findViewById(2131365114);
        this.k = (TextView) findViewById(2131374360);
        this.p = (TextView) findViewById(2131385955);
        this.b = (TextView) findViewById(2131384367);
        this.c = (TextView) findViewById(2131385960);
        this.q = (TextView) findViewById(2131371431);
        this.r = (TextView) findViewById(2131368795);
        this.s = (TextView) findViewById(2131362284);
        this.t = (TextView) findViewById(2131362287);
        this.s = (TextView) findViewById(2131362284);
        TextView r8 = this.t;
        if (r8 == null) goto L20;
        r8.setOnClickListener(this);
        Unit r9 = Unit.INSTANCE;
    L20:
        TextView r10 = this.s;
        if (r10 == null) goto L23;
        r10.setOnClickListener(this);
        Unit r11 = Unit.INSTANCE;
    L23:
        TextView r12 = this.e;
        if (r12 == null) goto L26;
        r12.setOnClickListener(this);
        Unit r13 = Unit.INSTANCE;
    L26:
        TextView r14 = this.f;
        if (r14 == null) goto L29;
        r14.setOnClickListener(this);
        Unit r15 = Unit.INSTANCE;
    L29:
        TextView r16 = this.g;
        if (r16 == null) goto L32;
        r16.setOnClickListener(this);
        Unit r17 = Unit.INSTANCE;
    L32:
        TextView r18 = this.m;
        if (r18 == null) goto L35;
        r18.setOnClickListener(this);
        Unit r19 = Unit.INSTANCE;
    L35:
        TextView r20 = this.h;
        if (r20 == null) goto L38;
        r20.setOnClickListener(this);
        Unit r22 = Unit.INSTANCE;
    L38:
        TextView r23 = this.i;
        if (r23 == null) goto L41;
        r23.setOnClickListener(this);
        Unit r24 = Unit.INSTANCE;
    L41:
        TextView r25 = this.b;
        if (r25 == null) goto L44;
        r25.setOnClickListener(this);
        Unit r26 = Unit.INSTANCE;
    L44:
        TextView r27 = this.c;
        if (r27 == null) goto L47;
        r27.setOnClickListener(this);
        Unit r28 = Unit.INSTANCE;
    L47:
        TextView r29 = this.j;
        if (r29 == null) goto L50;
        r29.setOnClickListener(this);
        Unit r30 = Unit.INSTANCE;
    L50:
        TextView r31 = this.p;
        if (r31 == null) goto L53;
        r31.setOnClickListener(this);
        Unit r32 = Unit.INSTANCE;
    L53:
        TextView r33 = this.q;
        if (r33 == null) goto L56;
        r33.setOnClickListener(this);
        Unit r34 = Unit.INSTANCE;
    L56:
        TextView r35 = this.r;
        if (r35 == null) goto L59;
        r35.setOnClickListener(this);
        Unit r36 = Unit.INSTANCE;
    L59:
        TextView r37 = (TextView) findViewById(2131385959);
        if (r37 == null) goto L62;
        r37.setOnClickListener(this);
        Unit r38 = Unit.INSTANCE;
    L62:
        boolean r110 = false;
        if (this.D == false) goto L65;
    L75:
        TextView r39 = this.k;
        if (r39 == null) goto L94;
        String r111 = jc1.k.n(IMiddlewareUserService.class).user().n();
        ILinkPlayerInfoBridge r112 = this.d;
        if (r112 == null) goto L82;
        IBaseUser r113 = r112.getUser();
        if (r113 == null) goto L82;
        String r114 = r113.getIdString();
    L84:
        if ((!Intrinsics.areEqual(r111, r114)) == false) goto L92;
        Object[] r115 = new Object[1];
        ILinkPlayerInfoBridge r116 = this.d;
        if (r116 == null) goto L90;
        IBaseUser r117 = r116.getUser();
        if (r117 == null) goto L90;
        String r118 = r117.getNickName();
    L91:
        r115[0] = r118;
        String r119 = s1.C(2131920072, r115);
    L93:
        r39.setText(r119);
    L90:
        r118 = null;
        goto L91
    L92:
        r119 = s1.B(2131919309);
    L82:
        r114 = null;
    L94:
        ILinkPlayerInfoBridge r40 = this.d;
        if (r40 == null) goto L97;
        Integer r41 = Integer.valueOf(r40.getSilenceStatus());
    L99:
        if (r41 != null) goto L102;
    L109:
        if (r41 != null) goto L112;
    L117:
        if (r41 != null) goto L120;
    L125:
        if (r41 != null) goto L128;
    L135:
        ILinkPlayerInfoBridge r42 = this.d;
        this.v = jc1.k.n(IMiddlewareUserService.class).user().c();
        com.bytedance.live.datacontext.j r120 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r120 == null) goto L142;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r121 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r120.getValue();
        if (r121 == null) goto L142;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r122 = r121.t();
        if (r122 == null) goto L142;
        Integer r123 = Integer.valueOf(r122.a);
    L143:
        com.bytedance.live.datacontext.m r124 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r124 == null) goto L148;
        IRoom r125 = (IRoom) r124.getValue();
        if (r125 == null) goto L148;
        String r126 = r125.getOwnerUserIdString();
    L150:
        if (r42 == null) goto L193;
        boolean r7 = this.D;
        if (r7 == true) goto L156;
        if (this.v == false) goto L193;
    L156:
        if (je0.d.J(r7, jc1.k.n(IMiddlewareUserService.class).user().E(Long.valueOf(this.y.getRoomId()))) == false) goto L193;
        if (r123 != null) goto L160;
    L167:
        if (r123 == null) goto L172;
        if (r123.intValue() != 12) goto L172;
    L176:
        if (TeamFightContext.Companion.h() == true) goto L178;
    L179:
        TextView r2 = this.p;
        if (r2 == null) goto L182;
        UtilityKotlinExtentionsKt.w(r2);
        Unit r4 = Unit.INSTANCE;
    L182:
        TextView r5 = this.p;
        if (r5 == null) goto L186;
        r5.setTag(Boolean.valueOf(r42.isEnlarged()));
    L186:
        if (r42.isEnlarged() == false) goto L190;
        TextView r6 = this.p;
        if (r6 == null) goto L196;
        r6.setText(2131922760);
        Unit r43 = Unit.INSTANCE;
    L196:
        String r44 = "";
        if (tc0.c.h().E == true) goto L206;
        com.bytedance.live.datacontext.j r45 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r45 == null) goto L215;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r46 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r45.getValue();
        if (r46 == null) goto L215;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r47 = r46.t();
        if (r47 == null) goto L215;
        if (r47.a == 12) goto L206;
    L215:
        TextView r48 = this.l;
        if (r48 == null) goto L244;
        r48.setVisibility(8);
    L244:
        if (fj0.e.l() == true) goto L246;
    L258:
        TextView r49 = this.m;
        if (r49 == null) goto L261;
        r49.setVisibility(8);
    L261:
        if (r42 == null) goto L274;
        if (r42.isAnonymous() != true) goto L274;
        TextView r50 = this.i;
        if (r50 == null) goto L267;
        r50.setVisibility(8);
    L267:
        TextView r51 = this.l;
        if (r51 == null) goto L270;
        r51.setVisibility(8);
    L270:
        TextView r52 = this.b;
        if (r52 == null) goto L274;
        r52.setVisibility(0);
    L274:
        if (o.o(null) == false) goto L284;
        TextView r53 = this.l;
        if (r53 == null) goto L278;
        r53.setVisibility(8);
    L278:
        TextView r54 = this.p;
        if (r54 == null) goto L281;
        UtilityKotlinExtentionsKt.t(r54);
        Unit r55 = Unit.INSTANCE;
    L281:
        TextView r56 = this.p;
        if (r56 == null) goto L284;
        UtilityKotlinExtentionsKt.t(r56);
        Unit r57 = Unit.INSTANCE;
    L284:
        int r58 = c1.a;
        if (c1.a(0, je0.d.h()) == false) goto L289;
        TextView r59 = this.l;
        if (r59 == null) goto L289;
        r59.setVisibility(8);
    L289:
        y r60 = this.x;
        if (r60 == null) goto L307;
        Iterator<LinkmicPositionItem> r61 = r60.e.iterator();
    L293:
        if (r61.hasNext() == false) goto L302;
        LinkmicPositionItem r62 = r61.next();
        int r63 = (int) r62.getPosition();
        if (r42 != null) goto L297;
    L299:
        boolean r65 = false;
    L300:
        if (r65 == false) goto L293;
    L303:
        LinkmicPositionItem r66 = r62;
        if (r66 == null) goto L307;
        this.u = r66.getActiveName();
        Unit r67 = Unit.INSTANCE;
        goto L307
    L297:
        if (r63 != r42.getUserPosition()) goto L299;
        r65 = true;
        goto L300
    L302:
        r62 = null;
    L307:
        if (TextUtils.isEmpty(this.u) == true) goto L309;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.w(findViewById(2131371431));
        UtilityKotlinExtentionsKt.w(findViewById(2131377916));
        UtilityKotlinExtentionsKt.w(findViewById(2131368795));
        UtilityKotlinExtentionsKt.w(findViewById(2131377913));
    L309:
        TeamFightContext.a r68 = TeamFightContext.Companion;
        if (r68.h() == false) goto L315;
        if (li0.d.g(null) == true) goto L315;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
        UtilityKotlinExtentionsKt.t(findViewById(2131362284));
        UtilityKotlinExtentionsKt.t(findViewById(2131377909));
    L315:
        if (je0.d.M() == false) goto L317;
    L318:
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
        UtilityKotlinExtentionsKt.t(findViewById(2131362284));
        UtilityKotlinExtentionsKt.t(findViewById(2131377909));
    L320:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f() == false) goto L322;
    L323:
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
        UtilityKotlinExtentionsKt.t(findViewById(2131362284));
        UtilityKotlinExtentionsKt.t(findViewById(2131377909));
    L325:
        if (gh0.a.d() == true) goto L330;
        if (jc1.k.n(IMiddlewareUserService.class).user().t(Long.valueOf(this.y.getRoomId())) == true) goto L330;
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
    L330:
        if (r68.d() == true) goto L332;
    L342:
        if (r42 == null) goto L346;
        IBaseUser r69 = r42.getUser();
        if (r69 == null) goto L346;
        String r70 = r69.getIdString();
    L347:
        com.bytedance.live.datacontext.m r127 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r127 == null) goto L352;
        IRoom r128 = (IRoom) r127.getValue();
        if (r128 == null) goto L352;
        r3 = r128.getOwnerUserIdString();
    L352:
        boolean r71 = Intrinsics.areEqual(r70, r3);
        if (r42 == null) goto L393;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.e() == false) goto L357;
    L386:
        TextView r72 = (TextView) findViewById(2131362284);
        if (r72 == null) goto L389;
        r72.setVisibility(8);
    L389:
        View r73 = findViewById(2131377909);
        if (r73 == null) goto L393;
        r73.setVisibility(8);
        goto L393
    L357:
        if (r42.isEnlarged() == true) goto L386;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.b(this.B) == true) goto L386;
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == true) goto L386;
        if (r71 == true) goto L365;
    L380:
        TextView r74 = (TextView) findViewById(2131362284);
        if (r74 == null) goto L383;
        r74.setVisibility(0);
    L383:
        View r75 = findViewById(2131377909);
        if (r75 == null) goto L393;
        r75.setVisibility(0);
        goto L393
    L365:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a() == false) goto L380;
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.c() == false) goto L374;
        TextView r76 = (TextView) findViewById(2131362284);
        if (r76 == null) goto L371;
        r76.setVisibility(8);
    L371:
        View r77 = findViewById(2131377909);
        if (r77 == null) goto L393;
        r77.setVisibility(8);
        goto L393
    L374:
        TextView r78 = (TextView) findViewById(2131362284);
        if (r78 == null) goto L377;
        r78.setVisibility(0);
    L377:
        View r79 = findViewById(2131377909);
        if (r79 == null) goto L393;
        r79.setVisibility(0);
    L393:
        if (ThemedCompetitionContext.Companion.g() == true) goto L395;
    L420:
        TextView r80 = (TextView) findViewById(2131385959);
        if (r80 == null) goto L423;
        r80.setVisibility(8);
    L423:
        View r81 = findViewById(2131377926);
        if (r81 == null) goto L426;
        r81.setVisibility(8);
    L426:
        ILinkPlayerInfoBridge r82 = this.C;
        if (r82 == null) goto L434;
        IBaseUser r83 = r82.getUser();
        if (r83 == null) goto L434;
        String r84 = r83.getIdString();
        if (r84 == null) goto L434;
        r44 = r84;
    L434:
        int r85 = li0.d.c(r44);
        if (r85 != 1) goto L437;
        int r86 = 2;
    L438:
        this.z = r86;
        this.A = 1;
        TextView r87 = (TextView) findViewById(2131362287);
        if (r85 != 1) goto L441;
        String r88 = s1.B(2131915771);
    L442:
        r87.setText(r88);
        IInteractService r89 = (IInteractService) jc1.k.n(IInteractService.class);
        Integer r90 = je0.d.h();
        if (r90 == null) goto L445;
        int r91 = r90.intValue();
    L447:
        if (r89.isPCLandscape(0, r91) == false) goto L452;
        TextView r92 = this.p;
        if (r92 == null) goto L451;
        UtilityKotlinExtentionsKt.t(r92);
        Unit r93 = Unit.INSTANCE;
    L451:
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
        UtilityKotlinExtentionsKt.t(findViewById(2131362284));
        UtilityKotlinExtentionsKt.t(findViewById(2131377909));
    L452:
        if (r42 == null) goto L454;
        int r94 = r42.getAiGuestType();
    L456:
        if (r94 <= LinkmicAIGuestType.None.ordinal()) goto L458;
        r110 = true;
    L458:
        if (r110 == false) goto L478;
        TextView r95 = this.i;
        if (r95 == null) goto L462;
        r95.setVisibility(8);
    L462:
        TextView r96 = this.h;
        if (r96 == null) goto L465;
        r96.setVisibility(8);
    L465:
        TextView r97 = this.l;
        if (r97 == null) goto L468;
        r97.setVisibility(8);
    L468:
        TextView r98 = this.p;
        if (r98 == null) goto L471;
        UtilityKotlinExtentionsKt.t(r98);
        Unit r99 = Unit.INSTANCE;
    L471:
        UtilityKotlinExtentionsKt.t(findViewById(2131385960));
        UtilityKotlinExtentionsKt.t(findViewById(2131377927));
        UtilityKotlinExtentionsKt.t(findViewById(2131371431));
        UtilityKotlinExtentionsKt.t(findViewById(2131377916));
        UtilityKotlinExtentionsKt.t(findViewById(2131368795));
        UtilityKotlinExtentionsKt.t(findViewById(2131377913));
        UtilityKotlinExtentionsKt.t(findViewById(2131362284));
        UtilityKotlinExtentionsKt.t(findViewById(2131377909));
        return;
    L478:
        return;
    L454:
        r94 = LinkmicAIGuestType.None.ordinal();
        goto L456
    L445:
        r91 = 0;
        goto L447
    L441:
        r88 = s1.B(2131915772);
        goto L442
    L437:
        r86 = 1;
        goto L438
    L395:
        if (ThemedCompetitionContext.a.e() == false) goto L420;
        if (r42 != null) goto L398;
    L401:
        if (r42 == null) goto L420;
        if (r42.getThemedCompetitionRole() != ThemedCompetitionRole.PERFORMER.getValue()) goto L420;
    L405:
        TextView r129 = (TextView) findViewById(2131385959);
        if (r129 == null) goto L408;
        r129.setVisibility(0);
    L408:
        View r100 = findViewById(2131377926);
        if (r100 == null) goto L412;
        r100.setVisibility(0);
    L412:
        if (r42.getThemedCompetitionRole() != ThemedCompetitionRole.PERFORMER.getValue()) goto L416;
        TextView r101 = (TextView) findViewById(2131385959);
        if (r101 == null) goto L419;
        r101.setText(s1.B(2131919403));
    L419:
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r102 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.b(false, r42.getThemedCompetitionRole());
        goto L426
    L416:
        TextView r103 = (TextView) findViewById(2131385959);
        if (r103 == null) goto L419;
        r103.setText(s1.B(2131919407));
        goto L419
    L398:
        if (r42.getThemedCompetitionRole() == ThemedCompetitionRole.CONTESTANT.getValue()) goto L405;
    L346:
        r70 = null;
        goto L347
    L332:
        if (li0.d.g(null) == false) goto L342;
        if (r42 == null) goto L338;
        IBaseUser r104 = r42.getUser();
        if (r104 == null) goto L338;
        String r105 = r104.getIdString();
        if (r105 == null) goto L338;
    L340:
        if (li0.d.c(r105) == (-1)) goto L342;
        UtilityKotlinExtentionsKt.w(findViewById(2131362287));
        UtilityKotlinExtentionsKt.w(findViewById(2131377910));
    L338:
        r105 = "";
        goto L340
    L322:
        if (o.o(null) == false) goto L325;
    L317:
        if (je0.d.s() == false) goto L320;
    L246:
        if (this.D == false) goto L258;
        TextView r106 = this.m;
        if (r106 == null) goto L250;
        r106.setVisibility(0);
    L250:
        fj0.a r107 = fj0.b.a;
        if (r42 == null) goto L256;
        IBaseUser r108 = r42.getUser();
        if (r108 == null) goto L256;
        String r109 = r108.getIdString();
        if (r109 == null) goto L256;
    L257:
        fj0.b.b(r109);
    L256:
        r109 = "";
    L206:
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r130 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r130 == null) goto L218;
        if (r42 == null) goto L211;
        String r131 = r42.getInteractId();
        if (r131 == null) goto L211;
    L213:
        if (r130.c(r131) == 3) goto L215;
    L211:
        r131 = "";
    L218:
        TextView r132 = this.l;
        if (r132 == null) goto L221;
        r132.setVisibility(0);
    L221:
        com.bytedance.android.live.liveinteract.plantform.camera.b r133 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r133 == null) goto L244;
        if (r42 == null) goto L226;
        String r134 = r42.getInteractId();
        if (r134 == null) goto L226;
    L227:
        this.o = r133.d(r134);
        if (r42 == null) goto L231;
        String r135 = r42.getInteractId();
        if (r135 == null) goto L231;
    L233:
        if (r133.d(r135) == false) goto L237;
        TextView r136 = this.l;
        if (r136 == null) goto L240;
        r136.setText(s1.B(2131917596));
    L240:
        TextView r137 = this.l;
        if (r137 == null) goto L244;
        r137.setOnClickListener(new i(r133, this, r42, r123));
        Unit r138 = Unit.INSTANCE;
        goto L244
    L237:
        TextView r139 = this.l;
        if (r139 == null) goto L240;
        r139.setText(s1.B(2131917801));
    L231:
        r135 = "";
    L226:
        r134 = "";
        goto L227
    L190:
        TextView r140 = this.p;
        if (r140 == null) goto L196;
        r140.setText(2131922758);
        Unit r141 = Unit.INSTANCE;
        goto L196
    L178:
        if (li0.d.g(null) == false) goto L193;
    L172:
        if (aj0.a.d() == false) goto L193;
        if (aj0.a.b(this.y) == false) goto L193;
    L160:
        if (r123.intValue() != 8) goto L167;
        IBaseUser r142 = r42.getUser();
        if (r142 == null) goto L164;
        String r143 = r142.getIdString();
    L166:
        if ((!Intrinsics.areEqual(r143, r126)) == true) goto L176;
    L164:
        r143 = null;
    L193:
        TextView r144 = this.p;
        if (r144 == null) goto L196;
        UtilityKotlinExtentionsKt.t(r144);
        Unit r145 = Unit.INSTANCE;
    L148:
        r126 = null;
    L142:
        r123 = null;
        goto L143
    L128:
        if (r41.intValue() != 2) goto L135;
        TextView r146 = this.e;
        if (r146 == null) goto L132;
        r146.setVisibility(8);
    L132:
        TextView r147 = this.f;
        if (r147 == null) goto L135;
        r147.setVisibility(0);
        goto L135
    L120:
        if (r41.intValue() != 3) goto L125;
        TextView r148 = this.e;
        if (r148 == null) goto L124;
        r148.setVisibility(8);
    L124:
        UIUtils.setViewVisibility(this.f, 0);
        goto L135
    L112:
        if (r41.intValue() != 1) goto L117;
        TextView r149 = this.e;
        if (r149 == null) goto L116;
        r149.setVisibility(8);
    L116:
        UIUtils.setViewVisibility(this.f, 0);
        goto L135
    L102:
        if (r41.intValue() != 0) goto L109;
        TextView r150 = this.e;
        if (r150 == null) goto L106;
        r150.setVisibility(0);
    L106:
        TextView r151 = this.f;
        if (r151 == null) goto L135;
        r151.setVisibility(8);
        goto L135
    L97:
        r41 = null;
        goto L99
    L65:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == true) goto L75;
        TextView r152 = this.k;
        if (r152 == null) goto L69;
        r152.setVisibility(8);
    L69:
        TextView r153 = this.h;
        if (r153 == null) goto L72;
        r153.setVisibility(8);
    L72:
        TextView r154 = this.i;
        if (r154 == null) goto L94;
        r154.setVisibility(8);
        goto L94
    L8:
        if (r2.a(this.E) == false) goto L15;
        rj0.l.n2.getClass();
        rj0.l r155 = rj0.l.a.a();
        if (r155 == null) goto L15;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r156 = r155.getLinkUserInfoCenter();
        if (r156 == null) goto L15;
        String r157 = this.E;
        this.d = (ILinkPlayerInfoBridge) r156.getGuestInfo(r157, r156.N4(r157));
        Unit r158 = Unit.INSTANCE;
    L15:
        if (this.d != null) goto L17;
    }

    public n(Context r2, ILinkPlayerInfoBridge r3, boolean r4, String r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        super(r2, true);
        this.C = r3;
        this.D = r4;
        this.E = r5;
        this.F = r6;
        this.d = r3;
        this.n = "";
        this.u = "";
        this.w = new CompositeDisposable();
        this.x = (y) ((IInteractService) jc1.k.n(IInteractService.class)).getLinkUserInfoCenter();
        this.y = a0.n(r6);
        this.z = -1;
        this.B = -1;
    }
}
