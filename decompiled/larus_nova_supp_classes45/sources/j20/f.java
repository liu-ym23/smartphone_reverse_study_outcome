package j20;

import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ InteractGameFeedbackDialog a;

    public f(InteractGameFeedbackDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        InteractGameFeedbackDialog r0 = this.a;
        int r1 = InteractGameFeedbackDialog.i;
        r0.getClass();
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("GameFeedbackDialog", "提交反馈成功：" + ((j10.b) r4));
        InteractGameFeedbackDialog.M0(this.a);
        f2.c("反馈成功！", 0);
    }
}
