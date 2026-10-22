package erb;

import android.view.View;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ IItemContainer a;
    public final /* synthetic */ BaseAtBean b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        IItemContainer.a r4 = this.a.a0();
        int r0 = this.a.y0();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r0 != 0) goto L9;
        r4.c(this.b);
        return;
    L9:
        if (this.b.isSelected() == false) goto L11;
        this.b.setSelected(false);
        r4.b(this.b);
        return;
    L11:
        this.b.setSelected(true);
        r4.a(this.b);
    }

    public h(IItemContainer r1, BaseAtBean r2) {
        this.a = r1;
        this.b = r2;
    }
}
