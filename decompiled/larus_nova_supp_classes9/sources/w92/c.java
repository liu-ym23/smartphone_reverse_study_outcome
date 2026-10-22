package w92;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.e {
    public final /* synthetic */ a a;
    public final /* synthetic */ q b;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.e
    public final void a(boolean r3) {
        l r0 = com.bytedance.android.livesdk.interactivity.api.q.a();
        if (r0 == null) goto L7;
        PropertyOwner<com.bytedance.android.live.base.model.data.b> r1 = r0.d();
        if (r1 == null) goto L7;
        r1.a(new com.bytedance.android.live.base.model.data.b());
    L7:
        this.a.f = null;
        if (r3 == true) goto L14;
        q r4 = this.b;
        if (r4 == null) goto L12;
        r4.a();
    L12:
        a r5 = this.a;
        r5.h = null;
        r5.i = null;
        return;
    }

    public c(a r1, q r2) {
        this.a = r1;
        this.b = r2;
    }
}
