package org.koin.androidx.fragment.android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.koin.core.component.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lorg/koin/androidx/fragment/android/KoinFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "Lorg/koin/core/component/a;", "koin-android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KoinFragmentFactory extends FragmentFactory implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.koin.core.scope.a f20991a;

    public KoinFragmentFactory() {
        this(0);
    }

    public final org.koin.core.a a() {
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // androidx.fragment.app.FragmentFactory
    public final Fragment instantiate(ClassLoader r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "classLoader");
        Intrinsics.checkNotNullParameter(r10, "className");
        KClass r11 = JvmClassMappingKt.getKotlinClass(Class.forName(r10));
        org.koin.core.scope.a r12 = this.f20991a;
        if (r12 == null) goto L5;
        Fragment r13 = (Fragment) r12.c(null, r11, null);
    L6:
        if (r13 == null) goto L8;
        return r13;
    L8:
        return super.instantiate(r5, r10);
    L5:
        org.koin.core.a r14 = a();
        Intrinsics.checkNotNullParameter(r11, "clazz");
        r13 = (Fragment) r14.f20999a.d.c(null, r11, null);
        goto L6
    }

    public KoinFragmentFactory(int r5) {
        this.f20991a = null;
    }
}
