package com.larus.bmhome.view;

import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatTitleAlignLeftStyle$e implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ ChatTitleAlignLeftStyle a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public ChatTitleAlignLeftStyle$e(ChatTitleAlignLeftStyle r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r5) {
        if (r5 == null) goto L9;
        View r6 = r5.getCustomView();
        if (r6 == null) goto L10;
        TextView r7 = (TextView) r6.findViewById(2131391606);
        if (r7 == null) goto L11;
        r7.setTextColor(ContextCompat.getColor(this.a.getContext(), v19.c.b(2130972079, this.a.getContext(), 2131103136)));
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void onTabUnselected(TabLayout.Tab r5) {
        if (r5 == null) goto L9;
        View r6 = r5.getCustomView();
        if (r6 == null) goto L10;
        TextView r7 = (TextView) r6.findViewById(2131391606);
        if (r7 == null) goto L11;
        r7.setTextColor(ContextCompat.getColor(this.a.getContext(), v19.c.b(2130972081, this.a.getContext(), 2131103143)));
        return;
    L11:
        return;
    L10:
        return;
    }
}
