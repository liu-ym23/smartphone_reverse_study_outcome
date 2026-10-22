package com.ss.android.lark.contact.customized.search.view;

import android.text.Editable;
import androidx.lifecycle.Observer;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ OfficeInviteExternalSearchFragment a;

    public b(OfficeInviteExternalSearchFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r13) {
        o9b.a r14 = (o9b.a) r13;
        boolean r0 = r14 instanceof o9b.a.d;
        String r1 = BuildConfig.FLAVOR;
        boolean r2 = false;
        ContactDbInviteSearchViewLayoutBinding r3 = null;
        ContactDbInviteSearchViewLayoutBinding r4 = null;
        ContactDbInviteSearchViewLayoutBinding r5 = null;
        OfficeInviteExternalSearchAdapter r6 = null;
        if (r0 == false) goto L23;
        OfficeInviteExternalSearchFragment r15 = this.a;
        ContactDbInviteSearchViewLayoutBinding r7 = r15.d;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L8:
        Editable r8 = r4.j.getText();
        if (r8 == null) goto L17;
        String r9 = r8.toString();
        if (r9 == null) goto L17;
        String r10 = StringsKt.replace$default(r9, " ", BuildConfig.FLAVOR, false, 4, null);
        if (r10 == null) goto L17;
        r1 = r10;
    L17:
        if (r1.length() != 0) goto L19;
        r2 = true;
    L19:
        if (r2 == false) goto L21;
        r15.U90();
        return;
    L21:
        r15.T90(r1);
        return;
    L7:
        r4 = r7;
        goto L8
    L23:
        if ((r14 instanceof o9b.a.b) == false) goto L42;
        OfficeInviteExternalSearchFragment r16 = this.a;
        ContactDbInviteSearchViewLayoutBinding r11 = r16.d;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r11 = null;
    L27:
        r11.d.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r12 = r16.d;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r12 = null;
    L30:
        r12.e.a.setVisibility(0);
        ContactDbInviteSearchViewLayoutBinding r17 = r16.d;
        if (r17 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L33:
        r17.e.c.c.start();
        ContactDbInviteSearchViewLayoutBinding r18 = r16.d;
        if (r18 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r18 = null;
    L36:
        r18.f.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r19 = r16.d;
        if (r19 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L40:
        r5.h.a.setVisibility(8);
        return;
    L39:
        r5 = r19;
        goto L40
    L42:
        if ((r14 instanceof o9b.a.c) == false) goto L78;
        OfficeInviteExternalSearchFragment r20 = this.a;
        List<mtb.d> r110 = ((o9b.a.c) r14).a;
        ContactDbInviteSearchViewLayoutBinding r21 = r20.d;
        if (r21 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r21 = null;
    L46:
        r21.e.c.a();
        ContactDbInviteSearchViewLayoutBinding r22 = r20.d;
        if (r22 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r22 = null;
    L49:
        r22.d.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r23 = r20.d;
        if (r23 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r23 = null;
    L52:
        r23.e.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r24 = r20.d;
        if (r24 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r24 = null;
    L55:
        r24.f.setVisibility(0);
        ContactDbInviteSearchViewLayoutBinding r25 = r20.d;
        if (r25 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r25 = null;
    L58:
        r25.h.a.setVisibility(8);
        OfficeInviteExternalSearchAdapter r26 = r20.e;
        if (r26 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r26 = null;
    L61:
        ContactDbInviteSearchViewLayoutBinding r27 = r20.d;
        if (r27 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r27 = null;
    L64:
        Editable r28 = r27.j.getText();
        if (r28 == null) goto L72;
        String r29 = r28.toString();
        if (r29 == null) goto L72;
        String r30 = StringsKt.replace$default(r29, " ", BuildConfig.FLAVOR, false, 4, null);
        if (r30 == null) goto L72;
        r1 = r30;
    L72:
        r26.getClass();
        Intrinsics.checkNotNullParameter(r1, "query");
        r26.d = r1;
        OfficeInviteExternalSearchAdapter r31 = r20.e;
        if (r31 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L76:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r110, "list");
        r6.c.clear();
        ((ArrayList) r6.b).clear();
        ((ArrayList) r6.b).addAll(r110);
        r6.notifyDataSetChanged();
        return;
    L75:
        r6 = r31;
        goto L76
    L78:
        if ((r14 instanceof o9b.a.C0270a) == false) goto L98;
        OfficeInviteExternalSearchFragment r32 = this.a;
        String r111 = ((o9b.a.C0270a) r14).a;
        ContactDbInviteSearchViewLayoutBinding r112 = r32.d;
        if (r112 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r112 = null;
    L82:
        r112.e.c.a();
        ContactDbInviteSearchViewLayoutBinding r113 = r32.d;
        if (r113 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L85:
        r113.d.a.setVisibility(0);
        ContactDbInviteSearchViewLayoutBinding r114 = r32.d;
        if (r114 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r114 = null;
    L88:
        r114.e.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r115 = r32.d;
        if (r115 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r115 = null;
    L91:
        r115.f.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r116 = r32.d;
        if (r116 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L95:
        r3.h.a.setVisibility(8);
        return;
    L94:
        r3 = r116;
        goto L95
    L98:
        throw new NoWhenBranchMatchedException();
    }
}
