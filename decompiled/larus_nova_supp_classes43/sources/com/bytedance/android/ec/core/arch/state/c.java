package com.bytedance.android.ec.core.arch.state;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.core.utils.a0;
import com.bytedance.android.ec.core.utils.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final <S extends b, A> void a(QStateViewModel<S> r10, LifecycleOwner r11, final KProperty1<S, ? extends A> r12, Function1<? super A, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$observeStateProperty");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "prop1");
        Intrinsics.checkNotNullParameter(r13, "action");
        StateRepository<S> r14 = r10.getRepository$ec_core_saasRelease();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "prop1");
        Intrinsics.checkNotNullParameter(r13, "action");
        MutableLiveData r15 = r14.a.e;
        Function1<b, f<Object>> r0 = new StateRepository$observePartOfState$1(r12);
        Intrinsics.checkNotNullParameter(r15, "$this$map");
        Intrinsics.checkNotNullParameter(r0, "mapFunction");
        int r16 = b0.a;
        Intrinsics.checkNotNullParameter(r15, "source");
        Intrinsics.checkNotNullParameter(r0, "switchMapFunction");
        LiveData r17 = Transformations.map(r15, new a0(r0));
        Intrinsics.checkNotNullParameter(r17, "$this$distinctUntilChanged");
        final MediatorLiveData r18 = new MediatorLiveData();
        r18.addSource(r17, new LivedataKt$transformationsDistinctUntilChanged$1(r18));
        r18.observe(r11, new d(r13));
    }
}
