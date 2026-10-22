package com.bytedance.android.livesdk.dslservice.lynxair.view;

import android.view.View;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<V extends View> extends yt1.b<LynxBaseUI, V> {
    @Override // yt1.b
    public final int b() {
        return ((LynxBaseUI) this.a).getChildren().size();
    }

    @Override // yt1.b
    public final int c() {
        return ((LynxBaseUI) this.a).getMarginLeft();
    }

    @Override // yt1.b
    public final int d() {
        return ((LynxBaseUI) this.a).getMarginLeft();
    }

    @Override // yt1.b
    public final Object e() {
        Intrinsics.checkNotNullParameter("is_separate", LiveEndPageData.TAG_NAME);
        return ((LynxBaseUI) this.a).getProps().get("is_separate");
    }

    @Override // yt1.b
    public final int f() {
        return Math.max(((LynxBaseUI) this.a).getWidth(), 0);
    }

    @Override // yt1.b
    public final void g() {
        Object r0 = this.a;
        if ((r0 instanceof LynxUI) == true) goto L5;
        r0 = null;
    L5:
        LynxUI r1 = (LynxUI) r0;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
        return;
    }

    @Override // yt1.b
    public final yt1.b<LynxBaseUI, ? extends View> a(int r4) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(new e(((LynxBaseUI) this.a).getChildAt(r4), null));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == true) goto L12;
        r0 = r5;
    L12:
        return (yt1.b) r0;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public e(LynxBaseUI r2, V r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        super(r2, r3);
    }
}
