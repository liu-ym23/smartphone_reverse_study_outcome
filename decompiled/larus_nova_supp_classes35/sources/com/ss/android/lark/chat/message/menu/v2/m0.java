package com.ss.android.lark.chat.message.menu.v2;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m0 {
    public final PanelType a;
    public final float b;
    public final boolean c;
    public final PanelActionType d;

    public final PanelType getType() {
        return this.a;
    }

    public m0(PanelType r2, float r3, boolean r4, PanelActionType r5) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r5, "actionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static m0 a(m0 r1, PanelType r2, float r3, boolean r4, PanelActionType r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = r1.d;
    L14:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r5, "actionType");
        return new m0(r2, r3, r4, r5);
    }
}
