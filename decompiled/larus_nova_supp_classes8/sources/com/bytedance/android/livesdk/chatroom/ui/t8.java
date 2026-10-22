package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t8 implements View.OnClickListener {
    public final /* synthetic */ ResolutionItemView a;
    public final /* synthetic */ l5 b;

    public t8(ResolutionItemView r1, l5 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        String r5 = this.b.e;
        if (Intrinsics.areEqual(r5, "disable") == true) goto L5;
        l5 r0 = this.b;
        String r1 = "selected";
        if (Intrinsics.areEqual(r5, "selected") == false) goto L14;
        r1 = "unselected";
    L14:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.e = r1;
        this.a.getSelectedCallback().invoke(this.b.b);
        return;
    L5:
        if (this.a.getToastAction() == null) goto L9;
        Function1<String, Unit> r6 = this.a.getToastAction();
        if (r6 == null) goto L16;
        Unit r7 = (Unit) r6.invoke("设备不支持当前清晰度播放");
        return;
    L16:
        return;
    L9:
        String r8 = rm3.c.a;
        rm3.c.g(this.a.getContext(), "设备不支持当前清晰度播放", 0, false, 28);
    }
}
