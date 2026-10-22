package mh8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.chat.model.ChatDraftItem;
import fh8.h;
import fh8.i;
import fh8.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kc8.b;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import usc.e;
import usc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends FrameLayout implements f {
    public hk9.a a;
    public String b;
    public a c;
    public c d;
    public int e;

    public final void a() {
    }

    public final View asView() {
        return this;
    }

    public final Size c(TextView r1, e r2, Map<String, ? extends Object> r3) {
        return null;
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g() {
        String r0 = this.b;
        a r1 = this.c;
        if (r0 == null) goto L23;
        if (r1 == null) goto L23;
        if (Intrinsics.areEqual(r1.a, r0) == true) goto L12;
        hk9.a r2 = this.a;
        if (r2 == null) goto L27;
        r2.a();
        return;
    L27:
        return;
    L12:
        List<jc8.a> r3 = r1.b;
        if (r3.isEmpty() == false) goto L18;
        hk9.a r4 = this.a;
        if (r4 == null) goto L28;
        r4.a();
        return;
    L28:
        return;
    L18:
        hk9.a r5 = this.a;
        if (r5 != null) goto L21;
        int r6 = ra8.a.a;
        r5 = ra8.a.a(getContext());
        this.a = r5;
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        addView(r5, new FrameLayout.LayoutParams(-1, -2));
    L21:
        int r7 = RangesKt.coerceAtLeast(this.d.a, 0);
        int r8 = RangesKt.coerceAtLeast(this.d.b, 0);
        r5.setPaddingRelative(r7, r5.getPaddingTop(), r8, r5.getPaddingBottom());
        r5.b(b.class, r1.c);
        r5.b(c.class, this.d);
        int r9 = ra8.a.a;
        ra8.a.e(r5, r3, false);
        return;
    L23:
        hk9.a r10 = this.a;
        if (r10 == null) goto L29;
        r10.a();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        hk9.a r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = ra8.a.a;
        ra8.a.c(r0);
    L5:
        this.a = null;
        removeAllViews();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) goto L6;
        g();
        return;
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = new c(0);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final Integer b(Size r2, TextView r3, Canvas r4, Paint r5) {
        Intrinsics.checkNotNullParameter(r2, "widgetSize");
        Intrinsics.checkNotNullParameter(r3, "textView");
        Intrinsics.checkNotNullParameter(r4, "canvas");
        Intrinsics.checkNotNullParameter(r5, "paint");
        return Integer.valueOf(this.e);
    }

    public final Size d(TextView r5, Spanned r6, e r7, int r8, Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r5, "textView");
        Intrinsics.checkNotNullParameter(r6, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r7, "span");
        this.b = r7.k();
        fh8.f r10 = h.b(r9);
        a r0 = null;
        if (r10 == null) goto L16;
        j r11 = r10.r;
        if (r11 == null) goto L16;
        List<i> r12 = r11.a;
        if (r12 == null) goto L16;
        Iterator<T> r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        Object r1 = r13.next();
        if (Intrinsics.areEqual(((i) r1).a(), r7.k()) == false) goto L10;
    L15:
        i r2 = (i) r1;
    L18:
        if ((r2 instanceof a) == false) goto L20;
        r0 = (a) r2;
    L20:
        this.c = r0;
        int r14 = gw8.e.a(r6, r6.getSpanStart(r7)) + r5.getPaddingStart();
        int r15 = r5.getPaddingEnd();
        this.d = new c(r14, r15, Integer.valueOf(RangesKt.coerceAtLeast(r8, 0)));
        this.e = -r14;
        g();
        int r16 = RangesKt.coerceAtLeast((r8 + r14) + r15, 0);
        measure(View.MeasureSpec.makeMeasureSpec(r16, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new Size(r16, getMeasuredHeight());
    L14:
        r1 = null;
    L16:
        r2 = null;
        goto L18
    }
}
