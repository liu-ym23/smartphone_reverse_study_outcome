package com.bytedance.android.live.revlink.link.biz.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.link.model.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface j extends k {

    public static final class a {
        public static String a(j r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "$this$linkerID");
            p r3 = r1.getContext().getAnchorLinkUserCenter().getGuestInfo(r2, r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return r3.getInteractId();
        }

        public static String b(j r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "$this$uid");
            p r3 = r1.getContext().getAnchorLinkUserCenter().getGuestInfo(r2, r2);
            if (r3 == null) goto L7;
            IBaseUser r4 = r3.getUser();
            if (r4 == null) goto L7;
            return iz.a.a(r4);
        L7:
            return null;
        }
    }

    com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext();
}
