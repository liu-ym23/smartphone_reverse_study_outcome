package com.ss.android.lark.export;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends SimpleTarget<Drawable> {
    public final /* synthetic */ ColorIcon a;
    public final /* synthetic */ Drawable b;
    public final /* synthetic */ i<Drawable> c;

    public final void onLoadFailed(Drawable r2) {
        super.onLoadFailed(r2);
        if (this.c.isActive() == false) goto L6;
        i<Drawable> r3 = this.c;
        Result.Companion r0 = Result.Companion;
        r3.resumeWith(Result.constructor-impl(this.b));
        return;
    }

    public final void onResourceReady(Object r4) {
        Drawable r5 = (Drawable) r4;
        ColorIcon r0 = this.a;
        if (r0 == null) goto L12;
        ThemeColor r1 = r0.getThemeColor();
        if (r1 == null) goto L12;
        int r2 = com.ss.android.lark.export.entity.preview.a.a(r1, UIHelper.getContext(), null);
        if (r2 == 0) goto L12;
        if (r5 == null) goto L10;
        r5.mutate();
    L10:
        if (r5 == null) goto L12;
        r5.setTint(r2);
    L12:
        if (r5 != null) goto L15;
        r5 = this.b;
    L15:
        if (this.c.isActive() == false) goto L18;
        this.c.resumeWith(Result.constructor-impl(r5));
        return;
    }

    public f(ColorIcon r1, Drawable r2, j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
