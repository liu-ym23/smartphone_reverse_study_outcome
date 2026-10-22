package com.obric.memorydata.sdk.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.obric.capabilitykit.PackageUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class MemoryDataServiceProxy {
    public static final MemoryDataServiceProxy a = null;
    public static volatile IMemoryDataService b;
    public static Context c;
    public static final Handler d = null;
    public static volatile boolean e;
    public static volatile int f;
    public static final com.obric.memorydata.sdk.service.a g = null;
    public static final ConcurrentHashMap<Integer, a> h = null;
    public static final c i = null;
    public static final b j = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/service/MemoryDataServiceProxy$ServiceProxy;", "Lcom/obric/memorydata/sdk/service/IMemoryDataService;", "service", "<init>", "(Lcom/obric/memorydata/sdk/service/IMemoryDataService;)V", "getService", "()Lcom/obric/memorydata/sdk/service/IMemoryDataService;", "asBinder", "Landroid/os/IBinder;", "queryBinder", "binderCode", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class ServiceProxy implements IMemoryDataService {
        private final IMemoryDataService service;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.service.asBinder();
        L4:
            return null;
        }

        public final IMemoryDataService getService() {
            return this.service;
        }

        public ServiceProxy(IMemoryDataService r2) {
            Intrinsics.checkNotNullParameter(r2, "service");
            this.service = r2;
        }

        @Override // com.obric.memorydata.sdk.service.IMemoryDataService
        public IBinder queryBinder(int r2) {
            return this.service.queryBinder(r2);
        L4:
            return null;
        }
    }

    public interface a {
        void binderDied();
    }

    public MemoryDataServiceProxy() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.memorydata.sdk.service.a] */
    static {
        a = new MemoryDataServiceProxy();
        d = new Handler(Looper.getMainLooper());
        f = 64;
        g = new com.obric.memorydata.sdk.service.a();
        h = new ConcurrentHashMap();
        i = new c();
        j = new b();
    }

    public final void unbindService() {
        pka.b.a(new c());
    }

    public final boolean bindService(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return bindService(r2, 64);
    }

    public static boolean a(Context r5, int r6) {
        Context r7 = r5.getApplicationContext();
        c = r7;
        f = r6;
        e = true;
        Handler r1 = d;
        com.obric.memorydata.sdk.service.a r2 = g;
        r1.removeCallbacks(r2);
        r1.postDelayed(r2, 12000);
        Intent r3 = new Intent();
        r3.setAction("com.obric.memorydata.sdk");
        r3.setPackage(PackageUtils.NOVA_PKG_NAME);
        int r8 = r6 | 1;
        boolean r9 = r7.bindService(r3, j, r8);     // Catch: Exception -> L5
    L7:
        if (r9 == true) goto L9;
        d.removeCallbacks(g);
        e = false;
    L9:
        return r9;
    L5:
        r9 = false;
        goto L7
    }

    public final boolean bindService(final Context r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Boolean r4 = (Boolean) pka.b.a(new b(r2, r3));
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.booleanValue();
    }
}
