package bt8;

import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpMenuTabContainerWidget;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b0 implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ KmpMenuTabContainerWidget a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public b0(KmpMenuTabContainerWidget r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r7) {
        Object r0 = null;
        if (r7 == null) goto L5;
        Object r8 = r7.getTag();
    L7:
        if ((r8 instanceof Long) == false) goto L9;
        Long r9 = (Long) r8;
    L10:
        if (r9 == null) goto L32;
        long r1 = r9.longValue();
        cq8.f0 r10 = this.a.h;
        if (r10 != null) goto L14;
        return;
    L14:
        Iterator<T> r3 = r10.f.iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        Object r4 = r3.next();
        if (((cq8.g0) r4).c == false) goto L16;
        r0 = r4;
    L20:
        cq8.g0 r2 = (cq8.g0) r0;
        boolean r5 = false;
        if (r2 != null) goto L23;
    L25:
        if (r5 == false) goto L27;
        return;
    L27:
        FLogger.a.i("KmpMenuTabContainerWidget", "[onTabSelected] tabId:" + r1);
        r10.d.a(new cq8.h0(r10.c, r1));
        return;
    L23:
        if (r2.a != r1) goto L25;
        r5 = true;
        goto L25
    L32:
        return;
    L9:
        r9 = null;
        goto L10
    L5:
        r8 = null;
        goto L7
    }
}
