package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ChangeMultiSendReceiver;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "users", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "(Ljava/util/List;)V", "getUsers", "()Ljava/util/List;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeMultiSendReceiver extends GiftRepoAction {
    private final List<IBaseUser> users;

    public final List<IBaseUser> getUsers() {
        return this.users;
    }

    public ChangeMultiSendReceiver(List<? extends IBaseUser> r2) {
        Intrinsics.checkNotNullParameter(r2, "users");
        super("ChangeMultiSendReceiver");
        this.users = r2;
    }
}
