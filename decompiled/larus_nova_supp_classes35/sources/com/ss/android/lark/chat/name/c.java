package com.ss.android.lark.chat.name;

import android.content.Context;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.widget.dialog.SwitchTranslateDialog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import z5c.m;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements SwitchTranslateDialog.b {
    public final /* synthetic */ Map<Integer, String> a;
    public final /* synthetic */ a b;
    public final /* synthetic */ Chat c;
    public final /* synthetic */ Context d;

    public final void a(fcc.c<?> r1) {
        if (r1 == null) goto L5;
        r1.j();
        return;
    }

    public final void onClick(int r6) {
        String r7 = this.a.get(Integer.valueOf(r6));
        if (r7 == null) goto L6;
        a r0 = this.b;
        Chat r1 = this.c;
        Context r2 = this.d;
        s5c.a r3 = r.a3;
        int r4 = m.c;
        Map r5 = MapsKt.mapOf(TuplesKt.to("change_lang_to", r7));
        r0.getClass();
        a.a(r3, r1, r5);
        r0.a.h3(r1.getId(), r7, true, new ChatNameRenderer$doTranslate$1(r1, r2));
        return;
    }

    public c(Map<Integer, String> r1, a r2, Chat r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
