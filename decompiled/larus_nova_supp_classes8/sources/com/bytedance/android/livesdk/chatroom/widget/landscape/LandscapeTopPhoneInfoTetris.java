package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeTopPhoneInfoTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Lcom/bytedance/android/livesdk/widgetdescriptor/e0;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopPhoneInfoTetris extends LiveTetris<e0> implements com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public ViewGroup o;
    public ViewGroup p;
    public ViewGroup q;

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return true;
    }

    public final void O() {
        ViewGroup r2 = this.o;
        if (r2 == null) goto L5;
        LiveTetris.Q(this, LandscapeNetworkInfoWidget.class, r2, false, null, 24);
    L5:
        ViewGroup r8 = this.p;
        if (r8 == null) goto L8;
        LiveTetris.Q(this, LandscapeTimeInfoWidget.class, r8, false, null, 24);
    L8:
        ViewGroup r3 = this.q;
        if (r3 == null) goto L12;
        LiveTetris.Q(this, LandscapeBatteryInfoWidget.class, r3, false, null, 24);
        return;
    }

    public LandscapeTopPhoneInfoTetris() {
    }

    public final View G(t70.k r12) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        View r13 = r12.b(2131566691);
        this.o = (ViewGroup) r13.findViewById(2131393205);
        this.p = (ViewGroup) r13.findViewById(2131388662);
        this.q = (ViewGroup) r13.findViewById(2131364010);
        if (VSMediaUIConfigHelper.c(K()) == false) goto L11;
        IVSPlayerService r0 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(((d90.d) K()).h);
    L8:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r1;
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r2, PlayerViewControl.KEY.LandscapePhoneInfo, PlayerViewControl.Type.TOP, PlayerViewControl.Style.HIDE, r13, 0.0f, true, false, this, 336);
        goto L11
    L7:
        r1 = null;
    L11:
        return r13;
    }
}
