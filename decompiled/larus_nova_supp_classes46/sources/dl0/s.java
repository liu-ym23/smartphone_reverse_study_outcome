package dl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.kr0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements a<c.e, User> {
    public static final c.e a = null;
    public static WeakReference<User> b;
    public static final s c = null;

    public s() {
    }

    static {
        c = new s();
        a = c.e.a;
    }

    public final boolean d() {
        Integer r0 = (Integer) kr0.a.getValue();
        if (r0 != null) goto L6;
    L8:
        WeakReference<User> r1 = b;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L11:
        User r2 = r1.get();
        if (r2 != null) goto L14;
        return false;
    L14:
        List r3 = r2._badgeImageListV2;
        Object r4 = null;
        if (r3 == null) goto L29;
        Iterator r5 = r3.iterator();
    L18:
        if (r5.hasNext() == false) goto L28;
        Object r6 = r5.next();
        Integer r7 = ((ImageModel) r6).getImageType();
        if (r7 != null) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L18;
        r4 = r6;
        goto L28
    L23:
        if (r7.intValue() != 59) goto L25;
        r8 = true;
    L28:
        r4 = (ImageModel) r4;
    L29:
        if (r4 == null) goto L37;
        return true;
    L37:
        return false;
    L6:
        if (r0.intValue() != 0) goto L8;
        return false;
    }

    @Override // dl0.a
    public final c b() {
        return a;
    }

    @Override // dl0.a
    public final void c(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        HSImageView r8 = r7.findViewById(2131376647);
        WeakReference<User> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        User r1 = r0.get();
        py.k r2 = null;
        Object r3 = null;
        r2 = null;
        if (r1 == null) goto L22;
        List r4 = r1._badgeImageListV2;
        if (r4 == null) goto L22;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        Integer r9 = ((ImageModel) r6).getImageType();
        if (r9 != null) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == false) goto L11;
        r3 = r6;
        goto L21
    L16:
        if (r9.intValue() != 59) goto L18;
        r10 = true;
    L21:
        r2 = (ImageModel) r3;
    L22:
        ImageUtil.loadImage(r8, r2, 0);
        r8.setVisibility(0);
        r8.setOnClickListener(new r());
    }

    @Override // dl0.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565214, r4, false);
    }
}
