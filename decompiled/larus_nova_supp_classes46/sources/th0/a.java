package th0;

import com.bytedance.android.live.liveinteract.plantform.widgt.videolink.MultiLinkVideoBaseGuestLinkWidget;
import tf0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements q {
    public final /* synthetic */ MultiLinkVideoBaseGuestLinkWidget a;
    public final /* synthetic */ sf0.a b;

    @Override // tf0.q
    public final void a() {
    }

    @Override // tf0.q
    public final void b() {
        MultiLinkVideoBaseGuestLinkWidget r0 = this.a;
        r0.y = this.b.b;
        xf6.b r1 = r0.Tq();
        if (r1 == null) goto L6;
        r1.apply(this.b);
        return;
    }

    public a(MultiLinkVideoBaseGuestLinkWidget r1, sf0.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
