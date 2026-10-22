package com.bytedance.ai.debugscene;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.debugrouter.DebugRouter;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t2 {
    public static final t2 a = null;

    static {
        a = new t2();
    }

    public t2() {
    }

    public static void c() {
        Object r0 = r2.a;
        monitor-enter(r0);
        HashMap<Integer, r2.a> r1 = r2.d;     // Catch: Throwable -> L12
        int r10 = r1.size();     // Catch: Throwable -> L12
        Iterator<T> r11 = r1.values().iterator();     // Catch: Throwable -> L12
    L6:
        if (r11.hasNext() == false) goto L8;
        ((r2.a) r11.next()).d = null;     // Catch: Throwable -> L12
        goto L6
    L8:
        r2.d.clear();     // Catch: Throwable -> L12
        monitor-exit(r0);
        com.bytedance.ai.utils.g.a.d("JsbDebugRuntimeRegistry", "clear session bindings, count:" + r10);
        Function2<? super q2, ? super String, Unit> r12 = p2.a;
        p2.a = null;
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void b(boolean r10) {
        Object r0 = r2.a;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(r2.b.keySet());     // Catch: Throwable -> L12
        monitor-exit(r0);
        Iterator r11 = r1.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        a.getClass();
        a(r12, r10);
        goto L8
    L10:
        com.bytedance.ai.utils.g.a.d("JsbDebugTransport", "notify debug channel state, open:" + r10 + ", runtimeCount:" + r1.size());
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static JavaOnlyMap f(JSONObject r10) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r11 = r1.next();
        t2 r12 = a;
        Object r13 = r10.opt(r11);
        r12.getClass();
        r0.put(r11, g(r13));
        goto L4
    L6:
        return r0;
    }

    public static Object g(Object r10) {
        if (Intrinsics.areEqual(r10, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r10 instanceof JSONObject) == false) goto L9;
        return f((JSONObject) r10);
    L9:
        if ((r10 instanceof JSONArray) == false) goto L18;
        JSONArray r11 = (JSONArray) r10;
        JavaOnlyArray r0 = new JavaOnlyArray();
        int r1 = r11.length();
        int r12 = 0;
    L11:
        if (r12 >= r1) goto L14;
        t2 r13 = a;
        Object r14 = r11.opt(r12);
        r13.getClass();
        r0.add(g(r14));
        r12 = r12 + 1;
        goto L11
    L14:
        return r0;
    L18:
        return r10;
    }

    public static void a(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "runtime");
        JavaOnlyMap r1 = new JavaOnlyMap();
        r1.putString("type", "debug_channel_state");
        r1.putBoolean(com.bytedance.android.ec.core.event.a.VALUE_OPEN, r11);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
        JavaOnlyArray r13 = JavaOnlyArray.of(new Object[]{r1});     // Catch: Throwable -> L13
        if ((r10 instanceof LynxView) == false) goto L8;
        ((LynxView) r10).sendGlobalEvent("__DOUBAO_JSB_DEBUG__", r13);     // Catch: Throwable -> L13
    L10:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r14 = Result.exceptionOrNull-impl(r0);
        if (r14 == null) goto L20;
        com.bytedance.ai.utils.g.a.e("JsbDebugTransport", "notify debug channel state failed, open:" + r11 + ", engine:" + r10.getClass().getSimpleName() + ", error:" + r14.getMessage());
        return;
    L20:
        return;
    L8:
        if ((r10 instanceof LynxBackgroundRuntime) == false) goto L12;
        ((LynxBackgroundRuntime) r10).f("__DOUBAO_JSB_DEBUG__", r13);     // Catch: Throwable -> L13
        goto L10
    L12:
        throw new IllegalStateException("unsupported runtime: ".concat(r10.getClass().getName()).toString());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static Object d(int r10, String r11) {
        LynxView r0 = DebugRouter.getInstance().getViewBySessionId(r10);
        if ((r0 instanceof LynxView) == false) goto L5;
        LynxView r1 = r0;
    L6:
        if (r1 != null) goto L10;
        r1 = e(r11, r10);
        if (r1 != null) goto L10;
        return null;
    L10:
        Object r12 = r2.a;
        Intrinsics.checkNotNullParameter(r1, "engineObject");
        Object r13 = r2.a;
        monitor-enter(r13);
        r2.a r14 = r2.b.get(r1);     // Catch: Throwable -> L46
        if (r14 != null) goto L15;
        r14 = null;
    L22:
        Long r15 = null;
        Integer r16 = null;
    L32:
        monitor-exit(r13);
        if (r14 != null) goto L35;
        q2 r17 = null;
    L41:
        if (r17 != null) goto L44;
        com.bytedance.ai.utils.g.a.w("JsbDebugTransport", "resolved runtime is not registered, appId:" + r11 + ", sessionId:" + r10 + ", engine:" + r1.getClass().getSimpleName());
        return null;
    L44:
        com.bytedance.ai.utils.g.a.d("JsbDebugTransport", "resolved and bound runtime, appId:" + r11 + ", sessionId:" + r10 + ", handle:" + r17.a + ", engine:" + r1.getClass().getSimpleName());
        return r1;
    L35:
        if (r16 != null) goto L39;
        if (r15 != null) goto L39;
        com.bytedance.ai.utils.g.a.d("JsbDebugRuntimeRegistry", "bind session, sessionId:" + r10 + ", handle:" + r14.a.a);
    L40:
        r17 = r14.a;
    L39:
        com.bytedance.ai.utils.g.a.w("JsbDebugRuntimeRegistry", "replace binding, sessionId:" + r10 + ", handle:" + r14.a.a + ", previousSession:" + r16 + ", previousHandle:" + r15);
        goto L40
    L15:
        Integer r18 = r14.d;     // Catch: Throwable -> L46
        if (r18 != null) goto L19;
    L23:
        HashMap<Integer, r2.a> r19 = r2.d;     // Catch: Throwable -> L46
        r2.a r20 = r19.get(Integer.valueOf(r10));     // Catch: Throwable -> L46
        if (r20 == null) goto L26;
        r15 = Long.valueOf(r20.a.a);     // Catch: Throwable -> L46
        r20.d = null;     // Catch: Throwable -> L46
    L27:
        Integer r21 = r14.d;     // Catch: Throwable -> L46
        if (r21 == null) goto L30;
        int r22 = r21.intValue();     // Catch: Throwable -> L46
        r16 = Integer.valueOf(r22);     // Catch: Throwable -> L46
        r2.a r23 = r19.remove(Integer.valueOf(r22));     // Catch: Throwable -> L46
    L31:
        r14.d = Integer.valueOf(r10);     // Catch: Throwable -> L46
        r19.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L46
        goto L32
    L30:
        r16 = null;
        goto L31
    L26:
        r15 = null;
        goto L27
    L19:
        if (r18.intValue() != r10) goto L23;
        if (r2.d.get(Integer.valueOf(r10)) != r14) goto L23;
    L46:
        th = move-exception;
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    public static LynxBackgroundRuntime e(String r10, int r11) {
        Object r0 = r2.a;
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        Object r1 = r2.a;
        monitor-enter(r1);
        r2.a r12 = r2.e.get(r10);     // Catch: Throwable -> L20
        if (r12 == null) goto L8;
        Object r13 = r12.b;     // Catch: Throwable -> L20
    L9:
        monitor-exit(r1);
        if ((r13 instanceof LynxBackgroundRuntime) == true) goto L19;
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        StringBuilder r15 = new StringBuilder("background runtime not registered, appId:");
        r15.append(r10);
        r15.append(", sessionId:");
        r15.append(r11);
        r15.append(", runtime:");
        if (r13 == null) goto L15;
        String r16 = r13.getClass().getSimpleName();
    L16:
        r15.append(r16);
        r14.w("JsbDebugTransport", r15.toString());
        return null;
    L15:
        r16 = null;
        goto L16
    L19:
        return (LynxBackgroundRuntime) r13;
    L8:
        r13 = null;
    L20:
        th = move-exception;
        throw th;
    }
}
