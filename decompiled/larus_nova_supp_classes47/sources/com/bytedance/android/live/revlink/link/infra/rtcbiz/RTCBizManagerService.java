package com.bytedance.android.live.revlink.link.infra.rtcbiz;

import com.bytedance.android.live.core.utils.b0;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RTCBizManagerService extends com.bytedance.android.live.revlink.link.infra.rtcbiz.a implements o, b {
    public static final /* synthetic */ int k = 0;
    public final AnchorRtcConnectModel a;
    public final CompositeDisposable b;
    public final RTCManagerDataContext c;
    public final Map<String, d> d;
    public final m<Map<String, d>> e;
    public final n<com.bytedance.android.live.revlink.impl.multianchor.connect.o> f;
    public Map<String, Boolean> g;
    public final com.bytedance.android.livesdk.revenue.service.room.c h;
    public final com.bytedance.android.live.revlink.impl.global.c i;
    public final i j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCBizManagerService$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "", "Lcom/bytedance/android/live/revlink/link/utils/LinkerID;", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Map<String, ? extends Boolean>, Unit> {
        public AnonymousClass2(RTCBizManagerService r8) {
            super(1, r8, RTCBizManagerService.class, "onFrameRenderStateChange", "onFrameRenderStateChange(Ljava/util/Map;)V", 0);
        }

        public final void invoke(Map<String, Boolean> r6) {
            RTCBizManagerService r0 = (RTCBizManagerService) ((CallableReference) this).receiver;
            int r1 = RTCBizManagerService.k;
            r0.getClass();
            if (r6 == null) goto L23;
            jy0.b.c("RTCBizManagerService", "onFrameRenderStateChange with renderState: " + r6 + " and stack: " + ExceptionsKt.stackTraceToString(new Error()), null, 4);
            r0.g = r6;
            m<Map<String, d>> r2 = r0.c.getRenderFrames();
            LinkedHashMap r3 = new LinkedHashMap();
            Iterator<Map.Entry<String, Boolean>> r7 = r6.entrySet().iterator();
        L7:
            if (r7.hasNext() == false) goto L11;
            Map.Entry<String, Boolean> r4 = r7.next();
            if (r4.getValue().booleanValue() == false) goto L7;
            r3.put(r4.getKey(), r4.getValue());
            goto L7
        L11:
            LinkedHashMap r8 = new LinkedHashMap(MapsKt.mapCapacity(r3.size()));
            Iterator r5 = r3.entrySet().iterator();
        L13:
            if (r5.hasNext() == false) goto L15;
            Map.Entry r9 = (Map.Entry) r5.next();
            r8.put(r9.getKey(), new d((String) r9.getKey()));
            goto L13
        L15:
            r2.setValue(r8);
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Map) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onStart() {
        jy0.b.c("RTCBizManagerService", "onStart", null, 4);
        f.a((Disposable) com.bytedance.live.datacontext.d.a(new AnonymousClass1(this)).getSecond(), this.b);
        f.a(b0.b(this.a.getFrameRenderState(), new AnonymousClass2(this)), this.b);
    }

    public final void onStop() {
        jy0.b.c("RTCBizManagerService", "onStop", null, 4);
        ((LinkedHashMap) this.d).clear();
        this.e.setValue(this.d);
        this.b.clear();
    }

    @Override // com.bytedance.android.live.revlink.link.infra.rtcbiz.b
    public final n<com.bytedance.android.live.revlink.impl.multianchor.connect.o> getForwardInfo() {
        return this.f;
    }

    @Override // com.bytedance.android.live.revlink.link.infra.rtcbiz.b
    public final m<Map<String, d>> getRenderFrames() {
        return this.e;
    }

    public RTCBizManagerService(com.bytedance.android.livesdk.revenue.service.room.c r9, com.bytedance.android.live.revlink.impl.global.c r10, i r12) {
        Intrinsics.checkNotNullParameter(r9, "roomService");
        Intrinsics.checkNotNullParameter(r10, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r12, "anchorRtcManager");
        this.h = r9;
        this.i = r10;
        this.j = r12;
        AnchorRtcConnectModel r13 = new AnchorRtcConnectModel(r9, r10, null, null, 12, null);
        this.a = r13;
        this.b = new CompositeDisposable();
        RTCManagerDataContext r14 = new RTCManagerDataContext(r13.getRtcForwardData());
        this.c = r14;
        this.d = new LinkedHashMap();
        this.e = r14.getRenderFrames();
        this.f = r14.getForwardInfo();
    }
}
