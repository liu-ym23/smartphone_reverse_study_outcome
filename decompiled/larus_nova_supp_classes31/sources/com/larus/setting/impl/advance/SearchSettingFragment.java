package com.larus.setting.impl.advance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.setting.impl.SettingModel;
import com.larus.setting.impl.databinding.LarusPageSettingSearchBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/setting/impl/advance/SearchSettingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/setting/impl/databinding/LarusPageSettingSearchBinding;", "model", "Lcom/larus/setting/impl/SettingModel;", "getModel", "()Lcom/larus/setting/impl/SettingModel;", "model$delegate", "Lkotlin/Lazy;", "pageTrace", "Lcom/bytedance/apm/trace/PageLoadTrace;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViewModel", "setGroupEnable", "enable", "", "(Z)Lkotlin/Unit;", "onResume", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SearchSettingFragment extends Fragment {
    public static final /* synthetic */ int g = 0;
    public LarusPageSettingSearchBinding d;
    public final Lazy e;
    public final ct3.b f;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(k r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public final SettingModel S90() {
        return (SettingModel) this.e.getValue();
    }

    public SearchSettingFragment() {
        final Function0<Fragment> r0 = new SearchSettingFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingModel.class), new SearchSettingFragment$special$$inlined$viewModels$default$2(r0), new SearchSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.f = new ct3.b("SearchSettingFgt");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onResume() {
        super.onResume();
        this.f.a(1, -1);
    }

    public final void T90(boolean r4) {
        final LarusPageSettingSearchBinding r0 = this.d;
        if (r0 == null) goto L16;
        r0.j.setEnabled(r4);
        r0.j.getToggleView().setChecked(S90().getSugAllEnabled());
        r0.j.getToggleView().setOnCheckedChangeListener(new l(this));
        r0.k.setEnabled(r4);
        r0.k.getToggleView().setChecked(S90().getSugSearchEnabled());
        r0.k.getToggleView().setOnCheckedChangeListener(new m(this));
        int r1 = S90().getEngineType();
        if (r1 != 1) goto L7;
        r0.l.b(r0.c);
    L14:
        r0.d.setEnabled(r4);
        r0.d.setOnClickListener(new n(r0, this));
        r0.b.setEnabled(r4);
        r0.b.setOnClickListener(new o(r0, this));
        r0.c.setEnabled(r4);
        r0.c.setOnClickListener(new f(r0, this));
        Unit r5 = Unit.INSTANCE;
        return;
    L7:
        if (r1 != 2) goto L9;
        r0.l.b(r0.b);
        goto L14
    L9:
        if (r1 != 4) goto L14;
        r0.l.b(r0.d);
        goto L14
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.f.b();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.setting.impl.advance.k] */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        final LarusPageSettingSearchBinding r13 = this.d;
        if (r13 == null) goto L27;
        NovaTitleBarEx.Y5(r13.m, getString(2131909084), null, null, 6);
        NovaTitleBarEx.b6(r13.m, 2131241477, false, null, null, new e(this), 14);
        r13.i.getToggleView().setChecked(S90().getShowCardSearch());
        r13.i.getToggleView().setOnCheckedChangeListener(new g(this));
        boolean r0 = false;
        if (S90().isInputSuggestEnable() == false) goto L7;
    L10:
        boolean r14 = true;
    L11:
        T90(r14);
        if (AppHost.a.isOversea() == false) goto L14;
        r13.d.setVisibility(8);
        S90().setEngineType(1);
    L16:
        if (S90().isInputSuggestEnable() == false) goto L18;
    L19:
        r0 = true;
    L20:
        T90(r0);
        r13.h.setEnabled(S90().isHighlightEnabled());
        r13.e.setEnabled(S90().isHighlightEnabled());
        r13.g.setEnabled(S90().isHighlightEnabled());
        r13.h.getToggleView().setChecked(S90().isHighlightGoWebview());
        r13.h.getToggleView().setOnCheckedChangeListener(new h(this));
        String r15 = S90().getHighlightEngine();
        if (Intrinsics.areEqual(r15, "1") == false) goto L24;
        r13.f.b(r13.e);
    L26:
        r13.e.setOnClickListener(new i(this, r13));
        r13.g.setOnClickListener(new j(this, r13));
        goto L27
    L24:
        if (Intrinsics.areEqual(r15, "2") == false) goto L26;
        r13.f.b(r13.g);
        goto L26
    L18:
        if (S90().getShowCardSearch() == false) goto L20;
    L14:
        r13.d.setVisibility(0);
        goto L16
    L7:
        if (S90().getShowCardSearch() == true) goto L10;
        r14 = false;
    L27:
        S90().getHighlightEngineLiveData().observe(getViewLifecycleOwner(), new a(new k()));
    }

    public final View onCreateView(LayoutInflater r18, ViewGroup r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r18, "inflater");
        View r0 = r18.inflate(2131563070, r19, false);
        int r1 = 2131371663;
        ItemTextSelector r5 = ViewBindings.findChildViewById(r0, 2131371663);
        if (r5 == null) goto L35;
        r1 = 2131371664;
        ItemTextSelector r6 = ViewBindings.findChildViewById(r0, 2131371664);
        if (r6 == null) goto L35;
        r1 = 2131371665;
        ItemTextSelector r7 = ViewBindings.findChildViewById(r0, 2131371665);
        if (r7 == null) goto L35;
        r1 = 2131374355;
        ItemTextSelector r8 = ViewBindings.findChildViewById(r0, 2131374355);
        if (r8 == null) goto L35;
        r1 = 2131374356;
        ItemGroup r9 = ViewBindings.findChildViewById(r0, 2131374356);
        if (r9 == null) goto L35;
        r1 = 2131374357;
        ItemTextSelector r10 = ViewBindings.findChildViewById(r0, 2131374357);
        if (r10 == null) goto L35;
        LinearLayout r2 = (LinearLayout) r0;
        int r3 = 2131382856;
        if (ViewBindings.findChildViewById(r0, 2131382856) == null) goto L37;
        r3 = 2131382857;
        if (ViewBindings.findChildViewById(r0, 2131382857) == null) goto L37;
        r3 = 2131382858;
        ItemTextToggle r11 = ViewBindings.findChildViewById(r0, 2131382858);
        if (r11 == null) goto L37;
        r3 = 2131382862;
        ItemTextToggle r12 = ViewBindings.findChildViewById(r0, 2131382862);
        if (r12 == null) goto L37;
        r3 = 2131382865;
        ItemTextToggle r13 = ViewBindings.findChildViewById(r0, 2131382865);
        if (r13 == null) goto L37;
        r3 = 2131382866;
        ItemTextToggle r14 = ViewBindings.findChildViewById(r0, 2131382866);
        if (r14 == null) goto L37;
        r3 = 2131385238;
        if (ViewBindings.findChildViewById(r0, 2131385238) == null) goto L37;
        r3 = 2131385423;
        ItemGroup r15 = ViewBindings.findChildViewById(r0, 2131385423);
        if (r15 == null) goto L37;
        r3 = 2131388772;
        NovaTitleBarEx r16 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r16 == null) goto L37;
        this.d = new LarusPageSettingSearchBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        return r2;
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r3)));
    L35:
        r3 = r1;
        goto L37
    }
}
