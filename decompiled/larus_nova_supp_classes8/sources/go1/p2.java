package go1;

import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p2 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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
        return r0.getMicRoomEnterOfficialWidget();
    }

    public p2() {
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.v;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        Room r4 = d90.c.q(r3);
        if (r4 == null) goto L7;
        IMicRoomService r0 = jc1.k.f(IMicRoomService.class);
        if (r0 == null) goto L7;
        Boolean r5 = Boolean.valueOf(r0.isMicRoom(r4));
    L9:
        return Intrinsics.areEqual(r5, Boolean.FALSE);
    L7:
        r5 = null;
        goto L9
    }
}
