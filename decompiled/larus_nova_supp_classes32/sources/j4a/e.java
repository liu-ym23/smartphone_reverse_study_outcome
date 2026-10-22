package j4a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    static {
    }

    public static ParcelFileDescriptor a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static Long b(Context r10, Uri r11) {
        if (r11 != null) goto L6;
        return 0L;
    L6:
        if (DocumentsContract.isDocumentUri(r10, r11) == false) goto L38;
        if (TextUtils.equals("com.android.providers.media.documents", r11.getAuthority()) == false) goto L38;
        List r12 = StringsKt.split$default(DocumentsContract.getDocumentId(r11), new String[]{":"}, false, 0, 6, null);
        boolean r1 = false;
        String r4 = (String) ListProtector.get(r12, 0);
        if (TextUtils.equals("image", r4) == false) goto L17;
        Uri r5 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int r6 = a.a;
        if (Build.VERSION.SDK_INT < 29) goto L14;
        r1 = true;
    L14:
        if (r1 == false) goto L32;
        r5 = MediaStore.Images.Media.getContentUri("external_primary");
    L32:
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r12, 1)) == false) goto L34;
        r11 = null;
    L35:
        if (r11 != null) goto L47;
        return null;
    L47:
        if (r11 == null) goto L58;
        if (r10 == null) goto L63;
        ContentResolver r13 = r10.getContentResolver();     // Catch: Throwable -> L55
        if (r13 == null) goto L64;
        ParcelFileDescriptor r14 = a(r13, r11);     // Catch: Throwable -> L55
        if (r14 == null) goto L65;
        return Long.valueOf(r14.getStatSize());
    L65:
        return null;
    L64:
        return null;
    L55:
        th = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(th, "AppFileUtils.getFileSize");
        FLogger.a.e("AppFileUtils", "getFileSize error", th);
        return 0L;
    L63:
        return null;
    L58:
        return null;
    L34:
        Intrinsics.checkNotNull(r5);
        r11 = ContentUris.withAppendedId(r5, CastLongProtector.parseLong((String) ListProtector.get(r12, 1)));
        goto L35
    L17:
        if (TextUtils.equals(LynxResourceModule.VIDEO_TYPE, r4) == false) goto L24;
        r5 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        int r7 = a.a;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        r1 = true;
    L21:
        if (r1 == false) goto L32;
        r5 = MediaStore.Video.Media.getContentUri("external_primary");
        goto L32
    L24:
        if (TextUtils.equals(LynxResourceModule.AUDIO_TYPE, r4) == false) goto L30;
        r5 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        int r8 = a.a;
        if (Build.VERSION.SDK_INT < 29) goto L28;
        r1 = true;
    L28:
        if (r1 == false) goto L32;
        r5 = MediaStore.Audio.Media.getContentUri("external_primary");
        goto L32
    L30:
        r5 = null;
    L38:
        if (TextUtils.equals("media", r11.getAuthority()) == true) goto L47;
        if (r10 != null) goto L61;
        r11 = null;
        goto L47
    L61:
        return Long.valueOf(new PolarisFileWrapper(l4a.a.a(r10, r11)).length());
    L43:
        th = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(th, "AppFileUtils.getFileLength");
        FLogger.a.e("AppFileUtils", "getFileLength error", th);
        return 0L;
    }
}
