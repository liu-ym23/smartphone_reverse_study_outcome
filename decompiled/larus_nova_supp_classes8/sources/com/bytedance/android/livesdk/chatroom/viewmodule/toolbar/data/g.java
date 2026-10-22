package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T extends a2, R extends a2> {
    public static final /* synthetic */ int f = 0;
    public final C0062g<T> a;
    public e<T> b;
    public final e<R> c;
    public i<R> d;
    public final d<T, R> e;

    public static final class a {
        public static void a(String r2, List r3) {
            Intrinsics.checkNotNullParameter(r2, "startInfo");
            Intrinsics.checkNotNullParameter(r3, "list");
            StringBuilder r0 = new StringBuilder(r2 + " [");
            Iterator r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.append(((a2) r4.next()).debugName() + " ");
            goto L4
        L6:
            r0.append("]");
            ALogger.i("MorePanelDataManager", r0.toString());
        }
    }

    public interface b<T extends a2> extends a2 {
        boolean a(T r1);
    }

    public interface c<T extends a2> extends a2 {
        boolean b();

        List<T> c();

        void d();

        void onLoad();

        void onUnLoad();
    }

    public static final class d<T extends a2, R extends a2> {
        public h<R> a;

        public d() {
        }
    }

    public static final class e<T extends a2> extends f<b<T>, T> {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(List<T> r8) {
            Intrinsics.checkNotNullParameter(r8, "list");
            Iterator r9 = ((ArrayList) r8).iterator();
        L4:
            if (r9.hasNext() == false) goto L14;
            a2 r0 = (a2) r9.next();
            Iterator r1 = this.a.iterator();
            boolean r3 = false;
        L7:
            if (r1.hasNext() == false) goto L12;
            b r4 = (b) r1.next();
            boolean r5 = r4.a(r0);
            if (r5 == false) goto L11;
            int r6 = g.f;
            a.a("Delete by " + r4.debugName() + " :", CollectionsKt.arrayListOf(new a2[]{r0}));
        L11:
            r3 = r5;
            goto L7
        L12:
            if (r3 == false) goto L4;
            r9.remove();
            goto L4
        }
    }

    public static abstract class f<Handler, Button extends a2> {
        public final ArrayList<Handler> a;

        public f() {
            this.a = new ArrayList();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g$g, reason: collision with other inner class name */
    public static final class C0062g<T extends a2> extends f<c<T>, T> {
        public C0062g() {
        }
    }

    public interface h<R extends a2> {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e a(a2 r1);
    }

    public interface i<T extends a2> {
        void a(List<T> r1);
    }

    static {
    }

    public g() {
        new ArrayList();
        this.a = new C0062g();
        this.b = new e();
        this.c = new e();
        this.e = new d();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a(c<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        if (r2.b() == false) goto L6;
        r2.onLoad();
        this.a.a.add((Handler) r2);
        return;
    }
}
