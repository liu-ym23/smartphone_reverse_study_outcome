package be8;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r4) {
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        if (Intrinsics.areEqual(r4, "task_skill_entry") == false) goto L7;
    L18:
        return true;
    L7:
        if (StringsKt.startsWith$default(r4, "task_skill_chip_", false, 2, null) == true) goto L18;
        if (Intrinsics.areEqual(r4, "task_device_entry") == true) goto L18;
        if (Intrinsics.areEqual(r4, "task_folder_entry") == true) goto L18;
        if (Intrinsics.areEqual(r4, "task_device_folder_merged_entry") == true) goto L18;
        if (Intrinsics.areEqual(r4, "task_authorization_mode") == true) goto L18;
        if (Intrinsics.areEqual(r4, "task_connector_entry") == true) goto L18;
        return false;
    }
}
