package com.obric.assistant.settings.autogui;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b1 extends RecyclerView.ViewHolder {
    public final Function2<a, Boolean, Unit> a;
    public final boolean b;
    public final OCardListItem c;
    public final TextView d;

    public final void T3(final c.b r3) {
        Intrinsics.checkNotNullParameter(r3, "row");
        OSwitch r0 = this.c.getEndSwitch();
        if (r0 == null) goto L5;
        r0.setOnCheckedChangeListener(null);
    L5:
        if (r0 == null) goto L7;
        r0.setChecked(r3.b);
    L7:
        if (r0 == null) goto L10;
        r0.setOnCheckedChangeListener(new a1(this, r3));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b1(y0 r2, Function2<? super a, ? super Boolean, Unit> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "saveStoredValue");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r2.a;
        this.d = r2.b;
    }
}
