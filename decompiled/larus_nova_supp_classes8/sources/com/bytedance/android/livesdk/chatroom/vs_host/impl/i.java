package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.interactivity.api.IExpressionService;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements vr1.g, com.bytedance.android.scope.o {
    public i() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.g
    public final List<Object> parseEmojiIndexList(CharSequence r1) {
        return ab2.a.d(r1);
    }

    @Override // vr1.g
    public final GradientEditText a(Context r2, int r3) {
        return jc1.k.n(IExpressionService.class).createEmojiEditText(r2, r3);
    }

    @Override // vr1.g
    public final SpannableString c(CharSequence r1, float r2) {
        return ab2.a.f(r1, r2);
    }

    @Override // vr1.g
    public final View d(boolean r10, boolean r11, Function2 r12, Function0 r13, Function0 r14) {
        Intrinsics.checkNotNullParameter(r12, "onEmojiSelected");
        Intrinsics.checkNotNullParameter(r13, "onEmojiDeleted");
        Intrinsics.checkNotNullParameter(r14, "dismissDialog");
        if (jc1.k.f(IHostContext.class) != null) goto L5;
        return null;
    L5:
        Context r0 = jc1.k.n(IHostContext.class).context();
        if (r0 != null) goto L9;
        return null;
    L9:
        if (r10 != true) goto L11;
        boolean r3 = false;
    L12:
        com.bytedance.android.livesdk.interactivity.api.expression.a r1 = new com.bytedance.android.livesdk.interactivity.api.expression.a(r3, false, false, false, false, new h(r12, r13, r14));
        return jc1.k.n(IExpressionService.class).createExpressionPanelV3(r0, r1);
    L11:
        r3 = r11;
        goto L12
    }

    @Override // vr1.g
    public final f f(boolean r3, boolean r4, Function2 r5, Function0 r6, Function0 r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r5, "onEmojiSelected");
        Intrinsics.checkNotNullParameter(r6, "onEmojiDeleted");
        Intrinsics.checkNotNullParameter(r7, "onSendMsg");
        Intrinsics.checkNotNullParameter(r8, "dismissDialog");
        if (jc1.k.f(IHostContext.class) != null) goto L5;
        return null;
    L5:
        Context r0 = jc1.k.n(IHostContext.class).context();
        if (r0 != null) goto L8;
        return null;
    L8:
        g r1 = new g(r5, r6, r7, r8);
        IExpressionService r9 = jc1.k.n(IExpressionService.class);
        if (r3 != true) goto L12;
        r4 = false;
    L12:
        return new f(r9.createSimpleExpressionPanelV3(r0, r4, r1));
    }
}
