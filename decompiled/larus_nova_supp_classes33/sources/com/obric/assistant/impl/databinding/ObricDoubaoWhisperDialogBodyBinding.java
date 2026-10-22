package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricDoubaoWhisperDialogBodyBinding implements ViewBinding {
    public final LinearLayout a;
    public final OCheckBoxLayout b;

    public final View getRoot() {
        return this.a;
    }

    public ObricDoubaoWhisperDialogBodyBinding(LinearLayout r1, OCheckBoxLayout r2, OTextView r3) {
        this.a = r1;
        this.b = r2;
    }
}
