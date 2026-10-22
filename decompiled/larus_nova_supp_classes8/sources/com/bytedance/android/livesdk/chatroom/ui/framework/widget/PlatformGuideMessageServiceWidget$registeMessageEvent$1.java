package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lb30/d0;", "p1", "", "invoke", "(Lb30/d0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class PlatformGuideMessageServiceWidget$registeMessageEvent$1 extends FunctionReferenceImpl implements Function1<b30.d0, Unit> {
    public PlatformGuideMessageServiceWidget$registeMessageEvent$1(PlatformGuideMessageServiceWidget r8) {
        super(1, r8, PlatformGuideMessageServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/live/browser/jsbridge/event/ShowFollowGuideEvent;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((b30.d0) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(b30.d0 r2) {
        ((PlatformGuideMessageServiceWidget) ((CallableReference) this).receiver).onEvent(r2);
    }
}
