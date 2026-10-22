package com.bytedance.android.live.revlink.link.core.layoutstatus;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements d {
    public final Function0<Unit> a;
    public final Function0<o51.e> b;

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.d
    public final o51.e getUiLayout() {
        return (o51.e) this.b.invoke();
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.d
    public final void requestLayout() {
        this.a.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function0<Unit> r2, Function0<? extends o51.e> r3) {
        Intrinsics.checkNotNullParameter(r2, "requestLayout");
        Intrinsics.checkNotNullParameter(r3, "uiLayoutGetter");
        this.a = r2;
        this.b = r3;
    }
}
