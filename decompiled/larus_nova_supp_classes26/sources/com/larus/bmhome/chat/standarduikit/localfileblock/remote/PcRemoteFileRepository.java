package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PcRemoteFileRepository {
    public static final PcRemoteFileRepository a = null;
    public static final CoroutineScope b = null;
    public static final MutexImpl c = null;
    public static final AtomicLong d = null;
    public static final ConcurrentHashMap<b, Deferred<File>> e = null;
    public static final Map<b, a> f = null;
    public static final MutableLiveData<Unit> g = null;
    public static final MutableLiveData h = null;
    public static final Lazy i = null;
    public static volatile Deferred<Unit> j;

    public static final class a {
        public final File a;
        public final long b;

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
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "CacheEntry(file=" + this.a + ", createdAt=" + this.b + ')';
        }

        public a(File r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.FILE);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
        public final String a;
        public final long b;
        public final String c;
        public final int d;
        public final String e;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "FileKey(accountId=" + this.a + ", generation=" + this.b + ", sourceDeviceId=" + this.c + ", sourceAppId=" + this.d + ", filePath=" + this.e + ')';
        }

        public b(String r2, long r3, String r5, int r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "accountId");
            Intrinsics.checkNotNullParameter(r5, "sourceDeviceId");
            Intrinsics.checkNotNullParameter(r7, "filePath");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    public static final class c implements com.larus.platform.api.b {
        public c() {
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            PcRemoteFileRepository.a();
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            PcRemoteFileRepository.a();
        }
    }

    public PcRemoteFileRepository() {
    }

    public final synchronized void i() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (j == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        j = BuildersKt.async$default(b, null, null, new PcRemoteFileRepository$initialize$1(null), 3, null);     // Catch: Throwable -> L10
        AppHost.a.a().j(new PcRemoteFileRepository$initialize$2());     // Catch: Throwable -> L10
        AccountService.a.E(new c());     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    static {
        a = new PcRemoteFileRepository();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        c = kotlinx.coroutines.sync.b.a();
        d = new AtomicLong(0);
        e = new ConcurrentHashMap();
        f = new LinkedHashMap();
        MutableLiveData<Unit> r0 = new MutableLiveData(Unit.INSTANCE);
        g = r0;
        h = r0;
        i = LazyKt.lazy(new e());
    }

    public static final void a() {
        long r0 = d.incrementAndGet();
        g.postValue(Unit.INSTANCE);
        Iterator<Map.Entry<b, Deferred<File>>> r2 = e.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<b, Deferred<File>> r3 = r2.next();
        b r5 = r3.getKey();
        Deferred<File> r4 = r3.getValue();
        if (r5.b >= r0) goto L4;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        goto L4
    L8:
        BuildersKt.launch$default(b, null, null, new PcRemoteFileRepository$invalidateAccount$2(r0, null), 3, null);
    }

    public static final void c() {
        long r0 = SystemClock.elapsedRealtime();
        Map<b, a> r2 = f;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator r4 = ((LinkedHashMap) r2).entrySet().iterator();
    L3:
        boolean r5 = true;
        if (r4.hasNext() == false) goto L11;
        Map.Entry r6 = (Map.Entry) r4.next();
        if ((r0 - ((a) r6.getValue()).b) >= 3600000) goto L9;
        r5 = false;
    L9:
        if (r5 == false) goto L3;
        r3.put(r6.getKey(), r6.getValue());
        goto L3
    L11:
        List r1 = CollectionsKt.toList(r3.keySet());
        Iterator r7 = r1.iterator();
    L13:
        if (r7.hasNext() == false) goto L22;
        a r8 = f.remove((b) r7.next());
        if (r8 == null) goto L13;
        File r9 = r8.a;
        if (r9 == null) goto L13;
        File r10 = r9.getParentFile();
        if (r10 == null) goto L13;
        k(r10, "expired");
        goto L13
    L22:
        if ((!r1.isEmpty()) == false) goto L39;
        g.postValue(Unit.INSTANCE);
        return;
    }

    public static Object d(Continuation r1) {
        Deferred<Unit> r0 = j;
        if (r0 == null) goto L10;
        Object r2 = r0.await(r1);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r2;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public static File e(b r8) {
        l(r8);
        Map<b, a> r0 = f;
        a r1 = (a) ((LinkedHashMap) r0).get(r8);
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((SystemClock.elapsedRealtime() - r1.b) < 3600000) goto L8;
    L14:
        r0.remove(r8);
        g.postValue(Unit.INSTANCE);
        File r9 = r1.a.getParentFile();
        if (r9 == null) goto L17;
        k(r9, "cache_invalid");
    L17:
        return null;
    L8:
        if (r1.a.isFile() == false) goto L14;
        if (r1.a.canRead() == false) goto L14;
        return r1.a;
    }

    public static b g(g r8) {
        long r3 = d.get();
        AccountService r0 = AccountService.a;
        String r2 = r0.getUserId();
        if (r0.isLogin().booleanValue() == false) goto L9;
        if (StringsKt.isBlank(r2) == true) goto L9;
        return new b(r2, r3, r8.a, r8.b, r8.c);
    L9:
        throw new PcRemoteFileException(PcRemoteFileError.ACCOUNT_CHANGED, null, 2, null);
    }

    public static void l(b r5) {
        if (r5.b != d.get()) goto L10;
        AccountService r0 = AccountService.a;
        if (r0.isLogin().booleanValue() == false) goto L10;
        if (Intrinsics.areEqual(r5.a, r0.getUserId()) == false) goto L10;
        return;
    L10:
        throw new PcRemoteFileException(PcRemoteFileError.ACCOUNT_CHANGED, null, 2, null);
    }

    public static Object f(g r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PcRemoteFileRepository$cachedFile$2(r3, null), r4);
    }

    public static void k(File r4, String r5) {
    L9:
        e = move-exception;
        FLogger.a.e("PcRemoteFilePreview", "stage=cache_remove_failed reason=" + r5 + " exception=" + e.getClass().getSimpleName());
        return;
    L4:
        if (r4.exists() == true) goto L6;
        return;
    L6:
        if (FilesKt.deleteRecursively(r4) == true) goto L15;
        FLogger.a.e("PcRemoteFilePreview", "stage=cache_remove_failed reason=".concat(r5));     // Catch: Exception -> L9
        return;
    }

    public final Object j(g r12, Continuation<? super File> r13) {
        if ((r13 instanceof PcRemoteFileRepository$prepareFile$1) == false) goto L7;
        PcRemoteFileRepository$prepareFile$1 r0 = (PcRemoteFileRepository$prepareFile$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        b r15 = (b) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L22:
        File r16 = (File) r14;
        l(r15);
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r12.b();
        i();
        final b r17 = g(r12);
        final Deferred<File> r18 = BuildersKt.async$default(b, null, CoroutineStart.LAZY, new PcRemoteFileRepository$prepareFile$candidate$1(r17, r12, null), 1, null);
        Deferred<File> r4 = e.putIfAbsent(r17, r18);
        if (r4 == null) goto L17;
        Job.DefaultImpls.cancel$default(r18, null, 1, null);
        r18 = r4;
    L18:
        r0.L$0 = r17;
        r0.label = 1;
        Object r19 = r18.await(r0);
        if (r19 != r2) goto L21;
        return r2;
    L21:
        r14 = r19;
        r15 = r17;
        goto L22
    L17:
        r18.invokeOnCompletion(new f(r17, r18));
        r18.start();
    L7:
        r0 = new PcRemoteFileRepository$prepareFile$1(this, r13);
        goto L8
    }

    public final Object h(String r6, File r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof PcRemoteFileRepository$download$1) == false) goto L7;
        PcRemoteFileRepository$download$1 r0 = (PcRemoteFileRepository$download$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r9);     // Catch: TimeoutCancellationException -> L21
    L19:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        PcRemoteFileRepository$download$2 r10 = new PcRemoteFileRepository$download$2(r7, r6, null);     // Catch: TimeoutCancellationException -> L21
        r0.label = 1;     // Catch: TimeoutCancellationException -> L21
        if (TimeoutKt.b(900000, r10, r0) != r2) goto L19;
        return r2;
    L22:
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);
    L7:
        r0 = new PcRemoteFileRepository$download$1(this, r8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x040f: MOVE (r11 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:67109903), block:B:184:0x040e */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v40, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v36, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v39, types: [kotlin.jvm.internal.Ref$BooleanRef] */
    /* JADX WARN: Type inference failed for: r9v45 */
    /* JADX WARN: Type inference failed for: r9v47 */
    /* JADX WARN: Type inference failed for: r9v50 */
    public static final Object b(PcRemoteFileRepository r26, b r27, g r28, Continuation r29) {
        r26.getClass();
        if ((r29 instanceof PcRemoteFileRepository$prepareFile$2) == false) goto L7;
        PcRemoteFileRepository$prepareFile$2 r2 = (PcRemoteFileRepository$prepareFile$2) r29;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r5 = r2.label;
        switch(r5) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L28;
            case 5: goto L17;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        Throwable r0 = (Throwable) r2.L$0;
        ResultKt.throwOnFailure(r1);
        throw r0;
    L13:
        File r6 = (File) r2.L$0;
        ResultKt.throwOnFailure(r1);
        return r6;
    L14:
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r2.L$4;
        Ref.BooleanRef r8 = (Ref.BooleanRef) r2.L$3;
        File r9 = (File) r2.L$2;
        File r10 = (File) r2.L$1;
        b r11 = (b) r2.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        ?? r12 = r8;
    L16:
        kotlinx.coroutines.sync.a r13 = r7;
        l(r11);     // Catch: Throwable -> L167
        if (r9.isFile() == false) goto L166;
        if (r9.canRead() == false) goto L166;
        f.put(r11, new a(r9, SystemClock.elapsedRealtime()));     // Catch: Throwable -> L167
        g.postValue(Unit.INSTANCE);     // Catch: Throwable -> L167
        ((Ref.BooleanRef) r12).element = true;     // Catch: Throwable -> L167
        r13.unlock(null);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        BuildersKt.launch$default(b, null, null, new PcRemoteFileRepository$prepareFile$7(null), 3, null);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        FLogger.a.i("PcRemoteFilePreview", "stage=save_success file_id=" + r10.getName() + " bytes=" + r9.length());     // Catch: Throwable -> L20 PcRemoteFileException -> L24 CancellationException -> L26 Exception -> L171
        if (((Ref.BooleanRef) r12).element == true) goto L211;
        CoroutineContext r14 = k1.a.plus(Dispatchers.getIO());
        PcRemoteFileRepository$prepareFile$8 r15 = new PcRemoteFileRepository$prepareFile$8(r10, null);
        r2.L$0 = r9;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 7;
        if (BuildersKt.withContext(r14, r15, r2) != r4) goto L211;
        return r4;
    L211:
        return r9;
    L166:
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);     // Catch: Throwable -> L167
    L171:
        e = e;
        ?? r16 = r12;
        File r17 = r10;
    L180:
        FLogger.a.e("PcRemoteFilePreview", "stage=download_failed exception=" + e.getClass().getSimpleName());     // Catch: Throwable -> L20
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);     // Catch: Throwable -> L20
    L167:
        th = move-exception;
        r13.unlock(null);     // Catch: Throwable -> L20 PcRemoteFileException -> L24 CancellationException -> L26 Exception -> L171
        throw th;     // Catch: Throwable -> L20 PcRemoteFileException -> L24 CancellationException -> L26 Exception -> L171
    L17:
        Ref.BooleanRef r18 = (Ref.BooleanRef) r2.L$3;
        File r19 = (File) r2.L$2;
        r10 = (File) r2.L$1;
        b r20 = (b) r2.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r11 = r20;
        r9 = r19;
        ?? r21 = r18;
    L148:
        r7 = c;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$0 = r11;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$1 = r10;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$2 = r9;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$3 = r21;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$4 = r7;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.label = 6;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r12 = r21;
        if (r7.a(null, r2) != r4) goto L16;
        return r4;
    L28:
        kotlinx.coroutines.sync.a r22 = (kotlinx.coroutines.sync.a) r2.L$5;
        r16 = (Ref.BooleanRef) r2.L$4;
        File r110 = (File) r2.L$3;
        r17 = (File) r2.L$2;
        String r111 = (String) r2.L$1;
        b r112 = (b) r2.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        ?? r23 = r16;
    L200:
        l(r112);     // Catch: Throwable -> L175
        if (r17.mkdirs() == false) goto L138;
    L142:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L175
        r22.unlock(null);     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r2.L$0 = r112;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r2.L$1 = r17;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r2.L$2 = r110;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r2.L$3 = r23;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r2.L$4 = null;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r2.L$5 = null;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        r2.label = 5;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        if (r26.h(r111, r110, r2) == r4) goto L217;
        r21 = r23;
        r9 = r110;
        r10 = r17;
        r11 = r112;
        goto L148
    L217:
        return r4;
    L138:
        if (r17.isDirectory() == true) goto L142;
        throw new PcRemoteFileException(PcRemoteFileError.DOWNLOAD_FAILED, null, 2, null);     // Catch: Throwable -> L175
    L175:
        th = move-exception;
        r22.unlock(null);     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
        throw th;     // Catch: Throwable -> L31 PcRemoteFileException -> L33 CancellationException -> L35 Exception -> L173
    L33:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L35:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L173:
        e = e;
    L31:
        th = th;
    L186:
        if (((Ref.BooleanRef) r16).element == true) goto L220;
        CoroutineContext r25 = k1.a.plus(Dispatchers.getIO());
        PcRemoteFileRepository$prepareFile$8 r30 = new PcRemoteFileRepository$prepareFile$8(r17, null);
        r2.L$0 = th;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.L$5 = null;
        r2.label = 8;
        if (BuildersKt.withContext(r25, r30, r2) != r4) goto L221;
        return r4;
    L221:
        throw th;
    L220:
        throw th;
    L37:
        g r31 = (g) r2.L$1;
        b r32 = (b) r2.L$0;
        ResultKt.throwOnFailure(r1);
        r112 = r32;
    L57:
        r111 = (String) r1;
        l(r112);
        File r113 = new PolarisFileWrapper((File) i.getValue(), UUID.randomUUID().toString());
        String r33 = StringsKt.trim(StringsKt.substringAfterLast$default(StringsKt.replace$default(r31.c, '\\', '/', false, 4, null), '/', null, 2, null)).toString();
        if (StringsKt.isBlank(r33) == false) goto L60;
    L65:
        boolean r114 = true;
    L66:
        if (r114 == false) goto L69;
        r33 = null;
    L69:
        String r115 = "";
        if (r33 != null) goto L75;
        String r34 = r31.d;
        if (r34 != null) goto L74;
        r34 = "";
    L74:
        r33 = StringsKt.substringAfterLast$default(StringsKt.replace$default(StringsKt.trim(r34).toString(), '\\', '/', false, 4, null), '/', null, 2, null);
    L75:
        ArrayList r116 = new ArrayList(r33.length());
        int r35 = 0;
    L77:
        if (r35 >= r33.length()) goto L82;
        char r36 = r33.charAt(r35);
        if (Character.isISOControl(r36) == false) goto L81;
        r36 = '_';
    L81:
        r116.add(Character.valueOf(r36));
        r35 = r35 + 1;
        goto L77
    L82:
        String r37 = CollectionsKt.joinToString$default(r116, "", null, null, 0, null, null, 62, null);
        if (StringsKt.isBlank(r37) == false) goto L85;
    L88:
        r37 = ShareType.FILE;
    L89:
        String r117 = StringsKt.substringAfterLast(r37, '.', "");
        if (StringsKt.lastIndexOf$default(r37, '.', 0, false, 6, null) > 0) goto L92;
    L94:
        boolean r118 = false;
    L95:
        if (r118 == true) goto L98;
        r117 = null;
    L98:
        if (r117 != null) goto L120;
        String r38 = r31.e;
        if (r38 == null) goto L108;
        String r39 = StringsKt.trim(r38).toString();
        if (r39 == null) goto L108;
        String r40 = StringsKt.removePrefix(r39, ".");
        if (r40 == null) goto L108;
        if (g.a(r40) == false) goto L108;
    L109:
        if (r40 == null) goto L118;
        StringBuilder r119 = new StringBuilder();
        String r41 = StringsKt.trimEnd(r37, new char[]{'.'});
        if (r41.length() != 0) goto L113;
        boolean r120 = true;
    L114:
        if (r120 == false) goto L116;
        String r42 = ShareType.FILE;
    L117:
        r119.append(r42);
        r119.append('.');
        r119.append(r40);
        r37 = r119.toString();
        goto L118
    L116:
        r42 = r41;
        goto L117
    L113:
        r120 = false;
    L118:
        r117 = r40;
    L108:
        r40 = null;
    L120:
        if (r37.getBytes(Charsets.UTF_8).length <= 240) goto L130;
        if (r117 == null) goto L124;
        r37 = StringsKt.substringBeforeLast$default(r37, '.', null, 2, null);
    L124:
        if (r37.getBytes(Charsets.UTF_8).length <= 200) goto L126;
        r37 = r37.substring(0, Character.offsetByCodePoints(r37, r37.length(), -1));
        goto L124
    L126:
        StringBuilder r43 = new StringBuilder();
        r43.append(r37);
        if (r117 == null) goto L129;
        r115 = ".".concat(r117);
    L129:
        r43.append(r115);
        r37 = r43.toString();
    L130:
        File r44 = new PolarisFileWrapper(r113, r37);
        Ref.BooleanRef r45 = new Ref.BooleanRef();
        kotlinx.coroutines.sync.a r46 = c;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$0 = r112;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$1 = r111;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$2 = r113;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$3 = r44;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$4 = r45;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.L$5 = r46;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        r2.label = 4;     // Catch: Throwable -> L20 Exception -> L22 PcRemoteFileException -> L24 CancellationException -> L26
        if (r46.a(null, r2) == r4) goto L216;
        r23 = r45;
        r22 = r46;
        r17 = r113;
        r110 = r44;
        goto L200
    L216:
        return r4;
    L92:
        if (g.a(r117) == false) goto L94;
        r118 = true;
        goto L95
    L85:
        if (Intrinsics.areEqual(r37, ".") == true) goto L88;
        if (Intrinsics.areEqual(r37, "..") == false) goto L89;
    L60:
        if (Intrinsics.areEqual(r33, ".") == true) goto L65;
        if (Intrinsics.areEqual(r33, "..") == true) goto L65;
        r114 = false;
        goto L66
    L38:
        kotlinx.coroutines.sync.a r47 = (kotlinx.coroutines.sync.a) r2.L$2;
        g r48 = (g) r2.L$1;
        b r121 = (b) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L198:
        File r49 = e(r121);     // Catch: Throwable -> L193
        r47.unlock(null);
        if (r49 == null) goto L52;
        return r49;
    L52:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == false) goto L192;
        PcRemoteFileDispatcher r50 = PcRemoteFileDispatcher.a;
        r2.L$0 = r121;
        r2.L$1 = r48;
        r2.L$2 = null;
        r2.label = 3;
        r1 = r50.b(r48, r2);
        if (r1 == r4) goto L215;
        r31 = r48;
        r112 = r121;
        goto L57
    L215:
        return r4;
    L192:
        throw new PcRemoteFileException(PcRemoteFileError.NETWORK_ERROR, null, 2, null);
    L193:
        th = move-exception;
        r47.unlock(null);
        throw th;
    L39:
        g r51 = (g) r2.L$1;
        b r52 = (b) r2.L$0;
        ResultKt.throwOnFailure(r1);
        b r53 = r52;
    L43:
        l(r53);
        kotlinx.coroutines.sync.a r54 = c;
        r2.L$0 = r53;
        r2.L$1 = r51;
        r2.L$2 = r54;
        r2.label = 2;
        if (r54.a(null, r2) == r4) goto L214;
        r121 = r53;
        r48 = r51;
        r47 = r54;
        goto L198
    L214:
        return r4;
    L40:
        ResultKt.throwOnFailure(r1);
        r53 = r27;
        r2.L$0 = r53;
        r51 = r28;
        r2.L$1 = r51;
        r2.label = 1;
        if (d(r2) != r4) goto L43;
        return r4;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        e = e;
    L20:
        th = th;
        r16 = r5;
        r17 = r10;
    L24:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L26:
        e = move-exception;
        throw e;     // Catch: Throwable -> L20
    L7:
        r2 = new PcRemoteFileRepository$prepareFile$2(r26, r29);
        goto L8
    }
}
