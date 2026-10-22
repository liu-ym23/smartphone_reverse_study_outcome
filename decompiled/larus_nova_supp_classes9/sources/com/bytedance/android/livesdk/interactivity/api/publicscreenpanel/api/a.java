package com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.entity.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {
    PanelItemSymbol a();

    boolean b(l r1);

    void c(l r1, e r2);

    View getView(Context r1);

    void onClick(View r1);

    void onDestroyView();
}
