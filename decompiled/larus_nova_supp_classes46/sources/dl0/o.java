package dl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements a<c.d, User> {
    public static WeakReference<User> a;
    public static final c.d b = null;
    public static final o c = null;

    public o() {
    }

    static {
        c = new o();
        b = c.d.a;
    }

    public final boolean d() {
        WeakReference<User> r0 = a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        User r1 = r0.get();
        if (r1 != null) goto L8;
        return false;
    L8:
        FollowInfo r2 = r1.getFollowInfo();
        if (r2 == null) goto L11;
        Long r3 = Long.valueOf(r2.getFollowStatus());
    L12:
        if (r3 != null) goto L15;
    L16:
        if (r3 != null) goto L19;
        return false;
    L19:
        if (r3.longValue() != 3) goto L22;
    L20:
        return true;
    L22:
        return false;
    L15:
        if (r3.longValue() == 2) goto L20;
    L11:
        r3 = null;
        goto L12
    }

    @Override // dl0.a
    public final c b() {
        return b;
    }

    @Override // dl0.a
    public final void c(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        WeakReference<User> r0 = a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        User r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        FollowInfo r2 = r1.getFollowInfo();
        if (r2 == null) goto L11;
        Long r3 = Long.valueOf(r2.getFollowStatus());
    L12:
        TextView r8 = (TextView) r7.findViewById(2131390667);
        r8.setTextColor(s1.h(2131108569));
        r8.setPadding((int) s1.e(6.0f), 0, (int) s1.e(6.0f), 0);
        if (r3 != null) goto L16;
    L18:
        if (r3 != null) goto L21;
        return;
    L21:
        if (r3.longValue() != 3) goto L25;
        r8.setText(s1.B(2131923024));
        return;
    L25:
        return;
    L16:
        if (r3.longValue() != 2) goto L18;
        r8.setText(s1.B(2131923026));
        return;
    L11:
        r3 = null;
        goto L12
    }

    @Override // dl0.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565213, r4, false);
    }
}
