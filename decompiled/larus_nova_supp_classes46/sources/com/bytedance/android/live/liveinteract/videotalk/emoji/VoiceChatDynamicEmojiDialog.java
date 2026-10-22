package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.p0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.w0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.z0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/VoiceChatDynamicEmojiDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/BaseDynamicEmojiDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class VoiceChatDynamicEmojiDialog extends BaseDynamicEmojiDialog {
    public final b F;
    public final boolean G;

    public static final class a {
    }

    public static final class b implements cj0.l.b {
        public final /* synthetic */ VoiceChatDynamicEmojiDialog a;

        public b(VoiceChatDynamicEmojiDialog r1) {
            this.a = r1;
        }

        @Override // cj0.l.b
        public final void B0(long r5) {
            TextView r0 = (TextView) this.a.findViewById(2131391059);
            if (r5 <= 0) goto L5;
            String r6 = p6.a(r5);
        L6:
            r0.setText(r6);
            return;
        L5:
            r6 = "--:--";
            goto L6
        }
    }

    public static final class c implements com.bytedance.android.live.liveinteract.videotalk.utils.g {
        public final /* synthetic */ VoiceChatDynamicEmojiDialog a;

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.videotalk.emoji.VoiceChatDynamicEmojiDialog, java.lang.Object] */
        @Override // com.bytedance.android.live.liveinteract.videotalk.utils.g
        public final void onFinish() {
            ?? r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r2 == null) goto L16;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
        }

        public c(VoiceChatDynamicEmojiDialog r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void O0() {
        ILinkPlayerInfoBridge r0 = null;
        Object r1 = null;
        r0 = null;
        r0 = null;
        if (li0.d.g(null) == false) goto L22;
        IMiddlewareUserService r2 = jc1.k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L11;
        String r4 = r3.n();
        if (r4 == null) goto L11;
    L12:
        int r5 = li0.d.c(r4);
        if (je0.d.r() == true) goto L17;
        if (com.bytedance.android.live.ktv.common.util.a.g() == false) goto L22;
    L17:
        if (TeamFightContext.Companion.h() == false) goto L22;
        if (r5 == (-1)) goto L22;
        ((ArrayList) this.w).add(new z0(this, r4));
    L11:
        r4 = "";
    L22:
        if (ThemedCompetitionContext.Companion.g() == true) goto L24;
        return;
    L24:
        if (ThemedCompetitionContext.a.e() == true) goto L26;
        return;
    L26:
        if (je0.d.u() == false) goto L57;
        IInteractService r6 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r6 == null) goto L44;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r7 = r6.getLinkUserInfoCenter();
        if (r7 == null) goto L44;
        Iterable r8 = r7.getOnlineUserList();
        if (r8 == null) goto L44;
        Iterator r9 = r8.iterator();
    L35:
        if (r9.hasNext() == false) goto L43;
        Object r10 = r9.next();
        IBaseUser r11 = ((ILinkPlayerInfoBridge) r10).getUser();
        if (r11 == null) goto L39;
        String r12 = r11.getIdString();
    L41:
        if (Intrinsics.areEqual(r12, je0.d.b0()) == false) goto L35;
        r1 = r10;
        goto L43
    L39:
        r12 = null;
    L43:
        r0 = (ILinkPlayerInfoBridge) r1;
    L44:
        if (r0 != null) goto L46;
    L47:
        if (r0 != null) goto L49;
        return;
    L49:
        if (r0.getThemedCompetitionRole() != ThemedCompetitionRole.PERFORMER.getValue()) goto L59;
    L50:
        ((ArrayList) this.w).add(new w0(this, r0.getThemedCompetitionRole()));
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r13 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.b(false, r0.getThemedCompetitionRole());
        return;
    L59:
        return;
    L46:
        if (r0.getThemedCompetitionRole() == ThemedCompetitionRole.CONTESTANT.getValue()) goto L50;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void W0() {
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void P0() {
        boolean r2 = false;
        if (this.n == true) goto L28;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L28;
        int r0 = cj0.l.f;
        cj0.l r1 = cj0.l.a.a();
        if (r1 == null) goto L11;
        if (r1.b == 0) goto L28;
    L11:
        if (je0.d.u() == false) goto L28;
        cj0.l r3 = cj0.l.a.a();
        if (r3 == null) goto L15;
        Long r4 = Long.valueOf(r3.b);
    L16:
        ((TextView) findViewById(2131391059)).setVisibility(0);
        cj0.l r5 = cj0.l.a.a();
        if (r5 == null) goto L22;
        b r6 = this.F;
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (((ArrayList) r5.d).contains(r6) == true) goto L22;
        ((ArrayList) r5.d).add(r6);
    L22:
        TextView r7 = (TextView) findViewById(2131391059);
        if (r4 != null) goto L25;
        String r8 = "--:--";
    L26:
        r7.setText(r8);
        goto L28
    L25:
        r8 = p6.a(r4.longValue());
        goto L26
    L15:
        r4 = null;
    L28:
        if (com.bytedance.android.live.liveinteract.videotalk.utils.e.a(this.v, this.n, je0.d.b0()) == false) goto L38;
        List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r9 = this.w;
        Integer r10 = je0.d.h();
        if (r10 != null) goto L34;
    L36:
        boolean r11 = false;
    L37:
        ((ArrayList) r9).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o(this, r11));
        goto L38
    L34:
        if (r10.intValue() != 27) goto L36;
        r11 = true;
    L38:
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L43;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L43;
        String r14 = r13.getOwnerUserIdString();
    L45:
        if (je0.d.f() == 5) goto L47;
        return;
    L47:
        if (hd0.c.f().h() == false) goto L141;
        TeamFightContext.a r15 = TeamFightContext.Companion;
        if (r15.h() == false) goto L53;
        if (li0.d.g(null) == true) goto L53;
        return;
    L53:
        if (je0.d.K(this.n, jc1.k.n(IMiddlewareUserService.class).user().E(Long.valueOf(this.p))) == false) goto L143;
        int r16 = ((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout();
        CPositionContext.a r17 = CPositionContext.Companion;
        if (CPositionContext.a.b(r17) == true) goto L79;
        if (Intrinsics.areEqual(je0.d.b0(), r14) == false) goto L79;
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.b(r16) == false) goto L61;
    L62:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r18 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r18 == null) goto L69;
        ILinkPlayerInfoBridge r19 = r18.currentCPositionUser();
        if (r19 == null) goto L69;
        IBaseUser r20 = r19.getUser();
        if (r20 == null) goto L69;
        String r21 = r20.getIdString();
    L71:
        if ((!Intrinsics.areEqual(r21, r14)) == false) goto L79;
        Integer r22 = je0.d.h();
        if (r22 != null) goto L76;
        return;
    L76:
        if (r22.intValue() == 28) goto L79;
        return;
    L69:
        r21 = null;
        goto L71
    L61:
        if (r16 == 30) goto L62;
    L79:
        if (CPositionContext.a.a("") == false) goto L92;
        if (Intrinsics.areEqual(je0.d.b0(), r14) == false) goto L92;
        if (r17.d() != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal()) goto L92;
        Integer r23 = je0.d.h();
        if (r23 == null) goto L87;
        int r24 = r23.intValue();
    L89:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.b(r24) == false) goto L92;
        return;
    L87:
        r24 = 0;
    L92:
        if (CPositionContext.a.a("") == true) goto L94;
    L100:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L104;
        return;
    L104:
        if (aj0.a.d() == true) goto L106;
    L108:
        Integer r25 = je0.d.h();
        if (r25 == null) goto L119;
        if (r25.intValue() != 22) goto L119;
        if (r15.h() == false) goto L119;
        if (li0.d.g(null) == false) goto L119;
        return;
    L119:
        if (this.n == false) goto L123;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r26 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r26 == null) goto L126;
        r2 = r26.userIsCPosition(je0.d.b0());
    L126:
        Integer r27 = je0.d.h();
        if (r27 != null) goto L130;
    L132:
        Integer r28 = je0.d.h();
        if (r28 != null) goto L136;
    L138:
        ((ArrayList) this.w).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d(this, !r2, this.D));
        return;
    L136:
        if (r28.intValue() != 29) goto L138;
        return;
    L130:
        if (r27.intValue() != 24) goto L132;
        return;
    L123:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r29 = IVoiceChatGuestService.a.a();
        if (r29 == null) goto L126;
        r2 = r29.userIsCPosition(je0.d.b0());
        goto L126
    L106:
        if (aj0.a.b(this.v) == true) goto L108;
        return;
    L94:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout() != 26) goto L100;
        if (Intrinsics.areEqual(je0.d.b0(), r14) == false) goto L100;
        if (r17.e().contains(je0.d.b0()) == false) goto L100;
        return;
    L143:
        return;
    L141:
        return;
    L43:
        r14 = null;
        goto L45
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void Q0() {
        if (this.o == false) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r0 = new c1(this);
    L6:
        this.x = r0;
        ((ArrayList) this.w).add(r0);
        return;
    L5:
        r0 = new x0(this);
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void R0() {
        Boolean r0 = (Boolean) this.D.get("data_hamlet_avatar_status", Boolean.FALSE);
        if (s0.g(null) == false) goto L9;
        if (InteractiveSongContext.Companion.f() == false) goto L9;
        if (r0.booleanValue() == true) goto L9;
    L15:
        Integer r1 = je0.d.h();
        if (r1 != null) goto L19;
    L26:
        List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r2 = this.w;
        ArrayList r3 = (ArrayList) r2;
        r3.add(new p0(this));
        return;
    L19:
        if (r1.intValue() != 30) goto L26;
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.F0;
        Long r5 = (Long) r4.getValue();
        if (r5 == null) goto L26;
        if (r5.longValue() != 0) goto L26;
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Long.valueOf(System.currentTimeMillis()));
    L9:
        if (((Boolean) com.bytedance.android.live.core.setting.u.a.getValue()).booleanValue() == false) goto L28;
        Integer r6 = je0.d.h();
        if (r6 != null) goto L14;
        return;
    L14:
        if (r6.intValue() == 30) goto L15;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void Z0() {
        f0 r0 = new f0(this.n, this.D);
        this.h = r0;
        ((q46.b) r0).a = this;
        if ((r0 instanceof f0) == true) goto L6;
        r0 = null;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final boolean a1() {
        if (this.n == false) goto L7;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 != null) goto L12;
    L10:
        return false;
    L12:
        return r0.userIsCPosition(je0.d.b0());
    L7:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L10;
        return r1.userIsCPosition(je0.d.b0());
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public void b1() {
        int r0 = y.a;
        y.d(this.u);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public void c1() {
        int r0 = y.a;
        y.e(this.D, getContext(), this.u);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void dismiss() {
        int r0 = cj0.l.f;
        cj0.l r1 = cj0.l.a.a();
        if (r1 == null) goto L7;
        b r2 = this.F;
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) r1.d).contains(r2) == false) goto L7;
        ((ArrayList) r1.d).remove(r2);
    L7:
        Handler r3 = DialogLancet.resolveDialogHandler(this);
        if (r3 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r4 == null) goto L21;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r3.getLooper()) goto L12;
        r3.post(DialogLancet.createDismissRunnable(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void T() {
        Context r0 = getContext();
        Property<String> r1 = qf0.b.a;
        com.bytedance.android.live.liveinteract.voicechat.util.k r3 = null;
        Uri r2 = new u6((String) vm2.h.x5.getValue(null, vm2.h.a[334(0x14e, float:4.68E-43)])).c();
        if (jc1.k.f(IBaseBrowserService.class) == null) goto L8;
        if (r0 == null) goto L8;
        IBaseBrowserService r4 = jc1.k.f(IBaseBrowserService.class);
        if (r4 == null) goto L8;
        IBaseBrowserService.b.a(r4, r0, r2);
    L8:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r5 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r5 == null) goto L14;
        com.bytedance.android.live.liveinteract.voicechat.util.k r6 = r5.getLogger();
        if (r6 == null) goto L14;
        r3 = r6;
    L17:
        if (r3 == null) goto L23;
        LinkedHashMap r7 = new LinkedHashMap();
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L21;
        String r8 = "anchor";
    L22:
        r7.put("user_type", r8);
        j0.l().sendLog("livesdk_anchor_ksong_singing_image_entrance_click", r7, new Object[]{IRoom.class, am2.x.class});
        goto L23
    L21:
        r8 = "guest";
    L23:
        j1(this);
        return;
    L14:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r9 = IVoiceChatGuestService.a.a();
        if (r9 == null) goto L17;
        r3 = r9.getLogger();
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public boolean T0() {
        if (jc0.a.a() == false) goto L8;
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.canSilenceSelf();
    L8:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r1 = IVoiceChatAdminService.a.a();
        if (r1 != null) goto L11;
        return false;
    L11:
        return r1.canSilenceSelf();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final void Y0() {
        findViewById(2131382836).setOnClickListener(new e0(this));
        if (this.G == false) goto L8;
        UtilityKotlinExtentionsKt.w(findViewById(2131382836));
        if (hd0.c.f().j() == false) goto L7;
        findViewById(2131382836).setSelected(true);
        findViewById(2131382836).setText(2131923210);
        return;
    L7:
        findViewById(2131382836).setSelected(false);
        findViewById(2131382836).setText(2131923209);
        return;
    L8:
        UtilityKotlinExtentionsKt.t(findViewById(2131382836));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j1(VoiceChatDynamicEmojiDialog r3) {
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

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog
    public final int V0(int r4) {
        boolean r0 = com.bytedance.android.livesdk.chatroom.interact.model.d0.h(this.v);
        if (r0 == true) goto L15;
        if (TeamFightContext.Companion.h() == false) goto L15;
        Integer r1 = je0.d.h();
        if (r1 == null) goto L15;
        if (r1.intValue() != 22) goto L15;
        if (li0.d.e() == false) goto L15;
        r0 = true;
    L15:
        if (je0.d.u() == false) goto L20;
        if (r0 == true) goto L21;
        if (r4 != 0) goto L22;
        return -1;
    L22:
        return r4;
    L21:
        return r4;
    L20:
        return r4;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void l(boolean r5) {
        if (hd0.c.f().h() == true) goto L5;
        return;
    L5:
        IRoom r0 = this.v;
        if (r0 == null) goto L12;
        long r1 = r0.getId();
        pj0.b r2 = ThemedCompetitionContext.Companion.c();
        if (r2 == null) goto L10;
        r2.Z6(r1, je0.d.b0(), r5);
    L10:
        j1(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void w0(boolean r8) {
        if (getContext() != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.liveinteract.videotalk.utils.e.b(getContext(), r8, this.v, je0.d.b0(), this.y, new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void z0(boolean r8, DataCenter r9) {
        if (hd0.c.f().h() == true) goto L5;
        return;
    L5:
        IRoom r0 = this.v;
        if (r0 == null) goto L9;
        long r3 = r0.getId();
        oe0.d.c(r8, je0.d.b0(), r3, getContext(), r9);
        j1(this);
        return;
    }

    public VoiceChatDynamicEmojiDialog(Context r2, DataCenter r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3, r4);
        this.G = r5;
        this.F = new b(this);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e5(int r7, int r8, long r9, String r11) {
        com.bytedance.android.live.liveinteract.revenue.fight.c r0 = TeamFightContext.Companion.c();
        if (r0 == null) goto L5;
        r0.e5(r7, r8, 0, r11);
    L5:
        j1(this);
    }
}
