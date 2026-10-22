package com.larus.bmhome.video.fragment;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationRefContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$onDoCreationAction$1", f = "AiGenVideoDetailFragment.kt", i = {0}, l = {817, 825}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class AiGenVideoDetailFragment$onDoCreationAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$onDoCreationAction$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$onDoCreationAction$1$1", f = "AiGenVideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserCreationFromIM $creation;
        final /* synthetic */ UserCreationRefContent $creationRefContent;
        int label;
        final /* synthetic */ AiGenVideoDetailFragment this$0;

        public AnonymousClass1(AiGenVideoDetailFragment r1, UserCreationFromIM r2, UserCreationRefContent r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$creation = r2;
            this.$creationRefContent = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$creation, this.$creationRefContent, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r6);
            final AiGenVideoDetailFragment r7 = this.this$0;
            nr9.g r0 = r7.e;
            if (r0 == null) goto L20;
            UserCreationFromIM r1 = this.$creation;
            UserCreationRefContent r2 = this.$creationRefContent;
            Function4<nr9.g, String, String, Function1<? super Boolean, Unit>, Unit> r3 = r7.D;
            String r4 = null;
            if (r1 == null) goto L9;
            String r5 = r1.getPrompt();
        L10:
            if (r2 == null) goto L18;
            List r8 = r2.a();
            if (r8 == null) goto L18;
            ImageInfo r9 = (ImageInfo) CollectionsKt.firstOrNull(r8);
            if (r9 == null) goto L18;
            Image r10 = r9.c;
            if (r10 == null) goto L18;
            r4 = r10.a;
        L18:
            r3.invoke(r0, r5, r4, new j(r7));
            goto L20
        L9:
            r5 = null;
        L20:
            return Unit.INSTANCE;
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AiGenVideoDetailFragment$onDoCreationAction$1(AiGenVideoDetailFragment r1, Continuation<? super AiGenVideoDetailFragment$onDoCreationAction$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AiGenVideoDetailFragment$onDoCreationAction$1 r0 = new AiGenVideoDetailFragment$onDoCreationAction$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L35:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L13:
        UserCreationFromIM r9 = (UserCreationFromIM) r8;
        if (r9 == null) goto L30;
        String r4 = r9.getRefContent();
        if (r4 == null) goto L30;
        if ((true ^ StringsKt.isBlank(r4)) == true) goto L21;
        r4 = null;
    L21:
        if (r4 == null) goto L30;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L24
        Object r5 = Result.constructor-impl((UserCreationRefContent) xt7.d.b.c(UserCreationRefContent.Companion.serializer(), r4));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r5) == false) goto L29;
        r5 = null;
    L29:
        UserCreationRefContent r6 = (UserCreationRefContent) r5;
    L31:
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        AnonymousClass1 r10 = new AnonymousClass1(this.this$0, r9, r6, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r7, r10, this) != r0) goto L35;
        return r0;
    L24:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L30:
        r6 = null;
        goto L31
    L10:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        AiGenVideoDetailFragment r13 = this.this$0;
        int r14 = AiGenVideoDetailFragment.U;
        String r15 = r13.la0();
        this.L$0 = r12;
        this.label = 1;
        r8 = r13.ka0(r15, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
