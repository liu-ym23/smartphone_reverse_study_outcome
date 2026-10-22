package org.koin.androidx.viewmodel.parameter;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends vu.a {
    public final CreationExtras d;

    public a(Function0 r5, CreationExtras r10) {
        Intrinsics.checkNotNullParameter(r10, "extras");
        if (r5 == null) goto L10;
        vu.a r11 = (vu.a) r5.invoke();
        if (r11 == null) goto L10;
        List r12 = r11.f22651a;
        if (r12 == null) goto L10;
        List r13 = CollectionsKt.toMutableList(r12);
        if (r13 == null) goto L10;
    L11:
        super(r13, 2);
        this.d = r10;
        return;
    L10:
        r13 = new ArrayList();
        goto L11
    }

    public static final /* synthetic */ Object c(a r5, KClass r10) {
        return super.b(r10);
    }

    @Override // vu.a
    public final Object b(final KClass r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Function0<Object> r10 = new AndroidParametersHolder$getOrNull$1(this, r5);
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(SavedStateHandle.class)) == false) goto L6;
        return SavedStateHandleSupport.createSavedStateHandle(this.d);
    L6:
        return r10.invoke();
    }
}
