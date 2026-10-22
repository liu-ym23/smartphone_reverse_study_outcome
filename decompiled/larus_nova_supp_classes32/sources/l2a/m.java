package l2a;

import com.larus.video.impl.VideoActivity;
import com.larus.video.impl.widget.PagerLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m implements PagerLayoutManager.a {
    public final /* synthetic */ VideoActivity a;

    public m(VideoActivity r1) {
        this.a = r1;
    }

    @Override // com.larus.video.impl.widget.PagerLayoutManager.a
    public final void a(int r3, int r4) {
        this.a.Q1(r3, r4, "up");
    }

    @Override // com.larus.video.impl.widget.PagerLayoutManager.a
    public final void b(int r3, int r4) {
        this.a.Q1(r3, r4, "down");
    }
}
