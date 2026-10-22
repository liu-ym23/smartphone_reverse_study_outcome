package com.bytedance.ai.applet.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/applet/permission/PermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "TRUE", "FALSE", "APPLET_TRUE", "APPLET_FALSE", "APP_TRUE", "APP_FALSE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionStatus extends Enum<PermissionStatus> {
    public static final PermissionStatus APPLET_FALSE = null;
    public static final PermissionStatus APPLET_TRUE = null;
    public static final PermissionStatus APP_FALSE = null;
    public static final PermissionStatus APP_TRUE = null;
    public static final PermissionStatus FALSE = null;
    public static final PermissionStatus TRUE = null;
    public static final /* synthetic */ PermissionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PermissionStatus> getEntries() {
        return b;
    }

    static {
        PermissionStatus r0 = new PermissionStatus("TRUE", 0);
        TRUE = r0;
        PermissionStatus r1 = new PermissionStatus("FALSE", 1);
        FALSE = r1;
        PermissionStatus r10 = new PermissionStatus("APPLET_TRUE", 2);
        APPLET_TRUE = r10;
        PermissionStatus r11 = new PermissionStatus("APPLET_FALSE", 3);
        APPLET_FALSE = r11;
        PermissionStatus r12 = new PermissionStatus("APP_TRUE", 4);
        APP_TRUE = r12;
        PermissionStatus r13 = new PermissionStatus("APP_FALSE", 5);
        APP_FALSE = r13;
        PermissionStatus[] r14 = {r0, r1, r10, r11, r12, r13};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) a.clone();
    }

    public static PermissionStatus valueOf(String r1) {
        return (PermissionStatus) r27.a.a(PermissionStatus.class, r1);
    }

    public PermissionStatus(String r1, int r10) {
        super(r1, r10);
    }
}
