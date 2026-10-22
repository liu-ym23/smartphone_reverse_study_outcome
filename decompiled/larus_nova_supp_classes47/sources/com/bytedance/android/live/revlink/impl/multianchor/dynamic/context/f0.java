package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.profile.monitor.DataType;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ k0 a;

    public f0(k0 r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        sh6.b r5 = (sh6.b) r4;
        k0 r6 = this.a;
        MutableLiveData<String> r0 = r6.h;
        com.bytedance.android.live.revlink.impl.global.c r7 = r6.B;
        com.bytedance.android.live.revlink.impl.utils.b r1 = null;
        if (r7 == null) goto L5;
        com.bytedance.android.live.revlink.impl.utils.b r8 = r7.getClearScreenLinkUtils();
    L7:
        if (r8 != null) goto L9;
    L10:
        com.bytedance.android.live.revlink.impl.global.c r9 = this.a.B;
        if (r9 == null) goto L13;
        r1 = r9.getClearScreenLinkUtils();
    L13:
        if (r1 != null) goto L15;
    L17:
        String r10 = DataType.FALSE;
    L18:
        r0.setValue(r10);
        return;
    L15:
        if (r1.a() != true) goto L17;
    L16:
        r10 = DataType.TRUE;
        goto L18
    L9:
        if (r8.b() == true) goto L16;
    L5:
        r8 = null;
        goto L7
    }
}
