package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview;

import android.R;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformTitleBar;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.ShelfManagementViewModelV2;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.preview.PreviewShelfManagementViewModelV2;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.ILiveDuxPopupNotice;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/preview/PreviewShelfManagementActivityV2;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementActivityV2;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/preview/PreviewShelfManagementViewModelV2;", "", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewShelfManagementActivityV2 extends ShelfManagementActivityV2<PreviewShelfManagementViewModelV2> {
    public static final /* synthetic */ int l = 0;
    public Map<Integer, View> h;
    public ILiveDuxPopupNotice i;
    public boolean j;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PreviewShelfManagementActivityV2 a;

        public b(PreviewShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            OpenPlatformContext r9 = this.a.B1().a();
            if (r9 == null) goto L15;
            AnchorMiniAppAppLogContextService r0 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
            if (r0 == null) goto L15;
            ShelfMicroAppInfo r10 = PreviewShelfManagementActivityV2.F1(this.a).getShelfAppInfo();
            if (r10 == null) goto L10;
            String r11 = r10.appId;
            if (r11 == null) goto L10;
        L11:
            String r1 = r11;
            Integer r12 = (Integer) PreviewShelfManagementActivityV2.F1(this.a).getPageCount().getValue();
            if (r12 != null) goto L14;
            r12 = 0;
        L14:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r0, r1, "click_close", r12.intValue(), 0, 8, null);
        L10:
            r11 = "";
        L15:
            this.a.H1();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PreviewShelfManagementActivityV2 a;

        public c(PreviewShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            OpenPlatformContext r9 = this.a.B1().a();
            if (r9 == null) goto L15;
            AnchorMiniAppAppLogContextService r0 = (AnchorMiniAppAppLogContextService) r9.getService(AnchorMiniAppAppLogContextService.class);
            if (r0 == null) goto L15;
            ShelfMicroAppInfo r10 = PreviewShelfManagementActivityV2.F1(this.a).getShelfAppInfo();
            if (r10 == null) goto L10;
            String r11 = r10.appId;
            if (r11 == null) goto L10;
        L11:
            String r1 = r11;
            Integer r12 = (Integer) PreviewShelfManagementActivityV2.F1(this.a).getPageCount().getValue();
            if (r12 != null) goto L14;
            r12 = 0;
        L14:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r0, r1, "click_begin_live", r12.intValue(), 0, 8, null);
        L10:
            r11 = "";
        L15:
            this.a.H1();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ PreviewShelfManagementActivityV2 a;

        public d(PreviewShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            PreviewShelfManagementActivityV2.G1(this.a);
            return;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ PreviewShelfManagementActivityV2 a;

        public e(PreviewShelfManagementActivityV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PreviewShelfManagementActivityV2.G1(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ PreviewShelfManagementActivityV2 a;
        public final /* synthetic */ View b;

        public f(PreviewShelfManagementActivityV2 r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            if (((CheckBox) this.b.findViewById(2131378280)).isChecked() == false) goto L5;
            PreviewShelfManagementActivityV2.F1(this.a).doNotCheckDefaultTitleOrCover();
        L5:
            PreviewShelfManagementActivityV2.F1(this.a).startLive(this.a);
            r2.dismiss();
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

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(PreviewShelfManagementActivityV2.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PreviewShelfManagementActivityV2.class.getName()));
    L5:
        super.onDestroy();
        this.k.b();
    }

    public PreviewShelfManagementActivityV2() {
        this.k = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.h = new LinkedHashMap();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.f = r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2
    public final ShelfManagementViewModelV2 D1() {
        return (PreviewShelfManagementViewModelV2) ViewModelProviders.of(this).get(PreviewShelfManagementViewModelV2.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H1() {
        if (((PreviewShelfManagementViewModelV2) C1()).checkDefaultTitleOrCover() == false) goto L5;
        View r0 = LayoutInflater.from(this).inflate(2131565807, null);
        ((TextView) r0.findViewById(2131379478)).setText(s1.B(2131920902));
        ((TextView) r0.findViewById(2131387553)).setText(s1.B(2131920901));
        x0.b r1 = new x0.b(this, 7);
        r1.a.f = r0;
        r1.j(0, s1.B(2131920912), new f(this, r0));
        r1.j(1, s1.B(2131920891), g.a);
        r1.setCornerRadius(16.0f);
        r1.k(0, true);
        r1.n();
        return;
    L5:
        ((PreviewShelfManagementViewModelV2) C1()).startLive(this);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2
    public final void initView() {
        super.initView();
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setLeftIconDrawable(2131252526);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setOnLeftIconClickListener(new b(this));
        ((TextView) _$_findCachedViewById(2131387220)).setVisibility(0);
        ((TextView) _$_findCachedViewById(2131372569)).setVisibility(8);
        ((TextView) _$_findCachedViewById(2131387220)).setOnClickListener(new c(this));
        C1().getShowOpenExplainCardGuide().observe(this, new d(this));
        Disposable r0 = m.f(xs2.b.a().b(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.b.class), new AnonymousClass4(this));
        Intrinsics.checkNotNullParameter(r0, "$this$autoDispose");
        this.k.a(r0);
        Disposable r1 = m.f(xs2.b.a().b(zp0.d.class), new AnonymousClass5(this));
        Intrinsics.checkNotNullParameter(r1, "$this$autoDispose");
        this.k.a(r1);
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.j == false) goto L6;
        this.j = false;
        ((FrameLayout) _$_findCachedViewById(2131364422)).post(new e(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final void onBackPressed() {
        H1();
    }

    public static final /* synthetic */ PreviewShelfManagementViewModelV2 F1(PreviewShelfManagementActivityV2 r0) {
        return r0.C1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void G1(final PreviewShelfManagementActivityV2 r10) {
        if (r10.B1().getCoexistComponent() == 0) goto L5;
        return;
    L5:
        if (r10.B1().getMemoryStatus().b() == true) goto L63;
        ILiveDuxPopupNotice r0 = r10.i;
        boolean r1 = true;
        if (r0 != null) goto L10;
    L12:
        String r2 = "";
        if (xq0.a.b() == false) goto L15;
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.F3;
        Long r4 = Long.valueOf(System.currentTimeMillis());
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        qo0.a.c("PreviewShelfManagementActivity", "start show explain notice");
        IHostService r5 = TTLiveSDK.hostService();
        Integer r6 = null;
        if (r5 == null) goto L41;
        IHostLiveOpenPlatform r7 = r5.hostOpenPlatform();
        if (r7 == null) goto L41;
        DuxPopupNoticeConfig r8 = new DuxPopupNoticeConfig();
        r8.setLeftIconAttrs(PreviewShelfManagementActivityV2$showOpenExplainCardNotice$1$1.INSTANCE);
        r8.setLeftTitle(r10.getString(2131921027));
        r8.setLeftSubTitle(r10.getString(2131921026));
        r8.setUseButtonStyleAtEnd(true);
        r8.setRightTitle(r10.getString(2131921025));
        r8.setRightTextAttrs(new PreviewShelfManagementActivityV2$showOpenExplainCardNotice$$inlined$apply$lambda$1(r10));
        r8.setRightIconAttrs(new PreviewShelfManagementActivityV2$showOpenExplainCardNotice$$inlined$apply$lambda$2(r10));
        r8.setEnableAutoDismiss(false);
        r8.setHideCallback(new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.d());
        r8.setAnchorView(r10._$_findCachedViewById(2131364422));
        Integer r9 = Integer.valueOf(((FrameLayout) r10._$_findCachedViewById(2131364422)).getHeight());
        if (r9.intValue() != 0) goto L35;
        r1 = false;
    L35:
        if (r1 == false) goto L37;
        r6 = r9;
    L37:
        if (r6 == null) goto L39;
        int r11 = r6.intValue();
    L40:
        r8.setYOffset(r11 + ((int) UIUtils.dip2Px(r10, 12.0f)));
        Unit r12 = Unit.INSTANCE;
        r6 = r7.showDuxPopupNotice(r10, r8);
        goto L41
    L39:
        r11 = (int) UIUtils.dip2Px(r10, 111.0f);
    L41:
        r10.i = r6;
        if (r6 == null) goto L44;
        r6.show();
    L44:
        OpenPlatformContext r13 = r10.B1().a();
        if (r13 == null) goto L61;
        AnchorMiniAppAppLogContextService r14 = (AnchorMiniAppAppLogContextService) r13.getService(AnchorMiniAppAppLogContextService.class);
        if (r14 == null) goto L62;
        ShelfMicroAppInfo r15 = ((PreviewShelfManagementViewModelV2) r10.C1()).getShelfAppInfo();
        if (r15 == null) goto L54;
        String r16 = r15.appId;
        if (r16 == null) goto L54;
        r2 = r16;
    L54:
        r14.reportOpenExplainCardNotice(r2);
        return;
    L62:
        return;
    L61:
        return;
    L15:
        if (xq0.a.a() == false) goto L57;
        ((OpenPlatformTitleBar) r10._$_findCachedViewById(2131388807)).b(r10, 1, new ko0.f(r10.getString(2131921024), 3000, 0, 4));
        com.bytedance.android.livesdk.sharedpref.e r17 = com.bytedance.android.livesdk.sharedpref.b.H3;
        Long r18 = Long.valueOf(System.currentTimeMillis());
        r17.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r17, r18);
        OpenPlatformContext r19 = r10.B1().a();
        if (r19 == null) goto L58;
        AnchorMiniAppAppLogContextService r20 = (AnchorMiniAppAppLogContextService) r19.getService(AnchorMiniAppAppLogContextService.class);
        if (r20 == null) goto L59;
        ShelfMicroAppInfo r110 = ((PreviewShelfManagementViewModelV2) r10.C1()).getShelfAppInfo();
        if (r110 == null) goto L26;
        String r111 = r110.appId;
        if (r111 == null) goto L26;
        r2 = r111;
    L26:
        r20.reportPageShelfBubblePush(r2, "default_popup_card_set_guide");
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L10:
        if (r0.isShowing() != true) goto L12;
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder.a
    public final void E(bq0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        super.E(r3);
        BusinessToolType r4 = r3.b();
        if (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.c.b[r4.ordinal()] != 1) goto L18;
        OpenPlatformContext r5 = B1().a();
        if (r5 == null) goto L16;
        AnchorMiniAppAppLogContextService r6 = (AnchorMiniAppAppLogContextService) r5.getService(AnchorMiniAppAppLogContextService.class);
        if (r6 == null) goto L17;
        ShelfMicroAppInfo r0 = C1().getShelfAppInfo();
        if (r0 == null) goto L13;
        String r1 = r0.appId;
        if (r1 == null) goto L13;
    L14:
        r6.reportCouponEntranceShow(r1, "shelf_setting_page");
        return;
    L13:
        r1 = "";
        goto L14
    L17:
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2
    public final View _$_findCachedViewById(int r3) {
        if (this.h != null) goto L5;
        this.h = new LinkedHashMap();
    L5:
        View r0 = this.h.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.h.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder.a
    public final void g1(bq0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.g1(r2);
        BusinessToolType r3 = r2.b();
        if (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.c.a[r3.ordinal()] != 1) goto L7;
        ((PreviewShelfManagementViewModelV2) C1()).openCouponPage(this);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivityV2
    public final void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        this.j = true;
    }
}
