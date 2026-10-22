package org.koin.androidx.viewmodel;

import ai.j0;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.androidx.viewmodel.factory.KoinViewModelFactory;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final ViewModel a(KClass r5, ViewModelStore r10, String r11, CreationExtras r12, wu.a r13, org.koin.core.scope.a r14, Function0 r15) {
        Intrinsics.checkNotNullParameter(r5, "vmClass");
        Intrinsics.checkNotNullParameter(r10, "viewModelStore");
        Intrinsics.checkNotNullParameter(r12, "extras");
        Intrinsics.checkNotNullParameter(r14, "scope");
        Class r16 = JvmClassMappingKt.getJavaClass(r5);
        ViewModelProvider r17 = new ViewModelProvider(r10, new KoinViewModelFactory(r5, r14, r13, r15), r12);
        Intrinsics.checkNotNullParameter(r14, "scope");
        if (r13 != null) goto L8;
        if (r11 != null) goto L8;
        if (r14.f21025c == false) goto L8;
        String r18 = null;
    L19:
        if (r18 == null) goto L22;
        return r17.get(r18, r16);
    L22:
        return r17.get(r16);
    L8:
        String r19 = "";
        if (r13 == null) goto L12;
        String r20 = r13.getValue();
        if (r20 == null) goto L12;
    L13:
        if (r11 != null) goto L16;
        r11 = "";
    L16:
        if (r14.f21025c == true) goto L18;
        r19 = r14.f21024b;
    L18:
        r18 = j0.D(r20, r11, r19);
    L12:
        r20 = "";
        goto L13
    }
}
