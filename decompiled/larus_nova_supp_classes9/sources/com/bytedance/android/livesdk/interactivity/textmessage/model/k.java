package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.w0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.common.utility.collection.CollectionUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends com.bytedance.android.livesdk.interactivity.api.entity.f<w0> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        m0 r0 = this.b.getBaseMessage();
        if (r0 == null) goto L5;
        a5 r1 = r0.getDisplayText();
    L6:
        if (r1 == null) goto L31;
        List r2 = r1.getPieces();
        if (r2 != null) goto L10;
        return null;
    L10:
        if (CollectionUtils.isEmpty(r2) == true) goto L33;
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L35;
        c5 r4 = (c5) r3.next();
        if (r4.getUserValue() == null) goto L13;
        i5 r5 = r4.getUserValue();
        if (r5 == null) goto L19;
        IBaseUser r6 = r5.getUser();
    L20:
        if (r6 == null) goto L13;
        i5 r7 = r4.getUserValue();
        if (r7 != null) goto L24;
        return null;
    L24:
        return r7.getUser();
    L19:
        r6 = null;
        goto L20
    L35:
        return null;
    L33:
        return null;
    L31:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public k(w0 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2, 0);
    }
}
