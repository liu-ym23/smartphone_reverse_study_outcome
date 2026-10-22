package go1;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v2 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public v2() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r11) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r12 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r11;
        Intrinsics.checkNotNullParameter(r12, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r12.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L16;
        Room r5 = d90.c.q(r12);
        LiveMode r6 = r0.getLiveMode();
        com.bytedance.android.livesdk.chatroom.ui.framework.d r13 = ho1.a.i(r12);
        if (r13 == null) goto L10;
        View r14 = r13.getRootView();
        if (r14 == null) goto L10;
        View r15 = r14.findViewById(2131375543);
    L11:
        ALogger.i("MultiLinkThemeBgUIWidget", "Descriptor createWidget, room=" + r5 + ", liveMode=" + r6 + ", container=" + r15);
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.createLiveThemeBgUIWidget(false, "inner_feed", r5, r6, null, null, null);
    L10:
        r15 = null;
        goto L11
    L16:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.T;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r4.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L12;
        d90.c.q(r4);
        LiveMode r5 = r0.getLiveMode();
        if (r5 != LiveMode.VIDEO) goto L8;
    L13:
        return true;
    L8:
        if (r5 == LiveMode.AUDIO) goto L13;
        if (r5 == LiveMode.THIRD_PARTY) goto L13;
    L12:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375543;
    }
}
