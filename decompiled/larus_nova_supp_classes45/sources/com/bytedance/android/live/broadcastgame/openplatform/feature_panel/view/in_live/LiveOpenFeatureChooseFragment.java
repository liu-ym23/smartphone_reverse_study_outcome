package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.LiveOpenFeatureChooseListFragmentV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.LiveOpenFeaturePanelViewModel;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ah;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveOpenFeatureChooseConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.DataContext;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureChooseFragment;", "Lcom/bytedance/android/livesdk/widget/LiveBottomSheetDialogFragment;", "<init>", "()V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseFragment extends LiveBottomSheetDialogFragment {
    public static boolean i;
    public BaseFragment d;
    public AbsLiveOpenFeatureChooseFragment e;
    public LiveOpenFeaturePanelViewModel f;
    public final CompositeDisposable g;
    public final LiveOpenFeatureChooseFragment$fragmentLifecycleCallbacks$1 h;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {
        public final /* synthetic */ LiveOpenFeatureChooseFragment a;

        public b(LiveOpenFeatureChooseFragment r1) {
            this.a = r1;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }

        public final boolean disableDragDown() {
            LiveOpenFeaturePanelViewModel r0 = this.a.f;
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.getDisablePanelDragDown$livebroadcastgame_impl_saasRelease();
        }
    }

    public static final class c implements LiveBottomSheetDialog.k {
        public final /* synthetic */ LiveBottomSheetDialog a;
        public final /* synthetic */ LiveOpenFeatureChooseFragment b;

        public c(LiveBottomSheetDialog r1, LiveOpenFeatureChooseFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(boolean r5) {
            int r6 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
            Context r7 = this.b.getContext();
            Window r0 = this.a.getWindow();
            if (r0 == null) goto L11;
            View r1 = r0.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L9;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r2 = ThreadMethodProxy.currentThread();
            if (r2 == com.larus.home.impl.utils.c.a) goto L9;
            com.larus.home.impl.utils.c.a(r2, "getDecorView");
        L9:
            if (r1 == null) goto L11;
            View r3 = r1.findFocus();
        L12:
            com.bytedance.android.live.broadcastgame.opengame.utils.l.a(r7, r3);
            return;
        L11:
            r3 = null;
            goto L12
        }
    }

    static {
    }

    public final String getDegradeTag() {
        return "interact_panel";
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.LiveOpenFeatureChooseFragment$fragmentLifecycleCallbacks$1] */
    public LiveOpenFeatureChooseFragment() {
        this.g = new CompositeDisposable();
        this.h = new LiveOpenFeatureChooseFragment$fragmentLifecycleCallbacks$1(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ft0 r0 = ft0.a;
        if (((k81) r0.getValue()).b() == false) goto L8;
        this.g.clear();
        if (((k81) r0.getValue()).a() == false) goto L9;
        getChildFragmentManager().unregisterFragmentLifecycleCallbacks(this.h);
        return;
    L9:
        return;
    }

    public final void S90(DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r4);
        if (((Boolean) ah.a.getValue()).booleanValue() == false) goto L6;
        y3.l().b(ToolbarButton.INTERACT_GAME, new pp1.j(false));
        return;
    }

    public final void onCreate(Bundle r9) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r9);
        setStyle(1, 2131954751);
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        r0.updateSwitchSceneSource("interaction_button");
    L5:
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("source", "interaction_button"), TuplesKt.to("request_page", "Link_panel")});
        Integer r2 = Integer.valueOf(jc1.k.n(IInteractService.class).getCurrentScene());
        Intrinsics.checkNotNullParameter(r1, "logMap");
        if (r2 != null) goto L9;
    L22:
        if (r2 != null) goto L25;
    L27:
        if (r2 != null) goto L30;
    L32:
        if (r2 != null) goto L35;
    L37:
        if (r2 != null) goto L40;
    L42:
        if (r2 != null) goto L45;
    L47:
        ft0 r3 = ft0.a;
        if (((k81) r3.getValue()).b() == false) goto L77;
        IBrowserService r4 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r4 == null) goto L58;
        Observable<SubscriberJsEvent> r5 = r4.registerJsEventSubscriber("live_broadcast_interact_close_panel");
        if (r5 == null) goto L58;
        Observable r6 = r5.observeOn(AndroidSchedulers.mainThread());
        if (r6 == null) goto L58;
        Disposable r7 = r6.subscribe(new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.c(this));
        if (r7 == null) goto L58;
        RxUtilKt.c(r7, this.g);
    L58:
        IBrowserService r8 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r8 == null) goto L67;
        Observable<SubscriberJsEvent> r11 = r8.registerJsEventSubscriber("live_broadcast_interact_dialog_event");
        if (r11 == null) goto L67;
        Observable r12 = r11.observeOn(AndroidSchedulers.mainThread());
        if (r12 == null) goto L67;
        Disposable r13 = r12.subscribe(new d(this));
        if (r13 == null) goto L67;
        RxUtilKt.c(r13, this.g);
    L67:
        IBrowserService r14 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r14 == null) goto L77;
        Observable<SubscriberJsEvent> r15 = r14.registerJsEventSubscriber("live_broadcast_interact_refresh_panel");
        if (r15 == null) goto L77;
        Observable r16 = r15.observeOn(AndroidSchedulers.mainThread());
        if (r16 == null) goto L77;
        Disposable r17 = r16.subscribe(new e(this));
        if (r17 == null) goto L77;
        RxUtilKt.c(r17, this.g);
    L77:
        if (LiveOpenFeatureChooseConfig.useV3() == true) goto L85;
        IOpenPlatformMgAnchorService r18 = jc1.k.f(IOpenPlatformMgAnchorService.class);
        if (r18 == null) goto L83;
        Map r19 = r18.getMiniGameLotteryCommonLogMap();
        if (r19 == null) goto L83;
        r1.putAll(r19);
    L83:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_function_panel_show", r1, new Object[]{Room.class});
    L85:
        if (((k81) r3.getValue()).a() == false) goto L88;
        getChildFragmentManager().registerFragmentLifecycleCallbacks(this.h, true);
        return;
    L88:
        return;
    L45:
        if (r2.intValue() != 12) goto L47;
        r1.put("function_type", "party");
        goto L47
    L40:
        if (r2.intValue() != 4) goto L42;
        r1.put("function_type", "audience");
        goto L47
    L35:
        if (r2.intValue() != 10) goto L37;
        r1.put("function_type", "watch");
        goto L47
    L30:
        if (r2.intValue() != 9) goto L32;
        r1.put("function_type", "ktv");
        goto L47
    L25:
        if (r2.intValue() != 8) goto L27;
        r1.put("function_type", "radio");
        goto L47
    L9:
        if (r2.intValue() != 5) goto L22;
        r1.put("function_type", "radio");
        DataContext r21 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r21 instanceof RoomContext) == true) goto L13;
        r21 = null;
    L13:
        RoomContext r22 = (RoomContext) r21;
        if (r22 == null) goto L47;
        com.bytedance.live.datacontext.m r23 = r22.getRoom();
        if (r23 == null) goto L47;
        Room r24 = (Room) r23.getValue();
        if (r24 == null) goto L47;
        if (d0.h(r24) == false) goto L47;
        r1.put("function_type", "party");
        goto L47
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Context r0 = getContext();
        if (r0 == null) goto L28;
        LiveBottomSheetDialog r4 = new LiveBottomSheetDialog(r0, getTheme());
        Window r1 = r4.getWindow();
        if (r1 == null) goto L7;
        r1.clearFlags(RomUtils.SZ);
    L7:
        Window r2 = r4.getWindow();
        if (r2 == null) goto L10;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r2.addFlags(Integer.MIN_VALUE);
    L10:
        Window r5 = r4.getWindow();
        if (r5 == null) goto L13;
        r5.clearFlags(67108864);
    L13:
        Window r6 = r4.getWindow();
        if (r6 == null) goto L16;
        r6.setStatusBarColor(s1.h(2131106784));
    L16:
        Window r7 = r4.getWindow();
        if (r7 == null) goto L19;
        r7.setNavigationBarColor(s1.h(2131100641));
    L19:
        Window r8 = r4.getWindow();
        if (r8 == null) goto L22;
        r8.setGravity(80);
    L22:
        Window r9 = r4.getWindow();
        if (r9 == null) goto L25;
        r9.setDimAmount(0.0f);
    L25:
        r4.setCanceledOnTouchOutside(true);
        r4.setNeedHookBottomSheetInterceptEvent(true);
        r4.setBottomSheetSlideProcessor(new b(this));
        r4.setLiveBottomSheetOutsideListener(new c(r4, this));
        return r4;
    L28:
        return super.onCreateDialog(r3);
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        if (this.f == null) goto L5;
    L13:
        LiveOpenFeaturePanelViewModel r7 = this.f;
        if (r7 == null) goto L18;
        LiveData<Boolean> r8 = r7.getOpenSearchPage();
        if (r8 == null) goto L18;
        r8.observe(this, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.a(this));
    L18:
        LiveOpenFeaturePanelViewModel r9 = this.f;
        if (r9 == null) goto L24;
        LiveData<Boolean> r11 = r9.getClosePanel();
        if (r11 == null) goto L24;
        r11.observe(this, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.b(this));
    L24:
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L39;
        if (this.e != null) goto L28;
        this.e = new LiveOpenFeatureChooseListFragmentV3();
    L28:
        AbsLiveOpenFeatureChooseFragment r12 = this.e;
        if (r12 == null) goto L37;
        FragmentTransaction r1 = getChildFragmentManager().beginTransaction();
        if (getChildFragmentManager().findFragmentByTag(LiveOpenFeatureChooseListFragmentV3.class.getName()) != null) goto L37;
        String r2 = LiveOpenFeatureChooseListFragmentV3.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r2, 2131372183) == true) goto L36;
        r1.add(2131372183, r12, r2);
    L36:
        r1.commitAllowingStateLoss();
    L37:
        UIUtils.updateLayout(r5.findViewById(2131372183), -3, (int) (((double) s1.w()) * 0.7d));
    L51:
        if (i == true) goto L54;
        i = true;
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.c();
        return;
    L54:
        return;
    L39:
        if (this.e != null) goto L41;
        this.e = new LiveOpenFeatureChooseListFragment();
    L41:
        AbsLiveOpenFeatureChooseFragment r13 = this.e;
        if (r13 == null) goto L51;
        FragmentTransaction r14 = getChildFragmentManager().beginTransaction();
        if (getChildFragmentManager().findFragmentByTag(LiveOpenFeatureChooseListFragment.class.getName()) != null) goto L51;
        String r3 = LiveOpenFeatureChooseListFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r3, 2131372183) == true) goto L49;
        r14.add(2131372183, r13, r3);
    L49:
        r14.commitAllowingStateLoss();
        goto L51
    L5:
        if ((getActivity() instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r15 = getActivity();
        if (r15 == null) goto L10;
        LiveOpenFeaturePanelViewModel r16 = (LiveOpenFeaturePanelViewModel) ViewModelProviders.of(r15).get(LiveOpenFeaturePanelViewModel.class);
    L12:
        this.f = r16;
        goto L13
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L11:
        r16 = (LiveOpenFeaturePanelViewModel) ViewModelProviders.of(this).get(LiveOpenFeaturePanelViewModel.class);
        goto L12
    }

    public final void showNow(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L12
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);     // Catch: Exception -> L12
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == false) goto L16;
    L8:
        AbsLiveOpenFeatureChooseFragment r4 = this.e;     // Catch: Exception -> L12
        if (r4 == null) goto L20;
        r4.S90();     // Catch: Exception -> L12
        return;
    L20:
        return;
    L16:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L7:
        super/*androidx.fragment.app.DialogFragment*/.showNow(r2, r3);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (LiveOpenFeatureChooseConfig.useV3() == false) goto L7;
        return r2.inflate(2131567065, r3, false);
    L7:
        return r2.inflate(2131567064, r3, false);
    }
}
