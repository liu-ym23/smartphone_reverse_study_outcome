package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import android.util.LruCache;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.DataPreloadEngineV2$load$1", f = "DataPreloadEngineV2.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
public final class DataPreloadEngineV2$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ w3b.c<S> $job;
    final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> $loader;
    final /* synthetic */ String $taskKey;
    int label;
    final /* synthetic */ DataPreloadEngineV2 this$0;

    public DataPreloadEngineV2$load$1(com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r1, w3b.c<S> r2, DataPreloadEngineV2 r3, String r4, Continuation<? super DataPreloadEngineV2$load$1> r5) {
        this.$loader = r1;
        this.$job = r2;
        this.this$0 = r3;
        this.$taskKey = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DataPreloadEngineV2$load$1(this.$loader, this.$job, this.this$0, this.$taskKey, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L29:
        ((ReentrantLock) this.this$0.h).lock();     // Catch: Throwable -> L26
        Function1<? super Result<? extends S>, Unit> r2 = this.$job.c;     // Catch: Throwable -> L26
        if (r2 != 0) goto L15;
        Log.i("DataPreloadEngineV2", "Task：" + this.$taskKey + " finish before fetch data, cache result");     // Catch: Throwable -> L26
        ((Map) this.this$0.f.getValue()).put(this.$taskKey, Result.box-impl(r6));     // Catch: Throwable -> L26
    L24:
        ((LruCache) this.this$0.g.getValue()).remove(this.$taskKey);
        ((ReentrantLock) this.this$0.h).unlock();
        return Unit.INSTANCE;
    L15:
        if (Result.isSuccess-impl(r6) == false) goto L17;
        Log.i("DataPreloadEngineV2", "Task：" + this.$taskKey + " finish after fetch data，return result");     // Catch: Throwable -> L26
    L22:
        r2.invoke(Result.box-impl(r6));     // Catch: Throwable -> L26
        goto L24
    L17:
        StringBuilder r3 = new StringBuilder("Task：");     // Catch: Throwable -> L26
        r3.append(this.$taskKey);     // Catch: Throwable -> L26
        r3.append(" finish after fetch data，return error:");     // Catch: Throwable -> L26
        Throwable r4 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L26
        if (r4 == null) goto L20;
        String r7 = r4.getMessage();     // Catch: Throwable -> L26
    L21:
        r3.append(r7);     // Catch: Throwable -> L26
        Log.i("DataPreloadEngineV2", r3.toString());     // Catch: Throwable -> L26
        goto L22
    L20:
        r7 = null;
    L26:
        th = move-exception;
        DataPreloadEngineV2 r8 = this.this$0;
        int r9 = DataPreloadEngineV2.i;
        ((LruCache) r8.g.getValue()).remove(this.$taskKey);
        ((ReentrantLock) this.this$0.h).unlock();
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c<w3b.d<S>, S> r10 = this.$loader;
        Object r11 = this.$job.b;
        this.label = 1;
        r6 = r10.a(r11, this);
        if (r6 != r0) goto L29;
        return r0;
    }
}
