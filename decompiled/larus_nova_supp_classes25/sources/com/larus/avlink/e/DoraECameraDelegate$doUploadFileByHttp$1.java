package com.larus.avlink.e;

import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.e.DoraECameraDelegate$doUploadFileByHttp$1", f = "DoraECameraDelegate.kt", i = {}, l = {913}, m = "invokeSuspend", n = {}, s = {})
final class DoraECameraDelegate$doUploadFileByHttp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b49.h $imageInfo;
    final /* synthetic */ List<f98.l> $images;
    final /* synthetic */ int $mode;
    int label;

    public DoraECameraDelegate$doUploadFileByHttp$1(b49.h r1, int r2, List<f98.l> r3, Continuation<? super DoraECameraDelegate$doUploadFileByHttp$1> r4) {
        this.$imageInfo = r1;
        this.$mode = r2;
        this.$images = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraECameraDelegate$doUploadFileByHttp$1(this.$imageInfo, this.$mode, this.$images, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.avlink.e.g] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L22:
        if (((m.a) r14).a == true) goto L25;
        FLogger.a.e("DoraE_Camera", "doUploadFile failed. imageId: " + this.$imageInfo.a);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        m r2 = m.a;
        b49.h r15 = this.$imageInfo;
        int r3 = this.$mode;
        List<f98.l> r4 = this.$images;
        String r5 = a98.a.a;
        String r6 = a98.a.b;
        l r7 = l.a;
        int r8 = l.d(Boxing.boxInt(r3));
        DoraVisionBizScene.a r9 = DoraVisionBizScene.Companion;
        int r10 = this.$mode;
        r9.getClass();
        if (r10 != 2) goto L11;
        DoraVisionBizScene r11 = DoraVisionBizScene.LIVE_AI;
    L15:
        if (r11 == null) goto L17;
        Integer r12 = Boxing.boxInt(r11.getValue());
    L18:
        int r13 = o.b();
        f r16 = new f();
        final b49.h r17 = this.$imageInfo;
        ?? r18 = new g(r17);
        this.label = 1;
        r14 = r2.a(r15, r3, r4, r5, r6, r8, r12, r13, r16, r18, this);
        if (r14 != r0) goto L22;
        return r0;
    L17:
        r12 = null;
        goto L18
    L11:
        if (r10 == 17) goto L13;
        r11 = DoraVisionBizScene.DEFAULT;
        goto L15
    L13:
        r11 = DoraVisionBizScene.ENV_OBSERVE;
        goto L15
    }
}
