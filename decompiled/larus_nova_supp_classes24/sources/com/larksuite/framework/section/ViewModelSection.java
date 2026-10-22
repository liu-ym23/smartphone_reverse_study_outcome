package com.larksuite.framework.section;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\rH&JU\u0010\u0014\u001a\u00020\r2M\u0010\u0015\u001aI\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/larksuite/framework/section/ViewModelSection;", "M", "Landroidx/lifecycle/ViewModel;", "Lcom/larksuite/framework/section/IActionHandler;", "viewModelAbility", "Lcom/larksuite/framework/section/IViewModelAbility;", "<init>", "(Lcom/larksuite/framework/section/IViewModelAbility;)V", "modelData", "getModelData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initViewModel", "", "getModelStore", "getContext", "Landroid/content/Context;", "getFragment", "Landroidx/fragment/app/Fragment;", "initViewData", "registerActivityResult", "block", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onStop", "onDestroy", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class ViewModelSection<M> extends ViewModel {
    private final M modelData;
    private final f<M> viewModelAbility;

    public abstract void initViewData();

    public void initViewModel() {
    }

    public void onDestroy() {
    }

    public void onStop() {
    }

    public final Context getContext() {
        return this.viewModelAbility.provideContext();
    }

    public final Fragment getFragment() {
        return this.viewModelAbility.f();
    }

    public final M getModelStore() {
        return this.viewModelAbility.d();
    }

    public final M getModelData() {
        return this.modelData;
    }

    public ViewModelSection(f<M> r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModelAbility");
        this.viewModelAbility = r2;
        this.modelData = r2.d();
    }

    public void handleAction(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    public final void registerActivityResult(Function3<? super Integer, ? super Integer, ? super Intent, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.viewModelAbility.g(r2);
    }

    public void handleAction(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "actionData");
    }

    public void handleViewAction(int r1, com.ss.android.lark.todo.impl.features.detail.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    public void handleAction(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "actionData");
    }

    public void handleAction(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "action");
    }

    public void handleAction(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "action");
    }

    public void handleAction(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "action");
    }
}
