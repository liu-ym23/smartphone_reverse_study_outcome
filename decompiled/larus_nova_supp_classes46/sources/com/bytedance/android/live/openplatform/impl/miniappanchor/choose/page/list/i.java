package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ MiniAppChooseListFragment a;

    public i(MiniAppChooseListFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        fp0.c r8 = (fp0.c) r7;
        if ((r8 instanceof fp0.c.C0211c) == false) goto L6;
        MiniAppChooseListFragment.W90(this.a, true);
        ((OpenPlatformFullScreenErrorView) this.a.T90(2131371779)).R5();
        return;
    L6:
        if ((r8 instanceof fp0.c.d) == false) goto L12;
        HashMap<String, zo0.f> r9 = zo0.g.a;
        zo0.f r10 = zo0.h.b(PerformanceScene.CHOOSE_PAGE_LIST);
        int r0 = zo0.f.d;
        r10.l("list_request_data_end", null);
        mp0.a r11 = lp0.b.a(this.a.g);
        if (r11 == null) goto L10;
        mp0.a.c(r11, "success", null, "list", 6);
    L10:
        MiniAppChooseListFragment.W90(this.a, false);
        return;
    L12:
        if ((r8 instanceof fp0.c.a) == false) goto L21;
        mp0.a r12 = lp0.b.a(this.a.g);
        if (r12 == null) goto L16;
        r12.b = false;
    L16:
        mp0.a r13 = lp0.b.a(this.a.g);
        if (r13 == null) goto L19;
        mp0.a.c(r13, "fail", "empty", "list", 4);
    L19:
        MiniAppChooseListFragment.W90(this.a, false);
        ((OpenPlatformFullScreenErrorView) this.a.T90(2131371779)).S5(s1.B(2131920372));
        return;
    L21:
        if ((r8 instanceof fp0.c.b) == false) goto L33;
        mp0.a r1 = lp0.b.a(this.a.g);
        if (r1 == null) goto L25;
        r1.b = false;
    L25:
        mp0.a r2 = lp0.b.a(this.a.g);
        if (r2 == null) goto L28;
        mp0.a.c(r2, "fail", String.valueOf(((fp0.c.b) r8).a), "list", 4);
    L28:
        MiniAppChooseListFragment.W90(this.a, false);
        this.a.T90(2131385224).setVisibility(8);
        ((OpenPlatformFullScreenErrorView) this.a.T90(2131371779)).U5(new h(this));
        return;
    }
}
