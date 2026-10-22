package com.ss.android.lark.inline.ai.ui;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.image.impl.preload.ImagePreloadConfig;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.Input;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class u implements TextWatcher {
    public final /* synthetic */ InlineAIPanelController a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public u(InlineAIPanelController r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "s");
        StringBuilder r14 = new StringBuilder("onTextChanged: ");
        r14.append(r10);
        r14.append(", status = ");
        InlineAIPanel r15 = this.a.O;
        Prompt r16 = null;
        if (r15 == null) goto L7;
        Input r17 = r15.getInput();
        if (r17 == null) goto L7;
        Integer r18 = Integer.valueOf(r17.getStatus());
    L8:
        r14.append(r18);
        r14.append(", isHiding = ");
        r14.append(this.a.Q);
        Log.d("InlineAIPanelController", r14.toString());
        InlineAIPanel r19 = this.a.O;
        boolean r110 = false;
        if (r19 == null) goto L15;
        Input r111 = r19.getInput();
        if (r111 == null) goto L15;
        if (r111.getStatus() != 0) goto L15;
        boolean r112 = true;
    L16:
        if (r112 == false) goto L21;
        InlineAIPanelController.g r113 = this.a.T;
        String r1 = r10.toString();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r1, "text");
        r113.c.e.removeCallbacks(r113.b);
        long r2 = System.currentTimeMillis();
        if ((r2 - r113.a) < 200) goto L20;
        r113.a = r2;
    L20:
        long r3 = r2 - r113.a;
        InlineAIPanelController.g.a r4 = new InlineAIPanelController.g.a(r113, r1);
        r113.b = r4;
        r113.c.e.postDelayed(r4, ((long) ImagePreloadConfig.DEFAULT_PRELOAD_CACHE_COUNT) - r3);
    L21:
        InlineAIPanel r114 = this.a.O;
        if (r114 == null) goto L26;
        Input r115 = r114.getInput();
        if (r115 == null) goto L26;
        r16 = r115.getRecentPrompt();
    L26:
        if (r16 == null) goto L28;
        boolean r116 = true;
    L29:
        InlineAIPanel r117 = this.a.O;
        if (r117 == null) goto L36;
        Input r118 = r117.getInput();
        if (r118 == null) goto L36;
        if (r118.getPlacehoderSelected() != true) goto L36;
        boolean r119 = true;
    L37:
        AppCompatImageView r5 = this.a.F;
        if (r10.length() <= 0) goto L40;
        boolean r6 = true;
    L41:
        if (r6 == false) goto L43;
    L49:
        r110 = true;
    L50:
        r5.setEnabled(r110);
        return;
    L43:
        if (r10.length() != 0) goto L45;
        boolean r120 = true;
    L46:
        if (r120 == false) goto L50;
        if (r116 == true) goto L49;
        if (r119 == false) goto L50;
    L45:
        r120 = false;
        goto L46
    L40:
        r6 = false;
    L36:
        r119 = false;
        goto L37
    L28:
        r116 = false;
    L15:
        r112 = false;
    L7:
        r18 = null;
        goto L8
    }
}
