package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/x0;", "p1", BuildConfig.FLAVOR, "invoke", "(Lzg1/x0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DiggWidget$initEvents$2$1 extends FunctionReferenceImpl implements Function1<zg1.x0, Unit> {
    public DiggWidget$initEvents$2$1(DiggWidget r8) {
        super(1, r8, DiggWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LandscapeRootViewChangeEvent;)V", 0);
    }

    public final void invoke(zg1.x0 r3) {
        Intrinsics.checkNotNullParameter(r3, "p1");
        DiggWidget r0 = (DiggWidget) ((CallableReference) this).receiver;
        int r1 = DiggWidget.M1;
        r0.onEvent(r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((zg1.x0) r1);
        return Unit.INSTANCE;
    }
}
