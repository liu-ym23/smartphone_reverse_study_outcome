package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.cb1;
import com.bytedance.android.livesdk.config.y80;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import j40.l1;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/toolbar/ToolbarOpenPlatformMiniGameBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "g", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarOpenPlatformMiniGameBehavior implements c0.b, Observer<KVData> {
    public final String a;
    public View b;
    public HSImageView c;
    public HSImageView d;
    public boolean e;
    public final CompositeDisposable f;
    public final Context g;
    public final boolean h;

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final Context getContext() {
        return this.g;
    }

    public final void Mr(s r4) {
        if (r4 == null) goto L6;
        boolean r1 = true;
        if (r4.n != true) goto L6;
    L7:
        this.e = r1;
        String r0 = this.a;
        StringBuilder r2 = new StringBuilder("Behavior onBehaviorUpdate, isAnchor=");
        r2.append(this.h);
        r2.append(", toolbarButton: ");
        if (r4 == null) goto L10;
        String r5 = r4.toString();
    L11:
        r2.append(r5);
        Logger.d(r0, r2.toString());
        return;
    L10:
        r5 = null;
    L6:
        r1 = false;
        goto L7
    }

    public final void SY(s r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        this.e = r2;
        Logger.d(this.a, "Behavior onShow, isAnchor=" + this.h + ", this=" + this);
        final Ref.IntRef r3 = new Ref.IntRef();
        r3.element = 2131251143;
        if (this.h == false) goto L24;
        int r8 = com.bytedance.android.livesdk.utils.landscape.d.a;
        cb1 r9 = (cb1) l1.a.getValue();
        if (r9 == null) goto L15;
        Boolean r10 = r9.b();
        if (r10 == null) goto L15;
        r0 = r10.booleanValue();
    L15:
        if (r0 == false) goto L17;
    L20:
        int r11 = 2131250905;
    L21:
        HSImageView r1 = this.c;
        if (r1 == null) goto L43;
        r1.setActualImageResource(r11);
        return;
    L43:
        return;
    L17:
        if (LiveOpenFeatureChooseConfig.useV3() == true) goto L20;
        r11 = 2131250904;
        goto L21
    L24:
        int r4 = com.bytedance.android.livesdk.utils.landscape.d.a;
        cb1 r5 = (cb1) l1.a.getValue();
        if (r5 == null) goto L28;
        String r6 = r5.a();
        if (r6 == null) goto L28;
    L30:
        if (((Boolean) y80.a.getValue()).booleanValue() == false) goto L35;
        if (r7 != null) goto L33;
    L39:
        Logger.d(this.a, "Behavior onShow skip");
        HSImageView r12 = this.c;
        if (r12 == null) goto L47;
        r12.setActualImageResource(r3.element);
        return;
    L47:
        return;
    L33:
        if (r7.n == true) goto L39;
    L35:
        if ((!Intrinsics.areEqual(r6, "")) == false) goto L39;
        HSImageView r13 = this.d;
        Function0<Unit> r14 = new ToolbarOpenPlatformMiniGameBehavior$onShow$1(this, r3);
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = r14;
        if (r13 == null) goto L45;
        r13.setController(Fresco.newDraweeControllerBuilder().setUri(r6).setAutoPlayAnimations(false).setControllerListener(new g(new ToolbarOpenPlatformMiniGameBehavior$runEnterAnimation$4(r15), new ToolbarOpenPlatformMiniGameBehavior$runEnterAnimation$1(this), ToolbarOpenPlatformMiniGameBehavior$runEnterAnimation$2.INSTANCE, ToolbarOpenPlatformMiniGameBehavior$runEnterAnimation$3.INSTANCE)).build());
        return;
    L45:
        return;
    L28:
        r6 = "";
        goto L30
    L5:
        if (r7.n != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r6.getKey(), "cmd_notify_live_game_play_toolbar_show_bubble") == false) goto L13;
        View r7 = this.b;
        if (r7 != null) goto L10;
        return;
    L10:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L15;
        this.f.add(((SingleSubscribeProxy) Single.timer(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.g))).subscribe(new i(this, r7)));
        return;
    L15:
        return;
    }

    public final void onClick(View r3) {
        if (this.h == false) goto L7;
        IOpenPlatformMgAnchorService r4 = (IOpenPlatformMgAnchorService) k.f(IOpenPlatformMgAnchorService.class);
        if (r4 == null) goto L14;
        r4.openBottomFeaturePanel(this.g, null);
        return;
    L14:
        return;
    L7:
        IOpenPlatformMgAudienceService r5 = (IOpenPlatformMgAudienceService) k.f(IOpenPlatformMgAudienceService.class);
        if (r5 == null) goto L10;
        r5.reportMpClick(MountedMiniGameSource.Toolbar);
    L10:
        IOpenPlatformMgAudienceService r6 = (IOpenPlatformMgAudienceService) k.f(IOpenPlatformMgAudienceService.class);
        if (r6 == null) goto L16;
        r6.openMountedMiniGame(MountedMiniGameSource.Toolbar, null);
        return;
    }

    public final void onHide(boolean r4) {
        Logger.d(this.a, "Behavior onHide, isAnchor=" + this.h + ", isFromMsg = " + r4);
    }

    public ToolbarOpenPlatformMiniGameBehavior(Context r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.g = r2;
        this.h = r3;
        this.a = "ToolbarOpenPlatformMiniGameBehavior";
        this.f = new CompositeDisposable();
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Logger.d(this.a, "Behavior onUnload, isAnchor=" + this.h + " this=" + this);
        this.f.clear();
        if (this.h == false) goto L6;
        ((IOpenPlatformMgAnchorService) k.n(IOpenPlatformMgAnchorService.class)).setMountStatus(false);
        return;
    L6:
        if (((Boolean) y80.a.getValue()).booleanValue() == true) goto L8;
    L9:
        ((IOpenPlatformMgAudienceService) k.n(IOpenPlatformMgAudienceService.class)).setMountStatus(false);
        return;
    L8:
        if (this.e == false) goto L9;
    }

    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Logger.d(this.a, "Behavior onLoad, isAnchor=" + this.h + ", this=" + this);
        this.b = r4;
        this.c = r4.findViewById(2131381529);
        this.d = r4.findViewById(2131381524);
        r5.observe("cmd_notify_live_game_play_toolbar_show_bubble", this);
    }
}
