package com.obric.memorydata.b;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0014\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u0012\u001a\u00020\tJ\b\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/location/LocationPermissionManager;", "", "<init>", "()V", "TAG", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function0;", "", "stateLock", "lastPermissionState", "Lcom/obric/memorydata/location/LocationPermissionManager$PermissionState;", "hasFineLocationPermission", "", "hasBackgroundLocationPermission", "registerListener", "listener", "notifyPermissionChanged", "getCurrentPermissionState", "PermissionState", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8796a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Function0<Unit>> f8797b = null;
    private static final Object c = null;
    private static C0450a d;

    /* JADX INFO: renamed from: com.obric.memorydata.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/location/LocationPermissionManager$PermissionState;", "", "fineLocationGranted", "", "backgroundLocationGranted", "<init>", "(ZZ)V", "getFineLocationGranted", "()Z", "getBackgroundLocationGranted", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0450a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8799b;

        public C0450a(boolean r1, boolean r2) {
            this.f8798a = r1;
            this.f8799b = r2;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0450a.class) == true) goto L8;
            return false;
        L8:
            C0450a r6 = (C0450a) ZeusTransformUtils.preCheckCast(r5, C0450a.class, "com.obric.memorydata.plugin");
            if (this.f8798a == r6.f8798a) goto L12;
            return false;
        L12:
            if (this.f8799b == r6.f8799b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f8798a) * 31) + Boolean.hashCode(this.f8799b);
        }

        public String toString() {
            return "PermissionState(fineLocationGranted=" + this.f8798a + ", backgroundLocationGranted=" + this.f8799b + ')';
        }
    }

    static {
        a r0 = new a();
        f8796a = r0;
        f8797b = new CopyOnWriteArraySet();
        c = new Object();
        d = r0.d();
    }

    private a() {
    }

    private final C0450a d() {
        return new C0450a(a(), b());
    }

    public final void a(Function0<Unit> r2) {
        Function0<Unit> r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        f8797b.add(r1);
    }

    public final boolean a() {
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (a() == true) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L7;
    L8:
        return true;
    L7:
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) goto L9;
        goto L8
    }

    public final void c() {
        C0450a r4 = d();
        Object r0 = c;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(d, r4) == false) goto L7;
        boolean r5 = false;
    L9:
        monitor-exit(r0);
        if (r5 == true) goto L12;
        return;
    L12:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(f8797b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r6.hasNext() == false) goto L23;
        Function0 r1 = (Function0) ZeusTransformUtils.preCheckCast(r6.next(), Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L18
        r1.invoke();     // Catch: Throwable -> L18
        Object r3 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r3);
        if (r7 == null) goto L14;
        RunLog.INSTANCE.error("LocationPermissionManager", "notify location permission changed failed", r7);
    L18:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L23:
        return;
    L7:
        d = r4;     // Catch: Throwable -> L24
        r5 = true;
        goto L9
    }
}
