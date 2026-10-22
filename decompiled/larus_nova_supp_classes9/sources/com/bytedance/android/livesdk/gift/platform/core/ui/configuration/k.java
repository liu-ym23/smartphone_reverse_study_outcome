package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1 a;

    public k(Function1 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        this.a.invoke(Boolean.FALSE);
        r2.dismiss();
    }
}
