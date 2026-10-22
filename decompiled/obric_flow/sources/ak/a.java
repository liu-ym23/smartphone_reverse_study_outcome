package ak;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.pm.PluginPackageManager;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static String a() {
        wj.a r5 = ik.a.f17574a;
        r5.getClass();
        String r10 = com.bytedance.ies.bullet.lynx.init.a.class.getName();
        Object r11 = r5.f22868a.get(r10);
        if (r11 == null) goto L5;
        com.bytedance.ies.bullet.lynx.init.a r12 = (com.bytedance.ies.bullet.lynx.init.a) r11;
    L6:
        if (r12 != null) goto L9;
        return "";
    L9:
        return "com.ss.android.ugc.aweme.vmsdk_plugin";
    L5:
        r12 = null;
        goto L6
    }

    public static String b(String r5, String r10) {
        if (d() == true) goto L15;
        return "";
    L15:
    L8:
        th = move-exception;
        StringBuilder r11 = com.lynx.tasm.base.a.e("getPluginLibAbsPath failed: soname : lib", r10, ".so, PluginName: ", r5, " error:");
        r11.append(th.getMessage());
        Log.e("VmSdk", r11.toString());
        return "";
    L6:
        if (Pattern.compile("lib\\w+\\.so").matcher(r10).matches() == true) goto L10;
        String r12 = System.mapLibraryName(r10);     // Catch: Throwable -> L8
    L11:
        return new File(PluginDirHelper.getNativeLibraryDir(r5, PluginPackageManager.getInstalledPluginVersion(r5)), r12).getPath();
    L10:
        r12 = r10;
        goto L11
    }

    public static boolean c(String r10) {
        if (d() == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r10 = a();
    L8:
        String[] r5 = {"quick", "napi", "worker"};
        int r11 = 0;
    L10:
        if (r11 >= 3) goto L20;
        String r12 = r5[r11];
        String r13 = b(r10, r12);
        if (TextUtils.isEmpty(r13) == true) goto L13;
        System.load(r13);     // Catch: Throwable -> L17
        Log.d("VmSdk", "loadWorkerLibrary success: soname :" + r13 + ", PluginName: " + r10);
        r11 = r11 + 1;
    L17:
        th = move-exception;
        StringBuilder r14 = com.lynx.tasm.base.a.e("loadWorkerLibrary failed: soname: ", r13, ", PluginName: ", r10, "error:");
        r14.append(th.getMessage());
        Log.e("VmSdk", r14.toString());
        return false;
    L13:
        Log.e("VmSdk", "loadWorkerLibrary failed: so: " + r12 + ", Plugin: " + r10);
        return false;
    L20:
        return true;
    }

    public static boolean d() {
        wj.a r5 = ik.a.f17574a;
        r5.getClass();
        Object r10 = r5.f22868a.get(com.bytedance.ies.bullet.lynx.init.a.class.getName());
        if (r10 == null) goto L5;
        com.bytedance.ies.bullet.lynx.init.a r11 = (com.bytedance.ies.bullet.lynx.init.a) r10;
    L6:
        if (r11 == null) goto L8;
        boolean r12 = true;
    L9:
        Log.d("VmSdk", "isSettingsEnable: " + r12);
        return r12;
    L8:
        r12 = false;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    public static boolean e(String r5) {
        if (d() == true) goto L15;
        return false;
    L15:
    L9:
        th = move-exception;
        Log.e("VmSdk", "preloadPlugin error: " + th.getMessage());
        return false;
    L6:
        if (PluginPackageManager.checkPluginInstalled(r5) == true) goto L11;
        return Mira.loadPlugin(r5);
    L11:
        return true;
    }
}
