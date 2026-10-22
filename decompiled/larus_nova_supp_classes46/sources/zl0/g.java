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
public final class g extends c {
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
        v61.a r3 = this.e;
        if (r3 == null) goto L21;
        Observable r4 = r3.v();
        if (r4 == null) goto L21;
        Disposable r5 = r4.subscribe(new f(this, r10));
        if (r5 == null) goto L21;
        RxUtilKt.c(r5, this.a);
    L21:
        if (r10 == null) goto L25;
        OfficialChannelExtraInfo r6 = r10.getOfficialChannelExtraInfo();
        if (r6 == null) goto L25;
        Long r7 = Long.valueOf(r6.getShowListId());
    L26:
        Boolean r11 = Boolean.valueOf(mm0.b.b(r7));
        if (r10 == null) goto L29;
        Long r12 = Long.valueOf(r10.getId());
    L30:
        if (r10 == null) goto L34;
        OfficialChannelExtraInfo r13 = r10.getOfficialChannelExtraInfo();
        if (r13 == null) goto L34;
        r1 = Long.valueOf(r13.getShowListId());
    L34:
        long r14 = System.currentTimeMillis() - com.bytedance.android.live.messagewindow.business.util.c.b(mm0.b.c(r11, r12, r1), this.d, false);
        Long r15 = this.c;
        if (r15 == null) goto L37;
        long r16 = r15.longValue();
    L39:
        if (r14 >= r16) goto L42;
        return true;
    L42:
        return false;
    L37:
        r16 = 0;
        goto L39
    L29:
        r12 = null;
    L25:
        r7 = null;
        goto L26
    L13:
        r10 = null;
        goto L14
    L8:
        if (r8.e != true) goto L10;
        return false;
    }

    public g(DataCenter r1, Long r2, Integer r3, v61.a r4) {
        super(r1, r2, r3, r4);
        this.f = ConditionId.CARD_SHOW_INTERVAL_TIME_LIMIT;
    }
}
