package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.message.model.o7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final String a(o7 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toRecordString");
        StringBuilder r0 = new StringBuilder("mId:");
        r0.append(r3.getMessageId());
        r0.append(",gId:");
        r0.append(r3.getGiftId());
        r0.append(",rEd:");
        r0.append(r3.getRepeatEnd());
        r0.append(",ban");
        r0.append(r3.getBannedDisplayEffects());
        r0.append(",gNm:");
        h1 r1 = r3.getGift();
        if (r1 == null) goto L6;
        String r2 = r1.getName();
        if (r2 == null) goto L6;
    L10:
        r0.append(r2);
        return r0.toString();
    L6:
        m0 r4 = r3.getCommonData();
        if (r4 == null) goto L9;
        r2 = r4.getDescribe();
        goto L10
    L9:
        r2 = null;
        goto L10
    }
}
