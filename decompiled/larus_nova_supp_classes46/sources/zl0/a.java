package zl0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.messagewindow.strategy.showintercept.ConditionId;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends c {
    public final ConditionId f;

    @Override // zl0.c
    public final Object getIdentity() {
        return this.f;
    }

    public final boolean b(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "msgWindow");
        if ((r5 instanceof v61.a) == true) goto L6;
        r5 = null;
    L6:
        if (r5 != null) goto L8;
    L10:
        DataCenter r6 = this.b;
        if (r6 == null) goto L19;
        IRoom r7 = (IRoom) r6.get("data_room", null);
        if (r7 == null) goto L19;
        IBaseUser r8 = r7.getOwner();
        if (r8 == null) goto L19;
        if (r8.isFollowing() != true) goto L19;
        return true;
    L19:
        return false;
    L8:
        if (r5.e != true) goto L10;
        return false;
    }

    public a(DataCenter r1, Long r2, Integer r3, v61.a r4) {
        super(r1, r2, r3, r4);
        this.f = ConditionId.ALREADY_FOLLOWED_NOT_DISPLAY;
    }
}
