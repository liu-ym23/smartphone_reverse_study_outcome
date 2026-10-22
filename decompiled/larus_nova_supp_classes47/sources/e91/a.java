package e91;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class a<T> extends com.bytedance.android.live.room.navi.userinfo.cert.d<T> {
    public boolean a;
    public final b b;

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public void b() {
        this.a = false;
        ViewGroup r0 = this.b.getContainer();
        if (r0 == null) goto L5;
        r0.removeAllViews();
        r0.setVisibility(8);
    L5:
        this.b.onUnload();
    }

    public void c() {
        ViewGroup r0 = this.b.getContainer();
        if (r0 == null) goto L9;
        this.b.a();
        r0.setVisibility(8);
        if (r0.getChildCount() <= 0) goto L7;
        r0.removeAllViews();
    L7:
        this.a = false;
        return;
    }

    public a(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }
}
