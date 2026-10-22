package com.larus.bmhome.chat.list.cell.send_image;

import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/larus/bmhome/chat/list/cell/send_image/SendImageCell$actLifecycleObserver$1", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", "onResume", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SendImageCell$actLifecycleObserver$1 extends SafeLifecycleObserver {
    public final /* synthetic */ SendImageCell a;

    public SendImageCell$actLifecycleObserver$1(SendImageCell r1) {
        this.a = r1;
    }

    public final void onResume(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        SendImageCell r3 = this.a;
        int r0 = SendImageCell.t;
        r3.w();
    }
}
