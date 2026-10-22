package ds0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.core.setting.p3;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomMetrics;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.config.tl0;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class d extends RoomBaseSession {
    public final List<String> a;
    public List<String> b;
    public final int c;
    public final c d;
    public final List<String> e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public boolean j;
    public int k;
    public boolean l;
    public VSCameraInfo m;
    public boolean n;
    public List<String> o;
    public boolean p;
    public boolean q;
    public final boolean r;
    public final boolean s;

    public abstract void a(String r1);

    public abstract void b(IBaseStreamUrl r1);

    public abstract void c(VSCameraInfo r1);

    public abstract Context d();

    public abstract p0 e();

    public abstract Bundle f();

    public int i() {
        return 0;
    }

    public int j() {
        return 0;
    }

    public boolean k() {
        return false;
    }

    public abstract LiveRoomMetrics o();

    public boolean s() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return false;
    }

    public abstract boolean v();

    public abstract Room w();

    public abstract long x();

    public abstract void z();

    public Pair<Integer, Integer> getVideoSize() {
        ILivePlayerClient r0 = m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getVideoSize();
    }

    public final boolean l() {
        return LivePlatformPlayerManager.c(x(), false).k();
    }

    public final ILivePlayerClient m() {
        return LivePlatformPlayerManager.c(x(), v()).player();
    }

    public final IRoomEventHub n() {
        ILivePlayerClient r0 = m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getEventHub();
    }

    public List<String> g() {
        return this.e;
    }

    public List<String> h() {
        return this.a;
    }

    public int p() {
        return this.c;
    }

    public List<String> q() {
        return this.b;
    }

    public Observer<Boolean> r() {
        return this.d;
    }

    public void y(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public d(Context r2, Bundle r3, hn1.e r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "inExtra");
        Intrinsics.checkNotNullParameter(r4, "roomLog");
        super(r2, r3, r4);
        this.a = CollectionsKt.emptyList();
        this.b = CollectionsKt.emptyList();
        this.c = -1;
        this.d = c.a;
        this.e = CollectionsKt.emptyList();
        this.r = ((Boolean) tl0.a.getValue()).booleanValue();
        this.s = ((Boolean) p3.a.getValue()).booleanValue();
    }
}
