package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.DialogInterface;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements DialogInterface.OnCancelListener {
    public final /* synthetic */ Function1 a;

    public l(Function1 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        this.a.invoke(Boolean.FALSE);
    }
}
