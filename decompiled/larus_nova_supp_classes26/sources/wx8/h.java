package wx8;

import com.larus.camera.impl.ui.component.result.video.ResultVideoView;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements VideoPlayView.a {
    public final /* synthetic */ ResultVideoView a;

    public h(ResultVideoView r1) {
        this.a = r1;
    }

    public final void a(String r3) {
        FLogger.a.i("ResultVideoView", "User click play");
        com.larus.camera.impl.ui.component.result.general.viewpager.e r4 = this.a.e;
        if (r4 == null) goto L6;
        r4.c();
        return;
    }

    public final void onPause(String r3) {
        FLogger.a.i("ResultVideoView", "User click pause");
        com.larus.camera.impl.ui.component.result.general.viewpager.e r4 = this.a.e;
        if (r4 == null) goto L6;
        r4.a();
        return;
    }
}
