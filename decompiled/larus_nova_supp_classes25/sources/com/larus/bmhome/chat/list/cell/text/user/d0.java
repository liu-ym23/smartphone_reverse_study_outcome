package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d0 implements Function1 {
    public final /* synthetic */ UserTextCell a;

    public /* synthetic */ d0(UserTextCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        UserTextCell r0 = this.a;
        int r1 = UserTextCell.z;
        Intrinsics.checkNotNullParameter((View) r3, "widget");
        r0.r.e();
        return Unit.INSTANCE;
    }
}
