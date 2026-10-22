package com.bytedance.android.ec.core.arch.viewmodel;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final c a(FragmentActivity r1, KClass r10, Function0 r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r1, "$this$createViewModelLazy");
        Intrinsics.checkNotNullParameter(r10, "viewModelClass");
        Intrinsics.checkNotNullParameter(r11, "storeProducer");
        Intrinsics.checkNotNullParameter(r12, "factoryProducer");
        return new c(r10, r11, r12);
    }
}
