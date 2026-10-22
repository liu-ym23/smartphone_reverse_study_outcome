package com.larus.bmhome.chat.standarduikit.search.vm;

import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.p2;
import com.larus.bmhome.chat.layout.holder.helper.w0;
import com.larus.im.bean.message.Message;
import kc8.k0;
import kc8.y;
import kc8.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ Message b;

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r7) {
        Intrinsics.checkNotNullParameter(r7, "v");
        kc8.b r0 = this.a.a;
        q0.a r2 = null;
        if (r0 == null) goto L10;
        k0 r3 = r0.g;
        if (r3 == null) goto L10;
        z r4 = r3.b;
        if (r4 == null) goto L10;
        z.a.a(r4, null, null, 7);
        return true;
    L10:
        Message r5 = this.b;
        if (r0 == null) goto L15;
        y r6 = r0.a;
        if (r6 == null) goto L15;
        q0 r8 = r6.x;
    L16:
        if (r0 == null) goto L22;
        y r1 = r0.a;
        if (r1 == null) goto L22;
        q0 r9 = r1.x;
        if (r9 == null) goto L22;
        r2 = r9.getProvider();
    L22:
        new w0(new p2(r5, r8, r2, new e.a())).onLongClick(r7);
        return true;
    L15:
        r8 = null;
        goto L16
    }

    public f(e r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }
}
