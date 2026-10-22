package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.view.View;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoPopupPresenter;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoPopupElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoPopupElement extends BaseElement {
    public UserInfoPopupPresenter d;
    public final View e;

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r1) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        UserInfoPopupPresenter r0 = new UserInfoPopupPresenter(this.c, this.e);
        vlc.d r1 = r0.b;
        if (r1 == null) goto L5;
        r1.addMessageListener(MessageType.GRADE_BUFF_ANCHOR_SHARE_MESSAGE.getIntType(), r0);
        r1.addMessageListener(MessageType.TOP_LEFT_BUBBLE_MESSAGE.getIntType(), r0);
        r1.addMessageListener(MessageType.PROFILE_VIEW_MESSAGE.getIntType(), r0);
        r1.addMessageListener(MessageType.DAILY_RANK_AWARD.getIntType(), r0);
    L5:
        Unit r2 = Unit.INSTANCE;
        this.d = r0;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        UserInfoPopupPresenter r0 = this.d;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public UserInfoPopupElement(m91.d r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "mUserHead");
        super(r2);
        this.e = r3;
    }
}
