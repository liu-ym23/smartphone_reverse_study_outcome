package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 a;

    public v(Function0 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        this.a.invoke();
        r1.dismiss();
    }
}
