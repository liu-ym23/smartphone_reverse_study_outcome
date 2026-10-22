package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public ILivePlayerClient a;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void onChanged(Object r3) {
            ALogger.i("AdventureMediaManager", "livePlayerClient, update isMute: " + ((Boolean) r3));
        }
    }

    static {
    }

    public h() {
    }

    public static final ILivePlayerClient a(h r3) {
        if (r3.a != null) goto L23;
        ILivePlatformPlayerProxy r0 = hs0.a.b.curRoomPlayer();
        Boolean r1 = null;
        if (r0 == null) goto L7;
        ILivePlayerClient r2 = r0.player();
    L8:
        r3.a = r2;
        StringBuilder r4 = new StringBuilder("getLivePlayerClient, isMute: ");
        ILivePlayerClient r5 = r3.a;
        if (r5 == null) goto L15;
        IRoomEventHub r6 = r5.getEventHub();
        if (r6 == null) goto L15;
        MutableLiveData r7 = r6.getPlayerMute();
        if (r7 == null) goto L15;
        r1 = (Boolean) r7.getValue();
    L15:
        r4.append(r1);
        ALogger.i("AdventureMediaManager", r4.toString());
        ILivePlayerClient r8 = r3.a;
        if (r8 == null) goto L23;
        IRoomEventHub r9 = r8.getEventHub();
        if (r9 == null) goto L23;
        MutableLiveData r10 = r9.getPlayerMute();
        if (r10 == null) goto L23;
        r10.observeForever(b.a);
        goto L23
    L7:
        r2 = null;
    L23:
        return r3.a;
    }
}
