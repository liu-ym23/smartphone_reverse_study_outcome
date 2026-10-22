package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ViewTraverseProcessor {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static boolean c;
    public static final WeakHashMap<View, WeakHashMap<View, Boolean>> d = null;
    public static final Lazy e = null;

    public ViewTraverseProcessor() {
    }

    static {
        a = LazyKt.lazy(ViewTraverseProcessor$mInternalViewMemCache$2.INSTANCE);
        b = LazyKt.lazy(ViewTraverseProcessor$mProcessorChain$2.INSTANCE);
        c = true;
        d = new WeakHashMap();
        e = LazyKt.lazy(ViewTraverseProcessor$traversePoolThreadScope$2.INSTANCE);
    }

    public static void a(View r10) {
        BuildersKt.async$default((CoroutineScope) e.getValue(), null, null, new ViewTraverseProcessor$rootViewOut$1(r10, null), 3, null);
    }

    public static void b(View r10, int r11, TraverseFromType r12) {
        if (c == true) goto L37;
        return;
    L37:
    L28:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L33;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L33:
        if (("TraverseProcessor >>> visit view  exception = " + e.getMessage()) == null) goto L35;
        Context r14 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L35:
        Unit r15 = Unit.INSTANCE;
        return;
    L6:
        if (("traverseView rootView = " + r10 + ", traverseFromType = " + r12.name()) == null) goto L9;
        Context r1 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
    L9:
        if (r12 != TraverseFromType.InternalVisitViewGlobalLayoutChange) goto L11;
    L16:
        boolean r16 = true;
    L17:
        if (r16 == true) goto L19;
    L26:
        BuildersKt.async$default((CoroutineScope) e.getValue(), null, null, new ViewTraverseProcessor$traverseView$$inlined$Try$lambda$1(new WeakReference(r10), null, r10, r12, r11), 3, null);     // Catch: Exception -> L28
        return;
    L19:
        if (r10.getWidth() != 0) goto L26;
        if (r10.getHeight() != 0) goto L26;
        if (("width or height not valid,traverseFromType = " + r12.name()) == null) goto L38;
        Context r17 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L28
        return;
    L38:
        return;
    L11:
        if (r12 == TraverseFromType.FragmentGlobalLayoutChange) goto L16;
        if (r12 == TraverseFromType.ActivityGlobalLayoutChange) goto L16;
        r16 = false;
        goto L17
    }
}
