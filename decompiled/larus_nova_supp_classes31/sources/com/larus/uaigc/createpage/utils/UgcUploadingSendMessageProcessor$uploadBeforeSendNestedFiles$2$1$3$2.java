package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {698, 707, 732, 723, 732, 732}, m = "invokeSuspend", n = {}, s = {})
final class UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y8 $dependency;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ AtomicInteger $handlingFileCount;
    final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
    final /* synthetic */ Ref.ObjectRef<String> $localTextMessageId;
    final /* synthetic */ AtomicBoolean $messageSent;
    final /* synthetic */ Function3<ICoreInputAbility.OnSendParams, String, String, Unit> $originalLogic;
    final /* synthetic */ ICoreInputAbility.OnSendParams $params;
    Object L$0;
    int label;
    final /* synthetic */ UgcUploadingSendMessageProcessor this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
        int label;

        public AnonymousClass1(Ref.ObjectRef<String> r1, UplinkFileEntity r2, Continuation<? super AnonymousClass1> r3) {
            this.$localNestedFileMessageId = r1;
            this.$entity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$localNestedFileMessageId, this.$entity, r4);
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
            NestedFileCacheManagerService.b.k((String) this.$localNestedFileMessageId.element, this.$entity);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2$2", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UplinkFileEntity $entity;
        final /* synthetic */ Ref.ObjectRef<String> $localNestedFileMessageId;
        int label;

        public AnonymousClass2(Ref.ObjectRef<String> r1, UplinkFileEntity r2, Continuation<? super AnonymousClass2> r3) {
            this.$localNestedFileMessageId = r1;
            this.$entity = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$localNestedFileMessageId, this.$entity, r4);
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
            NestedFileCacheManagerService.b.k((String) this.$localNestedFileMessageId.element, this.$entity);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2(y8 r1, ICoreInputAbility.OnSendParams r2, UplinkFileEntity r3, UgcUploadingSendMessageProcessor r4, Ref.ObjectRef<String> r5, AtomicInteger r6, AtomicBoolean r7, Map<String, String> r8, Ref.ObjectRef<String> r9, Function3<? super ICoreInputAbility.OnSendParams, ? super String, ? super String, Unit> r10, Continuation<? super UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2> r11) {
        this.$dependency = r1;
        this.$params = r2;
        this.$entity = r3;
        this.this$0 = r4;
        this.$localNestedFileMessageId = r5;
        this.$handlingFileCount = r6;
        this.$messageSent = r7;
        this.$ext = r8;
        this.$localTextMessageId = r9;
        this.$originalLogic = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$2(this.$dependency, this.$params, this.$entity, this.this$0, this.$localNestedFileMessageId, this.$handlingFileCount, this.$messageSent, this.$ext, this.$localTextMessageId, this.$originalLogic, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L17;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L7;
            case 5: goto L11;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Throwable r0 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r18);
        throw r0;
    L7:
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L9
    L69:
        int r1 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i("NestedFileSendMessageProcessor", "[imageReview] handlingFileCount decremented, remaining: " + r1 + ", identifier: " + this.$entity.getFileIdentifier());
        UgcUploadingSendMessageProcessor r2 = this.this$0;
        AtomicInteger r3 = this.$handlingFileCount;
        AtomicBoolean r4 = this.$messageSent;
        ICoreInputAbility.OnSendParams r5 = this.$params;
        Map<String, String> r6 = this.$ext;
        String r7 = (String) this.$localNestedFileMessageId.element;
        String r8 = (String) this.$localTextMessageId.element;
        Function3<ICoreInputAbility.OnSendParams, String, String, Unit> r9 = this.$originalLogic;
        this.label = 5;
        if (UgcUploadingSendMessageProcessor.a(r2, r3, r4, r5, r6, r7, r8, r9, this) != r11) goto L73;
        return r11;
    L73:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r18);
        goto L73
    L12:
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L15
    L63:
        int r10 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i("NestedFileSendMessageProcessor", "[imageReview] handlingFileCount decremented, remaining: " + r10 + ", identifier: " + this.$entity.getFileIdentifier());
        UgcUploadingSendMessageProcessor r12 = this.this$0;
        AtomicInteger r13 = this.$handlingFileCount;
        AtomicBoolean r14 = this.$messageSent;
        ICoreInputAbility.OnSendParams r15 = this.$params;
        Map<String, String> r16 = this.$ext;
        String r17 = (String) this.$localNestedFileMessageId.element;
        String r19 = (String) this.$localTextMessageId.element;
        Function3<ICoreInputAbility.OnSendParams, String, String, Unit> r20 = this.$originalLogic;
        this.label = 3;
        if (UgcUploadingSendMessageProcessor.a(r12, r13, r14, r15, r16, r17, r19, r20, this) != r11) goto L73;
        return r11;
    L13:
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L15
        Object r21 = r18;
        boolean r22 = true;
    L55:
        Boolean r23 = (Boolean) r21;     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r23, Boxing.boxBoolean(false)) == false) goto L61;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.NOT_COMPLIANT.getValue()));     // Catch: Throwable -> L15
        MainCoroutineDispatcher r24 = Dispatchers.getMain();     // Catch: Throwable -> L15
        AnonymousClass1 r25 = new AnonymousClass1(this.$localNestedFileMessageId, this.$entity, null);     // Catch: Throwable -> L15
        this.label = 2;     // Catch: Throwable -> L15
        if (BuildersKt.withContext(r24, r25, this) != r11) goto L63;
        return r11;
    L61:
        if (Intrinsics.areEqual(r23, Boxing.boxBoolean(r22)) == false) goto L63;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.ACCESS.getValue()));     // Catch: Throwable -> L15
        goto L63
    L17:
        ResultKt.throwOnFailure(r18);
        com.larus.bmhome.chat.component.cvs.y r26 = this.$dependency.u0();     // Catch: Throwable -> L15
        if (r26 == null) goto L23;
        wc9.e r27 = r26.h();     // Catch: Throwable -> L15
        if (r27 == null) goto L23;
        String r28 = r27.a;     // Catch: Throwable -> L15
    L24:
        com.larus.bmhome.chat.component.cvs.y r29 = this.$dependency.u0();     // Catch: Throwable -> L15
        if (r29 == null) goto L29;
        wc9.e r30 = r29.h();     // Catch: Throwable -> L15
        if (r30 == null) goto L29;
        String r31 = r30.B;     // Catch: Throwable -> L15
    L30:
        CustomMultiAttachmentInfo r32 = this.$params.getCustomMultiAttachment();     // Catch: Throwable -> L15
        if (r32 != null) goto L33;
    L35:
        boolean r33 = false;
    L36:
        if (r33 == false) goto L38;
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.PROCESSING.getValue()));     // Catch: Throwable -> L15
        goto L63
    L38:
        UgcUploadingSendMessageProcessor r34 = this.this$0;     // Catch: Throwable -> L15
        UplinkEntityContent r35 = this.$entity.getUplinkEntityContent();     // Catch: Throwable -> L15
        if (r35 == null) goto L43;
        Image r36 = r35.getUplinkImageInfo();     // Catch: Throwable -> L15
        if (r36 == null) goto L43;
        String r37 = r36.key;     // Catch: Throwable -> L15
    L44:
        if (r37 != null) goto L46;
        r37 = "";
    L46:
        String r38 = r37;
        UplinkFileEntity r39 = this.$entity;     // Catch: Throwable -> L15
        String r40 = (String) this.$localNestedFileMessageId.element;     // Catch: Throwable -> L15
        CustomMultiAttachmentInfo r41 = this.$params.getCustomMultiAttachment();     // Catch: Throwable -> L15
        if (r41 != null) goto L49;
    L51:
        boolean r42 = false;
    L52:
        this.label = 1;     // Catch: Throwable -> L15
        r22 = true;
        r21 = UgcUploadingSendMessageProcessor.b(r34, r38, r39, r40, r28, r31, r42, this);     // Catch: Throwable -> L15
        if (r21 != r11) goto L55;
        return r11;
    L49:
        if (r41.getPreHandleV2Check() != true) goto L51;
        r42 = true;
    L43:
        r37 = null;
        goto L44
    L33:
        if (r32.getOnlyRegisterCheck() != true) goto L35;
        r33 = true;
    L29:
        r31 = null;
    L23:
        r28 = null;
        goto L24
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        th = move-exception;
        FLogger.a.e("NestedFileSendMessageProcessor", "[imageReview] review failed, identifier: " + this.$entity.getFileIdentifier(), th);     // Catch: Throwable -> L9
        this.$entity.setFileReviewStatus(Boxing.boxInt(FileReviewState.NOT_COMPLIANT.getValue()));     // Catch: Throwable -> L9
        MainCoroutineDispatcher r43 = Dispatchers.getMain();     // Catch: Throwable -> L9
        AnonymousClass2 r44 = new AnonymousClass2(this.$localNestedFileMessageId, this.$entity, null);     // Catch: Throwable -> L9
        this.label = 4;     // Catch: Throwable -> L9
        if (BuildersKt.withContext(r43, r44, this) != r11) goto L69;
        return r11;
    L9:
        th = move-exception;
        int r45 = this.$handlingFileCount.decrementAndGet();
        FLogger.a.i("NestedFileSendMessageProcessor", "[imageReview] handlingFileCount decremented, remaining: " + r45 + ", identifier: " + this.$entity.getFileIdentifier());
        UgcUploadingSendMessageProcessor r46 = this.this$0;
        AtomicInteger r47 = this.$handlingFileCount;
        AtomicBoolean r48 = this.$messageSent;
        ICoreInputAbility.OnSendParams r49 = this.$params;
        Map<String, String> r50 = this.$ext;
        String r51 = (String) this.$localNestedFileMessageId.element;
        String r52 = (String) this.$localTextMessageId.element;
        Function3<ICoreInputAbility.OnSendParams, String, String, Unit> r53 = this.$originalLogic;
        this.L$0 = th;
        this.label = 6;
        if (UgcUploadingSendMessageProcessor.a(r46, r47, r48, r49, r50, r51, r52, r53, this) != r11) goto L79;
        return r11;
    L79:
        throw th;
    }
}
