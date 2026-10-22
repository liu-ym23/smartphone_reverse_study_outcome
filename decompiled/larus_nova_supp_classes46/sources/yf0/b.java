package yf0;

import com.bytedance.android.live.liveinteract.linkpanel.contract.BaseTalkInviteListContract$View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b extends e<BaseTalkInviteListContract$View> {
    public abstract void d(boolean r1);

    public abstract void e(ILinkPlayerInfoBridge r1);

    public abstract void f(ILinkPlayerInfoBridge r1);

    public b(BaseTalkInviteListContract$View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }
}
