package go1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.widget.BroadcastPauseStateLandscapeWidget;
import com.bytedance.android.livesdk.chatroom.widget.BroadcastPauseStateWidget;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d2 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final com.bytedance.android.livesdk.config.w0 c;

    public final e70.d N() {
        return this;
    }

    public final e70.e O() {
        return this;
    }

    public final e70.f P() {
        return this;
    }

    public final Class<? extends Widget> m() {
        return null;
    }

    public final ViewGroup q(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
        return null;
    }

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public d2() {
        this.c = (com.bytedance.android.livesdk.config.w0) h21.c.getValue();
    }

    public final f70.b getLayerType() {
        return mg2.e.b;
    }

    public final Widget l(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = ho1.a.d(r3);
        if (r4 == null) goto L5;
        boolean r5 = r4.isPortrait();
    L6:
        if (r5 == false) goto L9;
        return new BroadcastPauseStateWidget();
    L9:
        return new BroadcastPauseStateLandscapeWidget();
    L5:
        r5 = true;
        goto L6
    }

    public final boolean o(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (d90.c.i(r3) == true) goto L7;
        return true;
    L7:
        return k60.b.a();
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.m0;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        com.bytedance.android.livesdk.config.w0 r0 = this.c;
        if (r0 != null) goto L5;
    L10:
        return true;
    L5:
        if (r0.a() == false) goto L10;
        if (d90.c.c(r3) == true) goto L10;
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131364575;
    }
}
