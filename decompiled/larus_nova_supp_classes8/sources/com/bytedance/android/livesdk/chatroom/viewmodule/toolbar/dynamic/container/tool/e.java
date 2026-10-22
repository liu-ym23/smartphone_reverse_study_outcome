package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ContainerContextEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.more.MorePanelHandler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    static {
    }

    public static void a(ot2.a r4, ContainerContextEnv r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "env");
        if (Intrinsics.areEqual(r4, ot2.a.a.a) == false) goto L18;
        Intrinsics.checkNotNullParameter(r5, "env");
        r5.e = new BottomToolbarContainerDataManager(r5.f, new BottomToolbarContainerFactory$createDataManager$1(r5));
        ot2.d r6 = r5.c;
        if (r6 == null) goto L7;
        d r0 = new d(r6, r5.f);
    L8:
        r5.b = r0;
        BottomToolbarHandler r7 = new BottomToolbarHandler(r5);
        zo1.f<s> r1 = r5.e;
        if (r1 == null) goto L11;
        r1.d("showing", r7);
    L11:
        Unit r2 = Unit.INSTANCE;
        r5.d = r7;
        Iterator r8 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("ready", new MorePanelHandler(true, r5)), TuplesKt.to("ready", new c(r5))}).iterator();
    L13:
        if (r8.hasNext() == false) goto L30;
        Pair r3 = (Pair) r8.next();
        zo1.f<s> r9 = r5.e;
        if (r9 == null) goto L13;
        r9.d((String) r3.getFirst(), (zo1.g) r3.getSecond());
        goto L13
    L30:
        return;
    L7:
        r0 = null;
        goto L8
    L18:
        if (Intrinsics.areEqual(r4, ot2.a.b.a) == false) goto L29;
        Intrinsics.checkNotNullParameter(r5, "env");
        r5.e = new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.more.a();
        MorePanelHandler r10 = new MorePanelHandler(false, r5);
        zo1.f<s> r11 = r5.e;
        if (r11 == null) goto L22;
        r11.d("showing", r10);
    L22:
        Unit r12 = Unit.INSTANCE;
        r5.d = r10;
        return;
    }
}
