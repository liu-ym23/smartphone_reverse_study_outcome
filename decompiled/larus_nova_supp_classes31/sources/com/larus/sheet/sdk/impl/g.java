package com.larus.sheet.sdk.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements gm5.a {
    public final /* synthetic */ SheetSdkServiceImplV2 a;

    public final Function1<String, Unit> getOnSelectionShowCallBack() {
        final SheetSdkServiceImplV2 r0 = this.a;
        return new f(r0);
    }

    public g(SheetSdkServiceImplV2 r1) {
        this.a = r1;
    }
}
