package go1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.api.ICommentService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r1 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public final Class<? extends Widget> m() {
        ICommentService r0 = jc1.k.f(ICommentService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMediaLandScapeCommentWidgetClass();
    }

    public r1() {
    }

    public final f70.b getLayerType() {
        return mg2.e.g;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.l;
    }

    public final ViewGroup q(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = ho1.a.i(r3);
        if (r4 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r5 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r4);
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.e;
    L5:
        r5 = null;
        goto L6
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        DataCenter r0 = ((d90.d) r4).h;
        if (r0 == null) goto L14;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 == null) goto L14;
        if (r1.isMediaRoom() != true) goto L14;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r5 = ho1.a.i(r4);
        if (r5 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r6 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r5);
    L12:
        if (r6 == null) goto L14;
        return true;
    L11:
        r6 = null;
    L14:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return null;
    }
}
