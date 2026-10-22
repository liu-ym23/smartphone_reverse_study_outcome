package go1;

import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.AnchorPortraitGestureWidget;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.AudienceLandscapeGestureWidget;
import com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.AudiencePortraitGestureWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g1 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public g1() {
    }

    public final Widget l(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = ho1.a.d(r4);
        if (r5 != null) goto L5;
    L7:
        if (r5 != null) goto L9;
    L11:
        if (r5 == null) goto L16;
        if (r5.V9() != true) goto L16;
        return new AudiencePortraitGestureWidget();
    L16:
        return new AudiencePortraitGestureWidget();
    L9:
        if (r5.o5() != true) goto L11;
        return new AudienceLandscapeGestureWidget();
    L5:
        if (r5.dg() != true) goto L7;
        return new AnchorPortraitGestureWidget();
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.J0;
    }

    public final boolean r(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }
}
