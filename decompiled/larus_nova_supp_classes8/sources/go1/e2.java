package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.room.api.IDiscoveryService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e2 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public final Class<? extends Widget> m() {
        IDiscoveryService r0 = jc1.k.f(IDiscoveryService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLiveSceneWidget();
    }

    public e2() {
    }

    public final f70.b getLayerType() {
        return mg2.e.f;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.h;
    }

    public final boolean r(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        DataCenter r0 = ((d90.d) r6).h;
        if (r0 == null) goto L20;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.isMediaRoom() == true) goto L22;
        z70.b r2 = ((h70.b) r6).a;
        if (r2 != null) goto L11;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L23;
        return true;
    L23:
        return false;
    L11:
        if (r2.k() == false) goto L16;
        ((d90.d) r6).f.getClass();
        if (r2.d(d90.d.a.L2) == false) goto L16;
        r7 = false;
        goto L17
    L22:
        return false;
    L20:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131378457;
    }
}
