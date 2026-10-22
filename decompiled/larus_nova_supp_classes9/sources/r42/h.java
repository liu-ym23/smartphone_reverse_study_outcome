package r42;

import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public final int a;
    public final i b;

    public interface a {
    }

    public final void b() {
        i r0 = this.b;
        if (((ArrayList) r0.c).isEmpty() == true) goto L7;
        CollectionsKt.reverse(r0.c);
        return;
    }

    public h(i r2) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        this.b = r2;
        this.a = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
    }

    public final void a(t r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        i r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "message");
        ((ArrayList) r1.c).add(r3);
    }

    public final void c(List<? extends tlc.d> r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        if (g.a(null, null) == true) goto L5;
        return;
    L5:
        i r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "list");
        if (r5.isEmpty() == true) goto L24;
        int r0 = r1.a;
        int r2 = r5.size() - 1;
    L9:
        if (r2 < 0) goto L31;
        if ((ListProtector.get(r5, r2) instanceof k0) == false) goto L23;
        if (r0 <= 0) goto L32;
        Object r3 = ListProtector.get(r5, r2);
        if (r3 == null) goto L22;
        k0 r4 = (k0) r3;
        r4.setFirstFetchShowMessage(true);
        IPublicAreaCommon r6 = v3.a(r4);
        if (r6 != null) goto L18;
    L20:
        r0 = r0 - 1;
        goto L23
    L18:
        if (r6.isFirstAggregateHistoryMessage() != true) goto L20;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ICommonChatMessage");
    L32:
        return;
    L23:
        r2 = r2 - 1;
        goto L9
    L31:
        return;
    }
}
