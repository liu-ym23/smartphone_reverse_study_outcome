package hd0;

import com.bytedance.android.live.livelink.multilink.pipeline.LinkPipelineManager;
import com.bytedance.android.livesdk.app.dataholder.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ d a;

    public e(LinkPipelineManager.c r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        d r0 = this.a;
        r0.onChanged((Integer) r2);
    }
}
