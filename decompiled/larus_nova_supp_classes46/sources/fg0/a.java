package fg0;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public List<? extends e> a;
    public final List<MultiTypeAdapter> b;

    public a() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final int a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "userId");
        List<? extends e> r0 = this.a;
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L23;
        Object r3 = ListProtector.get(r0, r2);
        String r5 = null;
        if ((r3 instanceof MultiLinkGuestViewBinder.a) == true) goto L7;
        r3 = null;
    L7:
        MultiLinkGuestViewBinder.a r4 = (MultiLinkGuestViewBinder.a) r3;
        if (r4 == null) goto L22;
        if (r2.a(r7) == false) goto L18;
        IBaseUser r6 = r4.k.a.getUser();
        if (r6 == null) goto L15;
        r5 = r6.getIdString();
    L15:
        if (Intrinsics.areEqual(r5, r7) == false) goto L18;
        return r2;
    L18:
        if (TextUtils.isEmpty(r8) == true) goto L22;
        if (Intrinsics.areEqual(r4.k.a.getInteractId(), r8) == false) goto L22;
        return r2;
    L22:
        r2 = r2 + 1;
        goto L3
    L23:
        return -1;
    }
}
