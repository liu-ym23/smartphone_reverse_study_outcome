package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.live.base.model.banner.OperationCard;
import com.relax.relaxframework.j5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/base/model/banner/OperationCard;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Lcom/bytedance/android/live/base/model/banner/OperationCard;I)Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2$1$for__1$2 extends Lambda implements Function2<OperationCard, Integer, j5> {
    final /* synthetic */ MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2.AnonymousClass1 this$0;

    public MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2$1$for__1$2(MainpageDrawerOperationBannerKt$LiveDrawerMainOperationBanner$1$1$3$switch__5$1$match__8$2.AnonymousClass1 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((OperationCard) r1, ((Number) r2).intValue());
    }

    public final j5 invoke(OperationCard r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return (j5) new AnonymousClass1(this, r3).invoke();
    }
}
