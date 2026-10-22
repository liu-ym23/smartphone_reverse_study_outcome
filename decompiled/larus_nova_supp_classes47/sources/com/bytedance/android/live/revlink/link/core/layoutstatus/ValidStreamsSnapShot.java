package com.bytedance.android.live.revlink.link.core.layoutstatus;

import com.bytedance.android.live.core.utils.b0;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ValidStreamsSnapShot implements c<Map<String, ? extends com.bytedance.android.live.revlink.link.infra.rtcbiz.d>> {
    public final CompositeDisposable a;
    public Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> b;
    public final com.bytedance.android.live.revlink.link.infra.rtcbiz.b c;
    public final d d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.core.layoutstatus.ValidStreamsSnapShot$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/bytedance/android/live/revlink/link/utils/LinkerID;", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/d;", "p1", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Map<String, ? extends com.bytedance.android.live.revlink.link.infra.rtcbiz.d>, Unit> {
        public AnonymousClass1(ValidStreamsSnapShot r8) {
            super(1, r8, ValidStreamsSnapShot.class, "onRenderFramesUpdate", "onRenderFramesUpdate(Ljava/util/Map;)V", 0);
        }

        public final void invoke(Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            ValidStreamsSnapShot r0 = (ValidStreamsSnapShot) ((CallableReference) this).receiver;
            if (r0.a(r0.b, r3) == true) goto L7;
            r0.b = r3;
            r0.d.requestLayout();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Map) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void attach() {
        jy0.b.c("ValidStreamsSnapShot", "attach with validStream: " + this.b, null, 4);
        com.bytedance.revenue.platform.api.core.rx.f.a(b0.a(this.c.getRenderFrames(), new AnonymousClass1(this)), this.a);
    }

    @Override // com.bytedance.android.live.revlink.link.core.layoutstatus.c
    public final void detach() {
        this.a.clear();
        this.b = MapsKt.emptyMap();
        jy0.b.c("ValidStreamsSnapShot", "attach with validStream: " + this.b, null, 4);
    }

    public ValidStreamsSnapShot(com.bytedance.android.live.revlink.link.infra.rtcbiz.b r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.c = r2;
        this.d = r3;
        this.a = new CompositeDisposable();
        this.b = MapsKt.emptyMap();
    }

    public final boolean a(Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r5, Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r6) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        return true;
    L7:
        if (r5 == null) goto L19;
        if (r6 == null) goto L19;
        if (r5.size() != r6.size()) goto L19;
        Iterator<T> r7 = r5.keySet().iterator();
    L14:
        if (r7.hasNext() == false) goto L18;
        if (r6.containsKey((String) r7.next()) == true) goto L14;
        return false;
    L18:
        return true;
    L19:
        return false;
    }
}
