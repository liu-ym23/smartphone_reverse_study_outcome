package com.bytedance.android.live.livepkaudience.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.videotalk.emoji.EmojiListAdapter;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiListResponse;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomEmojiPermission;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.emoji.panel.LinkPKAudienceInteractPanelItemAdapter;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.RtlViewPagerShower;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.message.model.ue;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/emoji/BaseAudienceInteractDynamicEmojiDialog;", "Lcom/bytedance/android/live/livepkaudience/emoji/LinkCommonBottomDialog;", "Lcom/bytedance/android/live/livepkaudience/emoji/d$a;", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/s;", "Lcom/bytedance/android/live/livepkaudience/emoji/panel/f;", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseAudienceInteractDynamicEmojiDialog extends LinkCommonBottomDialog implements d.a, com.bytedance.android.live.liveinteract.videotalk.emoji.s, com.bytedance.android.live.livepkaudience.emoji.panel.f {
    public static long A;
    public final int a;
    public final int b;
    public long c;
    public String d;
    public LinkPKAudienceInteractPanelItemAdapter e;
    public EmojiListAdapter f;
    public d g;
    public com.bytedance.android.live.livepkaudience.base.i h;
    public x0 i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public long p;
    public int q;
    public int r;
    public int s;
    public String t;
    public final List<com.bytedance.android.live.livepkaudience.emoji.panel.g> u;
    public com.bytedance.android.live.livepkaudience.emoji.panel.g v;
    public final CompositeDisposable w;
    public final com.bytedance.android.live.livepkaudience.emoji.a x;
    public final DataCenter y;
    public final boolean z;

    public static final class a {
    }

    static {
    }

    public abstract void O0();

    public abstract void P0();

    public abstract boolean Q0();

    public int R0() {
        return 1;
    }

    public abstract void T0();

    public abstract void U0();

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void f() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void g() {
    }

    public final int getLayoutId() {
        return 2131565596;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void h() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void w5() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void x5(boolean r1, boolean r2) {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void y5() {
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public void z5(int r1, boolean r2) {
    }

    public final void S0() {
        x0 r0 = this.i;
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
    public final void dismiss() {
        d r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        r0.detachView();
        hd0.c.f().e(this.x);
        this.w.clear();
        ALogger.w("ttlive_link", "self panel dismissed");
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void k() {
        el0.j.g(this.t, dl0.n.d());
        W0(2131919829);
        d r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L5:
        long r1 = this.p;
        String r3 = dl0.n.d();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        if (r0.c == true) goto L10;
        r0.c = true;
        Disposable r2 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).unSilence(r1, r3, r3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(r0, r3), new l(r0, r3));
        r0.f.add(r2);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void disconnect() {
        M0(this);
        U0();
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void e() {
        if (Q0() == false) goto L18;
        String r0 = this.t;
        com.bytedance.android.live.livepkaudience.base.i r1 = this.h;
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(c.a(r1));
    L8:
        el0.j.h(r0, r2, dl0.n.d());
        W0(2131919826);
        d r3 = this.g;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L11:
        long r4 = this.p;
        String r5 = dl0.n.d();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "toRevUid");
        if (r5 != null) goto L15;
        r5 = "0";
    L15:
        if (r3.b == true) goto L21;
        r3.b = true;
        Disposable r6 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).silence(r4, r5, r5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r3, r5), new j(r3, r5));
        r3.f.add(r6);
        return;
    L21:
        return;
    L7:
        r2 = null;
        goto L8
    L18:
        f2.b(2131919216, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.LinkCommonBottomDialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        String r0 = this.t;
        int r1 = el0.j.b;
        Intrinsics.checkNotNullParameter(r0, "requestPage");
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("user_type", "guest");
        r2.put("user_id", jc1.k.n(IUserService.class).user().n());
        r2.put("request_page", r0);
        r2.put("interact_type", "self");
        int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        el0.j.l(r2, r3);
        el0.j.j(r2, Integer.valueOf(r3));
        el0.j.o(r2);
        el0.j.n(r2, Integer.valueOf(r3));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_chat_emoji_panel_show", r2, new Object[]{am2.x.class, Room.class});
        hd0.c.f().c(this.x);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.f
    public final void dismissDialog() {
        M0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void M0(BaseAudienceInteractDynamicEmojiDialog r3) {
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

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void D(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        S0();
        M0(this);
        this.n = true;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void E3(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        findViewById(2131378151).setVisibility(8);
        String r0 = (String) new com.bytedance.android.livesdk.sharedpref.e("dynamic_emoji_list", "").getValue();
        if (StringUtils.isEmpty(r0) == false) goto L5;
        List<com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r1 = null;
    L6:
        if (r1 == null) goto L8;
        Y0(r1);
    L8:
        EmojiListAdapter r2 = this.f;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L12:
        if (r2.getItemCount() != 0) goto L14;
        V0(true);
    L14:
        com.bytedance.android.live.liveinteract.plantform.utils.x.j(r4, false);
        return;
    L5:
        r1 = ((TalkRoomEmojiListResponse) GsonProtectorUtils.fromJson(GsonHelper.get(), r0, TalkRoomEmojiListResponse.class)).emojiList;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void G(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        S0();
        M0(this);
        this.n = false;
    }

    public final void V0(boolean r5) {
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
    public final void W0(int r4) {
        if (this.i != null) goto L5;
        Context r0 = getContext();
        x0.d r1 = new x0.d();
        r1.b = r0;
        r1.a = 2;
        r1.d = r0.getText(r4);
        r1.k = false;
        this.i = new x0(r1.b, r1);
    L5:
        x0 r5 = this.i;
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

    public final boolean X0(Throwable r3) {
        if ((r3 instanceof ApiServerException) == false) goto L8;
        ApiServerException r4 = (ApiServerException) r3;
        if (TextUtils.isEmpty(r4.getPrompt()) == true) goto L8;
        f2.c(r4.getPrompt(), 0);
        return true;
    L8:
        return false;
    }

    public final void Y0(List<? extends com.bytedance.android.live.liveinteract.videotalk.emoji.model.r> r6) {
        EmojiListAdapter r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L5:
        r0.y2(r6);
        int r1 = r6.size() / this.l;
        int r2 = 0;
        if ((r6.size() % this.l) <= 0) goto L8;
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

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void c0(TalkRoomBaseDynamicEmoji r4) {
        Intrinsics.checkNotNullParameter(r4, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r5 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.r) com.bytedance.android.live.base.model.m.b(r4, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r.class);
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = el0.j.b;
        el0.j.c(this.m, this.t, r5, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.s
    public final void j0(TalkRoomBaseDynamicEmoji r11) {
        Intrinsics.checkNotNullParameter(r11, "emoji");
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r12 = (com.bytedance.android.live.liveinteract.videotalk.emoji.model.r) com.bytedance.android.live.base.model.m.b(r11, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r.class);
        if (r12 != null) goto L5;
        return;
    L5:
        int r1 = el0.j.b;
        el0.j.b(r12, this.m, true, this.t);
        TalkRoomEmojiPermission r2 = r12.emojiPermission;
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.schemaJumpUrl;
    L10:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        ILiveActionHandler r0 = jc1.k.n(ILiveActionHandler.class);
        Context r5 = getContext();
        TalkRoomEmojiPermission r13 = r12.emojiPermission;
        if (r13 == null) goto L14;
        r3 = r13.schemaJumpUrl;
    L14:
        r0.handle(r5, r3);
        M0(this);
        return;
    L16:
        TalkRoomEmojiPermission r6 = r12.emojiPermission;
        if (r6 != null) goto L19;
    L24:
        d r7 = this.g;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L27:
        long r8 = this.p;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r12, "emoji");
        if (r7.d == false) goto L30;
    L33:
        A = System.currentTimeMillis();
        return;
    L30:
        if ((System.currentTimeMillis() - r7.e) < 1000) goto L33;
        r7.d = true;
        r7.e = System.currentTimeMillis();
        long r9 = System.currentTimeMillis();
        r7.f.add(((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).sendTalkRoomEmoji(r8, r12.emojiId).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r7, r12, r9), new h(r7, r12, r9)));
        goto L33
    L19:
        if (r6.hasPermission != true) goto L24;
        if ((System.currentTimeMillis() - A) >= this.c) goto L24;
        f2.c(this.d, 0);
        return;
    L8:
        r4 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r14) {
        super.onCreate(r14);
        boolean r15 = ((Boolean) this.y.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.m = r15;
        ViewGroup.LayoutParams r0 = null;
        if (r15 == false) goto L7;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r16 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r16 == null) goto L10;
        com.bytedance.android.live.livepkaudience.base.i r17 = r16.getLinkUserCenter();
    L11:
        this.h = r17;
        int r1 = 0;
        if (r17 == null) goto L22;
        String r3 = dl0.n.d();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r4 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r4 == null) goto L16;
        String r5 = r4.getAudienceSelfLinkMicId();
    L17:
        LinkPlayerInfo r18 = r17.o(r3, r5);
        if (r18 == null) goto L22;
        if (r18.silenceStatus == 0) goto L22;
        boolean r19 = true;
    L23:
        this.n = r19;
        com.bytedance.android.live.livepkaudience.base.i r110 = this.h;
        if (r110 == null) goto L32;
        String r6 = dl0.n.d();
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r7 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r7 == null) goto L28;
        String r8 = r7.getAudienceSelfLinkMicId();
    L29:
        LinkPlayerInfo r111 = r110.o(r6, r8);
        if (r111 == null) goto L32;
        int r112 = r111.getLinkType();
    L33:
        this.o = r112;
        Room r113 = (Room) this.y.get("data_room");
        if (r113 == null) goto L36;
        long r9 = r113.id;
    L37:
        this.p = r9;
        T0();
        int r114 = this.a;
        this.j = r114;
        int r10 = this.b;
        this.k = r10;
        this.l = r114 * r10;
        if (this.z == false) goto L40;
        findViewById(2131378151).setVisibility(0);
        findViewById(2131388181).setVisibility(0);
        findViewById(2131381814).setVisibility(0);
    L41:
        EmojiListAdapter r11 = new EmojiListAdapter(this.a, this.b, UIUtils.getScreenWidth(getContext()));
        this.f = r11;
        Intrinsics.checkNotNullParameter(this, "listener");
        r11.c = this;
        SSGridLayoutManager r115 = new SSGridLayoutManager(getContext(), this.j, 0);
        RecyclerView r12 = findViewById(2131388181);
        EmojiListAdapter r13 = this.f;
        if (r13 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L44:
        r12.setAdapter(r13);
        findViewById(2131388181).setLayoutManager(r115);
        findViewById(2131388181).setHasFixedSize(true);
        findViewById(2131388181).setItemViewCacheSize(this.l * 2);
        GridPagerSnapHelper r116 = new BaseAudienceInteractDynamicEmojiDialog$attachSnapHelper$snapHelper$1(this);
        r116.h(this.j);
        r116.g(this.k);
        r116.attachToRecyclerView(findViewById(2131388181));
        findViewById(2131388181).addOnScrollListener(new BaseAudienceInteractDynamicEmojiDialog$attachSnapHelper$1(this));
        findViewById(2131381814).setMargin(s1.j(2131168969));
        RtlViewPagerShower r117 = findViewById(2131381814);
        Drawable r20 = s1.m(2131250379);
        Drawable r21 = s1.m(2131250380);
        r117.c = r20;
        r117.d = r21;
        if (this.z == false) goto L51;
        d r118 = this.g;
        if (r118 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mPresenter");
    L49:
        long r22 = this.p;
        int r23 = R0();
        r118.getClass();
        long r119 = System.currentTimeMillis();
        r118.f.add(LinkApi.a.a((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class), r22, 8, 1, r23).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r118, r23, r119), new f(r118, r23, r119)));
    L51:
        if (this.m == false) goto L53;
        char r120 = '\b';
    L55:
        if (r120 != 0) goto L63;
        ((TextView) findViewById(2131390507)).setVisibility(0);
        ViewGroup.LayoutParams r121 = ((TextView) findViewById(2131388772)).getLayoutParams();
        if ((r121 instanceof FrameLayout.LayoutParams) == false) goto L60;
        r0 = r121;
    L60:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r0;
        if (r2 == null) goto L70;
        r2.gravity = 8388627;
        ((TextView) findViewById(2131388772)).setLayoutParams(r2);
    L70:
        ((TextView) findViewById(2131390507)).setOnClickListener(new b(this));
        P0();
        O0();
        this.e = new LinkPKAudienceInteractPanelItemAdapter(this.u);
        findViewById(2131388180).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        findViewById(2131388180).setAdapter(this.e);
        findViewById(2131388180).setHasFixedSize(true);
        RecyclerView r24 = findViewById(2131388180);
        if (((ArrayList) this.u).size() > 0) goto L74;
        r1 = 8;
    L74:
        r24.setVisibility(r1);
        findViewById(2131374137).setVisibility(findViewById(2131388180).getVisibility());
        TextView r122 = (TextView) findViewById(2131388772);
        if (r122 == null) goto L78;
        r122.setText(getContext().getString(2131922726));
        return;
    L78:
        return;
    L63:
        ((TextView) findViewById(2131390507)).setVisibility(8);
        ViewGroup.LayoutParams r123 = ((TextView) findViewById(2131388772)).getLayoutParams();
        if ((r123 instanceof FrameLayout.LayoutParams) == false) goto L67;
        r0 = r123;
    L67:
        FrameLayout.LayoutParams r25 = (FrameLayout.LayoutParams) r0;
        if (r25 == null) goto L70;
        r25.gravity = 17;
        ((TextView) findViewById(2131388772)).setLayoutParams(r25);
        goto L70
    L53:
        r120 = 0;
        goto L55
    L40:
        findViewById(2131378151).setVisibility(8);
        findViewById(2131388181).setVisibility(8);
        findViewById(2131381814).setVisibility(8);
        goto L41
    L36:
        r9 = 0;
        goto L37
    L28:
        r8 = null;
    L32:
        r112 = 2;
        goto L33
    L16:
        r5 = null;
    L22:
        r19 = false;
    L10:
        r17 = null;
        goto L11
    L7:
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r124 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r124 == null) goto L10;
        r17 = r124.getLinkUserCenter();
        goto L11
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void vM(TalkRoomEmojiListResponse r6) {
        Intrinsics.checkNotNullParameter(r6, "response");
        findViewById(2131378151).setVisibility(8);
        if (Lists.isEmpty(r6.emojiList) == true) goto L5;
        V0(false);
        Y0(r6.emojiList);
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("dynamic_emoji_list", ""), GsonProtectorUtils.toJson(GsonHelper.get(), r6));
    L6:
        long r0 = r6.sendLimitTime;
        if (r0 > 1000) goto L10;
        r0 = 1000;
    L10:
        this.c = r0;
        String r7 = r6.getSendLimitDesc();
        if (r7 == null) goto L14;
        this.d = r7;
        return;
    L14:
        return;
    L5:
        V0(true);
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void w2(com.bytedance.android.live.liveinteract.voicechat.model.a r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        ue r0 = r10.a();
        if (r0 == null) goto L10;
        ue r1 = r0;
        M0(this);
        vlc.d r2 = (vlc.d) this.y.get("data_message_manager", null);
        r1.setCurrUserIsAnchor(this.m);
        if (r2 == null) goto L7;
        r2.B(r1);
    L7:
        el0.j.d(this.m, this.t, dl0.n.a(), r1.getDynamicEmoji(), null, null);
        w8 r11 = r10.a();
        Intrinsics.checkNotNull(r11);
        com.bytedance.android.live.liveinteract.plantform.utils.x.s0(r11.getMessageId(), r1.getDynamicEmoji());
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LinkMicDynamicEmojiMessage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void w6(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "throwable");
        if (X0(r2) == true) goto L5;
        ExceptionUtils.handleException(getContext(), r2);
        M0(this);
    L5:
        com.bytedance.android.live.liveinteract.plantform.utils.x.r0(r2, false);
    }

    public static final void N0(BaseAudienceInteractDynamicEmojiDialog r1, int r2) {
        int r3 = r2 / r1.l;
        if (r3 >= 0) goto L5;
        return;
    L5:
        if (r3 >= r1.r) goto L10;
        r1.s = r3;
        r1.findViewById(2131381814).b(r1.s);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void F(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        X0(r3);
        S0();
        M0(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.d.a
    public final void r(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r3, "throwable");
        X0(r3);
        S0();
        M0(this);
    }

    public BaseAudienceInteractDynamicEmojiDialog(Context r2, DataCenter r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2);
        this.y = r3;
        this.z = r4;
        this.a = 2;
        this.b = 6;
        this.c = 1000;
        this.d = s1.B(2131922729);
        this.o = 2;
        this.t = "";
        this.u = new ArrayList();
        this.w = new CompositeDisposable();
        this.x = new com.bytedance.android.live.livepkaudience.emoji.a(this);
    }
}
