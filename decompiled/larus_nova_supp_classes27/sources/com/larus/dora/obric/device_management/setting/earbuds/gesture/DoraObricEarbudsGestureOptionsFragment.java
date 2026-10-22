package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.options.OptionModel;
import com.larus.dora.impl.device.settings.gesture.options.OptionsViewModel;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010%\u001a\u00020\u001fH\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0011H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006+"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/gesture/DoraObricEarbudsGestureOptionsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/options/OptionsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/options/OptionsViewModel;", "model$delegate", "Lkotlin/Lazy;", "page", "Lcom/larus/dora/obric/device_management/setting/earbuds/ui/DoraObricEarbudsOuiPage;", "optionList", "", "Lcom/larus/dora/impl/device/settings/gesture/options/OptionModel;", "optionViews", "Ljava/util/LinkedHashMap;", "", "Lcom/obric/oui/lisitem/OCardListItem;", "Lkotlin/collections/LinkedHashMap;", "selectedValue", "Ljava/lang/Byte;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "renderOptions", "onOptionClicked", "option", "updateSelection", "value", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsGestureOptionsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy f;
    public b79.d g;
    public List<OptionModel> h;
    public final LinkedHashMap<Byte, OCardListItem> i;
    public Byte j;

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
        public final /* synthetic */ DoraObricEarbudsGestureOptionsFragment a;

        public c(DoraObricEarbudsGestureOptionsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            if (((Boolean) r2).booleanValue() == true) goto L12;
            OptionModel r4 = (OptionModel) CollectionsKt.firstOrNull(this.a.h);
            if (r4 == null) goto L12;
            GestureSettingsKey r5 = r4.c;
            if (r5 == null) goto L12;
            DoraObricEarbudsGestureOptionsFragment r6 = this.a;
            Byte r7 = (Byte) ((Map) ((OptionsViewModel) r6.f.getValue()).getGestureSettingsStateFlow().getValue()).get(r5);
            if (r7 == null) goto L12;
            r6.W90(r7.byteValue());
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraObricEarbudsGestureOptionsFragment a;

        public d(DoraObricEarbudsGestureOptionsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Map r4 = (Map) r2;
            OptionModel r5 = (OptionModel) CollectionsKt.firstOrNull(this.a.h);
            if (r5 == null) goto L10;
            GestureSettingsKey r6 = r5.c;
            if (r6 == null) goto L10;
            DoraObricEarbudsGestureOptionsFragment r0 = this.a;
            Byte r7 = (Byte) r4.get(r6);
            if (r7 == null) goto L10;
            r0.W90(r7.byteValue());
        L10:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        b79.d r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final String k() {
        OptionModel r0 = (OptionModel) CollectionsKt.firstOrNull(this.h);
        if (r0 == null) goto L5;
        GestureSettingsKey r1 = r0.c;
    L6:
        if (r1 != null) goto L8;
        int r2 = -1;
    L10:
        if (r2 != 1) goto L12;
        return "gesture_setting_med_left";
    L12:
        if (r2 != 2) goto L14;
        return "gesture_setting_med_right";
    L14:
        if (r2 != 3) goto L16;
        return "gesture_setting_call_left";
    L16:
        if (r2 == 4) goto L18;
        return "";
    L18:
        return "gesture_setting_call_right";
    L8:
        r2 = b.a[r1.ordinal()];
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void onDestroyView() {
        this.i.clear();
        this.j = null;
        this.g = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricEarbudsGestureOptionsFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsGestureOptionsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OptionsViewModel.class), new DoraObricEarbudsGestureOptionsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsGestureOptionsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = CollectionsKt.emptyList();
        this.i = new LinkedHashMap();
    }

    public final void W90(byte r4) {
        this.j = Byte.valueOf(r4);
        Iterator<Map.Entry<Byte, OCardListItem>> r0 = this.i.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Map.Entry<Byte, OCardListItem> r1 = r0.next();
        byte r2 = r1.getKey().byteValue();
        OCardListItem r3 = r1.getValue();
        if (r2 != r4) goto L8;
        boolean r5 = true;
    L9:
        r3.m(r5);
        goto L4
    L8:
        r5 = false;
        goto L9
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureOptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGestureOptionsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r10, null, this), 3, null);
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.dora.obric.device_management.setting.earbuds.gesture.b, java.lang.Object] */
    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        final DoraObricEarbudsGestureOptionsFragment r0 = this;
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        List<OptionModel> r2 = r1.getParcelableArrayList("options_data");
    L6:
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        r0.h = r2;
        Context r3 = requireContext();
        Bundle r4 = getArguments();
        if (r4 == null) goto L11;
        String r5 = r4.getString("options_title");
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        b79.d r6 = new b79.d(r3, r5, new com.larus.dora.obric.device_management.setting.earbuds.gesture.a(r0));
        r0.g = r6;
        r0.i.clear();
        Iterator<T> r7 = r0.h.iterator();
        boolean r8 = false;
        int r9 = 0;
    L16:
        if (r7.hasNext() == false) goto L50;
        Object r10 = r7.next();
        int r11 = r9 + 1;
        if (r9 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        final OptionModel r12 = (OptionModel) r10;
        if (r0.h.size() != 1) goto L23;
        int r13 = 0;
    L29:
        LinkedHashMap<Byte, OCardListItem> r14 = r0.i;
        Byte r15 = Byte.valueOf(r12.d);
        b79.d r16 = r0.g;
        if (r16 == null) goto L50;
        String r111 = r12.a;
        String r112 = r12.b;
        final ?? r113 = new com.larus.dora.obric.device_management.setting.earbuds.gesture.b(r0, r12);
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r112, "subtitle");
        Intrinsics.checkNotNullParameter(r113, "onClick");
        LinearLayout r20 = r16.d;
        if (r20 != null) goto L35;
        r20 = new LinearLayout(r16.a);
        r20.setOrientation(1);
        r20.setClipChildren(r8);
        r20.setClipToPadding(r8);
        r16.c.addView(r20, new LinearLayout.LayoutParams(-1, -2));
        r16.d = r20;
    L35:
        final OCardListItem r21 = new OCardListItem(r16.a, null, 6, 0);
        r21.setCardType(0);
        OCardListItem.h(r21, r13);
        r21.setShowCardBg(true);
        r21.p(false);
        r21.setTitle(r111);
        r21.s(true);
        if (r112.length() != 0) goto L38;
        boolean r22 = true;
    L39:
        if (r22 == false) goto L41;
        r21.q(false);
    L42:
        r21.setDefaultCustomEndView(2);
        r21.m(false);
        r21.r(false);
        ViewGroup.LayoutParams r23 = r21.getCardContainer().getLayoutParams();
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L45;
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
    L46:
        if (r24 == null) goto L48;
        r24.setMarginStart(0);
        r24.setMarginEnd(0);
        r24.leftMargin = 0;
        r24.rightMargin = 0;
        r21.getCardContainer().setLayoutParams(r24);
    L48:
        r21.getContentContainer().setPadding(0, 0, r16.b(4), 0);
        r21.getTitleContainer().setGravity(16);
        r21.getTitleContainer().setPadding(r16.b(12), r16.b(8), r16.b(8), r16.b(8));
        OTextView r25 = r21.getTitleView();
        r25.setGravity(8388611);
        r25.setMaxLines(1);
        r25.setTextColor(v19.c.a(2130972079, r16.a, 2131103136));
        r25.setTextSize(2, 16.0f);
        Resources r26 = r16.a.getResources();
        TextViewCompat.setLineHeight(r25, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics())));
        r25.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r21.o(false);
        r21.setOnContentClickListener(new b79.c(r21, r113));
        r20.addView(r21);
        r14.put(r15, r21);
        r0 = this;
        r9 = r11;
        r8 = false;
        goto L16
    L45:
        r24 = null;
        goto L46
    L41:
        r21.setSubTitle(r112);
        r21.q(true);
        goto L42
    L38:
        r22 = false;
        goto L39
    L23:
        if (r9 != 0) goto L26;
        r13 = 1;
        goto L29
    L26:
        if (r9 != CollectionsKt.getLastIndex(r0.h)) goto L28;
        r13 = 3;
        goto L29
    L28:
        r13 = 2;
    L50:
        return r6.f;
    L11:
        r5 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }
}
