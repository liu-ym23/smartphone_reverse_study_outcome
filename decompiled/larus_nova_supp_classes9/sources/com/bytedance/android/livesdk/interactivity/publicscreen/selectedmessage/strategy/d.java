package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements Comparator<f<?>> {
    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(f<?> r4, f<?> r5) {
        f<?> r6 = r4;
        f<?> r7 = r5;
        Intrinsics.checkNotNullParameter(r6, "o1");
        Intrinsics.checkNotNullParameter(r7, "o2");
        u3 r8 = r7.b;
        u3 r1 = null;
        if ((r8 instanceof u3) == true) goto L5;
        r8 = null;
    L5:
        u3 r9 = r8;
        int r0 = 0;
        if (r9 == null) goto L10;
        IPublicAreaCommon r10 = r9.getOrInitPublicAreaCommon();
        if (r10 == null) goto L10;
        int r11 = r10.getIndividualPriority();
    L11:
        u3 r13 = r6.b;
        if ((r13 instanceof u3) == false) goto L15;
        r1 = r13;
    L15:
        u3 r2 = r1;
        if (r2 == null) goto L21;
        IPublicAreaCommon r14 = r2.getOrInitPublicAreaCommon();
        if (r14 == null) goto L21;
        r0 = r14.getIndividualPriority();
    L21:
        return r11 - r0;
    L10:
        r11 = 0;
        goto L11
    }
}
