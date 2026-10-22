package androidx.profileinstaller;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends PluginBroadcastReceiver {
    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        final /* synthetic */ ProfileInstallReceiver this$0;

        ResultDiagnostics(ProfileInstallReceiver r1) {
            this.this$0 = r1;
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int r1, Object r2) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(r1, r2);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int r2, Object r3) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(r2, r3);
            this.this$0.setResultCode(r2);
        }
    }

    public ProfileInstallReceiver() {
    }

    static void saveProfile(ProfileInstaller.DiagnosticsCallback r3) {
        ProfileInstaller.DiagnosticsCallback r4 = (ProfileInstaller.DiagnosticsCallback) ZeusTransformUtils.wrapperContextForParams(r3, ProfileInstaller.DiagnosticsCallback.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Process.sendSignal(Process.myPid(), 10);
        int r0 = 12;
    L6:
        r4.onResultReceived(r0, null);
        return;
    L5:
        r0 = 13;
        goto L6
    }

    public void onReceive(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        String r0 = r4.getAction();
        if (ACTION_INSTALL_PROFILE.equals(r0) == false) goto L9;
        ProfileInstaller.writeProfile(r5, $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, new ResultDiagnostics(this), true);
        return;
    L9:
        if (ACTION_SKIP_FILE.equals(r0) == false) goto L19;
        Bundle r6 = r4.getExtras();
        if (r6 == null) goto L31;
        String r7 = r6.getString(EXTRA_SKIP_FILE_OPERATION);
        if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(r7) == false) goto L16;
        ProfileInstaller.writeSkipFile(r5, $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, new ResultDiagnostics(this));
        return;
    L16:
        if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(r7) == false) goto L33;
        ProfileInstaller.deleteSkipFile(r5, $$Lambda$PNiE7SuEFxRjAZH7pJpZIFOFjWg.INSTANCE, new ResultDiagnostics(this));
        return;
    L33:
        return;
    L31:
        return;
    L19:
        if (ACTION_SAVE_PROFILE.equals(r0) == false) goto L22;
        saveProfile(new ResultDiagnostics(this));
        return;
    L22:
        if (ACTION_BENCHMARK_OPERATION.equals(r0) == false) goto L36;
        Bundle r8 = r4.getExtras();
        if (r8 == null) goto L37;
        String r9 = r8.getString(EXTRA_BENCHMARK_OPERATION);
        ResultDiagnostics r1 = new ResultDiagnostics(this);
        if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(r9) == false) goto L28;
        BenchmarkOperation.dropShaderCache(r5, r1);
        return;
    L28:
        r1.onResultReceived(16, null);
        return;
    L37:
        return;
    }
}
