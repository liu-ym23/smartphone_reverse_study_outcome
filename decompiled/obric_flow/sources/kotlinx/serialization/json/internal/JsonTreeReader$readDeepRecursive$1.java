package kotlinx.serialization.json.internal;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import kotlin.DeepRecursiveScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/DeepRecursiveScope;", "", "Lkotlinx/serialization/json/l;", ST.IMPLICIT_ARG_NAME, "<anonymous>", "(Lkotlin/DeepRecursiveScope;V)Lkotlinx/serialization/json/JsonElement;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, kotlinx.serialization.json.l>, Unit, Continuation<? super kotlinx.serialization.json.l>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ l this$0;

    public JsonTreeReader$readDeepRecursive$1(l r5, Continuation<? super JsonTreeReader$readDeepRecursive$1> r10) {
        this.this$0 = r5;
        super(3, r10);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(DeepRecursiveScope<Unit, kotlinx.serialization.json.l> r5, Unit r10, Continuation<? super kotlinx.serialization.json.l> r11) {
        return invoke2(r5, r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L28:
        return (kotlinx.serialization.json.l) r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        DeepRecursiveScope r12 = (DeepRecursiveScope) this.L$0;
        byte r13 = this.this$0.f19431a.y();
        if (r13 != 1) goto L12;
        return this.this$0.d(true);
    L12:
        if (r13 != 0) goto L15;
        return this.this$0.d(false);
    L15:
        if (r13 != 6) goto L21;
        l r14 = this.this$0;
        this.label = 1;
        r10 = l.a(r14, r12, this);
        if (r10 != r5) goto L28;
        return r5;
    L21:
        if (r13 == 8) goto L23;
        bi.e.q(this.this$0.f19431a, "Can't begin reading element, unexpected token", 0, null, 6);
        throw null;
    L23:
        return this.this$0.c();
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DeepRecursiveScope<Unit, kotlinx.serialization.json.l> r5, Unit r10, Continuation<? super kotlinx.serialization.json.l> r11) {
        JsonTreeReader$readDeepRecursive$1 r12 = new JsonTreeReader$readDeepRecursive$1(this.this$0, r11);
        r12.L$0 = r5;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
