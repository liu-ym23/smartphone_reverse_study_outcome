package com.ss.android.lark.keyboard.utils;

import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TransitionUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(TransitionUtils$sPendingTransitionsField$2.INSTANCE);
    }

    public static boolean a(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "sceneRoot");
        Field r0 = (Field) a.getValue();
        ArrayList r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get(null);
    L7:
        if ((r2 instanceof ArrayList) == false) goto L9;
        r1 = (ArrayList) r2;
    L9:
        if (r1 != null) goto L11;
    L13:
        return false;
    L11:
        if (r1.contains(r3) != true) goto L13;
        return true;
    L5:
        r2 = null;
        goto L7
    }
}
