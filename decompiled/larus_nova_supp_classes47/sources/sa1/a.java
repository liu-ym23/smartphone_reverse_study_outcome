package sa1;

import android.view.View;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchHistoryAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ qa1.b b;

    public a(boolean r1, LiveSearchHistoryAdapter.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (this.a == false) goto L5;
        this.b.a();
        return;
    L5:
        this.b.deleteAll();
    }
}
