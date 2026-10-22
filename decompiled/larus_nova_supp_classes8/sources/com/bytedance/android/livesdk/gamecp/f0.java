package com.bytedance.android.livesdk.gamecp;

import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdkapi.service.gamecp.IDialogLandScapeParam;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveRoomLandScapeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0 implements ILiveRoomLandScapeService {
    public f0() {
    }

    public final void dismissDialog(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        MatchRoomLandScapeAnimUtil.E.j(r2);
    }

    public final void showDialog(String r4, DialogFragment r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r4, "key");
        int r1 = -1;
        if ((r5 instanceof IDialogLandScapeParam) == false) goto L5;
        int r0 = ((IDialogLandScapeParam) r5).getActualContentWidth();
    L6:
        if (r0 > 0) goto L14;
        if (r6 != null) goto L10;
    L11:
        if (r6 == null) goto L13;
        r1 = r6.intValue();
    L13:
        r0 = r1;
        goto L14
    L10:
        if (r6.intValue() != (-1)) goto L11;
    L14:
        if (r0 > 0) goto L16;
        r0 = s1.f(375.0f);
    L16:
        boolean r7 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.y(r4, r5, Integer.valueOf(r0));
        return;
    L5:
        r0 = -1;
        goto L6
    }
}
