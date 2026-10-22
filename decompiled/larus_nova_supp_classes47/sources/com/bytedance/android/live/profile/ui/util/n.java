package com.bytedance.android.live.profile.ui.util;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.DressSuitInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(NewProfileUser r2) {
        Intrinsics.checkNotNullParameter(r2, "user");
        DressSuitInfo r0 = r2.getDressSuitInfo();
        String r1 = null;
        if (r0 == null) goto L5;
        String r3 = r0.getName();
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        DressSuitInfo r4 = r2.getDressSuitInfo();
        if (r4 == null) goto L12;
        r1 = r4.getSchema();
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L14;
        return true;
    L14:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public static boolean b(com.bytedance.android.live.profile.ui.base.h r1) {
        Intrinsics.checkNotNullParameter(r1, "profileContext");
        String r2 = r1.getFlashCardAsset();
        String r0 = (String) rs0.d.a.getValue();
        if (r2.a(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.a(r0) == false) goto L7;
        return true;
    }

    public static String c(NewProfileInfoViewModel r0, DressType r1) {
        py.k r2 = r0.getDressImageModelWithFallback(r1);
        if (r2 != null) goto L5;
    L7:
        return DataType.FALSE;
    L5:
        if (r2.isValid() != true) goto L7;
        return DataType.TRUE;
    }
}
