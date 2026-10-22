package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.nl.permission.CategoryWhenNotGranted;
import com.larus.dora.impl.nl.permission.ProactivePermission;
import com.larus.dora.impl.noti_v3.overview.viewmodel.NotificationBroadcastV3ViewModel;
import com.larus.dora.impl.noti_v3.social_message.model.MessageModeSheetSource;
import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u0092\u00012\u00020\u0001:\u0002\u0092\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0016J$\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u00182\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\b\u0010?\u001a\u00020\u000fH\u0016J\b\u0010@\u001a\u00020\u000fH\u0016J\b\u0010A\u001a\u00020BH\u0016J\n\u0010C\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010D\u001a\u00020\u0018H\u0002J\b\u0010E\u001a\u00020\u0018H\u0002J\b\u0010F\u001a\u00020\u0018H\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020\u000fH\u0002J\b\u0010K\u001a\u00020\u000fH\u0002J\b\u0010L\u001a\u00020\u000fH\u0002J\b\u0010M\u001a\u00020\u000fH\u0002J\b\u0010N\u001a\u00020\u000fH\u0002J\b\u0010O\u001a\u00020\u000fH\u0002J\b\u0010P\u001a\u00020\u000fH\u0002J\b\u0010Q\u001a\u00020\u000fH\u0002J\u0010\u0010R\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020BH\u0002J\u0010\u0010T\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020BH\u0002J\b\u0010U\u001a\u00020\u000fH\u0002J\b\u0010V\u001a\u00020\u000fH\u0002J\b\u0010W\u001a\u00020\u000fH\u0002J\u0010\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000bH\u0002J\b\u0010Z\u001a\u00020\u000fH\u0002J\u0010\u0010[\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0018\u0010]\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000bH\u0002J\u0010\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\u000bH\u0002J\b\u0010b\u001a\u00020\u000fH\u0002J\u0010\u0010c\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\b\u0010d\u001a\u00020\u000fH\u0002J\b\u0010e\u001a\u00020\u000fH\u0002J0\u0010f\u001a\u00020\u000f2\u0010\b\u0002\u0010g\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010h2\u0014\b\u0002\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010j\u001a\u00020\u000fH\u0002J\u0018\u0010k\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH\u0002J\u0018\u0010n\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH\u0002J\u0018\u0010o\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH\u0002J\u0018\u0010p\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000bH\u0002J\b\u0010q\u001a\u00020\u000fH\u0002J\u0010\u0010r\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020\u000bH\u0002J\u0010\u0010t\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020\u000bH\u0002J\u0010\u0010v\u001a\u00020\u000f2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0016\u0010w\u001a\u00020\u000f2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u000f0hH\u0002J8\u0010y\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020B2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010B2\u0006\u0010|\u001a\u00020}2\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J3\u0010\u007f\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020B2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010B2\u0006\u0010|\u001a\u00020}2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0hH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020\u00182\u0006\u0010z\u001a\u00020BH\u0002J\t\u0010\u0082\u0001\u001a\u00020\u000fH\u0002J\r\u0010\u0083\u0001\u001a\u00020\u000f*\u00020\u001cH\u0002J\r\u0010\u0084\u0001\u001a\u00020\u000f*\u00020\u001cH\u0002J\u000e\u0010\u0085\u0001\u001a\u00020\u000f*\u00030\u0086\u0001H\u0002J\t\u0010\u0087\u0001\u001a\u00020}H\u0002J\t\u0010\u0088\u0001\u001a\u00020}H\u0002J\t\u0010\u0089\u0001\u001a\u00020}H\u0002J\u000e\u0010\u008a\u0001\u001a\u00020\u000f*\u00030\u008b\u0001H\u0002J\u000e\u0010\u008c\u0001\u001a\u00020\u000f*\u00030\u008b\u0001H\u0002J\u0012\u0010\u008d\u0001\u001a\u00020\u000f2\u0007\u0010\u008e\u0001\u001a\u00020\u0018H\u0002J\r\u0010\u008f\u0001\u001a\u00020}*\u00020}H\u0002J\u000e\u0010\u0090\u0001\u001a\u00020}*\u00030\u0091\u0001H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u0001010100X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsBroadcastSettingFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/overview/viewmodel/NotificationBroadcastV3ViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "firstResume", "", "waitingForNotificationListenerSettings", "notificationListenerSettingsReturnAction", "Lkotlin/Function1;", "", "mainHandle", "Landroid/os/Handler;", "settings", "Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "getSettings", "()Lcom/larus/dora/impl/settings/DoraPushSummaryConfig;", "settings$delegate", "pageMaskView", "Landroid/view/View;", "notificationSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "notificationSwitchCard", "Lcom/obric/oui/lisitem/OCardListItem;", "contentTitle", "contentGroup", "socialMessageItem", "serviceNoticeItem", "appManagementGroup", "appListItem", "customRulesItem", "behaviorTitle", "behaviorGroup", "Landroid/widget/LinearLayout;", "freqItem", "priorityItem", "headGestureItem", "headGestureSwitch", "moreTitle", "wearingRemindItem", "wearingRemindSwitch", "invalidHelpGroup", "headControlLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildNotificationTips", "buildNotificationTipsText", "", "openSocialMessagePage", "openServiceNoticeSheet", "openAppListPage", "openCustomRulesPage", "openFrequencySheet", "openConflictSheet", "openInvalidHelpPage", "observeFragmentResult", "handleConflictSelected", "mode", "handleRhythmSelected", "observeNotificationState", "observeNotificationPrivacyState", "observeWearingRemindState", "bindWearingRemindSwitch", "currentState", "observeUiState", "updateNotificationSectionState", "enabled", "updateMoreSectionState", "showWearingRemind", "showInvalidHelp", "updateInvalidHelpGap", "showGap", "bindNotificationSwitchClick", "handleNotificationSwitchClick", "showNotificationPrivacyDialog", "checkPermissionAndEnableNotification", "showNotificationListenerDialog", "onCancel", "Lkotlin/Function0;", "onSettingsReturn", "checkPermissionOnFirstResume", "checkPermissionOnOther", "isProactiveNotificationEnabled", "isProactiveChatEnabled", "checkNotificationListenerOnFirstResume", "handleNotificationListenerDeniedOnFirstResume", "checkPermissionOnHonor", "updateHeadGestureControl", "onHeadGestureSwitchChanged", "isChecked", "revertHeadGestureSwitch", "checked", "updateHeadGestureControlState", "showHeadControlDisableDialog", "onConfirm", "buildSwitchCard", "title", "subtitle", "position", "", "onSwitchCreated", "buildArrowCard", "onClick", "buildSectionTitle", "updatePriorityItemCornerByHeadGesture", "applyCardStyle", "resetCardContainerMargins", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applySectionTitleTextStyle", "relaxClipForShadow", "target", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsBroadcastSettingFragment extends DoraBaseFragment {
    public static final /* synthetic */ int F = 0;
    public OSectionTitleBar A;
    public OCardListItem B;
    public OSwitch C;
    public OCardListItem D;
    public final ActivityResultLauncher<Intent> E;
    public final Lazy f;
    public boolean g;
    public boolean h;
    public Function1<? super Boolean, Unit> i;
    public final Handler j;
    public final Lazy k;
    public View l;
    public OSwitch m;
    public OSectionTitleBar n;
    public View o;
    public OCardListItem p;
    public OCardListItem q;
    public View r;
    public OCardListItem s;
    public OCardListItem t;
    public OSectionTitleBar u;
    public LinearLayout v;
    public OCardListItem w;
    public OCardListItem x;
    public OCardListItem y;
    public OSwitch z;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsBroadcastSettingFragment$onAttach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.earbuds.broadcast.DoraObricEarbudsBroadcastSettingFragment$onAttach$1", f = "DoraObricEarbudsBroadcastSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            DoraUserSettingsManager.a.h("enterNotificationBroadcastV3");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final String k() {
        return "dora_broadcast_settings";
    }

    public final void onDestroyView() {
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final NotificationBroadcastV3ViewModel ea0() {
        return (NotificationBroadcastV3ViewModel) this.f.getValue();
    }

    public final void la0() {
        final OCardListItem r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        OCardListItem r1 = this.y;
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
        int r3 = 2;
    L14:
        OCardListItem.h(r0, r3);
        X90(r0);
        r0.setOnContentClickListener(new j0(r0, this));
        return;
    L13:
        r3 = 3;
        goto L14
    L8:
        if (r1.getVisibility() != 0) goto L10;
        r2 = true;
        goto L11
    }

    public DoraObricEarbudsBroadcastSettingFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsBroadcastSettingFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3ViewModel.class), new DoraObricEarbudsBroadcastSettingFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsBroadcastSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = true;
        this.j = new Handler(Looper.getMainLooper());
        this.k = LazyKt.lazy(new b1());
        this.E = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b0(this));
    }

    public final void ca0() {
        if (com.larus.dora.impl.nl.n.d() == true) goto L7;
        ia0(null, new o0(this));
        return;
    L7:
        if (DoraAVLinkDelegate.b.y() == false) goto L9;
        List r0 = CollectionsKt.listOf(new ProactivePermission[]{ProactivePermission.POST_NOTIFICATION, ProactivePermission.NOTIFICATION_LISTENER});
    L10:
        int r1 = p59.b.a;
        p59.b.c(this, r0, CategoryWhenNotGranted.INTERRUPT, new y0(this));
        return;
    L9:
        r0 = CollectionsKt.listOf(ProactivePermission.NOTIFICATION_LISTENER);
        goto L10
    }

    public final void ga0() {
        q59.a r0 = ((com.larus.dora.impl.noti_v3.overview.viewmodel.b) ea0().getUiState$impl_mainlandRelease().getValue()).h;
        if (r0 == null) goto L6;
        String r1 = r0.a;
        if (r1 == null) goto L6;
    L7:
        int r2 = DoraObricEarbudsMessageModeSheet.f;
        W90(DoraObricEarbudsMessageModeSheet.a.a(MessageModeSheetSource.CONFLICT, r1), getParentFragmentManager());
        return;
    L6:
        r1 = "1";
        goto L7
    }

    public final void onResume() {
        super.onResume();
        final boolean r1 = false;
        if (this.h == false) goto L8;
        this.h = false;
        boolean r0 = com.larus.dora.impl.nl.n.d();
        Function1<? super Boolean, Unit> r2 = this.i;
        this.i = null;
        if (r2 == null) goto L8;
        r2.invoke(Boolean.valueOf(r0));
    L8:
        if (this.g == false) goto L30;
        this.g = false;
        if (((DoraPushSummaryConfig) this.k.getValue()).getNotificationSummary() == true) goto L12;
    L14:
        final boolean r3 = false;
    L16:
        if (((DoraPushSummaryConfig) this.k.getValue()).getProactiveMessage() == true) goto L18;
    L20:
        if (r1 == true) goto L24;
        if (r3 == true) goto L24;
        g49.d.d("DoraObricEarbudsBroadcastSetting", "checkPermissionOnFirstResume: notification and proactive chat are both disabled");
    L24:
        if (DoraAVLinkDelegate.b.y() == false) goto L26;
        this.j.postDelayed(new d1(this, r3, r1), 50);
        goto L30
    L26:
        if (r1 == false) goto L28;
        int r4 = p59.b.a;
        p59.b.c(this, CollectionsKt.listOf(ProactivePermission.POST_NOTIFICATION), CategoryWhenNotGranted.NEXT, new x0(this, r3, r1));
        goto L30
    L28:
        ba0(r3, r1);
        goto L30
    L18:
        if (((Boolean) DoraUserSettingsManager.o.getValue()).booleanValue() == false) goto L20;
        r1 = true;
        goto L20
    L12:
        if (((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue() == false) goto L14;
        r3 = true;
    L30:
        if (((DoraPushSummaryConfig) this.k.getValue()).getNotificationSummary() == false) goto L33;
        ea0().syncSettings();
        return;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.l;
    }

    public final void X90(OCardListItem r7) {
        ViewGroup.LayoutParams r0 = r7.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r7.getCardContainer().setLayoutParams(r1);
    L9:
        r7.getContentContainer().setPadding(0, 0, da0(4), 0);
        r7.getTitleContainer().setGravity(16);
        r7.getTitleContainer().setPadding(da0(12), da0(10), da0(8), da0(10));
        OTextView r2 = r7.getTitleView();
        r2.setGravity(8388611);
        r2.setMaxLines(1);
        r2.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r2.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r2, ja0(22.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r7.o(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final View Z90(String r8) {
        OSectionTitleBar r0 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131367728);
        if (r1 == null) goto L5;
        r1.setPadding(da0(20), da0(8), da0(12), da0(8));
    L5:
        r0.setTitleText(r8);
        r0.setTitleTextSize(12.0f);
        r0.setTitleTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        TextView r2 = (TextView) r0.findViewById(2131388792);
        if (r2 == null) goto L8;
        r2.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r2.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r2, ja0(16.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    L8:
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }

    public final int da0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.dora.obric.device_management.setting.earbuds.broadcast.m0] */
    public final void fa0(boolean r4) {
        if (r4 == false) goto L17;
        int r5 = kj4.a.g().D();
        if (r5 != 1) goto L7;
        ha0(false);
        final ?? r6 = new m0(this);
        com.obric.oui.dialog.v2.alert.g r1 = new com.obric.oui.dialog.v2.alert.g(requireContext());
        r1.w = false;
        String r2 = getString(2131903159);
        r1.j = false;
        r1.h = r2;
        r1.i = getString(2131903158);
        com.obric.oui.dialog.v2.alert.g.c(r1);
        r1.e(getString(2131900590), new q0());
        r1.h(getString(2131903183), new r0(r6));
        com.obric.oui.dialog.v2.alert.c r7 = r1.a();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L16:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        return;
    L7:
        if (r5 == 2) goto L11;
        ha0(false);
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L22;
        Handler r0 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r8, getString(2131903117));
        return;
    L22:
        return;
    L11:
        ha0(true);
        com.larus.dora.impl.util.b0.a.getClass();
        com.larus.dora.impl.util.b0.K(true);
        return;
    L17:
        ha0(false);
        com.larus.dora.impl.util.b0.a.getClass();
        com.larus.dora.impl.util.b0.K(false);
    }

    public final void ha0(boolean r3) {
        OSwitch r0 = this.z;
        if (r0 == null) goto L6;
        r0.setOnCheckedChangeListener(null);
        r0.setChecked(r3);
        r0.setOnCheckedChangeListener(new i0(this));
        return;
    }

    public final int ja0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final void onAttach(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r8);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public static void W90(DoraObricEarbudsMessageModeSheet r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DoraObricEarbudsMessageModeSheet", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "DoraObricEarbudsMessageModeSheet");
    }

    public final void ba0(final boolean r3, final boolean r4) {
        if (com.larus.dora.impl.nl.n.d() == false) goto L5;
        return;
    L5:
        ia0(new g0(this, r3, r4), new h0(this, r3, r4));
    }

    public final void ia0(final Function0<Unit> r5, final Function1<? super Boolean, Unit> r6) {
        if (isStateSaved() == false) goto L5;
        return;
    L5:
        final Context r0 = getContext();
        if (r0 != null) goto L8;
        return;
    L8:
        com.larus.dora.impl.util.b0.a.getClass();
        com.larus.dora.impl.util.b0.F();
        com.obric.oui.dialog.v2.alert.g r1 = new com.obric.oui.dialog.v2.alert.g(r0);
        r1.w = false;
        String r3 = r0.getString(2131902205);
        r1.j = false;
        r1.h = r3;
        r1.i = r0.getString(2131902200);
        com.obric.oui.dialog.v2.alert.g.c(r1);
        r1.e(r0.getString(2131902465), new s0(r5));
        r1.h(r0.getString(2131903063), new t0(this, r6, r0));
        com.obric.oui.dialog.v2.alert.c r7 = r1.a();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    }

    public final void ka0(boolean r6, boolean r7) {
        boolean r0 = true;
        int r1 = 0;
        if (r6 == true) goto L7;
        if (r7 == true) goto L7;
        boolean r2 = false;
    L8:
        OSectionTitleBar r3 = this.A;
        int r4 = 8;
        if (r3 == null) goto L14;
        if (r2 == false) goto L12;
        int r5 = 0;
    L13:
        r3.setVisibility(r5);
        goto L14
    L12:
        r5 = 8;
    L14:
        OCardListItem r8 = this.B;
        if (r8 == null) goto L20;
        if (r6 == false) goto L18;
        int r9 = 0;
    L19:
        r8.setVisibility(r9);
        goto L20
    L18:
        r9 = 8;
    L20:
        OCardListItem r10 = this.D;
        if (r10 == null) goto L25;
        if (r7 == false) goto L24;
        r4 = 0;
    L24:
        r10.setVisibility(r4);
    L25:
        if (r6 == false) goto L28;
        if (r7 == false) goto L28;
    L29:
        OCardListItem r11 = this.D;
        LinearLayout.LayoutParams r12 = null;
        if (r11 == null) goto L32;
        ViewGroup.LayoutParams r13 = r11.getLayoutParams();
    L34:
        if ((r13 instanceof LinearLayout.LayoutParams) == false) goto L36;
        r12 = (LinearLayout.LayoutParams) r13;
    L36:
        if (r12 == null) goto L45;
        if (r0 == false) goto L40;
        r1 = da0(16);
    L40:
        if (r12.topMargin == r1) goto L46;
        r12.topMargin = r1;
        OCardListItem r14 = this.D;
        if (r14 == null) goto L47;
        r14.setLayoutParams(r12);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L32:
        r13 = null;
    L28:
        r0 = false;
    L7:
        r2 = true;
        goto L8
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        IObricDoraService r11 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r11 == null) goto L7;
        boolean r0 = true;
        if (r11.t() != true) goto L7;
    L9:
        if (r0 == false) goto L14;
        OCardListItem r1 = this.B;
        if (r1 == null) goto L13;
        r1.setVisibility(8);
    L13:
        ka0(false, ((Boolean) DoraUserSettingsManager.g.getValue()).booleanValue());
    L16:
        if (((DoraPushSummaryConfig) this.k.getValue()).getNotificationSummary() == false) goto L18;
        Lifecycle.State r12 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsBroadcastSettingFragment$observeNotificationState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsBroadcastSettingFragment$observeNotificationPrivacyState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsBroadcastSettingFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
        getParentFragmentManager().setFragmentResultListener("request_key_dora_obric_earbuds_privacy_agree", getViewLifecycleOwner(), new a0(this));
        getParentFragmentManager().setFragmentResultListener("request_key_message_mode_result", getViewLifecycleOwner(), new l0(this));
        ea0().syncSettings();
        return;
    L18:
        OSectionTitleBar r13 = this.n;
        if (r13 == null) goto L21;
        r13.setVisibility(8);
    L21:
        View r14 = this.o;
        if (r14 == null) goto L24;
        r14.setVisibility(8);
    L24:
        View r15 = this.r;
        if (r15 == null) goto L27;
        r15.setVisibility(8);
    L27:
        OSectionTitleBar r16 = this.u;
        if (r16 == null) goto L30;
        r16.setVisibility(8);
    L30:
        LinearLayout r17 = this.v;
        if (r17 == null) goto L35;
        r17.setVisibility(8);
        return;
    L35:
        return;
    L14:
        Lifecycle.State r18 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsBroadcastSettingFragment$observeWearingRemindState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r18, null, this), 3, null);
    L7:
        r0 = false;
        goto L9
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r110, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        Context r1 = requireContext();
        LinearLayout r2 = new LinearLayout(r1);
        r2.setOrientation(1);
        r2.setClipChildren(true);
        r2.setClipToPadding(true);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        OFloatingTitleBar r4 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r4);
        r4.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        int r7 = com.larus.utils.j0.a;
        r4.setCenterTitle(com.larus.utils.j0.d(2131904110));
        r4.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r8 = (TextView) r4.findViewById(2131365427);
        if (r8 == null) goto L5;
        r8.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r8.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r8, ja0(22.0f));
        r8.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r4.R(false);
        final View r9 = OFloatingTitleBar.k(r4, null, 6);
        r9.setOnClickListener(new z0(this));
        r4.post(new a1(this, r9));
        r2.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        Context r5 = requireContext();
        LinearLayout r10 = new LinearLayout(r5);
        r10.setOrientation(1);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r10.setPadding(da0(12), 0, da0(12), da0(16));
        r10.addView(aa0(com.larus.utils.j0.d(2131900385), null, 0, new u0(this)));
        OSectionSupportiveText r3 = new OSectionSupportiveText(requireContext(), null, 6, 0);
        r3.setPadding(da0(20), da0(8), da0(20), da0(8));
        r3.setSectionDes("");
        TextView r6 = (TextView) r3.findViewById(2131385718);
        r6.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r6.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r6, ja0(16.0f));
        r6.setHighlightColor(0);
        r6.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableStringBuilder r11 = new SpannableStringBuilder(HtmlCompat.fromHtml(com.larus.utils.j0.d(2131902183), 0));
        Object[] r12 = r11.getSpans(0, r11.length(), URLSpan.class);
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L8;
        URLSpan r15 = (URLSpan) r12[r14];
        int r16 = r11.getSpanStart(r15);
        int r17 = r11.getSpanEnd(r15);
        int r111 = r11.getSpanFlags(r15);
        r11.removeSpan(r15);
        r11.setSpan(new c1(r15, this), r16, r17, r111);
        r14 = r14 + 1;
        goto L6
    L8:
        r6.setText(r11);
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r10.addView(r3);
        int r21 = com.larus.utils.j0.a;
        View r22 = Z90(com.larus.utils.j0.d(2131902266));
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-1, -2);
        r23.topMargin = da0(16);
        Unit r24 = Unit.INSTANCE;
        r10.addView(r22, r23);
        this.n = (OSectionTitleBar) r22;
        LinearLayout r25 = new LinearLayout(r5);
        r25.setOrientation(1);
        r25.setClipChildren(false);
        r25.setClipToPadding(false);
        OCardListItem r26 = Y90(com.larus.utils.j0.d(2131902296), null, 1, new DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$4$1(this));
        r25.addView(r26);
        this.p = r26;
        OCardListItem r27 = Y90(com.larus.utils.j0.d(2131902293), null, 3, new DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$4$3(this));
        r25.addView(r27);
        this.q = r27;
        r10.addView(r25);
        this.o = r25;
        LinearLayout r28 = new LinearLayout(r5);
        r28.setOrientation(1);
        r28.setClipChildren(false);
        r28.setClipToPadding(false);
        OCardListItem r30 = Y90(com.larus.utils.j0.d(2131902259), null, 1, new DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$6$1(this));
        r28.addView(r30);
        this.s = r30;
        OCardListItem r31 = Y90(com.larus.utils.j0.d(2131902251), null, 3, new DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$6$3(this));
        r28.addView(r31);
        this.t = r31;
        LinearLayout.LayoutParams r32 = new LinearLayout.LayoutParams(-1, -2);
        r32.topMargin = da0(16);
        r10.addView(r28, r32);
        this.r = r28;
        View r33 = Z90(com.larus.utils.j0.d(2131902260));
        LinearLayout.LayoutParams r34 = new LinearLayout.LayoutParams(-1, -2);
        r34.topMargin = da0(16);
        r10.addView(r33, r34);
        this.u = (OSectionTitleBar) r33;
        LinearLayout r35 = new LinearLayout(r5);
        r35.setOrientation(1);
        r35.setClipChildren(false);
        r35.setClipToPadding(false);
        OCardListItem r36 = Y90(com.larus.utils.j0.d(2131902275), null, 1, new DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$9$1(this));
        r35.addView(r36);
        this.w = r36;
        OCardListItem r37 = Y90(com.larus.utils.j0.d(2131902265), null, 2, new DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$9$3(this));
        r35.addView(r37);
        this.x = r37;
        OCardListItem r38 = aa0(com.larus.utils.j0.d(2131903156), com.larus.utils.j0.d(2131902278), 3, new v0(this));
        r38.setVisibility(8);
        r35.addView(r38);
        this.y = r38;
        r10.addView(r35);
        this.v = r35;
        View r40 = Z90(com.larus.utils.j0.d(2131902280));
        r40.setVisibility(8);
        LinearLayout.LayoutParams r41 = new LinearLayout.LayoutParams(-1, -2);
        r41.topMargin = da0(16);
        r10.addView(r40, r41);
        this.A = (OSectionTitleBar) r40;
        OCardListItem r42 = aa0(com.larus.utils.j0.d(2131903930), com.larus.utils.j0.d(2131903931), 0, new w0(this));
        r42.setVisibility(8);
        r10.addView(r42);
        this.B = r42;
        OCardListItem r43 = Y90(com.larus.utils.j0.d(2131902320), com.larus.utils.j0.d(2131902319), 0, new DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$14(this));
        r43.setVisibility(8);
        r10.addView(r43, new LinearLayout.LayoutParams(-1, -2));
        this.D = r43;
        NestedScrollView r44 = new NestedScrollView(r5);
        r44.setClipChildren(false);
        r44.setClipToPadding(false);
        r44.setOverScrollMode(2);
        r44.setFillViewport(true);
        r44.setPadding(0, da0(16), 0, 0);
        r44.addView(r10, new ViewGroup.LayoutParams(-1, -2));
        r2.addView(r44, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r45 = new FrameLayout(r1);
        r45.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r45.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        View r46 = new View(r1);
        r46.setBackgroundColor(ContextCompat.getColor(r1, 2131103066));
        r46.setClickable(true);
        r46.setFocusable(true);
        r45.addView(r46, new FrameLayout.LayoutParams(-1, -1));
        this.l = r46;
        return r45;
    }

    public final OCardListItem Y90(String r6, String r7, int r8, final Function0<Unit> r9) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r8);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        if (r7 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        r0.q(false);
    L12:
        r0.setDefaultCustomEndView(3);
        r0.m(true);
        r0.k("", da0(140));
        OTextView r11 = r0.getEndDetail();
        if (r11 == null) goto L15;
        r11.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r11.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r11, ja0(18.0f));
    L15:
        r0.setDefaultTailIcon(0);
        r0.r(true);
        X90(r0);
        r0.setOnContentClickListener(new p0(r0, r9));
        return r0;
    L11:
        r0.setSubTitle(r7);
        r0.getSubTitleView().setMaxLines(5);
        r0.q(true);
        goto L12
    L5:
        if (r7.length() == 0) goto L8;
        r10 = false;
        goto L9
    }

    public final OCardListItem aa0(String r6, String r7, int r8, Function1<? super OSwitch, Unit> r9) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r8);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        if (r7 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        r0.q(false);
    L12:
        r0.setDefaultCustomEndView(1);
        r0.m(true);
        r0.r(false);
        OSwitch r11 = r0.getEndSwitch();
        if (r11 == null) goto L15;
        r9.invoke(r11);
    L15:
        r0.setOnContentClickListener(new k0(r0));
        X90(r0);
        return r0;
    L11:
        r0.setSubTitle(r7);
        r0.getSubTitleView().setMaxLines(5);
        r0.q(true);
        goto L12
    L5:
        if (r7.length() == 0) goto L8;
        r10 = false;
        goto L9
    }
}
