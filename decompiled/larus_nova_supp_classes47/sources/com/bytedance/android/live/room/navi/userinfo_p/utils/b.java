package com.bytedance.android.live.room.navi.userinfo_p.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final String a(IRoom r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$anchorAccessibleContent");
        IBaseUser r0 = r3.getOwner();
        if (r0 == null) goto L6;
        String r1 = r0.getNickName();
        if (r1 == null) goto L6;
    L7:
        AnchorTabLabel r4 = r3.getAnchorTabLabel();
        String r2 = s1.B(2131911613);
        if (r4 == null) goto L13;
        if (TextUtils.isEmpty(r4.getAccessibleContent()) == true) goto L13;
        r2 = r4.getAccessibleContent();
    L13:
        return r1 + r2;
    L6:
        r1 = "";
        goto L7
    }
}
