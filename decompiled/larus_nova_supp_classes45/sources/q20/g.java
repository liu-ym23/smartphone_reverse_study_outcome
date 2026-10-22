package q20;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.debug.mock.HybridHistoryListAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ HybridHistoryListAdapter a;
    public final /* synthetic */ r20.a b;

    public g(HybridHistoryListAdapter r1, r20.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        FragmentActivity r3 = this.a.getContext();
        if (r3 == null) goto L6;
        int r0 = a.a;
        a.a(r3, this.b.c.toString());
        return;
    }
}
