package com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui;

import com.bytedance.android.live.base.model.data.i;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/base/model/data/i;", "p1", "", "invoke", "(Lcom/bytedance/android/live/base/model/data/i;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MultiLinkLinkRoomFightWindowManager$initViewManager$1 extends FunctionReferenceImpl implements Function1<i, Unit> {
    public MultiLinkLinkRoomFightWindowManager$initViewManager$1(MultiLinkLinkRoomFightWindowManager r8) {
        super(1, r8, MultiLinkLinkRoomFightWindowManager.class, "onRemoteRoomSilenceStatechanged", "onRemoteRoomSilenceStatechanged(Lcom/bytedance/android/live/base/model/data/ILinkRoomFightUpdateContent;)V", 0);
    }

    public final void invoke(i r3) {
        MultiLinkLinkRoomFightWindowManager r0 = (MultiLinkLinkRoomFightWindowManager) ((CallableReference) this).receiver;
        int r1 = MultiLinkLinkRoomFightWindowManager.Z;
        r0.getClass();
        ALogger.i(LinkRoomFightContext.TAG, "onRemoteRoomSilenceStatechanged: updateContent = " + r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((i) r1);
        return Unit.INSTANCE;
    }
}
