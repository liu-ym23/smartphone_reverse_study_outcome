package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.utils.MVIWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ro1.a;
import ro1.f;
import vo1.e;
import vo1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/base/BaseBannerWidget;", "Lro1/a;", "M", "Lcom/bytedance/android/livesdk/utils/MVIWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/a;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/ActivityTopBannerViewIntent;", "<init>", "()V", "BannerPosition", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseBannerWidget<M extends ro1.a> extends MVIWidget<com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a, ActivityTopBannerViewIntent, M> {
    public boolean b;
    public f c;
    public String d;
    public i e;
    public BaseHybridParamVo.HybridType f;
    public final GestureDetector g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/base/BaseBannerWidget$BannerPosition;", "", "TOP_RIGHT", "BOTTOM_RIGHT", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BannerPosition extends Enum<BannerPosition> {
        public static final BannerPosition BOTTOM_RIGHT = null;
        public static final BannerPosition TOP_RIGHT = null;
        public static final /* synthetic */ BannerPosition[] a = null;

        static {
            BannerPosition r1 = new BannerPosition("TOP_RIGHT", 0);
            TOP_RIGHT = r1;
            BannerPosition r2 = new BannerPosition("BOTTOM_RIGHT", 1);
            BOTTOM_RIGHT = r2;
            a = new BannerPosition[]{r1, r2};
        }

        public static BannerPosition valueOf(String r1) {
            return (BannerPosition) r27.a.a(BannerPosition.class, r1);
        }

        public static BannerPosition[] values() {
            return (BannerPosition[]) a.clone();
        }

        public BannerPosition(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements IBaseBrowserService.PageFinishedListener {
        public final /* synthetic */ BaseBannerWidget a;
        public final /* synthetic */ BannerInRoomCollection.BannerInfo b;

        public a(BaseBannerWidget r1, BannerInRoomCollection.BannerInfo r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onPageFinished(WebView r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "webView");
            Intrinsics.checkNotNullParameter(r4, "url");
            this.a.Aq(r3, r4, this.b);
        }
    }

    public static final class b implements IBaseBrowserService.PageErrorListener {
        public final /* synthetic */ BaseBannerWidget a;

        public b(BaseBannerWidget r1) {
            this.a = r1;
        }

        public final void onReceiveError(WebView r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "webView");
            Intrinsics.checkNotNullParameter(r4, "url");
            Intrinsics.checkNotNullParameter(r5, "msg");
            BaseBannerWidget r0 = this.a;
            r0.b = true;
            r0.Bq(r3, r4, r5);
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ BaseBannerWidget a;

        public c(BaseBannerWidget r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.a.zq();
            return false;
        }
    }

    public void Aq(View r1, String r2, BannerInRoomCollection.BannerInfo r3) {
    }

    public void Bq(View r1, String r2, String r3) {
    }

    public void Cq(BannerInRoomCollection.BannerInfo r1) {
    }

    public void zq() {
    }

    public void Eq() {
        i r0 = this.e;
        if (r0 == null) goto L6;
        r0.release();
    L6:
        if (((Boolean) com.bytedance.android.live.core.setting.a.a.getValue()).booleanValue() == true) goto L9;
        this.e = null;
        return;
    }

    public BaseBannerWidget() {
        this.d = "";
        this.f = BaseHybridParamVo.HybridType.H5;
        this.g = new GestureDetector(getContext(), new c(this));
    }

    public void onUnload() {
        super/*com.bytedance.android.live.core.arch.mvi.widgetcompat.MVIDataWidget*/.onUnload();
        this.b = false;
        Eq();
        i0.k(c50.b.b(((Widget) this).dataCenter), this.c);
        this.c = null;
    }

    public final void Fq(String r2, JSONObject r3) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        if (r3 == null) goto L13;
        i r1 = this.e;
        if (r1 == null) goto L13;
        r1.sendJsEvent(r2, r3);
    L13:
        ALogger.i("tag_banner_001", "sendJsEvent-> eventName=" + r2);
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void yq(Activity r8, BannerInRoomCollection.BannerInfo r9) {
        if (this.e != null) goto L9;
        int r0 = e.a;
        if (((Boolean) com.bytedance.android.live.core.setting.a.a.getValue()).booleanValue() == false) goto L7;
        i r1 = new vo1.f();
    L8:
        this.e = r1;
        goto L9
    L7:
        r1 = new vo1.a();
    L9:
        i r2 = this.e;
        if (r2 != null) goto L12;
    L23:
        this.f = BaseHybridParamVo.HybridType.H5;
        return;
    L12:
        if (r9 == null) goto L17;
        String r3 = r9.getUrl();
        if (r3 == null) goto L17;
        String r4 = r3;
    L18:
        a r5 = new a(this, r9);
        b r6 = new b(this);
        String r10 = getSpm();
        if (r10 != null) goto L21;
        String r7 = "";
    L22:
        r2.d(r8, r4, r5, r6, r7);
        goto L23
    L21:
        r7 = r10;
    L17:
        r4 = "";
        goto L18
    }
}
