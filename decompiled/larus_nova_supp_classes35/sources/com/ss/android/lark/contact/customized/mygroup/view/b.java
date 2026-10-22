package com.ss.android.lark.contact.customized.mygroup.view;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbFragmentOfficeMyJoinGroupBinding;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ OfficeMyJoinGroupFragment a;

    public b(OfficeMyJoinGroupFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        i9b.a r8 = (i9b.a) r7;
        ContactDbFragmentOfficeMyJoinGroupBinding r4 = null;
        if ((r8 instanceof i9b.a.b) == false) goto L24;
        OfficeMyJoinGroupFragment r9 = this.a;
        if (r9.g != null) goto L10;
        ContactDbFragmentOfficeMyJoinGroupBinding r0 = r9.e;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L9:
        lt7.d.a r5 = new lt7.d.a(r0.c);
        r5.b = 2131559904;
        r5.a(2131108723);
        r5.c = UIUtils.canShowSkeleton();
        r9.g = r5.b();
    L10:
        ContactDbFragmentOfficeMyJoinGroupBinding r1 = r9.e;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L13:
        r1.c.setVisibility(0);
        ContactDbFragmentOfficeMyJoinGroupBinding r2 = r9.e;
        if (r2 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L16:
        r2.e.setVisibility(8);
        ContactDbFragmentOfficeMyJoinGroupBinding r3 = r9.e;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L20:
        r4.b.setVisibility(8);
        lt7.d r10 = r9.g;
        if (r10 == null) goto L97;
        r10.b();
        return;
    L97:
        return;
    L19:
        r4 = r3;
        goto L20
    L24:
        if ((r8 instanceof i9b.a.c) == false) goto L64;
        OfficeMyJoinGroupFragment r6 = this.a;
        List r11 = (List) ((i9b.a.c) r8).a;
        int r12 = OfficeMyJoinGroupFragment.i;
        ContactDbFragmentOfficeMyJoinGroupBinding r13 = r6.e;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r13 = null;
    L28:
        r13.c.setVisibility(8);
        lt7.d r14 = r6.g;
        if (r14 == null) goto L32;
        r14.a();
    L32:
        if (r11.isEmpty() == false) goto L50;
        ContactDbFragmentOfficeMyJoinGroupBinding r15 = r6.e;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L36:
        r15.e.setVisibility(8);
        ContactDbFragmentOfficeMyJoinGroupBinding r16 = r6.e;
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L39:
        r16.b.setVisibility(0);
        ContactDbFragmentOfficeMyJoinGroupBinding r17 = r6.e;
        if (r17 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L42:
        r17.b.setHideActionButton(true);
        ContactDbFragmentOfficeMyJoinGroupBinding r18 = r6.e;
        if (r18 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L45:
        r18.b.setEmptyIcon(2131233633);
        ContactDbFragmentOfficeMyJoinGroupBinding r19 = r6.e;
        if (r19 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L49:
        r4.b.setEmptyText(UIHelper.getString(2131890066));
        return;
    L48:
        r4 = r19;
        goto L49
    L50:
        ContactDbFragmentOfficeMyJoinGroupBinding r20 = r6.e;
        if (r20 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r20 = null;
    L53:
        r20.e.setVisibility(0);
        ContactDbFragmentOfficeMyJoinGroupBinding r21 = r6.e;
        if (r21 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L57:
        r4.b.setVisibility(8);
        OfficeMyGroupAdapter r22 = r6.h;
        if (r22 == null) goto L100;
        Intrinsics.checkNotNullParameter(r11, "newItems");
        final ArrayList r23 = new ArrayList(r22.a);
        final ArrayList r24 = new ArrayList(r11);
        if (r23.isEmpty() == false) goto L62;
        r22.a.clear();
        r22.a.addAll(r24);
        r22.notifyDataSetChanged();
        return;
    L62:
        DiffUtil.calculateDiff(new OfficeMyGroupAdapter$diff$diffResult$1(r23, r24)).dispatchUpdatesTo(r22);
        r22.a.clear();
        r22.a.addAll(r24);
        return;
    L100:
        return;
    L56:
        r4 = r21;
        goto L57
    L64:
        if ((r8 instanceof i9b.a.C0235a) == false) goto L96;
        OfficeMyJoinGroupFragment r25 = this.a;
        int r26 = OfficeMyJoinGroupFragment.i;
        ContactDbFragmentOfficeMyJoinGroupBinding r27 = r25.e;
        if (r27 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r27 = null;
    L68:
        r27.c.setVisibility(8);
        lt7.d r28 = r25.g;
        if (r28 == null) goto L71;
        r28.a();
    L71:
        ContactDbFragmentOfficeMyJoinGroupBinding r29 = r25.e;
        if (r29 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r29 = null;
    L74:
        r29.e.setVisibility(8);
        ContactDbFragmentOfficeMyJoinGroupBinding r30 = r25.e;
        if (r30 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r30 = null;
    L77:
        r30.b.setVisibility(0);
        ContactDbFragmentOfficeMyJoinGroupBinding r31 = r25.e;
        if (r31 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r31 = null;
    L80:
        r31.b.setHideActionButton(false);
        ContactDbFragmentOfficeMyJoinGroupBinding r32 = r25.e;
        if (r32 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r32 = null;
    L83:
        r32.b.setEmptyIcon(2131233634);
        ContactDbFragmentOfficeMyJoinGroupBinding r33 = r25.e;
        if (r33 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r33 = null;
    L86:
        r33.b.setEmptyText(UIHelper.getString(2131889966));
        ContactDbFragmentOfficeMyJoinGroupBinding r34 = r25.e;
        if (r34 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r34 = null;
    L89:
        r34.b.setEmptyActionText(UIHelper.getString(2131889969));
        ContactDbFragmentOfficeMyJoinGroupBinding r35 = r25.e;
        if (r35 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L93:
        r4.b.setOnActionClickListener(new g(r25));
        return;
    L92:
        r4 = r35;
        goto L93
    L96:
        throw new NoWhenBranchMatchedException();
    }
}
