package xl0;

import android.view.View;
import com.bytedance.android.live.messagewindow.business.card.c;
import com.bytedance.android.live.messagewindow.business.card.d;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements k71.a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final c a(DataCenter r2) {
        return new c(r2);
    }

    public final d b(DataCenter r2, View r3, CardTypeAndPriority r4) {
        Intrinsics.checkNotNullParameter(r3, "bannerContainerView");
        Intrinsics.checkNotNullParameter(r4, "cardTypeAndPriority");
        return new d(r2, r3, r4);
    }
}
