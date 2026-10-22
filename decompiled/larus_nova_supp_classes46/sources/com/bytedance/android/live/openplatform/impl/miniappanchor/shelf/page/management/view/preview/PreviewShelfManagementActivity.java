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
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.base.utils.m;
import com.bytedance.android.live.openplatform.impl.base.view.OpenPlatformTitleBar;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementCardListAdapter;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.model.BusinessToolType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.viewmodel.preview.PreviewShelfManagementViewModel;
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
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/preview/PreviewShelfManagementActivity;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementActivity;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/viewmodel/preview/PreviewShelfManagementViewModel;", "", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewShelfManagementActivity extends ShelfManagementActivity<PreviewShelfManagementViewModel> {
    public static final /* synthetic */ int k = 0;
    public Map<Integer, View> g;
    public ILiveDuxPopupNotice h;
    public boolean i;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a j;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ PreviewShelfManagementActivity a;
        public final /* synthetic */ Function0 b;

        public b(PreviewShelfManagementActivity r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            OpenPlatformContext r6 = this.a.A1().a();
            if (r6 == null) goto L12;
            AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
            if (r7 == null) goto L12;
            ShelfMicroAppInfo r0 = PreviewShelfManagementActivity.F1(this.a).getShelfAppInfo();
            if (r0 == null) goto L10;
            String r1 = r0.appId;
            if (r1 == null) goto L10;
        L11:
            r7.reportExitBindPushClick(r1, "direct_close", "exit");
        L10:
            r1 = "";
        L12:
            this.b.invoke();
            r4.dismiss();
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ PreviewShelfManagementActivity a;

        public c(PreviewShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            OpenPlatformContext r6 = this.a.A1().a();
            if (r6 == null) goto L12;
            AnchorMiniAppAppLogContextService r7 = (AnchorMiniAppAppLogContextService) r6.getService(AnchorMiniAppAppLogContextService.class);
            if (r7 == null) goto L12;
            ShelfMicroAppInfo r0 = PreviewShelfManagementActivity.F1(this.a).getShelfAppInfo();
            if (r0 == null) goto L10;
            String r1 = r0.appId;
            if (r1 == null) goto L10;
        L11:
            r7.reportExitBindPushClick(r1, "direct_close", "cancel");
        L10:
            r1 = "";
        L12:
            r4.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            this.a.invoke();
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PreviewShelfManagementActivity a;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ e a;
            public final /* synthetic */ View b;

            public a(e r1, View r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r2, int r3) {
                if (((CheckBox) this.b.findViewById(2131378280)).isChecked() == false) goto L5;
                PreviewShelfManagementActivity.F1(this.a.a).doNotCheckDefaultTitleOrCover();
            L5:
                PreviewShelfManagementActivity.F1(this.a.a).startLive(this.a.a);
                r2.dismiss();
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                r1.dismiss();
            }
        }

        public e(PreviewShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            OpenPlatformContext r10 = this.a.A1().a();
            if (r10 == null) goto L16;
            AnchorMiniAppAppLogContextService r1 = (AnchorMiniAppAppLogContextService) r10.getService(AnchorMiniAppAppLogContextService.class);
            if (r1 == null) goto L16;
            ShelfMicroAppInfo r11 = PreviewShelfManagementActivity.F1(this.a).getShelfAppInfo();
            if (r11 == null) goto L10;
            String r12 = r11.appId;
            if (r12 == null) goto L10;
        L11:
            String r2 = r12;
            Integer r13 = (Integer) PreviewShelfManagementActivity.F1(this.a).getPageCount().getValue();
            if (r13 != null) goto L14;
            r13 = 0;
        L14:
            AnchorMiniAppAppLogContextService.reportShelfSettingPageOperate$default(r1, r2, "click_begin_live", r13.intValue(), 0, 8, null);
        L10:
            r12 = "";
        L16:
            if (PreviewShelfManagementActivity.F1(this.a).checkDefaultTitleOrCover() == false) goto L18;
            View r14 = LayoutInflater.from(this.a).inflate(2131565807, null);
            ((TextView) r14.findViewById(2131379478)).setText(s1.B(2131920902));
            ((TextView) r14.findViewById(2131387553)).setText(s1.B(2131920901));
            x0.b r3 = new x0.b(this.a, 7);
            r3.a.f = r14;
            r3.j(0, s1.B(2131920912), new a(this, r14));
            r3.j(1, s1.B(2131920891), b.a);
            r3.setCornerRadius(16.0f);
            r3.k(0, true);
            r3.n();
            return;
        L18:
            PreviewShelfManagementActivity.F1(this.a).startLive(this.a);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ PreviewShelfManagementActivity a;

        public f(PreviewShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OpenPlatformContext r0 = this.a.A1().a();     // Catch: Throwable -> L9
            if (r0 == null) goto L7;
            OpenPlatformPerformanceReportService r1 = (OpenPlatformPerformanceReportService) r0.getService(OpenPlatformPerformanceReportService.class);     // Catch: Throwable -> L9
            if (r1 == null) goto L7;
            HashMap<String, zo0.f> r2 = zo0.g.a;     // Catch: Throwable -> L9
            zo0.f r3 = h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);     // Catch: Throwable -> L9
            r3.b();     // Catch: Throwable -> L9
            zo0.f.a(r3, new zo0.d(r1));     // Catch: Throwable -> L9
        L7:
            PreviewShelfManagementActivity.H1(this.a);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L13;
            return;
        L13:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ PreviewShelfManagementActivity a;

        public g(PreviewShelfManagementActivity r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PreviewShelfManagementActivity.H1(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(PreviewShelfManagementActivity.class.getName()));
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

    public final void onBackPressed() {
        I1(new C03281(this));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PreviewShelfManagementActivity.class.getName()));
    L5:
        super.onDestroy();
        this.j.b();
    }

    public PreviewShelfManagementActivity() {
        this.j = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.g = new LinkedHashMap();
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r0 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.e = r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity
    public final PreviewShelfManagementViewModel D1() {
        return (PreviewShelfManagementViewModel) ViewModelProviders.of(this).get(PreviewShelfManagementViewModel.class);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity
    public final void initView() {
        super.initView();
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setLeftIconDrawable(2131252526);
        ((OpenPlatformTitleBar) _$_findCachedViewById(2131388807)).setOnLeftIconClickListener(new AnonymousClass1(this));
        ((TextView) _$_findCachedViewById(2131382399)).setVisibility(8);
        ((TextView) _$_findCachedViewById(2131387220)).setVisibility(0);
        ((TextView) _$_findCachedViewById(2131387220)).setOnClickListener(new e(this));
        ShelfManagementCardListAdapter r0 = z1();
        ShelfManagementCardListAdapter.b r1 = new AnonymousClass3(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r0.c = r1;
        Disposable r2 = m.f(xs2.b.a().b(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.b.class), new AnonymousClass4(this));
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.j.a(r2);
        ((FrameLayout) _$_findCachedViewById(2131364422)).post(new f(this));
        Disposable r3 = m.f(xs2.b.a().b(zp0.d.class), new AnonymousClass6(this));
        Intrinsics.checkNotNullParameter(r3, "$this$autoDispose");
        this.j.a(r3);
        HashMap<String, zo0.f> r4 = zo0.g.a;
        zo0.f r5 = h.b(PerformanceScene.SHELF_MANAGEMENT_PAGE);
        int r6 = zo0.f.d;
        r5.l("view_created", null);
        OpenPlatformContext r7 = A1().a();
        if (r7 != null) goto L5;
    L7:
        int r8 = 1;
    L8:
        int r9 = no0.a.a;
        no0.a.d(1, r8, 3, "", "");
        return;
    L5:
        if (r7.isInLive() != true) goto L7;
        r8 = 2;
        goto L8
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.i == false) goto L6;
        this.i = false;
        ((FrameLayout) _$_findCachedViewById(2131364422)).post(new g(this));
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

    public static final /* synthetic */ PreviewShelfManagementViewModel F1(PreviewShelfManagementActivity r0) {
        return r0.B1();
    }

    public static final /* synthetic */ void G1(PreviewShelfManagementActivity r0) {
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void H1(final PreviewShelfManagementActivity r10) {
        if (r10.A1().getCoexistComponent() == 0) goto L5;
        return;
    L5:
        if (r10.A1().getMemoryStatus().b() == true) goto L63;
        ILiveDuxPopupNotice r0 = r10.h;
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
        r8.setLeftIconAttrs(PreviewShelfManagementActivity$showOpenExplainCardNotice$1$1.INSTANCE);
        r8.setLeftTitle(r10.getString(2131921027));
        r8.setLeftSubTitle(r10.getString(2131921026));
        r8.setUseButtonStyleAtEnd(true);
        r8.setRightTitle(r10.getString(2131921025));
        r8.setRightTextAttrs(new PreviewShelfManagementActivity$showOpenExplainCardNotice$$inlined$apply$lambda$1(r10));
        r8.setRightIconAttrs(new PreviewShelfManagementActivity$showOpenExplainCardNotice$$inlined$apply$lambda$2(r10));
        r8.setEnableAutoDismiss(false);
        r8.setHideCallback(new com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.b());
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
        r10.h = r6;
        if (r6 == null) goto L44;
        r6.show();
    L44:
        OpenPlatformContext r13 = r10.A1().a();
        if (r13 == null) goto L61;
        AnchorMiniAppAppLogContextService r14 = (AnchorMiniAppAppLogContextService) r13.getService(AnchorMiniAppAppLogContextService.class);
        if (r14 == null) goto L62;
        ShelfMicroAppInfo r15 = ((PreviewShelfManagementViewModel) r10.B1()).getShelfAppInfo();
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
        OpenPlatformContext r19 = r10.A1().a();
        if (r19 == null) goto L58;
        AnchorMiniAppAppLogContextService r20 = (AnchorMiniAppAppLogContextService) r19.getService(AnchorMiniAppAppLogContextService.class);
        if (r20 == null) goto L59;
        ShelfMicroAppInfo r110 = ((PreviewShelfManagementViewModel) r10.B1()).getShelfAppInfo();
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

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity
    public final void C1(Intent r3) {
        PreviewShelfManagementViewModel r0 = B1();
        if (r3 == null) goto L5;
        ShelfInfo r4 = (ShelfInfo) r3.getParcelableExtra("key_shelf_info_data");
    L6:
        r0.initData(r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder.a
    public final void E(bq0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        super.E(r3);
        BusinessToolType r4 = r3.b();
        if (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.a.b[r4.ordinal()] != 1) goto L18;
        OpenPlatformContext r5 = A1().a();
        if (r5 == null) goto L16;
        AnchorMiniAppAppLogContextService r6 = (AnchorMiniAppAppLogContextService) r5.getService(AnchorMiniAppAppLogContextService.class);
        if (r6 == null) goto L17;
        ShelfMicroAppInfo r0 = B1().getShelfAppInfo();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void I1(final Function0<Unit> r7) {
        if (((PreviewShelfManagementViewModel) B1()).checkNewShelf() == false) goto L15;
        x0.b r0 = new x0.b(this, 7);
        r0.m(2131920904);
        r0.l(2131920903);
        r0.j(0, s1.B(2131920953), new b(this, r7));
        r0.j(1, s1.B(2131920891), new c(this));
        r0.setCornerRadius(16.0f);
        r0.k(0, true);
        r0.n();
        OpenPlatformContext r8 = A1().a();
        if (r8 == null) goto L19;
        AnchorMiniAppAppLogContextService r9 = (AnchorMiniAppAppLogContextService) r8.getService(AnchorMiniAppAppLogContextService.class);
        if (r9 == null) goto L20;
        ShelfMicroAppInfo r1 = ((PreviewShelfManagementViewModel) B1()).getShelfAppInfo();
        if (r1 == null) goto L12;
        String r2 = r1.appId;
        if (r2 == null) goto L12;
    L13:
        r9.reportExitBindPushShow(r2, "direct_close");
        return;
    L12:
        r2 = "";
        goto L13
    L20:
        return;
    L19:
        return;
    L15:
        if (((PreviewShelfManagementViewModel) B1()).checkShelfModify() == false) goto L17;
        x0.b r3 = new x0.b(this, 7);
        r3.m(2131920905);
        r3.j(0, s1.B(2131921054), new PreviewShelfManagementActivity$checkSaveShelfBeforeExit$3(this, r7));
        r3.j(1, s1.B(2131920969), new d(r7));
        r3.setCornerRadius(16.0f);
        r3.k(0, true);
        r3.n();
        return;
    L17:
        r7.invoke();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity
    public final View _$_findCachedViewById(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.g.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.businesstools.viewholder.BaseBusinessToolItemViewHolder.a
    public final void g1(bq0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super.g1(r2);
        BusinessToolType r3 = r2.b();
        if (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview.a.a[r3.ordinal()] != 1) goto L7;
        ((PreviewShelfManagementViewModel) B1()).openCouponPage(this);
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.ShelfManagementActivity
    public final void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        this.i = true;
    }
}
