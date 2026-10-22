package ukb;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    public final Resources a;

    public b(Context r1) {
        this.a = r1.getResources();
    }

    public final Resource<BitmapDrawable> transcode(Resource<Bitmap> r2, Options r3) {
        Resources r4 = this.a;
        if (r2 != null) goto L6;
        return null;
    L6:
        return new c(r4, r2);
    }
}
