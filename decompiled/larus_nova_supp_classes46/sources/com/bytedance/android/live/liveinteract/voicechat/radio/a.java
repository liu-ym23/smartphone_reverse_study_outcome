package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.livelink.multilink.MultiLinkService;
import com.bytedance.android.livesdk.chatroom.model.interact.k2;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.dm;
import com.bytedance.android.livesdk.config.hj1;
import com.bytedance.android.livesdk.config.hr;
import com.bytedance.android.livesdk.config.jr0;
import com.bytedance.android.livesdk.config.ma1;
import com.bytedance.android.livesdk.config.uh1;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final com.bytedance.android.live.pushstream.d a;
    public vb6.g b;
    public m00.e c;
    public he0.b d;
    public final Map<String, Integer> e;
    public final b f;
    public final Context g;
    public final k2 h;
    public final j1 i;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.voicechat.radio.a$a, reason: collision with other inner class name */
    public static final class C0108a {
    }

    public static final class b implements xb6.a {
        public final /* synthetic */ a a;

        public b(a r1) {
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

        public final void c(fi6.a r7) {
            Intrinsics.checkNotNullParameter(r7, "config");
            a r0 = this.a;
            r0.getClass();
            if (((Boolean) hj1.a.getValue()).booleanValue() == false) goto L5;
            int r1 = le0.a.a;
            InteractMode r2 = InteractMode.FM;
        L6:
            r0.d = new he0.b(new c(r0), r0.e, r0.i);
            String r3 = r0.h.a();
            if (r3 != null) goto L9;
            r3 = "";
        L9:
            r7.f = r0.d;
            r7.f(LinkConstant.STREAM_BACKGROUND);
            r7.h(r0.g);
            Intrinsics.checkNotNullParameter(r3, "info");
            r7.v = r3;
            r7.S = 5;
            r7.o(qi6.g.h);
            String r4 = s1.B(2131922659);
            Intrinsics.checkNotNullParameter(r4, "key");
            r7.w = r4;
            r7.i(r2);
            r7.N = 300;
            r7.g(Character.ANCHOR);
            r7.d = -1;
            r7.R = ((Boolean) uh1.a.getValue()).booleanValue();
            r7.Q = (int) ((Number) jr0.a.getValue()).longValue();
            he0.b r5 = r0.d;
            Intrinsics.checkNotNull(r5);
            r5.b = r7;
            com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            IBaseStreamUrl r8 = null;
            if (r6 == null) goto L12;
            IRoom r9 = (IRoom) r6.getValue();
        L13:
            m00.e r10 = r0.c;
            if (r10 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
        L16:
            if (r10 == null) goto L36;
            r10.d();
            if (r9 == null) goto L20;
            r8 = r9.getStreamUrl();
        L20:
            Intrinsics.checkNotNull(r8);
            r7.e = r8.getRtmpPushUrl();
            MixStreamType r11 = MixStreamType.SERVER_MIX;
            r7.j(r11);
            r7.n(StreamType.VIDEO);
            if (((Boolean) hr.a.getValue()).booleanValue() == false) goto L27;
            Boolean r12 = (Boolean) dm.a.getValue();
            r7.W = false;
            if (r12.booleanValue() == false) goto L25;
            r11 = MixStreamType.RTC_CLIENT_MIX;
        L25:
            r7.j(r11);
        L27:
            if (com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.c.a() == false) goto L29;
            r7.Z = true;
            x.O(true);
        L31:
            if (((Boolean) ma1.a.getValue()).booleanValue() == false) goto L33;
            r7.j = 1;
        L33:
            he0.b r13 = r0.d;
            Intrinsics.checkNotNull(r13);
            r13.b = r7;
            return;
        L29:
            x.O(false);
            goto L31
        L36:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.ILinkInRoomView");
        L12:
            r9 = null;
            goto L13
        L5:
            r2 = InteractMode.FM;
            goto L6
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

    static {
    }

    public a(Context r2, k2 r3, j1 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "initRtcInfo");
        Intrinsics.checkNotNullParameter(r4, "scopeProvider");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.e = new HashMap();
        this.f = new b(this);
        jb6.a r5 = r4.getScopeServiceOrNullInMultiLinkRoom(jb6.a.class);
        com.bytedance.android.live.pushstream.d r6 = null;
        if (r5 == null) goto L5;
        MultiLinkService r7 = r5.wi(r2, gh0.a.d());
    L6:
        this.b = r7;
        com.bytedance.live.datacontext.j r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r8 == null) goto L9;
        r6 = (com.bytedance.android.live.pushstream.d) r8.getValue();
    L9:
        this.a = r6;
        return;
    L5:
        r7 = null;
        goto L6
    }
}
