package com.bytedance.android.annie.container.dialog;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final Map<String, HybridDialog> a = null;
    public static final Map<String, WeakReference<HybridDialog>> b = null;

    static {
        a = new LinkedHashMap();
        b = new LinkedHashMap();
    }

    public static void a(HybridDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L11;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @JvmStatic
    public static final void c(HybridDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        String r1 = "";
        if (i9.e.a.booleanValue() == false) goto L15;
        Iterator r0 = ((LinkedHashMap) b).keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        String r11 = (String) r0.next();
        WeakReference r12 = (WeakReference) ((LinkedHashMap) b).get(r11);
        if (r12 == null) goto L10;
        HybridDialog r13 = (HybridDialog) r12.get();
    L12:
        if (Intrinsics.areEqual(r13, r10) == false) goto L6;
        r1 = r11;
        goto L6
    L10:
        r13 = null;
        goto L12
    L14:
        b.remove(r1);
        return;
    L15:
        Iterator r14 = ((LinkedHashMap) a).keySet().iterator();
    L17:
        if (r14.hasNext() == false) goto L21;
        String r15 = (String) r14.next();
        if (Intrinsics.areEqual(((LinkedHashMap) a).get(r15), r10) == false) goto L17;
        r1 = r15;
        goto L17
    L21:
        a.remove(r1);
    }

    @JvmStatic
    public static final void b(String r10, HybridDialog r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r11, "dialog");
        if (i9.e.a.booleanValue() == false) goto L11;
        Map<String, WeakReference<HybridDialog>> r0 = b;
        WeakReference r1 = (WeakReference) ((LinkedHashMap) r0).get(r10);
        if (r1 == null) goto L7;
        HybridDialog r12 = (HybridDialog) r1.get();
    L8:
        if (r12 != null) goto L10;
        r0.put(r10, new WeakReference(r11));
        return;
    L10:
        a(r11);
        return;
    L7:
        r12 = null;
        goto L8
    L11:
        Map<String, HybridDialog> r13 = a;
        if (((HybridDialog) ((LinkedHashMap) r13).get(r10)) != null) goto L14;
        r13.put(r10, r11);
        return;
    L14:
        a(r11);
    }
}
