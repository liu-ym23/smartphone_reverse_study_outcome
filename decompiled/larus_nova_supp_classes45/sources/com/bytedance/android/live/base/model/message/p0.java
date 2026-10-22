package com.bytedance.android.live.base.model.message;

import android.text.Spannable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface p0 extends x3 {
    String getDefaultContent();

    Spannable getRenderSpan();

    a5 getRichTextContent();

    void setRenderSpan(Spannable r1);
}
