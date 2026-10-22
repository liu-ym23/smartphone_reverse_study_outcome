package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.ILiveWrappedRtcService;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMediaStreamType;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import uf2.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int l = 0;
    public m00.g a;
    public ei6.a b;
    public mi6.b c;
    public ci0.a d;
    public boolean e;
    public boolean f;
    public boolean g;
    public l h;
    public k i;
    public final b j;
    public final Set<String> k;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a$a, reason: collision with other inner class name */
    public static final class C0065a {
    }

    public static final class b implements h0.c {
        public b(a r1) {
        }
    }

    static {
    }

    public final void c() {
        ALogger.i("AdventureLinkEngine", "destroyEngine");
        mi6.b r0 = this.c;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        this.c = null;
        ILiveWrappedRtcService.Companion.getClass();
        ILiveWrappedRtcService.a.a().destroyRTCEngine();
        m00.g r1 = this.a;
        if (r1 == null) goto L10;
        com.bytedance.android.live.pushstream.d r2 = r1.getLiveStream();
        if (r2 == null) goto L10;
        r2.release();
    L10:
        this.a = null;
        this.b = null;
        this.e = false;
        this.f = false;
    }

    public final void d() {
        Iterator<String> r0 = this.k.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        ei6.a r2 = this.b;
        if (r2 == null) goto L4;
        gi6.e r3 = r2.getEventManager();
        if (r3 == null) goto L4;
        r3.c(r1);
        goto L4
    L10:
        this.k.clear();
    }

    public final void e() {
        ALogger.i("AdventureLinkEngine", "pause");
        if (this.e == false) goto L21;
        ALogger.i("AdventureLinkEngine", "pause start");
        m00.g r0 = this.a;
        if (r0 == null) goto L9;
        com.bytedance.android.live.pushstream.d r1 = r0.getLiveStream();
        if (r1 == null) goto L9;
        r1.Q0(true, "adventure background pause", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.pause.setAudioMute", null));
    L9:
        m00.g r2 = this.a;
        if (r2 == null) goto L14;
        com.bytedance.android.live.pushstream.d r3 = r2.getLiveStream();
        if (r3 == null) goto L14;
        r3.J0("adventure background pause", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.pauseBackground", null));
    L14:
        mi6.b r4 = this.c;
        if (r4 == null) goto L17;
        r4.e();
    L17:
        k r5 = this.i;
        if (r5 == null) goto L22;
        r5.a(false);
        return;
    L22:
        return;
    }

    public final void f() {
        g.b r0 = g.j;
        Intrinsics.checkNotNullParameter(r0, "callback");
        this.i = r0;
    }

    public final void g() {
        g.c r0 = g.i;
        Intrinsics.checkNotNullParameter(r0, "callback");
        this.h = r0;
    }

    public final void h() {
        ALogger.i("AdventureLinkEngine", "resume");
        if (this.e == false) goto L21;
        ALogger.i("AdventureLinkEngine", "resume start");
        m00.g r0 = this.a;
        if (r0 == null) goto L9;
        com.bytedance.android.live.pushstream.d r1 = r0.getLiveStream();
        if (r1 == null) goto L9;
        r1.q1("adventure background resume", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.resumeBackground", null));
    L9:
        m00.g r2 = this.a;
        if (r2 == null) goto L14;
        com.bytedance.android.live.pushstream.d r3 = r2.getLiveStream();
        if (r3 == null) goto L14;
        r3.Q0(false, "adventure background resume", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.resume.setAudioMute", null));
    L14:
        mi6.b r4 = this.c;
        if (r4 == null) goto L17;
        r4.e();
    L17:
        k r5 = this.i;
        if (r5 == null) goto L22;
        r5.a(true);
        return;
    L22:
        return;
    }

    public a() {
        this.g = true;
        this.j = new b(this);
        this.k = new LinkedHashSet();
    }

    public static final void a(a r1, String r2, LiveWrappedMediaStreamType r3) {
        r1.getClass();
        StringBuilder r4 = new StringBuilder("onUserPublishStream, uid: ");
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r4.append(r2);
        r4.append(", type: ");
        r4.append(r3);
        ALogger.i("AdventureLinkEngine", r4.toString());
    }

    public static final void b(a r1, String r2, LiveWrappedMediaStreamType r3) {
        r1.getClass();
        ALogger.i("AdventureLinkEngine", "onUserUnpublishStream, uid: " + r2 + ", type: " + r3 + ", reason: null");
    }
}
