package zl0;

import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends c {
    @Override // zl0.c
    public final Object getIdentity() {
        return ConditionId.EXIT_CARD_TIMES_LIMIT;
    }

    public final boolean b(v61.a r8) {
        Intrinsics.checkNotNullParameter(r8, "msgWindow");
        Long r1 = null;
        if ((r8 instanceof v61.a) == true) goto L6;
        r8 = null;
    L6:
        if (r8 != null) goto L8;
    L10:
        DataCenter r9 = this.b;
        if (r9 == null) goto L13;
        IRoom r10 = (IRoom) r9.get("data_room", null);
    L14:
        if (r10 == null) goto L18;
        OfficialChannelExtraInfo r3 = r10.getOfficialChannelExtraInfo();
        if (r3 == null) goto L18;
        Long r4 = Long.valueOf(r3.getShowListId());
    L19:
        Boolean r5 = Boolean.valueOf(mm0.b.b(r4));
        if (r10 == null) goto L22;
        Long r6 = Long.valueOf(r10.getId());
    L23:
        if (r10 == null) goto L27;
        OfficialChannelExtraInfo r11 = r10.getOfficialChannelExtraInfo();
        if (r11 == null) goto L27;
        r1 = Long.valueOf(r11.getShowListId());
    L27:
        long r7 = com.bytedance.android.live.messagewindow.business.util.c.a(mm0.b.c(r5, r6, r1), this.d, false);
        Long r12 = this.c;
        if (r12 == null) goto L30;
        long r13 = r12.longValue();
    L32:
        if (r7 < r13) goto L35;
        return true;
    L35:
        return false;
    L30:
        r13 = 0;
        goto L32
    L22:
        r6 = null;
    L18:
        r4 = null;
        goto L19
    L13:
        r10 = null;
        goto L14
    L8:
        if (r8.e != true) goto L10;
        return false;
    }

    public h(DataCenter r1, Long r2, Integer r3, v61.a r4) {
        super(r1, r2, r3, r4);
    }
}
