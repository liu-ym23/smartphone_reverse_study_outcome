package com.bytedance.android.live.profit.format.voicechat.rtc;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.scope.o;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfitRTCService implements b, o {
    public static final /* synthetic */ int i = 0;
    public String a;
    public final CopyOnWriteArrayList<com.bytedance.android.live.profit.format.voicechat.rtc.a> b;
    public boolean c;
    public final HashSet<String> d;
    public boolean e;
    public ku0.c f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void stopAndRelease() {
        this.c = false;
        this.b.clear();
        ku0.c r0 = this.f;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.f = null;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void f() {
        if (this.c == true) goto L14;
        ku0.c r0 = this.f;
        if (r0 == null) goto L12;
        ALogger.i("ProfitRTCEngine", "publishStream");
        ku0.a r2 = r0.d;
        if (r2 == null) goto L10;
        r2.c();
    L10:
        if (r0.a == true) goto L12;
        r0.a = true;
        ALogger.i("ProfitRTCEngine", "updateLocalAudioCaptureStatus:true");
    L12:
        this.c = true;
        return;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void g() {
        if (this.c == false) goto L14;
        ku0.c r0 = this.f;
        if (r0 == null) goto L12;
        ALogger.i("ProfitRTCEngine", "unpublishStream");
        ku0.a r2 = r0.d;
        if (r2 == null) goto L10;
        r2.c();
    L10:
        if (r0.a == false) goto L12;
        r0.a = false;
        ALogger.i("ProfitRTCEngine", "updateLocalAudioCaptureStatus:false");
    L12:
        this.c = false;
        return;
    }

    public ProfitRTCService() {
        this.a = "";
        this.b = new CopyOnWriteArrayList();
        this.d = new HashSet();
        this.g = LazyKt.lazy(new ProfitRTCService$rtcEngineEventListener$2(this));
        this.h = LazyKt.lazy(new ProfitRTCService$rtcRoomListener$2(this));
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        if (this.f == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "content");
        return;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void h(hu0.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listerner");
        this.b.add(r2);
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.rtc.b
    public final void d(Context r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2.a(r5) == false) goto L8;
        if (r5 != null) goto L6;
        String r8 = "";
    L7:
        this.a = r8;
        goto L8
    L6:
        r8 = r5;
    L8:
        this.f = new ku0.c(r1, (ku0.a) this.g.getValue(), (ku0.b) this.h.getValue());
        lu0.a r9 = new lu0.a();
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        ku0.c r10 = this.f;
        if (r10 == null) goto L15;
        r10.a(r9);
        return;
    }
}
