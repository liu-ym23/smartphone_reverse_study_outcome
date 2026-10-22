package com.larus.bmhome.chat.component.title;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.service.c2;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q implements View.OnClickListener {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ q(ChatTitleComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ChatTitleComponent r4 = this.a;
        int r0 = ChatTitleComponent.P1;
        Fragment r5 = a.c(r4);
        if (r5 == null) goto L8;
        FragmentActivity r6 = r5.getActivity();
        if (r6 == null) goto L9;
        c2.a.b(r6, "credit_banner");
        return;
    L9:
        return;
    }
}
