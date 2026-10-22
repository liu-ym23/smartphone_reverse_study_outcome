package sy1;

import com.bytedance.android.live.browser.jsbridge.base.ChangeGroupLiveContainerStatusResultModel;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentDataStore;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.scope.m;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import w20.n;
import w20.w7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends n<w7, ChangeGroupLiveContainerStatusResultModel> {
    public final k a;

    public a(k r1) {
        this.a = r1;
    }

    public final void invoke(Object r3, CallContext r4) {
        w7 r5 = (w7) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        Integer r6 = r5.a();
        if (r6 == null) goto L5;
        int r7 = r6.intValue();
    L6:
        k r8 = this.a;
        if (r8 == null) goto L12;
        GroupComponentDataStore r9 = (GroupComponentDataStore) m.e.d(r8, GroupComponentDataStore.class);
        if (r9 == null) goto L13;
        r9.o(r7);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r7 = -1;
        goto L6
    }
}
