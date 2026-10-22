package com.bytedance.android.livesdk.chatroom.vs_base.base.service.out;

import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nm1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements h, o {
    public c() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final <T> Map<String, String> d(DataCenter r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        Map<String, String> r0 = null;
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.log.filter.o r4 = d.a(r2).c(r3);
        if (r4 == null) goto L7;
        Map<String, String> r5 = r4.getMap();
    L8:
        if (r5 == null) goto L9;
        return r5;
    L7:
        r5 = null;
    L9:
        com.bytedance.android.livesdk.log.filter.o r6 = d.b.c(r3);
        if (r6 == null) goto L13;
        r0 = r6.getMap();
    L13:
        return r0;
    }

    public final <T> void a(DataCenter r2, Class<T> r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.log.filter.o r5 = d.a(r2).c(r3);
        if (r5 == null) goto L7;
        r5.putAll(r4);
        Unit r6 = Unit.INSTANCE;
    L8:
        if (r6 == null) goto L9;
        return;
    L7:
        r6 = null;
    L9:
        com.bytedance.android.livesdk.log.filter.o r7 = d.b.c(r3);
        if (r7 == null) goto L14;
        r7.putAll(r4);
        Unit r8 = Unit.INSTANCE;
        return;
    }

    public final <T> void c(DataCenter r2, Class<T> r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.log.filter.o r5 = d.a(r2).c(r3);
        if (r5 == null) goto L7;
        r5.a(r4);
        Unit r6 = Unit.INSTANCE;
    L8:
        if (r6 == null) goto L9;
        return;
    L7:
        r6 = null;
    L9:
        com.bytedance.android.livesdk.log.filter.o r7 = d.b.c(r3);
        if (r7 == null) goto L14;
        r7.a(r4);
        Unit r8 = Unit.INSTANCE;
        return;
    }

    public final void f(DataCenter r3, String r4, Map<String, String> r5, Object... r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r6, "args");
        if (r3 == null) goto L5;
        d.a(r3).d(r4, r5, new Object[]{r6});
        return;
    L5:
        d.b.d(r4, r5, new Object[]{r6});
    }

    public final void g(DataCenter r3, String r4, Map<String, String> r5, Object... r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r6, "args");
        if (r3 == null) goto L5;
        d.a(r3).e(r4, r5, new Object[]{r6});
        return;
    L5:
        d.b.e(r4, r5, new Object[]{r6});
    }
}
