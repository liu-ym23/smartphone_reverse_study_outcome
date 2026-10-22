package com.bytedance.android.ec.core.widget;

import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECAuctionStatusLayout$bindInList$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECPromotionAuctionInfo $auctionInfo;
    final /* synthetic */ Function0 $countDownAction;
    final /* synthetic */ ECAuctionStatusLayout this$0;

    public ECAuctionStatusLayout$bindInList$1(ECAuctionStatusLayout r1, ECPromotionAuctionInfo r10, Function0 r11) {
        this.this$0 = r1;
        this.$auctionInfo = r10;
        this.$countDownAction = r11;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1488invoke() {
        if (this.this$0.e(this.$auctionInfo) == false) goto L8;
        Function0 r0 = this.$countDownAction;
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke();
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1488invoke();
        return Unit.INSTANCE;
    }
}
