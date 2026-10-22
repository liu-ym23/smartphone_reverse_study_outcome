package com.larus.bmhome.chat.component.bottom.core;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class c5 implements TextView.OnEditorActionListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ CoreInputComponent b;

    public /* synthetic */ c5(EditText r1, CoreInputComponent r2, LarusWidgetInputBinding r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r3, int r4, KeyEvent r5) {
        EditText r6 = this.a;
        CoreInputComponent r7 = this.b;
        int r0 = CoreInputComponent.d3;
        if (r4 != 4) goto L5;
        FLogger.a.i("CoreInputComponent", "actionId == EditorInfo.IME_ACTION_SEND， text=" + r6.getText());
        r7.x5();
        return true;
    L5:
        return false;
    }
}
