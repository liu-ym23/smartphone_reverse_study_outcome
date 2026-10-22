package com.larksuite.component.card.component.image;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ UniversalCardLynxImageUI a;
    public final /* synthetic */ UniversalCardRoundedImageView b;

    public c(UniversalCardLynxImageUI r1, UniversalCardRoundedImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        Object r3 = this.a.getLynxContext().getSharedData("card_share_data");
        if ((r3 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L5;
        com.larksuite.component.card.cardcontainer.c r4 = (com.larksuite.component.card.cardcontainer.c) r3;
    L6:
        if (r4 != null) goto L10;
        return false;
    L10:
        return r4.c.getDependency().onLongClicked(this.b);
    L5:
        r4 = null;
        goto L6
    }
}
