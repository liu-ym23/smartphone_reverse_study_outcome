package com.obric.assistant.impl.databinding;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricActivityRecordAudioRuleWebviewBinding implements ViewBinding {
    public final LinearLayout a;
    public final View b;
    public final ProgressBar c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public ObricActivityRecordAudioRuleWebviewBinding(LinearLayout r1, ImageView r2, View r3, ProgressBar r4, TextView r5, WebView r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
