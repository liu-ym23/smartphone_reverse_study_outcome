package com.larus.doc.impl.operation;

import android.app.Application;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import t19.s;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$deleteDoc$showDialog$1$2$confirm$1", f = "DocOpManager.kt", i = {1}, l = {923, 926, 928}, m = "invokeSuspend", n = {"isSuccess"}, s = {"I$0"})
public final class DocOpManager$deleteDoc$showDialog$1$2$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $artifactMetaId;
    final /* synthetic */ Map<String, Object> $bizExtra;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ boolean $needNotifyDocList;
    final /* synthetic */ String $resourceId;
    final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ by7.e $trackNode;
    final /* synthetic */ int $trackingResourceType;
    int I$0;
    int label;

    /* JADX INFO: renamed from: com.larus.doc.impl.operation.DocOpManager$deleteDoc$showDialog$1$2$confirm$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$deleteDoc$showDialog$1$2$confirm$1$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $artifactMetaId;
        final /* synthetic */ String $currentPage;
        final /* synthetic */ boolean $isSuccess;
        final /* synthetic */ String $resourceId;
        final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
        final /* synthetic */ String $showFrom;
        final /* synthetic */ by7.e $trackNode;
        final /* synthetic */ int $trackingResourceType;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Boolean, Unit> r1, boolean r2, String r3, String r4, String r5, int r6, String r7, by7.e r8, Continuation<? super AnonymousClass1> r9) {
            this.$resultCallback = r1;
            this.$isSuccess = r2;
            this.$showFrom = r3;
            this.$resourceId = r4;
            this.$artifactMetaId = r5;
            this.$trackingResourceType = r6;
            this.$currentPage = r7;
            this.$trackNode = r8;
            super(2, r9);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new AnonymousClass1(this.$resultCallback, this.$isSuccess, this.$showFrom, this.$resourceId, this.$artifactMetaId, this.$trackingResourceType, this.$currentPage, this.$trackNode, r12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r12);
            Function1<Boolean, Unit> r13 = this.$resultCallback;
            if (r13 == null) goto L8;
            r13.invoke(Boxing.boxBoolean(this.$isSuccess));
        L8:
            if (this.$isSuccess == true) goto L11;
            s r14 = s.a;
            Application r0 = AppHost.a.getApplication();
            r14.getClass();
            s.s(r0, 2131899537);
        L11:
            if (this.$isSuccess == false) goto L13;
            String r15 = "1";
        L14:
            String r1 = this.$showFrom;
            u0.f(r1, r15, null, "delete", this.$resourceId, this.$artifactMetaId, Boxing.boxInt(this.$trackingResourceType), this.$currentPage, null, this.$trackNode, 260);
            return Unit.INSTANCE;
        L13:
            r15 = "0";
            goto L14
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocOpManager$deleteDoc$showDialog$1$2$confirm$1(Context r1, String r2, Map<String, ? extends Object> r3, boolean r4, Function1<? super Boolean, Unit> r5, String r6, String r7, int r8, String r9, by7.e r10, Continuation<? super DocOpManager$deleteDoc$showDialog$1$2$confirm$1> r11) {
        this.$context = r1;
        this.$resourceId = r2;
        this.$bizExtra = r3;
        this.$needNotifyDocList = r4;
        this.$resultCallback = r5;
        this.$showFrom = r6;
        this.$artifactMetaId = r7;
        this.$trackingResourceType = r8;
        this.$currentPage = r9;
        this.$trackNode = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new DocOpManager$deleteDoc$showDialog$1$2$confirm$1(this.$context, this.$resourceId, this.$bizExtra, this.$needNotifyDocList, this.$resultCallback, this.$showFrom, this.$artifactMetaId, this.$trackingResourceType, this.$currentPage, this.$trackNode, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r18);
    L33:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r18);
    L25:
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        Function1<Boolean, Unit> r8 = this.$resultCallback;
        if (r3 == 0) goto L28;
        boolean r9 = true;
    L29:
        AnonymousClass1 r15 = new AnonymousClass1(r8, r9, this.$showFrom, this.$resourceId, this.$artifactMetaId, this.$trackingResourceType, this.$currentPage, this.$trackNode, null);
        this.label = 3;
        if (BuildersKt.withContext(r4, r15, this) != r1) goto L33;
        return r1;
    L28:
        r9 = false;
        goto L29
    L11:
        ResultKt.throwOnFailure(r18);
        Object r5 = r18;
    L16:
        if (((Number) r5).intValue() != 3) goto L18;
        r3 = 1;
    L19:
        if (r3 == 0) goto L25;
        if (this.$needNotifyDocList == false) goto L25;
        MutableSharedFlow<Unit> r7 = DocOpManager.b;
        Unit r10 = Unit.INSTANCE;
        this.I$0 = r3;
        this.label = 2;
        if (r7.emit(r10, this) != r1) goto L25;
        return r1;
    L18:
        r3 = 0;
        goto L19
    L12:
        ResultKt.throwOnFailure(r18);
        DocOpManager r6 = DocOpManager.a;
        Context r11 = this.$context;
        String r12 = this.$resourceId;
        Map<String, Object> r13 = this.$bizExtra;
        this.label = 1;
        r5 = DocOpManager.a(r6, r11, r12, r13, this);
        if (r5 != r1) goto L16;
        return r1;
    }
}
