package com.larus.avlink.gallery;

import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e {
    public static final e a = null;
    public static final Lazy b = null;

    public e() {
    }

    public static void a() {
        Iterator r0 = CollectionsKt.listOf(new File[]{c(), g(), f(), e(), d(), new PolarisFileWrapper(b(), "failed")}).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        File r1 = (File) r0.next();
        if (r1.exists() == true) goto L4;
        r1.mkdirs();
        goto L4
    }

    static {
        a = new e();
        b = LazyKt.lazy(new d());
    }

    public static PolarisFileWrapper b() {
        return new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir(), m());
    }

    public static PolarisFileWrapper c() {
        return new PolarisFileWrapper(b(), "downloads");
    }

    public static PolarisFileWrapper d() {
        return new PolarisFileWrapper(b(), "final");
    }

    public static PolarisFileWrapper e() {
        return new PolarisFileWrapper(b(), "processed");
    }

    public static PolarisFileWrapper f() {
        return new PolarisFileWrapper(b(), "processing");
    }

    public static PolarisFileWrapper g() {
        return new PolarisFileWrapper(b(), "temp");
    }

    public static boolean i() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static String m() {
        String r0 = IApplog.a.getUserID();
        StringBuilder r1 = new StringBuilder();
        int r2 = r0.length();
        boolean r3 = false;
        int r4 = 0;
    L3:
        boolean r5 = true;
        if (r4 >= r2) goto L16;
        char r6 = r0.charAt(r4);
        if (Character.isLetterOrDigit(r6) == false) goto L8;
    L13:
        if (r5 == false) goto L15;
        r1.append(r6);
    L15:
        r4 = r4 + 1;
        goto L3
    L8:
        if (r6 == '-') goto L13;
        if (r6 == '_') goto L13;
        r5 = false;
        goto L13
    L16:
        String r7 = r1.toString();
        if (r7.length() != 0) goto L19;
        r3 = true;
    L19:
        if (r3 == false) goto L22;
        r7 = "0";
    L22:
        return "doraG/".concat(r7);
    }

    public static String k() {
        if (i() == false) goto L6;
        return Environment.DIRECTORY_PICTURES + '/' + StringsKt.substringAfterLast$default(AppHost.a.getApplication().getPackageName(), '.', null, 2, null) + "/files/" + m();
    L6:
        return Environment.DIRECTORY_DCIM + '/' + AppHost.a.getApplication().getString(2131894310);
    }

    public static String l() {
        if (i() == false) goto L6;
        return Environment.DIRECTORY_PICTURES + '/' + StringsKt.substringAfterLast$default(AppHost.a.getApplication().getPackageName(), '.', null, 2, null) + "/files/doraG";
    L6:
        return k();
    }

    public static boolean h(String r6) {
        boolean r1 = true;
        String r0 = StringsKt.trim(l(), new char[]{'/'});
        if (r0.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return false;
    L8:
        if (r6 != null) goto L10;
    L12:
        r1 = false;
    L13:
        if (r1 == true) goto L15;
        FLogger.a.w("GalleryPaths", "isDataUnderPublicAlbumRoot: MISS dataPath=" + r6 + ", root=" + r0);
    L15:
        return r1;
    L10:
        if (StringsKt.contains(r6, "/" + r0 + '/', true) != true) goto L12;
    L5:
        r2 = false;
        goto L6
    }

    public static boolean j(String r9) {
        boolean r1 = true;
        String r0 = StringsKt.trimEnd(l(), new char[]{'/'});
        if (r9 != null) goto L6;
        FLogger.a.w("GalleryPaths", "isUnderPublicAlbumRoot: relativePath is null, root=" + r0);
        return false;
    L6:
        String r10 = StringsKt.trimEnd(r9, new char[]{'/'});
        if (r0.length() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        FLogger.a.w("GalleryPaths", "isUnderPublicAlbumRoot: root is empty, path=" + r10);
        return false;
    L13:
        boolean r5 = StringsKt.equals(r10, r0, true);
        if (i() == true) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r5 == true) goto L24;
        if (r6 == true) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L26;
        FLogger.a.d("GalleryPaths", "isUnderPublicAlbumRoot: hit path=" + r10 + ", root=" + r0 + ", exact=" + r5 + ", underSub=" + r6);
    L27:
        return r1;
    L26:
        FLogger.a.w("GalleryPaths", "isUnderPublicAlbumRoot: MISS path=" + r10 + ", root=" + r0 + ", obric=" + i() + " (判否会导致该媒体被视为移出相册)");
        goto L27
    L16:
        if (StringsKt.startsWith(r10, r0.concat("/"), true) == false) goto L18;
        r6 = true;
        goto L19
    L9:
        r4 = false;
        goto L10
    }
}
