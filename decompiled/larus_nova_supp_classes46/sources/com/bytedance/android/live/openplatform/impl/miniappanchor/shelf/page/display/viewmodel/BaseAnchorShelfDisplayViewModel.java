package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.coupon.AnchorCouponContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.launch.LiveAnchorLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.memory.k;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.message.model.bl;
import com.bytedance.android.livesdk.message.model.cl;
import com.bytedance.android.livesdk.message.model.dl;
import com.bytedance.android.livesdk.message.model.el;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import ko0.f;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J$\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0004J\u0010\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\bJ\u0018\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\nJ\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$R*\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020'8\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001d\u00101\u001a\b\u0012\u0004\u0012\u0002000/8\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/BaseAnchorShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/viewmodel/CommonShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/b;", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "newCardInfoList", "Lcom/bytedance/android/livesdk/message/model/el;", "newTradeData", "", "updateDisplayItemInfoList", "", "canShowTradeData", "initData", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo", "notifyShelfInfoChange", "cardInfoList", "tradeData", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/trade/d;", "buildTopTradeData", "cardInfo", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/a;", "convertToDisplayCardInfo", "", "source", "openShelfManagementPage", "", "cardId", "startExplain", "cancelExplain", "showToolbarTips", "schema", "forceColdBoot", "openMiniAppLandingPage", "openLinkCastPage", "getLinkCastTips", "Landroid/content/Context;", "context", "openCouponPage", "Lso0/a;", "<set-?>", "miniAppAnchorService", "Lso0/a;", "getMiniAppAnchorService", "()Lso0/a;", "setMiniAppAnchorService", "(Lso0/a;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/openplatform/api/model/coupon/a;", "couponEntranceInfo", "Landroidx/lifecycle/MutableLiveData;", "getCouponEntranceInfo", "()Landroidx/lifecycle/MutableLiveData;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseAnchorShelfDisplayViewModel extends CommonShelfDisplayViewModel<com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.b> {
    private final MutableLiveData<com.bytedance.android.live.openplatform.api.model.coupon.a> couponEntranceInfo;
    public so0.a miniAppAnchorService;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.a();
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (el) sh6.c.b(r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BaseAnchorShelfDisplayViewModel a;

        public c(BaseAnchorShelfDisplayViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            BaseAnchorShelfDisplayViewModel r0 = this.a;
            BaseAnchorShelfDisplayViewModel.updateDisplayItemInfoList$default(r0, null, (el) r4, 1, null);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BaseAnchorShelfDisplayViewModel a;

        public d(BaseAnchorShelfDisplayViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            k r4 = (k) r3;
            BaseAnchorShelfDisplayViewModel.updateDisplayItemInfoList$default(this.a, null, null, 3, null);
        }
    }

    private final boolean canShowTradeData() {
        if (((uc1) ee0.a.getValue()).u() != 1) goto L14;
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L8:
        if (r0.getMemoryStatus().c != 1) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L15;
        return true;
    L15:
        return false;
    L10:
        r1 = false;
        goto L11
    L14:
        return false;
    }

    public final so0.a getMiniAppAnchorService() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public void openLinkCastPage() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        LiveAnchorLaunchContextService r2 = (LiveAnchorLaunchContextService) r1.getService(LiveAnchorLaunchContextService.class);
        if (r2 == null) goto L12;
        r2.openLiveCastingMiniApp();
        return;
    L12:
        return;
    }

    public final void showToolbarTips() {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        DataCenter r2 = r1.getDataCenter();
        if (r2 == null) goto L12;
        r2.put("open_platform_toolbar_show_tips", new f(s1.B(2131921087), 0, 0, 6));
        return;
    L12:
        return;
    }

    public BaseAnchorShelfDisplayViewModel() {
        this.couponEntranceInfo = new MutableLiveData();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        setMiniAppAnchorService((so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get());
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public String getLinkCastTips() {
        return s1.B(2131920875);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public void initData() {
        super.initData();
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L12;
        AnchorCouponContextService r2 = (AnchorCouponContextService) r1.getService(AnchorCouponContextService.class);
        if (r2 == null) goto L12;
        Disposable r3 = AnchorCouponContextService.f(r2, 1, new C03251(this));
        if (r3 == null) goto L12;
        autoDispose(r3);
    L12:
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r4 = AnchorMiniAppDataContext.a.a();
        if (r4 == null) goto L25;
        n<el> r5 = r4.getShelfTradeData();
        if (r5 == null) goto L25;
        Observable r6 = r5.a();
        if (r6 == null) goto L25;
        Observable r7 = r6.filter(a.a);
        if (r7 == null) goto L25;
        Observable r8 = r7.map(b.a);
        if (r8 == null) goto L25;
        Disposable r9 = r8.subscribe(new c(this));
        if (r9 == null) goto L25;
        autoDispose(r9);
    L25:
        autoDispose(xs2.b.a().b(k.class).subscribe(new d(this)));
    }

    public final MutableLiveData<com.bytedance.android.live.openplatform.api.model.coupon.a> getCouponEntranceInfo() {
        return this.couponEntranceInfo;
    }

    public final void cancelExplain(long r9) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        AnchorExplainCardContextService r2 = (AnchorExplainCardContextService) r1.getService(AnchorExplainCardContextService.class);
        if (r2 == null) goto L12;
        AnonymousClass1 r6 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r7 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "onSuccess");
        Intrinsics.checkNotNullParameter(r7, "onFail");
        r2.g(r9, 0, r6, r7);
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public void notifyShelfInfoChange(ShelfInfo r3) {
        super.notifyShelfInfoChange(r3);
        if (r3 == null) goto L6;
        List<ShelfCardInfo> r4 = r3.cardInfoList;
        if (r4 == null) goto L6;
    L7:
        updateDisplayItemInfoList$default(this, r4, null, 2, null);
        return;
    L6:
        r4 = CollectionsKt.emptyList();
        goto L7
    }

    public final void openCouponPage(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        String r2 = "";
        if (r1 == null) goto L15;
        AnchorCouponContextService r3 = (AnchorCouponContextService) r1.getService(AnchorCouponContextService.class);
        if (r3 == null) goto L15;
        String[] r4 = new String[1];
        ShelfMicroAppInfo r5 = (ShelfMicroAppInfo) getShelfMicroAppInfo().getValue();
        if (r5 == null) goto L13;
        String r6 = r5.appId;
        if (r6 == null) goto L13;
    L14:
        r4[0] = r6;
        r3.h(r8, 1, CollectionsKt.arrayListOf(r4));
    L13:
        r6 = "";
    L15:
        so0.a r9 = this.miniAppAnchorService;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L18:
        OpenPlatformContext r10 = r9.a();
        if (r10 == null) goto L30;
        AnchorMiniAppAppLogContextService r11 = (AnchorMiniAppAppLogContextService) r10.getService(AnchorMiniAppAppLogContextService.class);
        if (r11 == null) goto L31;
        ShelfMicroAppInfo r7 = (ShelfMicroAppInfo) getShelfMicroAppInfo().getValue();
        if (r7 == null) goto L28;
        String r12 = r7.appId;
        if (r12 == null) goto L28;
        r2 = r12;
    L28:
        r11.reportCouponEntranceClick(r2, "shelf_show_page");
        return;
    L31:
        return;
    }

    public final void openShelfManagementPage(String r3) {
        HashMap<String, zo0.f> r0 = g.a;
        zo0.f r1 = h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);
        r1.o();
        h.a(r1, "manangement");
        so0.a r2 = this.miniAppAnchorService;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r4 = r2.a();
        if (r4 == null) goto L17;
        AnchorShelfContextService r5 = (AnchorShelfContextService) r4.getService(AnchorShelfContextService.class);
        if (r5 == null) goto L18;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r6 = AnchorMiniAppDataContext.a.a();
        if (r6 == null) goto L14;
        n<ShelfInfo> r7 = r6.m618getShelfInfo();
        if (r7 == null) goto L14;
        ShelfInfo r8 = (ShelfInfo) r7.getValue();
    L15:
        r5.openShelfManagementPage(r8, r3);
        return;
    L14:
        r8 = null;
        goto L15
    L18:
        return;
    }

    @Inject
    public final void setMiniAppAnchorService(so0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.miniAppAnchorService = r2;
    }

    public final void startExplain(long r9) {
        so0.a r0 = this.miniAppAnchorService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        AnchorExplainCardContextService r2 = (AnchorExplainCardContextService) r1.getService(AnchorExplainCardContextService.class);
        if (r2 == null) goto L12;
        C03261 r6 = C03261.INSTANCE;
        C03272 r7 = C03272.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "onSuccess");
        Intrinsics.checkNotNullParameter(r7, "onFail");
        r2.g(r9, 1, r6, r7);
        return;
    L12:
        return;
    }

    private final void updateDisplayItemInfoList(List<ShelfCardInfo> r3, el r4) {
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        getDisplayItemInfoList().setValue(buildDisplayItemInfoList(new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.b(r3, r4)));
    }

    public final com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.d buildTopTradeData(List<ShelfCardInfo> r6, el r7) {
        Intrinsics.checkNotNullParameter(r6, "cardInfoList");
        if (canShowTradeData() == true) goto L5;
        return null;
    L5:
        if (r6.isEmpty() == true) goto L43;
        if (r7 == null) goto L8;
        List r8 = r7.b();
    L9:
        List r9 = r8;
        if (r9 != null) goto L12;
    L15:
        boolean r10 = true;
    L16:
        if (r10 == true) goto L45;
        ArrayList r11 = new ArrayList();
        if (r7 == null) goto L33;
        List r12 = r7.b();
        if (r12 == null) goto L33;
        Iterator r13 = r12.iterator();
    L24:
        if (r13.hasNext() == false) goto L33;
        dl r2 = (dl) r13.next();
        String r4 = r2.a();
        if (r4 != null) goto L28;
        r4 = "";
    L28:
        String r3 = r2.b();
        if (r3 != null) goto L31;
        r3 = "0";
    L31:
        r11.add(new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.c(r4, r3));
    L33:
        if ((!r11.isEmpty()) == true) goto L36;
        r11 = null;
    L36:
        if (r11 != null) goto L38;
        return null;
    L38:
        return new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.d(1, r11);
    L45:
        return null;
    L12:
        if (r9.isEmpty() == true) goto L15;
        r10 = false;
        goto L16
    L8:
        r8 = null;
        goto L9
    L43:
        return null;
    }

    public final com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a convertToDisplayCardInfo(ShelfCardInfo r5, el r6) {
        Intrinsics.checkNotNullParameter(r5, "cardInfo");
        if (r6 == null) goto L7;
        Map r7 = r6.a();
        if (r7 == null) goto L7;
        bl r8 = (bl) r7.get(Long.valueOf(r5.getCardId()));
    L9:
        if (canShowTradeData() == false) goto L39;
        if (r8 == null) goto L12;
        List r1 = r8.a();
    L13:
        List r2 = r1;
        if (r2 != null) goto L16;
    L19:
        boolean r3 = true;
    L20:
        if (r3 == true) goto L39;
        ArrayList r0 = new ArrayList();
        if (r8 == null) goto L37;
        List r9 = r8.a();
        if (r9 == null) goto L37;
        Iterator r10 = r9.iterator();
    L28:
        if (r10.hasNext() == false) goto L37;
        cl r4 = (cl) r10.next();
        String r11 = r4.a();
        if (r11 != null) goto L32;
        r11 = "";
    L32:
        String r12 = r4.b();
        if (r12 != null) goto L35;
        r12 = "0";
    L35:
        r0.add(new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.c(r11, r12));
    L37:
        return new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a(r5, new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.d(2, r0));
    L16:
        if (r2.isEmpty() == true) goto L19;
        r3 = false;
        goto L20
    L12:
        r1 = null;
    L39:
        return new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a(r5, null);
    L7:
        r8 = null;
        goto L9
    }

    public final void openMiniAppLandingPage(String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r19, "schema");
        so0.a r2 = this.miniAppAnchorService;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        r2.openMiniApp(r19, new ko0.b(LaunchParamConstant$Scene.a, "live", PbRequest.SwitchType.PREVIEW, "solid_entrance", "live_take_page", "shelf_show_page", null, null, null, true, r20, null, 10176));
    }

    public static /* synthetic */ void openMiniAppLandingPage$default(BaseAnchorShelfDisplayViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.openMiniAppLandingPage(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMiniAppLandingPage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateDisplayItemInfoList$default(BaseAnchorShelfDisplayViewModel r0, List r1, el r2, int r3, Object r4) {
        if (r4 != null) goto L19;
        if ((r3 & 1) == 0) goto L9;
        r1 = (List) r0.getShelfCardInfoList().getValue();
        if (r1 != null) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        if ((r3 & 2) == 0) goto L16;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r5 = AnchorMiniAppDataContext.a.a();
        if (r5 == null) goto L15;
        n<el> r6 = r5.getShelfTradeData();
        if (r6 == null) goto L15;
        r2 = (el) r6.getValue();
    L15:
        r2 = null;
    L16:
        r0.updateDisplayItemInfoList(r1, r2);
        return;
    L19:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateDisplayItemInfoList");
    }
}
