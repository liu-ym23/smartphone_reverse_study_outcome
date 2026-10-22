package com.bytedance.android.live.liveinteract.banner;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/banner/BannerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "a", "b", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BannerWidget extends LiveWidget {
    public final CompositeDisposable a;
    public ka0.b b;
    public LabelBannerUrl c;
    public boolean d;
    public final IRoom e;
    public final long f;
    public final View g;
    public final a h;

    public interface a {
        boolean a();

        void b(boolean r1, Map<String, String> r2);
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BannerWidget a;

        public c(BannerWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r6) {
            e r7 = (e) r6;
            if (r7 == null) goto L17;
            KtvActivityLinkResponse r8 = (KtvActivityLinkResponse) r7.data;
            if (r8 == null) goto L18;
            Map<Long, LabelBannerUrl> r9 = r8.getBannerUrl_links();
            if (r9 == null) goto L19;
            BannerWidget r0 = this.a;
            r0.c = r9.get(Long.valueOf(r0.f));
            LabelBannerUrl r10 = this.a.c;
            if (r10 == null) goto L20;
            String r11 = r10.getUrl();
            if (r11 == null) goto L21;
            ka0.b r1 = this.a.b;
            if (r1 == null) goto L15;
            r1.release();
        L15:
            BannerWidget r2 = this.a;
            r2.b = null;
            com.bytedance.android.live.liveinteract.banner.c r3 = new com.bytedance.android.live.liveinteract.banner.c(r2, ((Widget) r2).context, x6.a.d(r11), s1.y());
            r2.b = r3;
            r3.loadUrl(r11);
            StringCompanionObject r12 = StringCompanionObject.INSTANCE;
            ALogger.i("BannerWidget", String.format("updateBannerUrl getActivityLinks success, bannerId: %s, labelBannerUrl: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.a.f), this.a.c}, 2)));
            return;
        L21:
            return;
        L20:
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            ALogger.e("BannerWidget", "getActivityLinks failed", (Throwable) r3);
        }
    }

    static {
    }

    public final void wq() {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.d("BannerWidget", String.format("onVisible, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f)}, 1)));
        xq();
    }

    public final void xq() {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        ALogger.d("BannerWidget", String.format("tryReportPageView, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f)}, 1)));
        if (this.d == false) goto L5;
        return;
    L5:
        a r1 = this.h;
        if (r1 == null) goto L11;
        if (r1.a() == true) goto L11;
        return;
    L11:
        if (this.c == null) goto L14;
        ALogger.d("BannerWidget", String.format("tryReportPageView success, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f)}, 1)));
        this.d = true;
        return;
    }

    public final void yq() {
        IRoom r0 = this.e;
        if (r0 == null) goto L6;
        long r1 = r0.getRoomId();
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        ALogger.i("BannerWidget", String.format("updateBannerUrl getActivityLinks start, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f)}, 1)));
        RxUtilKt.c(((BannerApi) com.bytedance.android.live.network.c.b().e(BannerApi.class)).getActivityLinks(r1, String.valueOf(this.f), "").compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), d.a), this.a);
        return;
    }

    public final void onCreate() {
        super.onCreate();
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r1 = this.g;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        IRoom r2 = this.e;
        if (r2 == null) goto L12;
        long r3 = r2.getRoomId();
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        ALogger.i("BannerWidget", String.format("getActivityLinks start, bannerId: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.f)}, 1)));
        RxUtilKt.c(((BannerApi) com.bytedance.android.live.network.c.b().e(BannerApi.class)).getActivityLinks(r3, String.valueOf(this.f), "").compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.banner.a(this), new com.bytedance.android.live.liveinteract.banner.b(this)), this.a);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a.clear();
        ka0.b r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.b = null;
    }

    public /* synthetic */ BannerWidget(IRoom r8) {
        this(r8, 23, "connection_request_panel", null, null);
    }

    public BannerWidget(IRoom r2, long r3, String r5, View r6, a r7) {
        Intrinsics.checkNotNullParameter(r5, "showPage");
        this.e = r2;
        this.f = r3;
        this.g = r6;
        this.h = r7;
        this.a = new CompositeDisposable();
    }
}
