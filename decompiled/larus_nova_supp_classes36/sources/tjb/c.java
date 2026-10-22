package tjb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import rjb.g;
import ujb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends tjb.a {
    public final ujb.d i;
    public final ujb.d j;
    public final Boolean k;

    public static final class a implements f {
        public final /* synthetic */ g a;

        @Override // ujb.f
        public final void close() {
            this.a.close();
        }

        @Override // ujb.f
        public final boolean d() {
            return this.a.isShowing();
        }

        public a(g r1) {
            this.a = r1;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ujb.d a;
        public final /* synthetic */ f b;

        public b(ujb.d r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ujb.d.a r0 = this.a.b;
            Intrinsics.checkNotNull(r3);
            r0.a(r3, this.b);
        }
    }

    /* JADX INFO: renamed from: tjb.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0329c implements View.OnClickListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ f b;

        public ViewOnClickListenerC0329c(c r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ujb.d.a r0 = this.a.j.b;
            Intrinsics.checkNotNull(r3);
            r0.a(r3, this.b);
        }
    }

    @Override // tjb.a
    public final void h() {
    }

    @Override // tjb.a
    public final boolean i() {
        Boolean r0 = this.k;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // tjb.a
    public final f m(g r2) {
        Intrinsics.checkNotNullParameter(r2, "guide");
        return new a(r2);
    }

    public c(WeakReference<Activity> r9, ujb.c r10) {
        Intrinsics.checkNotNullParameter(r9, "activityRef");
        Intrinsics.checkNotNullParameter(r10, "config");
        super(r9, r10.f, r10.g, r10.e, r10.d, r10);
        this.i = r10.h;
        this.j = r10.i;
        this.k = r10.a;
    }

    @Override // tjb.a
    public final View n(Context r8, f r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "bubbleDelegate");
        boolean r2 = true;
        View r10 = LayoutInflater.from(r8).cloneInContext(r8).inflate(2131561507, new FrameLayout(r8), true);
        Intrinsics.checkNotNull(r10);
        FrameLayout r0 = (FrameLayout) r10.findViewById(2131374968);
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        TextView r1 = (TextView) r10.findViewById(2131388772);
        String r4 = null;
        if (r1 == null) goto L19;
        String r5 = this.b;
        if (r5 != null) goto L10;
    L18:
        r1.setVisibility(8);
        goto L19
    L10:
        if (r5.length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L16;
        r5 = null;
    L16:
        if (r5 == null) goto L18;
        r1.setText(r5);
        goto L19
    L12:
        r6 = false;
    L19:
        View r3 = r10.findViewById(2131385249);
        if (r3 == null) goto L22;
        r3.setVisibility(8);
    L22:
        TextView r7 = (TextView) r10.findViewById(2131368879);
        if (r7 == null) goto L35;
        r7.setVisibility(0);
        String r11 = this.c;
        if (r11 != null) goto L27;
    L34:
        r7.setVisibility(8);
        goto L35
    L27:
        if (r11.length() > 0) goto L30;
        r2 = false;
    L30:
        if (r2 == false) goto L32;
        r4 = r11;
    L32:
        if (r4 == null) goto L34;
        r7.setText(r4);
    L35:
        ((TextView) r10.findViewById(2131387335)).setVisibility(8);
        TextView r12 = (TextView) r10.findViewById(2131377737);
        if (r12 == null) goto L41;
        ujb.d r13 = this.i;
        if (r13 == null) goto L40;
        r12.setText(r13.a);
        r12.setOnClickListener(new b(r13, r9));
        r12.setVisibility(0);
        goto L41
    L40:
        r12.setVisibility(8);
    L41:
        TextView r14 = (TextView) r10.findViewById(2131384558);
        if (r14 == null) goto L44;
        r14.setText(this.j.a);
        r14.setOnClickListener(new ViewOnClickListenerC0329c(this, r9));
    L44:
        return r10;
    }
}
