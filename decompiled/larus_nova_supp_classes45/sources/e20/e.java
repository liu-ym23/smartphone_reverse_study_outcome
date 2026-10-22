package e20;

import android.view.View;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ a20.e a;
    public final /* synthetic */ View b;
    public final /* synthetic */ f10.f c;
    public final /* synthetic */ int d;

    public e(a20.e r1, View r2, f10.f r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (this.a != null) goto L5;
        LocalTestManager.a(new Class[]{wy.a.class});
    L5:
        a20.e r6 = this.a;
        if (r6 == null) goto L9;
        r6.a(this.b, this.c, this.d, null);
        return;
    }
}
