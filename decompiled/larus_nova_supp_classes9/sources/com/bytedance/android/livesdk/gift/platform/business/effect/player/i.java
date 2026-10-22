package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.util.SparseArray;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.model.GiftPlayerAutoReleaseSwitch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements ILiveGiftPlayControllerManager {
    public static final SparseArray<ILiveGiftPlayController> b = null;
    public static int c;
    public static i d;
    public final Context a;

    static {
        b = new SparseArray(2);
    }

    public static i a() {
        if (d != null) goto L6;
        d = new i(vh6.c.b(wh6.a.class).getHostContext());
    L6:
        return d;
    }

    public i(Context r1) {
        this.a = r1.getApplicationContext();
    }

    public final ITextureViewPlayerController createTextureViewPlayer(LifecycleOwner r3) {
        k r0 = new k(this.a);
        r0.initialize(r3);
        return r0;
    }

    public final ILiveGiftPlayController get(int r2) {
        return b.get(r2);
    }

    public final void release(int r5) {
        SparseArray<ILiveGiftPlayController> r0 = b;
        ILiveGiftPlayController r1 = r0.get(r5);
        jy0.b.a("GiftCtlManager", "manager release() called with [" + r1 + "]");
        if (r1 != null) goto L5;
        return;
    L5:
        r1.release();
        r0.remove(r5);
        jy0.b.d("GiftCtlManager", "release player " + r5);
    }

    public final ILiveGiftPlayController initialize(int r4, LifecycleOwner r5) {
        int r0 = c;
        if (r4 != r0) goto L9;
        if (get(r0) == null) goto L9;
        return get(c);
    L9:
        if (((GiftPlayerAutoReleaseSwitch) com.bytedance.android.livesdk.gift.platform.business.effect.a.w.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[21])).enable == false) goto L11;
        return null;
    L11:
        c = r4;
        h r1 = new h(this.a);
        r1.initialize(r5);
        b.put(r4, r1);
        jy0.b.d("GiftCtlManager", "create new player " + r4);
        return r1;
    }

    public final ILiveGiftPlayController initializeForPlay(int r3, LifecycleOwner r4) {
        int r0 = c;
        if (r3 == r0) goto L5;
    L8:
        c = r3;
        h r1 = new h(this.a);
        r1.initialize(r4);
        b.put(r3, r1);
        jy0.b.d("GiftCtlManager", "create new player " + r3);
        return r1;
    L5:
        if (get(r0) == null) goto L8;
        return get(c);
    }
}
