package c12;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends e {
    public final String q;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.e
    public final String toString() {
        StringBuilder r0 = new StringBuilder("TTMD5ResourceRequest{mId=");
        r0.append(this.i);
        r0.append(", mUrls='");
        String[] r1 = this.j;
        r0.append(GsonProtectorUtils.toJson(l97.a.a, r1));
        r0.append("', mMd5='");
        r0.append(this.k);
        r0.append("', mSourceFrom='");
        r0.append(this.l);
        r0.append("', mNeedToUnzip=");
        r0.append(this.m);
        r0.append(", mTTMD5=");
        String r2 = this.q;
        if (r2 != null) goto L5;
        r2 = "null";
    L5:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    }

    public n(long r10, String[] r13, String r14, String r15, long r16, GiftResourceFileCacheService r17) {
        Intrinsics.checkNotNullParameter(r13, "urls");
        Intrinsics.checkNotNullParameter(r14, "md5");
        Intrinsics.checkNotNullParameter(r17, "fileCacheService");
        super(r10, r13, r14, r16, r17);
        this.q = r15;
    }
}
