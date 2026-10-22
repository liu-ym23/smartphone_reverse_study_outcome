package com.ss.android.lark.inline.ai.creationai;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.image.impl.preload.ImagePreloadConfig;
import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.Input;
import com.ss.android.lark.inline.ai.api.creationai.UIConfig;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0 implements TextWatcher {
    public final /* synthetic */ CreationAIPanelController a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public b0(CreationAIPanelController r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "s");
        StringBuilder r11 = new StringBuilder("onTextChanged: ");
        r11.append(r7);
        r11.append(", status = ");
        CreationAIPanel r12 = this.a.x;
        String r13 = null;
        if (r12 == null) goto L9;
        UIConfig r14 = r12.getUiConfig();
        if (r14 == null) goto L9;
        Input r15 = r14.getInput();
        if (r15 == null) goto L9;
        String r16 = r15.getWritingStatus();
    L10:
        r11.append(r16);
        r11.append(", isHiding = ");
        r11.append(this.a.z);
        Log.d("CreationAIPanelController", r11.toString());
        CreationAIPanel r17 = this.a.x;
        if (r17 == null) goto L18;
        UIConfig r18 = r17.getUiConfig();
        if (r18 == null) goto L18;
        Input r19 = r18.getInput();
        if (r19 == null) goto L18;
        r13 = r19.getWritingStatus();
    L18:
        if (TextUtils.equals(r13, "waiting") == false) goto L23;
        CreationAIPanelController.e r20 = this.a.B;
        String r21 = r7.toString();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, "text");
        r20.c.e.removeCallbacks(r20.b);
        long r0 = System.currentTimeMillis();
        if ((r0 - r20.a) < 200) goto L22;
        r20.a = r0;
    L22:
        long r1 = r0 - r20.a;
        CreationAIPanelController.e.a r110 = new CreationAIPanelController.e.a(r20, r21);
        r20.b = r110;
        r20.c.e.postDelayed(r110, ((long) ImagePreloadConfig.DEFAULT_PRELOAD_CACHE_COUNT) - r1);
    L23:
        AppCompatImageView r22 = this.a.t;
        boolean r111 = false;
        if (StringsKt.trim(r7).length() <= 0) goto L26;
        boolean r23 = true;
    L27:
        r22.setActivated(r23);
        AppCompatImageView r24 = this.a.t;
        if (StringsKt.trim(r7).length() <= 0) goto L30;
        r111 = true;
    L30:
        r24.setEnabled(r111);
        return;
    L26:
        r23 = false;
    L9:
        r16 = null;
        goto L10
    }
}
