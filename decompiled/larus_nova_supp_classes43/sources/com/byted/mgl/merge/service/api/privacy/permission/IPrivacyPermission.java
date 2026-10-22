package com.byted.mgl.merge.service.api.privacy.permission;

import android.app.Activity;
import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IPrivacyPermission {
    void addPermissionResultListener(OnGlobalPermitListener r1);

    boolean hasPermission(Context r1, String r10);

    boolean hasPermissions(Context r1, String[] r10);

    void removePermissionResultListener(OnGlobalPermitListener r1);

    void requestPermissions(Activity r1, String r10, Set<String> r11, AbsPermitListener r12);

    void requestPermissions(Activity r1, String r10, String[] r11, AbsPermitListener r12);
}
