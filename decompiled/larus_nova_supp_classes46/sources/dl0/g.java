package dl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements a<c.b, User> {
    public static final c.b a = null;
    public static WeakReference<User> b;
    public static final g c = null;

    public g() {
    }

    static {
        c = new g();
        a = c.b.a;
    }

    public final boolean d() {
        WeakReference<User> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("user");
    L5:
        User r1 = r0.get();
        if (r1 != null) goto L8;
        return false;
    L8:
        py.d r2 = r1.getUserHonor();
        if (r2 == null) goto L11;
        py.k r3 = r2.getNewImIconWithLevel();
    L12:
        if (r3 == null) goto L15;
        return true;
    L15:
        return false;
    L11:
        r3 = null;
        goto L12
    }

    @Override // dl0.a
    public final c b() {
        return a;
    }

    @Override // dl0.a
    public final void c(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        WeakReference<User> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("user");
    L5:
        User r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        HSImageView r4 = r3.findViewById(2131376293);
        r4.setVisibility(0);
        py.d r2 = r1.getUserHonor();
        if (r2 == null) goto L11;
        py.k r5 = r2.getNewImIconWithLevel();
    L12:
        ImageUtil.loadImage(r4, r5, 0);
        return;
    L11:
        r5 = null;
        goto L12
    }

    @Override // dl0.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565211, r4, false);
    }
}
