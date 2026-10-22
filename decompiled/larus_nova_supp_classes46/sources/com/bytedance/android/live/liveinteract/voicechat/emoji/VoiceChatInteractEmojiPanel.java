package com.bytedance.android.live.liveinteract.voicechat.emoji;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Receiver;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Scene;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Sender;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.k0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.v0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.w0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.z0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/VoiceChatInteractEmojiPanel;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/InteractEmojiPanel;", "Lcom/bytedance/android/live/liveinteract/voicechat/VoiceChatMuteManager$a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceChatInteractEmojiPanel extends InteractEmojiPanel implements VoiceChatMuteManager.a {
    public static final /* synthetic */ int L = 0;
    public final com.bytedance.android.live.liveinteract.voicechat.b F;
    public final e G;
    public int H;
    public boolean I;
    public final CompositeDisposable J;
    public final f K;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ VoiceChatInteractEmojiPanel a;

        public b(VoiceChatInteractEmojiPanel r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.VoiceChatInteractEmojiPanel, java.lang.Object] */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            r3.dismiss();
            ?? r5 = this.a;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L18:
            if (this.a.j == false) goto L20;
        L23:
            IBaseUser r7 = this.a.l;
            if (r7 == null) goto L35;
            IVoiceChatAdminService.Companion.getClass();
            IVoiceChatAdminService r8 = IVoiceChatAdminService.a.a();
            if (r8 == null) goto L36;
            r8.kickOut(r7);
            return;
        L36:
            return;
        L35:
            return;
        L20:
            if (je0.d.Y() == true) goto L23;
            int r9 = InteractEmojiPanel.E;
            InteractEmojiPanel.a.a(TalkRoomOperate.DISCONNECT);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r10 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r10 == null) goto L16;
            com.bytedance.crash.d.d(r10, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r6.getLooper()) goto L7;
            r6.post(DialogLancet.createDismissRunnable(r5));
            goto L18
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class e implements com.bytedance.android.live.liveinteract.voicechat.util.b {
        public final /* synthetic */ VoiceChatInteractEmojiPanel a;

        public e(VoiceChatInteractEmojiPanel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.voicechat.util.b
        public final void c(int r3) {
            VoiceChatInteractEmojiPanel r4 = this.a;
            r4.H--;
            TextView r5 = (TextView) r4.findViewById(2131385960);
            int r0 = this.a.H;
            if (r0 <= 0) goto L5;
            String r1 = p6.a(r0);
        L6:
            r5.setText(r1);
            return;
        L5:
            r1 = "--:--";
            goto L6
        }
    }

    public static final class f implements bk0.d.a {
        public final /* synthetic */ VoiceChatInteractEmojiPanel a;

        @Override // bk0.d.a
        public final boolean a() {
            VoiceChatInteractEmojiPanel r0 = this.a;
            int r1 = VoiceChatInteractEmojiPanel.L;
            r0.getClass();
            return false;
        }

        @Override // bk0.d.a
        public final boolean b() {
            VoiceChatInteractEmojiPanel r0 = this.a;
            int r1 = VoiceChatInteractEmojiPanel.L;
            return r0.o1();
        }

        @Override // bk0.d.a
        public final boolean c() {
            VoiceChatInteractEmojiPanel r0 = this.a;
            int r1 = VoiceChatInteractEmojiPanel.L;
            r0.getClass();
            com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
            if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.A.getValue()).booleanValue() == false) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L11;
        L13:
            return false;
        L11:
            if (r0.C.getExpectLeaveTime() <= 0) goto L13;
            return true;
        L5:
            if (fj0.c.a() == true) goto L8;
            r2 = false;
            goto L9
        }

        @Override // bk0.d.a
        public final boolean isFollowed() {
            IBaseUser r0 = this.a.l;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isFollowing() != true) goto L7;
            return true;
        }

        @Override // bk0.d.a
        public final boolean isMute() {
            return this.a.X0();
        }

        public f(VoiceChatInteractEmojiPanel r1) {
            this.a = r1;
        }
    }

    public static final class g implements DialogInterface.OnShowListener {
        public final /* synthetic */ VoiceChatInteractEmojiPanel a;

        public g(VoiceChatInteractEmojiPanel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r5) {
            VoiceChatInteractEmojiPanel r6 = this.a;
            int r0 = VoiceChatInteractEmojiPanel.L;
            if (r6.n1() == false) goto L26;
            LinkedHashMap r7 = new LinkedHashMap();
            m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r1 == null) goto L7;
            IRoom r2 = (IRoom) r1.getValue();
        L8:
            r7.put("live_type", "voice_live");
            String r3 = "";
            if (r2 == null) goto L12;
            String r4 = r2.getOwnerUserIdString();
            if (r4 == null) goto L12;
        L13:
            r7.put("anchor_id", r4);
            if (r2 == null) goto L17;
            String r8 = String.valueOf(r2.getRoomId());
            if (r8 == null) goto L17;
        L18:
            r7.put("room_id", r8);
            r7.put("function_type", "ktv");
            IBaseUser r9 = this.a.l;
            if (r9 == null) goto L24;
            String r10 = r9.getIdString();
            if (r10 == null) goto L24;
            r3 = r10;
        L24:
            r7.put("to_user_id", r3);
            j0.l().sendLog("livesdk_ktv_friends_group_join_invite_icon_show", r7, new Object[]{x.class, IRoom.class});
            return;
        L17:
            r8 = "";
        L12:
            r4 = "";
            goto L13
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class h implements com.bytedance.android.live.liveinteract.videotalk.utils.g {
        public final /* synthetic */ VoiceChatInteractEmojiPanel a;

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.VoiceChatInteractEmojiPanel, java.lang.Object] */
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

        public h(VoiceChatInteractEmojiPanel r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final int Q0() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void C0() {
        IBaseUser r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (n.g(this.C) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        String r1 = r0.getIdString();
        LinkApi.UpdateMcAction r2 = LinkApi.UpdateMcAction.UNSET_KTV_HOST;
        this.m.d0(r1, r2, new VoiceChatInteractEmojiPanel$setMcStatus$1(this, r1, r2));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void M() {
        IBaseUser r0 = this.l;
        if (r0 == null) goto L20;
        k.n(IKtvService.class).inviteToKtvGroup(this.i.getRoomId(), r0.getIdString());
        LinkedHashMap r1 = new LinkedHashMap();
        m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L7;
        IRoom r3 = (IRoom) r2.getValue();
    L8:
        r1.put("live_type", "voice_live");
        String r4 = "";
        if (r3 == null) goto L12;
        String r5 = r3.getOwnerUserIdString();
        if (r5 == null) goto L12;
    L13:
        r1.put("anchor_id", r5);
        if (r3 == null) goto L19;
        String r6 = String.valueOf(r3.getRoomId());
        if (r6 == null) goto L19;
        r4 = r6;
    L19:
        r1.put("room_id", r4);
        r1.put("function_type", "ktv");
        r1.put("to_user_id", r0.getIdString());
        j0.l().sendLog("livesdk_ktv_friends_group_join_invite_icon_click", r1, new Object[]{x.class, IRoom.class});
    L12:
        r5 = "";
        goto L13
    L7:
        r3 = null;
    L20:
        g1(this);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void h0() {
        IBaseUser r0 = this.l;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!n.g(this.C)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        String r1 = r0.getIdString();
        LinkApi.UpdateMcAction r2 = LinkApi.UpdateMcAction.SET_KTV_HOST;
        this.m.d0(r1, r2, new VoiceChatInteractEmojiPanel$setMcStatus$1(this, r1, r2));
        return;
    }

    public final boolean n1() {
        Object r1 = null;
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.B, null, 2);
        if (r0 != null) goto L5;
        return false;
    L5:
        j r2 = r0.s();
        if (r2 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L35;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r3) != true) goto L35;
        if (this.j == false) goto L35;
        if (jc0.a.a() == true) goto L35;
        List r4 = (List) IInteractService.linkMicSettings.getValue();
        if (r4 == null) goto L33;
        Iterator r5 = r4.iterator();
    L20:
        if (r5.hasNext() == false) goto L27;
        Object r6 = r5.next();
        if (((y) r6).getKey() != 56) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == false) goto L20;
        r1 = r6;
        goto L27
    L24:
        r7 = false;
    L27:
        y r8 = (y) r1;
        if (r8 == null) goto L33;
        if (r8.getValue() != 1) goto L33;
        return true;
    L33:
        ALogger.i("VoiceChatInteractEmojiPanel", "not in group");
        return false;
    L35:
        ALogger.i("VoiceChatInteractEmojiPanel", "not in ktv room");
        return false;
    }

    public final boolean o1() {
        j r0 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.B, null, 2).s();
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r1 != null) goto L7;
        return true;
    L7:
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.c(r1) != true) goto L13;
        return false;
    L13:
        return true;
    L11:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void H() {
        if (Y0() == true) goto L6;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L6:
        String r0 = vm2.d.l().addTimeSchema;
        IBaseUser r2 = this.l;
        if (r2 == null) goto L21;
        String r3 = r2.getIdString();
        if (r3 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r0) == true) goto L14;
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("to_user_id", r3), TuplesKt.to("live_type", "voice_live")});
        TalkRoomLogUtils.B0(r1, null, null, 6);
        k.n(IBaseLiveActionHandler.class).handle(getContext(), y0.b(r0, r1));
    L14:
        fj0.a r4 = fj0.b.a;
        IBaseUser r5 = this.l;
        if (r5 == null) goto L18;
        String r6 = r5.getIdString();
        if (r6 == null) goto L18;
    L19:
        fj0.b.a(r6);
        g1(this);
        return;
    L18:
        r6 = "";
        goto L19
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> S0() {
        boolean r1 = false;
        String r2 = null;
        if (vm2.d.L() == true) goto L5;
        ArrayList r0 = new ArrayList();
        m1(r0);
        if (this.j == false) goto L58;
    L88:
        l1(r0);
        IBaseUser r3 = this.l;
        if (r3 == null) goto L97;
        if (r3.isMysteryMan() == true) goto L97;
        if (this.C.isAnonymous() == false) goto L95;
        ALogger.i("VoiceChatInteractEmojiPanel", "the anchor clicks the anonymous seat profile emoji panel item need to be hidden.");
        goto L97
    L95:
        r0.add(new r0(this));
    L97:
        if (X0() == false) goto L103;
        if (W0() == false) goto L101;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r4 = new b1(this);
    L106:
        r0.add(r4);
        W0();
        if (W0() == true) goto L124;
        if (this.j == false) goto L124;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.A.getValue()).booleanValue() == false) goto L113;
    L116:
        boolean r5 = true;
    L117:
        if (r5 == true) goto L119;
    L121:
        if (r1 == false) goto L124;
        r0.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a(this));
        goto L124
    L119:
        if (this.C.getExpectLeaveTime() <= 0) goto L121;
        r1 = true;
        goto L121
    L113:
        if (fj0.c.a() == true) goto L116;
        r5 = false;
    L124:
        if (aj0.a.d() == true) goto L126;
    L127:
        h1(r0);
    L129:
        if (W0() == true) goto L132;
        i1(r0);
        r0.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n(this));
    L132:
        if (this.C.isAnonymous() == false) goto L135;
        ALogger.i("VoiceChatInteractEmojiPanel", "the anchor clicks the anonymous seat KtvGroup and KtvHostOption panel item  need to be hidden.");
    L138:
        IBaseUser r6 = this.l;
        if (r6 == null) goto L153;
        if (r6.isMysteryMan() == true) goto L153;
        if (this.C.isAnonymous() == false) goto L145;
        ALogger.i("VoiceChatInteractEmojiPanel", "the anchor clicks the anonymous seat follow panel item need to be hidden.");
        goto L153
    L145:
        IBaseUser r7 = this.l;
        if (r7 != null) goto L148;
    L150:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r8 = new q(this);
    L151:
        r0.add(r8);
        goto L153
    L148:
        if (r7.isFollowing() != true) goto L150;
        r8 = new a1(this);
    L153:
        if (W0() == true) goto L158;
        if (o1() == false) goto L158;
        r0.add(new r(this));
    L158:
        if (this.C.isAnonymous() == false) goto L161;
        r0.add(new v0(this));
    L161:
        if (W0() == true) goto L163;
        k1(r0);
        P0(r0);
    L163:
        return r0;
    L135:
        if (n1() == false) goto L137;
        r0.add(new i0(this));
    L137:
        j1(r0);
        goto L138
    L126:
        if (aj0.a.b(this.i) == false) goto L129;
    L101:
        r4 = new c1(this);
        goto L106
    L103:
        if (W0() == false) goto L105;
        r4 = new n0(this);
        goto L106
    L105:
        r4 = new x0(this);
        goto L106
    L58:
        if (je0.d.Y() == false) goto L66;
        IBaseUser r9 = this.l;
        if (r9 == null) goto L63;
        r2 = r9.getIdString();
    L63:
        if ((!Intrinsics.areEqual(r2, this.i.getOwnerUserIdString())) == true) goto L88;
    L66:
        if (this.C.isAnonymous() == false) goto L70;
        ALogger.i("VoiceChatInteractEmojiPanel", "other guest clicks the anonymous seat profile emoji and follow panel item need to be hidden.");
        if (W0() == true) goto L81;
        i1(r0);
    L81:
        if (W0() == true) goto L86;
        if (o1() == false) goto L86;
        r0.add(new r(this));
    L86:
        if (this.C.isAnonymous() == false) goto L161;
        r0.add(new v0(this));
        goto L161
    L70:
        r0.add(new r0(this));
        if (W0() == true) goto L73;
        i1(r0);
    L73:
        IBaseUser r10 = this.l;
        if (r10 != null) goto L76;
    L78:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r11 = new q(this);
    L79:
        r0.add(r11);
        goto L81
    L76:
        if (r10.isFollowing() != true) goto L78;
        r11 = new a1(this);
        goto L79
    L5:
        if (this.j == false) goto L8;
        IconFilterFactory$Sender r12 = IconFilterFactory$Sender.ANCHOR;
    L11:
        IBaseUser r13 = this.l;
        if (r13 == null) goto L17;
        if (r13.isMysteryMan() != true) goto L17;
        IconFilterFactory$Receiver r14 = IconFilterFactory$Receiver.MYSTERY;
    L27:
        j r15 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.B, null, 2).s();
        if (r15 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r16 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r15.getValue();
        if (r16 == null) goto L35;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r16) != true) goto L35;
        r1 = true;
    L35:
        if (W0() == false) goto L37;
        IconFilterFactory$Scene r17 = IconFilterFactory$Scene.CROSS_ROOM;
    L40:
        bk0.f r18 = bk0.u.a(r12, r14, r17, new bk0.d(this.K));
        ArrayList r19 = new ArrayList();
        m1(r19);
        l1(r19);
        r19.add(new r0(this));
        r19.add(new x0(this));
        r19.add(new c1(this));
        r19.add(new n0(this));
        r19.add(new b1(this));
        r19.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a(this));
        i1(r19);
        if (this.j == false) goto L43;
    L49:
        h1(r19);
    L50:
        r19.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n(this));
        if (n1() == false) goto L53;
        r19.add(new i0(this));
    L53:
        j1(r19);
        r19.add(new q(this));
        r19.add(new a1(this));
        r19.add(new r(this));
        r19.add(new v0(this));
        k1(r19);
        P0(r19);
        return r18.a(r19);
    L43:
        if (je0.d.Y() == false) goto L50;
        IBaseUser r20 = this.l;
        if (r20 == null) goto L48;
        r2 = r20.getIdString();
    L48:
        if ((!Intrinsics.areEqual(r2, this.i.getOwnerUserIdString())) == false) goto L50;
    L37:
        if (r1 == false) goto L39;
        r17 = IconFilterFactory$Scene.KTV;
        goto L40
    L39:
        r17 = IconFilterFactory$Scene.ROOM;
    L17:
        if (this.C.isAnonymous() == false) goto L19;
        r14 = IconFilterFactory$Receiver.ANONYMOUS;
        goto L27
    L19:
        IBaseUser r21 = this.l;
        if (r21 == null) goto L22;
        String r22 = r21.getIdString();
    L24:
        if (Intrinsics.areEqual(r22, this.i.getOwnerUserIdString()) == false) goto L26;
        r14 = IconFilterFactory$Receiver.ANCHOR;
        goto L27
    L26:
        r14 = IconFilterFactory$Receiver.NORMAL;
        goto L27
    L22:
        r22 = null;
        goto L24
    L8:
        if (je0.d.Y() == false) goto L10;
        r12 = IconFilterFactory$Sender.ADMIN;
        goto L11
    L10:
        r12 = IconFilterFactory$Sender.GUEST;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final boolean Y0() {
        if (W0() == false) goto L35;
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(this.C) == true) goto L35;
        if (this.j == false) goto L13;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r1 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r1 == null) goto L18;
        i<ILinkPlayerInfoBridge> r2 = r1.getLinkUserInfoCenter();
        if (r2 == null) goto L18;
        Iterable r3 = r2.c();
    L19:
        if (r3 == null) goto L34;
        Iterator r4 = r3.iterator();
    L22:
        if (r4.hasNext() == false) goto L34;
        IBaseUser r5 = ((ILinkPlayerInfoBridge) r4.next()).getUser();
        if (r5 == null) goto L26;
        String r6 = r5.getIdString();
    L27:
        IBaseUser r7 = this.l;
        if (r7 == null) goto L30;
        String r8 = r7.getIdString();
    L32:
        if (Intrinsics.areEqual(r6, r8) == false) goto L22;
        return true;
    L30:
        r8 = null;
        goto L32
    L26:
        r6 = null;
    L34:
        return false;
    L18:
        r3 = null;
        goto L19
    L13:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r9 = IVoiceChatAdminService.a.a();
        if (r9 == null) goto L18;
        i<ILinkPlayerInfoBridge> r10 = r9.getLinkUserInfoCenter();
        if (r10 == null) goto L18;
        r3 = r10.c();
    L35:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r11 = IVoiceChatAdminService.a.a();
        if (r11 == null) goto L38;
        List<ILinkPlayerInfoBridge> r12 = r11.getOnlineUserList();
    L39:
        List<ILinkPlayerInfoBridge> r13 = r12;
        if (r13 != null) goto L42;
    L45:
        boolean r14 = true;
    L46:
        if (r14 == false) goto L48;
        return false;
    L48:
        Iterator<T> r15 = r12.iterator();
    L50:
        if (r15.hasNext() == false) goto L62;
        IBaseUser r16 = ((ILinkPlayerInfoBridge) r15.next()).getUser();
        if (r16 == null) goto L54;
        String r17 = r16.getIdString();
    L55:
        IBaseUser r18 = this.l;
        if (r18 == null) goto L58;
        String r19 = r18.getIdString();
    L60:
        if (Intrinsics.areEqual(r17, r19) == false) goto L50;
        return true;
    L58:
        r19 = null;
        goto L60
    L54:
        r17 = null;
        goto L55
    L62:
        return false;
    L42:
        if (r13.isEmpty() == true) goto L45;
        r14 = false;
        goto L46
    L38:
        r12 = null;
        goto L39
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void disconnect() {
        if (Y0() == true) goto L6;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L6:
        String r0 = s1.B(2131919267);
        String r2 = s1.B(2131915442);
        if (this.j == false) goto L9;
    L13:
        Object[] r4 = new Object[1];
        com.bytedance.android.live.liveinteract.plantform.model.m.a r5 = com.bytedance.android.live.liveinteract.plantform.model.m.q0;
        IBaseUser r6 = this.l;
        if (r6 == null) goto L16;
        String r7 = r6.getNickName();
    L17:
        r5.getClass();
        r4[0] = com.bytedance.android.live.liveinteract.plantform.model.m.a.a(r7);
        String r8 = s1.C(2131919814, r4);
        b r9 = new b(this);
        if (je0.d.y() == false) goto L26;
        Context r10 = getContext();
        com.bytedance.android.livesdk.widget.x0.d r11 = new com.bytedance.android.livesdk.widget.x0.d();
        r11.b = r10;
        r11.a = 0;
        r11.a = 5;
        r11.k = false;
        r11.c = r8;
        r11.d = s1.B(2131919479);
        com.bytedance.android.livesdk.widget.x0.c[] r12 = r11.g;
        com.bytedance.android.livesdk.widget.x0.c r13 = r12[0];
        if (r13 != null) goto L22;
        r13 = new com.bytedance.android.livesdk.widget.x0.c();
        r12[0] = r13;
    L22:
        r13.a = r0;
        r13.b = r9;
        c r1 = c.a;
        com.bytedance.android.livesdk.widget.x0.c[] r3 = r11.g;
        com.bytedance.android.livesdk.widget.x0.c r14 = r3[1];
        if (r14 != null) goto L25;
        r14 = new com.bytedance.android.livesdk.widget.x0.c();
        r3[1] = r14;
    L25:
        r14.a = r2;
        r14.b = r1;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r11.b, r11));
        return;
    L26:
        com.bytedance.android.livesdk.widget.j0.a r15 = new com.bytedance.android.livesdk.widget.j0.a(getContext());
        r15.a = r8;
        r15.a(r0, r9);
        r15.b(r2, d.a);
        r15.c();
        return;
    L16:
        r7 = null;
        goto L17
    L9:
        if (je0.d.Y() == true) goto L13;
        InteractEmojiPanel.a.a(TalkRoomOperate.DISCONNECT);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e() {
        if (Y0() == true) goto L7;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L7:
        if (this.j == false) goto L9;
    L12:
        e1(2131919826);
        if (W0() == false) goto L26;
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r1 = null;
        if (r0 == null) goto L19;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L19;
        Long r3 = Long.valueOf(r2.getRoomId());
    L20:
        LinkRoomFightContext r4 = LinkRoomFightContext.Companion.getContext();
        if (r4 == null) goto L23;
        r1 = r4.getLinkRoomId();
    L23:
        if (r3 == null) goto L32;
        if (r1 == null) goto L33;
        InteractEmojiPanel.Z0(r3.longValue(), r1.longValue(), true, this.s, new VoiceChatInteractEmojiPanel$silence$$inlined$lets$lambda$1(this));
        return;
    L33:
        return;
    L32:
        return;
    L19:
        r3 = null;
        goto L20
    L26:
        IBaseUser r5 = this.l;
        if (r5 == null) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.b r6 = this.F;
        if (r6 == null) goto L36;
        r6.h(r5.getIdString());
        return;
    L36:
        return;
    L35:
        return;
    L9:
        if (je0.d.Y() == true) goto L12;
        InteractEmojiPanel.a.a(TalkRoomOperate.SILENCE);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void k() {
        if (Y0() == true) goto L7;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L7:
        if (this.j == false) goto L9;
    L12:
        e1(2131919829);
        Long r1 = null;
        if (W0() == false) goto L26;
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L19;
        IRoom r2 = (IRoom) r0.getValue();
        if (r2 == null) goto L19;
        Long r3 = Long.valueOf(r2.getRoomId());
    L20:
        LinkRoomFightContext r4 = LinkRoomFightContext.Companion.getContext();
        if (r4 == null) goto L23;
        r1 = r4.getLinkRoomId();
    L23:
        if (r3 == null) goto L32;
        if (r1 == null) goto L33;
        InteractEmojiPanel.Z0(r3.longValue(), r1.longValue(), false, this.s, new VoiceChatInteractEmojiPanel$unSilence$$inlined$lets$lambda$1(this));
        return;
    L33:
        return;
    L32:
        return;
    L19:
        r3 = null;
        goto L20
    L26:
        IBaseUser r5 = this.l;
        if (r5 == null) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.b r6 = this.F;
        if (r6 == null) goto L36;
        r6.f(r5.getIdString(), null);
        return;
    L36:
        return;
    L35:
        return;
    L9:
        if (je0.d.Y() == true) goto L12;
        InteractEmojiPanel.a.a(TalkRoomOperate.UNSILENCE);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.android.live.liveinteract.voicechat.b r0 = this.F;
        if (r0 == null) goto L6;
        r0.a(this);
    L6:
        if (jc0.a.a() == false) goto L8;
        U0();
    L9:
        DataCenter r1 = this.B;
        if (r1 == null) goto L13;
        r1.put("data_multi_link_interaction_dialog_show", Boolean.TRUE);
        return;
    L13:
        return;
    L8:
        b1();
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.I == false) goto L5;
        List<com.bytedance.android.live.liveinteract.voicechat.util.b> r0 = com.bytedance.android.live.liveinteract.voicechat.util.c.a;
        com.bytedance.android.live.liveinteract.voicechat.util.c.c(this.G);
        this.I = false;
    L5:
        com.bytedance.android.live.liveinteract.voicechat.b r1 = this.F;
        if (r1 == null) goto L8;
        r1.g(this);
    L8:
        DataCenter r2 = this.B;
        if (r2 == null) goto L11;
        r2.put("data_multi_link_interaction_dialog_show", Boolean.FALSE);
    L11:
        this.J.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g1(VoiceChatInteractEmojiPanel r3) {
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void C(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUserId");
        f2.c(s1.C(2131923172, new Object[]{T0(r3)}), 0);
        V0();
        g1(this);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void V(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUserId");
        f2.c(s1.C(2131923165, new Object[]{T0(r3)}), 0);
        V0();
        g1(this);
    }

    public final void h1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r8) {
        ILinkPlayerInfoBridge r0 = this.C;
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.getOwnerUserIdString();
    L9:
        if (je0.d.f() == 5) goto L11;
        return;
    L11:
        if (je0.d.K(this.j, k.n(IMiddlewareUserService.class).user().E(Long.valueOf(this.i.getRoomId()))) == false) goto L66;
        IBaseUser r4 = r0.getUser();
        if (r4 == null) goto L15;
        String r5 = r4.getIdString();
    L17:
        if (Intrinsics.areEqual(r5, r3) == true) goto L19;
    L31:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L35;
        return;
    L35:
        if (TeamFightContext.Companion.h() == false) goto L45;
        if (li0.d.g(null) == false) goto L43;
        Integer r6 = je0.d.h();
        if (r6 == null) goto L45;
        if (r6.intValue() != 22) goto L45;
        return;
    L43:
        return;
    L45:
        if (je0.d.s() == true) goto L47;
    L49:
        Integer r7 = je0.d.h();
        if (r7 != null) goto L53;
    L55:
        Integer r9 = je0.d.h();
        if (r9 != null) goto L59;
    L61:
        ((ArrayList) r8).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d(this, !r0.isEnlarged(), this.B));
        return;
    L59:
        if (r9.intValue() != 29) goto L61;
        return;
    L53:
        if (r7.intValue() != 24) goto L55;
        return;
    L47:
        if (aj0.a.b(this.i) == true) goto L49;
        return;
    L19:
        if (d0.h(this.i) == true) goto L31;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r10 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r10 == null) goto L23;
        ILinkPlayerInfoBridge r11 = r10.currentCPositionUser();
    L24:
        if (r11 != null) goto L31;
        Integer r12 = je0.d.h();
        if (r12 != null) goto L29;
        return;
    L29:
        if (r12.intValue() == 21) goto L31;
        return;
    L23:
        r11 = null;
        goto L24
    L15:
        r5 = null;
        goto L17
    L66:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void i1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r4) {
        IRoom r0 = this.i;
        boolean r1 = this.j;
        ILinkPlayerInfoBridge r2 = this.C;
        if (r2 == null) goto L8;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L8;
        String r5 = r3.getIdString();
        if (r5 == null) goto L8;
    L10:
        if (com.bytedance.android.live.liveinteract.videotalk.utils.e.a(r0, r1, r5) == true) goto L12;
        return;
    L12:
        Integer r6 = je0.d.h();
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        ArrayList r8 = (ArrayList) r4;
        r8.add(new o(this, r7));
        return;
    L16:
        if (r6.intValue() != 27) goto L18;
        r7 = true;
    L8:
        r5 = "";
        goto L10
    }

    public final void j1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r5) {
        nd r1 = null;
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.B, null, 2);
        if (r0 != null) goto L5;
        return;
    L5:
        j r2 = r0.s();
        if (r2 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L40;
        boolean r4 = true;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r3) == true) goto L12;
        return;
    L12:
        if (this.j == true) goto L14;
        return;
    L14:
        if (jc0.a.a() == true) goto L46;
        m r6 = r0.q();
        if (r6 == null) goto L19;
        r1 = (nd) r6.getValue();
    L19:
        IBaseUser r7 = this.l;
        int r8 = 0;
        if (r7 == null) goto L26;
        t r9 = r7.getUserAttr();
        if (r9 == null) goto L26;
        if (r9.isAdmin() != true) goto L26;
    L28:
        if (n.g(this.C) == false) goto L30;
        ArrayList r10 = (ArrayList) r5;
        r10.add(new k0(this));
        return;
    L30:
        if (r4 == false) goto L44;
        if (r1 == null) goto L33;
        int r11 = r1.a;
    L34:
        if (r1 == null) goto L36;
        r8 = r1.b;
    L36:
        if (r11 >= r8) goto L45;
        ArrayList r12 = (ArrayList) r5;
        r12.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j0(this));
        return;
    L45:
        return;
    L33:
        r11 = 0;
        goto L34
    L44:
        return;
    L26:
        r4 = false;
        goto L28
    L46:
        return;
    L40:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r13) {
        if (vm2.c.c() == false) goto L6;
        return;
    L6:
        if (vm2.d.E() == false) goto L120;
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        List<ILinkmicInteractEntrance> r1 = null;
        if (r0 == null) goto L10;
        i<ILinkPlayerInfoBridge> r2 = r0.getLinkUserInfoCenter();
    L12:
        if ((r2 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L14;
        r2 = null;
    L14:
        com.bytedance.android.live.liveinteract.plantform.core.y r3 = (com.bytedance.android.live.liveinteract.plantform.core.y) r2;
        if (r3 == null) goto L24;
        Map<String, List<ILinkmicInteractEntrance>> r4 = r3.E;
        if (r4 == null) goto L24;
        IBaseUser r5 = this.l;
        if (r5 == null) goto L22;
        Object r6 = r5.getIdString();
        if (r6 == null) goto L22;
    L23:
        List r7 = (List) ((LinkedHashMap) r4).get(r6);
    L25:
        List<ILinkmicInteractEntrance> r8 = com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.a(r7);
        Context r9 = getContext();
        IBaseUser r10 = this.l;
        if (r10 == null) goto L29;
        String r11 = r10.getIdString();
        if (r11 == null) goto L29;
    L30:
        List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b> r12 = com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.b(r9, this, r8, r11);
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.d(r12);
        if (r7 == null) goto L68;
        Iterator r14 = r7.iterator();
    L34:
        if (r14.hasNext() == false) goto L68;
        ILinkmicInteractEntrance r15 = (ILinkmicInteractEntrance) r14.next();
        if ((r15 instanceof ILinkmicInteractEntrance) == false) goto L34;
        List r16 = r15.getButtons();
        if (r16 == null) goto L34;
        if ((!r16.isEmpty()) != true) goto L34;
        if (r15.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L34;
        if (r15.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L34;
        if (this.o.contains(Long.valueOf(r15.getEntranceId())) == true) goto L61;
        this.o.add(Long.valueOf(r15.getEntranceId()));
        int r17 = dk0.a.a;
        String r18 = r15.getSource();
        if (r18 != null) goto L50;
        r18 = "";
    L50:
        List r19 = r15.getButtons();
        Intrinsics.checkNotNull(r19);
        com.bytedance.android.livesdk.chatroom.model.interact.r r110 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r19, 0);
        if (r110 == null) goto L54;
        String r111 = r110.getToast();
        if (r111 == null) goto L54;
    L55:
        IBaseUser r112 = this.l;
        if (r112 == null) goto L59;
        String r113 = r112.getIdString();
        if (r113 == null) goto L59;
    L60:
        dk0.a.a("others", r18, r111, r113);
    L59:
        r113 = "";
    L54:
        r111 = "";
    L61:
        Context r114 = getContext();
        this.i.getRoomId();
        IBaseUser r115 = this.l;
        if (r115 == null) goto L65;
        String r116 = r115.getIdString();
        if (r116 == null) goto L65;
    L66:
        ((ArrayList) r13).add(new l0(this, r114, r116, r15));
    L65:
        r116 = "";
    L68:
        if ((!((ArrayList) r12).isEmpty()) == false) goto L70;
        ((ArrayList) r13).addAll(0, r12);
    L70:
        if (r7 != null) goto L72;
    L73:
        IInteractService r20 = (IInteractService) k.f(IInteractService.class);
        if (r20 == null) goto L76;
        i<ILinkPlayerInfoBridge> r21 = r20.getLinkUserInfoCenter();
    L78:
        if ((r21 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L80;
        r21 = null;
    L80:
        com.bytedance.android.live.liveinteract.plantform.core.y r22 = (com.bytedance.android.live.liveinteract.plantform.core.y) r21;
        if (r22 == null) goto L83;
        r1 = r22.D;
    L83:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.a(r1);
        if (r1 == null) goto L148;
        Iterator<T> r23 = r1.iterator();
    L87:
        if (r23.hasNext() == false) goto L149;
        ILinkmicInteractEntrance r24 = (ILinkmicInteractEntrance) r23.next();
        if ((r24 instanceof ILinkmicInteractEntrance) == false) goto L87;
        List r25 = r24.getButtons();
        if (r25 == null) goto L87;
        if ((!r25.isEmpty()) != true) goto L87;
        if (r24.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L87;
        if (r24.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L87;
        if (this.o.contains(Long.valueOf(r24.getEntranceId())) == true) goto L114;
        this.o.add(Long.valueOf(r24.getEntranceId()));
        int r26 = dk0.a.a;
        String r27 = r24.getSource();
        if (r27 != null) goto L103;
        r27 = "";
    L103:
        List r28 = r24.getButtons();
        Intrinsics.checkNotNull(r28);
        com.bytedance.android.livesdk.chatroom.model.interact.r r29 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r28, 0);
        if (r29 == null) goto L107;
        String r30 = r29.getToast();
        if (r30 == null) goto L107;
    L108:
        IBaseUser r31 = this.l;
        if (r31 == null) goto L112;
        String r32 = r31.getIdString();
        if (r32 == null) goto L112;
    L113:
        dk0.a.a("others", r27, r30, r32);
    L112:
        r32 = "";
    L107:
        r30 = "";
    L114:
        Context r33 = getContext();
        this.i.getRoomId();
        IBaseUser r34 = this.l;
        if (r34 == null) goto L118;
        String r35 = r34.getIdString();
        if (r35 == null) goto L118;
    L119:
        ((ArrayList) r13).add(new l0(this, r33, r35, r24));
    L118:
        r35 = "";
        goto L119
    L149:
        return;
    L148:
        return;
    L76:
        r21 = null;
        goto L78
    L72:
        if (r7.isEmpty() == true) goto L73;
        return;
    L29:
        r11 = "";
    L22:
        r6 = 0;
    L24:
        r7 = null;
        goto L25
    L10:
        r2 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void l(boolean r5) {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L16;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L17;
        long r2 = r1.getRoomId();
        IBaseUser r3 = this.C.getUser();
        if (r3 == null) goto L18;
        String r4 = r3.getIdString();
        if (r4 == null) goto L19;
        pj0.b r6 = ThemedCompetitionContext.Companion.c();
        if (r6 == null) goto L14;
        r6.Z6(r2, r4, r5);
    L14:
        g1(this);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void l1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r3) {
        if (ThemedCompetitionContext.Companion.g() == true) goto L6;
        return;
    L6:
        if (je0.d.f() != 9) goto L9;
        return;
    L9:
        if (this.C.getThemedCompetitionRole() == ThemedCompetitionRole.PERFORMER.getValue()) goto L14;
        if (this.C.getThemedCompetitionRole() == ThemedCompetitionRole.CONTESTANT.getValue()) goto L14;
        return;
    L14:
        if (this.j == false) goto L16;
    L17:
        ListProtector.add(r3, 0, new w0(this, this.C.getThemedCompetitionRole()));
        if (this.u == true) goto L22;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r4 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.b(this.j, this.C.getThemedCompetitionRole());
        this.u = true;
        return;
    L22:
        return;
    L16:
        if (ThemedCompetitionContext.a.e() == true) goto L17;
    }

    public final void m1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r4) {
        if (li0.d.g(null) == true) goto L5;
        return;
    L5:
        IBaseUser r0 = this.C.getUser();
        String r1 = "";
        if (r0 == null) goto L9;
        String r2 = r0.getIdString();
        if (r2 == null) goto L9;
    L10:
        int r3 = li0.d.c(r2);
        if (this.j == true) goto L15;
        if (com.bytedance.android.live.ktv.common.util.a.g() == true) goto L15;
        return;
    L15:
        if (TeamFightContext.Companion.h() == true) goto L17;
        return;
    L17:
        if (r3 == (-1)) goto L28;
        IBaseUser r5 = this.C.getUser();
        if (r5 == null) goto L24;
        String r6 = r5.getIdString();
        if (r6 == null) goto L24;
        r1 = r6;
    L24:
        ArrayList r7 = (ArrayList) r4;
        r7.add(new z0(this, r1));
        return;
    L28:
        return;
    L9:
        r2 = "";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        setOnShowListener(new g(this));
        if (this.j == false) goto L24;
        long r2 = 0;
        if (this.C.getExpectLeaveTime() == 0) goto L25;
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.A.getValue()).booleanValue() == false) goto L9;
    L12:
        boolean r12 = true;
    L13:
        if (r12 == false) goto L26;
        ILinkPlayerInfoBridge r13 = this.C;
        Intrinsics.checkNotNullParameter(r13, "userInfo");
        long r4 = r13.getExpectLeaveTime() - (System.currentTimeMillis() / 1000);
        if (r4 <= 0) goto L18;
        r2 = r4;
    L18:
        this.H = (int) r2;
        TextView r3 = (TextView) findViewById(2131385960);
        int r5 = this.H;
        if (r5 <= 0) goto L21;
        String r6 = p6.a(r5);
    L22:
        r3.setText(r6);
        ((TextView) findViewById(2131385960)).setClickable(false);
        com.bytedance.android.live.liveinteract.voicechat.util.c.d.b(this.G);
        this.I = true;
        return;
    L21:
        r6 = "--:--";
        goto L22
    L26:
        return;
    L9:
        if (fj0.c.a() == true) goto L12;
        r12 = false;
        goto L13
    L25:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void w0(boolean r8) {
        if (getContext() != null) goto L5;
        return;
    L5:
        Context r1 = getContext();
        IRoom r3 = this.i;
        ILinkPlayerInfoBridge r0 = this.C;
        if (r0 == null) goto L11;
        IBaseUser r2 = r0.getUser();
        if (r2 == null) goto L11;
        String r4 = r2.getIdString();
        if (r4 == null) goto L11;
    L12:
        com.bytedance.android.live.liveinteract.videotalk.utils.e.b(r1, r8, r3, r4, this.J, new h(this));
        return;
    L11:
        r4 = "";
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void Q(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "targetUserId");
        V0();
        if ((r3 instanceof ApiServerException) == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L11;
        ExceptionUtils.handleException(getContext(), r3, 2131919337);
        return;
    L11:
        return;
    L5:
        if (((ApiServerException) r3).getErrorCode() != 4004468) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void i0(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "targetUserId");
        V0();
        ExceptionUtils.handleException(getContext(), r3, 2131919335);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void z0(boolean r9, DataCenter r10) {
        IBaseUser r0 = this.C.getUser();
        if (r0 != null) goto L5;
        return;
    L5:
        long r4 = this.i.getRoomId();
        oe0.d.c(r9, r0.getIdString(), r4, getContext(), r10);
        g1(this);
    }

    public VoiceChatInteractEmojiPanel(Context r1, DataCenter r2, ILinkPlayerInfoBridge r3) {
        super(r1, r2, r3);
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r4 = IVoiceChatAdminService.a.a();
        if (r4 == null) goto L5;
        com.bytedance.android.live.liveinteract.voicechat.b r5 = r4.muteManager();
    L6:
        this.F = r5;
        this.G = new e(this);
        this.J = new CompositeDisposable();
        this.K = new f(this);
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e5(int r7, int r8, long r9, String r11) {
        com.bytedance.android.live.liveinteract.revenue.fight.c r0 = TeamFightContext.Companion.c();
        if (r0 == null) goto L5;
        r0.e5(r7, r8, 0, r11);
    L5:
        g1(this);
    }
}
