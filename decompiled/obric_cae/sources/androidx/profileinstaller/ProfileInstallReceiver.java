package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    public class a implements c.InterfaceC0019c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProfileInstallReceiver f2215a;

        public a(ProfileInstallReceiver r8) {
            this.f2215a = r8;
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void a() {
            c.f2225b.a();
        }

        @Override // androidx.profileinstaller.c.InterfaceC0019c
        public final void b(int r8, Object r10) {
            c.f2225b.b(r8, r10);
            this.f2215a.setResultCode(r8);
        }
    }

    public ProfileInstallReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(r11) == false) goto L8;
        c.b(r8, new i.b(1), new a(this), true);
        return;
    L8:
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(r11) == false) goto L22;
        Bundle r12 = r10.getExtras();
        if (r12 == null) goto L44;
        String r13 = r12.getString("EXTRA_SKIP_FILE_OPERATION");
        if ("WRITE_SKIP_FILE".equals(r13) == false) goto L19;
        v0.d r14 = new v0.d(0);
        a r15 = new a(this);
        String r16 = r8.getApplicationContext().getPackageName();
        PackageInfo r17 = r8.getPackageManager().getPackageInfo(r16, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        c.a(r17, r8.getFilesDir());
        r14.execute(new v0.a(r15, 10, 1, null));
        return;
    L16:
        e = move-exception;
        r14.execute(new v0.a(r15, 7, 1, e));
        return;
    L19:
        if ("DELETE_SKIP_FILE".equals(r13) == false) goto L47;
        i.a r18 = new i.a(1);
        a r19 = new a(this);
        new File(r8.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
        r18.execute(new v0.a(r19, 11, 1, null));
        return;
    L47:
        return;
    L44:
        return;
    L22:
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(r11) == false) goto L25;
        a r20 = new a(this);
        Process.sendSignal(Process.myPid(), 10);
        r20.b(12, null);
        return;
    L25:
        if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(r11) == false) goto L50;
        Bundle r21 = r10.getExtras();
        if (r21 == null) goto L51;
        String r22 = r21.getString("EXTRA_BENCHMARK_OPERATION");
        a r23 = new a(this);
        if ("DROP_SHADER_CACHE".equals(r22) == true) goto L31;
        r23.b(16, null);
        return;
    L31:
        if (Build.VERSION.SDK_INT < 34) goto L33;
        File r24 = r8.createDeviceProtectedStorageContext().getCacheDir();
    L35:
        if (androidx.profileinstaller.a.a(r24) == false) goto L37;
        int r25 = 14;
    L38:
        r23.b(r25, null);
        return;
    L37:
        r25 = 15;
        goto L38
    L33:
        r24 = r8.createDeviceProtectedStorageContext().getCodeCacheDir();
        goto L35
    L51:
        return;
    }
}
