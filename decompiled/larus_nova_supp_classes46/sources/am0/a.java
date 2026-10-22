package am0;

import com.bytedance.android.live.messagewindow.business.card.d;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import kotlin.jvm.internal.Intrinsics;
import s71.e;
import s71.g;
import v61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements g<v61.a> {
    public final d a;

    public a(d r1) {
        this.a = r1;
    }

    public final s71.d a(v61.a r2, c r3) {
        v61.a r4 = (v61.a) r3;
        Intrinsics.checkNotNullParameter(r2, "us");
        Intrinsics.checkNotNullParameter(r4, "others");
        if (r2.k < r4.k) goto L6;
        return s71.d.c.a;
    L6:
        if (Intrinsics.areEqual(r4.j, CardTypeAndPriority.AudienceLink.getType()) == false) goto L12;
        d r5 = this.a;
        if (r5 == null) goto L14;
        r5.T();
    L14:
        return s71.d.d.a;
    L12:
        return new s71.d.b(0);
    }

    public final e b(c r2, v61.a r3) {
        Intrinsics.checkNotNullParameter((v61.a) r2, "us");
        Intrinsics.checkNotNullParameter(r3, "winner");
        if (Intrinsics.areEqual(r3.j, CardTypeAndPriority.AudienceLink.getType()) == false) goto L9;
        d r4 = this.a;
        if (r4 == null) goto L10;
        r4.T();
    L10:
        return s71.b.a;
    L9:
        return s71.c.a.b;
    }
}
