package com.ss.ugc.clientai.core.api;

import alc.d;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u00168\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR6\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00168\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a¨\u0006\""}, d2 = {"Lcom/ss/ugc/clientai/core/api/SmartServiceManager;", "", "", "type", "Ljava/util/ArrayList;", "Lalc/b;", "Lkotlin/collections/ArrayList;", "getEventTypeListener", "serviceName", "Lcom/ss/ugc/clientai/core/api/SmartService;", "getService", "getCommonService", "service", "", "addSmartService", "removeSmartService", "listener", "addCommonEventListener", "removeCommonEventListener", "Lalc/d;", "params", "onNotifyCommonEvent", "Ljava/util/concurrent/ConcurrentHashMap;", "services", "Ljava/util/concurrent/ConcurrentHashMap;", "getServices", "()Ljava/util/concurrent/ConcurrentHashMap;", "commonEventListeners", "getCommonEventListeners", "<init>", "()V", "Companion", "a", "b", "core-api_release"}, k = 1, mv = {1, 4, 1})
public class SmartServiceManager {
    public static final a Companion = null;
    private final ConcurrentHashMap<String, ArrayList<alc.b>> commonEventListeners;
    private final ConcurrentHashMap<String, SmartService> services;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.ugc.clientai.core.api.SmartServiceManager$a$a, reason: collision with other inner class name */
        public static final class C0199a {
            public static final SmartServiceManager a = null;

            static {
                a = new SmartServiceManager();
            }
        }

        public a() {
        }
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ArrayList a;

        public c(ArrayList r1, String r2, d r3) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r0 = this.a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            ((alc.b) r0.next()).a();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final SmartServiceManager instance() {
        Companion.getClass();
        int r0 = b.a;
        return a.C0199a.a;
    }

    public SmartServiceManager() {
        this.services = new ConcurrentHashMap();
        this.commonEventListeners = new ConcurrentHashMap();
    }

    public final ConcurrentHashMap<String, ArrayList<alc.b>> getCommonEventListeners() {
        return this.commonEventListeners;
    }

    public final ConcurrentHashMap<String, SmartService> getServices() {
        return this.services;
    }

    private final ArrayList<alc.b> getEventTypeListener(String r2) {
        ArrayList<alc.b> r3 = this.commonEventListeners.get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if ((!r3.isEmpty()) == false) goto L18;
        ArrayList<alc.b> r0 = new ArrayList();
        monitor-enter(r3);
        r0.addAll(r3);     // Catch: Throwable -> L11
        monitor-exit(r3);
        return r0;
    L11:
        th = move-exception;
        throw th;
    L18:
        return null;
    }

    public SmartService getCommonService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        return null;
    }

    public SmartService getService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        return this.services.get(r2);
    }

    public void removeSmartService(String r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        this.services.remove(r2);
    }

    public void addCommonEventListener(String r3, alc.b r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Objects.toString(r4);
        if (this.commonEventListeners.get(r3) != null) goto L5;
        this.commonEventListeners.put(r3, new ArrayList());
    L5:
        ArrayList<alc.b> r5 = this.commonEventListeners.get(r3);
        if (r5 == null) goto L17;
        monitor-enter(r5);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (r5.contains(r4) == true) goto L11;
        r5.add(r4);     // Catch: Throwable -> L14
    L11:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r5);
        return;
    }

    public void addSmartService(String r2, SmartService r3) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        Intrinsics.checkNotNullParameter(r3, "service");
        Objects.toString(r3);
        this.services.put(r2, r3);
    }

    public void onNotifyCommonEvent(String r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        ArrayList<alc.b> r0 = getEventTypeListener(r3);
        if (r0 == null) goto L6;
        c r1 = new c(r0, r3, r4);
        int r5 = alc.a.a;
        Intrinsics.checkNotNullParameter(r1, "runnable");
        int r6 = alc.a.C0004a.a;
        int r7 = alc.a.C0004a.C0005a.b.a;
        alc.a.C0004a.C0005a.C0006a.a.getClass();
        return;
    }

    public void removeCommonEventListener(String r2, alc.b r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Objects.toString(r3);
        ArrayList<alc.b> r4 = this.commonEventListeners.get(r2);
        if (r4 == null) goto L11;
        monitor-enter(r4);
        r4.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r4);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
