package com.bytedance.android.live.livepkaudience.emoji;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.videotalk.emoji.EmojiListAdapter;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiPermission;
import com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemAdapter;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.message.model.ue;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/BaseInteractEmojiPanel;", "Lcom/bytedance/android/live/livepkaudience/emoji/LinkCommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/s;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/f;", "Lcom/bytedance/android/live/livepkaudience/emoji/p$a;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseInteractEmojiPanel extends LinkCommonBottomDialog implements com.bytedance.android.live.liveinteract.videotalk.emoji.s, com.bytedance.android.live.livepkaudience.emoji.panel.f, p.a {
    public static long u;
    public long a;
    public String b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public int h;
    public final Room i;
    public final boolean j;
    public String k;
    public User l;
    public final p m;
    public LinkPKAudienceInteractPanelItemAdapter n;
    public EmojiListAdapter o;
    public final b p;
    public final Context q;
    public final DataCenter r;
    public final LinkPlayerInfo s;
    public final boolean t;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseInteractEmojiPanel a;

        public b(BaseInteractEmojiPanel r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 == null) goto L8;
            if (r5.intValue() != 2) goto L8;
            return;
        L8:
            if (dl0.n.c() == true) goto L30;
            q46.a r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r1 == null) goto L23;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r0.getLooper()) goto L14;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ BaseInteractEmojiPanel a;
        public final /* synthetic */ User b;

        public c(BaseInteractEmojiPanel r1, User r2, String r3) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r6, int r7) {
            r6.dismiss();
            if (this.b.getFollowInfo() != null) goto L5;
            return;
        L5:
            BaseInteractEmojiPanel r8 = this.a;
            p r9 = r8.m;
            Context r10 = r8.q;
            if (r10 == null) goto L17;
            Activity r11 = (Activity) r10;
            FollowInfo r12 = this.b.getFollowInfo();
            if (r12 == null) goto L10;
            r12.getFollowStatus();
        L10:
            String r13 = this.b.getIdStr();
            long r0 = this.a.i.id;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r13, "userId");
            if (r9.c == true) goto L14;
            com.bytedance.android.livesdk.user.f r2 = jc1.k.n(IUserService.class).user();
            com.bytedance.android.livesdk.user.m.c r14 = new com.bytedance.android.livesdk.user.m.c().c(r13);
            r14.d();
            com.bytedance.android.livesdk.user.m.c r15 = r14.e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PK_GUEST_INTERACT_PANEL)).f(r0);
            r15.getClass();
            r2.i(new com.bytedance.android.livesdk.user.m(r15)).subscribe(new y(r9), new z(r9));
        L14:
            BaseInteractEmojiPanel r16 = this.a;
            p r17 = r16.m;
            Room r18 = r16.i;
            String r1 = this.b.getIdStr();
            boolean r3 = this.a.j;
            r17.getClass();
            p.c0(r18, false, r1, r3);
            return;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
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
            r1.dismiss();
        }
    }

    static {
    }

    public abstract int O0();

    public abstract List<com.bytedance.android.live.livepkaudience.emoji.panel.g> P0();

    public abstract boolean Q0();

    public String R0() {
        Object[] r0 = new Object[1];
        User r1 = this.l;
        if (r1 == null) goto L5;
        String r2 = r1.getRealNickName();
    L6:
        r0[0] = r2;
        return s1.C(2131922750, r0);
    L5:
        r2 = null;
        goto L6
    }

    public String S0() {
        return "";
    }

    public final int getLayoutId() {
        return 2131565597;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void w5() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void x5(boolean r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void y5() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void z5(int r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void f() {
        User r0 = this.l;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.j == false) goto L8;
        String r1 = "live_anchor_c_audience";
    L16:
        z0 r2 = z0.a();
        Context r3 = this.q;
        r2.getClass();
        x0.b r4 = z0.b(r3);
        r4.l(2131922752);
        r4.i(0, 2131920806, new c(this, r0, r1));
        r4.i(1, 2131915442, d.a);
        r4.n();
        return;
    L8:
        String r5 = r0.getIdStr();
        User r6 = this.i.getOwner();
        if (r6 == null) goto L11;
        String r7 = r6.getIdStr();
    L13:
        if (Intrinsics.areEqual(r5, r7) == false) goto L15;
        r1 = "live_audience_c_anchor";
        goto L16
    L15:
        r1 = "live_audience_c_audience";
        goto L16
    L11:
        r7 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void h() {
        User r0 = this.l;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.j == false) goto L8;
        String r1 = "live_anchor_c_audience";
    L16:
        p r2 = this.m;
        this.i.getRequestId();
        String r3 = r0.getIdStr();
        Room r4 = this.i;
        long r5 = r4.id;
        r4.getLabels();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "userId");
        if (r2.c == true) goto L20;
        r2.c = true;
        com.bytedance.android.livesdk.user.f r6 = jc1.k.n(IUserService.class).user();
        com.bytedance.android.livesdk.user.b.c r7 = new com.bytedance.android.livesdk.user.b.c().c(r3).e();
        r7.e();
        com.bytedance.android.livesdk.user.b.c r8 = r7.g(r1).h(r5).f(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PK_GUEST_INTERACT_PANEL));
        r8.e();
        r6.h(new com.bytedance.android.livesdk.user.b(r8)).subscribe(new s(r2), new t(r2));
    L20:
        p r9 = this.m;
        Room r10 = this.i;
        String r11 = r0.getIdStr();
        boolean r12 = this.j;
        r9.getClass();
        p.c0(r10, true, r11, r12);
        return;
    L8:
        String r13 = r0.getIdStr();
        User r14 = this.i.getOwner();
        if (r14 == null) goto L11;
        String r15 = r14.getIdStr();
    L13:
        if (Intrinsics.areEqual(r13, r15) == false) goto L15;
        r1 = "live_audience_c_anchor";
        goto L16
    L15:
        r1 = "live_audience_c_audience";
        goto L16
    L11:
        r15 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void g() {
        if (Q0() == true) goto L6;
        f2.b(2131922751, 0);
        M0(this);
        return;
    L6:
        M0(this);
        xs2.b.a().post(new UserProfileEvent(this.l).setReportSource("pk_with_audience").setReportType("data_card_linked_audience_mutiaudience").setShowSendGift(true));
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        hd0.c.f().c(this.p);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hd0.c.f().e(this.p);
        this.m.detachView();
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void dismissDialog() {
        M0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M0(BaseInteractEmojiPanel r3) {
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

    @Override // com.bytedance.android.live.livepkaudience.emoji.p.a
    public final void M40(FollowPair r3) {
        User r0 = this.l;
        if (r0 == null) goto L17;
        FollowInfo r1 = r0.getFollowInfo();
        if (r1 == null) goto L18;
        long r2 = r1.getFollowStatus();
        if (r3 == null) goto L19;
        int r4 = (int) r2;
        int r5 = r3.followStatus;
        if (r4 == r5) goto L20;
        User r6 = this.l;
        if (r6 == null) goto L13;
        r6.setFollowStatus(r5);
    L13:
        LinkPKAudienceInteractPanelItemAdapter r7 = this.n;
        if (r7 == null) goto L21;
        List<com.bytedance.android.live.livepkaudience.emoji.panel.g> r8 = P0();
        Intrinsics.checkNotNullParameter(r8, "items");
        r7.b.clear();
        r7.b.addAll(r8);
        r7.notifyDataSetChanged();
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void T0(boolean r5) {
        if (r5 == false) goto L5;
        ((TextView) findViewById(2131371590)).setVisibility(0);
        findViewById(2131388181).setVisibility(4);
        findViewById(2131381814).setVisibility(8);
        return;
    L5:
        ((TextView) findViewById(2131371590)).setVisibility(8);
        findViewById(2131388181).setVisibility(0);
    }

    public final void U0(List<? extends com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r4) {
        EmojiListAdapter r0 = this.o;
        if (r0 == null) goto L5;
        r0.y2(r4);
    L5:
        int r1 = r4.size() / this.e;
        if ((r4.size() % this.e) <= 0) goto L8;
        int r5 = 1;
    L9:
        this.g = r1 + r5;
        findViewById(2131381814).a(this.g, this.h);
        findViewById(2131381814).setVisibility(4);
        return;
    L8:
        r5 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.p.a
    public final void U2(Throwable r2) {
        if ((r2 instanceof ApiServerException) == false) goto L5;
        IESUIUtils.displayToast(this.q, ((ApiServerException) r2).getPrompt());
        return;
    L5:
        f2.b(2131919727, 0);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void c0(TalkRoomBaseDynamicEmoji r4) {
        Intrinsics.checkNotNullParameter(r4, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r5 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.r) com.bytedance.android.live.base.model.m.b(r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r.class);
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = el0.j.b;
        el0.j.c(this.j, this.k, r5, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void j0(TalkRoomBaseDynamicEmoji r14) {
        Intrinsics.checkNotNullParameter(r14, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r15 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.r) com.bytedance.android.live.base.model.m.b(r14, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r.class);
        if (r15 != null) goto L5;
        return;
    L5:
        User r1 = this.l;
        if (r1 == null) goto L40;
        String r10 = r1.getIdStr();
        if (r10 != null) goto L11;
        return;
    L11:
        if (Q0() == true) goto L14;
        f2.b(2131922751, 0);
        M0(this);
        return;
    L14:
        int r2 = el0.j.b;
        el0.j.b(r15, this.j, false, this.k);
        TalkRoomEmojiPermission r3 = r15.emojiPermission;
        String r4 = null;
        if (r3 == null) goto L17;
        String r5 = r3.schemaJumpUrl;
    L19:
        if (TextUtils.isEmpty(r5) == true) goto L25;
        ILiveActionHandler r0 = jc1.k.n(ILiveActionHandler.class);
        Context r6 = getContext();
        TalkRoomEmojiPermission r16 = r15.emojiPermission;
        if (r16 == null) goto L23;
        r4 = r16.schemaJumpUrl;
    L23:
        r0.handle(r6, r4);
        M0(this);
        return;
    L25:
        TalkRoomEmojiPermission r7 = r15.emojiPermission;
        if (r7 != null) goto L28;
    L33:
        u = System.currentTimeMillis();
        p r8 = this.m;
        long r9 = this.i.id;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r15, "emoji");
        Intrinsics.checkNotNullParameter(r10, "toUserId");
        if (r8.b == false) goto L36;
        return;
    L36:
        if ((System.currentTimeMillis() - r8.d) < 1000) goto L43;
        r8.b = true;
        r8.d = System.currentTimeMillis();
        long r11 = System.currentTimeMillis();
        ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendTalkRoomInteractEmoji(r9, r15.emojiId, 4, 2, r10, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new w(r8, r15, r11), new x(r8, r15, r11));
        return;
    L43:
        return;
    L28:
        if (r7.hasPermission != true) goto L33;
        if ((System.currentTimeMillis() - u) >= this.a) goto L33;
        f2.c(this.b, 0);
        return;
    L17:
        r5 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.p.a
    public final void j8(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        UtilityKotlinExtentionsKt.t(findViewById(2131378151));
        String r0 = (String) new com.bytedance.android.livesdk.sharedpref.e("interact_emoji_list", "").getValue();
        if (StringUtils.isEmpty(r0) == false) goto L5;
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r1 = null;
    L6:
        if (r1 == null) goto L8;
        U0(r1);
    L8:
        EmojiListAdapter r2 = this.o;
        if (r2 != null) goto L11;
    L13:
        com.bytedance.android.live.liveinteract.plantform.utils.x.j(r4, true);
        return;
    L11:
        if (r2.getItemCount() != 0) goto L13;
        T0(true);
        goto L13
    L5:
        r1 = ((TalkRoomEmojiListResponse) GsonProtectorUtils.fromJson(GsonHelper.get(), r0, TalkRoomEmojiListResponse.class)).emojiList;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.p.a
    public final void kH(TalkRoomEmojiListResponse r8) {
        Intrinsics.checkNotNullParameter(r8, "response");
        UtilityKotlinExtentionsKt.t(findViewById(2131378151));
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r0 = r8.emojiList;
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r1 = r0;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        T0(true);
    L12:
        long r4 = r8.sendLimitTime;
        if (r4 > 1000) goto L16;
        r4 = 1000;
    L16:
        this.a = r4;
        String r5 = r8.getSendLimitDesc();
        if (r5 != null) goto L19;
    L20:
        r2 = true;
    L21:
        if (r2 == true) goto L24;
        this.b = r8.getSendLimitDesc();
        return;
    L24:
        return;
    L19:
        if (r5.length() != 0) goto L21;
    L11:
        T0(false);
        U0(r0);
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("interact_emoji_list", ""), GsonProtectorUtils.toJson(GsonHelper.get(), r8));
        goto L12
    L5:
        if (r1.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r11) {
        super.onCreate(r11);
        ((TextView) findViewById(2131388939)).setText(R0());
        ((TextView) findViewById(2131388938)).setText(S0());
        if (this.t == false) goto L5;
        UtilityKotlinExtentionsKt.w(findViewById(2131378151));
        UtilityKotlinExtentionsKt.w(findViewById(2131371552));
        UtilityKotlinExtentionsKt.w(findViewById(2131369197));
        UtilityKotlinExtentionsKt.w(findViewById(2131388181));
        UtilityKotlinExtentionsKt.w(findViewById(2131381814));
    L6:
        this.n = new LinkPKAudienceInteractPanelItemAdapter(P0());
        findViewById(2131388180).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        findViewById(2131388180).setAdapter(this.n);
        findViewById(2131388180).setHasFixedSize(true);
        int r12 = UIUtils.getScreenWidth(getContext());
        EmojiListAdapter r1 = new EmojiListAdapter(this.c, this.d, r12);
        this.o = r1;
        Intrinsics.checkNotNullParameter(this, "listener");
        r1.c = this;
        findViewById(2131388181).setLayoutManager(new SSGridLayoutManager(getContext(), this.c, 0));
        findViewById(2131388181).setAdapter(this.o);
        findViewById(2131388181).setHasFixedSize(true);
        findViewById(2131388181).setItemViewCacheSize(this.e * 2);
        ViewGroup.LayoutParams r13 = findViewById(2131388181).getLayoutParams();
        r13.height = this.c * s1.j(2131168802);
        GridPagerSnapHelper r14 = new BaseInteractEmojiPanel$attachSnapHelper$snapHelper$1(this);
        r14.h(this.c);
        r14.g(this.d);
        r14.attachToRecyclerView(findViewById(2131388181));
        findViewById(2131388181).addOnScrollListener(new BaseInteractEmojiPanel$attachSnapHelper$1(this));
        findViewById(2131381814).setMargin(s1.j(2131168969));
        RtlViewPagerShower r15 = findViewById(2131381814);
        Drawable r0 = s1.m(2131250379);
        Drawable r2 = s1.m(2131250380);
        r15.c = r0;
        r15.d = r2;
        p r16 = this.m;
        ((q46.b) r16).a = this;
        if (this.t == false) goto L9;
        long r3 = this.i.id;
        int r4 = O0();
        long r8 = System.currentTimeMillis();
        Disposable r5 = LinkApi.a.a((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class), r3, 8, 2, r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new q(r16, r4, r8), new r(r16, r4, r8));
        r16.e.add(r5);
    L9:
        p r17 = this.m;
        Room r6 = this.i;
        User r7 = this.l;
        Function1<IUser, Unit> r9 = new AnonymousClass1(this);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r6, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        if (r7 == null) goto L17;
        HashMap r10 = new HashMap();
        r10.put("target_uid", r7.getIdStr());
        r10.put("user_open_id", r7.getIdStr());
        r10.put("current_room_id", String.valueOf(r6.id));
        r10.put("packed_level", String.valueOf(2));
        r10.put("request_from", "admin");
        String r18 = r7.getCastSecUid();
        if (r18 != null) goto L15;
        r18 = "";
    L15:
        r10.put("sec_target_uid", r18);
        RxUtilKt.c(jc1.k.n(IUserService.class).user().d(r10).observeOn(AndroidSchedulers.mainThread()).subscribe(new u(r9), v.a), r17.e);
        return;
    L17:
        return;
    L5:
        UtilityKotlinExtentionsKt.t(findViewById(2131378151));
        UtilityKotlinExtentionsKt.t(findViewById(2131369197));
        UtilityKotlinExtentionsKt.t(findViewById(2131371552));
        UtilityKotlinExtentionsKt.t(findViewById(2131388181));
        UtilityKotlinExtentionsKt.t(findViewById(2131381814));
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.p.a
    public final void q4(com.bytedance.android.live.liveinteract.voicechat.model.a r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        if (r10.a() != null) goto L5;
        return;
    L5:
        ue r11 = r10.a();
        if (r11 == null) goto L21;
        ue r12 = r11;
        String r2 = null;
        vlc.d r0 = (vlc.d) this.r.get("data_message_manager", null);
        r12.setCurrUserIsAnchor(this.j);
        if (r0 == null) goto L10;
        r0.B(r12);
    L10:
        boolean r3 = this.j;
        String r4 = this.k;
        int r5 = dl0.n.a();
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r6 = r12.getDynamicEmoji();
        User r1 = r12.getToUser();
        if (r1 == null) goto L14;
        String r7 = r1.getIdString();
        if (r7 == null) goto L14;
    L15:
        String r8 = r7;
        User r13 = r12.getToUser();
        if (r13 == null) goto L18;
        r2 = r13.getIdString();
    L18:
        el0.j.d(r3, r4, r5, r6, r8, Boolean.valueOf(Intrinsics.areEqual(r2, this.i.getOwnerUserIdString())));
        M0(this);
        return;
    L14:
        r7 = "";
        goto L15
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LinkMicDynamicEmojiMessage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.livepkaudience.emoji.p.a
    public final void za(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if ((r2 instanceof ApiServerException) == false) goto L5;
        f2.c(((ApiServerException) r2).getPrompt(), 0);
        return;
    L5:
        ExceptionUtils.handleException(getContext(), r2);
        M0(this);
    }

    public static final void N0(BaseInteractEmojiPanel r1, int r2) {
        int r3 = r2 / r1.e;
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= r1.g) goto L10;
        r1.h = r3;
        r1.findViewById(2131381814).b(r1.h);
        return;
    }

    public BaseInteractEmojiPanel(Context r3, DataCenter r4, LinkPlayerInfo r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "userInfo");
        super(r3);
        this.q = r3;
        this.r = r4;
        this.s = r5;
        this.t = r6;
        this.a = 1000;
        this.b = s1.B(2131922729);
        this.c = 1;
        this.d = 6;
        this.e = 6;
        this.i = com.bytedance.android.live.core.utils.z.o(r4);
        this.j = com.bytedance.android.live.core.utils.z.e(r4, false);
        this.k = "seat";
        this.l = jm2.a.e(r5.getUser());
        this.m = new p();
        this.p = new b(this);
    }
}
