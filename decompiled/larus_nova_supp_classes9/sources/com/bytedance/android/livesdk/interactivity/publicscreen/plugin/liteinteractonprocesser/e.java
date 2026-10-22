package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser;

import com.bytedance.android.live.core.utils.f2;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends a {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final String a() {
        return "ToastProcessor";
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final boolean b(long r4) {
        if (r4 != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public e() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final void c(t42.a r2, com.bytedance.android.live.base.model.liteinteraction.a r3, CompositeDisposable r4) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "actions");
        Intrinsics.checkNotNullParameter(r4, "cd");
        String r5 = r3.e();
        if (r5 != null) goto L5;
        return;
    L5:
        f2.c(r5, 0);
    }
}
