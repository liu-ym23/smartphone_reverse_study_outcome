package go1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.indicator.shortterm.LandscapeShortTermIndicatorWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q1 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.d N() {
        return this;
    }

    public final e70.e O() {
        return this;
    }

    public final e70.f P() {
        return this;
    }

    public final Widget l(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
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

    public q1() {
    }

    public final f70.b getLayerType() {
        return mg2.e.g;
    }

    public final Class<? extends Widget> m() {
        return LandscapeShortTermIndicatorWidget.class;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return l60.a.b();
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.i;
    }

    public final boolean r(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        DataCenter r0 = ((d90.d) r6).h;
        if (r0 == null) goto L5;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
    L7:
        if (r1 == null) goto L12;
        RoomAuthStatus r3 = r1.getRoomAuthStatus();
        if (r3 == null) goto L12;
        if (r3.enableShortTouch() != true) goto L12;
    L17:
        boolean r2 = true;
    L19:
        if (r2 == true) goto L21;
        return false;
    L21:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((d90.d) r6).h) == false) goto L23;
        return false;
    L23:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.b.a(((d90.d) r6).h) == true) goto L38;
        z70.b r4 = ((h70.b) r6).a;
        if (r4 != null) goto L27;
    L32:
        boolean r7 = true;
    L33:
        if (r7 == false) goto L39;
        return true;
    L39:
        return false;
    L27:
        if (r4.k() == false) goto L32;
        ((d90.d) r6).f.getClass();
        if (r4.d(d90.d.a.v0) == false) goto L32;
        r7 = false;
        goto L33
    L38:
        return false;
    L12:
        if (r1 == null) goto L18;
        RoomAuthStatus r8 = r1.getRoomAuthStatus();
        if (r8 == null) goto L18;
        if (r8.enableEnhancedTouch() == true) goto L17;
    L18:
        r2 = false;
        goto L19
    L5:
        r1 = null;
        goto L7
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131386363;
    }
}
