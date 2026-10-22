package c64;

import android.util.Size;
import android.widget.ImageView;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final Size a;
    public final ImageView.ScaleType b;
    public final VideoScaleModel c;

    public b(Size r2, ImageView.ScaleType r3, VideoScaleModel r4) {
        Intrinsics.checkNotNullParameter(r2, "size");
        Intrinsics.checkNotNullParameter(r3, "coverScaleType");
        Intrinsics.checkNotNullParameter(r4, "videoScaleModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
