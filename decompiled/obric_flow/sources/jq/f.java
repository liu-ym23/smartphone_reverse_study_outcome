package jq;

import android.view.View;
import com.obric.common.oui.R$id;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a.a {
    @Override // a.a
    public final void E(Object r5, float r10) {
        View r11 = (View) r5;
        if (r11 == null) goto L15;
        Object r12 = r11.getTag(R$id.o_popover_anim_p);
        if (r12 != null) goto L7;
        return;
    L7:
        if ((r12 instanceof e) == true) goto L10;
        r12 = null;
    L10:
        e r13 = (e) r12;
        if (r13 == null) goto L17;
        r13.f18427a = r10;
        return;
    L17:
        return;
    }

    @Override // a.a
    public final float u(Object r5) {
        View r10 = (View) r5;
        if (r10 == null) goto L15;
        Object r11 = r10.getTag(R$id.o_popover_anim_p);
        if (r11 == null) goto L15;
        Float r12 = null;
        if ((r11 instanceof e) == true) goto L10;
        r11 = null;
    L10:
        e r13 = (e) r11;
        if (r13 == null) goto L13;
        r12 = Float.valueOf(r13.f18427a);
    L13:
        if (r12 == null) goto L15;
        return r12.floatValue();
    L15:
        return 0.0f;
    }
}
