package com.bytedance.android.live.revlink.impl.control.dialog;

import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class g<V extends RevInteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {
    public final String b;
    public final V c;

    public final <R> AutoDisposeConverter<R> c() {
        return this.c.T90();
    }

    public g(V r2) {
        this.b = getClass().getSimpleName();
        this.c = r2;
        ((com.bytedance.android.livesdk.common.c) this).a = r2;
    }

    public final void d(Throwable r3) {
        jy0.d.a(6, this.b, r3.getStackTrace());
    }
}
