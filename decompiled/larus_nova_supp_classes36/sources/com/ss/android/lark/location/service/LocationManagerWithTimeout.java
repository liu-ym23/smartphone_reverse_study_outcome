package com.ss.android.lark.location.service;

import android.app.Application;
import android.location.LocationListener;
import android.location.LocationManager;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LocationManagerWithTimeout {
    public static final LocationManagerWithTimeout a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    public LocationManagerWithTimeout() {
    }

    static {
        a = new LocationManagerWithTimeout();
        b = LazyKt.lazy(LocationManagerWithTimeout$dispatcher$2.INSTANCE);
        c = LazyKt.lazy(LocationManagerWithTimeout$scope$2.INSTANCE);
        d = LazyKt.lazy(LocationManagerWithTimeout$context$2.INSTANCE);
        e = LazyKt.lazy(LocationManagerWithTimeout$locationManager$2.INSTANCE);
        new WeakHashMap();
    }

    public static final boolean a() {
        LocationManagerWithTimeout r0 = a;
        if (ContextCompat.checkSelfPermission(r0.getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L5;
    L7:
        return false;
    L5:
        if (ContextCompat.checkSelfPermission(r0.getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) goto L7;
        return true;
    }

    public static final /* synthetic */ Application c() {
        return a.getContext();
    }

    private final Application getContext() {
        return (Application) d.getValue();
    }

    public static final void b(List r5) {
        LocationManagerWithTimeout r0 = a;
        monitor-enter(r0);
        List r1 = r5;     // Catch: Throwable -> L32
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        monitor-exit(r0);
        return;
    L14:
        Iterator r3 = r5.iterator();     // Catch: Throwable -> L32
    L16:
        if (r3.hasNext() == false) goto L29;
        LocationListener r4 = (LocationListener) r3.next();     // Catch: Throwable -> L32
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L24
        LocationManager r7 = (LocationManager) e.getValue();     // Catch: Throwable -> L24
        if (fna.g.d() == true) goto L21;
        r7.removeUpdates(r4);     // Catch: Throwable -> L24
    L22:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L32
        if (r9 == null) goto L16;
        Log.e("LocationManager.WithTimeout", "locationManager.removeUpdates error", r9);     // Catch: Throwable -> L32
        goto L16
    L21:
        r7.removeUpdates(r4);     // Catch: Throwable -> L24
        nna.a.a(r4.hashCode());     // Catch: Throwable -> L24
        goto L22
    L24:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L32
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L32
        goto L26
    L29:
        r5.clear();     // Catch: Throwable -> L32
        monitor-exit(r0);
        return;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    L32:
        th = move-exception;
        throw th;
    }
}
