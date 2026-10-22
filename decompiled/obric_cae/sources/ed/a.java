package ed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f7229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0068a f7230b = null;

    /* JADX INFO: renamed from: ed.a$a, reason: collision with other inner class name */
    public class C0068a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.getAction() == null) goto L38;
            b r11 = a.f7229a;
            Log.d("GlobalConfigManager", "onReceive action: " + r10.getAction());
            String r12 = r10.getStringExtra("feature");     // Catch: Exception -> L9
        L10:
            String r13 = r12;
            String r14 = r10.getStringExtra("gid");     // Catch: Exception -> L13
        L14:
            String r15 = r14;
            if (r10.getIntExtra("is_enable", 1) != 1) goto L17;
            String r16 = "on";
        L18:
            String r17 = r16;
            JSONObject r18 = new JSONObject(r10.getStringExtra("data"));     // Catch: Exception -> L21
        L22:
            JSONObject r19 = r18;
            if (r10.hasExtra("path") == false) goto L25;
            String r20 = r10.getStringExtra("path");
        L26:
            String r21 = r20;
            b r22 = a.f7229a;
            if (r22 == null) goto L37;
            r22.onConfigUpdate(r13, r15, r17, r19, r21);
            return;
        L37:
            return;
        L25:
            r20 = null;
        L21:
            r18 = new JSONObject();
            goto L22
        L17:
            r16 = "off";
        L13:
            r14 = "0";
        L9:
            r12 = "";
            goto L10
        }
    }

    static {
        f7230b = new C0068a();
    }

    public static void a(Context r8, String r10) {
        Intent r11 = new Intent("slardaros.globalconfig.local.get");
        PackageManager r12 = r8.getPackageManager();
        if (r12 != null) goto L5;
        String r13 = "packageManager is null ";
    L11:
        Log.d("GlobalConfigManager", r13);
        return;
    L5:
        List<ResolveInfo> r14 = r12.queryBroadcastReceivers(r11, 0);
        if (r14 != null) goto L9;
        r13 = "resolveInfoList is null ";
        goto L11
    L9:
        if (r14.isEmpty() == false) goto L12;
        r13 = "resolveInfoList is empty ";
        goto L11
    L12:
        r11.setPackage(r14.get(0).activityInfo.packageName);
        r11.putExtra("feature_name", CloudServiceConstants.OSlardars.CAE_ACTION);
        r11.putExtra("gid", r10);
        Log.d("GlobalConfigManager", "getLocalConfigs com.slardaros.caeconfig");
        r8.sendBroadcast(r11);
    }
}
