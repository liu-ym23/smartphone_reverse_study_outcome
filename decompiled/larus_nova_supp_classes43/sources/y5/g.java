package y5;

import android.view.View;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements x5.a {
    public final View a;

    @Override // x5.a
    public final void invoke() {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        int r10 = 2131100437;
    L10:
        View r11 = this.a;
        r11.setBackgroundColor(r11.getResources().getColor(r10));
        return;
    L9:
        r10 = 2131100438;
        goto L10
    L5:
        if (r0.v(this.a.getContext()) != true) goto L7;
        r1 = true;
        goto L7
    }

    public g(AppletPopupSchemaParam r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "view");
        this.a = r11;
    }
}
