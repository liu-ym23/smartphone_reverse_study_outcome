package com.larus.bmhome.chat.list.cell.nested_file;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.r0;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper$onSuccess$3$1", f = "NestedFileClickHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NestedFileClickHelper$onSuccess$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ lr8.a $delegate;
    final /* synthetic */ String $it;
    final /* synthetic */ Message $msg;
    int label;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ lr8.a a;

        public final boolean mustInMain() {
            return true;
        }

        public a(lr8.a r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
        }

        public final void onSuccess(Object r3) {
            Message r4 = (Message) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            q0 r0 = this.a.getAdapter();
            if (r0 == null) goto L9;
            String r1 = r4.getMessageId();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            r0.x7(r1, r4.getContentType());
            return;
        }
    }

    public NestedFileClickHelper$onSuccess$3$1(Message r1, String r2, lr8.a r3, Continuation<? super NestedFileClickHelper$onSuccess$3$1> r4) {
        this.$msg = r1;
        this.$it = r2;
        this.$delegate = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new NestedFileClickHelper$onSuccess$3$1(this.$msg, this.$it, this.$delegate, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r5);
        RepoDispatcher.a.getClass();
        ChatRepo r6 = RepoDispatcher.d;
        String r0 = this.$msg.getLocalMessageId();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        Pair r1 = TuplesKt.to("nested_file_local_path_list", this.$it);
        a r2 = new a(this.$delegate);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "localMessageId");
        Intrinsics.checkNotNullParameter(r1, "newExt");
        com.larus.im.d.e().x(r0, new r0(r1), r2);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
