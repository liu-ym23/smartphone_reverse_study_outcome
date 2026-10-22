package com.larus.uaigc.chat.markdown.video.statemanager;

import android.widget.TextView;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.uaigc.utils.DataConverterKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$initClickListener$1$1", f = "VideoSuccessState.kt", i = {0}, l = {327, 336}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class VideoSuccessState$initClickListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    final /* synthetic */ CreationTask $successTaskMap;
    final /* synthetic */ nr9.g $videoPlayData;
    final /* synthetic */ TextView $view;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ i this$0;

    public VideoSuccessState$initClickListener$1$1(Message r1, CreationTask r2, nr9.g r3, TextView r4, i r5, Continuation<? super VideoSuccessState$initClickListener$1$1> r6) {
        this.$message = r1;
        this.$successTaskMap = r2;
        this.$videoPlayData = r3;
        this.$view = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        VideoSuccessState$initClickListener$1$1 r7 = new VideoSuccessState$initClickListener$1$1(this.$message, this.$successTaskMap, this.$videoPlayData, this.$view, this.this$0, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L47:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L21:
        UserCreationFromIM r9 = (UserCreationFromIM) r15;
        if (r9 == null) goto L38;
        String r16 = r9.getRefContent();
        if (r16 == null) goto L38;
        if ((!StringsKt.isBlank(r16)) == true) goto L29;
        r16 = null;
    L29:
        if (r16 == null) goto L38;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L32
        Object r17 = Result.constructor-impl((UserCreationRefContent) xt7.d.b.c(UserCreationRefContent.Companion.serializer(), r16));     // Catch: Throwable -> L32
    L35:
        if (Result.isFailure-impl(r17) == false) goto L37;
        r17 = null;
    L37:
        UserCreationRefContent r10 = (UserCreationRefContent) r17;
    L39:
        nr9.g r7 = this.$videoPlayData;
        if (r7 == null) goto L47;
        if (r7.c == null) goto L47;
        TextView r6 = this.$view;
        Message r8 = this.$message;
        CreationTask r11 = this.$successTaskMap;
        i r12 = this.this$0;
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        VideoSuccessState$initClickListener$1$1$1$1 r4 = new VideoSuccessState$initClickListener$1$1$1$1(r6, r7, r8, r9, r10, r11, r12, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r18, r4, this) != r0) goto L47;
        return r0;
    L32:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L38:
        r10 = null;
        goto L39
    L10:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        Message r13 = this.$message;
        if (r13 == null) goto L13;
        String r14 = r13.getMessageId();
    L14:
        CreationTask r20 = this.$successTaskMap;
        if (r20 == null) goto L17;
        String r21 = r20.id;
    L18:
        this.L$0 = r19;
        this.label = 1;
        r15 = DataConverterKt.e(r14, r21, this);
        if (r15 != r0) goto L21;
        return r0;
    L17:
        r21 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    }
}
