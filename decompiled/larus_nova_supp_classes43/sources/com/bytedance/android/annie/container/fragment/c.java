package com.bytedance.android.annie.container.fragment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.u;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {
    public boolean a;
    public final int b;
    public final Rect c;
    public final /* synthetic */ AnnieFragment d;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        AnnieFragment r0 = this.d;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L100
        View r10 = r0.Y;     // Catch: Throwable -> L100
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.getRootView() == null) goto L116;
        com.bytedance.android.annie.util.p r11 = com.bytedance.android.annie.util.p.a;     // Catch: Throwable -> L100
        int r12 = r11.a(this.b);     // Catch: Throwable -> L100
        View r13 = r0.Y;     // Catch: Throwable -> L100
        if (r13 == null) goto L11;
        r13.getWindowVisibleDisplayFrame(this.c);     // Catch: Throwable -> L100
    L11:
        Rect r14 = this.c;     // Catch: Throwable -> L100
        int r15 = r14.bottom - r14.top;     // Catch: Throwable -> L100
        if (r0.Z != r15) goto L14;
        return;
    L14:
        r0.Z = r15;     // Catch: Throwable -> L100
        View r16 = r0.Y;     // Catch: Throwable -> L100
        ViewGroup r17 = null;
        if (r16 == null) goto L97;
        int r18 = r16.getRootView().getHeight() - r15;     // Catch: Throwable -> L100
        if (r18 < r12) goto L19;
        boolean r19 = true;
    L21:
        if (AnnieFragment.T90(r0) == false) goto L81;
        if (r19 == false) goto L58;
        FragmentParamVoNew r20 = r0.e;     // Catch: Throwable -> L100
        if (r20 != null) goto L26;
    L28:
        boolean r21 = false;
    L29:
        if (r21 == false) goto L32;
        int r22 = u.a;     // Catch: Throwable -> L100
        int r23 = r15 + u.b(r0.getActivity());     // Catch: Throwable -> L100
    L60:
        if (((Boolean) r0.Q.getValue()).booleanValue() == false) goto L62;
        FragmentParamVoNew r24 = r0.e;     // Catch: Throwable -> L100
        if (r24 != null) goto L70;
    L72:
        boolean r25 = false;
    L73:
        if (r25 == true) goto L75;
    L79:
        r16.getLayoutParams().height = r23;     // Catch: Throwable -> L100
        r16.requestLayout();     // Catch: Throwable -> L100
        goto L81
    L75:
        if (AnnieConfigSettingKeys.FIX_ANNIE_INPUT_ADAPTER.a().booleanValue() == false) goto L79;
        if (r19 == false) goto L78;
        r16.scrollBy(0, r16.getHeight() - r23);     // Catch: Throwable -> L100
        goto L81
    L78:
        r16.scrollTo(0, 0);     // Catch: Throwable -> L100
        goto L81
    L70:
        if (r24.f2() != true) goto L72;
        r25 = true;
        goto L73
    L62:
        if (AnnieConfigSettingKeys.FIX_ANNIE_INPUT_ADAPTER.a().booleanValue() == false) goto L66;
        if (r19 == false) goto L65;
        r16.scrollBy(0, r16.getHeight() - r23);     // Catch: Throwable -> L100
        goto L81
    L65:
        r16.scrollTo(0, 0);     // Catch: Throwable -> L100
        goto L81
    L66:
        r16.getLayoutParams().height = r23;     // Catch: Throwable -> L100
        r16.requestLayout();     // Catch: Throwable -> L100
        goto L81
    L32:
        if (r0.isFullScreen() == false) goto L40;
        View r26 = r0.h;     // Catch: Throwable -> L100
        if ((r26 instanceof ViewGroup) == false) goto L36;
        r17 = (ViewGroup) r26;     // Catch: Throwable -> L100
    L36:
        if (r17 == null) goto L48;
        View r27 = r17.findViewById(2131362975);     // Catch: Throwable -> L100
        if (r27 == null) goto L48;
        int r28 = r16.getHeight();     // Catch: Throwable -> L100
        int r29 = r27.getHeight();     // Catch: Throwable -> L100
    L47:
        int r30 = r28 - r29;     // Catch: Throwable -> L100
    L49:
        if (r30 == 0) goto L51;
    L57:
        r23 = r15 + r30;     // Catch: Throwable -> L100
        goto L60
    L51:
        if (AnnieConfigSettingKeys.HYBRID_FIX_KEYBOARD_RESIZE_HEIGHT.a().booleanValue() == false) goto L57;
        if (r0.isFullScreen() == true) goto L57;
        if (r16.getRootView().getHeight() != com.bytedance.android.annie.util.p.c(r0.getActivity()).heightPixels) goto L57;
        int r31 = u.a;     // Catch: Throwable -> L100
        r30 = u.b(r0.getActivity());     // Catch: Throwable -> L100
    L48:
        r30 = 0;
        goto L49
    L40:
        View r32 = r0.Y;     // Catch: Throwable -> L100
        if ((r32 instanceof ViewGroup) == false) goto L43;
        r17 = (ViewGroup) r32;     // Catch: Throwable -> L100
    L43:
        if (r17 == null) goto L48;
        View r33 = r17.getChildAt(0);     // Catch: Throwable -> L100
        if (r33 == null) goto L48;
        r28 = r16.getHeight();     // Catch: Throwable -> L100
        r29 = r33.getHeight();     // Catch: Throwable -> L100
        goto L47
    L26:
        if (r20.i() != true) goto L28;
        r21 = true;
        goto L29
    L58:
        r23 = -1;
    L81:
        if (r19 != this.a) goto L83;
        return;
    L83:
        this.a = r19;     // Catch: Throwable -> L100
        if (r19 == false) goto L93;
        if (r0.X == true) goto L96;
        r0.X = true;     // Catch: Throwable -> L100
        int r34 = (int) r11.h(r18);
        JSONObject r35 = new JSONObject();     // Catch: JSONException -> L110 Throwable -> L100
        r35.put("visible", true);     // Catch: JSONException -> L110 Throwable -> L100
        r35.put("height", r34);     // Catch: JSONException -> L110 Throwable -> L100
        r0.sendJsEvent("H5_keyboardStatusChange", r35);     // Catch: JSONException -> L110 Throwable -> L100
        r0.sendJsEvent("keyboardStatusChange", r35);     // Catch: JSONException -> L110 Throwable -> L100
    L113:
        goto L96
    L93:
        if (r0.X == false) goto L96;
        r0.X = false;     // Catch: Throwable -> L100
        JSONObject r36 = new JSONObject();     // Catch: JSONException -> L110 Throwable -> L100
        r36.put("visible", false);     // Catch: JSONException -> L110 Throwable -> L100
        r36.put("height", 0);     // Catch: JSONException -> L110 Throwable -> L100
        r0.sendJsEvent("H5_keyboardStatusChange", r36);     // Catch: JSONException -> L110 Throwable -> L100
        r0.sendJsEvent("keyboardStatusChange", r36);     // Catch: JSONException -> L110 Throwable -> L100
    L96:
        r17 = Unit.INSTANCE;     // Catch: Throwable -> L100
        goto L97
    L19:
        r19 = false;
    L97:
        Object r37 = Result.constructor-impl(r17);     // Catch: Throwable -> L100
    L102:
        AnnieFragment r38 = this.d;
        Throwable r39 = Result.exceptionOrNull-impl(r37);
        if (r39 == null) goto L117;
        com.bytedance.android.annie.param.a r40 = r38.f;
        if (r40 == null) goto L118;
        x8.b r41 = r40.d;
        if (r41 == null) goto L119;
        x8.b.c(r41, r39);
        return;
    L119:
        return;
    L118:
        return;
    L117:
        return;
    L116:
        return;
    L100:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L102
    }

    public c(AnnieFragment r1) {
        this.d = r1;
        this.b = 148;
        this.c = new Rect();
    }
}
