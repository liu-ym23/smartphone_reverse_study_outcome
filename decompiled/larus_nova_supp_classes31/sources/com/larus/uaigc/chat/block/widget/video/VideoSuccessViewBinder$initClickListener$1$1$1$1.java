package com.larus.uaigc.chat.block.widget.video;

import android.content.Context;
import android.widget.TextView;
import androidx.collection.LruCache;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationReportService;
import com.tencent.open.log.TraceLevel;
import kc8.b0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.widget.video.VideoSuccessViewBinder$initClickListener$1$1$1$1", f = "VideoSuccessViewBinder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoSuccessViewBinder$initClickListener$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextView $it;
    final /* synthetic */ nr9.g $videoPlayData;
    int label;
    final /* synthetic */ VideoSuccessViewBinder this$0;

    public VideoSuccessViewBinder$initClickListener$1$1$1$1(TextView r1, nr9.g r2, VideoSuccessViewBinder r3, Continuation<? super VideoSuccessViewBinder$initClickListener$1$1$1$1> r4) {
        this.$it = r1;
        this.$videoPlayData = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoSuccessViewBinder$initClickListener$1$1$1$1(this.$it, this.$videoPlayData, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r36);
        hy9.d r2 = ICreationReportService.a.j();
        String r3 = AppHost.a.getApplication().getString(2131905605);
        LruCache r1 = ko8.a.a;
        hy9.d.a.a(r2, r3, null, null, "video_overview", "single_function", null, null, null, null, ko8.a.h(ko8.a.e), null, null, null, null, null, null, null, null, "chat", null, null, 3931622);
        IAIChatUgcAIGCService.Companion r25 = IAIChatUgcAIGCService.a;
        Context r26 = this.$it.getContext();
        nr9.g r4 = this.$videoPlayData;
        cz9.o r5 = this.this$0.f;
        Function4 r6 = null;
        if (r5 == null) goto L9;
        Message r7 = r5.e;
        if (r7 == null) goto L9;
        String r28 = r7.getMessageId();
    L10:
        VideoSuccessViewBinder r8 = this.this$0;
        cz9.o r9 = r8.f;
        if (r9 == null) goto L15;
        CreationItem r10 = r9.d;
        if (r10 == null) goto L15;
        String r31 = r10.id;
    L16:
        kc8.q r11 = r8.g();
        if (r11 == null) goto L23;
        Function0 r12 = r11.e;
        if (r12 == null) goto L23;
        if (((Boolean) r12.invoke()).booleanValue() != true) goto L23;
        boolean r32 = true;
    L24:
        kc8.q r13 = this.this$0.g();
        if (r13 == null) goto L29;
        final b0 r14 = r13.k;
        if (r14 == null) goto L29;
        r6 = new t(r14);
    L29:
        IAIChatUgcAIGCService.a.c(r25, r26, r4, r28, null, null, r31, r32, r6, MapsKt.mapOf(TuplesKt.to("enter_method", "ai_edit_video_overview")));
        return Unit.INSTANCE;
    L23:
        r32 = false;
    L15:
        r31 = null;
    L9:
        r28 = null;
        goto L10
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
