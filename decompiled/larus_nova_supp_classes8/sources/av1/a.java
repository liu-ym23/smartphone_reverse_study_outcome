package av1;

import com.bytedance.android.live.room.enterprocess.IEnterProcessorService;
import com.bytedance.android.live.room.enterprocess.IFeedBizInterceptor;
import com.bytedance.android.live.room.enterprocess.IInteractionBizInterceptor;
import com.bytedance.android.live.room.enterprocess.IRoomBizInterceptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class a implements IEnterProcessorService {
    public a() {
    }

    public IFeedBizInterceptor feedBizInterceptor() {
        return b.b;
    }

    public IInteractionBizInterceptor interactionBizInterceptor() {
        return c.b;
    }

    public IRoomBizInterceptor roomBizInterceptor() {
        return d.a;
    }
}
