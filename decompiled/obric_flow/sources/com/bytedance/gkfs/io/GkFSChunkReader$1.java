package com.bytedance.gkfs.io;

import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Ljava/lang/Runnable;", "Lkotlin/ParameterName;", "name", "task", "invoke"}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class GkFSChunkReader$1 extends FunctionReference implements Function1<Runnable, Unit> {
    public GkFSChunkReader$1() {
        super(1, com.bytedance.gkfs.c.f4816c);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "parallel";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(com.bytedance.gkfs.c.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "parallel(Ljava/lang/Runnable;)V";
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Runnable r5) {
        ((com.bytedance.gkfs.c) this.receiver).getClass();
        ThreadPoolExecutor r10 = com.bytedance.gkfs.c.f4814a;
        r10.execute(r5);
        return Unit.INSTANCE;
    }
}
