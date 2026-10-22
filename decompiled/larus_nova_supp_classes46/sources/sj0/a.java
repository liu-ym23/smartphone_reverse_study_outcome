package sj0;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import pn0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final ViewGroup a;
    public final DataCenter b;

    /* JADX INFO: renamed from: sj0.a$a, reason: collision with other inner class name */
    public static final class C0272a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0272a) == false) goto L14;
            C0272a r4 = (C0272a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "LayoutAlignConfig(width = " + this.a + ", height = " + this.b + ", marginLeft = " + this.c + ", marginTop = " + this.d + ')';
        }

        public C0272a(int r1, int r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ f.a b;
        public final /* synthetic */ ViewGroup c;

        public b(a r1, f.a r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            a r0 = this.a;
            f.a r2 = this.b;
            if (r2 == null) goto L5;
            int r3 = r2.c;
        L6:
            f.a r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.d;
        L10:
            f.a r6 = this.b;
            int r7 = 0;
            if (r6 == null) goto L13;
            int r8 = r6.a;
        L14:
            if (r6 == null) goto L16;
            r7 = r6.b;
        L16:
            r0.a(true, new C0272a(r3, r5, r8, r7));
            return;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = this.c.getHeight();
            goto L10
        L5:
            r3 = this.c.getWidth();
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void update() {
        b("update");
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        ALogger.i("MicseatMixer#AnchorPreviewUpdater", "init from ".concat(r4));
        DataCenter r5 = this.b;
        f.a r0 = null;
        if (r5 == null) goto L5;
        m r6 = (m) r5.get("cmd_link_window_layout_config_changed");
    L6:
        if (r6 == null) goto L10;
        f r7 = r6.d;
        if (r7 == null) goto L10;
        r0 = r7.b;
    L10:
        this.a.post(new b(this, r0, (ViewGroup) this.a.findViewById(2131387772)));
        return;
    L5:
        r6 = null;
        goto L6
    }

    public a(ViewGroup r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r2;
        this.b = r3;
    }

    public final void a(boolean r6, C0272a r7) {
        ViewGroup r0 = this.a;
        if ((r0 instanceof ConstraintLayout) == true) goto L5;
        r0 = null;
    L5:
        ConstraintLayout r1 = (ConstraintLayout) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        ConstraintLayout r2 = r1.findViewById(2131387772);
        if (r2 != null) goto L12;
        return;
    L12:
        if ((r2 instanceof ConstraintLayout) == true) goto L14;
        return;
    L14:
        View r3 = r1.findViewById(2131378009);
        if (r3 != null) goto L17;
        return;
    L17:
        ALogger.i("MicseatMixer#AnchorPreviewUpdater", "changeSurfaceViewAlignMode, isSingleMode = " + r6 + ", layoutAlignConfig = " + r7);
        if (r6 == false) goto L28;
        if (r7 == null) goto L29;
        int r4 = r7.a;
        int r5 = -2;
        if (r4 > 0) goto L24;
        r4 = -2;
    L24:
        int r8 = r7.b;
        if (r8 <= 0) goto L27;
        r5 = r8;
    L27:
        ViewGroup.LayoutParams r9 = new ConstraintLayout.LayoutParams(r4, r5);
        ((ConstraintLayout.LayoutParams) r9).leftToLeft = -1;
        ((ConstraintLayout.LayoutParams) r9).topToTop = -1;
        ((ConstraintLayout.LayoutParams) r9).rightToRight = -1;
        ((ConstraintLayout.LayoutParams) r9).bottomToBottom = -1;
        ConstraintLayout r10 = r2;
        r10.setLayoutParams(r9);
        r10.setTranslationX(r7.c);
        r10.setTranslationY(r7.d);
    L29:
        r1.requestLayout();
        return;
    L28:
        ViewGroup.LayoutParams r11 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r11).leftToLeft = r3.getId();
        ((ConstraintLayout.LayoutParams) r11).rightToRight = r3.getId();
        ((ConstraintLayout.LayoutParams) r11).topToTop = r3.getId();
        ((ConstraintLayout.LayoutParams) r11).bottomToBottom = r3.getId();
        ConstraintLayout r12 = r2;
        r12.setLayoutParams(r11);
        r12.setTranslationX(0.0f);
        r12.setTranslationY(0.0f);
        goto L29
    }
}
