package y5;

import android.view.ViewGroup;
import com.bytedance.ai.view.popup.RadiusLayout;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements x5.a {
    public final AppletPopupSchemaParam a;
    public final ViewGroup b;
    public final RadiusLayout c;

    @Override // x5.a
    public final void invoke() {
        this.c.setRadiusNew(this.a.getRadius());
    }

    public h(AppletPopupSchemaParam r10, ViewGroup r11, RadiusLayout r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "popupContainer");
        Intrinsics.checkNotNullParameter(r12, "view");
        Intrinsics.checkNotNullParameter(r13, "gravity");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
