package com.larus.bmhome.chat.list.cell.video;

import com.larus.bmhome.double_post.drag_panel.l0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ AwemePostListCell a;

    public /* synthetic */ a(AwemePostListCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        com.larus.bmhome.chat.layout.item.f r0 = this.a.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("box");
        r0 = null;
    L5:
        t1a.b r1 = ei9.c.a(r0);
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getAbility(l0.class);
    }
}
