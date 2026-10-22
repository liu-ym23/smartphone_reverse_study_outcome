package com.bytedance.android.livesdk.gift.platform.business.effect.widget;

import com.bytedance.android.livesdk.gift.platform.business.tray2.VSGiftMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.message.model.i6;
import com.bytedance.android.livesdk.message.model.k6;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.q8;
import gm2.g;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/VideoGiftWidgetVS;", "Lcom/bytedance/android/livesdk/gift/platform/business/effect/widget/BaseVideoGiftWidgetNewQueue;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoGiftWidgetVS extends BaseVideoGiftWidgetNewQueue {
    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Qq() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Tq(i6 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Wq(q8 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Yq(g r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Cq() {
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().c.clear();
    }

    public VideoGiftWidgetVS() {
        Intrinsics.checkNotNullParameter("VideoGiftWidgetVS", "<set-?>");
        this.b = "VideoGiftWidgetVS";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Fq() {
        if (u.p() == false) goto L6;
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().c(2);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Mq() {
        if (u.p() == false) goto L6;
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().b = this;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Nq() {
        if (u.p() == false) goto L6;
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().c(2);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void ar() {
        if (u.p() == false) goto L6;
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager r1 = VSGiftMessageManager.a.a();
        r1.a = null;
        r1.b = null;
        r1.c.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Pq(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        if (u.p() == false) goto L6;
        Lazy r3 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().c(2);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Sq(k6 r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if (isViewValid() == true) goto L5;
        return;
    L5:
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().a(r3, u.a());
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget
    public final void Zq(o7 r3) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        Lazy r0 = VSGiftMessageManager.e;
        VSGiftMessageManager.a.a().a(r3, u.a());
    }
}
