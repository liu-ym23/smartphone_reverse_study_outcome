package js1;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.livelink.multilink.MultiLinkService;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import vb6.g;
import yb6.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final g a;
    public final js1.b b;
    public final c c;
    public final C0395a d;
    public final b e;
    public final Context f;

    /* JADX INFO: renamed from: js1.a$a, reason: collision with other inner class name */
    public static final class C0395a implements xb6.a {
        public final /* synthetic */ a a;

        public C0395a(a r1) {
            this.a = r1;
        }

        public final void a(Map r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
        }

        public final String b(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
            return "";
        }

        public final void c(fi6.a r5) {
            Intrinsics.checkNotNullParameter(r5, "config");
            a r0 = this.a;
            r0.getClass();
            InteractMode r1 = InteractMode.VIDEO_TALK;
            String r2 = tc0.c.h().k;
            r5.f(LinkConstant.STREAM_BACKGROUND);
            r5.h(r0.f);
            String r3 = String.valueOf(r2);
            Intrinsics.checkNotNullParameter(r3, "info");
            r5.v = r3;
            r5.S = 5;
            r5.o(qi6.g.h);
            String r4 = s1.B(2131922659);
            Intrinsics.checkNotNullParameter(r4, "key");
            r5.w = r4;
            r5.i(r1);
            r5.N = 300;
            r5.g(Character.GUEST);
            r5.d = 3;
            r5.n(StreamType.VIDEO);
        }

        public final String d(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
            return "";
        }

        public final String e(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
            return "";
        }

        public final String f(yb6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r2, "params");
            return "";
        }
    }

    public static final class b implements xb6.b {
        public final /* synthetic */ a a;

        public final Pair<Boolean, String> a() {
            return xb6.b.a.k();
        }

        public final Pair<Boolean, String> b() {
            return xb6.b.a.a();
        }

        public final Pair<Boolean, String> c() {
            return xb6.b.a.b();
        }

        public final Pair<Boolean, String> e() {
            return xb6.b.a.e();
        }

        public final Pair<Boolean, String> g() {
            return xb6.b.a.l();
        }

        public final Pair<Boolean, String> h() {
            return xb6.b.a.g();
        }

        public final Pair<Boolean, String> k() {
            return xb6.b.a.i();
        }

        public final Pair<Boolean, String> m() {
            return xb6.b.a.c();
        }

        public b(a r1) {
            this.a = r1;
        }

        public final Pair<Boolean, String> d(z0 r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            if (r4.getSwitchToSilence() == false) goto L21;
            g r5 = this.a.a;
            if (r5 == null) goto L9;
            e r6 = r5.j();
            if (r6 == null) goto L9;
            r6.d0(com.bytedance.kmp.live.livelink.api.multilink.media.StreamType.AUDIO, "handleKickOutMsg switchToSilence");
        L9:
            g r7 = this.a.a;
            if (r7 == null) goto L14;
            e r8 = r7.j();
            if (r8 == null) goto L14;
            r8.g0(false, "handleKickOutMsg switchToSilence");
        L14:
            g r9 = this.a.a;
            if (r9 == null) goto L20;
            e r10 = r9.j();
            if (r10 == null) goto L20;
            r10.v();
        L20:
            return new Pair(Boolean.TRUE, "chorus concert intercept");
        L21:
            g r11 = this.a.a;
            if (r11 == null) goto L25;
            r11.i1("leave chorus", false);
        L25:
            return new Pair(Boolean.TRUE, "chorus concert component");
        }

        public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.d(r2);
        }

        public final Pair<Boolean, String> j(z0 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.h(r2);
        }

        public final Pair<Boolean, String> l(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.m(r2);
        }

        public final Pair<Boolean, String> i(long r1, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "secToUserId");
            Intrinsics.checkNotNullParameter(r4, "toUserIdString");
            return xb6.b.a.j(r3, r4);
        }
    }

    public final ei6.a a() {
        g r0 = this.a;
        if (r0 == null) goto L7;
        e r1 = r0.j();
        if (r1 == null) goto L7;
        return r1.Z0();
    L7:
        return null;
    }

    public final d b() {
        g r0 = this.a;
        if (r0 == null) goto L11;
        e r1 = r0.j();
        if (r1 == null) goto L11;
        ec6.a r2 = r1.r0();
        if (r2 == null) goto L11;
        sk0.c r3 = r2.r();
        if (r3 == null) goto L11;
        return gc6.b.a(r3);
    L11:
        return null;
    }

    public a(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this.f = r9;
        IMultiLinkInternalService r0 = k.f(IMultiLinkInternalService.class);
        c r1 = null;
        if (r0 == null) goto L7;
        jb6.a r2 = r0.getLinkServiceScopeService();
        if (r2 == null) goto L7;
        MultiLinkService r3 = r2.wi(r9, Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE));
    L8:
        this.a = r3;
        js1.b r4 = new js1.b();
        this.b = r4;
        C0395a r5 = new C0395a(this);
        this.d = r5;
        b r6 = new b(this);
        this.e = r6;
        if (r3 == null) goto L11;
        r3.attach();
    L11:
        com.bytedance.live.datacontext.m r7 = m.i().getRoom();
        if (r7 == null) goto L18;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L18;
        if (r3 == null) goto L18;
        r3.b(r8.getId(), r8.getOwnerUserIdString(), null);
    L18:
        if (r3 == null) goto L20;
        r3.X0(r4, true);
    L20:
        if (r3 == null) goto L22;
        r3.e1(r6, true);
    L22:
        if (r3 == null) goto L24;
        r3.b1(r5, true);
    L24:
        if (r3 == null) goto L26;
        r1 = new c(r3, r9);
    L26:
        this.c = r1;
        if (r1 == null) goto L29;
        r1.e.X0(r1.d, true);
    L29:
        if (r1 == null) goto L32;
        gd2.e r10 = r4.a;
        Intrinsics.checkNotNullParameter(r10, "listener");
        r1.b.add(r10);
        return;
    L32:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
