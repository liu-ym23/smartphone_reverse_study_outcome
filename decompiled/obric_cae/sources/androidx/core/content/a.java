package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.app.n;
import java.io.File;
import java.util.WeakHashMap;
import z.f;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f1674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1675b = null;

    /* JADX INFO: renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    public static class C0011a {
        public static void a(Context r8, Intent[] r10, Bundle r11) {
            r8.startActivities(r10, r11);
        }

        public static void b(Context r8, Intent r10, Bundle r11) {
            r8.startActivity(r10, r11);
        }
    }

    public static class b {
        public static File a(Context r8) {
            return r8.getCodeCacheDir();
        }

        public static Drawable b(Context r8, int r10) {
            return r8.getDrawable(r10);
        }

        public static File c(Context r8) {
            return r8.getNoBackupFilesDir();
        }
    }

    public static class c {
        public static int a(Context r8, int r10) {
            return r8.getColor(r10);
        }

        public static <T> T b(Context r8, Class<T> r10) {
            return (T) r8.getSystemService(r10);
        }

        public static String c(Context r8, Class<?> r10) {
            return r8.getSystemServiceName(r10);
        }
    }

    public static class d {
        public static Intent a(Context r8, BroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, int r14) {
            if ((r14 & 4) == 0) goto L12;
            if (r12 != null) goto L12;
            Object r15 = a.f1674a;
            String r16 = r8.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
            if (defpackage.c.z(r8, r16) != 0) goto L10;
            return r8.registerReceiver(r10, r11, r16, r13);
        L10:
            throw new RuntimeException(defpackage.b.d("Permission ", r16, " is required by your application to receive broadcasts, please add it to your manifest"));
        L12:
            return r8.registerReceiver(r10, r11, r12, r13, r14 & 1);
        }

        public static ComponentName b(Context r8, Intent r10) {
            return r8.startForegroundService(r10);
        }
    }

    public static class e {
        public static Intent a(Context r8, BroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, int r14) {
            return r8.registerReceiver(r10, r11, r12, r13, r14);
        }
    }

    static {
        f1674a = new Object();
        f1675b = new Object();
    }

    public static int a(Context r8, String r10) {
        if (r10 == null) goto L15;
        if (f0.a.a() == true) goto L13;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r10) == false) goto L13;
        if (new n(r8).f1640b.areNotificationsEnabled() == false) goto L10;
        return 0;
    L10:
        return -1;
    L13:
        return r8.checkPermission(r10, Process.myPid(), Process.myUid());
    L15:
        throw new NullPointerException("permission must be non-null");
    }

    public static ColorStateList b(Context r8, int r10) {
        Resources r11 = r8.getResources();
        Resources.Theme r12 = r8.getTheme();
        f.d r13 = new f.d(r11, r12);
        Object r14 = f.f14148c;
        monitor-enter(r14);
        SparseArray<f.c> r15 = f.f14147b.get(r13);     // Catch: Throwable -> L56
        ColorStateList r16 = null;
        if (r15 != null) goto L7;
    L22:
        monitor-exit(r14);     // Catch: Throwable -> L56
        ColorStateList r17 = null;
    L24:
        if (r17 != null) goto L65;
        ThreadLocal<TypedValue> r18 = f.f14146a;
        TypedValue r19 = r18.get();
        if (r19 != null) goto L29;
        r19 = new TypedValue();
        r18.set(r19);
    L29:
        boolean r20 = true;
        r11.getValue(r10, r19, true);
        int r21 = r19.type;
        if (r21 >= 28) goto L32;
    L34:
        r20 = false;
    L35:
        if (r20 == false) goto L59;
    L42:
        if (r16 == null) goto L55;
        Object r22 = f.f14148c;
        monitor-enter(r22);
        WeakHashMap<f.d, SparseArray<f.c>> r23 = f.f14147b;     // Catch: Throwable -> L51
        SparseArray<f.c> r24 = r23.get(r13);     // Catch: Throwable -> L51
        if (r24 != null) goto L48;
        r24 = new SparseArray();     // Catch: Throwable -> L51
        r23.put(r13, r24);     // Catch: Throwable -> L51
    L48:
        r24.append(r10, new f.c(r16, r13.f14152a.getConfiguration(), r12));     // Catch: Throwable -> L51
        monitor-exit(r22);     // Catch: Throwable -> L51
        return r16;
    L51:
        th = move-exception;
        throw th;
    L55:
        return f.b.b(r11, r10, r12);
    L59:
        r16 = z.b.a(r11, r11.getXml(r10), r12);     // Catch: Exception -> L40
    L40:
        e = move-exception;
        Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
        goto L42
    L32:
        if (r21 > 31) goto L34;
    L65:
        return r17;
    L7:
        if (r15.size() <= 0) goto L22;
        f.c r25 = r15.get(r10);     // Catch: Throwable -> L56
        if (r25 == null) goto L22;
        if (r25.f14150b.equals(r11.getConfiguration()) == false) goto L21;
        if (r12 == null) goto L14;
    L15:
        if (r12 == null) goto L21;
        if (r25.f14151c != r12.hashCode()) goto L21;
    L18:
        r17 = r25.f14149a;     // Catch: Throwable -> L56
        monitor-exit(r14);     // Catch: Throwable -> L56
        goto L24
    L14:
        if (r25.f14151c == 0) goto L18;
    L21:
        r15.remove(r10);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        throw th;
    }
}
