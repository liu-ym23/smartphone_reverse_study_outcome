package l4a;

import ae7.d;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r10, Uri r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Uri r0 = null;
        if (r11 == null) goto L107;
        String r1 = r11.getScheme();
        if (TextUtils.isEmpty(r1) == true) goto L90;
        if ("file".equals(r1) == true) goto L90;
        if ("http".equals(r1) == false) goto L14;
        return r11.toString();
    L14:
        if (LynxAccessibilityModule.MSG_CONTENT.equals(r1) == true) goto L16;
    L18:
        int r3 = Build.VERSION.SDK_INT;
        if (DocumentsContract.isDocumentUri(r10, r11) == false) goto L61;
        if (TextUtils.equals("com.android.externalstorage.documents", r11.getAuthority()) == false) goto L26;
        String[] r4 = DocumentsContract.getDocumentId(r11).split(":");
        if ("primary".equalsIgnoreCase(r4[0]) == false) goto L61;
        return Environment.getExternalStorageDirectory() + "/" + r4[1];
    L26:
        if (TextUtils.equals("com.android.providers.downloads.documents", r11.getAuthority()) == false) goto L49;
        String r2 = DocumentsContract.getDocumentId(r11);
        if (r2 == null) goto L33;
        if (r2.startsWith("raw:") == false) goto L33;
        return r2.substring(4);
    L33:
        if (r3 >= 26) goto L35;
        Uri r5 = ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.valueOf(r2).longValue());
    L36:
        String r6 = d.c(r10, r5, null, null);
        if (r6 != null) goto L101;
        String r7 = new PolarisFileWrapper(r10.getCacheDir(), "uri_tmp").getAbsolutePath();     // Catch: IOException -> L91
        ParcelFileDescriptor r12 = d.a(r10.getContentResolver(), r11);     // Catch: IOException -> L91
        if (r12 == null) goto L100;
        PolarisFileInputStreamWrapper r13 = new PolarisFileInputStreamWrapper(r12.getFileDescriptor());     // Catch: IOException -> L91
        PolarisFileOutputStreamWrapper r14 = new PolarisFileOutputStreamWrapper(r7);     // Catch: IOException -> L91
        byte[] r8 = new byte[4096];     // Catch: IOException -> L91
    L42:
        int r9 = r13.read(r8);     // Catch: IOException -> L91
        if (r9 == (-1)) goto L45;
        r14.write(r8, 0, r9);     // Catch: IOException -> L91
        goto L42
    L45:
        r13.close();     // Catch: IOException -> L91
        r14.close();     // Catch: IOException -> L91
        return new PolarisFileWrapper(r7).getAbsolutePath();
    L100:
        return null;
    L101:
        return r6;
    L35:
        r5 = r11;
        goto L36
    L49:
        if (TextUtils.equals("com.android.providers.media.documents", r11.getAuthority()) == false) goto L61;
        String[] r15 = DocumentsContract.getDocumentId(r11).split(":");
        String r16 = r15[0];
        if (TextUtils.equals("image", r16) == false) goto L54;
        r0 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L102:
        return d.c(r10, r0, "_id=?", new String[]{r15[1]});
    L54:
        if (TextUtils.equals(LynxResourceModule.VIDEO_TYPE, r16) == false) goto L57;
        r0 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L102
    L57:
        if (TextUtils.equals(LynxResourceModule.AUDIO_TYPE, r16) == false) goto L102;
        r0 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    L61:
        if (LynxAccessibilityModule.MSG_CONTENT.equals(r1) == false) goto L103;
        r10.getContentResolver();
        if ("com.google.android.apps.photos.contentprovider".equals(r11.getAuthority()) == false) goto L68;
        String r17 = (String) ListProtector.get(r11.getPathSegments(), 2);
        if (r17.startsWith(LynxAccessibilityModule.MSG_CONTENT) == true) goto L104;
    L78:
        String r18 = r11.getLastPathSegment();
        if (TextUtils.isEmpty(r18) == true) goto L84;
        if (r18.startsWith("/storage/emulated/") == false) goto L84;
        return r18;
    L84:
        if (TextUtils.isEmpty(r18) == true) goto L106;
        if (r18.contains(":") == false) goto L106;
        r18 = r18.split(":")[1];
    L106:
        return d.c(r10, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id= ?", new String[]{r18});
    L104:
        return d.c(r10, UriProtector.parse(r17), null, null);
    L68:
        if ("com.android.fileexplorer.myprovider".equals(r11.getAuthority()) == true) goto L72;
        if ("com.mi.android.globalFileexplorer.myprovider".equals(r11.getAuthority()) == false) goto L78;
    L72:
        if (TextUtils.isEmpty(r11.getPath()) == true) goto L78;
        ArrayList r19 = new ArrayList(r11.getPathSegments());
        ListProtector.remove(r19, 0);
        StringBuilder r110 = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        Iterator r111 = r19.iterator();
    L75:
        if (r111.hasNext() == false) goto L105;
        String r20 = (String) r111.next();
        r110.append("/");
        r110.append(r20);
        goto L75
    L105:
        return r110.toString();
    L103:
        return null;
    L16:
        if ("media".equals(r11.getAuthority()) == false) goto L18;
        return d.c(r10, r11, null, null);
    L90:
        return r11.getPath();
    L107:
        return null;
    }
}
