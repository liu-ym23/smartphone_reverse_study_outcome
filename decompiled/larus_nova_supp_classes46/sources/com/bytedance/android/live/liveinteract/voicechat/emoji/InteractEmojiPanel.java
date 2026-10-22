package com.bytedance.android.live.liveinteract.voicechat.emoji;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.emoji.EmojiListAdapter;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.l;
import com.bytedance.android.live.liveinteract.videotalk.emoji.s;
import com.bytedance.android.live.liveinteract.view.GuestHonorView;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemAdapter;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.e0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.f0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.h0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.m0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.u;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.v;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.w;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.room.api.report.IMiddlewareReportService;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.chatroom.model.j1;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import mz0.n;
import py.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/emoji/InteractEmojiPanel;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/s;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/q0;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/s$a;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class InteractEmojiPanel extends LinkCommonBottomDialog implements s, q0, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a {
    public static long D;
    public static final /* synthetic */ int E = 0;
    public final Context A;
    public final DataCenter B;
    public final ILinkPlayerInfoBridge C;
    public long a;
    public String b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public final IRoom i;
    public final boolean j;
    public String k;
    public IBaseUser l;
    public final com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s m;
    public x0 n;
    public final Set<Long> o;
    public ChatRoomPanelItemAdapter p;
    public EmojiListAdapter q;
    public boolean r;
    public final CompositeDisposable s;
    public int t;
    public boolean u;
    public boolean v;
    public final List<j1> w;
    public tb6.c x;
    public final b y;
    public boolean z;

    public static final class a {
        @JvmStatic
        public static void a(TalkRoomOperate r2) {
            Intrinsics.checkNotNullParameter(r2, "operation");
            if (k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L5;
            f2.b(2131914522, 0);
        L6:
            x.C0(r2);
            return;
        L5:
            f2.b(2131917298, 0);
            goto L6
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ InteractEmojiPanel a;

        public b(InteractEmojiPanel r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel, java.lang.Object] */
        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L6;
        L7:
            ?? r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r1 == null) goto L21;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L10:
            if (Looper.myLooper() == r0.getLooper()) goto L12;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        L6:
            if (r5.intValue() != 2) goto L7;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ boolean b;

        public c(Function2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            Function2 r5 = this.a;
            if (r5 == null) goto L6;
            Unit r6 = (Unit) r5.invoke(Boolean.valueOf(this.b), null);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ boolean b;

        public d(Function2 r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Function2 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r5 = (Unit) r0.invoke(Boolean.valueOf(this.b), r4);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ InteractEmojiPanel a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Ref.IntRef c;
        public final /* synthetic */ boolean d;

        public e(InteractEmojiPanel r1, Ref.ObjectRef r2, Ref.IntRef r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(InteractEmojiPanel r3) {
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

        @Override // android.view.View.OnClickListener
        public final void onClick(View r19) {
            String r2 = null;
            if (TeamFightContext.Companion.h() == false) goto L9;
            if (li0.d.g(null) == true) goto L9;
            f2.b(2131922781, 0);
            return;
        L9:
            if (this.a.C.isEnlarged() == true) goto L16;
            ArrayList<c0> r1 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
            IBaseUser r3 = this.a.C.getUser();
            Intrinsics.checkNotNull(r3);
            if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.g(r3.getIdString()) == false) goto L16;
            if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L16;
            f2.b(2131919001, 0);
            return;
        L16:
            IBaseUser r4 = this.a.C.getUser();
            if (r4 == null) goto L19;
            String r5 = r4.getIdString();
        L20:
            m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r6 == null) goto L25;
            IRoom r7 = (IRoom) r6.getValue();
            if (r7 == null) goto L25;
            String r8 = r7.getOwnerUserIdString();
        L26:
            boolean r9 = Intrinsics.areEqual(r5, r8);
            if (TextUtils.isEmpty((String) this.b.element) == true) goto L34;
            Context r11 = this.a.getContext();
            InteractEmojiPanel r10 = this.a;
            boolean r12 = r10.j;
            int r13 = r10.C.getUserPosition();
            InteractEmojiPanel r14 = this.a;
            com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m r15 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.m(r11, r12, r13, r14.i, true, Boolean.valueOf(r14.C.isEnlarged()), Boolean.valueOf(r9));
            if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L50;
            DialogLancet.handleBlockedDialogShow(r15);
        L33:
            a(this.a);
            jf0.a r16 = jf0.a.a;
            jf0.a.d(this.c.element, this.d);
            return;
        L50:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
        L32:
            DialogLancet.beforeDialogShow(r15);
            r15.show();
            DialogLancet.afterDialogShow(r15);
            goto L33
        L34:
            ArrayList<c0> r17 = com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.a;
            Context r18 = this.a.getContext();
            InteractEmojiPanel r20 = this.a;
            IRoom r21 = r20.i;
            int r22 = r20.C.getUserPosition();
            boolean r23 = this.a.C.isEnlarged();
            if (InteractEmojiPanel.N0(this.a) == false) goto L37;
            int r24 = this.c.element - 1;
        L38:
            int r110 = r24;
            IBaseUser r25 = this.a.C.getUser();
            if (r25 == null) goto L41;
            r2 = r25.getIdString();
        L41:
            com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e r26 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.e(r18, r21, r22, r23, r9, r110, r2);
            if (DialogLancet.shouldBlockDialogShow(r26) == false) goto L52;
            DialogLancet.handleBlockedDialogShow(r26);
        L46:
            a(this.a);
            jf0.a r27 = jf0.a.a;
            jf0.a.d(this.c.element, this.d);
            return;
        L52:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
        L45:
            DialogLancet.beforeDialogShow(r26);
            r26.show();
            DialogLancet.afterDialogShow(r26);
            goto L46
        L37:
            r24 = this.c.element;
        L25:
            r8 = null;
            goto L26
        L19:
            r5 = null;
            goto L20
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ InteractEmojiPanel a;
        public final /* synthetic */ IBaseUser b;

        public f(InteractEmojiPanel r1, IBaseUser r2, String r3) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r6, int r7) {
            r6.dismiss();
            if (this.b.getFollowInfo() != null) goto L5;
            return;
        L5:
            InteractEmojiPanel r8 = this.a;
            com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r9 = r8.m;
            Context r10 = r8.A;
            if (r10 == null) goto L17;
            Activity r11 = (Activity) r10;
            j r12 = this.b.getFollowInfo();
            if (r12 == null) goto L10;
            r12.getFollowStatus();
        L10:
            String r13 = this.b.getIdString();
            long r0 = this.a.i.getId();
            r9.getClass();
            Intrinsics.checkNotNullParameter(r13, "userId");
            if (r9.c == true) goto L14;
            com.bytedance.android.livesdk.user.e r2 = k.n(IMiddlewareUserService.class).user();
            com.bytedance.android.livesdk.user.m.c r14 = new com.bytedance.android.livesdk.user.m.c().c(r13);
            r14.d();
            com.bytedance.android.livesdk.user.m.c r15 = r14.e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.TALK_ROOM_INTERACT_PANEL)).f(r0);
            r15.getClass();
            r2.i(new com.bytedance.android.livesdk.user.m(r15)).subscribe(new g0(r9), new h0(r9));
        L14:
            InteractEmojiPanel r16 = this.a;
            com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r17 = r16.m;
            IRoom r18 = r16.i;
            String r1 = this.b.getIdString();
            boolean r3 = this.a.j;
            r17.getClass();
            com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.c0(r18, false, r1, r3);
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void B4() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void C0() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void E() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void H() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void M() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void O() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void P() {
    }

    public abstract int Q0();

    public abstract List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> S0();

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void T() {
    }

    public final void U0() {
        this.v = true;
        UtilityKotlinExtentionsKt.t(findViewById(2131388181));
        UtilityKotlinExtentionsKt.t(findViewById(2131371552));
        UtilityKotlinExtentionsKt.t(findViewById(2131381814));
    }

    public abstract boolean Y0();

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void b(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void b0() {
    }

    public final void b1() {
        this.v = false;
        UtilityKotlinExtentionsKt.w(findViewById(2131388181));
        UtilityKotlinExtentionsKt.w(findViewById(2131371552));
        UtilityKotlinExtentionsKt.w(findViewById(2131381814));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void e5(int r1, int r2, long r3, String r5) {
    }

    public final int getLayoutId() {
        return 2131565520;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void h0() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void l(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void s() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void w0(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void y0() {
        Intrinsics.checkNotNullParameter("link_interaction_panel_beauty", "eventPage");
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void z0(boolean r1, DataCenter r2) {
    }

    public i<ILinkPlayerInfoBridge> R0() {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkUserInfoCenter();
    }

    public final void V0() {
        x0 r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L29;
        x0 r1 = this.n;
        if (r1 == null) goto L30;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r1);
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r3 == null) goto L22;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L11:
        if (Looper.myLooper() == r2.getLooper()) goto L13;
        r2.post(DialogLancet.createDismissRunnable(r1));
        return;
    L30:
        return;
    }

    public final boolean W0() {
        if (this.r == true) goto L8;
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.b(this.C) == false) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void f() {
        IBaseUser r0 = this.l;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.j == false) goto L9;
        String r1 = "live_anchor_c_audience";
    L12:
        z0 r2 = z0.a();
        Context r3 = this.A;
        r2.getClass();
        x0.b r4 = new x0.b(r3, 4);
        r4.l(2131922752);
        r4.i(0, 2131920806, new f(this, r0, r1));
        r4.i(1, 2131915442, g.a);
        r4.n();
        return;
    L9:
        if (Intrinsics.areEqual(r0.getIdString(), this.i.getOwnerUserIdString()) == false) goto L11;
        r1 = "live_audience_c_anchor";
        goto L12
    L11:
        r1 = "live_audience_c_audience";
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void h() {
        IBaseUser r0 = this.l;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.j == false) goto L9;
        String r1 = "live_anchor_c_audience";
    L12:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r2 = this.m;
        this.i.getRequestId();
        String r3 = r0.getIdString();
        long r4 = this.i.getId();
        this.i.getLabels();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (r2.c == true) goto L16;
        r2.c = true;
        com.bytedance.android.livesdk.user.e r6 = k.n(IMiddlewareUserService.class).user();
        com.bytedance.android.livesdk.user.b.c r5 = new com.bytedance.android.livesdk.user.b.c().c(r3).e();
        r5.e();
        com.bytedance.android.livesdk.user.b.c r7 = r5.g(r1).h(r4).f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.TALK_ROOM_INTERACT_PANEL));
        r7.e();
        r6.h(new com.bytedance.android.livesdk.user.b(r7)).subscribe(new a0(r2), new b0(r2));
    L16:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r8 = this.m;
        IRoom r9 = this.i;
        String r10 = r0.getIdString();
        boolean r11 = this.j;
        r8.getClass();
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.c0(r9, true, r10, r11);
        return;
    L9:
        if (Intrinsics.areEqual(r0.getIdString(), this.i.getOwnerUserIdString()) == false) goto L11;
        r1 = "live_audience_c_anchor";
        goto L12
    L11:
        r1 = "live_audience_c_audience";
        goto L12
    }

    private final boolean a1() {
        if (je0.d.N() == false) goto L7;
        if (je0.d.w() == true) goto L7;
    L10:
        return true;
    L7:
        if (je0.d.u() == true) goto L9;
    L11:
        return false;
    L9:
        if (d0.h(this.i) == true) goto L11;
        goto L10
    }

    public final boolean X0() {
        if (W0() == false) goto L8;
        if (this.C.getRoomLinkSilenceStatus() == 1) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (this.C.getSilenceStatus() == 0) goto L10;
        return true;
    }

    @Override // ih0.d
    public final void a() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        findViewById(2131388180).setAdapter(null);
        this.p = null;
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void g() {
        if (Y0() == true) goto L6;
        f2.b(2131922751, 0);
        M0(this);
        return;
    L6:
        M0(this);
        xs2.b.a().post(new UserProfileEvent(this.l).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience").setFromInteractEmojiPanel(true).setShowSendGift(true));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void m() {
        if (Y0() == true) goto L6;
        f2.b(2131922751, 0);
        M0(this);
        return;
    L6:
        M0(this);
        Bundle r0 = new Bundle();
        r0.putString("gift_show_from", "emoji_panel");
        k.n(g50.c.class).openGiftDialog(this.l, r0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hd0.c.f().c(this.y);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hd0.c.f().e(this.y);
        this.m.detachView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ih0.d
    public final boolean p() {
        return super/*android.app.Dialog*/.isShowing();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void report() {
        if (Y0() == true) goto L6;
        f2.b(2131922751, 0);
        M0(this);
        return;
    L6:
        M0(this);
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
    L10:
        k.n(IMiddlewareReportService.class).reportWithUserProfileEvent(ReportConstant.BusinessSource.NewProfile, this.C.getUser(), r1, new UserProfileEvent(this.C.getUser()).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
        return;
    L9:
        r1 = null;
        goto L10
    }

    @Override // ih0.d
    public final void dismissDialog() {
        M0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M0(InteractEmojiPanel r3) {
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

    public static final /* synthetic */ boolean N0(InteractEmojiPanel r0) {
        return r0.a1();
    }

    private final void c1(boolean r5) {
        if (r5 == false) goto L5;
        ((TextView) findViewById(2131371590)).setVisibility(0);
        findViewById(2131388181).setVisibility(4);
        findViewById(2131381814).setVisibility(8);
        return;
    L5:
        ((TextView) findViewById(2131371590)).setVisibility(8);
        findViewById(2131388181).setVisibility(0);
    }

    private final void f1(List<? extends com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r6) {
        EmojiListAdapter r0 = this.q;
        if (r0 == null) goto L5;
        r0.y2(KotlinTypeUtilsKt.castElementType(r6));
    L5:
        int r1 = r6.size() / this.e;
        int r2 = 0;
        if ((r6.size() % this.e) <= 0) goto L8;
        int r7 = 1;
    L9:
        this.g = r1 + r7;
        findViewById(2131381814).a(this.g, this.h);
        RtlViewPagerShower r8 = findViewById(2131381814);
        if (this.g != 1) goto L12;
    L13:
        r2 = 4;
    L14:
        r8.setVisibility(r2);
        return;
    L12:
        if (((Boolean) vm2.d.n5.getValue(null, vm2.d.a[323(0x143, float:4.53E-43)])).booleanValue() == false) goto L14;
    L8:
        r7 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void A2(List<? extends j1> r2) {
        Intrinsics.checkNotNullParameter(r2, "newList");
        ((ArrayList) this.w).clear();
        ArrayList r0 = (ArrayList) this.w;
        r0.addAll(r2);
        ChatRoomPanelItemAdapter r3 = this.p;
        if (r3 == null) goto L6;
        r3.y2(S0());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void G3(Throwable r4) {
        ((GuestHonorView) findViewById(2131392518)).a(null, this.l);
        ALogger.e("ttlive_link", r4);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void GN(IFollowPair r3) {
        IBaseUser r0 = this.l;
        if (r0 == null) goto L17;
        j r1 = r0.getFollowInfo();
        if (r1 == null) goto L18;
        long r2 = r1.getFollowStatus();
        if (r3 != null) goto L9;
        return;
    L9:
        if (((int) r2) == r3.getFollowStatus()) goto L20;
        IBaseUser r4 = this.l;
        if (r4 == null) goto L13;
        r4.setFollowStatus(r3.getFollowStatus());
    L13:
        ChatRoomPanelItemAdapter r5 = this.p;
        if (r5 == null) goto L21;
        r5.y2(S0());
        return;
    L21:
        return;
    L20:
        return;
    L18:
        return;
    }

    public final void P0(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r11) {
        Intrinsics.checkNotNullParameter(r11, "panelItems");
        if (vm2.c.c() == true) goto L5;
        return;
    L5:
        Iterator r0 = ((ArrayList) r11).iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        if ((((com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r0.next()) instanceof m0) == false) goto L7;
        r0.remove();
        goto L7
    L11:
        Iterator r1 = ((ArrayList) this.w).iterator();
        int r2 = 0;
    L13:
        if (r1.hasNext() == false) goto L18;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        ListProtector.add(r11, r2, new m0(this, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.c((j1) r3)));
        r2 = r4;
        goto L13
    L18:
        List<j1> r12 = this.w;
        if (this.z == true) goto L57;
        Iterator r13 = ((ArrayList) r12).iterator();
    L23:
        if (r13.hasNext() == false) goto L58;
        List r5 = ((j1) r13.next()).getLinkmicEntranceList();
        Object r6 = null;
        if (r5 == null) goto L36;
        Iterator r7 = r5.iterator();
    L28:
        if (r7.hasNext() == false) goto L35;
        Object r8 = r7.next();
        if (ILinkmicInteractEntrance.LinkmicInteractEntranceID.LINKMIC_INTERACT_ENTRANCE_ID_GUEST_LINK_INVITE.getValue() != ((ILinkmicInteractEntrance) r8).getEntranceId()) goto L32;
        boolean r9 = true;
    L33:
        if (r9 == false) goto L28;
        r6 = r8;
        goto L35
    L32:
        r9 = false;
    L35:
        r6 = (ILinkmicInteractEntrance) r6;
    L36:
        if (r6 == null) goto L23;
        this.z = true;
        int r14 = tb6.a.a;
        Intrinsics.checkNotNullParameter("audience_interact", "requestPage");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("user_id", nd0.e.a());
        r15.put("user_type", tb6.b.a());
        r15.put("request_page", "audience_interact");
        n r10 = new n();
        Map r16 = r10.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r15, "map");
        r16.putAll(r15);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        r17.b(LogCommon.PAGE_SOURCE_LOG);
        List r18 = r10.b;
        ArrayList r19 = (ArrayList) r18;
        r19.addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r110 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((f80.a) r111).w3("livesdk_chatroom_audiencelink_icon_show", r10.a, r10.b);
        return;
    L58:
        return;
    }

    public final String T0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "targetUserId");
        i<ILinkPlayerInfoBridge> r0 = R0();
        if (r0 != null) goto L5;
        return "";
    L5:
        IBaseUser r5 = r0.c5(r4);
        if (r5 != null) goto L9;
        return "";
    L9:
        if (r5.getNickName().length() <= 10) goto L16;
        StringBuilder r1 = new StringBuilder();
        String r6 = r5.getNickName();
        if (r6 == null) goto L14;
        r1.append(r6.substring(0, 10));
        r1.append("...");
        return r1.toString();
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L16:
        return r5.getNickName();
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void U2(Throwable r2) {
        if ((r2 instanceof ApiServerException) == false) goto L5;
        IESUIUtils.displayToast(this.A, ((ApiServerException) r2).getPrompt());
        return;
    L5:
        f2.b(2131919727, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void c0(TalkRoomBaseDynamicEmoji r5) {
        Intrinsics.checkNotNullParameter(r5, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r6 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) com.bytedance.android.live.base.model.m.b(r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j.class);
        if (r6 != null) goto L5;
        return;
    L5:
        IBaseUser r0 = this.l;
        if (r0 == null) goto L8;
        String r1 = r0.getIdString();
    L9:
        i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.k(this.j, this.k, r6, false);
        if (r6.getEmojiCategory() != 7) goto L13;
        TalkRoomLogUtils.k1("emoji_panel_guest", r1);
        return;
    L13:
        return;
    L8:
        r1 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e1(int r4) {
        if (this.n != null) goto L5;
        Context r0 = getContext();
        x0.d r1 = new x0.d();
        r1.b = r0;
        r1.a = 2;
        r1.d = r0.getText(r4);
        r1.k = false;
        this.n = new x0(r1.b, r1);
    L5:
        x0 r5 = this.n;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isShowing() == true) goto L21;
        x0 r6 = this.n;
        if (r6 != null) goto L12;
        return;
    L12:
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void j0(TalkRoomBaseDynamicEmoji r14) {
        Intrinsics.checkNotNullParameter(r14, "emoji");
        IBaseUser r1 = this.l;
        if (r1 == null) goto L43;
        String r10 = r1.getIdString();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r14.emojiCategory != 7) goto L11;
        i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.j1("emoji_panel_guest", r10);
    L11:
        if (Y0() == true) goto L14;
        f2.b(2131922751, 0);
        M0(this);
        return;
    L14:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r15 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) com.bytedance.android.live.base.model.m.b(r14, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j.class);
        if (r15 != null) goto L17;
        return;
    L17:
        i0 r3 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.j(r15, this.j, false, this.k);
        l r4 = r15.getEmojiPermission();
        String r5 = null;
        if (r4 == null) goto L20;
        String r6 = r4.schemaJumpUrl;
    L22:
        if (TextUtils.isEmpty(r6) == true) goto L28;
        IBaseLiveActionHandler r0 = k.n(IBaseLiveActionHandler.class);
        Context r7 = getContext();
        l r16 = r15.getEmojiPermission();
        if (r16 == null) goto L26;
        r5 = r16.schemaJumpUrl;
    L26:
        r0.handle(r7, r5);
        M0(this);
        return;
    L28:
        l r8 = r15.getEmojiPermission();
        if (r8 != null) goto L31;
    L36:
        D = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r9 = this.m;
        long r11 = this.i.getId();
        int r12 = je0.d.f();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r15, "emoji");
        Intrinsics.checkNotNullParameter(r10, "toUserId");
        if (r9.b == false) goto L39;
        return;
    L39:
        if ((System.currentTimeMillis() - r9.d) < 1000) goto L46;
        r9.b = true;
        r9.d = System.currentTimeMillis();
        long r13 = System.currentTimeMillis();
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendTalkRoomInteractEmoji(r11, r15.getEmojiId(), r12, 2, r10, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new e0(r9, r15, r13), new f0(r9, r15, r13));
        return;
    L46:
        return;
    L31:
        if (r8.hasPermission != true) goto L36;
        if ((System.currentTimeMillis() - D) >= this.a) goto L36;
        f2.c(this.b, 0);
        return;
    L20:
        r6 = null;
        goto L22
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void j8(Throwable r7) {
        Intrinsics.checkNotNullParameter(r7, "throwable");
        UtilityKotlinExtentionsKt.t(findViewById(2131378151));
        tb6.c r0 = this.x;
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r1 = null;
        if (r0 == null) goto L7;
        i97.a r2 = i97.a.a;
        r0.c = System.currentTimeMillis() - r0.a;
        r0.e = false;
        tb6.c r3 = r0.b();
        if (r3 == null) goto L7;
        r3.c("emoji_panel_type");
        Unit r4 = Unit.INSTANCE;
        this.x = null;
    L7:
        String r5 = (String) new com.bytedance.android.livesdk.sharedpref.e("interact_emoji_list", "").getValue();
        if (StringUtils.isEmpty(r5) == true) goto L11;
        r1 = ((com.bytedance.android.live.liveinteract.videotalk.emoji.model.k) GsonProtectorUtils.fromJson(GsonHelper.get(), r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.k.class)).getEmojiList();
    L11:
        if (r1 == null) goto L13;
        f1(r1);
    L13:
        EmojiListAdapter r6 = this.q;
        if (r6 != null) goto L16;
    L18:
        x.j(r7, true);
        return;
    L16:
        if (r6.getItemCount() != 0) goto L18;
        c1(true);
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void j9(List<? extends ILinkmicInteractEntrance> r4) {
        Intrinsics.checkNotNullParameter(r4, "newList");
        IBaseUser r0 = this.l;
        i<ILinkPlayerInfoBridge> r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getIdString();
    L6:
        if (r2 != null) goto L13;
        IBaseUser r3 = this.l;
        if (r3 == null) goto L10;
        String r5 = r3.getIdString();
    L12:
        if (r2.a(r5) == true) goto L13;
    L31:
        ChatRoomPanelItemAdapter r6 = this.p;
        if (r6 == null) goto L35;
        r6.y2(S0());
        return;
    L35:
        return;
    L10:
        r5 = null;
    L13:
        IInteractService r7 = (IInteractService) k.f(IInteractService.class);
        if (r7 == null) goto L16;
        i<ILinkPlayerInfoBridge> r8 = r7.getLinkUserInfoCenter();
    L18:
        if ((r8 instanceof y) == false) goto L21;
        r1 = r8;
    L21:
        y r9 = (y) r1;
        if (r9 == null) goto L31;
        Map<String, List<ILinkmicInteractEntrance>> r10 = r9.E;
        if (r10 == null) goto L31;
        IBaseUser r11 = this.l;
        if (r11 == null) goto L29;
        String r12 = r11.getIdString();
        if (r12 == null) goto L29;
    L30:
        List<ILinkmicInteractEntrance> r13 = r10.put(r12, CollectionsKt.toMutableList(r4));
    L29:
        r12 = "";
        goto L30
    L16:
        r8 = null;
        goto L18
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r21) {
        super.onCreate(r21);
        int r1 = com.bytedance.android.live.liveinteract.videotalk.utils.f.a;
        com.bytedance.android.live.liveinteract.videotalk.utils.f.a(this.i);
        UtilityKotlinExtentionsKt.w(findViewById(2131388939));
        TextView r2 = (TextView) findViewById(2131388939);
        Object[] r3 = new Object[1];
        IBaseUser r4 = this.l;
        if (r4 == null) goto L5;
        String r5 = r4.getRealNickName();
    L6:
        boolean r6 = false;
        r3[0] = r5;
        r2.setText(s1.C(2131922750, r3));
        ((TextView) findViewById(2131385960)).post(new com.bytedance.android.live.liveinteract.voicechat.emoji.c(this));
        a1.o(findViewById(2131388180), UtilityKotlinExtentionsKt.i(56));
        UtilityKotlinExtentionsKt.t(findViewById(2131390995));
        UtilityKotlinExtentionsKt.t(findViewById(2131375128));
        UtilityKotlinExtentionsKt.t(findViewById(2131392518));
        UtilityKotlinExtentionsKt.w(findViewById(2131378151));
        this.p = new ChatRoomPanelItemAdapter(CollectionsKt.toMutableList(S0()));
        findViewById(2131388180).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        findViewById(2131388180).setAdapter(this.p);
        findViewById(2131388180).setHasFixedSize(true);
        EmojiListAdapter r7 = new EmojiListAdapter(this.c, this.d, UIUtils.getScreenWidth(getContext()));
        this.q = r7;
        Intrinsics.checkNotNullParameter(this, "listener");
        r7.c = this;
        findViewById(2131388181).setLayoutManager(new SSGridLayoutManager(getContext(), this.c, 0));
        findViewById(2131388181).setAdapter(this.q);
        findViewById(2131388181).setHasFixedSize(true);
        findViewById(2131388181).setItemViewCacheSize(this.e * 2);
        findViewById(2131388181).getLayoutParams().height = this.c * s1.j(2131168802);
        findViewById(2131388181).setClipChildren(false);
        findViewById(2131388181).setClipToPadding(false);
        GridPagerSnapHelper r8 = new InteractEmojiPanel$attachSnapHelper$snapHelper$1(this);
        r8.h(this.c);
        r8.g(this.d);
        r8.attachToRecyclerView(findViewById(2131388181));
        findViewById(2131388181).addOnScrollListener(new InteractEmojiPanel$attachSnapHelper$1(this));
        findViewById(2131381814).setMargin(s1.j(2131168969));
        RtlViewPagerShower r9 = findViewById(2131381814);
        Drawable r10 = s1.m(2131250379);
        Drawable r11 = s1.m(2131250380);
        r9.c = r10;
        r9.d = r11;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r12 = this.m;
        ((q46.b) r12).a = this;
        long r13 = this.i.getId();
        int r14 = je0.d.f();
        int r15 = Q0();
        IBaseUser r16 = this.l;
        if (r16 == null) goto L9;
        String r17 = r16.getIdString();
    L10:
        long r18 = System.currentTimeMillis();
        r12.e.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getTalkRoomEmojiList(r13, r14, 2, r15, r17).compose(RxUtil.rxSchedulerHelper()).subscribe(new w(r12, r14, r15, r18), new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x(r12, r14, r15, r18)));
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r19 = this.m;
        IRoom r20 = this.i;
        IBaseUser r22 = this.l;
        Function1<IBaseUser, Unit> r23 = new AnonymousClass1(this);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r23, "onSuccess");
        String r24 = "";
        if (r22 == null) goto L23;
        HashMap r110 = new HashMap();
        r110.put("target_uid", r22.getIdString());
        r110.put("user_open_id", r22.getIdString());
        r110.put("current_room_id", String.valueOf(r20.getId()));
        r110.put("packed_level", String.valueOf(2));
        r110.put("request_from", "admin");
        Intrinsics.checkNotNullParameter(r22, "$this$secUidExt");
        String r25 = r22.getCastSecUid();
        if (r25 != null) goto L16;
        r25 = "";
    L16:
        r110.put("sec_target_uid", r25);
        IInteractService r26 = (IInteractService) k.f(IInteractService.class);
        if (r26 != null) goto L19;
    L21:
        RxUtilKt.c(k.n(IMiddlewareUserService.class).user().d(r110).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c0(r23), com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d0.a), r19.e);
        goto L23
    L19:
        if (r26.isAnonymousUser(r22.getIdString()) != true) goto L21;
        r110.put("target_display_role", String.valueOf(2));
    L23:
        if (com.bytedance.android.live.liveinteract.videotalk.utils.f.a(this.i) == false) goto L32;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s r27 = this.m;
        long r111 = this.i.getId();
        IBaseUser r28 = this.l;
        if (r28 == null) goto L30;
        String r29 = r28.getIdString();
        if (r29 == null) goto L30;
        String r112 = r29;
    L31:
        r27.getClass();
        Intrinsics.checkNotNullParameter(r112, "targetUserId");
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).contributeShow(r111, d5.c(r112), r112, 0, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new u(r27), new v(r27));
    L30:
        r112 = "";
    L32:
        boolean r30 = this.j;
        String r31 = this.k;
        je0.d.y();
        TalkRoomLogUtils.l(r30, r31, false);
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r32 = IVoiceChatAdminService.a.a();
        if (r32 == null) goto L37;
        MuteStateChecker r33 = r32.muteChecker();
        if (r33 == null) goto L37;
        r33.a("guest_panel", false);
    L37:
        boolean r34 = k.n(IMiddlewareUserService.class).user().c();
        boolean r35 = k.n(IMiddlewareUserService.class).user().t(Long.valueOf(this.i.getRoomId()));
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a() == true) goto L40;
    L209:
        tb6.c r36 = this.x;
        if (r36 == null) goto L223;
        i97.a r37 = i97.a.a;
        r36.b = System.currentTimeMillis() - r36.a;
        tb6.c r38 = r36.b();
        if (r38 == null) goto L224;
        r38.c("emoji_panel_type");
        Unit r39 = Unit.INSTANCE;
        this.x = null;
        return;
    L224:
        return;
    L223:
        return;
    L40:
        if (this.j == true) goto L43;
        if (r34 == true) goto L43;
        if (r35 == false) goto L209;
    L43:
        y r40 = (y) ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (this.C.isEnlarged() == false) goto L59;
        Integer r41 = je0.d.h();
        if (r41 != null) goto L49;
    L50:
        Integer r42 = je0.d.h();
        if (r42 == null) goto L59;
        if (r42.intValue() != 112) goto L59;
    L56:
        if (this.t != 0) goto L59;
        this.t = this.C.getUserPosition();
        goto L59
    L49:
        if (r41.intValue() == 6) goto L56;
    L59:
        if (this.C.isEnlarged() == true) goto L88;
        Integer r43 = je0.d.h();
        if (r43 != null) goto L64;
    L65:
        Integer r44 = je0.d.h();
        if (r44 == null) goto L88;
        if (r44.intValue() != 112) goto L88;
    L71:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.d() == false) goto L88;
        int r45 = this.t - 1;
        IInteractService r46 = (IInteractService) k.f(IInteractService.class);
        if (r46 == null) goto L85;
        i<ILinkPlayerInfoBridge> r47 = r46.getLinkUserInfoCenter();
        if (r47 == null) goto L85;
        Iterable r48 = r47.getOnlineUserList();
        if (r48 == null) goto L85;
        Iterator r49 = r48.iterator();
    L81:
        if (r49.hasNext() == false) goto L85;
        ILinkPlayerInfoBridge r113 = (ILinkPlayerInfoBridge) r49.next();
        if (r113.isEnlarged() == false) goto L81;
        int r50 = r113.getUserPosition();
    L86:
        if (r45 >= r50) goto L88;
        this.t--;
    L85:
        r50 = -1;
        goto L86
    L64:
        if (r43.intValue() == 6) goto L71;
    L88:
        Ref.IntRef r51 = new Ref.IntRef();
        int r52 = this.t;
        if (r52 != (-1)) goto L92;
        r52 = this.C.getUserPosition();
    L92:
        r51.element = r52;
        Ref.ObjectRef r53 = new Ref.ObjectRef();
        r53.element = "";
        if (r40 == null) goto L112;
        Iterator<LinkmicPositionItem> r54 = r40.e.iterator();
    L96:
        if (r54.hasNext() == false) goto L103;
        LinkmicPositionItem r114 = r54.next();
        if (((int) r114.getPosition()) != this.C.getUserPosition()) goto L100;
        boolean r115 = true;
    L101:
        if (r115 == false) goto L96;
    L104:
        LinkmicPositionItem r116 = r114;
        if (r116 == null) goto L112;
        String r55 = r116.getActiveName();
        if (r55 == null) goto L110;
        r24 = r55;
    L110:
        r53.element = r24;
        goto L112
    L100:
        r115 = false;
        goto L101
    L103:
        r114 = null;
    L112:
        if (a1() == false) goto L114;
        int r56 = r51.element - 1;
    L116:
        if (a1() == false) goto L119;
        r56 = r56 + 1;
    L119:
        if (je0.d.s() == true) goto L124;
        if (je0.d.M() == true) goto L124;
        UtilityKotlinExtentionsKt.w(findViewById(2131385960));
    L124:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f() == false) goto L128;
        TextView r57 = (TextView) findViewById(2131385960);
        if (r57 == null) goto L128;
        UtilityKotlinExtentionsKt.t(r57);
    L128:
        Integer r58 = je0.d.h();
        if (r58 == null) goto L131;
        int r59 = r58.intValue();
    L133:
        if (r59 != 109) goto L135;
    L141:
        boolean r60 = true;
    L142:
        if (r60 == false) goto L146;
        TextView r61 = (TextView) findViewById(2131385960);
        if (r61 == null) goto L146;
        UtilityKotlinExtentionsKt.t(r61);
    L146:
        int r62 = c1.a;
        if (c1.a(0, je0.d.h()) == false) goto L152;
        TextView r63 = (TextView) findViewById(2131385960);
        if (r63 == null) goto L152;
        UtilityKotlinExtentionsKt.t(r63);
    L152:
        if (je0.d.P() == false) goto L157;
        TextView r65 = (TextView) findViewById(2131385960);
        if (r65 == null) goto L157;
        UtilityKotlinExtentionsKt.t(r65);
    L157:
        if (je0.d.N() == true) goto L159;
    L161:
        int r66 = r56 + 1;
    L162:
        if (r66 == 0) goto L164;
        TextView r67 = (TextView) findViewById(2131385960);
        if (r67 == null) goto L175;
        r67.setText(s1.C(2131919007, new Object[]{String.valueOf(r66)}));
    L175:
        IInteractService r68 = (IInteractService) k.n(IInteractService.class);
        Integer r69 = je0.d.h();
        if (r69 == null) goto L178;
        int r70 = r69.intValue();
    L180:
        if (r68.isVoiceMultiEnlargeSeat(r70, r56) == false) goto L184;
        TextView r71 = (TextView) findViewById(2131385960);
        if (r71 == null) goto L184;
        r71.setText(s1.B(2131919004));
    L184:
        Integer r72 = je0.d.h();
        if (r72 != null) goto L188;
    L208:
        ((TextView) findViewById(2131385960)).setOnClickListener(new e(this, r53, r51, r34));
        goto L209
    L188:
        if (r72.intValue() != 28) goto L208;
        HamletAvatarContext r73 = HamletAvatarContext.Companion.getContext();
        if (r73 == null) goto L197;
        com.bytedance.live.datacontext.j<gd0.g> r74 = r73.getHamletAvatarService();
        if (r74 == null) goto L197;
        gd0.g r75 = (gd0.g) r74.getValue();
        if (r75 == null) goto L197;
        r6 = r75.I6();
    L197:
        if (this.C.isEnlarged() == true) goto L205;
        if (r6 == false) goto L208;
        IBaseUser r76 = this.C.getUser();
        if (r76 == null) goto L202;
        String r77 = r76.getIdString();
    L204:
        if (Intrinsics.areEqual(r77, this.i.getOwnerUserIdString()) == false) goto L208;
    L202:
        r77 = null;
    L205:
        TextView r78 = (TextView) findViewById(2131385960);
        if (r78 == null) goto L208;
        UtilityKotlinExtentionsKt.t(r78);
        goto L208
    L178:
        r70 = 0;
        goto L180
    L164:
        if (gh0.a.d() == true) goto L169;
        if (r35 == true) goto L169;
        TextView r79 = (TextView) findViewById(2131385960);
        if (r79 == null) goto L169;
        UtilityKotlinExtentionsKt.t(r79);
    L169:
        TextView r80 = (TextView) findViewById(2131385960);
        if (r80 == null) goto L175;
        r80.setText(s1.B(2131919005));
        goto L175
    L159:
        if (je0.d.w() == true) goto L161;
        r66 = r56;
        goto L162
    L135:
        if (r59 == 110) goto L141;
        if (r59 == 111) goto L141;
        if (r59 == 112) goto L141;
        r60 = false;
        goto L142
    L131:
        r59 = 0;
        goto L133
    L114:
        r56 = r51.element;
        goto L116
    L9:
        r17 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void q4(com.bytedance.android.live.liveinteract.voicechat.model.a r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        w8 r11 = r10.a();
        String r1 = null;
        if ((r11 instanceof w8) == true) goto L5;
        r11 = null;
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        vlc.d r0 = (vlc.d) this.B.get("data_message_manager", null);
        r11.setCurrUserIsAnchor(this.j);
        if (r0 == null) goto L10;
        r0.B((tlc.d) r11);
    L10:
        boolean r3 = this.j;
        String r4 = this.k;
        int r5 = je0.d.f();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r6 = r11.getDynamicEmojiFlex();
        IBaseUser r2 = r11.getToUser();
        if (r2 == null) goto L13;
        String r7 = r2.getIdString();
    L14:
        IBaseUser r12 = r11.getToUser();
        if (r12 == null) goto L17;
        r1 = r12.getIdString();
    L17:
        TalkRoomLogUtils.m(r3, r4, r5, r6, r7, Boolean.valueOf(Intrinsics.areEqual(r1, this.i.getOwnerUserIdString())));
        M0(this);
        return;
    L13:
        r7 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void ta(ContributeShowResponse.OwnerHonorInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        ((GuestHonorView) findViewById(2131392518)).a(r3, this.l);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void up(com.bytedance.android.live.liveinteract.videotalk.emoji.model.k r9) {
        Intrinsics.checkNotNullParameter(r9, "response");
        UtilityKotlinExtentionsKt.t(findViewById(2131378151));
        tb6.c r0 = this.x;
        boolean r1 = true;
        if (r0 == null) goto L8;
        i97.a r2 = i97.a.a;
        r0.c = System.currentTimeMillis() - r0.a;
        r0.e = true;
        tb6.c r3 = r0.b();
        if (r3 == null) goto L8;
        r3.c("emoji_panel_type");
        Unit r4 = Unit.INSTANCE;
        this.x = null;
    L8:
        if (this.v == false) goto L11;
        UtilityKotlinExtentionsKt.t(findViewById(2131388181));
        return;
    L11:
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r5 = r9.getEmojiList();
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r6 = r5;
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        c1(true);
    L22:
        if (r9.getSendLimitTime() <= 1000) goto L24;
        long r8 = r9.getSendLimitTime();
    L25:
        this.a = r8;
        String r10 = r9.getSendLimitDesc();
        if (r10 != null) goto L28;
    L31:
        if (r1 == true) goto L34;
        this.b = r9.getSendLimitDesc();
        return;
    L34:
        return;
    L28:
        if (r10.length() == 0) goto L31;
        r1 = false;
        goto L31
    L24:
        r8 = 1000;
        goto L25
    L20:
        c1(false);
        f1(r5);
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("interact_emoji_list", ""), GsonProtectorUtils.toJson(GsonHelper.get(), r9));
        goto L22
    L14:
        if (r6.isEmpty() == true) goto L17;
        r7 = false;
        goto L18
    }

    @Override // ih0.a
    public final void v0(int r1) {
        this.t = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s.a
    public final void za(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if ((r2 instanceof ApiServerException) == false) goto L5;
        f2.c(((ApiServerException) r2).getPrompt(), 0);
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r2);
        M0(this);
    }

    public static final void O0(InteractEmojiPanel r1, int r2) {
        int r3 = r2 / r1.e;
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= r1.g) goto L10;
        r1.h = r3;
        r1.findViewById(2131381814).b(r1.h);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void L(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r3, VideoShowMode r4) {
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        Intrinsics.checkNotNullParameter(r4, "selectMode");
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        Intrinsics.checkNotNullParameter(r4, "selectMode");
    }

    public InteractEmojiPanel(Context r3, DataCenter r4, ILinkPlayerInfoBridge r5) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "userInfo");
        super(r3);
        this.A = r3;
        this.B = r4;
        this.C = r5;
        this.a = 1000;
        this.b = s1.B(2131922729);
        if (((Boolean) vm2.d.n5.getValue(null, vm2.d.a[323(0x143, float:4.53E-43)])).booleanValue() == false) goto L5;
        int r6 = 1;
    L6:
        this.c = r6;
        this.d = 6;
        this.e = r6 * 6;
        this.i = com.bytedance.android.live.core.utils.a0.n(r4);
        this.j = com.bytedance.android.live.core.utils.a0.d(r4, false);
        this.k = "seat";
        this.l = r5.getUser();
        this.m = new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s();
        this.o = new LinkedHashSet();
        this.s = new CompositeDisposable();
        this.t = -1;
        this.w = new ArrayList();
        this.x = new tb6.c();
        this.y = new b(this);
        return;
    L5:
        r6 = 2;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void H0(LinkScreenCastType r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "castType");
        Intrinsics.checkNotNullParameter(r5, "appId");
        Intrinsics.checkNotNullParameter(r6, "appName");
        Intrinsics.checkNotNullParameter(r4, "castType");
        Intrinsics.checkNotNullParameter(r5, "appId");
        Intrinsics.checkNotNullParameter(r6, "appName");
    }

    public static void Z0(long r7, long r9, boolean r11, CompositeDisposable r12, Function2 r13) {
        Intrinsics.checkNotNullParameter(r12, "disposable");
        if (r11 == false) goto L5;
        Single<com.bytedance.android.live.network.response.e<r1>> r8 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silenceLinkRoom(r7, r9, 2);
    L6:
        r12.add(r8.compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r13, r11), new d(r13, r11)));
        return;
    L5:
        r8 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilenceLinkRoom(r7, r9, 1);
        goto L6
    }
}
