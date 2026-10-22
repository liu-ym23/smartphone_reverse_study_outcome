package com.larus.share.impl.util;

import android.content.Context;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.camera.impl.ui.viewmodel.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function2 c;

    public /* synthetic */ b(Context r1, String r2, b0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r5) {
        Context r0 = this.a;
        String r1 = this.b;
        final Function2 r2 = this.c;
        if (((Boolean) r5).booleanValue() == false) goto L6;
        ImageSave.s(ImageSave.a, r0, r1, new d(r2));
    L6:
        return Unit.INSTANCE;
    }
}
