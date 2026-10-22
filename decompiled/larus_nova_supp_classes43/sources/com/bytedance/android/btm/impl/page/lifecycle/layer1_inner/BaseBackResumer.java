package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import android.app.Activity;
import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FilterDispatcher;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.d;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BaseBackResumer {
    public final String a;
    public final ResumeFuncOrigin b;
    public final int c;
    public final int d;

    public static Set a(Set r10) {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r11 = r10.iterator();
        int r1 = 0;
    L4:
        if (r11.hasNext() == false) goto L13;
        Object r12 = r11.next();
        String r13 = BtmPageRecorder.a;
        PageInfo r14 = BtmPageRecorder.j(r12);
        if (r14 == null) goto L4;
        if (r14.getStep() > r1) goto L9;
        if (r14.getStep() != r1) goto L4;
        r0.add(r12);
        goto L4
    L9:
        r1 = r14.getStep();
        r0.clear();
        r0.add(r12);
        goto L4
    L13:
        return r0;
    }

    public static Set d(Set r10) {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r1 = r11.next();
        String r12 = BtmPageRecorder.a;
        PageInfoStack r13 = BtmPageRecorder.k(r1);
        if (r13 == null) goto L8;
        BtmPageLifecycle.State r14 = r13.getPageState();
    L10:
        if (r14 != BtmPageLifecycle.State.CREATED) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r14 = null;
        goto L10
    L12:
        return r0;
    }

    public final boolean i(h r10) {
        ALogger.e(ALogger.d, "BaseBackResumer_tryResumeTopPage", new BaseBackResumer$tryResumeTopPage$1(this));
        d r11 = r10.m(r10.e);
        if (r11 == null) goto L5;
        Object r12 = r11.a();
    L6:
        if (r12 == null) goto L11;
        String r0 = FilterDispatcher.a;
        if (FilterDispatcher.e(r12, this.b) != null) goto L13;
        return true;
    L13:
        return false;
    L11:
        return false;
    L5:
        r12 = null;
        goto L6
    }

    public static Set f(h r10, Set r11) {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        Object r1 = r12.next();
        if ((r1 instanceof Dialog) == true) goto L7;
        if ((r1 instanceof DialogFragment) == true) goto L11;
        if ((r1 instanceof Fragment) == true) goto L14;
        boolean r13 = r1 instanceof Activity;
        goto L4
    L14:
        r0.add(r1);
        goto L4
    L11:
        r0.add(r1);
        goto L4
    L7:
        r0.clear();
        r0.add(r1);
        return r0;
    L16:
        LinkedHashSet r14 = new LinkedHashSet();
        r14.addAll(r0);
        Iterator r15 = r0.iterator();
    L18:
        if (r15.hasNext() == false) goto L29;
        Object r16 = r15.next();
        if (r10 == null) goto L22;
        d r17 = r10.l(r16);
    L23:
        if (r17 == null) goto L18;
        d r18 = r17.getParentNode();
        if (r18 == null) goto L27;
        Object r19 = r18.a();
    L28:
        TypeIntrinsics.asMutableCollection(r14).remove(r19);
        r17 = r17.getParentNode();
        goto L23
    L27:
        r19 = null;
        goto L28
    L22:
        r17 = null;
        goto L23
    L29:
        return r14;
    }

    public static void g(Object r1, h r10) {
        Map<f<Object>, ResumeFuncOrigin> r11 = r10.k;
        LinkedHashMap r12 = (LinkedHashMap) r11;
        ResumeFuncOrigin r13 = (ResumeFuncOrigin) r12.get(new f(r1));
        if (r13 == null) goto L6;
        FilterDispatcher.f(r1, r13);
        return;
    }

    public final void c(Activity r10, final String r11) {
        final String r12 = r10.getClass().getName();
        String r0 = BtmPageRecorder.a;
        PageInfo r13 = BtmPageRecorder.j(r10);
        final String r1 = "null";
        if (r13 == null) goto L7;
        final String r14 = r13.getPageBtm();
        if (r14 == null) goto L7;
    L8:
        if (r13 == null) goto L12;
        String r15 = r13.getBtmPre();
        if (r15 == null) goto L12;
        r1 = r15;
    L12:
        g$a.a(BtmMonitor.c, this.d, r12, null, new BaseBackResumer$monitorZero$1(r12, r14, r1, r11), 28);
        return;
    L7:
        r14 = "null";
        goto L8
    }

    public void e(Activity r10, final h r11) {
        ALogger.e(ALogger.d, this.a, BaseBackResumer$onActivityPostResumed$1.INSTANCE);
        new LinkedHashSet();
        HashSet r0 = new HashSet(((r11.k.size() * 4) / 3) + 1);
        Iterator r1 = ((LinkedHashMap) r11.k).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) r1.next();
        T r13 = ((f) r12.getKey()).get();
        if (r13 == 0) goto L4;
        String r14 = FilterDispatcher.a;
        if (FilterDispatcher.a(r13, (ResumeFuncOrigin) r12.getValue()) != null) goto L4;
        r0.add(r13);
        goto L4
    L10:
        final int r15 = r0.size();
        ALogger r16 = ALogger.d;
        ALogger.e(r16, this.a, new BaseBackResumer$onActivityPostResumed$2$1(r15));
        if (r15 != 0) goto L14;
        c(r10, "filter");
        return;
    L14:
        if (r15 != 1) goto L17;
        g(CollectionsKt.last(r0), r11);
        return;
    L17:
        Set r17 = f(r11, r0);
        final int r18 = r17.size();
        ALogger.e(r16, this.a, new BaseBackResumer$onActivityPostResumed$3$1(r18));
        if (r18 != 0) goto L21;
        c(r10, "removeParent");
        return;
    L21:
        if (r18 != 1) goto L24;
        g(CollectionsKt.last(r17), r11);
        return;
    L24:
        Set r19 = d(r17);
        final int r20 = r19.size();
        ALogger.e(r16, this.a, new BaseBackResumer$onActivityPostResumed$4$1(r20));
        if (r20 == 0) goto L30;
        if (r20 != 1) goto L29;
        g(CollectionsKt.last(r19), r11);
        return;
    L29:
        r17 = r19;
    L30:
        LinkedHashSet r21 = new LinkedHashSet();
        Iterator r22 = r17.iterator();
    L32:
        if (r22.hasNext() == false) goto L38;
        Object r23 = r22.next();
        ResumeFuncOrigin r24 = (ResumeFuncOrigin) ((LinkedHashMap) r11.k).get(new f(r23));
        if (r24 == null) goto L32;
        if (r24.isManual() != true) goto L32;
        r21.add(r23);
        goto L32
    L38:
        final int r25 = r21.size();
        ALogger r26 = ALogger.d;
        ALogger.e(r26, this.a, new BaseBackResumer$onActivityPostResumed$5$1(r25));
        if (r25 == 0) goto L44;
        if (r25 != 1) goto L43;
        g(CollectionsKt.last(r21), r11);
        return;
    L43:
        r17 = r21;
    L44:
        ALogger.e(r26, this.a, new BaseBackResumer$onActivityPostResumed$6(r11));
        d r27 = r11.m(r11.e);
        if (r27 == null) goto L64;
        Object r28 = r27.a();
        if (r28 != null) goto L49;
    L52:
        final Ref.IntRef r29 = new Ref.IntRef();
        r29.element = 1;
        d r30 = r27.j();
    L53:
        if (r30 == null) goto L64;
        if (r29.element > 3) goto L64;
        Object r31 = r30.a();
        if (r31 == null) goto L63;
        if (r17.contains(r31) == false) goto L63;
        ALogger.e(ALogger.d, this.a, new BaseBackResumer$onActivityPostResumed$8(r29));
        g(r31, r11);
        return;
    L63:
        r30 = r30.j();
        r29.element++;
        goto L53
    L49:
        if (r17.contains(r28) == false) goto L52;
        ALogger.e(r26, this.a, BaseBackResumer$onActivityPostResumed$7.INSTANCE);
        g(r28, r11);
        return;
    L64:
        Set r32 = a(r17);
        final int r33 = r32.size();
        ALogger r34 = ALogger.d;
        ALogger.e(r34, this.a, new BaseBackResumer$onActivityPostResumed$9$1(r33));
        if (r33 != 0) goto L68;
        c(r10, "largeStep");
        return;
    L68:
        if (r33 != 1) goto L71;
        String r35 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r32), this.b);
        return;
    L71:
        ALogger.e(r34, this.a, BaseBackResumer$onActivityPostResumed$10.INSTANCE);
        g(CollectionsKt.last(r32), r11);
        b(this, r10, r32);
    }

    public final boolean h(Activity r10, h r11) {
        ALogger.e(ALogger.d, "BaseBackResumer_tryResumeManualPages", new BaseBackResumer$tryResumeManualPages$1(this));
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r12 = ((ArrayList) r11.j).iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        T r1 = ((f) r12.next()).get();
        if (r1 == 0) goto L4;
        String r13 = FilterDispatcher.a;
        if (FilterDispatcher.a(r1, this.b) != null) goto L4;
        r0.add(r1);
        goto L4
    L11:
        if (r0.size() != 1) goto L15;
        String r14 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r0), this.b);
        return true;
    L15:
        if (r0.size() <= 1) goto L18;
        String r15 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r0), this.b);
        b(this, r10, r0);
        return true;
    L18:
        return false;
    }

    public final boolean j(Activity r10, h r11) {
        ALogger.e(ALogger.d, "BaseBackResumer_tryResumeUnManualPages", new BaseBackResumer$tryResumeUnManualPages$1(this));
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator r1 = ((ArrayList) r11.i).iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        T r12 = ((f) r1.next()).get();
        if (r12 == 0) goto L4;
        String r13 = FilterDispatcher.a;
        if (FilterDispatcher.a(r12, this.b) != null) goto L4;
        r0.add(r12);
        goto L4
    L11:
        if (r0.size() != 1) goto L15;
        String r14 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r0), this.b);
        return true;
    L15:
        if (r0.size() <= 1) goto L24;
        Set r15 = f(r11, r0);
        if (r15.size() != 1) goto L21;
        String r16 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r15), this.b);
        return true;
    L21:
        if (r15.size() <= 1) goto L33;
        String r17 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r15), this.b);
        b(this, r10, r15);
        return true;
    L33:
        return false;
    L24:
        return false;
    }

    public BaseBackResumer(ResumeFuncOrigin r1, int r10, int r11) {
        this.b = r1;
        this.c = r10;
        this.d = r11;
        this.a = "BaseBackResumer_resume_new";
    }

    public static void b(BaseBackResumer r10, Activity r11, Set r12) {
        r10.getClass();
        final ArrayList r0 = new ArrayList();
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Object r1 = r13.next();
        String r14 = BtmPageRecorder.a;
        r0.add(BtmPageRecorder.j(r1));
        goto L4
    L6:
        final String r15 = r11.getClass().getName();
        Lazy r16 = BtmMonitor.a;
        final String r17 = "";
        BtmMonitor.j(r10.c, null, null, new BaseBackResumer$monitorMulti$2(r0), new BaseBackResumer$monitorMulti$3(r15, r17), null, 182);
    }
}
