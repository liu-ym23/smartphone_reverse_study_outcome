package em;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderRequest;
import com.lynx.animax.loader.AnimaXLoaderResponse$Type;
import com.lynx.animax.loader.AnimaXLoaderScheme;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.animax.util.AnimaX;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.utils.k;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16834a;

    public /* synthetic */ a(int r5) {
        this.f16834a = r5;
    }

    @Override // em.b
    public final void a(AnimaXLoaderRequest r5, AnimaXLoaderCompletionHandler r10) {
        switch(this.f16834a) {
            case 0: goto L48;
            case 1: goto L79;
            default: goto L4;
        };
    L4:
        gm.a r11 = gm.a.b();
        r11.getClass();
        IAnimaXImageService r12 = (IAnimaXImageService) r11.a(gm.b.f17107b, IAnimaXImageService.class);
        if (r12 != null) goto L7;
    L9:
        String r13 = r5.a();
        byte[] r14 = null;
        if (r13 != null) goto L12;
        Uri r15 = null;
    L13:
        String r16 = r15.getPath();
        FileInputStream r17 = new FileInputStream(r16);     // Catch: IOException -> L18
        int r18 = r17.available();     // Catch: IOException -> L18
        ByteArrayOutputStream r19 = new ByteArrayOutputStream();     // Catch: IOException -> L18
        if (k.n(r17, r19, r18) == false) goto L20;
        r14 = r19.toByteArray();     // Catch: IOException -> L18
    L20:
        if (r14 == null) goto L22;
        q7.a r20 = new q7.a(6, AnimaXLoaderResponse$Type.f9628a, false, r14);
    L23:
        r10.a(r20);
        return;
    L22:
        r20 = new q7.a(6, AnimaXLoaderResponse$Type.f9630c, false, new Throwable("load file failed, getByteArrayFromFile returned null."));
    L18:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "ResourceUtil", "Failed to open local file:" + r16 + " , reason: " + e);
        goto L20
    L12:
        r15 = Uri.parse(r13);
        goto L13
    L7:
        if (r12.loadImage(r5, r10) == false) goto L9;
        return;
    L48:
        gm.a r21 = gm.a.b();
        r21.getClass();
        IAnimaXImageService r22 = (IAnimaXImageService) r21.a(gm.b.f17107b, IAnimaXImageService.class);
        if (r22 != null) goto L51;
    L53:
        String r23 = r5.a();
        byte[] r24 = null;
        if (r23 != null) goto L56;
        Uri r25 = null;
    L57:
        Context r26 = AnimaX.a().f9712c;
        if (r26 == null) goto L60;
        AssetManager r27 = r26.getAssets();
    L61:
        if (r27 == null) goto L69;
        String r28 = r25.getPath().substring(1);
        InputStream r29 = r27.open(r28);     // Catch: IOException -> L67
        int r30 = r29.available();     // Catch: IOException -> L67
        ByteArrayOutputStream r31 = new ByteArrayOutputStream();     // Catch: IOException -> L67
        if (k.n(r29, r31, r30) == false) goto L69;
        r24 = r31.toByteArray();     // Catch: IOException -> L67
    L67:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "ResourceUtil", "Failed to open asset: " + r28 + " , reason: " + e);
    L69:
        if (r24 != null) goto L71;
        q7.a r32 = new q7.a(6, AnimaXLoaderResponse$Type.f9630c, false, new Throwable("failed to load asset"));
    L72:
        r10.a(r32);
        return;
    L71:
        r32 = new q7.a(6, AnimaXLoaderResponse$Type.f9628a, false, r24);
        goto L72
    L60:
        r27 = null;
        goto L61
    L56:
        r25 = Uri.parse(r23);
        goto L57
    L51:
        if (r22.loadImage(r5, r10) == false) goto L53;
        return;
    L79:
        String r33 = r5.a();     // Catch: Throwable -> L34 Exception -> L36
        byte[] r34 = Base64.decode(r33.substring(r33.indexOf("base64,") + 7), 0);     // Catch: Throwable -> L34 Exception -> L36
        JavaOnlyMap r35 = r5.f9627c;
        if (r35 == null) goto L38;
        Object r36 = r35.get("image_width");     // Catch: Throwable -> L34 Exception -> L36
        Object r37 = r35.get("image_height");     // Catch: Throwable -> L34 Exception -> L36
        if ((r36 instanceof Integer) == false) goto L38;
        if ((r37 instanceof Integer) == false) goto L38;
        com.bytedance.frameworks.baselib.network.http.cronet.b r38 = new com.bytedance.frameworks.baselib.network.http.cronet.b(false);     // Catch: Throwable -> L34 Exception -> L36
    L39:
        if (r38 == null) goto L41;
        q7.a r39 = new q7.a(6, AnimaXLoaderResponse$Type.f9629b, false, new d(BitmapFactory.decodeByteArray(r34, 0, r34.length)));     // Catch: Throwable -> L34 Exception -> L36
    L42:
        r10.a(r39);
        return;
    L41:
        r39 = new q7.a(6, AnimaXLoaderResponse$Type.f9628a, false, r34);     // Catch: Throwable -> L34 Exception -> L36
    L38:
        r38 = null;
    L36:
        e = move-exception;
        r10.a(new q7.a(6, AnimaXLoaderResponse$Type.f9630c, false, e));
        return;
    L34:
        th = move-exception;
        r10.a(null);
        throw th;
    }

    @Override // em.b
    public final AnimaXLoaderScheme a() {
        switch(this.f16834a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return AnimaXLoaderScheme.f9633b;
    L7:
        return AnimaXLoaderScheme.d;
    L9:
        return AnimaXLoaderScheme.f9632a;
    }
}
