package com.larus.utils;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ Ref.ObjectRef a;
    public final /* synthetic */ CoroutineScope b;
    public final /* synthetic */ CoroutineContext c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Function1 e;

    public /* synthetic */ j(Ref.ObjectRef r1, LifecycleCoroutineScope r2, CoroutineDispatcher r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = 300;
        this.e = r4;
    }

    public final Object invoke() {
        Ref.ObjectRef r0 = this.a;
        CoroutineScope r1 = this.b;
        CoroutineContext r2 = this.c;
        long r3 = this.d;
        Function1 r5 = this.e;
        Job r6 = (Job) r0.element;
        if (r6 == null) goto L5;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L5:
        r0.element = BuildersKt.launch$default(r1, r2, null, new CoroutineScopeExtKt$debounceCoroutine$1$1(r3, r5, null), 2, null);
        return Unit.INSTANCE;
    }
}
