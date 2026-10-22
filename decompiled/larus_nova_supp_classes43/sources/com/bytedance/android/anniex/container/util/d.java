package com.bytedance.android.anniex.container.util;

import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.anniex.container.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Function0<Unit> {
    public final /* synthetic */ AnnieXContainer a;

    public final Object invoke() {
        this.a.reload(null);
        return Unit.INSTANCE;
    }

    public d(n r1) {
        this.a = r1;
    }
}
