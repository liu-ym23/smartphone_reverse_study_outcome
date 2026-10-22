package y5;

import android.view.View;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements x5.a {
    public final AppletPopupSchemaParam a;
    public final View b;

    @Override // x5.a
    public final void invoke() {
        if (this.a.getShowMask() == false) goto L5;
        this.b.setVisibility(0);
        this.b.setAlpha(1.0f);
        return;
    L5:
        this.b.setVisibility(0);
        this.b.setAlpha(0.0f);
    }

    public i(AppletPopupSchemaParam r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "view");
        this.a = r10;
        this.b = r11;
    }
}
