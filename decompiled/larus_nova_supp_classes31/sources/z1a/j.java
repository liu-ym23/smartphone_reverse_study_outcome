package z1a;

import com.larus.utils.logger.FLogger;
import com.ss.android.update.OnUpdateStatusChangedListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements OnUpdateStatusChangedListener {
    public j() {
    }

    public final void b(boolean r4) {
        FLogger.a.i("update_sdk", "onPrepare pre:" + r4);
    }

    public final void c(int r4) {
        FLogger.a.i("update_sdk", "onUpdateStatusChanged status:" + r4);
    }

    public final void a(boolean r4, boolean r5) {
        FLogger.a.i("update_sdk", "downloadResult isSuccess:" + r4 + ",pre:" + r5);
    }

    public final void e(int r3, boolean r4) {
        FLogger.a.i("update_sdk", "saveDownloadInfo etag:,pre:" + r4);
    }

    public final void d(int r4, int r5, boolean r6) {
        FLogger.a.d("update_sdk", "updateProgress byteSoFar:" + r4 + ",contentLength:" + r5 + ",pre:" + r6);
    }
}
