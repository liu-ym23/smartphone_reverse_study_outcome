package l2a;

import android.view.View;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.video.impl.VideoActivity;
import com.larus.video.impl.widget.VideoViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements e {
    public final /* synthetic */ VideoActivity a;

    @Override // l2a.e
    public final void b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public o(VideoActivity r1) {
        this.a = r1;
    }

    @Override // l2a.e
    public final void a(boolean r4, VideoViewHolder.b r5) {
        VideoActivity r0 = this.a;
        CommonVideoModel r1 = r0.j;
        if (r1 == null) goto L6;
        MediaEntityContainer r2 = r0.n;
        Intrinsics.checkNotNull(r2);
        r1.requestLoadMore(r4, r2, new n(r5));
        return;
    }
}
