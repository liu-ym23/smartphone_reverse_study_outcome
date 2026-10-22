package com.ss.android.lark.officesdk.launcher.load;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.OfficeBizType;
import com.ss.android.lark.officesdk.api.init.RuntimeStrategy;
import com.ss.android.lark.officesdk.executor.OfficeSDKRuntime;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import dagger.hilt.android.EntryPointAccessors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeLoadCoordinator {
    public static final OfficeLoadCoordinator a = null;
    public static final Handler b = null;
    public static final ExecutorService c = null;
    public static final ConcurrentHashMap<a, ExecuteState> d = null;
    public static final ConcurrentHashMap<a, ExecuteState> e = null;
    public static final com.ss.android.lark.officesdk.launcher.load.d f = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/load/OfficeLoadCoordinator$EnterResult;", "", "<init>", "(Ljava/lang/String;I)V", "START", "RUNNING", "SUCCESS", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum EnterResult extends Enum<EnterResult> {
        public static final EnterResult RUNNING = null;
        public static final EnterResult START = null;
        public static final EnterResult SUCCESS = null;
        public static final /* synthetic */ EnterResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EnterResult> getEntries() {
            return b;
        }

        static {
            EnterResult r0 = new EnterResult("START", 0);
            START = r0;
            EnterResult r1 = new EnterResult("RUNNING", 1);
            RUNNING = r1;
            EnterResult r3 = new EnterResult("SUCCESS", 2);
            SUCCESS = r3;
            EnterResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static EnterResult[] values() {
            return (EnterResult[]) a.clone();
        }

        public static EnterResult valueOf(String r1) {
            return (EnterResult) r27.a.a(EnterResult.class, r1);
        }

        public EnterResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/load/OfficeLoadCoordinator$ExecuteState;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "SUCCESS", "FAILED", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum ExecuteState extends Enum<ExecuteState> {
        public static final ExecuteState FAILED = null;
        public static final ExecuteState RUNNING = null;
        public static final ExecuteState SUCCESS = null;
        public static final /* synthetic */ ExecuteState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ExecuteState> getEntries() {
            return b;
        }

        static {
            ExecuteState r0 = new ExecuteState("RUNNING", 0);
            RUNNING = r0;
            ExecuteState r1 = new ExecuteState("SUCCESS", 1);
            SUCCESS = r1;
            ExecuteState r3 = new ExecuteState("FAILED", 2);
            FAILED = r3;
            ExecuteState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ExecuteState[] values() {
            return (ExecuteState[]) a.clone();
        }

        public static ExecuteState valueOf(String r1) {
            return (ExecuteState) r27.a.a(ExecuteState.class, r1);
        }

        public ExecuteState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final OfficeBizType b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "BizUserKey(userId=" + this.a + ", bizType=" + this.b + ')';
        }

        public a(String r2, OfficeBizType r3) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            Intrinsics.checkNotNullParameter(r3, "bizType");
            this.a = r2;
            this.b = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0013\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003H&J\u0013\u0010\u0006\u001a\r\u0012\t\u0012\u00070\u0007¢\u0006\u0002\b\u00050\u0003H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/load/OfficeLoadCoordinator$OfficeLoadEntryPoint;", "", "loadTaskInjectors", "", "Lcom/ss/android/lark/officesdk/launcher/load/IOfficeLoadTaskInjector;", "Lkotlin/jvm/JvmSuppressWildcards;", "warmupJobs", "Lcom/ss/android/lark/officesdk/launcher/load/IOfficeLoadWarmupJob;", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface b {
        Set<com.ss.android.lark.officesdk.launcher.load.a> i();
    }

    public static final class c {
        public final Context a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "RequestContext(context=" + this.a + ", userId=" + this.b + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public c(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "userId");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[EnterResult.values().length];
            r0[EnterResult.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[EnterResult.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[EnterResult.START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[ExecuteState.values().length];
            r1[ExecuteState.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[ExecuteState.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[ExecuteState.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Function0 a;

        public e(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements ThreadFactory {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            return new PthreadThreadV2(r3, "office-load-warmup");
        }
    }

    public OfficeLoadCoordinator() {
    }

    static {
        a = new OfficeLoadCoordinator();
        b = new Handler(Looper.getMainLooper());
        c = PThreadExecutorsUtils.newSingleThreadExecutor(f.a);
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new com.ss.android.lark.officesdk.launcher.load.d();
    }

    public static void b(RuntimeStrategy r1, final Function0 r2) {
        if (r1 == RuntimeStrategy.MAIN) goto L5;
        new OfficeSDKRuntime(r1).run(new OfficeLoadCoordinator$dispatch$1(r2));
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        r2.invoke();
        return;
    L7:
        b.post(new e(r2));
    }

    public static void c(final OfficeBizType r10, final RuntimeStrategy r11) {
        Intrinsics.checkNotNullParameter(r10, "bizType");
        Intrinsics.checkNotNullParameter(r11, "strategy");
        if (r10 == OfficeBizType.BASE) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L58;
        Context r1 = OfficeSDKManager.getContext();
        if (r1 == null) goto L55;
        Context r2 = r1.getApplicationContext();
        if (r2 == null) goto L55;
        String r3 = OfficeSDKManager.getCurrentUid();
        if (r3 != null) goto L14;
        Log.e("OfficeLoadCoordinator", "validate request failed, no current uid, bizType=" + r10);
        throw new IllegalStateException("OfficeSDK load/warmup can only be called after onLoginSuccess");
    L14:
        if (OfficeSDKManager.getOfficeSDKUserComponent() == null) goto L51;
        Log.i("OfficeLoadCoordinator", "validate request success, bizType=" + r10);
        final c r4 = new c(r2, r3);
        final a r5 = new a(r4.b, r10);
        ConcurrentHashMap<a, ExecuteState> r6 = d;
    L16:
        ExecuteState r7 = r6.get(r5);
        if (r7 != null) goto L19;
        int r8 = -1;
    L21:
        if (r8 == (-1)) goto L30;
        if (r8 == 1) goto L29;
        if (r8 == 2) goto L28;
        if (r8 == 3) goto L30;
        throw new NoWhenBranchMatchedException();
    L28:
        EnterResult r9 = EnterResult.SUCCESS;
    L38:
        int r12 = d.a[r9.ordinal()];
        if (r12 != 1) goto L41;
        Log.i("OfficeLoadCoordinator", "load ignored because task is running, bizType=" + r10);
        return;
    L41:
        if (r12 == 2) goto L47;
        if (r12 != 3) goto L46;
        Log.i("OfficeLoadCoordinator", "load start, bizType=" + r10 + ", strategy=" + r11);
        b(r11, new OfficeLoadCoordinator$load$2(r5, r10, r11, r4));
        return;
    L46:
        throw new NoWhenBranchMatchedException();
    L47:
        Log.i("OfficeLoadCoordinator", "load already success, dispatch ready again, bizType=" + r10 + ", strategy=" + r11);
        b(r11, new OfficeLoadCoordinator$load$1(r10));
        return;
    L29:
        r9 = EnterResult.RUNNING;
    L30:
        ExecuteState r13 = ExecuteState.RUNNING;
        ExecuteState r14 = r6.putIfAbsent(r5, r13);
        if (r14 == null) goto L32;
        ExecuteState r15 = ExecuteState.FAILED;
        if (r14 != r15) goto L16;
        if (r6.replace(r5, r15, r13) == false) goto L16;
        r9 = EnterResult.START;
        goto L38
    L32:
        r9 = EnterResult.START;
        goto L38
    L19:
        r8 = d.b[r7.ordinal()];
        goto L21
    L51:
        Log.e("OfficeLoadCoordinator", "validate request failed, user component is not ready, bizType=" + r10);
        throw new IllegalStateException("OfficeSDK user component is not ready");
    L55:
        Log.e("OfficeLoadCoordinator", "validate request failed, OfficeSDK is not initialized, bizType=" + r10);
        throw new IllegalStateException("OfficeSDK is not initialized");
    L58:
        throw new IllegalArgumentException("BASE warmup should use OfficeSDK.warmup(context, OfficeBizType.BASE)".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final List a(OfficeLoadCoordinator r3, Context r4, OfficeBizType r5) {
        r3.getClass();
        Context r6 = r4.getApplicationContext();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.Application");
        Set<com.ss.android.lark.officesdk.launcher.load.a> r7 = ((b) EntryPointAccessors.fromApplication((Application) r6, b.class)).i();
        ArrayList r0 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        Object r1 = r8.next();
        if (((com.ss.android.lark.officesdk.launcher.load.a) r1).getBizType() != r5) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r2 = false;
        goto L9
    L11:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r0.iterator();
    L13:
        if (r10.hasNext() == false) goto L15;
        com.ss.android.lark.officesdk.launcher.load.a r11 = (com.ss.android.lark.officesdk.launcher.load.a) r10.next();
        com.ss.android.lark.officesdk.launcher.load.c r12 = new com.ss.android.lark.officesdk.launcher.load.c();
        r11.a(r12);
        CollectionsKt.addAll(r9, CollectionsKt.toList(r12.a.values()));
        goto L13
    L15:
        Log.i("OfficeLoadCoordinator", "collect load tasks, bizType=" + r5 + ", injectorCount=" + r7.size() + ", taskCount=" + r9.size());
        return r9;
    }
}
