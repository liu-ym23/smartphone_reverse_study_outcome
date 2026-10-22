package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface r0 {

    public static final class a {
        public static /* synthetic */ void a(GiftExtraRepo r2, List r3, String r4, IBaseUser r5, int r6) {
            if ((r6 & 2) == 0) goto L5;
            r4 = BuildConfig.FLAVOR;
        L5:
            IGiftExtraRepo$syncGiftExtra$1 r1 = null;
            if ((r6 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r1 = IGiftExtraRepo$syncGiftExtra$1.INSTANCE;
        L11:
            r2.U(r3, r4, r5, r1);
        }
    }

    void c(List r1, long r2);
}
