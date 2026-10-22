package pd;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface h {
    void b();

    void onFirstScreen(View r1);

    void onLoadFailed(View r1, String r10);

    void onLoadSuccess(View r1);

    void onPageStart(View r1, String r10);

    void onReceivedError(View r1, String r10);

    void onRuntimeReady(View r1);
}
