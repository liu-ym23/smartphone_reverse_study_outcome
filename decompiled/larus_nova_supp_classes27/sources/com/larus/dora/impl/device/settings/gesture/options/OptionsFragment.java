package com.larus.dora.impl.device.settings.gesture.options;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextSelectorSubTitle;
import com.larus.dora.impl.databinding.LarusDoraPageOptionsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0002J\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010&\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006("}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/options/OptionsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageOptionsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/options/OptionsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/options/OptionsViewModel;", "model$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "titleText", "setPrefer", "optionList", "", "Lcom/larus/dora/impl/device/settings/gesture/options/OptionModel;", "(Ljava/util/List;)Lkotlin/Unit;", "updateSelectItemView", "value", "", "onItemSelectorViewClicked", "option", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraPageOptionsBinding f;
    public final Lazy g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GestureSettingsKey.values().length];
            r0[GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ List<OptionModel> a;
        public final /* synthetic */ OptionsFragment b;

        public c(List<OptionModel> r1, OptionsFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r2, Continuation r3) {
            if (((Boolean) r2).booleanValue() == true) goto L13;
            OptionModel r4 = (OptionModel) CollectionsKt.firstOrNull(this.a);
            if (r4 == null) goto L7;
            GestureSettingsKey r5 = r4.c;
        L8:
            if (r5 == null) goto L13;
            OptionsFragment r6 = this.b;
            int r0 = OptionsFragment.h;
            Byte r7 = (Byte) ((Map) ((OptionsViewModel) r6.g.getValue()).getGestureSettingsStateFlow().getValue()).get(r5);
            if (r7 == null) goto L13;
            OptionsFragment.W90(this.b, r7.byteValue());
            goto L13
        L7:
            r5 = null;
        L13:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ List<OptionModel> a;
        public final /* synthetic */ OptionsFragment b;

        public d(List<OptionModel> r1, OptionsFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r1, Continuation r2) {
            Map r3 = (Map) r1;
            OptionModel r4 = (OptionModel) CollectionsKt.firstOrNull(this.a);
            if (r4 == null) goto L5;
            GestureSettingsKey r5 = r4.c;
        L6:
            if (r5 == null) goto L11;
            Byte r6 = (Byte) r3.get(r5);
            if (r6 == null) goto L11;
            OptionsFragment.W90(this.b, r6.byteValue());
        L11:
            return Unit.INSTANCE;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageOptionsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final String k() {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L30
        Bundle r2 = getArguments();     // Catch: Throwable -> L30
        GestureSettingsKey r3 = null;
        if (r2 == null) goto L6;
        List r4 = r2.getParcelableArrayList("options_data");     // Catch: Throwable -> L30
    L7:
        if (r4 != null) goto L9;
        r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L30
    L9:
        OptionModel r5 = (OptionModel) CollectionsKt.firstOrNull(r4);     // Catch: Throwable -> L30
        if (r5 == null) goto L12;
        r3 = r5.c;     // Catch: Throwable -> L30
    L12:
        if (r3 != null) goto L14;
        int r6 = -1;
    L16:
        if (r6 != 1) goto L18;
        String r7 = "gesture_setting_med_left";
    L28:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r8) == true) goto L37;
        r0 = r8;
    L37:
        return (String) r0;
    L18:
        if (r6 != 2) goto L20;
        r7 = "gesture_setting_med_right";
        goto L28
    L20:
        if (r6 != 3) goto L22;
        r7 = "gesture_setting_call_left";
        goto L28
    L22:
        if (r6 == 4) goto L24;
        r7 = "";
        goto L28
    L24:
        r7 = "gesture_setting_call_right";
        goto L28
    L14:
        r6 = b.a[r3.ordinal()];     // Catch: Throwable -> L30
        goto L16
    L6:
        r4 = null;
    L30:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    public OptionsFragment() {
        final Function0<Fragment> r0 = new OptionsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OptionsViewModel.class), new OptionsFragment$special$$inlined$viewModels$default$2(r0), new OptionsFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public static final void W90(OptionsFragment r3, byte r4) {
        LarusDoraPageOptionsBinding r5 = r3.f;
        if (r5 == null) goto L7;
        ItemGroup r6 = r5.b;
        if (r6 == null) goto L7;
        Sequence r7 = ViewGroupKt.getChildren(r6);
    L8:
        if (r7 != null) goto L10;
        r7 = SequencesKt.emptySequence();
    L10:
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        View r0 = (View) r8.next();
        r0.setSelected(Intrinsics.areEqual(r0.getTag(), Byte.valueOf(r4)));
        goto L12
    L14:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        Bundle r13 = getArguments();
        if (r13 == null) goto L5;
        String r14 = r13.getString("options_title");
    L6:
        if (r14 != null) goto L8;
        r14 = "";
    L8:
        Bundle r0 = getArguments();
        if (r0 == null) goto L11;
        List r1 = r0.getParcelableArrayList("options_data");
    L12:
        if (r1 != null) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        LarusDoraPageOptionsBinding r2 = this.f;
        if (r2 == null) goto L17;
        NovaTitleBarEx r3 = r2.d;
        NovaTitleBarEx.Y5(r3, r14, null, null, 6);
        NovaTitleBarEx.b6(r3, 2131240517, false, null, null, new o(this), 14);
    L17:
        LarusDoraPageOptionsBinding r15 = this.f;
        if (r15 == null) goto L42;
        Context r16 = getContext();
        if (r16 == null) goto L41;
        r15.b.removeAllViews();
        int r4 = r1.size();
        Iterator r5 = r1.iterator();
        int r6 = 0;
    L24:
        if (r5.hasNext() == false) goto L41;
        int r7 = r6 + 1;
        final OptionModel r8 = (OptionModel) r5.next();
        if (r8.b.length() != 0) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L31;
        ItemTextSelector r10 = new ItemTextSelector(r16);
        r10.setText(r8.a);
    L32:
        if (r4 != 1) goto L34;
        int r17 = 2131239210;
    L40:
        r10.setBackgroundResource(r17);
        r10.setTag(Byte.valueOf(r8.d));
        e1.d(r10, new n(this, r8));
        r15.b.addView(r10, new ViewGroup.LayoutParams(-1, -1));
        r6 = r7;
        goto L24
    L34:
        if (r6 != 0) goto L37;
        r17 = 2131239212;
        goto L40
    L37:
        if (r6 != (r4 - 1)) goto L39;
        r17 = 2131239215;
        goto L40
    L39:
        r17 = 2131239218;
        goto L40
    L31:
        r10 = new ItemTextSelectorSubTitle(r16);
        r10.setMainTitle(r8.a);
        r10.setSubTitle(r8.b);
        goto L32
    L28:
        r9 = false;
    L41:
        Unit r18 = Unit.INSTANCE;
    L42:
        Lifecycle.State r110 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r110, null, this, r1), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r110, null, this, r1), 3, null);
        return;
    L11:
        r1 = null;
        goto L12
    L5:
        r14 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraPageOptionsBinding r4 = LarusDoraPageOptionsBinding.a(r1, r2);
        this.f = r4;
        return r4.a;
    }
}
