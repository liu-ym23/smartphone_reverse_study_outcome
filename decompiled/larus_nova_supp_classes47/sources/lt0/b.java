package lt0;

import android.graphics.drawable.Animatable;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.profile.standard.tag.view.LiveLifeHonorView;
import com.facebook.imagepipeline.image.ImageInfo;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements p0 {
    public final /* synthetic */ LiveLifeHonorView a;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(k r1) {
    }

    public b(LiveLifeHonorView r1) {
        this.a = r1;
    }

    public final void b(k r1, Exception r2) {
        LiveLifeHonorView.f(this.a, 0);
    }

    public final void c(k r1, int r2, int r3, boolean r4) {
        LiveLifeHonorView.f(this.a, (r2 * UtilityKotlinExtentionsKt.i(18)) / r3);
    }
}
