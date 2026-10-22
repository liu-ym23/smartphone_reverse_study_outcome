package com.ss.android.lark.flow.chat.creategroup.page;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnTouchListener {
    public final /* synthetic */ FlowGroupCreateActivity a;

    public b(FlowGroupCreateActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        boolean r0 = false;
        if (this.a.c == false) goto L5;
        return false;
    L5:
        int r12 = r11.getActionMasked();
        View r1 = null;
        if (r12 != 0) goto L8;
        float r13 = r11.getY();
        FlowGroupCreateActivity r5 = this.a;
        if (r13 <= r5.k) goto L67;
        return false;
    L67:
        VelocityTracker r14 = r5.d;
        if (r14 == null) goto L70;
        r14.recycle();
    L70:
        this.a.d = VelocityTracker.obtain();
        VelocityTracker r15 = this.a.d;
        if (r15 == null) goto L73;
        r15.addMovement(r11);
    L73:
        this.a.e = r11.getRawY();
        FlowGroupCreateActivity r16 = this.a;
        View r17 = r16.j;
        if (r17 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r17 = null;
    L76:
        r16.f = r17.getTranslationY();
        View r18 = this.a.j;
        if (r18 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r18 = null;
    L79:
        r18.animate().cancel();
        View r19 = this.a.i;
        if (r19 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L83:
        r1.animate().cancel();
    L84:
        return true;
    L82:
        r1 = r19;
        goto L83
    L8:
        if (r12 != 1) goto L10;
    L40:
        VelocityTracker r110 = this.a.d;
        if (r110 == null) goto L43;
        r110.addMovement(r11);
    L43:
        VelocityTracker r111 = this.a.d;
        if (r111 == null) goto L46;
        r111.computeCurrentVelocity(AudioViewModel.ASR_SESSION_IDLE);
    L46:
        VelocityTracker r112 = this.a.d;
        if (r112 == null) goto L49;
        float r113 = r112.getYVelocity();
    L50:
        VelocityTracker r114 = this.a.d;
        if (r114 == null) goto L53;
        r114.recycle();
    L53:
        FlowGroupCreateActivity r115 = this.a;
        r115.d = null;
        View r116 = r115.j;
        if (r116 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r116 = null;
    L56:
        float r117 = r116.getTranslationY();
        FlowGroupCreateActivity r3 = this.a;
        if (r117 <= (r3.h * 0.33f)) goto L59;
    L60:
        r0 = true;
    L61:
        if (r0 == false) goto L63;
        FlowGroupCreateActivity.z1(r3);
        this.a.finish();
        goto L84
    L63:
        r3.A1(0.0f, 1.0f, null);
        goto L84
    L59:
        if (r113 <= 1500.0f) goto L61;
    L49:
        r113 = 0.0f;
        goto L50
    L10:
        if (r12 != 2) goto L12;
        VelocityTracker r118 = this.a.d;
        if (r118 == null) goto L17;
        r118.addMovement(r11);
    L17:
        float r119 = r11.getRawY() - this.a.e;
        float r120 = Math.abs(r119);
        FlowGroupCreateActivity r7 = this.a;
        if (r120 >= r7.g) goto L28;
        View r121 = r7.j;
        if (r121 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r121 = null;
    L23:
        if (r121.getTranslationY() != this.a.f) goto L25;
        boolean r122 = true;
    L26:
        if (r122 == false) goto L28;
        return false;
    L25:
        r122 = false;
    L28:
        FlowGroupCreateActivity r123 = this.a;
        float r124 = RangesKt.coerceIn(r123.f + r119, 0.0f, r123.h);
        View r125 = this.a.j;
        if (r125 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r125 = null;
    L31:
        r125.setTranslationY(r124);
        float r126 = RangesKt.coerceIn(r124 / this.a.h, 0.0f, 1.0f);
        View r127 = this.a.i;
        if (r127 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L35:
        r1.setAlpha(1.0f - r126);
        View r128 = this.a.getCurrentFocus();
        if ((r128 instanceof EditText) == false) goto L84;
        EditText r129 = (EditText) r128;
        if (r129.isFocused() == false) goto L84;
        FlowGroupCreateActivity.z1(this.a);
        r129.clearFocus();
        goto L84
    L34:
        r1 = r127;
        goto L35
    L12:
        if (r12 == 3) goto L40;
        return false;
    }
}
