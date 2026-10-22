package com.bytedance.android.btm.impl.page;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.collection.LruCache;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.e;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.c;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BtmPageRecorder {
    public static final String a = "BtmPageRecorder_putSourceBtm";
    public static final String b = "BtmPageRecorder_findPageByItem";
    public static final String c = "BtmPageRecorder_getPageInfo";
    public static final ConcurrentHashMap<f<? extends Object>, PageInfoStack> d = null;
    public static final LruCache<f<? extends Object>, PageInfoStack> e = null;
    public static final ConcurrentHashMap<f<? extends Object>, c> f = null;
    public static boolean g;
    public static final Lazy h = null;
    public static boolean i;
    public static final Lazy j = null;
    public static final Map<String, e> k = null;
    public static final Map<String, e> l = null;
    public static final ConcurrentHashMap<f<View>, f<Fragment>> m = null;
    public static final Map<View, f<Fragment>> n = null;
    public static final ConcurrentHashMap<f<View>, f<DialogFragment>> o = null;
    public static final ConcurrentHashMap<f<View>, f<Dialog>> p = null;
    public static final List<f<View>> q = null;
    public static final ConcurrentHashMap<String, com.bytedance.android.btm.api.model.b> r = null;
    public static final Map<f<Activity>, Boolean> s = null;

    public BtmPageRecorder() {
    }

    static {
        a = "BtmPageRecorder_putSourceBtm";
        b = "BtmPageRecorder_findPageByItem";
        c = "BtmPageRecorder_getPageInfo";
        d = new ConcurrentHashMap();
        e = new LruCache(10);
        f = new ConcurrentHashMap();
        Lazy r0 = LazyKt.lazy(BtmPageRecorder$btmIdPageRelatedInfoMap$2.INSTANCE);
        h = r0;
        Lazy r1 = LazyKt.lazy(BtmPageRecorder$eventBtmIdPageRelatedInfoMap$2.INSTANCE);
        j = r1;
        k = Collections.synchronizedMap((BtmPageRecorder$btmIdPageRelatedInfoMap$2.AnonymousClass1) r0.getValue());
        l = Collections.synchronizedMap((BtmPageRecorder$eventBtmIdPageRelatedInfoMap$2.AnonymousClass1) r1.getValue());
        m = new ConcurrentHashMap();
        n = Collections.synchronizedMap(new WeakHashMap());
        o = new ConcurrentHashMap();
        p = new ConcurrentHashMap();
        q = new ArrayList();
        r = new ConcurrentHashMap();
        s = new LinkedHashMap();
    }

    public static boolean a(Object r10) {
        if (d.containsKey(new f(r10)) == false) goto L5;
    L8:
        return true;
    L5:
        if (e.get(new f(r10)) != null) goto L8;
        return false;
    }

    public static Object b(final com.bytedance.android.btm.api.model.c r10) {
        ALogger r0 = ALogger.d;
        String r1 = b;
        ALogger.j(r0, r1, new BtmPageRecorder$findPageByItem$1(r10));
        String r11 = BtmPageFinder.a;
        Object r12 = BtmPageFinder.a(r10.e);
        if (r12 == null) goto L6;
        final String r13 = r12.getClass().getName();
        ALogger.j(r0, r1, new BtmPageRecorder$findPageByItem$2(r13));
        return r12;
    L6:
        ViewPager r14 = r10.f;
        final String r15 = null;
        if (r14 == null) goto L19;
        int r16 = r10.g;
        if (r16 < 0) goto L14;
        PagerAdapter r17 = r14.getAdapter();
        if (r17 == null) goto L14;
        Object r18 = r17.instantiateItem(r14, r16);
    L15:
        if (r18 == null) goto L17;
        r15 = r18.getClass().getName();
    L17:
        ALogger.j(r0, r1, new BtmPageRecorder$findPageByItem$3(r15));
        return r18;
    L14:
        r18 = null;
        goto L15
    L19:
        return null;
    }

    public static Object c(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator<Map.Entry<f<? extends Object>, PageInfoStack>> r1 = d.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<f<? extends Object>, PageInfoStack> r11 = r1.next();
        if (Intrinsics.areEqual(r11.getValue().current().getPageId(), r10) == false) goto L7;
        return r11.getKey().get();
    L12:
        Iterator r12 = e.snapshot().entrySet().iterator();
    L14:
        if (r12.hasNext() == false) goto L19;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (Intrinsics.areEqual(((PageInfoStack) r13.getValue()).current().getPageId(), r10) == false) goto L14;
        return ((f) r13.getKey()).get();
    L19:
        return null;
    }

    public static Fragment d(View r10) {
        if (BtmSetting.d.c().d().v() != 1) goto L8;
        f<Fragment> r11 = n.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.get();
    L8:
        f<Fragment> r12 = m.get(new f(r10));
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.get();
    }

    public static Set e(Function1 r10) {
        HashSet r0 = new HashSet();
        Map<String, e> r1 = k;
        monitor-enter(r1);
        Iterator<Map.Entry<String, e>> r11 = r1.entrySet().iterator();     // Catch: Throwable -> L29
    L6:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<String, e> r12 = r11.next();     // Catch: Throwable -> L29
        if (((Boolean) r10.invoke(r12.getValue())).booleanValue() == false) goto L6;
        r0.add(r12.getKey());     // Catch: Throwable -> L29
        goto L6
    L10:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r1);
        if (BtmSetting.d.c().d().g() != 1) goto L28;
        Map<String, e> r14 = l;
        monitor-enter(r14);
        Iterator<Map.Entry<String, e>> r15 = r14.entrySet().iterator();     // Catch: Throwable -> L25
    L18:
        if (r15.hasNext() == false) goto L22;
        Map.Entry<String, e> r16 = r15.next();     // Catch: Throwable -> L25
        if (((Boolean) r10.invoke(r16.getValue())).booleanValue() == false) goto L18;
        r0.add(r16.getKey());     // Catch: Throwable -> L25
        goto L18
    L22:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r14);
    L25:
        th = move-exception;
        throw th;
    L28:
        return r0;
    L29:
        th = move-exception;
        throw th;
    }

    public static e f(String r1) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return null;
    L11:
        e r10 = k.get(r1);
        if (r10 == null) goto L15;
        return r10;
    L15:
        return l.get(r1);
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static String g(String r0) {
        e r1 = f(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a;
    }

    public static c h(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return f.get(new f(r10));
    }

    public static Object i(PageInfo r10) {
        Iterator<Map.Entry<f<? extends Object>, PageInfoStack>> r0 = d.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<f<? extends Object>, PageInfoStack> r1 = r0.next();
        Iterator r11 = r1.getValue().all().iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        if (Intrinsics.areEqual(((PageInfo) r11.next()).getPageId(), r10.getPageId()) == false) goto L7;
        return r1.getKey().get();
    L12:
        return null;
    }

    public static PageInfo j(Object r10) {
        PageInfo r0 = null;
        if (r10 != null) goto L6;
        ALogger.j(ALogger.d, c, BtmPageRecorder$getPageInfo$1.INSTANCE);
        return null;
    L6:
        final String r1 = r10.getClass().getName();
        PageInfoStack r11 = k(r10);
        if (r11 == null) goto L9;
        r0 = r11.current();
    L9:
        if (r0 != null) goto L11;
        ALogger.j(ALogger.d, c, new BtmPageRecorder$getPageInfo$2(r1));
    L11:
        return r0;
    }

    public static PageInfoStack k(Object r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        PageInfoStack r0 = d.get(new f(r10));
        if (r0 == null) goto L9;
        return r0;
    L9:
        return (PageInfoStack) e.get(new f(r10));
    }

    public static void l(Object r10) {
        ConcurrentHashMap<f<? extends Object>, c> r0 = f;
        if (r0.get(new f(r10)) != null) goto L6;
        c r1 = new c();
        r0.put(new f(r10), r1);
        return;
    }

    public static PageInfoStack m(Object r10, boolean r11) {
        ConcurrentHashMap<f<? extends Object>, PageInfoStack> r0 = d;
        PageInfoStack r1 = r0.get(new f(r10));
        if (r1 != null) goto L6;
        PageInfoStack.Companion.getClass();
        PageInfoStack r12 = new PageInfoStack(null);
        r12.setContainer(r11);
        r0.put(new f(r10), r12);
        return r12;
    L6:
        return r1;
    }

    public static void p(String r1, PageInfo r10, com.bytedance.android.btm.api.model.c r11) {
        q(r1, r10, !r11.a());
        if (r11.a() == true) goto L6;
        return;
    L6:
        if ((BtmSetting.d.c().c().G() & 1) == 0) goto L9;
        com.bytedance.android.btm.api.model.b r12 = new com.bytedance.android.btm.api.model.b(0);
        r12.a = r10.getPageShowId();
        r12.c = r1;
        r10.setLatestBtmIdNode(r12);
        return;
    }

    public static void q(String r10, PageInfo r11, boolean r12) {
        String r1 = r11.getPageShowId();
        String r0 = r11.getPageBtm();
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        e r13 = new e(r1, r0, r11.getPageId(), r11.getInstanceId(), r11.getLastPageShowId(), 480);
        if (r12 == true) goto L9;
    L11:
        k.put(r10, r13);
        return;
    L9:
        if (BtmSetting.d.c().d().g() != 1) goto L11;
        l.put(r10, r13);
    }

    public static void n(Object r10, final String r11, final int r12, final String r13, boolean r14, boolean r15) {
        final String r0 = r10.getClass().getName();
        ALogger.j(ALogger.d, a, new BtmPageRecorder$putSourceBtm$1(r0, r11, r12, r13));
        PageInfoStack r16 = k(r10);
        if (r16 == null) goto L8;
        PageInfo r1 = r16.current();
        if (r1 == null) goto L9;
        r1.putSourceBtm(r11, r12, r13, r14, r15);
        return;
    L9:
        return;
    }

    public static /* synthetic */ void o(Object r10, String r11, int r12, String r13, boolean r14, int r15) {
        if ((r15 & 16) == 0) goto L5;
        boolean r16 = true;
    L7:
        if ((r15 & 32) == 0) goto L9;
        boolean r17 = false;
    L10:
        n(r10, r11, r12, r13, r16, r17);
        return;
    L9:
        r17 = r14;
        goto L10
    L5:
        r16 = false;
        goto L7
    }
}
