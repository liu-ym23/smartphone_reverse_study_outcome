package com.ss.android.lark.contact.customized.search.view;

import android.view.View;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.ViewUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mtb.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ OfficeInviteExternalSearchAdapter a;
    public final /* synthetic */ mtb.d b;
    public final /* synthetic */ int c;

    public a(OfficeInviteExternalSearchAdapter r1, mtb.d r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        OfficeInviteExternalSearchAdapter r0 = this.a;
        String r1 = r0.d;
        String r2 = this.b.h;
        r0.getClass();
        String r3 = StringsKt.trim(r1).toString();
        boolean r4 = true;
        if (r3.length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        boolean r6 = false;
    L9:
        if (r6 == false) goto L11;
        int r9 = 21;
    L12:
        ContactBaseModuleDependency.b.jumpProfilePageForResult(ViewUtils.getActivityByView(r12), this.a.a, Long.valueOf(this.b.a), r9, 273);
        int r13 = com.ss.android.lark.contact.customized.common.b.a;
        int r14 = !StringsKt.isBlank(this.a.d) ? 1 : 0;
        String r7 = String.valueOf(this.b.b);
        n r8 = this.b.k;
        if (r8 != null) goto L15;
    L17:
        r4 = false;
    L18:
        if (r4 == false) goto L20;
        String r10 = "1";
    L21:
        String r11 = String.valueOf(this.c);
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Intrinsics.checkNotNullParameter("contact", "functionType");
        Intrinsics.checkNotNullParameter("contact", "queryType");
        Intrinsics.checkNotNullParameter(r7, "searchResultId");
        Intrinsics.checkNotNullParameter(r10, "isAdded");
        Intrinsics.checkNotNullParameter(r11, "rank");
        Statistics.sendEvent("search_result_click", new JSONObject().put("current_page", "profile_add_friend").put("function_type", "contact").put("if_have_query", r14).put("query_type", "contact").put("entity_id", r7).put("search_result_id", r7).put("is_added", r10).put("rank", r11));
        return;
    L20:
        r10 = DocTabPayload.DocType.UNKNOWN;
        goto L21
    L15:
        if (r8.a != true) goto L17;
    L11:
        r9 = 8;
        goto L12
    L8:
        r6 = Intrinsics.areEqual(r3, StringsKt.trim(r2).toString());
        goto L9
    L5:
        r5 = false;
        goto L6
    }
}
