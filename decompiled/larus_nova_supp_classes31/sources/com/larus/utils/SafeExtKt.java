package com.larus.utils;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class SafeExtKt {
    public static /* synthetic */ void b(View r1, Function0 r2, long r3) {
        a(r1, r2, r3, Dispatchers.getMain());
    }

    public static void c(Fragment r2, Function0 r3, long r4) {
        MainCoroutineDispatcher r0 = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r0, "dispatcher");
        View r5 = r2.getView();
        if (r5 == null) goto L6;
        a(r5, r3, r4, r0);
        return;
    }

    public static final void a(View r6, Function0<Unit> r7, long r8, CoroutineDispatcher r10) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "action");
        Intrinsics.checkNotNullParameter(r10, "dispatcher");
        LifecycleOwner r9 = ViewTreeLifecycleOwner.get(r6);
        if (r9 == null) goto L8;
        LifecycleCoroutineScope r0 = LifecycleOwnerKt.getLifecycleScope(r9);
        if (r0 == null) goto L9;
        BuildersKt.launch$default(r0, r10, null, new SafeExtKt$safePostDelay$1(r7, r8, null), 2, null);
        return;
    L9:
        return;
    }
}
