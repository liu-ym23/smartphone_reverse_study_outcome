package u4a;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements k {
    public c() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.CONTENT_URI;
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
        if (r8 == null) goto L33;
        Context r9 = AnimaX.e().c;
        if (r9 != null) goto L38;
        AnimaXLog.a("ResourceUtil", "Context is null");
        goto L33
    L38:
        InputStream r10 = ContentResolverWrapper.openInputStream(r9.getContentResolver(), r8);     // Catch: Exception -> L31
        if (r10 != null) goto L39;
        AnimaXLog.a("ResourceUtil", "inputStream is null");     // Catch: Exception -> L31
        goto L33
    L39:
        int r11 = r10.available();     // Catch: IOException -> L28 Exception -> L31
    L29:
        r2 = y4a.b.c(r10, r11);     // Catch: Exception -> L31
    L28:
        r11 = 0;
    L31:
        e = move-exception;
        AnimaXLog.a("ResourceUtil", "readUriFile has Exception:" + e.getMessage());
    L33:
        if (r2 == null) goto L35;
        AnimaXLoaderResponse r12 = AnimaXLoaderResponse.a(r2);
    L36:
        ((AnimaXLoaderCompletionHandler) r6).a(r12);
        return;
    L35:
        r12 = AnimaXLoaderResponse.b(new Throwable("load file failed, getByteArrayFromContentUri returned null."));
        goto L36
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
