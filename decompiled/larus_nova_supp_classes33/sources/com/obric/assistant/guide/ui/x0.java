package com.obric.assistant.guide.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.t1;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x0 {
    public static final x0 a = null;
    public static boolean b;

    public static final class a extends ClickableSpan {
        public final /* synthetic */ URLSpan a;
        public final /* synthetic */ Context b;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r4) {
            Intrinsics.checkNotNullParameter(r4, "widget");
            if (Intrinsics.areEqual(this.a.getURL(), "pp") == false) goto L15;
            x0 r5 = x0.a;
            Context r0 = this.b;
            r5.getClass();
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
            int r7 = ObricRecordAudioRuleWebViewActivity.h;     // Catch: Throwable -> L7
            Intrinsics.checkNotNullParameter(r0, "context");     // Catch: Throwable -> L7
            Intent r8 = new Intent(r0, ObricRecordAudioRuleWebViewActivity.class);     // Catch: Throwable -> L7
            r8.putExtra("open_link", "https://os.obriccloud.com/agreement/AudioRecordingUsageRules");     // Catch: Throwable -> L7
            r0.startActivity(r8);     // Catch: Throwable -> L7
            Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r10 = Result.exceptionOrNull-impl(r9);
            if (r10 == null) goto L16;
            FLogger.a.e("VoiceNoiseReductionUpgradeDialog", "open record audio rule failed", r10);
            return;
        L16:
            return;
        L7:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L9
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "ds");
            r3.setColor(ContextCompat.getColor(this.b, 2131104787));
            r3.setUnderlineText(false);
        }

        public a(URLSpan r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        a = new x0();
    }

    public x0() {
    }

    public static CharSequence a(Context r10) {
        SpannableStringBuilder r1 = new SpannableStringBuilder(HtmlCompat.fromHtml(StringsKt.replace$default(r10.getString(2131912694), "\n", "<br/>", false, 4, null), 0));
        Object[] r0 = r1.getSpans(0, r1.length(), URLSpan.class);
        int r3 = r0.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L15;
        URLSpan r5 = (URLSpan) r0[r4];
        int r6 = r1.getSpanStart(r5);
        int r7 = r1.getSpanEnd(r5);
        int r8 = r1.getSpanFlags(r5);
        r1.removeSpan(r5);
        a r9 = new a(r5, r10);
        Integer r11 = Integer.valueOf(r8);
        if (r11.intValue() == 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r11 = null;
    L11:
        if (r11 == null) goto L13;
        int r13 = r11.intValue();
    L14:
        r1.setSpan(r9, r6, r7, r13);
        r4 = r4 + 1;
        goto L3
    L13:
        r13 = 33;
        goto L14
    L7:
        r12 = false;
        goto L8
    L15:
        return r1;
    }

    public final void b(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (t1.a.V1() == false) goto L7;
        FLogger.a.i("VoiceNoiseReductionUpgradeDialog", "show skipped because notice has been acknowledged");
        return;
    L7:
        if (b == false) goto L29;
        FLogger.a.i("VoiceNoiseReductionUpgradeDialog", "show skipped because dialog is already showing");
        return;
    L29:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L22
        b = true;     // Catch: Throwable -> L22
        CharSequence r3 = a(r7);     // Catch: Throwable -> L22
        com.obric.oui.dialog.v2.alert.g r4 = new com.obric.oui.dialog.v2.alert.g(r7);     // Catch: Throwable -> L22
        r4.w = false;     // Catch: Throwable -> L22
        String r5 = r7.getString(2131912695);     // Catch: Throwable -> L22
        r4.j = false;     // Catch: Throwable -> L22
        r4.h = r5;     // Catch: Throwable -> L22
        r4.i = r3;     // Catch: Throwable -> L22
        r4.z = true;     // Catch: Throwable -> L22
        r4.e(r7.getString(2131912693), new v0());     // Catch: Throwable -> L22
        com.obric.oui.dialog.v2.alert.c r8 = r4.a();     // Catch: Throwable -> L22
        r8.setCancelable(false);     // Catch: Throwable -> L22
        r8.setCanceledOnTouchOutside(false);     // Catch: Throwable -> L22
        r8.setOnDismissListener(new w0(this));     // Catch: Throwable -> L22
        TextView r6 = r8.K;     // Catch: Throwable -> L22
        if (r6 == null) goto L15;
        r6.setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Throwable -> L22
        r6.setHighlightColor(0);     // Catch: Throwable -> L22
    L15:
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r8);     // Catch: Throwable -> L22
    L20:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L33;
        b = false;
        FLogger.a.e("VoiceNoiseReductionUpgradeDialog", "show failed", r10);
        return;
    L33:
        return;
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28 Throwable -> L22
    L19:
        DialogLancet.beforeDialogShow(r8);     // Catch: Throwable -> L22
        r8.show();     // Catch: Throwable -> L22
        DialogLancet.afterDialogShow(r8);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }
}
