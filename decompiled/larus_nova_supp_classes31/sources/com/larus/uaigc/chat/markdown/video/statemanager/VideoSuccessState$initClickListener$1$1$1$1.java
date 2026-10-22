package com.larus.uaigc.chat.markdown.video.statemanager;

import android.content.Context;
import android.widget.TextView;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationReportService;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$initClickListener$1$1$1$1", f = "VideoSuccessState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoSuccessState$initClickListener$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserCreationFromIM $creation;
    final /* synthetic */ UserCreationRefContent $creationRefContent;
    final /* synthetic */ Message $message;
    final /* synthetic */ CreationTask $successTaskMap;
    final /* synthetic */ nr9.g $videoPlayData;
    final /* synthetic */ TextView $view;
    int label;
    final /* synthetic */ i this$0;

    public VideoSuccessState$initClickListener$1$1$1$1(TextView r1, nr9.g r2, Message r3, UserCreationFromIM r4, UserCreationRefContent r5, CreationTask r6, i r7, Continuation<? super VideoSuccessState$initClickListener$1$1$1$1> r8) {
        this.$view = r1;
        this.$videoPlayData = r2;
        this.$message = r3;
        this.$creation = r4;
        this.$creationRefContent = r5;
        this.$successTaskMap = r6;
        this.this$0 = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new VideoSuccessState$initClickListener$1$1$1$1(this.$view, this.$videoPlayData, this.$message, this.$creation, this.$creationRefContent, this.$successTaskMap, this.this$0, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r36);
        hy9.d r2 = ICreationReportService.a.j();
        String r3 = AppHost.a.getApplication().getString(2131905605);
        LruCache r1 = ko8.a.a;
        hy9.d.a.a(r2, r3, null, null, "video_overview", "single_function", null, null, null, null, ko8.a.h(ko8.a.e), null, null, null, null, null, null, null, null, "chat", null, null, 3931622);
        IAIChatUgcAIGCService.Companion r25 = IAIChatUgcAIGCService.a;
        Context r26 = this.$view.getContext();
        nr9.g r4 = this.$videoPlayData;
        Message r5 = this.$message;
        Function4 r6 = null;
        if (r5 == null) goto L7;
        String r28 = r5.getMessageId();
    L8:
        UserCreationFromIM r7 = this.$creation;
        if (r7 == null) goto L11;
        String r29 = r7.getPrompt();
    L12:
        UserCreationRefContent r8 = this.$creationRefContent;
        if (r8 == null) goto L21;
        List<ImageInfo> r9 = r8.a();
        if (r9 == null) goto L21;
        ImageInfo r10 = (ImageInfo) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L21;
        Image r11 = r10.c;
        if (r11 == null) goto L21;
        String r30 = r11.a;
    L22:
        CreationTask r12 = this.$successTaskMap;
        if (r12 == null) goto L25;
        String r31 = r12.id;
    L26:
        q0.a r13 = this.this$0.f();
        if (r13 == null) goto L33;
        o r14 = r13.i2();
        if (r14 == null) goto L33;
        if (r14.i0() != true) goto L33;
        boolean r32 = true;
    L34:
        q0.a r15 = this.this$0.f();
        if (r15 == null) goto L39;
        final ICoreInputAbility r16 = r15.v0();
        if (r16 == null) goto L39;
        r6 = new j(r16);
    L39:
        IAIChatUgcAIGCService.a.c(r25, r26, r4, r28, r29, r30, r31, r32, r6, MapsKt.mapOf(TuplesKt.to("enter_method", "ai_edit_video_overview")));
        return Unit.INSTANCE;
    L33:
        r32 = false;
        goto L34
    L25:
        r31 = null;
    L21:
        r30 = null;
        goto L22
    L11:
        r29 = null;
        goto L12
    L7:
        r28 = null;
        goto L8
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
