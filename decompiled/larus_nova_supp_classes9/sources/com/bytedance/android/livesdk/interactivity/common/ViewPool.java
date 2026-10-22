package com.bytedance.android.livesdk.interactivity.common;

import android.widget.ImageView;
import androidx.core.util.Pools;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/ViewPool;", "Landroidx/core/util/Pools$Pool;", "Landroid/widget/ImageView;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPool implements Pools.Pool<ImageView> {
    public final int a;
    public final ImageView[] b;
    public int c;

    public final ImageView a() {
        int r0 = this.c;
        if (r0 <= 0) goto L9;
        int r2 = r0 - 1;
        if (r2 < this.a) goto L7;
        return null;
    L7:
        ImageView[] r3 = this.b;
        ImageView r4 = r3[r2];
        r3[r2] = null;
        this.c = r0 - 1;
        return r4;
    L9:
        return null;
    }

    public final /* bridge */ /* synthetic */ Object acquire() {
        return a();
    }

    public ViewPool(int r1) {
        this.a = r1;
        this.b = new ImageView[r1];
    }

    public final boolean b(ImageView r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        int r0 = this.c;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L9;
        if (this.b[r2] == r6) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return false;
    L12:
        int r3 = this.c;
        if (r3 >= this.a) goto L16;
        this.b[r3] = r6;
        this.c = r3 + 1;
        r6.setVisibility(8);
        return true;
    L16:
        return false;
    L9:
        r1 = false;
        goto L10
    }

    public final /* bridge */ /* synthetic */ boolean release(Object r1) {
        return b((ImageView) r1);
    }
}
