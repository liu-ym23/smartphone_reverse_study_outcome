package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public v() {
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

    public final boolean r(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r5.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L17;
        Room r6 = d90.c.q(r5);
        LiveMode r1 = r0.getLiveMode();
        if (r1 == LiveMode.MEDIA) goto L17;
        if (r1 != LiveMode.THIRD_PARTY) goto L10;
        return true;
    L10:
        if (r1 == LiveMode.SCREEN_RECORD) goto L20;
        if (r6 == null) goto L17;
        RoomSpecificSceneTypeInfo r7 = r6.getSceneTypeInfo();
        if (r7 == null) goto L17;
        if (r7.isLandscapeVerticalRoom() != 1) goto L17;
        return true;
    L20:
        return true;
    L17:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375521;
    }
}
