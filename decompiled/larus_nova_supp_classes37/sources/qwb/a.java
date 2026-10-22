package qwb;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.qrcode.api.IQRCodeResultHandler;
import kotlin.jvm.internal.Intrinsics;
import ova.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements IQRCodeResultHandler {

    /* JADX INFO: renamed from: qwb.a$a, reason: collision with other inner class name */
    public static final class C0182a {
    }

    static {
    }

    public a() {
    }

    @Override // com.ss.android.lark.officesdk.qrcode.api.IQRCodeResultHandler
    public final boolean a(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Intrinsics.checkNotNullParameter(r3, "context");
        Uri r4 = UriProtector.parse(r2);     // Catch: Throwable -> L14
        if (f.m().h(r3, r4) == false) goto L21;
        f r0 = f.m();     // Catch: Throwable -> L14
        monitor-enter(r0);     // Catch: Throwable -> L14
        r0.x(r3, r4);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L21:
        return false;
    L14:
        th = move-exception;
        Log.e("AppLinkQrcodeHandler", "handle qrcode result failed : " + th.getMessage(), th);
        return false;
    }
}
