package com.bytedance.android.livesdk.dispatch.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.dispatch.DispatchContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "injectObjKey");
        Intrinsics.checkNotNullParameter(r6, "injectObj");
        DataContext r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L5;
        j r1 = r0.getDispatchContext();
    L6:
        if (r1 == null) goto L9;
        r4 = (DataContext) r1.getValue();
    L9:
        if ((r4 instanceof DispatchContext) == false) goto L27;
        Object r2 = r1.getValue();
        if (r2 == null) goto L26;
        DispatchContext r3 = (DispatchContext) r2;
        if (r3.getHasInit() == true) goto L15;
        r3.initProxy();
    L15:
        Lazy r7 = DispatchLogUtil.a;
        DispatchLogUtil.a("injectObjKey 是 " + r5 + ", obj 是 " + r6);
        Iterator<T> r8 = r3.getNeedInjectInstances().values().iterator();
    L17:
        if (r8.hasNext() == false) goto L37;
        st1.a r9 = (st1.a) r8.next();
        Lazy r10 = DispatchLogUtil.a;
        DispatchLogUtil.a("当前扫描到的proxy 是 " + r9);
        Map<String, Function1<Object, Unit>> r11 = r9.b();
        if (r11 == null) goto L17;
        if (r11.containsKey(r5) != true) goto L17;
        DispatchLogUtil.a("找到了 proxy " + r9 + " 当前注入的key是 " + r5);
        Map<String, Function1<Object, Unit>> r12 = r9.b();
        Intrinsics.checkNotNull(r12);
        Function1<Object, Unit> r13 = r12.get(r5);
        if (r13 == null) goto L17;
        Unit r14 = (Unit) r13.invoke(r6);
        goto L17
    L37:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.dispatch.DispatchContext");
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
