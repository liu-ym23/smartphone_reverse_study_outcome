package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ MmRecordingTitleNameView a;

    public static final class a implements gqb.a {
        public final /* synthetic */ MmRecordingTitleNameView a;

        public final void b() {
            int r0 = bwb.b.a;
            bwb.b.g(MmUiLogScene.TOOLBAR, "openLocationChooser", "cancelled", null, 8);
        }

        public a(MmRecordingTitleNameView r1) {
            this.a = r1;
        }

        public final void a(FragmentActivity r5, POIInfo r6) {
            Intrinsics.checkNotNullParameter(r5, "activity");
            if (r6 != null) goto L6;
            int r7 = bwb.b.a;
            bwb.b.d(MmUiLogScene.TOOLBAR, "openLocationChooser", "handleResult data is null", null);
            return;
        L6:
            int r1 = bwb.b.a;
            bwb.b.g(MmUiLogScene.TOOLBAR, "openLocationChooser", "handleResult: " + r6.getLocationName(), null, 8);
            MmRecordingViewModel r8 = this.a.c;
            if (r8 == null) goto L10;
            r8.dispatchEvent(new g.h(r6));
            return;
        }
    }

    public b(MmRecordingTitleNameView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Fragment r6 = this.a.d;
        if (r6 == null) goto L5;
        FragmentActivity r1 = r6.getActivity();
    L6:
        if (r1 != null) goto L9;
        int r2 = bwb.b.a;
        bwb.b.d(MmUiLogScene.TOOLBAR, "openLocationChooser", "activity is null, fragment=" + r6, null);
        return;
    L9:
        int r7 = wvb.c.a;
        wvb.c.a(r1, new a(this.a));
        return;
    L5:
        r1 = null;
        goto L6
    }
}
