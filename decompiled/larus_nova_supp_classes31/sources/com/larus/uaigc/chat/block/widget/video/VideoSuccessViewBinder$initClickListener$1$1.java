package com.larus.uaigc.chat.block.widget.video;

import android.widget.TextView;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.VideoData;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.VideoSuccessViewBinder$initClickListener$1$1", f = "VideoSuccessViewBinder.kt", i = {}, l = {464}, m = "invokeSuspend", n = {}, s = {})
public final class VideoSuccessViewBinder$initClickListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextView $it;
    int label;
    final /* synthetic */ VideoSuccessViewBinder this$0;

    public VideoSuccessViewBinder$initClickListener$1$1(VideoSuccessViewBinder r1, TextView r2, Continuation<? super VideoSuccessViewBinder$initClickListener$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoSuccessViewBinder$initClickListener$1$1(this.this$0, this.$it, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        cz9.o r9 = this.this$0.f;
        if (r9 == null) goto L13;
        CreationItem r10 = r9.d;
        if (r10 == null) goto L13;
        VideoData r11 = r10.video;
    L14:
        CreationNoWatermarkManager r3 = CreationNoWatermarkManager.a;
        if (r11 == null) goto L17;
        String r4 = r11.vid;
    L18:
        if (r11 == null) goto L20;
        nr9.g r5 = bz9.a.l(r11);
    L21:
        if (r11 == null) goto L25;
        Cover r12 = r11.cover;
        if (r12 == null) goto L25;
        String r13 = r12.key;
    L26:
        nr9.g r14 = r3.h0(r4, r5, r13);
        if (r14 == null) goto L32;
        TextView r6 = this.$it;
        VideoSuccessViewBinder r7 = this.this$0;
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        VideoSuccessViewBinder$initClickListener$1$1$1$1 r16 = new VideoSuccessViewBinder$initClickListener$1$1$1$1(r6, r14, r7, null);
        this.label = 1;
        if (BuildersKt.withContext(r15, r16, this) != r0) goto L32;
        return r0;
    L25:
        r13 = null;
        goto L26
    L20:
        r5 = null;
        goto L21
    L17:
        r4 = null;
    L13:
        r11 = null;
        goto L14
    }
}
