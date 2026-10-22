package com.bytedance.android.live.profile.ui.util;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profit.dress.config.x;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import rs0.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    static {
    }

    public static void a(BaseResponse r3) {
        Intrinsics.checkNotNullParameter(r3, "response");
        int r0 = t.a;
        if (((ss0.a) b0.a.getValue()).k() == false) goto L35;
        UserProfileDataResp r4 = (UserProfileDataResp) r3.data;
        if (r4 == null) goto L33;
        NewProfileUser r5 = r4.profileUser;
        if (r5 == null) goto L36;
        zt0.d r1 = yt0.c.b();
        x r2 = null;
        if (r1 == null) goto L13;
        zt0.c r6 = r1.d2();
    L14:
        if (r6 == null) goto L23;
        ProfileSkin r7 = r5.mProfileSkin;
        if (r7 == null) goto L21;
        ProfileCustomSkin r8 = r7.skin;
        if (r8 == null) goto L21;
        String r9 = r8.dressId;
        if (r9 == null) goto L21;
    L22:
        r2 = (x) r6.a(r9, Reflection.getOrCreateKotlinClass(x.class));
    L21:
        r9 = "";
    L23:
        py.k r10 = l.a(r5, DressType.BorderEnterWebp, r2);
        if (r10 == null) goto L26;
        a1.z(r10);
    L26:
        py.k r12 = l.a(r5, DressType.BorderLoopWebp, r2);
        if (r12 == null) goto L29;
        a1.z(r12);
    L29:
        py.k r13 = l.a(r5, DressType.PanelLoopWebp, r2);
        if (r13 == null) goto L34;
        a1.z(r13);
        return;
    L34:
        return;
    L13:
        r6 = null;
        goto L14
    L36:
        return;
    L33:
        return;
    }
}
