package com.larus.dora.impl.device.settings.media;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.databinding.LarusDoraPageMediaSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J,\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u00020\u0015H\u0002J\n\u00100\u001a\u0004\u0018\u00010\rH\u0016J\b\u00101\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u00063"}, d2 = {"Lcom/larus/dora/impl/device/settings/media/MediaSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageMediaSettingsBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/media/MediaSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/media/MediaSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showAspectRatioReelDialog", "showVideoQualityReelDialog", "showRecordDurationReelDialog", "showConfirmDialog", "title", "", "msg", "confirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "cancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "handleVideoRecordConfig", "state", "Lcom/larus/dora/impl/device/settings/media/MediaVideoRecordConfig;", "onResume", "handleMediaAlbumConfig", "config", "Lcom/larus/dora/impl/device/settings/media/MediaAlbumConfig;", "handleMediaAlbumAction", "action", "Lcom/larus/dora/impl/device/settings/media/MediaAlbumAction;", "showRecordLocationAlwaysAllowDialog", "openAppSettings", "permissionRecordLocation", "permissionLocation", "getPageMaskView", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraPageMediaSettingsBinding f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ MediaSettingsFragment a;

        public b(MediaSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            com.larus.dora.impl.device.settings.media.b r13 = (com.larus.dora.impl.device.settings.media.b) r11;
            final MediaSettingsFragment r14 = this.a;
            int r0 = MediaSettingsFragment.h;
            r14.getClass();
            if ((r13 instanceof com.larus.dora.impl.device.settings.media.b.C0053b) == false) goto L6;
            g49.d.d("MediaSettingsFragment", "cur state is empty");
        L33:
            return Unit.INSTANCE;
        L6:
            if ((r13 instanceof com.larus.dora.impl.device.settings.media.b.a) == false) goto L8;
            com.larus.dora.impl.device.settings.media.b.a r15 = (com.larus.dora.impl.device.settings.media.b.a) r13;
        L9:
            if (r15 == null) goto L33;
            g49.d.d("MediaSettingsFragment", "handle state isSup=" + r15.a + " autoSync=" + r15.b + " saveToGallery=" + r15.c + " recordLocation=" + r15.d + " alwaysAllowed=" + r15.e);
            LarusDoraPageMediaSettingsBinding r1 = r14.f;
            if (r1 == null) goto L33;
            if (r15.a == false) goto L16;
            e1.x(r1.c);
            e1.x(r1.d);
            e1.x(r1.n);
            e1.x(r1.o);
        L17:
            LarusDoraPageMediaSettingsBinding r2 = r14.f;
            if (r2 == null) goto L24;
            ItemTextToggle r3 = r2.b;
            if (r3 == null) goto L24;
            CustomSwitchCompat r4 = r3.getToggleView();
            if (r4 == null) goto L24;
            r4.setOnCheckedChangeListener(null);
            r4.setChecked(r15.b);
            r4.setOnCheckedChangeListener(new k(r14));
        L24:
            CustomSwitchCompat r5 = r1.m.getToggleView();
            r5.setOnCheckedChangeListener(null);
            r5.setChecked(r15.c);
            r5.setOnCheckedChangeListener(new l(r14));
            CustomSwitchCompat r6 = r1.k.getToggleView();
            r6.setOnCheckedChangeListener(null);
            r6.setChecked(r15.d);
            if (r6.isChecked() == false) goto L27;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r14), null, null, new MediaSettingsFragment$handleMediaAlbumConfig$1$3$1(null), 3, null);
        L27:
            r6.setOnCheckedChangeListener(new m(r14));
            AppCompatTextView r7 = r1.l;
            if (r15.e == false) goto L30;
            int r16 = 2131903961;
        L31:
            r7.setText(r14.getString(r16));
            goto L33
        L30:
            r16 = 2131903962;
            goto L31
        L16:
            e1.o(r1.c);
            e1.o(r1.d);
            e1.o(r1.n);
            e1.o(r1.o);
            goto L17
        L8:
            r15 = null;
            goto L9
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ MediaSettingsFragment a;

        public c(MediaSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r10, Continuation r11) {
            com.larus.dora.impl.device.settings.media.a r12 = (com.larus.dora.impl.device.settings.media.a) r10;
            MediaSettingsFragment r13 = this.a;
            int r0 = MediaSettingsFragment.h;
            r13.getClass();
            if ((r12 instanceof com.larus.dora.impl.device.settings.media.a.C0052a) == false) goto L19;
            com.larus.dora.impl.device.settings.media.a.C0052a r14 = (com.larus.dora.impl.device.settings.media.a.C0052a) r12;
            if (r14.a == false) goto L16;
            i2 r1 = i2.b;
            ArrayList r5 = new ArrayList();
            int r2 = Build.VERSION.SDK_INT;
            if (r2 < 33) goto L9;
            r5.add("android.permission.NEARBY_WIFI_DEVICES");
        L10:
            Unit r6 = Unit.INSTANCE;
            q r7 = new q(r13);
            if (r2 < 31) goto L13;
            int r3 = j0.a;
            Map r4 = MapsKt.mapOf(TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131902439)));
        L14:
            g1.a.a(r13, r5, r7, r4, null, 16);
            goto L16
        L13:
            int r8 = j0.a;
            r4 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131902439)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", j0.d(2131902439))});
            goto L14
        L9:
            r5.add("android.permission.ACCESS_FINE_LOCATION");
        L16:
            if (r14.b == false) goto L28;
            t19.s r15 = t19.s.a;
            Context r9 = r13.getContext();
            String r16 = r13.getString(2131904037);
            r15.getClass();
            t19.s.c(r9, r16);
        L28:
            return Unit.INSTANCE;
        L19:
            if ((r12 instanceof com.larus.dora.impl.device.settings.media.a.b) == false) goto L25;
            g49.d.d("MediaSettingsFragment", "permissionRecordLocation request");
            i2 r17 = i2.b;
            ArrayList r18 = new ArrayList();
            r18.add("android.permission.ACCESS_FINE_LOCATION");
            if (Build.VERSION.SDK_INT < 29) goto L23;
            r18.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        L23:
            Unit r20 = Unit.INSTANCE;
            r r21 = new r(r13);
            int r22 = j0.a;
            g1.a.a(r13, r18, r21, MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131903962)), TuplesKt.to("android.permission.ACCESS_BACKGROUND_LOCATION", j0.d(2131903962))}), null, 16);
            goto L28
        L25:
            if ((r12 instanceof com.larus.dora.impl.device.settings.media.a.c) == false) goto L30;
            g49.d.d("MediaSettingsFragment", "showRecordLocationAlwaysAllowDialog");
            CommonDialog.a r110 = new CommonDialog.a();
            r110.i(r13.getString(2131903364));
            r110.g(r13.getString(2131903363));
            CommonDialog.a.f(r110, new v(r13), r13.getString(2131903063), false, 12);
            CommonDialog.a.e(r110, new w(r13), r13.getString(2131902465), 4);
            MediaSettingsFragment.X90(r110.a(), r13.getChildFragmentManager());
            goto L28
        L30:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ MediaSettingsFragment a;

        public d(MediaSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            a0 r8 = (a0) r6;
            MediaSettingsFragment r9 = this.a;
            int r0 = MediaSettingsFragment.h;
            r9.getClass();
            if ((r8 instanceof a0.a) == false) goto L5;
            a0.a r10 = (a0.a) r8;
        L6:
            if (r10 == null) goto L12;
            g49.d.d("MediaSettingsFragment", "handle video record state = " + r10.a);
            LarusDoraPageMediaSettingsBinding r1 = r9.f;
            if (r1 == null) goto L12;
            ItemTextArrow r2 = r1.h;
            String r3 = r9.Z90().getVideoQualityTxt(r10.a);
            int r4 = ItemTextArrow.k;
            r2.Z5(r3, null);
            r1.i.Z5(r9.Z90().getVideoAspectRatioTxt(Integer.valueOf(r10.a.c)), null);
            r1.g.Z5(r9.Z90().getVideoDurationTxtByDur(r10.a.a), null);
        L12:
            return Unit.INSTANCE;
        L5:
            r10 = null;
            goto L6
        }
    }

    static {
    }

    public final String k() {
        return "media_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageMediaSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j;
    }

    public final MediaSettingsViewModel Z90() {
        return (MediaSettingsViewModel) this.g.getValue();
    }

    public MediaSettingsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MediaSettingsViewModel.class), new MediaSettingsFragment$special$$inlined$activityViewModels$default$1(this), new MediaSettingsFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super.onResume();
        g49.d.d("MediaSettingsFragment", "onResume refresh record location state");
        Z90().refreshRecordLocationState();
    }

    public static void W90(MediaReelDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void X90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public static void Y90(MediaReelDialogFragment r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "AspectRatio", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "AspectRatio");
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        LarusDoraPageMediaSettingsBinding r13 = this.f;
        if (r13 == null) goto L7;
        NovaTitleBarEx r0 = r13.p;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, getString(2131902444), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new g(this), 14);
    L7:
        LarusDoraPageMediaSettingsBinding r14 = this.f;
        if (r14 != null) goto L10;
    L13:
        Lifecycle.State r15 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MediaSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MediaSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MediaSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r15, null, this), 3, null);
        return;
    L10:
        if (Z90().isSupportVideoCfg() == false) goto L12;
        e1.x(r14.e);
        e1.x(r14.f);
        e1.d(r14.i, new h(this));
        e1.d(r14.h, new i(this));
        e1.d(r14.g, new j(this));
        goto L13
    L12:
        e1.o(r14.e);
        e1.o(r14.f);
        goto L13
    }

    public final void aa0(String r3, String r4, p0 r5) {
        int r0 = j49.a.a;
        j49.a.i();
        CommonDialog.a r1 = new CommonDialog.a();
        Intrinsics.checkNotNullParameter(r3, "title");
        r1.a = r3;
        Intrinsics.checkNotNullParameter(r4, "message");
        r1.i = r4;
        s r6 = new s(r5);
        int r7 = j0.a;
        CommonDialog.a.f(r1, r6, j0.d(2131902635), false, 12);
        int r8 = v19.c.b(2130972079, getContext(), 2131103136);
        Context r9 = getContext();
        if (r9 == null) goto L5;
        Integer r10 = Integer.valueOf(ContextCompat.getColor(r9, r8));
    L6:
        f0 r11 = new f0(null, r10, null, 5);
        Intrinsics.checkNotNullParameter(r11, "commonDialogTextStyleConfig");
        r1.D = r11;
        CommonDialog.a.e(r1, new t(), j0.d(2131902465), 4);
        X90(r1.a(), getChildFragmentManager());
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r21, ViewGroup r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r21, "inflater");
        ConstraintLayout r0 = r21.inflate(2131562274, r22, false);
        int r1 = 2131369702;
        ItemTextToggle r5 = ViewBindings.findChildViewById(r0, 2131369702);
        if (r5 == null) goto L39;
        r1 = 2131369703;
        ItemGroup r6 = ViewBindings.findChildViewById(r0, 2131369703);
        if (r6 == null) goto L39;
        r1 = 2131369704;
        AppCompatTextView r7 = ViewBindings.findChildViewById(r0, 2131369704);
        if (r7 == null) goto L39;
        r1 = 2131369705;
        ItemGroupTitle r8 = ViewBindings.findChildViewById(r0, 2131369705);
        if (r8 == null) goto L39;
        r1 = 2131369706;
        ItemGroup r9 = ViewBindings.findChildViewById(r0, 2131369706);
        if (r9 == null) goto L39;
        r1 = 2131369707;
        ItemTextArrow r10 = ViewBindings.findChildViewById(r0, 2131369707);
        if (r10 == null) goto L39;
        r1 = 2131369708;
        ItemTextArrow r11 = ViewBindings.findChildViewById(r0, 2131369708);
        if (r11 == null) goto L39;
        r1 = 2131369709;
        ItemTextArrow r12 = ViewBindings.findChildViewById(r0, 2131369709);
        if (r12 == null) goto L39;
        r1 = 2131369962;
        View r13 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r13 == null) goto L39;
        r1 = 2131369990;
        ItemTextToggle r14 = ViewBindings.findChildViewById(r0, 2131369990);
        if (r14 == null) goto L39;
        r1 = 2131369991;
        if (ViewBindings.findChildViewById(r0, 2131369991) == null) goto L39;
        r1 = 2131369992;
        AppCompatTextView r15 = ViewBindings.findChildViewById(r0, 2131369992);
        if (r15 == null) goto L39;
        r1 = 2131369995;
        ItemTextToggle r16 = ViewBindings.findChildViewById(r0, 2131369995);
        if (r16 == null) goto L39;
        r1 = 2131369996;
        ItemGroup r17 = ViewBindings.findChildViewById(r0, 2131369996);
        if (r17 == null) goto L39;
        r1 = 2131369997;
        AppCompatTextView r18 = ViewBindings.findChildViewById(r0, 2131369997);
        if (r18 == null) goto L39;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L39;
        r1 = 2131388772;
        NovaTitleBarEx r110 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r110 == null) goto L39;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageMediaSettingsBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110);
        return r2;
    L39:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
