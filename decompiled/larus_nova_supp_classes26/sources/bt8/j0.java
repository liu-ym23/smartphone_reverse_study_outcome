package bt8;

import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpTabSelectorWidget;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j0 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ KmpTabSelectorWidget a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public j0(KmpTabSelectorWidget r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r5) {
        Long r0 = null;
        if (r5 == null) goto L5;
        Object r6 = r5.getTag();
    L7:
        if ((r6 instanceof Long) == false) goto L9;
        r0 = (Long) r6;
    L9:
        if (r0 == null) goto L15;
        long r1 = r0.longValue();
        FLogger.a.i("KmpTabSelectorWidget", "[onTabSelected] tabOptionId:" + r1);
        cq8.r0 r7 = this.a.g;
        if (r7 != null) goto L13;
        return;
    L13:
        r7.d.a(new cq8.s0(r7.c, r1));
        return;
    L15:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
