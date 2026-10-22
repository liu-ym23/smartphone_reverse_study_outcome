package sk0;

import com.bytedance.android.live.livelink.platformapi.avclient.video.AndroidVideoStreamApi;
import com.bytedance.android.live.pushstream.d;
import com.google.gson.JsonElement;
import fr2.u;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ec6.b {
    public final d0 a;
    public final sk0.a b;
    public final tk0.a c;
    public final com.bytedance.android.live.livelink.platformapi.avclient.video.a d;
    public final AndroidVideoStreamApi e;
    public final uk0.a f;
    public final HashMap<u, h0.c> g;
    public final HashMap<u, h0.b> h;
    public final d i;

    public static final class a implements h0.b {
        public final /* synthetic */ u a;

        public a(u r1) {
            this.a = r1;
        }
    }

    public static final class b implements h0.c {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }
    }

    public final void b() {
        this.i.f0(false);
    }

    public final void j() {
        this.i.O(true);
    }

    public final void g() {
        this.i.release();
    }

    public final void i() {
        this.i.getLiveCore().resume();
    }

    public final void k() {
        this.i.s();
    }

    public final void l() {
        this.i.getLiveCore().stop();
    }

    public final sk0.a c() {
        return this.b;
    }

    public final uk0.a d() {
        return this.f;
    }

    public final com.bytedance.android.live.livelink.platformapi.avclient.video.a e() {
        return this.d;
    }

    public c(d r4) {
        Intrinsics.checkNotNullParameter(r4, "liveStream");
        this.i = r4;
        d0 r1 = r4.getLiveCore();
        this.a = r1;
        this.b = new sk0.a(r4, r1);
        this.c = new tk0.a(r4, r1);
        this.d = new com.bytedance.android.live.livelink.platformapi.avclient.video.a(r4, r1);
        Intrinsics.checkNotNullParameter(r4, "liveStream");
        Intrinsics.checkNotNullParameter(r1, "liveCore");
        this.e = new AndroidVideoStreamApi(r4);
        this.f = new uk0.a(r4);
        this.g = new HashMap();
        this.h = new HashMap();
    }

    public final void a(u r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        b r0 = new b(r4);
        a r1 = new a(r4);
        this.g.put(r4, r0);
        this.h.put(r4, r1);
        this.i.I0(r0);
        this.i.D0(r1);
    }

    public final void h(u r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        h0.c r0 = this.g.get(r4);
        h0.b r1 = this.h.get(r4);
        this.i.h1(r0);
        this.i.e1(r1);
        this.g.remove(r4);
        this.h.remove(r4);
    }

    public final int f(String r7, JsonElement r8, int r9, boolean r10, boolean r11) {
        return this.i.c1(r7, r8, r9, r10, r11);
    }
}
