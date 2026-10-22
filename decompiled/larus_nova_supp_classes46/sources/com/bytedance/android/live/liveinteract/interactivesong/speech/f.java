package com.bytedance.android.live.liveinteract.interactivesong.speech;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.k;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import fd2.t;
import fd2.v;
import hg6.g;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import uf2.z;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements k {
    public final /* synthetic */ a a;

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r1, boolean[] r2, int[] r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, s0 r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void V4(String r1, z.a r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r1, z.a r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f1(long r1, long r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void ip(Object r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void j0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void k1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    public f(a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h6(int r6) {
        a r0 = this.a;
        String r2 = null;
        if (r0.i == false) goto L30;
        ALogger.i("SpeechRecognitionProxy", "handleSelfAedStateChanged, AED state: " + r6);
        if (r0.b.a(r6) == true) goto L7;
        return;
    L7:
        if (r0.b.b() == false) goto L19;
        if (a.e() == true) goto L55;
        IInteractService r7 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r7 == null) goto L15;
        i<ILinkPlayerInfoBridge> r8 = r7.getLinkUserInfoCenter();
        if (r8 == null) goto L15;
        r2 = r8.N4(a.b());
    L15:
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        r0.i(r2, true);
        return;
    L55:
        return;
    L19:
        if (r0.f(a.b()) == true) goto L57;
        InteractiveSongContext r9 = InteractiveSongContext.Companion.getContext();
        if (r9 == null) goto L27;
        n<v> r10 = r9.getLyricsRecognizer();
        if (r10 == null) goto L27;
        v r11 = (v) r10.getValue();
        if (r11 == null) goto L27;
        r11.i();
    L27:
        r0.g();
        t r12 = r0.l;
        if (r12 == null) goto L58;
        r12.d(false);
        return;
    L58:
        return;
    L57:
        return;
    L30:
        IInteractService r1 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1 == null) goto L35;
        i<ILinkPlayerInfoBridge> r3 = r1.getLinkUserInfoCenter();
        if (r3 == null) goto L35;
        String r4 = r3.N4(a.b());
    L36:
        JSONObject r5 = new JSONObject();
        r5.put("aed_state", r6);
        r5.put("send_user_id", a.b());
        r5.put("send_interact_id", r4);
        JSONObject r13 = new JSONObject();
        r13.put("aed_report", r5);
        IInteractService r14 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r14 == null) goto L44;
        i<ILinkPlayerInfoBridge> r15 = r14.getLinkUserInfoCenter();
        if (r15 == null) goto L44;
        IRoom r16 = r0.h;
        if (r16 == null) goto L43;
        r2 = r16.getOwnerUserIdString();
    L43:
        r2 = r15.N4(r2);
    L44:
        cg6.a r17 = r0.c();
        if (r17 == null) goto L60;
        g r18 = r17.getRtcManager();
        if (r18 == null) goto L61;
        ei6.a r19 = r18.V0();
        if (r19 == null) goto L62;
        si6.b r20 = r19.b();
        if (r20 == null) goto L63;
        r20.p(bj6.a.b(r19), String.valueOf(r2), r13.toString());
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L35:
        r4 = null;
        goto L36
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "s");
        Intrinsics.checkNotNullParameter(r2, "s");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Z4(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void d5(dg2.e r2, dg2.e[] r3) {
        Intrinsics.checkNotNullParameter(r2, "localQuality");
        Intrinsics.checkNotNullParameter(r3, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r3, long r4) {
        ALogger.i("SpeechRecognitionProxy", "onUserLeaved songRecognition, id: ".concat(r3));
        if (this.a.i == true) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r3) == false) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L29;
        kd2.b r6 = (kd2.b) ((LinkedHashMap) this.a.c).get(r3);
        if (this.a.f(r3) == true) goto L22;
        if (r6 == null) goto L22;
        if (r6.b() != true) goto L22;
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L21;
        n<v> r1 = r0.getLyricsRecognizer();
        if (r1 == null) goto L21;
        v r2 = (v) r1.getValue();
        if (r2 == null) goto L21;
        r2.i();
    L21:
        this.a.g();
    L22:
        StringBuilder r7 = new StringBuilder("onUserLeaved, linkId: ");
        r7.append(r3);
        r7.append(", is play music: ");
        if (r6 == null) goto L25;
        Boolean r8 = Boolean.valueOf(r6.b());
    L26:
        r7.append(r8);
        ALogger.i("SpeechRecognitionProxy", r7.toString());
        this.a.c.remove(r3);
        return;
    L25:
        r8 = null;
        goto L26
    L29:
        return;
    L7:
        r5 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void g(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r2, "deviceId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }
}
