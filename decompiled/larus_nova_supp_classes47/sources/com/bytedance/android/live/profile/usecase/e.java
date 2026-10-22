package com.bytedance.android.live.profile.usecase;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdk.x3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements vlc.l {
    public boolean a;
    public final MutableLiveData<Boolean> b;
    public String c;
    public final vlc.d d;
    public final com.bytedance.android.live.profile.usecase.a e;

    public static final class a {
    }

    static {
    }

    public e(com.bytedance.android.live.profile.usecase.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dataProvider");
        this.e = r2;
        this.b = new MutableLiveData();
        this.c = DataType.FALSE;
        DataCenter r3 = r2.getRoomDataCenter();
        if (r3 == null) goto L5;
        vlc.d r4 = (vlc.d) r3.get("data_message_manager");
    L6:
        this.d = r4;
        if (r4 == null) goto L10;
        r4.addMessageListener("WebcastFansclubMessage", this);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void b(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "selfUser");
        this.c = r3.getIdString();
        com.bytedance.android.live.base.model.user.t r0 = r3.getFansClub();
        if (r0 == null) goto L7;
        py.h r1 = r0.getData();
        if (r1 == null) goto L7;
        String r2 = r1.getAnchorId();
    L8:
        boolean r4 = Intrinsics.areEqual(r2, this.e.getRoom().getOwnerUserIdStr());
        com.bytedance.android.live.base.model.user.t r5 = r3.getFansClub();
        if (r5 == null) goto L14;
        py.h r6 = r5.getData();
        if (r6 == null) goto L14;
        r6.getUserFansClubStatus();
    L14:
        if (r4 == this.a) goto L21;
        this.a = r4;
        if (this.e.loadUserSuccess() == false) goto L20;
        this.b.postValue(Boolean.valueOf(this.a));
        return;
    L20:
        return;
    L21:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onMessage(tlc.d r5) {
        String r1 = null;
        if ((r5 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L5;
        tlc.d r0 = null;
    L6:
        com.bytedance.android.live.base.model.message.t r2 = (com.bytedance.android.live.base.model.message.t) r0;
        if (r2 != null) goto L9;
        return;
    L9:
        String r3 = r2.getMessageMethod();
        if (r3 != null) goto L13;
        return;
    L13:
        if (r3.hashCode() == (-1317144130)) goto L16;
        return;
    L16:
        if (r3.equals("WebcastFansclubMessage") == true) goto L18;
        return;
    L18:
        if ((r5 instanceof h7) == true) goto L20;
        r5 = null;
    L20:
        h7 r6 = (h7) r5;
        if (r6 == null) goto L26;
        IBaseUser r4 = r6.getUser();
        if (r4 == null) goto L26;
        r1 = r4.getIdString();
    L26:
        if (Intrinsics.areEqual(r1, this.c) == false) goto L33;
        if (r6 != null) goto L29;
        return;
    L29:
        if (r6.getAction() != 2) goto L35;
        this.a = true;
        this.b.postValue(Boolean.TRUE);
        return;
    L35:
        return;
    L33:
        return;
    L5:
        r0 = r5;
        goto L6
    }

    public final void a(String r12, boolean r13) {
        Intrinsics.checkNotNullParameter("personal_profile_fansclub_entrance", "requestPage");
        Intrinsics.checkNotNullParameter(r12, "from");
        this.e.getLogUseCase().v(this.a);
        if (((Boolean) x3.a.getValue()).booleanValue() == false) goto L5;
        FansClubEntranceParams.Page r0 = FansClubEntranceParams.Page.FansClub;
    L6:
        FansClubEntranceParams.Page r1 = r0;
        com.bytedance.android.live.profit.fansclub.o r9 = yt0.c.c();
        if (r9 == null) goto L12;
        com.bytedance.android.live.profit.fansclub.p r14 = r9.Z8(new FansClubEntranceParams(r1, false, "personal_profile_fansclub_entrance", r12, null, r13, null, 434));
        if (r14 == null) goto L13;
        r14.show();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = FansClubEntranceParams.Page.Default;
        goto L6
    }
}
