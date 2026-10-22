package com.bytedance.android.live.liveinteract.revenue.paid.profilecard;

import com.bytedance.android.live.room.api.messagewindow.builder.card.CardMountingsBuilder;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/CardMountingsBuilder;", "invoke"}, k = 3, mv = {1, 5, 1})
final class PaidProfileCardControlWidget$initPaidProfileCard$1 extends Lambda implements Function1<CardMountingsBuilder, Unit> {
    final /* synthetic */ long $mills;
    final /* synthetic */ PaidProfileCardControlWidget this$0;

    public PaidProfileCardControlWidget$initPaidProfileCard$1(PaidProfileCardControlWidget r1, long r2) {
        this.this$0 = r1;
        this.$mills = r2;
        super(1);
    }

    public final void invoke(CardMountingsBuilder r8) {
        Intrinsics.checkNotNullParameter(r8, "$receiver");
        DataCenter r2 = ((Widget) this.this$0).dataCenter;
        CardTypeAndPriority r0 = CardTypeAndPriority.PaidProfile;
        CardMountingsBuilder.a(r8, r2, r0.getType(), r0.getPriority(), null, 24);
        Function1<CardMountingsBuilder.b, Unit> r1 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r1, "init");
        r8.g = r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((CardMountingsBuilder) r1);
        return Unit.INSTANCE;
    }
}
