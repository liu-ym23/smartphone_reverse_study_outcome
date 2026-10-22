package com.larus.dora.o.impl.diary.style;

import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.swipeaction.OSwipeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e extends com.obric.oui.swipeaction.b {
    public final /* synthetic */ ODiaryStyleAdapter.StyleViewHolder a;

    public final void onClose() {
        ODiaryStyleAdapter.StyleViewHolder r0 = this.a;
        int r1 = ODiaryStyleAdapter.StyleViewHolder.g;
        OCardListItem r2 = r0.a;
        OStateGradientDrawable r3 = r2.g;
        if (r3 == null) goto L6;
        r3.setSolidColors(r2.getContentContainerBgColor());
    L6:
        r0.a.getContentContainer().setSelected(false);
    }

    public e(ODiaryStyleAdapter.StyleViewHolder r1) {
        this.a = r1;
    }

    public final void c(OSwipeLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        ODiaryStyleAdapter.StyleViewHolder r3 = this.a;
        r3.e.invoke(r3.a);
    }
}
