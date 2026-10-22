package com.larus.bmhome.chat.layout.holder.video;

import android.content.Context;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.utils.DataConverterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.video.GenerateVideoBox$initClickListener$1$1", f = "GenerateVideoBox.kt", i = {0}, l = {346, 361}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class GenerateVideoBox$initClickListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreationTask $successTaskMap;
    final /* synthetic */ AiGenVideoContentData $videoContent;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GenerateVideoBox this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.video.GenerateVideoBox$initClickListener$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.video.GenerateVideoBox$initClickListener$1$1$1", f = "GenerateVideoBox.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserCreationFromIM $creation;
        final /* synthetic */ UserCreationRefContent $creationRefContent;
        final /* synthetic */ CreationTask $successTaskMap;
        final /* synthetic */ AiGenVideoContentData $videoContent;
        int label;
        final /* synthetic */ GenerateVideoBox this$0;

        public AnonymousClass1(GenerateVideoBox r1, AiGenVideoContentData r2, UserCreationFromIM r3, UserCreationRefContent r4, CreationTask r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$videoContent = r2;
            this.$creation = r3;
            this.$creationRefContent = r4;
            this.$successTaskMap = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$videoContent, this.$creation, this.$creationRefContent, this.$successTaskMap, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L42;
            ResultKt.throwOnFailure(r12);
            IAIChatUgcAIGCService.Companion r1 = IAIChatUgcAIGCService.a;
            Context r2 = this.this$0.getContext();
            nr9.g r3 = ff8.a.a(this.$videoContent);
            Message r13 = this.this$0.p;
            Function4 r0 = null;
            if (r13 == null) goto L7;
            String r4 = r13.getMessageId();
        L8:
            UserCreationFromIM r14 = this.$creation;
            if (r14 == null) goto L11;
            String r5 = r14.getPrompt();
        L12:
            UserCreationRefContent r15 = this.$creationRefContent;
            if (r15 == null) goto L21;
            List r16 = r15.a();
            if (r16 == null) goto L21;
            ImageInfo r17 = (ImageInfo) CollectionsKt.firstOrNull(r16);
            if (r17 == null) goto L21;
            Image r18 = r17.c;
            if (r18 == null) goto L21;
            String r6 = r18.a;
        L22:
            CreationTask r19 = this.$successTaskMap;
            if (r19 == null) goto L25;
            String r7 = r19.id;
        L26:
            q0.a r110 = this.this$0.u;
            if (r110 == null) goto L33;
            o r111 = r110.i2();
            if (r111 == null) goto L33;
            boolean r8 = true;
            if (r111.i0() != true) goto L33;
        L34:
            q0.a r112 = this.this$0.u;
            if (r112 == null) goto L39;
            final ICoreInputAbility r113 = r112.v0();
            if (r113 == null) goto L39;
            r0 = new g(r113);
        L39:
            IAIChatUgcAIGCService.a.c(r1, r2, r3, r4, r5, r6, r7, r8, r0, MapsKt.mapOf(TuplesKt.to("enter_method", "ai_edit_video_overview")));
            return Unit.INSTANCE;
        L33:
            r8 = false;
            goto L34
        L25:
            r7 = null;
        L21:
            r6 = null;
            goto L22
        L11:
            r5 = null;
            goto L12
        L7:
            r4 = null;
            goto L8
        L42:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public GenerateVideoBox$initClickListener$1$1(GenerateVideoBox r1, CreationTask r2, AiGenVideoContentData r3, Continuation<? super GenerateVideoBox$initClickListener$1$1> r4) {
        this.this$0 = r1;
        this.$successTaskMap = r2;
        this.$videoContent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        GenerateVideoBox$initClickListener$1$1 r0 = new GenerateVideoBox$initClickListener$1$1(this.this$0, this.$successTaskMap, this.$videoContent, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r35);
    L48:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r35);
        Object r3 = r35;
    L22:
        UserCreationFromIM r9 = (UserCreationFromIM) r3;
        if (r9 == null) goto L39;
        String r4 = r9.getRefContent();
        if (r4 == null) goto L39;
        if ((true ^ StringsKt.isBlank(r4)) == true) goto L30;
        r4 = null;
    L30:
        if (r4 == null) goto L39;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L33
        Object r6 = Result.constructor-impl((UserCreationRefContent) xt7.d.b.c(UserCreationRefContent.Companion.serializer(), r4));     // Catch: Throwable -> L33
    L36:
        if (Result.isFailure-impl(r6) == false) goto L38;
        r6 = null;
    L38:
        UserCreationRefContent r10 = (UserCreationRefContent) r6;
    L40:
        hy9.d r11 = ICreationReportService.a.j();
        Context r7 = this.this$0.getContext();
        if (r7 == null) goto L43;
        String r12 = r7.getString(2131905605);
    L44:
        ChatControlTrace r8 = ChatControlTrace.b;
        r8.getClass();
        hy9.d.a.a(r11, r12, null, null, "video_overview", "single_function", null, null, null, null, r8.bb(ChatControlTrace.y), null, null, null, null, null, null, null, null, "chat", null, null, 3931622);
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass1 r14 = new AnonymousClass1(this.this$0, this.$videoContent, r9, r10, this.$successTaskMap, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r13, r14, this) != r2) goto L48;
        return r2;
    L43:
        r12 = null;
    L33:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        r10 = null;
        goto L40
    L10:
        ResultKt.throwOnFailure(r35);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        Message r17 = this.this$0.p;
        if (r17 == null) goto L13;
        String r18 = r17.getMessageId();
    L14:
        CreationTask r19 = this.$successTaskMap;
        if (r19 == null) goto L18;
        String r20 = r19.id;
        if (r20 == null) goto L18;
    L19:
        this.L$0 = r16;
        this.label = 1;
        r3 = DataConverterKt.e(r18, r20, this);
        if (r3 != r2) goto L22;
        return r2;
    L18:
        r20 = "0";
        goto L19
    L13:
        r18 = null;
        goto L14
    }
}
