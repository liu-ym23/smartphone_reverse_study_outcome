package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.ui.framework.descriptors.MultiLinkDynamicFallbackWidget;
import com.bytedance.android.livesdk.n6;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u2 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public u2() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        if (ho1.a.d(r6) != null) goto L6;
        return null;
    L6:
        if (ho1.a.c(r6) == null) goto L39;
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        if (com.bytedance.android.live.liveinteract.plantform.multiroom.e.b(((d90.d) r6).h) == null) goto L13;
        ALogger.e("MultiLinkDynamicWidgetDescriptor", "createWidget failed! multiLinkDynamicService already exist");
        if (((Boolean) n6.a.getValue()).booleanValue() == true) goto L37;
        return null;
    L37:
        return new MultiLinkDynamicFallbackWidget();
    L13:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r1 = (com.bytedance.android.livesdk.chatroom.ui.framework.d) r6.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.d.class);
        if (r1 != null) goto L16;
        Widget r2 = null;
    L27:
        DataCenter r7 = ((d90.d) r6).h;
        if (r7 == null) goto L35;
        if ((r2 instanceof ih0.b) == true) goto L32;
        Widget r3 = null;
    L33:
        com.bytedance.android.live.liveinteract.plantform.multiroom.e.e(r7, (ih0.b) r3, null);
        goto L35
    L32:
        r3 = r2;
    L35:
        return r2;
    L16:
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L22;
        ViewGroup r8 = r1.oh();
        if ((r8 instanceof ViewGroup) == true) goto L21;
        r8 = null;
    L21:
        Widget r9 = r4.createDynamicWidget(r8);
    L24:
        if ((r9 instanceof Widget) == true) goto L26;
        r9 = null;
    L26:
        r2 = r9;
        goto L27
    L22:
        r9 = null;
        goto L24
    L39:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.Q;
    }

    public final boolean r(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r6.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L43;
        Room r7 = d90.c.q(r6);
        LiveMode r1 = r0.getLiveMode();
        if (r7 == null) goto L11;
        if (r7.isLiveTypeAudio() != true) goto L11;
    L39:
        return true;
    L11:
        if (r1 != LiveMode.VIDEO) goto L13;
    L16:
        if (r7 == null) goto L21;
        Map r2 = r7.getLinkMap();
        if (r2 == null) goto L21;
        if (r2.containsKey(String.valueOf(5)) != true) goto L21;
    L36:
        boolean r8 = true;
    L38:
        if (r8 == true) goto L39;
        return false;
    L21:
        if (r7 == null) goto L26;
        Map r3 = r7.getLinkMap();
        if (r3 == null) goto L26;
        if (r3.containsKey(String.valueOf(8)) == true) goto L36;
    L26:
        if (r7 == null) goto L31;
        Map r4 = r7.getLinkMap();
        if (r4 == null) goto L31;
        if (r4.containsKey(String.valueOf(12)) == true) goto L36;
    L31:
        if (r7 == null) goto L37;
        Map r9 = r7.getLinkMap();
        if (r9 == null) goto L37;
        if (r9.containsKey(String.valueOf(16)) == true) goto L36;
    L37:
        r8 = false;
        goto L38
    L13:
        if (r1 == LiveMode.AUDIO) goto L16;
        if (r1 == LiveMode.THIRD_PARTY) goto L16;
        return false;
    L43:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375520;
    }
}
