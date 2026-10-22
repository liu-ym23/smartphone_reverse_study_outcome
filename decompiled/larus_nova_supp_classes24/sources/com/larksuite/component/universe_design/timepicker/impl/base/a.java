package com.larksuite.component.universe_design.timepicker.impl.base;

import android.os.Handler;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends Handler {
    public final WheelView a;

    /* JADX INFO: renamed from: com.larksuite.component.universe_design.timepicker.impl.base.a$a, reason: collision with other inner class name */
    public static final class C0044a {
    }

    static {
    }

    public a(WheelView r2) {
        Intrinsics.checkNotNullParameter(r2, "loopview");
        this.a = r2;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        int r3 = r2.what;
        if (r3 != 1000) goto L5;
        this.a.invalidate();
        return;
    L5:
        if (r3 != 2000) goto L7;
        this.a.smoothScroll(WheelView.ACTION.FLING);
        return;
    L7:
        if (r3 != 3000) goto L15;
        this.a.onItemSelected();
        return;
    }
}
