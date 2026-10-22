package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ PkReserveViewHolder a;

    public t(PkReserveViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        y31.t.a r5 = this.a.a;
        if (r5 == null) goto L10;
        Function3<? super IRoom, ? super IBaseUser, ? super String, Unit> r0 = r5.i;
        if (r0 == null) goto L10;
        IRoom r1 = r5.b;
        IBaseUser r2 = r5.a;
        String r6 = r5.g;
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        Unit r7 = (Unit) r0.invoke(r1, r2, r6);
    L10:
        PkReserveViewHolder.T3(this.a, 1);
    }
}
