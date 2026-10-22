package com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtLabelViewHolder_ViewBinding implements Unbinder {
    public AtLabelViewHolder a;

    public final void unbind() {
        AtLabelViewHolder r0 = this.a;
        if (r0 == null) goto L7;
        this.a = null;
        r0.mLabelTV = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public AtLabelViewHolder_ViewBinding(AtLabelViewHolder r4, View r5) {
        this.a = r4;
        r4.mLabelTV = (TextView) Utils.findRequiredViewAsType(r5, 2131377093, "field 'mLabelTV'", TextView.class);
    }
}
