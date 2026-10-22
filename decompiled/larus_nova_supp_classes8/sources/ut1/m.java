package ut1;

import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerUIManager;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.drawer.LiveDrawerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m extends a {
    public final /* synthetic */ k a;

    @Override // ut1.a
    public final IDrawerUIManager getDrawerUIManager() {
        return null;
    }

    @Override // ut1.a
    public final void closeDrawerDialog() {
        DrawerLayout r0 = this.a.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ViewCompat.isAttachedToWindow(r0) == true) goto L7;
    L11:
        this.a.t.H();
        return;
    L7:
        if (r0.isDrawerOpen(8388613) == false) goto L11;
        this.a.getClass();
        LiveDrawerLayout r1 = this.a.a;
        if (r1 == null) goto L14;
        r1.closeDrawer(8388613);
        return;
    }

    @Override // ut1.a
    public final void disableDrawerSlide() {
        k r0 = this.a;
        DrawerLayout r1 = r0.a;
        if (r1 == null) goto L10;
        Intrinsics.checkNotNull(r1);
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L11;
        LiveDrawerLayout r2 = r0.a;
        if (r2 == null) goto L12;
        r2.requestDisallowInterceptTouchEvent(true);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ut1.a
    public final void enterSearch() {
        pa1.a r0 = this.a.e;
        if ((r0 instanceof pa1.a) == false) goto L8;
        if (r0 == null) goto L7;
        r0.OC(true);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.search.api.ILiveSearchFragment");
    }

    @Override // ut1.a
    public final void feedEnd() {
        DouyinLoadingLayout r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public m(k r1) {
        this.a = r1;
    }

    @Override // ut1.a
    public final void setBackgroundByTabType(int r2) {
        if (r2 != 5) goto L7;
        RelativeLayout r3 = this.a.k;
        if (r3 == null) goto L7;
        Intrinsics.checkNotNull(r3);
        r3.setVisibility(0);
        return;
    L7:
        RelativeLayout r4 = this.a.k;
        if (r4 == null) goto L12;
        Intrinsics.checkNotNull(r4);
        r4.setVisibility(4);
        return;
    }

    public final void setInterceptor(ILiveDrawerLayoutInterceptor r2) {
        LiveDrawerLayout r0 = this.a.a;
        if (r0 == null) goto L6;
        r0.setDrawerLayoutInterceptor(r2);
        return;
    }
}
