package com.bytedance.ai.utils;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final long a;
    public final CoroutineScope b;
    public Job c;

    public d() {
        MainCoroutineDispatcher r0 = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(r0, "context");
        this.a = 500;
        this.b = CoroutineScopeKt.CoroutineScope(r0);
    }

    public final void a(Object r10, Function2 r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        if (CoroutineScopeKt.isActive(this.b) == true) goto L6;
        g.a.e("CoroutineDebouncer", "Debouncer is canceled");
        return;
    L6:
        Job r0 = this.c;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        this.c = BuildersKt.launch$default(this.b, null, null, new CoroutineDebouncer$debounce$2(this, r11, r10, null), 3, null);
    }
}
