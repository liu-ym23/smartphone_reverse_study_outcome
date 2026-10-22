package tjb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.view.BubbleLayout;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import rjb.g;
import ujb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends tjb.a {
    public final ujb.e i;
    public final Boolean j;
    public Rect k;

    public static final class a {
    }

    public static final class b implements f {
        public final /* synthetic */ g a;

        @Override // ujb.f
        public final void close() {
            this.a.close();
        }

        @Override // ujb.f
        public final boolean d() {
            return this.a.isShowing();
        }

        public b(g r1) {
            this.a = r1;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ f b;

        public c(d r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.i.i;
            if (r2 == null) goto L5;
            r2.invoke();
        L5:
            this.b.close();
        }
    }

    static {
    }

    @Override // tjb.a
    public final void h() {
    }

    @Override // tjb.a
    public final boolean i() {
        Boolean r0 = this.j;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    @Override // tjb.a
    public final Rect l() {
        Rect r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return tjb.a.h;
    }

    @Override // tjb.a
    public final int j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ContextCompat.getColor(r2, 2131102028);
    }

    @Override // tjb.a
    public final int k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return UIUtils.dp2px(r2, 12.0f);
    }

    @Override // tjb.a
    public final f m(g r2) {
        Intrinsics.checkNotNullParameter(r2, "guide");
        return new b(r2);
    }

    public d(WeakReference<Activity> r9, ujb.e r10) {
        Intrinsics.checkNotNullParameter(r9, "activityRef");
        Intrinsics.checkNotNullParameter(r10, "config");
        super(r9, r10.f, r10.g, r10.e, r10.d, r10);
        this.i = r10;
        this.j = r10.a;
    }

    @Override // tjb.a
    public final View n(Context r9, f r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "bubbleDelegate");
        boolean r2 = false;
        View r11 = LayoutInflater.from(r9).inflate(2131561508, null, false);
        LinearLayout r0 = (LinearLayout) r11;
        int r1 = 2131366972;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r11, 2131366972);
        if (r3 == null) goto L35;
        r1 = 2131368879;
        AppCompatTextView r4 = ViewBindings.findChildViewById(r11, 2131368879);
        if (r4 == null) goto L35;
        r1 = 2131388772;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r11, 2131388772);
        if (r5 == null) goto L35;
        r1 = 2131388787;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r11, 2131388787);
        if (r6 == null) goto L35;
        String r12 = this.b;
        if (r12 != null) goto L13;
    L14:
        r2 = true;
    L15:
        boolean r7 = true ^ r2;
        boolean r8 = this.i.h;
        if (r7 == true) goto L19;
        if (r8 == true) goto L19;
        r6.setVisibility(8);
    L25:
        r4.setText(this.c);
        Integer r13 = this.i.j;
        if (r13 == null) goto L28;
        r4.setMaxWidth(r13.intValue());
    L28:
        Integer r14 = this.i.k;
        if (r14 == null) goto L31;
        int r15 = r14.intValue();
    L32:
        r4.getViewTreeObserver().addOnPreDrawListener(new e(r4, r15));
        return r0;
    L31:
        r15 = 2;
    L19:
        if (r7 == false) goto L21;
        r5.setText(r12);
    L22:
        if (r8 == false) goto L24;
        r3.setOnClickListener(new c(this, r10));
        goto L25
    L24:
        r3.setVisibility(8);
        goto L25
    L21:
        r5.setVisibility(8);
        goto L22
    L13:
        if (r12.length() != 0) goto L15;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r1)));
    }

    @Override // tjb.a
    public final View p(Context r13, BubbleLayout r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "layout");
        int r0 = UIUtils.dp2px(r13, 12.0f);
        int r1 = UIUtils.dp2px(r13, 4.0f);
        this.k = new Rect(r0, RangesKt.coerceAtLeast(r0 - r1, 0), r0, r0 + r1);
        vjb.a r2 = new vjb.a(r13, ContextCompat.getColor(r13, 2131102028), k(r13), r1, r0, ContextCompat.getColor(r13, 2131101965));
        r2.addView(r14);
        return r2;
    }
}
