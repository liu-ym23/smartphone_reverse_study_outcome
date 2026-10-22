package com.bytedance.android.livesdk.dslservice.util;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dsl.util.DSLLog;
import com.bytedance.android.livesdkapi.depend.model.live.room.dsl.BackendDsls;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class DSLTemplateCenter implements zt1.c {
    public static final ConcurrentHashMap<String, com.bytedance.android.livesdk.dsl.util.d> e = null;
    public final CompositeDisposable a;
    public final HashMap<String, zt1.d> b;
    public final Vector<com.bytedance.android.livesdk.dslservice.util.d> c;
    public final DataCenter d;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r1) {
            if (((com.bytedance.android.livesdk.dsl.util.b) r1) != null) goto L6;
            return;
        L6:
            throw null;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DSLTemplateCenter a;

        public c(DSLTemplateCenter r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((com.bytedance.android.livesdk.dsl.util.a) r2) != null) goto L5;
            return;
        L5:
            this.a.e(null);
            throw null;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e {
    }

    static {
        e = new ConcurrentHashMap();
    }

    @Override // zt1.c
    public final void b() {
        com.bytedance.android.livesdk.chatroom.q r2 = iv1.a.a(this.d, 2);
        if (r2 == null) goto L6;
        r2.a(a0.n(this.d).getId(), this.d, BackendDsls.class, DSLTemplateCenter$startReceiveBackendData$1.INSTANCE, new DSLTemplateCenter$startReceiveBackendData$2(this), this.a);
        return;
    }

    @Override // zt1.c
    public final void onClear() {
        this.a.clear();
    }

    public DSLTemplateCenter(DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.d = r4;
        CompositeDisposable r5 = new CompositeDisposable();
        this.a = r5;
        this.b = new HashMap();
        this.c = new Vector();
        RxUtilKt.c(xs2.b.a().b(com.bytedance.android.livesdk.dsl.util.b.class).subscribe(a.a, b.a), r5);
        RxUtilKt.c(xs2.b.a().b(com.bytedance.android.livesdk.dsl.util.a.class).subscribe(new c(this), d.a), r5);
    }

    @Override // zt1.c
    public final com.bytedance.android.livesdk.dsl.util.d c(yt1.q r2) {
        Intrinsics.checkNotNullParameter(r2, "templateKey");
        if (v.a() == true) goto L7;
        return null;
    L7:
        return e.get(r2.a);
    }

    public final void e(com.bytedance.android.livesdk.dsl.util.d r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        zt1.d r0 = this.b.get(r6.c);
        String r1 = "";
        if (r0 == null) goto L11;
        Lazy r3 = DSLLog.a;
        StringBuilder r4 = new StringBuilder("LoadTemplate2 ");
        r4.append(r6.c);
        r4.append(' ');
        yt1.o r2 = r6.a;
        Object r5 = r1;
        if (r2 == null) goto L10;
        yt1.q r7 = r2.b;
        r5 = r1;
        if (r7 == null) goto L10;
        r5 = r7;
    L10:
        r4.append(r5);
        DSLLog.a(r4.toString());
        d(r6, r0);
        return;
    L11:
        Lazy r8 = DSLLog.a;
        StringBuilder r9 = new StringBuilder("LoadTemplate delay ");
        r9.append(r6.c);
        r9.append(' ');
        yt1.o r10 = r6.a;
        String r11 = r1;
        if (r10 == null) goto L19;
        yt1.q r12 = r10.b;
        r11 = r1;
        if (r12 == null) goto L19;
        String r13 = r12.a;
        r11 = r1;
        if (r13 == null) goto L19;
        r11 = r13;
    L19:
        r9.append(r11);
        DSLLog.a(r9.toString());
        this.c.add(new com.bytedance.android.livesdk.dslservice.util.d(r6));
    }

    @Override // zt1.c
    public final void a(String r4, zt1.d r5) {
        Intrinsics.checkNotNullParameter(r4, "containerName");
        Intrinsics.checkNotNullParameter(r5, "viewContainer");
        this.b.put(r4, r5);
        Lazy r0 = DSLLog.a;
        DSLLog.a("DSLContainerAdded: " + r4);
        Iterator<com.bytedance.android.livesdk.dslservice.util.d> r1 = this.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        com.bytedance.android.livesdk.dslservice.util.d r2 = r1.next();
        if (Intrinsics.areEqual(r2.a.c, r4) == false) goto L4;
    L9:
        com.bytedance.android.livesdk.dslservice.util.d r3 = r2;
        if (r3 == null) goto L21;
        this.c.remove(r3);
        Lazy r6 = DSLLog.a;
        StringBuilder r7 = new StringBuilder("LoadTemplate1 ");
        r7.append(r4);
        r7.append(' ');
        yt1.o r8 = r3.a.a;
        if (r8 == null) goto L15;
        Object r9 = r8.b;
        if (r9 == null) goto L15;
    L16:
        r7.append(r9);
        DSLLog.a(r7.toString());
        d(r3.a, r5);
        return;
    L15:
        r9 = "";
        goto L16
    L21:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void d(com.bytedance.android.livesdk.dsl.util.d r9, zt1.d r10) {
        if (r10.a() != 1) goto L15;
        r10.e();
        yt1.o r3 = r9.a;
        ViewGroup r5 = r10.c();
        if (r3 == null) goto L19;
        if (r5 == null) goto L20;
        Lazy r0 = DSLLog.a;
        DSLLog.a("load dsl " + r3.b.a);
        com.bytedance.android.livesdk.chatroom.q r1 = iv1.a.a(this.d, 2);
        if (r1 == null) goto L14;
        com.bytedance.live.datacontext.j r2 = r1.E1();
        if (r2 == null) goto L14;
        yt1.n r4 = (yt1.n) r2.getValue();
        if (r4 == null) goto L14;
        r4.d(r3, r9.b, r5, new yt1.c(), null);
    L14:
        r10.b();
        return;
    L20:
        return;
    L19:
        return;
    L15:
        yt1.o r6 = r9.a;
        if (r6 == null) goto L22;
        DSLLog.a("load dsl by container self");
        r10.d(r6, r9.b);
        return;
    }
}
