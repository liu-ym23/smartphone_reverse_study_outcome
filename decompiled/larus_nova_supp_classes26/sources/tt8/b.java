package tt8;

import android.view.View;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import ut8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends k implements st8.b.InterfaceC0134b {
    public final TextView D;
    public st8.b.c E;

    public static final class a {
    }

    static {
    }

    @Override // ut8.b
    public final void i() {
        FLogger.a.i("SelectorTextView", "hideSelectView, callback=" + this.E);
        super.i();
        st8.b.c r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(true);
        return;
    }

    @Override // ut8.k, ut8.b
    public final void j() {
        FLogger.a.i("SelectorTextView", "onTouchOutside, callback=" + this.E);
        st8.b.c r0 = this.E;
        if (r0 == null) goto L6;
        r0.a(false);
        return;
    }

    @Override // ut8.b
    public final void o() {
        l();
        if (q(g(), this.l) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        st8.b.c r1 = this.E;
        if (r1 == null) goto L15;
        r1.onShow();
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (q(g(), this.m) == true) goto L8;
        r0 = false;
        goto L9
    }

    public b(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        super(r2);
        this.D = r2;
    }

    public final void s(int[] r6) {
        Intrinsics.checkNotNullParameter(r6, "outArr");
        View r0 = this.D.getRootView();
        int r1 = ((this.y + this.A) / 2) - (r0.getMeasuredWidth() / 2);
        int r2 = this.z;
        if (r2 == this.B) goto L5;
        r1 = 0;
    L5:
        r6[0] = r1;
        r6[1] = r2;
        r6[2] = this.C;
    }
}
