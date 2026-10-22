package yt1;

import android.view.View;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Deprecated(message = "use IDSLComponent")
public final class g implements k {
    public final View a;

    @Override // yt1.k
    public final void a(com.bytedance.android.livesdk.dsl.recyclerview.i r1) {
    }

    @Override // yt1.k
    public final void b(au1.a r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "lifeType");
    }

    @Override // yt1.k
    public final void c(String r1, Map<String, ? extends Object> r2, int r3) {
    }

    @Override // yt1.k
    public final void release() {
    }

    @Override // yt1.k
    public final View getView() {
        return this.a;
    }

    public g(View r2) {
        Intrinsics.checkNotNullParameter(r2, "mView");
        this.a = r2;
    }
}
