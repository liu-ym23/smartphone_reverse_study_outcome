package com.bytedance.android.live.liveinteract.enlarge.dialog;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.enlarge.dialog.diff.MultiEnlargeSelectGuestDiffCallback;
import com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements MultiEnlargeGuestSelectViewBinder.a {
    public final /* synthetic */ MultiLinkEnlargeSelectGuestDialog a;
    public final /* synthetic */ int b;

    public e(MultiLinkEnlargeSelectGuestDialog r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder.a
    public final void onSelected(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "userId");
        if (r8 == false) goto L21;
        List<MultiEnlargeGuestSelectViewBinder.b> r1 = this.a.D;
        if ((r1 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r2 = r1.iterator();
        int r3 = 0;
    L11:
        if (r2.hasNext() == false) goto L17;
        if (((MultiEnlargeGuestSelectViewBinder.b) r2.next()).a == false) goto L11;
        r3 = r3 + 1;
        if (r3 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
    L17:
        int r4 = this.b;
        if (r3 < r4) goto L21;
        f2.c(s1.C(2131916172, new Object[]{String.valueOf(r4)}), 0);
        return;
    L7:
        if (r1.isEmpty() == false) goto L9;
        r3 = 0;
    L21:
        MultiLinkEnlargeSelectGuestDialog r5 = this.a;
        int r6 = MultiLinkEnlargeSelectGuestDialog.F;
        r5.getClass();
        ArrayList r9 = new ArrayList();
        Iterator<MultiEnlargeGuestSelectViewBinder.b> r10 = r5.D.iterator();
    L23:
        if (r10.hasNext() == false) goto L32;
        MultiEnlargeGuestSelectViewBinder.b r11 = r10.next();
        IBaseUser r12 = r11.b.getUser();
        if (r12 == null) goto L27;
        String r13 = r12.getIdString();
    L29:
        if ((!Intrinsics.areEqual(r13, r7)) == true) goto L30;
        r9.add(new MultiEnlargeGuestSelectViewBinder.b(r8, r11.b));
        goto L23
    L30:
        r9.add(r11);
        goto L23
    L27:
        r13 = null;
        goto L29
    L32:
        DiffUtil.DiffResult r14 = DiffUtil.calculateDiff(new MultiEnlargeSelectGuestDiffCallback(r5.D, r9));
        MultiTypeAdapter r15 = r5.C;
        if (r15 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L35:
        r14.dispatchUpdatesTo(r15);
    }
}
