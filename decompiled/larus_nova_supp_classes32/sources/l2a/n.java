package l2a;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.video.impl.widget.VideoViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n implements CommonVideoModel.b {
    public final /* synthetic */ CommonVideoModel.b a;

    public final void b(AsyncThrowable r1) {
    }

    public n(VideoViewHolder.b r1) {
        this.a = r1;
    }

    public final void a(MediaEntityContainer r2) {
        CommonVideoModel.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
