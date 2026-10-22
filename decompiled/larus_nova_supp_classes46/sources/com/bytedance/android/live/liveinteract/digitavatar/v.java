package com.bytedance.android.live.liveinteract.digitavatar;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.liveinteract.digitavatar.videoavatar.VideoDigitAvatarRecognitionDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(FragmentManager r4, DigitAvatarRecognitionDialog.RecognitionType r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r4, "fm");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        int r3 = VideoDigitAvatarRecognitionDialog.P;
        Intrinsics.checkNotNullParameter(r4, "fm");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        VideoDigitAvatarRecognitionDialog r0 = new VideoDigitAvatarRecognitionDialog();
        Bundle r1 = new Bundle();
        r1.putSerializable("rec_type", r5);
        r0.setArguments(r1);
        r0.z = r6;
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "VideoDigitAvatarRecognitionDialog", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r0, r7) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r0.show(r4, "VideoDigitAvatarRecognitionDialog");
        return;
    }
}
