package lfc;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class q extends kfc.b {
    @Override // kfc.b
    public final int d(Context r1, ComponentName r2) {
        return -1;
    }

    @Override // kfc.a
    public final List<String> b() {
        return Arrays.asList(new String[]{"com.vivo.launcher", "com.bbk.launcher2"});
    }

    public q() {
    }

    @Override // kfc.b
    public final boolean e(int r2) {
        if (r2 <= 1) goto L6;
        com.bytedance.push.utils.f.b("VivoHomeBadger", "vv brand only support add 1,but count > 1");
        return false;
    L6:
        return true;
    }

    public static ContentProviderClient g(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // kfc.a
    public final void a(Context r4, ComponentName r5, int r6) throws RedBadgerException {
        if (r4 == null) goto L15;
        if (r5 == null) goto L18;
        if (r6 >= 0) goto L16;
        r6 = 0;
    L16:
        Intent r0 = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");     // Catch: Throwable -> L12
        r0.putExtra(DBDefinition.PACKAGE_NAME, r4.getPackageName());     // Catch: Throwable -> L12
        r0.putExtra("className", r5.getClassName());     // Catch: Throwable -> L12
        r0.putExtra("notificationNum", r6);     // Catch: Throwable -> L12
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r0.addFlags(16777216);     // Catch: Throwable -> L12
    L10:
        r4.sendBroadcast(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    L18:
        return;
    }

    @Override // kfc.b
    public final boolean c(Context r7, ComponentName r8, int r9) {
        boolean r1 = false;
        if (r7 == null) goto L42;
        if (r8 == null) goto L42;
        if (r9 > 0) goto L10;
        com.bytedance.push.utils.f.b("VivoHomeBadger", "count must bigger than 0");
        return false;
    L10:
        if (r9 == 1) goto L12;
        com.bytedance.push.utils.f.i("VivoHomeBadger", "vv only support add 1");
    L12:
        Uri r10 = UriProtector.parse("content://com.vivo.abe.provider.launcher.notification.num");
        Bundle r0 = new Bundle();
        r0.putString("package", r7.getPackageName());
        r0.putString("class", r8.getClassName());
        int r4 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L34
        ContentProviderClient r11 = g(r7.getContentResolver(), r10);     // Catch: Throwable -> L34
        if (r11 != null) goto L47;
    L28:
        if (r11 != null) goto L30;
    L33:
        return false;
    L30:
        if (Build.VERSION.SDK_INT < 24) goto L32;
        r11.close();
        goto L33
    L32:
        r11.release();
        goto L33
    L47:
        Bundle r12 = r11.call("add_badge", null, r0);     // Catch: Throwable -> L24 RemoteException -> L26
        if (r12 == null) goto L20;
        if (r12.getInt("result") != 0) goto L20;
        r1 = true;
        goto L20
    L20:
        if (r4 < 24) goto L22;
        r11.close();
    L23:
        return r1;
    L22:
        r11.release();
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
    L24:
        Throwable th = th;
    L36:
        if (r11 != null) goto L38;
    L41:
        throw th;
    L38:
        if (Build.VERSION.SDK_INT < 24) goto L40;
        r11.close();
        goto L41
    L40:
        r11.release();
    L34:
        th = move-exception;
        th = th;
        r11 = null;
    L42:
        com.bytedance.push.utils.f.b("VivoHomeBadger", "args is null");
        return false;
    }

    @Override // kfc.b
    public final boolean f(Context r7, ComponentName r8, int r9) {
        boolean r1 = false;
        if (r7 == null) goto L39;
        if (r8 == null) goto L39;
        if (r9 > 0) goto L9;
        com.bytedance.push.utils.f.b("VivoHomeBadger", "count must bigger than 0");
        return false;
    L9:
        Uri r0 = UriProtector.parse("content://com.vivo.abe.provider.launcher.notification.num");
        Bundle r2 = new Bundle();
        r2.putString("package", r7.getPackageName());
        r2.putString("class", r8.getClassName());
        r2.putInt("badgenumber", r9);
        int r3 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L31
        ContentProviderClient r10 = g(r7.getContentResolver(), r0);     // Catch: Throwable -> L31
        if (r10 != null) goto L42;
    L25:
        if (r10 != null) goto L27;
    L30:
        return false;
    L27:
        if (Build.VERSION.SDK_INT < 24) goto L29;
        r10.close();
        goto L30
    L29:
        r10.release();
        goto L30
    L42:
        Bundle r11 = r10.call("reduce_badge", null, r2);     // Catch: Throwable -> L21 RemoteException -> L23
        if (r11 == null) goto L17;
        if (r11.getInt("result") != 0) goto L17;
        r1 = true;
        goto L17
    L17:
        if (r3 < 24) goto L19;
        r10.close();
    L20:
        return r1;
    L19:
        r10.release();
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L21:
        Throwable th = th;
    L33:
        if (r10 != null) goto L35;
    L38:
        throw th;
    L35:
        if (Build.VERSION.SDK_INT < 24) goto L37;
        r10.close();
        goto L38
    L37:
        r10.release();
    L31:
        th = move-exception;
        th = th;
        r10 = null;
    L39:
        com.bytedance.push.utils.f.b("VivoHomeBadger", "args is null");
        return false;
    }
}
