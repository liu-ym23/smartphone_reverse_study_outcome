package x02;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t extends d0 {
    public t() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y b(com.bytedance.android.livesdk.gift.platform.core.model.t r3, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r4, Function1<? super y, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "info");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r5, "nextPlugin");
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<Bundle> r1 = r0.getGiftLogExtra();
        if (r1 == null) goto L9;
        Bundle r2 = (Bundle) r1.getValue();
        if (r2 == null) goto L9;
        String r6 = r2.getString("gift_show_from");
    L11:
        if (TextUtils.equals("icon_feed", r6) == false) goto L21;
        nq2.a r7 = vh6.c.b(nq2.a.class);
        if (r7 == null) goto L21;
        IRoom r8 = r3.i().H;
        if (r8 == null) goto L18;
        String r9 = r8.getIdStr();
        if (r9 == null) goto L18;
    L19:
        r7.showInteractionAndEnterRoom(r9);
    L18:
        r9 = BuildConfig.FLAVOR;
    L21:
        return super.b(r3, r4, r5);
    L9:
        r6 = null;
        goto L11
    }
}
