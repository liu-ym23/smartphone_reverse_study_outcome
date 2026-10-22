package l2a;

import com.larus.video.impl.VideoDetailAdapter;
import com.larus.video.impl.widget.VideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t implements VideoView.a {
    public final /* synthetic */ VideoDetailAdapter a;

    @Override // com.larus.video.impl.widget.VideoView.a
    public final void onPause() {
        VideoView.a r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    @Override // com.larus.video.impl.widget.VideoView.a
    public final void onPlay() {
        VideoView.a r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.onPlay();
        return;
    }

    public t(VideoDetailAdapter r1) {
        this.a = r1;
    }
}
