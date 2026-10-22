package androidx.room.parser;

import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.squareup.javapoet.x;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroidx/room/compiler/processing/XType;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.parser.SQLTypeAffinity$withBoxedAndNullableTypes$1$1", f = "SqlParser.kt", i = {0, 0}, l = {297, 299, LynxErrorCode.LYNX_ERROR_CODE_RESOURCE}, m = "invokeSuspend", n = {"$this$sequence", "type"}, s = {"L$0", "L$1"})
public final class SQLTypeAffinity$withBoxedAndNullableTypes$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super XType>, Continuation<? super Unit>, Object> {
    final /* synthetic */ XProcessingEnv $env;
    final /* synthetic */ x $typeName;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public SQLTypeAffinity$withBoxedAndNullableTypes$1$1(XProcessingEnv r5, x r10, Continuation<? super SQLTypeAffinity$withBoxedAndNullableTypes$1$1> r11) {
        this.$env = r5;
        this.$typeName = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        SQLTypeAffinity$withBoxedAndNullableTypes$1$1 r11 = new SQLTypeAffinity$withBoxedAndNullableTypes$1$1(this.$env, this.$typeName, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(SequenceScope<? super XType> r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L27:
        return Unit.INSTANCE;
    L11:
        XType r12 = (XType) this.L$1;
        SequenceScope r13 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        if (this.$env.getBackend() != XProcessingEnv.Backend.KSP) goto L22;
        XType r14 = r12.makeNullable();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r13.yield(r14, this) != r5) goto L27;
        return r5;
    L22:
        if (this.$typeName.k() == false) goto L27;
        XType r15 = r12.boxed();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        if (r13.yield(r15, this) != r5) goto L27;
        return r5;
    L12:
        ResultKt.throwOnFailure(r10);
        SequenceScope r16 = (SequenceScope) this.L$0;
        r12 = this.$env.requireType(this.$typeName);
        this.L$0 = r16;
        this.L$1 = r12;
        this.label = 1;
        if (r16.yield(r12, this) != r5) goto L15;
        return r5;
    L15:
        r13 = r16;
        goto L17
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super XType> r5, Continuation<? super Unit> r10) {
        return ((SQLTypeAffinity$withBoxedAndNullableTypes$1$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
