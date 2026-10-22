package com.larus.drive.sdk.impl.view.preview;

import androidx.fragment.app.Fragment;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public final Fragment a;
    public final int b;
    public final DriveFileItem c;
    public final String d;
    public Fragment e;

    public static final class a {
    }

    static {
    }

    public e(Fragment r2, DriveFileItem r3) {
        Intrinsics.checkNotNullParameter(r2, "parentFragment");
        this.a = r2;
        this.b = 2131370306;
        this.c = r3;
        this.d = "drive_preview_content_container";
    }
}
