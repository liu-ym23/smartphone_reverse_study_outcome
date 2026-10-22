package hv1;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdk.config.av;
import com.bytedance.android.livesdkapi.explore.ILiveExploreLynxFragmentCreator;
import com.bytedance.android.livesdkapi.explore.LiveExploreLynxCallback;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements ILiveExploreLynxFragmentCreator {
    public HybridFragment a;
    public final boolean b;
    public final LiveExploreLynxCallback c;

    /* JADX INFO: renamed from: hv1.a$a, reason: collision with other inner class name */
    public static final class C0391a {
    }

    static {
    }

    public final void callPauseLiveBridge() {
        HybridFragment r0 = this.a;
        if (r0 == null) goto L6;
        r0.sendJsEvent("webcast.discover.pause", new Object());
        return;
    }

    public final void callPlayLiveBridge() {
        HybridFragment r0 = this.a;
        if (r0 == null) goto L6;
        r0.sendJsEvent("webcast.discover.play", new Object());
        return;
    }

    public final boolean isTop() {
        HybridFragment r0 = this.a;
        if (r0 == null) goto L16;
        LynxView r1 = r0.getHybridView();
        if ((r1 instanceof LynxView) == false) goto L10;
        View r2 = r1.findViewByName("page-list");
        if ((r2 instanceof RecyclerView) == false) goto L10;
        return !r2.canScrollVertically(-1);
    L10:
        if (r1 != null) goto L12;
    L14:
        return false;
    L12:
        if (r1.getScrollY() != 0) goto L14;
        return true;
    L16:
        return true;
    }

    public final void release() {
        HybridFragment r0 = this.a;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.a = null;
    }

    public final Fragment createLiveWebFragment() {
        return this.a;
    }

    public final Fragment createLiveLynxFragment(Context r9) {
        if (this.a != null) goto L31;
        av r0 = av.a;
        String r1 = r0.getValue().b();
        boolean r3 = false;
        if (r1.length() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        Uri r4 = null;
    L25:
        if (r4 == null) goto L31;
        if (r9 == null) goto L31;
        HybridFragment r10 = k.n(IBrowserService.class).getHybridFragment(r9, r4, new b(this));
        if (r10 == null) goto L31;
        this.a = r10;
        goto L31
    L10:
        Uri.Builder r5 = UriProtector.parse(r1).buildUpon();
        String r6 = "dark";
        if (this.b == false) goto L13;
        String r7 = "dark";
    L14:
        r5.appendQueryParameter("model", r7);
        Uri.Builder r8 = x6.a.d(r5.toString()).buildUpon();
        String r11 = r0.getValue().a();
        if (r11.length() != 0) goto L17;
        r3 = true;
    L17:
        if (r3 == false) goto L19;
        String r12 = "";
    L24:
        r4 = r8.appendQueryParameter("fallback_url", r12).appendQueryParameter("hide_nav_bar", String.valueOf(1)).build();
        goto L25
    L19:
        Uri.Builder r13 = UriProtector.parse(r11).buildUpon();
        if (this.b == true) goto L23;
        r6 = "dawn";
    L23:
        r13.appendQueryParameter("model", r6);
        r12 = r13.toString();
        goto L24
    L13:
        r7 = "dawn";
        goto L14
    L7:
        r2 = false;
    L31:
        return this.a;
    }

    public a(boolean r2, LiveExploreLynxCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "mLiveExploreLyncCallback");
        this.b = r2;
        this.c = r3;
    }
}
