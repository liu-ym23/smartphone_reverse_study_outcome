package com.larus.drive.sdk.impl.view.preview;

import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.drive.sdk.impl.databinding.LarusLayoutDrivePreviewFileFragmentBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j implements v79.e {
    public final /* synthetic */ DrivePreviewFragment a;

    public j(DrivePreviewFragment r1) {
        this.a = r1;
    }

    @Override // v79.e
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }

    @Override // v79.e
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        Intrinsics.checkNotNullParameter(r3, "newFileName");
        LarusLayoutDrivePreviewFileFragmentBinding r4 = this.a.e;
        if (r4 == null) goto L8;
        TextView r5 = r4.g;
        if (r5 == null) goto L9;
        r5.setText(r3);
        return;
    L9:
        return;
    }
}
