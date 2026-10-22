package go1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.api.IPublicScreenService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v1 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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
        IPublicScreenService r0 = jc1.k.f(IPublicScreenService.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTextWidget(null);
    }

    public v1() {
    }

    public final f70.b getLayerType() {
        return mg2.e.g;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.m;
    }

    public final boolean r(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        DataCenter r0 = ((d90.d) r5).h;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r1 = null;
        if (r0 == null) goto L5;
        Room r2 = com.bytedance.android.live.core.utils.z.o(r0);
    L7:
        if (com.bytedance.android.livesdk.widgetdescriptor.template.utils.a.b(r2) == true) goto L9;
    L10:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r6 = ho1.a.i(r5);
        if (r6 == null) goto L13;
        r1 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r6);
    L13:
        if (r1 == null) goto L15;
        return true;
    L15:
        return false;
    L9:
        if (com.bytedance.android.livesdk.widgetdescriptor.template.utils.a.a(r2) == false) goto L15;
    L5:
        r2 = null;
        goto L7
    }

    public final Integer w(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = ho1.a.i(r3);
        if (r4 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.widget.landscape.r r5 = com.bytedance.android.livesdk.chatroom.ui.framework.base.s.a(r4);
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return 2131387102;
    L5:
        r5 = null;
        goto L6
    }
}
