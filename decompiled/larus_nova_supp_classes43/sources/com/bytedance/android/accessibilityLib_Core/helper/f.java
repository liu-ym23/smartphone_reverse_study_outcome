package com.bytedance.android.accessibilityLib_Core.helper;

import com.bytedance.android.accessibilityLib_Core.base.api.AbstractAccessibilityLibIsolation$appWindowEventListener$2$a;
import java.lang.ref.WeakReference;
import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<T> implements Predicate<WeakReference<AppWindows.a>> {
    public final /* synthetic */ AppWindows.a a;

    public f(AbstractAccessibilityLibIsolation$appWindowEventListener$2$a r1) {
        this.a = r1;
    }

    @Override // java.util.function.Predicate
    public final boolean test(WeakReference<AppWindows.a> r10) {
        return Intrinsics.areEqual(r10.get(), this.a);
    }
}
