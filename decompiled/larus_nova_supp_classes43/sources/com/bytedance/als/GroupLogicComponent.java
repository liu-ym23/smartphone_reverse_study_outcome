package com.bytedance.als;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.als.b;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Deprecated(message = "deprecated")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/als/GroupLogicComponent;", "Lcom/bytedance/als/b;", "T", "Lcom/bytedance/als/LogicComponent;", "Landroidx/lifecycle/ViewModelStoreOwner;", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class GroupLogicComponent<T extends b> extends LogicComponent<T> implements ViewModelStoreOwner {
    public ViewModelStore c;

    /* JADX INFO: renamed from: com.bytedance.als.GroupLogicComponent$getViewModelStore$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(GroupLogicComponent r10) {
            super(r10, GroupLogicComponent.class, "viewModelStore", "getViewModelStore()Landroidx/lifecycle/ViewModelStore;", 0);
        }

        public Object get() {
            ViewModelStore r0 = ((GroupLogicComponent) ((CallableReference) this).receiver).c;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
        L5:
            return r0;
        }

        public void set(Object r10) {
            ViewModelStore r11 = (ViewModelStore) r10;
            ((GroupLogicComponent) ((CallableReference) this).receiver).c = r11;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.als.GroupLogicComponent$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    final /* synthetic */ class C02231 extends MutablePropertyReference0Impl {
        public C02231(GroupLogicComponent r10) {
            super(r10, GroupLogicComponent.class, "viewModelStore", "getViewModelStore()Landroidx/lifecycle/ViewModelStore;", 0);
        }

        public Object get() {
            ViewModelStore r0 = ((GroupLogicComponent) ((CallableReference) this).receiver).c;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
        L5:
            return r0;
        }

        public void set(Object r10) {
            ViewModelStore r11 = (ViewModelStore) r10;
            ((GroupLogicComponent) ((CallableReference) this).receiver).c = r11;
        }
    }

    public final ViewModelStore getViewModelStore() {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.INITIALIZED) == false) goto L12;
        if (this.c != null) goto L7;
        this.c = new ViewModelStore();
    L7:
        ViewModelStore r0 = this.c;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
    L10:
        return r0;
    L12:
        throw new IllegalStateException("can't access ViewModels when component is destroyed");
    }

    @Override // com.bytedance.als.LogicComponent
    public final void onDestroy() {
        super.onDestroy();
        ViewModelStore r0 = this.c;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModelStore");
    L6:
        r0.clear();
        return;
    }
}
