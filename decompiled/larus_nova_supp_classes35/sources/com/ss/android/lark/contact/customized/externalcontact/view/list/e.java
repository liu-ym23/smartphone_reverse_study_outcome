package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.content.Context;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.contact.customized.department.DepartmentStructureActivity;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends OnSingleClickListener {
    public final /* synthetic */ Context a;

    public e(Context r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r4 = DepartmentStructureActivity.b;
        Context r5 = this.a;
        DepartmentStructureActivity.a.a(r5, DocTabPayload.DocType.UNKNOWN, UIUtils.getString(r5, 2131892245));
    }
}
