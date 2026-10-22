package com.larus.bmhome.chat.component.bottom.voice;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.apphost.AppHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 {
    public final ChatConstraintLayout a;
    public final boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public Function1<? super Integer, Unit> f;

    public final int a() {
        ChatConstraintLayout r0 = this.a;
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.getDisableBottomPadding() != true) goto L7;
    L8:
        if (r2 == true) goto L18;
        FragmentActivity r1 = AppHost.a.a().getCurrentActivity();
        if ((r1 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r3 = r1;
    L14:
        if (r3 != null) goto L16;
        return 0;
    L16:
        return com.larus.utils.u.b(r3);
    L13:
        r3 = null;
        goto L14
    L18:
        return 0;
    L7:
        r2 = false;
        goto L8
    }

    public c0(ChatConstraintLayout r1, boolean r2) {
        this.a = r1;
        this.b = r2;
        this.f = new a0();
    }
}
