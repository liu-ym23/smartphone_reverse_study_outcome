package c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LauncherApps;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.zte.miboard.cards.R;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f1083a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f1084b = null;

    static {
        if (Build.VERSION.SDK_INT < 35) goto L5;
        boolean r5 = true;
    L6:
        f1083a = r5;
        f1084b = new HashMap();
        return;
    L5:
        r5 = false;
        goto L6
    }

    public static Intent a(Context r5, String r10) {
        Intent r11 = new Intent();
        r11.setAction("android.intent.action.VIEW");
        b(r5, r11);
        r11.addFlags(268435456);
        r11.setData(Uri.parse(r10));
        r11.setComponent(null);
        r11.setSelector(null);
        return r11;
    }

    public static void b(Context r5, Intent r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getPackageName().equals("com.zte.miboard.cardsdemo") == false) goto L7;
        return;
    L7:
        if ((r5 instanceof Activity) == true) goto L11;
        r10.addFlags(32768);
        return;
    }

    public static boolean c(long r5) {
        long r10 = System.currentTimeMillis();
        SimpleDateFormat r11 = f("yyyyMMdd");
        return r11.format(Long.valueOf(r10)).equals(r11.format(Long.valueOf(r5)));
    }

    public static boolean d(Context r5, String r10, String r11) {
        Intent r12 = a(r5, r11);     // Catch: Exception -> L5
        r12.setPackage(r10);     // Catch: Exception -> L5
        r5.startActivity(r12);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        m.j("Utils", androidx.constraintlayout.motion.widget.a.p("jumpToAtyByData error. pkgName=", r10, " data= ", r11), e);
        return false;
    }

    public static boolean e(Context r5, boolean r10, String r11) {
        if (r10 == false) goto L4;
        String r12 = "zte.com.market";
    L5:
        String r13 = "market://details?id=";
        if (r10 == false) goto L8;
        String r14 = "zte_market://appdetails?pname=";
    L10:
        if (TextUtils.isEmpty(r11) == false) goto L12;
        r12 = null;
    L18:
        Intent r15 = new Intent("android.intent.action.VIEW");     // Catch: Exception -> L15
        r15.setData(Uri.parse(r13 + r11));     // Catch: Exception -> L15
        r15.setPackage(r12);     // Catch: Exception -> L15
        r15.addFlags(268435456);     // Catch: Exception -> L15
        r5.startActivity(r15);     // Catch: Exception -> L15
        return true;
    L15:
        e = move-exception;
        m.j("Utils", "jumpAppStoreWithAppStorePkg error.", e);
        return false;
    L12:
        r13 = r14;
        goto L18
    L8:
        r14 = "market://details?id=";
        goto L10
    L4:
        r12 = "cn.nubia.neostore";
        goto L5
    }

    public static SimpleDateFormat f(String r5) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        HashMap r10 = f1084b;
        SimpleDateFormat r11 = (SimpleDateFormat) r10.get(r5);
        if (r11 != null) goto L10;
        SimpleDateFormat r12 = new SimpleDateFormat(r5);
        r10.put(r5, r12);
        return r12;
    L10:
        return r11;
    L9:
        return new SimpleDateFormat(r5);
    }

    public static void g(Context r5, Intent r10) {
        b(r5, r10);     // Catch: Exception -> L4
        r10.addFlags(268435456);     // Catch: Exception -> L4
        r5.startActivity(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        m.j("Utils", "startActivityForResult error", e);
    }

    public static boolean h(Context r5, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L19;
        return false;
    L19:
        boolean r11 = ((LauncherApps) r5.getSystemService("launcherapps")).isPackageEnabled(r10, Process.myUserHandle());     // Catch: Throwable -> L7
    L10:
        if (f1083a == false) goto L21;
        if (r11 == false) goto L21;
        r11 = true;
        r5.getPackageManager().getPackageInfo(r10, 1);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        m.j("Utils", "isAPKInstalled getPackageInfo onError, pkgName=".concat(r10), th);
        return false;
    L21:
        return r11;
    L7:
        th = move-exception;
        m.j("Utils", "isAPKInstalled launcherApps onError, pkgName=".concat(r10), th);
        r11 = false;
        goto L10
    }

    public static boolean i(Context r5, String r10) {
        boolean r11 = e(r5, true, r10);
        if (r11 == true) goto L5;
        r11 = e(r5, false, r10);
    L5:
        if (r11 == true) goto L7;
        r11 = e(r5, false, "");
    L7:
        if (r11 == true) goto L9;
        m.l("Utils", "jumpAppStore error, pkgName=" + r10);
        Toast.makeText(r5, R.string.app_store_uninstalled, 0).show();
    L9:
        return r11;
    }

    public static void j(Context r5, String r10) {
        r5.startActivity(a(r5, r10));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        m.j("Utils", "jumpToAtyByData error. data= " + r10, e);
    }
}
