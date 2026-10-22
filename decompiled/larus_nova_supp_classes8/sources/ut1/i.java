package ut1;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements DrawerLayout.DrawerListener {
    public final /* synthetic */ LiveDrawerLayout a;

    public i(LiveDrawerLayout r1) {
        this.a = r1;
    }

    public final void onDrawerClosed(View r2) {
        LiveDrawerLayout r3 = this.a;
        r3.d = false;
        r3.getClass();
    }

    public final void onDrawerOpened(View r2) {
        this.a.d = true;
    }

    public final void onDrawerStateChanged(int r2) {
        if (r2 != 0) goto L5;
        LiveDrawerLayout r3 = this.a;
        int r0 = LiveDrawerLayout.g;
        r3.getClass();
        return;
    }

    public final void onDrawerSlide(View r1, float r2) {
        LiveDrawerLayout r3 = this.a;
        int r4 = LiveDrawerLayout.g;
        r3.getClass();
    }
}
