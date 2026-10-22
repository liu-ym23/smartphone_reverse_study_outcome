package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.content.Intent;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.bot.impl.databinding.LarusPageBotBgSelectBinding;
import com.larus.common_ui.dialog.p0;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements p0 {
    public final /* synthetic */ BgSelectFragment a;

    public final void confirm() {
        LarusPageBotBgSelectBinding r0 = this.a.e;
        if (r0 == null) goto L9;
        TextView r1 = r0.b;
        if (r1 == null) goto L9;
        if (r1.isEnabled() == true) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        qu8.b.d("gen_bg_by_prompt_with_img", -1);
    L13:
        qu8.b.d("bot_create_step", -1);
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L16;
        r3.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("quit_ai_gen_process", Boolean.TRUE)})));
    L16:
        FragmentActivity r4 = this.a.getActivity();
        if (r4 == null) goto L20;
        r4.finish();
        return;
    L20:
        return;
    L9:
        r2 = false;
        goto L11
    }

    public h(BgSelectFragment r1) {
        this.a = r1;
    }
}
