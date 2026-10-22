package com.ss.android.lark.inline.ai.ui.view;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends ncc.d {
    public final /* synthetic */ EditText b;

    public e(EditText r1) {
        this.b = r1;
        super(r1);
    }

    public final void invalidateDrawable(Drawable r4) {
        Intrinsics.checkNotNullParameter(r4, "who");
        super.invalidateDrawable(r4);
        int r5 = this.b.getSelectionStart();
        int r0 = this.b.getSelectionEnd();
        EditText r1 = this.b;
        r1.setText(r1.getText());
        this.b.setSelection(r5, r0);
        Log.i("URLRecognition", "invalidateDrawable");
    }
}
