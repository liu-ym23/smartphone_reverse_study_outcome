package com.larus.bmhome.chat.bubble.floating.runtime;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final j a = null;
    public static final l b = null;
    public static final CoroutineScope c = null;
    public static final Handler d = null;
    public static final Map<String, List<a>> e = null;
    public static final Set<String> f = null;

    public static final class a {
        public final WeakReference<k.a> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "RefreshRegistration(listenerRef=" + this.a + ')';
        }

        public a(WeakReference<k.a> r2) {
            Intrinsics.checkNotNullParameter(r2, "listenerRef");
            this.a = r2;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BubbleBannerState.values().length];
            r0[BubbleBannerState.ENTERING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BubbleBannerState.VISIBLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BubbleBannerState.EXITING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public j() {
    }

    public static Map l() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("banner_action_result", "fail"), TuplesKt.to("banner_action_fail_reason", "system_error")});
    }

    static {
        a = new j();
        b = new l();
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        d = new Handler(Looper.getMainLooper());
        e = new LinkedHashMap();
        f = new LinkedHashSet();
    }

    public static void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "promptId");
        pc8.e r2 = b.a(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        j(r2, true);
    }

    public static void f(String r5) {
        List r0 = (List) ((LinkedHashMap) e).get(r5);
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        k.a r3 = ((a) r1.next()).a.get();
        if (r3 == null) goto L7;
        r2.add(r3);
        goto L7
    L12:
        if (r2.size() == r0.size()) goto L25;
        Map<String, List<a>> r4 = e;
        LinkedHashMap r6 = (LinkedHashMap) r4;
        List r7 = (List) r6.get(r5);
        if (r7 == null) goto L16;
        CollectionsKt.removeAll(r7, new i());
    L16:
        Collection r8 = (Collection) r6.get(r5);
        if (r8 != null) goto L19;
    L22:
        boolean r9 = true;
    L23:
        if (r9 == false) goto L25;
        r4.remove(r5);
        goto L25
    L19:
        if (r8.isEmpty() == true) goto L22;
        r9 = false;
    L25:
        Iterator r10 = r2.iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        ((k.a) r10.next()).E(r5);
        goto L27
    }

    public static void g(String r8) {
        Intrinsics.checkNotNullParameter(r8, "promptId");
        l r1 = b;
        pc8.e r2 = r1.a(r8);
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.c == BubbleBannerState.VISIBLE) goto L8;
        return;
    L8:
        if (r2.h == true) goto L11;
        return;
    L11:
        if (r2.f == false) goto L14;
        return;
    L14:
        if (r2.e > 0) goto L16;
        r1.c(r8, k(r2, System.currentTimeMillis()));
    L16:
        Handler r3 = com.larus.bmhome.chat.bubble.floating.runtime.b.a;
        Intrinsics.checkNotNullParameter(r8, "promptId");
        if (com.larus.bmhome.chat.bubble.floating.runtime.b.b.containsKey(r8) == true) goto L23;
        pc8.e r9 = r1.a(r8);
        if (r9 == null) goto L24;
        com.larus.bmhome.chat.bubble.floating.runtime.b.b(r9);
        return;
    L24:
        return;
    }

    public static void a(String r2, BubbleBannerDismissReason r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "reason");
        l r0 = b;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r2, "conversationId");     // Catch: Throwable -> L11
        List r4 = CollectionsKt.listOfNotNull(r0.b(r2));     // Catch: Throwable -> L11
        monitor-exit(r0);
        Iterator r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        pc8.e r1 = (pc8.e) r5.next();
        j r6 = a;
        String r7 = r1.a;
        r6.getClass();
        c(r7, r3);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean c(final String r19, BubbleBannerDismissReason r20) {
        Intrinsics.checkNotNullParameter(r19, "promptId");
        Intrinsics.checkNotNullParameter(r20, "reason");
        l r14 = b;
        pc8.e r15 = r14.a(r19);
        if (r15 != null) goto L5;
        return false;
    L5:
        com.larus.bmhome.chat.bubble.floating.runtime.b.a(r19);
        if (r20 != BubbleBannerDismissReason.HOST_UNAVAILABLE) goto L17;
        BubbleBannerState r0 = r15.c;
        if (r0 != BubbleBannerState.EXITING) goto L11;
        return false;
    L11:
        if (r0 != BubbleBannerState.ENTERING) goto L13;
    L14:
        e(r15, r20);
    L15:
        j(r15, true);
        return true;
    L13:
        if (r0 != BubbleBannerState.VISIBLE) goto L15;
    L17:
        BubbleBannerState r2 = r15.c;
        int r3 = b.a[r2.ordinal()];
        if (r3 != 1) goto L20;
    L24:
        e(r15, r20);
        pc8.i r10 = h(r19, BubbleBannerTransitionType.EXIT);
        pc8.f r1 = r15.d;
        if (r1 == null) goto L28;
        Set<BubbleBannerRenderPart> r4 = r1.c;
        if (r4 == null) goto L28;
    L29:
        pc8.b r11 = new pc8.b(r4, SetsKt.emptySet());
        monitor-enter(r14);
        Intrinsics.checkNotNullParameter(r19, "promptId");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r20, "reason");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r10, "transition");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r11, "exitCompletion");     // Catch: Throwable -> L40
        pc8.e r5 = r14.a.get(r19);     // Catch: Throwable -> L40
        if (r5 != null) goto L35;
        monitor-exit(r14);
    L37:
        String r6 = r15.b.b;
        Handler r7 = d;
        r7.post(new e(r6));
        r7.postDelayed(new f(r19), 600);
    L38:
        return true;
    L35:
        r14.a.put(r19, pc8.e.a(r5, BubbleBannerState.EXITING, null, 0, false, false, false, r20, r10, r11, null, 2299));     // Catch: Throwable -> L40
        monitor-exit(r14);
    L40:
        th = move-exception;
        throw th;
    L28:
        r4 = SetsKt.setOf(BubbleBannerRenderPart.CONTENT);
        goto L29
    L20:
        if (r3 == 2) goto L24;
        if (r3 == 3) goto L45;
        j(r15, false);
        goto L38
    L45:
        return false;
    }

    public static void d(pc8.e r2, Map r3) {
        sc8.i r0 = sc8.i.a;
        sc8.a r1 = new sc8.a(r3);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r2, "prompt");
        Intrinsics.checkNotNullParameter(r1, "result");
        sc8.b r4 = pc8.g.b(r2);
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r1, "result");
        sc8.i.c(new sc8.e(sc8.i.b(r4.a), r4, r1));
    }

    public static void e(pc8.e r2, final BubbleBannerDismissReason r3) {
        sc8.i.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "prompt");
        Intrinsics.checkNotNullParameter(r3, "reason");
        final sc8.b r4 = pc8.g.b(r2);
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r3, "reason");
        final List r0 = sc8.i.b(r4.a);
        sc8.i.c(new sc8.f(r0, r4, r3));
    }

    public static pc8.i h(String r5, BubbleBannerTransitionType r6) {
        long r0 = SystemClock.uptimeMillis();
        return new pc8.i(r6.name() + '_' + r5 + '_' + r0, r6, r0);
    }

    public static void j(pc8.e r5, boolean r6) {
        l r0 = b;
        String r1 = r5.a;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r1, "promptId");     // Catch: Throwable -> L15
        pc8.e r2 = r0.a.remove(r1);     // Catch: Throwable -> L15
        if (r2 != null) goto L8;
        monitor-exit(r0);
    L12:
        if (r6 == false) goto L20;
        String r7 = r5.b.b;
        d.post(new e(r7));
        return;
    L20:
        return;
    L8:
        Map<String, String> r3 = r0.b;     // Catch: Throwable -> L15
        LinkedHashMap r4 = (LinkedHashMap) r3;     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r4.get(r2.b.b), r1) == false) goto L11;
        r0.b.remove(r2.b.b);     // Catch: Throwable -> L15
    L11:
        monitor-exit(r0);
    L15:
        th = move-exception;
        throw th;
    }

    public static long k(pc8.e r5, long r6) {
        if (r5.f == false) goto L5;
        return 0;
    L5:
        long r3 = r5.e;
        if (r3 <= 0) goto L8;
        return r3;
    L8:
        long r4 = r5.b.f.c;
        if (r4 > 0) goto L12;
        return 0;
    L12:
        return r6 + (r4 * 1000);
    }

    public static void i(Context r1, pc8.e r2, String r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r3)) == true) goto L7;
        r3 = null;
    L7:
        if (r3 == null) goto L21;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        SmartRouter.buildRoute(r1, r3).d();     // Catch: Throwable -> L11
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L20;
        FLogger.a.w("BubbleBannerManager", r4 + " failed, promptId=" + r2.a, r6);
        return;
    L20:
        return;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
