package go1;

import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeSpiltControllerWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t1 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public t1() {
    }

    public final Widget l(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = ho1.a.i(r5);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r1 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r0);
    L7:
        return new LandscapeSpiltControllerWidget(r1, new s1(r5));
    L5:
        r1 = null;
        goto L7
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.d;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        DataCenter r5 = ((d90.d) r4).h;
        int r0 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.b.a;
        if (r5 == null) goto L5;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r5);
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        if (VSMediaUIConfigHelper.b(r5) == true) goto L11;
        return false;
    L11:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(false, r1) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r1 = null;
        goto L7
    }
}
