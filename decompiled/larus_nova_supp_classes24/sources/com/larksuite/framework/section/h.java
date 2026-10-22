package com.larksuite.framework.section;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class h<T> {
    public final e<T> a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ Function1<M, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super M, Unit> r1) {
            this.a = r1;
        }

        public final void onChanged(M r2) {
            this.a.invoke(r2);
        }
    }

    public void a() {
    }

    public abstract void i();

    public abstract void j();

    public void l(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
    }

    public void m() {
    }

    public final c b() {
        return this.a.c();
    }

    public final BaseFragment c() {
        return this.a.f();
    }

    public final LifecycleOwner d() {
        return this.a.b();
    }

    public final T e() {
        return this.a.a();
    }

    public final Context getContext() {
        return this.a.provideContext();
    }

    public final Resources getResources() {
        return getContext().getResources();
    }

    public h(e<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "viewAbility");
        this.a = r2;
    }

    public void f(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    public void g(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "action");
    }

    public void h(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "action");
    }

    public final <M> void k(LiveData<M> r3, Function1<? super M, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "block");
        r3.observe(d(), new a(r4));
    }
}
