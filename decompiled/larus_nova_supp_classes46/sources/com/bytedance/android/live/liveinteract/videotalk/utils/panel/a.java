package com.bytedance.android.live.liveinteract.videotalk.utils.panel;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.effect.base.sharedpref.IEffectPluginPropertyService;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.linkcast.LinkCastAnchorDataContext;
import com.bytedance.android.live.liveinteract.linkcast.LinkCastGuestDataContext;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.r;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.liveinteract.widget.widget.ChatRoomGuestSettingDialog;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.livesdk.config.ab0;
import com.bytedance.android.livesdk.config.sj1;
import com.bytedance.android.livesdk.config.w60;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gd0.v;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements q0, VoiceChatMuteManager.a {
    public static ILinkPlayerInfoBridge a;
    public static String b;
    public static boolean c;
    public static int d;
    public static long e;
    public static long f;
    public static boolean g;
    public static boolean h;
    public static boolean i;
    public static final a j = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.utils.panel.a$a, reason: collision with other inner class name */
    public static final class DialogInterfaceOnClickListenerC0106a implements DialogInterface.OnClickListener {
        public final /* synthetic */ ChatMatchViewModel a;

        public DialogInterfaceOnClickListenerC0106a(ChatMatchViewModel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            Room r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
            if (r1 == null) goto L5;
            ChatMatchViewModel.startMatch$default(this.a, r1, false, 0, 6, null);
        L5:
            ChatMatchViewModel.showMatchDialog$default(this.a, false, 1, null);
            if (r7 == null) goto L8;
            r7.dismiss();
        L8:
            a.j.dismissDialog();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            if (r1 == null) goto L5;
            r1.dismiss();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TalkRoomBaseDynamicEmoji a;
        public final /* synthetic */ long b;
        public final /* synthetic */ DataCenter c;
        public final /* synthetic */ Ref.LongRef d;

        public c(TalkRoomBaseDynamicEmoji r1, long r2, DataCenter r4, String r5, Ref.LongRef r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r10) {
            com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
            a.g = false;
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            TalkRoomBaseDynamicEmoji r2 = this.a;
            long r3 = r2.emojiId;
            int r5 = r2.emojiType;
            long r6 = this.b;
            String r8 = r11.logId;
            r1.getClass();
            TalkRoomBusinessFullLinkMonitor.u0(r3, r5, r6, r8);
            a.d(this.c, (com.bytedance.android.live.liveinteract.voicechat.model.a) r11.data);
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.a r12 = this.a.getCustomizedRandomResource();
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.isRandomEmoji() == true) goto L7;
            return;
        L7:
            if (r12.getStatus() == 1) goto L29;
            int r13 = r12.getType();
            if (r13 != 1) goto L11;
            String r14 = s1.B(2131915065);
        L15:
            if (r14 != null) goto L17;
            return;
        L17:
            if ((!TextUtils.isEmpty(r14)) == true) goto L20;
            r14 = null;
        L20:
            if (r14 == null) goto L35;
            com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.y1;
            Map r7 = (Map) r4.getValue();
            Integer r9 = (Integer) r7.get(Long.valueOf(this.a.emojiId));
            if (r9 == null) goto L24;
            int r15 = r9.intValue();
        L26:
            if (r15 >= 3) goto L36;
            f2.c(r14, 0);
            r7.put(Long.valueOf(this.a.emojiId), Integer.valueOf(r15 + 1));
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r7);
            return;
        L36:
            return;
        L24:
            r15 = 0;
            goto L26
        L35:
            return;
        L11:
            if (r13 == 2) goto L13;
            r14 = "";
            goto L15
        L13:
            r14 = s1.B(2131915064);
            goto L15
        L29:
            if (this.d.element != 1) goto L38;
            f2.c("已公开，所有人可见", 0);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ TalkRoomBaseDynamicEmoji a;
        public final /* synthetic */ long b;

        public d(TalkRoomBaseDynamicEmoji r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            a.g = false;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            TalkRoomBaseDynamicEmoji r1 = this.a;
            long r2 = r1.emojiId;
            int r4 = r1.emojiType;
            long r5 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.t0(r2, r4, r5, r9);
            a.c(r9);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ TalkRoomBaseDynamicEmoji a;
        public final /* synthetic */ long b;
        public final /* synthetic */ DataCenter c;

        public e(TalkRoomBaseDynamicEmoji r1, long r2, DataCenter r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r10 = (com.bytedance.android.live.network.response.e) r9;
            a.g = false;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            TalkRoomBaseDynamicEmoji r1 = this.a;
            long r2 = r1.emojiId;
            int r4 = r1.emojiType;
            long r5 = this.b;
            String r7 = r10.logId;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.u0(r2, r4, r5, r7);
            TalkRoomBaseDynamicEmoji r3 = this.a;
            if (r3 == null) goto L13;
            com.bytedance.android.live.liveinteract.videotalk.emoji.model.h r6 = r3.getDigitAvatarEmojiData();
            if (r6 == null) goto L13;
            if (r6.actionID <= 0) goto L13;
            DigitAvatarContext r8 = DigitAvatarContext.Companion.getContext();
            if (r8 == null) goto L13;
            com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r11 = r8.getSendAvatarEmoji();
            if (r11 == null) goto L13;
            r11.post(this.a);
        L13:
            w8 r12 = ((com.bytedance.android.live.liveinteract.voicechat.model.a) r10.data).a();
            if (r12 == null) goto L16;
            Long r13 = Long.valueOf(r12.getMessageId());
        L17:
            x.s0(r13.longValue(), this.a);
            a.d(this.c, (com.bytedance.android.live.liveinteract.voicechat.model.a) r10.data);
            return;
        L16:
            r13 = null;
            goto L17
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ TalkRoomBaseDynamicEmoji a;
        public final /* synthetic */ long b;

        public f(TalkRoomBaseDynamicEmoji r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            a.g = false;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            TalkRoomBaseDynamicEmoji r1 = this.a;
            long r2 = r1.emojiId;
            int r4 = r1.emojiType;
            long r5 = this.b;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.t0(r2, r4, r5, r9);
            x.r0(r9, true);
            a.c(r9);
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void C0() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void E() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void H() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void M() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void P() {
        n(null);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void T() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void b(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void b0() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void disconnect() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e5(int r1, int r2, long r3, String r5) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void f() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void g() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void h() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void h0() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void k() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void l(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void m() {
    }

    @Override // ih0.d
    public final boolean p() {
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void w0(boolean r1) {
    }

    static {
        j = new a();
        b = "seat";
        c = true;
        d = -1;
    }

    public static Pair q() {
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32) == true) goto L5;
        return null;
    L5:
        if (je0.d.r() == false) goto L11;
        LinkCastAnchorDataContext r0 = LinkCastAnchorDataContext.Companion.getContext();
        if (r0 == null) goto L30;
        com.bytedance.live.datacontext.n<s0> r1 = r0.getMLinkCastInfo();
        if (r1 == null) goto L30;
        s0 r2 = (s0) r1.getValue();
    L31:
        if (r2 == null) goto L48;
        int r3 = r2.getItemType();
        LinkScreenCastType r4 = LinkScreenCastType.CAST_TYPE_GAME;
        if (r3 == r4.getTypeValue()) goto L39;
        r4 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        if (r3 == r4.getTypeValue()) goto L39;
        r4 = LinkScreenCastType.CAST_TYPE_UNKNOWN;
    L39:
        int r5 = com.bytedance.android.live.liveinteract.linkcast.i.a;
        String r6 = r2.getAppId();
        if (r6 != null) goto L42;
        r6 = "";
    L42:
        com.bytedance.android.live.liveinteract.linkcast.c r7 = com.bytedance.android.live.liveinteract.linkcast.i.a.a(r4, r6);
        if (r7 != null) goto L46;
        return null;
    L46:
        return new Pair(r4, r7);
    L48:
        return null;
    L30:
        r2 = null;
        goto L31
    L11:
        ILinkPlayerInfoBridge r8 = a;
        if (r8 == null) goto L16;
        IBaseUser r9 = r8.getUser();
        if (r9 == null) goto L16;
        String r10 = r9.getIdString();
    L17:
        com.bytedance.live.datacontext.m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L22;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L22;
        String r13 = r12.getOwnerUserIdString();
    L24:
        if (Intrinsics.areEqual(r10, r13) == false) goto L30;
        LinkCastGuestDataContext r14 = LinkCastGuestDataContext.Companion.getContext();
        if (r14 == null) goto L30;
        com.bytedance.live.datacontext.n<s0> r15 = r14.getMLinkCastInfo();
        if (r15 == null) goto L30;
        r2 = (s0) r15.getValue();
    L22:
        r13 = null;
    L16:
        r10 = null;
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void O() {
        IBaseUser r4 = jc1.k.n(IMiddlewareUserService.class).user().b();
        Room r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r5 == null) goto L9;
        Activity r2 = com.bytedance.android.live.core.utils.a.d();
        if (r4 == null) goto L10;
        if (r2 == null) goto L11;
        hi0.a.c(hi0.a.a, r2, null, r4, r5, false, 48);
        j.dismissDialog();
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // ih0.d
    public final void dismissDialog() {
        b = "seat";
        JsonObject r0 = new JsonObject();
        r0.addProperty("source", "");
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L8;
        ih0.b r2 = r1.dynamicService(null);
        if (r2 == null) goto L9;
        r2.Dk("interact_emoji_panel", "dismiss_interact_emoji_panel", r0, false);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void s() {
        int r0 = c1.a;
        if (e5.n() == false) goto L6;
        f2.b(2131917689, 0);
        return;
    L6:
        Activity r1 = com.bytedance.android.live.core.utils.a.d();
        if (r1 != null) goto L9;
        return;
    L9:
        String r2 = ChatMatchWidget.o;
        ChatMatchViewModel r3 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r3 == null) goto L19;
        Room r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r4 == null) goto L15;
        new gk0.a(r4).d(false, 0);
    L15:
        if (Intrinsics.areEqual((Boolean) r3.getMatchingState().getValue(), Boolean.TRUE) == false) goto L17;
        ChatMatchViewModel.showMatchDialog$default(r3, false, 1, null);
        j.dismissDialog();
        return;
    L17:
        j0.a r5 = new j0.a(r1);
        r5.a = s1.B(2131917765);
        r5.c = s1.B(2131915442);
        r5.b = b.a;
        r5.e = s1.B(2131917767);
        r5.d = new DialogInterfaceOnClickListenerC0106a(r3);
        r5.c();
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void y0() {
        Intrinsics.checkNotNullParameter("link_interaction_panel_beauty", "eventPage");
        m90.a r0 = jc1.k.n(IEffectPluginPropertyService.class).getLIVE_BEAUTY_STICKER_TAB_DOT_SHOW();
        if (r0 == null) goto L6;
        r0.a(LiveEffectContextFactoryType.LINK, Boolean.FALSE);
    L6:
        if (je0.d.r() == false) goto L10;
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 == null) goto L22;
        r1.w5();
    L22:
        i0 r2 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter("emoji_panel", "clickSource");
        HashMap r3 = new HashMap();
        int r4 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.B0(r3, Integer.valueOf(r4), null, 4);
        TalkRoomLogUtils.Q0(r3);
        TalkRoomLogUtils.I0(r3, r4);
        r3.put("click_source", "emoji_panel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_guest_connection_user_beauty_click", r3, new Object[]{IRoom.class, am2.x.class});
        return;
    L10:
        dismissDialog();
        DigitAvatarContext r5 = DigitAvatarContext.Companion.getContext();
        if (r5 == null) goto L14;
        VideoShowMode r6 = r5.getCurrentVideoShowMode();
        if (r6 == null) goto L14;
    L15:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.c r7 = new com.bytedance.android.live.liveinteract.videotalk.utils.panel.c(r6);
        int r8 = InteractBeautyPreviewDialog.A;
        InteractBeautyPreviewDialog r9 = InteractBeautyPreviewDialog.a.a(r7, "link_interaction_panel_beauty", null);
        FragmentActivity r10 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if ((r10 instanceof FragmentActivity) == false) goto L22;
        FragmentManager r11 = r10.getSupportFragmentManager();
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, "InteractBeautyPreviewDialog", r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r9, r12) == true) goto L22;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L21:
        r9.show(r11, "InteractBeautyPreviewDialog");
    L14:
        r6 = VideoShowMode.AUDIO;
        goto L15
    }

    public static com.bytedance.android.live.liveinteract.voicechat.b o() {
        Object r1 = null;
        if (je0.d.y() == false) goto L13;
        IKtvService r0 = jc1.k.f(IKtvService.class);
        if (r0 == null) goto L7;
        Object r2 = r0.muteManager();
    L9:
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.b) == false) goto L17;
        r1 = r2;
    L17:
        return (com.bytedance.android.live.liveinteract.voicechat.b) r1;
    L7:
        r2 = null;
        goto L9
    L13:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r3 = IVoiceChatAdminService.a.a();
        if (r3 != null) goto L16;
        return null;
    L16:
        return r3.muteManager();
    }

    @Override // ih0.d
    public final void a() {
        if ((System.currentTimeMillis() - e) >= vm2.i.a().getEmojiPanelDebounceInterval()) goto L5;
        return;
    L5:
        e = System.currentTimeMillis();
        u6 r0 = new u6(vm2.i.b().getEmojiPanelSchema());
        r0.b("url", vm2.i.b().getEmojiPanelUrl());
        u6 r1 = r0.d("url");
        LinkedHashMap r2 = new LinkedHashMap();
        ILinkPlayerInfoBridge r3 = a;
        if (r3 == null) goto L11;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L11;
        String r5 = r4.getIdString();
        if (r5 == null) goto L11;
    L12:
        r2.put("target_user_id", r5);
        r2.put("request_page", b);
        r2.put("hide_toolbar", String.valueOf(c));
        r2.put("open_time", String.valueOf(System.currentTimeMillis()));
        Iterator r6 = r2.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        Map.Entry r7 = (Map.Entry) r6.next();
        r1.b((String) r7.getKey(), (String) r7.getValue());
        goto L14
    L16:
        jc1.k.n(IBaseLiveActionHandler.class).handle(jc1.a.b(), r0.c());
        return;
    L11:
        r5 = "";
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void report() {
        dismissDialog();
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        IBaseUser r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.getValue();
    L6:
        IMiddlewareReportService r3 = jc1.k.n(IMiddlewareReportService.class);
        ReportConstant.BusinessSource r4 = ReportConstant.BusinessSource.NewProfile;
        ILinkPlayerInfoBridge r5 = a;
        if (r5 == null) goto L9;
        IBaseUser r6 = r5.getUser();
    L10:
        ILinkPlayerInfoBridge r7 = a;
        if (r7 == null) goto L13;
        r1 = r7.getUser();
    L13:
        r3.reportWithUserProfileEvent(r4, r6, r2, new UserProfileEvent(r1).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static final void c(Throwable r2) {
        a r0 = j;
        if ((r2 instanceof ApiServerException) == false) goto L5;
        f2.c(((ApiServerException) r2).getPrompt(), 0);
        return;
    L5:
        Activity r1 = com.bytedance.android.live.core.utils.a.d();
        if (r1 == null) goto L8;
        ExceptionUtils.handleException(r1, r2);
    L8:
        r0.dismissDialog();
    }

    public static final void i(Throwable r1) {
        if ((r1 instanceof ApiServerException) == false) goto L8;
        ApiServerException r2 = (ApiServerException) r1;
        if (TextUtils.isEmpty(r2.getPrompt()) == true) goto L9;
        f2.c(r2.getPrompt(), 0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void C(String r4) {
        Intrinsics.checkNotNullParameter(r4, "targetUserId");
        com.bytedance.android.live.liveinteract.voicechat.b r5 = o();
        if (r5 == null) goto L5;
        r5.g(this);
    L5:
        ILinkPlayerInfoBridge r6 = a;
        if (r6 == null) goto L16;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L17;
        String r8 = r7.getNickName();
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.length() <= 10) goto L14;
        r8 = r8.substring(0, 10) + "...";
    L14:
        f2.c(s1.C(2131923172, new Object[]{r8}), 0);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void V(String r4) {
        Intrinsics.checkNotNullParameter(r4, "targetUserId");
        com.bytedance.android.live.liveinteract.voicechat.b r5 = o();
        if (r5 == null) goto L5;
        r5.g(this);
    L5:
        ILinkPlayerInfoBridge r6 = a;
        if (r6 == null) goto L16;
        IBaseUser r7 = r6.getUser();
        if (r7 == null) goto L17;
        String r8 = r7.getNickName();
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.length() <= 10) goto L14;
        r8 = r8.substring(0, 10) + "...";
    L14:
        f2.c(s1.C(2131923165, new Object[]{r8}), 0);
        return;
    L17:
        return;
    }

    public final void n(DataCenter r5) {
        FragmentActivity r0 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = com.bytedance.android.live.liveinteract.digitavatar.m.a;
        com.bytedance.android.live.liveinteract.digitavatar.m.a(r0, r0.getSupportFragmentManager(), r5, true, null);
        dismissDialog();
    }

    @Override // ih0.a
    public final void v0(int r1) {
        d = r1;
    }

    public static final void d(DataCenter r10, com.bytedance.android.live.liveinteract.voicechat.model.a r11) {
        a r0 = j;
        w8 r1 = r11.a();
        Long r3 = null;
        if ((r1 instanceof w8) == true) goto L5;
        r1 = null;
    L5:
        if (r1 == null) goto L30;
        if (r10 == null) goto L9;
        vlc.d r12 = (vlc.d) r10.get("data_message_manager", null);
    L10:
        r1.setCurrUserIsAnchor(je0.d.r());
        if (r12 == null) goto L13;
        r12.B((tlc.d) r1);
    L13:
        boolean r4 = je0.d.r();
        String r5 = b;
        int r6 = je0.d.f();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r7 = r1.getDynamicEmojiFlex();
        IBaseUser r13 = r1.getToUser();
        if (r13 == null) goto L16;
        String r8 = r13.getIdString();
    L17:
        IBaseUser r14 = r1.getToUser();
        if (r14 == null) goto L20;
        String r15 = r14.getIdString();
    L21:
        Room r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r2 == null) goto L24;
        String r9 = r2.getOwnerUserIdString();
    L25:
        TalkRoomLogUtils.m(r4, r5, r6, r7, r8, Boolean.valueOf(Intrinsics.areEqual(r15, r9)));
        w8 r16 = r11.a();
        if (r16 == null) goto L28;
        r3 = Long.valueOf(r16.getMessageId());
    L28:
        x.s0(r3.longValue(), r1.getDynamicEmojiFlex());
        r0.dismissDialog();
        return;
    L24:
        r9 = null;
        goto L25
    L20:
        r15 = null;
        goto L21
    L16:
        r8 = null;
        goto L17
    L9:
        r12 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void L(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r3, VideoShowMode r4) {
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        Intrinsics.checkNotNullParameter(r4, "selectMode");
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        Intrinsics.checkNotNullParameter(r4, "selectMode");
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void Q(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "targetUserId");
        com.bytedance.android.live.liveinteract.voicechat.b r4 = o();
        if (r4 == null) goto L6;
        r4.g(this);
    L6:
        if ((r3 instanceof ApiServerException) == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L14;
        ExceptionUtils.handleException(jc1.a.b(), r3, 2131919337);
        return;
    L14:
        return;
    L8:
        if (((ApiServerException) r3).getErrorCode() != 4004468) goto L10;
        r5 = true;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager.a
    public final void i0(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "targetUserId");
        com.bytedance.android.live.liveinteract.voicechat.b r4 = o();
        if (r4 == null) goto L5;
        r4.g(this);
    L5:
        ExceptionUtils.handleException(jc1.a.b(), r3, 2131919335);
    }

    public final void r(String r21, int r22) {
        ILinkPlayerInfoBridge r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = jc1.k.n(IMiddlewareUserService.class).user().c();
        com.bytedance.android.livesdk.user.e r2 = jc1.k.n(IMiddlewareUserService.class).user();
        Room r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        String r4 = null;
        if (r3 == null) goto L8;
        Long r5 = Long.valueOf(r3.getRoomId());
    L9:
        boolean r6 = r2.t(r5);
        IBaseUser r7 = r0.getUser();
        if (r7 == null) goto L12;
        String r8 = r7.getIdString();
    L13:
        com.bytedance.live.datacontext.m r9 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r9 == null) goto L18;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L18;
        String r11 = r10.getOwnerUserIdString();
    L19:
        boolean r12 = Intrinsics.areEqual(r8, r11);
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a() == true) goto L22;
        return;
    L22:
        if (je0.d.r() == true) goto L25;
        if (r1 == true) goto L25;
        if (r6 == true) goto L25;
        return;
    L25:
        Activity r13 = com.bytedance.android.live.core.utils.a.d();
        if (r13 != null) goto L28;
        return;
    L28:
        String r14 = je0.d.b0();
        ILinkPlayerInfoBridge r15 = a;
        if (r15 == null) goto L33;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L33;
        String r17 = r16.getIdString();
    L34:
        boolean r18 = Intrinsics.areEqual(r14, r17);
        boolean r19 = true;
        if (r18 == false) goto L56;
        if (TextUtils.isEmpty(r21) == true) goto L44;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m r20 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m(r13, je0.d.r(), r22, com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom(), true, Boolean.valueOf(r12), 32);
        if (DialogLancet.shouldBlockDialogShow(r20) == false) goto L94;
        DialogLancet.handleBlockedDialogShow(r20);
    L43:
        jf0.a r23 = jf0.a.a;
        jf0.a.d(r0.getUserPosition(), r1);
        dismissDialog();
        return;
    L94:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L86
    L42:
        DialogLancet.beforeDialogShow(r20);
        r20.show();
        DialogLancet.afterDialogShow(r20);
        goto L43
    L44:
        ArrayList<c0> r24 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        IInteractService r25 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r25 != null) goto L47;
    L49:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e r26 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e(r13, com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom(), r22, r0.isEnlarged(), r12, r22);
        if (DialogLancet.shouldBlockDialogShow(r26) == false) goto L90;
        DialogLancet.handleBlockedDialogShow(r26);
    L54:
        jf0.a r27 = jf0.a.a;
        jf0.a.a(r0.getUserPosition(), true, true, "order", r1);
        dismissDialog();
        return;
    L90:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L87
    L53:
        DialogLancet.beforeDialogShow(r26);
        r26.show();
        DialogLancet.afterDialogShow(r26);
        goto L54
    L47:
        if (r25.isLinkCasting() != true) goto L49;
        f2.b(2131919002, 0);
        goto L49
    L56:
        if (TextUtils.isEmpty(r21) == true) goto L63;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m r28 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m(r13, je0.d.r(), r0.getUserPosition(), com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom(), true, Boolean.valueOf(r0.isEnlarged()), Boolean.valueOf(r12));
        if (DialogLancet.shouldBlockDialogShow(r28) == false) goto L96;
        DialogLancet.handleBlockedDialogShow(r28);
    L62:
        jf0.a r29 = jf0.a.a;
        jf0.a.d(r0.getUserPosition(), r1);
        dismissDialog();
        return;
    L96:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L88
    L61:
        DialogLancet.beforeDialogShow(r28);
        r28.show();
        DialogLancet.afterDialogShow(r28);
        goto L62
    L63:
        ArrayList<c0> r30 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
        Room r31 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        int r32 = r0.getUserPosition();
        boolean r110 = r0.isEnlarged();
        if (je0.d.N() == false) goto L68;
        if (je0.d.w() == true) goto L68;
    L73:
        if (r19 == false) goto L75;
        int r111 = r22 - 1;
    L76:
        IBaseUser r33 = r0.getUser();
        if (r33 == null) goto L79;
        r4 = r33.getIdString();
    L79:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e r34 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e(r13, r31, r32, r110, r12, r111, r4);
        if (DialogLancet.shouldBlockDialogShow(r34) == false) goto L92;
        DialogLancet.handleBlockedDialogShow(r34);
    L84:
        dismissDialog();
        jf0.a r35 = jf0.a.a;
        jf0.a.d(r0.getUserPosition(), r1);
        return;
    L92:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L89
    L83:
        DialogLancet.beforeDialogShow(r34);
        r34.show();
        DialogLancet.afterDialogShow(r34);
        goto L84
    L75:
        r111 = r22;
    L68:
        if (je0.d.u() == true) goto L70;
    L72:
        r19 = false;
        goto L73
    L70:
        if (d0.h(com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom()) == true) goto L72;
    L33:
        r17 = null;
    L18:
        r11 = null;
        goto L19
    L12:
        r8 = null;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void z0(boolean r2, DataCenter r3) {
        ILinkPlayerInfoBridge r0 = a;
        if (r0 == null) goto L11;
        IBaseUser r1 = r0.getUser();
        if (r1 == null) goto L12;
        String r4 = r1.getIdString();
        if (r4 == null) goto L13;
        j(r2, r4, r3);
        return;
    L13:
        return;
    L12:
        return;
    }

    public static void u(ILinkPlayerInfoBridge r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "requestPage");
        g = false;
        h = false;
        i = false;
        if (r1 == null) goto L5;
        int r0 = r1.getUserPosition();
    L6:
        d = r0;
        a = r1;
        b = r2;
        c = !r3;
        com.bytedance.android.live.liveinteract.linkpanel.util.v.a("emoji_panel");
        return;
    L5:
        r0 = d;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void H0(LinkScreenCastType r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "castType");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "appName");
        int r0 = com.bytedance.android.live.liveinteract.linkcast.i.a;
        com.bytedance.android.live.liveinteract.linkcast.i.a.b(r3, r4);
        com.bytedance.android.live.liveinteract.linkcast.g.a r1 = com.bytedance.android.live.liveinteract.linkcast.g.b;
        int r2 = r3.getTypeValue();
        r1.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.e(r4, r5, r2, true);
        if (r3.getTypeValue() != LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue()) goto L5;
        com.bytedance.android.live.liveinteract.linkcast.g.a.d(r4, true);
    L5:
        dismissDialog();
    }

    public final void j(boolean r8, String r9, DataCenter r10) {
        if (hd0.c.f().h() == true) goto L5;
        return;
    L5:
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r0 == null) goto L12;
        long r3 = r0.getRoomId();
        Activity r5 = com.bytedance.android.live.core.utils.a.d();
        if (r5 != null) goto L10;
        return;
    L10:
        oe0.d.c(r8, r9, r3, r5, r10);
        dismissDialog();
        return;
    }

    public final void v(DataCenter r20, TalkRoomBaseDynamicEmoji r21, String r22) {
        String r0 = je0.d.b0();
        ILinkPlayerInfoBridge r1 = a;
        String r2 = null;
        if (r1 == null) goto L7;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L7;
        String r4 = r3.getIdString();
    L8:
        long r5 = 0;
        if (Intrinsics.areEqual(r0, r4) == false) goto L83;
        if (g == true) goto L81;
        long r10 = 1000;
        if ((System.currentTimeMillis() - f) < r10) goto L108;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r6 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) com.bytedance.android.live.base.model.m.b(r21, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j.class);
        if (r6 == null) goto L59;
        Activity r7 = com.bytedance.android.live.core.utils.a.d();
        if (r7 == null) goto L59;
        i0 r8 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.j(r6, je0.d.r(), true, b);
        if (r6.getEmojiCategory() != 7) goto L24;
        TalkRoomLogUtils.j1("emoji_panel_oneself", null);
    L24:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r9 = r6.getEmojiPermission();
        if (r9 == null) goto L27;
        String r11 = r9.schemaJumpUrl;
    L29:
        if (TextUtils.isEmpty(r11) == true) goto L34;
        IBaseLiveActionHandler r12 = jc1.k.n(IBaseLiveActionHandler.class);
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r13 = r6.getEmojiPermission();
        if (r13 == null) goto L33;
        r2 = r13.schemaJumpUrl;
    L33:
        r12.handle(r7, r2);
        dismissDialog();
        goto L59
    L34:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r14 = r6.getEmojiPermission();
        if (r14 == null) goto L42;
        if (r14.hasPermission != true) goto L42;
        if ((System.currentTimeMillis() - f) >= r10) goto L42;
        f2.b(2131922729, 0);
    L42:
        if (r6.getEmojiCategory() != 2) goto L50;
        DigitAvatarContext r15 = DigitAvatarContext.Companion.getContext();
        if (r15 == null) goto L48;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r16 = r15.getSendAvatarEmoji();
        if (r16 == null) goto L48;
        r16.post(r6);
    L48:
        dismissDialog();
        goto L59
    L50:
        if (r6.getEmojiCategory() != 4) goto L56;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r17 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r17 == null) goto L54;
        r17.Fn(String.valueOf(r6.getEmojiId()));
    L54:
        dismissDialog();
        goto L59
    L56:
        if (r6.getEmojiCategory() == 6) goto L58;
    L60:
        boolean r18 = true;
    L61:
        if (r18 == true) goto L64;
        ALogger.i("LynxEmojiPanelHandler", "handleMySelfEmojiClickFilter not ready");
        return;
    L64:
        Ref.LongRef r19 = new Ref.LongRef();
        r19.element = 0;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.a r23 = r21.getCustomizedRandomResource();
        if (r23 != null) goto L67;
    L75:
        g = true;
        f = System.currentTimeMillis();
        long r24 = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.plantform.base.g r110 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r110 == null) goto L109;
        LinkApi r111 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        Room r25 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r25 == null) goto L80;
        r5 = r25.getRoomId();
    L80:
        r110.mq(r111.sendTalkRoomEmoji(r5, r21.emojiId, r19.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r21, r24, r20, r22, r19), new d(r21, r24)));
        return;
    L109:
        return;
    L67:
        if (r23.getType() <= 0) goto L75;
        if (r21.disable == false) goto L73;
        f2.c("已有随机表情正在进行，此随机表情暂不可发", 0);
        return;
    L73:
        if (r23.getStatus() != 1) goto L75;
        r19.element = 1;
        goto L75
    L58:
        if (r6.getDisable() == false) goto L60;
    L27:
        r11 = null;
    L59:
        r18 = false;
        goto L61
    L108:
        return;
    L81:
        return;
    L83:
        if (g == false) goto L85;
        return;
    L85:
        if ((System.currentTimeMillis() - f) < 1000) goto L113;
        g = true;
        f = System.currentTimeMillis();
        long r26 = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.plantform.base.g r27 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r27 == null) goto L112;
        LinkApi r112 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        Room r28 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r28 == null) goto L92;
        r5 = r28.getRoomId();
    L92:
        long r113 = r5;
        long r114 = r21.emojiId;
        int r115 = je0.d.f();
        ILinkPlayerInfoBridge r29 = a;
        if (r29 == null) goto L98;
        IBaseUser r30 = r29.getUser();
        if (r30 == null) goto L98;
        String r31 = r30.getIdString();
        if (r31 == null) goto L98;
    L99:
        String r116 = r31;
        ILinkPlayerInfoBridge r32 = a;
        if (r32 == null) goto L105;
        IBaseUser r33 = r32.getUser();
        if (r33 == null) goto L105;
        String r34 = r33.getIdString();
        if (r34 == null) goto L105;
    L106:
        r27.mq(r112.sendTalkRoomInteractEmoji(r113, r114, r115, 2, r116, r34).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r21, r26, r20, r22), new f(r21, r26)));
        return;
    L105:
        r34 = "";
    L98:
        r31 = "0";
        goto L99
    L112:
        return;
    L113:
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void t(String r17, String r18, JsonObject r19, ih0.h r20, DataCenter r21) {
        Intrinsics.checkNotNullParameter(r17, "panelType");
        Intrinsics.checkNotNullParameter(r18, "callType");
        Intrinsics.checkNotNullParameter(r19, "extraData");
        Intrinsics.checkNotNullParameter(r20, "updateCallback");
        ALogger.i("LynxEmojiPanelHandler", "emojiPanelUpdateAction call panelType=" + r17 + " callType=" + r18 + " extraData=" + r19);
        JsonElement r0 = r19.get("user_id");
        String r9 = "";
        if (r0 == null) goto L6;
        String r1 = r0.getAsString();
        if (r1 == null) goto L6;
    L8:
        switch(r18.hashCode()) {
            case -1674665027: goto L340;
            case -1460936650: goto L325;
            case -839557086: goto L322;
            case -382416171: goto L306;
            case 1776415492: goto L14;
            case 1805286486: goto L11;
            default: goto L342;
        };
    L342:
        ALogger.e("LynxEmojiPanelHandler", "emojiPanelUpdateAction callType=" + r18 + " not found");
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, r18.concat(" not define"), null);
        return;
    L11:
        if (r18.equals("open_beauty_panel") == false) goto L342;
        y0();
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "open_beauty_panel success", null);
        return;
    L14:
        if (r18.equals("interact_panel_click") == false) goto L342;
        JsonElement r2 = r19.get("action_type");
        if (r2 == null) goto L19;
        String r3 = r2.getAsString();
        if (r3 == null) goto L19;
    L20:
        JsonElement r4 = r19.get("data");
        if (r4 == null) goto L23;
        JsonObject r5 = r4.getAsJsonObject();
    L24:
        int r6 = r3.hashCode();
        a r10 = j;
        switch(r6) {
            case -763784670: goto L239;
            case -276465583: goto L216;
            case -246517770: goto L213;
            case 757927865: goto L192;
            case 814542031: goto L176;
            case 1432307344: goto L143;
            case 1632860697: goto L131;
            case 1858840781: goto L31;
            case 2094905634: goto L28;
            default: goto L304;
        };
    L304:
        ALogger.e("LynxEmojiPanelHandler", "emojiPanelUpdateAction subActionType=" + r3 + " not found");
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, r18 + ' ' + r3 + " not found", null);
        return;
    L28:
        if (r3.equals("recog_digit_avatar") == false) goto L304;
        n(r21);
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "interact_panel_click#recog_digit_avatar success", null);
        return;
    L31:
        if (r3.equals("camera_operation") == false) goto L304;
        if (r5 == null) goto L36;
        JsonElement r7 = r5.get("action");
        if (r7 == null) goto L36;
        int r8 = r7.getAsInt();
    L38:
        if (r8 != 1) goto L40;
    L43:
        if (r8 != 1) goto L45;
        boolean r11 = true;
    L47:
        if (je0.d.y() == true) goto L49;
    L51:
        String r12 = je0.d.b0();
        ILinkPlayerInfoBridge r13 = a;
        if (r13 == null) goto L56;
        IBaseUser r14 = r13.getUser();
        if (r14 == null) goto L56;
        String r15 = r14.getIdString();
    L58:
        if (Intrinsics.areEqual(r12, r15) == false) goto L62;
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r16 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r16 == null) goto L355;
        r16.f(r11, false, false, false, new com.bytedance.android.live.liveinteract.videotalk.utils.panel.b(r20), "openOrCloseCamera");
        return;
    L355:
        return;
    L62:
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r22 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r22 == null) goto L357;
        ILinkPlayerInfoBridge r23 = a;
        if (r23 == null) goto L70;
        IBaseUser r24 = r23.getUser();
        if (r24 == null) goto L70;
        String r25 = r24.getIdString();
        if (r25 == null) goto L70;
    L71:
        ILinkPlayerInfoBridge r26 = a;
        if (r26 == null) goto L75;
        String r27 = r26.getInteractId();
        if (r27 == null) goto L75;
    L76:
        r22.b(r25, !r22.d(r27));
        ILinkPlayerInfoBridge r28 = a;
        if (r28 == null) goto L82;
        IBaseUser r29 = r28.getUser();
        if (r29 == null) goto L82;
        String r30 = r29.getIdString();
        if (r30 == null) goto L82;
    L83:
        com.bytedance.live.datacontext.j r31 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r31 == null) goto L90;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r32 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r31.getValue();
        if (r32 == null) goto L90;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r33 = r32.t();
        if (r33 == null) goto L90;
        Integer r34 = Integer.valueOf(r33.a);
    L91:
        com.bytedance.live.datacontext.j r35 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r35 == null) goto L102;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r36 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r35.getValue();
        if (r36 == null) goto L102;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r37 = r36.t();
        if (r37 == null) goto L102;
        List r38 = r37.b;
        if (r38 == null) goto L102;
        if (r38.contains(1) == false) goto L102;
    L103:
        if (r38 == null) goto L105;
        boolean r39 = true;
    L106:
        ILinkPlayerInfoBridge r40 = a;
        if (r40 == null) goto L115;
        IBaseUser r41 = r40.getUser();
        if (r41 == null) goto L115;
        String r42 = r41.getIdString();
        if (r42 == null) goto L115;
        r9 = r42;
    L115:
        if (r22.d(r9) == false) goto L117;
        String r43 = "on";
    L118:
        i0 r44 = TalkRoomLogUtils.a;
        Intrinsics.checkNotNullParameter(r30, "toUserId");
        Intrinsics.checkNotNullParameter(r43, "buttonTypeStr");
        HashMap r45 = new HashMap();
        r45.put("live_type", "video_live");
        if (r34 == null) goto L121;
        TalkRoomLogUtils.B0(r45, Integer.valueOf(r34.intValue()), null, 4);
    L121:
        if (r39 == false) goto L123;
        r45.put("play_type", "video_friend");
    L123:
        r45.put("to_user_id", r30);
        r45.put("button_type", r43);
        TalkRoomLogUtils.g1(r45, r30);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_user_camera_open_click", r45, new Object[]{IRoom.class});
        UpdateLinkmicStatusResultModel.Code r46 = UpdateLinkmicStatusResultModel.Code.Success;
        StringBuilder r47 = new StringBuilder("interact_panel_click#camera_operation ");
        ILinkPlayerInfoBridge r48 = a;
        if (r48 == null) goto L128;
        IBaseUser r49 = r48.getUser();
        if (r49 == null) goto L128;
        String r50 = r49.getIdString();
    L129:
        r47.append(r50);
        r47.append("} success");
        r20.a(r46, r47.toString(), null);
        r10.dismissDialog();
        return;
    L128:
        r50 = null;
        goto L129
    L117:
        r43 = "off";
        goto L118
    L105:
        r39 = false;
    L102:
        r38 = null;
    L90:
        r34 = null;
    L82:
        r30 = "";
    L75:
        r27 = "";
    L70:
        r25 = "";
        goto L71
    L357:
        return;
    L56:
        r15 = null;
        goto L58
    L49:
        if (jc0.a.a() == true) goto L51;
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "interact_panel_click#camera_operation ktv disabled", null);
        return;
    L45:
        r11 = false;
        goto L47
    L40:
        if (r8 == 2) goto L43;
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "interact_panel_click#camera_operation failed", null);
        return;
    L36:
        r8 = 0;
        goto L38
    L131:
        if (r3.equals("open_cast_panel") == false) goto L304;
        Pair r51 = q();
        if (r51 == null) goto L359;
        LinkScreenCastType r52 = (LinkScreenCastType) r51.getFirst();
        String r53 = ((com.bytedance.android.live.liveinteract.linkcast.c) r51.getSecond()).a;
        if (r53 != null) goto L137;
        r53 = "";
    L137:
        String r54 = ((com.bytedance.android.live.liveinteract.linkcast.c) r51.getSecond()).c;
        if (r54 == null) goto L141;
        r9 = r54;
    L141:
        r10.H0(r52, r53, r9);
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "interact_panel_click#open_cast_panel success", null);
        return;
    L359:
        return;
    L143:
        if (r3.equals("switch_camera") == false) goto L304;
        rj0.l.n2.getClass();
        rj0.l r55 = rj0.l.a.a();
        if (r55 == null) goto L147;
        Boolean r56 = Boolean.valueOf(r55.T2());
    L148:
        i0 r57 = TalkRoomLogUtils.a;
        HashMap r58 = new HashMap();
        r58.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r59 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r59 == null) goto L155;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r60 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r59.getValue();
        if (r60 == null) goto L155;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r61 = r60.t();
        if (r61 == null) goto L155;
        TalkRoomLogUtils.B0(r58, Integer.valueOf(r61.a), null, 4);
    L155:
        TalkRoomLogUtils.Q0(r58);
        r58.put("request_page", "connection_interact_panel");
        r58.put("user_type", "guest");
        if (Intrinsics.areEqual(r56, Boolean.FALSE) == false) goto L158;
        String r62 = "before";
    L159:
        r58.put("filp_status", r62);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_connection_camera_flip", r58, new Object[]{IRoom.class, am2.x.class});
        dismissDialog();
        rj0.l r63 = rj0.l.a.a();
        if (r63 == null) goto L162;
        Boolean r65 = Boolean.valueOf(r63.T2());
    L164:
        if (((Boolean) w60.a.getValue()).booleanValue() == false) goto L171;
        if (r65 == null) goto L171;
        if (Intrinsics.areEqual(r65, Boolean.TRUE) == false) goto L169;
        int r110 = 2;
    L170:
        com.bytedance.android.livesdk.sharedpref.d.m(r110);
        goto L171
    L169:
        r110 = 1;
    L171:
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r66 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r66 == null) goto L174;
        com.bytedance.android.live.liveinteract.plantform.camera.b.C0048b.a(r66, true, true, true, true, "MultiLinkLynxEmojiPanel switchself camera", 16);
    L174:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "interact_panel_click#switch_camera success", null);
        return;
    L162:
        r65 = null;
        goto L164
    L158:
        r62 = "after";
        goto L159
    L147:
        r56 = null;
        goto L148
    L176:
        if (r3.equals("send_emoji") == false) goto L304;
        if (r5 != null) goto L347;
    L187:
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "interact_panel_click#send_emoji failed not found emoji", null);     // Catch: Exception -> L189
        return;
    L347:
    L189:
        e = move-exception;
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "interact_panel_click#send_emoji failed ==> " + e.getMessage(), null);
        return;
    L179:
        if (r5.has("emoji") != true) goto L187;
        String r67 = r5.get("emoji").getAsString();     // Catch: Exception -> L189
        JsonElement r68 = r5.get("request_page");     // Catch: Exception -> L189
        if (r68 == null) goto L186;
        String r69 = r68.getAsString();     // Catch: Exception -> L189
        if (r69 == null) goto L186;
        r9 = r69;
    L186:
        v(r21, (TalkRoomBaseDynamicEmoji) GsonHelper.get().fromJson(r67, r.class), r9);     // Catch: Exception -> L189
        return;
    L192:
        if (r3.equals("open_guest_setting_panel") == false) goto L304;
        Activity r70 = com.bytedance.android.live.core.utils.a.d();
        if (r70 == null) goto L203;
        if (r21 == null) goto L203;
        int r71 = ChatRoomGuestSettingDialog.f;
        ChatRoomGuestSettingDialog.a.a();
        ChatRoomGuestSettingDialog r72 = new ChatRoomGuestSettingDialog(r70, r21, !c, b, 1);
        if (DialogLancet.shouldBlockDialogShow(r72) == false) goto L345;
        DialogLancet.handleBlockedDialogShow(r72);
    L202:
        dismissDialog();
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "interact_panel_click#open_guest_setting_panel success", null);
        return;
    L345:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L344
    L201:
        DialogLancet.beforeDialogShow(r72);
        r72.show();
        DialogLancet.afterDialogShow(r72);
    L203:
        UpdateLinkmicStatusResultModel.Code r73 = UpdateLinkmicStatusResultModel.Code.Failed;
        StringBuilder r74 = new StringBuilder("interact_panel_click#open_guest_setting_panel failed context = null:");
        if (r70 != null) goto L206;
        boolean r75 = true;
    L207:
        r74.append(r75);
        r74.append(" or dataCenter=null:");
        if (r21 != null) goto L210;
        boolean r111 = true;
    L211:
        r74.append(r111);
        r20.a(r73, r74.toString(), null);
        return;
    L210:
        r111 = false;
        goto L211
    L206:
        r75 = false;
        goto L207
    L213:
        if (r3.equals("report_user") == false) goto L304;
        report();
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "interact_panel_click#report_user success", null);
        return;
    L216:
        if (r3.equals("xplay_clear_screen") == false) goto L304;
        if (r5 == null) goto L221;
        JsonElement r76 = r5.get("action");
        if (r76 == null) goto L221;
        int r77 = r76.getAsInt();
    L223:
        if (r77 != 1) goto L225;
    L228:
        IGameDataService r78 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r78 == null) goto L237;
        com.bytedance.live.datacontext.m r79 = r78.getClearScreen();
        if (r79 == null) goto L237;
        if (r77 != 1) goto L235;
        boolean r112 = true;
    L236:
        r79.setValue(Boolean.valueOf(r112));
        goto L237
    L235:
        r112 = false;
    L237:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "xplay_clear_screen success", null);
        return;
    L225:
        if (r77 == 2) goto L228;
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "xplay_clear_screen failed unknown action " + r77, null);
        return;
    L221:
        r77 = 0;
        goto L223
    L239:
        if (r3.equals("select_show_mode") == false) goto L304;
        if (r5 == null) goto L244;
        JsonElement r80 = r5.get("mode");
        if (r80 == null) goto L244;
        int r81 = r80.getAsInt();
    L245:
        VideoShowMode[] r82 = VideoShowMode.values();
        int r83 = r82.length;
        int r84 = 0;
    L246:
        if (r84 >= r83) goto L254;
        VideoShowMode r85 = r82[r84];
        if (r85.getType() != r81) goto L250;
        boolean r86 = true;
    L251:
        if (r86 == true) goto L255;
        r84 = r84 + 1;
    L255:
        if (r85 != null) goto L257;
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "interact_panel_click#select_show_mode failed", null);
        return;
    L257:
        if (r85 == VideoShowMode.DIGIT_AVATAR) goto L259;
    L266:
        FragmentActivity r87 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r87 != null) goto L269;
    L268:
        JsonObject r88 = null;
    L302:
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "interact_panel_click#select_show_mode success", r88);
        return;
    L269:
        DigitAvatarContext.a r89 = DigitAvatarContext.Companion;
        DigitAvatarContext r90 = r89.getContext();
        if (r90 == null) goto L300;
        VideoShowMode r91 = r90.getCurrentVideoShowMode();
        if (r91 == null) goto L300;
        if (r91 == r85) goto L300;
        if (((Boolean) ab0.a.getValue()).booleanValue() == true) goto L277;
    L290:
        int r92 = je0.d.f();
        if (r85 != VideoShowMode.VIDEO) goto L297;
        rj0.l.n2.getClass();
        if (rj0.l.a.a() == null) goto L297;
        if (sj1.a(r92, je0.f.a()) == false) goto L297;
        ArrayList r93 = new ArrayList();
        r93.add(new qh0.f.c(r87, OperateType.APPLY, 1));
        qh0.f.a(r93).a(new j(r91, r85));
    L297:
        r85.setSource(1);
        DigitAvatarContext r94 = r89.getContext();
        if (r94 == null) goto L300;
        r88 = null;
        DigitAvatarContext.setVideoShowMode$default(r94, r85, null, 2, null);
    L301:
        dismissDialog();
        goto L302
    L277:
        if (r85 != VideoShowMode.VIDEO) goto L290;
        if (je0.d.r() == true) goto L290;
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r95 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r95 == null) goto L290;
        if (r95.a() == true) goto L290;
        com.bytedance.android.live.liveinteract.plantform.camera.b r96 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r96 != null) goto L287;
    L289:
        f2.b(2131917478, 0);
        goto L268
    L287:
        if (r96.e() != true) goto L289;
        f2.b(2131917582, 0);
    L300:
        r88 = null;
        goto L301
    L259:
        if (((Boolean) b6.s.getValue()).booleanValue() == false) goto L266;
        FragmentActivity r97 = ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d());
        if (r97 == null) goto L268;
        if (r21 == null) goto L268;
        int r98 = com.bytedance.android.live.liveinteract.digitavatar.m.a;
        com.bytedance.android.live.liveinteract.digitavatar.m.a(r97, r97.getSupportFragmentManager(), r21, false, null);
        goto L300
    L250:
        r86 = false;
        goto L251
    L254:
        r85 = null;
    L244:
        r81 = 0;
        goto L245
    L23:
        r5 = null;
    L19:
        r3 = "";
        goto L20
    L306:
        if (r18.equals("update_enlarge_status") == false) goto L342;
        JsonElement r99 = r19.get("action");
        if (r99 == null) goto L310;
        int r100 = r99.getAsInt();
    L311:
        int r101 = 1;
        if (r100 != 1) goto L314;
    L317:
        if (r100 != r101) goto L319;
        boolean r113 = true;
    L320:
        j(r113, r1, r21);
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "update_enlarge_status success", null);
        return;
    L319:
        r113 = false;
        goto L320
    L314:
        if (r100 != 2) goto L316;
        r101 = 1;
        goto L317
    L316:
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "update_enlarge_status failed unknown action " + r100, null);
        return;
    L310:
        r100 = 0;
        goto L311
    L322:
        if (r18.equals("fast_match") == false) goto L342;
        s();
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "fast_match success", null);
        return;
    L325:
        if (r18.equals("edit_mic_position") == false) goto L342;
    L337:
        e = move-exception;
        ALogger.e("LynxEmojiPanelHandler", "emojiPanelUpdateAction edit_mic_position msg=" + e.getMessage() + ' ');
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "edit_mic_position failed=" + e.getMessage(), null);
        return;
    L327:
        if (r19.has("position") == false) goto L335;
        int r102 = r19.get("position").getAsInt();     // Catch: Exception -> L337
        JsonElement r103 = r19.get("active_name");     // Catch: Exception -> L337
        if (r103 == null) goto L334;
        String r104 = r103.getAsString();     // Catch: Exception -> L337
        if (r104 == null) goto L334;
        r9 = r104;
    L334:
        r(r9, r102);     // Catch: Exception -> L337
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "edit_mic_position success", null);     // Catch: Exception -> L337
        return;
    L335:
        r20.a(UpdateLinkmicStatusResultModel.Code.Failed, "edit_mic_position failed data not ready", null);     // Catch: Exception -> L337
        return;
    L340:
        if (r18.equals("open_contribution_list_panel") == false) goto L342;
        O();
        r20.a(UpdateLinkmicStatusResultModel.Code.Success, "open_contribution_list_panel success", null);
        return;
    L6:
        r1 = "";
        goto L8
    }
}
