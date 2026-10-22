package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoAnimPresenter;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserInfoAnimElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoAnimElement extends BaseElement {
    public c91.a d;
    public UserInfoAnimPresenter e;
    public final FrameLayout f;
    public final View g;

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void l(IRoom r1) {
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void h() {
        this.d = new c91.a(this.f, this.g);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void i() {
        UserInfoAnimPresenter r0 = new UserInfoAnimPresenter(this.c, this.d);
        vlc.d r1 = r0.b;
        if (r1 == null) goto L5;
        r1.addMessageListener(MessageType.EXHIBITION_TOP_LEFT.getIntType(), r0);
    L5:
        Unit r2 = Unit.INSTANCE;
        this.e = r0;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        UserInfoAnimPresenter r0 = this.e;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public UserInfoAnimElement(m91.d r2, FrameLayout r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "giftExhibitionContainer");
        Intrinsics.checkNotNullParameter(r4, "anchorInfoContainer");
        super(r2);
        this.f = r3;
        this.g = r4;
    }
}
