package com.obric.aiproactive.impl.livecard;

import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager$refreshActiveSessionTheme$1", f = "ProactiveLiveCardManager.kt", i = {0}, l = {1478}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class ProactiveLiveCardManager$refreshActiveSessionTheme$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    Object L$0;
    int label;

    ProactiveLiveCardManager$refreshActiveSessionTheme$1(String r3, Continuation<? super ProactiveLiveCardManager$refreshActiveSessionTheme$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$reason = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$refreshActiveSessionTheme$1(this.$reason, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardManager$refreshActiveSessionTheme$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardManager$refreshActiveSessionTheme$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        IslandSession r4 = null;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r18);
    L62:
        ProactiveLiveCardDisplayTool.d r5 = ProactiveLiveCardDisplayTool.INSTANCE.resolveHostColors$ai_proactive_impl_obricRelease();     // Catch: Throwable -> L56
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(n.b().values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L56
    L13:
        if (r7.hasNext() == false) goto L47;
        IslandSession r13 = (IslandSession) ZeusTransformUtils.preCheckCast(r7.next(), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
        IslandWidget r8 = r13.getExpandWidget();     // Catch: Throwable -> L56
        if (r8 == null) goto L18;
        Object r9 = r8.getTemplateData();     // Catch: Throwable -> L56
    L20:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class) == false) goto L22;
        ProactiveLiveCardDisplayTool.AiNotifyTemplateData r14 = (ProactiveLiveCardDisplayTool.AiNotifyTemplateData) ZeusTransformUtils.preCheckCast(r9, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
    L23:
        IslandWidget r10 = r13.getNotificationWidget();     // Catch: Throwable -> L56
        if (r10 == null) goto L26;
        Object r11 = r10.getTemplateData();     // Catch: Throwable -> L56
    L28:
        if (ZeusTransformUtils.instanceOf(r11, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class) == false) goto L30;
        ProactiveLiveCardDisplayTool.AiNotifyTemplateData r15 = (ProactiveLiveCardDisplayTool.AiNotifyTemplateData) ZeusTransformUtils.preCheckCast(r11, ProactiveLiveCardDisplayTool.AiNotifyTemplateData.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L56
    L31:
        if (r14 != 0) goto L34;
        if (r15 != 0) goto L34;
        r13 = r4;
    L44:
        if (r13 == null) goto L46;
        r12.add(r13);     // Catch: Throwable -> L54
    L54:
        th = th;
        IslandSession r16 = null;
    L58:
        r3.b(r16);
        throw th;
    L46:
        r4 = null;
    L34:
        if (r14 == 0) goto L40;
        IslandWidget r17 = r13.getExpandWidget();     // Catch: Throwable -> L56
        if (r17 == null) goto L40;
        r17.setTemplateData(ProactiveLiveCardDisplayTool.refreshTemplateColors$ai_proactive_impl_obricRelease$default(ProactiveLiveCardDisplayTool.INSTANCE, r14, r5, null, 4, null));     // Catch: Throwable -> L54
    L40:
        if (r15 == 0) goto L44;
        IslandWidget r19 = r13.getNotificationWidget();     // Catch: Throwable -> L54
        if (r19 == null) goto L44;
        r19.setTemplateData(ProactiveLiveCardDisplayTool.INSTANCE.refreshTemplateColors$ai_proactive_impl_obricRelease(r15, r5, r14));     // Catch: Throwable -> L54
        goto L44
    L30:
        r15 = r4;
        goto L31
    L26:
        r11 = r4;
        goto L28
    L22:
        r14 = r4;
        goto L23
    L18:
        r9 = r4;
        goto L20
    L47:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        r3.b(null);
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        ProactiveLiveCardDisplayTool r22 = ProactiveLiveCardDisplayTool.INSTANCE;
        Iterator r23 = r21.iterator();
    L50:
        if (r23.hasNext() == false) goto L52;
        r22.refreshSession((IslandSession) ZeusTransformUtils.preCheckCast(r23.next(), IslandSession.class, "com.obric.memorydata.plugin"));
        goto L50
    L52:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Refreshed lock-screen recommendation theme reason=" + this.$reason + " count=" + r20.size(), false, 4, null);
        return Unit.INSTANCE;
    L56:
        th = th;
        r16 = r4;
        goto L58
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        kotlinx.coroutines.sync.a r24 = n.a();
        Continuation<? super Unit> r25 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r24;
        this.label = 1;
        if (r24.a(null, r25) != r1) goto L11;
        return r1;
    L11:
        r3 = r24;
        goto L62
    }
}
