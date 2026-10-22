package com.ss.android.lark.chat.preview.components;

import android.view.View;
import android.widget.ImageView;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.ss.android.lark.chat.preview.components.view.UDListDialogAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ k a;
    public final /* synthetic */ ImageView b;

    public l(k r1, ImageView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Log.d("[URLPreview]PreviewTitleComponent", "click close");
        k r9 = this.a;
        ImageView r0 = this.b;
        r9.getClass();
        ArrayList r1 = new ArrayList();
        HashMap r2 = new HashMap();
        int r4 = 1;
        if (r9.r == false) goto L6;
        r1.add(UIHelper.getString(2131890365));
        r2.put(Integer.valueOf(r1.size() - 1), "show_copy");
    L6:
        if (r9.q == false) goto L8;
        r1.add(UIHelper.getString(2131891669));
        r2.put(Integer.valueOf(r1.size() - 1), "close_preview");
        r4 = r1.size() - 1;
    L8:
        new UDActionPanelBuilder(r0.getContext()).items(r1).adapter(new UDListDialogAdapter(r0.getContext(), r4, 2131102093)).itemClickListener(new m(r9, r2, r0)).addActionButton(2131391775, r0.getContext().getString(2131891541), null).show();
    }
}
