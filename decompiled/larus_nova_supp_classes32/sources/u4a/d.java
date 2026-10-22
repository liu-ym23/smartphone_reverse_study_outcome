package u4a;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements k {
    public d() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.FILE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u4a.k
    public final void a(m r5, l r6) {
        w4a.a r0 = w4a.a.b();
        r0.getClass();
        Map r1 = (Map) ((ConcurrentHashMap) r0.a).get(w4a.e.b);
        byte[] r2 = null;
        if (r1 != null) goto L5;
    L7:
        IAnimaXService r3 = null;
    L8:
        IAnimaXImageService r4 = (IAnimaXImageService) r3;
        if (r4 != null) goto L11;
    L13:
        String r7 = ((AnimaXLoaderRequest) r5).b();
        if (r7 != null) goto L16;
        Uri r8 = null;
    L17:
        String r9 = r8.getPath();
        PolarisFileInputStreamWrapper r10 = new PolarisFileInputStreamWrapper(r9);     // Catch: IOException -> L20
        r2 = y4a.b.c(r10, r10.available());     // Catch: IOException -> L20
    L22:
        if (r2 == null) goto L24;
        AnimaXLoaderResponse r11 = AnimaXLoaderResponse.a(r2);
    L25:
        ((AnimaXLoaderCompletionHandler) r6).a(r11);
        return;
    L24:
        r11 = AnimaXLoaderResponse.b(new Throwable("load file failed, getByteArrayFromFile returned null."));
    L20:
        e = move-exception;
        AnimaXLog.a("ResourceUtil", "Failed to open local file:" + r9 + " , reason: " + e);
        goto L22
    L16:
        r8 = UriProtector.parse(r7);
        goto L17
    L11:
        if (r4.loadImage(r5, r6) == false) goto L13;
        return;
    L5:
        if (r1.containsKey(IAnimaXImageService.class) == false) goto L7;
        r3 = (IAnimaXService) r1.get(IAnimaXImageService.class);
        goto L8
    }
}
