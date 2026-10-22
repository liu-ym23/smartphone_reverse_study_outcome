package x02;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends d0 {

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public u() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y a(com.bytedance.android.livesdk.gift.platform.core.model.t r4, y r5, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r6, Function1<? super y, Unit> r7) {
        Intrinsics.checkNotNullParameter(r4, "info");
        Intrinsics.checkNotNullParameter(r5, "response");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Intrinsics.checkNotNullParameter(r7, "nextPlugin");
        if ((r5 instanceof y.c.a.C0067a) == false) goto L13;
        y.c.a.C0067a r8 = (y.c.a.C0067a) r5;
        if (r8.d.getErrorCode() != 90501) goto L13;
        w0.b(r4.i().d());
        com.bytedance.android.livesdk.gift.platform.business.g r9 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r9 == null) goto L12;
        Context r10 = r9.getContext();
        if (r10 == null) goto L12;
        cs2.b r11 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(r10, 0);
        r11.a.d(true);
        r11.f();
        a r0 = a.a;
        r11.a.a(0, 2131918654, r0);
        r11.h();
    L12:
        return new y.c.a.C0067a(r8.d, true, r8.c);
    L13:
        return r5;
    }
}
