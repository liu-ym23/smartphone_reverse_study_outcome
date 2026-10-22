package zl0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends c {
    public final ConditionId f;

    @Override // zl0.c
    public final Object getIdentity() {
        return this.f;
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
        v61.a r2 = this.e;
        if (r2 == null) goto L21;
        Observable r3 = r2.v();
        if (r3 == null) goto L21;
        Disposable r4 = r3.subscribe(new k(this, r10));
        if (r4 == null) goto L21;
        RxUtilKt.c(r4, this.a);
    L21:
        if (r10 == null) goto L23;
        String r5 = r10.getOwnerUserIdString();
    L24:
        if (r10 == null) goto L28;
        OfficialChannelExtraInfo r6 = r10.getOfficialChannelExtraInfo();
        if (r6 == null) goto L28;
        Long r7 = Long.valueOf(r6.getShowListId());
    L29:
        Boolean r11 = Boolean.valueOf(mm0.b.b(r7));
        if (r10 == null) goto L32;
        Long r12 = Long.valueOf(r10.getId());
    L33:
        if (r10 == null) goto L38;
        OfficialChannelExtraInfo r13 = r10.getOfficialChannelExtraInfo();
        if (r13 == null) goto L38;
        r1 = Long.valueOf(r13.getShowListId());
    L38:
        return com.bytedance.android.live.messagewindow.business.util.c.c(r5, mm0.b.c(r11, r12, r1), this.d, false);
    L32:
        r12 = null;
    L28:
        r7 = null;
        goto L29
    L23:
        r5 = null;
        goto L24
    L13:
        r10 = null;
        goto L14
    L8:
        if (r8.e != true) goto L10;
        return false;
    }

    public l(DataCenter r1, Long r2, Integer r3, v61.a r4) {
        super(r1, r2, r3, r4);
        this.f = ConditionId.SAME_ANCHOR_NOT_DISPLAY;
    }
}
