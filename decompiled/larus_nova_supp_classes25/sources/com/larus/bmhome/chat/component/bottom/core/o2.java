package com.larus.bmhome.chat.component.bottom.core;

import android.content.res.Resources;
import android.text.SpannableString;
import androidx.core.content.res.ResourcesCompat;
import com.larus.bmhome.chat.outerinput.a;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o2 implements Function0 {
    public final /* synthetic */ LarusWidgetInputBinding a;
    public final /* synthetic */ CoreInputComponent b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ o2(LarusWidgetInputBinding r1, CoreInputComponent r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        LarusWidgetInputBinding r0 = this.a;
        CoreInputComponent r1 = this.b;
        boolean r2 = this.c;
        int r3 = CoreInputComponent.d3;
        SpannableString r4 = new SpannableString(r0.s.getText().toString());
        int r5 = r4.length();
        Resources r6 = r1.getContext().getResources();
        if (r2 == false) goto L5;
        int r7 = 2131103298;
    L6:
        r4.setSpan(new a(r5, ResourcesCompat.getColor(r6, r7, null), v19.c7.c(1), v19.c7.c(3)), 0, r4.length(), 34);
        return r4;
    L5:
        r7 = v19.c.b(2130972079, r1.getContext(), 2131103136);
        goto L6
    }
}
