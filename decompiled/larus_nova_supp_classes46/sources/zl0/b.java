package zl0;

import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends c {
    public final ConditionId f;

    @Override // zl0.c
    public final Object getIdentity() {
        return this.f;
    }

    public final boolean b(v61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "msgWindow");
        boolean r3 = r2 instanceof v61.a;
        return false;
    }

    public b(DataCenter r3, Long r4) {
        super(r3, r4, 0, null);
        this.f = ConditionId.ANCHOR_EXIT_MIC_NOT_DISPLAY;
    }
}
