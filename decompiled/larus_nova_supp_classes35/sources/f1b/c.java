package f1b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends y0b.c {
    public c() {
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r5) {
        if (r5 == null) goto L5;
        String r6 = UriProtector.getQueryParameter(r5, "key");
    L6:
        if (r6 == null) goto L14;
        Bitmap r7 = qsb.b.a().v1(r6);
        if (r7 == null) goto L15;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        if (r7.compress(Bitmap.CompressFormat.PNG, 100, r1) == false) goto L16;
        byte[] r8 = r1.toByteArray();
        r1.close();
        return new WebResourceResponse("image/png", Charset.defaultCharset().name(), new ByteArrayInputStream(r8));
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    L5:
        r6 = null;
        goto L6
    }
}
