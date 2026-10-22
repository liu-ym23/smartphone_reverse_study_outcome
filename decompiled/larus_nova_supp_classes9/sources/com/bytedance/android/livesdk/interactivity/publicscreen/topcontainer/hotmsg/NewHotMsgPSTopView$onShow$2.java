package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class NewHotMsgPSTopView$onShow$2 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ f52.b $container;
    final /* synthetic */ NewHotMsgPSTopView this$0;

    public NewHotMsgPSTopView$onShow$2(NewHotMsgPSTopView r1, f52.b r2) {
        this.this$0 = r1;
        this.$container = r2;
        super(1);
    }

    public final void invoke(q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.e = new AnonymousClass1(this);
        r2.d(new AnonymousClass2(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((q4) r1);
        return Unit.INSTANCE;
    }
}
