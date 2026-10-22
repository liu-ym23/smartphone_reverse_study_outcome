package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.graphics.Bitmap;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView$loadMissingAvatars$1", f = "ThreadReplyExposureView.kt", i = {0}, l = {314}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ThreadReplyExposureView$loadMissingAvatars$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $entityId;
    final /* synthetic */ String $newAvatarKey;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ThreadReplyExposureView this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView$loadMissingAvatars$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView$loadMissingAvatars$1$1", f = "ThreadReplyExposureView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $avatarBitmap;
        final /* synthetic */ String $newAvatarKey;
        int label;
        final /* synthetic */ ThreadReplyExposureView this$0;

        public AnonymousClass1(ThreadReplyExposureView r1, String r2, Bitmap r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$newAvatarKey = r2;
            this.$avatarBitmap = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$newAvatarKey, this.$avatarBitmap, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.this$0.e.remove(this.$newAvatarKey);
            this.this$0.d.put(this.$newAvatarKey, this.$avatarBitmap);
            this.this$0.postInvalidate();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ThreadReplyExposureView$loadMissingAvatars$1(ThreadReplyExposureView r1, String r2, String r3, Continuation<? super ThreadReplyExposureView$loadMissingAvatars$1> r4) {
        this.this$0 = r1;
        this.$newAvatarKey = r2;
        this.$entityId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ThreadReplyExposureView$loadMissingAvatars$1 r0 = new ThreadReplyExposureView$loadMissingAvatars$1(this.this$0, this.$newAvatarKey, this.$entityId, r6);
        r0.L$0 = r5;
        return r0;
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
        if (r1 != 1) goto L9;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L17
    L15:
        BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, this.$newAvatarKey, (Bitmap) r8, null), 2, null);     // Catch: Throwable -> L17
    L20:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        ThreadReplyExposureView r3 = this.this$0;     // Catch: Throwable -> L17
        String r4 = this.$newAvatarKey;     // Catch: Throwable -> L17
        String r5 = this.$entityId;     // Catch: Throwable -> L17
        this.L$0 = r9;     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        Object r6 = ThreadReplyExposureView.b(r3, r4, r5, this);     // Catch: Throwable -> L17
        if (r6 != r0) goto L14;
        return r0;
    L14:
        r2 = r9;
        r8 = r6;
    L17:
        th = move-exception;
        Log.e("MessageThreadCellReplyView", "call loadAvatarBitmap for " + this.$newAvatarKey + " failed: " + th);
        goto L20
    }
}
