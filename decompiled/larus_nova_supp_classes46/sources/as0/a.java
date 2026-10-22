package as0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.depend.player.ILivePlatformPlayerProxy;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends ILivePlatformPlayerProxy {

    /* JADX INFO: renamed from: as0.a$a, reason: collision with other inner class name */
    public static final class C0004a {
        public static /* synthetic */ AbsLivePlayerView a(a r8, Context r9, long r10) {
            return r8.s(r9, r10, true, false, false, true);
        }
    }

    public static final class b {
        public Context a;
        public boolean b;

        public b() {
            this.a = null;
            this.b = false;
        }

        public final Context getContext() {
            return this.a;
        }
    }

    public static final class c {
        public final long a;
        public final long b;
        public final String c;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof c) == false) goto L12;
            c r7 = (c) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r7.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            String r4 = this.c;
            if (r4 == null) goto L5;
            int r5 = r4.hashCode();
        L7:
            return r2 + r5;
        L5:
            r5 = 0;
            goto L7
        }

        public final String toString() {
            return "SameRoomInfo(roomId=" + this.a + ", originRoomId=" + this.b + ", reason=" + this.c + ")";
        }

        public c(long r2, long r4, String r6) {
            Intrinsics.checkNotNullParameter(r6, "reason");
            this.a = r2;
            this.b = r4;
            this.c = r6;
        }
    }

    RoomBaseSession d();

    boolean e(Context r1, Bundle r2);

    void f(boolean r1, EndReason r2);

    ILivePlayerClient g(boolean r1);

    LivePlayerView getLivePlayerView();

    void h();

    void i(RoomBaseSession r1);

    void j(c r1);

    boolean k();

    void l(Context r1, Bundle r2);

    void log(String r1);

    boolean m();

    IBaseStreamUrl n();

    void o(b r1);

    boolean p(EndReason.USER_CLOSE r1);

    ILivePlayerClient player();

    boolean q(Context r1);

    boolean r(Bundle r1);

    long roomId();

    LivePlayerView s(Context r1, long r2, boolean r4, boolean r5, boolean r6, boolean r7);

    void t(Context r1);

    boolean u(String r1, RoomSession r2);

    void v(Bundle r1);

    LivePlayerConfig w();

    boolean x(LiveMode r1, boolean r2, boolean r3, boolean r4, boolean r5);

    Context y();
}
