package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraHowConversationLinkFragmentBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final DoraTextView b;
    public final NovaTitleBarEx c;
    public final DoraTextView d;
    public final DoraTextView e;

    public final View getRoot() {
        return this.a;
    }

    public DoraHowConversationLinkFragmentBinding(ConstraintLayout r1, DoraTextView r2, NovaTitleBarEx r3, DoraTextView r4, DoraTextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
