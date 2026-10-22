package com.lynx.tasm.behavior.ui;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    void afterDispatchProcessViewInfo(g0 r5);

    void afterProcessChildViewInfo(g0 r5, View r10, long r11);

    void afterProcessViewInfo(g0 r5);

    void beforeDispatchProcessViewInfo(g0 r5);

    void beforeProcessChildViewInfo(g0 r5, View r10, long r11);

    void beforeProcessViewInfo(g0 r5);

    void processLayoutChildren();

    void processMeasureChildren();
}
