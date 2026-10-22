package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$observeAttachmentReferences$2", f = "MultiTypeMentionPanelController.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
final class MultiTypeMentionPanelController$observeAttachmentReferences$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.i1<List<id8.f>> $attachmentFlow;
    int label;
    final /* synthetic */ MultiTypeMentionPanelController this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$observeAttachmentReferences$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "entities", "", "Lcom/larus/bmhome/chat/component/bottom/attachment/entity/ImmutableUplinkFileEntity;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypeMentionPanelController$observeAttachmentReferences$2$1", f = "MultiTypeMentionPanelController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends id8.f>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MultiTypeMentionPanelController this$0;

        public AnonymousClass1(MultiTypeMentionPanelController r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((List) r1, (Continuation) r2);
        }

        public final Object invoke(List<id8.f> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            List r5 = (List) this.L$0;
            MultiTypeMentionPanelController r0 = this.this$0;
            List r6 = r5;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L8;
            r1.add(k0.d((id8.f) r7.next()));
            goto L6
        L8:
            int r8 = MultiTypeMentionPanelController.c0;
            r0.r(r1);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiTypeMentionPanelController$observeAttachmentReferences$2(kotlinx.coroutines.flow.i1<? extends List<id8.f>> r1, MultiTypeMentionPanelController r2, Continuation<? super MultiTypeMentionPanelController$observeAttachmentReferences$2> r3) {
        this.$attachmentFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiTypeMentionPanelController$observeAttachmentReferences$2(this.$attachmentFlow, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.flow.i1<List<id8.f>> r7 = this.$attachmentFlow;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
