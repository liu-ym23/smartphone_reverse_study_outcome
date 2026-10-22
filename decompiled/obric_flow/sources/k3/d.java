package k3;

import android.view.View;
import com.bytedance.ai.model.p;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.launcher.widget.R$color;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements j3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f18594a;

    public d(AppletPopupSchemaParam r5, View r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "view");
        this.f18594a = r10;
    }

    @Override // j3.a
    public final void invoke() {
        t0.b r5 = p.f2294c;
        if (r5 != null) goto L5;
    L7:
        int r10 = R$color.applet_popup_mask_color_light;
    L8:
        View r11 = this.f18594a;
        r11.setBackgroundColor(r11.getResources().getColor(r10));
        return;
    L5:
        if (r5.isDarkMode() != true) goto L7;
        r10 = R$color.applet_popup_mask_color_dark;
        goto L8
    }
}
