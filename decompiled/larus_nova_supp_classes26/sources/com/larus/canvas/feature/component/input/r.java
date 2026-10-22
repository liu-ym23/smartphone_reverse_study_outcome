package com.larus.canvas.feature.component.input;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r implements ICoreInputAbility.e {
    public final /* synthetic */ CanvasInputComponent a;

    public r(CanvasInputComponent r1) {
        this.a = r1;
    }

    public final void h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }

    public final void i(String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        if ((!StringsKt.isBlank(r4)) == true) goto L5;
    L9:
        CanvasInputComponent r0 = this.a;
        r4.getClass();
        this.a.m.getClass();
        r0.getClass();
        this.a.m = r4;
        return;
    L5:
        if (StringsKt.isBlank(this.a.m) == false) goto L9;
        ICoreInputAbility r1 = this.a.Y2();
        if (r1 == null) goto L9;
        r1.g2(3, true);
        goto L9
    }

    public final void j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
    }
}
