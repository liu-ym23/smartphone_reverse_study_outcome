package com.bytedance.android.live.liveinteract.voicechat.emoji;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bk0.h;
import bk0.o;
import bk0.p;
import bk0.s;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.linkcast.LinkCastGuestDataContext;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Receiver;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Scene;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Sender;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemAdapter;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.v0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.w0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.z0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.chatroom.model.interact.s0;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkmicAIGuestType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import rj0.k;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/VideoTalkInteractEmojiPanel;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/InteractEmojiPanel;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkInteractEmojiPanel extends InteractEmojiPanel {
    public static final /* synthetic */ int G = 0;
    public final e F;

    public static final class a {
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
            r1.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ VideoTalkInteractEmojiPanel a;

        public c(VideoTalkInteractEmojiPanel r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r3v4, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.VideoTalkInteractEmojiPanel, java.lang.Object] */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            r3.dismiss();
            IBaseUser r5 = this.a.C.getUser();
            if (r5 == null) goto L9;
            Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
            String r6 = r5.getCastSecUid();
            if (r6 == null) goto L9;
            k.m2.getClass();
            k r0 = k.a.a();
            if (r0 == null) goto L9;
            r0.Kh(r5.getIdString(), r6);
        L9:
            ?? r7 = this.a;
            Handler r8 = DialogLancet.resolveDialogHandler(r7);
            if (r8 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r9 == null) goto L23;
            com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r8.getLooper()) goto L14;
            r8.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ VideoTalkInteractEmojiPanel a;

        public d(VideoTalkInteractEmojiPanel r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r3v4, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.VideoTalkInteractEmojiPanel, java.lang.Object] */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            r3.dismiss();
            IBaseUser r5 = this.a.C.getUser();
            if (r5 == null) goto L9;
            Intrinsics.checkNotNullParameter(r5, "$this$secUidExt");
            String r6 = r5.getCastSecUid();
            if (r6 == null) goto L9;
            com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
            com.bytedance.android.live.liveinteract.plantform.base.k r0 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
            if (r0 == null) goto L9;
            r0.ge(r5.getIdString(), r6);
        L9:
            ?? r7 = this.a;
            Handler r8 = DialogLancet.resolveDialogHandler(r7);
            if (r8 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r7);
            r7.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r7);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r7);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r9 == null) goto L23;
            com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r8.getLooper()) goto L14;
            r8.post(DialogLancet.createDismissRunnable(r7));
        }
    }

    public static final class e implements bk0.d.a {
        public final /* synthetic */ VideoTalkInteractEmojiPanel a;

        @Override // bk0.d.a
        public final boolean a() {
            return true;
        }

        @Override // bk0.d.a
        public final boolean b() {
            return true;
        }

        @Override // bk0.d.a
        public final boolean c() {
            VideoTalkInteractEmojiPanel r0 = this.a;
            int r1 = VideoTalkInteractEmojiPanel.G;
            return r0.m1();
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

        public e(VideoTalkInteractEmojiPanel r1) {
            this.a = r1;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VideoTalkInteractEmojiPanel a;

        public f(VideoTalkInteractEmojiPanel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            VideoTalkInteractEmojiPanel r4 = this.a;
            ChatRoomPanelItemAdapter r0 = r4.p;
            if (r0 == null) goto L6;
            r0.y2(r4.S0());
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void O() {
        hi0.a r0 = hi0.a.a;
        Context r2 = getContext();
        DataCenter r3 = this.B;
        ILinkPlayerInfoBridge r4 = this.C;
        IRoom r5 = this.i;
        hi0.a.a.b(r2, r3, r4, r5, false);
        g1(this);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final int Q0() {
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L7;
        m<Boolean> r1 = r0.getCurrentUsingDigitAvatarInVideoTalkRoom();
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.getValue();
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L11;
        return 3;
    L11:
        return 1;
    L7:
        r2 = null;
        goto L9
    }

    public final i<ILinkPlayerInfoBridge> n1() {
        if (this.i.isLiveTypeAudio() == true) goto L13;
        if (this.j == false) goto L9;
        k.m2.getClass();
        k r0 = k.a.a();
        if (r0 != null) goto L22;
    L20:
        return null;
    L22:
        return r0.getLinkUserInfoCenter();
    L9:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r1 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r1 == null) goto L20;
        return r1.getLinkUserInfoCenter();
    L13:
        if (this.j == false) goto L17;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r2 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r2 == null) goto L20;
        return r2.getLinkUserInfoCenter();
    L17:
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r3 = IVoiceChatAdminService.a.a();
        if (r3 == null) goto L20;
        return r3.getLinkUserInfoCenter();
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
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("to_user_id", r3), TuplesKt.to("live_type", "video_live")});
        TalkRoomLogUtils.B0(r1, null, null, 6);
        jc1.k.n(IBaseLiveActionHandler.class).handle(getContext(), y0.b(r0, r1));
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
    public final List<g> S0() {
        boolean r1 = false;
        s0 r2 = null;
        if (vm2.d.L() == true) goto L5;
        ArrayList r0 = new ArrayList();
        String r5 = "";
        if (li0.d.g(null) == false) goto L110;
        IBaseUser r4 = this.C.getUser();
        if (r4 == null) goto L94;
        String r6 = r4.getIdString();
        if (r6 == null) goto L94;
    L95:
        int r7 = li0.d.c(r6);
        if (this.j == true) goto L100;
        if (com.bytedance.android.live.ktv.common.util.a.g() == false) goto L110;
    L100:
        if (TeamFightContext.Companion.h() == false) goto L110;
        if (r7 == (-1)) goto L110;
        IBaseUser r8 = this.C.getUser();
        if (r8 == null) goto L107;
        String r9 = r8.getIdString();
        if (r9 == null) goto L107;
    L108:
        r0.add(new z0(this, r9));
    L107:
        r9 = "";
    L94:
        r6 = "";
    L110:
        if (this.j == false) goto L112;
    L148:
        l1(r0);
        IBaseUser r3 = this.l;
        if (r3 == null) goto L157;
        if (r3.isMysteryMan() == true) goto L157;
        if (this.C.isAnonymous() == false) goto L155;
        ALogger.i("ttlive_video_talk_interact_emoji_panel", "the anchor clicks the anonymous seat profile emoji panel item need to be hidden.");
        goto L157
    L155:
        r0.add(new r0(this));
    L157:
        if (X0() == false) goto L163;
        if (W0() == false) goto L161;
        g r10 = new b1(this);
    L166:
        r0.add(r10);
        if (aj0.a.d() == false) goto L171;
        if (aj0.a.b(this.i) == true) goto L171;
    L198:
        h1(r0);
        if (W0() == true) goto L206;
        if (this.j == false) goto L206;
        if (m1() == false) goto L206;
        r0.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a(this));
    L206:
        if (W0() == true) goto L208;
        r0.add(new n(this));
    L208:
        IBaseUser r11 = this.l;
        if (r11 == null) goto L223;
        if (r11.isMysteryMan() == true) goto L223;
        if (this.C.isAnonymous() == false) goto L215;
        ALogger.i("ttlive_video_talk_interact_emoji_panel", "the anchor clicks the anonymous seat follow panel item need to be hidden.");
        goto L223
    L215:
        IBaseUser r12 = this.l;
        if (r12 != null) goto L218;
    L220:
        g r13 = new q(this);
    L221:
        r0.add(r13);
        goto L223
    L218:
        if (r12.isFollowing() != true) goto L220;
        r13 = new a1(this);
    L223:
        if (W0() == true) goto L226;
        r0.add(new r(this));
    L226:
        if (this.C.isAnonymous() == false) goto L229;
        r0.add(new v0(this));
    L229:
        if (W0() == true) goto L236;
        kj0.b r14 = SelfDisciplineContext.Companion.d();
        if (r14 != null) goto L233;
    L235:
        k1(r0);
        P0(r0);
        goto L236
    L233:
        if (r14.canShowContributionPanelItem() == false) goto L235;
        r0.add(new j(this));
    L236:
        return r0;
    L171:
        if (this.C.isAnonymous() == false) goto L174;
        ALogger.i("ttlive_video_talk_interact_emoji_panel", "the anchor clicks the anonymous seat open camera panel item need to be hidden.");
        goto L198
    L174:
        if (aj0.a.e() == true) goto L176;
    L197:
        j1(r0);
        goto L198
    L176:
        if (this.j == false) goto L186;
        k.m2.getClass();
        k r15 = k.a.a();
        if (r15 == null) goto L195;
        IBaseUser r16 = this.l;
        if (r16 == null) goto L185;
        String r17 = r16.getIdString();
        if (r17 == null) goto L185;
        r5 = r17;
    L185:
        r1 = r15.userIsCPosition(r5);
    L195:
        if (r1 == true) goto L197;
        ALogger.i("ttlive_video_talk_interact_emoji_panel", "the room fight hidden guest click seat open camera panel item need to be hidden.");
        goto L198
    L186:
        l.n2.getClass();
        l r18 = l.a.a();
        if (r18 == null) goto L195;
        IBaseUser r19 = this.l;
        if (r19 == null) goto L194;
        String r20 = r19.getIdString();
        if (r20 == null) goto L194;
        r5 = r20;
    L194:
        r1 = r18.userIsCPosition(r5);
        goto L195
    L161:
        r10 = new c1(this);
        goto L166
    L163:
        if (W0() == false) goto L165;
        r10 = new n0(this);
        goto L166
    L165:
        r10 = new x0(this);
        goto L166
    L112:
        if (je0.d.Y() == false) goto L121;
        IBaseUser r21 = this.l;
        if (r21 == null) goto L116;
        String r22 = r21.getIdString();
    L118:
        if ((!Intrinsics.areEqual(r22, this.i.getOwnerUserIdString())) == false) goto L121;
    L116:
        r22 = null;
    L121:
        if (W0() == true) goto L129;
        LinkCastGuestDataContext r23 = LinkCastGuestDataContext.Companion.getContext();
        if (r23 == null) goto L127;
        com.bytedance.live.datacontext.n<s0> r24 = r23.getMLinkCastInfo();
        if (r24 == null) goto L127;
        r2 = (s0) r24.getValue();
    L127:
        i1(r0, r2);
    L129:
        if (this.C.isAnonymous() == false) goto L131;
        ALogger.i("ttlive_video_talk_interact_emoji_panel", "other guest clicks the anonymous seat profile emoji panel item need to be hidden.");
    L132:
        h1(r0);
        if (this.C.isAnonymous() == false) goto L135;
        ALogger.i("ttlive_video_talk_interact_emoji_panel", "other guest clicks the anonymous seat follow panel item need to be hidden.");
    L143:
        if (W0() == true) goto L146;
        r0.add(new r(this));
    L146:
        if (this.C.isAnonymous() == false) goto L229;
        r0.add(new v0(this));
        goto L229
    L135:
        IBaseUser r25 = this.l;
        if (r25 != null) goto L138;
    L140:
        g r26 = new q(this);
    L141:
        r0.add(r26);
        goto L143
    L138:
        if (r25.isFollowing() != true) goto L140;
        r26 = new a1(this);
        goto L141
    L131:
        r0.add(new r0(this));
        goto L132
    L5:
        if (this.j == false) goto L8;
        IconFilterFactory$Sender r27 = IconFilterFactory$Sender.ANCHOR;
    L11:
        IBaseUser r28 = this.l;
        if (r28 == null) goto L17;
        if (r28.isMysteryMan() != true) goto L17;
        IconFilterFactory$Receiver r29 = IconFilterFactory$Receiver.MYSTERY;
    L31:
        if (W0() == false) goto L33;
        IconFilterFactory$Scene r30 = IconFilterFactory$Scene.CROSS_ROOM;
    L34:
        bk0.d r31 = new bk0.d(this.F);
        Intrinsics.checkNotNullParameter(r27, "senderType");
        Intrinsics.checkNotNullParameter(r29, "receiverType");
        Intrinsics.checkNotNullParameter(r30, "sceneType");
        Intrinsics.checkNotNullParameter(r31, "functionFilter");
        int r32 = s.a[r27.ordinal()];
        if (r32 == 1) goto L39;
        if (r32 == 2) goto L38;
        bk0.e r33 = new bk0.r();
    L40:
        int r34 = s.b[r30.ordinal()];
        if (r34 == 1) goto L48;
        if (r34 == 2) goto L47;
        if (r34 != 3) goto L46;
        bk0.e r35 = new bk0.n();
    L49:
        int r36 = s.c[r29.ordinal()];
        if (r36 == 1) goto L62;
        if (r36 == 2) goto L61;
        if (r36 == 3) goto L60;
        if (r36 != 4) goto L55;
        bk0.e r37 = new h();
    L63:
        List r38 = CollectionsKt.listOf(new bk0.e[]{r33, r35, r37, r31});
        Intrinsics.checkNotNullParameter(r38, "mIconFilters");
        ArrayList r39 = new ArrayList();
        l1(r39);
        LinkCastGuestDataContext r40 = LinkCastGuestDataContext.Companion.getContext();
        if (r40 == null) goto L68;
        com.bytedance.live.datacontext.n<s0> r41 = r40.getMLinkCastInfo();
        if (r41 == null) goto L68;
        r2 = (s0) r41.getValue();
    L68:
        i1(r39, r2);
        r39.add(new r0(this));
        r39.add(new x0(this));
        r39.add(new c1(this));
        r39.add(new n0(this));
        r39.add(new b1(this));
        j1(r39);
        r39.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a(this));
        h1(r39);
        r39.add(new n(this));
        r39.add(new q(this));
        r39.add(new a1(this));
        r39.add(new r(this));
        r39.add(new v0(this));
        kj0.b r42 = SelfDisciplineContext.Companion.d();
        if (r42 != null) goto L71;
    L73:
        k1(r39);
        P0(r39);
        Intrinsics.checkNotNullParameter(r39, "icons");
        ArrayList r43 = new ArrayList();
        Iterator r44 = r39.iterator();
    L75:
        if (r44.hasNext() == false) goto L86;
        g r45 = (g) r44.next();
        Iterator r46 = r38.iterator();
    L78:
        if (r46.hasNext() == false) goto L82;
        if (((bk0.e) r46.next()).a(r45) == true) goto L78;
        boolean r47 = false;
    L83:
        if (r47 == false) goto L75;
        r43.add(r45);
        goto L75
    L82:
        r47 = true;
        goto L83
    L86:
        return CollectionsKt.toList(r43);
    L71:
        if (r42.canShowContributionPanelItem() == false) goto L73;
        r39.add(new j(this));
        goto L73
    L55:
        if (r36 != 5) goto L58;
        r37 = new bk0.g();
        goto L63
    L58:
        throw new NoWhenBranchMatchedException();
    L60:
        r37 = new bk0.j();
        goto L63
    L61:
        r37 = new bk0.i();
        goto L63
    L62:
        r37 = new bk0.k();
        goto L63
    L46:
        throw new NoWhenBranchMatchedException();
    L47:
        r35 = new bk0.m();
        goto L49
    L48:
        r35 = new o();
        goto L49
    L38:
        r33 = new p();
        goto L40
    L39:
        r33 = new bk0.q();
        goto L40
    L33:
        r30 = IconFilterFactory$Scene.ROOM;
    L17:
        if (this.C.isAnonymous() == false) goto L19;
        r29 = IconFilterFactory$Receiver.ANONYMOUS;
        goto L31
    L19:
        IBaseUser r48 = this.l;
        if (r48 == null) goto L22;
        String r49 = r48.getIdString();
    L24:
        if (Intrinsics.areEqual(r49, this.i.getOwnerUserIdString()) == false) goto L27;
        r29 = IconFilterFactory$Receiver.ANCHOR;
        goto L31
    L27:
        if (this.C.getAiGuestType() <= LinkmicAIGuestType.None.ordinal()) goto L29;
        r29 = IconFilterFactory$Receiver.AI_GUEST;
        goto L31
    L29:
        r29 = IconFilterFactory$Receiver.NORMAL;
        goto L31
    L22:
        r49 = null;
        goto L24
    L8:
        if (je0.d.Y() == false) goto L10;
        r27 = IconFilterFactory$Sender.ADMIN;
        goto L11
    L10:
        r27 = IconFilterFactory$Sender.GUEST;
        goto L11
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final boolean Y0() {
        if (W0() == false) goto L24;
        i<ILinkPlayerInfoBridge> r0 = n1();
        if (r0 == null) goto L7;
        Iterable r1 = r0.c();
    L8:
        if (r1 == null) goto L23;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L23;
        IBaseUser r4 = ((ILinkPlayerInfoBridge) r2.next()).getUser();
        if (r4 == null) goto L15;
        String r5 = r4.getIdString();
    L16:
        IBaseUser r6 = this.l;
        if (r6 == null) goto L19;
        String r7 = r6.getIdString();
    L21:
        if (Intrinsics.areEqual(r5, r7) == false) goto L11;
        return true;
    L19:
        r7 = null;
        goto L21
    L15:
        r5 = null;
    L23:
        return false;
    L7:
        r1 = null;
        goto L8
    L24:
        i<ILinkPlayerInfoBridge> r3 = n1();
        if (r3 == null) goto L27;
        Collection r8 = r3.getOnlineUserList();
    L28:
        Collection r9 = r8;
        if (r9 != null) goto L31;
    L34:
        boolean r10 = true;
    L35:
        if (r10 == false) goto L37;
        return false;
    L37:
        Iterator r11 = r8.iterator();
    L39:
        if (r11.hasNext() == false) goto L51;
        IBaseUser r12 = ((ILinkPlayerInfoBridge) r11.next()).getUser();
        if (r12 == null) goto L43;
        String r13 = r12.getIdString();
    L44:
        IBaseUser r14 = this.l;
        if (r14 == null) goto L47;
        String r15 = r14.getIdString();
    L49:
        if (Intrinsics.areEqual(r13, r15) == false) goto L39;
        return true;
    L47:
        r15 = null;
        goto L49
    L43:
        r13 = null;
        goto L44
    L51:
        return false;
    L31:
        if (r9.isEmpty() == true) goto L34;
        r10 = false;
        goto L35
    L27:
        r8 = null;
        goto L28
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
        Object[] r3 = new Object[1];
        com.bytedance.android.live.liveinteract.plantform.model.m.a r4 = com.bytedance.android.live.liveinteract.plantform.model.m.q0;
        IBaseUser r5 = this.C.getUser();
        if (r5 == null) goto L9;
        String r6 = r5.getNickName();
    L10:
        r4.getClass();
        r3[0] = com.bytedance.android.live.liveinteract.plantform.model.m.a.a(r6);
        String r1 = s1.C(2131919814, r3);
        if (this.j == false) goto L14;
        DialogInterface.OnClickListener r7 = new c(this);
    L16:
        j0.a r8 = new j0.a(getContext());
        r8.a = r1;
        r8.b(r2, b.a);
        r8.a(r0, r7);
        r8.c();
        return;
    L14:
        if (je0.d.Y() == false) goto L18;
        r7 = new d(this);
        goto L16
    L18:
        InteractEmojiPanel.a.a(TalkRoomOperate.DISCONNECT);
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e() {
        if (Y0() == true) goto L7;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L7:
        if (W0() == false) goto L9;
        e1(2131919826);
    L9:
        String r2 = "";
        if (this.j == false) goto L29;
        if (W0() == false) goto L14;
        o1(true);
    L21:
        String r0 = this.k;
        IBaseUser r3 = this.C.getUser();
        if (r3 == null) goto L27;
        String r4 = r3.getIdString();
        if (r4 == null) goto L27;
        r2 = r4;
    L27:
        TalkRoomLogUtils.A(r0, null, null, r2);
    L48:
        g1(this);
        return;
    L14:
        IBaseUser r1 = this.C.getUser();
        if (r1 == null) goto L21;
        String r5 = r1.getIdString();
        if (r5 == null) goto L21;
        k.m2.getClass();
        k r6 = k.a.a();
        if (r6 == null) goto L21;
        k.b.d(r6, r5);
        goto L21
    L29:
        if (je0.d.Y() == true) goto L31;
        InteractEmojiPanel.a.a(TalkRoomOperate.SILENCE);
        goto L48
    L31:
        if (W0() == false) goto L33;
        o1(true);
    L40:
        String r7 = this.k;
        IBaseUser r8 = this.C.getUser();
        if (r8 == null) goto L46;
        String r9 = r8.getIdString();
        if (r9 == null) goto L46;
        r2 = r9;
    L46:
        TalkRoomLogUtils.A(r7, null, null, r2);
        goto L48
    L33:
        IBaseUser r10 = this.C.getUser();
        if (r10 == null) goto L40;
        String r11 = r10.getIdString();
        if (r11 == null) goto L40;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r12 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r12 == null) goto L40;
        r12.li(r11, null);
        goto L40
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void k() {
        if (Y0() == true) goto L7;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L7:
        if (W0() == false) goto L9;
        e1(2131919829);
    L9:
        String r3 = "";
        if (this.j == false) goto L29;
        if (W0() == false) goto L14;
        o1(false);
    L21:
        String r0 = this.k;
        IBaseUser r1 = this.C.getUser();
        if (r1 == null) goto L27;
        String r2 = r1.getIdString();
        if (r2 == null) goto L27;
        r3 = r2;
    L27:
        TalkRoomLogUtils.z(r0, null, r3);
    L48:
        g1(this);
        return;
    L14:
        IBaseUser r4 = this.C.getUser();
        if (r4 == null) goto L21;
        String r5 = r4.getIdString();
        if (r5 == null) goto L21;
        k.m2.getClass();
        k r6 = k.a.a();
        if (r6 == null) goto L21;
        r6.Q5(r5, false, null);
        goto L21
    L29:
        if (je0.d.Y() == true) goto L31;
        InteractEmojiPanel.a.a(TalkRoomOperate.UNSILENCE);
        goto L48
    L31:
        if (W0() == false) goto L33;
        o1(false);
    L40:
        String r7 = this.k;
        IBaseUser r8 = this.C.getUser();
        if (r8 == null) goto L46;
        String r9 = r8.getIdString();
        if (r9 == null) goto L46;
        r3 = r9;
    L46:
        TalkRoomLogUtils.z(r7, null, r3);
        goto L48
    L33:
        IBaseUser r10 = this.C.getUser();
        if (r10 == null) goto L40;
        String r11 = r10.getIdString();
        if (r11 == null) goto L40;
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.k r12 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r12 == null) goto L40;
        r12.Td(r11, null);
        goto L40
    }

    public final boolean m1() {
        if (fj0.e.l() == true) goto L7;
        if (this.C.getPaidCount() > 0) goto L7;
    L9:
        return false;
    L7:
        if (this.C.getExpectLeaveTime() <= 0) goto L9;
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinkCastGuestDataContext r0 = LinkCastGuestDataContext.Companion.getContext();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<s0> r1 = r0.getMLinkCastInfo();
        if (r1 == null) goto L13;
        Observable r2 = r1.a();
        if (r2 == null) goto L14;
        Disposable r3 = r2.subscribe(new f(this));
        if (r3 == null) goto L15;
        RxUtilKt.c(r3, this.s);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g1(VideoTalkInteractEmojiPanel r3) {
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

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void b(boolean r9) {
        if (Y0() == true) goto L6;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L6:
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r10 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r10 == null) goto L56;
        IBaseUser r1 = this.C.getUser();
        String r2 = "";
        if (r1 == null) goto L12;
        String r3 = r1.getIdString();
        if (r3 == null) goto L12;
    L13:
        String r4 = this.C.getInteractId();
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r10.b(r3, !r10.d(r4));
        HashMap r5 = new HashMap();
        r5.put("live_type", "video_live");
        List r6 = null;
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.B, null, 2).getVideoTalkRoomSubScene();
        if (r7 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r7.getValue();
        if (r8 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r11 = r8.t();
        if (r11 == null) goto L23;
        TalkRoomLogUtils.B0(r5, Integer.valueOf(r11.a), null, 4);
    L23:
        com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.h(this.B, null, 2).getVideoTalkRoomSubScene();
        if (r12 == null) goto L36;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r13 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r12.getValue();
        if (r13 == null) goto L36;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r14 = r13.t();
        if (r14 == null) goto L36;
        List r15 = r14.b;
        if (r15 == null) goto L36;
        if (r15.contains(1) == false) goto L34;
        r6 = r15;
    L34:
        if (r6 == null) goto L36;
        r5.put("play_type", "video_friend");
    L36:
        IBaseUser r16 = this.C.getUser();
        if (r16 == null) goto L40;
        String r17 = r16.getIdString();
        if (r17 == null) goto L40;
    L41:
        r5.put("to_user_id", r17);
        String r18 = this.C.getInteractId();
        if (r18 != null) goto L45;
        r18 = "";
    L45:
        if (r10.d(r18) == false) goto L47;
        String r19 = "on";
    L48:
        r5.put("button_type", r19);
        IBaseUser r20 = this.C.getUser();
        if (r20 == null) goto L54;
        String r21 = r20.getIdString();
        if (r21 == null) goto L54;
        r2 = r21;
    L54:
        TalkRoomLogUtils.g1(r5, r2);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_user_camera_open_click", r5, new Object[]{IRoom.class});
        g1(this);
        return;
    L47:
        r19 = "off";
    L40:
        r17 = "";
    L12:
        r3 = "";
        goto L13
    }

    public final void h1(List<g> r11) {
        if (this.r == true) goto L5;
    L6:
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(this.C) == false) goto L67;
        ILinkPlayerInfoBridge r1 = this.C;
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r2 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 == null) goto L16;
        Integer r5 = Integer.valueOf(r4.a);
    L17:
        com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = r7.t();
        if (r8 == null) goto L24;
        int r9 = r8.c;
    L25:
        m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L30;
        IRoom r12 = (IRoom) r10.getValue();
        if (r12 == null) goto L30;
        String r13 = r12.getOwnerUserIdString();
    L32:
        if (je0.d.J(this.j, jc1.k.n(IMiddlewareUserService.class).user().E(Long.valueOf(this.i.getRoomId()))) == false) goto L68;
        if (r5 != null) goto L36;
    L46:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L50;
        return;
    L50:
        if (LinkMicGameContext.Companion.e() == false) goto L53;
        return;
    L53:
        if (TeamFightContext.Companion.h() == false) goto L58;
        if (li0.d.g(null) == true) goto L58;
        return;
    L58:
        if (je0.d.M() == false) goto L63;
        if (aj0.a.b(this.i) == true) goto L63;
        return;
    L63:
        if (((IInteractService) jc1.k.n(IInteractService.class)).isPCLandscape(0, r9) == false) goto L65;
        return;
    L65:
        ((ArrayList) r11).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d(this, !r1.isEnlarged(), this.B));
        return;
    L36:
        if (r5.intValue() != 8) goto L46;
        if (CPositionContext.Companion.c() == true) goto L46;
        IBaseUser r14 = r1.getUser();
        if (r14 == null) goto L42;
        String r15 = r14.getIdString();
    L44:
        if (Intrinsics.areEqual(r15, r13) == false) goto L46;
        return;
    L42:
        r15 = null;
        goto L44
    L68:
        return;
    L30:
        r13 = null;
    L24:
        r9 = 0;
    L16:
        r5 = null;
        goto L17
    L67:
        return;
    L5:
        if (aj0.a.b(this.i) == true) goto L6;
    }

    public final void j1(List<g> r5) {
        if (W0() == false) goto L5;
        return;
    L5:
        int r0 = com.bytedance.android.live.liveinteract.utils.c1.a;
        boolean r1 = false;
        if (com.bytedance.android.live.liveinteract.utils.c1.a(0, je0.d.h()) == false) goto L9;
        return;
    L9:
        if (tc0.c.h().E == true) goto L18;
        com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r2 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
        if (r3 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 != null) goto L17;
        return;
    L17:
        if (r4.a == 12) goto L18;
        return;
    L35:
        return;
    L34:
        return;
    L18:
        com.bytedance.android.live.liveinteract.plantform.camera.b.o0.getClass();
        com.bytedance.android.live.liveinteract.plantform.camera.b r6 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        String r7 = "";
        if (r6 == null) goto L25;
        String r8 = this.C.getInteractId();
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        if (r6.c(r8) != 3) goto L25;
        return;
    L25:
        com.bytedance.android.live.liveinteract.plantform.camera.b r9 = com.bytedance.android.live.liveinteract.plantform.camera.b.a.a();
        if (r9 == null) goto L32;
        String r10 = this.C.getInteractId();
        if (r10 == null) goto L31;
        r7 = r10;
    L31:
        r1 = r9.d(r7);
    L32:
        ArrayList r11 = (ArrayList) r5;
        r11.add(new o0(this, r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k1(List<g> r13) {
        if (vm2.c.c() == false) goto L6;
        return;
    L6:
        if (vm2.d.E() == false) goto L120;
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        List<ILinkmicInteractEntrance> r1 = null;
        if (r0 == null) goto L10;
        i<ILinkPlayerInfoBridge> r2 = r0.getLinkUserInfoCenter();
    L12:
        if ((r2 instanceof y) == true) goto L14;
        r2 = null;
    L14:
        y r3 = (y) r2;
        if (r3 == null) goto L24;
        Map<String, List<ILinkmicInteractEntrance>> r4 = r3.E;
        if (r4 == null) goto L24;
        IBaseUser r5 = this.l;
        if (r5 == null) goto L22;
        String r6 = r5.getIdString();
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
        IInteractService r20 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r20 == null) goto L76;
        i<ILinkPlayerInfoBridge> r21 = r20.getLinkUserInfoCenter();
    L78:
        if ((r21 instanceof y) == true) goto L80;
        r21 = null;
    L80:
        y r22 = (y) r21;
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
        r6 = "";
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

    public final void l1(List<g> r3) {
        if (ThemedCompetitionContext.Companion.g() == true) goto L6;
        return;
    L6:
        if (this.C.getThemedCompetitionRole() == ThemedCompetitionRole.PERFORMER.getValue()) goto L11;
        if (this.C.getThemedCompetitionRole() == ThemedCompetitionRole.CONTESTANT.getValue()) goto L11;
        return;
    L11:
        if (this.j == false) goto L13;
    L14:
        ArrayList r4 = (ArrayList) r3;
        r4.add(new w0(this, this.C.getThemedCompetitionRole()));
        if (this.u == true) goto L19;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r5 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.b(this.j, this.C.getThemedCompetitionRole());
        this.u = true;
        return;
    L19:
        return;
    L13:
        if (ThemedCompetitionContext.a.e() == true) goto L14;
    }

    public final void o1(final boolean r10) {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.getRoomId());
    L8:
        long r4 = this.C.getLinkRoomId();
        if (r2 == null) goto L12;
        InteractEmojiPanel.Z0(r2.longValue(), r4, r10, this.s, new VideoTalkInteractEmojiPanel$handleMuteOtherRoom$$inlined$lets$lambda$1(this, r10));
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void i1(List<g> r4, s0 r5) {
        if (tb1.d.a == false) goto L6;
        return;
    L6:
        if (this.j == true) goto L32;
        IBaseUser r0 = this.l;
        if (r0 == null) goto L10;
        String r1 = r0.getIdString();
    L12:
        if (Intrinsics.areEqual(r1, this.i.getOwnerUserIdString()) == false) goto L33;
        if (r5 == null) goto L34;
        int r2 = r5.getItemType();
        LinkScreenCastType r3 = LinkScreenCastType.CAST_TYPE_GAME;
        if (r2 == r3.getTypeValue()) goto L21;
        r3 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        if (r2 == r3.getTypeValue()) goto L21;
        r3 = LinkScreenCastType.CAST_TYPE_UNKNOWN;
    L21:
        int r6 = com.bytedance.android.live.liveinteract.linkcast.i.a;
        String r7 = r5.getAppId();
        if (r7 != null) goto L24;
        r7 = "";
    L24:
        com.bytedance.android.live.liveinteract.linkcast.c r8 = com.bytedance.android.live.liveinteract.linkcast.i.a.a(r3, r7);
        if (r8 != null) goto L28;
        return;
    L28:
        if (Integer.valueOf(((ArrayList) r4).size()).intValue() <= 0) goto L30;
        ListProtector.add(r4, 0, new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.e(r3, r8, this));
        return;
    L30:
        ArrayList r9 = (ArrayList) r4;
        r9.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.e(r3, r8, this));
        return;
    L34:
        return;
    L33:
        return;
    L10:
        r1 = null;
        goto L12
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

    public VideoTalkInteractEmojiPanel(Context r1, DataCenter r2, ILinkPlayerInfoBridge r3) {
        super(r1, r2, r3);
        this.F = new e(this);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void H0(LinkScreenCastType r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "castType");
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "appName");
        super.H0(r3, r4, r5);
        com.bytedance.android.live.liveinteract.linkcast.g.a r0 = com.bytedance.android.live.liveinteract.linkcast.g.b;
        int r1 = r3.getTypeValue();
        r0.getClass();
        com.bytedance.android.live.liveinteract.linkcast.g.a.e(r4, r5, r1, false);
        if (r3.getTypeValue() != LinkScreenCastType.CAST_TYPE_MINI_APP.getTypeValue()) goto L5;
        com.bytedance.android.live.liveinteract.linkcast.g.a.d(r4, false);
    L5:
        g1(this);
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
