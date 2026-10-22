package com.bytedance.android.live.revlink.impl.control;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.livesdk.link.model.a9;
import com.bytedance.android.livesdk.link.model.f5;
import com.bytedance.android.livesdk.link.model.i5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v {
    public static final r a(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getMultiInfo");
        Map r3 = IRoomKt_androidKt.getLinkMapKt(r2);
        if (r3 == null) goto L8;
        Long r4 = (Long) r3.get(String.valueOf(7));
        if (r4 != null) goto L7;
        return null;
    L7:
        return new r(r4.longValue());
    L8:
        return null;
    }

    public static final u b(IRoom r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$getPkInfo");
        a9 r7 = ((IRoomLinkExt) ((vh7.c) r12).castTo(IRoomLinkExt.class)).getLinkMicInfo();
        Object r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        i5 r1 = r7.getChannelInfo();
        if (r1 != null) goto L8;
        return null;
    L8:
        long r3 = r7.getChannelId();
        String r2 = r7.getGuestId();
        if (r3 > 0) goto L11;
        return null;
    L11:
        long r5 = r1.getDimension();
        long r8 = r1.getLayout();
        int r6 = (int) r5;
        if (r6 != 1) goto L38;
        int r9 = (int) r8;
        if (r9 != 4) goto L38;
        List r10 = r7.getBattleScorePairList();
        if (r10 == null) goto L37;
        Iterator r13 = r10.iterator();
    L20:
        if (r13.hasNext() == false) goto L33;
        Object r14 = r13.next();
        f5 r15 = (f5) r14;
        if (r12.getOwnerKt() == null) goto L30;
        IBaseUser r16 = r12.getOwnerKt();
        if (r16 == null) goto L26;
        String r17 = r16.getIdString();
    L28:
        if ((!Intrinsics.areEqual(r17, r15.getUserId())) == false) goto L30;
        boolean r18 = true;
    L31:
        if (r18 == false) goto L20;
        r0 = r14;
        goto L33
    L26:
        r17 = null;
    L30:
        r18 = false;
    L33:
        f5 r4 = (f5) r0;
        if (r4 == null) goto L37;
        r2 = r4.getUserId();
    L37:
        return new u(r2, r3, r6, r9, r7);
    L38:
        return null;
    }
}
