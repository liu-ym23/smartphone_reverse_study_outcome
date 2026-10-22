package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PausingDispatcherKt {
    public static final <T> Object a(Lifecycle r10, Lifecycle.State r11, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r12, Continuation<? super T> r13) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new PausingDispatcherKt$whenStateAtLeast$2(r10, r11, r12, null), r13);
    }
}
