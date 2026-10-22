package com.bytedance.android.ec.adapter.impl.adapters.reverse.player;

import android.content.Context;
import android.util.AttributeSet;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.sdk.helper.j;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements IECPlayerViewService {
    public c() {
    }

    @Override // com.bytedance.android.ec.adapter.api.player.IECPlayerViewService
    public final d a(Context r19, AttributeSet r20, int r21, String r22, String r23, IECPlayerViewService.RenderViewType r24, Long r25) {
        String r1 = r23;
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r22, BdpAwemeConstant.KEY_ROOM_ID);
        Intrinsics.checkNotNullParameter(r1, "playerScene");
        if (r23.length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L9;
        j.b("EC_LIVE_PLAYER_VIEW_WARNING", "当前场景直播播放器未设置染色信息（use_scene），请设置染色信息并联系@chenpan.julian.0224进行登记");
    L9:
        if (StringsKt.startsWith$default(r1, "ec_", false, 2, null) == true) goto L12;
        r1 = "ec_".concat(r1);
    L12:
        LivePlayerConfig r11 = new LivePlayerConfig(ILivePlayerScene.Companion.scene(r1), r22, null, false, null, false, false, null, false, 0, false, 2044, null);
        if (r25 == null) goto L15;
        r11.setDelayStopOrReleaseTime(r25.longValue());
    L15:
        if (r24 == null) goto L28;
        int r12 = b.a[r24.ordinal()];
        if (r12 != 1) goto L19;
        IRenderView.RenderViewType r13 = IRenderView.RenderViewType.TEXTURE_VIEW;
    L27:
        r11.setRenderViewType(r13);
        goto L28
    L19:
        if (r12 != 2) goto L21;
        r13 = IRenderView.RenderViewType.SURFACE_VIEW;
        goto L27
    L21:
        if (r12 != 3) goto L24;
        r13 = IRenderView.RenderViewType.KEEP_TEXTURE_RENDER_VIEW;
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L28:
        Unit r14 = Unit.INSTANCE;
        return new d(new LivePlayerView(r19, r20, r21, r11));
    L5:
        r10 = false;
        goto L6
    }
}
