package com.larus.drive.biz.impl.file;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.impl.activity.DriveFileSelectProxyActivity;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.service.i2;
import com.larus.platform.service.n0;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveLocalFileSelector {
    public static final DriveLocalFileSelector a = null;
    public static WeakReference<u> b;
    public static long c;

    static {
        a = new DriveLocalFileSelector();
    }

    public DriveLocalFileSelector() {
    }

    public static Activity e() {
        AppHost.Companion r0 = AppHost.a;
        Activity r1 = r0.a().getCurrentActivity();
        if ((r1 instanceof DriveFileSelectProxyActivity) == false) goto L6;
        FLogger r2 = FLogger.a;
        r2.i("DriveLocalFileSelector", "getRealTopActivity: result is DriveFileSelectProxyActivity[" + r1 + ']');
        Activity r3 = r0.a().a(r1, null);
        r2.i("DriveLocalFileSelector", "getRealTopActivity: real result is DriveFileSelectProxyActivity[" + r3 + ']');
        return r3;
    L6:
        return r1;
    }

    public static void h(u r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        WeakReference<u> r0 = b;
        if (r0 == null) goto L5;
        u r1 = r0.get();
    L7:
        if (Intrinsics.areEqual(r1, r2) == true) goto L9;
        return;
    L9:
        b = null;
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static void b(Fragment r6, Function0 r7) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6), Dispatchers.getIO(), null, new DriveLocalFileSelector$checkStorageBeforeUpload$1(r6, r7, null), 2, null);
    }

    public static void d(Fragment r2, final Function0 r3) {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        List r0 = CollectionsKt.mutableListOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
        i2 r1 = i2.b;
        i2.q(r2, r0, new h(r3));
        return;
    L5:
        r3.invoke();
    }

    public static Pair g(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        Cursor r5 = c(r3.getContentResolver(), r4, new String[]{"_display_name"});     // Catch: Throwable -> L22
        if (r5 == null) goto L31;
        Cursor r6 = r5;     // Catch: Throwable -> L22
        Cursor r7 = r6;     // Catch: Throwable -> L15
        int r0 = r7.getColumnIndex("_display_name");     // Catch: Throwable -> L15
        if (r0 >= 0) goto L9;
    L11:
        String r8 = null;
    L12:
        Pair r1 = new Pair(Boolean.TRUE, r8);     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L22
        return r1;
    L9:
        if (r7.moveToFirst() == false) goto L11;
        r8 = r7.getString(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L31:
        return new Pair(Boolean.FALSE, null);
    L22:
        th = move-exception;
        FLogger.a.e("DriveLocalFileSelector", "queryDisplayName failed", th);
        return new Pair(Boolean.FALSE, null);
    }

    public static Cursor c(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public static final void a(DriveLocalFileSelector r10, final Context r11, List r12, int r13, u r14) {
        r10.getClass();
        List r15 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L73;
        Uri r1 = (Uri) r16.next();
        if (n0.a.b() == true) goto L72;
        a.getClass();
        Long r4 = null;
        String r5 = r1.getScheme();     // Catch: Throwable -> L66
        if (r5 == null) goto L11;
        String r6 = r5.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L66
    L13:
        if (Intrinsics.areEqual(r6, "content") == false) goto L47;
        Cursor r7 = c(r11.getContentResolver(), r1, new String[]{"_size"});     // Catch: Throwable -> L66
        if (r7 == null) goto L31;
        Cursor r8 = r7;     // Catch: Throwable -> L66
        Cursor r9 = r8;     // Catch: Throwable -> L26
        int r2 = r9.getColumnIndex("_size");     // Catch: Throwable -> L26
        if (r2 >= 0) goto L20;
    L23:
        Long r3 = null;
    L24:
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L66
    L32:
        if (r3 != null) goto L34;
    L36:
        AssetFileDescriptor r17 = ContentResolverWrapper.openAssetFileDescriptor(r11.getContentResolver(), r1, "r");     // Catch: Throwable -> L66
        if (r17 != null) goto L80;
    L68:
        if (r4 == null) goto L72;
        if (r4.longValue() <= 314572800) goto L72;
        FLogger.a.i("DriveLocalFileSelector", "reject due to large file size: size[" + r4 + ']');
        new Handler(Looper.getMainLooper()).postDelayed(new a(r11), 500);
        r14.b(new Throwable("reject due to large file size: size[" + r4 + ']'));
        return;
    L80:
        Long r18 = Long.valueOf(r17.getLength());     // Catch: Throwable -> L41
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L66
        r4 = r18;
        goto L68
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L34:
        if (r3.longValue() < 0) goto L36;
    L65:
        r4 = r3;
        goto L68
    L20:
        if (r9.moveToFirst() == false) goto L23;
        r3 = Long.valueOf(r9.getLong(r2));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L66
        throw th;     // Catch: Throwable -> L66
    L31:
        r3 = null;
        goto L32
    L47:
        if (Intrinsics.areEqual(r6, "file") == false) goto L68;
        String r20 = r1.getPath();     // Catch: Throwable -> L66
        if (r20 != null) goto L51;
    L54:
        boolean r21 = true;
    L55:
        if (r21 == true) goto L68;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L59
        Object r23 = Result.constructor-impl(Long.valueOf(new PolarisFileWrapper(r20).length()));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r23) == false) goto L64;
        r23 = null;
    L64:
        r3 = (Long) r23;     // Catch: Throwable -> L66
    L59:
        th = move-exception;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L66
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L66
        goto L62
    L51:
        if (r20.length() == 0) goto L54;
        r21 = false;
        goto L55
    L11:
        r6 = null;
    L66:
        th = move-exception;
        FLogger.a.e("DriveLocalFileSelector", "queryFileSize failed", th);
    L72:
        a.getClass();
        Pair r25 = g(r11, r1);
        r0.add(new i(r1, (String) r25.getSecond(), r11.getContentResolver().getType(r1), !((Boolean) r25.getFirst()).booleanValue()));
        goto L4
    L73:
        switch(r13) {
            case 41701: goto L76;
            case 41702: goto L75;
            default: goto L74;
        };
    L74:
        String r110 = "unknown";
    L77:
        r14.c(r110, r0);
        return;
    L75:
        r110 = "upload_file";
        goto L77
    L76:
        r110 = "upload_pic";
        goto L77
    }

    public static void f(Activity r8, int r9, int r10, Intent r11, long r12) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        if (r12 == c) goto L5;
        return;
    L5:
        WeakReference<u> r13 = b;
        if (r13 == null) goto L87;
        u r14 = r13.get();
        if (r14 != null) goto L11;
        return;
    L11:
        if (r9 == 41701) goto L16;
        if (r9 == 41702) goto L16;
        return;
    L16:
        if (r10 == (-1)) goto L72;
        r14.a();
        return;
    L72:
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L69
        if (r11 == null) goto L21;
        ArrayList r0 = r11.getParcelableArrayListExtra("result.uri.list");     // Catch: Throwable -> L69
    L23:
        if (r0 != null) goto L25;
    L33:
        if (r11 == null) goto L35;
        Uri r1 = r11.getData();     // Catch: Throwable -> L69
    L36:
        if (r11 == null) goto L38;
        ClipData r15 = r11.getClipData();     // Catch: Throwable -> L69
    L39:
        if (r15 == null) goto L50;
        int r3 = r15.getItemCount();     // Catch: Throwable -> L69
        int r4 = 0;
    L41:
        if (r4 >= r3) goto L50;
        ClipData.Item r5 = r15.getItemAt(r4);     // Catch: Throwable -> L69
        if (r5 == null) goto L45;
        Uri r6 = r5.getUri();     // Catch: Throwable -> L69
    L46:
        if (r6 == null) goto L48;
        r2.add(r6);     // Catch: Throwable -> L69
    L48:
        r4 = r4 + 1;     // Catch: Throwable -> L69
        goto L41
    L45:
        r6 = null;
    L50:
        if (r2.isEmpty() == false) goto L54;
        if (r1 == null) goto L54;
        r2.add(r1);     // Catch: Throwable -> L69
    L54:
        if (r2.isEmpty() == false) goto L56;
        r14.b(new IllegalStateException("No uri returned by picker"));     // Catch: Throwable -> L69
        return;
    L56:
        Lazy r16 = t.a;     // Catch: Throwable -> L69
        if (t.h(r2.size()) == true) goto L59;
        new Handler(Looper.getMainLooper()).postDelayed(new b(), 500);     // Catch: Throwable -> L69
        return;
    L59:
        Iterator r17 = r2.iterator();     // Catch: Throwable -> L69
    L61:
        if (r17.hasNext() == false) goto L67;
        r8.getContentResolver().takePersistableUriPermission((Uri) r17.next(), 1);     // Catch: SecurityException -> L65 Throwable -> L69
    L65:
        e = move-exception;
        FLogger.a.e("DriveLocalFileSelector", "takePersistableUriPermission failed", e);     // Catch: Throwable -> L69
        goto L61
    L67:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DriveLocalFileSelector$handleResult$4(r8, r2, r9, r14, null), 2, null);     // Catch: Throwable -> L69
        return;
    L38:
        r15 = null;
        goto L39
    L35:
        r1 = null;
        goto L36
    L25:
        if ((!r0.isEmpty()) == false) goto L33;
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L69
        Iterator r110 = r0.iterator();     // Catch: Throwable -> L69
    L28:
        if (r110.hasNext() == false) goto L32;
        Uri r7 = ((AlbumSelectItem) r110.next()).a;     // Catch: Throwable -> L69
        if (r7 == null) goto L28;
        r18.add(r7);     // Catch: Throwable -> L69
        goto L28
    L32:
        r2.addAll(r18);     // Catch: Throwable -> L69
        goto L54
    L21:
        r0 = null;
    L69:
        th = move-exception;
        FLogger.a.e("DriveLocalFileSelector", "handleResult failed", th);
        r14.b(th);
        return;
    }
}
