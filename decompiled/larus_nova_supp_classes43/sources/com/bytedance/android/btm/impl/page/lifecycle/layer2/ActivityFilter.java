package com.bytedance.android.btm.impl.page.lifecycle.layer2;

import android.app.Activity;
import android.os.Bundle;
import cd.b;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.HybridContainerFinder;
import com.bytedance.android.btm.impl.page.PageWoods;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.ActivityResumeOrigin;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ActivityFilter extends BaseFilter<Activity> {
    public static final String h = "ActivityFilter_onCreated";
    public static final String i = "ActivityFilter_buildPageTree";
    public static final String j = "ActivityFilter_isResumeFiltered";
    public static final ActivityFilter k = null;

    static {
        k = new ActivityFilter();
        h = "ActivityFilter_onCreated";
        i = "ActivityFilter_buildPageTree";
        j = "ActivityFilter_isResumeFiltered";
    }

    public ActivityFilter() {
    }

    @Override // com.bytedance.android.btm.impl.page.lifecycle.layer2.BaseFilter
    public final /* bridge */ /* synthetic */ ResumeFilterReason b(Activity r1, ResumeFuncOrigin r10) {
        return g(r1, r10);
    }

    public final ResumeFilterReason g(Activity r10, final ResumeFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger r1 = ALogger.d;
        String r12 = j;
        ALogger.f(r1, r12, new ActivityFilter$isResumeFiltered$1(r0, r11));
        final ResumeFilterReason r13 = super.b(r10, r11);
        if (r13 == null) goto L6;
        ALogger.f(r1, r12, new ActivityFilter$isResumeFiltered$2(r0, r13));
        return r13;
    L6:
        String r14 = BtmPageRecorder.a;
        PageInfoStack r15 = BtmPageRecorder.k(r10);
        if (r15 == null) goto L9;
        BtmPageLifecycle.State r16 = r15.getNativeState();
    L11:
        if (r16 == BtmPageLifecycle.State.RESUMED) goto L14;
        ALogger.f(r1, r12, new ActivityFilter$isResumeFiltered$3(r0));
        return ResumeFilterReason.NativeStateError;
    L14:
        return null;
    L9:
        r16 = null;
        goto L11
    }

    public static void h(Activity r19, final Bundle r20, final PageProp r21) {
        final String r10 = r19.getClass().getName();
        ALogger r0 = ALogger.d;
        String r11 = h;
        ALogger.f(r0, r11, new ActivityFilter$onCreated$1(r10, r20, r21));
        String r12 = BtmPageRecorder.a;
        if (BtmPageRecorder.k(r19) == null) goto L7;
        if (r20 != null) goto L7;
        ALogger.f(r0, r11, ActivityFilter$onCreated$2.INSTANCE);
        return;
    L7:
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        String r1 = null;
        if (r20 == null) goto L10;
        Serializable r14 = r20.getSerializable("page_info_stack");
    L12:
        if ((r14 instanceof PageInfoStack) == true) goto L14;
        r14 = null;
    L14:
        r13.element = (PageInfoStack) r14;
        BtmSetting r15 = BtmSetting.d;
        if (r15.c().b().n() != 1) goto L20;
        if (((PageInfoStack) r13.element) != null) goto L22;
        com.bytedance.android.btm.impl.page.lifecycle.layer1_inner.a.f.getClass();
    L22:
        PageInfoStack r16 = (PageInfoStack) r13.element;
        if (r16 == null) goto L27;
        PageProp r17 = r16.getPageProp();
        if (r17 == null) goto L27;
    L28:
        if (r17 != null) goto L31;
        r17 = b.a(r19);
    L31:
        final PageProp r18 = r17;
        if (r18 == null) goto L34;
        boolean r110 = true;
    L35:
        String r22 = HybridContainerFinder.a;
        final boolean r111 = HybridContainerFinder.b(r19);
        if (r110 == false) goto L41;
        boolean r23 = BtmPageLifecycleCallbackV2.a;
        if (r18 != null) goto L40;
        Intrinsics.throwNpe();
    L40:
        BufferBtm r112 = BtmPageLifecycleCallbackV2.b(r19, r18, r111, (PageInfoStack) r13.element, r20);
    L42:
        if (r111 == false) goto L45;
        BtmPageRecorder.l(r19);
    L45:
        if (r15.c().b().n() != 1) goto L48;
        if (r20 == null) goto L48;
        r1 = r20.getString("top_node_id");
    L48:
        String r24 = r1;
        if (r110 == true) goto L60;
        if (r111 == true) goto L60;
        if (r24 != null) goto L53;
    L56:
        boolean r25 = true;
    L57:
        if (r25 == false) goto L60;
    L93:
        final boolean r26 = r110;
        ALogger.f(ALogger.d, h, new ActivityFilter$onCreated$3(r10, r18, r26, r111, r13));
        return;
    L53:
        if (r24.length() == 0) goto L56;
        r25 = false;
    L60:
        final String r113 = r19.getClass().getName();
        final h r27 = new h(r19);
        r27.c.e(r110, r111);
        if (r15.c().b().n() != 1) goto L80;
        if (r20 == null) goto L67;
        String r28 = r20.getString("node_id");
        if (r28 == null) goto L67;
        r27.c.f(r28);
    L67:
        if (r20 == null) goto L71;
        String r29 = r20.getString("tree_id");
        if (r29 == null) goto L71;
    L72:
        r27.a = r29;
        if (r20 == null) goto L80;
        String r30 = r20.getString("page_tree");
        if (r30 == null) goto L80;
        JSONObject r31 = new JSONObject(r30);     // Catch: Exception -> L78
        r27.a = r31.optString("tree_id");     // Catch: Exception -> L78
        r27.e = r31.optString("top_node_id");     // Catch: Exception -> L78
        r27.c.parse(r31.optString("root_node"));     // Catch: Exception -> L78
    L78:
        e = move-exception;
        e.printStackTrace();
    L71:
        r29 = r27.a;
    L80:
        final boolean r32 = r110;
        ALogger.f(ALogger.d, i, new ActivityFilter$buildPageTree$$inlined$apply$lambda$1(r27, r32, r111, r20, r113));
        PageWoods.b(r27);
        if (r24 != null) goto L83;
    L86:
        boolean r114 = true;
    L88:
        if (r114 == true) goto L92;
        r27.e = r24;
        r27.g = ActivityResumeOrigin.BackProcess;
        com.bytedance.android.btm.impl.page.model.a r33 = r27.h;
        if (r33 == null) goto L92;
        r33.b = Boolean.TRUE;
    L92:
        BaseFilter.a(r19, r27, r112);
        goto L93
    L83:
        if (r24.length() == 0) goto L86;
        r114 = false;
        goto L88
    L41:
        r112 = null;
        goto L42
    L34:
        r110 = false;
    L27:
        r17 = r21;
        goto L28
    L20:
        if (((PageInfoStack) r13.element) != null) goto L22;
        com.bytedance.android.btm.impl.page.lifecycle.layer1_inner.a.f.getClass();
        goto L22
    L10:
        r14 = null;
        goto L12
    }
}
