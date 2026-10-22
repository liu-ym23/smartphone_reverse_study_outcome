package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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

    public class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        final /* synthetic */ ProfileInstallReceiver this$0;

        public ResultDiagnostics(ProfileInstallReceiver r5) {
            this.this$0 = r5;
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r5, @Nullable Object r10) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(r5, r10);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r5, @Nullable Object r10) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(r5, r10);
            this.this$0.setResultCode(r5);
        }
    }

    public ProfileInstallReceiver() {
    }

    public static void saveProfile(@NonNull ProfileInstaller.DiagnosticsCallback r5) {
        Process.sendSignal(Process.myPid(), 10);
        r5.onResultReceived(12, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NonNull Context r5, @Nullable Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.getAction();
        if (ACTION_INSTALL_PROFILE.equals(r11) == false) goto L8;
        ProfileInstaller.writeProfile(r5, new androidx.arch.core.executor.a(2), new ResultDiagnostics(this), true);
        return;
    L8:
        if (ACTION_SKIP_FILE.equals(r11) == false) goto L18;
        Bundle r12 = r10.getExtras();
        if (r12 == null) goto L30;
        String r13 = r12.getString(EXTRA_SKIP_FILE_OPERATION);
        if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(r13) == false) goto L15;
        ProfileInstaller.writeSkipFile(r5, new androidx.arch.core.executor.a(2), new ResultDiagnostics(this));
        return;
    L15:
        if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(r13) == false) goto L32;
        ProfileInstaller.deleteSkipFile(r5, new androidx.arch.core.executor.a(2), new ResultDiagnostics(this));
        return;
    L32:
        return;
    L30:
        return;
    L18:
        if (ACTION_SAVE_PROFILE.equals(r11) == false) goto L21;
        saveProfile(new ResultDiagnostics(this));
        return;
    L21:
        if (ACTION_BENCHMARK_OPERATION.equals(r11) == false) goto L35;
        Bundle r14 = r10.getExtras();
        if (r14 == null) goto L36;
        String r15 = r14.getString(EXTRA_BENCHMARK_OPERATION);
        ResultDiagnostics r16 = new ResultDiagnostics(this);
        if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(r15) == false) goto L27;
        BenchmarkOperation.dropShaderCache(r5, r16);
        return;
    L27:
        r16.onResultReceived(16, null);
        return;
    L36:
        return;
    }
}
