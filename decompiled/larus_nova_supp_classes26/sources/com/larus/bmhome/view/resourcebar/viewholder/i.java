package com.larus.bmhome.view.resourcebar.viewholder;

import com.larus.bmhome.chat.layout.widget.i0;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements i0 {
    public final /* synthetic */ BaseResourceViewHolder.a a;
    public final /* synthetic */ ResourceItemBean b;
    public final /* synthetic */ EntityResourceViewHolder c;

    public final void a() {
        BaseResourceViewHolder.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(this.b.getKey(), 107, this.c.b.s);
        return;
    }

    public final void b() {
        BaseResourceViewHolder.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(this.b.getKey(), 108, this.c.b.s);
        return;
    }

    public i(lt8.a r1, ResourceItemBean r2, EntityResourceViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
