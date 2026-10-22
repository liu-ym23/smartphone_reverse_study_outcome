package go1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeVisibilityControllerWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y1 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.e N() {
        return this;
    }

    public final e70.f O() {
        return this;
    }

    public final Class<? extends Widget> m() {
        return null;
    }

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public y1() {
    }

    public final Widget l(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = ho1.a.i(r6);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r2 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r0);
    L6:
        if (r0 == null) goto L12;
        View r1 = r0.getRootView();
        if (r1 != null) goto L11;
        return null;
    L11:
        return new LandscapeVisibilityControllerWidget(r1, r2, new x1(r6));
    L12:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return l60.a.b();
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.e;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return !com.bytedance.android.livesdk.chatroom.ui.framework.utils.b.a(((d90.d) r3).h);
    }
}
