package com.obric.assistant.permission;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricPermissionService$Companion {
    public static final /* synthetic */ IObricPermissionService$Companion a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static final List<String> d = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "GRANTED", "DENIED", "LIMITED_GRANTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ObricPermissionStatus extends Enum<ObricPermissionStatus> {
        public static final ObricPermissionStatus DENIED = null;
        public static final ObricPermissionStatus GRANTED = null;
        public static final ObricPermissionStatus LIMITED_GRANTED = null;
        public static final /* synthetic */ ObricPermissionStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ObricPermissionStatus> getEntries() {
            return b;
        }

        static {
            ObricPermissionStatus r0 = new ObricPermissionStatus("GRANTED", 0);
            GRANTED = r0;
            ObricPermissionStatus r1 = new ObricPermissionStatus("DENIED", 1);
            DENIED = r1;
            ObricPermissionStatus r3 = new ObricPermissionStatus("LIMITED_GRANTED", 2);
            LIMITED_GRANTED = r3;
            ObricPermissionStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ObricPermissionStatus[] values() {
            return (ObricPermissionStatus[]) a.clone();
        }

        public static ObricPermissionStatus valueOf(String r1) {
            return (ObricPermissionStatus) a.a(ObricPermissionStatus.class, r1);
        }

        public ObricPermissionStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public IObricPermissionService$Companion() {
    }

    static {
        a = new IObricPermissionService$Companion();
        ArrayList r0 = new ArrayList();
        r0.add("android.permission.RECORD_AUDIO");
        r0.add("android.permission.READ_SMS");
        r0.add("android.permission.READ_CONTACTS");
        r0.add("android.permission.READ_CALL_LOG");
        r0.add("android.permission.READ_CALENDAR");
        r0.add("android.permission.WRITE_CALENDAR");
        r0.add("android.permission.ACCESS_COARSE_LOCATION");
        r0.add("android.permission.ACCESS_FINE_LOCATION");
        int r8 = Build.VERSION.SDK_INT;
        if (r8 < 29) goto L6;
        r0.add("android.permission.ACCESS_BACKGROUND_LOCATION");
    L6:
        if (r8 < 31) goto L9;
        r0.add("android.permission.BLUETOOTH_CONNECT");
    L9:
        if (r8 < 31) goto L12;
        r0.add("android.permission.BLUETOOTH_SCAN");
    L12:
        if (r8 < 31) goto L15;
        r0.add("android.permission.BLUETOOTH_ADVERTISE");
    L15:
        if (r8 < 33) goto L18;
        r0.add("android.permission.NEARBY_WIFI_DEVICES");
    L18:
        if (r8 < 33) goto L21;
        r0.add("android.permission.POST_NOTIFICATIONS");
    L21:
        if (r8 < 33) goto L24;
        r0.add("android.permission.READ_MEDIA_IMAGES");
    L24:
        if (r8 < 33) goto L26;
        r0.add("android.permission.READ_MEDIA_VIDEO");
    L26:
        r0.add("com.android.permission.GET_INSTALLED_APPS");
        b = CollectionsKt.toList(r0);
        ArrayList r1 = new ArrayList();
        r1.add("android.permission.RECORD_AUDIO");
        r1.add("android.permission.READ_SMS");
        r1.add("android.permission.READ_CONTACTS");
        r1.add("android.permission.READ_CALL_LOG");
        r1.add("android.permission.READ_CALENDAR");
        r1.add("android.permission.WRITE_CALENDAR");
        r1.add("android.permission.ACCESS_FINE_LOCATION");
        if (r8 < 31) goto L29;
        r1.add("android.permission.BLUETOOTH_CONNECT");
    L29:
        if (r8 < 31) goto L31;
        r1.add("android.permission.BLUETOOTH_SCAN");
    L31:
        if (r8 < 31) goto L34;
        r1.add("android.permission.BLUETOOTH_ADVERTISE");
    L34:
        if (r8 < 33) goto L36;
        r1.add("android.permission.NEARBY_WIFI_DEVICES");
    L36:
        if (r8 < 33) goto L38;
        r1.add("android.permission.POST_NOTIFICATIONS");
    L38:
        if (r8 < 33) goto L40;
        r1.add("android.permission.READ_MEDIA_IMAGES");
    L40:
        if (r8 < 33) goto L42;
        r1.add("android.permission.READ_MEDIA_VIDEO");
    L42:
        r1.add("com.android.permission.GET_INSTALLED_APPS");
        c = CollectionsKt.toList(r1);
        ArrayList r2 = new ArrayList();
        r2.add("android.permission.RECORD_AUDIO");
        d = CollectionsKt.toList(r2);
    }
}
