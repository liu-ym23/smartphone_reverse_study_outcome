package com.larus.dora.impl.offline.record;

import com.bytedance.dora.offline.record.DoraOfflineRecord;
import com.larus.avlink.record.page.RecordMinutesViewModel;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import com.larus.dora.api.offline.record.c;
import com.larus.dora.api.offline.record.d;
import com.larus.dora.api.offline.record.e;
import fk4.g;
import fk4.h;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u000e\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J.\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0096@¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010%J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\fH\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J(\u0010-\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020(H\u0002J\u0018\u00101\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00102\u001a\u00020\u001cH\u0002J\f\u00103\u001a\u000204*\u00020\u0016H\u0002J\f\u00105\u001a\u00020\"*\u000206H\u0002J\f\u00107\u001a\u00020\u0011*\u000208H\u0002J\f\u00109\u001a\u00020:*\u00020;H\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u001aH\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0011H\u0002J\u0010\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020:H\u0002J\u0010\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020\"H\u0002J \u0010D\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u001cH\u0002J\u0018\u0010F\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010C\u001a\u00020\"H\u0002J\u0018\u0010G\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010A\u001a\u00020:H\u0002J\b\u0010H\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/dora/impl/offline/record/DoraOfflineRecordSyncServiceImpl;", "Lcom/larus/dora/api/offline/record/IDoraOfflineRecordSyncService;", "<init>", "()V", "listenerDispatchScope", "Lkotlinx/coroutines/CoroutineScope;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferListener;", "doraOfflineRecord", "Lcom/bytedance/dora/offline/record/DoraOfflineRecord;", "linkDisconnected", "", "transferListener", "com/larus/dora/impl/offline/record/DoraOfflineRecordSyncServiceImpl$transferListener$1", "Lcom/larus/dora/impl/offline/record/DoraOfflineRecordSyncServiceImpl$transferListener$1;", "latestProgress", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "doraLinkCallback", "Lcom/bytedance/dora/link/IDoraLinkCallback;", "configureStorage", "config", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordStorageConfig;", "(Lcom/larus/dora/api/offline/record/DoraOfflineRecordStorageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindContext", "businessType", "", "vuiId", "", "contextType", "contextId", "(ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncedRecordings", "", "Lcom/larus/dora/api/offline/record/DoraOfflineSyncedRecording;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncedRecording", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSyncedRecording", "registerTransferListener", "", "listener", "unregisterTransferListener", "initializeDoraOfflineRecord", "configureDoraOfflineRecordStorage", "bindDoraOfflineRecordContext", "getDoraOfflineRecordings", "getDoraOfflineRecording", "initializeOfflineRecordService", "deleteAppSyncedRecording", "reason", "toOfflineRecordStorageConfig", "Lcom/bytedance/dora/offline/record/OfflineRecordStorageConfig;", "toSyncedRecording", "Lcom/bytedance/dora/offline/record/OfflineRecordDelivery;", "toFlowProgress", "Lcom/bytedance/dora/offline/record/OfflineRecordTransferProgress;", "toFlowNotify", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordFileReadyNotify;", "Lcom/bytedance/dora/offline/record/OfflineRecordFileReadyNotify;", "handleDoraLinkStateChanged", "state", "dispatchTransferProgress", "progress", "dispatchRecordFileReadyNotify", "notify", "dispatchTransferCompleted", "recording", "dispatchTransferProgressToListener", "source", "dispatchTransferCompletedToListener", "dispatchRecordFileReadyNotifyToListener", "isOfflineMinutesSupported", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOfflineRecordSyncServiceImpl implements IDoraOfflineRecordSyncService {
    public static final /* synthetic */ int g = 0;
    public final CoroutineScope a;
    public final CopyOnWriteArraySet<c> b;
    public final DoraOfflineRecord c;
    public boolean d;
    public volatile d e;
    public final com.larus.dora.impl.offline.record.a f;

    public static final class a {
    }

    public static final class b implements g {
        public final /* synthetic */ DoraOfflineRecordSyncServiceImpl a;

        public b(DoraOfflineRecordSyncServiceImpl r1) {
            this.a = r1;
        }

        public final void a(fk4.c r10) {
            Intrinsics.checkNotNullParameter(r10, "delivery");
            DoraOfflineRecordSyncServiceImpl r0 = this.a;
            int r1 = DoraOfflineRecordSyncServiceImpl.g;
            if (r0.h() == true) goto L6;
            g49.d.d("DoraOfflineRecordSyncService", "Skip offline record completion callback because ability is unsupported");
            return;
        L6:
            g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer completed, recordId=" + r10.a + ", size=" + r10.h);
            DoraOfflineRecordSyncServiceImpl r2 = this.a;
            r2.getClass();
            e r11 = DoraOfflineRecordSyncServiceImpl.i(r10);
            g49.d.d("DoraOfflineRecordSyncService", "Dispatch offline record transfer completed, listenerCount=" + r2.b.size() + ", vuiId=" + r11.a + ", size=" + r11.g);
            BuildersKt.launch$default(r2.a, null, null, new DoraOfflineRecordSyncServiceImpl$dispatchTransferCompleted$1(r2, r11, null), 3, null);
        }

        public final void b(h r15) {
            Intrinsics.checkNotNullParameter(r15, "progress");
            DoraOfflineRecordSyncServiceImpl r0 = this.a;
            int r1 = DoraOfflineRecordSyncServiceImpl.g;
            if (r0.h() == true) goto L6;
            g49.d.d("DoraOfflineRecordSyncService", "Skip offline record progress callback because ability is unsupported");
            return;
        L6:
            g49.d.d("DoraOfflineRecordSyncService", "SDK onTransferProgress raw: total=" + r15.b + ", completed=" + r15.c + ", percent=" + r15.d + ", recordId=" + r15.a);
            DoraOfflineRecordSyncServiceImpl r2 = this.a;
            r2.getClass();
            int r8 = RangesKt.coerceIn(r15.d, 0, 100);
            int r3 = r15.b;
            if (r3 > 0) goto L9;
        L11:
            boolean r5 = false;
        L12:
            int r6 = r15.b;
            int r7 = r15.c;
            String r4 = r15.a;
            if (r4 != null) goto L15;
            String r9 = "";
        L16:
            String r16 = r15.e;
            if (r16 != null) goto L19;
            String r10 = "";
        L20:
            r2.g(new d(r5, r6, r7, r8, r9, r10, false, null, 192));
            return;
        L19:
            r10 = r16;
            goto L20
        L15:
            r9 = r4;
            goto L16
        L9:
            if (r15.c >= r3) goto L11;
            r5 = true;
            goto L12
        }

        public final void c(fk4.e r14) {
            Intrinsics.checkNotNullParameter(r14, "notify");
            DoraOfflineRecordSyncServiceImpl r0 = this.a;
            int r1 = DoraOfflineRecordSyncServiceImpl.g;
            r0.getClass();
            int r3 = r14.a;
            int r4 = r14.b;
            String r2 = r14.c;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            com.larus.dora.api.offline.record.a r5 = new com.larus.dora.api.offline.record.a(r3, r4, r2, r14.d, r14.e, r14.f, r14.g);
            StringBuilder r15 = new StringBuilder("Offline record file ready notify received, status=");
            r15.append(r5.a);
            r15.append(", isOfflineRecording=");
            boolean r6 = false;
            if (r5.a != 1) goto L8;
            boolean r7 = true;
        L9:
            r15.append(r7);
            r15.append(", businessType=");
            r15.append(r5.b);
            r15.append(", vuiId=");
            r15.append(r5.c);
            r15.append(", fileType=");
            r15.append(r5.f);
            g49.d.d("DoraOfflineRecordSyncService", r15.toString());
            DoraOfflineRecordSyncServiceImpl r16 = this.a;
            r16.getClass();
            StringBuilder r8 = new StringBuilder("Dispatch offline record file ready notify, status=");
            r8.append(r5.a);
            r8.append(", isOfflineRecording=");
            if (r5.a != 1) goto L12;
            r6 = true;
        L12:
            r8.append(r6);
            r8.append(", listenerCount=");
            r8.append(r16.b.size());
            r8.append(", businessType=");
            r8.append(r5.b);
            r8.append(", vuiId=");
            r8.append(r5.c);
            g49.d.d("DoraOfflineRecordSyncService", r8.toString());
            BuildersKt.launch$default(r16.a, null, null, new DoraOfflineRecordSyncServiceImpl$dispatchRecordFileReadyNotify$1(r16, r5, null), 3, null);
            return;
        L8:
            r7 = false;
            goto L9
        }
    }

    static {
    }

    public final boolean h() {
        return this.c.isOfflineMinutesSupported();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.dora.impl.offline.record.a] */
    public DoraOfflineRecordSyncServiceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO().limitedParallelism(1)));
        this.b = new CopyOnWriteArraySet();
        DoraOfflineRecord r0 = DoraOfflineRecord.getInstance();
        this.c = r0;
        b r1 = new b(this);
        this.e = d.i;
        this.f = new com.larus.dora.impl.offline.record.a(this);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        r0.init();     // Catch: Throwable -> L5
        r0.registerTransferListener(r1);     // Catch: Throwable -> L5
        g49.d.d("DoraOfflineRecordSyncService", "Dora offline record SDK initialized");     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        if (r4 == null) goto L10;
        g49.d.c("DoraOfflineRecordSyncService", "Initialize Dora offline record SDK failed", r4);
    L10:
        Boolean r5 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L14;
        r2 = r5;
    L14:
        if (((Boolean) r2).booleanValue() == true) goto L25;
        g(new d(false, 0, 0, 0, null, null, true, "Initialize Dora offline record SDK failed", 63));
        return;
    L25:
        kj4.a.g().registerDoraLinkCallback(this.f);     // Catch: Throwable -> L18
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L23;
        g49.d.c("DoraOfflineRecordSyncService", "Register Dora link callback for offline record failed", r7);
    L23:
        g49.d.d("DoraOfflineRecordSyncService", "Offline record sync service initialized");
        return;
    L18:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static e i(fk4.c r26) {
        String r1 = r26.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = r26.b;
        int r4 = r26.d;
        long r5 = r26.e;
        long r7 = r26.f;
        long r9 = r26.g;
        long r11 = r26.h;
        String r13 = r26.r;
        int r15 = (int) RangesKt.coerceIn(r26.i, 0, 2147483647L);
        int r14 = r26.j;
        int r16 = r26.q;
        int r17 = r26.n;
        String r2 = r26.s;
        if (r2 != null) goto L8;
        String r110 = "";
    L9:
        long r18 = r26.t;
        String r0 = r26.c;
        if (r0 != null) goto L12;
        String r23 = "";
    L14:
        return new e(r1, r3, r4, r5, r7, r9, r11, r13, r15, r14, r16, r17, r110, r18, r23);
    L12:
        r23 = r0;
        goto L14
    L8:
        r110 = r2;
        goto L9
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final Object c(ContinuationImpl r4) {
        if (h() == true) goto L7;
        g49.d.d("DoraOfflineRecordSyncService", "Get synced offline records skipped because ability is unsupported");
        return CollectionsKt.emptyList();
    L7:
        return BuildersKt.withContext(Dispatchers.getIO(), new DoraOfflineRecordSyncServiceImpl$getSyncedRecordings$2(this, null), r4);
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final void d(c r9) {
        Intrinsics.checkNotNullParameter(r9, "listener");
        if (h() == true) goto L6;
        g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer listener registered without snapshot because ability is unsupported");
        return;
    L6:
        this.b.add(r9);
        BuildersKt.launch$default(this.a, null, null, new DoraOfflineRecordSyncServiceImpl$registerTransferListener$1(this, r9, null), 3, null);
        g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer listener registered, count=" + this.b.size());
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final void e(RecordMinutesViewModel.syncListener.1 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        g49.d.d("DoraOfflineRecordSyncService", "Offline record transfer listener unregistered, removed=" + this.b.remove(r3) + ", count=" + this.b.size());
    }

    public final synchronized void g(d r7) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.d == true) goto L7;
    L11:
        this.e = r7;     // Catch: Throwable -> L14
        BuildersKt.launch$default(this.a, null, null, new DoraOfflineRecordSyncServiceImpl$dispatchTransferProgress$1(this, r7, null), 3, null);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L7:
        if (r7.a == false) goto L11;
        g49.d.d("DoraOfflineRecordSyncService", "Ignore stale offline record progress after link disconnected, recordId=" + r7.e + ", progress=" + r7.d);     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final Object b(String r4, ContinuationImpl r5) {
        if (h() == true) goto L7;
        g49.d.d("DoraOfflineRecordSyncService", "Delete app offline record skipped because ability is unsupported");
        return Boxing.boxBoolean(false);
    L7:
        return BuildersKt.withContext(Dispatchers.getIO(), new DoraOfflineRecordSyncServiceImpl$deleteSyncedRecording$2(this, r4, null), r5);
    }

    @Override // com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService
    public final Object a(String r10, String r11, Continuation r12) {
        if (h() == true) goto L7;
        g49.d.d("DoraOfflineRecordSyncService", "Bind offline record context skipped because ability is unsupported");
        return Boxing.boxBoolean(false);
    L7:
        return BuildersKt.withContext(Dispatchers.getIO(), new DoraOfflineRecordSyncServiceImpl$bindContext$2(this, 1, r10, 1, r11, null), r12);
    }

    public static final void f(DoraOfflineRecordSyncServiceImpl r2, c r3, d r4, String r5) {
        if (r2.h() == true) goto L5;
        return;
    L5:
        if (r2.b.contains(r3) == false) goto L19;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        r3.c(r4);     // Catch: Throwable -> L9
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        g49.d.c("DoraOfflineRecordSyncService", "Dispatch offline record transfer progress failed, source=" + r5 + ", listener=" + r3.getClass().getName() + ", currentVuiId=" + r4.e + ", progress=" + r4.d + ", syncing=" + r4.a, r8);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
