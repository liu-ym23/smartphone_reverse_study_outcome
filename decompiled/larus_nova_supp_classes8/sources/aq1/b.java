package aq1;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs.widget.landscape.VSRoomLandscapeResetPlayerViewWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayABSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import j70.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oq1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends ReplayWidgetDescriptor<uq1.b> {
    public final boolean h() {
        return true;
    }

    public b() {
    }

    public final Class<? extends Widget> c() {
        return VSRoomLandscapeResetPlayerViewWidget.class;
    }

    public final f C(h70.b r2) {
        uq1.b r3 = (uq1.b) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.d.getClass();
        return uq1.a.k;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final boolean N(h70.b r6, Function1 r7) {
        uq1.b r8 = (uq1.b) r6;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        Intrinsics.checkNotNullParameter(r7, "isState");
        DataCenter r9 = r8.e;
        if (PadConfigUtils.c() == false) goto L6;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == true) goto L21;
        return false;
    L21:
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == false) goto L26;
        if (((Boolean) r7.invoke(16)).booleanValue() == false) goto L26;
        return false;
    L26:
        return ((Boolean) r7.invoke(8)).booleanValue();
    L6:
        if (((g) ReplayABSettingKeys.REPLAY_GESTURE_CONFIG.getValue()).b() == false) goto L17;
        fq1.a r11 = fq1.b.a();
        if (r11 == null) goto L17;
        Episode r12 = r11.a;
        if (r12 == null) goto L17;
        IRoomAuthStatus r13 = r12.getRoomAuthStatus();
        if (r13 == null) goto L17;
        if (r13.getVideoAmplificationType() != 1) goto L17;
        r10 = true;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final ElementConstraint O(h70.b r5, Function1 r6) {
        uq1.b r7 = (uq1.b) r5;
        Intrinsics.checkNotNullParameter(r7, "layerContext");
        Intrinsics.checkNotNullParameter(r6, "isState");
        ElementConstraint r8 = new ElementConstraint(-2.0f, -2.0f);
        ElementConstraint.Side r0 = ElementConstraint.Side.LEFT;
        r7.d.getClass();
        r8.b(r0, uq1.a.h, ElementConstraint.Side.RIGHT, 0.0f);
        ElementConstraint.Side r1 = ElementConstraint.Side.BOTTOM;
        r7.d.getClass();
        r8.b(r1, uq1.a.l, r1, 26.0f);
        return r8;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.widget.ReplayWidgetDescriptor
    public final LayerIndex P(h70.b r2, Function1 r3) {
        Intrinsics.checkNotNullParameter((uq1.b) r2, "layerContext");
        Intrinsics.checkNotNullParameter(r3, "isState");
        return LayerIndex.INDEX_4;
    }
}
