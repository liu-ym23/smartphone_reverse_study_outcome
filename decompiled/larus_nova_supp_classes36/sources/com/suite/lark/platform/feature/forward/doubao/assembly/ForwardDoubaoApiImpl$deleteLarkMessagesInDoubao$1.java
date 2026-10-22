package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.DeleteLarkMessagesInDoubaoRequest;
import com.bytedance.lark.pb.im.v1.DeleteLarkMessagesInDoubaoResponse;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
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
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1", f = "ForwardDoubaoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<byte[]> $serMessages;
    int label;

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object parse(byte[] r2) {
            return (DeleteLarkMessagesInDoubaoResponse) DeleteLarkMessagesInDoubaoResponse.ADAPTER.decode(r2);
        }
    }

    public ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1(List<byte[]> r1, Continuation<? super ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1> r2) {
        this.$serMessages = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1(this.$serMessages, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r5);
        DeleteLarkMessagesInDoubaoRequest.Builder r6 = new DeleteLarkMessagesInDoubaoRequest.Builder();     // Catch: Throwable -> L11
        List<byte[]> r0 = this.$serMessages;     // Catch: Throwable -> L11
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Throwable -> L11
        Iterator<T> r2 = r0.iterator();     // Catch: Throwable -> L11
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.add(ByteString.a.e(ByteString.Companion, (byte[]) r2.next()));     // Catch: Throwable -> L11
        goto L7
    L9:
        DeleteLarkMessagesInDoubaoRequest.Builder r7 = r6.ser_messages(r1);     // Catch: Throwable -> L11
        SdkSender.IParser r3 = a.a;     // Catch: Throwable -> L11
        final List<byte[]> r4 = this.$serMessages;     // Catch: Throwable -> L11
        SdkSender.asynSendRequestNonWrap(Command.DELETE_LARK_MESSAGES_IN_DOUBAO, r7, new ForwardDoubaoApiImpl$deleteLarkMessagesInDoubao$1$callback$1(r4), r3);     // Catch: Throwable -> L11
    L14:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        Log.e("ForwardDoubaoApiImpl", "deleteLarkMessagesInDoubao failed, count=" + this.$serMessages.size(), th);
        goto L14
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
