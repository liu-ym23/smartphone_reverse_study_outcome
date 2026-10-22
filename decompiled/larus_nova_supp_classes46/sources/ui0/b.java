package ui0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public boolean a;
    public ui0.a b;
    public final LifecycleOwner c;

    public static final class a {
    }

    static {
    }

    public b(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "liveCycleOwner");
        this.c = r2;
    }

    public final void a(boolean r3, String r4) {
        ALogger.i("LiveRoomAudioManger", "muteLivePlayer, isMute: " + r3 + ", source: " + r4 + ", isLivePlayerMuteByGuestLink: " + this.a);
        if (this.b != null) goto L5;
        this.b = new ui0.a(this.c);
    L5:
        boolean r5 = false;
        if (r3 == false) goto L19;
        ui0.a r6 = this.b;
        if (r6 == null) goto L24;
        ILivePlayerClient r7 = r6.a();
        if (r7 != null) goto L12;
    L14:
        if (r5 == true) goto L25;
        ALogger.i("LiveRoomAudioManger", "muteLivePlayer true");
        this.a = true;
        ui0.a r8 = this.b;
        if (r8 == null) goto L26;
        r8.b(true);
        return;
    L26:
        return;
    L25:
        return;
    L12:
        if (r7.isMute() != true) goto L14;
        r5 = true;
        goto L14
    L24:
        return;
    L19:
        if (this.a == false) goto L28;
        ALogger.i("LiveRoomAudioManger", "muteLivePlayer false");
        this.a = false;
        ui0.a r9 = this.b;
        if (r9 == null) goto L29;
        r9.b(false);
        return;
    L29:
        return;
    }
}
