package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements ChatWindowTitleBar.a {
    public final /* synthetic */ FlowMessageSelectPlugin a;
    public final /* synthetic */ String b;

    public final void a(FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        FlowMessageSelectPlugin r1 = this.a;
        int r2 = FlowMessageSelectPlugin.f0;
        TextView r0 = new TextView(r1.getContext());
        r0.setText(this.b);
        r0.setTextColor(UIUtils.getColor(r0.getContext(), 2131106622));
        r0.setTextSize(17.0f);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        r0.setLayoutParams(r3);
        r4.addView(r0);
    }

    public d(FlowMessageSelectPlugin r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
