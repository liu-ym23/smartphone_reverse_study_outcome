package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "it"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, kotlinx.serialization.json.g>, Unit, Continuation<? super kotlinx.serialization.json.g>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ p this$0;

    JsonTreeReader$readDeepRecursive$1(p r3, Continuation<? super JsonTreeReader$readDeepRecursive$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(3, r5);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(DeepRecursiveScope<Unit, kotlinx.serialization.json.g> r3, Unit r4, Continuation<? super kotlinx.serialization.json.g> r5) {
        return invoke2((DeepRecursiveScope) ZeusTransformUtils.preCheckCast(r3, DeepRecursiveScope.class, "com.obric.memorydata.plugin"), (Unit) ZeusTransformUtils.preCheckCast(r4, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DeepRecursiveScope<Unit, kotlinx.serialization.json.g> r2, Unit r3, Continuation<? super kotlinx.serialization.json.g> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        JsonTreeReader$readDeepRecursive$1 r6 = new JsonTreeReader$readDeepRecursive$1(this.this$0, r5);
        r6.L$0 = r2;
        return r6.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L20:
        Object r6 = ZeusTransformUtils.preCheckCast(r7, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    L27:
        return (kotlinx.serialization.json.g) r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        DeepRecursiveScope r8 = (DeepRecursiveScope) ZeusTransformUtils.preCheckCast(this.L$0, DeepRecursiveScope.class, "com.obric.memorydata.plugin");
        byte r2 = p.a(this.this$0).e();
        if (r2 != 1) goto L13;
        kotlinx.serialization.json.r r9 = p.a(this.this$0, true);
    L11:
        r6 = ZeusTransformUtils.preCheckCast(r9, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
        goto L27
    L13:
        if (r2 != 0) goto L16;
        r9 = p.a(this.this$0, false);
        goto L11
    L16:
        if (r2 != 6) goto L21;
        p r3 = this.this$0;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r7 = p.a(r3, r8, r4);
        if (r7 != r0) goto L20;
        return r0;
    L21:
        p r10 = this.this$0;
        if (r2 == 8) goto L24;
        a.a(p.a(r10), "Can't begin reading element, unexpected token", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L24:
        return p.b(r10);
    }
}
