package com.bytedance.android.live.livepkaudience.rtc;

import android.os.Handler;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.g;
import com.bytedance.android.live.liveinteract.plantform.core.u;
import com.bytedance.android.live.liveinteract.plantform.core.v;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.liveinteract.utils.j1;
import com.bytedance.android.live.livepkaudience.linksecurity.LinkSecurityManager;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pushstream.IEffectPerfToolsHelper;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.jn0;
import com.bytedance.android.livesdk.config.ma1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.larus.apm.impl.protector.RunnableProtector;
import dl0.n;
import gy.h;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements ii6.a {
    public static final /* synthetic */ int x = 0;
    public ei6.a a;
    public d0 b;
    public v0 c;
    public v d;
    public final CompositeDisposable e;
    public Disposable f;
    public Disposable g;
    public final Handler h;
    public u i;
    public boolean j;
    public final ArrayList<ui6.a> k;
    public long l;
    public final Set<String> m;
    public final Map<String, Long> n;
    public final Map<String, Long> o;
    public final ii6.a p;
    public v0 q;
    public final gy.a r;
    public Map<String, Object> s;
    public final HashSet<String> t;
    public Integer u;
    public String v;
    public Room w;

    /* JADX INFO: renamed from: com.bytedance.android.live.livepkaudience.rtc.a$a, reason: collision with other inner class name */
    public static final class C0118a {
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final MultiChannelInfo c;
        public final String d;

        public b() {
            this(null, null, 15);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            if (r4 == true) goto L9;
            r1 = r4;
        L9:
            int r5 = (r3 + r1) * 31;
            MultiChannelInfo r6 = this.c;
            int r7 = 0;
            if (r6 == null) goto L12;
            int r8 = r6.hashCode();
        L13:
            int r9 = (r5 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L17;
            r7 = r10.hashCode();
        L17:
            return r9 + r7;
        L12:
            r8 = 0;
            goto L13
        }

        public final String toString() {
            return "StartEngineParams(needPushStream=" + this.a + ", enableAllRemoteRender=" + this.b + ", multiChannelInfo=" + this.c + ", channelId=" + this.d + ")";
        }

        public b(MultiChannelInfo r5, String r6, int r7) {
            boolean r1 = false;
            if ((r7 & 1) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r7 & 2) == 0) goto L10;
            r1 = true;
        L10:
            if ((r7 & 4) == 0) goto L13;
            r5 = null;
        L13:
            if ((r7 & 8) == 0) goto L15;
            r6 = "";
        L15:
            Intrinsics.checkNotNullParameter(r6, "channelId");
            this.a = r0;
            this.b = r1;
            this.c = r5;
            this.d = r6;
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Exception d;

        public c(a r1, int r2, long r3, Exception r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void a() {
            int r0 = this.b;
            String r4 = null;
            if (r0 != (-1)) goto L22;
            Disposable r1 = this.a.f;
            if (r1 == null) goto L7;
            r1.dispose();
        L7:
            gy.a r2 = this.a.r;
            if (r2 == null) goto L17;
            long r5 = this.c;
            Exception r3 = this.d;
            if (r3 == null) goto L12;
            r4 = r3.getMessage();
        L12:
            h r7 = r2.f;
            LiveTracingMonitor.EventModule r8 = LiveTracingMonitor.b(0);
            int r12 = (int) r5;
            if (r4 != null) goto L15;
            String r13 = "";
        L16:
            r7.n(r8, "start_error", "", r2.a(), r12, r13);
            goto L17
        L15:
            r13 = r4;
        L17:
            v r6 = this.a.d;
            if (r6 == null) goto L20;
            r6.R(this.c, this.d);
        L20:
            this.a.f("onStartFailed");
            return;
        L22:
            if (r0 != (-2)) goto L31;
            Disposable r9 = this.a.g;
            if (r9 == null) goto L26;
            r9.dispose();
        L26:
            v r10 = this.a.d;
            if (r10 == null) goto L29;
            r10.G9(this.c, this.d);
        L29:
            this.a.getClass();
            return;
        L31:
            if (r0 != (-3)) goto L45;
            gy.a r11 = this.a.r;
            long r14 = this.c;
            Exception r15 = this.d;
            if (r15 == null) goto L35;
            r4 = r15.getMessage();
        L35:
            h r16 = r11.f;
            LiveTracingMonitor.EventModule r17 = LiveTracingMonitor.b(0);
            int r18 = (int) r14;
            if (r4 != null) goto L38;
            String r19 = "";
        L39:
            r16.n(r17, "did_occur_error", "", r11.a(), r18, r19);
            v r20 = this.a.d;
            if (r20 == null) goto L46;
            r20.f0(this.c, this.d);
            return;
        L46:
            return;
        L38:
            r19 = r4;
            goto L39
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

    public static final class d implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Object[] d;

        public d(a r1, int r2, long r3, Object[] r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            int r1 = this.b;
            if (r1 != 1) goto L5;
            v r2 = this.a.d;
            if (r2 == null) goto L325;
            r2.o0(this.c);
            return;
        L325:
            return;
        L5:
            if (r1 == 2) goto L273;
            Object r7 = null;
            Object r8 = null;
            Object r9 = null;
            Object r10 = null;
            Object r11 = null;
            Object r12 = null;
            Object r13 = null;
            Object r14 = null;
            Object r15 = null;
            String r16 = null;
            Object r17 = null;
            if (r1 != 19) goto L9;
            Object[] r3 = this.d;
            Object r4 = r3[0];
            if ((r4 instanceof String) == false) goto L260;
            r7 = r4;
        L260:
            String r18 = (String) r7;
            if (r18 == null) goto L320;
            Object r5 = r3[1];
            if (r5 == null) goto L272;
            int r6 = ((Integer) r5).intValue();
            Object r19 = this.d[2];
            if (r19 == null) goto L270;
            int r20 = ((Integer) r19).intValue();
            v r21 = this.a.d;
            if (r21 == null) goto L321;
            r21.S(r18, r6, r20);
            return;
        L321:
            return;
        L270:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L272:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L320:
            return;
        L9:
            switch(r1) {
                case 4: goto L149;
                case 5: goto L138;
                case 6: goto L131;
                case 7: goto L119;
                case 8: goto L98;
                case 9: goto L85;
                case 10: goto L75;
                case 11: goto L14;
                default: goto L10;
            };
        L10:
            switch(r1) {
                case 14: goto L179;
                case 15: goto L167;
                case 16: goto L155;
                default: goto L12;
            };
        L155:
            Object[] r22 = this.d;
            Object r23 = r22[0];
            if ((r23 instanceof String) == true) goto L158;
            r23 = null;
        L158:
            String r24 = (String) r23;
            if (r24 == null) goto L305;
            v r25 = this.a.d;
            if (r25 == null) goto L306;
            Object r26 = r22[1];
            if ((r26 instanceof Boolean) == false) goto L166;
            r8 = r26;
        L166:
            r25.g(r24, (Boolean) r8);
            return;
        L306:
            return;
        L305:
            return;
        L167:
            Object[] r27 = this.d;
            Object r28 = r27[0];
            if ((r28 instanceof String) == true) goto L170;
            r28 = null;
        L170:
            String r29 = (String) r28;
            if (r29 == null) goto L308;
            v r30 = this.a.d;
            if (r30 == null) goto L309;
            Object r31 = r27[1];
            if ((r31 instanceof Boolean) == false) goto L178;
            r9 = r31;
        L178:
            r30.A(r29, (Boolean) r9);
            return;
        L309:
            return;
        L308:
            return;
        L179:
            Object r32 = this.d[0];
            if (r32 == null) goto L185;
            gy.a r33 = this.a.r;
            if (r33 == null) goto L184;
            String r34 = r32.toString();
            long r110 = this.a.l;
            Intrinsics.checkNotNullParameter(r34, "linkId");
            r33.e = System.currentTimeMillis();
            h.o(r33.f, LiveTracingMonitor.b(0), "first_remote_video_frame_render", r34, r33.a(), 0, 48);
            ALogger.i(r33.a, "onFirstVideoFrameRender " + r34);
        L184:
            this.a.l = 0;
        L185:
            Object[] r35 = this.d;
            if (r35.length <= 5) goto L196;
            Object r36 = r35[4];
            if (r36 == null) goto L195;
            int r37 = ((Integer) r36).intValue();
            Object r38 = this.d[5];
            if (r38 == null) goto L193;
            int r39 = ((Integer) r38).intValue();
        L197:
            Object[] r40 = this.d;
            Object r41 = r40[1];
            boolean r42 = r41 instanceof SurfaceView;
            if (r42 == false) goto L209;
            v r43 = this.a.d;
            if (r43 == null) goto L311;
            Object r44 = r40[0];
            if ((r44 instanceof String) == true) goto L204;
            r44 = null;
        L204:
            String r45 = (String) r44;
            if (r42 == false) goto L208;
            r10 = r41;
        L208:
            r43.y0(r45, (SurfaceView) r10, r37, r39);
            return;
        L311:
            return;
        L209:
            boolean r46 = r41 instanceof TextureView;
            if (r46 == false) goto L221;
            v r47 = this.a.d;
            if (r47 == null) goto L313;
            Object r48 = r40[0];
            if ((r48 instanceof String) == true) goto L216;
            r48 = null;
        L216:
            String r49 = (String) r48;
            if (r46 == false) goto L220;
            r11 = r41;
        L220:
            r47.j0(r49, (TextureView) r11, r37, r39);
            return;
        L313:
            return;
        L221:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r50 = ILiveWrappedLivePusher.a.b();
            if (r50 == null) goto L224;
            z.a r51 = r50.buildLayerControlLayer(this.d[1]);
        L225:
            v r52 = this.a.d;
            if (r52 == null) goto L315;
            Object r53 = this.d[0];
            if ((r53 instanceof String) == false) goto L231;
            r12 = r53;
        L231:
            r52.V4((String) r12, r51);
            return;
        L315:
            return;
        L224:
            r51 = null;
            goto L225
        L193:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L195:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L196:
            r37 = 0;
            r39 = 0;
            goto L197
        L12:
            switch(r1) {
                case 301: goto L248;
                case 302: goto L240;
                case 303: goto L232;
                default: goto L326;
            };
        L232:
            this.a.getClass();
            this.a.getClass();
            gy.a r54 = this.a.r;
            if (r54 == null) goto L239;
            Object r55 = this.d[0];
            if (r55 == null) goto L238;
            int r56 = ((LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError) r55).value();
            String r57 = String.valueOf(this.d[1]);
            Intrinsics.checkNotNullParameter(r57, "roomId");
            HashMap r111 = r54.a();
            r111.put("target_room_id", r57);
            ALogger.e(r54.a, "onForwardStreamFailed " + r56 + ' ' + r57);
            h.o(r54.f, LiveTracingMonitor.b(0), "start_forward_stream_failed", "", r111, r56, 32);
            goto L239
        L238:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError");
        L239:
            int r58 = a.x;
            ALogger.i("GuestRtcManager", "GuestRtcManager on cross room rtc info failed " + this.d[0] + ' ' + this.d[1]);
            return;
        L240:
            this.a.getClass();
            gy.a r59 = this.a.r;
            if (r59 == null) goto L247;
            Object r60 = this.d[0];
            if (r60 == null) goto L246;
            int r61 = ((LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError) r60).value();
            String r62 = String.valueOf(this.d[1]);
            Intrinsics.checkNotNullParameter(r62, "roomId");
            HashMap r112 = r59.a();
            r112.put("target_room_id", r62);
            ALogger.e(r59.a, "onForwardStreamSuccess " + r61 + ' ' + r62);
            h.o(r59.f, LiveTracingMonitor.b(0), "start_forward_stream_success", "", r112, r61, 32);
            goto L247
        L246:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError");
        L247:
            int r63 = a.x;
            ALogger.i("GuestRtcManager", "GuestRtcManager on cross room rtc info success " + this.d[0] + ' ' + this.d[1]);
            return;
        L248:
            this.a.getClass();
            gy.a r65 = this.a.r;
            if (r65 == null) goto L255;
            Object r66 = this.d[0];
            if (r66 == null) goto L254;
            int r67 = ((LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError) r66).value();
            String r68 = String.valueOf(this.d[1]);
            Intrinsics.checkNotNullParameter(r68, "roomId");
            HashMap r113 = r65.a();
            r113.put("target_room_id", r68);
            ALogger.e(r65.a, "onForwardStreamStop " + r67 + ' ' + r68);
            h.o(r65.f, LiveTracingMonitor.b(0), "stop_forward_stream", "", r113, r67, 32);
            goto L255
        L254:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError");
        L255:
            int r69 = a.x;
            ALogger.i("GuestRtcManager", "GuestRtcManager on cross room rtc info idle " + this.d[0] + ' ' + this.d[1]);
            return;
        L326:
            return;
        L14:
            int r70 = a.x;
            ALogger.i("GuestRtcManager", "MSG_INFO_FIRST_REMOTE_VIDEO, linkId: " + this.d[0]);
            Object r71 = this.d[0];
            if (r71 == null) goto L20;
            this.a.n.put(r71.toString(), Long.valueOf(System.currentTimeMillis()));
            gy.a r72 = this.a.r;
            if (r72 == null) goto L19;
            String r73 = r71.toString();
            long r114 = this.a.l;
            Intrinsics.checkNotNullParameter(r73, "linkId");
            r72.d = System.currentTimeMillis();
            h.o(r72.f, LiveTracingMonitor.b(0), "first_remote_video_decoded_of_uid", r73, r72.a(), 0, 48);
            ALogger.w(r72.a, "onFirstVideoFrame " + r73);
        L19:
            this.a.l = 0;
        L20:
            Object[] r74 = this.d;
            if (r74.length <= 4) goto L31;
            Object r75 = r74[3];
            if (r75 == null) goto L30;
            int r76 = ((Integer) r75).intValue();
            Object r77 = this.d[4];
            if (r77 == null) goto L28;
            int r78 = ((Integer) r77).intValue();
        L32:
            Object[] r79 = this.d;
            Object r80 = r79[1];
            if (r80 == null) goto L39;
            Map<String, Object> r81 = this.a.s;
            Object r82 = r79[0];
            if (r82 == null) goto L38;
            r81.put((String) r82, r80);
            goto L39
        L38:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L39:
            Object[] r83 = this.d;
            Object r84 = r83[1];
            boolean r85 = r84 instanceof SurfaceView;
            if (r85 == false) goto L51;
            v r86 = this.a.d;
            if (r86 == null) goto L284;
            Object r87 = r83[0];
            if ((r87 instanceof String) == true) goto L46;
            r87 = null;
        L46:
            String r88 = (String) r87;
            if (r85 == false) goto L50;
            r13 = r84;
        L50:
            r86.h1(r88, (SurfaceView) r13, r76, r78);
            return;
        L284:
            return;
        L51:
            boolean r89 = r84 instanceof TextureView;
            if (r89 == false) goto L63;
            v r90 = this.a.d;
            if (r90 == null) goto L286;
            Object r91 = r83[0];
            if ((r91 instanceof String) == true) goto L58;
            r91 = null;
        L58:
            String r92 = (String) r91;
            if (r89 == false) goto L62;
            r14 = r84;
        L62:
            r90.L0(r92, (TextureView) r14, r76, r78);
            return;
        L286:
            return;
        L63:
            if (r84 == null) goto L288;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r93 = ILiveWrappedLivePusher.a.b();
            if (r93 == null) goto L67;
            z.a r94 = r93.buildLayerControlLayer(this.d[1]);
        L68:
            v r95 = this.a.d;
            if (r95 == null) goto L289;
            Object r96 = this.d[0];
            if ((r96 instanceof String) == false) goto L74;
            r15 = r96;
        L74:
            r95.b4((String) r15, r94, r76, r78);
            return;
        L289:
            return;
        L67:
            r94 = null;
            goto L68
        L288:
            return;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L31:
            r76 = 0;
            r78 = 0;
            goto L32
        L75:
            Object r97 = this.d[0];
            if (r97 == null) goto L78;
            r16 = r97.toString();
        L78:
            if (r16 == null) goto L291;
            gy.a r98 = this.a.r;
            if (r98 == null) goto L82;
            Intrinsics.checkNotNullParameter(r16, "linkId");
            h.o(r98.f, LiveTracingMonitor.b(0), "first_remote_audio_of_uid", r16, r98.a(), 0, 48);
        L82:
            a r99 = this.a;
            r99.l = 0;
            v r100 = r99.d;
            if (r100 == null) goto L292;
            r100.L(r16);
            return;
        L292:
            return;
        L291:
            return;
        L85:
            v r101 = this.a.d;
            if (r101 == null) goto L294;
            Object[] r102 = this.d;
            Object r103 = r102[0];
            if ((r103 instanceof String[]) == true) goto L90;
            r103 = null;
        L90:
            String[] r104 = (String[]) r103;
            Object r105 = r102[1];
            if ((r105 instanceof boolean[]) == true) goto L93;
            r105 = null;
        L93:
            boolean[] r106 = (boolean[]) r105;
            Object r107 = r102[2];
            if ((r107 instanceof int[]) == false) goto L97;
            r17 = r107;
        L97:
            r101.J(r104, r106, (int[]) r17);
            return;
        L294:
            return;
        L98:
            Object r108 = this.d[0];
            if (r108 == null) goto L103;
            this.a.m.remove(r108.toString());
            gy.a r109 = this.a.r;
            if (r109 == null) goto L103;
            String r115 = r108.toString();
            Intrinsics.checkNotNullParameter(r115, "linkId");
            h.o(r109.f, LiveTracingMonitor.b(0), "did_offline_of_uid", r115, r109.a(), 0, 48);
            ALogger.w(r109.a, "onUserLeave " + r115);
        L103:
            Map<String, Object> r116 = this.a.s;
            Object r117 = this.d[0];
            if (r117 == null) goto L118;
            r116.remove((String) r117);
            v r118 = this.a.d;
            if (r118 == null) goto L112;
            Object r119 = this.d[0];
            if (r119 == null) goto L111;
            r118.e1((String) r119, this.c);
            goto L112
        L111:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L112:
            HashSet<String> r120 = this.a.t;
            Object r121 = this.d[0];
            if (r121 == null) goto L116;
            r120.remove((String) r121);
            return;
        L116:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L118:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L119:
            Object r122 = this.d[0];
            if (r122 == null) goto L124;
            this.a.m.add(r122.toString());
            this.a.o.put(r122.toString(), Long.valueOf(System.currentTimeMillis()));
            gy.a r123 = this.a.r;
            if (r123 == null) goto L124;
            String r124 = r122.toString();
            Intrinsics.checkNotNullParameter(r124, "linkId");
            h.o(r123.f, LiveTracingMonitor.b(0), "did_user_join", r124, r123.a(), 0, 48);
            ALogger.w(r123.a, "onUserJoin " + r124);
        L124:
            v r125 = this.a.d;
            if (r125 == null) goto L297;
            Object r126 = this.d[0];
            if (r126 == null) goto L130;
            r125.onUserJoined((String) r126);
            return;
        L130:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L297:
            return;
        L131:
            v r127 = this.a.d;
            if (r127 == null) goto L299;
            Object r128 = this.d[0];
            if (r128 == null) goto L137;
            r127.wk((String) r128);
            return;
        L137:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L299:
            return;
        L138:
            ei6.a r129 = this.a.a;
            if (r129 == null) goto L143;
            gi6.e r130 = r129.getEventManager();
            if (r130 == null) goto L143;
            r130.b(null);
        L143:
            a r131 = this.a;
            r131.a = null;
            r131.getClass();
            this.a.getClass();
            Disposable r132 = this.a.g;
            if (r132 == null) goto L146;
            r132.dispose();
        L146:
            v r133 = this.a.d;
            if (r133 == null) goto L301;
            r133.M1();
            return;
        L301:
            return;
        L149:
            a r134 = this.a;
            gy.a r135 = r134.r;
            long r136 = r134.l;
            r135.getClass();
            r135.b = System.currentTimeMillis();
            h.o(r135.f, LiveTracingMonitor.b(0), "did_join_channel", "", r135.a(), 0, 48);
            ALogger.w(r135.a, "onRtcStartSuccess cost " + (System.currentTimeMillis() - r136) + "ms");
            Disposable r137 = this.a.f;
            if (r137 == null) goto L152;
            r137.dispose();
        L152:
            v r138 = this.a.d;
            if (r138 == null) goto L303;
            r138.o();
            return;
        L303:
            return;
        L273:
            v r139 = this.a.d;
            if (r139 == null) goto L323;
            long r140 = this.c;
            Object r141 = this.d[0];
            if (r141 == null) goto L279;
            r139.f1(r140, ((Integer) r141).intValue());
            return;
        L279:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
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

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            tc0.c r6 = tc0.c.h();
            int r0 = x.a;
            Intrinsics.checkNotNullParameter(r6, "dataHolder");
            HashMap r1 = new HashMap();
            x.a(r1);
            g.n("rtc_stop_time_out", r1, r6, true);
        }
    }

    static {
    }

    public final String a() {
        ei6.a r0 = this.a;
        if (r0 == null) goto L7;
        si6.b r1 = r0.b();
        if (r1 == null) goto L7;
        String r2 = r1.m();
    L9:
        return String.valueOf(r2);
    L7:
        r2 = null;
        goto L9
    }

    public a(Room r2) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        this.w = r2;
        this.e = new CompositeDisposable();
        this.h = new Handler();
        this.k = new ArrayList();
        this.m = new LinkedHashSet();
        this.n = new LinkedHashMap();
        this.o = new LinkedHashMap();
        this.p = (ii6.a) WeakReferenceWrapper.wrap(this);
        this.r = new gy.a(this.w);
        this.s = new LinkedHashMap();
        this.t = new HashSet();
        this.v = "";
    }

    public final void d(boolean r4) {
        HashSet<String> r0 = this.t;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.j = false;
        this.m.clear();
        if (r4 == true) goto L13;
        ei6.a r5 = this.a;
        if (r5 == null) goto L12;
        si6.b r6 = r5.b();
        if (r6 == null) goto L12;
        si6.a.b(r6, false, "GuestRtcManager onDestroy", 3);
    L12:
        this.s.clear();
    L13:
        this.e.dispose();
        Disposable r7 = this.f;
        if (r7 == null) goto L16;
        r7.dispose();
    L16:
        Disposable r8 = this.g;
        if (r8 == null) goto L19;
        r8.dispose();
    L19:
        this.h.removeCallbacksAndMessages(null);
    }

    public final void f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reqFrom");
        this.j = false;
        this.m.clear();
        gy.a r1 = this.r;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r6, "reqSrc");
        HashMap r2 = r1.a();
        r2.put("req_src", r6);
        h r3 = r1.f;
        LiveTracingMonitor.EventModule r4 = LiveTracingMonitor.b(0);
        int r5 = h.d;
        r3.m(r4, "stop_interact_streaming", r2, false);
    L5:
        u r7 = this.i;
        if (r7 == null) goto L9;
        r7.l8();
    L9:
        if (this.a != null) goto L13;
        gy.a r8 = this.r;
        if (r8 == null) goto L13;
        r8.c("guestStopEngine " + r6);
    L13:
        ei6.a r9 = this.a;
        if (r9 == null) goto L18;
        ui6.b r10 = r9.h();
        if (r10 == null) goto L18;
        r10.a(a());
    L18:
        ei6.a r11 = this.a;
        if (r11 == null) goto L23;
        si6.b r12 = r11.b();
        if (r12 == null) goto L23;
        si6.a.b(r12, false, "GuestRtcManager stopEngine", 3);
    L23:
        System.currentTimeMillis();
        Disposable r13 = this.g;
        if (r13 == null) goto L26;
        r13.dispose();
    L26:
        this.g = Observable.timer(10, TimeUnit.SECONDS).subscribe(e.a);
        ei6.a r14 = this.a;
        if (r14 == null) goto L31;
        ri6.b r15 = r14.r();
        if (r15 == null) goto L31;
        r15.s1();
    L31:
        Disposable r16 = this.f;
        if (r16 == null) goto L34;
        r16.dispose();
    L34:
        this.s.clear();
        HashSet<String> r17 = this.t;
        if (r17 == null) goto L38;
        r17.clear();
        return;
    }

    public final void g(String r5) {
        Intrinsics.checkNotNullParameter(r5, "req");
        this.k.clear();
        if (this.j == false) goto L12;
        gy.a r1 = this.r;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r5, "req");
        HashMap r0 = r1.a();
        r0.put("stop_forward_req", r5);
        h r6 = r1.f;
        LiveTracingMonitor.EventModule r2 = LiveTracingMonitor.b(0);
        int r3 = h.d;
        r6.m(r2, "stop_forward_stream", r0, false);
    L8:
        if (this.a != null) goto L12;
        gy.a r7 = this.r;
        if (r7 == null) goto L12;
        r7.c("guestStopForwardStreamToRooms");
    L12:
        ei6.a r8 = this.a;
        if (r8 == null) goto L18;
        ui6.b r9 = r8.h();
        if (r9 == null) goto L19;
        r9.a(a());
        return;
    L19:
        return;
    }

    public static void i(a r6, String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        Integer r2 = null;
        if (r0 == false) goto L10;
        String r1 = r7;
    L11:
        if (r1 == null) goto L39;
        d0 r3 = r6.b;
        if (r3 == null) goto L17;
        d0.a r4 = r3.getBuilder();
        if (r4 == null) goto L17;
        r2 = Integer.valueOf(r4.f0());
    L17:
        ALogger.w("GuestRtcManager", "GuestRtcManager updateLiveCoreExtInfo ".concat(r7));
        gy.a r5 = r6.r;
        HashMap r8 = r5.a();
        r8.put("liveCore", r7);
        h r9 = r5.f;
        LiveTracingMonitor.EventModule r10 = LiveTracingMonitor.b(0);
        int r11 = h.d;
        r9.m(r10, "update_live_core", r8, false);
        if (k.n(IEffectPerfToolsHelper.class).checkDebug() == false) goto L20;
        k.n(IEffectPerfToolsHelper.class).setPerfToolsNormalData("data_chatroom_livecore_extra", r7);
    L20:
        ei6.a r12 = r6.a;
        if (r12 == null) goto L25;
        si6.b r13 = r12.b();
        if (r13 == null) goto L25;
        r13.f(r7);
    L25:
        d0 r14 = r6.b;
        if (r14 == null) goto L28;
        r14.A();
    L28:
        if (r2 == null) goto L43;
        d0 r15 = r6.b;
        if (r15 == null) goto L40;
        d0.a r16 = r15.getBuilder();
        if (r16 != null) goto L35;
        return;
    L35:
        if (r2.intValue() == r16.f0()) goto L42;
        r6.u = r2;
        return;
    L42:
        return;
    L40:
        return;
    L43:
        return;
    L39:
        return;
    L10:
        r1 = null;
        goto L11
    L6:
        r0 = false;
        goto L7
    }

    public static void j(a r5, String r6) {
        Intrinsics.checkNotNullParameter("", "src");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        String r1 = r6;
    L11:
        if (r1 == null) goto L19;
        ALogger.w("GuestRtcManager", "GuestRtcManager updateRtcExtInfo ".concat(r6));
        r5.v = r6;
        LinkSecurityManager.f("switch_resolution");
        gy.a r2 = r5.r;
        HashMap r3 = r2.a();
        r3.put("rtc_params", r6);
        h r4 = r2.f;
        LiveTracingMonitor.EventModule r7 = LiveTracingMonitor.b(0);
        int r8 = h.d;
        r4.m(r7, "update_rtc_params", r3, false);
        ei6.a r9 = r5.a;
        if (r9 == null) goto L20;
        si6.b r10 = r9.b();
        if (r10 == null) goto L21;
        r10.c(r6);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r1 = null;
        goto L11
    L7:
        r0 = false;
        goto L8
    }

    public final ei6.a b(v0 r5, String r6) {
        this.q = r5;
        Intrinsics.checkNotNullParameter(r6, "rtcExtInfo");
        fi6.a r0 = new fi6.a();
        r0.h(TTMiddlewareLiveSDK.getContext());
        Intrinsics.checkNotNullParameter(r6, "info");
        r0.v = r6;
        r0.S = 5;
        String r1 = s1.B(2131922659);
        Intrinsics.checkNotNullParameter(r1, "key");
        r0.w = r1;
        String r2 = k.n(IHostContext.class).getChannel();
        Intrinsics.checkNotNullParameter(r2, "channel");
        r0.y = r2;
        r0.c(String.valueOf(k.n(IHostContext.class).appId()));
        r0.e(k.n(IHostContext.class).getVersionCode());
        r0.d(String.valueOf(k.n(IHostContext.class).getUpdateVersionCode()));
        if (k.n(IHostContext.class).isBoe() == false) goto L6;
        r0.l(Env.ENV_BOE);
    L6:
        if (((Boolean) jn0.a.getValue()).booleanValue() == true) goto L8;
    L10:
        boolean r3 = true;
        if (((Boolean) ma1.a.getValue()).booleanValue() == false) goto L13;
        r0.j = 1;
    L13:
        r0.k(j1.a());
        if (n.b() == false) goto L16;
        r0.Z = true;
        x.O(true);
    L17:
        v r4 = this.d;
        if (r4 == null) goto L21;
        r4.p2(r0);
    L21:
        if (r6.length() == 0) goto L24;
        r3 = false;
    L24:
        if (r3 == false) goto L26;
        ALogger.e("GuestRtcManager", "GuestRtcManager initEngine rtcInfo is empty");
    L26:
        if (r5 != null) goto L30;
        return null;
    L30:
        return r5.create();
    L16:
        x.O(false);
        goto L17
    L8:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L10;
        r0.l(Env.ENV_TEST);
        goto L10
    }

    public final void c(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "interactId");
        ei6.a r0 = this.a;
        if (r0 == null) goto L7;
        ri6.b r1 = r0.r();
        if (r1 == null) goto L7;
        r1.l(a(), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r8, r9, "revenue switch audio");
    L7:
        if (r9 == false) goto L9;
        this.t.add(r8);
        return;
    L9:
        this.t.remove(r8);
    }

    public final void h(boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        ei6.a r1 = this.a;
        if (r1 == null) goto L7;
        ri6.b r2 = r1.r();
        if (r2 == null) goto L7;
        r2.s(a(), !r5);
    L7:
        d0 r3 = this.b;
        if (r3 == null) goto L10;
        r3.k();
    L10:
        gy.a r4 = this.r;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "reason");
        HashMap r7 = r4.a();
        r7.put("enable", String.valueOf(r5));
        r7.put("reason", r6);
        h r8 = r4.f;
        LiveTracingMonitor.EventModule r0 = LiveTracingMonitor.b(0);
        int r9 = h.d;
        r8.m(r0, "switch_audio", r7, false);
    }

    public final Integer e(Map<Long, String> r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "channelId");
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<Long, String>> r2 = r10.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<Long, String> r3 = r2.next();
        if (r3.getKey().longValue() == this.w.id) goto L4;
        r1.add(new ui6.a(String.valueOf(r3.getKey().longValue()), r3.getValue()));
        goto L4
    L8:
        this.k.clear();
        this.k.addAll(r1);
        gy.a r4 = this.r;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r10, "rtcInfoMap");
        Intrinsics.checkNotNullParameter(r1, "forwardRoomList");
        Intrinsics.checkNotNullParameter(r11, "reqFrom");
        String r13 = Arrays.toString(CollectionsKt.toLongArray(r10.keySet()));
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r0.add(((ui6.a) r5.next()).a);
        goto L10
    L12:
        String r6 = r0.toString();
        HashMap r7 = r4.a();
        r7.put("rtc_map_keys", r13);
        r7.put("forward_rooms", r6);
        r7.put("req_from", r11);
        h r14 = r4.f;
        LiveTracingMonitor.EventModule r8 = LiveTracingMonitor.b(0);
        int r9 = h.d;
        r14.m(r8, "start_forward_stream", r7, false);
        ei6.a r15 = this.a;
        if (r15 == null) goto L17;
        ui6.b r16 = r15.h();
        if (r16 == null) goto L17;
        r16.d(a(), r1, r12);
        return 0;
    L17:
        return null;
    }

    public final void H(ei6.a r8, int r9, long r10, Exception r12) {
        this.h.post(new c(this, r9, r10, r12));
    }

    public final void M(ei6.a r8, int r9, long r10, Object... r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        this.h.post(new d(this, r9, r10, r12));
    }
}
