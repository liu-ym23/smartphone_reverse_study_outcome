package com.bytedance.android.accessibilityLib_Core.engine;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig;
import com.bytedance.android.accessibilityLib_Core.config.bean.c;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.processor.RemoteConfigProcessor;
import com.bytedance.android.accessibilityLib_Core.processor.ViewAccessibilityDelegateProcessor;
import com.bytedance.android.accessibilityLib_Core.tool.AccessibilityCommonToolExtKt;
import com.bytedance.android.accessibilityLib_Core.tool.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AccessibilityConfigEngine {
    public static final ArrayList<IBaseConfig> a = null;
    public static final ArrayList<IBaseConfig> b = null;
    public static boolean c;
    public static final ArrayList<IBaseConfig> d = null;
    public static final ArrayList<h> e = null;
    public static final HashMap<IBaseConfig, Boolean> f = null;
    public static final ArrayList<IBaseLargeTouchAreaConfig> g = null;

    public static final class a implements IBaseLargeTouchAreaConfig {
        public final /* synthetic */ IBaseConfig a;

        @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig
        public final String name() {
            return this.a.name();
        }

        @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseLargeTouchAreaConfig
        public final List<Integer> supportLayoutRootList() {
            return CollectionsKt.listOf(Integer.valueOf(this.a.layoutRoot()));
        }

        public a(IBaseConfig r1) {
            this.a = r1;
        }
    }

    static {
        a = new ArrayList();
        b = new ArrayList();
        d = new ArrayList();
        e = new ArrayList();
        f = new HashMap();
        g = new ArrayList();
    }

    public static void e() {
        Context r0 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        Iterator<IBaseConfig> r1 = a.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        IBaseConfig r10 = r1.next();
        if (com.bytedance.android.accessibilityLib_Core.engine.a.b[r10.getScope().ordinal()] != 1) goto L7;
        if (("AccessibilityConfigEngine >>> configName = " + r10.name()) == null) goto L11;
        Context r11 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L11:
        c(r10);
        goto L4
    L7:
        AccessibilityCommonToolExtKt.a(r10, AccessibilityConfigEngine$analysis$1$1.INSTANCE);
        goto L4
    L12:
        RemoteConfigProcessor.a(true);
    }

    public static void c(IBaseConfig r10) {
        if (r10.getScope() == AccessiblityScope.Fragment) goto L9;
        if (r10.getScope() == AccessiblityScope.Activity) goto L9;
        if (r10.getScope() == AccessiblityScope.ViewGroup) goto L9;
    L13:
        d.add(r10);
        return;
    L9:
        if (r10.enableLargeTouchArea() == false) goto L13;
        if (r10.layoutRoot() == (-1)) goto L13;
        g.add(new a(r10));
        goto L13
    }

    public static void d(final List r10) {
        StringBuilder r0 = new StringBuilder("before remove configList = ");
        ArrayList<IBaseConfig> r1 = d;
        r0.append(r1.size());
        r0.append(", _largeTouchAreaConfigList = ");
        ArrayList<IBaseLargeTouchAreaConfig> r11 = g;
        r0.append(r11.size());
        if (r0.toString() == null) goto L5;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L5:
        r1.removeAll(CollectionsKt.toSet(r10));
        CollectionsKt.removeAll(r11, new AccessibilityConfigEngine$removeConfigList$1(r10));
        if (("after remove configList = " + r1.size() + ", _largeTouchAreaConfigList = " + r11.size()) == null) goto L9;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        return;
    }

    public static h a(int r10, int r11) {
        ArrayList<h> r0 = e;
        h r12 = null;
        if (r0.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<h> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L30;
        h r13 = r1.next();
        h r14 = r13;
        if (com.bytedance.android.accessibilityLib_Core.config.remote.dsl.a.b(r14) == true) goto L12;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L7;
        r12 = r13;
        goto L30
    L12:
        if (c.a(Integer.valueOf(r10)) == false) goto L26;
        int r16 = r14.b;
        if (r16 == r10) goto L17;
    L21:
        if (r16 != r10) goto L26;
        if (("predicateInDynamicLabel step2 true for " + r14) == null) goto L25;
        Context r17 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L25:
        r15 = true;
        goto L27
    L17:
        if (r14.a != r11) goto L21;
        if (("predicateInDynamicLabel step1 true for " + r14) == null) goto L25;
        Context r18 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L30:
        return r12;
    }

    public static boolean b(IBaseConfig r12, ViewAccessibilityDelegateProcessor.a r13) {
        Integer r0 = r12.getVirtualNode().b;
        View r1 = r13.a();
        if (r1 == null) goto L5;
        Integer r10 = Integer.valueOf(r1.getId());
    L7:
        if (Intrinsics.areEqual(r0, r10) == false) goto L25;
        int r11 = r13.b;
        Integer r14 = r12.getVirtualNode().a;
        if (r14 == null) goto L25;
        if (r11 != r14.intValue()) goto L25;
        View r15 = r13.a();
        if (r15 == null) goto L16;
        Integer r16 = Integer.valueOf(r15.getId());
    L18:
        if (c.a(r16) == false) goto L25;
        if (c.a(Integer.valueOf(r13.b)) == false) goto L25;
        if (("predicate true for v.id = " + r12.getVirtualNode().b + ",resid = " + r12.getVirtualNode().a) == null) goto L24;
        Context r17 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L24:
        return true;
    L16:
        r16 = null;
    L25:
        Integer r18 = r12.getVirtualNode().b;
        View r19 = r13.a();
        if (r19 == null) goto L28;
        Integer r20 = Integer.valueOf(r19.getId());
    L30:
        if (Intrinsics.areEqual(r18, r20) == false) goto L71;
        View r21 = r13.a();
        if (r21 == null) goto L34;
        Integer r22 = Integer.valueOf(r21.getId());
    L36:
        if (c.a(r22) == false) goto L71;
        if (r12.getVirtualNode().q == false) goto L71;
        View r23 = r13.a();
        Integer r24 = r12.getVirtualNode().a;
        if (r24 == null) goto L42;
        int r25 = r24.intValue();
    L43:
        if (r23 != null) goto L46;
    L65:
        boolean r26 = false;
    L66:
        if (r26 == false) goto L71;
        if (("predicate true for v.id = " + r12.getVirtualNode().b + ",resid = " + r12.getVirtualNode().a) == null) goto L70;
        Context r110 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L70:
        return true;
    L46:
        if (c.a(Integer.valueOf(r25)) == false) goto L65;
        ViewParent r27 = r23.getParent();
        View r28 = r23.getRootView();
        int r29 = 0;
    L49:
        if (r27 == null) goto L63;
        if ((!Intrinsics.areEqual(r27, r28)) == false) goto L63;
        if (r29 >= 100) goto L63;
        r29 = r29 + 1;
        if ((r27 instanceof View) == false) goto L61;
        View r111 = (View) r27;
        if (r111.getId() == r25) goto L64;
        if (e.a(r111) != r25) goto L61;
    L64:
        r26 = true;
    L61:
        r27 = r27.getParent();
    L63:
        if (r25 != e.a(r23)) goto L65;
    L42:
        r25 = -1;
        goto L43
    L34:
        r22 = null;
    L71:
        Integer r30 = r12.getVirtualNode().b;
        View r31 = r13.a();
        if (r31 == null) goto L74;
        Integer r32 = Integer.valueOf(r31.getId());
    L76:
        if (Intrinsics.areEqual(r30, r32) == true) goto L78;
    L83:
        r12.getVirtualNode().getClass();
        View r112 = r13.a();
        if (r112 == null) goto L88;
        String r113 = r112.getClass().getCanonicalName();
        if (r113 == null) goto L88;
    L90:
        if (Intrinsics.areEqual(null, r113) == false) goto L97;
        HashMap<IBaseConfig, Boolean> r114 = f;
        if (r114.containsKey(r12) == true) goto L97;
        r114.put(r12, Boolean.TRUE);
        StringBuilder r115 = new StringBuilder("find for viewIdentify = null, virtualIndex = ");
        r12.getVirtualNode().getClass();
        r115.append(r12.getVirtualNode().c);
        if (r115.toString() == null) goto L96;
        Context r116 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L96:
        return true;
    L97:
        return false;
    L88:
        r113 = "null";
        goto L90
    L78:
        if (r12.getVirtualNode().q == true) goto L83;
        if (("predicate true for v.id = " + r12.getVirtualNode().b + ",resid = " + r12.getVirtualNode().a) == null) goto L82;
        Context r117 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L82:
        return true;
    L74:
        r32 = null;
        goto L76
    L28:
        r20 = null;
        goto L30
    L5:
        r10 = null;
        goto L7
    }
}
