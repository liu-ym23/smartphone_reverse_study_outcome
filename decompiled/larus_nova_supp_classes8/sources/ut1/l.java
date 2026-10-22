package ut1;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.getClass();
        k r3 = this.a;
        DrawerLayout r0 = r3.a;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (ViewCompat.isAttachedToWindow(r0) == false) goto L11;
        LiveDrawerLayout r4 = r3.a;
        if (r4 == null) goto L12;
        r4.closeDrawer(8388613);
        return;
    L12:
        return;
    L11:
        return;
    }
}
