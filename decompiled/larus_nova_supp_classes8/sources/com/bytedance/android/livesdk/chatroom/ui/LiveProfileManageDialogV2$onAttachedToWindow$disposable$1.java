package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/event/f;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/event/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LiveProfileManageDialogV2$onAttachedToWindow$disposable$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.event.f, Unit> {
    public LiveProfileManageDialogV2$onAttachedToWindow$disposable$1(LiveProfileManageDialogV2 r8) {
        super(1, r8, LiveProfileManageDialogV2.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/event/ConfigurationChangedEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.event.f r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((LiveProfileManageDialogV2) ((CallableReference) this).receiver).onEvent(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.event.f) r1);
        return Unit.INSTANCE;
    }
}
