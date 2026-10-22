package com.larksuite.framework.section;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LkViewModelUtilsKt;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.todo.impl.features.detail.TodoDetailFragment;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.TodoDetailModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g<T, M extends T> implements e<T>, f<M> {
    public final d a;
    public final M b;
    public final List<h<T>> c;
    public final List<ViewModelSection<M>> d;
    public final Lazy e;
    public final List<Function3<Integer, Integer, Intent, Unit>> f;

    @Override // com.larksuite.framework.section.e
    public final LifecycleOwner b() {
        return this.a.getLifecycleOwner();
    }

    @Override // com.larksuite.framework.section.e
    public final c c() {
        return (c) this.e.getValue();
    }

    @Override // com.larksuite.framework.section.a
    public final BaseFragment f() {
        return this.a.getFragment();
    }

    @Override // com.larksuite.framework.section.a
    public final Context provideContext() {
        return this.a.getContext();
    }

    @Override // com.larksuite.framework.section.e
    public final T a() {
        return this.b;
    }

    @Override // com.larksuite.framework.section.f
    public final M d() {
        return this.b;
    }

    public final void e(Function1<? super f<M>, ? extends ViewModelSection<M>> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        ViewModelSection r4 = (ViewModelSection) r3.invoke(this);
        ((ArrayList) this.d).add(r4);
        r4.initViewModel();
        r4.initViewData();
        LkViewModelUtilsKt.putViewModel(this.a.getViewModelStore(), r4.getClass().getName(), r4);
    }

    @Override // com.larksuite.framework.section.a
    public final void g(Function3<? super Integer, ? super Integer, ? super Intent, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        ((ArrayList) this.f).add(r2);
    }

    public final void h(Function1<? super e<T>, ? extends h<T>> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        h r3 = (h) r2.invoke(this);
        ((ArrayList) this.c).add(r3);
        r3.j();
        r3.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(TodoDetailFragment.sectionManager.2.a r2, TodoDetailModel r3) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = LazyKt.lazy(new SectionManager$dispatcher$2(this));
        this.f = new ArrayList();
    }
}
