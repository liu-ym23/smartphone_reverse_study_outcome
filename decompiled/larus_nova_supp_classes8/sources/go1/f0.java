package go1;

import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0 extends e70.a<com.bytedance.android.livesdk.widgetdescriptor.e0> implements e70.h<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.e<com.bytedance.android.livesdk.widgetdescriptor.e0>, e70.i<com.bytedance.android.livesdk.widgetdescriptor.e0> {
    public static final /* synthetic */ int c = 0;

    public static final class a {
        public static boolean a(com.bytedance.android.livesdk.chatroom.ui.framework.c r3) {
            Intrinsics.checkNotNullParameter(r3, "containerAbility");
            Room r0 = r3.getRoom();
            LiveMode r1 = r3.getLiveMode();
            if (r3.isPortrait() == true) goto L5;
            if (r0 == null) goto L13;
            if (r0.isMediaRoom() != true) goto L13;
        L22:
            return false;
        L13:
            if (r1 != LiveMode.THIRD_PARTY) goto L15;
            return true;
        L15:
            if (r1 == LiveMode.SCREEN_RECORD) goto L26;
            if (r0 == null) goto L22;
            RoomSpecificSceneTypeInfo r4 = r0.getSceneTypeInfo();
            if (r4 == null) goto L22;
            if (r4.isLandscapeVerticalRoom() != 1) goto L22;
            return true;
        L26:
            return true;
        L5:
            if (r1 != LiveMode.THIRD_PARTY) goto L7;
            return true;
        L7:
            if (r1 != LiveMode.SCREEN_RECORD) goto L22;
            return true;
        }
    }

    static {
    }

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

    public f0() {
    }

    public final f70.b getLayerType() {
        return mg2.e.a;
    }

    public final Widget l(h70.b r6) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r7 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r6;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = ho1.a.d(r7);
        ViewGroup r1 = null;
        if (r0 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r2 = ho1.a.c(r7);
        if (r2 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r3 = (com.bytedance.android.livesdk.chatroom.ui.framework.d) r7.m.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.d.class);
        if (r3 == null) goto L29;
        g0 r4 = new g0(r0, r2);
        IAbilityCenter r8 = r7.m;
        if (r8 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.ui.framework.widget.s r9 = (com.bytedance.android.livesdk.chatroom.ui.framework.widget.s) r8.getAbility(com.bytedance.android.livesdk.chatroom.ui.framework.widget.s.class);
    L15:
        if (r9 == null) goto L17;
        tlc.d r10 = r9.gi();
    L18:
        IBroadcastService r5 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r5 == null) goto L26;
        ViewGroup r11 = r3.oh();
        if ((r11 instanceof ViewGroup) == false) goto L25;
        r1 = r11;
    L25:
        return r5.createScreenControlWidget(r4, r1, r10);
    L26:
        return null;
    L17:
        r10 = null;
        goto L18
    L14:
        r9 = null;
        goto L15
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    }

    public final boolean o(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return true;
    }

    public final j70.f p(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return com.bytedance.android.livesdk.chatroom.ui.framework.f.L;
    }

    public final boolean r(h70.b r3) {
        com.bytedance.android.livesdk.widgetdescriptor.e0 r4 = (com.bytedance.android.livesdk.widgetdescriptor.e0) r3;
        Intrinsics.checkNotNullParameter(r4, "layerContext");
        LivePluginSPIManager.e.getClass();
        if (LivePluginSPIManager.b() == true) goto L5;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L15;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = ho1.a.d(r4);
        if (r5 != null) goto L13;
        return false;
    L13:
        return a.a(r5);
    L15:
        return false;
    L5:
        if (LivePluginSPIManager.c() == true) goto L7;
        r0 = false;
        goto L8
    }

    public final Integer w(h70.b r2) {
        Intrinsics.checkNotNullParameter((com.bytedance.android.livesdk.widgetdescriptor.e0) r2, "layerContext");
        return 2131375533;
    }
}
