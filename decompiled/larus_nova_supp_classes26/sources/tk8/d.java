package tk8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;
import java.util.List;
import kc8.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends FrameLayout implements hb8.a {
    public final hk9.a a;
    public f b;
    public a c;

    public static final class a {
        public final boolean a;
        public final boolean b;
        public final Integer c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L10;
            r1 = 1237;
        L10:
            int r3 = (r2 + r1) * 31;
            Integer r4 = this.c;
            if (r4 != null) goto L13;
            int r5 = 0;
        L15:
            return r3 + r5;
        L13:
            r5 = r4.hashCode();
            goto L15
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "RenderState(isStreaming=" + this.a + ", isFinished=" + this.b + ", messageStatusLocal=" + this.c + ')';
        }

        public a(boolean r1, boolean r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final void f() {
        this.a.a();
        this.c = null;
        this.b = null;
    }

    public final CustomMarkdownTextView getContentMarkdownView() {
        return b(this);
    }

    public d(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        int r0 = ra8.a.a;
        hk9.a r5 = ra8.a.a(r4);
        addView(r5, new FrameLayout.LayoutParams(-1, -2));
        this.a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static CustomMarkdownTextView b(View r4) {
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L7;
        return (CustomMarkdownTextView) r4;
    L7:
        if ((r4 instanceof ViewGroup) == true) goto L9;
        return null;
    L9:
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        CustomMarkdownTextView r3 = b(r5.getChildAt(r2));
        if (r3 != null) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return r3;
    L15:
        return null;
    }

    public static void c(View r3) {
        r3.forceLayout();
        if ((r3 instanceof ViewGroup) == true) goto L5;
        return;
    L5:
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        c(r4.getChildAt(r1));
        r1 = r1 + 1;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [tk8.c] */
    private final void setupPassData(e r12) {
        this.a.b(tb8.a.class, new tb8.a(new tk8.a(this), new b(this), new c(this), null, false, null, 56));
        this.a.b(kc8.b.class, r12.c);
        int r0 = com.larus.bmhome.chat.markdown.imagetool.f.a;
        Context r1 = getContext();
        Message r2 = r12.b;
        kc8.b r3 = r12.c;
        if (r3 == null) goto L7;
        y r4 = r3.a;
        if (r4 == null) goto L7;
        Integer r5 = r4.j;
    L8:
        boolean r6 = false;
        if (r3 == null) goto L13;
        y r7 = r3.a;
        if (r7 == null) goto L13;
        boolean r8 = Intrinsics.areEqual(r7.i, Boolean.TRUE);
    L14:
        Boolean r9 = Boolean.valueOf(r8);
        kc8.b r13 = r12.c;
        if (r13 == null) goto L19;
        y r14 = r13.a;
        if (r14 == null) goto L19;
        r6 = Intrinsics.areEqual(r14.h, Boolean.TRUE);
    L19:
        int r15 = com.larus.bmhome.chat.markdown.imagetool.f.a(r1, r2, r5, r9, Boolean.valueOf(r6), this);
        this.a.b(cd8.a.class, new cd8.a(r15, -1));
        return;
    L13:
        r8 = false;
    L7:
        r5 = null;
        goto L8
    }

    public final void a(e r6, f r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "output");
        this.b = r7;
        setupPassData(r6);
        boolean r8 = com.larus.bmhome.chat.bean.d.j0(r6.b);
        boolean r2 = true;
        if (com.larus.bmhome.chat.bean.d.Q0(r6.b) == true) goto L7;
        if (r8 == false) goto L7;
        boolean r1 = false;
    L8:
        a r0 = new a(r1, r8, Integer.valueOf(r6.b.getMessageStatusLocal()));
        int r9 = ra8.a.a;
        hk9.a r10 = this.a;
        List<jc8.a> r3 = r6.a;
        if (r6.d == false) goto L11;
    L14:
        ra8.a.e(r10, r3, r2);
        this.c = r0;
        return;
    L11:
        if (Intrinsics.areEqual(this.c, r0) == false) goto L14;
        r2 = false;
    L7:
        r1 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        if (getVisibility() != 8) goto L5;
        int r4 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    L6:
        super.onMeasure(r2, r4);
        return;
    L5:
        r4 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 == 0) goto L5;
        return;
    L5:
        c(this);
        requestLayout();
    }
}
