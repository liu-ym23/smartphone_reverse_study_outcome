package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c0 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public c0() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r3) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r3, "layerContext");
        IPkAudienceLinkOutService r4 = jc1.k.f(IPkAudienceLinkOutService.class);
        if (r4 != null) goto L5;
        return null;
    L5:
        return r4.createRevPkAudienceControlWidget(null, 2131382344);
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.U;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r4.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L10;
        Room r5 = d90.c.q(r4);
        if (r0.getLiveMode() == LiveMode.SCREEN_RECORD) goto L8;
    L11:
        return true;
    L8:
        if (com.bytedance.android.livesdk.config.setting.d.a(r5, "LinkRevControl") == false) goto L11;
    L10:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375521;
    }
}
