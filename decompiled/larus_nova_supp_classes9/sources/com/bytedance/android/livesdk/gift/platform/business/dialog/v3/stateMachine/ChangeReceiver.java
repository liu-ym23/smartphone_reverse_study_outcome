package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeReceiver;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "preUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getPreUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeReceiver extends GiftRepoAction {
    private final IBaseUser preUser;
    private final IBaseUser user;

    public final IBaseUser getPreUser() {
        return this.preUser;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    public ChangeReceiver(IBaseUser r2, IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "preUser");
        super("ChangeReceiver");
        this.user = r2;
        this.preUser = r3;
    }
}
