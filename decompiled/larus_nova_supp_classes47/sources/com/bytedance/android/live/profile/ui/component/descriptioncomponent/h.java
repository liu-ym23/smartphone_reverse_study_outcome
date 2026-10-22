package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ com.bytedance.android.live.profit.dress.config.d b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ uu0.b d;

    public h(i r1, com.bytedance.android.live.profit.dress.config.d r2, ConstraintLayout r3, uu0.b r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.d.recordBusinessClick("get_same_dress_button", null);
        String r4 = this.b.getSchema();
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        jc1.k.n(IBaseLiveActionHandler.class).handle(this.c.getContext(), r4);
        this.a.k("livesdk_package_center_get_same_click", this.d);
        return;
    L5:
        if (StringsKt.isBlank(r4) == true) goto L8;
        r0 = false;
        goto L9
    }
}
