package com.ss.android.lark.contact.customized.externalinvite.view;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ OfficeInviteExternalFragment a;

    public b(OfficeInviteExternalFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        i9b.a r11 = (i9b.a) r10;
        ContactDbInviteExternalViewFeishuBinding r1 = null;
        if ((r11 instanceof i9b.a.b) == false) goto L17;
        OfficeInviteExternalFragment r12 = this.a;
        int r0 = OfficeInviteExternalFragment.i;
        j r2 = r12.h;
        if (r2 == null) goto L11;
        ContactDbInviteExternalViewFeishuBinding r3 = r12.e;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L10:
        r3.a.removeCallbacks(r2);
        r12.h = null;
    L11:
        r12.h = new j(r12);
        ContactDbInviteExternalViewFeishuBinding r4 = r12.e;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L15:
        r1.a.postDelayed(r12.h, 500);
        return;
    L14:
        r1 = r4;
        goto L15
    L17:
        if ((r11 instanceof i9b.a.c) == false) goto L63;
        OfficeInviteExternalFragment.T90(this.a);
        ContactDbInviteExternalViewFeishuBinding r5 = this.a.e;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L21:
        r5.b.setVisibility(8);
        ContactDbInviteExternalViewFeishuBinding r6 = this.a.e;
        if (r6 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L24:
        r6.o.setVisibility(0);
        z8b.a r13 = (z8b.a) ((i9b.a.c) r11).a;
        r13.getClass();
        if (TextUtils.equals("qr_code", "qr_code") == false) goto L27;
        InvitationInfo r14 = r13.a;
    L28:
        if (r14 == null) goto L92;
        OfficeInviteExternalFragment r7 = this.a;
        r7.getClass();
        String r8 = r14.userName;
        String r9 = BuildConfig.FLAVOR;
        if (r8 != null) goto L33;
        r8 = BuildConfig.FLAVOR;
    L33:
        if (r8.length() != 0) goto L35;
        boolean r15 = true;
    L36:
        if (r15 == false) goto L41;
        ContactDbInviteExternalViewFeishuBinding r16 = r7.e;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L40:
        r16.h.setVisibility(8);
    L49:
        if (OfficeContactUtils.f() == false) goto L57;
        ContactDbInviteExternalViewFeishuBinding r17 = r7.e;
        if (r17 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L53:
        TextView r18 = r17.k;
        String r19 = r14.teamName;
        if (r19 == null) goto L56;
        r9 = r19;
    L56:
        r18.setText(r9);
    L61:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7.getViewLifecycleOwner()), Dispatchers.getDefault(), null, new OfficeInviteExternalFragment$bindQrCard$1(r7, r14, null), 2, null);
        return;
    L57:
        ICUUtils.FormatArgsBuilder r20 = new ICUUtils.FormatArgsBuilder();
        r20.b("brandName", UIHelper.getAppName());
        r20.b("id", ((x1c.d) OfficeContactUtils.a.getValue()).y1().b);
        List r21 = r20.a;
        ContactDbInviteExternalViewFeishuBinding r22 = r7.e;
        if (r22 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r22 = null;
    L60:
        r22.k.setText(ICUUtils.icuFormat(UIHelper.getString(2131890051), r21));
        goto L61
    L41:
        ContactDbInviteExternalViewFeishuBinding r23 = r7.e;
        if (r23 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r23 = null;
    L44:
        r23.h.setVisibility(0);
        ContactDbInviteExternalViewFeishuBinding r24 = r7.e;
        if (r24 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r24 = null;
    L47:
        r24.h.setText(r8);
        goto L49
    L35:
        r15 = false;
        goto L36
    L92:
        return;
    L27:
        r14 = r13.b;
        goto L28
    L63:
        if ((r11 instanceof i9b.a.C0235a) == false) goto L94;
        OfficeInviteExternalFragment.T90(this.a);
        OfficeInviteExternalFragment r110 = this.a;
        ContactDbInviteExternalViewFeishuBinding r25 = r110.e;
        if (r25 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r25 = null;
    L67:
        r25.d.a();
        ContactDbInviteExternalViewFeishuBinding r26 = r110.e;
        if (r26 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r26 = null;
    L70:
        r26.c.setVisibility(8);
        ContactDbInviteExternalViewFeishuBinding r27 = r110.e;
        if (r27 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r27 = null;
    L73:
        r27.o.setVisibility(8);
        ContactDbInviteExternalViewFeishuBinding r28 = r110.e;
        if (r28 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r28 = null;
    L76:
        r28.b.setEmptyIcon(2131233634);
        ContactDbInviteExternalViewFeishuBinding r29 = r110.e;
        if (r29 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r29 = null;
    L79:
        r29.b.setEmptyText(UIHelper.getString(2131889966));
        ContactDbInviteExternalViewFeishuBinding r30 = r110.e;
        if (r30 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r30 = null;
    L82:
        r30.b.setEmptyActionText(UIHelper.getString(2131889969));
        ContactDbInviteExternalViewFeishuBinding r31 = r110.e;
        if (r31 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r31 = null;
    L85:
        r31.b.setOnActionClickListener(new i(r110));
        ContactDbInviteExternalViewFeishuBinding r111 = r110.e;
        if (r111 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L89:
        r1.b.setVisibility(0);
        return;
    L88:
        r1 = r111;
        goto L89
    }
}
