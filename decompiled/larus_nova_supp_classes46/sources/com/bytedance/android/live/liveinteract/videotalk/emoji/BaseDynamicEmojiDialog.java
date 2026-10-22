package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.view.GuestHonorView;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.MuteStateChecker;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.ChatRoomPanelItemAdapter;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.m0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.j1;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.config.o60;
import com.bytedance.android.livesdk.config.w60;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.LiveChatRoomPanelBannerLynxConfig;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/emoji/BaseDynamicEmojiDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/d$a;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/s;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/panel/q0;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseDynamicEmojiDialog extends LinkCommonBottomDialog implements com.bytedance.android.live.liveinteract.videotalk.emoji.d.a, s, q0 {
    public tb6.c A;
    public g B;
    public final f C;
    public final DataCenter D;
    public final boolean E;
    public final int a;
    public final int b;
    public long c;
    public String d;
    public final rj0.g e;
    public ChatRoomPanelItemAdapter f;
    public EmojiListAdapter g;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.d h;
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> i;
    public x0 j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public long p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public String u;
    public IRoom v;
    public final List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> w;
    public com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g x;
    public final CompositeDisposable y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ BaseDynamicEmojiDialog a;

        public b(BaseDynamicEmojiDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r10v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, java.lang.Object] */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            if (s0.b() == false) goto L5;
            this.a.b1();
        L10:
            if (r10 == null) goto L12;
            r10.dismiss();
        L12:
            ?? r12 = this.a;
            Handler r13 = DialogLancet.resolveDialogHandler(r12);
            if (r13 != null) goto L15;
        L17:
            DialogLancet.beforeDialogDismiss(r12);
            r12.dismiss();     // Catch: Throwable -> L20 Exception -> L22
        L26:
            DialogLancet.afterDialogDismiss(r12);
            return;
        L20:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r12);
            throw th;
        L22:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L20
            Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L20
            if (r14 == null) goto L26;
            com.bytedance.crash.d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L20
            goto L26
        L15:
            if (Looper.myLooper() == r13.getLooper()) goto L17;
            r13.post(DialogLancet.createDismissRunnable(r12));
            return;
        L5:
            int r15 = TalkRoomFeedbackDialog.r;
            int r0 = je0.d.f();
            BaseDynamicEmojiDialog r16 = this.a;
            TalkRoomFeedbackDialog r17 = TalkRoomFeedbackDialog.a.a(r0, r16.n, r16.u, null, false, null, null, null, 1016);
            FragmentActivity r1 = ContextUtil.contextToFragmentActivity(this.a.getContext());
            Intrinsics.checkNotNull(r1);
            FragmentManager r2 = r1.getSupportFragmentManager();
            LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, "TalkRoomFeedbackDialog", r3);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r17, r3) == true) goto L10;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
        L9:
            r17.show(r2, "TalkRoomFeedbackDialog");
            goto L10
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
            if (r1 == null) goto L5;
            r1.dismiss();
            return;
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ ChatMatchViewModel a;
        public final /* synthetic */ BaseDynamicEmojiDialog b;

        public d(ChatMatchViewModel r1, BaseDynamicEmojiDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r7v1, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, java.lang.Object] */
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r7, int r8) {
            IRoom r1 = this.b.v;
            if (r1 == null) goto L5;
            ChatMatchViewModel.startMatch$default(this.a, r1, false, 0, 6, null);
        L5:
            ChatMatchViewModel.showMatchDialog$default(this.a, false, 1, null);
            if (r7 == null) goto L8;
            r7.dismiss();
        L8:
            ?? r9 = this.b;
            Handler r10 = DialogLancet.resolveDialogHandler(r9);
            if (r10 != null) goto L11;
        L13:
            DialogLancet.beforeDialogDismiss(r9);
            r9.dismiss();     // Catch: Throwable -> L16 Exception -> L18
        L22:
            DialogLancet.afterDialogDismiss(r9);
            return;
        L18:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
            Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
            if (r11 == null) goto L22;
            com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r9);
            throw th;
        L11:
            if (Looper.myLooper() == r10.getLooper()) goto L13;
            r10.post(DialogLancet.createDismissRunnable(r9));
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            if (r1 == null) goto L5;
            r1.dismiss();
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ BaseDynamicEmojiDialog a;

        public f(BaseDynamicEmojiDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v4, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.videotalk.emoji.BaseDynamicEmojiDialog, java.lang.Object] */
        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 == null) goto L8;
            if (r5.intValue() != 2) goto L8;
            return;
        L8:
            if (hd0.c.f().i() == true) goto L30;
            ?? r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r1 == null) goto L23;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L12:
            if (Looper.myLooper() == r0.getLooper()) goto L14;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class g extends ka0.a {
        public final /* synthetic */ ViewGroup c;

        public final void a(HybridCard r1, String r2) {
            ViewGroup r3 = this.c;
            if (r3 == null) goto L6;
            r3.setVisibility(8);
            return;
        }

        public final void b(HybridCard r1, View r2, int r3) {
            ViewGroup r4 = this.c;
            if (r4 == null) goto L5;
            r4.removeAllViews();
        L5:
            ViewGroup r5 = this.c;
            if (r5 == null) goto L8;
            r5.addView(r1);
        L8:
            ViewGroup r6 = this.c;
            if (r6 == null) goto L12;
            r6.setVisibility(0);
            return;
        }

        public g(ViewGroup r1, Context r2, Uri r3, int r4) {
            this.c = r1;
            super(r2, r3, r4);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void B4() {
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
    public void O() {
    }

    public abstract void O0();

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void P() {
    }

    public abstract void P0();

    public abstract void Q0();

    public abstract void R0();

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void T() {
    }

    public abstract boolean T0();

    public int V0(int r1) {
        return r1;
    }

    public abstract void W0();

    public abstract void Y0();

    public abstract void Z0();

    public boolean a1() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void b(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void b0() {
    }

    public abstract void b1();

    public abstract void c1();

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void e5(int r1, int r2, long r3, String r5) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void f() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void g() {
    }

    public final int getLayoutId() {
        return 2131565454;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void h() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void h0() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void l(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void m() {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void report() {
    }

    @Override // ih0.a
    public final void v0(int r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void w0(boolean r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void z0(boolean r1, DataCenter r2) {
    }

    public boolean S0() {
        if (this.n == true) goto L11;
        com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.util.d.a.a() == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r0 = false;
        goto L8
    L11:
        return false;
    }

    public int U0() {
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        if (com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.b() == false) goto L5;
        return 5;
    L5:
        return 1;
    }

    public final void X0() {
        x0 r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L27;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r2 == null) goto L20;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L9:
        if (Looper.myLooper() == r1.getLooper()) goto L11;
        r1.post(DialogLancet.createDismissRunnable(r0));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void disconnect() {
        String r0 = this.u;
        je0.d.y();
        TalkRoomLogUtils.B(r0, je0.d.Z());
        M0(this);
        TeamFightContext.a r1 = TeamFightContext.Companion;
        if (r1.f() == false) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.multiscene.a r2 = r1.b();
        if (r2 == null) goto L52;
        Intrinsics.checkNotNullParameter(r2, "$this$isSelfLastTeamPlayer");
        com.bytedance.android.live.liveinteract.multiscene.j r3 = li0.d.i(r2);
        String r5 = "";
        if (r3 == null) goto L24;
        List<com.bytedance.android.live.liveinteract.multiscene.f> r6 = r3.getPlayers();
        if (r6 == null) goto L24;
        if (r6.size() != 1) goto L24;
        List<com.bytedance.android.live.liveinteract.multiscene.f> r4 = r3.getPlayers();
        if (r4 == null) goto L20;
        com.bytedance.android.live.liveinteract.multiscene.f r7 = (com.bytedance.android.live.liveinteract.multiscene.f) ListProtector.get(r4, 0);
        if (r7 == null) goto L20;
        String r8 = r7.getUserIdString();
        if (r8 == null) goto L20;
    L22:
        if (Intrinsics.areEqual(r8, je0.d.b0()) == false) goto L24;
    L40:
        boolean r9 = true;
    L42:
        if (r9 != true) goto L52;
        j0.a r10 = new j0.a(getContext());
        com.bytedance.android.live.liveinteract.multiscene.a r11 = r1.b();
        if (r11 == null) goto L48;
        Intrinsics.checkNotNullParameter(r11, "$this$selfTeamId");
        if (com.bytedance.android.live.liveinteract.multiscene.b.c(r11, je0.d.b0()) != 1) goto L48;
        String r12 = s1.B(2131922805);
    L49:
        r10.a = s1.C(2131922783, new Object[]{r12, r12});
        r10.c = s1.B(2131915442);
        r10.b = c.a;
        r10.e = s1.B(2131915913);
        r10.d = new b(this);
        r10.c();
        return;
    L48:
        r12 = s1.B(2131922777);
    L20:
        r8 = "";
    L24:
        com.bytedance.android.live.liveinteract.multiscene.j r13 = li0.d.a(r2);
        if (r13 == null) goto L41;
        List<com.bytedance.android.live.liveinteract.multiscene.f> r14 = r13.getPlayers();
        if (r14 == null) goto L41;
        if (r14.size() != 1) goto L41;
        List<com.bytedance.android.live.liveinteract.multiscene.f> r15 = r13.getPlayers();
        if (r15 == null) goto L39;
        com.bytedance.android.live.liveinteract.multiscene.f r16 = (com.bytedance.android.live.liveinteract.multiscene.f) ListProtector.get(r15, 0);
        if (r16 == null) goto L39;
        String r17 = r16.getUserIdString();
        if (r17 == null) goto L39;
        r5 = r17;
    L39:
        if (Intrinsics.areEqual(r5, je0.d.b0()) == true) goto L40;
    L41:
        r9 = false;
    L52:
        if (s0.b() == true) goto L54;
    L57:
        c1();
        return;
    L54:
        if (y.c() == true) goto L57;
        b1();
        return;
    L5:
        if (r1.e() == false) goto L52;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dismiss() {
        ALogger.w("ttlive_link", "self panel dismissed");
        findViewById(2131388180).setAdapter(null);
        this.f = null;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void k() {
        String r0 = this.u;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r1 = IVoiceChatAdminService.a.a();
        if (r1 == null) goto L5;
        r1.isKtvOn();
    L5:
        TalkRoomLogUtils.z(r0, je0.d.Z(), je0.d.b0());
        g1(2131919829);
        com.bytedance.android.live.liveinteract.videotalk.emoji.d r2 = this.h;
        if (r2 == null) goto L14;
        long r3 = this.p;
        String r4 = je0.d.b0();
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        if (r2.c == true) goto L14;
        r2.c = true;
        VoiceChatMuteManager r5 = com.bytedance.android.live.liveinteract.videotalk.emoji.d.c0();
        if (r5 == null) goto L13;
        r5.h = System.currentTimeMillis();
    L13:
        long r6 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r4);
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(r3, r4, r4).subscribeOn(Schedulers.io()).flatMap(p.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(r2, r4, r6), new r(r2, r4, r6));
    L14:
        rj0.g r7 = this.e;
        if (r7 == null) goto L18;
        r7.a("click_unSilence", true);
        return;
    }

    public final void onDetachedFromWindow() {
        com.bytedance.android.live.liveinteract.videotalk.emoji.d r0 = this.h;
        if (r0 == null) goto L5;
        r0.detachView();
    L5:
        hd0.c.f().e(this.C);
        this.y.clear();
        g r1 = this.B;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.B = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void s() {
        int r0 = c1.a;
        if (e5.n() == false) goto L6;
        f2.b(2131917689, 0);
        return;
    L6:
        String r1 = ChatMatchWidget.o;
        ChatMatchViewModel r2 = (ChatMatchViewModel) com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class);
        if (r2 == null) goto L20;
        IRoom r3 = this.v;
        if (r3 == null) goto L12;
        new gk0.a(r3).d(false, 0);
    L12:
        if (Intrinsics.areEqual((Boolean) r2.getMatchingState().getValue(), Boolean.TRUE) == false) goto L14;
        ChatMatchViewModel.showMatchDialog$default(r2, false, 1, null);
        M0(this);
        return;
    L14:
        j0.a r4 = new j0.a(getContext());
        if (((Boolean) w60.a.getValue()).booleanValue() == false) goto L17;
        int r5 = 2131917766;
    L18:
        r4.a = s1.B(r5);
        r4.c = s1.B(2131915442);
        r4.b = e.a;
        r4.e = s1.B(2131917767);
        r4.d = new d(r2, this);
        r4.c();
        return;
    L17:
        r5 = 2131917765;
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void y0() {
        Intrinsics.checkNotNullParameter("link_interaction_panel_beauty", "eventPage");
        Intrinsics.checkNotNullParameter("link_interaction_panel_beauty", "eventPage");
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
        show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public final void e() {
        if (T0() == false) goto L17;
        String r0 = this.u;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r2 = this.i;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(je0.d.j(r2));
    L8:
        TalkRoomLogUtils.A(r0, r3, je0.d.Z(), je0.d.b0());
        g1(2131919826);
        com.bytedance.android.live.liveinteract.videotalk.emoji.d r1 = this.h;
        if (r1 == null) goto L18;
        long r4 = this.p;
        String r5 = je0.d.b0();
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        if (r1.b == true) goto L18;
        r1.b = true;
        VoiceChatMuteManager r6 = com.bytedance.android.live.liveinteract.videotalk.emoji.d.c0();
        if (r6 == null) goto L16;
        r6.h = System.currentTimeMillis();
    L16:
        long r7 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r5);
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r4, r5, r5).subscribeOn(Schedulers.io()).flatMap(m.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(r1, r5, r7), new o(r1, r5, r7));
    L18:
        rj0.g r8 = this.e;
        if (r8 == null) goto L22;
        r8.a("click_silence", true);
        return;
    L22:
        return;
    L7:
        r3 = null;
        goto L8
    L17:
        f2.b(2131919216, 0);
        goto L18
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tb6.c r0 = this.A;
        if (r0 == null) goto L7;
        i97.a r1 = i97.a.a;
        r0.b = System.currentTimeMillis() - r0.a;
        tb6.c r2 = r0.b();
        if (r2 == null) goto L7;
        r2.c("emoji_panel_type");
        Unit r3 = Unit.INSTANCE;
        this.A = null;
    L7:
        hd0.c.f().c(this.C);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ih0.d
    public final boolean p() {
        return super/*android.app.Dialog*/.isShowing();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        boolean r0 = this.n;
        String r1 = this.u;
        je0.d.y();
        TalkRoomLogUtils.l(r0, r1, true);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // ih0.d
    public final void dismissDialog() {
        M0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M0(BaseDynamicEmojiDialog r3) {
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

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void A2(List<? extends j1> r6) {
        Intrinsics.checkNotNullParameter(r6, "entranceList");
        if (vm2.c.c() == true) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.w).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r0.add((com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r1.next());
        goto L7
    L9:
        Iterator<T> r7 = r6.iterator();
        int r2 = 0;
    L11:
        if (r7.hasNext() == false) goto L16;
        Object r3 = r7.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        ListProtector.add(r0, r2, new m0(this, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.c((j1) r3)));
        r2 = r4;
        goto L11
    L16:
        ChatRoomPanelItemAdapter r8 = this.f;
        if (r8 == null) goto L24;
        r8.z2(r0);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void D(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        X0();
        M0(this);
        this.o = true;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void E3(Throwable r8) {
        Intrinsics.checkNotNullParameter(r8, "throwable");
        findViewById(2131378151).setVisibility(8);
        tb6.c r0 = this.A;
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r2 = null;
        if (r0 == null) goto L7;
        i97.a r3 = i97.a.a;
        r0.c = System.currentTimeMillis() - r0.a;
        r0.e = false;
        tb6.c r1 = r0.b();
        if (r1 == null) goto L7;
        r1.c("emoji_panel_type");
        Unit r4 = Unit.INSTANCE;
        this.A = null;
    L7:
        String r5 = (String) new com.bytedance.android.livesdk.sharedpref.e("dynamic_emoji_list", "").getValue();
        if (StringUtils.isEmpty(r5) == true) goto L11;
        r2 = ((com.bytedance.android.live.liveinteract.videotalk.emoji.model.k) GsonProtectorUtils.fromJson(GsonHelper.get(), r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.k.class)).getEmojiList();
    L11:
        if (r2 == null) goto L13;
        i1(r2);
    L13:
        EmojiListAdapter r6 = this.g;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L17:
        if (r6.getItemCount() != 0) goto L19;
        f1(true);
    L19:
        com.bytedance.android.live.liveinteract.plantform.utils.x.j(r8, false);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void G(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        X0();
        M0(this);
        this.o = false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void G3(Throwable r4) {
        IBaseUser r0 = jc1.k.n(IMiddlewareUserService.class).user().b();
        ((GuestHonorView) findViewById(2131392518)).a(null, r0);
        ALogger.e("ttlive_link", r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void Lu(List<? extends ILinkmicInteractEntrance> r6) {
        Intrinsics.checkNotNullParameter(r6, "bannerList");
        if (((Boolean) w60.a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (r6.isEmpty() == false) goto L8;
        return;
    L8:
        String r0 = ((LiveChatRoomPanelBannerLynxConfig) o60.a.getValue()).getBannerUrl();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return;
    L11:
        String r7 = UriProtector.parse(r0).buildUpon().appendQueryParameter("banner_list", GsonProtectorUtils.toJson(GsonHelper.get(), r6)).toString();
        g r1 = new g((ViewGroup) findViewById(2131363934), getContext(), x6.a.d(r7), s1.y());
        this.B = r1;
        r1.loadUrl(r7);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void c0(TalkRoomBaseDynamicEmoji r4) {
        Intrinsics.checkNotNullParameter(r4, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r5 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) com.bytedance.android.live.base.model.m.b(r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j.class);
        if (r5 != null) goto L5;
        return;
    L5:
        i0 r0 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.k(this.n, this.u, r5, true);
        if (r5.getEmojiCategory() != 7) goto L9;
        TalkRoomLogUtils.k1("emoji_panel_oneself", null);
        return;
    }

    public final void e1(int r4) {
        if (r4 != 0) goto L5;
        findViewById(2131369197).setVisibility(8);
        ((TextView) findViewById(2131390507)).setVisibility(0);
        return;
    L5:
        findViewById(2131369197).setVisibility(8);
        ((TextView) findViewById(2131390507)).setVisibility(8);
    }

    public final void f1(boolean r5) {
        if (r5 == false) goto L5;
        ((TextView) findViewById(2131371590)).setVisibility(0);
        findViewById(2131388181).setVisibility(8);
        findViewById(2131381814).setVisibility(8);
        return;
    L5:
        ((TextView) findViewById(2131371590)).setVisibility(8);
        findViewById(2131388181).setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g1(int r4) {
        if (this.j != null) goto L5;
        Context r0 = getContext();
        x0.d r1 = new x0.d();
        r1.b = r0;
        r1.a = 2;
        r1.d = r0.getText(r4);
        r1.k = false;
        this.j = new x0(r1.b, r1);
    L5:
        x0 r5 = this.j;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isShowing() == false) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L13:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }

    public final boolean h1(Throwable r3) {
        if ((r3 instanceof ApiServerException) == false) goto L8;
        ApiServerException r4 = (ApiServerException) r3;
        if (TextUtils.isEmpty(r4.getPrompt()) == true) goto L8;
        f2.c(r4.getPrompt(), 0);
        return true;
    L8:
        return false;
    }

    public final void i1(List<? extends com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r6) {
        EmojiListAdapter r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L5:
        r0.y2(KotlinTypeUtilsKt.castElementType(r6));
        int r1 = r6.size() / this.m;
        int r2 = 0;
        if ((r6.size() % this.m) <= 0) goto L8;
        int r7 = 1;
    L9:
        this.r = r1 + r7;
        findViewById(2131381814).a(this.r, this.s);
        RtlViewPagerShower r8 = findViewById(2131381814);
        if (this.r != 1) goto L12;
        r2 = 4;
    L12:
        r8.setVisibility(r2);
        return;
    L8:
        r7 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void ih(com.bytedance.android.live.liveinteract.videotalk.emoji.model.k r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        findViewById(2131378151).setVisibility(8);
        tb6.c r0 = this.A;
        if (r0 == null) goto L8;
        i97.a r2 = i97.a.a;
        r0.c = System.currentTimeMillis() - r0.a;
        r0.e = true;
        tb6.c r1 = r0.b();
        if (r1 == null) goto L8;
        r1.c("emoji_panel_type");
        Unit r3 = Unit.INSTANCE;
        this.A = null;
    L8:
        if (this.z == false) goto L12;
        UtilityKotlinExtentionsKt.t(findViewById(2131388181));
        return;
    L12:
        if (Lists.isEmpty(r7.getEmojiList()) == true) goto L14;
        f1(false);
        i1(r7.getEmojiList());
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("dynamic_emoji_list", ""), GsonProtectorUtils.toJson(GsonHelper.get(), r7));
    L16:
        if (r7.getSendLimitTime() <= 1000) goto L18;
        long r4 = r7.getSendLimitTime();
    L19:
        this.c = r4;
        String r8 = r7.getSendLimitDesc();
        if (r8 == null) goto L23;
        this.d = r8;
        return;
    L23:
        return;
    L18:
        r4 = 1000;
        goto L19
    L14:
        f1(true);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void j0(TalkRoomBaseDynamicEmoji r18) {
        Intrinsics.checkNotNullParameter(r18, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r1 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.j) com.bytedance.android.live.base.model.m.b(r18, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j.class);
        if (r1 != null) goto L5;
        return;
    L5:
        i0 r3 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.j(r1, this.n, true, this.u);
        String r6 = null;
        if (r1.getEmojiCategory() != 7) goto L8;
        TalkRoomLogUtils.j1("emoji_panel_oneself", null);
    L8:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r4 = r1.getEmojiPermission();
        if (r4 == null) goto L11;
        String r5 = r4.schemaJumpUrl;
    L13:
        if (TextUtils.isEmpty(r5) == true) goto L19;
        IBaseLiveActionHandler r2 = jc1.k.n(IBaseLiveActionHandler.class);
        Context r7 = getContext();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r8 = r1.getEmojiPermission();
        if (r8 == null) goto L17;
        r6 = r8.schemaJumpUrl;
    L17:
        r2.handle(r7, r6);
        M0(this);
        return;
    L19:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.l r9 = r1.getEmojiPermission();
        if (r9 == null) goto L28;
        if (r9.hasPermission != true) goto L28;
        if ((System.currentTimeMillis() - InteractEmojiPanel.D) >= this.c) goto L28;
        f2.c(this.d, 0);
        return;
    L28:
        if (r1.getEmojiCategory() != 2) goto L37;
        DigitAvatarContext r10 = DigitAvatarContext.Companion.getContext();
        if (r10 == null) goto L34;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.liveinteract.videotalk.emoji.model.j> r11 = r10.getSendAvatarEmoji();
        if (r11 == null) goto L34;
        r11.post(r1);
    L34:
        M0(this);
        return;
    L37:
        if (r1.getEmojiCategory() != 4) goto L44;
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.r0.getClass();
        com.bytedance.android.live.liveinteract.videotalk.quickinteract.b r12 = com.bytedance.android.live.liveinteract.videotalk.quickinteract.b.C0101b.a();
        if (r12 == null) goto L41;
        r12.Fn(String.valueOf(r1.getEmojiId()));
    L41:
        M0(this);
        return;
    L44:
        if (r1.getEmojiCategory() == 6) goto L46;
    L48:
        com.bytedance.android.live.liveinteract.videotalk.emoji.d r13 = this.h;
        if (r13 == null) goto L66;
        long r14 = this.p;
        Intrinsics.checkNotNullParameter(r1, "emoji");
        if (r13.d == true) goto L66;
        if ((System.currentTimeMillis() - r13.e) < 1000) goto L66;
        Ref.LongRef r15 = new Ref.LongRef();
        r15.element = 0;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.a r16 = r1.getCustomizedRandomResource();
        if (r16 != null) goto L58;
    L65:
        r13.d = true;
        r13.e = System.currentTimeMillis();
        long r17 = System.currentTimeMillis();
        r13.f.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendTalkRoomEmoji(r14, r1.getEmojiId(), r15.element).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(r13, r1, r17, r15), new l(r13, r1, r17)));
        goto L66
    L58:
        if (r16.getType() <= 0) goto L65;
        if (r1.getDisable() == false) goto L63;
        f2.c("已有随机表情正在进行，此随机表情暂不可发", 0);
        goto L66
    L63:
        if (r16.getStatus() != 1) goto L65;
        r15.element = 1;
    L66:
        System.currentTimeMillis();
        return;
    L46:
        if (r1.getDisable() == false) goto L48;
        return;
    L11:
        r5 = null;
        goto L13
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
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void j9(List<? extends ILinkmicInteractEntrance> r14) {
        Intrinsics.checkNotNullParameter(r14, "list");
        if (vm2.c.c() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.w).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r0.add((com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r1.next());
        goto L7
    L9:
        ArrayList r2 = new ArrayList();
        r2.addAll(r14);
        List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b> r15 = com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.b(getContext(), this, com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.a(r2), je0.d.b0());
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.d(r15);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L10:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L43;
        Object r6 = r4.next();
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r7 = (com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r6;
        if (r2.isEmpty() == true) goto L40;
        Iterator r8 = r2.iterator();
    L17:
        if (r8.hasNext() == false) goto L40;
        ILinkmicInteractEntrance r9 = (ILinkmicInteractEntrance) r8.next();
        if (TextUtils.equals(r7.j(), r9.getName()) == false) goto L37;
        List r10 = r9.getButtons();
        if (r10 == null) goto L33;
        if ((!r10.isEmpty()) != true) goto L33;
        String r11 = r7.f();
        List r12 = r9.getButtons();
        if (r12 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.model.interact.r r13 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r12, 0);
        if (r13 == null) goto L29;
        String r16 = r13.getToast();
    L31:
        if (TextUtils.equals(r11, r16) == true) goto L33;
    L36:
        boolean r17 = true;
    L38:
        if (r17 == false) goto L17;
    L41:
        if (r5 == false) goto L10;
        r3.add(r6);
    L29:
        r16 = null;
    L33:
        if (r9.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L36;
        if (r9.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L36;
    L37:
        r17 = false;
    L40:
        r5 = false;
        goto L41
    L43:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r2.iterator();
    L45:
        if (r19.hasNext() == false) goto L65;
        Object r20 = r19.next();
        ILinkmicInteractEntrance r21 = (ILinkmicInteractEntrance) r20;
        if (r0.isEmpty() == true) goto L62;
        Iterator r22 = r0.iterator();
    L51:
        if (r22.hasNext() == false) goto L62;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r110 = (com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r22.next();
        List r111 = r21.getButtons();
        if (r111 != null) goto L55;
    L59:
        boolean r112 = false;
    L60:
        if (r112 == true) goto L51;
        boolean r23 = false;
    L63:
        if (r23 == false) goto L45;
        r18.add(r20);
        goto L45
    L55:
        if ((!r111.isEmpty()) != true) goto L59;
        if (TextUtils.equals(r21.getName(), r110.j()) == true) goto L59;
        r112 = true;
    L62:
        r23 = true;
        goto L63
    L65:
        r0.removeAll(r3);
        Iterator r24 = r3.iterator();
    L67:
        if (r24.hasNext() == false) goto L88;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r25 = (com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r24.next();
        ArrayList r26 = new ArrayList();
        Iterator r27 = r2.iterator();
    L70:
        if (r27.hasNext() == false) goto L74;
        Object r113 = r27.next();
        if (TextUtils.equals(((ILinkmicInteractEntrance) r113).getName(), r25.j()) == false) goto L70;
        r26.add(r113);
        goto L70
    L74:
        ILinkmicInteractEntrance r28 = (ILinkmicInteractEntrance) CollectionsKt.firstOrNull(r26);
        if (r28 == null) goto L67;
        if (r28.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L67;
        if (r28.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L67;
        List r29 = r28.getButtons();
        if (r29 == null) goto L67;
        if ((!r29.isEmpty()) != true) goto L67;
        Context r30 = getContext();
        IRoom r114 = this.v;
        if (r114 == null) goto L87;
        r114.getRoomId();
    L87:
        r0.add(new l0(this, r30, "", r28));
        goto L67
    L88:
        Iterator r31 = r18.iterator();
    L90:
        if (r31.hasNext() == false) goto L107;
        ILinkmicInteractEntrance r32 = (ILinkmicInteractEntrance) r31.next();
        if (r32 == null) goto L95;
        if (r32.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L90;
    L95:
        if (r32 == null) goto L98;
        if (r32.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L90;
    L98:
        List r33 = r32.getButtons();
        if (r33 == null) goto L90;
        if ((!r33.isEmpty()) != true) goto L90;
        Context r34 = getContext();
        IRoom r35 = this.v;
        if (r35 == null) goto L105;
        r35.getRoomId();
    L105:
        r0.add(new l0(this, r34, "", r32));
        goto L90
    L107:
        if ((!((ArrayList) r15).isEmpty()) == false) goto L109;
        r0.addAll(0, r15);
    L109:
        ChatRoomPanelItemAdapter r115 = this.f;
        if (r115 == null) goto L165;
        r115.z2(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r15) {
        super.onCreate(r15);
        this.n = ((Boolean) this.D.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r16 = this.i;
        int r1 = 0;
        if (r16 == null) goto L9;
        ILinkPlayerInfoBridge r17 = (ILinkPlayerInfoBridge) r16.a5(je0.d.b0(), tc0.c.h().f);
        if (r17 == null) goto L9;
        if (r17.getSilenceStatus() == 0) goto L9;
        boolean r18 = true;
    L10:
        this.o = r18;
        IRoom r19 = (IRoom) this.D.get("data_room");
        this.v = r19;
        if (r19 == null) goto L13;
        long r2 = r19.getId();
    L14:
        this.p = r2;
        this.t = jc1.k.n(IMiddlewareUserService.class).user().c();
        Z0();
        int r110 = this.a;
        this.k = r110;
        int r3 = this.b;
        this.l = r3;
        this.m = r110 * r3;
        findViewById(2131378151).setVisibility(0);
        int r4 = c1.a;
        if (e5.n() == false) goto L17;
        int r5 = s1.f(375.0f);
    L18:
        EmojiListAdapter r6 = new EmojiListAdapter(this.a, this.b, r5);
        this.g = r6;
        Intrinsics.checkNotNullParameter(this, "listener");
        r6.c = this;
        SSGridLayoutManager r7 = new SSGridLayoutManager(getContext(), this.k, 0);
        RecyclerView r8 = findViewById(2131388181);
        EmojiListAdapter r9 = this.g;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L21:
        r8.setAdapter(r9);
        findViewById(2131388181).setLayoutManager(r7);
        findViewById(2131388181).setHasFixedSize(true);
        findViewById(2131388181).setItemViewCacheSize(this.m * 2);
        findViewById(2131388181).setClipChildren(false);
        findViewById(2131388181).setClipToPadding(false);
        GridPagerSnapHelper r10 = new BaseDynamicEmojiDialog$attachSnapHelper$snapHelper$1(this);
        r10.h(this.k);
        r10.g(this.l);
        r10.attachToRecyclerView(findViewById(2131388181));
        findViewById(2131388181).addOnScrollListener(new BaseDynamicEmojiDialog$attachSnapHelper$1(this));
        findViewById(2131381814).setMargin(s1.j(2131168969));
        RtlViewPagerShower r11 = findViewById(2131381814);
        Drawable r12 = s1.m(2131250379);
        Drawable r13 = s1.m(2131250380);
        r11.c = r12;
        r11.d = r13;
        int r14 = com.bytedance.android.live.liveinteract.videotalk.utils.f.a;
        com.bytedance.android.live.liveinteract.videotalk.utils.f.a(this.v);
        UtilityKotlinExtentionsKt.w(findViewById(2131388772));
        a1.k(findViewById(2131388843), UtilityKotlinExtentionsKt.i(52));
        UtilityKotlinExtentionsKt.t(findViewById(2131375128));
        UtilityKotlinExtentionsKt.t(findViewById(2131390995));
        UtilityKotlinExtentionsKt.t(findViewById(2131392518));
        Y0();
        if (jc0.a.a() == false) goto L24;
        this.z = true;
        findViewById(2131378151).setVisibility(8);
        UtilityKotlinExtentionsKt.t(findViewById(2131388181));
        UtilityKotlinExtentionsKt.t(findViewById(2131381814));
    L25:
        com.bytedance.android.live.liveinteract.videotalk.emoji.d r111 = this.h;
        if (r111 == null) goto L29;
        long r20 = this.p;
        int r21 = U0();
        String r112 = je0.d.b0();
        Intrinsics.checkNotNullParameter(r112, "selfId");
        long r22 = System.currentTimeMillis();
        r111.f.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).getTalkRoomEmojiList(r20, je0.d.f(), 1, r21, r112).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r111, r21, r22), new j(r111, r21, r22)));
    L29:
        if (this.E == true) goto L31;
        ((LinearLayout) findViewById(2131389057)).setVisibility(8);
        findViewById(2131374137).setVisibility(8);
        e1(8);
        W0();
    L299:
        com.bytedance.android.live.liveinteract.videotalk.emoji.d r113 = this.h;
        if (r113 == null) goto L302;
        ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).fetchInteractEntrances(this.p).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.emoji.g(r113), new h(r113));
    L302:
        int r114 = com.bytedance.android.live.liveinteract.videotalk.utils.f.a;
        if (com.bytedance.android.live.liveinteract.videotalk.utils.f.a(this.v) == false) goto L307;
        com.bytedance.android.live.liveinteract.videotalk.emoji.d r115 = this.h;
        if (r115 == null) goto L307;
        long r23 = this.p;
        String r24 = je0.d.b0();
        Intrinsics.checkNotNullParameter(r24, "targetUserId");
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).contributeShow(r23, d5.c(r24), r24, 0, 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.videotalk.emoji.e(r115), new com.bytedance.android.live.liveinteract.videotalk.emoji.f(r115));
    L307:
        rj0.g r116 = this.e;
        if (r116 == null) goto L332;
        r116.a("self_panel", true);
        return;
    L332:
        return;
    L31:
        findViewById(2131374137).setVisibility(0);
        if (this.n == false) goto L34;
    L48:
        int r117 = 8;
    L49:
        e1(r117);
        ((TextView) findViewById(2131390507)).setOnClickListener(new com.bytedance.android.live.liveinteract.videotalk.emoji.a(this));
        if (TeamFightContext.Companion.h() == false) goto L52;
        ((TextView) findViewById(2131390507)).setText(s1.B(2131922796));
    L52:
        Integer r25 = je0.d.h();
        if (r25 != null) goto L56;
    L58:
        boolean r26 = false;
    L60:
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.util.a.a() == false) goto L194;
        if (this.n == false) goto L194;
        Ref.IntRef r27 = new Ref.IntRef();
        r27.element = -1;
        Ref.ObjectRef r28 = new Ref.ObjectRef();
        r28.element = "";
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r29 = this.i;
        if ((r29 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L66;
        r29 = null;
    L66:
        com.bytedance.android.live.liveinteract.plantform.core.y r30 = (com.bytedance.android.live.liveinteract.plantform.core.y) r29;
        if (r30 == null) goto L104;
        CopyOnWriteArrayList<ILinkPlayerInfoBridge> r31 = r30.c;
        if (r31 == null) goto L88;
        Iterator<ILinkPlayerInfoBridge> r32 = r31.iterator();
    L72:
        if (r32.hasNext() == false) goto L84;
        ILinkPlayerInfoBridge r33 = r32.next();
        IBaseUser r118 = r33.getUser();
        if (r118 == null) goto L76;
        String r119 = r118.getIdString();
    L77:
        IRoom r120 = this.v;
        if (r120 == null) goto L80;
        String r121 = r120.getOwnerUserIdString();
    L82:
        if (Intrinsics.areEqual(r119, r121) == false) goto L72;
    L85:
        ILinkPlayerInfoBridge r34 = r33;
        if (r34 == null) goto L88;
        r27.element = r34.getUserPositionFlex();
        goto L88
    L80:
        r121 = null;
        goto L82
    L76:
        r119 = null;
        goto L77
    L84:
        r33 = null;
    L88:
        Iterator<LinkmicPositionItem> r35 = r30.e.iterator();
    L90:
        if (r35.hasNext() == false) goto L97;
        LinkmicPositionItem r36 = r35.next();
        if (r36.getPosition() != r27.element) goto L94;
        boolean r37 = true;
    L95:
        if (r37 == false) goto L90;
    L98:
        LinkmicPositionItem r38 = r36;
        if (r38 == null) goto L104;
        String r39 = r38.getActiveName();
        if (r39 != null) goto L103;
        r39 = "";
    L103:
        r28.element = r39;
        goto L104
    L94:
        r37 = false;
        goto L95
    L97:
        r36 = null;
    L104:
        int r40 = V0(r27.element);
        if (je0.d.N() == false) goto L109;
        if (je0.d.w() == true) goto L109;
    L112:
        boolean r41 = true;
    L114:
        if (r41 == false) goto L118;
        if (r26 == true) goto L118;
        r40 = r40 + 1;
    L118:
        if (je0.d.N() == true) goto L120;
    L122:
        r40 = r40 + 1;
    L124:
        if (r40 != 0) goto L128;
        TextView r42 = (TextView) findViewById(2131391411);
        if (r42 == null) goto L131;
        r42.setText(s1.B(2131919005));
    L131:
        Integer r43 = je0.d.h();
        if (r43 != null) goto L135;
    L136:
        Integer r44 = je0.d.h();
        if (r44 != null) goto L140;
    L142:
        IInteractService r45 = (IInteractService) jc1.k.n(IInteractService.class);
        Integer r46 = je0.d.h();
        if (r46 == null) goto L145;
        int r47 = r46.intValue();
    L147:
        if (r45.isVoiceMultiEnlargeSeat(r47, r27.element) == false) goto L155;
        TextView r48 = (TextView) findViewById(2131391411);
        if (r48 == null) goto L155;
        r48.setText(s1.B(2131919004));
    L155:
        if (je0.d.f() == 16) goto L194;
        Integer r49 = je0.d.h();
        if (r49 != null) goto L160;
    L161:
        Integer r50 = je0.d.h();
        if (r50 != null) goto L165;
    L166:
        UtilityKotlinExtentionsKt.w(findViewById(2131391411));
        if (com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.d.f() == false) goto L169;
        UtilityKotlinExtentionsKt.t(findViewById(2131391411));
    L169:
        Integer r51 = je0.d.h();
        if (r51 != null) goto L173;
    L176:
        Integer r52 = je0.d.h();
        if (r52 != null) goto L180;
    L184:
        Integer r53 = je0.d.h();
        if (r53 != null) goto L188;
    L192:
        ((TextView) findViewById(2131391411)).setOnClickListener(new com.bytedance.android.live.liveinteract.videotalk.emoji.b(this, r27, r28));
        goto L194
    L188:
        if (r53.intValue() != 30) goto L192;
        if (r27.element != 0) goto L192;
        UtilityKotlinExtentionsKt.t(findViewById(2131391411));
        goto L192
    L180:
        if (r52.intValue() != 28) goto L184;
        if (r27.element != 0) goto L184;
        UtilityKotlinExtentionsKt.t(findViewById(2131391411));
        goto L184
    L173:
        if (r51.intValue() != 1) goto L176;
        if (r40 != 0) goto L176;
        UtilityKotlinExtentionsKt.t(findViewById(2131391411));
        goto L176
    L165:
        if (r50.intValue() == 29) goto L194;
    L160:
        if (r49.intValue() == 24) goto L194;
    L145:
        r47 = 0;
        goto L147
    L140:
        if (r44.intValue() != 112) goto L142;
    L151:
        TextView r54 = (TextView) findViewById(2131391411);
        if (r54 == null) goto L155;
        r54.setText(s1.B(2131919005));
        goto L155
    L135:
        if (r43.intValue() == 6) goto L151;
    L128:
        TextView r55 = (TextView) findViewById(2131391411);
        if (r55 == null) goto L131;
        r55.setText(s1.C(2131919007, new Object[]{String.valueOf(r40)}));
        goto L131
    L120:
        if (je0.d.w() == true) goto L122;
    L109:
        if (je0.d.u() == true) goto L111;
    L113:
        r41 = false;
        goto L114
    L111:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(this.v) == true) goto L113;
    L194:
        if (S0() == false) goto L198;
        ((TextView) findViewById(2131391412)).setVisibility(0);
        ((TextView) findViewById(2131391412)).setOnClickListener(new com.bytedance.android.live.liveinteract.videotalk.emoji.c(this));
        if (((TextView) findViewById(2131390507)).getVisibility() != 0) goto L199;
        findViewById(2131369197).setVisibility(0);
    L199:
        O0();
        Q0();
        R0();
        if (je0.d.O() == false) goto L205;
        if (this.n == false) goto L205;
    L249:
        if (this.n == true) goto L255;
        String r122 = ChatMatchWidget.o;
        if (com.bytedance.live.datacontext.d.e("ChatMatchWidget", ChatMatchViewModel.class) == null) goto L255;
        ((ArrayList) this.w).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.p(this));
        Intrinsics.checkNotNullParameter("normal_panel", "requestPage");
        ChatMatchWidget.o = "normal_panel";
        IRoom r123 = this.v;
        if (r123 == null) goto L255;
        new gk0.a(r123).c(LinkMatchType.MATCH.getValue());
    L255:
        P0();
        if (vm2.c.c() == false) goto L259;
    L294:
        this.f = new ChatRoomPanelItemAdapter(this.w);
        findViewById(2131388180).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        findViewById(2131388180).setAdapter(this.f);
        findViewById(2131388180).setHasFixedSize(true);
        RecyclerView r56 = findViewById(2131388180);
        if (((ArrayList) this.w).size() > 0) goto L298;
        r1 = 8;
    L298:
        r56.setVisibility(r1);
        findViewById(2131374137).setVisibility(findViewById(2131388180).getVisibility());
        goto L299
    L259:
        if (vm2.d.E() == false) goto L294;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r124 = this.i;
        if ((r124 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L263;
        r124 = null;
    L263:
        com.bytedance.android.live.liveinteract.plantform.core.y r125 = (com.bytedance.android.live.liveinteract.plantform.core.y) r124;
        if (r125 == null) goto L266;
        List<ILinkmicInteractEntrance> r126 = r125.D;
    L267:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.a(r126);
        if (r126 == null) goto L294;
        Iterator<T> r127 = r126.iterator();
    L271:
        if (r127.hasNext() == false) goto L294;
        ILinkmicInteractEntrance r57 = (ILinkmicInteractEntrance) r127.next();
        if ((r57 instanceof ILinkmicInteractEntrance) == false) goto L271;
        List r58 = r57.getButtons();
        if (r58 == null) goto L271;
        if ((!r58.isEmpty()) != true) goto L271;
        if (r57.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L271;
        if (r57.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L271;
        int r59 = dk0.a.a;
        String r60 = r57.getSource();
        if (r60 != null) goto L285;
        r60 = "";
    L285:
        List r61 = r57.getButtons();
        Intrinsics.checkNotNull(r61);
        com.bytedance.android.livesdk.chatroom.model.interact.r r62 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r61, 0);
        if (r62 == null) goto L289;
        String r63 = r62.getToast();
        if (r63 == null) goto L289;
    L290:
        dk0.a.a("self", r60, r63, "");
        List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r65 = this.w;
        Context r66 = getContext();
        IRoom r67 = this.v;
        if (r67 == null) goto L293;
        r67.getRoomId();
    L293:
        ((ArrayList) r65).add(new l0(this, r66, "", r57));
    L289:
        r63 = "";
        goto L290
    L266:
        r126 = null;
    L205:
        if (jc0.a.a() == true) goto L249;
        com.bytedance.live.datacontext.j r128 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r128 == null) goto L215;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r129 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r128.getValue();
        if (r129 == null) goto L215;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.c(r129) == true) goto L249;
    L215:
        if (aj0.a.e() == true) goto L217;
    L219:
        Integer r130 = (Integer) com.bytedance.android.livesdk.sharedpref.c.N0.getValue();
        if (r130 != null) goto L223;
    L224:
        if (r130 != null) goto L227;
    L228:
        if (r130 == null) goto L249;
        if (r130.intValue() != 4) goto L249;
    L232:
        com.bytedance.android.livesdk.sharedpref.e r131 = com.bytedance.android.livesdk.sharedpref.c.P0;
        if ((!((Collection) r131.getValue()).isEmpty()) == false) goto L249;
        if ((ListProtector.get((List) r131.getValue(), 0) instanceof com.bytedance.android.livesdk.chatroom.model.r) == false) goto L249;
        String r68 = ((com.bytedance.android.livesdk.chatroom.model.r) ListProtector.get((List) r131.getValue(), 0)).a;
        if (r68 != null) goto L240;
        r68 = "";
    L240:
        Context r69 = getContext();
        IRoom r70 = this.v;
        if (r70 == null) goto L243;
        r70.getRoomId();
    L243:
        Boolean r132 = ((com.bytedance.android.livesdk.chatroom.model.r) ListProtector.get((List) r131.getValue(), 0)).b;
        if (r132 == null) goto L246;
        boolean r133 = r132.booleanValue();
    L247:
        ((ArrayList) this.w).add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.s0(this, r68, r69, r133));
        int r134 = dk0.b.a;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_link_interact_panel_head_decorate_icon_show", new HashMap(), new Object[]{IRoom.class});
        goto L249
    L246:
        r133 = false;
        goto L247
    L227:
        if (r130.intValue() == 2) goto L232;
    L223:
        if (r130.intValue() == 1) goto L232;
    L217:
        if (a1() == true) goto L219;
    L198:
        ((TextView) findViewById(2131391412)).setVisibility(8);
        goto L199
    L56:
        if (r25.intValue() != 1) goto L58;
        r26 = true;
        goto L60
    L34:
        if (jc0.a.a() == false) goto L44;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r135 = this.i;
        if (r135 == null) goto L40;
        ILinkPlayerInfoBridge r136 = (ILinkPlayerInfoBridge) r135.a5(je0.d.b0(), tc0.c.h().f);
        if (r136 == null) goto L40;
        long r71 = r136.getChorusGuestStatus();
    L42:
        if (r71 > 0) goto L44;
        boolean r137 = true;
    L45:
        if (r137 == true) goto L48;
        r117 = 0;
    L40:
        r71 = 0;
    L44:
        r137 = false;
        goto L45
    L24:
        this.z = false;
        UtilityKotlinExtentionsKt.w(findViewById(2131388181));
        UtilityKotlinExtentionsKt.w(findViewById(2131381814));
        goto L25
    L17:
        r5 = UIUtils.getScreenWidth(getContext());
        goto L18
    L13:
        r2 = 0;
    L9:
        r18 = false;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void ta(ContributeShowResponse.OwnerHonorInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        IBaseUser r0 = jc1.k.n(IMiddlewareUserService.class).user().b();
        ((GuestHonorView) findViewById(2131392518)).a(r3, r0);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void w2(com.bytedance.android.live.liveinteract.voicechat.model.a r7) {
        Intrinsics.checkNotNullParameter(r7, "response");
        tlc.d r0 = r7.a();
        if (r0 == null) goto L13;
        M0(this);
        Long r3 = null;
        vlc.d r1 = (vlc.d) this.D.get("data_message_manager", null);
        r0.setCurrUserIsAnchor(this.n);
        if (r1 == null) goto L7;
        r1.B(r0);
    L7:
        TalkRoomLogUtils.n(this.n, this.u, je0.d.f(), r0.getDynamicEmojiFlex());
        w8 r8 = r7.a();
        if (r8 == null) goto L10;
        r3 = Long.valueOf(r8.getMessageId());
    L10:
        com.bytedance.android.live.liveinteract.plantform.utils.x.s0(r3.longValue(), r0.getDynamicEmojiFlex());
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.ILinkMicDynamicEmojiMessage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void w6(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if (h1(r2) == true) goto L5;
        ExceptionUtils.handleException(getContext(), r2);
        M0(this);
    L5:
        com.bytedance.android.live.liveinteract.plantform.utils.x.r0(r2, false);
    }

    public static final void N0(BaseDynamicEmojiDialog r1, int r2) {
        int r3 = r2 / r1.m;
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= r1.r) goto L10;
        r1.s = r3;
        r1.findViewById(2131381814).b(r1.s);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void F(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        h1(r3);
        X0();
        M0(this);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0
    public void L(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r3, VideoShowMode r4) {
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        Intrinsics.checkNotNullParameter(r4, "selectMode");
        Intrinsics.checkNotNullParameter(r3, "panelItem");
        Intrinsics.checkNotNullParameter(r4, "selectMode");
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.d.a
    public final void r(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        h1(r3);
        X0();
        M0(this);
    }

    public BaseDynamicEmojiDialog(Context r2, DataCenter r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2);
        this.D = r3;
        this.E = r4;
        this.a = 2;
        this.b = 6;
        this.c = 1000;
        this.d = s1.B(2131922729);
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r5 = IVoiceChatAdminService.a.a();
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r6 = null;
        if (r5 == null) goto L7;
        MuteStateChecker r7 = r5.muteChecker();
        if (r7 == null) goto L7;
    L11:
        this.e = r7;
        IInteractService r8 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r8 == null) goto L14;
        r6 = r8.getLinkUserInfoCenter();
    L14:
        this.i = r6;
        this.u = "";
        this.w = new ArrayList();
        this.y = new CompositeDisposable();
        this.A = new tb6.c();
        this.C = new f(this);
        return;
    L7:
        rj0.l.n2.getClass();
        rj0.l r9 = rj0.l.a.a();
        if (r9 == null) goto L10;
        r7 = r9.Hg();
        goto L11
    L10:
        r7 = null;
        goto L11
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
}
