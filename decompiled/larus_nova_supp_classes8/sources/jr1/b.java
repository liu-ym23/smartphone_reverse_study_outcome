package jr1;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import d90.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final boolean a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isAnchor");
        DataCenter r3 = r2.h;
        if (r3 == null) goto L7;
        Boolean r4 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
        if (r4 == null) goto L7;
        return r4.booleanValue();
    L7:
        return false;
    }

    public static final boolean b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isAudienceMediaRoom");
        DataCenter r0 = r2.h;
        if (r0 == null) goto L11;
        IRoom r1 = a0.n(r0);
        if (r1 == null) goto L11;
        if (r1.isMediaRoom() != true) goto L11;
        if (a(r2) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean c(d r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$isVSRoom");
        Intrinsics.checkNotNullParameter(r6, "$this$vsRoom");
        DataCenter r0 = r6.h;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = (IRoom) r0.get("data_room");
    L6:
        DataCenter r7 = r6.h;
        if (r7 == null) goto L10;
        r1 = (IRoom) r7.get("data_prepare_room");
    L10:
        if (r2 == null) goto L12;
        long r4 = r2.getId();
    L14:
        if (r4 > 0) goto L17;
        r2 = r1;
    L17:
        if (r2 != null) goto L21;
        return false;
    L21:
        return r2.isMergeVSRoom();
    L12:
        r4 = 0;
        goto L14
    L5:
        r2 = null;
        goto L6
    }
}
