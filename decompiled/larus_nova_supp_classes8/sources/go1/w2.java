package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w2 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public w2() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        if (ho1.a.d(r3) != null) goto L6;
    L11:
        return null;
    L6:
        if (ho1.a.c(r3) == null) goto L11;
        IInteractService r4 = jc1.k.f(IInteractService.class);
        if (r4 == null) goto L11;
        return r4.createMultiLinkUIWidget();
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.S;
    }

    public final boolean r(h70.b r5) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r6 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r6.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L43;
        Room r7 = d90.c.q(r6);
        LiveMode r1 = r0.getLiveMode();
        if (r1 == LiveMode.VIDEO) goto L12;
        if (r1 == LiveMode.AUDIO) goto L12;
        if (r1 == LiveMode.THIRD_PARTY) goto L12;
        return false;
    L12:
        if (r7 == null) goto L17;
        Map r2 = r7.getLinkMap();
        if (r2 == null) goto L17;
        if (r2.containsKey(String.valueOf(5)) != true) goto L17;
    L32:
        Map r8 = r7.getLinkMap();
        if (r8 != null) goto L35;
    L37:
        boolean r9 = false;
    L38:
        if (r9 == false) goto L42;
        return true;
    L42:
        return false;
    L35:
        if (r8.containsKey(String.valueOf(9)) == true) goto L37;
        r9 = true;
    L17:
        if (r7 == null) goto L22;
        Map r3 = r7.getLinkMap();
        if (r3 == null) goto L22;
        if (r3.containsKey(String.valueOf(8)) == true) goto L32;
    L22:
        if (r7 == null) goto L27;
        Map r4 = r7.getLinkMap();
        if (r4 == null) goto L27;
        if (r4.containsKey(String.valueOf(12)) == true) goto L32;
    L27:
        if (r7 == null) goto L37;
        Map r10 = r7.getLinkMap();
        if (r10 == null) goto L37;
        if (r10.containsKey(String.valueOf(16)) != true) goto L37;
    L43:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375520;
    }
}
