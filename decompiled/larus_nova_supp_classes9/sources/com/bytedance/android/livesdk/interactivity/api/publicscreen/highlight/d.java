package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.message.model.b6;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class d implements m {
    public m.a a;
    public b6.b b;
    public final CompositeDisposable c;

    public abstract void d();

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public void release() {
        this.c.clear();
        this.a = null;
    }

    public d() {
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public final void a(m.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m
    public final void b(b6.b r2) {
        Intrinsics.checkNotNullParameter(r2, "triggerInfo");
        this.b = r2;
        d();
    }

    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        b6.b r0 = this.b;
        if (r0 == null) goto L7;
        Map r1 = r0.b();
        if (r1 == null) goto L7;
        return (String) r1.get(r2);
    L7:
        return null;
    }
}
