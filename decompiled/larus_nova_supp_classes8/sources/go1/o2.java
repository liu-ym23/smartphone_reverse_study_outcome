package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o2 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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
        IMicRoomService r0 = jc1.k.f(IMicRoomService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMicRoomCountDownWidget();
    }

    public o2() {
    }

    public final f70.b getLayerType() {
        return mg2.e.b;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.k1;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        if (d90.c.c(r4) == true) goto L5;
    L11:
        return false;
    L5:
        if (d90.c.q(r4) == null) goto L13;
        Room r5 = d90.c.q(r4);
        if (r5 != null) goto L9;
        return true;
    L9:
        if (r5.isMediaRoom() == true) goto L11;
        return true;
    L13:
        return true;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131380062;
    }
}
