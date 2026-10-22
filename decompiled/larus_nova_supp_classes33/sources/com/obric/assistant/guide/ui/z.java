package com.obric.assistant.guide.ui;

import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import com.obric.assistant.impl.databinding.ObricActivityRecordAudioRuleWebviewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class z extends WebChromeClient {
    public final /* synthetic */ ObricActivityRecordAudioRuleWebviewBinding a;

    public z(ObricActivityRecordAudioRuleWebviewBinding r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r2, int r3) {
        if (r3 != 100) goto L5;
        this.a.c.setVisibility(4);
        this.a.c.setProgress(0);
        return;
    L5:
        this.a.c.setVisibility(0);
        if (Build.VERSION.SDK_INT < 24) goto L8;
        this.a.c.setProgress(r3, true);
        return;
    L8:
        this.a.c.setProgress(r3);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r1, String r2) {
        TextView r3 = this.a.d;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r3.setText(r2);
    }
}
