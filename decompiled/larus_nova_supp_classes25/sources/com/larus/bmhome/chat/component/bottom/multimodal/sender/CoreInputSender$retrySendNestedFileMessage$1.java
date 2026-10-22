package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.sender.CoreInputSender$retrySendNestedFileMessage$1", f = "CoreInputSender.kt", i = {0}, l = {434}, m = "invokeSuspend", n = {"messages"}, s = {"L$0"})
final class CoreInputSender$retrySendNestedFileMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarTemplateName;
    final /* synthetic */ String $botId;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ List<UplinkFileEntity> $entityList;
    final /* synthetic */ List<UplinkFileEntity> $failEntities;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ boolean $isMultiFile;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $referenceFromType;
    final /* synthetic */ ReferenceInfo $referenceInfo;
    Object L$0;
    int label;
    final /* synthetic */ f this$0;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ Function0<Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        public a(l r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Intrinsics.checkNotNullParameter(r3, "error");
            FLogger.a.e("CoreInputSender", "[retrySendNestedFileMessage] update finalized text failed");
        }

        public final void onSuccess(Object r2) {
            Intrinsics.checkNotNullParameter((Message) r2, "result");
            this.a.invoke();
        }
    }

    public CoreInputSender$retrySendNestedFileMessage$1(Message r1, ChatPageContext r2, wc9.e r3, List<UplinkFileEntity> r4, List<UplinkFileEntity> r5, f r6, String r7, boolean r8, String r9, String r10, String r11, String r12, String r13, ReferenceInfo r14, Continuation<? super CoreInputSender$retrySendNestedFileMessage$1> r15) {
        this.$message = r1;
        this.$chatPageContext = r2;
        this.$conversation = r3;
        this.$failEntities = r4;
        this.$entityList = r5;
        this.this$0 = r6;
        this.$botId = r7;
        this.$isMultiFile = r8;
        this.$fromScene = r9;
        this.$clickFrom = r10;
        this.$enterMethod = r11;
        this.$actionBarTemplateName = r12;
        this.$referenceFromType = r13;
        this.$referenceInfo = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r19, Continuation<?> r20) {
        return new CoreInputSender$retrySendNestedFileMessage$1(this.$message, this.$chatPageContext, this.$conversation, this.$failEntities, this.$entityList, this.this$0, this.$botId, this.$isMultiFile, this.$fromScene, this.$clickFrom, this.$enterMethod, this.$actionBarTemplateName, this.$referenceFromType, this.$referenceInfo, r20);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r21);
        Object r4 = r21;
    L12:
        List r5 = (List) r4;
        if (r5.isEmpty() == false) goto L15;
        r3.add(this.$message);
    L16:
        IChatRepoService r6 = zh8.a.a;
        IChatRepoService r7 = zh8.a.a;
        List r8 = r7.getSender().c(r3, this.$chatPageContext);
        u1 r9 = r7.getSender();
        final wc9.e r10 = this.$conversation;
        String r15 = r10.a;
        final Message r11 = this.$message;
        final List<UplinkFileEntity> r12 = this.$failEntities;
        final List<UplinkFileEntity> r13 = this.$entityList;
        final f r14 = this.this$0;
        final String r16 = this.$botId;
        final boolean r17 = this.$isMultiFile;
        final String r18 = this.$fromScene;
        final String r19 = this.$clickFrom;
        final String r110 = this.$enterMethod;
        final String r111 = this.$actionBarTemplateName;
        final String r20 = this.$referenceFromType;
        final ReferenceInfo r22 = this.$referenceInfo;
        final ChatPageContext r23 = this.$chatPageContext;
        r9.g(r15, r8, new j(r11, r12, r13, r14, r10, r16, r17, r18, r19, r110, r111, r20, r22, r23));
        return Unit.INSTANCE;
    L15:
        r3.addAll(r5);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        ArrayList r24 = new ArrayList();
        IChatRepoService r25 = zh8.a.a;
        IChatRepoService r26 = zh8.a.a;
        Message r27 = this.$message;
        this.L$0 = r24;
        this.label = 1;
        r4 = r26.z1(r27, this);
        if (r4 != r1) goto L11;
        return r1;
    L11:
        r3 = r24;
        goto L12
    }
}
