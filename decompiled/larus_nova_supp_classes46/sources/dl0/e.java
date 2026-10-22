package dl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.config.kr0;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements a<c.a, com.bytedance.android.live.profit.fansclub.b> {
    public static final c.a a = null;
    public static WeakReference<com.bytedance.android.live.profit.fansclub.b> b;
    public static final e c = null;

    public e() {
    }

    static {
        c = new e();
        a = c.a.a;
    }

    public final boolean e() {
        WeakReference<com.bytedance.android.live.profit.fansclub.b> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        com.bytedance.android.live.profit.fansclub.b r1 = r0.get();
        if (r1 == null) goto L8;
        py.k r2 = r1.b();
    L9:
        if (r2 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r2 = null;
        goto L9
    }

    @Override // dl0.a
    public final c b() {
        return a;
    }

    public static com.bytedance.android.live.profit.fansclub.b d(User r3) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Integer r0 = (Integer) kr0.a.getValue();
        com.bytedance.android.live.profit.fansclub.a r1 = null;
        if (r0 != null) goto L6;
    L13:
        com.bytedance.android.live.profit.fansclub.o r2 = yt0.c.c();
        if (r2 == null) goto L18;
        com.bytedance.android.live.profit.fansclub.g r4 = r2.P5(r3);
        if (r4 == null) goto L18;
        com.bytedance.android.live.profit.fansclub.b r5 = r4.a;
    L19:
        if (r5 == null) goto L33;
        py.h r6 = r3.getFansClub().getData();
        Intrinsics.checkNotNull(r6);
        u r7 = r6.getBadge();
        if (r7 == null) goto L34;
        Map r8 = r7.getIcons();
        if (r8 == null) goto L35;
        py.k r9 = (py.k) r8.get(4);
        if (r9 == null) goto L36;
        r9.setImageType(51);
        com.bytedance.android.live.profit.fansclub.a r10 = r5.d;
        if (r10 == null) goto L30;
        r1 = com.bytedance.android.live.profit.fansclub.a.a(r10, r9);
    L30:
        return com.bytedance.android.live.profit.fansclub.b.a(r5, r1);
    L36:
        return null;
    L35:
        return null;
    L34:
        return null;
    L33:
        return null;
    L18:
        r5 = null;
        goto L19
    L6:
        if (r0.intValue() != 0) goto L13;
        com.bytedance.android.live.profit.fansclub.o r11 = yt0.c.c();
        if (r11 == null) goto L31;
        com.bytedance.android.live.profit.fansclub.g r12 = r11.P5(r3);
        if (r12 != null) goto L12;
        return null;
    L12:
        return r12.a;
    L31:
        return null;
    }

    @Override // dl0.a
    public final void c(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        WeakReference<com.bytedance.android.live.profit.fansclub.b> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        com.bytedance.android.live.profit.fansclub.b r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        FrameLayout r2 = (FrameLayout) r5.findViewById(2131372116);
        TextView r6 = (TextView) r5.findViewById(2131390602);
        py.k r3 = r1.b();
        r2.setVisibility(0);
        int r4 = a3.d;
        a3.a.a(r2, r3, new d(r6, r1), 0.0f);
    }

    @Override // dl0.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565210, r4, false);
    }
}
