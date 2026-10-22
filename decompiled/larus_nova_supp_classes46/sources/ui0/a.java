package ui0;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public boolean a;
    public ILivePlayerClient b;
    public final b c;
    public final LifecycleOwner d;

    /* JADX INFO: renamed from: ui0.a$a, reason: collision with other inner class name */
    public static final class C0280a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            ALogger.i("LivePlayerMediaManager", "livePlayerClient, update isMute: " + r4 + ", LivePlayerMediaManager: " + this.a);
            if (this.a.a == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r4, Boolean.FALSE) == false) goto L9;
            ALogger.i("LivePlayerMediaManager", "keep mute");
            this.a.b(true);
            vi0.b.b();
            return;
        }
    }

    static {
    }

    public final ILivePlayerClient a() {
        if (this.b != null) goto L23;
        ILivePlatformPlayerProxy r0 = hs0.a.b.curRoomPlayer();
        Boolean r1 = null;
        if (r0 == null) goto L7;
        ILivePlayerClient r2 = r0.player();
    L8:
        this.b = r2;
        StringBuilder r3 = new StringBuilder("getLivePlayerClient, isMute: ");
        ILivePlayerClient r4 = this.b;
        if (r4 == null) goto L15;
        IRoomEventHub r5 = r4.getEventHub();
        if (r5 == null) goto L15;
        MutableLiveData r6 = r5.getPlayerMute();
        if (r6 == null) goto L15;
        r1 = (Boolean) r6.getValue();
    L15:
        r3.append(r1);
        ALogger.i("LivePlayerMediaManager", r3.toString());
        ILivePlayerClient r7 = this.b;
        if (r7 == null) goto L23;
        IRoomEventHub r8 = r7.getEventHub();
        if (r8 == null) goto L23;
        MutableLiveData r9 = r8.getPlayerMute();
        if (r9 == null) goto L23;
        ALogger.i("LivePlayerMediaManager", "add playerMuteObserver");
        r9.observe(this.d, this.c);
        goto L23
    L7:
        r2 = null;
    L23:
        return this.b;
    }

    public a(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "liveCycleOwner");
        this.d = r2;
        this.c = new b(this);
    }

    public final void b(boolean r3) {
        this.a = r3;
        ALogger.i("LivePlayerMediaManager", "muteLiveRoom, isMute: " + r3);
        if (r3 == false) goto L7;
        ILivePlayerClient r4 = a();
        if (r4 == null) goto L11;
        r4.mute("LivePlayerMediaManager.mute");
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r5 = a();
        if (r5 == null) goto L13;
        r5.unmute("LivePlayerMediaManager.mute");
        return;
    }
}
