package com.obric.aikernel.api.impl.obric.rss;

import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.rssroute.RssRouteSdk;
import obric.rssroute.model.RssIntResult;
import obric.rssroute.model.RssSessionInferenceData;
import obric.rssroute.model.RssSessionUidStatusListener;

/* JADX INFO: loaded from: classes2.dex */
public final class RssImpl extends d7.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Integer> f4448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f4449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f4450d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b implements RssSessionUidStatusListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RssImpl f4451a;

        b(RssImpl r10) {
            this.f4451a = r10;
        }

        @Override // obric.rssroute.model.RssSessionUidStatusListener
        public void onUidStatusChanged(int r10, int r11, int r12) {
            AIKLog.INSTANCE.i("RssImpl", "k_session " + r10 + " onUidStatusChanged " + r11 + " -> " + r12);
            if (r12 != 1) goto L5;
        L7:
            RssImpl.i(this.f4451a).put(Integer.valueOf(r10), Integer.valueOf(r12));
            return;
        L5:
            if (r12 == 2) goto L7;
        }
    }

    static {
        new a(null);
    }

    public RssImpl() {
        this.f4448b = new ConcurrentHashMap();
        this.f4449c = new b(this);
        this.f4450d = LazyKt.lazy(new RssImpl$rssManager$2(this));
    }

    public static final /* synthetic */ b h(RssImpl r10) {
        return r10.f4449c;
    }

    public static final /* synthetic */ Map i(RssImpl r10) {
        return r10.f4448b;
    }

    private final RssRouteSdk j() {
        return (RssRouteSdk) this.f4450d.getValue();
    }

    @Override // d7.a
    public int a(int r10) {
        RssIntResult r11 = j().sessionCreateGrp(0);
        if (r11.isSuccess() == false) goto L8;
        int r12 = r11.value;
        if (r10 <= 0) goto L7;
        j().sessionSetClientUid(r12, r10);
        return r12;
    L7:
        AIKLog.INSTANCE.w("RssImpl", "k_session " + r12 + " bind illegal uid " + r10);
        return r12;
    L8:
        AIKLog.INSTANCE.w("RssImpl", "k_session createSession(" + r10 + ") failed, status=" + r11.status);
        return -1;
    }

    @Override // d7.a
    public void b(int r10) {
        if (r10 < 0) goto L5;
        Integer r11 = this.f4448b.remove(Integer.valueOf(r10));
        int r12 = j().sessionDeleteGrp(r10);
        AIKLog.INSTANCE.d("RssImpl", "destroySession(" + r10 + ") " + r12 + " state:" + r11);
        return;
    }

    @Override // d7.a
    public int c(int r10) {
        RssIntResult r11 = j().sessionGetNpuPowerGear(r10);
        if (r11.isSuccess() == false) goto L5;
        int r12 = r11.value;
    L6:
        AIKLog.INSTANCE.d("RssImpl", "getNpuPowerGear(" + r10 + ") get " + r12 + ", [" + r11.value + ", " + r11.status + ']');
        return r12;
    L5:
        r12 = -9999;
        goto L6
    }

    @Override // d7.a
    public Boolean d(int r10) {
        Integer r11 = this.f4448b.get(Integer.valueOf(r10));
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.intValue() != 2) goto L7;
        boolean r12 = true;
    L11:
        return Boolean.valueOf(r12);
    L7:
        r12 = false;
        goto L11
    }

    @Override // d7.a
    public void e(int r10, int r11) {
        j().sessionAddThread(r10, r11);
    }

    @Override // d7.a
    public void f(int r10, int r11) {
        j().sessionRemoveThread(r11);
    }

    @Override // d7.a
    public int g(int r10, String r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "modelStage");
        return j().sessionSetInferenceInfo(new RssSessionInferenceData(r10, r11, r12, r13, r14, 0));
    }
}
