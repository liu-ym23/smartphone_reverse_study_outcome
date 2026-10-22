package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y {
    public final HashSet<Integer> a;
    public final SparseArray<ToolbarComponentCheckInterface> b;
    public final HashMap<NewToolbarButtonConstants, Runnable> c;
    public final String d;

    public y() {
        this.a = new HashSet();
        this.b = new SparseArray();
        this.c = new HashMap();
        this.d = "NewToolbarLog";
    }

    public final void a(s r3, Function0<Unit> r4, Function1<? super String, Unit> r5) {
        ToolbarComponentCheckInterface r0 = this.b.get(r3.a);
        if (r0 == null) goto L5;
        Boolean r6 = Boolean.valueOf(r0.checkThenLoad(r3, r4, r5));
    L6:
        Boolean r1 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r6, r1)) == false) goto L10;
        r4.invoke();
    L10:
        if (Intrinsics.areEqual(r6, r1) == false) goto L13;
        ALogger.i(this.d, "component handle! - " + r3);
        return;
    L13:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L15;
        ALogger.i(this.d, "component don't handle! - " + r3);
        return;
    L15:
        if (r6 != null) goto L20;
        ALogger.i(this.d, "no component filter - " + r3);
        return;
    L20:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
