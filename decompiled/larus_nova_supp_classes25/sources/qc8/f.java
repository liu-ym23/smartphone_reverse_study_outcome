package qc8;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent$f;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent$g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements View.OnTouchListener {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ pc8.e b;
    public final /* synthetic */ BubbleBannerComponent$g c;
    public final /* synthetic */ BubbleBannerComponent$f d;

    public /* synthetic */ f(BubbleBannerComponent r1, pc8.e r2, BubbleBannerComponent$g r3, BubbleBannerComponent$f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r10, MotionEvent r11) {
        BubbleBannerComponent r0 = this.a;
        pc8.e r1 = this.b;
        BubbleBannerComponent$g r2 = this.c;
        BubbleBannerComponent$f r3 = this.d;
        int r4 = BubbleBannerComponent.S;
        String r5 = r1.a;
        if (Intrinsics.areEqual(r0.u, r5) == false) goto L11;
        pc8.e r6 = com.larus.bmhome.chat.bubble.floating.runtime.k.b(r5);
        if (r6 == null) goto L7;
        BubbleBannerState r7 = r6.c;
    L9:
        if (r7 != BubbleBannerState.VISIBLE) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        Intrinsics.checkNotNull(r10);
        r0.V3(r10, r1.a);
    L60:
        return true;
    L14:
        int r9 = r11.getActionMasked();
        if (r9 == 0) goto L57;
        if (r9 != 1) goto L18;
        Intrinsics.checkNotNull(r10);
        ViewParent r12 = r10.getParent();
        if (r12 == null) goto L52;
        r12.requestDisallowInterceptTouchEvent(false);
    L52:
        if (r2.d == true) goto L60;
        if (r2.e == true) goto L60;
        r10.performClick();
        goto L60
    L18:
        if (r9 != 2) goto L20;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        float r13 = r11.getRawX() - r2.a;
        float r14 = r11.getRawY() - r2.b;
        if (r2.c == true) goto L39;
        if (Math.abs(r13) <= r3.a) goto L30;
    L31:
        r2.e = true;
        if (r14 > r3.a) goto L34;
    L36:
        boolean r15 = false;
    L37:
        r2.c = r15;
        goto L39
    L34:
        if (Math.abs(r14) <= Math.abs(r13)) goto L36;
        r15 = true;
        goto L37
    L30:
        if (Math.abs(r14) > r3.a) goto L31;
    L39:
        if (r2.c == false) goto L60;
        if (r2.d == true) goto L60;
        int r16 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        boolean r17 = com.larus.bmhome.chat.bubble.floating.runtime.k.a(r1.a, BubbleBannerDismissReason.MANUAL);
        r2.d = r17;
        if (r17 == false) goto L45;
        BubbleBannerComponent.Q3(r0.t, r10);
    L45:
        ViewParent r18 = r10.getParent();
        if (r18 == null) goto L60;
        r18.requestDisallowInterceptTouchEvent(false);
        goto L60
    L20:
        if (r9 != 3) goto L60;
        Intrinsics.checkNotNull(r10);
        ViewParent r19 = r10.getParent();
        if (r19 == null) goto L60;
        r19.requestDisallowInterceptTouchEvent(false);
        goto L60
    L57:
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        r10.animate().cancel();
        r2.a = r11.getRawX();
        r2.b = r11.getRawY();
        r2.c = false;
        r2.d = false;
        r2.e = false;
        ViewParent r110 = r10.getParent();
        if (r110 == null) goto L60;
        r110.requestDisallowInterceptTouchEvent(true);
        goto L60
    L7:
        r7 = null;
    L11:
        r8 = false;
        goto L12
    }
}
