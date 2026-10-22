package com.larksuite.rucket.core;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.rucket.core.proxymethod.a;
import com.larksuite.rucket.core.proxymethod.c;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.rucket.core.RucketImpl$getProxyMethod$2$1", f = "RucketImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RucketImpl$getProxyMethod$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<a> $cont;
    final /* synthetic */ Method $method;
    final /* synthetic */ Ref.ObjectRef<a> $result;
    int label;
    final /* synthetic */ RucketImpl this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public RucketImpl$getProxyMethod$2$1(Ref.ObjectRef<a> r1, RucketImpl r2, Method r3, i<? super a> r4, Continuation<? super RucketImpl$getProxyMethod$2$1> r5) {
        this.$result = r1;
        this.this$0 = r2;
        this.$method = r3;
        this.$cont = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new RucketImpl$getProxyMethod$2$1(this.$result, this.this$0, this.$method, this.$cont, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r12);
        long r0 = System.currentTimeMillis();
        Ref.ObjectRef<a> r13 = this.$result;
        RucketImpl r2 = this.this$0;
        Method r3 = this.$method;
        ConcurrentHashMap<KClass<? extends Annotation>, Function1<Method, a>> r4 = r2.d;
        Annotation[] r5 = r3.getAnnotations();
        ArrayList r6 = new ArrayList(r5.length);
        int r7 = r5.length;
        int r9 = 0;
    L5:
        if (r9 >= r7) goto L7;
        r6.add(JvmClassMappingKt.getAnnotationClass(r5[r9]));
        r9 = r9 + 1;
        goto L5
    L7:
        ArrayList r8 = new ArrayList();
        Iterator r10 = r6.iterator();
    L9:
        if (r10.hasNext() == false) goto L14;
        Object r11 = r10.next();
        if (r2.d.keySet().contains((KClass) r11) == false) goto L9;
        r8.add(r11);
        goto L9
    L14:
        if (r8.isEmpty() == false) goto L16;
        KClass r14 = null;
    L17:
        Function1<Method, a> r15 = r4.get(r14);
        if (r15 == null) goto L21;
        Object r16 = (a) r15.invoke(r3);
        if (r16 == null) goto L21;
    L22:
        r13.element = r16;
        Log.d("Rucket", "getProxyMethod: create new proxy method " + this.$method.getName() + ", thread " + ThreadMethodProxy.currentThread() + ", cost " + (System.currentTimeMillis() - r0) + " milliSeconds");
        this.this$0.b.put(this.$method, (a) this.$result.element);
        i<a> r17 = this.$cont;
        Result.Companion r1 = Result.Companion;
        Object r19 = this.$result.element;
        Intrinsics.checkNotNull(r19);
        r17.resumeWith(Result.constructor-impl(r19));
        return Unit.INSTANCE;
    L21:
        r16 = new c();
        goto L22
    L16:
        r14 = (KClass) ListProtector.get(r8, 0);
        goto L17
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
