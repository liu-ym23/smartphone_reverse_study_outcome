package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements View.OnFocusChangeListener {
    public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 a;

    public s(LiveOpenFeatureSearchFragmentV3 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r3, boolean r4) {
        if (r4 == false) goto L19;
        EditText r5 = this.a.l;
        if (r5 == null) goto L16;
        Editable r6 = r5.getText();
        if (r6 == null) goto L16;
        if (r6.length() != 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 != true) goto L16;
        ImageView r8 = this.a.k;
        if (r8 == null) goto L23;
        r8.setVisibility(4);
        return;
    L23:
        return;
    L11:
        r7 = false;
    L16:
        ImageView r9 = this.a.k;
        if (r9 == null) goto L25;
        r9.setVisibility(0);
        return;
    L25:
        return;
    L19:
        ImageView r11 = this.a.k;
        if (r11 == null) goto L27;
        r11.setVisibility(4);
        return;
    }
}
