package com.larus.community.impl.component;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s1 implements gs9.e {
    public final gs9.e a;

    public final void checkLoadMore() {
        this.a.checkLoadMore();
    }

    public final LiveData<List<UserCreationModel>> getFeedDataLiveData() {
        LiveData r0 = this.a.getFeedDataLiveData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Transformations.map(r0, new r1());
    }

    public final LiveData<gs9.i> getMoreState() {
        return this.a.getMoreState();
    }

    public s1(CreationFeedViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.a = r2;
    }

    public final void updateCreationContent(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        this.a.updateCreationContent(r2);
    }

    public final void deleteUserCreation(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
        this.a.deleteUserCreation(r2, r3);
    }

    public final void updateCreationModelPrivacy(int r2, boolean r3, UserCreation r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        this.a.updateCreationModelPrivacy(r2, r3, r4, r5);
    }
}
