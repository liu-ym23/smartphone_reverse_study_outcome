package com.larus.community.impl.detail.prompt;

import com.facebook.common.references.CloseableReference;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.prompt.CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1", f = "CreationDetailPromptRefImageViewerDialog.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
final class CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    int label;
    final /* synthetic */ CreationDetailPromptRefImageViewerDialog this$0;

    /* JADX INFO: renamed from: com.larus.community.impl.detail.prompt.CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.detail.prompt.CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1", f = "CreationDetailPromptRefImageViewerDialog.kt", i = {1}, l = {108, 113}, m = "invokeSuspend", n = {"imageReference"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $imageUrl;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CreationDetailPromptRefImageViewerDialog this$0;

        public AnonymousClass1(String r1, CreationDetailPromptRefImageViewerDialog r2, Continuation<? super AnonymousClass1> r3) {
            this.$imageUrl = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$imageUrl, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Unit r2 = null;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L15;
            if (r1 != 2) goto L14;
            CloseableReference r3 = (CloseableReference) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L9 Exception -> L11
        L29:
            Unit r10 = (Unit) r9;     // Catch: Throwable -> L9 Exception -> L11
        L30:
            r2 = r10;
            r3.close();     // Catch: Throwable -> L43
        L41:
            Object r11 = Result.constructor-impl(r2);     // Catch: Throwable -> L43
        L45:
            Result.isFailure-impl(r11);
            return Unit.INSTANCE;
        L11:
            Exception e = e;
        L35:
            FLogger.a.e("CreationDetailPromptRefImageViewerDialog", e.toString());     // Catch: Throwable -> L9
            r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            CloseableReference r7 = r3;
            th = th;
            CloseableReference r12 = r7;
        L39:
            r12.close();     // Catch: Throwable -> L43
            throw th;     // Catch: Throwable -> L43
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            CreationDetailPromptRefImageViewerDialog r4 = (CreationDetailPromptRefImageViewerDialog) this.L$1;
            String r5 = (String) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L43
        L23:
            r12 = (CloseableReference) r9;     // Catch: Throwable -> L43
            if (r12 == null) goto L41;
            MainCoroutineDispatcher r6 = Dispatchers.getMain();     // Catch: Throwable -> L31 Exception -> L33
            CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1$1$1$1 r8 = new CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1$1$1$1(r12, r4, r5, null);     // Catch: Throwable -> L31 Exception -> L33
            this.L$0 = r12;     // Catch: Throwable -> L31 Exception -> L33
            this.L$1 = null;     // Catch: Throwable -> L31 Exception -> L33
            this.label = 2;     // Catch: Throwable -> L31 Exception -> L33
            Object r13 = BuildersKt.withContext(r6, r8, this);     // Catch: Throwable -> L31 Exception -> L33
            if (r13 != r0) goto L28;
            return r0;
        L28:
            r3 = r12;
            r9 = r13;
            goto L29
        L33:
            e = move-exception;
            r3 = r12;
            e = e;
        L31:
            th = th;
            goto L39
        L18:
            ResultKt.throwOnFailure(r9);
            String r14 = this.$imageUrl;
            r4 = this.this$0;
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L43
            this.L$0 = r14;     // Catch: Throwable -> L43
            this.L$1 = r4;     // Catch: Throwable -> L43
            this.label = 1;     // Catch: Throwable -> L43
            Object r16 = ImageLoaderKt.i(r14, "community_creation_photo", null, this, 60);     // Catch: Throwable -> L43
            if (r16 != r0) goto L22;
            return r0;
        L22:
            r5 = r14;
            r9 = r16;
        L43:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L45
        }
    }

    public CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1(String r1, CreationDetailPromptRefImageViewerDialog r2, Continuation<? super CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1> r3) {
        this.$imageUrl = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1(this.$imageUrl, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$imageUrl, this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
