package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.text.TextUtils;
import com.bytedance.android.livesdk.message.model.j4;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoAnimPresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoAnimPresenter extends BaseElementPresenter {
    public final c91.a f;

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void e() {
        super.e();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof o0) == true) goto L5;
        tlc.d r0 = null;
    L6:
        o0 r1 = (o0) r0;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.getMessageType() != MessageType.EXHIBITION_TOP_LEFT) goto L19;
        if (r3 == null) goto L18;
        j4 r4 = (j4) r3;
        if (TextUtils.isEmpty(r4.P()) == true) goto L20;
        c91.a r2 = this.f;
        if (r2 == null) goto L21;
        r2.a(r4);
        return;
    L21:
        return;
    L20:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.ExhibitionTopLeftMessage");
    L19:
        return;
    L5:
        r0 = r3;
        goto L6
    }

    public UserInfoAnimPresenter(m91.c r2, c91.a r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoWidgetAbility");
        super(r2);
        this.f = r3;
    }
}
