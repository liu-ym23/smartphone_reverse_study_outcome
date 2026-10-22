package com.obric.memorydata.screencapture.service;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface IMemoryAccessibilityDelegate {
    void onAccessibilityEvent(AccessibilityEvent r1);

    void onDestroy();

    void onInterrupt();

    void onServiceConnected(AccessibilityService r1);
}
