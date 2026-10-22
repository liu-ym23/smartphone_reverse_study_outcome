package zh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 implements com.bytedance.android.live.ui.a {
    public final /* synthetic */ RadioWidget a;

    public d0(RadioWidget r1) {
        this.a = r1;
    }

    public final void Ek(IVoiceLiveTheme r4) {
        int r5 = RadioWidget.H0;
        ALogger.d("RadioWidget", "[smoothEnterRoom] on start load");
        int r0 = t0.a;
        t0.a("RadioWidget", "[ThemePreLoad]roomId=" + this.a.b.getId() + "RadioWidget#initVoiceLiveTheme load background onStart");
    }

    public final void W9(boolean r4, IVoiceLiveTheme r5) {
        int r6 = RadioWidget.H0;
        ALogger.d("RadioWidget", "[smoothEnterRoom] on complete load isSuccess: $success");
        int r0 = t0.a;
        t0.a("RadioWidget", "[ThemePreLoad]roomId=" + this.a.b.getId() + "RadioWidget#initVoiceLiveTheme load background success");
        if (r4 == false) goto L8;
        int r7 = MultiSceneEnterRoomStatisticsUtils.u;
        RadioWidget r8 = this.a;
        if (MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) r8).dataCenter, Long.valueOf(r8.b.getId())) == null) goto L9;
        RadioWidget r9 = this.a;
        MultiSceneEnterRoomStatisticsUtils.a.a(((Widget) r9).dataCenter, Long.valueOf(r9.b.getId())).recordSubElementShow("background_Load", System.currentTimeMillis());
        return;
    L9:
        return;
    }
}
