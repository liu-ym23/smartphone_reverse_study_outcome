package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o1 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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
        return r0.getMicRoomAnchorWidget();
    }

    public o1() {
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
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.w;
    }

    public final boolean r(h70.b r6) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r7 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(r7);
        if (r0 == null) goto L33;
        Room r2 = r0.getRoom();
        if (r2 == null) goto L34;
        z70.b r8 = ((h70.b) r7).a;
        if (r8 != null) goto L11;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L19;
        return false;
    L19:
        if (r0.o5() == true) goto L21;
        return false;
    L21:
        if (r2.isMediaRoom() == true) goto L30;
        IMicRoomService r10 = jc1.k.f(IMicRoomService.class);
        if (r10 != null) goto L25;
        return false;
    L25:
        if (r10.isMicRoom(r2) != true) goto L32;
        return true;
    L32:
        return false;
    L30:
        return false;
    L11:
        if (r8.k() == false) goto L16;
        if (r8.d(d90.d.a.L2) == false) goto L16;
        r9 = false;
        goto L17
    L34:
        return false;
    L33:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131377127;
    }
}
