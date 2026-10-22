package com.larus.common_ui.view;

import android.graphics.Paint;
import android.widget.TextView;
import com.larus.common_res.common_ui.databinding.LarusChatContinuousTalkInputBinding;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ LarusChatContinuousTalkInputBinding a;
    public final /* synthetic */ ChatInputInnerView b;

    public /* synthetic */ k(LarusChatContinuousTalkInputBinding r1, ChatInputInnerView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LarusChatContinuousTalkInputBinding r0 = this.a;
        ChatInputInnerView r1 = this.b;
        int r2 = ChatInputInnerView.e;
        TextView r3 = r0.d;
        float r4 = nda.d.a().va(r1.getContext(), i5.v());
        float r5 = nda.d.a().va(r1.getContext(), i5.h());
        int r6 = r0.d.getWidth();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r6 > 0) goto L5;
        return;
    L5:
        if (r3.getText().length() != 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L22;
        String r8 = r3.getText().toString();
        Paint r9 = new Paint();
        r9.set(r3.getPaint());
    L12:
        if (r4 <= r5) goto L17;
        r9.setTextSize(r4);
        if (r9.measureText(r8) <= r6) goto L17;
        r4 = r4 - 1.0f;
    L17:
        r3.setTextSize(0, r4);
        return;
    L22:
        return;
    L7:
        r7 = false;
        goto L8
    }
}
