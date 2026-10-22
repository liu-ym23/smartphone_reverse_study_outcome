package u4a;

import android.graphics.BitmapFactory;
import android.util.Base64;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements k {
    public b() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.DATA_URL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u4a.k
    public final void a(m r3, l r4) {
        AnimaXLoaderRequest r5 = (AnimaXLoaderRequest) r3;     // Catch: Exception -> L5 Throwable -> L9
        String r0 = r5.b();     // Catch: Exception -> L5 Throwable -> L9
        byte[] r1 = Base64.decode(r0.substring(r0.indexOf("base64,") + 7), 0);     // Catch: Exception -> L5 Throwable -> L9
        if (r5.a() == null) goto L7;
        q r2 = new q(BitmapFactory.decodeByteArray(r1, 0, r1.length));     // Catch: Exception -> L5 Throwable -> L9
        AnimaXLoaderResponse r6 = new AnimaXLoaderResponse(AnimaXLoaderResponse.Type.BITMAP, r2);     // Catch: Exception -> L5 Throwable -> L9
    L16:
    L12:
        ((AnimaXLoaderCompletionHandler) r4).a(r6);
        return;
    L7:
        r6 = AnimaXLoaderResponse.a(r1);     // Catch: Exception -> L5 Throwable -> L9
    L5:
        e = move-exception;
        r6 = AnimaXLoaderResponse.b(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ((AnimaXLoaderCompletionHandler) r4).a(null);
        throw th;
    }
}
