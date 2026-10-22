package y6a;

import android.view.View;
import com.lynx.tasm.behavior.u0;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r implements f {
    public View a;
    public Runnable b;

    public r(UIBody.UIBodyView r1) {
        this.a = r1;
    }

    @Override // y6a.f
    public final void a(u0 r2) {
        UIThreadUtils.runOnUiThreadImmediately(new q(this, r2));
    }
}
