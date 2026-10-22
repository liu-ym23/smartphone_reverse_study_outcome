package com.lynx.tasm.behavior.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a {
    void afterDispatchProcessViewInfo(m r1);

    void afterProcessChildViewInfo(m r1, View r2, long r3);

    void afterProcessViewInfo(m r1);

    void beforeDispatchProcessViewInfo(m r1);

    void beforeProcessChildViewInfo(m r1, View r2, long r3);

    void beforeProcessViewInfo(m r1);

    void processLayoutChildren();

    void processMeasureChildren();
}
