package sc;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsets;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f12088a;

    public e(a r8) {
        this.f12088a = r8;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r8, WindowInsets r10) {
        i.f(r8, "v");
        i.f(r10, "insets");
        a r11 = this.f12088a;
        int r12 = ad.a.b(r11.getContext());
        int r13 = ad.a.a(r11.a());
        if (r13 <= 0) goto L10;
        int r14 = r11.f12080o.ordinal();
        if (r14 == 0) goto L9;
        if (r14 != 1) goto L17;
        r8.setPadding(0, 0, 0, r13);
    L17:
        return r10.consumeSystemWindowInsets();
    L9:
        RadiusLayout r15 = r11.a();
        Resources r16 = Resources.getSystem();
        i.e(r16, "Resources.getSystem()");
        defpackage.c.h0(r15, l6.a.I0(TypedValue.applyDimension(1, 16, r16.getDisplayMetrics())) + r13);
        goto L17
    L10:
        int r17 = r11.f12080o.ordinal();
        if (r17 == 0) goto L15;
        if (r17 != 1) goto L17;
        RadiusLayout r18 = r11.a();
        Resources r19 = Resources.getSystem();
        i.e(r19, "Resources.getSystem()");
        defpackage.c.h0(r18, l6.a.I0(TypedValue.applyDimension(1, 0, r19.getDisplayMetrics())));
        r11.a().setPadding(0, 0, 0, r12);
        goto L17
    L15:
        defpackage.c.h0(r11.a(), r12);
        r11.a().setPadding(0, 0, 0, 0);
        goto L17
    }
}
