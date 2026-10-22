package com.larus.dora.impl.file;

import android.os.SystemClock;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.file.record.DoraFileRecorder;
import com.larus.dora.impl.frameassembler.DoraIncompleteReason;
import com.larus.dora.impl.frameassembler.j;
import com.larus.dora.impl.util.b0;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraFileStreamingSink {
    public static final DoraFileStreamingSink a = null;

    public static final class a {
        public final String a;
        public final File b;
        public final OutputStream c;
        public final long d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            long r1 = this.d;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "StreamState(taskId=" + this.a + ", file=" + this.b + ", stream=" + this.c + ", startTimeMs=" + this.d + ')';
        }

        public a(String r2, PolarisFileWrapper r3, PolarisFileOutputStreamWrapper r4, long r5) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "file");
            Intrinsics.checkNotNullParameter(r4, "stream");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraFileTaskStatus.values().length];
            r0[DoraFileTaskStatus.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DoraFileTaskStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DoraFileTaskStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DoraFileTaskStatus.CANCELED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DoraFileTaskStatus.DONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class c implements j {
        public final /* synthetic */ Job a;
        public final /* synthetic */ DoraFileFetchTask b;
        public final /* synthetic */ i c;
        public final /* synthetic */ ConcurrentHashMap<Long, a> d;
        public final /* synthetic */ u e;
        public final /* synthetic */ CompletableDeferred<h> f;
        public final /* synthetic */ v g;

        @Override // com.larus.dora.impl.frameassembler.j
        public final PolarisFileOutputStreamWrapper a(com.larus.dora.impl.frameassembler.h r33) throws IOException {
            Intrinsics.checkNotNullParameter(r33, "context");
            Job.DefaultImpls.cancel$default(this.a, null, 1, null);
            long r1 = r33.a.a;
            String r3 = this.b.getLocalPath();
            if (r3 != null) goto L5;
            r3 = "";
        L5:
            PolarisFileWrapper r7 = new PolarisFileWrapper(r3);
            File r4 = r7.getParentFile();
            if (r4 != null) goto L8;
        L10:
            long r8 = 0;
            if (r7.exists() == false) goto L13;
            long r10 = r7.length();
        L14:
            Long r5 = this.b.getDownloadedBytes();
            if (r5 == null) goto L17;
            r8 = r5.longValue();
        L17:
            long r9 = Math.max(r10, r8);
            PolarisFileOutputStreamWrapper r6 = new PolarisFileOutputStreamWrapper(r7, true);
            long r11 = System.currentTimeMillis();
            DoraFileFetchTask r12 = DoraFileFetchTask.copy$default(this.b, null, null, null, null, Long.valueOf(r9), DoraFileTaskStatus.RUNNING, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.c.d(r12);
            DoraFileRecorder.a(r12);
            g49.d.d("DoraFileStreamingSink", "openStream: dataId=" + r1 + ", taskId=" + r12.getId() + ", sn=" + r12.getSn() + ", remotePath=" + r12.getRemotePath() + ", localPath=" + r12.getLocalPath() + ", startOffset=" + r9);
            Long r2 = Long.valueOf(r1);
            ConcurrentHashMap<Long, a> r13 = this.d;
            String r14 = r12.getId();
            if (r14 != null) goto L20;
            String r15 = "";
        L21:
            r13.put(r2, new a(r15, r7, r6, r11));
            return r6;
        L20:
            r15 = r14;
            goto L21
        L13:
            r10 = 0;
            goto L14
        L8:
            if (r4.exists() == true) goto L10;
            r4.mkdirs();
            goto L10
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void b(com.larus.dora.impl.frameassembler.h r26, OutputStream r27) throws IOException {
            Intrinsics.checkNotNullParameter(r26, "context");
            Intrinsics.checkNotNullParameter(r27, "stream");
            long r1 = r26.a.a;
            a r4 = this.d.remove(Long.valueOf(r1));
            r27.close();     // Catch: IOException -> L5
        L6:
            if (r4 != null) goto L8;
            return;
        L8:
            long r3 = r4.b.length();
            DoraFileFetchTask r5 = DoraFileFetchTask.copy$default(this.b, null, null, null, null, Long.valueOf(r3), DoraFileTaskStatus.UPLOADING, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.c.d(r5);
            DoraFileRecorder.a(r5);
            g49.d.d("DoraFileStreamingSink", "onCompleted: switch to UPLOADING, taskId=" + r5.getId() + ", dataId=" + r1 + ", finalLen=" + r3);
            this.f.complete(new h(r5, DoraFileStreamingSinkReason.DONE));
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void c(com.larus.dora.impl.frameassembler.h r28, OutputStream r210, Throwable r30) throws IOException {
            Intrinsics.checkNotNullParameter(r28, "context");
            Intrinsics.checkNotNullParameter(r210, "stream");
            Intrinsics.checkNotNullParameter(r30, "error");
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFileStreamingSink$sink$consumer$1$onError$1(this.g, this.b, null), 3, null);
            long r5 = r28.a.a;
            a r1 = this.d.remove(Long.valueOf(r5));
            r210.close();     // Catch: IOException -> L5
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            long r3 = r1.b.length();
            DoraFileFetchTask r2 = DoraFileFetchTask.copy$default(this.b, null, null, null, null, Long.valueOf(r3), DoraFileTaskStatus.FAILED, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.c.d(r2);
            DoraFileRecorder.a(r2);
            g49.d.c("DoraFileStreamingSink", "onError: mark FAILED, taskId=" + r2.getId() + ", dataId=" + r5 + ", len=" + r3, r30);
            this.f.complete(new h(r2, DoraFileStreamingSinkReason.ERROR));
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void e(com.larus.dora.impl.frameassembler.h r48, OutputStream r410, DoraIncompleteReason r50) throws IOException {
            Intrinsics.checkNotNullParameter(r48, "context");
            Intrinsics.checkNotNullParameter(r410, "stream");
            Intrinsics.checkNotNullParameter(r50, "reason");
            if (r50 != DoraIncompleteReason.SEQ_MISMATCH) goto L5;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraFileStreamingSink$sink$consumer$1$onIncomplete$1(this.g, this.b, null), 3, null);
        L5:
            long r5 = r48.a.a;
            a r1 = this.d.remove(Long.valueOf(r5));
            r410.close();     // Catch: IOException -> L8
        L9:
            if (r1 != null) goto L11;
            return;
        L11:
            long r3 = r1.b.length();
            DoraFileFetchTask r27 = DoraFileFetchTask.copy$default(this.b, null, null, null, null, Long.valueOf(r3), null, null, null, null, null, null, null, null, null, null, null, null, 131055, null);
            if (r50 != DoraIncompleteReason.TIMEOUT) goto L19;
            u r2 = this.e;
            String r7 = this.b.getId();
            if (r7 != null) goto L16;
            r7 = "";
        L16:
            r2.getClass();
            Intrinsics.checkNotNullParameter(r7, "taskId");
            if (Intrinsics.areEqual(r2.a.get(r7), Boolean.TRUE) == false) goto L19;
            DoraFileTaskStatus r4 = DoraFileTaskStatus.PAUSED;
        L20:
            DoraFileFetchTask r8 = DoraFileFetchTask.copy$default(r27, null, null, null, null, null, r4, null, null, null, null, null, null, null, null, null, null, null, 131039, null);
            this.c.d(r8);
            DoraFileRecorder.a(r8);
            g49.d.d("DoraFileStreamingSink", "onIncomplete: finalStatus=" + r4 + ", taskId=" + r8.getId() + ", dataId=" + r5 + ", len=" + r3 + ", reason=" + r50);
            CompletableDeferred<h> r6 = this.f;
            if (r8.getStatus() != DoraFileTaskStatus.PAUSED) goto L23;
            DoraFileStreamingSinkReason r9 = DoraFileStreamingSinkReason.PAUSED;
        L24:
            r6.complete(new h(r8, r9));
            return;
        L23:
            r9 = DoraFileStreamingSinkReason.INCOMPLETED;
        L19:
            r4 = DoraFileTaskStatus.FAILED;
            goto L20
        }

        @Override // com.larus.dora.impl.frameassembler.j
        public final void d(com.larus.dora.impl.frameassembler.h r31, OutputStream r32, byte[] r33, int r34) throws IOException {
            Intrinsics.checkNotNullParameter(r31, "context");
            Intrinsics.checkNotNullParameter(r32, "stream");
            Intrinsics.checkNotNullParameter(r33, "chunk");
            long r6 = r31.a.a;
            a r1 = this.d.get(Long.valueOf(r6));
            if (r1 != null) goto L5;
            return;
        L5:
            u r4 = this.e;
            String r8 = r1.a;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r8, "taskId");
            if (Intrinsics.areEqual(r4.a.get(r8), Boolean.TRUE) == false) goto L15;
            g49.d.a("DoraFileStreamingSink", "onChunk: taskId=" + r1.a + ", dataId=" + r6 + " is PAUSED, drop chunk seq=" + r34 + ", len=" + r33.length);
            CompletableDeferred<h> r2 = this.f;
            i r3 = this.c;
            String r5 = this.b.getId();
            if (r5 != null) goto L10;
            r5 = "";
        L10:
            DoraFileFetchTask r7 = r3.b(r5);
            if (r7 != null) goto L13;
            r7 = this.b;
        L13:
            r2.complete(new h(r7, DoraFileStreamingSinkReason.PAUSED));
            return;
        L15:
            r32.write(r33);
            r32.flush();
            DoraFileFetchTask r9 = DoraFileFetchTask.copy$default(this.b, null, null, null, null, Long.valueOf(r1.b.length()), DoraFileTaskStatus.RUNNING, null, null, null, null, null, null, null, null, null, null, null, 131023, null);
            this.c.d(r9);
            DoraFileRecorder.a(r9);
            g49.d.a("DoraFileStreamingSink", "onChunk: wrote len=" + r33.length + ", seq=" + r34 + ", taskId=" + r9.getId() + ", dataId=" + r6 + ", downloadedBytes=" + r9.getDownloadedBytes());
        }

        public c(Job r1, DoraFileFetchTask r2, i r3, ConcurrentHashMap<Long, a> r4, u r5, CompletableDeferred<h> r6, v r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    static {
        a = new DoraFileStreamingSink();
    }

    public DoraFileStreamingSink() {
    }

    public static void b(int r3, long r4, String r6) {
        g49.d.d("DoraFileStreamingSink", "id: " + r3 + ", " + r6 + ", cost: " + (SystemClock.elapsedRealtime() - r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [vj4.d] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2, types: [vj4.d] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.dora.impl.frameassembler.d] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.larus.dora.impl.frameassembler.d] */
    public final Object a(DoraFileFetchTask r26, i r27, v r28, u r210, Continuation<? super h> r30) {
        if ((r30 instanceof DoraFileStreamingSink$sink$1) == false) goto L7;
        DoraFileStreamingSink$sink$1 r2 = (DoraFileStreamingSink$sink$1) r30;
        int r3 = r2.label;
        ?? r4 = -2147483648(0xffffffff80000000, float:-0.0);
        ?? r5 = r3 & Integer.MIN_VALUE;
        if (r5 == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraFileStreamingSink$sink$1 r11 = r2;
        Object r1 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r11.label;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 != 2) goto L18;
        long r7 = r11.J$0;
        int r0 = r11.I$0;
        vj4.d r8 = (vj4.d) r11.L$1;
        com.larus.dora.impl.frameassembler.d r9 = (com.larus.dora.impl.frameassembler.d) r11.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L15
        r4 = r8;
        r5 = r9;
    L55:
        h r10 = (h) r1;     // Catch: Throwable -> L15
        b(r0, r7, "result=" + r10);     // Catch: Throwable -> L15
        vj4.b.a.a.c(r4);
        r5.shutdown();
        return r10;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r7 = r11.J$0;
        r0 = r11.I$0;
        vj4.d r13 = (vj4.d) r11.L$2;
        com.larus.dora.impl.frameassembler.d r14 = (com.larus.dora.impl.frameassembler.d) r11.L$1;
        CompletableDeferred r15 = (CompletableDeferred) r11.L$0;
        ResultKt.throwOnFailure(r1);
        vj4.d r16 = r13;
        com.larus.dora.impl.frameassembler.d r17 = r14;
    L51:
        b(r0, r7, "start remote streaming, ret=" + ((Number) r1).intValue());
        r11.L$0 = r17;     // Catch: Throwable -> L15
        r11.L$1 = r16;     // Catch: Throwable -> L15
        r11.L$2 = null;     // Catch: Throwable -> L15
        r11.I$0 = r0;     // Catch: Throwable -> L15
        r11.J$0 = r7;     // Catch: Throwable -> L15
        r11.label = 2;     // Catch: Throwable -> L15
        r1 = r15.await(r11);     // Catch: Throwable -> L15
        r4 = r16;
        r5 = r17;
        if (r1 != r12) goto L55;
        return r12;
    L20:
        ResultKt.throwOnFailure(r1);
        g49.d.d("DoraFileStreamingSink", "sink start, task=" + r26);
        DoraFileTaskStatus r18 = r26.getStatus();
        if (r18 != null) goto L23;
        int r20 = -1;
    L24:
        if (r20 == 1) goto L64;
        if (r20 == 2) goto L64;
        if (r20 == 3) goto L64;
        if (r20 == 4) goto L64;
        if (r20 == 5) goto L64;
        ConcurrentHashMap r21 = new ConcurrentHashMap();
        k49.a r22 = k49.a.a;
        monitor-enter(r22);
        b0.a.getClass();     // Catch: Throwable -> L60
        int r23 = b0.j().getInt("key_data_id", 0);     // Catch: Throwable -> L60
        if (r23 != Integer.MAX_VALUE) goto L37;
        int r24 = 0;
    L38:
        b0.j().storeInt("key_data_id", r24);     // Catch: Throwable -> L60
        monitor-exit(r22);
        long r25 = SystemClock.elapsedRealtime();
        CompletableDeferred r31 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        final int r211 = r24;
        c r32 = new c(BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new DoraFileStreamingSink$sink$firstFrameTimeoutJob$1(r26, r27, r31, null), 3, null), r26, r27, r21, r210, r31, r28);
        int r33 = com.larus.dora.impl.frameassembler.e.m;
        com.larus.dora.impl.frameassembler.e.a r34 = new com.larus.dora.impl.frameassembler.e.a();
        r34.a = 10000;
        r34.l = true;
        final com.larus.dora.impl.frameassembler.k r35 = new com.larus.dora.impl.frameassembler.k(new com.larus.dora.impl.frameassembler.e(r34), r32);
        vj4.d r36 = new g(r211, r35);
        ((CopyOnWriteArraySet) vj4.b.a.a.a).add(r36);
        b(r211, r25, "start remote streaming");
        long r37 = r211;
        String r38 = r26.getFileName();
        if (r38 != null) goto L43;
        r38 = "";
    L43:
        String r212 = r38;
        Long r40 = r26.getDownloadedBytes();
        if (r40 == null) goto L46;
        long r41 = r40.longValue();
    L47:
        r11.L$0 = r31;
        r11.L$1 = r35;
        r11.L$2 = r36;
        r11.I$0 = r211;
        r11.J$0 = r25;
        r11.label = 1;
        Object r42 = r28.c(r37, r212, r41);
        if (r42 != r12) goto L50;
        return r12;
    L50:
        r15 = r31;
        r17 = r35;
        r1 = r42;
        r0 = r211;
        r16 = r36;
        r7 = r25;
        goto L51
    L46:
        r41 = 0;
        goto L47
    L37:
        r24 = r23 + 1;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    L64:
        return new h(r26, DoraFileStreamingSinkReason.DONE);
    L23:
        r20 = b.a[r18.ordinal()];
    L15:
        th = move-exception;
        vj4.b.a.a.c(r4);
        r5.shutdown();
        throw th;
    L7:
        r2 = new DoraFileStreamingSink$sink$1(this, r30);
        goto L8
    }
}
