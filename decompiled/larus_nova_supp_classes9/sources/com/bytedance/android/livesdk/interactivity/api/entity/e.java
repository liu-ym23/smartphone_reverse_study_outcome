package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.r;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements r {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ g52.c b;
    public final /* synthetic */ f c;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.r
    public final void onFailed() {
        ALogger.d("PSOperatePanel", "open panel fail");
        boolean r0 = this.c.E(this.b);
        WeakReference r1 = this.a;
        if (r1 == null) goto L5;
        Function1 r2 = (Function1) r1.get();
    L6:
        if (r2 == null) goto L9;
        r2.invoke(Boolean.valueOf(r0));
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.r
    public final void onSuccess() {
        ALogger.d("PSOperatePanel", "success open panel");
        this.c.J("action_sheet");
        WeakReference r0 = this.a;
        if (r0 == null) goto L5;
        Function1 r1 = (Function1) r0.get();
    L6:
        if (r1 == null) goto L9;
        r1.invoke(Boolean.TRUE);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public e(f r1, WeakReference r2, g52.c r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
