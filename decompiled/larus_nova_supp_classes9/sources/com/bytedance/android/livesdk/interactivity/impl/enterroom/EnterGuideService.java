package com.bytedance.android.livesdk.interactivity.impl.enterroom;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.l;
import com.bytedance.android.livesdk.audiencemore.AudienceMoreDynamicLoader;
import com.bytedance.android.livesdk.authorize.NewAuthGuideManager;
import com.bytedance.android.livesdk.authorize.p;
import com.bytedance.android.livesdk.bottomguide.BottomGuideModel;
import com.bytedance.android.livesdk.bottomguide.BottomGuideWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.coupon.CouponDialogWidget;
import com.bytedance.android.livesdk.coupon.UgCouponWidget;
import com.bytedance.android.livesdk.followtool.utils.XTFollowSyncUtils;
import com.bytedance.android.livesdk.followtool.utils.f;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.slideuptip.SlideTaskWidget;
import com.bytedance.android.livesdk.slideuptip.g;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l32.a;
import l32.c;
import l32.d;
import we1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AJJ\u0010\u0011\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\u001e\u0010$\u001a\u00020\u00102\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\"H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0016J\u0016\u0010+\u001a\u00020\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0.2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\b\u00101\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u000202H\u0016J\u001a\u00107\u001a\u0004\u0018\u0001062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0016J\n\u00109\u001a\u0004\u0018\u000108H\u0016R$\u0010?\u001a\u00020,2\u0006\u0010:\u001a\u00020,8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/impl/enterroom/EnterGuideService;", "Lcom/bytedance/android/livesdk/interactivity/api/enterroom/IEnterGuideService;", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "widgetManager", "Landroid/content/Context;", "context", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", BuildConfig.FLAVOR, "isScreenPortrait", BuildConfig.FLAVOR, "bottomGuideContainerId", "Lcom/bytedance/ies/sdk/widgets/Widget;", "saasCouponWidget", BuildConfig.FLAVOR, "prepareEnterRoomGuide", "createCouponDialogWidget", "isCouponNeedShow", "(Lcom/bytedance/ies/sdk/widgets/Widget;)Ljava/lang/Boolean;", "ensureNewAuthGuideManagerInitialized", "Ll32/a;", "createAuthActionRoutine", "hasShown", "setHasShownSlideUpGuideInSingleContainer", "getHasShownSlideUpGuideInSingleContainer", BuildConfig.FLAVOR, "getSlideTaskGuideDuration", "Landroidx/fragment/app/Fragment;", "fragment", "isBottomGuideShowing", "closeBottomGuide", "firstEnterLiveRoom", "Lkotlin/Function1;", "action", "initSlideTask", "Lcom/bytedance/android/live/room/l;", "mRoomLogger", "createUgCouponWidget", BuildConfig.FLAVOR, "Lkf1/a;", "closeRoomInterceptorList", "createSlideTaskWidget", BuildConfig.FLAVOR, "userId", "Lio/reactivex/Observable;", "checkXTFollowSync", "taskManagerReset", "taskManagerReleaseAction", "Ll32/c;", "getKeyRoomInfoBizController", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/e;", "env", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsMiddlewareDynamicLoader;", "getAudienceToolbarMoreLoader", "Ll32/b;", "getGotoLiveTabHelper", "value", "getNewAuthReportOneClickLoginStatus", "()Ljava/lang/String;", "setNewAuthReportOneClickLoginStatus", "(Ljava/lang/String;)V", "newAuthReportOneClickLoginStatus", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class EnterGuideService implements IEnterGuideService {
    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public d getRoomBizController() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public a createAuthActionRoutine() {
        return new b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void ensureNewAuthGuideManagerInitialized() {
        NewAuthGuideManager.l.getClass();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public boolean getHasShownSlideUpGuideInSingleContainer() {
        boolean r0 = g.a;
        return g.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public c getKeyRoomInfoBizController() {
        return new com.bytedance.android.livesdk.room.external.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public String getNewAuthReportOneClickLoginStatus() {
        String r0 = p.a;
        return p.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public long getSlideTaskGuideDuration() {
        boolean r0 = g.a;
        return ((Number) LiveConfigSettingKeys.GLIDE_TASK_GUIDE_DISAPPEAR.getValue()).longValue() * 1000;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void taskManagerReleaseAction() {
        boolean r0 = g.a;
        g.c = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void taskManagerReset() {
        boolean r0 = g.a;
        g.a = false;
        g.b = false;
    }

    public EnterGuideService() {
        k.l(IEnterGuideService.class, this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void firstEnterLiveRoom() {
        int r0 = we1.a.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public l32.b getGotoLiveTabHelper() {
        return wl2.a.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void closeBottomGuide(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        BottomGuideModel r4 = ViewModelProviders.of(r3).get(BottomGuideModel.class);
        if (Intrinsics.areEqual((Boolean) r4.getShowing().getValue(), Boolean.TRUE) == false) goto L6;
        r4.getShowing().setValue(Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public Widget createCouponDialogWidget(Context r1) {
        return new CouponDialogWidget();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public Widget createSlideTaskWidget(List<kf1.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "closeRoomInterceptorList");
        return new SlideTaskWidget(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public Widget createUgCouponWidget(l r2) {
        Intrinsics.checkNotNullParameter(r2, "mRoomLogger");
        return new UgCouponWidget(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void initSlideTask(Function1<? super Boolean, Boolean> r2) {
        boolean r0 = g.a;
        g.c = r2;
        g.a = false;
        g.b = false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public boolean isBottomGuideShowing(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Boolean r3 = (Boolean) ViewModelProviders.of(r2).get(BottomGuideModel.class).getShowing().getValue();
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public Boolean isCouponNeedShow(Widget r3) {
        if ((r3 instanceof CouponDialogWidget) == true) goto L5;
        r3 = null;
    L5:
        CouponDialogWidget r4 = (CouponDialogWidget) r3;
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void setHasShownSlideUpGuideInSingleContainer(boolean r2) {
        boolean r0 = g.a;
        g.b = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void setNewAuthReportOneClickLoginStatus(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        p.b.setOnClickLogin(Intrinsics.areEqual(r3, "yes"));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public Observable<Boolean> checkXTFollowSync(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "userId");
        Disposable r1 = XTFollowSyncUtils.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "userOpenId");
        return XTFollowSyncUtils.a(r4).flatMap(new com.bytedance.android.livesdk.followtool.utils.d(r3));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public AbsMiddlewareDynamicLoader getAudienceToolbarMoreLoader(Context r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "env");
        return new AudienceMoreDynamicLoader(r3, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService
    public void prepareEnterRoomGuide(WidgetManager r3, Context r4, Lifecycle r5, Room r6, boolean r7, int r8, Widget r9) {
        if (r3 != null) goto L4;
        return;
    L4:
        IMiddlewareRoomService r0 = k.f(IMiddlewareRoomService.class);
        if (r0 == null) goto L7;
        r0.getEnterConfigManager();
    L7:
        if (r7 == false) goto L13;
        BottomGuideWidget r10 = new BottomGuideWidget();
        if ((r9 instanceof CouponDialogWidget) == false) goto L11;
        CouponDialogWidget r1 = (CouponDialogWidget) r9;
        Intrinsics.checkNotNullParameter(r1, "couponDialogWidget");
        r10.n = r1;
    L11:
        r3.load(r8, r10);
    L13:
        if ((r9 instanceof CouponDialogWidget) == true) goto L15;
        r9 = null;
    L15:
        CouponDialogWidget r11 = (CouponDialogWidget) r9;
        if (r6 == null) goto L24;
        if (r5 == null) goto L25;
        Disposable r13 = XTFollowSyncUtils.a;
        Intrinsics.checkNotNullParameter(r5, "lifecycle");
        Intrinsics.checkNotNullParameter(r6, "mRoom");
        if (((Boolean) LiveSettingKeys.LIVE_STOCK_OF_FOLLOW_SHOW.getValue()).booleanValue() == false) goto L26;
        if (r4 == null) goto L27;
        ((ObservableSubscribeProxy) Observable.just(Boolean.TRUE).delay(10, TimeUnit.SECONDS).flatMap(new com.bytedance.android.livesdk.followtool.utils.e(r6)).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(r5, Lifecycle.Event.ON_DESTROY)))).subscribe(new f(r6, r5, r11, r4), new com.bytedance.android.livesdk.followtool.utils.g(r6));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }
}
