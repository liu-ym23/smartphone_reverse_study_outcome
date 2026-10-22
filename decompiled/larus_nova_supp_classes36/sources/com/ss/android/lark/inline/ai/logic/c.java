package com.ss.android.lark.inline.ai.logic;

import android.content.DialogInterface;
import com.bytedance.supervisor.token.Token;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ InlineAIController a;
    public final /* synthetic */ String b;

    public c(InlineAIController r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r4, int r5) {
        int r6 = com.ss.android.lark.inline.ai.utils.b.a;
        com.ss.android.lark.inline.ai.utils.b.a(this.a.a.getActivity(), this.b, new Token("LARK-PSDA-myai_message_copy_debug_info"));
        if (r4 == null) goto L6;
        r4.dismiss();
        return;
    }
}
