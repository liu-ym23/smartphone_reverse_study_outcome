package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ String a;

    public e(String r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ChatCoreModule.a().getBrowserDependency().openUrl(r3.getContext(), this.a);
    }
}
