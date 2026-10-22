package com.bytedance.android.live.room.navi.userinfo_p.widget.ecom;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/f;", "p1", "", "invoke", "(Lzg1/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECLiveUserInfoWidget$initEvents$1 extends FunctionReferenceImpl implements Function1<f, Unit> {
    public ECLiveUserInfoWidget$initEvents$1(ECLiveUserInfoWidget r8) {
        super(1, r8, ECLiveUserInfoWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/AnchorWidgetTranslationEvent;)V", 0);
    }

    public final void invoke(f r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((ECLiveUserInfoWidget) ((CallableReference) this).receiver).onEvent(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((f) r1);
        return Unit.INSTANCE;
    }
}
