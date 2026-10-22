package com.larus.dora.obric.device_management.setting.earbuds.doubao_agent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.ailab.AiLabViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.dora.obric.device_management.setting.common.auto_disconnect.DoraObricDoubaoAutoDisconnectViewModel;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.spi.dora.ObricDoraDelegate;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u0086\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010:\u001a\u000208H\u0016J\b\u0010;\u001a\u000208H\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u000208H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010@\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020\u001bH\u0002J\b\u0010B\u001a\u00020\u001bH\u0002J\u0010\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u0002082\u0006\u0010J\u001a\u00020\u0012H\u0002J\u0010\u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020\u0012H\u0002J\u0010\u0010M\u001a\u0002082\u0006\u0010J\u001a\u00020\u0012H\u0002J\b\u0010N\u001a\u000208H\u0002J\b\u0010O\u001a\u000208H\u0002J\u0016\u0010P\u001a\u0002082\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RH\u0002J\u0010\u0010T\u001a\u0002082\u0006\u0010U\u001a\u00020\u0012H\u0002J\u0018\u0010V\u001a\u0002082\u0006\u0010W\u001a\u00020=2\u0006\u0010U\u001a\u00020\u0012H\u0002J\u001c\u0010X\u001a\u00020\u00192\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u0002080ZH\u0002J\b\u0010[\u001a\u00020\\H\u0002J,\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020=2\u0006\u0010_\u001a\u00020`2\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002080ZH\u0002J\u0010\u0010b\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020`H\u0002J\u0010\u0010c\u001a\u0002082\u0006\u0010d\u001a\u00020\u001dH\u0002J\u0018\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u001bH\u0002J\u0010\u0010j\u001a\u00020=2\u0006\u0010k\u001a\u00020`H\u0002J\f\u0010l\u001a\u000208*\u00020mH\u0002J&\u0010n\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020=2\u0006\u0010_\u001a\u00020`2\f\u0010o\u001a\b\u0012\u0004\u0012\u0002080pH\u0002J\u0018\u0010q\u001a\u0002082\u0006\u0010r\u001a\u00020\u001d2\u0006\u0010s\u001a\u00020\u0012H\u0002J\u0010\u0010t\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020=H\u0002J\u0010\u0010u\u001a\u00020\u001b2\u0006\u0010v\u001a\u00020`H\u0002J\f\u0010w\u001a\u000208*\u00020\u001dH\u0002J\f\u0010x\u001a\u000208*\u00020\u001dH\u0002J\b\u0010y\u001a\u00020`H\u0002J\b\u0010z\u001a\u00020`H\u0002J\b\u0010{\u001a\u00020`H\u0002J\f\u0010|\u001a\u000208*\u00020}H\u0002J\f\u0010~\u001a\u000208*\u00020}H\u0002J\u0011\u0010\u007f\u001a\u0002082\u0007\u0010\u0080\u0001\u001a\u00020\u001bH\u0002J\r\u0010\u0081\u0001\u001a\u00020`*\u00020`H\u0002J\u000e\u0010\u0082\u0001\u001a\u00020`*\u00030\u0083\u0001H\u0002J\t\u0010\u0084\u0001\u001a\u00020mH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0016\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b%\u0010\u0014R\u0010\u0010'\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0087\u0001"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/doubao_agent/DoraObricEarbudsDoubaoAgentSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "getModel", "()Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "model$delegate", "Lkotlin/Lazy;", "autoStopTimeViewModel", "Lcom/larus/dora/obric/device_management/setting/common/auto_disconnect/DoraObricDoubaoAutoDisconnectViewModel;", "getAutoStopTimeViewModel", "()Lcom/larus/dora/obric/device_management/setting/common/auto_disconnect/DoraObricDoubaoAutoDisconnectViewModel;", "autoStopTimeViewModel$delegate", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "isVoiceWakeSwitchChecking", "", "isSyllableSwitchEnabled", "()Z", "isSyllableSwitchEnabled$delegate", "isAISFirmware", "isAISFirmware$delegate", "contentContainer", "Landroid/widget/LinearLayout;", "pageMaskView", "Landroid/view/View;", "voiceWakeCard", "Lcom/obric/oui/lisitem/OCardListItem;", "voiceWakeSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "autoStopTimeSection", "autoStopTimeItem", "autoStopTimePopover", "Lcom/obric/oui/popover/v2/OPopover;", "showAutoStopTimeRow", "getShowAutoStopTimeRow", "showAutoStopTimeRow$delegate", "syllableSection", "doubaoItem", "doubaoDoubaoItem", "convSoundSection", "convStartEndSoundSwitch", "showConvStartEndSoundRow", "multiUserModeSection", "multiUserModeSwitch", "showMultiUserModeRow", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStop", "onDestroyView", "getCurrentPageName", "", "onResume", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "handleAbility", "ability", "Lcom/larus/dora/impl/device/ailab/AiLabAbility;", "handleUiState", "state", "Lcom/larus/dora/impl/device/ailab/AiLabState;", "bindVoiceWakeSwitch", "checked", "onVoiceWakeSwitchChanged", "isChecked", "bindConvStartEndSound", "adjustSyllableLayout", "hideSyllableLayout", "updateKeywordDoubaoSettings", "data", "", "Lcom/larus/dora/impl/device/ailab/AiLabKeyword;", "setSyllableSelected", "isDoubao", "onSyllableClicked", "keyword", "buildCardGroup", "buildItems", "Lkotlin/Function1;", "buildItemLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "buildSwitchCard", "title", "position", "", "onSwitchCreated", "buildAutoStopTimeCard", "showAutoStopTimeMenu", "anchor", "buildBlurMenuHost", "Landroid/widget/FrameLayout;", "activity", "Landroid/app/Activity;", "menuView", "autoStopTimeText", "time", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "buildSelectableCard", "onClick", "Lkotlin/Function0;", "markSelected", "item", "selected", "buildSectionTitle", "buildSpacer", "heightDp", "applyCardStyle", "resetCardContainerMargins", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applySectionTitleTextStyle", "relaxClipForShadow", "target", "dp", "sp", "", "buildMultiUserModeTips", "BlurMenuHostView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsDoubaoAgentSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int B = 0;
    public boolean A;
    public final Lazy f;
    public final Lazy g;
    public final CoroutineScope h;
    public boolean i;
    public final Lazy j;
    public final Lazy k;
    public LinearLayout l;
    public View m;
    public OCardListItem n;
    public OSwitch o;
    public OCardListItem p;
    public com.obric.oui.popover.v2.c q;
    public final Lazy r;
    public LinearLayout s;
    public OCardListItem t;
    public OCardListItem u;
    public LinearLayout v;
    public OSwitch w;
    public boolean x;
    public LinearLayout y;
    public OSwitch z;

    public static final class a extends FrameLayout {
        public final float a;
        public final boolean b;

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
            Context r1 = getContext();     // Catch: Throwable -> L12
            if (OMaterialHelper.k() == true) goto L7;
        L9:
            boolean r2 = false;
        L10:
            Object r3 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L12
        L14:
            Boolean r4 = Boolean.FALSE;
            if (Result.isFailure-impl(r3) == false) goto L18;
            r3 = r4;
        L18:
            if (((Boolean) r3).booleanValue() == false) goto L37;
            setBackground(a(0));
        L26:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        L29:
            if (Result.exceptionOrNull-impl(r6) != null) goto L31;
        L35:
            Result.box-impl(r6);
            return;
        L31:
            if (this.b == false) goto L33;
            int r7 = Color.argb(100, 255, 255, 255);
        L34:
            setBackground(a(r7));
            goto L35
        L33:
            r7 = Color.argb(100, 30, 30, 30);
            goto L34
        L21:
            if (this.b == false) goto L23;
            int r8 = Color.argb(100, 255, 255, 255);     // Catch: Throwable -> L26
        L24:
            com.obric.oui.material.c r15 = new com.obric.oui.material.c(null, null, new com.obric.oui.color.a[]{new com.obric.oui.color.a(r8, BlendMode.SRC_OVER)}, null, null, Float.valueOf(BlurToken.Blur_Thick), null, null, 891);     // Catch: Throwable -> L26
            Resources r9 = Resources.getSystem();     // Catch: Throwable -> L26
            OMaterialHelper.v(this, 3, r15, WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).density);     // Catch: Throwable -> L26
            r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
            goto L29
        L23:
            r8 = Color.argb(100, 30, 30, 30);     // Catch: Throwable -> L26
            goto L24
        L37:
            if (this.b == false) goto L39;
            int r10 = Color.argb(100, 255, 255, 255);
        L40:
            setBackground(a(r10));
            return;
        L39:
            r10 = Color.argb(100, 30, 30, 30);
            goto L40
        L7:
            if (OMaterialHelper.g(r1) <= 0) goto L9;
            r2 = true;
        L12:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r3 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L14
        }

        public final GradientDrawable a(int r3) {
            GradientDrawable r0 = new GradientDrawable();
            r0.setShape(0);
            r0.setCornerRadius(this.a);
            r0.setColor(r3);
            return r0;
        }

        public a(FragmentActivity r2, float r3, float r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.a = r3;
            this.b = r5;
            setClipChildren(false);
            setClipToPadding(false);
            setClipToOutline(true);
            setOutlineProvider(new v(this));
            setElevation(r4);
        }
    }

    public static final class b {
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment a;

        public c(DoraObricEarbudsDoubaoAgentSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            com.larus.dora.impl.device.ailab.u r6 = (com.larus.dora.impl.device.ailab.u) r4;
            g49.d.d("DoraObricEarbudsDoubaoAgentSettings", "deviceStateFlow collect " + r6);
            DoraObricEarbudsDoubaoAgentSettingsFragment r7 = this.a;
            int r0 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
            r7.getClass();
            if ((r6 instanceof com.larus.dora.impl.device.ailab.u.c) == false) goto L9;
            boolean r8 = ((com.larus.dora.impl.device.ailab.u.c) r6).a;
            r7.i = true;
            OSwitch r1 = r7.o;
            if (r1 == null) goto L7;
            r1.setChecked(r8);
        L7:
            r7.i = false;
            r7.W90();
        L19:
            return Unit.INSTANCE;
        L9:
            if ((r6 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L17;
            com.larus.dora.impl.device.ailab.u.b r9 = (com.larus.dora.impl.device.ailab.u.b) r6;
            boolean r2 = r9.a;
            r7.i = true;
            OSwitch r3 = r7.o;
            if (r3 == null) goto L13;
            r3.setChecked(r2);
        L13:
            r7.i = false;
            boolean r10 = r9.e;
            OSwitch r11 = r7.w;
            if (r11 == null) goto L19;
            r11.setOnCheckedChangeListener(null);
            r11.setChecked(r10);
            r11.setOnCheckedChangeListener(new n(r7));
            goto L19
        L17:
            if (Intrinsics.areEqual(r6, com.larus.dora.impl.device.ailab.u.a.a) == true) goto L19;
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment a;

        public d(DoraObricEarbudsDoubaoAgentSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            DoraObricEarbudsDoubaoAgentSettingsFragment r6 = this.a;
            OCardListItem r0 = r6.p;
            if (r0 == null) goto L5;
            r0.k(r6.Y90(r5), this.a.da0(80));
        L5:
            OCardListItem r7 = this.a.p;
            if (r7 == null) goto L11;
            OTextView r8 = r7.getEndDetail();
            if (r8 == null) goto L11;
            DoraObricEarbudsDoubaoAgentSettingsFragment r9 = this.a;
            r8.setTextColor(ContextCompat.getColor(r9.requireContext(), 2131104359));
            r8.setTextSize(2, 14.0f);
            TextViewCompat.setLineHeight(r8, r9.ha0(18.0f));
        L11:
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment a;

        public e(DoraObricEarbudsDoubaoAgentSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            DoraObricEarbudsDoubaoAgentSettingsFragment r8 = this.a;
            int r0 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
            r8.W90();
            DoraObricEarbudsDoubaoAgentSettingsFragment r9 = this.a;
            r9.getClass();
            List r10 = (List) r6;
            boolean r2 = false;
            if ((r10 instanceof Collection) == true) goto L5;
        L7:
            Iterator<T> r11 = r10.iterator();
        L9:
            if (r11.hasNext() == false) goto L18;
            com.larus.dora.impl.device.ailab.t r1 = (com.larus.dora.impl.device.ailab.t) r11.next();
            String r3 = r1.d;
            Lazy<String> r4 = com.larus.dora.impl.device.ailab.t.h;
            if (Intrinsics.areEqual(r3, com.larus.dora.impl.device.ailab.t.a.a()) == true) goto L13;
        L15:
            boolean r5 = false;
        L16:
            if (r5 == false) goto L9;
            r2 = true;
            goto L18
        L13:
            if (r1.f == false) goto L15;
            r5 = true;
        L18:
            OCardListItem r12 = r9.t;
            if (r12 == null) goto L21;
            r12.m(r2);
        L21:
            OCardListItem r13 = r9.u;
            if (r13 == null) goto L25;
            r13.m(!r2);
        L25:
            return Unit.INSTANCE;
        L5:
            if (r10.isEmpty() == false) goto L7;
            goto L7
        }
    }

    public static final class f<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment a;

        public f(DoraObricEarbudsDoubaoAgentSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            com.larus.dora.impl.device.ailab.a r7 = (com.larus.dora.impl.device.ailab.a) r5;
            if (r7 == null) goto L35;
            DoraObricEarbudsDoubaoAgentSettingsFragment r8 = this.a;
            OCardListItem r0 = r8.n;
            if (r0 != null) goto L7;
        L11:
            int r1 = 8;
            if (r7.a == false) goto L14;
            r8.W90();
        L17:
            boolean r2 = r7.d;
            if (r8.x == r2) goto L20;
            r8.x = r2;
        L20:
            LinearLayout r3 = r8.v;
            if (r3 == null) goto L26;
            if (r2 == false) goto L24;
            int r4 = 0;
        L25:
            r3.setVisibility(r4);
            goto L26
        L24:
            r4 = 8;
        L26:
            boolean r9 = r7.b;
            if (r8.A == r9) goto L29;
            r8.A = r9;
        L29:
            LinearLayout r10 = r8.y;
            if (r10 == null) goto L35;
            if (r9 == false) goto L33;
            r1 = 0;
        L33:
            r10.setVisibility(r1);
            goto L35
        L14:
            LinearLayout r11 = r8.s;
            if (r11 == null) goto L17;
            r11.setVisibility(8);
            goto L17
        L7:
            if (r7.a == false) goto L9;
            String r12 = r8.getString(2131902057);
        L10:
            r0.setTitle(r12);
            goto L11
        L9:
            r12 = r8.getString(2131902059);
        L35:
            return Unit.INSTANCE;
        }
    }

    public static final class g<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment a;

        public g(DoraObricEarbudsDoubaoAgentSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.dora.impl.device.ailab.b r5 = (com.larus.dora.impl.device.ailab.b) r3;
            if ((r5 instanceof com.larus.dora.impl.device.ailab.b.C0032b) == false) goto L13;
            FragmentActivity r6 = this.a.getActivity();
            if (r6 == null) goto L7;
            DoraObricEarbudsDoubaoAgentSettingsFragment r0 = this.a;
            Handler r1 = com.obric.oui.toast.f.n;
            com.obric.oui.toast.f.a.a(r6, r0.getString(((com.larus.dora.impl.device.ailab.b.C0032b) r5).a));
        L7:
            DoraObricEarbudsDoubaoAgentSettingsFragment r7 = this.a;
            int r8 = DoraObricEarbudsDoubaoAgentSettingsFragment.B;
            com.larus.dora.impl.device.ailab.u r9 = (com.larus.dora.impl.device.ailab.u) r7.fa0().getDeviceStateFlow().getValue();
            if ((r9 instanceof com.larus.dora.impl.device.ailab.u.b) == false) goto L13;
            DoraObricEarbudsDoubaoAgentSettingsFragment r10 = this.a;
            boolean r11 = ((com.larus.dora.impl.device.ailab.u.b) r9).e;
            OSwitch r2 = r10.w;
            if (r2 == null) goto L13;
            r2.setOnCheckedChangeListener(null);
            r2.setChecked(r11);
            r2.setOnCheckedChangeListener(new n(r10));
        L13:
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment a;

        public h(DoraObricEarbudsDoubaoAgentSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            boolean r4 = ((Boolean) r2).booleanValue();
            OSwitch r5 = this.a.z;
            if (r5 == null) goto L5;
            r5.setOnCheckedChangeListener(null);
        L5:
            OSwitch r6 = this.a.z;
            if (r6 == null) goto L8;
            r6.setChecked(r4);
        L8:
            DoraObricEarbudsDoubaoAgentSettingsFragment r7 = this.a;
            OSwitch r8 = r7.z;
            if (r8 == null) goto L12;
            r8.setOnCheckedChangeListener(new w(r7));
        L12:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "ai_lab";
    }

    public final void W90() {
        OSwitch r0 = this.o;
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        Iterable r4 = (Iterable) fa0().getKeywordsStateFlow().getValue();
        if ((r4 instanceof Collection) == true) goto L11;
    L13:
        Iterator r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L12;
        if (((com.larus.dora.impl.device.ailab.t) r5.next()).g == false) goto L15;
        boolean r6 = true;
    L20:
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L24;
        if (r3 == false) goto L24;
        if (r6 == false) goto L24;
    L25:
        LinearLayout r7 = this.s;
        if (r7 == null) goto L31;
        if (r1 == true) goto L30;
        r2 = 8;
    L30:
        r7.setVisibility(r2);
    L31:
        if (r1 == false) goto L33;
        ObricDoraDelegate.b.p(CollectionsKt.listOf(this.s));
        return;
    L33:
        ObricDoraDelegate.b.l(CollectionsKt.listOf(this.s));
        return;
    L24:
        r1 = false;
    L12:
        r6 = false;
        goto L20
    L11:
        if (((Collection) r4).isEmpty() == false) goto L13;
    L5:
        if (r0.isChecked() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final DoraObricDoubaoAutoDisconnectViewModel ea0() {
        return (DoraObricDoubaoAutoDisconnectViewModel) this.g.getValue();
    }

    public final AiLabViewModel fa0() {
        return (AiLabViewModel) this.f.getValue();
    }

    public final void onDestroyView() {
        com.obric.oui.popover.v2.c r0 = this.q;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.q = null;
        this.p = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.y = null;
        this.z = null;
        this.v = null;
        this.w = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricEarbudsDoubaoAgentSettingsFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AiLabViewModel.class), new DoraObricEarbudsDoubaoAgentSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsDoubaoAgentSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        final Function0<Fragment> r0 = new DoraObricEarbudsDoubaoAgentSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricDoubaoAutoDisconnectViewModel.class), new DoraObricEarbudsDoubaoAgentSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsDoubaoAgentSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.j = LazyKt.lazy(new o());
        this.k = LazyKt.lazy(new p());
        this.r = LazyKt.lazy(new q(this));
    }

    public final void onResume() {
        super.onResume();
        if (((Boolean) this.r.getValue()).booleanValue() == false) goto L6;
        ea0().refreshAutoStopTime();
        return;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
        OSwitch r0 = this.o;
        if (r0 == null) goto L5;
        boolean r1 = r0.isChecked();
    L6:
        DoraBuryPointManager r2 = DoraBuryPointManager.a;
        Pair[] r3 = new Pair[2];
        String r4 = "on";
        if (r1 == false) goto L9;
        Object r5 = "on";
    L10:
        r3[0] = TuplesKt.to("voice_wakeup", r5);
        if (fa0().isMultiUserModeEnabled() == true) goto L14;
        r4 = "off";
    L14:
        r3[1] = TuplesKt.to("multi_user_mode", r4);
        r2.L("dora_ai_lab_settings", MapsKt.mapOf(r3));
        return;
    L9:
        r5 = "off";
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.m;
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
        TextViewCompat.setLineHeight(r2, ha0(22.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r7.o(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final String Y90(int r2) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append('s');
        return r0.toString();
    }

    public final LinearLayout Z90(Function1<? super LinearLayout, Unit> r3) {
        LinearLayout r1 = new LinearLayout(requireContext());
        r1.setOrientation(1);
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        r3.invoke(r1);
        return r1;
    }

    public final View ba0(int r4) {
        View r5 = new View(requireContext());
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, da0(16)));
        return r5;
    }

    public final int da0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int ha0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final OCardListItem ca0(String r6, Function1 r7) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, 0);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(1);
        r0.m(true);
        r0.r(false);
        OSwitch r8 = r0.getEndSwitch();
        if (r8 == null) goto L5;
        r7.invoke(r8);
    L5:
        r0.setOnContentClickListener(new m(r0));
        X90(r0);
        return r0;
    }

    public final void ga0(String r3, boolean r4) {
        Object r0 = ServiceManager.get().getService(IDoraService.class);
        if ((r0 instanceof DoraServiceImpl) == false) goto L5;
        DoraServiceImpl r1 = (DoraServiceImpl) r0;
    L6:
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (r1.A1() != true) goto L10;
    L11:
        if (r2 == false) goto L16;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L18;
        Handler r6 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r5, getString(2131902081));
        return;
    L18:
        return;
    L16:
        fa0().updateKeyword(r3, r4);
        return;
    L10:
        r2 = false;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        AiLabViewModel r10 = fa0();
        Bundle r11 = getArguments();
        if (r11 == null) goto L5;
        String r12 = r11.getString("mac");
    L6:
        r10.updateCurrentDoraDeviceMac(r12);
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDoubaoAgentSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDoubaoAgentSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDoubaoAgentSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDoubaoAgentSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDoubaoAgentSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDoubaoAgentSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$6(this, r13, null, this), 3, null);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final OCardListItem aa0(String r6, int r7, final Function0<Unit> r8) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r7);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(2);
        r0.m(true);
        r0.r(false);
        X90(r0);
        r0.setOnContentClickListener(new com.larus.dora.obric.device_management.setting.earbuds.doubao_agent.f(r0, r8));
        return r0;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        LinearLayout r2 = new LinearLayout(r1);
        r2.setOrientation(1);
        r2.setClipChildren(true);
        r2.setClipToPadding(true);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        OFloatingTitleBar r4 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r4);
        r4.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        DoraDevice r7 = DoraAdapterExtKt.h(kj4.a.g());
        if (r7 != null) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r8 == false) goto L10;
        int r9 = 2131903995;
    L11:
        r4.setCenterTitle(getString(r9));
        r4.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r10 = (TextView) r4.findViewById(2131365427);
        if (r10 == null) goto L14;
        r10.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r10.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r10, ha0(22.0f));
        r10.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L14:
        r4.R(false);
        final View r5 = OFloatingTitleBar.k(r4, null, 6);
        r5.setOnClickListener(new com.larus.dora.obric.device_management.setting.earbuds.doubao_agent.a(this));
        r4.post(new l(this, r5));
        r2.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        Context r6 = requireContext();
        LinearLayout r11 = new LinearLayout(r6);
        r11.setOrientation(1);
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
        r11.setPadding(da0(12), 0, da0(12), da0(16));
        this.n = null;
        LinearLayout r12 = new LinearLayout(requireContext());
        r12.setOrientation(1);
        r12.setClipChildren(false);
        r12.setClipToPadding(false);
        Intrinsics.checkNotNullParameter(r12, "itemContainer");
        OCardListItem r13 = ca0(getString(2131902059), new u(this));
        this.n = r13;
        r12.addView(r13);
        Unit r14 = Unit.INSTANCE;
        r11.addView(r12);
        LinearLayout r15 = new LinearLayout(r6);
        r15.setOrientation(1);
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        r15.setVisibility(8);
        r15.addView(ba0(16));
        String r16 = getString(2131902074);
        OSectionTitleBar r111 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r3 = (LinearLayout) r111.findViewById(2131367728);
        if (r3 == null) goto L17;
        r3.setPadding(da0(20), da0(8), da0(12), da0(8));
    L17:
        r111.setTitleText(r16);
        r111.setTitleTextSize(12.0f);
        r111.setTitleTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        TextView r20 = (TextView) r111.findViewById(2131388792);
        if (r20 == null) goto L20;
        r20.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r20.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r20, ha0(16.0f));
        r20.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    L20:
        r111.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r15.addView(r111);
        r15.addView(Z90(new r(this)));
        r11.addView(r15);
        this.s = r15;
        LinearLayout r21 = new LinearLayout(r6);
        r21.setOrientation(1);
        r21.setClipChildren(false);
        r21.setClipToPadding(false);
        if (((Boolean) this.r.getValue()).booleanValue() == false) goto L23;
        int r22 = 0;
    L24:
        r21.setVisibility(r22);
        r21.addView(ba0(16));
        r21.addView(Z90(new s(this)));
        r11.addView(r21);
        LinearLayout r23 = new LinearLayout(r6);
        r23.setOrientation(1);
        r23.setClipChildren(false);
        r23.setClipToPadding(false);
        r23.setVisibility(8);
        r23.addView(ba0(16));
        this.w = null;
        LinearLayout r24 = new LinearLayout(requireContext());
        r24.setOrientation(1);
        r24.setClipChildren(false);
        r24.setClipToPadding(false);
        Intrinsics.checkNotNullParameter(r24, "itemContainer");
        r24.addView(ca0(getString(2131902400), new t(this)));
        Unit r25 = Unit.INSTANCE;
        r23.addView(r24);
        r11.addView(r23);
        this.v = r23;
        LinearLayout r26 = new LinearLayout(r6);
        r26.setOrientation(1);
        r26.setClipChildren(false);
        r26.setClipToPadding(false);
        r26.setVisibility(8);
        r26.addView(ba0(16));
        this.z = null;
        LinearLayout r27 = new LinearLayout(requireContext());
        r27.setOrientation(1);
        r27.setClipChildren(false);
        r27.setClipToPadding(false);
        Intrinsics.checkNotNullParameter(r27, "itemContainer");
        r27.addView(ca0(getString(2131903374), new com.larus.dora.obric.device_management.setting.earbuds.doubao_agent.e(this)));
        Unit r28 = Unit.INSTANCE;
        r26.addView(r27);
        DoraDevice r30 = DoraAdapterExtKt.h(kj4.a.g());
        if (r30 == null) goto L27;
        Integer r31 = Integer.valueOf(r30.productId);
    L28:
        int r32 = ProductNameType.DORA_G.id;
        if (r31 != null) goto L32;
    L34:
        int r33 = 2131903375;
    L35:
        OTextView r34 = new OTextView(requireContext(), null, 0, 14);
        int r35 = j0.a;
        r34.setText(j0.d(r33));
        r34.setGravity(16);
        r34.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r34.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r34, ha0(18.0f));
        r34.setPadding(da0(16), da0(8), da0(16), da0(12));
        r34.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r26.addView(r34);
        r11.addView(r26);
        this.y = r26;
        this.l = r11;
        NestedScrollView r36 = new NestedScrollView(r6);
        r36.setClipChildren(false);
        r36.setClipToPadding(false);
        r36.setOverScrollMode(2);
        r36.setFillViewport(true);
        r36.setPadding(0, da0(16), 0, 0);
        r36.addView(this.l, new ViewGroup.LayoutParams(-1, -2));
        r2.addView(r36, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r37 = new FrameLayout(r1);
        r37.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r37.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        View r38 = new View(r1);
        r38.setBackgroundColor(ContextCompat.getColor(r1, 2131103066));
        r38.setClickable(true);
        r38.setFocusable(true);
        r37.addView(r38, new FrameLayout.LayoutParams(-1, -1));
        this.m = r38;
        return r37;
    L32:
        if (r31.intValue() != r32) goto L34;
        r33 = 2131902767;
        goto L35
    L27:
        r31 = null;
        goto L28
    L23:
        r22 = 8;
        goto L24
    L10:
        r9 = 2131902056;
        goto L11
    L5:
        if (r7.productId != ProductNameType.DORA_G.id) goto L7;
        r8 = true;
        goto L8
    }
}
