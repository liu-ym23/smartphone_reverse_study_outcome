package com.ss.ugc.effectplatform.task.pipline;

import bytekn.foundation.utils.Transmitter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "progress", "p2", "", "contentLength", "invoke"}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class FileWriterPipeLine$doJob$2$hex$1 extends FunctionReference implements Function2<Integer, Long, Unit> {
    public FileWriterPipeLine$doJob$2$hex$1(b r2) {
        super(2, r2);
    }

    public final String getName() {
        return "onProgress";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(b.class);
    }

    public final String getSignature() {
        return "onProgress(IJ)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).intValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r3, long r4) {
        b r0 = (b) ((CallableReference) this).receiver;
        int r1 = b.a;
        r0.getClass();
        Transmitter.a(new c(r0, r3, r4));
    }
}
