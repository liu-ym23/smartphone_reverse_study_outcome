package com.larus.voicecall.impl.component.picture;

import com.larus.audio.call.subtitle.DisplayType;
import ic8.m0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e implements Function1 {
    public final /* synthetic */ x3a.a a;

    public /* synthetic */ e(x3a.a r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        x3a.a r0 = this.a;
        com.larus.voicecall.impl.subtitle.c r5 = (com.larus.voicecall.impl.subtitle.c) r4;
        int r1 = RealtimePictureComponent.B;
        Intrinsics.checkNotNullParameter(r5, "it");
        if (r5.c != DisplayType.QUERY_IMAGE) goto L13;
        x3a.a r6 = r5.i;
        if (r6 == null) goto L9;
        m0 r7 = r6.a;
        if (r7 == null) goto L9;
        String r8 = r7.e;
    L11:
        if (Intrinsics.areEqual(r8, r0.a.e) == false) goto L13;
        boolean r9 = true;
    L15:
        return Boolean.valueOf(r9);
    L9:
        r8 = null;
    L13:
        r9 = false;
        goto L15
    }
}
