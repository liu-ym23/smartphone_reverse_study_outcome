package com.larus.uaigc.createpage.component.instruction;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.uaigc.service.ICreationWorkflowService;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$onAlbumSelected$1", f = "CreationEditorComponent.kt", i = {}, l = {4369}, m = "invokeSuspend", n = {}, s = {})
public final class CreationEditorComponent$onAlbumSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$onAlbumSelected$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$onAlbumSelected$1$1", f = "CreationEditorComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Uri $finalUri;
        int label;
        final /* synthetic */ CreationEditorComponent this$0;

        public AnonymousClass1(CreationEditorComponent r1, Uri r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$finalUri = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$finalUri, r4);
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
            CreationEditorComponent r4 = this.this$0;
            String r0 = this.$finalUri.toString();
            int r1 = CreationEditorComponent.g2;
            r4.V3(r0, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationEditorComponent$onAlbumSelected$1(Uri r1, CreationEditorComponent r2, Continuation<? super CreationEditorComponent$onAlbumSelected$1> r3) {
        this.$uri = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationEditorComponent$onAlbumSelected$1(this.$uri, this.this$0, r4);
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
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        Uri r8 = Uri.fromFile(ICreationWorkflowService.a.T("jpeg"));
        CreationEditorComponent r2 = this.this$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl(s1a.a.c(r2).getActivity());     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == false) goto L16;
        r4 = null;
    L16:
        FragmentActivity r5 = (FragmentActivity) r4;
        if (r5 == null) goto L19;
        ICreationWorkflowService.Companion r6 = ICreationWorkflowService.a;
        Uri r9 = this.$uri;
        Intrinsics.checkNotNull(r8);
        r6.M(r5, r9, r8);
        MainCoroutineDispatcher r10 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, r8, null);
        this.label = 1;
        if (BuildersKt.withContext(r10, r11, this) != r0) goto L24;
        return r0;
    L19:
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
