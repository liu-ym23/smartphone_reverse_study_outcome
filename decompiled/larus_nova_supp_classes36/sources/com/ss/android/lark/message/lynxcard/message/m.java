package com.ss.android.lark.message.lynxcard.message;

import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements r5b.e<LynxCardContentVO, n, LynxCardMessageCell> {
    public m() {
    }

    public final v5b.b b() {
        return new n();
    }

    public final r5b.d a(r5b.a r2, p2b.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "openCellCallback");
        return new LynxCardMessageCell(r2, r3);
    }
}
