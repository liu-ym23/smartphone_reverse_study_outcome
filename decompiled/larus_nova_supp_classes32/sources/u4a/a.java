package u4a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
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
public final class a implements k {
    public a() {
    }

    @Override // u4a.k
    public final AnimaXLoaderScheme getScheme() {
        return AnimaXLoaderScheme.ASSET;
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
        Context r9 = AnimaX.e().c;
        if (r9 == null) goto L20;
        AssetManager r10 = r9.getAssets();
    L21:
        if (r10 == null) goto L27;
        String r11 = r8.getPath().substring(1);
        InputStream r12 = r10.open(r11);     // Catch: IOException -> L25
        r2 = y4a.b.c(r12, r12.available());     // Catch: IOException -> L25
    L25:
        e = move-exception;
        AnimaXLog.a("ResourceUtil", "Failed to open asset: " + r11 + " , reason: " + e);
    L27:
        if (r2 != null) goto L29;
        AnimaXLoaderResponse r13 = AnimaXLoaderResponse.b(new Throwable("failed to load asset"));
    L30:
        ((AnimaXLoaderCompletionHandler) r6).a(r13);
        return;
    L29:
        r13 = AnimaXLoaderResponse.a(r2);
        goto L30
    L20:
        r10 = null;
        goto L21
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
