package com.obric.aiproactive.ui.entry;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.ui.databinding.ActivityProactiveV2Binding;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020\u0011H\u0014J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)H\u0014J\b\u0010*\u001a\u00020$H\u0014J\b\u0010+\u001a\u00020$H\u0002J\u0006\u0010,\u001a\u00020$J\u0012\u0010-\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0006\u0010.\u001a\u00020\u0013J\u0006\u0010/\u001a\u00020\u0011J\u0006\u00100\u001a\u00020$J\u0012\u00101\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J \u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0013H\u0002J\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ProactiveV2Activity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/aiproactive/ui/databinding/ActivityProactiveV2Binding;", "startupCoordinatorViewModel", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorViewModel;", "getStartupCoordinatorViewModel", "()Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorViewModel;", "startupCoordinatorViewModel$delegate", "Lkotlin/Lazy;", "isFirstEnter", "", "previousPageOnFirstEnter", "", "sessionEnterFrom", "pendingStartupDetailOpen", "hasHandledFirstAppForeground", "pendingDto", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "getPendingDto", "()Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "setPendingDto", "(Lcom/obric/aiproactive/api/ProactiveRecommendationDto;)V", "pendingIsExecute", "getPendingIsExecute", "()Z", "setPendingIsExecute", "(Z)V", "needLoginCheckOnCreate", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onAppForeground", "setupPager", "showAllPageForStartupFallback", "handleStartupIntent", "currentEnterFrom", "shouldSuppressFeedEnterPage", "onStartupDetailHandled", "updateStartupTracking", "reportFeedEnterPage", "position", "", "previousPage", "enterMethod", "setTitleBlurAlpha", "alpha", "", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveV2Activity extends BaseProactiveActivity {
    private static final a Companion = null;
    private static final String EXTRA_INSPIRATION_ID = "inspirationId";
    private static final String TAG = "ProactiveUI";
    private ActivityProactiveV2Binding binding;
    private boolean hasHandledFirstAppForeground;
    private boolean isFirstEnter;
    private final NavigationBarScheme navigationBarScheme;
    private ProactiveRecommendationDto pendingDto;
    private boolean pendingIsExecute;
    private boolean pendingStartupDetailOpen;
    private String previousPageOnFirstEnter;
    private String sessionEnterFrom;
    private final Lazy startupCoordinatorViewModel$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ProactiveV2Activity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_INSPIRATION_ID", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public ProactiveV2Activity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        this.startupCoordinatorViewModel$delegate = LazyKt.lazy(new $$Lambda$ProactiveV2Activity$LdyBUagZvEUcCcejeBY6OmE3UFw(this));
        this.isFirstEnter = true;
        this.sessionEnterFrom = "desktop_icon";
    }

    public static final /* synthetic */ ActivityProactiveV2Binding access$getBinding$p(ProactiveV2Activity r2) {
        return ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ String access$getPreviousPageOnFirstEnter$p(ProactiveV2Activity r2) {
        return ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).previousPageOnFirstEnter;
    }

    public static final /* synthetic */ boolean access$isFirstEnter$p(ProactiveV2Activity r2) {
        return ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).isFirstEnter;
    }

    public static final /* synthetic */ void access$reportFeedEnterPage(ProactiveV2Activity r2, int r3, String r4, String r5) {
        ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).reportFeedEnterPage(r3, r4, r5);
    }

    public static final /* synthetic */ void access$setFirstEnter$p(ProactiveV2Activity r2, boolean r3) {
        ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).isFirstEnter = r3;
    }

    public static final /* synthetic */ void access$setPreviousPageOnFirstEnter$p(ProactiveV2Activity r2, String r3) {
        ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).previousPageOnFirstEnter = r3;
    }

    private final StartupInspirationCoordinatorViewModel getStartupCoordinatorViewModel() {
        return (StartupInspirationCoordinatorViewModel) ZeusTransformUtils.preCheckCast(this.startupCoordinatorViewModel$delegate.getValue(), StartupInspirationCoordinatorViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void handleStartupIntent(Intent r13) {
        ActivityProactiveV2Binding r0 = null;
        if (r13 == null) goto L5;
        String r1 = r13.getStringExtra(EXTRA_INSPIRATION_ID);
    L6:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("[StartupFlow] handleStartupIntent inspirationId=").append(r1).append(" hasIntent=");
        boolean r3 = true;
        if (r13 == null) goto L9;
        boolean r14 = true;
    L10:
        IRunLog.a.a(r5, TAG, r2.append(r14).toString(), false, 4, null);
        getStartupCoordinatorViewModel().updatePendingInspirationId(r1);
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L13;
    L16:
        if (r3 == true) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[StartupFlow] moveToNowForStartup inspirationId=" + r1, false, 4, null);
        ActivityProactiveV2Binding r12 = this.binding;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r0.vpFeed.setCurrentItem(0, false);
        return;
    L20:
        r0 = r12;
        goto L21
    L23:
        return;
    L13:
        if (StringsKt.isBlank(r15) == true) goto L16;
        r3 = false;
        goto L16
    L9:
        r14 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void lambda$0SZU93NK0EKFBBPlgOv50wxAUnU(ProactiveV2Activity r0, View r1) {
        onCreateChecked$lambda$6(r0, r1);
    }

    public static /* synthetic */ void lambda$Kosnma5KiGBIALhmrpC0W7WS2Wc(ProactiveV2Activity r0) {
        onStartupDetailHandled$lambda$8(r0);
    }

    public static /* synthetic */ StartupInspirationCoordinatorViewModel lambda$LdyBUagZvEUcCcejeBY6OmE3UFw(ProactiveV2Activity r0) {
        return startupCoordinatorViewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ WindowInsets lambda$oPF0xWXwqToo6U7xrATCEt6X8rY(ProactiveV2Activity r0, int r1, int r2, View r3, WindowInsets r4) {
        return onCreateChecked$lambda$5(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$pVomhIbvaNg9l9qOiN_Aar7TIZo(ProactiveV2Activity r0) {
        onAppForeground$lambda$7(r0);
    }

    private static final void onAppForeground$lambda$7(ProactiveV2Activity r3) {
        ProactiveV2Activity r4 = (ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveV2Activity.class, "com.obric.memorydata.plugin");
        if (r4.isFirstEnter == false) goto L5;
        return;
    L5:
        if (r4.shouldSuppressFeedEnterPage() == true) goto L12;
        ActivityProactiveV2Binding r0 = r4.binding;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        r4.reportFeedEnterPage(r0.vpFeed.getCurrentItem(), "", "click");
        return;
    }

    private static final WindowInsets onCreateChecked$lambda$5(ProactiveV2Activity r8, int r9, int r10, View r11, WindowInsets r12) {
        ProactiveV2Activity r13 = (ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r8, ProactiveV2Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "<unused var>");
        Intrinsics.checkNotNullParameter(r12, "insets");
        int r14 = r12.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        int r0 = r12.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r2 = (int) (14 * ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        ActivityProactiveV2Binding r3 = r13.binding;
        ActivityProactiveV2Binding r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L5:
        LinearLayout r5 = r3.titleContainer;
        Intrinsics.checkNotNullExpressionValue(r5, "titleContainer");
        View r6 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        Objects.requireNonNull(r7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r15 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).topMargin = r14 + r2;
        r6.setLayoutParams(r15);
        ActivityProactiveV2Binding r16 = r13.binding;
        if (r16 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L8:
        FrameLayout r17 = r16.bottomMoreHandle;
        Intrinsics.checkNotNullExpressionValue(r17, "bottomMoreHandle");
        View r18 = (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r1 = r18.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r1.height = r9 + r0;
        r18.setLayoutParams(r1);
        ActivityProactiveV2Binding r19 = r13.binding;
        if (r19 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        View r20 = r4.bottomBlur;
        Intrinsics.checkNotNullExpressionValue(r20, "bottomBlur");
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        Objects.requireNonNull(r21, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        r21.height = r10 + r0;
        r20.setLayoutParams(r21);
        return r12;
    L11:
        r4 = r19;
        goto L12
    }

    private static final void onCreateChecked$lambda$6(ProactiveV2Activity r1, View r2) {
        ActivityProactiveV2Binding r3 = ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r1, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).binding;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L5:
        r3.vpFeed.setCurrentItem(1, true);
    }

    private static final void onStartupDetailHandled$lambda$8(ProactiveV2Activity r2) {
        ((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveV2Activity.class, "com.obric.memorydata.plugin")).pendingStartupDetailOpen = false;
    }

    private final void reportFeedEnterPage(int r2, String r3, String r4) {
        if (r2 != 1) goto L5;
        String r5 = "proactive_all";
    L6:
        com.obric.aiproactive.ui.util.h.f6884a.b(r5, r3, this.sessionEnterFrom, r4);
        return;
    L5:
        r5 = "home";
        goto L6
    }

    private final void setupPager() {
        ActivityProactiveV2Binding r0 = this.binding;
        ActivityProactiveV2Binding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.vpFeed.setOrientation(1);
        ActivityProactiveV2Binding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        r2.vpFeed.setUserInputEnabled(false);
        ActivityProactiveV2Binding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        r3.vpFeed.setOffscreenPageLimit(1);
        ActivityProactiveV2Binding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        r4.vpFeed.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        ActivityProactiveV2Binding r5 = this.binding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        r5.vpFeed.registerOnPageChangeCallback((ViewPager2.OnPageChangeCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), ViewPager2.OnPageChangeCallback.class, "com.obric.memorydata.plugin"));
        ActivityProactiveV2Binding r6 = this.binding;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L20:
        r6.vpFeed.setCurrentItem(0, false);
        ActivityProactiveV2Binding r7 = this.binding;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L23:
        r7.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.proactive_title_now, TypedValues.Custom.S_STRING, "proactive_title_now")), CharSequence.class, "com.obric.memorydata.plugin"));
        ActivityProactiveV2Binding r8 = this.binding;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L26:
        r8.tvTitle.setVisibility(8);
        ActivityProactiveV2Binding r9 = this.binding;
        if (r9 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L29:
        r9.bottomMoreHandle.setVisibility(8);
        ActivityProactiveV2Binding r10 = this.binding;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L33:
        r1.bottomBlur.setVisibility(8);
        return;
    L32:
        r1 = r10;
        goto L33
    }

    private static final StartupInspirationCoordinatorViewModel startupCoordinatorViewModel_delegate$lambda$0(ProactiveV2Activity r3) {
        return (StartupInspirationCoordinatorViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast((ProactiveV2Activity) ZeusTransformUtils.wrapperContextForParams(r3, ProactiveV2Activity.class, "com.obric.memorydata.plugin"), ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(StartupInspirationCoordinatorViewModel.class), StartupInspirationCoordinatorViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void updateStartupTracking(Intent r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.getStringExtra("enter_from");
    L6:
        if (r3 == null) goto L8;
        r0 = r3.getStringExtra(EXTRA_INSPIRATION_ID);
    L8:
        String r4 = com.obric.aiproactive.ui.util.n.a(r1, r0);
        this.sessionEnterFrom = r4;
        this.pendingStartupDetailOpen = Intrinsics.areEqual(r4, "lockscreen_card");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final String currentEnterFrom() {
        return this.sessionEnterFrom;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    public final ProactiveRecommendationDto getPendingDto() {
        return this.pendingDto;
    }

    public final boolean getPendingIsExecute() {
        return this.pendingIsExecute;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onAppForeground() {
        super.onAppForeground();
        if (this.hasHandledFirstAppForeground == true) goto L6;
        this.hasHandledFirstAppForeground = true;
        return;
    L6:
        ActivityProactiveV2Binding r0 = this.binding;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        r0.getRoot().post(new $$Lambda$ProactiveV2Activity$pVomhIbvaNg9l9qOiN_Aar7TIZo(this));
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onCreateChecked(Bundle r9) {
        ActivityProactiveV2Binding r10 = ActivityProactiveV2Binding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        ActivityProactiveV2Binding r0 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        AiProactiveUiModeController r11 = AiProactiveUiModeController.f6869a;
        Configuration r4 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r4, "getConfiguration(...)");
        boolean r12 = !r11.b(r4);
        Window r5 = getWindow();
        ActivityProactiveV2Binding r6 = this.binding;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L8:
        WindowInsetsControllerCompat r7 = new WindowInsetsControllerCompat(r5, (View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        r7.setAppearanceLightStatusBars(r12);
        r7.setAppearanceLightNavigationBars(r12);
        ActivityProactiveV2Binding r13 = this.binding;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L11:
        final int r14 = r13.bottomMoreHandle.getLayoutParams().height;
        ActivityProactiveV2Binding r8 = this.binding;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L14:
        final int r15 = r8.bottomBlur.getLayoutParams().height;
        ActivityProactiveV2Binding r16 = this.binding;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L17:
        r16.getRoot().setOnApplyWindowInsetsListener(new $$Lambda$ProactiveV2Activity$oPF0xWXwqToo6U7xrATCEt6X8rY(this, r14, r15));
        this.previousPageOnFirstEnter = "";
        updateStartupTracking(getIntent());
        setupPager();
        handleStartupIntent(getIntent());
        ActivityProactiveV2Binding r17 = this.binding;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L20:
        r17.bottomMoreHandle.setOnClickListener(new $$Lambda$ProactiveV2Activity$0SZU93NK0EKFBBPlgOv50wxAUnU(this));
        float r18 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        ActivityProactiveV2Binding r3 = this.binding;
        if (r3 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L23:
        float r19 = r18 * 8.0f;
        BlurUtils.a(r3.titleBlur, BlurUtils.BlurType.PROGRESS_BLUR_DOWN_UP, r19, new int[0]);
        ActivityProactiveV2Binding r20 = this.binding;
        if (r20 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L27:
        BlurUtils.a(r0.bottomBlur, BlurUtils.BlurType.PROGRESS_BLUR_UP_DOWN, r19, new int[0]);
        return;
    L26:
        r0 = r20;
        goto L27
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        super.onNewIntent(r2);
        updateStartupTracking(r2);
        handleStartupIntent(r2);
    }

    public final void onStartupDetailHandled() {
        ActivityProactiveV2Binding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.getRoot().post(new $$Lambda$ProactiveV2Activity$Kosnma5KiGBIALhmrpC0W7WS2Wc(this));
    }

    public final void setPendingDto(ProactiveRecommendationDto r1) {
        this.pendingDto = r1;
    }

    public final void setPendingIsExecute(boolean r1) {
        this.pendingIsExecute = r1;
    }

    public final void setTitleBlurAlpha(float r3) {
        ActivityProactiveV2Binding r2 = this.binding;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        r2.titleBlur.setAlpha(RangesKt.coerceIn(r3, 0.0f, 1.0f));
    }

    public final boolean shouldSuppressFeedEnterPage() {
        return this.pendingStartupDetailOpen;
    }

    public final void showAllPageForStartupFallback() {
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("[StartupFlow] showAllPageForStartupFallback currentItem=");
        ActivityProactiveV2Binding r2 = this.binding;
        ActivityProactiveV2Binding r7 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        IRunLog.a.a(r1, TAG, r0.append(r2.vpFeed.getCurrentItem()).toString(), false, 4, null);
        ActivityProactiveV2Binding r9 = this.binding;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r7.vpFeed.setCurrentItem(1, false);
        return;
    L8:
        r7 = r9;
        goto L9
    }
}
