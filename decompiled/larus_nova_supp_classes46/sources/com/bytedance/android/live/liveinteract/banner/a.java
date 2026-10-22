package com.bytedance.android.live.liveinteract.banner;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.e;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BannerWidget a;

    public a(BannerWidget r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r9) {
        e r10 = (e) r9;
        boolean r1 = false;
        if (r10 == null) goto L14;
        KtvActivityLinkResponse r2 = (KtvActivityLinkResponse) r10.data;
        if (r2 == null) goto L14;
        Map<Long, LabelBannerUrl> r3 = r2.getBannerUrl_links();
        if (r3 == null) goto L14;
        BannerWidget r4 = this.a;
        r4.c = r3.get(Long.valueOf(r4.f));
        LabelBannerUrl r5 = this.a.c;
        if (r5 == null) goto L14;
        String r6 = r5.getUrl();
        if (r6 == null) goto L14;
        BannerWidget r7 = this.a;
        r7.getClass();
        c r8 = new c(r7, ((Widget) r7).context, x6.a.d(r6), s1.y());
        r7.b = r8;
        r8.loadUrl(r6);
        StringCompanionObject r11 = StringCompanionObject.INSTANCE;
        ALogger.i("BannerWidget", String.format("getActivityLinks success, bannerId: %s, labelBannerUrl: %s", Arrays.copyOf(new Object[]{Long.valueOf(this.a.f), this.a.c}, 2)));
    L14:
        if (r10 == null) goto L22;
        KtvActivityLinkResponse r12 = (KtvActivityLinkResponse) r10.data;
        if (r12 == null) goto L22;
        Map<Long, LabelBannerUrl> r13 = r12.getBannerUrl_links();
        if (r13 == null) goto L22;
        LabelBannerUrl r14 = r13.get(Long.valueOf(this.a.f));
        if (r14 == null) goto L22;
        String r15 = r14.getUrl();
    L23:
        BannerWidget.a r16 = this.a.h;
        if (r16 == null) goto L31;
        if (r15 != null) goto L27;
    L28:
        r1 = true;
    L29:
        r16.b(!r1, null);
        return;
    L27:
        if (r15.length() != 0) goto L29;
    L31:
        return;
    L22:
        r15 = null;
        goto L23
    }
}
