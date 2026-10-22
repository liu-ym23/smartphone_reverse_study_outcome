package n62;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.depend.IShareMsgCallback;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements IShareMsgCallback {
    public final /* synthetic */ c a;
    public final /* synthetic */ s22.a b;

    public final void onSuccess() {
        boolean r0 = false;
        a.e = false;
        f2.b(2131915712, 0);
        c r1 = this.a;
        a.b(r1.g, this.b, r1.h);
        LinkedHashMap r2 = new LinkedHashMap();
        int r3 = j.a;
        c r4 = this.a;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r5 = r4.i;
        if (r5 != null) goto L5;
    L7:
        j.f("channel_create", r0, r2, r4.h);
        return;
    L5:
        if (r5.c != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void onFail() {
        boolean r0 = a.d;
        a.e = false;
    }

    public b(c r1, s22.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
