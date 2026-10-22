package n2c;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class h implements com.ss.android.lark.reaction.widget.detailwindow.scroller.a {
    public final /* synthetic */ com.ss.android.lark.reaction.widget.detailwindow.a a;

    public /* synthetic */ h(com.ss.android.lark.reaction.widget.detailwindow.a r1) {
        this.a = r1;
    }

    public final boolean a(int r2) {
        RecyclerView r0 = this.a.r;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.canScrollVertically(r2);
    }
}
