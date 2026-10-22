package go1;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.BaseLinkMultiControlWidget;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b0 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
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

    public b0() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r10) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r10;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r6 = ho1.a.d(r4);
        BaseLinkMultiControlWidget r11 = null;
        if (r6 == null) goto L35;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r3 = ho1.a.c(r4);
        if (r3 == null) goto L35;
        Room r0 = d90.c.q(r4);
        LiveMode r1 = r6.getLiveMode();
        if (Q(r1, r0) == false) goto L21;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r2 = r6.Gg();
        if (r2 == null) goto L13;
        View r5 = r2.getRootView();
    L15:
        if ((r5 instanceof ViewGroup) == true) goto L17;
        r5 = null;
    L17:
        ViewGroup r7 = (ViewGroup) r5;
        z r8 = new z(this, r6.getLiveVideoClientFactory(), r3, r4, !MultiLinkLoadWidgetUtils.f(), r6);
        IInteractService r9 = jc1.k.f(IInteractService.class);
        if (r9 == null) goto L31;
        r11 = r9.createLinkMultiControlWidget(r8, r7, Boolean.FALSE);
    L31:
        if (r11 == null) goto L35;
        if (MultiLinkLoadWidgetUtils.f() == false) goto L35;
        r11.wq();
        goto L35
    L13:
        r5 = null;
        goto L15
    L21:
        if (R(r1, r0) == false) goto L31;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r12 = r6.Gg();
        if (r12 == null) goto L25;
        BaseLinkMultiControlWidget r13 = r12.getRootView();
    L27:
        if ((r13 instanceof ViewGroup) == false) goto L30;
        r11 = r13;
    L30:
        a0 r14 = new a0(r3, r4, r6.getLiveVideoClientFactory());
        IInteractService r15 = jc1.k.f(IInteractService.class);
        Intrinsics.checkNotNull(r15);
        r11 = r15.createLinkMultiControlWidget(r14, (ViewGroup) r11, Boolean.FALSE);
        goto L31
    L25:
        r13 = null;
    L35:
        return r11;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return !MultiLinkLoadWidgetUtils.f();
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.N;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = (com.bytedance.android.livesdk.chatroom.ui.framework.c) r4.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.c.class);
        if (r0 == null) goto L12;
        Room r5 = d90.c.q(r4);
        LiveMode r1 = r0.getLiveMode();
        if (r1 == LiveMode.MEDIA) goto L12;
        if (Q(r1, r5) == false) goto L10;
    L11:
        return true;
    L10:
        if (R(r1, r5) == true) goto L11;
    L12:
        return false;
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375519;
    }

    public static boolean Q(LiveMode r3, Room r4) {
        if (KtvSettingHelper.e().b() == false) goto L9;
        if (r4 == null) goto L9;
        if (r4.isMergeVSRoom() != true) goto L9;
        return false;
    L9:
        if (r3 != LiveMode.VIDEO) goto L11;
    L16:
        return true;
    L11:
        if (r3 == LiveMode.AUDIO) goto L16;
        if (r3 == LiveMode.SCREEN_RECORD) goto L15;
        return false;
    L15:
        if (com.bytedance.android.livesdk.config.setting.d.a(r4, "LinkMultiControl") == false) goto L16;
        return false;
    }

    public static boolean R(LiveMode r3, Room r4) {
        if (KtvSettingHelper.e().b() == false) goto L9;
        if (r4 == null) goto L9;
        if (r4.isMergeVSRoom() != true) goto L9;
        return false;
    L9:
        if (r3 == LiveMode.THIRD_PARTY) goto L13;
        return false;
    L13:
        return true;
    }
}
