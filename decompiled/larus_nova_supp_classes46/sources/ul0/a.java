package ul0;

import android.view.View;
import com.bytedance.android.live.lynx.ui.paidlive.LynxLiveFeature;
import com.bytedance.ies.xelement.live.LynxLiveLight;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LynxLiveFeature a;

    public a(LynxLiveFeature r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LynxLiveFeature r3 = this.a;
        if (r3.m == false) goto L11;
        com.bytedance.ies.xelement.live.a r0 = ((LynxLiveLight) r3).a;
        if (r0 == null) goto L12;
        HashMap<String, Object> r4 = r3.l;
        if (r4 != null) goto L9;
        r4 = new HashMap();
    L9:
        r0.b(r4);
        return;
    L12:
        return;
    }
}
