package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.room.api.messagewindow.builder.card.CommonCardBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/CommonCardBuilder;", "invoke"}, k = 3, mv = {1, 4, 3})
final class AudienceLynxExplainCardContextService$createExplainCard$1 extends Lambda implements Function1<CommonCardBuilder, Unit> {
    final /* synthetic */ r71.f $source;
    final /* synthetic */ AudienceLynxExplainCardContextService this$0;

    public AudienceLynxExplainCardContextService$createExplainCard$1(AudienceLynxExplainCardContextService r1, r71.f r2) {
        this.this$0 = r1;
        this.$source = r2;
        super(1);
    }

    public final void invoke(CommonCardBuilder r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a = this.$source.a;
        Function1<CommonCardBuilder.d, Unit> r0 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r0, "callback");
        r3.b = r0;
        Function1<CommonCardBuilder.b, Unit> r1 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r1, "callback");
        r3.c = r1;
        Function1<CommonCardBuilder.c, Unit> r2 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r2, "callback");
        r3.e = r2;
        Function1<CommonCardBuilder.a, Unit> r4 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r4, "callback");
        r3.d = r4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((CommonCardBuilder) r1);
        return Unit.INSTANCE;
    }
}
