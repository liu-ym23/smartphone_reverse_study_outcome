package oe0;

import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends i.a<ILinkPlayerInfoBridge> {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r2) {
        if (r2 == null) goto L5;
        this.a.d(r2);
        return;
    }
}
