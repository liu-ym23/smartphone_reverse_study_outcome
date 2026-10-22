package com.bytedance.android.live.broadcastgame.openplatform.behavior;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.broadcast.api.BubblePosition;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.xplay.f1;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.message.model.m;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemBubbleInfo;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.k;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import p11.j;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/behavior/ToolbarInteractPlayControlBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarInteractPlayControlBehavior implements c0.b, Observer<KVData>, l {
    public View a;
    public boolean b;
    public ObjectAnimator c;
    public final CompositeDisposable d;
    public boolean e;
    public String f;
    public vlc.d g;

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public ToolbarInteractPlayControlBehavior() {
        this.b = true;
        this.d = new CompositeDisposable();
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r6.getKey(), "cmd_notify_live_game_play_toolbar_show_bubble") == false) goto L13;
        View r7 = this.a;
        if (r7 != null) goto L10;
        return;
    L10:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L15;
        this.d.add(((SingleSubscribeProxy) Single.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r7.getContext()))).subscribe(new e(r7)));
        return;
    L15:
        return;
    }

    public final void onClick(View r5) {
        if (this.b == true) goto L5;
        return;
    L5:
        String r0 = "";
        if (this.e == true) goto L8;
    L39:
        XplayExternalContext r6 = XplayExternalContext.Companion.getContext();
        if (r6 == null) goto L50;
        k<String> r7 = r6.getOpenGameMoreDialog();
        if (r7 == null) goto L51;
        r7.post("");
        return;
    L51:
        return;
    L50:
        return;
    L8:
        if (r2.a(this.f) == false) goto L39;
        String r8 = this.f;
        if (r8 != null) goto L13;
        return;
    L13:
        if (this.e == false) goto L19;
        HashMap<String, String> r1 = new HashMap();
        r1.put("user_type", "anchor");
        ILinkServiceExternal r2 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r2 == null) goto L19;
        lc0.a r3 = r2.getControlService();
        if (r3 == null) goto L19;
        r3.d("livesdk_cohost_game_operate_icon_click", r1);
    L19:
        u6 r4 = new u6(r8);
        u6 r9 = r4.d(LiveSlardarConstants.EXTRA_KEY_URL);
        boolean r11 = h.a;
        j r12 = h.d(ILinkService.class).getRevenueLinkDataHolder();
        if (r12 == null) goto L22;
        Long r13 = Long.valueOf(r12.getChannelId());
    L23:
        String r14 = String.valueOf(r13.longValue());
        if (r14 == null) goto L27;
        r0 = r14;
    L27:
        r9.b("channel_id", r0);
        Uri r15 = r4.c();
        View r16 = this.a;
        if (r16 == null) goto L47;
        Context r17 = r16.getContext();
        if (r17 == null) goto L48;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L33
        Object r19 = Result.constructor-impl(((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialog(r17, r15, new c()));     // Catch: Throwable -> L33
    L35:
        Throwable r21 = Result.exceptionOrNull-impl(r19);
        if (r21 == null) goto L38;
        int r22 = q.a;
        q.e("ToolbarInteractPlayControlBehavior", new Object[]{"rev link lynx start failed, cause: " + r21.getCause() + ", message: " + r21.getMessage()});
    L38:
        Result.box-impl(r19);
        return;
    L33:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    L48:
        return;
    L47:
        return;
    L22:
        r13 = null;
        goto L23
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof m) == false) goto L23;
        m r6 = (m) r5;
        if (r6.getIntType() != MessageType.ANCHOR_COMMON_BUBBLE_MESSAGE.getIntType()) goto L24;
        View r0 = this.a;
        if (r0 == null) goto L25;
        ItemBubbleInfo r7 = r6.E();
        if (r7 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r7.getShowItemId(), String.valueOf(6)) == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L27;
        IBroadcastService r1 = (IBroadcastService) jc1.k.f(IBroadcastService.class);
        if (r1 == null) goto L28;
        nz.h r2 = r1.getBroadcastBubbleManager();
        if (r2 == null) goto L29;
        CompositeDisposable r8 = r2.a(r0.getContext(), r0, r7, BubblePosition.Top);
        if (r8 == null) goto L30;
        RxUtilKt.c(r8, this.d);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L25:
        return;
    L24:
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        vlc.d r4 = this.g;
        if (r4 == null) goto L5;
        r4.removeMessageListener(this);
    L5:
        this.b = true;
        this.a = null;
        this.d.dispose();
    }

    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.a = r5;
        HSImageView r7 = (HSImageView) r5.findViewById(2131374718);
        if (this.e == false) goto L5;
        int r3 = f1.a;
        Pair r0 = TuplesKt.to(2131251439, f1.b(XplayScene.RevenueLink, true, false));
    L6:
        int r1 = ((Number) r0.component1()).intValue();
        String r2 = (String) r0.component2();
        if (r2 != null) goto L9;
    L14:
        if (r7 == null) goto L17;
        r7.setActualImageResource(r1);
    L17:
        if (this.e == false) goto L23;
        HashMap<String, String> r8 = new HashMap();
        r8.put("user_type", "anchor");
        ILinkServiceExternal r4 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r4 == null) goto L23;
        lc0.a r9 = r4.getControlService();
        if (r9 == null) goto L23;
        r9.d("livesdk_cohost_game_operate_icon_show", r8);
    L23:
        vlc.d r11 = (vlc.d) r6.get("data_message_manager", null);
        this.g = r11;
        if (r11 == null) goto L26;
        r11.addMessageListener(MessageType.ANCHOR_COMMON_BUBBLE_MESSAGE.getIntType(), this);
    L26:
        r6.observe("cmd_notify_live_game_play_toolbar_show_bubble", this);
        return;
    L9:
        if (r2.a(r2) == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L14;
        a1.n(r7, r2);
        goto L17
    L5:
        int r12 = f1.a;
        r0 = TuplesKt.to(2131251100, f1.b(XplayScene.Video, true, false));
        goto L6
    }
}
