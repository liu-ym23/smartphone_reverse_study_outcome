package e1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.ai.utils.c;
import com.bytedance.ai.widget.f;
import kotlin.jvm.internal.Intrinsics;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ai.utils.b f16740a;

    public a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r11) {
        com.bytedance.ai.utils.b r5 = this.f16740a;
        if (r5 == null) goto L55;
        f r10 = (f) r5;
        boolean r12 = false;
        if (r10.b() == false) goto L51;
        Integer r13 = null;
        if (r11 == null) goto L10;
        Integer r14 = Integer.valueOf(r11.getAction());
    L11:
        if (r14 != null) goto L14;
    L19:
        if (r14 != null) goto L22;
    L41:
        if (r14 != null) goto L44;
    L46:
        if (r14 == null) goto L51;
        if (r14.intValue() != 3) goto L51;
        r10.a();
        goto L51
    L44:
        if (r14.intValue() != 1) goto L46;
        r12 = r10.g;
        r10.a();
        goto L51
    L22:
        if (r14.intValue() != 2) goto L41;
        a r15 = r10.e;
        if (r15 == null) goto L28;
        Context r16 = r15.getContext();
        if (r16 == null) goto L28;
        r13 = Integer.valueOf(ViewConfiguration.get(r16).getScaledTouchSlop());
    L28:
        if (r13 == null) goto L40;
        a r17 = r10.e;
        if (r17 == null) goto L40;
        float r18 = r11.getX();
        float r19 = r11.getY();
        if (r18 < (-r13.intValue())) goto L40;
        if (r19 < (-r13.intValue())) goto L40;
        if (r18 >= (r13.intValue() + (r17.getRight() - r17.getLeft()))) goto L40;
        if (r19 < (r13.intValue() + (r17.getBottom() - r17.getTop()))) goto L51;
    L40:
        r10.a();
        goto L51
    L14:
        if (r14.intValue() != 0) goto L19;
        r10.f3061b = r11;
        r10.a();
        String r20 = "this=" + r10 + ", send delay LongClick";
        Intrinsics.checkNotNullParameter("WidgetLongPressController", "tag");
        d r21 = c.f2846a;
        if (r21 == null) goto L18;
        r21.d("WidgetLongPressController", r20);
    L18:
        r10.f.postDelayed(r10.f3063h, ((long) ViewConfiguration.getLongPressTimeout()) + 300);
        goto L51
    L10:
        r14 = null;
    L51:
        if (r12 != true) goto L55;
        MotionEvent r110 = MotionEvent.obtain(r11);
        r110.setAction(3);
        super.dispatchTouchEvent(r110);
        r110.recycle();
        return true;
    L55:
        return super.dispatchTouchEvent(r11);
    }

    public Float getLastMotionX() {
        com.bytedance.ai.utils.b r5 = this.f16740a;
        if (r5 == null) goto L11;
        f r10 = (f) r5;
        MotionEvent r11 = r10.f3061b;
        if (r11 == null) goto L11;
        float r12 = r11.getRawX();
        a r13 = r10.e;
        int[] r14 = new int[2];
        if (r13 == null) goto L10;
        r13.getLocationOnScreen(r14);
    L10:
        return Float.valueOf(r12 - r14[0]);
    L11:
        return null;
    }

    public Float getLastMotionY() {
        com.bytedance.ai.utils.b r5 = this.f16740a;
        if (r5 == null) goto L11;
        f r10 = (f) r5;
        MotionEvent r11 = r10.f3061b;
        if (r11 == null) goto L11;
        float r12 = r11.getRawY();
        a r13 = r10.e;
        int[] r14 = new int[2];
        if (r13 == null) goto L10;
        r13.getLocationOnScreen(r14);
    L10:
        return Float.valueOf(r12 - r14[1]);
    L11:
        return null;
    }

    public final com.bytedance.ai.utils.b getLongPressController() {
        return this.f16740a;
    }

    public final void setLongPressController(com.bytedance.ai.utils.b r5) {
        this.f16740a = r5;
    }
}
