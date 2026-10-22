package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.behavior;

import com.bytedance.android.live.room.api.messagewindow.builder.card.CommonCardBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/live/room/api/messagewindow/builder/card/CommonCardBuilder;", "invoke"}, k = 3, mv = {1, 4, 3})
final class CommonToolbarUiHandler$registerIntroCardService$1$1 extends Lambda implements Function1<CommonCardBuilder, Unit> {
    final /* synthetic */ f $it;
    final /* synthetic */ b this$0;

    public CommonToolbarUiHandler$registerIntroCardService$1$1(b r1, f r2) {
        this.$it = r2;
        super(1);
    }

    public final void invoke(CommonCardBuilder r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a = this.$it.a;
        Function1<CommonCardBuilder.d, Unit> r0 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r0, "callback");
        r3.b = r0;
        r3.c(AnonymousClass2.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((CommonCardBuilder) r1);
        return Unit.INSTANCE;
    }
}
