package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.text.TextUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ NewPkRecordViewHolder a;
    public final /* synthetic */ String b;

    public c(NewPkRecordViewHolder r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        IFollowPair r5 = (IFollowPair) r4;
        String r0 = null;
        if (r5 == null) goto L5;
        String r1 = r5.getUserIdString();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L16;
        if (r5 == null) goto L10;
        String r2 = r5.getUserIdString();
    L12:
        if (TextUtils.equals(r2, DataType.FALSE) == true) goto L16;
        if (r5 == null) goto L16;
        r0 = r5.getUserIdString();
        goto L16
    L10:
        r2 = null;
    L16:
        if ((!Intrinsics.areEqual(r0, this.b)) == true) goto L25;
        if (r5 == null) goto L23;
        int r6 = r5.getFollowStatus();
        NewPkRecordViewHolder r3 = this.a;
        r3.V3(r3.o, r3.T3(r6));
        x31.u r7 = this.a.f;
        if (r7 == null) goto L24;
        r7.a = r6;
        return;
    L24:
        return;
    L23:
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
