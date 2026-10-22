package go1;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends e70.b<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public final e70.e N() {
        return this;
    }

    public final e70.f O() {
        return this;
    }

    public final Class<? extends Widget> m() {
        return null;
    }

    public final void s(h70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layerContext");
    }

    public final /* synthetic */ void u() {
    }

    public a() {
    }

    public final Widget l(h70.b r4) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r5 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r4;
        Intrinsics.checkNotNullParameter(r5, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r6 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r5.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r6 == null) goto L5;
        FragmentManager r1 = r6.getChildFragmentManager();
    L6:
        if (r6 == null) goto L8;
        com.bytedance.android.live.pushstream.d r7 = r6.getLiveStream();
    L9:
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.createLiveAwemePlayControlWidghet(r1, r7);
    L8:
        r7 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return false;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.K;
    }

    public final boolean r(h70.b r2) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r3 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        return d90.c.c(r3);
    }
}
