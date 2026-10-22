package com.bytedance.ai.model.widgets;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.google.android.material.datepicker.DateSelector;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.behavior.v0;
import com.obric.oui.forms.OBoxInputView;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2344b;

    public /* synthetic */ h(Object r5, int r10) {
        this.f2343a = r10;
        this.f2344b = r5;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r10, boolean r11) {
        Object r5 = this.f2344b;
        switch(this.f2343a) {
            case 0: goto L38;
            case 1: goto L23;
            case 2: goto L19;
            case 3: goto L17;
            default: goto L4;
        };
    L4:
        int r12 = OBoxInputView.f13234v;
        OBoxInputView r13 = (OBoxInputView) r5;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        if (r11 == false) goto L11;
        Object r14 = r13.getContext().getSystemService("input_method");
        if (r14 == null) goto L10;
        ((InputMethodManager) r14).showSoftInput(r13, 0);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L11:
        Object r15 = r13.getContext().getSystemService("input_method");
        if (r15 == null) goto L16;
        ((InputMethodManager) r15).hideSoftInputFromWindow(r13.getWindowToken(), 0);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L17:
        DateSelector.b((EditText[]) r5, r10, r11);
        return;
    L19:
        AppletWidgetContainer r16 = (AppletWidgetContainer) r5;
        m1.i r17 = r16.f3025l;
        if (r17 == null) goto L52;
        JsonObject r18 = new JsonObject();
        r18.addProperty("containerID", r16.e);
        r18.addProperty("focusState", Boolean.valueOf(r11));
        Unit r19 = Unit.INSTANCE;
        r17.e("onFocusChange", r18);
        return;
    L52:
        return;
    L23:
        WebViewFloatingPageV2 r20 = (WebViewFloatingPageV2) r5;
        ql.b r21 = r20.f2324j;
        if (r21 == null) goto L53;
        String r22 = ((com.ivy.ivykit.plugin.impl.web.h) r21).f9542a.getSessionId();
        if (StringsKt.isBlank(r22) == false) goto L28;
        r22 = null;
    L28:
        if (r22 == null) goto L54;
        StringBuilder r110 = com.lynx.tasm.utils.j.d(r22, " widget ");
        r110.append(r20.f2331c);
        r110.append(" focus change: ");
        r110.append(r11);
        r110.append(" send");
        String r111 = r110.toString();
        Intrinsics.checkNotNullParameter("WebViewFloatingPageV2", "tag");
        t0.d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L32;
        r23.d("WebViewFloatingPageV2", r111);
    L32:
        JSONObject r112 = new JSONObject(MapsKt.mapOf(TuplesKt.to("data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("containerID", r22), TuplesKt.to("focusState", Boolean.valueOf(r11))}))));
        ql.b r24 = r20.f2324j;
        if (r24 == null) goto L55;
        Intrinsics.checkNotNullParameter("onFocusChange", "name");
        com.bytedance.ies.bullet.service.base.h r25 = ((com.ivy.ivykit.plugin.impl.web.h) r24).f9542a.getKitView();
        if (r25 == null) goto L56;
        r25.a("onFocusChange", r112);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L38:
        LynxViewFloatingPage r26 = (LynxViewFloatingPage) r5;
        com.bytedance.ai.lynx.g r27 = r26.e;
        String r113 = r26.f2331c;
        if (r27 == null) goto L47;
        Map r28 = MapsKt.mapOf(TuplesKt.to("data", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("containerID", r113), TuplesKt.to("focusState", Boolean.valueOf(r11))})));
        Intrinsics.checkNotNullParameter("onFocusChange", "eventName");
        com.bytedance.sdk.xbridge.cn.platform.lynx.a r29 = r27.e;
        if (r29 == null) goto L47;
        Intrinsics.checkNotNullParameter("onFocusChange", "eventName");
        JSONObject r30 = new JSONObject();
        if (r28 == null) goto L45;
        JSONObject r31 = new JSONObject(r28);
    L46:
        r30.put("data", r31);
        JavaOnlyArray r32 = new JavaOnlyArray();
        r32.pushMap(v0.g(r30));
        com.bytedance.sdk.xbridge.cn.platform.lynx.c r33 = r29.t();
        r33.getClass();
        Intrinsics.checkNotNullParameter("onFocusChange", "name");
        Intrinsics.checkNotNullParameter(r32, LynxResourceModule.PARAMS_KEY);
        r33.f.sendGlobalEvent("onFocusChange", r32);
        goto L47
    L45:
        r31 = new JSONObject();
    L47:
        m1.i r34 = r26.f2305k;
        if (r34 == null) goto L57;
        JsonObject r35 = new JsonObject();
        r35.addProperty("containerID", r113);
        r35.addProperty("focusState", Boolean.valueOf(r11));
        Unit r114 = Unit.INSTANCE;
        r34.e("onFocusChange", r35);
        return;
    }
}
