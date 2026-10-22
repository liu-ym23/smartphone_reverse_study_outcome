package com.byted.mgl.merge.service.api.privacy.permission;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface OnGlobalPermitListener {
    void onPermissionNeverAsk(String[] r1, int[] r10, String[] r11);

    void onPermissionResult(String r1, PermitResult.Type r10);
}
