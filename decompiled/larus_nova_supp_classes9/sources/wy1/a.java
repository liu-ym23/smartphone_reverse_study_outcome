package wy1;

import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentDataStore;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.livesdk.gift.grouplive.component.repo.GroupComponentRepo;
import com.bytedance.android.scope.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public a() {
    }

    public final boolean a(int r5) {
        m r0 = m.e;
        r0.getClass();
        k r1 = r0.a(m.d, k.class);
        if (r1 == null) goto L17;
        GroupComponentRepo r2 = (GroupComponentRepo) r0.d(r1, GroupComponentRepo.class);
        if (r2 == null) goto L18;
        GroupComponentDataStore r3 = r2.e;
        if (r3.A.d == null) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L19;
        ty1.b r6 = r3.L();
        if (r6 != null) goto L14;
        return false;
    L14:
        if (r6.getType() != r5) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L9:
        r4 = false;
        goto L10
    L18:
        return false;
    L17:
        return false;
    }
}
