package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ Function1 a;

    public e0(Function1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.invoke(r2);
    }
}
