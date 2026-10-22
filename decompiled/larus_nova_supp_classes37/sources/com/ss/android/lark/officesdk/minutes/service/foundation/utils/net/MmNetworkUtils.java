package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmNetworkUtils {
    public static final Object a = null;
    public static final LinkedHashMap<Integer, Function2<Boolean, String, Unit>> b = null;
    public static int c;
    public static b d;
    public static ConnectivityManager e;

    public static final class a implements NetworkLevelListener {
        public final /* synthetic */ Ref.ObjectRef<Boolean> a;
        public final /* synthetic */ Ref.ObjectRef<Job> b;
        public final /* synthetic */ CoroutineScope c;
        public final /* synthetic */ long d;
        public final /* synthetic */ Function1<Boolean, Unit> e;

        public a(Ref.ObjectRef r1, Ref.ObjectRef r2, CoroutineScope r3, long r4, Function1 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void a(NetworkLevelListener.NetworkLevel r10) {
            MmNetworkUtils.d(this.a, this.b, this.c, this.d, "MmNetworkUtils", this.e, !c.b(r10), "rust_net_state");
        }
    }

    public MmNetworkUtils() {
    }

    static {
        a = new Object();
        b = new LinkedHashMap();
        c = 1;
    }

    public static final void b(Integer r3) {
        if (r3 == null) goto L35;
        Object r0 = a;
        monitor-enter(r0);
        LinkedHashMap<Integer, Function2<Boolean, String, Unit>> r1 = b;     // Catch: Throwable -> L28
        r1.remove(r3);     // Catch: Throwable -> L28
        if ((!r1.isEmpty()) == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        b r4 = d;     // Catch: Throwable -> L28
        if (r4 != null) goto L32;
        monitor-exit(r0);
        return;
    L32:
        ConnectivityManager r2 = e;     // Catch: Throwable -> L20 Exception -> L22
        if (r2 == null) goto L23;
        r2.unregisterNetworkCallback(r4);     // Catch: Throwable -> L20 Exception -> L22
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L20 Exception -> L22
    L23:
        d = null;     // Catch: Throwable -> L28
        e = null;     // Catch: Throwable -> L28
        monitor-exit(r0);
        return;
    L20:
        th = move-exception;
        d = null;     // Catch: Throwable -> L28
        e = null;     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L22:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L28:
        th = move-exception;
        throw th;
    }

    public static final void a(boolean r3, String r4) {
        Object r0 = a;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(b.values());     // Catch: Throwable -> L11
        monitor-exit(r0);
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((Function2) r2.next()).invoke(Boolean.valueOf(r3), r4);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static Job c(final String r17, final CoroutineScope r18, final long r19, final Function1 r21) {
        Intrinsics.checkNotNullParameter(r17, "scene");
        Intrinsics.checkNotNullParameter(r18, "scope");
        Intrinsics.checkNotNullParameter(r21, "onNetworkAvailable");
        final String r13 = "MmNetworkUtils";
        Application r0 = LarkContext.getApplication();
        if (r0 != null) goto L6;
        lvb.a.h("MmNetworkUtils", "[launchNetworkChangeJob] app null, skip register");
        return null;
    L6:
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        final a r11 = new a(r12, r15, r18, r19, r21);
        Object r4 = LarkNetworkLevelManager.d;
        LarkNetworkLevelManager.a.a().w0(r11);
        Function2<Boolean, String, Unit> r10 = new MmNetworkUtils$launchNetworkChangeJob$systemListenerId$1(r12, r15, r18, r19, r13, r21);
        Object r5 = a;
        monitor-enter(r5);
        int r6 = c;     // Catch: Throwable -> L30
        c = r6 + 1;     // Catch: Throwable -> L30
        b.put(Integer.valueOf(r6), r10);     // Catch: Throwable -> L30
        if (d == null) goto L13;
        Integer r1 = Integer.valueOf(r6);     // Catch: Throwable -> L30
        monitor-exit(r5);
    L28:
        Object r7 = LarkNetworkLevelManager.d;
        NetworkLevelListener.NetworkLevel r8 = LarkNetworkLevelManager.a.a().getCurNetWorkLevel();
        Intrinsics.checkNotNull(r8);
        d(r12, r15, r18, r19, "MmNetworkUtils", r21, !c.b(r8), "init, scene:".concat(r17));
        Job r9 = BuildersKt.launch$default(r18, null, null, new MmNetworkUtils$launchNetworkChangeJob$job$1(null), 3, null);
        final Integer r14 = r1;
        r9.invokeOnCompletion(new MmNetworkUtils$launchNetworkChangeJob$1(r13, r17, r11, r14, r15));
        return r9;
    L13:
        Object r2 = r0.getSystemService("connectivity");     // Catch: Throwable -> L30
        if ((r2 instanceof ConnectivityManager) == false) goto L16;
        ConnectivityManager r3 = (ConnectivityManager) r2;     // Catch: Throwable -> L30
    L17:
        if (r3 != null) goto L21;
        lvb.a.h("MmNetworkUtils", "[network] connectivity manager null, skip register");     // Catch: Throwable -> L30
        r1 = Integer.valueOf(r6);     // Catch: Throwable -> L30
        monitor-exit(r5);
        goto L28
    L21:
        b r16 = new b();     // Catch: Throwable -> L30
        r3.registerNetworkCallback(new NetworkRequest.Builder().build(), r16);     // Catch: Exception -> L24 Throwable -> L30
        e = r3;     // Catch: Exception -> L24 Throwable -> L30
        d = r16;     // Catch: Exception -> L24 Throwable -> L30
        r1 = Integer.valueOf(r6);     // Catch: Exception -> L24 Throwable -> L30
    L27:
        monitor-exit(r5);
        goto L28
    L24:
        e = move-exception;
        lvb.a.b("MmNetworkUtils", "[network] registerNetworkCallback failed: " + e);     // Catch: Throwable -> L30
        b.remove(Integer.valueOf(r6));     // Catch: Throwable -> L30
        r1 = null;
        goto L27
    L16:
        r3 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public static final void d(Ref.ObjectRef<Boolean> r12, Ref.ObjectRef<Job> r13, CoroutineScope r14, long r15, String r17, Function1<? super Boolean, Unit> r18, boolean r19, String r20) {
        if (Intrinsics.areEqual(r12.element, Boolean.valueOf(r19)) == false) goto L5;
        return;
    L5:
        r12.element = Boolean.valueOf(r19);
        Job r0 = (Job) r13.element;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        r13.element = BuildersKt.launch$default(r14, null, null, new MmNetworkUtils$launchNetworkChangeJob$dispatch$1(r15, r17, r20, r19, r18, null), 3, null);
    }
}
