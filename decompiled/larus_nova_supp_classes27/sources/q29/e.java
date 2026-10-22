package q29;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import fs9.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements gs9.e {
    public final /* synthetic */ List<UserCreation> a;

    public final void checkLoadMore() {
    }

    public final LiveData<List<UserCreationModel>> getFeedDataLiveData() {
        List<UserCreation> r0 = this.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        UserCreation r3 = (UserCreation) r2.next();
        UserCreationModel r4 = new UserCreationModel(0, CollectionsKt.mutableListOf(new UserCreation[]{r3}), r3.a, 1);
        a0.c(r4);
        r1.add(r4);
        goto L4
    L7:
        return new MutableLiveData(r1);
    }

    public final LiveData<gs9.i> getMoreState() {
        return new MutableLiveData();
    }

    public e(List<UserCreation> r1) {
        this.a = r1;
    }

    public final void updateCreationContent(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void deleteUserCreation(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "creationId");
    }

    public final void updateCreationModelPrivacy(int r1, boolean r2, UserCreation r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "userCreation");
    }
}
