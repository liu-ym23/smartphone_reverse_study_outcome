package ue0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.w0;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ d a;

    public e(d r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
        Intrinsics.checkNotNullParameter(r5, "response");
        List<k> r0 = ((w0) r5.data).getMPlayerInfo();
        if (r0 == null) goto L5;
        ArrayList<ILinkPlayerInfoBridge> r1 = je0.d.f0(r0, false);
    L6:
        ClientUIInfo r2 = ((w0) r5.data).getClientUiInfo();
        this.a.f(r1, r2);
        this.a.e(((w0) r5.data).getPositions());
        return;
    L5:
        r1 = new ArrayList();
        goto L6
    }
}
