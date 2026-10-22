package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {

    @NonNull
    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";

    @NonNull
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";

    @NonNull
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";

    @NonNull
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";

    @NonNull
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";

    @NonNull
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";

    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";

    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";

    @NonNull
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        final /* synthetic */ ProfileInstallReceiver this$0;

        ResultDiagnostics(ProfileInstallReceiver r10) {
            this.this$0 = r10;
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r10, @Nullable Object r11) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(r10, r11);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r10, @Nullable Object r11) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(r10, r11);
            this.this$0.setResultCode(r10);
        }
    }

    public ProfileInstallReceiver() {
    }

    static void saveProfile(@NonNull ProfileInstaller.DiagnosticsCallback r10) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Process.sendSignal(Process.myPid(), 10);
        int r11 = 12;
    L6:
        r10.onResultReceived(r11, null);
        return;
    L5:
        r11 = 13;
        goto L6
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context r10, @Nullable Intent r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        String r12 = r11.getAction();
        if (ACTION_INSTALL_PROFILE.equals(r12) == false) goto L8;
        ProfileInstaller.writeProfile(r10, b.f393c, new ResultDiagnostics(this), true);
        return;
    L8:
        if (ACTION_SKIP_FILE.equals(r12) == false) goto L18;
        Bundle r13 = r11.getExtras();
        if (r13 == null) goto L30;
        String r14 = r13.getString(EXTRA_SKIP_FILE_OPERATION);
        if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(r14) == false) goto L15;
        ProfileInstaller.writeSkipFile(r10, b.f393c, new ResultDiagnostics(this));
        return;
    L15:
        if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(r14) == false) goto L32;
        ProfileInstaller.deleteSkipFile(r10, b.f393c, new ResultDiagnostics(this));
        return;
    L32:
        return;
    L30:
        return;
    L18:
        if (ACTION_SAVE_PROFILE.equals(r12) == false) goto L21;
        saveProfile(new ResultDiagnostics(this));
        return;
    L21:
        if (ACTION_BENCHMARK_OPERATION.equals(r12) == false) goto L35;
        Bundle r15 = r11.getExtras();
        if (r15 == null) goto L36;
        String r16 = r15.getString(EXTRA_BENCHMARK_OPERATION);
        ResultDiagnostics r17 = new ResultDiagnostics(this);
        if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(r16) == false) goto L27;
        BenchmarkOperation.dropShaderCache(r10, r17);
        return;
    L27:
        r17.onResultReceived(16, null);
        return;
    L36:
        return;
    }
}
