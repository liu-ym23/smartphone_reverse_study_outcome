package com.ss.android.lark.contact.customized.newcontact.view;

import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ OfficeNewContactFragment a;

    public g(OfficeNewContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        i9b.a r8 = (i9b.a) r7;
        l r3 = null;
        if ((r8 instanceof i9b.a.b) == false) goto L15;
        l r9 = this.a.e;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
    L9:
        if (r3.f != null) goto L11;
        lt7.d.a r0 = new lt7.d.a(r3.a.b);
        r0.b = 2131559904;
        r0.a(2131108723);
        r0.c = UIUtils.canShowSkeleton();
        r3.f = r0.b();
    L11:
        r3.a.d.setVisibility(0);
        r3.a.e.setVisibility(0);
        r3.a.b.setVisibility(0);
        r3.a.f.setVisibility(8);
        lt7.d r10 = r3.f;
        if (r10 == null) goto L55;
        r10.b();
        return;
    L55:
        return;
    L7:
        r3 = r9;
        goto L9
    L15:
        if ((r8 instanceof i9b.a.c) == false) goto L38;
        l r1 = this.a.e;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r1 = null;
    L19:
        r1.a.b.setVisibility(8);
        r1.a.e.setVisibility(8);
        lt7.d r2 = r1.f;
        if (r2 == null) goto L22;
        r2.a();
    L22:
        boolean r4 = Intrinsics.areEqual(this.a.S90().getShowEmptyView().getValue(), Boolean.TRUE);
        i9b.a.c r11 = (i9b.a.c) r8;
        if (((List) r11.a).isEmpty() == false) goto L30;
        if (r4 == false) goto L30;
        l r12 = this.a.e;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
    L29:
        r3.a();
        return;
    L28:
        r3 = r12;
    L30:
        l r5 = this.a.e;
        if (r5 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
    L34:
        List r13 = (List) r11.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r13, "viewDataList");
        r3.b();
        OfficeNewContactAdapter r6 = r3.d;
        if (r6 == null) goto L58;
        Intrinsics.checkNotNullParameter(r13, "newItems");
        r6.a.clear();
        r6.a.addAll(r13);
        r6.notifyDataSetChanged();
        return;
    L58:
        return;
    L33:
        r3 = r5;
        goto L34
    L38:
        if ((r8 instanceof i9b.a.C0235a) == false) goto L54;
        l r14 = this.a.e;
        if (r14 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r14 = null;
    L42:
        r14.a.b.setVisibility(8);
        r14.a.e.setVisibility(8);
        lt7.d r15 = r14.f;
        if (r15 == null) goto L45;
        r15.a();
    L45:
        l r16 = this.a.e;
        if (r16 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
    L49:
        String r17 = ((i9b.a.C0235a) r8).a;
        r3.a.f.setEmptyIcon(2131233633);
        r3.a.f.setEmptyText(UIHelper.getString(2131889966));
        r3.a.f.setEmptyActionText(UIHelper.getString(2131889969));
        r3.a.f.setOnActionClickListener(new r(r3));
        r3.a.d.setVisibility(8);
        r3.a.e.setVisibility(0);
        r3.a.f.setVisibility(0);
        r3.a.b.setVisibility(8);
        lt7.d r18 = r3.f;
        if (r18 == null) goto L60;
        r18.a();
        return;
    L60:
        return;
    L48:
        r3 = r16;
        goto L49
    L54:
        throw new NoWhenBranchMatchedException();
    }
}
