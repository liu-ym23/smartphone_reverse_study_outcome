package com.bytedance.android.annie.bridge.method.permission;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/permission/PermissionStatus;", "", "PERMITTED", "DENIED", "UNDETERMINED", "RESTRICTED", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum PermissionStatus extends Enum<PermissionStatus> {
    public static final PermissionStatus DENIED = null;
    public static final PermissionStatus PERMITTED = null;
    public static final PermissionStatus RESTRICTED = null;
    public static final PermissionStatus UNDETERMINED = null;
    public static final /* synthetic */ PermissionStatus[] a = null;

    public static PermissionStatus valueOf(String r1) {
        return (PermissionStatus) r27.a.a(PermissionStatus.class, r1);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) a.clone();
    }

    static {
        PermissionStatus r0 = new PermissionStatus("PERMITTED", 0);
        PERMITTED = r0;
        PermissionStatus r1 = new PermissionStatus("DENIED", 1);
        DENIED = r1;
        PermissionStatus r10 = new PermissionStatus("UNDETERMINED", 2);
        UNDETERMINED = r10;
        PermissionStatus r11 = new PermissionStatus("RESTRICTED", 3);
        RESTRICTED = r11;
        a = new PermissionStatus[]{r0, r1, r10, r11};
    }

    public PermissionStatus(String r1, int r10) {
        super(r1, r10);
    }
}
