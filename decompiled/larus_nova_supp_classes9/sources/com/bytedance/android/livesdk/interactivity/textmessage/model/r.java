package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.na;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r extends com.bytedance.android.livesdk.interactivity.api.entity.f<na> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        na r0 = this.b;
        if (r0 == null) goto L33;
        m0 r1 = r0.getCommonData();
        if (r1 == null) goto L34;
        a5 r2 = r1.getDisplayText();
        if (r2 == null) goto L35;
        List r3 = r2.getPieces();
        if (r3 == null) goto L36;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        c5 r6 = (c5) r5;
        if (r6.getType() == PieceType.USER.getPieceType()) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L12;
    L22:
        c5 r8 = (c5) r5;
        if (r8 == null) goto L37;
        i5 r9 = r8.getUserValue();
        if (r9 != null) goto L27;
        return null;
    L27:
        return r9.getUser();
    L37:
        return null;
    L16:
        if (r6.getUserValue() == null) goto L18;
        r7 = true;
        goto L19
    L21:
        r5 = null;
        goto L22
    L36:
        return null;
    L35:
        return null;
    L34:
        return null;
    L33:
        return null;
    }

    public r(na r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2, 0);
    }
}
