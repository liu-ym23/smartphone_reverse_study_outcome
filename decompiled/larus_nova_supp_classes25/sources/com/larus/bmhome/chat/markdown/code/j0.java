package com.larus.bmhome.chat.markdown.code;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j0 extends ViewOutlineProvider {
    public final /* synthetic */ int a;

    public j0(int r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "v");
        Intrinsics.checkNotNullParameter(r9, "outline");
        r9.setRoundRect(0, this.a, r8.getWidth(), r8.getHeight(), MarkdownDimensExtKt.b());
    }
}
