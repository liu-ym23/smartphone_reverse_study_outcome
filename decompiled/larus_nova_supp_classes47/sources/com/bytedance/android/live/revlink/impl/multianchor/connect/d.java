package com.bytedance.android.live.revlink.impl.multianchor.connect;

import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import fr2.g0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends f {
    public final a g;

    public static final class a extends com.bytedance.android.live.revenuelink.rtc.e {
        public final /* synthetic */ d a;
        public final /* synthetic */ com.bytedance.android.live.revenuelink.rtc.i b;
        public final /* synthetic */ yz0.g c;
        public final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.vm.b d;
        public final /* synthetic */ AnchorRtcConnectManager e;
        public final /* synthetic */ AnchorRtcConnectModel f;

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void o() {
            com.bytedance.android.live.revenuelink.rtc.i r0 = this.b;
            if (r0 == null) goto L5;
            r0.j();
        L5:
            Pair[] r1 = new Pair[4];
            yz0.g r2 = this.c;
            String r3 = "";
            if (r2 == null) goto L11;
            IRoomBase r4 = r2.mo444getRoom();
            if (r4 == null) goto L11;
            String r5 = r4.getIdStr();
            if (r5 == null) goto L11;
        L12:
            r1[0] = TuplesKt.to("room_id", r5);
            com.bytedance.android.live.revlink.impl.multianchor.vm.b r6 = this.d;
            if (r6 == null) goto L17;
            com.bytedance.live.datacontext.m<Long> r7 = r6.getChannelId();
            if (r7 == null) goto L17;
            Long r8 = (Long) r7.getValue();
        L18:
            r1[1] = TuplesKt.to("channel_id", String.valueOf(r8));
            r1[2] = TuplesKt.to("module", LiveTracingMonitorKt.EventModule.MULTI_LINKER.name());
            com.bytedance.android.live.revenuelink.rtc.i r9 = this.b;
            if (r9 == null) goto L24;
            String r10 = r9.c0();
            if (r10 == null) goto L24;
            r3 = r10;
        L24:
            r1[3] = TuplesKt.to("linker_session_id", r3);
            Map r12 = MapsKt.mapOf(r1);
            KProperty[] r13 = g.a;
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            g.b.setValue(null, g.a[0], r12);
            return;
        L17:
            r8 = null;
        L11:
            r5 = "";
            goto L12
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void onUserJoined(String r2) {
            Intrinsics.checkNotNullParameter(r2, "interactId");
            this.f.getOnRtcUserJoinEvent().post(r2);
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void R(long r3, Exception r5) {
            jy0.b.c("ttlive_anchor_connect_mgr", "rtc start failed " + r3 + ' ' + r5, null, 4);
            AnchorRtcConnectManager r4 = this.e;
            int r6 = AnchorRtcConnectManager.o;
            r4.l("startFailed", false);
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void e1(String r1, long r2) {
            this.f.onUserLeave(r1);
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void L0(String r2, TextureView r3, int r4, int r5) {
            if (r3 == null) goto L5;
            boolean r6 = this.a.b(r2);
            this.f.onFirstFrame(r2, new g21.d(r3, r6));
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void T3(String r2, vc0.a r3, int r4, int r5) {
            fr2.l r6 = null;
            Object r7 = null;
            xh6.c r8 = null;
            if (r3 == null) goto L16;
            Object r9 = r3.b;
            if ((r9 instanceof xh6.c) == true) goto L7;
            xh6.c r10 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.l.class), r3.a);
            if ((r10 instanceof fr2.l) == false) goto L15;
            r8 = r10;
        L15:
            r6 = (fr2.l) r8;
            goto L16
        L7:
            if ((r9 instanceof fr2.l) == false) goto L10;
            r7 = r9;
        L10:
            r6 = (fr2.l) r7;
        L16:
            if (r2 == null) goto L20;
            if (r6 == null) goto L21;
            boolean r12 = this.a.b(r2);
            this.f.onFirstFrame(r2, new g21.b(r6, r12));
            return;
        L21:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void V3(String r2, vc0.a r3, int r4, int r5) {
            fr2.l r6 = null;
            Object r7 = null;
            xh6.c r8 = null;
            if (r3 == null) goto L16;
            Object r9 = r3.b;
            if ((r9 instanceof xh6.c) == true) goto L7;
            xh6.c r10 = vh6.c.b(g0.class).o6().e(Reflection.getOrCreateKotlinClass(fr2.l.class), r3.a);
            if ((r10 instanceof fr2.l) == false) goto L15;
            r8 = r10;
        L15:
            r6 = (fr2.l) r8;
            goto L16
        L7:
            if ((r9 instanceof fr2.l) == false) goto L10;
            r7 = r9;
        L10:
            r6 = (fr2.l) r7;
        L16:
            if (r2 == null) goto L20;
            if (r6 == null) goto L21;
            boolean r12 = this.a.b(r2);
            this.f.onFirstFrameRender(r2, new g21.b(r6, r12));
            this.a.c(r2);
            return;
        L21:
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void h1(String r2, SurfaceView r3, int r4, int r5) {
            if (r3 == null) goto L5;
            boolean r6 = this.a.b(r2);
            this.f.onFirstFrame(r2, new g21.c(r3, r6));
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void j0(String r2, TextureView r3, int r4, int r5) {
            if (r3 == null) goto L5;
            boolean r6 = this.a.b(r2);
            this.f.onFirstFrameRender(r2, new g21.d(r3, r6));
            this.a.c(r2);
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.rtc.e, com.bytedance.android.live.revenuelink.rtc.g
        public final void y0(String r2, SurfaceView r3, int r4, int r5) {
            if (r3 == null) goto L5;
            boolean r6 = this.a.b(r2);
            this.f.onFirstFrameRender(r2, new g21.c(r3, r6));
            this.a.c(r2);
            return;
        }

        public a(d r1, com.bytedance.android.live.revenuelink.rtc.i r2, yz0.g r3, com.bytedance.android.live.revlink.impl.multianchor.vm.b r4, AnchorRtcConnectManager r5, AnchorRtcConnectModel r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.connect.f
    public final a d() {
        return this.g;
    }

    public d(com.bytedance.android.live.revenuelink.rtc.i r9, AnchorRtcConnectManager r10, AnchorRtcConnectModel r12, com.bytedance.android.live.revlink.impl.multianchor.vm.b r13, yz0.g r14, w r15, com.bytedance.android.live.revlink.impl.multianchor.utils.g0 r16) {
        Intrinsics.checkNotNullParameter(r10, "rtcConnectionManager");
        Intrinsics.checkNotNullParameter(r12, "rtcConnectModel");
        super(r9, r10, r12, r13, r14, r15, r16);
        this.g = new a(this, r9, r14, r13, r10, r12);
    }
}
