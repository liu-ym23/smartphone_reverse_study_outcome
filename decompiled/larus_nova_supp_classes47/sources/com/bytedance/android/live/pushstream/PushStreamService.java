package com.bytedance.android.live.pushstream;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStatesAndAVResourceUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.pushstream.utils.StreamSignHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import hh1.v0;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001fH\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0016\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010#H\u0016J\n\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0016J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106¨\u0006:"}, d2 = {"Lcom/bytedance/android/live/pushstream/PushStreamService;", "Lcom/bytedance/android/live/pushstream/IPushStreamService;", "", "init", "Lcom/bytedance/android/live/pushstream/u;", "config", "Lcom/bytedance/android/live/pushstream/d;", "createLiveStreamWithConfig", "Landroid/content/Context;", "context", "Lfi6/a;", "Lei6/a;", "createGuestClient", "Lhh1/v0;", "createGuestAudioFactory", "Lqv0/a;", "getLiveStreamController", "getRecordLiveStream", "getPushLiveStream", "getLiveRoomStreamCache", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lwv0/a;", "createStreamSignHelper", "releaseRecordLiveStream", "Landroid/view/SurfaceView;", "surfaceView", "liveStream", "Lnv0/a;", "getCameraCaptureInst", "getVoiceRoomCameraCaptureInst", "Lcom/bytedance/android/live/pushstream/report/c;", "statusResultListener", "Lcom/bytedance/android/live/pushstream/report/a;", "getStreamReporter", "Lorg/json/JSONObject;", "getLiveCoreDebugInfo", "", "", "getFpsInfo", "getClientDebugInfo", "Luf2/d0$a;", "getLiveCoreBuilder", "", "getRenderFps", "getLastAudioCaptureLogMap", "getLastVideoCaptureLogMap", "Lcom/bytedance/android/live/pushstream/LiveStream4;", "Lcom/bytedance/android/live/pushstream/LiveStream4;", "Lcom/bytedance/android/live/pushstream/LiveStream4Proxy;", "liveStream4Proxy", "Lcom/bytedance/android/live/pushstream/LiveStream4Proxy;", "Ljava/lang/ref/WeakReference;", "pushLiveStream", "Ljava/lang/ref/WeakReference;", "liveRoomStreamCache", "<init>", "()V", "livepushstream-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PushStreamService implements IPushStreamService {
    private WeakReference<d> liveRoomStreamCache;
    private LiveStream4 liveStream;
    private LiveStream4Proxy liveStream4Proxy;
    private WeakReference<d> pushLiveStream;

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public v0 createGuestAudioFactory(Context r1) {
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public ei6.a createGuestClient(Context r1, fi6.a r2) {
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public void init() {
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public JSONObject getClientDebugInfo() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 == null) goto L7;
        d r1 = r0.get();
        if (r1 == null) goto L7;
        return r1.getClientInfo();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public Map<String, String> getFpsInfo() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 == null) goto L7;
        d r1 = r0.get();
        if (r1 == null) goto L7;
        return r1.getFpsInfo();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public Map<String, String> getLastAudioCaptureLogMap() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 == null) goto L9;
        d r1 = r0.get();
        if (r1 == null) goto L9;
        Map<String, String> r2 = r1.getLastAudioCaptureLogMap();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public Map<String, String> getLastVideoCaptureLogMap() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 == null) goto L9;
        d r1 = r0.get();
        if (r1 == null) goto L9;
        Map<String, String> r2 = r1.getLastVideoCaptureLogMap();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d0.a getLiveCoreBuilder() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 == null) goto L9;
        d r1 = r0.get();
        if (r1 == null) goto L9;
        d0 r2 = r1.A();
        if (r2 == null) goto L9;
        return r2.getBuilder();
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public JSONObject getLiveCoreDebugInfo() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 == null) goto L9;
        d r1 = r0.get();
        if (r1 == null) goto L9;
        d0 r2 = r1.getLiveCore();
        if (r2 == null) goto L9;
        return r2.c();
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d getLiveRoomStreamCache() {
        WeakReference<d> r0 = this.liveRoomStreamCache;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d getPushLiveStream() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public double getRenderFps() {
        WeakReference<d> r0 = this.pushLiveStream;
        if (r0 == null) goto L11;
        d r1 = r0.get();
        if (r1 == null) goto L11;
        d0 r2 = r1.getLiveCore();
        if (r2 == null) goto L11;
        z r3 = r2.C();
        if (r3 == null) goto L11;
        return r3.a();
    L11:
        return -1.0d;
    }

    public PushStreamService() {
        jc1.k.l(IPushStreamService.class, this);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public void releaseRecordLiveStream() {
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L8;
        LiveStream4Proxy r0 = this.liveStream4Proxy;
        if (r0 == null) goto L7;
        r0.release();
    L7:
        this.liveStream4Proxy = null;
    L8:
        LiveStream4 r1 = this.liveStream;
        if (r1 == null) goto L11;
        r1.release();
    L11:
        this.liveStream = null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d createLiveStreamWithConfig(u r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        LiveStream4 r0 = new LiveStream4(r3);
        d0 r1 = null;
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L16;
        LiveStream4Proxy r4 = new LiveStream4Proxy(r0);
        if (LiveRoomStatesAndAVResourceUtils.a() == false) goto L13;
        WeakReference<d> r2 = this.liveRoomStreamCache;
        if (r2 == null) goto L11;
        d r5 = r2.get();
        if (r5 == null) goto L11;
        r1 = r5.getLiveCore();
    L11:
        if (r1 != null) goto L13;
        this.liveRoomStreamCache = new WeakReference(r4);
    L13:
        this.pushLiveStream = new WeakReference(r4);
        return r4;
    L16:
        if (LiveRoomStatesAndAVResourceUtils.a() == false) goto L24;
        WeakReference<d> r6 = this.liveRoomStreamCache;
        if (r6 == null) goto L22;
        d r7 = r6.get();
        if (r7 == null) goto L22;
        r1 = r7.getLiveCore();
    L22:
        if (r1 != null) goto L24;
        this.liveRoomStreamCache = new WeakReference(r0);
    L24:
        this.pushLiveStream = new WeakReference(r0);
        return r0;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public wv0.a createStreamSignHelper(IRoom r2) {
        return new StreamSignHelper(r2);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public qv0.a getLiveStreamController(Context r1) {
        new com.bytedance.android.live.broadcast.live.newstream.c();
        throw null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d getRecordLiveStream(Context r6) {
        if (this.liveStream != null) goto L5;
    L9:
        u.a r0 = new u.a(r6);
        r0.q = s1.B(2131922659);
        r0.v = new vv0.c();
        r0.p = new vv0.d();
        r0.n = 0;
        r0.w = new vv0.e();
        int r7 = r0.c;
        if (r7 != 0) goto L12;
        r7 = 500;
    L12:
        r0.c = r7;
        int r8 = r0.d;
        if (r8 != 0) goto L15;
        r8 = 200;
    L15:
        r0.d = r8;
        int r9 = r0.e;
        if (r9 != 0) goto L18;
        r9 = 800;
    L18:
        r0.e = r9;
        int r10 = r0.g;
        if (r10 != 0) goto L21;
        r10 = 360;
    L21:
        r0.g = r10;
        int r12 = r0.h;
        if (r12 != 0) goto L24;
        r12 = 640;
    L24:
        r0.h = r12;
        int r13 = r0.f;
        if (r13 != 0) goto L27;
        r13 = 15;
    L27:
        r0.f = r13;
        int r14 = r0.j;
        if (r14 != 0) goto L30;
        r14 = 9;
    L30:
        r0.j = r14;
        long r1 = r0.k;
        if (r1 != 0) goto L33;
        r1 = 60000;
    L33:
        r0.k = r1;
        int r15 = r0.l;
        if (r15 != 0) goto L36;
        r15 = 44100;
    L36:
        r0.l = r15;
        int r2 = 1;
        int r3 = 2;
        if (r0.m == 2) goto L40;
        r3 = 1;
    L40:
        r0.m = r3;
        String r4 = "";
        if (TextUtils.isEmpty(r0.b) == false) goto L43;
        String r16 = "";
    L44:
        r0.b = r16;
        int r17 = r0.i;
        if (r17 != 0) goto L47;
        int r18 = 1;
    L48:
        r0.i = r18;
        int r19 = r0.n;
        if (r19 != (-1)) goto L51;
        r19 = 4;
    L51:
        r0.n = r19;
        int r20 = r0.o;
        if (r20 != (-1)) goto L54;
        r20 = 1;
    L54:
        r0.o = r20;
        if ("".equals(r0.q) == false) goto L57;
        String r22 = "live-stream-sdk";
    L58:
        r0.q = r22;
        int r23 = r0.s;
        if (r23 == 0) goto L62;
        r2 = r23;
    L62:
        r0.s = r2;
        float r24 = r0.r;
        if (r24 != 0.0f) goto L65;
        r24 = 2.0f;
    L65:
        r0.r = r24;
        String r25 = r0.u;
        if (r25 != null) goto L68;
        r25 = "";
    L68:
        r0.u = r25;
        String r26 = r0.t;
        if (r26 != null) goto L71;
        r26 = "";
    L71:
        r0.t = r26;
        if (TextUtils.isEmpty(r0.x) == true) goto L75;
        r4 = r0.x;
    L75:
        r0.x = r4;
        LiveStream4 r5 = new LiveStream4(new u(r0));
        this.liveStream = r5;
        this.liveStream4Proxy = new LiveStream4Proxy(r5);
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L78;
        d r27 = this.liveStream4Proxy;
    L80:
        return r27;
    L78:
        r27 = this.liveStream;
        goto L80
    L57:
        r22 = r0.q;
        goto L58
    L47:
        r18 = Math.min(r17, 3);
        goto L48
    L43:
        r16 = r0.b;
        goto L44
    L5:
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L7;
        d r28 = this.liveStream4Proxy;
    L8:
        if (r28 == null) goto L9;
        return r28;
    L7:
        r28 = this.liveStream;
        goto L8
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public nv0.a getCameraCaptureInst(SurfaceView r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
        Intrinsics.checkNotNullParameter(r4, "liveStream");
        return new nv0.b(r3, r4, false);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public com.bytedance.android.live.pushstream.report.a getStreamReporter(IRoom r2, com.bytedance.android.live.pushstream.report.c r3) {
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r3, "statusResultListener");
        return new com.bytedance.android.live.pushstream.report.d(r2, r3);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public nv0.a getVoiceRoomCameraCaptureInst(SurfaceView r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "surfaceView");
        Intrinsics.checkNotNullParameter(r4, "liveStream");
        return new nv0.b(r3, r4, true);
    }
}
