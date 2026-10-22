package com.bytedance.android.live.revlink.impl.service;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.scope.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements p11.c, o {
    public b() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // p11.c
    public final long A() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L15;
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.c;
        if (r1 == null) goto L7;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r1.Ig();
    L8:
        if (r2 == null) goto L16;
        MutableLiveData<Long> r3 = r2.getAudioPunishRemainTime();
        if (r3 == null) goto L17;
        Long r4 = (Long) r3.getValue();
        if (r4 != null) goto L14;
        return 0;
    L14:
        return r4.longValue();
    L17:
        return 0;
    L16:
        return 0;
    L7:
        r2 = null;
        goto L8
    L15:
        return 0;
    }
}
