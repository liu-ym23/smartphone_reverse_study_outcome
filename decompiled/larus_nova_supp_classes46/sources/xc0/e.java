package xc0;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;

    public e(d r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<String> r6) {
        Intrinsics.checkNotNullParameter(r6, "emitter");
        d r0 = this.a;
        String r1 = this.b;
        r0.getClass();
        String r2 = null;
        InputStreamReader r3 = null;
        r3 = null;
        r2 = null;
        if (new PolarisFileWrapper(r1).exists() == true) goto L58;
    L45:
        if (r2 != null) goto L47;
        r2 = "";
    L47:
        r6.onNext(r2);
        r6.onComplete();
        return;
    L58:
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r1);     // Catch: Throwable -> L18 IOException -> L20
    L60:
        InputStreamReader r5 = new InputStreamReader(r4, "UTF-8");     // Catch: Throwable -> L14 IOException -> L16
        char[] r7 = new char[r4.available()];     // Catch: IOException -> L12 Throwable -> L34
        r5.read(r7);     // Catch: IOException -> L10 Throwable -> L34
        r5.close();     // Catch: IOException -> L10 Throwable -> L34
        r4.close();     // Catch: IOException -> L10 Throwable -> L34
        r5.close();     // Catch: IOException -> L26
    L29:
        r4.close();     // Catch: IOException -> L26
    L32:
        if (r7 == null) goto L45;
        r2 = new String(r7);
    L10:
        IOException e = e;
    L23:
        e.printStackTrace();     // Catch: Throwable -> L34
        if (r5 == null) goto L28;
        r5.close();     // Catch: IOException -> L26
    L28:
        if (r4 == null) goto L32;
    L12:
        e = move-exception;
        e = e;
        r7 = null;
    L34:
        th = th;
        r3 = r5;
    L36:
        if (r3 != null) goto L56;
    L40:
        if (r4 == null) goto L44;
        r4.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L44:
        throw th;
    L56:
        r3.close();     // Catch: IOException -> L38
        goto L40
    L16:
        e = move-exception;
        e = e;
    L22:
        r5 = null;
        r7 = null;
    L14:
        th = th;
    L20:
        e = move-exception;
        e = e;
        r4 = null;
    L18:
        th = th;
        r4 = null;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }
}
