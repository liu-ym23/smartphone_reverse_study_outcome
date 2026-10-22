package j20;

import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ InteractGameFeedbackDialog a;

    public g(InteractGameFeedbackDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        InteractGameFeedbackDialog r0 = this.a;
        int r1 = InteractGameFeedbackDialog.i;
        r0.getClass();
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("GameFeedbackDialog", "提交反馈失败", (Throwable) r4);
        f2.c("反馈失败！", 0);
        InteractGameFeedbackDialog.M0(this.a);
    }
}
