package com.larus.bmhome.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.view.share.MessageListMaskView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutSelectedMessageShareBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final MessageListMaskView b;
    public final View c;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutSelectedMessageShareBinding(ConstraintLayout r1, MessageListMaskView r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
