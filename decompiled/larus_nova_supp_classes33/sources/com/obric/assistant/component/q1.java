package com.obric.assistant.component;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class q1 implements Function0 {
    public final /* synthetic */ ObricIntercomComponent a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;

    public /* synthetic */ q1(ObricIntercomComponent r1, boolean r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        ObricIntercomComponent r0 = this.a;
        boolean r1 = this.b;
        String r2 = this.c;
        int r3 = ObricIntercomComponent.h1;
        boolean r4 = r0.p4(true, r1);
        if (r4 == false) goto L10;
        if (r0.X == false) goto L7;
        View r5 = r0.X3();
    L8:
        xga.b.a(r5, r2, "first_frame_ready", new x1());
        goto L10
    L7:
        r5 = r0.d4();
    L10:
        return Boolean.valueOf(r4);
    }
}
