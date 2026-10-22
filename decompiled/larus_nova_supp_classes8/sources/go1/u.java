package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public u() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r6) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r7 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(r7);
        ViewGroup r1 = null;
        if (r0 == null) goto L20;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r2 = ho1.a.c(r7);
        if (r2 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = (com.bytedance.android.livesdk.chatroom.ui.framework.d) r7.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.d.class);
        if (r3 == null) goto L22;
        t r4 = new t(r2, r7, r0.getLiveVideoClientFactory());
        IInteractService r8 = jc1.k.f(IInteractService.class);
        if (r8 == null) goto L19;
        ViewGroup r5 = r3.oh();
        if ((r5 instanceof ViewGroup) == false) goto L18;
        r1 = r5;
    L18:
        return r8.createLinkMultiControlWidget(r4, r1, Boolean.FALSE);
    L19:
        return null;
    L22:
        return null;
    L21:
        return null;
    L20:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.N;
    }

    public final boolean r(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r5.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L23;
        Room r6 = d90.c.q(r5);
        LiveMode r1 = r0.getLiveMode();
        if (KtvSettingHelper.e().b() == false) goto L12;
        if (r6 == null) goto L12;
        if (r6.isMergeVSRoom() == true) goto L23;
    L12:
        if (r1 == LiveMode.MEDIA) goto L23;
        if (r1 != LiveMode.THIRD_PARTY) goto L16;
        return true;
    L16:
        if (r1 == LiveMode.SCREEN_RECORD) goto L26;
        if (r6 == null) goto L23;
        IRoomSpecificSceneTypeInfo r7 = r6.getSceneTypeInfo();
        if (r7 == null) goto L23;
        if (r7.isLandscapeVerticalRoom() != 1) goto L23;
        return true;
    L26:
        return true;
    L23:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375519;
    }
}
