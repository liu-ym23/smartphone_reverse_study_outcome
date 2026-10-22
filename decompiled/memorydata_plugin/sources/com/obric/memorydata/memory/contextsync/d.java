package com.obric.memorydata.memory.contextsync;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\b\u0010\u001f\u001a\u0004\u0018\u00010 J\n\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u001b\u0010\"\u001a\u0004\u0018\u00010\u001b*\u00020#2\u0006\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\n \n*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextSwitchProviderClient;", "", "<init>", "()V", "TAG", "", "AUTHORITY", "PATH_MEMORY_SYNC", "MEMORY_SYNC_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "COLUMN_GLOBAL_MEMORY", "COLUMN_PERSONAL_INFO_MEMORY", "QUERY_PROJECTION", "", "[Ljava/lang/String;", "QUERY_TIMEOUT_MS", "", "observerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "providerCallExecutor", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", "observer", "Landroid/database/ContentObserver;", "registerRootObserver", "", "onChange", "Lkotlin/Function0;", "", "querySnapshot", "Lcom/obric/memorydata/memory/contextsync/MemoryContextSwitchSnapshot;", "querySnapshotInternal", "readBooleanSwitch", "Landroid/database/Cursor;", "columnName", "(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/Boolean;", "providerExists", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10097a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f10098b = null;
    private static final String[] c = null;
    private static final AtomicBoolean d = null;
    private static final ExecutorService e = null;
    private static volatile ContentObserver f;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/contextsync/MemoryContextSwitchProviderClient$registerRootObserver$newObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f10099a;

        a(Function0<Unit> r3, Handler r4) {
            this.f10099a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            super(r4);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r7) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "memory_sync root changed", false, 4, null);
            this.f10099a.invoke();
        }
    }

    static {
        f10097a = new d();
        f10098b = Uri.parse("content://com.obric.assistant.provider.ObricPersonalContextProvider/memory_sync");
        c = new String[]{"reference_memory", "reference_memory_personal_info"};
        d = new AtomicBoolean(false);
        e = Executors.newFixedThreadPool(2, $$Lambda$d$iUE6doFbzpRYrHd68COvUp0FoV0.INSTANCE);
    }

    private d() {
    }

    private final Boolean a(Cursor r9, String r10) {
        Cursor r8 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r9, Cursor.class, "com.obric.memorydata.plugin");
        int r11 = r8.getColumnIndex(r10);
        if (r11 >= 0) goto L5;
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot missing column=" + r10, null, 4, null);
        return null;
    L5:
        if (r8.isNull(r11) == true) goto L15;
        int r12 = r8.getInt(r11);
        if (r12 == 0) goto L14;
        if (r12 == 1) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot invalid value=" + r12 + ", column=" + r10, null, 4, null);
        return null;
    L18:
        return true;
    L14:
        return false;
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "MemoryContextSwitchProviderThread");
        r0.setDaemon(true);
        return r0;
    }

    private final e b() {
        ContentResolver r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Uri r2 = f10098b;
        ContentProviderClient r16 = r15.acquireUnstableContentProviderClient(r2);
        e r8 = null;
        if (r16 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot acquire provider client failed", null, 4, null);
        return null;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot request, uri=" + r2, false, 4, null);
        Cursor r1 = ZeusProviderTransform.query(r16, r2, c, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28 RuntimeException -> L30 RemoteException -> L33 DeadObjectException -> L35
        if (r1 == null) goto L27;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28 RuntimeException -> L30 RemoteException -> L33 DeadObjectException -> L35
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r4.moveToFirst() == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot returned no initialized row", false, 4, null);     // Catch: Throwable -> L22
    L19:
        e r5 = null;
    L20:
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L28 RuntimeException -> L30 RemoteException -> L33 DeadObjectException -> L35
        r8 = r5;
        goto L27
    L13:
        d r6 = f10097a;     // Catch: Throwable -> L22
        Boolean r7 = r6.a(r4, "reference_memory");     // Catch: Throwable -> L22
        if (r7 == null) goto L19;
        boolean r9 = r7.booleanValue();     // Catch: Throwable -> L22
        Boolean r10 = r6.a(r4, "reference_memory_personal_info");     // Catch: Throwable -> L22
        if (r10 == null) goto L19;
        r5 = new e(r9, r10.booleanValue(), false);     // Catch: Throwable -> L22
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot response, globalMemory=" + r5.a() + ", personalInfoMemory=" + r5.b() + ", collectionMemory=" + r5.c(), false, 4, null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L28 RuntimeException -> L30 RemoteException -> L33 DeadObjectException -> L35
        throw th;     // Catch: Throwable -> L28 RuntimeException -> L30 RemoteException -> L33 DeadObjectException -> L35
    L27:
        r16.close();
        return r8;
    L28:
        th = move-exception;
        r16.close();
        throw th;
    L35:
        e = move-exception;
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        String r12 = "MeD_MemoryContextSwitchProvider";
        String r13 = "querySnapshot provider died: " + e;     // Catch: Throwable -> L28
    L32:
        IRunLog.a.a(r11, r12, r13, null, 4, null);     // Catch: Throwable -> L28
    L33:
        e = move-exception;
        r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        r12 = "MeD_MemoryContextSwitchProvider";
        r13 = "querySnapshot remote exception: " + e;     // Catch: Throwable -> L28
    L30:
        e = move-exception;
        r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        r12 = "MeD_MemoryContextSwitchProvider";
        r13 = "querySnapshot runtime exception: " + e;     // Catch: Throwable -> L28
        goto L32
    }

    private final boolean c() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().resolveContentProvider("com.obric.assistant.provider.ObricPersonalContextProvider", 0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    private static final e d() {
        return f10097a.b();
    }

    public static /* synthetic */ Thread lambda$iUE6doFbzpRYrHd68COvUp0FoV0(Runnable r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$sna4Mjfl9aur-gQpVVEDnwMyXY0, reason: not valid java name */
    public static /* synthetic */ e m692lambda$sna4Mjfl9aurgQpVVEDnwMyXY0() {
        return d();
    }

    public final e a() {
        if (c() == true) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot provider not found", null, 4, null);
        return null;
    L28:
        Future r2 = e.submit($$Lambda$d$sna4Mjfl9aurgQpVVEDnwMyXY0.INSTANCE);     // Catch: ExecutionException -> L13 InterruptedException -> L16 TimeoutException -> L21
    L31:
        goto L22
    L26:
        return (e) ZeusTransformUtils.preCheckCast(r2.get(5000, TimeUnit.MILLISECONDS), e.class, "com.obric.memorydata.plugin");
    L11:
        e = e;
    L18:
        if (r2 == null) goto L20;
        r2.cancel(true);
    L20:
        Thread.currentThread().interrupt();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "querySnapshot interrupted: " + e, null, 4, null);
        return null;
    L22:
        if (r2 == null) goto L24;
        boolean r10 = r2.cancel(true);
    L25:
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("querySnapshot timeout, cancel=").append(r10);
    L15:
        IRunLog.a.a(r3, "MeD_MemoryContextSwitchProvider", r11.toString(), null, 4, null);
        return null;
    L24:
        r10 = false;
    L13:
        e = move-exception;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r11 = new StringBuilder().append("querySnapshot execution failed: ").append(e);
    L16:
        e = e;
        r2 = null;
    L21:
        r2 = null;
        goto L22
    }

    public final synchronized boolean a(Function0<Unit> r11) {
        monitor-enter(this);
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r12, "onChange");     // Catch: Throwable -> L21
        AtomicBoolean r0 = d;     // Catch: Throwable -> L21
        boolean r2 = true;
        if (r0.get() == false) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (c() == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "registerRootObserver provider not found", null, 4, null);     // Catch: Throwable -> L21
        monitor-exit(this);
        return false;
    L13:
        a r4 = new a(r12, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L21
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), f10098b, false, (ContentObserver) ZeusTransformUtils.preCheckCast(r4, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L16 Throwable -> L21
        f = (ContentObserver) ZeusTransformUtils.preCheckCast(r4, ContentObserver.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L16 Throwable -> L21
        r0.set(true);     // Catch: RuntimeException -> L16 Throwable -> L21
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "registerRootObserver success", false, 4, null);     // Catch: RuntimeException -> L16 Throwable -> L21
    L19:
        monitor-exit(this);
        return r2;
    L16:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSwitchProvider", "registerRootObserver failed: " + e, null, 4, null);     // Catch: Throwable -> L21
        r2 = false;
    L21:
        th = move-exception;
        throw th;
    }
}
