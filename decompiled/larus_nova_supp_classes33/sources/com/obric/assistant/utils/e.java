package com.obric.assistant.utils;

import android.app.Activity;
import com.larus.common.apphost.AppHost;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Object a(Class r6) {
        Intrinsics.checkNotNullParameter(r6, "activityClass");
        List r0 = AppHost.a.a().g();
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        Object r2 = r1.previous();
        if (r6.isInstance((Activity) r2) == false) goto L4;
    L9:
        Activity r3 = (Activity) r2;
        if (r3 != null) goto L12;
        return null;
    L12:
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getTaskId() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        List r5 = AppHost.a.a().m();
        if ((true ^ r5.contains(r3)) == false) goto L22;
        Object r7 = (Activity) CollectionsKt.getOrNull(r0, r0.lastIndexOf(r3) - 1);
        if (r7 != null) goto L26;
    L31:
        return null;
    L26:
        if (r6.isInstance(r7) == false) goto L31;
        if (r5.contains(r7) == false) goto L31;
        return r6.cast(r7);
    L22:
        return r6.cast(r3);
    L18:
        return r6.cast(r3);
    L15:
        r4 = false;
        goto L16
    L8:
        r2 = null;
        goto L9
    }
}
