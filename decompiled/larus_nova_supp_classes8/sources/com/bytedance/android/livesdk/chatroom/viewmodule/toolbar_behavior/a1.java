package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a1 implements View.OnClickListener {
    public final /* synthetic */ x0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Map c;

    public a1(x0 r1, String r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (TextUtils.isEmpty(this.b) == true) goto L5;
        jc1.k.n(ILiveActionHandler.class).handle(this.a.n, this.b);
    L5:
        x0 r4 = this.a;
        Map r0 = this.c;
        r4.getClass();
        x0.a("livesdk_fan_group_pop_click", r0);
        x0 r5 = this.a;
        yo2.e r1 = r5.h;
        if (r1 == null) goto L8;
        r1.d();
    L8:
        r5.h = null;
    }
}
