package wo1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.sti.IBigCardAnimExcuteListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements IBigCardAnimExcuteListener {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    public final void onAnimDone(boolean r2) {
        ALogger.i("LoadShortTouchBigCardMethod", "大卡动画执行结束");
        this.a.finishWithSuccess();
    }
}
