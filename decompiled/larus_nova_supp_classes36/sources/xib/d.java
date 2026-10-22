package xib;

import android.view.View;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ e<SearchBaseInfo> a;
    public final /* synthetic */ SearchBaseInfo b;
    public final /* synthetic */ int c;

    public d(e<SearchBaseInfo> r1, SearchBaseInfo r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.c.a(this.b) == false) goto L6;
        return;
    L6:
        if (this.a.a == false) goto L8;
        SearchBaseInfo r5 = this.b;
        r5.selected(true ^ r5.isSelected());
    L9:
        RecentForwardAdapterV3.b r6 = this.a.b;
        SearchBaseInfo r0 = this.b;
        r6.a(r0, this.c, r0.isSelected());
        return;
    L8:
        this.b.selected(true);
        goto L9
    }
}
