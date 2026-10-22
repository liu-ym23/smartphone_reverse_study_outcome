package com.bytedance.ai.model.widgets;

import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RelaxViewFloatingPageV2 f2352b;

    public /* synthetic */ k(RelaxViewFloatingPageV2 r5, int r10) {
        this.f2351a = r10;
        this.f2352b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RelaxViewFloatingPageV2 r5 = this.f2352b;
        switch(this.f2351a) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L8;
            default: goto L4;
        };
    L4:
        AppletRuntime r10 = r5.f2329a;
        JavaOnlyMap r11 = new JavaOnlyMap();
        r11.put("viewId", r5.f2331c);
        Unit r12 = Unit.INSTANCE;
        r10.getClass();
        Intrinsics.checkNotNullParameter("onPageOpened", "eventName");
        m1.i r13 = r10.r();
        if (r13 == null) goto L31;
        r13.e("onPageOpened", ConvertUtils.toJson(r11));
        return;
    L31:
        return;
    L8:
        c3.c r14 = r5.g;
        if (r14 == null) goto L11;
        r14.f();
    L11:
        JSONObject r15 = com.lynx.tasm.utils.d.k("eventName", "onBackground");
        JSONObject r16 = new JSONObject();
        r16.put("eventName", r5.f2330b.toViewContext());
        Unit r17 = Unit.INSTANCE;
        r15.put("data", r16);
        Intrinsics.checkNotNullParameter(r15.toString(), "message");
        return;
    L13:
        JSONObject r18 = com.lynx.tasm.utils.d.k("eventName", "onHide");
        JSONObject r19 = new JSONObject();
        r19.put("eventName", r5.f2330b.toViewContext());
        Unit r20 = Unit.INSTANCE;
        r18.put("data", r19);
        Intrinsics.checkNotNullParameter(r18.toString(), "message");
        return;
    L15:
        r5.getClass();
        c3.c r21 = r5.g;
        if (r21 == null) goto L18;
        r21.e();
    L18:
        r5.g = null;
        RelaxViewFloatingPageV2.j(r5.f2320j, Lifecycle.Event.ON_DESTROY);
        return;
    L20:
        JSONObject r22 = com.lynx.tasm.utils.d.k("eventName", "onDestroy");
        JSONObject r23 = new JSONObject();
        r23.put("eventName", r5.f2330b.toViewContext());
        Unit r24 = Unit.INSTANCE;
        r22.put("data", r23);
        Intrinsics.checkNotNullParameter(r22.toString(), "message");
        return;
    L22:
        JSONObject r25 = com.lynx.tasm.utils.d.k("eventName", "onShow");
        JSONObject r26 = new JSONObject();
        r26.put("eventName", r5.f2330b.toViewContext());
        Unit r27 = Unit.INSTANCE;
        r25.put("data", r26);
        Intrinsics.checkNotNullParameter(r25.toString(), "message");
        return;
    L24:
        JSONObject r28 = com.lynx.tasm.utils.d.k("eventName", "FloatingMaskClicked");
        JSONObject r29 = new JSONObject();
        r29.put("viewId", r5.f2330b.getPageId());
        Unit r30 = Unit.INSTANCE;
        r28.put("data", r29);
        Intrinsics.checkNotNullParameter(r28.toString(), "message");
        return;
    L26:
        c3.c r31 = r5.g;
        if (r31 == null) goto L29;
        r31.g();
    L29:
        JSONObject r32 = com.lynx.tasm.utils.d.k("eventName", "onForeground");
        JSONObject r33 = new JSONObject();
        r33.put("eventName", r5.f2330b.toViewContext());
        Unit r34 = Unit.INSTANCE;
        r32.put("data", r33);
        Intrinsics.checkNotNullParameter(r32.toString(), "message");
    }
}
