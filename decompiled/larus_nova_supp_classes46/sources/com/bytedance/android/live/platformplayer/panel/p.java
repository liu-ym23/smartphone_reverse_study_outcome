package com.bytedance.android.live.platformplayer.panel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ s a;

    public p(s r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        if (((Boolean) r3).booleanValue() == false) goto L26;
        LivePlayerView r4 = this.a.b.get();
        LifecycleOwner r0 = null;
        if (r4 == null) goto L9;
        ILivePlayerClient r5 = r4.getClient();
        if (r5 == null) goto L9;
        LifecycleOwner r6 = r5.getLifecycleOwner();
    L10:
        if (r6 == null) goto L27;
        LivePlayerView r7 = this.a.b.get();
        if (r7 == null) goto L28;
        ILivePlayerClient r8 = r7.getClient();
        if (r8 == null) goto L29;
        IRoomEventHub r9 = r8.getEventHub();
        if (r9 == null) goto L30;
        MutableLiveData r10 = r9.getSeiUpdate();
        if (r10 == null) goto L31;
        LivePlayerView r1 = this.a.b.get();
        if (r1 == null) goto L24;
        ILivePlayerClient r2 = r1.getClient();
        if (r2 == null) goto L24;
        r0 = r2.getLifecycleOwner();
    L24:
        Intrinsics.checkNotNull(r0);
        r10.observe(r0, this.a.k);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L9:
        r6 = null;
        goto L10
    }
}
