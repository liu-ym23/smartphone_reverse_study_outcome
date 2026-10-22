package com.lynx.canvas;

import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CanvasPermissionManager {
    private static final String TAG = "KryptonCanvasPermissionManager";

    public CanvasPermissionManager() {
    }

    private static native void nativeOnUserMediaPermissionResponse(long r0, boolean r2);

    public static /* synthetic */ void access$000(long r0, boolean r2) {
        nativeOnUserMediaPermissionResponse(r0, r2);
    }

    private static boolean RequestUserMediaGranted(KryptonApp r1, boolean r2, boolean r3) {
        return DoRequest(r1, r2, r3, null);
    }

    private static boolean DoRequest(KryptonApp r3, boolean r4, boolean r5, KryptonPermissionService.Responder r6) {
        if (r3 != null) goto L5;
    L26:
        return false;
    L5:
        if (r3.isNativeReady() == false) goto L26;
        KryptonPermissionService r7 = (KryptonPermissionService) r3.getService(KryptonPermissionService.class);
        if (r7 != null) goto L12;
        if (r6 == null) goto L11;
        KryptonLLog.i(TAG, "request permission video:" + r4 + " audio:" + r5 + " force allow, no permission service found");
        r6.onResponse(true);
    L11:
        return true;
    L12:
        LinkedList r2 = new LinkedList();
        if (r4 == false) goto L15;
        r2.add(KryptonPermissionService.PermissionType.CAMERA);
    L15:
        if (r5 == false) goto L18;
        r2.add(KryptonPermissionService.PermissionType.RECORD_AUDIO);
    L18:
        if (r7.requestGranted(r2) == false) goto L22;
        if (r6 == null) goto L21;
        r6.onResponse(true);
    L21:
        return true;
    L22:
        if (r6 != null) goto L24;
        return false;
    L24:
        r7.requestPermission(r2, r6);
        return true;
    }

    private static void RequestUserMediaPermission(KryptonApp r1, final boolean r2, final boolean r3, final long r4) {
        DoRequest(r1, r2, r3, new AnonymousClass1(r2, r3, r4));
    }
}
