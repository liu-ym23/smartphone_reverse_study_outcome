package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.appreciable.ConversationPageTrace;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ActorScope;", "", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$initDataActor$1", f = "ConversationListModel.kt", i = {1, 2}, l = {458, 460, 474, 475}, m = "invokeSuspend", n = {"data", "dataList"}, s = {"L$1", "L$1"})
final class ConversationListModel$initDataActor$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.c<List<? extends wc9.e>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public ConversationListModel$initDataActor$1(Continuation<? super ConversationListModel$initDataActor$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ConversationListModel$initDataActor$1 r0 = new ConversationListModel$initDataActor$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.c) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.c<List<wc9.e>> r1, Continuation<? super Unit> r2) {
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x01bf -> B:67:0x01c4). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r6 = 2;
        String r8 = "IMConversationUpdate";
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ChannelIterator r3 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r18);
        ConversationListModel$initDataActor$1 r9 = this;
    L67:
        r6 = 2;
    L15:
        r9.L$0 = r3;
        r9.label = 1;
        Object r10 = r3.hasNext(r9);
        if (r10 != r1) goto L18;
        return r1;
    L18:
        ConversationListModel$initDataActor$1 r16 = r9;
        ChannelIterator r11 = r3;
        ConversationListModel$initDataActor$1 r4 = r16;
    L20:
        if (((Boolean) r10).booleanValue() == false) goto L69;
        List r12 = (List) r11.next();
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("update conversation list, size=");
        r14.append(r12.size());
        r14.append(' ');
        List r15 = r12;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r19 = r15.iterator();
    L23:
        if (r19.hasNext() == false) goto L25;
        r17.add(ic8.n.F((wc9.e) r19.next()));
        goto L23
    L25:
        r14.append(r17);
        r13.i("ConversationListModel_IMSDK", r14.toString());
        CompletableDeferred<Boolean> r110 = ConversationListModel.f;
        if (r110 == null) goto L32;
        r4.L$0 = r11;
        r4.L$1 = r12;
        r4.label = r6;
        Object r111 = r110.await(r4);
        if (r111 != r1) goto L30;
        return r1;
    L30:
        String r112 = r8;
        ConversationListModel$initDataActor$1 r20 = r4;
        List r5 = r12;
        ChannelIterator r113 = r11;
        String r21 = r112;
    L31:
        Boolean r114 = (Boolean) r111;
        ChannelIterator r115 = r113;
        r12 = r5;
        r4 = r20;
        r8 = r21;
        r11 = r115;
    L32:
        ConversationPageTrace.ConversationPageRecord r116 = ConversationPageTrace.a;
        ConversationPageTrace.c(false, r12.size());
        List r117 = r12;
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L34:
        if (r119.hasNext() == false) goto L53;
        Object r120 = r119.next();
        wc9.e r121 = (wc9.e) r120;
        Integer r7 = r121.f;
        if (r7 != null) goto L39;
    L49:
        boolean r22 = false;
    L50:
        if (r22 == false) goto L34;
        r118.add(r120);
        goto L34
    L39:
        if (r7.intValue() != 0) goto L49;
        if (ic8.n.d(r121) == true) goto L49;
        if (ic8.n.q(r121) == false) goto L45;
    L46:
        ConversationListModel.a.getClass();
        if (ConversationListModel.F(r121) == true) goto L49;
        r22 = true;
        goto L50
    L45:
        if (r121.F != 0) goto L49;
    L53:
        ConversationListModel.a.getClass();
        ConversationListModel.G(ConversationListModel.m(r118, null), r8);
        ConversationListModel.G(ConversationListModel.l(), "groupCellsUpdate");
        List<wh8.a> r23 = ConversationListModel.q;
        ConversationListModel.x(r23, r8);
        List r122 = CollectionsKt.filterNotNull(r117);
        if (r122.isEmpty() == true) goto L60;
        FLogger.a.d("ConversationListModel", "notifyIMConversationListChange source=IMConversationUpdate cvsList=" + r122.size() + " cvsDataList=" + r23.size());
        Iterator<wh8.b> r123 = ConversationListModel.h.iterator();
    L58:
        if (r123.hasNext() == false) goto L60;
        r123.next().R70(r23, r122);
    L60:
        ConversationListModel r24 = ConversationListModel.a;
        r4.L$0 = r11;
        r4.L$1 = r118;
        r4.label = 3;
        Object r25 = r24.u(r118, null, r8, r4);
        List<wc9.e> r124 = r118;
        if (r25 != r1) goto L63;
        return r1;
    L63:
        ConversationListModel r26 = ConversationListModel.a;
        r4.L$0 = r11;
        r4.L$1 = null;
        r4.label = 4;
        if (r26.p(r124, r8, r4) != r1) goto L66;
        return r1;
    L66:
        ChannelIterator r125 = r11;
        r9 = r4;
        r3 = r125;
        goto L67
    L69:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        List<wc9.e> r27 = (List) this.L$1;
        r11 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r18);
        r124 = r27;
        r4 = this;
        goto L63
    L12:
        r5 = (List) this.L$1;
        ChannelIterator r28 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r18);
        r111 = r18;
        r113 = r28;
        r21 = "IMConversationUpdate";
        r20 = this;
        goto L31
    L13:
        ChannelIterator r29 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r18);
        r10 = r18;
        r11 = r29;
        r4 = this;
        goto L20
    L14:
        ResultKt.throwOnFailure(r18);
        r3 = ((kotlinx.coroutines.channels.c) this.L$0).getChannel().iterator();
        r9 = this;
        goto L15
    }
}
