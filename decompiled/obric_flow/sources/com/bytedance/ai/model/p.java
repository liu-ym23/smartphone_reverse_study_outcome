package com.bytedance.ai.model;

import com.bytedance.ai.core.base.SessionType;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2292a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f2293b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static t0.b f2294c;
    public static final List d = null;

    static {
        f2292a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new a3.f(7));
        f2293b = new LinkedHashMap();
        d = CollectionsKt.emptyList();
    }

    public static AppletRuntime a(String r5, String r10, String r11) {
        com.bytedance.ai.core.manager.b r12 = (com.bytedance.ai.core.manager.b) f2292a.getValue();
        if (r5 != null) goto L10;
        if (r10 == null) goto L9;
        ConcurrentHashMap r13 = o2.a.f20402a;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() == 0) goto L9;
        String r14 = (String) o2.a.f20402a.get(r10);
    L12:
        if (com.bytedance.ai.utils.c.l(r11) == false) goto L20;
        AppletRuntime r15 = (AppletRuntime) r12.f2141a.get(r11);
        if (r15 != null) goto L16;
    L34:
        if (r15 == null) goto L38;
        if (r5 == null) goto L37;
        r15.k(r5, r10, SessionType.f2087a);
    L37:
        return r15;
    L38:
        return null;
    L16:
        if (r15.f2200k.get() != true) goto L34;
        if (r11 == null) goto L34;
        r12.d(r11);
    L19:
        r15 = null;
        goto L34
    L20:
        if (r14 == null) goto L33;
        Iterator r16 = MapsKt.asSequence(r12.f2141a).iterator();
    L23:
        if (r16.hasNext() == false) goto L29;
        Object r17 = r16.next();
        AppletRuntime r18 = (AppletRuntime) ((Map.Entry) r17).getValue();
        if (r18.f2200k.get() == true) goto L23;
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        if (((com.bytedance.ai.core.base.g) r18.f2206q.get(r14)) == null) goto L23;
    L30:
        Map.Entry r19 = (Map.Entry) r17;
        if (r19 == null) goto L19;
        r15 = (AppletRuntime) r19.getValue();
        goto L34
    L29:
        r17 = null;
        goto L30
    L33:
        r12.getClass();
    L9:
        r14 = null;
        goto L12
    L10:
        r14 = r5;
        goto L12
    }

    public static com.bytedance.ai.model.widgets.a b() {
        LinkedHashMap r5 = f2293b;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl((com.bytedance.ai.model.widgets.a) CollectionsKt.last(r5.values()));     // Catch: Throwable -> L5
    L8:
        if (Result.m130isFailureimpl(r11) == false) goto L11;
        r11 = null;
    L11:
        return (com.bytedance.ai.model.widgets.a) r11;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static Object c(String r10, String r11, String r12, String r13, Map r14, Continuation r15) {
        return BuildersKt.withContext(t2.b.f22091c, new AppletRuntimeManager$awaitRunApplet$2(r10, r11, r12, r13, r14, null), r15);
    }

    public static void d(String r11, String r12, String r13, String r14, String r15, Map r16, Function1 r17) {
        Intrinsics.checkNotNullParameter(r11, "appletId");
        Intrinsics.checkNotNullParameter(r12, "conversationID");
        Intrinsics.checkNotNullParameter(r13, "botId");
        Intrinsics.checkNotNullParameter(r17, "runAppletResult");
        StringBuilder r5 = new StringBuilder("runApplet called. appletId:");
        f8.b.e(r5, r11, ", conversationID:", r12, ", botId:");
        String r10 = f4.b.b(r5, r13, ", messageId:", r14);
        Intrinsics.checkNotNullParameter("AIManager", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L5;
        r18.i("AIManager", r10);
    L5:
        BuildersKt.launch$default(h0.a(t2.b.f22091c), null, null, new AppletRuntimeManager$runApplet$1(r11, r12, r13, r14, r15, r16, r17, null), 3, null);
    }

    public static /* synthetic */ void e(String r10, String r11, String r12, String r13, Map r14, Function1 r15, int r16) {
        if ((r16 & 8) == 0) goto L5;
        r13 = "";
    L5:
        String r5 = r13;
        if ((r16 & 32) == 0) goto L8;
        r14 = null;
    L8:
        d(r10, r11, r12, r5, "", r14, r15);
    }

    public static void f(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "invoke");
        com.bytedance.ai.core.manager.b r10 = (com.bytedance.ai.core.manager.b) f2292a.getValue();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "invoke");
        Iterator r11 = r10.f2141a.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((AppletRuntime) r12.getValue()).f2200k.get() == true) goto L4;
        r5.invoke(r12.getValue());
        goto L4
    L8:
        Iterator r13 = r10.f2142b.entrySet().iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (((AppletRuntime) r14.getValue()).f2200k.get() == true) goto L10;
        r5.invoke(r14.getValue());
        goto L10
    }

    public static com.bytedance.ai.widget.contianer.f g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetId");
        com.bytedance.ai.widget.l r10 = com.bytedance.ai.widget.o.f3079j;
        monitor-enter(r10);
        Intrinsics.checkNotNullParameter(r5, "widgetId");     // Catch: Throwable -> L13
        Iterator r11 = CollectionsKt.e(com.bytedance.ai.widget.o.f3080k).iterator();     // Catch: Throwable -> L13
    L5:
        com.bytedance.ai.widget.contianer.f r12 = null;
        if (r11.hasNext() == false) goto L15;
        com.bytedance.ai.widget.o r13 = (com.bytedance.ai.widget.o) ((WeakReference) r11.next()).get();     // Catch: Throwable -> L13
        if (r13 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "widgetId");     // Catch: Throwable -> L13
        r12 = r13.c(new com.bytedance.ai.widget.i(r5, 1));     // Catch: Throwable -> L13
    L10:
        if (r12 == null) goto L5;
        monitor-exit(r10);
        return r12;
    L15:
        monitor-exit(r10);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public static String h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        ConcurrentHashMap r10 = o2.a.f20402a;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r11 = o2.a.f20402a.entrySet().iterator();
    L3:
        String r12 = null;
        if (r11.hasNext() == false) goto L8;
        Object r13 = r11.next();
        if (Intrinsics.areEqual(((Map.Entry) r13).getValue(), r5) == false) goto L3;
    L9:
        Map.Entry r14 = (Map.Entry) r13;
        if (r14 == null) goto L12;
        String r15 = (String) r14.getKey();
    L13:
        if (r15 != null) goto L21;
        t0.b r16 = f2294c;
        if (r16 == null) goto L17;
        r12 = r16.conversationIdToBotId(r5);
    L17:
        if (r12 != null) goto L20;
        return "";
    L20:
        return r12;
    L21:
        return r15;
    L12:
        r15 = null;
        goto L13
    L8:
        r13 = null;
        goto L9
    }
}
