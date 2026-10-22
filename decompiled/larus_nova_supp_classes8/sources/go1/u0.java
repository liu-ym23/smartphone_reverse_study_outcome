package go1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.viewmodule.AnchorStickerWrapperWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.AudienceStickerWrapperWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.StickerWrapperWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u0 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public u0() {
    }

    public final f70.b getLayerType() {
        return mg2.e.b;
    }

    public final Widget l(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        int r0 = StickerWrapperWidget.j;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = ho1.a.d(r3);
        if (r4 == null) goto L5;
        boolean r5 = r4.dg();
    L6:
        if (r5 == false) goto L9;
        return new AnchorStickerWrapperWidget();
    L9:
        return new AudienceStickerWrapperWidget();
    L5:
        r5 = false;
        goto L6
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.g0;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        int r0 = StickerWrapperWidget.j;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r4 = ho1.a.d(r3);
        if (r4 == null) goto L7;
        boolean r1 = true;
        if (r4.dg() != true) goto L7;
    L9:
        return StickerWrapperWidget.b.a(r1);
    L7:
        r1 = false;
        goto L9
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131378275;
    }
}
