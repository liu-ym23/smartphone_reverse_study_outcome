package com.larus.reach.runtime;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.reach.api.ReachPresentationCapabilityProvider;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachSceneInterceptor;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y {
    public static Map<String, ? extends List<? extends ReachSceneLifecycleListener>> a;
    public static Map<String, ? extends List<? extends ReachSceneInterceptor>> b;
    public static Map<String, ? extends List<? extends ReachPresentationCapabilityProvider>> c;

    static {
    }

    public static Map b() {
        Map<String, ? extends List<? extends ReachPresentationCapabilityProvider>> r0 = c;
        if (r0 != null) goto L19;
        Set r1 = ServiceManager.get().getServices(ReachPresentationCapabilityProvider.class, true);
        if (r1 != null) goto L7;
        r1 = SetsKt.emptySet();
    L7:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        String r5 = ((ReachPresentationCapabilityProvider) r4).a();
        Object r6 = r2.get(r5);
        if (r6 != null) goto L13;
        r6 = new ArrayList();
        r2.put(r5, r6);
    L13:
        ((List) r6).add(r4);
        goto L9
    L14:
        c = r2;
        return r2;
    L19:
        return r0;
    }

    public static Map e() {
        Map<String, ? extends List<? extends ReachSceneInterceptor>> r0 = b;
        if (r0 != null) goto L19;
        Set r1 = ServiceManager.get().getServices(ReachSceneInterceptor.class, true);
        if (r1 != null) goto L7;
        r1 = SetsKt.emptySet();
    L7:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        String r5 = ((ReachSceneInterceptor) r4).a();
        Object r6 = r2.get(r5);
        if (r6 != null) goto L13;
        r6 = new ArrayList();
        r2.put(r5, r6);
    L13:
        ((List) r6).add(r4);
        goto L9
    L14:
        b = r2;
        return r2;
    L19:
        return r0;
    }

    public static Map g() {
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r0 = a;
        if (r0 != null) goto L19;
        Set r1 = ServiceManager.get().getServices(ReachSceneLifecycleListener.class, true);
        if (r1 != null) goto L7;
        r1 = SetsKt.emptySet();
    L7:
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        String r5 = ((ReachSceneLifecycleListener) r4).a();
        Object r6 = r2.get(r5);
        if (r6 != null) goto L13;
        r6 = new ArrayList();
        r2.put(r5, r6);
    L13:
        ((List) r6).add(r4);
        goto L9
    L14:
        a = r2;
        return r2;
    L19:
        return r0;
    }

    public static boolean a(ns9.t r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        List r0 = f(r6.a.c);
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L24;
        ReachSceneInterceptor r2 = (ReachSceneInterceptor) r1.next();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Object r4 = Result.constructor-impl(Boolean.valueOf(r2.f(r6)));     // Catch: Throwable -> L13
    L15:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L18;
        FLogger.a.w("ReachSceneDispatcher", "reach scene canShow failed, reachUniqueId=" + r6.a.h + ", scene=" + r6.a.c, r5);
    L18:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L22;
        r4 = r7;
    L22:
        if (((Boolean) r4).booleanValue() == true) goto L9;
        return false;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        return true;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public static void d(ns9.t r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Iterator r0 = h(r5.a.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ReachSceneLifecycleListener r1 = (ReachSceneLifecycleListener) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.g(r5);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        FLogger.a.w("ReachSceneDispatcher", "reach scene onShow failed, reachUniqueId=" + r5.a.h + ", scene=" + r5.a.c, r4);
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static List f(String r2) {
        List r0 = (List) e().get("*");
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = r0;
        List r3 = (List) e().get(r2);
        if (r3 != null) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r1, r3);
    }

    public static List h(String r2) {
        List r0 = (List) g().get("*");
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r1 = r0;
        List r3 = (List) g().get(r2);
        if (r3 != null) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.plus(r1, r3);
    }

    public static void c(ns9.t r5, ReachRejectReason r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        Intrinsics.checkNotNullParameter(r6, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Iterator r0 = h(r5.a.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        ReachSceneLifecycleListener r1 = (ReachSceneLifecycleListener) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.f(r5, r6);     // Catch: Throwable -> L8
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L4;
        FLogger.a.w("ReachSceneDispatcher", "reach scene onDiscard failed, reachUniqueId=" + r5.a.h + ", scene=" + r5.a.c, r4);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
