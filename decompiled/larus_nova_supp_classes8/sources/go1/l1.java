package go1;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.api.IBarrageService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l1 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.d N() {
        return this;
    }

    public final e70.e O() {
        return this;
    }

    public final e70.f P() {
        return this;
    }

    public final Class<? extends Widget> m() {
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

    public l1() {
    }

    public final f70.b getLayerType() {
        return mg2.e.b;
    }

    public final Widget l(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        IBarrageService r3 = jc1.k.f(IBarrageService.class);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.provideLandscapeBarrageWidget();
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.k;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        DataCenter r5 = ((d90.d) r4).h;
        if (r5 == null) goto L5;
        Room r6 = com.bytedance.android.live.core.utils.z.o(r5);
    L7:
        if (r6 != null) goto L10;
        return false;
    L10:
        if (r6.isMediaRoom() == false) goto L13;
        return false;
    L13:
        if (r6.isMergeVSRoom() == true) goto L15;
    L17:
        return true;
    L15:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(false, r6) == false) goto L17;
        return false;
    L5:
        r6 = null;
        goto L7
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131381282;
    }
}
