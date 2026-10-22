package com.bytedance.android.livesdk.clearscreen;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m {
    public final ClearScreenConst.GuideType a;
    public final String b;

    public m(ClearScreenConst.GuideType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "guideType");
        Intrinsics.checkNotNullParameter(r3, "triggerBy");
        this.a = r2;
        this.b = r3;
    }
}
