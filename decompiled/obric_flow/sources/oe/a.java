package oe;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import com.bytedance.ies.xelement.viewpager.childitem.AndroidNestedScrollView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends HorizontalScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NestedScrollView f20551b;

    public /* synthetic */ a(NestedScrollView r5, Context r10, int r11) {
        this.f20550a = r11;
        this.f20551b = r5;
        super(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        switch(this.f20550a) {
            case 0: goto L10;
            default: goto L5;
        };
    L5:
        if (((AndroidNestedScrollView) this.f20551b).f == true) goto L14;
        return false;
    L14:
        return super.onInterceptTouchEvent(r5);
    L10:
        if (((com.bytedance.ies.xelement.AndroidNestedScrollView) this.f20551b).f == true) goto L15;
        return false;
    L15:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        switch(this.f20550a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        super.onMeasure(r5, r10);
        return;
    L6:
        super.onMeasure(r5, r10);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r5, int r10, int r11, int r12) {
        switch(this.f20550a) {
            case 0: goto L24;
            default: goto L4;
        };
    L4:
        super.onScrollChanged(r5, r10, r11, r12);
        AndroidNestedScrollView r13 = (AndroidNestedScrollView) this.f20551b;
        if (r5 == r13.e) goto L46;
        boolean r14 = r13.f6529i;
        ArrayList r15 = r13.f6531k;
        if (r14 == true) goto L10;
    L16:
        r13.a(r13.f6537q);
        Iterator r16 = r15.iterator();
        if (r16.hasNext() == true) goto L23;
    L19:
        if (r13.e == getScrollX()) goto L45;
        r13.e = getScrollX();
        return;
    L45:
        return;
    L23:
        throw mn.h.c(r16);
    L10:
        if (r13.f6530j == true) goto L16;
        r13.f6530j = true;
        r13.a(1);
        Iterator r17 = r15.iterator();
        if (r17.hasNext() == false) goto L19;
        throw mn.h.c(r17);
    L46:
        return;
    L24:
        super.onScrollChanged(r5, r10, r11, r12);
        com.bytedance.ies.xelement.AndroidNestedScrollView r18 = (com.bytedance.ies.xelement.AndroidNestedScrollView) this.f20551b;
        if (r5 == r18.e) goto L48;
        boolean r19 = r18.f6338i;
        ArrayList r20 = r18.f6340k;
        if (r19 == true) goto L30;
    L35:
        r18.a(r18.f6346q);
        Iterator r21 = r20.iterator();
    L37:
        if (r21.hasNext() == false) goto L40;
        ((b) r21.next()).a(r5, r10, r11, r12);
    L40:
        if (r18.e == getScrollX()) goto L47;
        r18.e = getScrollX();
        return;
    L47:
        return;
    L30:
        if (r18.f6339j == true) goto L35;
        r18.f6339j = true;
        r18.a(1);
        Iterator r22 = r20.iterator();
    L33:
        if (r22.hasNext() == false) goto L40;
        ((b) r22.next()).getClass();
        goto L33
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        switch(this.f20550a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        AndroidNestedScrollView r10 = (AndroidNestedScrollView) this.f20551b;
        if (r10.f == false) goto L13;
        r10.b(r5);
        if (r5.getAction() != 0) goto L10;
        r10.a(r10.f6537q);
    L10:
        if (r5.getAction() != 1) goto L26;
        r10.f6534n = r10.getScrollY();
        r10.f6535o = r10.f6527c.getScrollX();
        r10.postDelayed(r10.f6533m, r10.f6536p);
    L26:
        return super.onTouchEvent(r5);
    L13:
        return false;
    L15:
        com.bytedance.ies.xelement.AndroidNestedScrollView r11 = (com.bytedance.ies.xelement.AndroidNestedScrollView) this.f20551b;
        if (r11.f == false) goto L24;
        r11.b(r5);
        if (r5.getAction() != 0) goto L21;
        r11.a(r11.f6346q);
    L21:
        if (r5.getAction() != 1) goto L27;
        r11.f6343n = r11.getScrollY();
        r11.f6344o = r11.f6336c.getScrollX();
        r11.postDelayed(r11.f6342m, r11.f6345p);
    L27:
        return super.onTouchEvent(r5);
    L24:
        return false;
    }
}
