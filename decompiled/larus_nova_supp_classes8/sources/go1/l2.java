package go1;

import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l2 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.e N() {
        return this;
    }

    public final e70.f O() {
        return this;
    }

    public final Widget l(h70.b r2) {
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
        return r0.getMicRoomAnchorGrabMicWidget();
    }

    public l2() {
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.l1;
    }

    public final boolean r(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        if (d90.c.c(r5) == true) goto L5;
    L19:
        return false;
    L5:
        if (d90.c.q(r5) == null) goto L10;
        Room r6 = d90.c.q(r5);
        if (r6 == null) goto L10;
        if (r6.isMediaRoom() == true) goto L19;
    L10:
        kjc.c r7 = new kjc.c();
        if (2 != kjc.a.a()) goto L14;
        kjc.b r0 = r7.a;
        r0.a = Boolean.TRUE;
        r7.b = true;
    L14:
        if (r7.b == true) goto L17;
        kjc.b r1 = r7.a;
        r1.a = Boolean.FALSE;
    L17:
        if (((Boolean) r7.a.a).booleanValue() == true) goto L19;
        return true;
    }
}
