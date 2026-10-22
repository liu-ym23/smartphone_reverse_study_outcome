package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkVoiceGuestContainerWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public MultiLinkVoiceGuestContainerWidget$interceptCloseRoomByLinkmicOnlineFloatWindow$3(MultiLinkVoiceGuestContainerWidget r8) {
        super(1, r8, MultiLinkVoiceGuestContainerWidget.class, "showLinkMicFloatWindow", "showLinkMicFloatWindow(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r2) {
        MultiLinkVoiceGuestContainerWidget.xq((MultiLinkVoiceGuestContainerWidget) ((CallableReference) this).receiver, r2);
    }
}
