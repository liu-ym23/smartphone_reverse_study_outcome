package x8b;

import android.view.View;
import com.ss.android.lark.contact.base.contact_list.page.ExternalContactFragment2;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ExternalContactFragment2 a;

    public b(ExternalContactFragment2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        g r3 = f.b(this.a);
        if (r3 == null) goto L5;
        r3.g(null);
        return;
    L5:
        this.a.finish();
    }
}
