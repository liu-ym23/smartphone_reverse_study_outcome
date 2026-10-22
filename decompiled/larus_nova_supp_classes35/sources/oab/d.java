package oab;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.custom.repeat.ChooseCustomRepeatFragment;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import com.ss.android.lark.ui.IActionTitlebar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class d extends IActionTitlebar.TextAction {
    public long a;

    public d(String r3) {
        super(r3, 2131105548);
        this.a = 0;
    }

    public final void performAction(View r8) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.a) <= 1000) goto L27;
        com.ss.android.lark.custom.repeat.e r2 = (com.ss.android.lark.custom.repeat.e) this;
        Intrinsics.checkNotNullParameter(r8, "view");
        ChooseCustomRepeatFragment r9 = r2.b;
        ChooseCustomRepeatFragment.b r4 = null;
        if (r9.T90().getVisibility() != 0) goto L21;
        View r3 = r9.f;
        if (r3 != null) goto L13;
        View r5 = r9.getView();
        if (r5 == null) goto L11;
        r3 = r5.findViewById(2131393170);
    L12:
        r9.f = (WheelView) r3;
        goto L13
    L11:
        r3 = null;
    L13:
        WheelView r6 = (WheelView) r3;
        r6.c.onItemSelected(r6.getCurrentItem());
        View r7 = r9.g;
        if (r7 != null) goto L20;
        View r10 = r9.getView();
        if (r10 == null) goto L18;
        r7 = r10.findViewById(2131393171);
    L19:
        r9.g = (WheelView) r7;
        goto L20
    L18:
        r7 = null;
    L20:
        WheelView r11 = (WheelView) r7;
        r11.c.onItemSelected(r11.getCurrentItem());
    L21:
        WheelView r12 = r9.W90();
        r12.c.onItemSelected(r12.getCurrentItem());
        WheelView r13 = r9.V90();
        r13.c.onItemSelected(r13.getCurrentItem());
        ChooseCustomRepeatFragment.b r14 = r2.b.m;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("customRepeatAction");
    L25:
        r4.a(r2.b.r.toER());
        ChooseCustomRepeatFragment r15 = r2.b;
        r15.r.clearRule();
        r15.T90().c();
        this.a = r0;
        return;
    L24:
        r4 = r14;
        goto L25
    }
}
