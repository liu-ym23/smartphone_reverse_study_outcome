package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface k {
    AudiencePanelItemSymbol a();

    void b(com.bytedance.android.live.base.model.message.t r1, v r2);

    boolean canShow();

    View getView(Context r1);

    void onClick(View r1);

    void onDestroyView();
}
