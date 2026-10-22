package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$addDirectSendAttachmentEntity$1", f = "AttachmentPanelComponent.kt", i = {}, l = {2379}, m = "invokeSuspend", n = {}, s = {})
public final class AttachmentPanelComponent$addDirectSendAttachmentEntity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    int label;
    final /* synthetic */ AttachmentPanelComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$addDirectSendAttachmentEntity$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$addDirectSendAttachmentEntity$1$1", f = "AttachmentPanelComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        int label;
        final /* synthetic */ AttachmentPanelComponent this$0;

        public AnonymousClass1(UplinkFileEntity r1, AttachmentPanelComponent r2, Continuation<? super AnonymousClass1> r3) {
            this.$entity = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$entity, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r20);
            FLogger.a.i("AttachmentPanelComponent", "[addDirectSendAttachmentEntity] " + this.$entity);
            ((ArrayList) this.this$0.N).add(UplinkFileEntity.copy$default(this.$entity, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null));
            StateFlowImpl r1 = this.this$0.O;
            int r2 = id8.e.a;
            r1.setValue(id8.e.e((List) r1.getValue(), this.this$0.N));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AttachmentPanelComponent$addDirectSendAttachmentEntity$1(AttachmentPanelComponent r1, UplinkFileEntity r2, Continuation<? super AttachmentPanelComponent$addDirectSendAttachmentEntity$1> r3) {
        this.this$0 = r1;
        this.$entity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AttachmentPanelComponent$addDirectSendAttachmentEntity$1(this.this$0, this.$entity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r8);     // Catch: NullPointerException -> L7 ConcurrentModificationException -> L9
    L21:
    L20:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r8);
        AttachmentPanelComponent.h3(this.this$0, this.$entity);     // Catch: NullPointerException -> L7 ConcurrentModificationException -> L9
        MainCoroutineDispatcher r9 = Dispatchers.getMain();     // Catch: NullPointerException -> L7 ConcurrentModificationException -> L9
        AnonymousClass1 r2 = new AnonymousClass1(this.$entity, this.this$0, null);     // Catch: NullPointerException -> L7 ConcurrentModificationException -> L9
        this.label = 1;     // Catch: NullPointerException -> L7 ConcurrentModificationException -> L9
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L21;
        return r0;
    L7:
        e = move-exception;
        FLogger.a.e("AttachmentPanelComponent", "[addDirectSendAttachmentEntity] NullPointerException: " + e.getMessage(), e);
    L9:
        e = move-exception;
        FLogger.a.e("AttachmentPanelComponent", "[addDirectSendAttachmentEntity] ConcurrentModificationException: " + e.getMessage(), e);
        goto L20
    }
}
