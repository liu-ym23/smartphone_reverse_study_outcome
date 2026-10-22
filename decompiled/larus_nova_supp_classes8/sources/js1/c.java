package js1;

import android.content.Context;
import android.os.Handler;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.larus.apm.impl.protector.RunnableProtector;
import gd2.e;
import hh1.v0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import m00.h;
import uf2.z;
import vb6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final tc0.c a;
    public final CopyOnWriteArraySet<e> b;
    public final Handler c;
    public final b d;
    public final g e;
    public final Context f;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ c a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;
            public final /* synthetic */ int b;
            public final /* synthetic */ Object[] c;

            public a(b r1, int r2, Object[] r3, long r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                int r0 = this.b;
                if (r0 != 7) goto L5;
                Iterator<e> r1 = this.a.a.b.iterator();
            L217:
                if (r1.hasNext() == false) goto L290;
                e r2 = r1.next();
                Object r4 = this.c[0];
                if (r4 == null) goto L222;
                r2.onUserJoined((String) r4);
                goto L217
            L222:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            L290:
                return;
            L5:
                if (r0 != 8) goto L7;
                Iterator<e> r3 = this.a.a.b.iterator();
            L209:
                if (r3.hasNext() == false) goto L289;
                e r5 = r3.next();
                Object r6 = this.c[0];
                if (r6 == null) goto L214;
                String r7 = (String) r6;
                r5.c();
                goto L209
            L214:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            L289:
                return;
            L7:
                if (r0 != 11) goto L9;
                Object[] r8 = this.c;
                if (r8[0] == null) goto L157;
                Object r9 = r8[1];
                if ((r9 instanceof SurfaceView) == true) goto L157;
                if ((r9 instanceof TextureView) == true) goto L157;
                boolean r10 = r9 instanceof z.a;
            L157:
                if (r8.length <= 4) goto L167;
                Object r11 = r8[3];
                if (r11 == null) goto L166;
                ((Integer) r11).intValue();
                Object r12 = this.c[4];
                if (r12 == null) goto L164;
                ((Integer) r12).intValue();
                goto L167
            L164:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L166:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L167:
                Object r13 = this.c[1];
                if ((r13 instanceof SurfaceView) == false) goto L180;
                Iterator<e> r14 = this.a.a.b.iterator();
            L171:
                if (r14.hasNext() == false) goto L286;
                e r15 = r14.next();
                Object[] r16 = this.c;
                Object r17 = r16[0];
                if ((r17 instanceof String) == true) goto L175;
                r17 = null;
            L175:
                String r18 = (String) r17;
                Object r19 = r16[1];
                if ((r19 instanceof SurfaceView) == true) goto L178;
                r19 = null;
            L178:
                r15.d(r18, (SurfaceView) r19);
                goto L171
            L286:
                return;
            L180:
                if ((r13 instanceof TextureView) == false) goto L194;
                Iterator<e> r20 = this.a.a.b.iterator();
            L183:
                if (r20.hasNext() == false) goto L287;
                e r21 = r20.next();
                if (r21 == null) goto L183;
                Object[] r22 = this.c;
                Object r23 = r22[0];
                if ((r23 instanceof String) == true) goto L189;
                r23 = null;
            L189:
                String r24 = (String) r23;
                Object r25 = r22[1];
                if ((r25 instanceof TextureView) == true) goto L192;
                r25 = null;
            L192:
                TextureView r26 = (TextureView) r25;
                r21.e();
                goto L183
            L287:
                return;
            L194:
                if ((r13 instanceof z.a) == false) goto L276;
                Iterator<e> r27 = this.a.a.b.iterator();
            L197:
                if (r27.hasNext() == false) goto L288;
                e r28 = r27.next();
                if (r28 == null) goto L197;
                Object[] r29 = this.c;
                Object r30 = r29[0];
                if ((r30 instanceof String) == true) goto L203;
                r30 = null;
            L203:
                String r31 = (String) r30;
                Object r32 = r29[1];
                if ((r32 instanceof z.a) == true) goto L206;
                r32 = null;
            L206:
                z.a r33 = (z.a) r32;
                r28.b(r31);
                goto L197
            L288:
                return;
            L276:
                return;
            L9:
                if (r0 != 14) goto L11;
                Object[] r34 = this.c;
                if (r34.length <= 5) goto L105;
                Object r35 = r34[4];
                if (r35 == null) goto L104;
                ((Integer) r35).intValue();
                Object r36 = this.c[5];
                if (r36 == null) goto L102;
                ((Integer) r36).intValue();
                goto L105
            L102:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L104:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L105:
                Object r37 = this.c[1];
                if ((r37 instanceof SurfaceView) == false) goto L120;
                Iterator<e> r38 = this.a.a.b.iterator();
            L109:
                if (r38.hasNext() == false) goto L283;
                e r39 = r38.next();
                if (r39 == null) goto L109;
                Object[] r40 = this.c;
                Object r41 = r40[0];
                if ((r41 instanceof String) == true) goto L115;
                r41 = null;
            L115:
                String r42 = (String) r41;
                Object r43 = r40[1];
                if ((r43 instanceof SurfaceView) == true) goto L118;
                r43 = null;
            L118:
                SurfaceView r44 = (SurfaceView) r43;
                r39.a(r42);
                goto L109
            L283:
                return;
            L120:
                if ((r37 instanceof TextureView) == false) goto L134;
                Iterator<e> r45 = this.a.a.b.iterator();
            L123:
                if (r45.hasNext() == false) goto L284;
                e r46 = r45.next();
                if (r46 == null) goto L123;
                Object[] r47 = this.c;
                Object r48 = r47[0];
                if ((r48 instanceof String) == true) goto L129;
                r48 = null;
            L129:
                String r49 = (String) r48;
                Object r50 = r47[1];
                if ((r50 instanceof TextureView) == true) goto L132;
                r50 = null;
            L132:
                TextureView r51 = (TextureView) r50;
                r46.h();
                goto L123
            L284:
                return;
            L134:
                if ((r37 instanceof z.a) == false) goto L275;
                Iterator<e> r52 = this.a.a.b.iterator();
            L137:
                if (r52.hasNext() == false) goto L285;
                e r53 = r52.next();
                if (r53 == null) goto L137;
                Object[] r54 = this.c;
                Object r55 = r54[0];
                if ((r55 instanceof String) == true) goto L143;
                r55 = null;
            L143:
                String r56 = (String) r55;
                Object r57 = r54[1];
                if ((r57 instanceof z.a) == true) goto L146;
                r57 = null;
            L146:
                z.a r58 = (z.a) r57;
                r53.f(r56);
                goto L137
            L285:
                return;
            L275:
                return;
            L11:
                if (r0 != 16) goto L13;
                Object[] r59 = this.c;
                Object r60 = r59[0];
                if ((r60 instanceof String) == true) goto L80;
                r60 = null;
            L80:
                String r61 = (String) r60;
                if (r61 == null) goto L223;
                tc0.c r62 = this.a.a.a;
                Object r63 = r59[1];
                if ((r63 instanceof Boolean) == true) goto L85;
                r63 = null;
            L85:
                x.k0(r61, r62, (Boolean) r63);
                Iterator<e> r64 = this.a.a.b.iterator();
            L87:
                if (r64.hasNext() == false) goto L282;
                e r65 = r64.next();
                if (r65 == null) goto L87;
                Object r66 = this.c[1];
                if ((r66 instanceof Boolean) == true) goto L93;
                r66 = null;
            L93:
                r65.g(r61, (Boolean) r66);
                goto L87
            L282:
                return;
            L223:
                return;
            L13:
                if (r0 != 18) goto L15;
                Iterator<e> r67 = this.a.a.b.iterator();
            L67:
                if (r67.hasNext() == false) goto L281;
                e r68 = r67.next();
                Object[] r69 = this.c;
                Object r70 = r69[0];
                if (r70 == null) goto L76;
                String r71 = (String) r70;
                Object r72 = r69[1];
                if (r72 == null) goto L74;
                r68.Z4(r71, ((Integer) r72).intValue());
                goto L67
            L74:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L76:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            L281:
                return;
            L15:
                if (r0 != 26) goto L17;
                Iterator<e> r73 = this.a.a.b.iterator();
            L55:
                if (r73.hasNext() == false) goto L280;
                e r75 = r73.next();
                Object[] r76 = this.c;
                Object r77 = r76[0];
                if (r77 == null) goto L64;
                dg2.e r78 = (dg2.e) r77;
                Object r79 = r76[1];
                if (r79 == null) goto L62;
                r75.d5(r78, (dg2.e[]) r79);
                goto L55
            L62:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkQualityStats>");
            L64:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkQualityStats");
            L280:
                return;
            L17:
                if (r0 != 30) goto L19;
                Iterator<e> r80 = this.a.a.b.iterator();
            L27:
                if (r80.hasNext() == false) goto L279;
                e r81 = r80.next();
                Object[] r82 = this.c;
                Object r83 = r82[0];
                if (r83 == null) goto L52;
                LiveWrappedNetworkDetectionLinkType r84 = (LiveWrappedNetworkDetectionLinkType) r83;
                Object r85 = r82[1];
                if (r85 == null) goto L50;
                ((Integer) r85).intValue();
                Object r86 = this.c[2];
                if (r86 == null) goto L48;
                int r87 = ((Integer) r86).intValue();
                Object r110 = this.c[3];
                if (r110 == null) goto L46;
                double r111 = ((Double) r110).doubleValue();
                Object r112 = this.c[4];
                if (r112 == null) goto L44;
                ((Integer) r112).intValue();
                Object r113 = this.c[5];
                if (r113 == null) goto L42;
                ((Integer) r113).intValue();
                r81.x1(r84, r87, r111);
                goto L27
            L42:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L44:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L46:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
            L48:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L50:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            L52:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType");
            L279:
                return;
            L19:
                if (r0 != 37) goto L277;
                Iterator<e> r88 = this.a.a.b.iterator();
            L23:
                if (r88.hasNext() == false) goto L278;
                r88.next().k1();
                goto L23
            L278:
                return;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(c r1) {
            this.a = r1;
        }

        public final ec6.a O2(String r4) {
            Intrinsics.checkNotNullParameter(r4, "liveCoreSetting");
            IMiddlewareBroadcastService r0 = (IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class);
            if (r0 == null) goto L5;
            h r5 = r0.createVoiceRoomVideoView(this.a.getContext(), r4);
        L7:
            if ((r5 instanceof v0) == true) goto L9;
            r5 = null;
        L9:
            v0 r6 = (v0) r5;
            if (r6 != null) goto L12;
            return null;
        L12:
            return gc6.b.c(r6, null);
        L5:
            r5 = null;
            goto L7
        }

        public final void vc(ei6.a r8, int r9, long r10, Object... r12) {
            Intrinsics.checkNotNullParameter(r12, "params");
            this.a.c.post(new a(this, r9, r12, r10));
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f;
    }

    public c(g r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "linkService");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.e = r2;
        this.f = r3;
        this.a = tc0.c.h();
        this.b = new CopyOnWriteArraySet();
        this.c = new Handler();
        this.d = new b(this);
    }
}
