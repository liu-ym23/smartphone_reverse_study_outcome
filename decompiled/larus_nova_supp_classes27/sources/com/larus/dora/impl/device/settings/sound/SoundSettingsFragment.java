package com.larus.dora.impl.device.settings.sound;

import android.app.Application;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraPageSoundSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002*\u0001\r\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\u0015\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010&J\u0015\u0010'\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010&J\b\u0010(\u001a\u00020)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\n\u0010,\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u000203H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/dora/impl/device/settings/sound/SoundSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageSoundSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/sound/SoundSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "ambientVolumeChangedReceiver", "com/larus/dora/impl/device/settings/sound/SoundSettingsFragment$ambientVolumeChangedReceiver$1", "Lcom/larus/dora/impl/device/settings/sound/SoundSettingsFragment$ambientVolumeChangedReceiver$1;", "checkedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "setupVoiceSeek", "setupAntiSoundLeak", "refreshAntiSoundLeakCheckedState", "state", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "convertIntToByte", "", "input", "(Ljava/lang/Integer;)I", "convertByteToInt", "getCurrentPageName", "", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "getPageMaskView", "soundAmbientVolumeSwitchCheckedChangeListener", "updateAmbientVolumeSwitch", "isOpen", "", "updateSpeakerVolumeSwitch", "vol", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SoundSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDoraPageSoundSettingsBinding f;
    public final Lazy g;
    public final SoundSettingsFragment$ambientVolumeChangedReceiver$1 h;
    public final g i;
    public final h j;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ SoundSettingsFragment a;

        public b(SoundSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            l r3 = (l) r1;
            if (Intrinsics.areEqual(r3, l.a.a) == true) goto L12;
            if (Intrinsics.areEqual(r3, l.b.a) == true) goto L12;
            if ((r3 instanceof l.c) == false) goto L10;
            SoundSettingsFragment.X90(this.a, ((l.c) r3).a);
            goto L12
        L10:
            throw new NoWhenBranchMatchedException();
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ SoundSettingsFragment a;

        public c(SoundSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            if (((Boolean) r2).booleanValue() == true) goto L8;
            s r4 = s.a;
            Application r5 = AppHost.a.getApplication();
            r4.getClass();
            s.b(r5, 2131904037, false);
            SoundSettingsFragment r6 = this.a;
            int r7 = SoundSettingsFragment.k;
            l r8 = (l) r6.Y90().getSoundSettingsStateFlow().getValue();
            if ((r8 instanceof l.c) == false) goto L8;
            SoundSettingsFragment.X90(this.a, ((l.c) r8).a);
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ SoundSettingsFragment a;

        public d(SoundSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            m r9 = (m) r7;
            if (Intrinsics.areEqual(r9, m.a.a) == true) goto L87;
            if (Intrinsics.areEqual(r9, m.b.a) == true) goto L87;
            if ((r9 instanceof m.c) == false) goto L85;
            if (r9 == null) goto L87;
            SoundSettingsFragment r10 = this.a;
            byte r11 = ((m.c) r9).a;
            int r0 = SoundSettingsFragment.k;
            r10.getClass();
            g49.d.d("SoundSettingsFragment", "update updateSpeakerVolumeSwitch " + r11);
            LarusDoraPageSoundSettingsBinding r12 = r10.f;
            if (r12 == null) goto L87;
            SeekBar r13 = r12.r;
            if (r13 == null) goto L87;
            Integer r14 = Integer.valueOf(r11 & 255);
            if (r14 == null) goto L20;
            if (r14.intValue() != 253) goto L20;
            int r15 = 0;
        L83:
            r13.setProgress(r15);
        L20:
            if (r14 == null) goto L26;
            if (r14.intValue() != 254) goto L26;
            r15 = 1;
        L26:
            if (r14 == null) goto L32;
            if (r14.intValue() != 255) goto L32;
            r15 = 2;
        L32:
            if (r14 == null) goto L38;
            if (r14.intValue() != 0) goto L38;
        L82:
            r15 = 3;
        L38:
            if (r14 == null) goto L44;
            if (r14.intValue() != 1) goto L44;
            r15 = 4;
        L44:
            if (r14 == null) goto L50;
            if (r14.intValue() != 2) goto L50;
            r15 = 5;
        L50:
            if (r14 == null) goto L56;
            if (r14.intValue() != 3) goto L56;
            r15 = 6;
        L56:
            if (r14 == null) goto L62;
            if (r14.intValue() != 4) goto L62;
            r15 = 7;
        L62:
            if (r14 != null) goto L65;
        L67:
            if (r14 != null) goto L70;
        L72:
            if (r14 != null) goto L75;
        L77:
            if (r14 == null) goto L82;
            if (r14.intValue() != 8) goto L82;
            r15 = 11;
            goto L83
        L75:
            if (r14.intValue() != 7) goto L77;
            r15 = 10;
            goto L83
        L70:
            if (r14.intValue() != 6) goto L72;
            r15 = 9;
            goto L83
        L65:
            if (r14.intValue() != 5) goto L67;
            r15 = 8;
            goto L83
        L85:
            throw new NoWhenBranchMatchedException();
        L87:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "dora_voice_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageSoundSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final SoundSettingsViewModel Y90() {
        return (SoundSettingsViewModel) this.g.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.settings.sound.SoundSettingsFragment$ambientVolumeChangedReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.device.settings.sound.g] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.device.settings.sound.h] */
    public SoundSettingsFragment() {
        final Function0<Fragment> r0 = new SoundSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SoundSettingsViewModel.class), new SoundSettingsFragment$special$$inlined$viewModels$default$2(r0), new SoundSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = new SoundSettingsFragment$ambientVolumeChangedReceiver$1(this);
        this.i = new g(this);
        this.j = new h(this);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager r0 = LocalBroadcastManager.getInstance(requireContext());
        SoundSettingsFragment$ambientVolumeChangedReceiver$1 r1 = this.h;
        DoraAmbientVolumeSettingsNotifier r2 = DoraAmbientVolumeSettingsNotifier.a;
        r0.registerReceiver(r1, new IntentFilter("com.larus.dora.impl.action.AMBIENT_VOLUME_CHANGED"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.h);
        super.onStop();
    }

    public static final void W90(SoundSettingsFragment r2, com.larus.dora.impl.device.settings.sound.a r3) {
        LarusDoraPageSoundSettingsBinding r0 = r2.f;
        if (r0 == null) goto L9;
        ItemTextToggle r1 = r0.n;
        if (r1 == null) goto L9;
        CustomSwitchCompat r4 = r1.getToggleView();
        if (r4 == null) goto L9;
        r4.setOnCheckedChangeListener(null);
    L9:
        LarusDoraPageSoundSettingsBinding r5 = r2.f;
        if (r5 == null) goto L16;
        ItemTextToggle r6 = r5.n;
        if (r6 == null) goto L16;
        CustomSwitchCompat r7 = r6.getToggleView();
        if (r7 == null) goto L16;
        r7.setChecked(Intrinsics.areEqual(r3, com.larus.dora.impl.device.settings.sound.a.b.a));
    L16:
        LarusDoraPageSoundSettingsBinding r8 = r2.f;
        if (r8 == null) goto L24;
        ItemTextToggle r9 = r8.n;
        if (r9 == null) goto L25;
        CustomSwitchCompat r10 = r9.getToggleView();
        if (r10 == null) goto L26;
        r10.setOnCheckedChangeListener(r2.i);
        return;
    L26:
        return;
    L25:
        return;
    }

    public static final void X90(SoundSettingsFragment r2, boolean r3) {
        r2.getClass();
        g49.d.d("SoundSettingsFragment", "update AmbientVolumeSwitch " + r3);
        LarusDoraPageSoundSettingsBinding r0 = r2.f;
        if (r0 == null) goto L9;
        ItemTextToggle r1 = r0.h;
        if (r1 == null) goto L9;
        CustomSwitchCompat r4 = r1.getToggleView();
        if (r4 == null) goto L9;
        r4.setOnCheckedChangeListener(null);
        r4.setChecked(r3);
        r4.setOnCheckedChangeListener(r2.j);
    L9:
        LarusDoraPageSoundSettingsBinding r5 = r2.f;
        if (r5 == null) goto L15;
        LinearLayout r6 = r5.e;
        if (r6 == null) goto L16;
        e1.o(r6);
        return;
    L16:
        return;
    }

    public final void onViewCreated(View r210, Bundle r30) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r210, r30);
        LarusDoraPageSoundSettingsBinding r0 = this.f;
        if (r0 == null) goto L5;
        NovaTitleBarEx r8 = r0.q;
        NovaTitleBarEx.Y5(r8, getString(2131903999), null, null, 6);
        NovaTitleBarEx.b6(r8, 2131240517, false, null, null, new i(this), 14);
    L5:
        LarusDoraPageSoundSettingsBinding r1 = this.f;
        if (r1 == null) goto L8;
        r1.r.setOnSeekBarChangeListener(new SoundSettingsFragment$setupVoiceSeek$1$1(this));
    L8:
        IDoraService r2 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r9 = true;
        if (r2 == null) goto L15;
        DeviceService r3 = r2.device();
        if (r3 == null) goto L15;
        if (r3.M() != true) goto L15;
        boolean r10 = true;
    L16:
        Lifecycle.State r11 = Lifecycle.State.STARTED;
        boolean r5 = r10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r11, null, this, r5), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r11, null, this, r5), 3, null);
        if (com.larus.dora.impl.util.s.a() == false) goto L36;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L25;
        DeviceService r6 = r4.device();
        if (r6 == null) goto L25;
        if (r6.N() != true) goto L25;
    L26:
        if (r9 == false) goto L36;
        LarusDoraPageSoundSettingsBinding r7 = this.f;
        if (r7 == null) goto L35;
        ItemTextToggle r12 = r7.n;
        if (r12 == null) goto L35;
        CustomSwitchCompat r13 = r12.getToggleView();
        if (r13 == null) goto L35;
        r13.setOnCheckedChangeListener(this.i);
    L35:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r11, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r11, null, this), 3, null);
        return;
    L25:
        r9 = false;
    L36:
        LarusDoraPageSoundSettingsBinding r14 = this.f;
        if (r14 == null) goto L41;
        ItemGroupTitle r15 = r14.o;
        if (r15 == null) goto L41;
        e1.o(r15);
    L41:
        LarusDoraPageSoundSettingsBinding r16 = this.f;
        if (r16 == null) goto L46;
        ItemGroup r17 = r16.l;
        if (r17 == null) goto L46;
        e1.o(r17);
    L46:
        LarusDoraPageSoundSettingsBinding r18 = this.f;
        if (r18 == null) goto L51;
        AppCompatTextView r20 = r18.m;
        if (r20 == null) goto L51;
        e1.o(r20);
    L51:
        LarusDoraPageSoundSettingsBinding r21 = this.f;
        if (r21 == null) goto L56;
        View r22 = r21.i;
        if (r22 == null) goto L56;
        e1.o(r22);
    L56:
        LarusDoraPageSoundSettingsBinding r23 = this.f;
        if (r23 == null) goto L65;
        ItemTextToggle r24 = r23.n;
        if (r24 == null) goto L66;
        CustomSwitchCompat r25 = r24.getToggleView();
        if (r25 == null) goto L67;
        r25.setChecked(false);
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L15:
        r10 = false;
        goto L16
    }

    public final View onCreateView(LayoutInflater r23, ViewGroup r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r23, "inflater");
        View r0 = r23.inflate(2131562292, r24, false);
        int r1 = 2131369711;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r0, 2131369711);
        if (r5 == null) goto L55;
        r1 = 2131369962;
        View r6 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r6 == null) goto L55;
        r1 = 2131370011;
        View r7 = ViewBindings.findChildViewById(r0, 2131370011);
        if (r7 == null) goto L55;
        r1 = 2131370012;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131370012);
        if (r8 == null) goto L55;
        r1 = 2131370013;
        if (ViewBindings.findChildViewById(r0, 2131370013) == null) goto L55;
        r1 = 2131370014;
        if (((SeekBar) ViewBindings.findChildViewById(r0, 2131370014)) == null) goto L55;
        r1 = 2131370015;
        if (ViewBindings.findChildViewById(r0, 2131370015) == null) goto L55;
        r1 = 2131370016;
        if (ViewBindings.findChildViewById(r0, 2131370016) == null) goto L55;
        r1 = 2131370017;
        if (ViewBindings.findChildViewById(r0, 2131370017) == null) goto L55;
        r1 = 2131370018;
        ItemGroupTitle r9 = ViewBindings.findChildViewById(r0, 2131370018);
        if (r9 == null) goto L55;
        r1 = 2131370019;
        ItemGroup r10 = ViewBindings.findChildViewById(r0, 2131370019);
        if (r10 == null) goto L55;
        r1 = 2131370020;
        ItemTextToggle r11 = ViewBindings.findChildViewById(r0, 2131370020);
        if (r11 == null) goto L55;
        r1 = 2131370021;
        View r12 = ViewBindings.findChildViewById(r0, 2131370021);
        if (r12 == null) goto L55;
        r1 = 2131370022;
        ItemGroup r13 = ViewBindings.findChildViewById(r0, 2131370022);
        if (r13 == null) goto L55;
        r1 = 2131370023;
        AppCompatTextView r14 = ViewBindings.findChildViewById(r0, 2131370023);
        if (r14 == null) goto L55;
        r1 = 2131370079;
        ItemGroup r15 = ViewBindings.findChildViewById(r0, 2131370079);
        if (r15 == null) goto L55;
        r1 = 2131370080;
        AppCompatTextView r16 = ViewBindings.findChildViewById(r0, 2131370080);
        if (r16 == null) goto L55;
        r1 = 2131370081;
        ItemTextToggle r17 = ViewBindings.findChildViewById(r0, 2131370081);
        if (r17 == null) goto L55;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L55;
        r1 = 2131386996;
        ItemGroupTitle r18 = ViewBindings.findChildViewById(r0, 2131386996);
        if (r18 == null) goto L55;
        r1 = 2131387001;
        ItemGroupTitle r110 = ViewBindings.findChildViewById(r0, 2131387001);
        if (r110 == null) goto L55;
        r1 = 2131388772;
        NovaTitleBarEx r20 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r20 == null) goto L55;
        r1 = 2131392729;
        if (ViewBindings.findChildViewById(r0, 2131392729) == null) goto L55;
        r1 = 2131392747;
        SeekBar r21 = (SeekBar) ViewBindings.findChildViewById(r0, 2131392747);
        if (r21 == null) goto L55;
        r1 = 2131392753;
        if (ViewBindings.findChildViewById(r0, 2131392753) == null) goto L55;
        LinearLayout r2 = (LinearLayout) r0;
        this.f = new LarusDoraPageSoundSettingsBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21);
        return r2;
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
