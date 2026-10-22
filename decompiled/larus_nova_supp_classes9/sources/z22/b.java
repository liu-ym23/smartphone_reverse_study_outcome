package z22;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ boolean c;

    public b(String r1, Context r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(ObservableEmitter<Uri> r9) {
        Intrinsics.checkNotNullParameter(r9, "emmit");
        if (FileUtils.isFileEmpty(this.a) == false) goto L6;
        r9.onError(new IllegalArgumentException("文件有问题"));
        return;
    L6:
        Uri r0 = BdMediaFileSystem.createVideoUri(this.b, "live_dy_record_" + System.currentTimeMillis() + ".mp4", "video/mp4", Environment.DIRECTORY_DCIM);
        PolarisFileInputStreamWrapper r1 = null;
        PolarisFileInputStreamWrapper r2 = ContentResolverWrapper.openOutputStream(this.b.getContentResolver(), r0);     // Catch: Throwable -> L44 NullPointerException -> L60 IOException -> L75 FileNotFoundException -> L90
    L133:
        PolarisFileInputStreamWrapper r3 = new PolarisFileInputStreamWrapper(this.a);     // Catch: Throwable -> L36 NullPointerException -> L38 IOException -> L40 FileNotFoundException -> L42
    L135:
        byte[] r4 = new byte[1048576];     // Catch: Throwable -> L28 NullPointerException -> L30 IOException -> L32 FileNotFoundException -> L34
    L11:
        int r5 = r3.read(r4);     // Catch: Throwable -> L28 NullPointerException -> L30 IOException -> L32 FileNotFoundException -> L34
        if (r5 < 0) goto L16;
        if (r2 == null) goto L11;
        r2.write(r4, 0, r5);     // Catch: Throwable -> L28 NullPointerException -> L30 IOException -> L32 FileNotFoundException -> L34
    L16:
        if (r2 != null) goto L127;
    L121:
        r3.close();     // Catch: IOException -> L23
    L26:
        if (this.c == true) goto L105;
    L107:
        if (r1 == null) goto L109;
        r9.onError(r1);
        return;
    L109:
        r9.onNext(r0);
        r9.onComplete();
        Unit r10 = Unit.INSTANCE;
        return;
    L105:
        int r6 = c.a;
        c.b(this.a);
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L127:
        r2.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L34:
        e = move-exception;
        e = e;
        r1 = r2;
    L92:
        if (r1 != null) goto L129;
    L97:
        if (r3 == null) goto L103;
        r3.close();     // Catch: IOException -> L100
    L100:
        e = move-exception;
        e.printStackTrace();
    L103:
        if (this.c == false) goto L106;
    L104:
        r1 = e;
    L106:
        r1 = e;
        goto L107
    L129:
        r1.close();     // Catch: IOException -> L95
    L95:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e = e;
        r1 = r2;
    L77:
        if (r1 != null) goto L125;
    L82:
        if (r3 == null) goto L88;
        r3.close();     // Catch: IOException -> L85
    L85:
        e = move-exception;
        e.printStackTrace();
    L88:
        if (this.c == false) goto L106;
    L125:
        r1.close();     // Catch: IOException -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
    L30:
        e = move-exception;
        e = e;
        r1 = r2;
    L62:
        if (r1 != null) goto L119;
    L67:
        if (r3 == null) goto L73;
        r3.close();     // Catch: IOException -> L70
    L70:
        e = move-exception;
        e.printStackTrace();
    L73:
        if (this.c == false) goto L106;
    L119:
        r1.close();     // Catch: IOException -> L65
    L65:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = th;
        r1 = r3;
    L37:
        PolarisFileInputStreamWrapper r7 = r1;
        r1 = r2;
    L46:
        if (r1 != null) goto L123;
    L51:
        if (r7 == null) goto L57;
        r7.close();     // Catch: IOException -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L57:
        if (this.c == false) goto L142;
        int r8 = c.a;
        c.b(this.a);
        throw th;
    L142:
        throw th;
    L123:
        r1.close();     // Catch: IOException -> L49
    L49:
        e = move-exception;
        e.printStackTrace();
    L42:
        e = move-exception;
        r3 = null;
        r1 = r2;
        e = e;
    L40:
        e = move-exception;
        r3 = null;
        r1 = r2;
        e = e;
    L38:
        e = move-exception;
        r3 = null;
        r1 = r2;
        e = e;
    L36:
        th = th;
    L90:
        e = e;
        r3 = null;
    L75:
        e = e;
        r3 = null;
    L60:
        e = e;
        r3 = null;
    L44:
        th = th;
        r7 = null;
        goto L46
    }
}
