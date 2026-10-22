package com.larus.doc.impl;

import com.larus.podcast.api.PodcastClickSource;
import com.larus.podcast.api.PodcastGenerateApiKt;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$sendPodcastRequest$2", f = "DocFragment.kt", i = {0}, l = {2176, 2185}, m = "invokeSuspend", n = {"requestId"}, s = {"L$0"})
final class DocFragment$sendPodcastRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DocFragment this$0;

    /* JADX INFO: renamed from: com.larus.doc.impl.DocFragment$sendPodcastRequest$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.DocFragment$sendPodcastRequest$2$1", f = "DocFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
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
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DocFragment$sendPodcastRequest$2(DocFragment r1, Continuation<? super DocFragment$sendPodcastRequest$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DocFragment$sendPodcastRequest$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r5 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L23:
        this.this$0.H2 = null;
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        com.larus.podcast.api.a r11 = (com.larus.podcast.api.a) ((com.larus.network.http.a) r10).b;
        FLogger.a.i("DocFragment", "sendPodcastRequest result=" + r11 + " id=" + r2);
        if (r11 != null) goto L16;
    L18:
        r5 = false;
    L19:
        if (r5 == false) goto L23;
        t19.s.a.g(this.this$0.getContext(), 2131908397, false);
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r12, r3, this) != r0) goto L23;
        return r0;
    L16:
        if (r11.c() != true) goto L18;
    L10:
        ResultKt.throwOnFailure(r10);
        r2 = this.this$0.f;
        PodcastClickSource r13 = PodcastClickSource.Doc;
        this.L$0 = r2;
        this.label = 1;
        r10 = PodcastGenerateApiKt.a(r2, false, r13, null, this);
        if (r10 != r0) goto L13;
        return r0;
    }
}
