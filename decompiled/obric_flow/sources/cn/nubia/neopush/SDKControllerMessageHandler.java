package cn.nubia.neopush;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import cn.nubia.neopush.commons.Constant;
import cn.nubia.neopush.commons.NeoLog;

/* JADX INFO: loaded from: classes.dex */
public class SDKControllerMessageHandler {
    public SDKControllerMessageHandler() {
    }

    public static /* synthetic */ void access$0(Context r5) {
        requestUpgrade(r5);
    }

    private static int getPackageCode(Context r5, String r10) {
        int r11 = 0;
        PackageInfo r12 = r5.getPackageManager().getPackageInfo(r10, 16384);     // Catch: PackageManager.NameNotFoundException -> L5
        r11 = r12.versionCode;     // Catch: PackageManager.NameNotFoundException -> L5
        NeoLog.i("luzhi", "neopush packageinfo  " + r12.versionCode + "   " + r12.packageName);     // Catch: PackageManager.NameNotFoundException -> L5
        return r11;
    L5:
        e = move-exception;
        e.printStackTrace();
        return r11;
    }

    public static void handlePassthroughMessage(final String r5, final Context r10) {
        new Thread(new AnonymousClass1(r5, r10)).start();
    }

    private static void requestUpgrade(Context r5) {
        if (r5 == null) goto L15;
        int r10 = getPackageCode(r5, Constant.CONTROL_APP_PACKAGES_NAME);
        if (r10 <= 155) goto L6;
        return;
    L6:
        if (r10 < 119) goto L17;
        Intent r11 = new Intent();     // Catch: Exception -> L12
        r11.setAction(Constant.CHECK_UPDATE_ACTION);     // Catch: Exception -> L12
        NeoLog.i("luzhi", "luzhi have send update broadcast");     // Catch: Exception -> L12
        if (getPackageCode(r5, Constant.CONTROL_APP_PACKAGES_NAME) < 124) goto L10;
        r11.setData(Uri.parse("package://"));     // Catch: Exception -> L12
    L10:
        r5.sendBroadcast(r11);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L17:
        return;
    }
}
