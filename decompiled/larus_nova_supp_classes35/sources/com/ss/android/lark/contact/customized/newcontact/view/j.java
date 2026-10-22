package com.ss.android.lark.contact.customized.newcontact.view;

import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ OfficeNewContactFragment a;

    public j(OfficeNewContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        NewContactView.a r6 = (NewContactView.a) r5;
        if (r6 == null) goto L19;
        l r0 = this.a.e;
        ArrayList<NewContactView.a> r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r0 = null;
    L7:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "viewData");
        OfficeNewContactAdapter r3 = r0.d;
        if (r3 == null) goto L12;
        Intrinsics.checkNotNullParameter(r6, "viewData");
        int r7 = r3.a.indexOf(r6);
        if (r7 < 0) goto L12;
        ListProtector.remove(r3.a, r7);
        r3.notifyItemRemoved(r7);
    L12:
        OfficeNewContactAdapter r8 = r0.d;
        if (r8 == null) goto L16;
        r1 = r8.a;
    L16:
        if (CollectionUtils.isEmpty(r1) == false) goto L20;
        r0.a();
        return;
    L20:
        return;
    }
}
