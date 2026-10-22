package com.bytedance.ai.utils;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.internal.c f2844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f2845c;

    public a() {
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f2843a = 500;
        this.f2844b = h0.a(r5);
    }

    public final void a(Integer r10, Function2 r11) {
        Intrinsics.checkNotNullParameter(r11, "action");
        kotlinx.coroutines.internal.c r5 = this.f2844b;
        Job r12 = (Job) r5.getCoroutineContext().get(Job.Key);
        if (r12 == null) goto L5;
        boolean r13 = r12.isActive();
    L6:
        if (r13 == true) goto L11;
        Intrinsics.checkNotNullParameter("CoroutineDebouncer", "tag");
        t0.d r14 = c.f2846a;
        if (r14 == null) goto L16;
        r14.e("CoroutineDebouncer", "Debouncer is canceled");
        return;
    L16:
        return;
    L11:
        Job r15 = this.f2845c;
        if (r15 == null) goto L14;
        r15.cancel(null);
    L14:
        this.f2845c = BuildersKt.launch$default(r5, null, null, new CoroutineDebouncer$debounce$2(this, r11, r10, null), 3, null);
        return;
    L5:
        r13 = true;
        goto L6
    }
}
