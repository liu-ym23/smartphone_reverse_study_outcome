package ppc;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements e {
    public static final b a = null;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ g a;
        public final /* synthetic */ OnCustomForwardConfirmDialogContentView b;

        public a(g r1, OnCustomForwardConfirmDialogContentView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (this.a.d.getDialogContent().k == false) goto L6;
            OnCustomForwardConfirmDialogContentView r0 = this.b;
            Activity r1 = this.a.getActivity();
            Fragment r2 = this.a.b;
            Intrinsics.checkNotNull(r4);
            r0.p(r1, r2, r4);
            return;
        }
    }

    static {
        a = new b();
    }

    public b() {
    }

    @Override // ppc.e
    public final boolean a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        OnCustomForwardConfirmDialogContentView r3 = r2.d.getCustomConfirmDialogContentView();
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.n1() != true) goto L7;
        return true;
    }

    @Override // ppc.e
    public final boolean b(g r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        OnCustomForwardConfirmDialogContentView r0 = r7.d.getCustomConfirmDialogContentView();
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.n1() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        r7.c.setBackground(null);
        ConstraintLayout r2 = new ConstraintLayout(r7.getActivity());
        r2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r7.c.addView(r2);
        r0.E1(r7.getActivity(), r2, r7.d.getDialogContent(), new c());
        r2.setOnClickListener(new a(r7, r0));
        r7.c.setVisibility(0);
        return true;
    }
}
