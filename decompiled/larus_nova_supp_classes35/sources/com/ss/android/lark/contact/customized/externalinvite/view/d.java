package com.ss.android.lark.contact.customized.externalinvite.view;

import android.view.View;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import com.ss.android.lark.statistics.Statistics;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ OfficeInviteExternalFragment a;

    public d(OfficeInviteExternalFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        OfficeInviteExternalFragment r6 = this.a;
        int r0 = OfficeInviteExternalFragment.i;
        OfficeInviteExternalViewModel r7 = r6.U90();
        OfficeInviteExternalFragment r1 = this.a;
        ContactDbInviteExternalViewFeishuBinding r2 = r1.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L5:
        r7.onClickSearchPhoneOrEmail(r1, r2.n);
        int r8 = com.ss.android.lark.contact.customized.common.b.a;
        String r9 = this.a.d;
        if (r9 != null) goto L8;
        r9 = BuildConfig.FLAVOR;
    L8:
        Intrinsics.checkNotNullParameter("contact", "functionType");
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        Statistics.sendEvent("search_bar_click", new JSONObject().put("function_type", "contact").put("current_page", "profile_add_friend").put("enter_from", r9));
    }
}
