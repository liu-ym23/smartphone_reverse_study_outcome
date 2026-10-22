package com.ivy.ivykit.plugin.impl.render;

import android.view.View;
import com.obric.oui.tips.OTips;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f9529b;

    public /* synthetic */ g(int r5, Function0 r10) {
        this.f9528a = r5;
        this.f9529b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        Function0 r10 = this.f9529b;
        switch(this.f9528a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        int r11 = OTips.f14763j;
        Intrinsics.checkNotNullParameter(r10, "$clickAction");
        r10.invoke();
        return;
    L6:
        int r12 = OTips.f14763j;
        Intrinsics.checkNotNullParameter(r10, "$clickAction");
        r10.invoke();
        return;
    L8:
        Intrinsics.checkNotNullParameter(r10, "$buttonClick");
        r10.invoke();
    }
}
