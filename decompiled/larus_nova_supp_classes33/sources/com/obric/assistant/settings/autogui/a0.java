package com.obric.assistant.settings.autogui;

import android.content.ComponentName;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a0 extends ClickableSpan {
    public final /* synthetic */ FragmentActivity a;

    public a0(FragmentActivity r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        FLogger r6 = FLogger.a;
        r6.i("ObricAutoGuiSettingsFragment", "autoGuiConfirmDialog privacy link click, url=https://www.doubao.com/ocean_legal/privacy");
        String r0 = HomeService.a.F();
        if ((!StringsKt.isBlank(r0)) == false) goto L13;
        FragmentActivity r7 = this.a;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Intent r3 = new Intent();     // Catch: Throwable -> L7
        r3.setComponent(new ComponentName(r7, r0));     // Catch: Throwable -> L7
        r3.putExtra("open_link", "https://www.doubao.com/ocean_legal/privacy");     // Catch: Throwable -> L7
        r7.startActivity(r3);     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r1 = Result.exceptionOrNull-impl(r8);
        if (r1 == null) goto L12;
        FLogger.a.e("ObricAutoGuiSettingsFragment", "open privacy policy failed", r1);
    L12:
        Result.box-impl(r8);
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L13:
        r6.e("ObricAutoGuiSettingsFragment", "open privacy policy failed: empty activity className");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setColor(ContextCompat.getColor(this.a, 2131104787));
        r3.setUnderlineText(false);
    }
}
