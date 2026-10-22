package com.ss.android.lark.export;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends SimpleTarget<Drawable> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Drawable b;
    public final /* synthetic */ i<Drawable> c;

    public final void onResourceReady(Object r3) {
        Drawable r4 = (Drawable) r3;
        super.onResourceReady(r4);
        if (r4 == null) goto L5;
        r4.mutate();
        r4.setTint(UDColorUtils.getColor(this.a, 2131105568));
    L5:
        if (r4 != null) goto L8;
        r4 = this.b;
    L8:
        if (this.c.isActive() == false) goto L11;
        this.c.resumeWith(Result.constructor-impl(r4));
        return;
    }

    public g(Context r1, Drawable r2, j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
