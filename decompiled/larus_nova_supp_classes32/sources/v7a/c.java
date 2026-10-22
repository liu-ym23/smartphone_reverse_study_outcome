package v7a;

import android.graphics.Bitmap;
import com.lynx.tasm.utils.BlurUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements b {
    public final int a;
    public String b;

    @Override // v7a.b
    public final String getName() {
        return c.class.getSimpleName();
    }

    @Override // v7a.b
    public final String getPostprocessorCacheKey() {
        if (this.b != null) goto L6;
        this.b = String.valueOf(this.a);
    L6:
        return this.b;
    }

    public c(int r1) {
        this.a = r1;
    }

    @Override // v7a.b
    public final void a(Bitmap r2) {
        BlurUtils.iterativeBoxBlur(r2, this.a);
    }
}
