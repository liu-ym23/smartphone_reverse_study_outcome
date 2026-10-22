package k28;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements c {
    public View a;
    public Context b;

    public b() {
    }

    @Override // k28.c
    public Context getContext() {
        Context r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L5:
        return r0;
    }
}
