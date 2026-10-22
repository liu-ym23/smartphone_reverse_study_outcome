package go1;

import com.bytedance.android.livesdk.chatroom.viewmodule.CommonShortTouchWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s0 extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public s0() {
    }

    public final Class<? extends Widget> m() {
        return CommonShortTouchWidget.class;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.f0;
    }

    public final boolean r(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        if (d90.c.q(r6) == null) goto L25;
        Room r1 = d90.c.q(r6);
        if (r1 != null) goto L7;
    L8:
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        Room r7 = d90.c.q(r6);
        if (r7 == null) goto L13;
        RoomAuthStatus r8 = r7.getMRoomAuthStatus();
        if (r8 == null) goto L13;
    L14:
        if (r8 != null) goto L16;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L27;
        return true;
    L27:
        return false;
    L16:
        if (r8.enableShortTouch() == false) goto L18;
    L20:
        r9 = true;
        goto L22
    L18:
        if (r8.enableEnhancedTouch() == true) goto L20;
    L13:
        r8 = null;
        goto L14
    L7:
        if (r1.isSofaRoom() != true) goto L8;
        return false;
    L25:
        return false;
    }
}
