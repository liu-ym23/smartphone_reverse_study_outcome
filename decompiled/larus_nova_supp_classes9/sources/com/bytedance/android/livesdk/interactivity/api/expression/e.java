package com.bytedance.android.livesdk.interactivity.api.expression;

import android.view.View;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.EmojiLocalRecentManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ BaseEmoji a;
    public final /* synthetic */ Function0 b;

    public e(BaseEmoji r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r2 = EmojiLocalRecentManager.a;
        EmojiLocalRecentManager.d(this.a);
        Function0 r3 = this.b;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke();
        return;
    }
}
