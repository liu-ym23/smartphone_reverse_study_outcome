package j20;

import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ InteractGameFeedbackDialog a;
    public final /* synthetic */ List b;

    public e(InteractGameFeedbackDialog r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        a r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        r0.a = this.b;
        r0.notifyDataSetChanged();
        this.a.getClass();
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("GameFeedbackDialog", "从server获取游戏反馈tag列表失败", r5);
    }
}
