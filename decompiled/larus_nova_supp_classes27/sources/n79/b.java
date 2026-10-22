package n79;

import android.content.Context;
import com.larus.drive.biz.impl.activity.DriveMoveListActivity;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements u79.a {
    public b() {
    }

    @Override // u79.a
    public final void startMoveDriveFileTask(DriveFileItem r9, Context r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "file");
        int r0 = DriveMoveListActivity.h;
        String r2 = r9.b;
        String r3 = r9.c;
        int r4 = r9.d;
        if (r11 == false) goto L5;
        String r12 = "common_refresh_mark_outer";
    L6:
        DriveMoveListActivity.a.a(r10, r2, r3, r4, null, null, r12);
        return;
    L5:
        r12 = null;
        goto L6
    }
}
