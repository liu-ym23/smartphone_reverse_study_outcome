package dia;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b1;
import laa.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e extends eia.e {

    public static final class a {
    }

    static {
    }

    @Override // eia.v
    public final void a() {
        FLogger r0 = FLogger.a;
        r0.i("PortraitActionBarStrategy", "applyOrientationChange " + hashCode());
        com.larus.bmhome.chat.component.bottom.core.a r1 = e();
        if (r1 == null) goto L5;
        ViewGroup r2 = r1.p();
    L6:
        boolean r3 = false;
        if (r2 != null) goto L9;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == false) goto L22;
        r0.i("PortraitActionBarStrategy", "showActionBar skipped, inputAboveLayout is visible");
        boolean r5 = true;
    L23:
        j r6 = (j) this.e.getValue();
        if (r6 == null) goto L30;
        b1 r7 = r6.O4();
        if (r7 == null) goto L30;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L30;
        boolean r8 = true;
    L31:
        r0.i("PortraitActionBarStrategy", "isInputAboveLayoutVisible: " + r5 + ", isSpecialInputOpen: " + r8);
        if (r5 == true) goto L34;
        if (r8 == true) goto L34;
    L35:
        if (r3 == false) goto L38;
        c();
        return;
    L38:
        d();
        return;
    L34:
        r3 = true;
    L30:
        r8 = false;
        goto L31
    L22:
        r5 = false;
        goto L23
    L9:
        if (r2.getVisibility() != 0) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == true) goto L14;
    L16:
        boolean r10 = false;
    L17:
        if (r10 != true) goto L19;
        r4 = true;
        goto L20
    L14:
        if (r2.getMeasuredHeight() <= 0) goto L16;
        r10 = true;
        goto L17
    L11:
        r9 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Override // eia.e
    public final void g() {
        FLogger.a.i("PortraitActionBarStrategy", "onSpecialOpen " + hashCode());
        c();
    }

    @Override // eia.e
    public final void f(boolean r4) {
        FLogger.a.i("PortraitActionBarStrategy", "onInputAboveLayoutVisibleChange " + hashCode() + ", visible " + r4);
        if (r4 == false) goto L5;
        c();
        return;
    L5:
        d();
    }

    public e(Context r2, t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
    }
}
