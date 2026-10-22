package com.larus.bmhome.chat.deepsearch.component;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1", f = "DeepSearchContentComponent.kt", i = {0}, l = {195, 203}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
final class DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fromMsgId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeepSearchContentComponent this$0;

    public DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1(String r1, DeepSearchContentComponent r2, Continuation<? super DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1> r3) {
        this.$fromMsgId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DeepSearchContentComponent$sendInvisibleDeepSearchMessageIfNeeded$1(this.$fromMsgId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.bmhome.chat.deepsearch.component.h] */
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
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = "";
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L49:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$1;
        final DeepSearchContentComponent r3 = (DeepSearchContentComponent) this.L$0;
        ResultKt.throwOnFailure(r14);
        String r7 = r2;
    L22:
        Iterator r15 = ((List) r14).iterator();
    L24:
        if (r15.hasNext() == false) goto L38;
        Message r5 = (Message) r15.next();
        Map r6 = r5.getExt();
        if (r6 == null) goto L28;
        String r8 = (String) r6.get("deep_search_from_id");
    L30:
        if (Intrinsics.areEqual(r8, r7) == false) goto L24;
        String r16 = r5.getMessageId();
        if (r16 == null) goto L35;
        r4 = r16;
    L35:
        int r17 = DeepSearchContentComponent.s;
        r3.getClass();
        if (o0.d(r4) == false) goto L49;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new DeepSearchContentComponent$showDeepSearchMessageByMsgId$1(r4, r3, null), 2, null);
        goto L49
    L28:
        r8 = null;
        goto L30
    L38:
        com.larus.bmhome.chat.deepsearch.m r9 = com.larus.bmhome.chat.deepsearch.m.a;
        int r18 = DeepSearchContentComponent.s;
        DeepSearchParam r19 = r3.Y2();
        if (r19 == null) goto L41;
        String r110 = r19.c;
    L42:
        if (r110 != null) goto L44;
        String r10 = "";
    L45:
        ChatPageContext r11 = (ChatPageContext) s1a.d.a(r3).a(ChatPageContext.class);
        ?? r12 = new h(r3);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r9.a(r7, r10, r11, r12, this) != r0) goto L49;
        return r0;
    L44:
        r10 = r110;
        goto L45
    L41:
        r110 = null;
        goto L42
    L10:
        ResultKt.throwOnFailure(r14);
        String r13 = this.$fromMsgId;
        if (r13 == null) goto L49;
        DeepSearchContentComponent r111 = this.this$0;
        IChatRepoService r20 = zh8.a.a;
        int r21 = DeepSearchContentComponent.s;
        DeepSearchParam r22 = r111.Y2();
        if (r22 == null) goto L15;
        String r23 = r22.c;
    L16:
        if (r23 != null) goto L18;
        r23 = "";
    L18:
        this.L$0 = r111;
        this.L$1 = r13;
        this.label = 1;
        Object r24 = r20.o1(r23, 0, this);
        if (r24 != r0) goto L21;
        return r0;
    L21:
        r7 = r13;
        r3 = r111;
        r14 = r24;
        goto L22
    L15:
        r23 = null;
        goto L16
    }
}
