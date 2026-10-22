package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy$imageXUpload$2$1", f = "ChatRetryStrategy.kt", i = {}, l = {744}, m = "invokeSuspend", n = {}, s = {})
public final class ChatRetryStrategy$imageXUpload$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<mr9.l> $continuation;
    final /* synthetic */ String $localPath;
    int label;

    public static final class a implements Function1<mr9.l, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<mr9.l> a;

        public a(kotlinx.coroutines.i<? super mr9.l> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            mr9.l r3 = (mr9.l) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            this.a.resumeWith(Result.constructor-impl(r3));
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<mr9.k, Unit> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object invoke(Object r2) {
            Intrinsics.checkNotNullParameter((mr9.k) r2, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<ResourceUploadError, Unit> {
        public final /* synthetic */ kotlinx.coroutines.i<mr9.l> a;

        public c(kotlinx.coroutines.i<? super mr9.l> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            Intrinsics.checkNotNullParameter((ResourceUploadError) r2, "it");
            this.a.resumeWith(Result.constructor-impl(null));
            return Unit.INSTANCE;
        }
    }

    public ChatRetryStrategy$imageXUpload$2$1(String r1, kotlinx.coroutines.i<? super mr9.l> r2, Continuation<? super ChatRetryStrategy$imageXUpload$2$1> r3) {
        this.$localPath = r1;
        this.$continuation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatRetryStrategy$imageXUpload$2$1(this.$localPath, this.$continuation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r28) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r28);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r28);
        ResourceUploader r3 = ResourceUploader.a;
        UploadDataType r7 = UploadDataType.IMAGE;
        CountDownLatch r4 = new CountDownLatch(1);
        String r15 = UUID.randomUUID().toString();
        String r5 = this.$localPath;
        kotlinx.coroutines.i<mr9.l> r11 = this.$continuation;
        mr9.j r14 = new mr9.j(r5, "bot_chat", r7, new a(r11), b.a, new c(r11), false, null, null, null, r15, true, r4, null, null, null, null, null, null, null, 2082752);
        this.label = 1;
        if (r3.j(r14, this) != r1) goto L12;
        return r1;
    }
}
