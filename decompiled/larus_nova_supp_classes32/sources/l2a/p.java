package l2a;

import com.larus.video.impl.VideoActivity;
import com.larus.video.impl.widget.VideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p implements VideoView.a {
    public final /* synthetic */ VideoActivity a;

    @Override // com.larus.video.impl.widget.VideoView.a
    public final void onPause() {
        this.a.P1("paused");
    }

    @Override // com.larus.video.impl.widget.VideoView.a
    public final void onPlay() {
        this.a.P1("play");
    }

    public p(VideoActivity r1) {
        this.a = r1;
    }
}
