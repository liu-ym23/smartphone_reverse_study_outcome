package com.larus.doc.impl.offline;

import android.os.Looper;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.larus.doc.sdk.api.SyncedDocInfoSource;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0014\u0010\u001b\u001a\u00020\u00182\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0018H\u0016J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0018H\u0016J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u00100\u001a\u0004\u0018\u00010\u0014*\u00020\u0012H\u0002J\u0014\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u00104\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u00010\u00142\u0006\u00106\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0014H\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u000209H\u0002J*\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020\u00142\b\u0010=\u001a\u0004\u0018\u00010\u00142\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010;\u001a\u0002022\u0006\u0010>\u001a\u00020?H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/doc/impl/offline/OfflineDocCreateComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/doc/impl/offline/IOfflineDocCreateAbility;", "<init>", "()V", "coordinator", "Lcom/larus/doc/impl/offline/OfflineDocCreateCoordinator;", "componentScope", "Lkotlinx/coroutines/CoroutineScope;", "config", "Lcom/larus/doc/impl/offline/OfflineDocCreateConfig;", "startInvoked", "", "hasRefreshedRemoteBinding", "shouldSkipUpdateDocumentBrief", "hostAbility", "Lcom/larus/doc/impl/offline/IOfflineDocCreateHostAbility;", "createDocumentResult", "Lcom/bytedance/ee/bear/list/DocumentListInfo;", "createDocumentError", "", "createDocumentFinishSignal", "Ljava/util/concurrent/CountDownLatch;", "onAttach", "", "initialize", "startIfNeeded", "handleCreateDocumentStartFailure", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCreateDocResp", "buildCreateDocResp", "Lorg/json/JSONObject;", "waitCreateDocumentFinishIfNeeded", "notifyOfflineCreateState", "state", "", "offlineCreateFail", "onSyncedDocInfo", "source", "Lcom/larus/doc/sdk/api/SyncedDocInfoSource;", "onChatInputReady", "onHostDestroy", "compensateEnabled", "isOfflineDocCreateFlow", "onDestroy", "currentRealToken", "firstRealToken", "buildSnapshot", "Lcom/larus/doc/impl/offline/CreateDocByMessageSnapshot;", "docRealToken", "applyRealTokenAndRefreshBinding", "realToken", "resourceType", "executeAction", "action", "Lcom/larus/doc/impl/offline/OfflineDocCreateAction;", "executeCreateDocByMessage", "snapshot", "trigger", "failReason", "createDocByMessageState", "Lcom/larus/doc/impl/offline/CreateDocByMessageState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineDocCreateComponent extends Component implements c {
    public static final /* synthetic */ int v = 0;
    public final OfflineDocCreateCoordinator l;
    public final CoroutineScope m;
    public volatile f n;
    public boolean o;
    public boolean p;
    public boolean q;
    public volatile d r;
    public volatile DocumentListInfo s;
    public volatile String t;
    public final CountDownLatch u;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SyncedDocInfoSource.values().length];
            r0[SyncedDocInfoSource.USER_CHANGES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SyncedDocInfoSource.OFFLINE_SYNC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SyncedDocInfoSource.CHAT_INPUT_HIDDEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final void onDestroy() {
        this.r = null;
        this.u.countDown();
        CoroutineScopeKt.cancel$default(this.m, null, 1, null);
    }

    @Override // com.larus.doc.impl.offline.c
    public final boolean BK() {
        f r0 = this.n;
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L7:
        return Intrinsics.areEqual(r1, "fake_offline_doc_id");
    L5:
        r1 = null;
        goto L7
    }

    public final JSONObject N2() {
        DocumentListInfo r0 = this.s;
        String r2 = null;
        if (r0 == null) goto L13;
        ArrayList r1 = r0.getDocumentList();
        if (r1 == null) goto L13;
        Document r3 = (Document) CollectionsKt.firstOrNull(r1);
        if (r3 == null) goto L13;
        String r4 = r3.d;
        if (r4 == null) goto L13;
        if ((!StringsKt.isBlank(r4)) == false) goto L13;
    L15:
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L22:
        if (r5 == true) goto L25;
        JSONObject r6 = new JSONObject();
        r6.put("objToken", r4);
        r6.put("code", 0);
        return r6;
    L25:
        JSONObject r7 = new JSONObject();
        r7.put("code", -1);
        String r8 = this.t;
        if (r8 != null) goto L28;
    L31:
        r2 = "create_document_missing_obj_token";
    L32:
        r7.put("msg", r2);
        return r7;
    L28:
        if ((true ^ StringsKt.isBlank(r8)) == false) goto L30;
        r2 = r8;
    L30:
        if (r2 != null) goto L32;
    L17:
        if (StringsKt.isBlank(r4) == true) goto L20;
        r5 = false;
    L13:
        r4 = null;
        goto L15
    }

    public final String U2() {
        String r0 = this.l.d();
        if (r0 != null) goto L13;
        d r1 = this.r;
        if (r1 == null) goto L12;
        String r2 = r1.ei();
        if (r2 == null) goto L12;
        if ((!Intrinsics.areEqual(r2, "fake_offline_doc_id")) == false) goto L12;
        return r2;
    L12:
        return null;
    L13:
        return r0;
    }

    public final void Y2() {
        f r0 = this.n;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.o == false) goto L8;
        return;
    L8:
        if (BK() == false) goto L22;
        this.o = true;
        OfflineDocCreateCoordinator r1 = this.l;
        monitor-enter(r1);
        OfflineDocCreateCoordinator.a r2 = r1.a;     // Catch: Throwable -> L16
        OfflineDocCreateCoordinator.CreateDocumentStatus r3 = OfflineDocCreateCoordinator.CreateDocumentStatus.WAITING_CALLBACK;     // Catch: Throwable -> L16
        r2.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r3, "<set-?>");     // Catch: Throwable -> L16
        r2.a = r3;     // Catch: Throwable -> L16
        new e.c("create_document_started");     // Catch: Throwable -> L16
        monitor-exit(r1);
        BuildersKt.launch$default(this.m, null, null, new OfflineDocCreateComponent$startIfNeeded$1(this, r0, null), 3, null);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, c.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.r = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).getAbility(d.class);
    }

    public OfflineDocCreateComponent() {
        this.l = new OfflineDocCreateCoordinator();
        this.m = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.u = new CountDownLatch(1);
    }

    @Override // com.larus.doc.impl.offline.c
    public final void FN() {
        com.larus.doc.impl.offline.a r0 = P2(U2());
        if (r0 != null) goto L5;
        return;
    L5:
        OfflineDocCreateCoordinator r1 = this.l;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r0, "snapshot");     // Catch: Throwable -> L11
        r1.c(r0);     // Catch: Throwable -> L11
        r1.a.b = true;     // Catch: Throwable -> L11
        e r2 = r1.b("frontend_linked");     // Catch: Throwable -> L11
        monitor-exit(r1);
        X2(r2);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.doc.impl.offline.c
    public final void g60() {
        if (BK() == true) goto L5;
        return;
    L5:
        f r0 = this.n;
        if (r0 != null) goto L8;
        return;
    L8:
        L2(U2(), r0.e, "chatInputReady");
    }

    @Override // com.larus.doc.impl.offline.c
    public final String getCreateDocResp() {
        if (BK() == false) goto L35;
        Y2();
        if (this.u.getCount() == 0) goto L35;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        int r0 = m39.b.a;
        m39.b.d("skip", "main_thread");
        goto L35
    L11:
        int r1 = m39.b.a;
        m39.b.d("before_get_create_doc_resp", null);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        this.u.await();     // Catch: Throwable -> L14
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L35;
        if ((r4 instanceof InterruptedException) == false) goto L21;
        ThreadMethodProxy.currentThread().interrupt();
    L21:
        int r5 = m39.b.a;
        m39.b.d("interrupted", r4.getMessage());
        FLogger.a.e("OfflineDocCreateComponent", "[offlineCreate] wait createDocument finish interrupted", r4);
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
    L35:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L24
        Object r8 = Result.constructor-impl(N2().toString());     // Catch: Throwable -> L24
    L26:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L34;
        int r10 = m39.b.a;
        Intrinsics.checkNotNullParameter(r9, "error");
        String r11 = r9.getMessage();
        if (r11 != null) goto L32;
        r11 = "";
    L32:
        m39.b.a("序列化创建离线文档结果失败, 错误:".concat(r11));
        FLogger.a.e("OfflineDocCreateComponent", "[offlineCreate] serialize createDocument response failed", r9);
        r8 = "{\"code\":-1,\"msg\":\"serialize_create_document_response_failed\"}";
    L34:
        return (String) r8;
    L24:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.larus.doc.impl.offline.c
    public final void offlineCreateFail() {
        com.larus.doc.impl.offline.a r0 = P2(U2());
        if (r0 != null) goto L5;
        return;
    L5:
        OfflineDocCreateCoordinator r1 = this.l;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r0, "snapshot");     // Catch: Throwable -> L21
        r1.c(r0);     // Catch: Throwable -> L21
        OfflineDocCreateCoordinator.a r2 = r1.a;     // Catch: Throwable -> L21
        if (r2.f == false) goto L10;
        e r3 = new e.c("offline_create_fail:create_doc_by_message_started");     // Catch: Throwable -> L21
    L18:
        monitor-exit(r1);
        X2(r3);
        return;
    L10:
        r2.f = true;     // Catch: Throwable -> L21
        String r4 = r2.g;     // Catch: Throwable -> L21
        if (r4 != null) goto L13;
    L15:
        r4 = null;
    L17:
        r3 = new e.d(r4);     // Catch: Throwable -> L21
        goto L18
    L13:
        if ((true ^ StringsKt.isBlank(r4)) == false) goto L15;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.doc.impl.offline.c
    public final boolean wL() {
        return this.q;
    }

    public final com.larus.doc.impl.offline.a P2(String r14) {
        f r0 = this.n;
        if (r0 != null) goto L5;
        return null;
    L5:
        Long r2 = r0.d;
        if (r2 != null) goto L8;
    L12:
        int r15 = m39.b.a;
        String r16 = r0.c;
        Intrinsics.checkNotNullParameter(r16, "conversationId");
        m39.b.a("创建卡片参数快照缺失, convId:" + r16 + ", messageId:" + r2);
        return null;
    L8:
        if (StringsKt.isBlank(r0.c) == true) goto L12;
        return new com.larus.doc.impl.offline.a(r0.c, r2.longValue(), r0.e, r0.f, r0.g, r14, null);
    }

    @Override // com.larus.doc.impl.offline.c
    public final void QN(f r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.n = r2;
        Y2();
    }

    public final void X2(e r14) {
        if ((r14 instanceof e.c) == false) goto L6;
        int r1 = m39.b.a;
        String r0 = ((e.c) r14).a;
        Intrinsics.checkNotNullParameter(r0, "stage");
        m39.b.a("卡片补偿决策, 是否补偿:false, 动作:无操作, 当前阶段:" + r0);
        return;
    L6:
        if ((r14 instanceof e.b) == false) goto L13;
        int r2 = m39.b.a;
        e.b r3 = (e.b) r14;
        String r4 = r3.b;
        com.larus.doc.impl.offline.a r5 = r3.a;
        m39.b.b(r4, r5.f, r5.g, null, r3.c);
        d r6 = this.r;
        if (r6 == null) goto L10;
        r6.dM(r3.c);
    L11:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfflineDocCreateComponent$executeCreateDocByMessage$1(r3.a, r3.b, this, r3.c, null, null), 2, null);
        return;
    L10:
        m39.b.e(r3.c, null, 6);
        goto L11
    L13:
        if ((r14 instanceof e.a) == false) goto L28;
        int r7 = m39.b.a;
        e.a r8 = (e.a) r14;
        String r9 = r8.c;
        com.larus.doc.impl.offline.a r10 = r8.a;
        m39.b.b(r9, r10.f, r10.g, r8.b, r8.d);
        d r11 = this.r;
        if (r11 == null) goto L17;
        r11.dM(r8.d);
    L18:
        com.larus.doc.impl.offline.a r12 = r8.a;
        com.larus.doc.impl.offline.b r13 = r8.d;
        if (r13.a == CreateDocByMessageActionType.COMPENSATE) goto L21;
    L25:
        boolean r15 = false;
    L26:
        this.q = r15;
        com.larus.doc.impl.offline.a r16 = r8.a;
        String r17 = r8.c;
        String r18 = r8.b;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new OfflineDocCreateComponent$executeCreateDocByMessage$1(r16, r17, this, r8.d, r18, null), 2, null);
        return;
    L21:
        if (r13.b == false) goto L25;
        if (Intrinsics.areEqual(r12.g, Boolean.FALSE) == false) goto L25;
        r15 = true;
        goto L26
    L17:
        m39.b.e(r8.d, null, 6);
        goto L18
    L28:
        if ((r14 instanceof e.d) == false) goto L34;
        int r20 = m39.b.a;
        e.d r21 = (e.d) r14;
        String r22 = r21.b;
        String r23 = r21.a;
        Intrinsics.checkNotNullParameter(r22, "stage");
        m39.b.a("卡片补偿决策, 是否补偿:false, 动作:重新在线打开, 当前阶段:" + r22 + ", realToken:" + m39.b.f(r23));
        d r24 = this.r;
        if (r24 == null) goto L38;
        r24.ic(r21.a);
        return;
    L38:
        return;
    L34:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.doc.impl.offline.c
    public final void b10(boolean r12) {
        boolean r0 = BK();
        boolean r1 = false;
        if (r0 == false) goto L46;
        if (r12 == false) goto L46;
        com.larus.doc.impl.offline.a r4 = P2(U2());
        if (r4 == null) goto L8;
        boolean r9 = true;
    L9:
        if (r4 == null) goto L45;
        OfflineDocCreateCoordinator r10 = this.l;
        monitor-enter(r10);
        Intrinsics.checkNotNullParameter(r4, "snapshot");     // Catch: Throwable -> L42
        OfflineDocCreateCoordinator.a r3 = r10.a;     // Catch: Throwable -> L42
        r3.h = r4;     // Catch: Throwable -> L42
        r3.i = r4;     // Catch: Throwable -> L42
        r3.e = true;     // Catch: Throwable -> L42
        if (r3.a != OfflineDocCreateCoordinator.CreateDocumentStatus.NOT_STARTED) goto L18;
        e r2 = new e.c("create_document_not_started");     // Catch: Throwable -> L42
        monitor-exit(r10);
    L41:
        X2(r2);
        goto L45
    L18:
        if (r3.f == false) goto L22;
        r2 = new e.c("create_doc_by_message_started");     // Catch: Throwable -> L42
        monitor-exit(r10);
        goto L41
    L22:
        String r5 = r3.g;     // Catch: Throwable -> L42
        if (r5 != null) goto L25;
    L26:
        r1 = true;
    L28:
        if ((!r1) == true) goto L35;
        if (r10.a.a != OfflineDocCreateCoordinator.CreateDocumentStatus.WAITING_CALLBACK) goto L35;
        r2 = new e.c("wait_create_document_callback");     // Catch: Throwable -> L42
        monitor-exit(r10);
    L35:
        if (r10.a.a != OfflineDocCreateCoordinator.CreateDocumentStatus.FAILED) goto L39;
        r2 = r10.e(r4, null, null, "create_doc_by_message_not_started", "destroy_after_create_document_failed");     // Catch: Throwable -> L42
        monitor-exit(r10);
        goto L41
    L39:
        r2 = r10.a("destroy_exit");     // Catch: Throwable -> L42
        monitor-exit(r10);
        goto L41
    L25:
        if (StringsKt.isBlank(r5) == false) goto L28;
    L42:
        th = move-exception;
        throw th;
    L45:
        r1 = r9;
        goto L46
    L8:
        r9 = false;
    L46:
        int r6 = m39.b.a;
        m39.b.a("宿主销毁, 是否离线创建链路:" + r0 + ", 是否开启退出补偿:" + r12 + ", 是否有参数快照:" + r1);
        this.r = null;
    }

    @Override // com.larus.doc.impl.offline.c
    public final void onSyncedDocInfo(SyncedDocInfoSource r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        d r0 = this.r;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L35;
        if (r5 == SyncedDocInfoSource.CHAT_INPUT_HIDDEN) goto L35;
        com.larus.doc.impl.offline.a r2 = P2(U2());
        if (r2 != null) goto L15;
        return;
    L15:
        int r3 = b.a[r5.ordinal()];
        if (r3 != 1) goto L18;
        int r4 = m39.b.a;
        Intrinsics.checkNotNullParameter(r5, "source");
        m39.b.a("文档已开始同步, source:" + r5);
        OfflineDocCreateCoordinator r6 = this.l;
        monitor-enter(r6);
        Intrinsics.checkNotNullParameter(r2, "snapshot");     // Catch: Throwable -> L31
        r6.c(r2);     // Catch: Throwable -> L31
        r6.a.c = true;     // Catch: Throwable -> L31
        e.c r7 = new e.c("user_changes");     // Catch: Throwable -> L31
        monitor-exit(r6);
        X2(r7);
        return;
    L31:
        th = move-exception;
        throw th;
    L18:
        if (r3 != 2) goto L20;
        int r8 = m39.b.a;
        Intrinsics.checkNotNullParameter(r5, "source");
        m39.b.a("文档同步完成, source:" + r5);
        X2(this.l.f(r2));
        return;
    L20:
        if (r3 != 3) goto L23;
        return;
    L23:
        throw new NoWhenBranchMatchedException();
    L35:
        if (r5 != SyncedDocInfoSource.CHAT_INPUT_HIDDEN) goto L42;
        int r9 = m39.b.a;
        Intrinsics.checkNotNullParameter(r5, "source");
        m39.b.a("文档可编辑, source:" + r5);
        return;
    L42:
        return;
    L5:
        if (r0.PM() != true) goto L7;
        r1 = true;
        goto L8
    }

    public static final void F2(OfflineDocCreateComponent r4, Exception r5) {
        r4.getClass();
        String r0 = r5.getMessage();
        if (r0 != null) goto L5;
    L9:
        r0 = "create_document_start_failed";
    L10:
        r4.s = null;
        r4.t = r0;
        r4.u.countDown();
        int r1 = m39.b.a;
        m39.b.a("创建离线文档失败, 错误:".concat(r0));
        FLogger.a.e("OfflineDocCreateComponent", "[offlineCreate] start createDocument failed", r5);
        r4.X2(r4.l.g(r0));
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        goto L9
    }

    public final void L2(String r11, int r12, String r13) {
        if (r11 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        BuildersKt.launch$default(this.m, null, null, new OfflineDocCreateComponent$applyRealTokenAndRefreshBinding$1(this, r11, r13, r12, null), 3, null);
        return;
    L4:
        if (StringsKt.isBlank(r11) == true) goto L7;
        r0 = false;
        goto L8
    }
}
