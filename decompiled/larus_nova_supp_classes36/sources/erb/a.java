package erb;

import android.view.View;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AllAtBean a;
    public final /* synthetic */ b b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        IItemContainer.a r3 = this.b.e;
        if (r3 == null) goto L6;
        r3.c(this.a);
        return;
    }

    public a(b r1, AllAtBean r2) {
        this.b = r1;
        this.a = r2;
    }
}
