package com.larus.doc.impl.offline;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.create.r0;
import com.bytedance.ee.bear.list.dto.Document;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.offline.OfflineDocCreateComponent$startIfNeeded$1", f = "OfflineDocCreateComponent.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class OfflineDocCreateComponent$startIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $currentConfig;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OfflineDocCreateComponent this$0;

    public static final class a implements nc5.a<DocumentListInfo> {
        public final /* synthetic */ OfflineDocCreateComponent a;
        public final /* synthetic */ f b;

        public final void onFailure(Throwable r5) {
            Intrinsics.checkNotNullParameter(r5, "error");
            String r0 = r5.getMessage();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            this.a.s = null;
            this.a.t = r0;
            this.a.u.countDown();
            int r1 = m39.b.a;
            m39.b.a("创建离线文档失败, 错误:".concat(r0));
            FLogger.a.e("OfflineDocCreateComponent", "[offlineCreate] createDocument failed", r5);
            OfflineDocCreateComponent r6 = this.a;
            r6.X2(r6.l.g(r0));
        }

        public final void onSuccess(Object r6) {
            DocumentListInfo r7 = (DocumentListInfo) r6;
            Intrinsics.checkNotNullParameter(r7, "result");
            this.a.s = r7;
            String r1 = null;
            this.a.t = null;
            this.a.u.countDown();
            OfflineDocCreateCoordinator r0 = this.a.l;
            monitor-enter(r0);
            Intrinsics.checkNotNullParameter(r7, "result");     // Catch: Throwable -> L20
            OfflineDocCreateCoordinator.a r2 = r0.a;     // Catch: Throwable -> L20
            OfflineDocCreateCoordinator.CreateDocumentStatus r3 = OfflineDocCreateCoordinator.CreateDocumentStatus.SUCCEEDED;     // Catch: Throwable -> L20
            r2.getClass();     // Catch: Throwable -> L20
            Intrinsics.checkNotNullParameter(r3, "<set-?>");     // Catch: Throwable -> L20
            r2.a = r3;     // Catch: Throwable -> L20
            OfflineDocCreateCoordinator.a r4 = r0.a;     // Catch: Throwable -> L20
            ArrayList r8 = r7.getDocumentList();     // Catch: Throwable -> L20
            if (r8 == null) goto L13;
            Document r9 = (Document) CollectionsKt.firstOrNull(r8);     // Catch: Throwable -> L20
            if (r9 == null) goto L13;
            String r10 = r9.d;     // Catch: Throwable -> L20
            if (r10 == null) goto L13;
            if ((!StringsKt.isBlank(r10)) == false) goto L13;
            r1 = r10;
        L13:
            r4.g = r1;     // Catch: Throwable -> L20
            if (r0.a.e == false) goto L16;
            e r11 = r0.a("create_document_finished_after_destroy");     // Catch: Throwable -> L20
        L17:
            monitor-exit(r0);
            String r5 = this.a.l.d();
            int r12 = m39.b.a;
            m39.b.a("创建离线文档成功, realToken:" + m39.b.f(r5));
            this.a.L2(r5, this.b.e, "createDocument");
            this.a.X2(r11);
            return;
        L16:
            r11 = r0.b("create_document_finished");     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            throw th;
        }

        public a(OfflineDocCreateComponent r1, f r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public OfflineDocCreateComponent$startIfNeeded$1(OfflineDocCreateComponent r1, f r2, Continuation<? super OfflineDocCreateComponent$startIfNeeded$1> r3) {
        this.this$0 = r1;
        this.$currentConfig = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        OfflineDocCreateComponent$startIfNeeded$1 r0 = new OfflineDocCreateComponent$startIfNeeded$1(this.this$0, this.$currentConfig, r5);
        r0.L$0 = r4;
        return r0;
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
        r0 r2 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L37 CancellationException -> L40
    L20:
        ik5.a r3 = (ik5.a) r7;     // Catch: Exception -> L37 CancellationException -> L40
    L22:
        if (r3 == null) goto L24;
        r2 = r3.Q3();     // Catch: Exception -> L37 CancellationException -> L40
    L24:
        r0 r4 = r2;
        if (r4 != null) goto L28;
        this.this$0.t = "create_folder_executor_not_ready";
        this.this$0.u.countDown();
        OfflineDocCreateComponent r8 = this.this$0;
        r8.X2(r8.l.g("create_folder_executor_not_ready"));
        int r9 = m39.b.a;
        Intrinsics.checkNotNullParameter("create_folder_executor_not_ready", "reason");
        m39.b.a("跳过创建离线文档, 原因:create_folder_executor_not_ready");
        return Unit.INSTANCE;
    L28:
        String r5 = String.valueOf(System.currentTimeMillis());
        int r10 = m39.b.a;
        m39.b.a("开始创建离线文档, fakeToken:" + m39.b.f(r5));
        r4.a(22, "", r5, "109", new a(this.this$0, this.$currentConfig));     // Catch: Exception -> L31 CancellationException -> L35
    L34:
        return Unit.INSTANCE;
    L35:
        e = move-exception;
        throw e;
    L31:
        e = move-exception;
        OfflineDocCreateComponent.F2(this.this$0, e);
        goto L34
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        IOfficeSdkServiceV2 r12 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);     // Catch: Exception -> L37 CancellationException -> L40
        if (r12 == null) goto L14;
        r3 = r12.c0();     // Catch: Exception -> L37 CancellationException -> L40
        if (r3 != null) goto L22;
    L14:
        if (r12 == null) goto L16;
        IOfficeSdkServiceV2.a.b(r12, true, "OfflineDocCreateComponent", 4);     // Catch: Exception -> L37 CancellationException -> L40
    L16:
        if (r12 == null) goto L21;
        this.label = 1;     // Catch: Exception -> L37 CancellationException -> L40
        r7 = IOfficeSdkServiceV2.a.a(r12, this);     // Catch: Exception -> L37 CancellationException -> L40
        if (r7 != r0) goto L20;
        return r0;
    L21:
        r3 = null;
    L40:
        e = move-exception;
        throw e;
    L37:
        e = move-exception;
        OfflineDocCreateComponent.F2(this.this$0, e);
        return Unit.INSTANCE;
    }
}
