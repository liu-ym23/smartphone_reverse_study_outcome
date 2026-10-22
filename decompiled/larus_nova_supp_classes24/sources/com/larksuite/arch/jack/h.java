package com.larksuite.arch.jack;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.j;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h<S extends j, T extends JackViewModel<S>> implements Lazy<T> {
    public final KClass<T> a;
    public final Function0<String> b;
    public final Function0<ViewModelStore> c;
    public final Function0<ViewModelProvider.Factory> d;
    public final Function1<S, S> e;
    public T f;

    public final T a() {
        T r0 = this.f;
        if (r0 != null) goto L6;
        ViewModelProvider.Factory r3 = (ViewModelProvider.Factory) this.d.invoke();
        T r1 = (T) new ViewModelProvider((ViewModelStore) this.c.invoke(), r3, null, 4, null).get((String) this.b.invoke(), JvmClassMappingKt.getJavaClass(this.a));
        this.f = r1;
        r1.initialize(this.e);
        r1.onPrepared();
        return r1;
    L6:
        return r0;
    }

    public final boolean isInitialized() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return a();
    }

    public final String toString() {
        if (isInitialized() == true) goto L7;
        return "Lazy value not initialized yet.";
    L7:
        return a().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(KClass<T> r2, Function0<String> r3, Function0<? extends ViewModelStore> r4, Function0<? extends ViewModelProvider.Factory> r5, Function1<? super S, ? extends S> r6) {
        Intrinsics.checkNotNullParameter(r2, "viewModelClass");
        Intrinsics.checkNotNullParameter(r3, "keyFactory");
        Intrinsics.checkNotNullParameter(r4, "storeProducer");
        Intrinsics.checkNotNullParameter(r5, "factoryProducer");
        Intrinsics.checkNotNullParameter(r6, "argumentsAcceptor");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
