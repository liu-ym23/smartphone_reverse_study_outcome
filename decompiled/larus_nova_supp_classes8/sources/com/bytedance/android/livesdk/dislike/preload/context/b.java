package com.bytedance.android.livesdk.dislike.preload.context;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.preload.datamanager.LLPanelPreprocessor$session$2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.revenue.platform.api.core.rx.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements com.bytedance.android.livesdk.dislike.preload.context.a {
    public final ActionsManager a;
    public final Fragment b;
    public final n<Boolean> c;
    public final n d;
    public final DataCenter e;
    public final a f;

    public interface a {
        void a();
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.context.a
    public final void a() {
        this.f.a();
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.context.a
    public final ActionsManager b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.context.a
    public final n c() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.context.a
    public final DataCenter getDataCenter() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.context.a
    public final Fragment getFragment() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.dislike.preload.context.a
    public final void d(boolean r2) {
        this.c.a(Boolean.valueOf(r2));
    }

    public b(DataCenter r2, LLPanelPreprocessor$session$2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "cb");
        this.e = r2;
        this.f = r3;
        this.a = r3.b();
        this.b = r3.c();
        n<Boolean> r4 = new n(Boolean.FALSE, LongPressPanelSession$_onDialogShow$1.INSTANCE);
        this.c = r4;
        this.d = r4;
    }
}
