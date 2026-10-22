package com.bytedance.android.livesdk.gift.platform.business.toolbar;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends lq2.b {
    public final WeakReference<ToolbarGiftBehavior> a;

    public m(WeakReference<ToolbarGiftBehavior> r1) {
        this.a = r1;
    }

    public final void b(Map r1, lq2.c r2) {
        WeakReference<ToolbarGiftBehavior> r3 = this.a;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.get() == null) goto L9;
        this.a.get().s = false;
        return;
    }

    public final boolean a(int r1, Map r2, lq2.c r3) {
        WeakReference<ToolbarGiftBehavior> r4 = this.a;
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.get() == null) goto L10;
        this.a.get().s = true;
        return true;
    L10:
        return false;
    }
}
