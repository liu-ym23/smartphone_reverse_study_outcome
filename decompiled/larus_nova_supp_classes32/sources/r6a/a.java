package r6a;

import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements AppBarLayout.OnOffsetChangedListener {
    public final /* synthetic */ q6a.a a;

    public a(q6a.a r1) {
        this.a = r1;
    }

    public final void onOffsetChanged(AppBarLayout r5, int r6) {
        q6a.a r0 = this.a;
        boolean r1 = true;
        if (r6 < 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r5.getTotalScrollRange() + r6) <= 0) goto L10;
        r1 = false;
    L10:
        o6a.a r2 = (o6a.a) r0;
        r2.g = r3;
        r2.h = r1;
        return;
    L5:
        r3 = false;
        goto L7
    }
}
