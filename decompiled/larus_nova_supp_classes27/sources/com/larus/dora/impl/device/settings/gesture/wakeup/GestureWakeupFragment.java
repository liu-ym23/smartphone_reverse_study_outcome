package com.larus.dora.impl.device.settings.gesture.wakeup;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextSelectorSubTitle;
import com.larus.dora.impl.databinding.LarusDoraPageWakeupGestureBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.j0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002J\n\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\"\u001a\u00020#H\u0002J\u000f\u0010)\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010 R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageWakeupGestureBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel;", "model$delegate", "Lkotlin/Lazy;", "side", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setPrefer", "()Lkotlin/Unit;", "updateSelectItemView", "type", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "onItemSelectorViewClicked", "initHintVideo", "Lcom/larus/dora/impl/view/DoraMovieView;", "updateHintVideo", "", "releaseHintVideo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureWakeupFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageWakeupGestureBinding f;
    public final Lazy g;
    public int h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GestureWakeupType.values().length];
            r0[GestureWakeupType.CLOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[GestureWakeupType.RADIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[GestureWakeupType.RADIO_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ GestureWakeupFragment a;

        public b(GestureWakeupFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            h r4 = (h) r2;
            if (r4 == null) goto L8;
            GestureWakeupType r5 = r4.getType();
            if (r5 == null) goto L8;
            GestureWakeupFragment.W90(this.a, r4.b, r5);
        L8:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ GestureWakeupFragment a;

        public c(GestureWakeupFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            if ((((com.larus.dora.impl.device.settings.gesture.wakeup.a) r1) instanceof com.larus.dora.impl.device.settings.gesture.wakeup.a.C0044a) == false) goto L10;
            FragmentActivity r3 = this.a.getActivity();
            if (r3 == null) goto L8;
            r3.finish();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public final String k() {
        return "";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageWakeupGestureBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h;
    }

    public final GestureWakeupViewModel X90() {
        return (GestureWakeupViewModel) this.g.getValue();
    }

    public final void Y90() {
        LarusDoraPageWakeupGestureBinding r0 = this.f;
        if (r0 == null) goto L6;
        r0.f.g();
        r0.f.f();
        Unit r1 = Unit.INSTANCE;
        return;
    }

    public GestureWakeupFragment() {
        final Function0<Fragment> r0 = new GestureWakeupFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GestureWakeupViewModel.class), new GestureWakeupFragment$special$$inlined$viewModels$default$2(r0), new GestureWakeupFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        Y90();
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        Bundle r14 = getArguments();
        if (r14 == null) goto L5;
        int r15 = r14.getInt("device_side");
    L6:
        this.h = r15;
        LarusDoraPageWakeupGestureBinding r16 = this.f;
        if (r16 == null) goto L9;
        NovaTitleBarEx r1 = r16.i;
        int r17 = j0.a;
        NovaTitleBarEx.Y5(r1, j0.d(2131904055), null, null, 6);
        NovaTitleBarEx.b6(r1, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.gesture.wakeup.b(this), 14);
    L9:
        LarusDoraPageWakeupGestureBinding r18 = this.f;
        if (r18 == null) goto L38;
        Context r2 = getContext();
        if (r2 == null) goto L37;
        List<GestureWakeupType> r3 = X90().getGestureWakeupTypes();
        r18.g.removeAllViews();
        int r4 = r3.size();
        Iterator<T> r5 = r3.iterator();
        int r6 = 0;
    L16:
        if (r5.hasNext() == false) goto L37;
        int r7 = r6 + 1;
        final GestureWakeupType r8 = (GestureWakeupType) r5.next();
        String r9 = r2.getString(r8.getTitleResId());
        if (r8.getSubtitleResId() <= 0) goto L20;
        String r10 = r2.getString(r8.getSubtitleResId());
    L21:
        Intrinsics.checkNotNull(r10);
        if (r10.length() != 0) goto L24;
        boolean r11 = true;
    L25:
        if (r11 == false) goto L27;
        ItemTextSelector r20 = new ItemTextSelector(r2);
        r20.setText(r9);
    L28:
        if (r4 != 1) goto L30;
        int r21 = 2131239210;
    L36:
        r20.setBackgroundResource(r21);
        r20.setTag(r8);
        e1.d(r20, new com.larus.dora.impl.device.settings.gesture.wakeup.c(this, r8));
        r18.g.addView(r20, new ViewGroup.LayoutParams(-1, -1));
        r6 = r7;
        goto L16
    L30:
        if (r6 != 0) goto L33;
        r21 = 2131239212;
        goto L36
    L33:
        if (r6 != (r4 - 1)) goto L35;
        r21 = 2131239215;
        goto L36
    L35:
        r21 = 2131239218;
        goto L36
    L27:
        ItemTextSelector r110 = new ItemTextSelectorSubTitle(r2);
        r110.setMainTitle(r9);
        r110.setSubTitle(r10);
        r20 = r110;
        goto L28
    L24:
        r11 = false;
        goto L25
    L20:
        r10 = "";
    L37:
        Unit r111 = Unit.INSTANCE;
    L38:
        final LarusDoraPageWakeupGestureBinding r112 = this.f;
        if (r112 == null) goto L41;
        final DoraMovieView r113 = r112.f;
        r113.setLooping(Boolean.TRUE);
        r113.setPauseInFirst(true);
        r113.setMediaPlayerStartListener(new d(r112));
        e1.d(r113, new e(r113, r112));
    L41:
        Lifecycle.State r114 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r114, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r114, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureWakeupFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r114, null, this), 3, null);
        return;
    L5:
        r15 = 0;
        goto L6
    }

    public static final void W90(final GestureWakeupFragment r3, int r4, GestureWakeupType r5) {
        if (r4 != 0) goto L4;
    L6:
        LarusDoraPageWakeupGestureBinding r6 = r3.f;
        if (r6 == null) goto L11;
        ItemGroup r7 = r6.g;
        if (r7 == null) goto L11;
        Sequence r8 = ViewGroupKt.getChildren(r7);
    L12:
        if (r8 != null) goto L14;
        r8 = SequencesKt.emptySequence();
    L14:
        Iterator r9 = r8.iterator();
    L15:
        boolean r1 = true;
        if (r9.hasNext() == false) goto L22;
        View r0 = (View) r9.next();
        if (r0.getTag() == r5) goto L21;
        r1 = false;
    L21:
        r0.setSelected(r1);
        goto L15
    L22:
        LarusDoraPageWakeupGestureBinding r10 = r3.f;
        if (r10 == null) goto L46;
        int r2 = a.a[r5.ordinal()];
        if (r2 != 1) goto L27;
        e1.o(r10.c);
        e1.o(r10.b);
        e1.o(r10.e);
        Unit r11 = Unit.INSTANCE;
        return;
    L27:
        if (r2 != 2) goto L29;
    L35:
        e1.x(r10.c);
        e1.x(r10.b);
        e1.x(r10.e);
        if (r5 != GestureWakeupType.RADIO) goto L38;
        int r12 = 2131904054;
    L39:
        r10.e.setText(r12);
        final DoraMovieView r13 = r10.f;
        r13.post(new f(r3, r13));
        Intrinsics.checkNotNull(r13);
        return;
    L38:
        r12 = 2131903943;
        goto L39
    L29:
        if (r2 == 3) goto L35;
        if (r2 != 4) goto L34;
        e1.x(r10.c);
        e1.x(r10.b);
        e1.x(r10.e);
        r10.e.setText(2131904051);
        final DoraMovieView r14 = r10.f;
        r14.post(new g(r3, r14));
        Intrinsics.checkNotNull(r14);
        return;
    L34:
        throw new NoWhenBranchMatchedException();
    L46:
        return;
    L11:
        r8 = null;
        goto L12
    L4:
        if (r4 == r3.h) goto L6;
        g49.d.a("DoraOTA", "updateSelectItemView but side not consistent:" + r4 + ", page side:" + r3.h);
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131562294, r12, false);
        int r15 = 2131369622;
        ItemGroup r2 = ViewBindings.findChildViewById(r14, 2131369622);
        if (r2 == null) goto L23;
        r15 = 2131369623;
        ItemGroupTitle r3 = ViewBindings.findChildViewById(r14, 2131369623);
        if (r3 == null) goto L23;
        r15 = 2131369624;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r14, 2131369624);
        if (r4 == null) goto L23;
        r15 = 2131369625;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r14, 2131369625);
        if (r5 == null) goto L23;
        r15 = 2131369626;
        DoraMovieView r6 = (DoraMovieView) ViewBindings.findChildViewById(r14, 2131369626);
        if (r6 == null) goto L23;
        r15 = 2131369954;
        ItemGroup r7 = ViewBindings.findChildViewById(r14, 2131369954);
        if (r7 == null) goto L23;
        r15 = 2131369962;
        View r8 = ViewBindings.findChildViewById(r14, 2131369962);
        if (r8 == null) goto L23;
        r15 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r14, 2131385238)) == null) goto L23;
        r15 = 2131388772;
        NovaTitleBarEx r9 = ViewBindings.findChildViewById(r14, 2131388772);
        if (r9 == null) goto L23;
        ConstraintLayout r16 = r14;
        this.f = new LarusDoraPageWakeupGestureBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
