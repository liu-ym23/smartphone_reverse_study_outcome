package y8b;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnFocusChangeListener {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        if (r2 == false) goto L5;
        Statistics.sendEvent("addressbook_search_click", InvHitPoint.a());
        return;
    }
}
