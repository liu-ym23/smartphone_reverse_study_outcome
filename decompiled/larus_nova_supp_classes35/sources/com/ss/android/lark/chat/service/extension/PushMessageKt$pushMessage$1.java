package com.ss.android.lark.chat.service.extension;

import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.biz.im.api.k0;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
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
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.k;
import m6b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.extension.PushMessageKt$pushMessage$1", f = "PushMessage.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
final class PushMessageKt$pushMessage$1 extends SuspendLambda implements Function2<k<? super MessageInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ u $this_pushMessage;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements k0 {
        public final /* synthetic */ k<MessageInfo> a;

        public final void b(PushMessageReadStates r2) {
            Intrinsics.checkNotNullParameter(r2, "readStates");
        }

        public final void f(PushMessageReactions r2) {
            Intrinsics.checkNotNullParameter(r2, "reactions");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(k<? super MessageInfo> r1) {
            this.a = r1;
        }

        public final void a(g1 r3) {
            Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
            MessageInfo r4 = r3.a;
            Object r5 = this.a.trySend-JP2dKIU(r4);
            g.c r0 = g.b;
            if ((r5 instanceof g.c) == false) goto L6;
            Log.e("PushMessage", "onPushMessage failed", g.a(r5));
            return;
        }
    }

    public PushMessageKt$pushMessage$1(u r1, Continuation<? super PushMessageKt$pushMessage$1> r2) {
        this.$this_pushMessage = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PushMessageKt$pushMessage$1 r0 = new PushMessageKt$pushMessage$1(this.$this_pushMessage, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<? super MessageInfo> r1, Continuation<? super Unit> r2) {
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
        k r7 = (k) this.L$0;
        final a r2 = new a(r7);
        this.$this_pushMessage.gc(r2);
        Log.i("PushMessage", "pushMessage add listener");
        final u r4 = this.$this_pushMessage;
        Function0<Unit> r3 = new AnonymousClass1(r4, r2);
        this.label = 1;
        if (ProduceKt.a(r7, r3, this) != r0) goto L12;
        return r0;
    }
}
