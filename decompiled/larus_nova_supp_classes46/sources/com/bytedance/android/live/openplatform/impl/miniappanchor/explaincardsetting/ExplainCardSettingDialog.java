package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.R;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.applog.AnchorMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincardsetting/ExplainCardSettingDialog;", "Landroidx/fragment/app/FragmentActivity;", "", "<init>", "()V", "a", "b", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardSettingDialog extends FragmentActivity {
    public static final /* synthetic */ int k = 0;
    public Map<Integer, View> a;
    public final int b;
    public final int c;
    public com.bytedance.android.live.openplatform.impl.base.utils.h d;
    public final Lazy e;
    public boolean f;
    public final Lazy g;
    public so0.a h;
    public boolean i;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a j;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c implements Animation.AnimationListener {
        public final /* synthetic */ ExplainCardSettingDialog a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public c(ExplainCardSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            com.bytedance.android.live.openplatform.impl.base.utils.m.e(this.a._$_findCachedViewById(2131384813), Boolean.FALSE);
            ExplainCardSettingDialog r3 = this.a;
            r3.i = false;
            ExplainCardSettingDialog.y1(r3);
        }
    }

    public static final class d implements View.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
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
            r1.dismiss();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ ExplainCardSettingDialog a;

        public f(ExplainCardSettingDialog r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            ExplainCardSettingDialog r3 = this.a;
            int r4 = ExplainCardSettingDialog.k;
            if (r3.z1().isTalentMount() == false) goto L5;
            this.a.z1().clearTalentPayload();
        L5:
            this.a.finish();
        }
    }

    static {
    }

    public final ExplainCardSettingViewModel z1() {
        return (ExplainCardSettingViewModel) this.e.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1() {
        this.d = new com.bytedance.android.live.openplatform.impl.base.utils.h(this, this.b, this.c, new ExplainCardSettingDialog$jumpToGallery$1(this));
        com.bytedance.android.live.core.utils.q.o(this, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        if (this.f == true) goto L15;
        this.f = true;
        if (z1().isShelf() == true) goto L11;
        ILiveMiniAppService r2 = jc1.k.f(ILiveMiniAppService.class);
        if (r2 == null) goto L11;
        r2.setMiniAppActivityStatue(false);
    L11:
        if (this.i == false) goto L13;
        xs2.b.a().post(new zp0.a());
    L13:
        LinearLayout r3 = (LinearLayout) _$_findCachedViewById(2131384813);
        Animation r4 = AnimationUtils.loadAnimation(this, 2130772636);
        r4.setAnimationListener(new c(this));
        Unit r5 = Unit.INSTANCE;
        r3.startAnimation(r4);
    L15:
        if ((this instanceof ChatWindowActivity) == true) goto L68;
        FLogger r6 = FLogger.a;
        r6.i("ActivityLancet", "finish ".concat(ExplainCardSettingDialog.class.getName()));
        long r7 = SystemClock.uptimeMillis();
        Map r8 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r8);
        Long r9 = (Long) r8.get(this);     // Catch: Throwable -> L57
        if (r9 != null) goto L22;
    L25:
        r8.put(this, Long.valueOf(r7));     // Catch: Throwable -> L57
        monitor-exit(r8);     // Catch: Throwable -> L57
    L54:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L65:
        return;
    L28:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L31;
        r6.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L54
    L60:
        goto L65
    L31:
        if (isFinishing() == true) goto L34;
        r6.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L54
        goto L60
    L34:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L37;
        r6.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L54
        goto L60
    L37:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L40;
        r6.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L54
        goto L60
    L40:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L43;
        r6.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L54
        goto L60
    L43:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L45;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L54
        goto L60
    L45:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L54
        if (r1 == null) goto L60;
        r1.addFlags(268435456);     // Catch: Throwable -> L54
        r1.addFlags(2097152);     // Catch: Throwable -> L54
        r6.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L54
        startActivity(r1);     // Catch: Throwable -> L51
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L54
        goto L60
    L22:
        if ((r7 - r9.longValue()) >= 800) goto L25;
        monitor-exit(r8);     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        throw th;
    }

    public ExplainCardSettingDialog() {
        this.j = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.a = new LinkedHashMap();
        this.b = 750;
        this.c = 751;
        this.e = LazyKt.lazy(new ExplainCardSettingDialog$viewModel$2(this));
        this.g = LazyKt.lazy(new ExplainCardSettingDialog$processDialog$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1() {
        if (z1().isEdit() == true) goto L5;
    L8:
        z1().reportGiveUpRemainder();
        if (z1().isShelf() == true) goto L11;
    L13:
        so0.a r0 = this.h;
        if (r0 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L16:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L23;
        AnchorShelfContextService r2 = (AnchorShelfContextService) r1.getService(AnchorShelfContextService.class);
        if (r2 == null) goto L23;
        if (r2.isMounted() != true) goto L23;
        int r3 = 2131920424;
    L24:
        x0.b r4 = new x0.b(this, 4);
        r4.a.d = getString(r3);
        r4.j(1, getString(2131920416), e.a);
        r4.j(0, getString(2131920419), new f(this));
        r4.k(0, true);
        r4.n();
        return;
    L23:
        r3 = 2131920425;
        goto L24
    L11:
        if (z1().isEdit() == true) goto L13;
        r3 = 2131920426;
        goto L24
    L5:
        if (z1().isCardChanged() == true) goto L8;
        finish();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.j.b();
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
        B1();
    }

    public static final /* synthetic */ void y1(ExplainCardSettingDialog r0) {
        super.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L44
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L44
    L8:
        super.onCreate(r7);
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r8 = (so0.a) ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().a.b.get();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.h = r8;
        setContentView(2131565460);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -2);
        overridePendingTransition(2130772626, 0);
        ExplainCardSettingsInfo r9 = (ExplainCardSettingsInfo) getIntent().getParcelableExtra("explain_card_info");
        if (r9 == null) goto L12;
        z1().initData(r9);
    L12:
        ((ImageView) _$_findCachedViewById(2131363770)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.f(this));
        ((ImageView) _$_findCachedViewById(2131366984)).setOnClickListener(new g(this));
        z1().getFinish().a(this, new ExplainCardSettingDialog$initView$3(this));
        z1().getExplainCardInfo().a(this, new ExplainCardSettingDialog$initView$4(this));
        z1().getLoadingStatus().a(this, new ExplainCardSettingDialog$initView$5(this));
        ((RelativeLayout) _$_findCachedViewById(2131386962)).setOnClickListener(new h(this));
        z1().getCustomCover().a(this, new ExplainCardSettingDialog$initView$7(this));
        ((RelativeLayout) _$_findCachedViewById(2131368169)).setOnClickListener(new i(this));
        z1().getChangeCoverEvent().a(this, new ExplainCardSettingDialog$initView$9(this));
        z1().getCustomTitle().a(this, new ExplainCardSettingDialog$initView$10(this));
        ((RelativeLayout) _$_findCachedViewById(2131388903)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.c(this));
        if (z1().isShelf() == false) goto L15;
        ((RelativeLayout) _$_findCachedViewById(2131386384)).setVisibility(8);
    L15:
        so0.a r10 = this.h;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L18:
        int r11 = r10.getCoexistComponent();
        if (r11 == 0) goto L21;
        ((RelativeLayout) _$_findCachedViewById(2131386384)).setAlpha(0.4f);
        ((RelativeLayout) _$_findCachedViewById(2131386384)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.a(r11));
        _$_findCachedViewById(2131369156).setEnabled(false);
    L21:
        z1().isIntroducing().a(this, new ExplainCardSettingDialog$initShowExplainCardLayout$2(this));
        LiveSwitchButton r12 = _$_findCachedViewById(2131369156);
        if (r12 == null) goto L24;
        r12.setOnCheckedChangeListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.b(this));
    L24:
        ((TextView) _$_findCachedViewById(2131364821)).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.d(this));
        ((LinearLayout) _$_findCachedViewById(2131384813)).post(new com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.e(this));
        HashMap<String, zo0.f> r0 = zo0.g.a;
        zo0.f r1 = zo0.h.b(PerformanceScene.EXPLAIN_CARD_SETTING_DIALOG);
        int r2 = zo0.f.d;
        r1.l("view_created", null);
        z1().observerData();
        ((LinearLayout) _$_findCachedViewById(2131384813)).setOnClickListener(d.a);
        so0.a r13 = this.h;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L27:
        OpenPlatformContext r14 = r13.a();
        if (r14 == null) goto L32;
        AnchorMiniAppAppLogContextService r15 = (AnchorMiniAppAppLogContextService) r14.getService(AnchorMiniAppAppLogContextService.class);
        if (r15 == null) goto L32;
        r15.reportExplainCardSettingShow();
    L32:
        so0.a r16 = this.h;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L35:
        OpenPlatformContext r17 = r16.a();
        if (r17 == null) goto L47;
        AnchorMiniAppAppLogContextService r18 = (AnchorMiniAppAppLogContextService) r17.getService(AnchorMiniAppAppLogContextService.class);
        if (r18 == null) goto L48;
        String r3 = z1().getAppId();
        if (r3 != null) goto L42;
        r3 = "";
    L42:
        r18.reportAnchorExplainCardSettingsShow(r3);
        return;
    L48:
        return;
    }

    public final void onNewIntent(Intent r3) {
        if (r3 == null) goto L7;
        ExplainCardSettingsInfo r0 = (ExplainCardSettingsInfo) r3.getParcelableExtra("explain_card_info");
        if (r0 == null) goto L7;
        z1().initData(r0);
    L7:
        super.onNewIntent(r3);
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (r2 != null) goto L5;
    L7:
        return true;
    L5:
        if (r2.getAction() != 1) goto L7;
        B1();
        goto L7
    }

    public final void onActivityResult(int r6, int r7, Intent r8) {
        super.onActivityResult(r6, r7, r8);
        com.bytedance.android.live.openplatform.impl.base.utils.h r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r6 != 40003) goto L16;
        if (r7 != 0) goto L10;
        com.bytedance.android.live.openplatform.impl.base.utils.e r9 = r0.d;
        if (r9 == null) goto L106;
        r9.onCanceled();
        return;
    L106:
        return;
    L10:
        if (r8 != null) goto L14;
        com.bytedance.android.live.openplatform.impl.base.utils.e r10 = r0.d;
        if (r10 == null) goto L108;
        r10.onCanceled();
        return;
    L108:
        return;
    L14:
        r0.e(r8.getData(), false);
        return;
    L16:
        if (r6 != 40004) goto L24;
        if (r7 != 0) goto L87;
        com.bytedance.android.live.openplatform.impl.base.utils.e r11 = r0.d;
        if (r11 == null) goto L111;
        r11.onCanceled();
        return;
    L111:
        return;
    L87:
        r0.e(r0.b(), true);     // Catch: Exception -> L82
        return;
    L119:
        return;
    L24:
        if (r6 != 40002) goto L113;
        if (r7 != 0) goto L29;
        com.bytedance.android.live.openplatform.impl.base.utils.e r12 = r0.d;
        if (r12 == null) goto L114;
        r12.onCanceled();
        return;
    L114:
        return;
    L29:
        IHostApp r13 = jc1.k.f(IHostApp.class);
        if (r13 != null) goto L32;
    L74:
        PolarisFileWrapper r14 = new PolarisFileWrapper(r0.b + "/" + r0.c());
        if (r14.exists() == false) goto L116;
        String r15 = r14.getAbsolutePath();
        com.bytedance.android.live.openplatform.impl.base.utils.e r16 = r0.d;
        if (r16 == null) goto L117;
        r16.a(r15);
        return;
    L117:
        return;
    L116:
        return;
    L32:
        if (r13.shouldUseScopedStorage() == false) goto L74;
        if (r0.g == null) goto L74;
        FileInputStream r17 = null;
        FileInputStream r18 = (FileInputStream) ContentResolverWrapper.openInputStream(r0.a.getContentResolver(), r0.g);     // Catch: Throwable -> L52 Exception -> L54
        PolarisFileOutputStreamWrapper r19 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(com.bytedance.android.live.openplatform.impl.base.utils.c.a(r0.a), r0.c()));     // Catch: Throwable -> L48 Exception -> L50
    L83:
        byte[] r20 = new byte[4096];     // Catch: Exception -> L46 Throwable -> L65
    L40:
        int r1 = r18.read(r20);     // Catch: Exception -> L46 Throwable -> L65
        if (r1 == (-1)) goto L96;
        r19.write(r20, 0, r1);     // Catch: Exception -> L46 Throwable -> L65
        goto L40
    L96:
        r18.close();     // Catch: Exception -> L80
    L92:
        r19.close();     // Catch: Exception -> L64
    L46:
        Exception e2 = e;
    L56:
        e2.printStackTrace();     // Catch: Throwable -> L65
        if (r18 != null) goto L85;
    L61:
        if (r19 == null) goto L74;
    L85:
        r18.close();     // Catch: Exception -> L60
    L65:
        th = move-exception;
        FileInputStream r4 = r18;
        Throwable r21 = th;
        r17 = r4;
    L67:
        if (r17 != null) goto L94;
    L71:
        if (r19 == null) goto L103;
        r19.close();     // Catch: Exception -> L81
        throw r21;
    L104:
        throw r21;
    L103:
        throw r21;
    L94:
        r17.close();     // Catch: Exception -> L70
    L50:
        e = move-exception;
        r19 = null;
        e2 = e;
    L48:
        th = move-exception;
        r19 = null;
        r17 = r18;
        r21 = th;
        goto L67
    L54:
        e = move-exception;
        r19 = null;
        e2 = e;
        r18 = null;
    L52:
        th = move-exception;
        r21 = th;
        r19 = null;
        goto L67
    }
}
