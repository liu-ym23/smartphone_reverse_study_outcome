package ut1;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements pa1.d {
    public final /* synthetic */ k a;
    public final /* synthetic */ ViewGroup b;
    public final /* synthetic */ float c;

    public final void closeDrawerDialog() {
        DrawerLayout r0 = this.a.a;
        if (r0 == null) goto L11;
        Intrinsics.checkNotNull(r0);
        if (ViewCompat.isAttachedToWindow(r0) == false) goto L11;
        LiveDrawerLayout r1 = this.a.a;
        Intrinsics.checkNotNull(r1);
        if (r1.isDrawerOpen(8388613) == false) goto L11;
        this.a.getClass();
        LiveDrawerLayout r2 = this.a.a;
        if (r2 == null) goto L13;
        r2.closeDrawer(8388613);
        return;
    L13:
        return;
    L11:
        this.a.t.H();
    }

    public final int getContainerWidth() {
        ViewGroup r0 = this.b;
        if (r0 == null) goto L6;
        return r0.getWidth();
    L6:
        return UIUtils.getScreenWidth(this.a.getContext()) - s1.f(this.c);
    }

    public final void a(boolean r3) {
        if (r3 == false) goto L4;
        k r4 = this.a;
        r4.b(r4.d, r4.e);
        return;
    L4:
        k r5 = this.a;
        r5.b(r5.e, r5.d);
    }

    public final void b(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        if (this.a.q == null) goto L5;
        r3.putInt("back_source", 6);
    L5:
        Activity r0 = this.a.getActivity();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.helper.a.b(r0, this.a.q, r3);
        r3.putBoolean("data_back_to_pre_room_countdown_dismiss", false);
        return;
    }

    public n(k r1, ViewGroup r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
