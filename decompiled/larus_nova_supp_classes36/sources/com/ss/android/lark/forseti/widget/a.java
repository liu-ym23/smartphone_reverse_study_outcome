package com.ss.android.lark.forseti.widget;

import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.ForsetiChainState;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.api.ui.d {
    public final /* synthetic */ ForsetiNormalChainDraggingLayout a;

    public a(ForsetiNormalChainDraggingLayout r1) {
        this.a = r1;
    }

    public final void a(int r6) {
        Log.i("FST_DraggingLayout", "left = " + r6);
        Lazy r7 = ForsetiFGHelpers.a;
        if (ForsetiFGHelpers.c(BizType.IM, "opt_nav_width") == false) goto L17;
        ForsetiChainFragment r8 = this.a.a;
        boolean r2 = false;
        if (r8 == null) goto L14;
        ForsetiChainState r9 = r8.z;
        if (r9 == null) goto L14;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.getValue() <= ForsetiChainState.STOPPED.getValue()) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        r2 = true;
        goto L14
    L11:
        r10 = false;
    L14:
        if (r2 == false) goto L25;
        Log.i("FST_DraggingLayout", "chain fragment state is not resumed.");
        return;
    L25:
        ForsetiNormalChainDraggingLayout.g(this.a);
        ForsetiNormalChainDraggingLayout.f(this.a);
        return;
    L17:
        ForsetiChainFragment r11 = this.a.a;
        if (r11 == null) goto L20;
        ForsetiChainState r12 = r11.z;
    L22:
        if (r12 == ForsetiChainState.RESUMED) goto L25;
        Log.i("FST_DraggingLayout", "chain fragment state is not resumed.");
        return;
    L20:
        r12 = null;
        goto L22
    }
}
