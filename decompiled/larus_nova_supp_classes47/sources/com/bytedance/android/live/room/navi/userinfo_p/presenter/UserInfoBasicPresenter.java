package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoBasicPresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoBasicPresenter extends BaseElementPresenter {
    public final ViewGroup f;

    public static final class a {
    }

    static {
    }

    public UserInfoBasicPresenter(m91.c r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoWidgetAbility");
        Intrinsics.checkNotNullParameter(r3, "anchorInfoContainer");
        super(r2);
        this.f = r3;
    }
}
