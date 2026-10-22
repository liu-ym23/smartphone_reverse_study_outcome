package kf0;

import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends hf0.b {
    public static final /* synthetic */ int d = 0;
    public final IRoom c;

    static {
    }

    public f(InteractAudienceInviteContract$View r1, IRoom r2) {
        super(r1);
        this.c = r2;
    }

    @Override // hf0.b
    public final void d(int r18, String r19) {
        if (this.c != null) goto L5;
        return;
    L5:
        if (vm2.d.k() == false) goto L7;
        long r1 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getInviteList(this.c.getId(), 1).as(c())).subscribe(new c(this, r1), new d(this, r1));
        return;
    L7:
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getPageList(this.c.getId(), d5.c(this.c.getOwnerUserIdString()), this.c.getOwnerUserIdString(), 1, r18, 0, false, "", 0, "", r19).as(c())).subscribe(new b(this), new e(this));
    }
}
