package com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter;

import com.bytedance.android.livesdk.link.model.r;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements h {
    public final /* synthetic */ a a;
    public final /* synthetic */ Function1 b;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.h
    public final void onFailed() {
        this.b.invoke(null);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.feed.machine.presenter.h
    public final void a(r r2) {
        this.b.invoke(r2);
        if (r2 == null) goto L8;
        List r3 = r2.getLinkUsers();
        if (r3 == null) goto L9;
        this.a.f.setValue(r3);
        return;
    L9:
        return;
    }

    public d(a r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
