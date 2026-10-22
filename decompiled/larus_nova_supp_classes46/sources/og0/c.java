package og0;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends BaseAnimationListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;

    public c(d r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        super.onAnimationFrame(r2, r3);
        if (r3 != (this.b - 1)) goto L9;
        HSImageView r4 = this.a.a.e;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("likeEffect");
    L7:
        UtilityKotlinExtentionsKt.t(r4);
        return;
    }
}
