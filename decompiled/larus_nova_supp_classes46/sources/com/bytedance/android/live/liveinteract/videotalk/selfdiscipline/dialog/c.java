package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.DialogInterface;
import com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.SelfDisciplineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements DialogInterface.OnClickListener {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        r3.dismiss();
        nd0.g.g(2);
        kj0.b r5 = SelfDisciplineContext.Companion.d();
        if (r5 == null) goto L6;
        kj0.b.a.a(r5, 2, null, 6);
        return;
    }
}
