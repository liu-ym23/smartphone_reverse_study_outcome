package com.ss.android.lark.chat.preview.components;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.chat.preview.entity.component.Direction;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.tangram.base.style.TCStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x extends SimpleTarget<BitmapDrawable> {
    public final /* synthetic */ w a;
    public final /* synthetic */ UDButton b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Direction d;

    public final void onLoadFailed(Drawable r2) {
        super.onLoadFailed(r2);
        this.b.setText(this.c);
        Log.i("ButtonComponent", "onLoadFailed: ");
    }

    public final void onResourceReady(Object r5) {
        BitmapDrawable r6 = (BitmapDrawable) r5;
        Intrinsics.checkNotNullParameter(r6, "resource");
        super.onResourceReady(r6);
        TCStyle r0 = ((q6c.b) this.a).c;
        if ((r0 instanceof Style) == false) goto L5;
        Style r1 = (Style) r0;
    L6:
        if (r1 == null) goto L10;
        ThemeColor r2 = r1.getTextColorV2();
        if (r2 == null) goto L10;
        UDButton r3 = this.b;
        r6.mutate();
        r6.setTint(com.ss.android.lark.export.entity.preview.a.a(r2, r3.getContext(), null));
    L10:
        Integer r4 = this.a.f;
        if (r4 == null) goto L13;
        int r7 = r4.intValue();
    L14:
        Integer r8 = this.a.g;
        if (r8 == null) goto L17;
        int r9 = r8.intValue();
    L18:
        r6.setBounds(0, 0, r7, r9);
        w r10 = this.a;
        UDButton r11 = this.b;
        String r12 = this.c;
        Direction r13 = this.d;
        r10.getClass();
        w.k(r11, r12, r13, r6);
        return;
    L17:
        r9 = 0;
        goto L18
    L13:
        r7 = 0;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public x(w r1, UDButton r2, String r3, Direction r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
