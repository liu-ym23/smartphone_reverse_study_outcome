package com.larus.bot.impl.feature.edit.feature.datamodel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bot.impl.databinding.LarusPageDataModelSettingBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000f\u0010*\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0002\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/datamodel/DataModelSettingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageDataModelSettingBinding;", "model", "Lcom/larus/bot/impl/feature/edit/feature/datamodel/DataModelSettingViewModel;", "getModel", "()Lcom/larus/bot/impl/feature/edit/feature/datamodel/DataModelSettingViewModel;", "model$delegate", "Lkotlin/Lazy;", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "initModel", "", "uiMode", "", "currentModel", "Lcom/larus/im/bean/bot/ModelItem;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupDataModel", "()Lkotlin/Unit;", "newDataModelItem", "Lcom/larus/bmhome/view/item/ItemTextSelector;", "data", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataModelSettingFragment extends Fragment {
    public static final /* synthetic */ int k = 0;
    public LarusPageDataModelSettingBinding d;
    public final Lazy e;
    public BotModel f;
    public String g;
    public boolean h;
    public ModelItem i;
    public final Lazy j;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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

    static {
    }

    public DataModelSettingFragment() {
        final Function0<Fragment> r0 = new DataModelSettingFragment$special$$inlined$viewModels$default$1(this);
        this.e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DataModelSettingViewModel.class), new DataModelSettingFragment$special$$inlined$viewModels$default$2(r0), new DataModelSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = "";
        this.j = LazyKt.lazy(new com.larus.bot.impl.feature.edit.feature.datamodel.b(this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (getArguments() != null) goto L7;
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L15;
        r4.finish();
        return;
    L15:
        return;
    L7:
        Bundle r5 = getArguments();
        if (r5 == null) goto L17;
        BotModel r0 = r5.getSerializable("select_model_argument");
        if ((r0 instanceof BotModel) == false) goto L12;
        BotModel r1 = r0;
    L13:
        this.f = r1;
        this.g = r5.getString("key_initial_model");
        this.h = r5.getBoolean("key_ui_mode", false);
        return;
    L12:
        r1 = null;
        goto L13
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LarusPageDataModelSettingBinding r10 = this.d;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.c;
        NovaTitleBarEx.Y5(r0, getString(2131900240), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131241477, false, null, null, new com.larus.bot.impl.feature.edit.feature.datamodel.a(this), 14);
    L5:
        final LarusPageDataModelSettingBinding r11 = this.d;
        if (r11 == null) goto L13;
        ((DataModelSettingViewModel) this.e.getValue()).getDataModels().observe(getViewLifecycleOwner(), new b(new c(r11, this)));
        if (this.h == true) goto L11;
        ((DataModelSettingViewModel) this.e.getValue()).getModelSelect().observe(getViewLifecycleOwner(), new b(new d(r11, this)));
        ((DataModelSettingViewModel) this.e.getValue()).getModelUpdate().observe(getViewLifecycleOwner(), new b(new e(this)));
    L11:
        Unit r12 = Unit.INSTANCE;
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131563031, r3, false);
        int r6 = 2131368533;
        ItemGroup r7 = (ItemGroup) ViewBindings.findChildViewById(r5, 2131368533);
        if (r7 == null) goto L13;
        r6 = 2131384827;
        if (((LinearLayout) ViewBindings.findChildViewById(r5, 2131384827)) == null) goto L13;
        r6 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r5, 2131385238)) == null) goto L13;
        r6 = 2131388772;
        NovaTitleBarEx r0 = (NovaTitleBarEx) ViewBindings.findChildViewById(r5, 2131388772);
        if (r0 == null) goto L13;
        LinearLayout r8 = (LinearLayout) r5;
        this.d = new LarusPageDataModelSettingBinding(r8, r7, r0);
        return r8;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
