package h2c;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.quicklaunchbar.widget.QuickLaunchBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a implements View.OnClickListener {
    public long a;

    /* JADX INFO: renamed from: h2c.a$a, reason: collision with other inner class name */
    public static final class C0144a {
    }

    static {
    }

    public a() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.a) <= 500) goto L10;
        com.ss.android.lark.quicklaunchbar.widget.a r8 = (com.ss.android.lark.quicklaunchbar.widget.a) this;
        if (r8.b == false) goto L7;
        QuickLaunchBar r2 = r8.c;
        int r3 = QuickLaunchBar.g;
        r2.getClass();
    L8:
        r8.d.getClass();
        this.a = r0;
        return;
    L7:
        QuickLaunchBar r4 = r8.c;
        int r5 = QuickLaunchBar.g;
        r4.getClass();
        goto L8
    }
}
