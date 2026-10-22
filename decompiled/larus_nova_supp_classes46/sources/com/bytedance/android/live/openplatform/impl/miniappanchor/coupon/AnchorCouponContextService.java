package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.CouponApi;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.CompletableSubject;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/coupon/AnchorCouponContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorCouponContextService extends OpenPlatformContextService {
    public final Map<Integer, com.bytedance.android.live.openplatform.api.model.coupon.a> a;

    public static final class a {
    }

    static {
    }

    public final void g() {
        autoDispose(f(this, 3, AnchorCouponContextService$initCouponEntranceInfoOnMorePanel$1.INSTANCE));
    }

    public AnchorCouponContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = new LinkedHashMap();
    }

    public static Disposable f(AnchorCouponContextService r5, int r6, Function1 r7) {
        AnchorCouponContextService$fetchCouponEntranceInfo$1 r0 = AnchorCouponContextService$fetchCouponEntranceInfo$1.INSTANCE;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r7, "onSuccess");
        Intrinsics.checkNotNullParameter(r0, "onFail");
        int r1 = qo0.a.a;
        qo0.a.c("AnchorCouponContextService", "fetch send coupon entrance info, scene: " + r6);
        Lazy r2 = LiveOpenPlatformClient.c;
        CouponApi r3 = (CouponApi) LiveOpenPlatformClient.a.a().a(CouponApi.class);
        int r4 = 1;
        if (k.n(IHostContext.class).isBoe() == false) goto L7;
        if (r6 != 2) goto L6;
        r4 = 2;
    L6:
        Observable<e<com.bytedance.android.live.openplatform.api.model.coupon.a>> r8 = r3.fetchSendCouponEntranceInfoBOE("https://boe-webcast.amemv.com/open/promotion/show_coupon_entrance/", r4);
    L11:
        return new CompletableSubject().doOnDispose(new com.bytedance.android.live.openplatform.impl.miniappanchor.coupon.a(r5, r8.compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r5, r6, r7, r0), new c(r0)), r6)).subscribe();
    L7:
        if (r6 != 2) goto L9;
        r4 = 2;
    L9:
        r8 = r3.fetchSendCouponEntranceInfo(r4);
        goto L11
    }

    public final void h(Context r8, int r9, List<String> r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        com.bytedance.android.live.openplatform.api.model.coupon.a r0 = (com.bytedance.android.live.openplatform.api.model.coupon.a) ((LinkedHashMap) this.a).get(Integer.valueOf(r9));
        int r1 = qo0.a.a;
        StringBuilder r2 = new StringBuilder("open coupon page, scene: ");
        r2.append(r9);
        r2.append(", info: ");
        if (r0 != null) goto L5;
        Object r11 = "null";
    L6:
        r2.append(r11);
        qo0.a.c("AnchorCouponContextService", r2.toString());
        if (r0 != null) goto L9;
        return;
    L9:
        String r12 = r0.a();
        Uri r3 = null;
        StringBuilder r4 = null;
        if (r12 == null) goto L39;
        u6 r5 = new u6(r12);
        u6 r13 = r5.d("url");
        List<String> r6 = r10;
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == true) goto L35;
        Iterator<String> r14 = r10.iterator();
    L22:
        if (r14.hasNext() == false) goto L32;
        String r15 = r14.next();
        if (r15.length() <= 0) goto L26;
        boolean r16 = true;
    L27:
        if (r16 == false) goto L22;
        if (r4 != null) goto L30;
        r4 = new StringBuilder();
    L31:
        r4.append(r15);
        goto L22
    L30:
        r4.append(",");
        goto L31
    L26:
        r16 = false;
        goto L27
    L32:
        if (r4 == null) goto L35;
        String r17 = URLEncoder.encode(r4.toString(), "UTF-8");
        r5.b("app_id", r17);
        r13.b("app_id", r17);
    L35:
        if (getOpenPlatformContext().isInLive() == false) goto L37;
        String r18 = "1";
    L38:
        r5.b("is_in_live", r18);
        r13.b("is_in_live", r18);
        r3 = r5.c();
        goto L39
    L37:
        r18 = "0";
        goto L38
    L15:
        if (r6.isEmpty() == true) goto L18;
        r7 = false;
    L39:
        if (r3 != null) goto L41;
        return;
    L41:
        int r19 = qo0.a.a;
        qo0.a.c("AnchorCouponContextService", "coupon page result uri: " + r3);
        k.n(ILiveActionHandler.class).handle(r8, r3);
        return;
    L5:
        r11 = r0;
        goto L6
    }
}
