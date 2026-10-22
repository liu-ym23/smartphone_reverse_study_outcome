package com.larus.dora.impl.device.ailab;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageAiLabBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.util.b0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.spi.dora.ObricDoraDelegate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010*\u001a\u00020+H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u000201H\u0002J\n\u00102\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u00103\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u00104\u001a\u0004\u0018\u00010\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0002J\n\u00108\u001a\u0004\u0018\u000109H\u0002J\u000f\u0010:\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010;J\u000f\u0010<\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010;R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012¨\u0006>"}, d2 = {"Lcom/larus/dora/impl/device/ailab/AiLabFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageAiLabBinding;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "isWakeSettingsChecking", "", "isVoiceWakeSwitchChecking", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "getModel", "()Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "model$delegate", "Lkotlin/Lazy;", "isSyllableSwitchEnabled", "()Z", "isSyllableSwitchEnabled$delegate", "autoStopTimeConfigLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "isAISFirmware", "isAISFirmware$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStop", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "getMultiUserModeTipsResId", "", "handleAbility", "ability", "Lcom/larus/dora/impl/device/ailab/AiLabAbility;", "handleUiState", "state", "Lcom/larus/dora/impl/device/ailab/AiLabState;", "adjustKeywordLayout", "hideKeywordLayout", "updateKeywordDoubaoSettings", "data", "", "Lcom/larus/dora/impl/device/ailab/AiLabKeyword;", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "updateVoiceWakeTipsVisibility", "()Lkotlin/Unit;", "setPrefer", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiLabFragment extends DoraBaseFragment {
    public static final /* synthetic */ int m = 0;
    public LarusDoraPageAiLabBinding f;
    public final CoroutineScope g;
    public boolean h;
    public final Lazy i;
    public final Lazy j;
    public ActivityResultLauncher<Intent> k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public b(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            u r7 = (u) r5;
            g49.d.d("AiLabFragment", "deviceStateFlow collect " + r7);
            final AiLabFragment r8 = this.a;
            LarusDoraPageAiLabBinding r0 = r8.f;
            if (r0 == null) goto L16;
            if ((r7 instanceof u.c) == false) goto L8;
            r8.h = true;
            r0.t.getToggleView().setChecked(((u.c) r7).a);
            r8.h = false;
            r8.X90();
            goto L16
        L8:
            if ((r7 instanceof u.b) == false) goto L11;
            r8.h = true;
            u.b r9 = (u.b) r7;
            r0.t.getToggleView().setChecked(r9.a);
            r8.h = false;
            r0.o.getToggleView().setOnCheckedChangeListener(null);
            r0.o.getToggleView().setChecked(r9.d);
            r0.o.getToggleView().setOnCheckedChangeListener(new com.larus.dora.impl.device.ailab.h(r8));
            CustomSwitchCompat r1 = r0.g.getToggleView();
            r1.setOnCheckedChangeListener(null);
            r1.setChecked(r9.f);
            r1.setOnCheckedChangeListener(new com.larus.dora.impl.device.ailab.i(r8));
            CustomSwitchCompat r2 = r0.e.getToggleView();
            r2.setOnCheckedChangeListener(null);
            r2.setChecked(r9.e);
            r2.setOnCheckedChangeListener(new j(r8));
            goto L16
        L11:
            if (Intrinsics.areEqual(r7, u.a.a) == true) goto L16;
            throw new NoWhenBranchMatchedException();
        L16:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public c(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            if (((Boolean) r2).booleanValue() == true) goto L13;
            LarusDoraPageAiLabBinding r4 = this.a.f;
            if (r4 == null) goto L11;
            ItemTextToggle r5 = r4.w;
            if (r5 == null) goto L11;
            CustomSwitchCompat r6 = r5.getToggleView();
            if (r6 == null) goto L11;
            r6.setChecked(this.a.Y90().isMultiUserModeEnabled());
        L11:
            t19.s r7 = t19.s.a;
            Application r8 = AppHost.a.getApplication();
            r7.getClass();
            t19.s.b(r8, 2131908080, false);
        L13:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public d(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            LarusDoraPageAiLabBinding r4 = this.a.f;
            if (r4 == null) goto L10;
            ItemTextToggle r5 = r4.w;
            if (r5 == null) goto L10;
            CustomSwitchCompat r6 = r5.getToggleView();
            if (r6 == null) goto L10;
            r6.setChecked(r3);
        L10:
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public e(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            LarusDoraPageAiLabBinding r4 = this.a.f;
            if (r4 == null) goto L10;
            ItemTextToggle r5 = r4.w;
            if (r5 == null) goto L10;
            CustomSwitchCompat r6 = r5.getToggleView();
            if (r6 == null) goto L10;
            r6.setChecked(r3);
        L10:
            return Unit.INSTANCE;
        }
    }

    public static final class f<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public f(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            AiLabFragment r4 = this.a;
            int r0 = AiLabFragment.m;
            r4.X90();
            AiLabFragment r5 = this.a;
            AiLabFragment.W90(r5, (List) r2);
            return Unit.INSTANCE;
        }
    }

    public static final class g<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public g(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            ((Boolean) r1).booleanValue();
            AiLabFragment r3 = this.a;
            int r4 = AiLabFragment.m;
            AiLabFragment.W90(r3, (List) r3.Y90().getKeywordsStateFlow().getValue());
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public h(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r8, Continuation r9) {
            com.larus.dora.impl.device.ailab.a r10 = (com.larus.dora.impl.device.ailab.a) r8;
            ItemGroup r1 = null;
            if (r10 == null) goto L33;
            AiLabFragment r2 = this.a;
            LarusDoraPageAiLabBinding r3 = r2.f;
            if (r3 == null) goto L32;
            AppCompatTextView r4 = r3.x;
            int r5 = j0.a;
            DoraDevice r6 = DoraAdapterExtKt.h(kj4.a.g());
            if (r6 == null) goto L9;
            Integer r7 = Integer.valueOf(r6.productId);
        L10:
            int r11 = ProductNameType.DORA_G.id;
            if (r7 != null) goto L14;
        L16:
            int r12 = 2131903375;
        L17:
            r4.setText(j0.d(r12));
            if (r10.a == false) goto L20;
            e1.o(r3.s);
            e1.x(r3.r);
            r3.t.setText(j0.d(2131902057));
            r2.X90();
            e1.x(r3.v);
            e1.x(r3.x);
        L24:
            e1.y(r3.v, r10.b);
            e1.y(r3.x, r10.b);
            r2.Z90();
            ItemGroup r13 = r3.d;
            if (r10.d == false) goto L27;
        L30:
            boolean r14 = true;
        L31:
            e1.y(r13, r14);
            e1.y(r3.e, r10.d);
            boolean r15 = r10.e;
            e1.y(r3.g, r15);
            e1.y(r3.f, r15);
            goto L32
        L27:
            if (r10.e == true) goto L30;
            r14 = false;
            goto L31
        L20:
            e1.x(r3.s);
            e1.x(r3.r);
            r3.t.setText(j0.d(2131902059));
            LarusDoraPageAiLabBinding r16 = r2.f;
            if (r16 == null) goto L23;
            r16.i.T5();
            r16.m.T5();
            r16.t.setBackgroundResource(2131239210);
            e1.o(r16.k);
            e1.o(r16.j);
            e1.o(r16.m);
            r16.i.setBackgroundResource(2131239215);
        L23:
            e1.x(r3.v);
            e1.x(r3.x);
            goto L24
        L14:
            if (r7.intValue() != r11) goto L16;
            r12 = 2131902767;
            goto L17
        L9:
            r7 = null;
        L32:
            AiLabFragment r17 = this.a;
            AiLabFragment.W90(r17, (List) r17.Y90().getKeywordsStateFlow().getValue());
        L33:
            AiLabFragment r18 = this.a;
            int r20 = AiLabFragment.m;
            if (r18.Y90().isDoraG() == true) goto L56;
            ObricDoraDelegate r21 = ObricDoraDelegate.b;
            View[] r22 = new View[5];
            LarusDoraPageAiLabBinding r23 = this.a.f;
            if (r23 == null) goto L38;
            AppCompatTextView r24 = r23.u;
        L39:
            r22[0] = r24;
            if (r23 == null) goto L42;
            ItemGroupTitle r0 = r23.s;
        L43:
            r22[1] = r0;
            if (r23 == null) goto L46;
            ItemGroup r25 = r23.v;
        L47:
            r22[2] = r25;
            if (r23 == null) goto L50;
            AppCompatTextView r26 = r23.x;
        L51:
            r22[3] = r26;
            if (r23 == null) goto L54;
            r1 = r23.c;
        L54:
            r22[4] = r1;
            r21.l(CollectionsKt.listOf(r22));
            goto L56
        L50:
            r26 = null;
            goto L51
        L46:
            r25 = null;
            goto L47
        L42:
            r0 = null;
            goto L43
        L38:
            r24 = null;
        L56:
            return Unit.INSTANCE;
        }
    }

    public static final class i<T> implements FlowCollector {
        public final /* synthetic */ AiLabFragment a;

        public i(AiLabFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.dora.impl.device.ailab.b r5 = (com.larus.dora.impl.device.ailab.b) r3;
            if ((r5 instanceof com.larus.dora.impl.device.ailab.b.a) == false) goto L14;
            t19.s r6 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            int r7 = ((com.larus.dora.impl.device.ailab.b.a) r5).a;
            r6.getClass();
            t19.s.b(r1, r7, false);
            AiLabFragment r8 = this.a;
            int r9 = AiLabFragment.m;
            u r10 = (u) r8.Y90().getDeviceStateFlow().getValue();
            if ((r10 instanceof u.b) == false) goto L25;
            LarusDoraPageAiLabBinding r11 = this.a.f;
            if (r11 == null) goto L25;
            ItemTextToggle r12 = r11.o;
            if (r12 == null) goto L25;
            CustomSwitchCompat r13 = r12.getToggleView();
            if (r13 == null) goto L25;
            r13.setChecked(((u.b) r10).d);
        L25:
            return Unit.INSTANCE;
        L14:
            if ((r5 instanceof com.larus.dora.impl.device.ailab.b.C0032b) == false) goto L27;
            t19.s r14 = t19.s.a;
            Application r2 = AppHost.a.getApplication();
            int r15 = ((com.larus.dora.impl.device.ailab.b.C0032b) r5).a;
            r14.getClass();
            t19.s.b(r2, r15, false);
            AiLabFragment r16 = this.a;
            int r17 = AiLabFragment.m;
            u r18 = (u) r16.Y90().getDeviceStateFlow().getValue();
            if ((r18 instanceof u.b) == false) goto L25;
            LarusDoraPageAiLabBinding r20 = this.a.f;
            if (r20 == null) goto L25;
            ItemTextToggle r21 = r20.e;
            if (r21 == null) goto L25;
            CustomSwitchCompat r22 = r21.getToggleView();
            if (r22 == null) goto L25;
            r22.setChecked(((u.b) r18).e);
            goto L25
        L27:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final String k() {
        return "ai_lab";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageAiLabBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.n;
    }

    public final LarusDoraPageAiLabBinding X90() {
        LarusDoraPageAiLabBinding r0 = this.f;
        LinearLayout r1 = null;
        if (r0 == null) goto L53;
        boolean r2 = r0.t.getToggleView().isChecked();
        Iterable r3 = (Iterable) Y90().getKeywordsStateFlow().getValue();
        boolean r5 = true;
        if ((r3 instanceof Collection) == true) goto L7;
    L9:
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        if (((t) r4.next()).g == false) goto L11;
        boolean r6 = true;
    L15:
        com.larus.dora.impl.device.ailab.a r7 = (com.larus.dora.impl.device.ailab.a) Y90().getAbilityStateFlow().getValue();
        if (r7 != null) goto L18;
    L20:
        boolean r8 = false;
    L22:
        if (((Boolean) this.j.getValue()).booleanValue() == false) goto L27;
        if (r2 == false) goto L27;
        if (r6 == true) goto L26;
        if (r8 == false) goto L27;
    L26:
        boolean r9 = true;
    L28:
        ItemTextToggle r10 = r0.t;
        int r11 = 2131239212;
        if (r9 == false) goto L31;
        int r12 = 2131239212;
    L32:
        r10.setBackgroundResource(r12);
        if (r9 == false) goto L35;
        e1.x(r0.k);
        e1.y(r0.j, r8);
    L36:
        e1.y(r0.h, !r8);
        ItemTextSelector r13 = r0.m;
        if (r9 == false) goto L40;
        if (r8 == false) goto L40;
    L41:
        e1.y(r13, r5);
        ItemTextSelector r14 = r0.i;
        if (r8 == false) goto L45;
    L48:
        r14.setBackgroundResource(r11);
        r0.m.setBackgroundResource(2131239215);
        ObricDoraDelegate r15 = ObricDoraDelegate.b;
        LarusDoraPageAiLabBinding r16 = this.f;
        if (r16 == null) goto L51;
        r1 = r16.k;
    L51:
        r15.p(CollectionsKt.listOf(r1));
        return r0;
    L45:
        if (r0.m.getVisibility() != 0) goto L47;
        r11 = 2131239218;
        goto L48
    L47:
        r11 = 2131239215;
    L40:
        r5 = false;
        goto L41
    L35:
        e1.o(r0.k);
        e1.o(r0.j);
        goto L36
    L31:
        r12 = 2131239210;
    L27:
        r9 = false;
        goto L28
    L18:
        if (r7.f != true) goto L20;
        r8 = true;
    L8:
        r6 = false;
        goto L15
    L7:
        if (((Collection) r3).isEmpty() == false) goto L9;
    L53:
        return null;
    }

    public final AiLabViewModel Y90() {
        return (AiLabViewModel) this.i.getValue();
    }

    public final void Z90() {
        LarusDoraPageAiLabBinding r0 = this.f;
        if (r0 == null) goto L16;
        com.larus.dora.impl.device.ailab.a r1 = (com.larus.dora.impl.device.ailab.a) Y90().getAbilityStateFlow().getValue();
        int r2 = 0;
        if (r1 == null) goto L9;
        boolean r3 = true;
        if (r1.f != true) goto L9;
    L10:
        AppCompatTextView r4 = r0.u;
        if (Y90().isDoreE() == true) goto L13;
        if (r3 == true) goto L13;
    L14:
        r4.setVisibility(r2);
        Unit r5 = Unit.INSTANCE;
        return;
    L13:
        r2 = 8;
    L9:
        r3 = false;
        goto L10
    }

    public AiLabFragment() {
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.i = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AiLabViewModel.class), new AiLabFragment$special$$inlined$activityViewModels$default$1(this), new AiLabFragment$special$$inlined$activityViewModels$default$2(this));
        this.j = LazyKt.lazy(new com.larus.dora.impl.device.ailab.c());
        this.l = LazyKt.lazy(new com.larus.dora.impl.device.ailab.g());
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
        LarusDoraPageAiLabBinding r0 = this.f;
        if (r0 == null) goto L9;
        ItemTextToggle r1 = r0.t;
        if (r1 == null) goto L9;
        CustomSwitchCompat r2 = r1.getToggleView();
        if (r2 == null) goto L9;
        boolean r3 = r2.isChecked();
    L10:
        LarusDoraPageAiLabBinding r4 = this.f;
        if (r4 == null) goto L17;
        ItemTextToggle r5 = r4.w;
        if (r5 == null) goto L17;
        CustomSwitchCompat r6 = r5.getToggleView();
        if (r6 == null) goto L17;
        boolean r7 = r6.isChecked();
    L18:
        DoraBuryPointManager r8 = DoraBuryPointManager.a;
        Pair[] r9 = new Pair[2];
        String r10 = "on";
        if (r3 == false) goto L21;
        Object r11 = "on";
    L22:
        r9[0] = TuplesKt.to("voice_wakeup", r11);
        if (r7 == true) goto L26;
        r10 = "off";
    L26:
        r9[1] = TuplesKt.to("multi_user_mode", r10);
        r8.L("dora_ai_lab_settings", MapsKt.mapOf(r9));
        return;
    L21:
        r11 = "off";
    L17:
        r7 = false;
    L9:
        r3 = false;
        goto L10
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (Y90().isDoraG() == true) goto L6;
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new l(this));
        return;
    }

    public static final void W90(AiLabFragment r5, List r6) {
        LarusDoraPageAiLabBinding r0 = r5.f;
        if (r0 == null) goto L44;
        com.larus.dora.impl.device.ailab.a r1 = (com.larus.dora.impl.device.ailab.a) r5.Y90().getAbilityStateFlow().getValue();
        boolean r2 = true;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L16;
        r0.i.T5();
        r0.m.T5();
        r0.i.setSelected(false);
        r0.m.setSelected(false);
        ItemTextSelector r7 = r0.i;
        r7.c = true;
        r7.d.setImageResource(2131240388);
        r7.d.setVisibility(0);
        ItemTextSelector r8 = r0.m;
        if (((Boolean) r5.Y90().getBudsQuickContinuousConversationSwitchStateFlow().getValue()).booleanValue() == false) goto L14;
        int r9 = 2131240385;
    L15:
        r8.c = true;
        r8.d.setImageResource(r9);
        r8.d.setVisibility(0);
        return;
    L14:
        r9 = 2131240384;
        goto L15
    L16:
        r0.i.T5();
        r0.m.T5();
        List r10 = r6;
        if ((r10 instanceof Collection) == true) goto L19;
    L21:
        Iterator r11 = r10.iterator();
    L23:
        if (r11.hasNext() == false) goto L32;
        t r12 = (t) r11.next();
        String r4 = r12.d;
        Lazy<String> r13 = t.h;
        if (Intrinsics.areEqual(r4, t.a.a()) == true) goto L27;
    L29:
        boolean r14 = false;
    L30:
        if (r14 == false) goto L23;
    L33:
        ItemGroup r15 = r0.l;
        if (r2 == false) goto L36;
        ItemTextSelector r16 = r0.h;
    L37:
        Intrinsics.checkNotNull(r16);
        r15.b(r16);
        return;
    L36:
        r16 = r0.i;
        goto L37
    L27:
        if (r12.f == false) goto L29;
        r14 = true;
    L32:
        r2 = false;
        goto L33
    L19:
        if (r10.isEmpty() == false) goto L21;
    L7:
        if (r1.f != true) goto L9;
        r3 = true;
        goto L10
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        LarusDoraPageAiLabBinding r1 = this.f;
        if (r1 == null) goto L13;
        NovaTitleBarEx r3 = r1.y;
        DoraDevice r2 = DoraAdapterExtKt.h(kj4.a.g());
        if (r2 == null) goto L7;
        Integer r4 = Integer.valueOf(r2.productId);
    L9:
        if (o59.a.o(r4) == false) goto L11;
        int r5 = 2131903995;
    L12:
        NovaTitleBarEx.Y5(r3, getString(r5), null, null, 6);
        NovaTitleBarEx.b6(r3, 2131240517, false, null, null, new k(this), 14);
        goto L13
    L11:
        r5 = 2131903993;
        goto L12
    L7:
        r4 = null;
    L13:
        final LarusDoraPageAiLabBinding r6 = this.f;
        if (r6 == null) goto L28;
        ItemGroupTitle r7 = r6.s;
        int r8 = 8;
        if (Y90().isDoreE() == false) goto L18;
        int r9 = 8;
    L19:
        r7.setVisibility(r9);
        ItemGroup r10 = r6.r;
        if (Y90().isDoreE() == true) goto L23;
        r8 = 0;
    L23:
        r10.setVisibility(r8);
        Z90();
        r6.t.getToggleView().setOnCheckedChangeListener(new m(this, r6));
        r6.w.getToggleView().setOnCheckedChangeListener(new n(this));
        e1.d(r6.h, new o(this));
        e1.d(r6.i, new com.larus.dora.impl.device.ailab.d(this));
        e1.d(r6.m, new com.larus.dora.impl.device.ailab.e(this));
        if (Y90().isDoraG() == false) goto L26;
        e1.o(r6.c);
    L27:
        e1.y(r6.p, Y90().isDoraG());
        e1.y(r6.q, Y90().isDoraG());
        Unit r11 = Unit.INSTANCE;
        goto L28
    L26:
        e1.y(r6.c, ((Boolean) this.l.getValue()).booleanValue());
        final ItemTextArrow r12 = r6.b;
        b0.a.getClass();
        int r13 = b0.c();
        StringBuilder r14 = new StringBuilder();
        r14.append(r13);
        r14.append('s');
        String r15 = r14.toString();
        int r16 = ItemTextArrow.k;
        r12.Z5(r15, null);
        e1.d(r12, new com.larus.dora.impl.device.ailab.f(r12, this));
        Intrinsics.checkNotNull(r12);
        goto L27
    L18:
        r9 = 0;
    L28:
        AiLabViewModel r17 = Y90();
        Bundle r18 = getArguments();
        if (r18 == null) goto L31;
        String r22 = r18.getString("mac");
    L32:
        r17.updateCurrentDoraDeviceMac(r22);
        Lifecycle.State r23 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r23, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r23, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r23, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r23, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r23, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$6(this, r23, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$7(this, r23, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiLabFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$8(this, r23, null, this), 3, null);
        return;
    L31:
        r22 = null;
        goto L32
    }

    public final View onCreateView(LayoutInflater r30, ViewGroup r31, Bundle r32) {
        Intrinsics.checkNotNullParameter(r30, "inflater");
        ConstraintLayout r0 = r30.inflate(2131562254, r31, false);
        int r1 = 2131369440;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r0, 2131369440);
        if (r5 == null) goto L55;
        r1 = 2131369441;
        ItemGroup r6 = ViewBindings.findChildViewById(r0, 2131369441);
        if (r6 == null) goto L55;
        r1 = 2131369443;
        ItemGroup r7 = ViewBindings.findChildViewById(r0, 2131369443);
        if (r7 == null) goto L55;
        r1 = 2131369444;
        ItemTextToggle r8 = ViewBindings.findChildViewById(r0, 2131369444);
        if (r8 == null) goto L55;
        r1 = 2131369445;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r0, 2131369445);
        if (r9 == null) goto L55;
        r1 = 2131369446;
        ItemTextToggle r10 = ViewBindings.findChildViewById(r0, 2131369446);
        if (r10 == null) goto L55;
        r1 = 2131369666;
        ItemTextSelector r11 = ViewBindings.findChildViewById(r0, 2131369666);
        if (r11 == null) goto L55;
        r1 = 2131369667;
        ItemTextSelector r12 = ViewBindings.findChildViewById(r0, 2131369667);
        if (r12 == null) goto L55;
        r1 = 2131369668;
        AppCompatTextView r13 = ViewBindings.findChildViewById(r0, 2131369668);
        if (r13 == null) goto L55;
        r1 = 2131369669;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131369669);
        if (r14 == null) goto L55;
        r1 = 2131369670;
        ItemGroup r15 = ViewBindings.findChildViewById(r0, 2131369670);
        if (r15 == null) goto L55;
        r1 = 2131369671;
        ItemTextSelector r16 = ViewBindings.findChildViewById(r0, 2131369671);
        if (r16 == null) goto L55;
        r1 = 2131369962;
        View r17 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r17 == null) goto L55;
        r1 = 2131369963;
        ItemTextToggle r18 = ViewBindings.findChildViewById(r0, 2131369963);
        if (r18 == null) goto L55;
        r1 = 2131369964;
        ItemGroup r110 = ViewBindings.findChildViewById(r0, 2131369964);
        if (r110 == null) goto L55;
        r1 = 2131369965;
        AppCompatTextView r20 = ViewBindings.findChildViewById(r0, 2131369965);
        if (r20 == null) goto L55;
        r1 = 2131370040;
        ItemGroup r21 = ViewBindings.findChildViewById(r0, 2131370040);
        if (r21 == null) goto L55;
        r1 = 2131370041;
        ItemGroupTitle r22 = ViewBindings.findChildViewById(r0, 2131370041);
        if (r22 == null) goto L55;
        r1 = 2131370042;
        ItemTextToggle r23 = ViewBindings.findChildViewById(r0, 2131370042);
        if (r23 == null) goto L55;
        r1 = 2131370043;
        AppCompatTextView r24 = ViewBindings.findChildViewById(r0, 2131370043);
        if (r24 == null) goto L55;
        r1 = 2131380464;
        ItemGroup r25 = ViewBindings.findChildViewById(r0, 2131380464);
        if (r25 == null) goto L55;
        r1 = 2131380465;
        ItemTextToggle r26 = ViewBindings.findChildViewById(r0, 2131380465);
        if (r26 == null) goto L55;
        r1 = 2131380466;
        AppCompatTextView r27 = ViewBindings.findChildViewById(r0, 2131380466);
        if (r27 == null) goto L55;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L55;
        r1 = 2131388772;
        NovaTitleBarEx r28 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r28 == null) goto L55;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageAiLabBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        return r2;
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
