package com.larus.bmhome.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/bmhome/utils/CommonExtKt$onResumeCallBack$callBack$1", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "onFragmentResumed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonExtKt$onResumeCallBack$callBack$1 extends FragmentManager.FragmentLifecycleCallbacks {
    public final /* synthetic */ KClass<?> a;
    public final /* synthetic */ Function0<Unit> b;
    public final /* synthetic */ FragmentManager c;

    public final void onFragmentResumed(FragmentManager r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        Intrinsics.checkNotNullParameter(r3, "f");
        super.onFragmentResumed(r2, r3);
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r3.getClass()), this.a) == false) goto L6;
        this.b.invoke();
        this.c.unregisterFragmentLifecycleCallbacks(this);
        return;
    }

    public CommonExtKt$onResumeCallBack$callBack$1(KClass r1, com.larus.home.impl.route.v r2, FragmentManager r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
