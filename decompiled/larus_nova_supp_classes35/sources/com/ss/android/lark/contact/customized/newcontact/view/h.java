package com.ss.android.lark.contact.customized.newcontact.view;

import androidx.lifecycle.Observer;
import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ OfficeNewContactFragment a;

    public h(OfficeNewContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        List r9 = (List) r8;
        if (r9 == null) goto L51;
        l r0 = this.a.e;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r0 = null;
    L7:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "viewDataList");
        Iterator r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L62;
        NewContactView.a r2 = (NewContactView.a) r10.next();
        OfficeNewContactAdapter r3 = r0.d;
        if (r3 == null) goto L13;
        ArrayList<NewContactView.a> r4 = r3.a;
    L14:
        if (r4 == null) goto L9;
        if (CollectionUtils.isEmpty(r4) == true) goto L9;
        int r5 = r4.indexOf(r2);
        if (r5 < 0) goto L43;
        NewContactView.a r6 = (NewContactView.a) ListProtector.get(r4, r5);
        ChatApplication.Status r7 = r2.h;
        r6.h = r7;
        CertificationInfo r11 = r2.i;
        if (r11 == null) goto L23;
        r6.i = r11;
    L23:
        String r12 = r2.e;
        if (r12 == null) goto L26;
        r6.e = r12;
    L26:
        r6.f = r2.f;
        if (r7 != ChatApplication.Status.AGREED) goto L29;
    L40:
        OfficeNewContactAdapter r13 = r0.d;
        if (r13 == null) goto L43;
        r13.notifyItemChanged(r5);
        goto L43
    L29:
        if (r7 == ChatApplication.Status.PEDING) goto L40;
        if (r7 == ChatApplication.Status.EXPIRED) goto L40;
        if (r7 != ChatApplication.Status.DELETED) goto L43;
        OfficeNewContactAdapter r14 = r0.d;
        if (r14 == null) goto L43;
        Intrinsics.checkNotNullParameter(r6, "viewData");
        int r15 = r14.a.indexOf(r6);
        if (r15 < 0) goto L43;
        ListProtector.remove(r14.a, r15);
        r14.notifyItemRemoved(r15);
    L43:
        OfficeNewContactAdapter r16 = r0.d;
        if (r16 == null) goto L46;
        ArrayList<NewContactView.a> r17 = r16.a;
    L48:
        if (CollectionUtils.isEmpty(r17) == true) goto L49;
        r0.b();
        goto L9
    L49:
        r0.a();
        goto L9
    L46:
        r17 = null;
        goto L48
    L13:
        r4 = null;
        goto L14
    L62:
        return;
    }
}
