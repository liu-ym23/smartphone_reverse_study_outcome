package com.larus.bmhome.chat.screenshot;

import android.content.ContentUris;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.component.bottom.multimodal.latest.c0;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public class f extends ContentObserver {
    public static final String[] e = null;
    public static final String[] f = null;
    public final Uri a;
    public final WeakReference<Context> b;
    public long c;
    public int d;

    public static final class a {
        public static boolean a(String r9) {
            Intrinsics.checkNotNullParameter(r9, "filePath");
            String r0 = r9.toLowerCase(Locale.ROOT);
            FLogger.a.d("ScreenCaptureUtils", "checkPath: ".concat(r9));
            String[] r1 = f.f;
            int r2 = r1.length;
            int r4 = 0;
        L4:
            if (r4 >= r2) goto L9;
            if (StringsKt.contains$default(r0, r1[r4], false, 2, null) == true) goto L7;
            r4 = r4 + 1;
            goto L4
        L7:
            return true;
        L9:
            String r3 = Build.MANUFACTURER;
            if (r3 != null) goto L12;
        L14:
            boolean r5 = false;
        L15:
            if (r5 == true) goto L17;
        L24:
            return false;
        L17:
            if (StringsKt.contains$default(r9, "/dcim/camera/", false, 2, null) == false) goto L24;
            String[] r10 = f.e;
            int r6 = r10.length;
            int r7 = 0;
        L19:
            if (r7 >= r6) goto L24;
            if (StringsKt.contains$default(r0, r10[r7], false, 2, null) == true) goto L22;
            r7 = r7 + 1;
            goto L19
        L22:
            return true;
        L12:
            if (StringsKt.contains$default(r3.toUpperCase(Locale.getDefault()), "HUAWEI", false, 2, null) == false) goto L14;
            r5 = true;
            goto L15
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.larus.bmhome.chat.screenshot.b) r4).a), Long.valueOf(((com.larus.bmhome.chat.screenshot.b) r3).a));
        }
    }

    static {
        e = new String[]{"tmp.png"};
        f = new String[]{"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
    }

    public void b() {
        f r1 = this;
        r1.c = System.currentTimeMillis();
        Context r0 = r1.b.get();
        if (r0 != null) goto L5;
        return;
    L5:
        String[] r2 = com.larus.bmhome.chat.screenshot.a.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter("date_added", "sortOrder");
        ArrayList r3 = new ArrayList();
        Uri r4 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int r5 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L73
        if (r5 < 30) goto L10;
        boolean r6 = true;
    L11:
        String[] r9 = com.larus.bmhome.chat.screenshot.a.a;
        if (r6 == false) goto L15;
        Cursor r7 = com.larus.bmhome.chat.screenshot.a.a(r0.getContentResolver(), r4, r9, com.larus.bmhome.chat.screenshot.a.c());     // Catch: Throwable -> L73
    L14:
        Cursor r8 = r7;
        if (r8 != null) goto L84;
        ArrayList r10 = r3;
    L60:
        FLogger.a.i("ScreenCaptureUtils", "onUserCaptureScreen ScreenCaptureObserver.onChange，imageCount=" + this.d + ", images.size=" + r10.size());
        if (this.d < r10.size()) goto L64;
        this.d = r10.size();
        return;
    L64:
        this.d = r10.size();
        com.larus.bmhome.chat.screenshot.b r11 = (com.larus.bmhome.chat.screenshot.b) CollectionsKt.firstOrNull(CollectionsKt.sortedWith(r10, new b()));
        if (r11 != null) goto L67;
        return;
    L67:
        String r12 = r11.c;
        if (r12 == null) goto L88;
        a(r12, r11.a, r11.b);
        return;
    L88:
        return;
    L84:
        int r13 = r8.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L71
        int r14 = r8.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L71
        int r15 = r8.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L71
        int r16 = r8.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L71
        int r17 = r8.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L71
        int r18 = r8.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L71
        int r19 = r8.getColumnIndexOrThrow("width");     // Catch: Throwable -> L71
        int r110 = r8.getColumnIndexOrThrow("height");     // Catch: Throwable -> L71
        if (r5 < 29) goto L27;
        boolean r20 = true;
    L28:
        if (r20 == false) goto L30;
        int r21 = r8.getColumnIndexOrThrow("relative_path");     // Catch: Throwable -> L71
    L31:
        int r22 = r8.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L71
        int r23 = (Environment.getExternalStorageDirectory().getPath() + '/').length();     // Catch: Throwable -> L71
    L32:
        if (r8.moveToNext() == false) goto L59;
        com.larus.bmhome.chat.screenshot.b r111 = new com.larus.bmhome.chat.screenshot.b();     // Catch: Throwable -> L57
        ArrayList r112 = r3;
        long r24 = r8.getLong(r13);     // Catch: Throwable -> L57
        r8.getString(r14);     // Catch: Throwable -> L57
        r8.getLong(r15);     // Catch: Throwable -> L57
        int r113 = r13;
        r111.a = r8.getLong(r16);     // Catch: Throwable -> L57
        r8.getString(r17);     // Catch: Throwable -> L57
        r8.getLong(r18);     // Catch: Throwable -> L57
        r8.getInt(r19);     // Catch: Throwable -> L57
        r8.getInt(r110);     // Catch: Throwable -> L57
        if (Build.VERSION.SDK_INT < 29) goto L38;
        boolean r25 = true;
    L40:
        if (r25 == false) goto L51;
        String r26 = r8.getString(r21);     // Catch: Throwable -> L57
        if (r26 != null) goto L48;
        String r27 = r8.getString(r22);     // Catch: Throwable -> L57
        Intrinsics.checkNotNull(r27);     // Catch: Throwable -> L57
        String r28 = File.separator;     // Catch: Throwable -> L57
        int r29 = r16;
        int r210 = r21;
        String r30 = r27.substring(r23, StringsKt.lastIndexOf$default(r27, r28, 0, false, 6, null)) + r28;     // Catch: IndexOutOfBoundsException -> L47 Throwable -> L57
    L50:
        r111.c = r30;     // Catch: Throwable -> L57
    L55:
        r111.b = ContentUris.withAppendedId(r4, r24);     // Catch: Throwable -> L57
        r112.add(r111);     // Catch: Throwable -> L57
        r1 = this;
        r3 = r112;
        r13 = r113;
        r21 = r210;
        r16 = r29;
        goto L32
    L47:
        r111.c = "";     // Catch: Throwable -> L57
    L49:
        r30 = r26;
        goto L50
    L48:
        r29 = r16;
        r210 = r21;
        goto L49
    L51:
        r29 = r16;
        r210 = r21;
        String r31 = r8.getString(r22);     // Catch: Throwable -> L57
        Intrinsics.checkNotNull(r31);     // Catch: Throwable -> L57
        String r32 = File.separator;     // Catch: Throwable -> L57
        r111.c = r31.substring(r23, StringsKt.lastIndexOf$default(r31, r32, 0, false, 6, null)) + r32;     // Catch: IndexOutOfBoundsException -> L54 Throwable -> L57
    L54:
        r111.c = "";     // Catch: Throwable -> L57
        goto L55
    L38:
        r25 = false;
    L57:
        th = th;
    L75:
        if (r8 == null) goto L77;
        r8.close();
    L77:
        throw th;
    L59:
        r10 = r3;
        r8.close();
        goto L60
    L30:
        r21 = 0;
        goto L31
    L27:
        r20 = false;
    L71:
        th = th;
        goto L75
    L15:
        if (r5 < 29) goto L17;
        boolean r33 = true;
    L18:
        if (r33 == false) goto L20;
        r7 = com.larus.bmhome.chat.screenshot.a.b(r0.getContentResolver(), r4, r9, "date_added");     // Catch: Throwable -> L73
        goto L14
    L20:
        r7 = com.larus.bmhome.chat.screenshot.a.b(r0.getContentResolver(), r4, com.larus.bmhome.chat.screenshot.a.b, "date_added");     // Catch: Throwable -> L73
        goto L14
    L17:
        r33 = false;
        goto L18
    L10:
        r6 = false;
    L73:
        th = th;
        r8 = null;
        goto L75
    }

    public final WeakReference<Context> getContext() {
        return this.b;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r2) {
        super.onChange(r2);
        if (AppHost.a.a().isAppBackground() == false) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 33) goto L8;
        String r3 = "android.permission.READ_EXTERNAL_STORAGE";
    L9:
        Context r0 = this.b.get();
        if (r0 != null) goto L13;
        return;
    L13:
        if (ContextCompat.checkSelfPermission(r0, r3) == 0) goto L15;
        return;
    L15:
        b();
        return;
    L8:
        r3 = "android.permission.READ_MEDIA_IMAGES";
        goto L9
    }

    public f(Uri r2, WeakReference r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(null);
        this.a = r2;
        this.b = r3;
        this.c = Long.MIN_VALUE;
        this.d = -1;
    }

    public final void a(String r8, long r9, Uri r11) {
        Intrinsics.checkNotNullParameter(r8, "relativePath");
        long r0 = this.c - (((long) 1000) * r9);
        if (r0 >= 6000) goto L5;
        boolean r2 = true;
    L6:
        boolean r3 = a.a(r8);
        FLogger.a.i("ScreenCaptureUtils", "onUserCaptureScreen ScreenCaptureObserver.dispatchScreenCapture, relativePath=" + r8 + ", dateAdded=" + r9 + ", interval=" + r0 + ", matchDateAdded=" + r2 + ", matchPath=" + r3 + ", uri=" + r11);
        if (r2 == false) goto L16;
        if (r3 == false) goto L22;
        CopyOnWriteArraySet<String> r10 = c0.a;
        String r12 = String.valueOf(r11);
        Intrinsics.checkNotNullParameter(r12, "uriString");
        c0.b.add(r12);
        Iterator<WeakReference<d>> r13 = i.c.iterator();
    L12:
        if (r13.hasNext() == false) goto L23;
        d r14 = r13.next().get();
        if (r14 == null) goto L12;
        r14.a();
        goto L12
    L23:
        return;
    L22:
        return;
    L16:
        return;
    L5:
        r2 = false;
        goto L6
    }
}
