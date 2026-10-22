package com.larus.sheet.operation;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.larus.common.apphost.AppHost;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.j;
import t19.s;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.sheet.operation.SheetOpManager$deleteSheet$showDialog$1$2$confirm$1", f = "SheetOpManager.kt", i = {}, l = {271, 272}, m = "invokeSuspend", n = {}, s = {})
public final class SheetOpManager$deleteSheet$showDialog$1$2$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $artifactMetaId;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ int $resourceType;
    final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
    final /* synthetic */ String $sheetToken;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ by7.e $trackNode;
    int label;

    /* JADX INFO: renamed from: com.larus.sheet.operation.SheetOpManager$deleteSheet$showDialog$1$2$confirm$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.sheet.operation.SheetOpManager$deleteSheet$showDialog$1$2$confirm$1$1", f = "SheetOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $artifactMetaId;
        final /* synthetic */ String $currentPage;
        final /* synthetic */ boolean $isSuccess;
        final /* synthetic */ int $resourceType;
        final /* synthetic */ Function1<Boolean, Unit> $resultCallback;
        final /* synthetic */ String $sheetToken;
        final /* synthetic */ String $showFrom;
        final /* synthetic */ by7.e $trackNode;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Boolean, Unit> r1, boolean r2, String r3, String r4, String r5, int r6, String r7, by7.e r8, Continuation<? super AnonymousClass1> r9) {
            this.$resultCallback = r1;
            this.$isSuccess = r2;
            this.$showFrom = r3;
            this.$sheetToken = r4;
            this.$artifactMetaId = r5;
            this.$resourceType = r6;
            this.$currentPage = r7;
            this.$trackNode = r8;
            super(2, r9);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new AnonymousClass1(this.$resultCallback, this.$isSuccess, this.$showFrom, this.$sheetToken, this.$artifactMetaId, this.$resourceType, this.$currentPage, this.$trackNode, r12);
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
            u0.f(r1, r15, null, "delete", this.$sheetToken, this.$artifactMetaId, Boxing.boxInt(this.$resourceType), this.$currentPage, null, this.$trackNode, 260);
            return Unit.INSTANCE;
        L13:
            r15 = "0";
            goto L14
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SheetOpManager$deleteSheet$showDialog$1$2$confirm$1(String r1, int r2, Function1<? super Boolean, Unit> r3, String r4, String r5, String r6, by7.e r7, Continuation<? super SheetOpManager$deleteSheet$showDialog$1$2$confirm$1> r8) {
        this.$sheetToken = r1;
        this.$resourceType = r2;
        this.$resultCallback = r3;
        this.$showFrom = r4;
        this.$artifactMetaId = r5;
        this.$currentPage = r6;
        this.$trackNode = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new SheetOpManager$deleteSheet$showDialog$1$2$confirm$1(this.$sheetToken, this.$resourceType, this.$resultCallback, this.$showFrom, this.$artifactMetaId, this.$currentPage, this.$trackNode, r11);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L23:
        boolean r5 = ((Boolean) r14).booleanValue();
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$resultCallback, r5, this.$showFrom, this.$sheetToken, this.$artifactMetaId, this.$resourceType, this.$currentPage, this.$trackNode, null);
        this.label = 2;
        if (BuildersKt.withContext(r15, r2, this) != r0) goto L27;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        HashMap<String, MutableLiveData<Boolean>> r16 = f.a;
        String r17 = this.$sheetToken;
        int r3 = this.$resourceType;
        this.label = 1;
        IOfficeSdkServiceV2 r4 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r4 == null) goto L15;
        ik5.a r6 = r4.c0();
        if (r6 == null) goto L15;
        com.bytedance.ee.bear.list.delete.f r7 = r6.R();
    L16:
        if (r7 != null) goto L18;
        FLogger.a.e("SheetOpManager", "deleteByToken failed, delete executor is null");
        r14 = Boxing.boxBoolean(false);
    L21:
        if (r14 != r0) goto L23;
        return r0;
    L18:
        j r8 = new j(IntrinsicsKt.intercepted(this), 1);
        r8.C();
        r7.e(r17, r3, new d(r8));
        r14 = r8.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(this);
    L15:
        r7 = null;
        goto L16
    }
}
