package com.bytedance.android.live.revlink.link.streaminteract.stream;

import com.bytedance.android.live.core.utils.b0;
import com.bytedance.android.live.revlink.link.infra.rtcbiz.d;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.revenue.platform.api.core.rx.f;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\u001c\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0018\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R,\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u00050\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/revlink/link/streaminteract/stream/StreamManager;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/tools/kcp/kmpscope/runtime/ScopeService;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/link/streaminteract/stream/a;", "", "", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/d;", "renderViews", "", "onRenderFramesChange", "onStart", "onStop", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "", "", "streams", "Ljava/util/Map;", "Lcom/bytedance/android/live/revlink/link/streaminteract/stream/StreamManagerDataContext;", "dataContext", "Lcom/bytedance/android/live/revlink/link/streaminteract/stream/StreamManagerDataContext;", "Lcom/bytedance/live/datacontext/m;", "validStreams", "Lcom/bytedance/live/datacontext/m;", "getValidStreams", "()Lcom/bytedance/live/datacontext/m;", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/b;", "rtcManagerDataContext", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/b;", "<init>", "(Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/b;)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StreamManager extends DataContext implements o, a {
    private final CompositeDisposable cd;
    private final StreamManagerDataContext dataContext;
    private final com.bytedance.android.live.revlink.link.infra.rtcbiz.b rtcManagerDataContext;
    private final Map<String, Object> streams;
    private final m<Map<String, Object>> validStreams;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.streaminteract.stream.StreamManager$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/bytedance/android/live/revlink/link/infra/rtcbiz/d;", "p1", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Map<String, ? extends d>, Unit> {
        public AnonymousClass2(StreamManager r8) {
            super(1, r8, StreamManager.class, "onRenderFramesChange", "onRenderFramesChange(Ljava/util/Map;)V", 0);
        }

        public final void invoke(Map<String, d> r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            StreamManager.access$onRenderFramesChange((StreamManager) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((Map) r1);
            return Unit.INSTANCE;
        }
    }

    public void onStart() {
        f.a((Disposable) com.bytedance.live.datacontext.d.a(new AnonymousClass1(this)).getSecond(), this.cd);
        f.a(b0.a(this.rtcManagerDataContext.getRenderFrames(), new AnonymousClass2(this)), this.cd);
    }

    public void onStop() {
        this.cd.clear();
    }

    public m<Map<String, Object>> getValidStreams() {
        return this.validStreams;
    }

    public StreamManager(com.bytedance.android.live.revlink.link.infra.rtcbiz.b r2) {
        Intrinsics.checkNotNullParameter(r2, "rtcManagerDataContext");
        this.rtcManagerDataContext = r2;
        this.cd = new CompositeDisposable();
        this.streams = new LinkedHashMap();
        StreamManagerDataContext r3 = new StreamManagerDataContext();
        this.dataContext = r3;
        this.validStreams = r3.getValidStreams();
    }

    public static final /* synthetic */ StreamManagerDataContext access$getDataContext$p(StreamManager r0) {
        return r0.dataContext;
    }

    private final void onRenderFramesChange(Map<String, d> r5) {
        Iterator<Map.Entry<String, d>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry<String, d> r0 = r6.next();
        String r1 = r0.getKey();
        d r2 = r0.getValue();
        Map<String, Object> r3 = this.streams;
        if (r3.get(r1) != null) goto L4;
        r3.put(r1, new b(r1, r2));
        goto L4
    L8:
        this.dataContext.getValidStreams().setValue(this.streams);
    }

    public static final /* synthetic */ void access$onRenderFramesChange(StreamManager r0, Map r1) {
        r0.onRenderFramesChange(r1);
    }
}
