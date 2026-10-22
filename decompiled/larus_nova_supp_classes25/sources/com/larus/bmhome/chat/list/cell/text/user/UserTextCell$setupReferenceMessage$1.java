package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.user.UserTextCell$setupReferenceMessage$1", f = "UserTextCell.kt", i = {}, l = {1609, 1610}, m = "invokeSuspend", n = {}, s = {})
public final class UserTextCell$setupReferenceMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ ReferenceInfo $refInfo;
    int label;
    final /* synthetic */ UserTextCell this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.text.user.UserTextCell$setupReferenceMessage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.user.UserTextCell$setupReferenceMessage$1$1", f = "UserTextCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $data;
        final /* synthetic */ ReferenceMessage $refMessage2;
        int label;
        final /* synthetic */ UserTextCell this$0;

        public AnonymousClass1(UserTextCell r1, ReferenceMessage r2, Message r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$refMessage2 = r2;
            this.$data = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$refMessage2, this.$data, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            UserTextCell r5 = this.this$0;
            ReferenceMessage r0 = this.$refMessage2;
            boolean r1 = com.larus.bmhome.chat.bean.d.G0(this.$data);
            int r2 = UserTextCell.z;
            r5.R(r0, r1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public UserTextCell$setupReferenceMessage$1(ReferenceInfo r1, UserTextCell r2, Message r3, Continuation<? super UserTextCell$setupReferenceMessage$1> r4) {
        this.$refInfo = r1;
        this.this$0 = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UserTextCell$setupReferenceMessage$1(this.$refInfo, this.this$0, this.$data, r5);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        UserTextCell r4 = this.this$0;
        AnonymousClass1 r3 = new AnonymousClass1(r4, (ReferenceMessage) r8, this.$data, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        ReferenceMessage.Companion r9 = ReferenceMessage.Companion;
        ReferenceInfo r5 = this.$refInfo;
        this.label = 1;
        r8 = r9.c(r5, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
