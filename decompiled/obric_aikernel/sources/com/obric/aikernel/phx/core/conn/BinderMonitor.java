package com.obric.aikernel.phx.core.conn;

import android.os.IBinder;
import com.obric.aikernel.core.log.AIKLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
public final class BinderMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BinderMonitor f4766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, a> f4767b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f4768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g1<Boolean> f4769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IBinder.DeathRecipient f4770c;

        /* JADX INFO: renamed from: com.obric.aikernel.phx.core.conn.BinderMonitor$a$a, reason: collision with other inner class name */
        public static final class C0110a implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ IBinder f4771a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ g1<Boolean> f4772b;

            C0110a(IBinder r10, g1<Boolean> r11) {
                this.f4771a = r10;
                this.f4772b = r11;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                AIKLog.INSTANCE.i("BinderMonitor", "binderDied, start callback.");
                BinderMonitor.a().remove(Integer.valueOf(this.f4771a.hashCode()));
                ConcurrentHashMap r10 = BinderMonitor.a();
                LinkedHashMap r11 = new LinkedHashMap();
                Iterator r12 = r10.entrySet().iterator();
            L4:
                if (r12.hasNext() == false) goto L8;
                Map.Entry r13 = (Map.Entry) r12.next();
                if ((!((a) r13.getValue()).a().isBinderAlive()) == false) goto L4;
                r11.put(r13.getKey(), r13.getValue());
                goto L4
            L8:
                Iterator r14 = r11.entrySet().iterator();
            L10:
                if (r14.hasNext() == false) goto L12;
                BinderMonitor.a().remove(((Map.Entry) r14.next()).getKey());
                goto L10
            L12:
                this.f4772b.c(Boolean.FALSE);
            }
        }

        public a(IBinder r10, g1<Boolean> r11, IBinder.DeathRecipient r12) {
            Intrinsics.checkNotNullParameter(r10, "binder");
            Intrinsics.checkNotNullParameter(r11, "stateFlow");
            Intrinsics.checkNotNullParameter(r12, "recipient");
            this.f4768a = r10;
            this.f4769b = r11;
            this.f4770c = r12;
        }

        public /* synthetic */ a(IBinder r10, g1 r11, IBinder.DeathRecipient r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = q1.a(Boolean.TRUE);
        L6:
            if ((r13 & 4) == 0) goto L8;
            r12 = new C0110a(r10, r11);
        L8:
            this(r10, r11, r12);
        }

        public final IBinder a() {
            return this.f4768a;
        }

        public final IBinder.DeathRecipient b() {
            return this.f4770c;
        }

        public final g1<Boolean> c() {
            return this.f4769b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.f4768a, r11.f4768a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4769b, r11.f4769b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4770c, r11.f4770c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f4768a.hashCode() * 31) + this.f4769b.hashCode()) * 31) + this.f4770c.hashCode();
        }

        public String toString() {
            return "BinderInfo(binder=" + this.f4768a + ", stateFlow=" + this.f4769b + ", recipient=" + this.f4770c + ')';
        }
    }

    static {
        f4766a = new BinderMonitor();
        f4767b = new ConcurrentHashMap();
    }

    private BinderMonitor() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f4767b;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, com.obric.aikernel.phx.core.conn.BinderMonitor$a, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final v1 b(CoroutineContext r11, com.obric.aikernel.a r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "ctx");
        Intrinsics.checkNotNullParameter(r12, "binder");
        Intrinsics.checkNotNullParameter(r13, "onDied");
        IBinder r14 = r12.asBinder();
        int r10 = r14.hashCode();
        Ref.ObjectRef r15 = new Ref.ObjectRef();
        ConcurrentHashMap<Integer, a> r16 = f4767b;
        ?? r17 = r16.get(Integer.valueOf(r10));
        r15.element = r17;
        if (r17 != 0) goto L17;
        monitor-enter(this);
        r15.element = r16.get(Integer.valueOf(r10));     // Catch: Throwable -> L13
        if (r14.isBinderAlive() == true) goto L8;
    L10:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        goto L17
    L8:
        if (r15.element != 0) goto L10;
        Intrinsics.checkNotNullExpressionValue(r14, "bd");     // Catch: Throwable -> L13
        ?? r19 = new a(r14, null, null, 6, null);     // Catch: Throwable -> L13
        r16.put(Integer.valueOf(r10), (a) r19);     // Catch: Throwable -> L13
        r14.linkToDeath(r19.b(), 0);     // Catch: Throwable -> L13
        r15.element = r19;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L17:
        return h.d(m0.a(r11), null, null, new BinderMonitor$monitorTransact$job$1(r15, r11, r13, null), 3, null);
    }
}
