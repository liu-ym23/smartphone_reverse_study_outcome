package c64;

import android.widget.ImageView;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements d {
    public a() {
    }

    @Override // c64.d
    public final b a(int r1, int r2, int r3, int r4) {
        return new b(f.a(r1, r2, r3, r4), ImageView.ScaleType.FIT_CENTER, VideoScaleModel.FIT);
    }
}
