package com.larus.dora.obric.device_management.setting.common.sound;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.sound.DoraAmbientVolumeSettingsNotifier;
import com.larus.dora.impl.device.settings.sound.SoundSettingsViewModel;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.slider.OSlider;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0017\u0018\u0000 t2\u00020\u0001:\u0001tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0016J\b\u0010)\u001a\u00020*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J0\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010*2\u0006\u00107\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010*2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010:\u001a\u00020\u000b2\u0006\u00106\u001a\u00020*H\u0002J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020*H\u0002J8\u0010=\u001a\u00020>2\u0006\u00106\u001a\u00020*2\b\u0010?\u001a\u0004\u0018\u00010*2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020$0A2\b\b\u0002\u0010B\u001a\u00020CH\u0002J\u001a\u0010D\u001a\u00020>2\u0006\u00106\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010\u0014H\u0002J*\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020H2\b\b\u0002\u0010K\u001a\u00020CH\u0002J\b\u0010L\u001a\u00020$H\u0002J\b\u0010M\u001a\u00020$H\u0002J\b\u0010N\u001a\u00020$H\u0002J\u000e\u0010O\u001a\u00020CH\u0082@¢\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020$H\u0002J\b\u0010R\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J\b\u0010T\u001a\u00020$H\u0002J\u0010\u0010U\u001a\u00020$2\u0006\u0010V\u001a\u00020CH\u0002J\u0010\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020$2\u0006\u0010V\u001a\u00020CH\u0002J\u0010\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020CH\u0002J\b\u0010_\u001a\u00020CH\u0002J\u0017\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0002\u0010cJ\u0017\u0010d\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0002\u0010cJ\f\u0010e\u001a\u00020$*\u00020>H\u0002J\f\u0010f\u001a\u00020$*\u00020>H\u0002J\f\u0010g\u001a\u00020$*\u00020>H\u0002J\f\u0010h\u001a\u00020$*\u00020>H\u0002J\f\u0010i\u001a\u00020$*\u00020>H\u0002J\u0010\u0010j\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020aH\u0002J\b\u0010l\u001a\u00020aH\u0002J\b\u0010m\u001a\u00020aH\u0002J\b\u0010n\u001a\u00020aH\u0002J\f\u0010o\u001a\u00020$*\u00020pH\u0002J\f\u0010q\u001a\u00020$*\u00020pH\u0002J\f\u0010r\u001a\u00020a*\u00020aH\u0002J\f\u0010s\u001a\u00020a*\u00020HH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/common/sound/DoraObricSoundSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "ambientSection", "Landroid/view/View;", "cueToneSection", "antiSoundLeakSection", "ambientToCueGap", "cueToAntiGap", "ambientSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "antiSoundLeakSwitch", "cueToneSlider", "Lcom/obric/oui/slider/OSlider;", "pageMaskView", "ambientVolumeChangedReceiver", "com/larus/dora/obric/device_management/setting/common/sound/DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1", "Lcom/larus/dora/obric/device_management/setting/common/sound/DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1;", "antiSoundLeakCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "ambientVolumeCheckedChangeListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildAmbientSection", "buildCueToneSection", "buildAntiSoundLeakSection", "getAmbientVolumeAdaptiveTips", "getCueToneVolumeDesc", "buildSection", "Landroid/widget/LinearLayout;", "title", "card", "supportiveText", "extraCard", "buildSectionTitle", "buildSupportiveText", "text", "buildSwitchCard", "Lcom/obric/oui/lisitem/OCardListItem;", "subtitle", "onSwitchCreated", "Lkotlin/Function1;", "embeddedInCard", "", "buildSliderCard", "slider", "buildSlider", "min", "", "max", "defaultProgress", "showLeftIcon", "setupAmbientVolume", "setupDefaultAmbientVolume", "setupEarbudsAmbientVolume", "isEarbudsAmbientVolumeSupported", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupCueToneVolume", "setupAntiSoundLeak", "updateSectionGaps", "setupCueToneSeek", "updateAmbientVolumeSwitch", "isOpen", "refreshAntiSoundLeakCheckedState", "state", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "updateAntiSoundLeakSwitch", "updateSpeakerVolumeSwitch", "vol", "", "isGDevice", "useEarbudsSoundStyle", "convertIntToByte", "", "input", "(Ljava/lang/Integer;)I", "convertByteToInt", "applyCardStyle", "applyEmbeddedSwitchRowStyle", "applyContainerCardStyle", "resetCardContainerMargins", "applyCardRadius", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applySupportiveTextStyle", "dp", "sp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricSoundSettingsFragment extends DoraBaseFragment {
    public static final IntRange s = null;
    public final Lazy f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public OSwitch l;
    public OSwitch m;
    public OSlider n;
    public View o;
    public final DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1 p;
    public final b q;
    public final c r;

    public static final class a {
    }

    public final String k() {
        return "dora_voice_setting";
    }

    public final void onDestroyView() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    static {
        s = new IntRange(0, 1);
    }

    public final SoundSettingsViewModel ea0() {
        return (SoundSettingsViewModel) this.f.getValue();
    }

    public final void ia0() {
        View r0 = this.g;
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        View r4 = this.h;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        View r6 = this.i;
        if (r6 != null) goto L17;
    L19:
        r1 = false;
    L20:
        View r7 = this.j;
        if (r7 == null) goto L27;
        if (r3 == false) goto L25;
        if (r5 == false) goto L25;
        int r8 = 0;
    L26:
        r7.setVisibility(r8);
    L25:
        r8 = 8;
    L27:
        View r9 = this.k;
        if (r9 == null) goto L36;
        if (r1 == false) goto L33;
        if (r3 == true) goto L34;
        if (r5 == false) goto L33;
    L34:
        r9.setVisibility(r2);
        return;
    L33:
        r2 = 8;
        goto L34
    L36:
        return;
    L17:
        if (r6.getVisibility() != 0) goto L19;
    L11:
        if (r4.getVisibility() != 0) goto L13;
        r5 = true;
        goto L14
    L5:
        if (r0.getVisibility() != 0) goto L7;
        r3 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.obric.device_management.setting.common.sound.DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.obric.device_management.setting.common.sound.b] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.obric.device_management.setting.common.sound.c] */
    public DoraObricSoundSettingsFragment() {
        final Function0<Fragment> r0 = new DoraObricSoundSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SoundSettingsViewModel.class), new DoraObricSoundSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricSoundSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.p = new DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1(this);
        this.q = new b(this);
        this.r = new c(this);
    }

    public final int ga0() {
        return v19.c.a(2130972079, requireContext(), 2131103136);
    }

    public final boolean ja0() {
        Bundle r0 = getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("key_use_earbuds_sound_style", false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager r0 = LocalBroadcastManager.getInstance(requireContext());
        DoraObricSoundSettingsFragment$ambientVolumeChangedReceiver$1 r1 = this.p;
        DoraAmbientVolumeSettingsNotifier r2 = DoraAmbientVolumeSettingsNotifier.a;
        r0.registerReceiver(r1, new IntentFilter("com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.p);
        super.onStop();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.o;
    }

    public final void Z90(OCardListItem r4) {
        Iterator r5 = CollectionsKt.listOf(new Drawable[]{r4.getCardContainer().getBackground(), r4.getContentContainer().getBackground()}).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Drawable r0 = (Drawable) r5.next();
        if ((r0 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r1 = (GradientDrawable) r0;
    L9:
        if (r1 == null) goto L4;
        r1.setCornerRadius(da0(20));
        goto L4
    L8:
        r1 = null;
        goto L9
    }

    public final View ba0(int r4) {
        View r0 = new View(requireContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, da0(r4)));
        return r0;
    }

    public final int da0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void fa0(OCardListItem r3) {
        ViewGroup.LayoutParams r0 = r3.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r3.getCardContainer().setLayoutParams(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final int ha0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public static final Object W90(DoraObricSoundSettingsFragment r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1) == false) goto L7;
        DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1 r0 = (DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r8 = r0.I$1;
        int r9 = r0.I$0;
        ResultKt.throwOnFailure(r6);
    L18:
        int r10 = ((Number) r6).intValue();
        if (r9 > r10) goto L22;
        if (r10 > r8) goto L22;
    L24:
        return Boxing.boxBoolean(r3);
    L22:
        r3 = false;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        IntRange r11 = s;
        int r12 = r11.getFirst();
        int r13 = r11.getLast();
        kj4.a r14 = kj4.a.g();
        r0.I$0 = r12;
        r0.I$1 = r13;
        r0.label = 1;
        Object r15 = DoraAdapterExtKt.l(r14);
        if (r15 == r7) goto L25;
        r8 = r13;
        r6 = r15;
        r9 = r12;
        goto L18
    L25:
        return r7;
    L7:
        r0 = new DoraObricSoundSettingsFragment$isEarbudsAmbientVolumeSupported$1(r4, r5);
        goto L8
    }

    public static final void X90(DoraObricSoundSettingsFragment r2, com.larus.dora.impl.device.settings.sound.a r3) {
        r2.getClass();
        boolean r4 = Intrinsics.areEqual(r3, com.larus.dora.impl.device.settings.sound.a.b.a);
        OSwitch r0 = r2.m;
        if (r0 == null) goto L5;
        r0.setOnCheckedChangeListener(null);
    L5:
        OSwitch r1 = r2.m;
        if (r1 == null) goto L8;
        r1.setChecked(r4);
    L8:
        OSwitch r5 = r2.m;
        if (r5 == null) goto L12;
        r5.setOnCheckedChangeListener(r2.q);
        return;
    }

    public static final void Y90(DoraObricSoundSettingsFragment r2, boolean r3) {
        r2.getClass();
        g49.d.d("DoraObricSoundSettings", "updateAmbientVolumeSwitch: " + r3);
        OSwitch r0 = r2.l;
        if (r0 == null) goto L5;
        r0.setOnCheckedChangeListener(null);
    L5:
        OSwitch r1 = r2.l;
        if (r1 == null) goto L8;
        r1.setChecked(r3);
    L8:
        OSwitch r4 = r2.l;
        if (r4 == null) goto L12;
        r4.setOnCheckedChangeListener(r2.r);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        if (ja0() == false) goto L5;
        Lifecycle.State r12 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupEarbudsAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
    L15:
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupCueToneVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        if (ja0() == true) goto L20;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r13, null, this), 3, null);
        return;
    L20:
        return;
    L5:
        boolean r14 = DoraAdapterExtKt.y(kj4.a.g());
        View r0 = this.g;
        if (r0 == null) goto L11;
        if (r14 == false) goto L9;
        int r1 = 0;
    L10:
        r0.setVisibility(r1);
        goto L11
    L9:
        r1 = 8;
    L11:
        ia0();
        if (r14 == false) goto L15;
        Lifecycle.State r15 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupDefaultAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSoundSettingsFragment$setupDefaultAmbientVolume$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r15, null, this), 3, null);
        goto L15
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        OFloatingTitleBar r2 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r2.setCenterTitle(getString(2131904020));
        r2.setCenterTitleColor(ga0());
        TextView r3 = (TextView) r2.findViewById(2131365427);
        if (r3 == null) goto L5;
        r3.setTextColor(ga0());
        r3.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r3, ha0(22.0f));
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r2.R(false);
        OFloatingTitleBar.k(r2, null, 6).setOnClickListener(new d(this));
        Context r4 = requireContext();
        LinearLayout r13 = new LinearLayout(r4);
        r13.setOrientation(1);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setPadding(da0(12), 0, da0(12), da0(24));
        String r7 = getString(2131904014);
        OCardListItem r8 = ca0(this, getString(2131904012), null, new e(this));
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L12;
        DeviceService r10 = r9.device();
        if (r10 == null) goto L12;
        if (r10.M() != true) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L15;
        String r12 = getString(2131904093);
        Intrinsics.checkNotNull(r12);
    L16:
        LinearLayout r14 = aa0(this, r7, r8, r12);
        r13.addView(r14);
        this.g = r14;
        View r15 = ba0(16);
        r13.addView(r15);
        this.j = r15;
        OSlider r16 = new OSlider(requireContext(), null, 6, 0);
        r16.setMinValue(0.0f);
        r16.setMaxValue(5.0f);
        r16.setProgress(4.0f);
        r16.g = true;
        Drawable r20 = ContextCompat.getDrawable(r16.getContext(), 2131244263);
        if (r20 == null) goto L21;
        r16.setLeftIcon(r20);
        r16.b.setVisibility(0);
        ImageView r21 = (ImageView) r16.findViewById(2131390043);
        if (r21 == null) goto L21;
        r21.setColorFilter(ContextCompat.getColor(r16.getContext(), 2131104350));
    L21:
        r16.c.setVisibility(8);
        this.n = r16;
        String r22 = getString(2131904017);
        String r5 = getString(2131904017);
        View r111 = this.n;
        LinearLayout r23 = new LinearLayout(requireContext());
        r23.setOrientation(1);
        r23.setGravity(16);
        r23.setPadding(da0(12), da0(12), da0(4), da0(10));
        OTextView r24 = new OTextView(r23.getContext(), null, 0, 14);
        r24.setText(r5);
        r24.setTextColor(ga0());
        r24.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r24, ha0(22.0f));
        r24.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r23.addView(r24, new LinearLayout.LayoutParams(-1, -2));
        if (r111 == null) goto L24;
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-1, da0(32));
        int r25 = 6;
        r6.topMargin = da0(6);
        Unit r112 = Unit.INSTANCE;
        r23.addView(r111, r6);
    L25:
        OCardListItem r26 = new OCardListItem(requireContext(), null, r25, 0);
        r26.setCardType(2);
        OCardListItem.h(r26, 0);
        r26.setShowCardBg(true);
        r26.setCustomStartView(r23);
        r26.n(true);
        r26.m(false);
        r26.r(false);
        fa0(r26);
        r26.getCardContainer().setPadding(da0(8), da0(8), da0(8), da0(8));
        r26.getContentContainer().setPadding(0, 0, 0, 0);
        r26.o(false);
        Z90(r26);
        if (ja0() == false) goto L28;
        String r27 = getString(2131904019);
        Intrinsics.checkNotNull(r27);
    L29:
        LinearLayout r28 = aa0(this, r22, r26, r27);
        r13.addView(r28);
        this.h = r28;
        if (ja0() == true) goto L32;
        View r30 = ba0(16);
        r13.addView(r30);
        this.k = r30;
        LinearLayout r31 = aa0(this, null, ca0(this, getString(2131902184), getString(2131902185), new f(this)), null);
        r13.addView(r31);
        this.i = r31;
    L32:
        NestedScrollView r32 = new NestedScrollView(r4);
        r32.setClipChildren(true);
        r32.setClipToPadding(false);
        r32.setOverScrollMode(2);
        r32.setFillViewport(true);
        r32.setPadding(0, da0(8), 0, 0);
        r32.addView(r13, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r1, r2, r32, v19.c.a(2130970531, requireContext(), 2131102535), new com.larus.dora.obric.device_management.setting.common.sound.a(this));
    L28:
        r27 = getString(2131902696);
        Intrinsics.checkNotNull(r27);
        goto L29
    L24:
        r25 = 6;
        goto L25
    L15:
        r12 = getString(2131904013);
        Intrinsics.checkNotNull(r12);
    L12:
        r11 = false;
        goto L13
    }

    public static LinearLayout aa0(DoraObricSoundSettingsFragment r16, String r17, OCardListItem r18, String r110) {
        r16.getClass();
        LinearLayout r3 = new LinearLayout(r16.requireContext());
        r3.setOrientation(1);
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        r3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (r17 == null) goto L8;
        OSectionTitleBar r10 = new OSectionTitleBar(r16.requireContext(), null, 6, 0);
        LinearLayout r11 = (LinearLayout) r10.findViewById(2131367728);
        if (r11 == null) goto L7;
        r11.setPadding(r16.da0(20), r16.da0(8), r16.da0(12), r16.da0(8));
    L7:
        r10.setTitleText(r17);
        r10.setTitleStyle(2131953405);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-1, r16.da0(32)));
        r3.addView(r10);
    L8:
        r3.addView(r18);
        if (r110 == null) goto L14;
        OSectionSupportiveText r1 = new OSectionSupportiveText(r16.requireContext(), null, 6, 0);
        r1.setPadding(r16.da0(20), 0, r16.da0(20), 0);
        r1.setSectionDes(r110);
        TextView r2 = (TextView) r1.findViewById(2131385718);
        if (r2 == null) goto L13;
        r2.setTextColor(ContextCompat.getColor(r16.requireContext(), 2131104359));
        r2.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r2, r16.ha0(16.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
    L13:
        r1.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r3.addView(r1);
    L14:
        return r3;
    }

    public static OCardListItem ca0(DoraObricSoundSettingsFragment r6, String r7, String r8, Function1 r9) {
        r6.getClass();
        OCardListItem r0 = new OCardListItem(r6.requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, 0);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r7);
        r0.s(true);
        r0.setSubTitle(r8);
        if (r8 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        r0.q(!r10);
        r0.setDefaultCustomEndView(1);
        r0.m(true);
        r0.r(false);
        OSwitch r11 = r0.getEndSwitch();
        if (r11 == null) goto L12;
        r9.invoke(r11);
    L12:
        r6.fa0(r0);
        r0.getCardContainer().setPadding(r6.da0(8), r6.da0(8), r6.da0(8), r6.da0(8));
        r0.getContentContainer().setPadding(0, 0, r6.da0(4), 0);
        r0.getTitleContainer().setGravity(16);
        r0.getTitleContainer().setPadding(r6.da0(12), r6.da0(10), r6.da0(8), r6.da0(10));
        OTextView r12 = r0.getTitleView();
        r12.setGravity(8388611);
        r12.setMaxLines(1);
        r12.setTextColor(r6.ga0());
        r12.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r12, r6.ha0(22.0f));
        r12.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        OTextView r13 = r0.getSubTitleView();
        r13.setMaxLines(5);
        r13.setTextColor(ContextCompat.getColor(r6.requireContext(), 2131104359));
        r13.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r13, r6.ha0(16.0f));
        r0.o(false);
        r6.Z90(r0);
        return r0;
    L5:
        if (r8.length() == 0) goto L8;
        r10 = false;
        goto L9
    }
}
