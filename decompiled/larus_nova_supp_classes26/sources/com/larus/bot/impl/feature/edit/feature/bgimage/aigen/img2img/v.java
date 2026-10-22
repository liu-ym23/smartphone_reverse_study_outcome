package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.larus.common_ui.dialog.p0;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v implements p0 {
    public final /* synthetic */ Img2BgImageFragment a;

    public final void confirm() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L5;
        r0.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("quit_ai_gen_process", Boolean.TRUE)})));
    L5:
        FragmentActivity r1 = this.a.getActivity();
        if (r1 == null) goto L9;
        r1.finish();
        return;
    }

    public v(Img2BgImageFragment r1) {
        this.a = r1;
    }
}
