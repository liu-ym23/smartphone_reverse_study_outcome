package com.bytedance.android.btm.impl.page.lifecycle.layer2;

import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.b;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.PageWoods;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class BaseFilter<T> {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public BaseFilter() {
        this.a = "BaseFilter_onResumed";
        this.b = "BaseFilter_isResumeFiltered";
        this.c = "BaseFilter_onPaused";
        this.d = "BaseFilter_isPauseFiltered";
        this.e = "BaseFilter_onDestroyed";
        this.f = "BaseFilter_pausePrePage";
        this.g = "BaseFilter_onResumedDirectly";
    }

    public final void c(T r10) {
        final String r0 = r10.getClass().getName();
        String r1 = BtmPageRecorder.a;
        PageInfoStack r11 = BtmPageRecorder.k(r10);
        if (r11 == null) goto L6;
        BtmPageLifecycleCallbackV2.c(r10, r11);
        ALogger.f(ALogger.d, this.e, new BaseFilter$onDestroyed$1(r0));
        return;
    }

    public ResumeFilterReason b(T r10, final ResumeFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        ALogger.f(r1, this.b, new BaseFilter$isResumeFiltered$1(r0, r11));
        String r12 = BtmPageRecorder.a;
        PageInfoStack r13 = BtmPageRecorder.k(r10);
        if (r13 == null) goto L44;
        if (r13.getPageState() != BtmPageLifecycle.State.RESUMED) goto L8;
        ALogger.f(r1, this.b, new BaseFilter$isResumeFiltered$2(r0));
        return ResumeFilterReason.PageStateDuplicate;
    L8:
        boolean r14 = b.a;
        if (b.b().isAppBackground() == false) goto L13;
        ALogger.f(r1, this.b, new BaseFilter$isResumeFiltered$3(r0));
        return ResumeFilterReason.AppBackground;
    L13:
        if (CollectionsKt.contains(b.b().i(), d.a.getActivity(r10)) == true) goto L16;
        ALogger.f(r1, this.b, new BaseFilter$isResumeFiltered$4(r0));
        return ResumeFilterReason.NotTopActivity;
    L16:
        final h r15 = PageWoods.a(r10);
        if (r15 != null) goto L19;
    L41:
        ALogger.f(r1, this.b, new BaseFilter$isResumeFiltered$6(r0));
        return null;
    L19:
        if (r15.f == false) goto L41;
        String r16 = r15.e;
        if (r16 != null) goto L23;
    L26:
        boolean r17 = true;
    L27:
        if (r17 == true) goto L41;
        ALogger.f(r1, this.b, new BaseFilter$isResumeFiltered$5(r0, r15));
        if (BtmSetting.d.c().b().o() != 1) goto L36;
        f<Object> r18 = new f(r10);
        ResumeFuncOrigin r19 = (ResumeFuncOrigin) ((LinkedHashMap) r15.k).get(r18);
        if (r19 != null) goto L33;
    L34:
        r15.k.put(r18, r11);
    L40:
        return ResumeFilterReason.ExecuteActivityResume;
    L33:
        if (r19.isManual() == true) goto L40;
    L36:
        if (r11.isManual() == false) goto L38;
        List<f<Object>> r20 = r15.j;
        ArrayList r21 = (ArrayList) r20;
        r21.add(new f(r10));
        goto L40
    L38:
        List<f<Object>> r22 = r15.i;
        ArrayList r23 = (ArrayList) r22;
        r23.add(new f(r10));
        goto L40
    L23:
        if (r16.length() == 0) goto L26;
        r17 = false;
        goto L27
    L44:
        return ResumeFilterReason.InfoStackNull;
    }

    public final void d(T r10, final PauseFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        ALogger.f(r1, this.c, new BaseFilter$onPaused$1(r0, r11));
        final String r12 = r10.getClass().getName();
        ALogger.f(r1, this.d, new BaseFilter$isPauseFiltered$1(r12, r11));
        String r13 = BtmPageRecorder.a;
        PageInfoStack r14 = BtmPageRecorder.k(r10);
        if (r14 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == false) goto L12;
        ALogger.f(r1, this.c, new BaseFilter$onPaused$2(r0));
        return;
    L12:
        boolean r16 = BtmPageLifecycleCallbackV2.a;
        PageInfoStack r17 = BtmPageRecorder.k(r10);
        if (r17 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        BtmPageLifecycleCallbackV2.d(r10, r17, r11);
        return;
    L5:
        if (r14.getPageState() == BtmPageLifecycle.State.RESUMED) goto L7;
        ALogger.f(r1, this.d, new BaseFilter$isPauseFiltered$2(r12));
        goto L8
    L7:
        ALogger.f(r1, this.d, new BaseFilter$isPauseFiltered$3(r12));
        r15 = false;
        goto L9
    }

    public final ResumeFilterReason e(T r10, ResumeFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        ALogger.f(r1, this.a, new BaseFilter$onResumed$1(r0));
        ResumeFilterReason r12 = b(r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        f(r10, r11);
        ALogger.f(r1, this.a, new BaseFilter$onResumed$2(r0));
        return null;
    }

    public final void f(T r10, final ResumeFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        ALogger.f(r1, this.g, new BaseFilter$onResumedDirectly$1(r0, r11));
        final String r12 = r10.getClass().getName();
        ALogger.f(r1, this.f, new BaseFilter$pausePrePage$1(r12));
        Object r13 = com.bytedance.android.btm.impl.page.b.b;
        if (r13 == null) goto L11;
        String r14 = BtmPageRecorder.a;
        PageInfoStack r15 = BtmPageRecorder.k(r13);
        if (r15 == null) goto L7;
        BtmPageLifecycle.State r16 = r15.getPageState();
    L9:
        if (r16 != BtmPageLifecycle.State.RESUMED) goto L11;
        boolean r17 = BtmPageLifecycleCallbackV2.a;
        BtmPageLifecycleCallbackV2.d(r13, r15, PauseFuncOrigin.PausePre);
        goto L11
    L7:
        r16 = null;
    L11:
        h r18 = PageWoods.a(r10);
        if (r18 == null) goto L33;
        Iterator<T> r19 = r18.n().iterator();
    L16:
        if (r19.hasNext() == false) goto L33;
        com.bytedance.android.btm.impl.page.model.d r20 = (com.bytedance.android.btm.impl.page.model.d) r19.next();
        if (r20.i() == false) goto L16;
        Object r21 = r20.a();
        if (Intrinsics.areEqual(r21, r10) == true) goto L16;
        String r22 = BtmPageRecorder.a;
        PageInfoStack r23 = BtmPageRecorder.k(r21);
        if (r23 == null) goto L26;
        BtmPageLifecycle.State r24 = r23.getPageState();
    L28:
        if (r24 != BtmPageLifecycle.State.RESUMED) goto L16;
        boolean r25 = BtmPageLifecycleCallbackV2.a;
        if (r21 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        BtmPageLifecycleCallbackV2.d(r21, r23, PauseFuncOrigin.PausePre);
        goto L16
    L26:
        r24 = null;
    L33:
        boolean r26 = BtmPageLifecycleCallbackV2.a;
        String r27 = BtmPageRecorder.a;
        PageInfoStack r28 = BtmPageRecorder.k(r10);
        if (r28 != null) goto L36;
        Intrinsics.throwNpe();
    L36:
        BtmPageLifecycleCallbackV2.e(r10, r28, r11);
    }

    public static void a(Object r10, h r11, BufferBtm r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if (BtmSetting.d.c().b().L() == 1) goto L7;
        return;
    L7:
        if (r11 == null) goto L9;
        com.bytedance.android.btm.impl.page.model.d r13 = r11.l(r10);
    L10:
        if (r13 != null) goto L12;
        return;
    L12:
        if (r12.getTreeId().length() <= 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == true) goto L17;
        return;
    L17:
        if (Intrinsics.areEqual(r13.d(), r12.getTreeId()) == false) goto L24;
        com.bytedance.android.btm.impl.page.model.d r14 = r11.m(r12.getNodeId());
        if ((!Intrinsics.areEqual(r14, r13)) == false) goto L25;
        r13.g(r14);
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r0 = false;
        goto L15
    L9:
        r13 = null;
        goto L10
    }
}
