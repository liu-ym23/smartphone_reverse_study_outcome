package com.ss.android.lark.inline.ai.creationai;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ CreationAIPanelController a;

    public r(CreationAIPanelController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.i("CreationAIPanelController", "click stop");
        this.a.b.e();
    }
}
