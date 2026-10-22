package com.bytedance.ai.model.widgets;

import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap;
import com.obric.launcher.widget.R$id;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebViewFloatingPageV2 f2366b;

    public /* synthetic */ q(WebViewFloatingPageV2 r5, int r10) {
        this.f2365a = r10;
        this.f2366b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebViewFloatingPageV2 r5 = this.f2366b;
        switch(this.f2365a) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L10;
            case 6: goto L8;
            default: goto L4;
        };
    L4:
        JavaOnlyMap r10 = new JavaOnlyMap();
        r10.put("viewId", r5.f2331c);
        Unit r11 = Unit.INSTANCE;
        AppletRuntime r12 = r5.f2329a;
        r12.getClass();
        Intrinsics.checkNotNullParameter("onPageOpened", "eventName");
        m1.i r13 = r12.r();
        if (r13 == null) goto L28;
        r13.e("onPageOpened", ConvertUtils.toJson(r10));
        return;
    L28:
        return;
    L8:
        JSONObject r14 = com.lynx.tasm.utils.d.k("eventName", "onHide");
        JSONObject r15 = new JSONObject();
        r15.put("eventName", r5.f2330b.toViewContext());
        Unit r16 = Unit.INSTANCE;
        r14.put("data", r15);
        r5.a(r14.toString());
        return;
    L10:
        WebView r17 = r5.e;
        if (r17 == null) goto L13;
        r17.setTag(R$id.applet_ai_container_tag, null);
    L13:
        ql.b r18 = r5.f2324j;
        if (r18 == null) goto L16;
        ((com.ivy.ivykit.plugin.impl.web.h) r18).f9542a.release();
    L16:
        r5.f2324j = null;
        WebViewFloatingPageV2.j(r5.f2327m, Lifecycle.Event.ON_DESTROY);
        return;
    L18:
        JSONObject r19 = com.lynx.tasm.utils.d.k("eventName", "onDestroy");
        JSONObject r20 = new JSONObject();
        r20.put("eventName", r5.f2330b.toViewContext());
        Unit r21 = Unit.INSTANCE;
        r19.put("data", r20);
        r5.a(r19.toString());
        return;
    L20:
        JSONObject r22 = com.lynx.tasm.utils.d.k("eventName", "onForeground");
        JSONObject r23 = new JSONObject();
        r23.put("eventName", r5.f2330b.toViewContext());
        Unit r24 = Unit.INSTANCE;
        r22.put("data", r23);
        r5.a(r22.toString());
        return;
    L22:
        JSONObject r25 = com.lynx.tasm.utils.d.k("eventName", "onBackground");
        JSONObject r26 = new JSONObject();
        r26.put("eventName", r5.f2330b.toViewContext());
        Unit r27 = Unit.INSTANCE;
        r25.put("data", r26);
        r5.a(r25.toString());
        return;
    L24:
        JSONObject r28 = com.lynx.tasm.utils.d.k("eventName", "onShow");
        JSONObject r29 = new JSONObject();
        r29.put("eventName", r5.f2330b.toViewContext());
        Unit r30 = Unit.INSTANCE;
        r28.put("data", r29);
        r5.a(r28.toString());
        return;
    L26:
        JSONObject r31 = com.lynx.tasm.utils.d.k("eventName", "FloatingMaskClicked");
        JSONObject r32 = new JSONObject();
        r32.put("viewId", r5.f2330b.getPageId());
        Unit r33 = Unit.INSTANCE;
        r31.put("data", r32);
        r5.a(r31.toString());
    }
}
