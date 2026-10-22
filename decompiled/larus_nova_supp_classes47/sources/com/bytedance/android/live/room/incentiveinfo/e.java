package com.bytedance.android.live.room.incentiveinfo;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements u81.f.a {
    public final /* synthetic */ u81.f a;
    public final /* synthetic */ IncentiveInfoLayout b;
    public final /* synthetic */ View c;

    @Override // u81.f.a
    public final void a() {
        x81.b<u81.d> r0 = this.b.getItemHolderPool();
        if (r0 == null) goto L35;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= 99) goto L12;
        if (r0.a[r2] == null) goto L10;
        r3 = r3 + 1;
    L10:
        r2 = r2 + 1;
        goto L6
    L12:
        if (Intrinsics.areEqual(this.b.d, this.a) == false) goto L36;
        WeakReference<View> r4 = this.b.c;
        if (r4 == null) goto L16;
        View r5 = r4.get();
    L18:
        if (Intrinsics.areEqual(r5, this.c) == true) goto L20;
        return;
    L20:
        if (r3 <= 1) goto L38;
        ALogger.d("IncentiveInfoLayout", "show next carousel holder");
        IncentiveInfoLayout r6 = this.b;
        int r7 = r6.b + 1;
        if (r7 < 0) goto L30;
        u81.c<? extends Object, ? extends u81.d> r8 = r6.getAdapter();
        if (r8 == null) goto L26;
        int r9 = r8.getItemSize();
    L27:
        if (r7 >= r9) goto L30;
        r1 = r7;
        goto L30
    L26:
        r9 = 0;
    L30:
        r6.c(r1, true);
        return;
    L38:
        return;
    L16:
        r5 = null;
        goto L18
    L36:
        return;
    }

    public e(u81.f r1, IncentiveInfoLayout r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
