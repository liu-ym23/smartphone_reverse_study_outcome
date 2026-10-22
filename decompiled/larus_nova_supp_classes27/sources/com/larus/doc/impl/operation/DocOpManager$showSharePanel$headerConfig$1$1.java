package com.larus.doc.impl.operation;

import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.doc.impl.DocumentApi;
import com.larus.doc.impl.review.DocAppealCreateRequest;
import com.larus.doc.impl.review.DocAppealCreateResponse;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import t19.s;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showSharePanel$headerConfig$1$1", f = "DocOpManager.kt", i = {}, l = {546}, m = "invokeSuspend", n = {}, s = {})
final class DocOpManager$showSharePanel$headerConfig$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ String $artifactMetaId;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ by7.e $fragment;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ int $trackingResourceType;
    int label;

    /* JADX INFO: renamed from: com.larus.doc.impl.operation.DocOpManager$showSharePanel$headerConfig$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showSharePanel$headerConfig$1$1$1", f = "DocOpManager.kt", i = {}, l = {548}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ String $artifactMetaId;
        final /* synthetic */ String $currentPage;
        final /* synthetic */ by7.e $fragment;
        final /* synthetic */ String $resourceId;
        final /* synthetic */ int $trackingResourceType;
        int label;

        /* JADX INFO: renamed from: com.larus.doc.impl.operation.DocOpManager$showSharePanel$headerConfig$1$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/doc/impl/review/DocAppealCreateResponse;", "Lcom/larus/doc/impl/DocumentApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showSharePanel$headerConfig$1$1$1$1", f = "DocOpManager.kt", i = {}, l = {548}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00241 extends SuspendLambda implements Function2<DocumentApi, Continuation<? super BizResponse<DocAppealCreateResponse>>, Object> {
            final /* synthetic */ DocAppealCreateRequest $createAppealRequest;
            private /* synthetic */ Object L$0;
            int label;

            public C00241(DocAppealCreateRequest r1, Continuation<? super C00241> r2) {
                this.$createAppealRequest = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00241 r0 = new C00241(this.$createAppealRequest, r4);
                r0.L$0 = r3;
                return r0;
            }

            public final Object invoke(DocumentApi r1, Continuation<? super BizResponse<DocAppealCreateResponse>> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((DocumentApi) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                DocumentApi r5 = (DocumentApi) this.L$0;
                DocAppealCreateRequest r2 = this.$createAppealRequest;
                this.label = 1;
                r4 = r5.createAppeal(r2, this);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        public AnonymousClass1(String r1, FragmentActivity r2, String r3, int r4, String r5, by7.e r6, Continuation<? super AnonymousClass1> r7) {
            this.$resourceId = r1;
            this.$activity = r2;
            this.$artifactMetaId = r3;
            this.$trackingResourceType = r4;
            this.$currentPage = r5;
            this.$fragment = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass1(this.$resourceId, this.$activity, this.$artifactMetaId, this.$trackingResourceType, this.$currentPage, this.$fragment, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            s.j(s.a, this.$activity, AppHost.a.getApplication().getString(2131910123), null, false, 28);
            u0.i(true, this.$resourceId, this.$artifactMetaId, Boxing.boxInt(this.$trackingResourceType), this.$currentPage, this.$fragment);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            DocAppealCreateRequest r15 = new DocAppealCreateRequest(0, this.$resourceId, 1, null);
            DocumentApi.a r2 = DocumentApi.a;
            C00241 r3 = new C00241(r15, null);
            this.label = 1;
            r2.getClass();
            if (DocumentApi.a.a(r3, this) != r0) goto L11;
            return r0;
        }
    }

    public DocOpManager$showSharePanel$headerConfig$1$1(String r1, FragmentActivity r2, String r3, int r4, String r5, by7.e r6, Continuation<? super DocOpManager$showSharePanel$headerConfig$1$1> r7) {
        this.$resourceId = r1;
        this.$activity = r2;
        this.$artifactMetaId = r3;
        this.$trackingResourceType = r4;
        this.$currentPage = r5;
        this.$fragment = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DocOpManager$showSharePanel$headerConfig$1$1(this.$resourceId, this.$activity, this.$artifactMetaId, this.$trackingResourceType, this.$currentPage, this.$fragment, r10);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r13 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$resourceId, this.$activity, this.$artifactMetaId, this.$trackingResourceType, this.$currentPage, this.$fragment, null);
        this.label = 1;
        if (BuildersKt.withContext(r13, r2, this) != r0) goto L12;
        return r0;
    }
}
