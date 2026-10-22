package com.larksuite.component.card.component.udicon;

import android.view.View;
import com.larksuite.component.card.cardcontainer.c;
import com.larksuite.component.card.component.image.UniversalCardRoundedImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ UniversalCardUDIconUI a;
    public final /* synthetic */ UniversalCardRoundedImageView b;

    public b(UniversalCardUDIconUI r1, UniversalCardRoundedImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        Object r3 = this.a.getLynxContext().getSharedData("card_share_data");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larksuite.component.card.cardcontainer.UniversalCardShareData");
        return ((c) r3).c.getDependency().onLongClicked(this.b);
    }
}
