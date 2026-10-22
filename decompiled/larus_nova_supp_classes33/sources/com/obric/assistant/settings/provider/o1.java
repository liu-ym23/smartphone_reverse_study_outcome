package com.obric.assistant.settings.provider;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o1 extends ClickableSpan {
    public final /* synthetic */ Context a;

    public o1(Context r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        FLogger.a.i("AsrSettingProvider", "showPcInAsrPrivacyDialog, clickableSpan, onClick https://os.obriccloud.com/agreement/enhance_asr");
        Context r5 = this.a;
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(r5, HomeService.a.F()));
        r0.putExtra("open_link", "https://os.obriccloud.com/agreement/enhance_asr");
        r5.startActivity(r0);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setColor(ContextCompat.getColor(this.a, 2131104787));
        r3.setUnderlineText(false);
    }
}
