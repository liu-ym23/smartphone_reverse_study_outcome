package com.obric.assistant.interaction.impl;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d0 implements Runnable {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ d0(FragmentActivity r1, Intent r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ObricRealtimeCallExtServiceImpl.b(this.a, this.b);
    }
}
