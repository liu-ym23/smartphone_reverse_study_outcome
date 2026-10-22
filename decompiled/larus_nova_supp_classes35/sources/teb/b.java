package teb;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends RecyclerView.OnScrollListener {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        if (r2 != 0) goto L5;
        d r3 = this.a;
        r3.b.postOnAnimation(r3.f);
        return;
    }
}
