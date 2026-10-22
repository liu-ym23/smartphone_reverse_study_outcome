package com.volcengine.zeus.transform;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.provider.ContentProviderManager;
import com.volcengine.zeus.provider.a;
import com.volcengine.zeus.util.MethodUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class ZeusProviderTransform {
    public ZeusProviderTransform() {
    }

    public static Bundle call(Object r8, Uri r9, String r10, String r11, Bundle r12, String r13) {
        if ((r8 instanceof ContentResolver) == true) goto L5;
        return (Bundle) MethodUtils.invokeMethod(r8, NotificationCompat.CATEGORY_CALL, new Object[]{r9, r10, r11, r12}, new Class[]{Uri.class, String.class, String.class, Bundle.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().call((ContentResolver) r8, r9, r10, r11, r12, r13);
    }

    public static Bundle call(Object r8, String r9, String r10, String r11, Bundle r12, String r13) {
        if ((r8 instanceof ContentResolver) == true) goto L5;
        return (Bundle) MethodUtils.invokeMethod(r8, NotificationCompat.CATEGORY_CALL, new Object[]{r9, r10, r11, r12}, new Class[]{String.class, String.class, String.class, Bundle.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().call((ContentResolver) r8, r9, r10, r11, r12, r13);
    }

    public static int delete(Object r3, Uri r4, Bundle r5, String r6) {
        if ((r3 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r3, "delete", new Object[]{r4, r5}, new Class[]{Uri.class, Bundle.class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().delete((ContentResolver) r3, r4, r5, r6);
    }

    public static int delete(Object r7, Uri r8, String r9, String[] r10, String r11) {
        if ((r7 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r7, "delete", new Object[]{r8, r9, r10}, new Class[]{Uri.class, String.class, String[].class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().delete((ContentResolver) r7, r8, r9, r10, r11);
    }

    public static String getType(Object r3, Uri r4, String r5) {
        if ((r3 instanceof ContentResolver) == true) goto L5;
        return (String) MethodUtils.invokeMethod(r3, "getType", new Object[]{r4}, new Class[]{Uri.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().getType((ContentResolver) r3, r4, r5);
    }

    public static Uri insert(Object r7, Uri r8, ContentValues r9, Bundle r10, String r11) {
        if ((r7 instanceof ContentResolver) == true) goto L5;
        return (Uri) MethodUtils.invokeMethod(r7, "insert", new Object[]{r8, r9, r10}, new Class[]{Uri.class, ContentValues.class, Bundle.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().insert((ContentResolver) r7, r8, r9, r10, r11);
    }

    public static Uri insert(Object r3, Uri r4, ContentValues r5, String r6) {
        if ((r3 instanceof ContentResolver) == true) goto L5;
        return (Uri) MethodUtils.invokeMethod(r3, "insert", new Object[]{r4, r5}, new Class[]{Uri.class, ContentValues.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().insert((ContentResolver) r3, r4, r5, r6);
    }

    public static void notifyChange(Object r4, Uri r5, ContentObserver r6, int r7, String r8) {
        if ((r4 instanceof ContentResolver) == false) goto L5;
        Uri r0 = a.a(r5, r8);
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify plugin proxyUri=" + r0 + ", original uri=" + r5 + ", pluginPkg=" + r8);
        ContentResolver r9 = (ContentResolver) r4;
        r9.notifyChange(r0, r6, r7);
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify host original uri=" + r5 + ", pluginPkg=" + r8);
        r9.notifyChange(r5, r6, r7);
        return;
    L5:
        ZeusLogger.d("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange(3 params, flags)] invoke via reflection");
        MethodUtils.invokeMethod(r4, "notifyChange", new Object[]{r5, r6, Integer.valueOf(r7)}, new Class[]{Uri.class, ContentObserver.class, Integer.TYPE});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void notifyChange(Object r4, Uri r5, ContentObserver r6, String r7) {
        if ((r4 instanceof ContentResolver) == false) goto L5;
        Uri r0 = a.a(r5, r7);
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify plugin proxyUri=" + r0 + ", original uri=" + r5 + ", pluginPkg=" + r7);
        ContentResolver r8 = (ContentResolver) r4;
        r8.notifyChange(r0, r6);
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify host original uri=" + r5 + ", pluginPkg=" + r7);
        r8.notifyChange(r5, r6);
        return;
    L5:
        ZeusLogger.d("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange(2 params)] invoke via reflection");
        MethodUtils.invokeMethod(r4, "notifyChange", new Object[]{r5, r6}, new Class[]{Uri.class, ContentObserver.class});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void notifyChange(Object r4, Uri r5, ContentObserver r6, boolean r7, String r8) {
        if ((r4 instanceof ContentResolver) == false) goto L5;
        Uri r0 = a.a(r5, r8);
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify plugin proxyUri=" + r0 + ", original uri=" + r5 + ", pluginPkg=" + r8);
        ContentResolver r9 = (ContentResolver) r4;
        r9.notifyChange(r0, r6, r7);
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify host original uri=" + r5 + ", pluginPkg=" + r8);
        r9.notifyChange(r5, r6, r7);
        return;
    L5:
        ZeusLogger.d("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange(3 params, sync)] invoke via reflection");
        MethodUtils.invokeMethod(r4, "notifyChange", new Object[]{r5, r6, Boolean.valueOf(r7)}, new Class[]{Uri.class, ContentObserver.class, Boolean.TYPE});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void notifyChange(Object r4, Collection<Uri> r5, ContentObserver r6, int r7, String r8) {
        if ((r4 instanceof ContentResolver) == false) goto L9;
        ArrayList r0 = new ArrayList();
        Iterator<Uri> r2 = r5.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r0.add(a.a(r2.next(), r8));
        goto L6
    L8:
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify plugin proxyUris=" + r0 + ", original uris=" + r5 + ", pluginPkg=" + r8);
        ContentResolver r9 = (ContentResolver) r4;
        r9.notifyChange(r0, r6, r7);
        ZeusLogger.i("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange] notify host original uris=" + r5 + ", pluginPkg=" + r8);
        r9.notifyChange(r5, r6, r7);
        return;
    L9:
        ZeusLogger.d("Zeus/provider_zeus", "[ZeusProviderTransform#notifyChange(Collection)] invoke via reflection");
        MethodUtils.invokeMethod(r4, "notifyChange", new Object[]{r5, r6, Integer.valueOf(r7)}, new Class[]{Collection.class, ContentObserver.class, Integer.TYPE});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Cursor query(Object r8, Uri r9, String[] r10, Bundle r11, CancellationSignal r12, String r13) {
        if ((r8 instanceof ContentResolver) == true) goto L5;
        return (Cursor) MethodUtils.invokeMethod(r8, ChatMessage.TYPE_QUERY, new Object[]{r9, r10, r11, r12}, new Class[]{Uri.class, String[].class, Bundle.class, CancellationSignal.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().query((ContentResolver) r8, r9, r10, r11, r12, r13);
    }

    public static Cursor query(Object r11, Uri r12, String[] r13, String r14, String[] r15, String r16, CancellationSignal r17, String r18) {
        if ((r11 instanceof ContentResolver) == true) goto L5;
        return (Cursor) MethodUtils.invokeMethod(r11, ChatMessage.TYPE_QUERY, new Object[]{r12, r13, r14, r15, r16, r17}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class, CancellationSignal.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().query((ContentResolver) r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static Cursor query(Object r9, Uri r10, String[] r11, String r12, String[] r13, String r14, String r15) {
        if ((r9 instanceof ContentResolver) == true) goto L5;
        return (Cursor) MethodUtils.invokeMethod(r9, ChatMessage.TYPE_QUERY, new Object[]{r10, r11, r12, r13, r14}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class});
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().query((ContentResolver) r9, r10, r11, r12, r13, r14, r15);
    }

    public static void registerContentObserver(Object r3, Uri r4, boolean r5, ContentObserver r6, String r7) {
        if ((r3 instanceof ContentResolver) == false) goto L10;
        ((ContentResolver) r3).registerContentObserver(a.a(r4, r7), r5, r6);
        return;
    L10:
        MethodUtils.invokeMethod(r3, "registerContentObserver", new Object[]{r4, Boolean.valueOf(r5), r6}, new Class[]{Uri.class, Boolean.TYPE, ContentObserver.class});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void unregisterContentObserver(Object r3, ContentObserver r4, String r5) {
        if ((r3 instanceof ContentResolver) == false) goto L10;
        ((ContentResolver) r3).unregisterContentObserver(r4);
        return;
    L10:
        MethodUtils.invokeMethod(r3, "unregisterContentObserver", new Object[]{r4}, new Class[]{ContentObserver.class});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static int update(Object r7, Uri r8, ContentValues r9, Bundle r10, String r11) {
        if ((r7 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r7, BuildConfig.CHANNEL, new Object[]{r8, r9, r10}, new Class[]{Uri.class, ContentValues.class, Bundle.class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().update((ContentResolver) r7, r8, r9, r10, r11);
    }

    public static int update(Object r8, Uri r9, ContentValues r10, String r11, String[] r12, String r13) {
        if ((r8 instanceof ContentResolver) == true) goto L5;
        return ((Integer) MethodUtils.invokeMethod(r8, BuildConfig.CHANNEL, new Object[]{r9, r10, r11, r12}, new Class[]{Uri.class, ContentValues.class, String.class, String[].class})).intValue();
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ContentProviderManager.getInstance().update((ContentResolver) r8, r9, r10, r11, r12, r13);
    }
}
