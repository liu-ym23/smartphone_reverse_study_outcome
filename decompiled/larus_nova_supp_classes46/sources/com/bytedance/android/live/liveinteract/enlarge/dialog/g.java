package com.bytedance.android.live.liveinteract.enlarge.dialog;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.enlarge.dialog.diff.MultiEnlargeSelectGuestDiffCallback;
import com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements MultiEnlargeGuestSelectViewBinder.a {
    public final /* synthetic */ MultiLinkEnlargeSelectNewEnlargeUserDialog a;

    public g(MultiLinkEnlargeSelectNewEnlargeUserDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder.a
    public final void onSelected(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        if (r7 == true) goto L5;
        return;
    L5:
        MultiLinkEnlargeSelectNewEnlargeUserDialog r8 = this.a;
        int r0 = MultiLinkEnlargeSelectNewEnlargeUserDialog.H;
        r8.getClass();
        ArrayList r1 = new ArrayList();
        Iterator<MultiEnlargeGuestSelectViewBinder.b> r2 = r8.F.iterator();
    L7:
        if (r2.hasNext() == false) goto L19;
        MultiEnlargeGuestSelectViewBinder.b r3 = r2.next();
        IBaseUser r4 = r3.b.getUser();
        if (r4 == null) goto L11;
        String r5 = r4.getIdString();
    L13:
        if ((!Intrinsics.areEqual(r5, r6)) == true) goto L15;
        r1.add(new MultiEnlargeGuestSelectViewBinder.b(true, r3.b));
        goto L7
    L15:
        if (r3.a == true) goto L16;
        r1.add(r3);
        goto L7
    L16:
        r1.add(new MultiEnlargeGuestSelectViewBinder.b(false, r3.b));
        goto L7
    L11:
        r5 = null;
        goto L13
    L19:
        DiffUtil.DiffResult r9 = DiffUtil.calculateDiff(new MultiEnlargeSelectGuestDiffCallback(r8.F, r1));
        MultiTypeAdapter r10 = r8.E;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L22:
        r9.dispatchUpdatesTo(r10);
    }
}
