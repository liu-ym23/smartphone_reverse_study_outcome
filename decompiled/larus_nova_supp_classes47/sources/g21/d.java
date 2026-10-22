package g21;

import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends a {
    public final TextureView d;

    public final String toString() {
        return "TextureRenderView(render=" + this.b + ')';
    }

    public d(TextureView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "textureView");
        super(r2, r3);
        this.d = r2;
    }
}
