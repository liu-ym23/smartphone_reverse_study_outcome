package com.obric.memorydata.screencapture.service;

import android.accessibilityservice.AccessibilityService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class MemoryAccessibilityRegistry {
    private static IMemoryAccessibilityDelegate sDelegate;
    private static AccessibilityService sService;

    public MemoryAccessibilityRegistry() {
    }

    public static void unregisterDelegate() {
        sDelegate = null;
    }

    public static void onServiceDestroyed() {
        IMemoryAccessibilityDelegate r0 = sDelegate;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        sService = null;
    }

    public static IMemoryAccessibilityDelegate getDelegate() {
        return sDelegate;
    }

    public static void onServiceConnected(AccessibilityService r1) {
        sService = r1;
        IMemoryAccessibilityDelegate r0 = sDelegate;
        if (r0 == null) goto L6;
        r0.onServiceConnected(r1);
        return;
    }

    public static void registerDelegate(IMemoryAccessibilityDelegate r1) {
        sDelegate = r1;
        AccessibilityService r0 = sService;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r1.onServiceConnected(r0);
        return;
    L8:
        return;
    }
}
