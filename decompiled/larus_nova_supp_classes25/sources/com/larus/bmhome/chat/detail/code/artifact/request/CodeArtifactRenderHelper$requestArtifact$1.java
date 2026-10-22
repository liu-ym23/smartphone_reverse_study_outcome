package com.larus.bmhome.chat.detail.code.artifact.request;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper$requestArtifact$1", f = "CodeArtifactRenderHelper.kt", i = {}, l = {MessageCellStateTransformerType.MUSIC, MessageCellStateTransformerType.SEARCH_LIST, MessageCellStateTransformerType.BOT_MAKER}, m = "invokeSuspend", n = {}, s = {})
final class CodeArtifactRenderHelper$requestArtifact$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $codeId;
    final /* synthetic */ b $listener;
    final /* synthetic */ Integer $version;
    int label;
    final /* synthetic */ a this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper$requestArtifact$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper$requestArtifact$1$1", f = "CodeArtifactRenderHelper.kt", i = {}, l = {MessageCellStateTransformerType.MUSIC}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends CodeNodeContent, ? extends Boolean>>, Object> {
        final /* synthetic */ long $codeId;
        final /* synthetic */ Integer $version;
        int label;
        final /* synthetic */ a this$0;

        public AnonymousClass1(a r1, long r2, Integer r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$codeId = r2;
            this.$version = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$codeId, this.$version, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Pair<CodeNodeContent, Boolean>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            a r7 = this.this$0;
            long r3 = this.$codeId;
            Integer r2 = this.$version;
            this.label = 1;
            r6 = a.a(r7, r3, r2, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper$requestArtifact$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper$requestArtifact$1$2", f = "CodeArtifactRenderHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $listener;
        final /* synthetic */ CodeNodeContent $renderCodeNode;
        int label;

        public AnonymousClass2(b r1, CodeNodeContent r2, Continuation<? super AnonymousClass2> r3) {
            this.$listener = r1;
            this.$renderCodeNode = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$listener, this.$renderCodeNode, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$listener.a(this.$renderCodeNode);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper$requestArtifact$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper$requestArtifact$1$3", f = "CodeArtifactRenderHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $listener;
        int label;

        public AnonymousClass3(b r1, Continuation<? super AnonymousClass3> r2) {
            this.$listener = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.$listener, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$listener.onError();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CodeArtifactRenderHelper$requestArtifact$1(a r1, long r2, Integer r4, b r5, Continuation<? super CodeArtifactRenderHelper$requestArtifact$1> r6) {
        this.this$0 = r1;
        this.$codeId = r2;
        this.$version = r4;
        this.$listener = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CodeArtifactRenderHelper$requestArtifact$1(this.this$0, this.$codeId, this.$version, this.$listener, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
    L26:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r12);
    L15:
        Pair r13 = (Pair) r12;
        CodeNodeContent r2 = (CodeNodeContent) r13.component1();
        if (((Boolean) r13.component2()).booleanValue() == false) goto L26;
        if (r2 == null) goto L22;
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass2 r4 = new AnonymousClass2(this.$listener, r2, null);
        this.label = 2;
        if (BuildersKt.withContext(r3, r4, this) != r0) goto L26;
        return r0;
    L22:
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        AnonymousClass3 r6 = new AnonymousClass3(this.$listener, null);
        this.label = 3;
        if (BuildersKt.withContext(r5, r6, this) != r0) goto L26;
        return r0;
    L12:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r14 = Dispatchers.getIO();
        AnonymousClass1 r7 = new AnonymousClass1(this.this$0, this.$codeId, this.$version, null);
        this.label = 1;
        r12 = BuildersKt.withContext(r14, r7, this);
        if (r12 != r0) goto L15;
        return r0;
    }
}
