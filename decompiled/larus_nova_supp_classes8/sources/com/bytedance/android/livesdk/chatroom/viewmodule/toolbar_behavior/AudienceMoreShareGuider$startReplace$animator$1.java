package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", "", "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class AudienceMoreShareGuider$startReplace$animator$1 extends Lambda implements Function1<com.bytedance.android.livesdk.utils.q4, Unit> {
    final /* synthetic */ View $from;
    final /* synthetic */ View $to;
    final /* synthetic */ f0 this$0;

    public AudienceMoreShareGuider$startReplace$animator$1(f0 r1, View r2, View r3) {
        this.this$0 = r1;
        this.$to = r2;
        this.$from = r3;
        super(1);
    }

    public final void invoke(com.bytedance.android.livesdk.utils.q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.e = new AnonymousClass1(this);
        r2.f = new AnonymousClass2(this);
        r2.b(new AnonymousClass3(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.utils.q4) r1);
        return Unit.INSTANCE;
    }
}
