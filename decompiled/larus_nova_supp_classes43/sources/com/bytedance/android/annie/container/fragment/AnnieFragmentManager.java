package com.bytedance.android.annie.container.fragment;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieFragmentManager {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, AnnieFragmentManager$mFragmentMap$2.INSTANCE);
    }

    public static LinkedHashMap c() {
        return (LinkedHashMap) a.getValue();
    }

    @JvmStatic
    public static final WeakReference<HybridFragment> b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "containerId");
        return (WeakReference) c().get(r1);
    }

    @JvmStatic
    public static final void d(String r10, HybridFragment r11) {
        Intrinsics.checkNotNullParameter(r11, "fragment");
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (c().containsKey(r10) == false) goto L14;
        return;
    L14:
        if (r11.isFullScreen() == true) goto L23;
        Iterator r12 = c().entrySet().iterator();
    L17:
        if (r12.hasNext() == false) goto L23;
        HybridFragment r13 = (HybridFragment) ((WeakReference) ((Map.Entry) r12.next()).getValue()).get();
        if (r13 == null) goto L17;
        if (Intrinsics.areEqual(r13.getActivity(), r11.getActivity()) == false) goto L17;
        r13.realVisibleChange(false);
    L23:
        c().put(r10, new WeakReference(r11));
        return;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean a(String r10, boolean r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if (r10 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L24;
        WeakReference r13 = (WeakReference) c().get(r10);
        if (r13 == null) goto L19;
        HybridFragment r14 = (HybridFragment) r13.get();
        if (r14 == null) goto L19;
        r14.closeWithFrom(r11);
    L21:
        return true;
    L19:
        com.bytedance.android.anniex.assemble.a r15 = com.bytedance.android.anniex.assemble.a.a;
        if (com.bytedance.android.anniex.assemble.a.a(r10) == true) goto L21;
        return false;
    L24:
        return false;
    L8:
        if (StringsKt.isBlank(r10) == true) goto L11;
        r1 = false;
        goto L12
    }

    @JvmStatic
    public static final void e(String r10, Activity r11, boolean r12) {
        if (r10 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        return;
    L11:
        WeakReference r14 = (WeakReference) c().remove(r10);
        ArrayList r15 = null;
        Set r16 = null;
        if (r14 == null) goto L14;
        HybridFragment r17 = (HybridFragment) r14.get();
    L15:
        if (r17 != null) goto L17;
    L19:
        boolean r18 = false;
    L20:
        if (r18 == false) goto L34;
        Set r19 = c().entrySet();
        if ((!r19.isEmpty()) == false) goto L24;
        r16 = r19;
    L24:
        if (r16 == null) goto L73;
        Map.Entry r20 = (Map.Entry) CollectionsKt.last(r16);
        if (r20 == null) goto L74;
        WeakReference r21 = (WeakReference) r20.getValue();
        if (r21 == null) goto L75;
        HybridFragment r22 = (HybridFragment) r21.get();
        if (r22 != null) goto L32;
        return;
    L32:
        if (Intrinsics.areEqual(r22.getActivity(), r17.getActivity()) == false) goto L77;
        r22.realVisibleChange(true);
        return;
    L77:
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L34:
        com.bytedance.android.anniex.assemble.a r23 = com.bytedance.android.anniex.assemble.a.a;
        Intrinsics.checkNotNullParameter(r10, "containerId");
        AnnieXContainerManager.INSTANCE.removeContainerById(r10, r12);
        if (r11 == null) goto L79;
        Set r24 = com.bytedance.android.anniex.assemble.a.e().entrySet();
        ArrayList r25 = new ArrayList();
        Iterator r26 = r24.iterator();
    L38:
        if (r26.hasNext() == false) goto L53;
        Object r27 = r26.next();
        ia.c r28 = (ia.c) ((WeakReference) ((Map.Entry) r27).getValue()).get();
        if (r28 == null) goto L42;
        String r29 = r28.getViewType();
    L44:
        if (Intrinsics.areEqual(r29, AIStateLogRequest.SOURCE_PAGE) == false) goto L46;
    L49:
        boolean r30 = true;
    L50:
        if (r30 == false) goto L38;
        r25.add(r27);
        goto L38
    L46:
        if (Intrinsics.areEqual(r29, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == true) goto L49;
        r30 = false;
        goto L50
    L42:
        r29 = null;
        goto L44
    L53:
        if ((!r25.isEmpty()) == false) goto L55;
        r15 = r25;
    L55:
        if (r15 == null) goto L80;
        Map.Entry r31 = (Map.Entry) CollectionsKt.last(r15);
        if (r31 == null) goto L81;
        WeakReference r32 = (WeakReference) r31.getValue();
        if (r32 == null) goto L82;
        ia.c r33 = (ia.c) r32.get();
        if (r33 != null) goto L63;
        return;
    L63:
        if ((r33.getWeakContext().get() instanceof Activity) == true) goto L65;
        return;
    L65:
        if (Intrinsics.areEqual(r11, r33.getWeakContext().get()) == false) goto L85;
        r33.onVisibleChange(true, Boolean.FALSE);
        return;
    L85:
        return;
    L82:
        return;
    L81:
        return;
    L80:
        return;
    L79:
        return;
    L17:
        if (r17.isFullScreen() == true) goto L19;
        r18 = true;
        goto L20
    L14:
        r17 = null;
        goto L15
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r13 = false;
        goto L9
    }

    public static /* synthetic */ void f(String r1, FragmentActivity r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r11 & 4) == 0) goto L8;
        boolean r12 = true;
    L9:
        e(r1, r10, r12);
        return;
    L8:
        r12 = false;
        goto L9
    }
}
