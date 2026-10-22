package k32;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.effect.giftview.i;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends a {
    public final Map<String, String> A;
    public final AtomicBoolean t;
    public final String u;
    public final a5 v;
    public final Map<String, c5> w;
    public final IBaseUser x;
    public final String y;
    public final IPlayerActionListener z;

    public c(String r6, a5 r7, Map r8, IBaseUser r9, String r10, i r11, Map r13) {
        Intrinsics.checkNotNullParameter(r6, "dressId");
        Intrinsics.checkNotNullParameter(r9, "user");
        Intrinsics.checkNotNullParameter(r10, "finishSelfSchema");
        Intrinsics.checkNotNullParameter(r11, "playListener");
        String r0 = r9.getIdString();
        String r1 = r9.getNickName();
        String r2 = BuildConfig.FLAVOR;
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        k r3 = r9.getAvatarThumbKt();
        if (r3 == null) goto L13;
        List r4 = r3.getUrls();
        if (r4 == null) goto L13;
        String r5 = (String) CollectionsKt.getOrNull(r4, 0);
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        super(r0, r1, r2);
        this.u = r6;
        this.v = r7;
        this.w = r8;
        this.x = r9;
        this.y = r10;
        this.z = r11;
        this.A = r13;
        this.p = 90000;
        this.t = new AtomicBoolean(false);
    }
}
