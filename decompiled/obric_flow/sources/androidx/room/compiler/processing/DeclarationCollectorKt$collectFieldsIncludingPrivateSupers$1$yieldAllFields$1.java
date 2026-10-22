package androidx.room.compiler.processing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.compiler.processing.DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1", f = "DeclarationCollector.kt", i = {0, 0, 0}, l = {31, 34}, m = "invokeSuspend$yieldAllFields", n = {"$this$invokeSuspend_u24yieldAllFields", "existingFieldNames", "type"}, s = {"L$0", "L$1", "L$2"})
public final class DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1$yieldAllFields$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1$yieldAllFields$1(Continuation<? super DeclarationCollectorKt$collectFieldsIncludingPrivateSupers$1$yieldAllFields$1> r5) {
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return DeclarationCollectorKt.C00971.access$invokeSuspend$yieldAllFields(null, null, null, this);
    }
}
