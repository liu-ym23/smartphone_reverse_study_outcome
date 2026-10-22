package qb;

import ge.r;
import he.i;
import he.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f11288a = null;

    /* JADX INFO: renamed from: qb.a$a, reason: collision with other inner class name */
    public static final class C0143a extends j implements r<Integer, Integer, Integer, Boolean, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0143a f11289a = null;

        static {
            f11289a = new C0143a();
        }

        public C0143a() {
            super(4);
        }

        @Override // ge.r
        public final xd.j d(Integer r8, Integer r10, Integer r11, Boolean r12) {
            int r13 = r8.intValue();
            int r14 = r10.intValue();
            int r15 = r11.intValue();
            boolean r16 = r12.booleanValue();
            StringBuilder r17 = defpackage.a.g("wsStatusReceiverFromMatrix receive: channelType = ", r13, ", connectionState = ", r14, ", channelId = ");
            r17.append(r15);
            r17.append(", isConnected = ");
            r17.append(r16);
            i.f(r17.toString(), "msg");
            ArrayList r18 = a.f11288a;
            monitor-enter(r18);
            Iterator r19 = r18.iterator();     // Catch: Throwable -> L12
        L6:
            if (r19.hasNext() == false) goto L9;
            ((r) r19.next()).d(Integer.valueOf(r13), Integer.valueOf(r14), Integer.valueOf(r15), Boolean.valueOf(r16));     // Catch: Throwable -> L12
            goto L6
        L9:
            monitor-exit(r18);
            return xd.j.f13877a;
        L12:
            th = move-exception;
            throw th;
        }
    }

    static {
        f11288a = new ArrayList();
        new ConcurrentHashMap();
        new b(C0143a.f11289a);
    }
}
