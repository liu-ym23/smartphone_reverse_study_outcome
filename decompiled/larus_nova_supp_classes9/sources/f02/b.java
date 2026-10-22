package f02;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ View a;

    public b(View r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        a.C0229a r3 = a.h;
        Context r0 = this.a.getContext();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        WindowManager r4 = (WindowManager) r0.getSystemService(WindowManager.class);
        a r1 = a.f;
        if (r1 == null) goto L5;
        r4.removeView(r1);
    L5:
        a.g = false;
    }
}
