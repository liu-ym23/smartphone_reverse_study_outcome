package com.larus.bmhome.chat.auth;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r extends ClickableSpan {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1<String, Unit> c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        StringBuilder r4 = new StringBuilder();
        r4.append(this.a + "\n\n");
        String r0 = this.b;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r4.append(r0);
        String r5 = r4.toString();
        Function1<String, Unit> r1 = this.c;
        if (r1 == null) goto L9;
        r1.invoke(r5);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "ds");
        AppHost.Companion r0 = AppHost.a;
        r5.setColor(ContextCompat.getColor(r0.getApplication(), v19.c.b(2130972081, r0.getApplication(), 2131103143)));
        r5.setUnderlineText(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(String r1, String r2, Function1<? super String, Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
