package f6;

import com.bytedance.android.scope.j;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements WidgetManager.IWidgetConfigHandler {
    public final j a;

    public e(j r10) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.a = r10;
    }

    public final void onDestroy(Widget r10) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        if ((r10 instanceof b) == true) goto L5;
        r10 = null;
    L5:
        b r11 = (b) r10;
        if (r11 == null) goto L9;
        r11.hp(null);
        return;
    }

    public final void onLoad(Widget r10) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        if ((r10 instanceof b) == true) goto L5;
        r10 = null;
    L5:
        b r11 = (b) r10;
        if (r11 == null) goto L9;
        r11.hp(this.a);
        return;
    }

    public final void onUnload(Widget r10) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        if ((r10 instanceof b) == true) goto L5;
        r10 = null;
    L5:
        b r11 = (b) r10;
        if (r11 == null) goto L9;
        r11.hp(null);
        return;
    }
}
