package rx1;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends a {
    public final WindowManager a;
    public final WindowManager.LayoutParams b;
    public View c;
    public int d;
    public int e;
    public boolean f;

    public f(Context r3) {
        this.f = true;
        this.a = (WindowManager) r3.getSystemService(LiveEndPageData.TAG_WINDOW);
        WindowManager.LayoutParams r4 = new WindowManager.LayoutParams();
        this.b = r4;
        r4.format = 1;
        r4.flags = 552;
        r4.windowAnimations = 0;
    }

    public final void a(int r2, int r3) {
        if (this.f == false) goto L5;
        return;
    L5:
        WindowManager.LayoutParams r0 = this.b;
        r0.x = r2;
        this.d = r2;
        r0.y = r3;
        this.e = r3;
        this.a.updateViewLayout(this.c, r0);
    }
}
