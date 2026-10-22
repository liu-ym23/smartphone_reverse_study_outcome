package o7;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import bytedance.io.BdMediaFileSystem;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f<T> implements ObservableOnSubscribe {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public f(Context r1, String r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void subscribe(ObservableEmitter<Object> r10) {
        int r11 = k.a;
        Context r12 = this.a;
        String r0 = this.b;
        String r1 = this.c;
        Uri r13 = BdMediaFileSystem.createImageUri(r12, DigestUtils.md5Hex(r0) + ".png");
        PolarisFileInputStreamWrapper r14 = null;
        PolarisFileInputStreamWrapper r15 = ContentResolverWrapper.openOutputStream(r12.getContentResolver(), r13);     // Catch: Throwable -> L21
        PolarisFileInputStreamWrapper r16 = new PolarisFileInputStreamWrapper(r1);     // Catch: Throwable -> L40
    L50:
        int r17 = r16.read();     // Catch: Throwable -> L19
        if (r17 == (-1)) goto L9;
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L19
        r15.write(r17);     // Catch: Throwable -> L19
        goto L50
    L9:
        if (r15 == null) goto L46;
        r15.close();     // Catch: Throwable -> L38
    L46:
        r16.close();     // Catch: Throwable -> L13
    L14:
        Intent r18 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        r18.setData(r13);
        r12.sendBroadcast(r18);
        PolarisFileWrapper r19 = new PolarisFileWrapper(r1);
        if (r19.exists() == true) goto L17;
        return;
    L17:
        if (r19.isFile() == false) goto L65;
        r19.delete();
        return;
    L65:
        return;
    L19:
        r14 = r16;
    L20:
        PolarisFileInputStreamWrapper r20 = r14;
        r14 = r15;
    L60:
        k.b(r12);     // Catch: Throwable -> L30
        if (r14 != null) goto L48;
    L27:
        if (r20 == null) goto L67;
        r20.close();     // Catch: Throwable -> L39
        return;
    L68:
        return;
    L67:
        return;
    L48:
        r14.close();     // Catch: Throwable -> L26
    L30:
        th = move-exception;
        if (r14 != null) goto L44;
    L35:
        if (r20 == null) goto L69;
        r20.close();     // Catch: Throwable -> L41
        throw th;
    L70:
        throw th;
    L69:
        throw th;
    L44:
        r14.close();     // Catch: Throwable -> L34
    L21:
        r20 = null;
        goto L60
    }
}
