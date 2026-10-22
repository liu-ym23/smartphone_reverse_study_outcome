package com.obric.assistant.cocreationreview;

import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.im.bean.message.UplinkFileEntity;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationFeedbackMediaUploader$upload$1", f = "CocreationFeedbackMediaUploader.kt", i = {}, l = {MessageContentType.FORM_MSG}, m = "invokeSuspend", n = {}, s = {})
final class CocreationFeedbackMediaUploader$upload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c5 $callback;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $identifier;
    final /* synthetic */ AtomicBoolean $terminal;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ q this$0;

    public static final class a implements com.larus.bmhome.chat.component.bottom.multimodal.upload.m {
        public final /* synthetic */ q a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ c5 d;

        public final void c(boolean r8) {
            if (r8 == false) goto L13;
            q r9 = this.a;
            String r0 = this.b;
            AtomicBoolean r1 = this.c;
            c5 r2 = this.d;
            r9.getClass();
            boolean r3 = false;
            boolean r5 = r1.compareAndSet(false, true);
            if (r5 == false) goto L6;
            r9.c.remove(r0, r1);
        L6:
            if (r5 == true) goto L8;
        L10:
            if (r3 == false) goto L14;
            r2.onFailure(r0, "不支持该媒体文件");
            return;
        L14:
            return;
        L8:
            if (r9.b.get() == true) goto L10;
            r3 = true;
            goto L10
        }

        public final void d(ic8.n0 r8) {
            Intrinsics.checkNotNullParameter(r8, "processResult");
            ProcessFileResultCode r9 = r8.b;
            boolean r0 = true;
            if (r9 != null) goto L5;
        L7:
            boolean r10 = false;
        L8:
            if (r10 == true) goto L20;
            q r11 = this.a;
            String r2 = this.b;
            AtomicBoolean r3 = this.c;
            c5 r4 = this.d;
            r11.getClass();
            boolean r5 = r3.compareAndSet(false, true);
            if (r5 == false) goto L12;
            r11.c.remove(r2, r3);
        L12:
            if (r5 == true) goto L14;
        L16:
            r0 = false;
        L17:
            if (r0 == false) goto L21;
            r4.onFailure(r2, "媒体处理失败");
            return;
        L21:
            return;
        L14:
            if (r11.b.get() == true) goto L16;
        L20:
            return;
        L5:
            if (r9.isSuccess() != true) goto L7;
            r10 = true;
            goto L8
        }

        public final void a(long r4, String r6) {
            Intrinsics.checkNotNullParameter(r6, "fileIdentifier");
            q r7 = this.a;
            String r0 = this.b;
            AtomicBoolean r1 = this.c;
            if (r7.b.get() == false) goto L5;
        L9:
            boolean r8 = false;
        L10:
            if (r8 == false) goto L13;
            this.d.a(this.b, r4);
            return;
        L13:
            return;
        L5:
            if (r7.c.get(r0) != r1) goto L9;
            if (r1.get() == true) goto L9;
            r8 = true;
            goto L10
        }

        public final void b(mr9.l r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "uploadResult");
            Intrinsics.checkNotNullParameter(r8, "fileIdentifier");
            String r9 = r7.a;
            boolean r10 = false;
            if (r9 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L19;
            q r11 = this.a;
            String r2 = this.b;
            AtomicBoolean r3 = this.c;
            c5 r4 = this.d;
            r11.getClass();
            boolean r5 = r3.compareAndSet(false, true);
            if (r5 == false) goto L13;
            r11.c.remove(r2, r3);
        L13:
            if (r5 == true) goto L15;
        L17:
            if (r10 == false) goto L29;
            r4.onFailure(r2, "媒体上传结果无效");
            return;
        L29:
            return;
        L15:
            if (r11.b.get() == true) goto L17;
            r10 = true;
            goto L17
        L19:
            q r6 = this.a;
            String r12 = this.b;
            AtomicBoolean r13 = this.c;
            r6.getClass();
            boolean r14 = r13.compareAndSet(false, true);
            if (r14 == false) goto L22;
            r6.c.remove(r12, r13);
        L22:
            if (r14 == true) goto L24;
        L26:
            if (r10 == false) goto L31;
            this.d.onSuccess(this.b, r9);
            return;
        L31:
            return;
        L24:
            if (r6.b.get() == true) goto L26;
            r10 = true;
            goto L26
        L5:
            if (StringsKt.isBlank(r9) == true) goto L8;
            r1 = false;
            goto L9
        }

        public final void e(String r7, String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "fileIdentifier");
            q r10 = this.a;
            String r11 = this.b;
            AtomicBoolean r0 = this.c;
            boolean r1 = true;
            if (r7 != null) goto L5;
        L9:
            r7 = "媒体上传失败";
        L10:
            c5 r2 = this.d;
            r10.getClass();
            boolean r4 = r0.compareAndSet(false, true);
            if (r4 == false) goto L13;
            r10.c.remove(r11, r0);
        L13:
            if (r4 == true) goto L15;
        L17:
            r1 = false;
        L18:
            if (r1 == false) goto L21;
            r2.onFailure(r11, r7);
            return;
        L21:
            return;
        L15:
            if (r10.b.get() == true) goto L17;
        L5:
            if ((!StringsKt.isBlank(r7)) == true) goto L8;
            r7 = null;
        L8:
            if (r7 != null) goto L10;
            goto L9
        }

        public a(q r1, String r2, AtomicBoolean r3, c5 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public CocreationFeedbackMediaUploader$upload$1(UplinkFileEntity r1, q r2, String r3, AtomicBoolean r4, c5 r5, Continuation<? super CocreationFeedbackMediaUploader$upload$1> r6) {
        this.$entity = r1;
        this.this$0 = r2;
        this.$identifier = r3;
        this.$terminal = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        CocreationFeedbackMediaUploader$upload$1 r7 = new CocreationFeedbackMediaUploader$upload$1(this.$entity, this.this$0, this.$identifier, this.$terminal, this.$callback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r21);     // Catch: Throwable -> L15
    L13:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        q r4 = this.this$0;
        String r5 = this.$identifier;
        AtomicBoolean r6 = this.$terminal;
        c5 r7 = this.$callback;
        Throwable r8 = Result.exceptionOrNull-impl(r1);
        if (r8 == null) goto L33;
        String r9 = r8.getMessage();
        if (r9 != null) goto L22;
        r9 = "媒体上传失败";
    L22:
        r4.getClass();
        boolean r10 = r6.compareAndSet(false, true);
        if (r10 == false) goto L25;
        r4.c.remove(r5, r6);
    L25:
        if (r10 == true) goto L27;
    L29:
        r3 = false;
    L30:
        if (r3 == false) goto L33;
        r7.onFailure(r5, r9);
        goto L33
    L27:
        if (r4.b.get() == true) goto L29;
    L33:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r21);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        UplinkFileEntity r12 = this.$entity;
        q r13 = this.this$0;
        String r14 = this.$identifier;
        AtomicBoolean r15 = this.$terminal;
        c5 r16 = this.$callback;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L15
        ye8.c r18 = ChatInputService.b.g();     // Catch: Throwable -> L15
        com.larus.bmhome.chat.component.bottom.multimodal.upload.q r19 = new com.larus.bmhome.chat.component.bottom.multimodal.upload.q(NameKeys.UnloadStrategy_No_Strategy, false, new a(r13, r14, r15, r16), "album", r12, false, null, null, null, null, 992);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r18.b(r19, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
