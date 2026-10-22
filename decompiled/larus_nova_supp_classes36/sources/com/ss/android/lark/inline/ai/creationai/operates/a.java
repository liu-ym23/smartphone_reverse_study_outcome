package com.ss.android.lark.inline.ai.creationai.operates;

import android.view.View;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ButtonGroupsLinearLayout a;
    public final /* synthetic */ MenuItem b;

    public a(ButtonGroupsLinearLayout r1, MenuItem r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ButtonGroupsLinearLayout.b r3 = this.a.a;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }
}
