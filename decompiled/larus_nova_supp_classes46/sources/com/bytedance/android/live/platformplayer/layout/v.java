package com.bytedance.android.live.platformplayer.layout;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;

    public v(LivePlayerWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L18;
        r4.booleanValue();
        if (r4.booleanValue() == true) goto L19;
        LivePlayerWidget r5 = this.a;
        int r0 = LivePlayerWidget.V2;
        ILivePlayerClient r6 = r5.dr();
        if (r6 == null) goto L13;
        IRoomEventHub r7 = r6.getEventHub();
        if (r7 == null) goto L13;
        MutableLiveData r8 = r7.getPlaying();
        if (r8 == null) goto L13;
        Boolean r9 = (Boolean) r8.getValue();
    L15:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L20;
        this.a.Wu("recover from illegal status", false);
        return;
    L20:
        return;
    L13:
        r9 = null;
        goto L15
    L19:
        return;
    }
}
