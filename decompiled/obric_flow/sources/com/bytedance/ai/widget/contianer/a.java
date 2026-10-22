package com.bytedance.ai.widget.contianer;

import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ies.xelement.input.LynxBaseInputView;
import com.bytedance.ies.xelement.input.LynxEditText;
import com.obric.common.oui.R$drawable;
import com.obric.oui.forms.OLineInputView;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3039b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f3038a = r10;
        this.f3039b = r5;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        boolean r5 = true;
        Object r12 = this.f3039b;
        switch(this.f3038a) {
            case 0: goto L70;
            case 1: goto L34;
            case 2: goto L8;
            default: goto L4;
        };
    L4:
        int r13 = OIndexScrollbar.D;
        OIndexScrollbar r14 = (OIndexScrollbar) r12;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        if (r14.f13413q != r14.f13412p) goto L7;
        r11.getAction();
    L7:
        return false;
    L8:
        int r15 = OLineInputView.V;
        OLineInputView r16 = (OLineInputView) r12;
        Intrinsics.checkNotNullParameter(r16, "this$0");
        Intrinsics.checkNotNullParameter(r11, "event");
        int r17 = r11.getActionMasked();
        if (r17 == 0) goto L23;
        if (r17 == 1) goto L13;
        if (r17 == 3) goto L13;
    L33:
        return false;
    L13:
        r16.getClass();
        if (r16.f13301m.hasFocus() == false) goto L19;
        ConstraintLayout r18 = r16.C;
        if (r18 == null) goto L33;
        r18.setBackgroundResource(R$drawable.o_line_box_input_focused_default_border);
        goto L33
    L19:
        ConstraintLayout r19 = r16.C;
        if (r19 == null) goto L33;
        r19.setBackgroundResource(R$drawable.o_line_box_input_normal_default_border);
        goto L33
    L23:
        r16.getClass();
        if (r16.f13301m.hasFocus() == false) goto L29;
        ConstraintLayout r20 = r16.C;
        if (r20 == null) goto L33;
        r20.setBackgroundResource(R$drawable.o_line_box_input_focused_pressed_border);
        goto L33
    L29:
        ConstraintLayout r21 = r16.C;
        if (r21 == null) goto L33;
        r21.setBackgroundResource(R$drawable.o_line_box_input_normal_pressed_border);
        goto L33
    L34:
        int r22 = LynxBaseInputView.L;
        LynxBaseInputView r23 = (LynxBaseInputView) r12;
        Intrinsics.checkNotNullParameter(r23, "this$0");
        int r24 = r11.getAction();
        if (r24 != 0) goto L37;
        r10.getParent().requestDisallowInterceptTouchEvent(true);
        r11.getX();
        r23.getClass();
        r23.f6421y = r11.getY();
        r23.f6422z = r10.getScrollY();
    L69:
        return false;
    L37:
        if (r24 != 1) goto L39;
        r10.getParent().requestDisallowInterceptTouchEvent(false);
        r23.getClass();
        r23.f6421y = 0.0f;
        if (Math.abs(r10.getScrollY() - r23.f6422z) > 10) goto L67;
        r5 = false;
    L67:
        r23.A = r5;
        goto L69
    L39:
        if (r24 == 2) goto L47;
        if (r24 != 3) goto L69;
        r10.getParent().requestDisallowInterceptTouchEvent(false);
        r23.getClass();
        r23.f6421y = 0.0f;
        if (Math.abs(r10.getScrollY() - r23.f6422z) > 10) goto L46;
        r5 = false;
    L46:
        r23.A = r5;
        goto L69
    L47:
        LynxEditText r25 = r23.f6402a;
        LynxEditText r26 = null;
        if (r25 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r25 = null;
    L51:
        if (r25.canScrollVertically(1) == false) goto L53;
    L54:
        LynxEditText r27 = r23.f6402a;
        if (r27 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L59:
        if (r26.canScrollVertically(-1) == true) goto L69;
        if (r11.getY() <= r23.f6421y) goto L69;
    L62:
        r10.getParent().requestDisallowInterceptTouchEvent(false);
        goto L69
    L57:
        r26 = r27;
        goto L59
    L53:
        if (r11.getY() < r23.f6421y) goto L62;
    L70:
        View r28 = ((AppletWidgetContainer) r12).d();
        if (r28 == null) goto L73;
        r28.dispatchTouchEvent(r11);
    L73:
        return true;
    }
}
