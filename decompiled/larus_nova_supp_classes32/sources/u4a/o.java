package u4a;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.animax.loader.AnimaXLoaderCompletionHandler;
import com.lynx.animax.loader.AnimaXLoaderResponse;
import com.lynx.animax.util.AnimaXLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements d8a.g {
    public final /* synthetic */ l a;

    public o(l r1) {
        this.a = r1;
    }

    @Override // d8a.g
    public final void onFailed(d8a.i r4) {
        ((AnimaXLoaderCompletionHandler) this.a).a(AnimaXLoaderResponse.b(new Throwable("LynxResRequest failed with error: " + r4.b + "status code: " + r4.a)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d8a.g
    public final void onSuccess(d8a.i r5) {
        InputStream r0 = r5.d;
        int r1 = 0;
        if (r0 != null) goto L26;
    L20:
        byte[] r6 = y4a.b.c(r0, r1);
        if (r6 == null) goto L23;
        AnimaXLoaderResponse r7 = AnimaXLoaderResponse.a(r6);
    L24:
        ((AnimaXLoaderCompletionHandler) this.a).a(r7);
        return;
    L23:
        r7 = AnimaXLoaderResponse.b(new Throwable("Failed to load raw data with LynxResRequest"));
        goto L24
    L26:
        int r2 = r0.available();     // Catch: IOException -> L7
    L8:
        Map<String, List<String>> r8 = r5.c;
        if (r8 == null) goto L15;
        List<String> r9 = r8.get("content-length");
        if (r9 == null) goto L15;
        if (r9.isEmpty() == true) goto L15;
        r1 = CastIntegerProtector.parseInt((String) ListProtector.get(r9, 0));
    L15:
        if (r2 > 0) goto L19;
        AnimaXLog.b("LynxResourceUtil", "no length from stream, responseContentLength = " + r1);
        if (r1 > 0) goto L20;
    L19:
        r1 = r2;
    L7:
        r2 = 0;
        goto L8
    }
}
